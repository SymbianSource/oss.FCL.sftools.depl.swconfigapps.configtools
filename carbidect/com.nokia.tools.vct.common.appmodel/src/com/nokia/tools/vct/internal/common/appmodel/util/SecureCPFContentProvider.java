/*
* Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies).
* All rights reserved.
* This component and the accompanying materials are made available
* under the terms of "Eclipse Public License v1.0"
* which accompanies this distribution, and is available
* at the URL "http://www.eclipse.org/legal/epl-v10.html".
*
* Initial Contributors:
* Nokia Corporation - initial contribution.
*
* Contributors:
*
* Description: 
*
*/

package com.nokia.tools.vct.internal.common.appmodel.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.nokia.tools.vct.common.appmodel.util.ICPFContentProvider;
import com.nokia.tools.vct.common.appmodel.util.ISecureCPFContentProvider;
import com.nokia.tools.vct.common.core.utils.ArrayUtils;
import com.nokia.tools.vct.common.core.utils.ExceptionUtils;
import com.nokia.tools.vct.common.core.utils.FileUtils;
import com.nokia.tools.vct.internal.common.appmodel.AppModelPlugin;

public final class SecureCPFContentProvider implements ICPFContentProvider,
		ISecureCPFContentProvider {

	static final int SIGNATURE = ('C' << 8) | '1';

	private ICPFContentProvider filter;
	private X509Certificate[] certificates;
	private X509Certificate authorCertificate;
	private X509Certificate readerCertificate;
	private String blockAlgorithm;
	private int keySize;
	private SecretKeySpec cipherKeySpec;
	private PrivateKey outputSigningKey;

	public SecureCPFContentProvider(ICPFContentProvider filter) {
		this.filter = filter;
	}

	public PrivateKey getPrivateKey() {
		return this.outputSigningKey;
	}

	public void setPrivateKey(PrivateKey privateKey) {
		this.outputSigningKey = privateKey;
	}
	
	public void setReaderCertificate(X509Certificate readerCertificate) {
		this.readerCertificate = readerCertificate;
	}
	
	public X509Certificate getReaderCertificate() {
		return this.readerCertificate;
	}

	public InputStream createInputStream() throws CoreException {
		if (cipherKeySpec == null) {
			throw new IllegalStateException("Not initialized");
		}

		InputStream is = null;
		try {
			is = new BufferedInputStream(filter.createInputStream());
			DataInputStream dis = new DataInputStream(is);
			int type = dis.readShort() & 0xFFFF;
			if (type != SIGNATURE) {
				throw new IOException("Unsuppported input signature");
			}
			int len = dis.readInt();
			long result = dis.skip(len - 4);
			if (result != len - 4) {
				throw new IOException("Header error");
			}
			Cipher cipher = Cipher.getInstance(blockAlgorithm);
			cipher.init(Cipher.DECRYPT_MODE, this.cipherKeySpec);
			CipherInputStream cis = new CipherInputStream(dis, cipher);

			return cis;
		} catch (Exception ex) {
			FileUtils.closeStream(is);
			ExceptionUtils.throwIfMatches(CoreException.class, ex);
			throw newCoreException("Can not open encrypted input", ex);
		}
	}

	private CoreException newCoreException(String message, Throwable cause) {
		IStatus status = new Status(IStatus.ERROR, AppModelPlugin.PLUGIN_ID,
				message, cause);
		return new CoreException(status);
	}

	public OutputStream createOutputStream() throws CoreException {
		OutputStream os = null;
		try {
			os = new BufferedOutputStream(filter.createOutputStream());
			os.write('C');
			os.write('1');

			KeyGenerator generator = KeyGenerator
					.getInstance(this.blockAlgorithm);
			generator.init(this.keySize);
			SecretKey secretKey = generator.generateKey();

			byte[] header = createC1Header(certificates, authorCertificate,
					this.outputSigningKey, secretKey, this.keySize);
			os.write(header);

			Cipher blockCipher = Cipher.getInstance(this.blockAlgorithm);
			SecretKeySpec skeySpec = new SecretKeySpec(secretKey.getEncoded(),
					this.blockAlgorithm);
			blockCipher.init(Cipher.ENCRYPT_MODE, skeySpec);
			this.cipherKeySpec = skeySpec;

			CipherOutputStream cos = new CipherOutputStream(os, blockCipher);
			os = cos;
			return cos;
		} catch (Exception ex) {
			FileUtils.closeStream(os);
			ExceptionUtils.throwIfMatches(CoreException.class, ex);
			throw newCoreException("Failed to open output stream", ex);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nokia.tools.vct.common.appmodel.util.ISecureCPFContentProvider
	 * #getUserCertificates()
	 */
	public X509Certificate[] getUserCertificates() {
		return certificates.clone();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nokia.tools.vct.common.appmodel.util.ISecureCPFContentProvider
	 * #setUserCertificates(java.security.cert.X509Certificate)
	 */
	public void setUserCertificates(X509Certificate... certificates) {
		this.certificates = certificates.clone();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nokia.tools.vct.common.appmodel.util.ISecureCPFContentProvider
	 * #getAuthorCertificate()
	 */
	public X509Certificate getAuthorCertificate() {
		return authorCertificate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nokia.tools.vct.common.appmodel.util.ISecureCPFContentProvider
	 * #setAuthorCertificate(java.security.cert.X509Certificate)
	 */
	public void setAuthorCertificate(X509Certificate authorCertificate) {
		this.authorCertificate = authorCertificate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nokia.tools.vct.common.appmodel.util.ISecureCPFContentProvider
	 * #getBlockAlgorithm()
	 */
	public String getBlockAlgorithm() {
		return blockAlgorithm;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nokia.tools.vct.common.appmodel.util.ISecureCPFContentProvider
	 * #setBlockAlgorithm(java.lang.String)
	 */
	public void setBlockAlgorithm(String blockAlgorithm) {
		this.blockAlgorithm = blockAlgorithm;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nokia.tools.vct.common.appmodel.util.ISecureCPFContentProvider
	 * #getBlockSize()
	 */
	public int getKeySize() {
		return keySize;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nokia.tools.vct.common.appmodel.util.ISecureCPFContentProvider
	 * #setBlockSize(int)
	 */
	public void setKeySize(int blockSize) {
		this.keySize = blockSize;
	}

	public void initializeFromSource(X509Certificate reader,
			PrivateKey privateKey) throws CoreException {
		InputStream is = null;
		try {
			is = new BufferedInputStream(filter.createInputStream());
			DataInputStream dis = new DataInputStream(is);
			int type = dis.readShort() & 0xFFFF;
			if (type != SIGNATURE) {
				throw new IOException("Unsuppported input signature");
			}
			int len = dis.readInt();
			byte[] header = new byte[len];
			dis.read(header, 4, len - 4);
			ByteBuffer.wrap(header).putInt(len);
			List<X509Certificate> users = new ArrayList<X509Certificate>();
			List<byte[]> ciphers = new ArrayList<byte[]>();
			if (!parseC1Header(header, users, ciphers)) {
				throw new IOException("Error in secure header");
			}
			this.certificates = ArrayUtils.createCopy(X509Certificate.class,
					users);
			this.authorCertificate = getAuthorCertificate(header);
			this.blockAlgorithm = getBlockCipherType(header);
			this.keySize = getBlockCipherSize(header);
			this.outputSigningKey = privateKey;
			this.readerCertificate = reader;

			if (reader != null) {
				byte[] keySpec = selectEncodedBlock(users, ciphers, reader);
				if (keySpec == null) {
					SecurityException ex = new SecurityException(
							"User is not authorized");
					ex.fillInStackTrace();
					throw newCoreException("Unauthorized access", ex);
				}

				keySpec = decodeByKey(keySpec, privateKey);
				this.cipherKeySpec = new SecretKeySpec(keySpec,
						this.blockAlgorithm);
			}
		} catch (CoreException ex) {
			throw ex;
		} catch (IOException ex) {
			throw newCoreException("Can not access CPF content", ex);
		} finally {
			FileUtils.closeStream(is);
		}
	}

	static final int C1_SIGNATURE_SIZE = 128;
	static final String C1_KEY_CIPHER = "RSA";
	static final String C1_CERTIFICATE = "X.509";
	static final String C1_SIGNATURE = "SHA1withRSA";

	static String getBlockCipherType(byte[] header) {
		try {
			ByteBuffer bb = ByteBuffer.wrap(header);
			// skip length
			bb.getInt();

			int algSize = bb.getInt();
			char[] alg = new char[algSize];
			bb.asCharBuffer().get(alg);
			return new String(alg);
		} catch (Exception ex) {
			return null;
		}
	}

	static int getBlockCipherSize(byte[] header) {
		try {
			ByteBuffer bb = ByteBuffer.wrap(header);
			// skip length
			bb.getInt();

			int algSize = bb.getInt();
			bb.position(bb.position() + 2 * algSize);
			return bb.getInt();
		} catch (Exception ex) {
			return -1;
		}
	}

	public static X509Certificate getAuthorCertificate(byte[] header) {
		try {
			ByteBuffer bb = ByteBuffer.wrap(header);
			// skip length
			bb.getInt();
			// skip algorithm and key size
			int algSize = bb.getInt();
			bb.position(bb.position() + 2 * algSize);
			bb.getInt();

			int blockCount = bb.getInt();
			int authorIndex = bb.getInt();
			if (authorIndex < 0 || authorIndex >= blockCount) {
				return null;
			}

			CertificateFactory factory = CertificateFactory
					.getInstance(C1_CERTIFICATE);
			for (int i = 0;; i++) {
				int certificateSize = bb.getInt();
				if (i == authorIndex) {
					byte[] certificateData = new byte[certificateSize];
					bb.get(certificateData);

					Certificate certificate = factory
							.generateCertificate(new ByteArrayInputStream(
									certificateData));
					if (!(certificate instanceof X509Certificate)) {
						return null;
					} else {
						return (X509Certificate) certificate;
					}
				}
				bb.position(bb.position() + certificateSize);
				int cipherSize = bb.getInt();
				bb.position(bb.position() + cipherSize);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	static boolean parseC1Header(byte[] header, List<X509Certificate> users,
			List<byte[]> ciphers) {
		users.clear();
		ciphers.clear();
		try {
			ByteBuffer bb = ByteBuffer.wrap(header);
			int len = bb.getInt();
			if (len != header.length) {
				return false;
			}
			// skip algorithm and key size
			int algSize = bb.getInt();
			bb.position(bb.position() + 2 * algSize);
			bb.getInt();

			int blockCount = bb.getInt();
			int authorIndex = bb.getInt();
			if (authorIndex < 0 || authorIndex >= blockCount) {
				return false;
			}

			CertificateFactory factory = CertificateFactory
					.getInstance(C1_CERTIFICATE);
			for (int i = 0; i < blockCount; i++) {
				int certificateSize = bb.getInt();
				byte[] certificateData = new byte[certificateSize];
				bb.get(certificateData);

				Certificate certificate = factory
						.generateCertificate(new ByteArrayInputStream(
								certificateData));
				if (!(certificate instanceof X509Certificate)) {
					return false;
				}
				users.add((X509Certificate) certificate);
				int cipherSize = bb.getInt();
				byte[] cipher = new byte[cipherSize];
				bb.get(cipher);
				ciphers.add(cipher);
			}

			byte[] signatureData = new byte[C1_SIGNATURE_SIZE];
			bb.get(signatureData);

			if (bb.hasRemaining()) {
				return false;
			}

			Signature signature = Signature.getInstance(C1_SIGNATURE);
			signature.initVerify(users.get(authorIndex));

			bb.position(0);
			bb.limit(bb.capacity() - C1_SIGNATURE_SIZE);
			signature.update(bb);
			return signature.verify(signatureData);
		} catch (Exception ex) {
			users.clear();
			ciphers.clear();
			ex.printStackTrace();
			return false;
		}
	}

	static byte[] selectEncodedBlock(List<X509Certificate> users,
			List<byte[]> encoded, X509Certificate user) {
		int i = 0;
		for (X509Certificate next : users) {
			if (next.getSerialNumber().equals(user.getSerialNumber())) {
				return encoded.get(i);
			}
			i++;
		}
		return null;
	}

	static byte[] decodeByKey(byte[] encoded, PrivateKey key) {
		try {
			Cipher rsaCipher = Cipher.getInstance(C1_KEY_CIPHER);
			rsaCipher.init(Cipher.DECRYPT_MODE, key);

			return rsaCipher.doFinal(encoded);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	static byte[] createC1Header(X509Certificate[] users,
			X509Certificate author, PrivateKey authorKey, SecretKey contentKey,
			int keySize) throws IOException {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();

			Set<X509Certificate> tmp = new LinkedHashSet<X509Certificate>();
			tmp.add(author); // always at 0-index
			tmp.addAll(Arrays.asList(users));

			DataOutputStream dao = new DataOutputStream(baos);
			dao.writeInt(-1); // size

			String alg = contentKey.getAlgorithm();
			dao.writeInt(alg.length());
			dao.writeChars(alg);
			byte[] encodedSecretKey = contentKey.getEncoded();
			dao.writeInt(keySize);

			dao.writeInt(tmp.size()); // user blocks
			dao.writeInt(0); // author block

			Cipher rsaCipher = Cipher.getInstance(C1_KEY_CIPHER);

			for (X509Certificate next : tmp) {
				byte[] encoded = next.getEncoded();

				System.out.println("Cert size: " + encoded.length);

				dao.writeInt(encoded.length); // key size
				dao.write(encoded); // key

				// Initialize the cipher for encryption
				rsaCipher.init(Cipher.ENCRYPT_MODE, next);

				byte[] encryptedSecretKey = rsaCipher.doFinal(encodedSecretKey);
				System.out.println("Key size: " + encryptedSecretKey.length);

				dao.writeInt(encryptedSecretKey.length); // key size
				dao.write(encryptedSecretKey); // key
			}

			dao.write(new byte[C1_SIGNATURE_SIZE]);
			dao.flush();

			byte[] result = baos.toByteArray();
			ByteBuffer bb = ByteBuffer.wrap(result);
			bb.putInt(result.length);

			Signature signature = Signature.getInstance(C1_SIGNATURE);
			signature.initSign(authorKey);

			bb.position(0);
			bb.limit(bb.capacity() - C1_SIGNATURE_SIZE);
			signature.update(bb);

			byte[] tail = signature.sign();
			bb.limit(bb.capacity());
			bb.position(bb.capacity() - C1_SIGNATURE_SIZE);
			bb.put(tail);

			return result;
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

}
