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
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSInput;
import org.w3c.dom.ls.LSOutput;
import org.w3c.dom.ls.LSParser;
import org.w3c.dom.ls.LSSerializer;

import com.nokia.tools.vct.common.core.utils.ExceptionUtils;
import com.nokia.tools.vct.common.core.utils.FileUtils;

public class ImportImplMLFileRunnable implements IWorkspaceRunnable {

	private boolean importDirectory;
	private File source;
	private IContainer targetContainer;
	private boolean makeLinks;
	private ArrayList<String> supportedExtensions = null;
	/**
	 * ID of plugin that calls this class
	 */
	private String plugin_ID;

	public ImportImplMLFileRunnable(boolean importDirectory, File source,
			IContainer targetContainer, boolean makeLinks,  String plugin_ID) {

		this.importDirectory = importDirectory;
		this.source = source;
		this.targetContainer = targetContainer;
		this.makeLinks = makeLinks;
		this.plugin_ID = plugin_ID;
		this.supportedExtensions = new ArrayList<String>();
		populateSupportedExtensions();
	}

	private void populateSupportedExtensions() {
		supportedExtensions.add("implml");
		supportedExtensions.add("commandml");
		supportedExtensions.add("content");
		supportedExtensions.add("contentml");
		supportedExtensions.add("crml");
		supportedExtensions.add("gcfml");
		supportedExtensions.add("hcrml");
		supportedExtensions.add("imageml");
		supportedExtensions.add("makeml");
		supportedExtensions.add("ruleml");
		supportedExtensions.add("templateml");
		supportedExtensions.add("thememl");
		supportedExtensions.add("convertprojectml");	
	}

	public void run(IProgressMonitor monitor) throws CoreException {

		if (!source.exists()) {
			throw new CoreException(new Status(IStatus.ERROR, plugin_ID,
			"Source does not exist"));
		}

		List<File> toImport = new ArrayList<File>();
		if (importDirectory) {
			File[] list = source.listFiles(new FileFilter() {
				public boolean accept(File pathname) {
					if (!pathname.isFile()) {
						return false;
					}
					String name = pathname.getName();
					int idx = name.lastIndexOf('.');
					if (idx < 0) {
						return false;
					}
					String suffix = name.substring(idx + 1);
					return (supportedExtensions.contains(suffix));
				}
			});
			toImport.addAll(Arrays.asList(list));
		} else {
			toImport.add(source);
		}

		IContainer dest = targetContainer;
		if (dest == null || !dest.exists()) {
			return;
		}

		if(makeLinks) {
			for (File file : toImport) {
				IFile ifile = dest.getFile(new Path(file.getName()));
				IPath path = new Path(file.getAbsolutePath());
				ifile.createLink(path,  IResource.FORCE
						| IResource.KEEP_HISTORY, monitor);
			}
		} else {
			DOMImplementationRegistry registry;
			try {
				registry = DOMImplementationRegistry.newInstance();
			} catch (Exception ex) {
				throw ExceptionUtils.wrapCoreException(ex, plugin_ID,
				"Failed to access DOM feature");
			}
			DOMImplementation domImpl = registry.getDOMImplementation("LS 3.0");
			if (domImpl == null) {
				throw new CoreException(new Status(IStatus.ERROR, plugin_ID,
				"Failed to access DOM Level 3 LS"));
			}
			DOMImplementationLS lsImpl = (DOMImplementationLS) domImpl;
			LSParser parser = lsImpl.createLSParser(
					DOMImplementationLS.MODE_SYNCHRONOUS,
			"http://www.w3.org/2001/XMLSchema");
			LSSerializer serializer = lsImpl.createLSSerializer();
			serializer.getDomConfig().setParameter("format-pretty-print", true);
//
//			if (prettyPrint) {
//			}


			for (File f : toImport) {
				try {
					LSInput input = lsImpl.createLSInput();
					InputStream is;
					try {
						is = new BufferedInputStream(new FileInputStream(f));
					} catch (FileNotFoundException e) {

						e.printStackTrace();
						continue;
					}
					input.setByteStream(is);
					Document xmlDocument = parser.parse(input);
					FileUtils.closeStream(is);

//					Element rootElement = xmlDocument.getDocumentElement();
					// rootElement.setAttributeNS(XMLConstants.XML_NS_URI,
					// "xmlns:xi", "http://www.w3.org/2001/XInclude");
//					if (fixXInclude) {
//						NodeList xincludes = rootElement.getElementsByTagNameNS(
//								"http://www.w3.org/2001/xinclude", "include");
//						ArrayList<Element> badElements = new ArrayList<Element>();
//						for (int i = 0; i < xincludes.getLength(); i++) {
//							Element xinc = (Element) xincludes.item(i);
//							badElements.add(xinc);
//						}
//						for (Element src : badElements) {
//							String href = src.getAttributeNS(null, "href");
//							int frag = href.indexOf('#');
//							if (frag >= 0) {
//								href = href.substring(0, frag);
//							}
//							while (href.length() > 0 && href.charAt(0) == '/') {
//								href = href.substring(1);
//							}
//
//							Element newElement = xmlDocument
//							.createElementNS(
//									"http://www.w3.org/2001/XInclude",
//							"xi:include");
//							newElement.setAttributeNS(null, "href", href);
//							((Element) src.getParentNode()).insertBefore(
//									newElement, src);
//							((Element) src.getParentNode()).removeChild(src);
//						}
//					}

					LSOutput output = lsImpl.createLSOutput();
					output.setEncoding("utf-8");
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					output.setByteStream(baos);

					serializer.write(xmlDocument, output);

					IFile file = dest.getFile(new Path(f.getName()));
					InputStream content = null;
					try {
						content = new ByteArrayInputStream(baos.toByteArray());
						if (file.exists()) {
							file.setContents(content, IResource.FORCE
									| IResource.KEEP_HISTORY,
									new SubProgressMonitor(monitor, 1));
						} else {
							file.create(content, IResource.FORCE
									| IResource.KEEP_HISTORY,
									new SubProgressMonitor(monitor, 1));
						}
					} finally {
						if (content != null) {
							content.close();
						}
					}
				} catch (CoreException ex) {
					ex.printStackTrace();

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}

		}
	}
}
