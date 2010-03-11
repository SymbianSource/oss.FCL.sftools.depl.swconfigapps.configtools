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
 * Description: This file is part of com.nokia.tools.vct.common.appmodel component.
 */

package com.nokia.tools.vct.common.appmodel.util;

import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.w3c.dom.Document;

import com.nokia.tools.vct.common.appmodel.EConfMLLayer;
import com.nokia.tools.vct.common.appmodel.EConfigurationProject;
import com.nokia.tools.vct.common.secure.core.SigningStatus;
import com.nokia.tools.vct.common.secure.core.SigningUtils;

public class CPFSigningUtils {

	public static final URI LAYER_SIGNATURE_LOCATION = URI
			.createURI("layer.sign");

	/**
	 * Get complete signing status of the configuration project
	 * 
	 * @param monitor Progress monitor
	 * @param project Configuration project to process
	 * @param resources List of all resource
	 * @param digestMap Digest map (project URI to digest)
	 * @param signatures Signature documents
	 * @return Array of all status objects
	 */
	public static SigningStatus[] getProjectStatus(IProgressMonitor monitor, 
			EConfigurationProject project, Collection<URI> resources, Map<URI,byte[]> digestMap, Map<URI,Document> signatures) {
		monitor.beginTask("Signature Checks",
				project.getLayers().size() * 100 + 10);
		List<SigningStatus> result = new ArrayList<SigningStatus>(project
				.getLayers().size() + 1);
		result.add(getRootStatus(project, resources, digestMap, signatures));
		monitor.worked(10);
		for (EConfMLLayer next : project.getLayers()) {
			result.add(getLayerStatus(next, resources, digestMap, signatures));
			monitor.worked(100);
		}
		monitor.done();
		return result.toArray(new SigningStatus[result.size()]);
	}
	
	public static SigningStatus getRootStatus(EConfigurationProject project, Collection<URI> resources, final Map<URI,byte[]> digestMap, Map<URI,Document> signatures) {
		String ref = project.getRootConfml().lastSegment();
		final URI signatureURI = URI.createURI(ref + ".sign").resolve(
				project.getRootConfml());
		URI temp = URI.createURI(project.getRootConfml().lastSegment());
		Document signature = signatures.get(signatureURI);
		SigningStatus status = SigningUtils.getSigningStatus(signature, new SigningUtils.IDigestVerifyer() {
			public boolean isDigestCorrect(URI uri, byte[] digest) {
				// URI is relative to the document
				uri = uri.resolve(signatureURI);
				byte[] provisioned = digestMap.get(uri);
				return Arrays.equals(digest, provisioned);
			}
		}, Collections.singleton(temp));
		
		status.modelObject = project;
		return status;
	}
	
	public static SigningStatus getLayerStatus(final EConfMLLayer layer, Collection<URI> resources, final Map<URI,byte[]> digestMap, Map<URI,Document> signatures) {
		Set<URI> layerFiles = new HashSet<URI>();
		for (URI file : layer.getLayerFiles()) {
			if (file.lastSegment().length() == 0) {
				continue;
			}
			if ("sign".equals(file.fileExtension())) {
				continue;
			}
			
			URI deres = file.deresolve(layer.getLayerURI());
			layerFiles.add(deres);
		}
		final URI signatureURI = LAYER_SIGNATURE_LOCATION.resolve(layer
				.getLayerURI());
		Document signature = signatures.get(signatureURI);
		SigningStatus status = SigningUtils.getSigningStatus(signature, new SigningUtils.IDigestVerifyer() {
			public boolean isDigestCorrect(URI uri, byte[] digest) {
				// URI is relative to the document
				uri = uri.resolve(signatureURI);
				byte[] provisioned = digestMap.get(uri);
				return Arrays.equals(digest, provisioned);
			}
		},layerFiles);
		status.modelObject = layer;
		return status;
	}
	
	public static SigningStatus[] getProjectStatus(
			EConfigurationProject project, IProgressMonitor monitor) {
		monitor.beginTask("Signature Checks",
				project.getLayers().size() * 100 + 10);
		List<SigningStatus> result = new ArrayList<SigningStatus>(project
				.getLayers().size() + 1);
		result.add(getRootStatus(project));
		monitor.worked(10);
		for (EConfMLLayer next : project.getLayers()) {
			result.add(getLayerStatus(next));
			monitor.worked(100);
		}
		monitor.done();
		return result.toArray(new SigningStatus[result.size()]);
	}

	public static SigningStatus getRootStatus(EConfigurationProject project) {
		URIConverter uriConverter = project.eResource().getResourceSet().getURIConverter();
		
		String ref = project.getRootConfml().lastSegment();
		URI signatureURI = URI.createURI(ref + ".sign").resolve(
				project.getRootConfml());
		URI temp = URI.createURI(project.getRootConfml().lastSegment());
		
		SigningStatus status = SigningUtils.getSigningStatus(uriConverter, signatureURI, Collections.singleton(temp));
		status.modelObject = project;
		return status;
	}

	public static SigningStatus getLayerStatus(final EConfMLLayer layer) {
		final URIConverter uriConverter = layer.eResource().getResourceSet()
				.getURIConverter();
		Set<URI> layerFiles = new HashSet<URI>();
		for (URI file : layer.getLayerFiles()) {
			if (file.lastSegment().length() == 0) {
				continue;
			}
			
			URI deres = file.deresolve(layer.getLayerURI());
			if (deres.equals(LAYER_SIGNATURE_LOCATION)) {
				continue;
			}
			layerFiles.add(deres);
		}
		URI signatureURI = LAYER_SIGNATURE_LOCATION.resolve(layer
				.getLayerURI());

		SigningStatus status = SigningUtils.getSigningStatus(uriConverter, signatureURI, layerFiles);
		status.modelObject = layer;
		return status;
	}
	public static Document createSignature(final EConfigurationProject project, X509Certificate certificate,
			PrivateKey privateKey) {
		URIConverter uriConverter = project.eResource().getResourceSet().getURIConverter();
		URI root = URI.createURI(project.getRootConfml().lastSegment());
		List<URI> contents = Collections.singletonList(root);
		URI base = URI.createURI("").resolve(project.getRootConfml());
		return SigningUtils.createSignature(uriConverter, base, contents, certificate, privateKey);
	}
	public static void signRoot(final EConfigurationProject project, X509Certificate certificate,
			PrivateKey privateKey) {
		URIConverter uriConverter = project.eResource().getResourceSet().getURIConverter();
		URI signatureURI = getSignatureURI(project);
		URI root = URI.createURI(project.getRootConfml().lastSegment());
		List<URI> contents = Collections.singletonList(root);
		URI base = URI.createURI("").resolve(project.getRootConfml());
		SigningUtils.signContents(uriConverter, signatureURI, base, contents, certificate, privateKey);
	}

	public static Document createSignature(final EConfMLLayer layer, X509Certificate certificate,
			PrivateKey privateKey) {
		URIConverter uriConverter = layer.eResource().getResourceSet().getURIConverter();
		URI base = layer.getLayerURI();
		List<URI> contents = new ArrayList<URI>(layer.getLayerFiles().size());
		for (URI file: layer.getLayerFiles()) {
			if (file.lastSegment().length() == 0) {
				continue;
			}
			URI deres = file.deresolve(layer.getLayerURI());
			if (deres.equals(CPFSigningUtils.LAYER_SIGNATURE_LOCATION)) {
				continue;
			}
			contents.add(deres);
		}
		return SigningUtils.createSignature(uriConverter, base, contents, certificate, privateKey);
	}
	
	public static URI getSignatureURI(EConfMLLayer layer) {
		URI signatureURI = CPFSigningUtils.LAYER_SIGNATURE_LOCATION.resolve(layer.getLayerURI());
		return signatureURI;
	}
	
	public static URI getSignatureURI(EConfigurationProject project) {
		String ref = project.getRootConfml().lastSegment();
		URI signatureURI = URI.createURI(ref + ".sign").resolve(
				project.getRootConfml());
		return signatureURI;
	}
	
	public static void signLayer(final EConfMLLayer layer, X509Certificate certificate,
			PrivateKey privateKey) {
		URIConverter uriConverter = layer.eResource().getResourceSet().getURIConverter();
		URI signatureURI = getSignatureURI(layer);
		URI base = layer.getLayerURI();
		List<URI> contents = new ArrayList<URI>(layer.getLayerFiles().size());
		for (URI file: layer.getLayerFiles()) {
			if (file.lastSegment().length() == 0) {
				continue;
			}
			URI deres = file.deresolve(layer.getLayerURI());
			if (deres.equals(CPFSigningUtils.LAYER_SIGNATURE_LOCATION)) {
				continue;
			}
			contents.add(deres);
		}
		SigningUtils.signContents(uriConverter, signatureURI, base, contents, certificate, privateKey);
	}
}
