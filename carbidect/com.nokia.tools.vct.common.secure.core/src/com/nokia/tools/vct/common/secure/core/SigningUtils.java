/*
 * Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies).
 * All rights reserved.
 * This component and the accompanying materials are made available
 * under the terms of "Eclipse Public License v1.0"
 * which accompanies this distribution, and is available
 * at the URL "http://www.eclipse.org/legal/epl-v10.html".
 * 
 * Initial Contributors:
 * Nokia Corporation - Initial contribution
 * 
 * Contributors:
 * 
 * Description: This file is part of com.nokia.tools.vct.common.secure.core component.
 */

package com.nokia.tools.vct.common.secure.core;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.KeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.crypto.AlgorithmMethod;
import javax.xml.crypto.Data;
import javax.xml.crypto.KeySelector;
import javax.xml.crypto.KeySelectorException;
import javax.xml.crypto.KeySelectorResult;
import javax.xml.crypto.MarshalException;
import javax.xml.crypto.OctetStreamData;
import javax.xml.crypto.URIDereferencer;
import javax.xml.crypto.URIReference;
import javax.xml.crypto.URIReferenceException;
import javax.xml.crypto.XMLCryptoContext;
import javax.xml.crypto.XMLStructure;
import javax.xml.crypto.dom.DOMStructure;
import javax.xml.crypto.dsig.CanonicalizationMethod;
import javax.xml.crypto.dsig.DigestMethod;
import javax.xml.crypto.dsig.Reference;
import javax.xml.crypto.dsig.SignatureMethod;
import javax.xml.crypto.dsig.SignedInfo;
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.dom.DOMValidateContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.keyinfo.KeyName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.w3c.dom.Document;


public class SigningUtils {

	public interface IDigestVerifyer {
		boolean isDigestCorrect(URI uri, byte[] digest);
	}

	public interface IDigestProvider {
		byte[] getDigest(URI uri);
	}

	public static final URI LAYER_SIGNATURE_LOCATION = URI
			.createURI("layer.sign");

	public static SigningStatus getSigningStatus(Document document, IDigestVerifyer provider, Set<URI> contentFiles) {
		SigningStatus result = new SigningStatus();
		result.signatureFound = document != null;
		
		if (document != null) {
			try {
				XMLSignatureFactory factory = SecurityCorePlugin
						.getXMLSignatureFactory();
				KeyNameSelector keyNameSelector = new KeyNameSelector();
				DOMValidateContext context = new DOMValidateContext(
						keyNameSelector, document.getDocumentElement());

				XMLSignature signature = factory.unmarshalXMLSignature(context);
				result.signatureParsed = true;
				Set<URI> signatureRefs = new HashSet<URI>();
				for (Object next : signature.getSignedInfo().getReferences()) {
					Reference reference = (Reference) next;
					if (reference.getURI() == null) {
						continue;
					}
					
					URI uri = URI.createURI(reference.getURI());
					
					signatureRefs.add(uri);
				}

				if (!contentFiles.equals(signatureRefs)) {
					Set<URI> added = new HashSet<URI>(contentFiles);
					added.removeAll(signatureRefs);

					result.addedFiles = added;
					
					System.out.println("ADDED= "+ added);

					Set<URI> removed = new HashSet<URI>(signatureRefs);
					removed.removeAll(contentFiles);

					result.removedFiles = removed;
					System.out.println("REMOVED= "+ removed);
				}

				// boolean coreValidity = signature.validate(context);
				keyNameSelector.select(signature.getKeyInfo(), null, null, context);
				result.certificate = keyNameSelector.certificate;

				boolean sv = signature.getSignatureValue().validate(context);
				result.signatureValid = sv;

				for (Object next : signature.getSignedInfo().getReferences()) {
					Reference reference = (Reference) next;
					byte[] digestValue = reference.getDigestValue();
					URI uri = URI.createURI(reference.getURI());
					if (provider.isDigestCorrect(uri, digestValue)) {
						result.checkedFiles.add(uri);
					} else if (contentFiles.contains(uri)) {
						result.tamperedFiles.add(uri);
					}
				}
				result.contentOK = sv && result.removedFiles.isEmpty() && result.addedFiles.isEmpty() && result.tamperedFiles.isEmpty();

			} catch (Exception ex) {
				// continue
			}
			
		}
		
		return result;
	}
	
	
	public static SigningStatus getSigningStatus(URIConverter uriConverter, URI signatureURI, Set<URI> contents) {
		SigningStatus result = new SigningStatus();
		if (!uriConverter.exists(signatureURI, null)) {
			// result.signatureFound = false;
			return result;
		}
		result.signatureFound = true;

		completeStatusCheck(result, uriConverter, signatureURI, contents);

		return result;
	}

	private static Document completeStatusCheck(SigningStatus result,
			final URIConverter uriConverter, final URI signatureURI,
			Collection<URI> contentFiles) {
		Document document = null;
		try {
			XMLSignatureFactory factory = SecurityCorePlugin
					.getXMLSignatureFactory();
			document = unmarshalSignature(uriConverter.createInputStream(signatureURI));
			KeyNameSelector keyNameSelector = new KeyNameSelector();
			DOMValidateContext context = new DOMValidateContext(
					keyNameSelector, document.getDocumentElement());
			context.setURIDereferencer(new URIDereferencer() {
				public Data dereference(URIReference reference,
						XMLCryptoContext context) throws URIReferenceException {
					String uri = reference.getURI();

					URI targetURI = URI.createURI(uri).resolve(signatureURI);
					try {
						if (uriConverter.exists(targetURI, null)) {
							return new OctetStreamData(uriConverter
									.createInputStream(targetURI));
						} else {
							return new OctetStreamData(
									new ByteArrayInputStream(new byte[0]));
						}
					} catch (Exception e) {
						throw new URIReferenceException(e);
					}
				}
			});

			XMLSignature signature = factory.unmarshalXMLSignature(context);
			result.signatureParsed = true;
			Set<URI> signatureRefs = new HashSet<URI>();
			for (Object next : signature.getSignedInfo().getReferences()) {
				Reference reference = (Reference) next;
				if (reference.getURI() == null) {
					continue;
				}
				URI uri = URI.createURI(reference.getURI());
				signatureRefs.add(uri);
			}

			if (!contentFiles.equals(signatureRefs)) {
				Set<URI> added = new HashSet<URI>(contentFiles);
				added.removeAll(signatureRefs);

				result.addedFiles = added;

				Set<URI> removed = new HashSet<URI>(signatureRefs);
				removed.removeAll(contentFiles);

				result.removedFiles = removed;
			}

			boolean coreValidity = signature.validate(context);
			result.certificate = keyNameSelector.certificate;

			if (coreValidity) {
				result.contentOK = result.addedFiles.isEmpty()
						&& result.removedFiles.isEmpty();
				result.signatureValid = true;

				for (Object next : signature.getSignedInfo().getReferences()) {
					Reference reference = (Reference) next;
					result.checkedFiles.add(URI.createURI(reference.getURI()));
				}

			} else {
				boolean sv = signature.getSignatureValue().validate(context);
				result.signatureValid = sv;
				result.contentOK = false;

				for (Object next : signature.getSignedInfo().getReferences()) {
					Reference reference = (Reference) next;
					boolean refValid = reference.validate(context);
					URI uri = URI.createURI(reference.getURI());
					if (refValid) {
						result.checkedFiles.add(uri);
					} else if (contentFiles.contains(uri)) {
						result.tamperedFiles.add(uri);
					}
				}
			}

		} catch (Exception ex) {
			// continue
		}
		return document;
	}

	public static Document unmarshalSignature(InputStream is) throws Exception {
		Document document;
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
				.newInstance();
		documentBuilderFactory.setNamespaceAware(true);
		DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
		builder.setErrorHandler(null);
		document = builder.parse(is);
		return document;
	}

	public static final class KeyNameSelector extends KeySelector {
		private X509Certificate certificate;

		public KeyNameSelector() {
		}

		@Override
		public KeySelectorResult select(KeyInfo keyInfo, Purpose purpose,
				AlgorithmMethod algorithm, XMLCryptoContext context)
				throws KeySelectorException {

			KeyName keyName = null;
			for (Object obj : keyInfo.getContent()) {
				if (obj instanceof KeyName) {
					keyName = (KeyName) obj;
					break;
				}
			}
			if (keyName == null) {
				throw new KeySelectorException("Key name is not specified");
			}
			X509Certificate certificate = null;

			try {
				IKeyStoreEntry[] entries = SecurityCorePlugin.getKeyStoreManager()
						.listEntries();
				BigInteger serial = new BigInteger(keyName.getName());
				for (IKeyStoreEntry next : entries) {
					X509Certificate cert = SecurityCorePlugin.getKeyStoreManager()
							.getCertificate(next);
					if (cert.getSerialNumber().equals(serial)) {
						certificate = cert;
						break;
					}
				}
			} catch (Exception ex) {
				throw new KeySelectorException("Key is not found");
			}

			if (certificate == null) {
				throw new KeySelectorException("Key is not found");
			}
			final PublicKey result = certificate.getPublicKey();
			this.certificate = certificate;

			return new KeySelectorResult() {
				public Key getKey() {
					return result;
				}
			};
		}
	}
	public static Document createSignature(List<URI> contents, X509Certificate certificate,
			PrivateKey privateKey, IDigestProvider digestProvider) {
		try {

			XMLSignatureFactory factory = SecurityCorePlugin.getXMLSignatureFactory();

			Set<URI> fileSet = new TreeSet<URI>(new Comparator<URI>() {
				public int compare(URI uri1, URI uri2) {
					return uri1.toString().compareTo(uri2.toString());
			}
			});
			fileSet.addAll(contents);	
			
			List<Reference> entries = new ArrayList<Reference>();
			DigestMethod digestMethod = factory.newDigestMethod(DigestMethod.SHA1, null);
			for (URI next: fileSet) {
				byte[] digest = digestProvider.getDigest(next);
				Reference reference = factory.newReference(next.toString(), digestMethod, null, null, null, digest);
				entries.add(reference);
			}
			SignedInfo signedInfo = createContentSignedInfo(factory, entries);
			
			KeyInfo keyInfo = createKeyInfo(certificate, privateKey, factory);
			
			XMLSignature signature = factory.newXMLSignature(signedInfo, keyInfo);
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			documentBuilderFactory.setNamespaceAware(true);
			Document document = documentBuilderFactory.newDocumentBuilder().newDocument();
			
			DOMSignContext context =new DOMSignContext(privateKey, document);
			context.setURIDereferencer(new URIDereferencer() {
				public Data dereference(URIReference reference, XMLCryptoContext context)
						throws URIReferenceException {
					throw new URIReferenceException("Unsupported operation");
				}
			});
			signature.sign(context);
			return document;
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	
	public static Document createSignature(final URIConverter uriConverter, final URI base, List<URI> contents, X509Certificate certificate,
			PrivateKey privateKey) {
		try {

			XMLSignatureFactory factory = SecurityCorePlugin.getXMLSignatureFactory();

			Set<URI> fileSet = new HashSet<URI>();
			
			for (URI file: contents) {
//				URI deres = file.deresolve(base);
//				if (deres.equals(SigningUtils.LAYER_SIGNATURE_LOCATION)) {
//					continue;
//				}
				fileSet.add(file);
			}
			URI[] sorted = fileSet.toArray(new URI[fileSet.size()]);
			Arrays.sort(sorted, new Comparator<URI>() {
				public int compare(URI o1, URI o2) {
					return o1.toString().compareTo(o2.toString());
				}
			});
			
			List<Reference> entries = new ArrayList<Reference>();
			DigestMethod digestMethod = factory.newDigestMethod(DigestMethod.SHA1, null);
			for (URI next: sorted) {
				Reference reference = factory.newReference(next.toString(), digestMethod);
				entries.add(reference);
			}
			SignedInfo signedInfo = createContentSignedInfo(factory, entries);
			
			KeyInfo keyInfo = createKeyInfo(certificate, privateKey, factory);
			
			XMLSignature signature = factory.newXMLSignature(signedInfo, keyInfo);
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			documentBuilderFactory.setNamespaceAware(true);
			Document document = documentBuilderFactory.newDocumentBuilder().newDocument();
			
			DOMSignContext context =new DOMSignContext(privateKey, document);
			context.setURIDereferencer(new URIDereferencer() {
				public Data dereference(URIReference reference, XMLCryptoContext context)
						throws URIReferenceException {
					String uri = reference.getURI();
					URI targetURI = URI.createURI(uri).resolve(base);
					
					try {
						InputStream is = uriConverter.createInputStream(targetURI);
						return new OctetStreamData(is);
					} catch (Exception e) {
						e.printStackTrace();
						throw new URIReferenceException(e);
					}
				}
			});
			signature.sign(context);
			return document;
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	
	public static void marshalSignature(Document document, OutputStream os) {
		try {
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer trans = tf.newTransformer();
		
			trans.transform(new DOMSource(document), new StreamResult(os));
		} catch (Exception ex) {
			throw new RuntimeException();
		}
		
	}

	public static void signContents(final URIConverter uriConverter, URI signatureURI, final URI base, List<URI> contents, X509Certificate certificate,
			PrivateKey privateKey) {
		try {
			Document document = createSignature(uriConverter, base, contents, certificate, privateKey);
			
			OutputStream os = new BufferedOutputStream(uriConverter.createOutputStream(signatureURI));
			try {
				marshalSignature(document, os);
			} finally {
				os.close();
			}

		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	private static SignedInfo createContentSignedInfo(
			XMLSignatureFactory factory, List<Reference> entries)
			throws NoSuchAlgorithmException, InvalidAlgorithmParameterException {
		CanonicalizationMethod cmethod = factory.newCanonicalizationMethod(
				CanonicalizationMethod.INCLUSIVE_WITH_COMMENTS, (XMLStructure) null);
		SignatureMethod smethod = factory.newSignatureMethod(
				SignatureMethod.RSA_SHA1, null);
		SignedInfo signedInfo = factory
				.newSignedInfo(cmethod, smethod, entries);
		return signedInfo;
	}

	private static KeyInfo createKeyInfo(X509Certificate certificate,
			PrivateKey privateKey, XMLSignatureFactory factory)
			throws KeyException {
		PublicKey publicKey = certificate.getPublicKey();
		KeyInfoFactory keyInfoFactory = factory.getKeyInfoFactory();
		List<Object> keyInfoList = new ArrayList<Object>();
		keyInfoList.add(keyInfoFactory.newKeyName(certificate.getSerialNumber()
				.toString()));
		keyInfoList.add(keyInfoFactory.newX509IssuerSerial(certificate
				.getIssuerX500Principal().getName(), certificate
				.getSerialNumber()));
		keyInfoList.add(keyInfoFactory.newKeyValue(publicKey));
		KeyInfo keyInfo = keyInfoFactory.newKeyInfo(keyInfoList);
		return keyInfo;
	}
	
	public static String getShortName(X509Certificate certificate) {
		String name = certificate.getSubjectX500Principal().getName();
		Pattern p = Pattern.compile(".*O=([^,]*).*");
		Matcher m = p.matcher(name);
		if (m.matches()) {
			return m.group(1).trim();
		} else {
			return name;
		}
	}


	public static XMLSignature createXMLSignature(Document doc) throws MarshalException {
		XMLSignatureFactory factory = SecurityCorePlugin.getXMLSignatureFactory();
		XMLStructure structure = new DOMStructure(doc);
		XMLSignature signature = factory.unmarshalXMLSignature(structure);
		return signature;
	}
}
