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

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIHandler;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.resource.impl.URIHandlerImpl;

import com.nokia.tools.vct.common.appmodel.EStorageClass;
import com.nokia.tools.vct.common.core.utils.ExceptionUtils;
import com.nokia.tools.vct.common.core.utils.FileUtils;
import com.nokia.tools.vct.confml.model.confml1.util.EConfML1ResourceFactoryImpl;
import com.nokia.tools.vct.internal.common.appmodel.util.FileContentProvider;
import com.nokia.tools.vct.internal.common.appmodel.util.StorageContentProvider;
import com.nokia.tools.vct.internal.common.appmodel.util.URIContentProvider;

public class CPFUtil {

	/** CPF Base Root */
	public static final URI CPF_BASE_URI = URI.createURI("cpf:///");

	// public static String HASH_CODE = "MD5";
	// private static final byte[] _$$d = { (byte) 0xE0, (byte) 0x9B, (byte)
	// 0xAB,
	// (byte) 0x75, (byte) 0xFF, (byte) 0xDC, (byte) 0xC8, (byte) 0x58,
	// (byte) 0x72, (byte) 0xC8, (byte) 0x43, (byte) 0x96, (byte) 0x92,
	// (byte) 0xC3, (byte) 0xB7, (byte) 0xF1 };

	public static ZipInputStream openCPFStream(Object source)
			throws CoreException {
		return openCPFStream(selectCPFContentProvider(source));
	}

	public static ZipOutputStream openCPFOutputStream(Object target)
			throws CoreException {
		return openCPFOutputStream(selectCPFContentProvider(target));
	}

	/**
	 * Selects a direct (insecure and unbuffered) content provider
	 * 
	 * @param input
	 *            Input object.
	 * @return CPF content provider interface
	 */
	public static ICPFContentProvider selectCPFContentProvider(Object input) {
		if (input instanceof ICPFContentProvider) {
			return (ICPFContentProvider) input;
		} else if (input instanceof File) {
			return new FileContentProvider((File) input);
		} else if (input instanceof URI) {
			return new URIContentProvider((URI) input);
		} else if (input instanceof IStorage) {
			return new StorageContentProvider((IStorage) input);
		} else {
			throw new IllegalArgumentException("Input is not supported:"
					+ input.getClass());
		}
	}

	/**
	 * Helper method for constructing hierarchical URI from {@link ZipEntry}
	 * name. The method escapes all requires characters from name segments.
	 * 
	 * @param zipEntry
	 *            ZIP entry for processing
	 * @return constructed URI
	 */
	public static URI createZipEntryURI(ZipEntry zipEntry) {
		// When the name contains some characteris like spaces, it shall be
		// escaped with %20 etc.
		String[] segments = zipEntry.getName().split("/", -1);
		for (int i = 0; i < segments.length; i++) {
			segments[i] = URI.encodeSegment(segments[i], false);
		}
		URI uri = URI.createHierarchicalURI(segments, null, null);
		return uri;
	}

	public static List<URI> enumerateCPFResources(Object input)
			throws IOException {
		List<URI> resources = new ArrayList<URI>();
		{
			ZipInputStream zis = null;
			try {
				ICPFContentProvider contentProvider = selectCPFContentProvider(input);
				zis = CPFUtil.openCPFStream(contentProvider);

				for (ZipEntry zipEntry; (zipEntry = zis.getNextEntry()) != null;) {
					URI uri = createZipEntryURI(zipEntry);
					uri = uri.resolve(CPFUtil.CPF_BASE_URI);
					resources.add(uri);
					zis.closeEntry();
				}
			} catch (CoreException ex) {
				throw new Resource.IOWrappedException(ex);
			} finally {
				FileUtils.closeStream(zis);
			}
		}
		return resources;
	}

	@Deprecated
	public static ZipOutputStream openCPFOutputStream(File file, boolean encrypt)
			throws FileNotFoundException, IOException {
		if (encrypt) {
			throw new UnsupportedOperationException();
		}

		try {
			return openCPFOutputStream(file);
		} catch (Exception ex) {
			ExceptionUtils.throwIfMatches(IOException.class, ex);
			throw new Resource.IOWrappedException(ex);
		}
	}

	private static ZipInputStream openCPFStream(ICPFContentProvider source)
			throws CoreException {
		BufferedInputStream buffered = new BufferedInputStream(source
				.createInputStream());
		return new ZipInputStream(buffered);
	}

	private static ZipOutputStream openCPFOutputStream(
			ICPFContentProvider target) throws CoreException {
		BufferedOutputStream buffered = new BufferedOutputStream(target
				.createOutputStream());
		return new ZipOutputStream(buffered);
	}

	public static ResourceSet createCPFResourceSet(Object input) {
		ICPFContentProvider contentProvider = selectCPFContentProvider(input);
		return createCPFResourceSetInternal(contentProvider);
	}

	private static ResourceSet createCPFResourceSetInternal(
			final ICPFContentProvider contentProvider) {
		ResourceSet resourceSet = new ResourceSetImpl();
		List<URIHandler> uriHandlers = new ArrayList<URIHandler>();
		List<ContentHandler> contentHandlers = new ArrayList<ContentHandler>();
		contentHandlers.addAll(ContentHandler.Registry.INSTANCE
				.contentHandlers());

		uriHandlers.add(new URIHandlerImpl() {

			public boolean canHandle(URI uri) {
				return true;
			}

			@Override
			public OutputStream createOutputStream(URI uri, Map<?, ?> options)
					throws IOException {
				throw new UnsupportedOperationException();
			}

			@Override
			public void delete(URI uri, Map<?, ?> options) throws IOException {
				throw new UnsupportedOperationException();
			}

			@Override
			public InputStream createInputStream(URI uri, Map<?, ?> options)
					throws IOException {

				uri = uri.resolve(CPF_BASE_URI);

				ZipInputStream zis = null;

				InputStream result = null;
				try {
					zis = CPFUtil.openCPFStream(contentProvider);

					for (ZipEntry zipEntry; (zipEntry = zis.getNextEntry()) != null;) {
						if (zipEntry.isDirectory()) {

							continue;
						}
						URI entryURI = createZipEntryURI(zipEntry).resolve(
								CPF_BASE_URI);
						if (uri.equals(entryURI)) {
							result = zis;
							break;
						}

					}
				} catch (CoreException e) {
					throw new Resource.IOWrappedException(e);
				} finally {
					if (result == null) {
						FileUtils.closeStream(zis);
					}
				}
				if (result != null) {
					return result;
				}

				throw new FileNotFoundException("Entry does not exist" + uri);
			}

			@Override
			public Map<String, ?> getAttributes(URI uri, Map<?, ?> options) {
				return super.getAttributes(uri, options);
			}
		});

		resourceSet.setURIConverter(new ExtensibleURIConverterImpl(uriHandlers,
				contentHandlers));
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put("confml", new EConfML1ResourceFactoryImpl());
		return resourceSet;
	}

	public static EStorageClass detectStorageClass(Object input)
			throws IOException {
		DataInputStream dis = null;
		try {
			ICPFContentProvider contentProvider = selectCPFContentProvider(input);
			dis = new DataInputStream(contentProvider.createInputStream());

			int signature = dis.readShort();
			switch (signature) {
			case ('C' << 8) | '0':
				return EStorageClass.SECURE_M0;
			case ('P' << 8) | 'K':
				return EStorageClass.PKZIP;
			case ('C' << 8) | '1':
				return EStorageClass.ENCRYPTED;
			default:
				throw new IOException("Unsupported file signature");
			}
		} catch (Exception ex) {
			ExceptionUtils.throwIfMatches(IOException.class, ex);
			throw new Resource.IOWrappedException(ex);
		} finally {
			FileUtils.closeStream(dis);
		}
	}

}
