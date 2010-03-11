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
package com.nokia.tools.vct.internal.common.secure.core;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.KeyStore.Entry;
import java.security.KeyStore.PrivateKeyEntry;
import java.security.KeyStore.TrustedCertificateEntry;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.security.auth.x500.X500Principal;

import org.bouncycastle.x509.X509V3CertificateGenerator;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.core.runtime.Status;
import org.eclipse.osgi.service.datalocation.Location;

import com.nokia.tools.vct.common.core.utils.ArrayUtils;
import com.nokia.tools.vct.common.core.utils.ExceptionUtils;
import com.nokia.tools.vct.common.core.utils.FileUtils;
import com.nokia.tools.vct.common.secure.core.IKeyStoreEntry;
import com.nokia.tools.vct.common.secure.core.IKeyStoreListener;
import com.nokia.tools.vct.common.secure.core.IKeyStoreManager;
import com.nokia.tools.vct.common.secure.core.KeyStoreEvent;
import com.nokia.tools.vct.common.secure.core.SecurityCorePlugin;

public class KeyStoreManager implements IKeyStoreManager {

	/**
	 * This "password" is used, when keystore is saved to file. However,
	 * individual private keys are protected by its own passwords.
	 */
	private static final String KEYSTORE_FILE_PASSWORD = "";

	private static final String CERTIFICATE_EXTENSION = ".cer";

	static final class KeyStoreEntry implements IKeyStoreEntry {
		private String alias;
		private boolean privateKey;
		private int hashCode;

		public KeyStoreEntry(String alias, boolean privateKey) {
			this.alias = alias;
			this.privateKey = privateKey;
			this.hashCode = alias.hashCode() + (privateKey ? 0x1000 : 0);
		}

		public String getAlias() {
			return this.alias;
		}

		public boolean hasPrivateKey() {
			return this.privateKey;
		}

		@Override
		public int hashCode() {
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof KeyStoreEntry)) {
				return false;
			}
			KeyStoreEntry arg = (KeyStoreEntry) obj;
			return this == arg
					|| (this.hashCode == arg.hashCode
							&& this.privateKey == arg.privateKey && this.alias
							.equals(arg.alias));
		}

		public String getName() {
			X500Principal principal = SecurityCorePlugin.getKeyStoreManager()
					.getCertificate(this).getSubjectX500Principal();
			String name = principal.getName();
			Pattern pattern = Pattern.compile(".*O=([^,]*).*");
			Matcher m = pattern.matcher(name);
			if (m.matches()) {
				return m.group(1);
			} else {
				return "n/a";
			}
		}

		public String getDate() {
			return DateFormat.getDateInstance(DateFormat.LONG).format(
					SecurityCorePlugin.getKeyStoreManager()
							.getCertificate(this).getNotAfter());
		}

		public String getOrganization() {
			X500Principal principal = SecurityCorePlugin.getKeyStoreManager()
					.getCertificate(this).getSubjectX500Principal();
			String name = principal.getName();
			Pattern pattern = Pattern.compile(".*OU=([^,]*).*");
			Matcher m = pattern.matcher(name);
			if (m.matches()) {
				return m.group(1);
			} else {
				return "n/a";
			}
		}
	}

	static final int KEY_SIZE = 1024;
	static final String GENERATOR_RSA = "RSA";
	static final String CERTIFICATE_X509 = "X.509";
	static final String SIGNATURE_SHA1_RSA = "SHA1withRSA";
	static final String SIGNATURE_MD5_RSA = "MD5withRSA";
	static final String KEY_STORE_PKCS12 = "pkcs12";

	private ListenerList listeners;

	private KeyPairGenerator keyPairGenerator;
	// private CertificateFactory certificateFactory;

	private KeyStore cachedKeyStore;
	// private List<CertificateEntry> cachedCertificates;
	private String defaultSerial;

	// private X509V1CertificateGenerator v1CertGen
	// private X509V3CertificateGenerator v3CertGen;

	public KeyStoreManager() {
		listeners = new ListenerList();
	}

	public void initialize() throws Exception {
		try {
			keyPairGenerator = KeyPairGenerator.getInstance(GENERATOR_RSA);
			keyPairGenerator.initialize(KEY_SIZE, new SecureRandom());
			// certificateFactory = CertificateFactory
			// .getInstance(CERTIFICATE_X509);
			// v1CertGen = new X509V1CertificateGenerator();
			// v3CertGen = new X509V3CertificateGenerator();
		} catch (Exception ex) {
			IStatus status = new Status(IStatus.ERROR,
					SecurityCorePlugin.PLUGIN_ID, "Failed to load key store",
					ex);
			SecurityCorePlugin.getDefault().getLog().log(status);
		}
	}

	private KeyStore loadKeyStore() throws CoreException {
		InputStream is = null;
		KeyStore keyStore = this.cachedKeyStore;

		try {
			if (keyStore == null) {
				IPath path = getKeyStorePath();
				keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
				try {
					is = new BufferedInputStream(new FileInputStream(path
							.toFile()));
				} catch (FileNotFoundException ex) {
					is = null;
				}
				keyStore.load(is, KEYSTORE_FILE_PASSWORD.toCharArray());
				cachedKeyStore = keyStore;
			}
			return keyStore;
		} catch (Exception ex) {
			if (is != null) {
				try {
					keyStore.load(null, KEYSTORE_FILE_PASSWORD.toCharArray());
					cachedKeyStore = keyStore;
					return keyStore;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			IStatus status = new Status(IStatus.ERROR,
					SecurityCorePlugin.PLUGIN_ID, "Failed to load key store",
					ex);
			SecurityCorePlugin.getDefault().getLog().log(status);
			throw new CoreException(status);
		} finally {
			FileUtils.closeStream(is);
		}
	}

	private void saveKeyStore(KeyStore keyStore) throws CoreException {
		OutputStream os = null;

		try {
			IPath path = getKeyStorePath();
			File file = path.toFile();
			file.getParentFile().mkdirs();
			os = new BufferedOutputStream(new FileOutputStream(path.toFile()));
			keyStore.store(os, KEYSTORE_FILE_PASSWORD.toCharArray());
		} catch (Exception ex) {
			IStatus status = new Status(IStatus.ERROR,
					SecurityCorePlugin.PLUGIN_ID, "Failed to load key store",
					ex);
			SecurityCorePlugin.getDefault().getLog().log(status);
			throw new CoreException(status);
		} finally {
			FileUtils.closeStream(os);
		}
	}

	private IPath getKeyStorePath() throws MalformedURLException {
		String value = System.getenv("APPDATA");
		if (value != null) {
			IPath path = new Path(value).append("Nokia/Carbide.vct/.keystore");
			return path;
		} else {
			Location location = Platform.getUserLocation();
			URL url = new URL(location.getURL(), ".keystore");
			return new Path(url.getPath());
		}
	}

	private IPath getPasswordPath() throws MalformedURLException {
		String value = System.getenv("APPDATA");
		if (value != null) {
			IPath path = new Path(value).append("Nokia/Carbide.vct/.keypass");
			return path;
		} else {
			Location location = Platform.getUserLocation();
			URL url = new URL(location.getURL(), ".keypass");
			return new Path(url.getPath());
		}
	}

	private IPath getDefaultKeyPath() throws MalformedURLException {
		String value = System.getenv("APPDATA");
		if (value != null) {
			IPath path = new Path(value)
					.append("Nokia/Carbide.vct/.keydefault");
			return path;
		} else {
			Location location = Platform.getUserLocation();
			URL url = new URL(location.getURL(), ".keydefault");
			return new Path(url.getPath());
		}
	}

	public KeyPair generateKeyPair() {
		return keyPairGenerator.generateKeyPair();
	}

	public X509Certificate createCertificate(KeyPair keys, int years,
			Map<String, String> fields) throws CoreException {
		X509V3CertificateGenerator certGen = new X509V3CertificateGenerator();
		certGen.setSerialNumber(BigInteger.valueOf(System.currentTimeMillis()));
		certGen.setNotBefore(new GregorianCalendar(Locale.getDefault())
				.getTime());
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		gregorianCalendar.add(Calendar.YEAR, 1);
		certGen.setNotAfter(gregorianCalendar.getTime());
		certGen.setPublicKey(keys.getPublic());

		StringBuffer userInformation = new StringBuffer();

		UUID uuid = UUID.randomUUID();

		ByteBuffer bb = ByteBuffer.allocate(17);
		bb.put((byte) 0);
		bb.putLong(uuid.getMostSignificantBits());
		bb.putLong(uuid.getLeastSignificantBits());
		BigInteger bigInteger = new BigInteger(bb.array());
		userInformation.append("SERIALNUMBER=").append(bigInteger.toString());
		for (Map.Entry<String, String> field : fields.entrySet()) {
			userInformation.append(',');
			userInformation.append(field.getKey());
			userInformation.append('=');
			userInformation.append(escapeRFC2253(field.getValue()));
		}
		X500Principal principal = new X500Principal(userInformation.toString());
		certGen.setIssuerDN(principal);
		certGen.setSubjectDN(principal);

		certGen.setSignatureAlgorithm(SIGNATURE_SHA1_RSA);

		X509Certificate certificate;
		try {
			certificate = certGen.generate(keys.getPrivate());
		} catch (Exception ex) {
			IStatus status = new Status(IStatus.ERROR,
					SecurityCorePlugin.PLUGIN_ID,
					"Failed to generate certificate", ex);
			SecurityCorePlugin.getDefault().getLog().log(status);

			throw new CoreException(status);
		}

		return certificate;
	}

	String escapeRFC2253(String source) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < source.length(); i++) {
			char ch = source.charAt(i);
			switch (ch) {
			case ' ':
			case '#':
			case ',':
			case '+':
			case '\"':
			case '<':
			case '>':
			case ';':
			case '\\':
				result.append('\\').append(ch);
				break;
			default:
				result.append(ch);
				break;
			}
		}
		return result.toString();
	}

	public void addCertificate(X509Certificate certificate,
			PrivateKey privateKey, String password) throws CoreException {
		String serial = certificate.getSerialNumber().toString(16);
		try {
			char[] passChars = password == null ? null : password.toCharArray();
			KeyStore keyStore = loadKeyStore();
			Certificate[] chain = { certificate };

			if (privateKey != null) {
				keyStore.setKeyEntry(serial, privateKey, passChars, chain);
			} else {
				keyStore.setCertificateEntry(serial, certificate);
			}
			saveKeyStore(keyStore);
		} catch (KeyStoreException ex) {
			IStatus status = new Status(IStatus.WARNING,
					SecurityCorePlugin.PLUGIN_ID, "Can not add certificate", ex);

			SecurityCorePlugin.getDefault().getLog().log(status);
			throw new CoreException(status);
		}

		KeyStoreEvent event = new KeyStoreEvent(this);
		event.type = KeyStoreEvent.OBJECTS_ADDED;
		event.serial = certificate.getSerialNumber();
		event.flags = KeyStoreEvent.CERTIFICATE | KeyStoreEvent.PUBLIC_KEY;
		if (privateKey != null) {
			event.flags |= KeyStoreEvent.PRIVATE_KEY;
		}
		sendEvent(event);
	}

	public void removeEntry(IKeyStoreEntry entry) throws CoreException {
		if (entry.getAlias().equals(defaultSerial)) {
			setDefaultEntry(null);
			setPasswordCookie(null);
		}

		X509Certificate cert = null;
		try {
			KeyStore keyStore = loadKeyStore();
			Certificate tmp = keyStore.getCertificate(entry.getAlias());
			if (tmp instanceof X509Certificate) {
				cert = (X509Certificate) tmp;
			}

			keyStore.deleteEntry(entry.getAlias());
			saveKeyStore(keyStore);

		} catch (KeyStoreException ex) {
			IStatus status = new Status(IStatus.WARNING,
					SecurityCorePlugin.PLUGIN_ID, "Can not add certificate", ex);

			SecurityCorePlugin.getDefault().getLog().log(status);
			throw new CoreException(status);
		}

		KeyStoreEvent event = new KeyStoreEvent(this);
		event.type = KeyStoreEvent.OBJECTS_REMOVED;
		event.serial = cert == null ? null : cert.getSerialNumber();
		event.flags = KeyStoreEvent.CERTIFICATE | KeyStoreEvent.PUBLIC_KEY
				| KeyStoreEvent.PRIVATE_KEY;
		sendEvent(event);
	}

	public X509Certificate[] loadCertificates() throws CoreException {
		List<X509Certificate> result = new ArrayList<X509Certificate>();

		try {
			KeyStore keyStore = loadKeyStore();
			Enumeration<String> en = keyStore.aliases();
			while (en.hasMoreElements()) {
				String alias = en.nextElement();
				Certificate next = keyStore.getCertificate(alias);
				if (next instanceof X509Certificate) {
					result.add((X509Certificate) next);
				}
			}
			return ArrayUtils.createCopy(X509Certificate.class, result);
		} catch (KeyStoreException ex) {
			IStatus status = new Status(IStatus.WARNING,
					SecurityCorePlugin.PLUGIN_ID, "Can not add certificate", ex);

			SecurityCorePlugin.getDefault().getLog().log(status);
			throw new CoreException(status);
		}
	}

	public IKeyStoreEntry[] listEntries() {
		List<IKeyStoreEntry> result = new ArrayList<IKeyStoreEntry>();
		try {
			KeyStore keyStore = loadKeyStore();
			Enumeration<String> en = keyStore.aliases();
			while (en.hasMoreElements()) {
				String alias = en.nextElement();
				boolean privateKey = keyStore.isKeyEntry(alias);
				result.add(new KeyStoreEntry(alias, privateKey));
			}

			// X509Certificate[] certificates = loadCertificates();
			// result.addAll(certificates);

		} catch (Exception ex) {
			IStatus status = new Status(IStatus.WARNING,
					SecurityCorePlugin.PLUGIN_ID, "Can not add certificate", ex);

			SecurityCorePlugin.getDefault().getLog().log(status);
		}
		return ArrayUtils.createCopy(IKeyStoreEntry.class, result);
	}

	public X509Certificate getCertificate(IKeyStoreEntry entry) {
		try {
			KeyStore keyStore = loadKeyStore();
			Certificate certificate = keyStore.getCertificate(entry.getAlias());
			if (certificate instanceof X509Certificate) {
				return (X509Certificate) certificate;
			} else {
				return null;
			}
		} catch (Exception ex) {
			IStatus status = new Status(IStatus.WARNING,
					SecurityCorePlugin.PLUGIN_ID,
					"Can not retrieve certificate", ex);

			SecurityCorePlugin.getDefault().getLog().log(status);
			return null;
		}
	}

	public PrivateKey getPrivateKey(IKeyStoreEntry ksEntry, String password)
			throws CoreException {

		try {
			char[] passChars = password == null ? null : password.toCharArray();
			KeyStore keyStore = loadKeyStore();
			KeyStore.ProtectionParameter param = new KeyStore.PasswordProtection(
					passChars);
			Entry entry = keyStore.getEntry(ksEntry.getAlias(), param);
			if (entry instanceof PrivateKeyEntry) {
				return ((PrivateKeyEntry) entry).getPrivateKey();
			} else {
				return null;
			}
		} catch (Exception ex) {
			ExceptionUtils.throwIfMatches(CoreException.class, ex);
			IStatus status = new Status(IStatus.WARNING,
					SecurityCorePlugin.PLUGIN_ID, "Can not access private key",
					ex);

			SecurityCorePlugin.getDefault().getLog().log(status);
			throw new CoreException(status);
		}
	}

	public void addListener(IKeyStoreListener listener) {
		listeners.add(listener);
	}

	public void removeListener(IKeyStoreListener listener) {
		listeners.remove(listener);
	}

	protected void sendEvent(final KeyStoreEvent event) {
		Object[] copy = listeners.getListeners();

		for (final Object obj : copy) {
			SafeRunner.run(new ISafeRunnable() {
				public void run() throws Exception {
					IKeyStoreListener listener = (IKeyStoreListener) obj;
					listener.handleEvent(event);
				}

				public void handleException(Throwable thr) {
					IStatus status = new Status(IStatus.WARNING,
							SecurityCorePlugin.PLUGIN_ID,
							"Exception during listener invocation", thr);

					SecurityCorePlugin.getDefault().getLog().log(status);
				}
			});
		}
	}

	// public X509Certificate importCertificate(InputStream is)
	// throws CoreException {
	// Certificate result;
	// try {
	// result = certificateFactory.generateCertificate(is);
	// } catch (CertificateException e) {
	// IStatus status = new Status(IStatus.ERROR,
	// SecurityCorePlugin.PLUGIN_ID,
	// "Exception during listener invocation", e);
	//
	// SecurityCorePlugin.getDefault().getLog().log(status);
	// throw new CoreException(status);
	// }
	//
	// if (result instanceof X509Certificate) {
	// return (X509Certificate) result;
	// }
	// IStatus status = new Status(IStatus.ERROR,
	// SecurityCorePlugin.PLUGIN_ID, "Certificate type mismatch");
	//
	// SecurityCorePlugin.getDefault().getLog().log(status);
	// throw new CoreException(status);
	// }

	public List<IKeyStoreEntry> importCertificate(InputStream is)
			throws CoreException {
		List<IKeyStoreEntry> result = new ArrayList<IKeyStoreEntry>();

		try {
			CertificateFactory factory2 = CertificateFactory
					.getInstance("X.509");
			X509Certificate x509 = (X509Certificate) factory2
					.generateCertificate(is);
			addCertificate(x509, null, null);
			result.add(new KeyStoreEntry(x509.getSerialNumber().toString(16),
					false));
		} catch (CoreException e) {
			IStatus status = new Status(
					IStatus.WARNING,
					SecurityCorePlugin.PLUGIN_ID,
					"Can not add certificate.\nPossible cause: Certificate exists in the key pair.",
					e);

			SecurityCorePlugin.getDefault().getLog().log(status);
			throw new CoreException(status);
		} catch (CertificateParsingException e) {
			IStatus status = new Status(
					IStatus.WARNING,
					SecurityCorePlugin.PLUGIN_ID,
					"Can not add certificate.\nPossible cause: Certificate is broken.",
					e);

			SecurityCorePlugin.getDefault().getLog().log(status);
			throw new CoreException(status);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public List<IKeyStoreEntry> importEntries(InputStream is,
			Map<String, String> alias2password) throws CoreException {
		try {
			KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());

			keyStore.load(is, KEYSTORE_FILE_PASSWORD.toCharArray());

			List<IKeyStoreEntry> result = new ArrayList<IKeyStoreEntry>();

			Enumeration<String> en = keyStore.aliases();

			while (en.hasMoreElements()) {
				String alias = en.nextElement();
				if (keyStore.isCertificateEntry(alias)) {
					Entry entry = keyStore.getEntry(alias, null);
					Certificate cert = ((TrustedCertificateEntry) entry)
							.getTrustedCertificate();
					if (cert instanceof X509Certificate) {
						X509Certificate x509 = (X509Certificate) cert;
						addCertificate(x509, null, null);
						result.add(new KeyStoreEntry(x509.getSerialNumber()
								.toString(16), false));
					}
				} else if (alias2password.containsKey(alias)) {
					Entry entry = keyStore.getEntry(alias,
							new KeyStore.PasswordProtection(alias2password.get(
									alias).toCharArray()));
					PrivateKeyEntry pke = (PrivateKeyEntry) entry;
					Certificate cert = pke.getCertificate();
					PrivateKey privateKey = pke.getPrivateKey();
					if (cert instanceof X509Certificate) {
						X509Certificate x509 = (X509Certificate) cert;
						addCertificate(x509, privateKey, alias2password
								.get(alias));
						result.add(new KeyStoreEntry(x509.getSerialNumber()
								.toString(16), true));
					}
				}
			}
			return result;
		} catch (Exception ex) {
			IStatus status = new Status(IStatus.ERROR,
					SecurityCorePlugin.PLUGIN_ID, "Data load error", ex);

			SecurityCorePlugin.getDefault().getLog().log(status);
			throw new CoreException(status);
		}
	}

	public void exportEntries(List<IKeyStoreEntry> entries,
			List<String> entryPassList, OutputStream os,
			String destinationFolder) throws CoreException {
		try {

			KeyStore keyStore = loadKeyStore();

			KeyStore target = KeyStore.getInstance(KeyStore.getDefaultType());
			target.load(null);

			for (int i = 0; i < entries.size(); i++) {
				IKeyStoreEntry entry = entries.get(i);
				String entryPass = entryPassList != null ? entryPassList.get(i)
						: null;

				if (entryPass != null && keyStore.isKeyEntry(entry.getAlias())) {
					Key key = keyStore.getKey(entry.getAlias(), entryPass
							.toCharArray());
					Certificate[] certs = keyStore.getCertificateChain(entry
							.getAlias());
					target.setKeyEntry(entry.getAlias(), key, entryPass
							.toCharArray(), certs);
				} else {
					Certificate cert = keyStore
							.getCertificate(entry.getAlias());
					X509Certificate x509 = (X509Certificate) cert;

					String date = DateFormat.getDateInstance(DateFormat.MEDIUM)
							.format(x509.getNotAfter());
					File file = new File(destinationFolder, getName(x509) + "_"
							+ date.replace(".", "_") + CERTIFICATE_EXTENSION);

					FileOutputStream certFos = new FileOutputStream(file);
					certFos.write(x509.getEncoded());
					certFos.close();

					// target.setCertificateEntry(entry.getAlias(), x509);
				}
				// else if (entry instanceof CertificateEntry) {
				// X509Certificate x509 = ((CertificateEntry) entry).getCert();
				// File file = new File(destinationFolder, getName(x509)
				// + CERTIFICATE_EXTENSION);
				//
				// FileOutputStream certFos = new FileOutputStream(file);
				// certFos.write(x509.getEncoded());
				// certFos.close();
				// }
			}
			if (os != null) {
				target.store(os, KEYSTORE_FILE_PASSWORD.toCharArray());
				os.flush();
			}
		} catch (Exception ex) {
			IStatus status = new Status(IStatus.ERROR,
					SecurityCorePlugin.PLUGIN_ID, "Data save error", ex);

			SecurityCorePlugin.getDefault().getLog().log(status);
			throw new CoreException(status);
		} finally {
			FileUtils.closeStream(os);
		}
	}

	public IKeyStoreEntry getDefaultEntry() {
		if (defaultSerial == null) {
			try {
				IPath path = getDefaultKeyPath();
				if (path.toFile().exists()) {
					InputStream is = new FileInputStream(path.toFile());
					byte[] data = FileUtils.readBytes(is);
					defaultSerial = ByteBuffer.wrap(data).asCharBuffer()
							.toString();
				} else {
					return null;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		try {

			KeyStore keyStore = loadKeyStore();
			if (keyStore.isKeyEntry(defaultSerial)) {
				return new KeyStoreEntry(defaultSerial, true);
			}
		} catch (Exception ex) {
			IStatus status = new Status(IStatus.WARNING,
					SecurityCorePlugin.PLUGIN_ID, "Can not add certificate", ex);

			SecurityCorePlugin.getDefault().getLog().log(status);
		}
		return null;
	}

	public void setDefaultEntry(IKeyStoreEntry entry) {

		X509Certificate certificate = null;
		try {
			if (entry != null) {
				KeyStore keyStore = loadKeyStore();
				Certificate cert = keyStore.getCertificate(entry.getAlias());
				if (cert instanceof X509Certificate) {
					certificate = (X509Certificate) cert;
				}
			}
		} catch (Exception ex) {
			IStatus status = new Status(IStatus.WARNING,
					SecurityCorePlugin.PLUGIN_ID, "Can not add certificate", ex);

			SecurityCorePlugin.getDefault().getLog().log(status);
		}

		defaultSerial = certificate != null ? entry.getAlias() : null;

		KeyStoreEvent event = new KeyStoreEvent(this);
		event.type = KeyStoreEvent.DEFAULT_CHANGED;
		event.serial = certificate == null ? null : certificate
				.getSerialNumber();
		event.flags = KeyStoreEvent.CERTIFICATE | KeyStoreEvent.PUBLIC_KEY
				| KeyStoreEvent.PRIVATE_KEY;
		sendEvent(event);

		try {
			IPath path = getDefaultKeyPath();
			File fileDefault = path.toFile();
			if (defaultSerial == null && fileDefault.exists()) {
				fileDefault.delete();
				return;
			}
			FileOutputStream fos = new FileOutputStream(path.toFile());
			ByteBuffer buffer = ByteBuffer.allocate(defaultSerial.length() * 2);
			buffer.asCharBuffer().append(defaultSerial);
			fos.write(buffer.array());
			FileUtils.closeStream(fos);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void release() {
	}

	private static byte[] keyBytes = new byte[] { 0x1f, 0x35, 0x22, 0x65,
			(byte) 0xe9, (byte) 0xae, 0x67, 0x7c, 0x7c, (byte) 0xbe, 0x73,
			0x2f, 0x5f, 0x02, 0x23, 0x45 };

	public String getPasswordCookie() {
		String password = null;

		try {
			IPath path = getPasswordPath();

			File passFile = path.toFile();

			if (passFile.exists()) {

				FileInputStream fis = new FileInputStream(passFile);

				byte encrypted[] = new byte[(int) passFile.length()];
				fis.read(encrypted);
				fis.close();

				Cipher cipher = Cipher.getInstance("AES");
				SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");

				cipher.init(Cipher.DECRYPT_MODE, key);
				byte[] original = cipher.doFinal(encrypted);
				password = new String(original);
			}

			return password;

			// InputStream is = new FileInputStream(path.toFile());
			// byte[] data = FileUtils.readBytes(is);
			// return ByteBuffer.wrap(data).asCharBuffer().toString();
		} catch (Exception ex) {
			return null;
		}
	}

	public void setPasswordCookie(String password) {
		try {
			IPath path = getPasswordPath();
			if (password == null && path.toFile().exists()) {
				path.toFile().delete();
			} else {
				SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");

				Cipher cipher = Cipher.getInstance("AES");
				cipher.init(Cipher.ENCRYPT_MODE, key);

				byte[] encryptedKey = cipher.doFinal(password.getBytes());

				FileOutputStream fos = new FileOutputStream(path.toFile());
				fos.write(encryptedKey);
				FileUtils.closeStream(fos);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public boolean checkPassword(IKeyStoreEntry entry, String passPhrase) {
		try {
			KeyStore keyStore = loadKeyStore();
			try {
				keyStore.getKey(entry.getAlias(), passPhrase.toCharArray());
			} catch (KeyStoreException e) {
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (UnrecoverableKeyException e) {
				return false;
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
		return true;
	}

	public String getName(X509Certificate cert) {
		Principal principal = cert.getIssuerDN();
		String name = principal.getName();
		Pattern pattern = Pattern.compile(".*O=([^,]*).*");
		Matcher m = pattern.matcher(name);
		if (m.matches()) {
			return m.group(1);
		} else {
			return "n/a";
		}
	}

	public String getOrganization(X509Certificate cert) {
		Principal principal = cert.getIssuerDN();
		String name = principal.getName();
		Pattern pattern = Pattern.compile(".*OU=([^,]*).*");
		Matcher m = pattern.matcher(name);
		if (m.matches()) {
			return m.group(1);
		} else {
			return "n/a";
		}
	}

}
