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
 * Description: This file is part of com.nokia.tools.variant.confml.core component.
 */

package com.nokia.tools.variant.confml.core.operation;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;

import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.URIHandler;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.resource.impl.URIHandlerImpl;

import com.nokia.tools.variant.common.core.utils.ExceptionUtils;
import com.nokia.tools.variant.common.core.utils.FileUtils;
import com.nokia.tools.variant.confml.core.model.application.EStorageClass;
import com.nokia.tools.vct.confml.model.confml1.util.EConfML1ResourceFactoryImpl;

public class CPFUtil {

	/** CPF Base Root */
	public static final URI CPF_BASE_URI = URI.createURI("cpf:///");;

	private static final byte[] _$$d = { (byte) 0xE0, (byte) 0x9B, (byte) 0xAB,
			(byte) 0x75, (byte) 0xFF, (byte) 0xDC, (byte) 0xC8, (byte) 0x58,
			(byte) 0x72, (byte) 0xC8, (byte) 0x43, (byte) 0x96, (byte) 0x92,
			(byte) 0xC3, (byte) 0xB7, (byte) 0xF1 };

	public static ZipInputStream openCPFStream(File source) throws IOException {
		return openCPFStream(new FileInputStream(source));
	}

	public static List<URI> enumerateCPFResources(Object input)
			throws IOException {
		List<URI> resources = new ArrayList<URI>();
		{
			ZipInputStream zis = null;
			try {
				if (input instanceof IStorage) {
					zis = CPFUtil.openCPFStream(((IStorage)input).getContents());
				} else if (input instanceof URI) {
					zis = CPFUtil.openCPFStream(((URI)input));
				} else if (input instanceof File) {
					zis = CPFUtil.openCPFStream(((File)input));
				}
				
				for (ZipEntry zipEntry; (zipEntry = zis.getNextEntry()) != null;) {
					resources.add(URI.createURI(zipEntry.getName()).resolve(
							CPFUtil.CPF_BASE_URI));
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

	public static ZipInputStream openCPFStream(IStorage source)
			throws IOException {
		try {
			return openCPFStream(source.getContents());
		} catch (CoreException e) {
			throw new Resource.IOWrappedException(e);
		}
	}

	public static ZipInputStream openCPFStream(URI uri) throws IOException {
		URIConverter uriConverter = new ExtensibleURIConverterImpl();
		return openCPFStream(uriConverter.createInputStream(uri));
	}

	public static ZipOutputStream openCPFOutputStream(File file, boolean encrypt)
			throws FileNotFoundException, IOException {
		try {

			FileOutputStream fos = new java.io.FileOutputStream(file);
			OutputStream buffered = new BufferedOutputStream(fos);

			ZipOutputStream zos;

			if (encrypt) {
				DataOutputStream dao = new DataOutputStream(buffered);
				dao.writeByte('C');
				dao.writeByte('0');

				byte[] raw = _$$d.clone();
				SecretKeySpec skeySpec = new SecretKeySpec(raw, "Blowfish");
				Cipher cipher = Cipher.getInstance("Blowfish");
				cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
				int len = raw.length;
				dao.writeInt(len);
				dao.write(raw);
				CipherOutputStream cos = new CipherOutputStream(dao, cipher);
				zos = new ZipOutputStream(cos);
			} else {
				zos = new ZipOutputStream(buffered);
			}
			return zos;
		} catch (Exception ex) {
			ExceptionUtils.throwIfMatches(IOException.class, ex);
			throw new Resource.IOWrappedException(ex);
		}
	}

	private static ZipInputStream openCPFStream(InputStream source)
			throws IOException {
		BufferedInputStream buffered = new BufferedInputStream(source);
		DataInputStream dis = new DataInputStream(buffered);
		dis.mark(4);
		int signature = dis.readShort();
		ZipInputStream zis = null;

		try {
			switch (signature) {
			case ('C' << 8) | '0':
				int len = dis.readInt();
				byte[] key = new byte[len];
				int read = dis.read(key);
				if (read < len) {
					throw new IOException("Key unread");
				}
				SecretKeySpec skeySpec = new SecretKeySpec(key, "Blowfish");
				Cipher cipher = Cipher.getInstance("Blowfish");
				cipher.init(Cipher.DECRYPT_MODE, skeySpec);
				zis = new ZipInputStream(new CipherInputStream(dis, cipher));
				break;
			case ('P' << 8) | 'K':
				dis.reset();
				zis = new ZipInputStream(dis);
				break;
			case ('C' << 8) | '1':
				// public/private key - unsupported
			default:
				throw new IOException("Unsupported file signature");
			}
		} catch (Exception ex) {
			ExceptionUtils.throwIfMatches(IOException.class, ex);
			throw new Resource.IOWrappedException(ex);
		}
		return zis;
	}

	public static ResourceSet createCPFResourceSet(IStorage file) {
		return createCPFResourceSetInternal(file);
	}
	public static ResourceSet createCPFResourceSet(URI input) {
		return createCPFResourceSetInternal(input);
	}
	
	private static ResourceSet createCPFResourceSetInternal(final Object file) {
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
					if (file instanceof IStorage) {
						zis = CPFUtil.openCPFStream(((IStorage)file).getContents());
					} else if (file instanceof URI) {
						zis = CPFUtil.openCPFStream(((URI)file));
					} else if (file instanceof File) {
						zis = CPFUtil.openCPFStream(((File)file));
					}
					
					for (ZipEntry zipEntry; (zipEntry = zis.getNextEntry()) != null;) {
						if (zipEntry.isDirectory()) {
							zis.closeEntry();
							continue;
						}
						String name = zipEntry.getName();
						URI entryURI = URI.createURI(name)
								.resolve(CPF_BASE_URI);
						if (uri.equals(entryURI)) {
							result = zis;
							break;
						}
						zis.closeEntry();
					}
				} catch (CoreException e) {

					e.printStackTrace();
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
			if (input instanceof URI) {
				ExtensibleURIConverterImpl uriConverter = new ExtensibleURIConverterImpl();
				InputStream is = uriConverter.createInputStream((URI)input);
				dis = new DataInputStream(is);
			} else if (input instanceof IStorage) {
				dis = new DataInputStream(((IStorage)input).getContents());
			} else if (input instanceof File) {
				dis = new DataInputStream(new FileInputStream((File)input));
			}
			
			int signature = dis.readShort();
			switch (signature) {
			case ('C' << 8) | '0':
				return EStorageClass.SECURE_M0;
			case ('P' << 8) | 'K':
				return EStorageClass.PKZIP;
			case ('C' << 8) | '1':
				// public/private key - unsupported
			default:
				throw new IOException("Unsupported file signature");
			}
		} catch (Exception ex) {
			ExceptionUtils.throwIfMatches(IOException.class, ex);
			throw new Resource.IOWrappedException(ex);
		} finally {
			dis.close();
		}
	}

}
