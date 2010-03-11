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
 * Description: This file is part of com.nokia.tools.variant.editor component.
 */

package com.nokia.tools.variant.editor.validation;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.eclipse.core.runtime.Path;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSInput;
import org.w3c.dom.ls.LSParser;
import org.w3c.dom.ls.LSResourceResolver;

import com.nokia.tools.variant.common.core.utils.FileUtils;
import com.nokia.tools.variant.confml.core.model.application.EConfigurationProject;
import com.nokia.tools.variant.preview.theme.ThemePreviewPlugin;
import com.nokia.tools.variant.viewer.validation.EResult;
import com.nokia.tools.variant.viewer.validation.ValidationResult;

public class ThemeValidator {

	private EConfigurationProject project;

	private File tdfFile;
	private String tpfFile;

	private String cpfPhoneId;
	private String tdfPhoneId;

	public ThemeValidator(EConfigurationProject project, String tpfFile) {
		this.tpfFile = tpfFile;
		this.tdfFile = getTdfFile(tpfFile);
		this.project = project;
	}

	public ValidationResult validate() {
		try {
			if (tdfFile == null) {
				this.tdfFile = getTdfFile(tpfFile);
			}
			cpfPhoneId = getCpfPhoneId();
			tdfPhoneId = parseTdfPhoneId();
			return validate(tdfPhoneId, cpfPhoneId);
		} catch (ClassCastException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return new ValidationResult(EResult.VALID);
	}

	private File getTdfFile(String tpfFile) {
		File tdf = null;
		InputStream inputContents = null;
		try {
			inputContents = new FileInputStream(new File(tpfFile));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			ZipInputStream zis = new ZipInputStream(inputContents);
			ZipEntry zipEntry;

			while ((zipEntry = zis.getNextEntry()) != null) {
				if (zipEntry.getName().endsWith(".tdf")) {
					String tmp = new Path(zipEntry.getName()
							.replace(".tdf", "")).toOSString();
					String name = tmp.substring(tmp.lastIndexOf("\\") + 1, tmp
							.length());
					tdf = File.createTempFile(name, ".tdf");

					FileOutputStream fos = new FileOutputStream(tdf);
					FileUtils.copyStream(zis, fos);
					fos.close();
					zis.closeEntry();
					break;
				}
				zis.closeEntry();
			}
		} catch (Exception e) {
			ThemePreviewPlugin.logError("Failed to read theme content", e);
		} finally {
			FileUtils.closeStream(inputContents);
			if (tdf != null) {
				tdf.deleteOnExit();
			}
		}

		return tdf;
	}

	private ValidationResult validate(String tdfId, String cpfId) {
		if (tdfId != "" && cpfPhoneId != "") {
			tdfId = tdfId.replaceAll("\\.", "");
			cpfId = cpfPhoneId.replaceAll("\\.", "");

			String[] tdf = tdfId.toLowerCase().split("_");
			String[] cpf = cpfId.toLowerCase().split("_");

			if (tdf.length >= 2 && cpf.length >= 2) {
				String tdfPlat = tdf[0];
				String cpfPlat = cpf[0];
				String tdfVer = tdf[1];
				String cpfVer = cpf[1];

				ValidationResult result = new ValidationResult(
						EResult.THEME_VERSION_NOT_MATCH, ", " + tdfPhoneId
								+ " is not equal " + cpfPhoneId);
				if (!tdfPlat.equals(cpfPlat)) {
					return result;
				} else if (!(tdfVer.equals(cpfVer))) {
					return result;
				}
			} else {
				return new ValidationResult(EResult.UNABLE_IDENTIFY);
			}
		}

		return new ValidationResult(EResult.VALID);
	}

	private String getCpfPhoneId() {
		String id = "";
		String platform = project.getPlatform();
		String release = project.getRelease();

		if (platform != "" && release != "") {
			id = platform + "_" + release;
		}

		return id;
	}

	private String parseTdfPhoneId() throws ClassCastException,
			ClassNotFoundException, InstantiationException,
			IllegalAccessException, IOException {
		String phoneId = "";

		DOMImplementationRegistry registry = DOMImplementationRegistry
				.newInstance();
		DOMImplementation domImpl = registry.getDOMImplementation("LS 3.0");
		DOMImplementationLS ls = (DOMImplementationLS) domImpl;
		LSInput lsInput = ls.createLSInput();
		InputStream is = new BufferedInputStream(new FileInputStream(tdfFile));
		lsInput.setByteStream(is);
		LSParser parser = ls.createLSParser(
				DOMImplementationLS.MODE_SYNCHRONOUS, null);
		parser.getDomConfig().setParameter("namespaces", false);
		parser.getDomConfig().setParameter("infoset", false);
		parser.getDomConfig().setParameter("resource-resolver",
				new LSResourceResolverImp(ls));

		Document doc = parser.parse(lsInput);
		is.close();
		Element root = doc.getDocumentElement();
		NodeList nodes = root.getChildNodes();

		for (int i = 0; i < nodes.getLength(); i++) {
			Node n = nodes.item(i);
			if (n instanceof Element) {
				Element phone = (Element) n;
				if ("phone".equals(phone.getNodeName())) {
					NodeList childNodes = phone.getChildNodes();
					for (int j = 0; j < childNodes.getLength(); j++) {
						Node child = childNodes.item(j);
						if (child instanceof Element) {
							Element model = (Element) child;
							if ("model".equals(model.getNodeName())) {
								Attr idAttr = model.getAttributeNode("id");
								String id = idAttr.getNodeValue();
								if (id != null) {
									if (phoneId != "") {
										String[] split = id.split("_");
										String[] split2 = phoneId.split("_");
										if (split.length == 2
												&& split[0]
														.equalsIgnoreCase(split2[0])) {
											phoneId += split[1];
										}
									} else {
										phoneId += id;
									}
								}
							}
						}
					}
					break;
				}
			}
		}

		return phoneId;
	}

	class LSResourceResolverImp implements LSResourceResolver {
		private DOMImplementationLS ls;

		public LSResourceResolverImp(DOMImplementationLS ls) {
			this.ls = ls;
		}

		public LSInput resolveResource(String type, String namespaceURI,
				String publicId, String systemId, String baseURI) {
			LSInput input = ls.createLSInput();
			input.setBaseURI(baseURI);
			input.setSystemId(systemId);
			input.setCharacterStream(new StringReader(""));
			return input;
		}
	}
}
