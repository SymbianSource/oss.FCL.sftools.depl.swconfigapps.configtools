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

package com.nokia.tools.variant.editor.utils;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InvalidPropertiesFormatException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Map.Entry;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.ui.IEditorInput;

import com.nokia.tools.variant.common.core.utils.ArrayUtils;
import com.nokia.tools.variant.common.core.utils.FileUtils;
import com.nokia.tools.variant.confml.core.model.application.EAppFeature;
import com.nokia.tools.variant.confml.core.model.application.EAppIncludeElement;
import com.nokia.tools.variant.confml.core.model.application.EAppSetting;
import com.nokia.tools.variant.confml.core.model.application.EAppView;
import com.nokia.tools.variant.confml.core.model.application.EApplicationFactory;
import com.nokia.tools.variant.confml.core.model.application.EConfMLLayer;
import com.nokia.tools.variant.confml.core.model.application.EConfigurationProject;
import com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata;
import com.nokia.tools.variant.confml.core.operation.CPFUtil;
import com.nokia.tools.variant.confml.internal.core.application.AppModelFactory;
import com.nokia.tools.variant.confml.internal.core.project.ContributorUtils;
import com.nokia.tools.variant.content.confml.ConfmlFactory;
import com.nokia.tools.variant.content.confml.FilePath;
import com.nokia.tools.variant.content.confml.FileSystemEntrySetting;
import com.nokia.tools.variant.content.confml.Icon;
import com.nokia.tools.variant.content.confml.Setting;
import com.nokia.tools.variant.content.confml.SimpleSetting;
import com.nokia.tools.variant.content.confml.TYPE;
import com.nokia.tools.variant.content.confml.View;
import com.nokia.tools.variant.editor.cpfInfo.CPFInformation;
import com.nokia.tools.variant.editor.cpfInfo.CpfInfoFactory;
import com.nokia.tools.variant.editor.editors.ViewEditorModel;
import com.nokia.tools.variant.editor.model.convertor.CPFInformationConvertor;
import com.nokia.tools.variant.editor.model.convertor.CPFInformationConvertorFactory;
import com.nokia.tools.variant.editor.model.convertor.ConfML1CPFInformationConvertor;
import com.nokia.tools.variant.editor.model.convertor.ConfML2CPFInformationConvertor;
import com.nokia.tools.variant.editor.model.convertor.ConfmlApplicationModel2ViewModelConvertor;
import com.nokia.tools.variant.editor.model.convertor.ViewModel2ConfMLPersistenceModelConvertor;
import com.nokia.tools.variant.editor.model.convertor.ViewModel2ConfMLPersistenceModelConvertorFactory;
import com.nokia.tools.variant.editor.model.summaryModel.History;
import com.nokia.tools.variant.editor.model.summaryModel.Note;
import com.nokia.tools.variant.editor.model.summaryModel.SummaryModelFactory;
import com.nokia.tools.variant.editor.validation.ThemeValidator;
import com.nokia.tools.variant.javascript.JavaScriptImplmlFilesEvaluator;
import com.nokia.tools.variant.javascript.accesslog.AuditLogger;
import com.nokia.tools.variant.javascript.accesslog.AuditLoggerImpl;
import com.nokia.tools.variant.resourcelibrary.model.Directory;
import com.nokia.tools.variant.resourcelibrary.model.FileSystemElement;
import com.nokia.tools.variant.resourcelibrary.model.ResourceModelRoot;
import com.nokia.tools.variant.resourcelibrary.model.ThemeFile;
import com.nokia.tools.variant.resourcelibrary.model.resourcesFactory;
import com.nokia.tools.variant.resourcelibrary.resources.ResourceUtil;
import com.nokia.tools.variant.viewer.validation.EResult;
import com.nokia.tools.variant.viewer.validation.ValidationResult;
import com.nokia.tools.vct.confml.model.confml1.EConfMLDocument;
import com.nokia.tools.vct.confml.model.confml1.EConfigurationElement;
import com.nokia.tools.vct.confml.model.confml1.include.EInclude;
import com.nokia.tools.vct.confml.model.confml1.util.EConfML1ResourceImpl;
import com.nokia.tools.vct.confml.model.confml2.EConfML2Document;

/**
 * This class provides common cpf operations.
 * ( Support for EMF/File System operations )
 */
public class CPFManager {

	/**
	 * Converts {@link EConfigurationProject} to {@link View}
	 * 
	 * @param project
	 * @return View
	 */
	public static View createView(EConfigurationProject project) {
		View view = new ConfmlApplicationModel2ViewModelConvertor()
				.convert(project);
		return view;
	}

	/**
	 * Loads {@link ResourceModelRoot} from given URI and {@link EConfigurationProject}
	 * 
	 * @param input
	 * @param configurationProject
	 * @param tempDefaultResourceLibraryFilesDir
	 * @return ResourceModelRoot
	 * @throws IOException
	 */
	public static ResourceModelRoot loadResourceModel(URI input,
			EConfigurationProject configurationProject,
			File tempDefaultResourceLibraryFilesDir) throws IOException {

		long start = System.currentTimeMillis();

		// create temporary resource library location
		ResourceModelRoot resourceModelRoot = resourcesFactory.eINSTANCE
				.createResourceModelRoot();

		File rootCpfTempDir = File.createTempFile("cpf", "_content");
		rootCpfTempDir.delete();
		rootCpfTempDir.mkdirs();

		resourceModelRoot.setTempDirPath(rootCpfTempDir.getAbsolutePath());

		// LOAD COMPLETE RESOURCE MAP INTO TMP
		// entry.key == Resource Path relative to CONTENT
		// entry.value == Resource Path relative CPF ROOT
		EConfMLLayer lastLayer = configurationProject.getLastLayer();
		if (lastLayer != null) {
			EMap<URI, URI> resourceMap = lastLayer.getResourceMap();

			Map<URI, List<URI>> reverseMap = new HashMap<URI, List<URI>>();
			for (Map.Entry<URI, URI> entry : resourceMap) {
				URI local = entry.getKey();
				URI global = entry.getValue();
				List<URI> list = reverseMap.get(global);
				if (list == null) {
					list = new ArrayList<URI>();
					reverseMap.put(global, list);
				}
				list.add(local);
			}

			ZipInputStream stream = CPFUtil.openCPFStream(input);
			for (ZipEntry entry = stream.getNextEntry(); entry != null; stream
					.closeEntry(), entry = stream.getNextEntry()) {
				URI entryURI = URI.createURI(entry.getName()).resolve(
						CPFUtil.CPF_BASE_URI);
				List<URI> targets = reverseMap.get(entryURI);
				if (targets == null) {
					continue;
				}
				for (URI targetURI : targets) {
					String targetPath = targetURI.path();
					File file = new File(rootCpfTempDir, targetPath);
					if (entry.isDirectory()) {
						file.mkdirs();
					} else {
						File parent = file.getParentFile();
						parent.mkdirs();
						FileOutputStream os = new FileOutputStream(file);
						FileUtils.copyStream(stream, os);
						FileUtils.closeStream(os);
					}
				}
			}

			stream.close();

			// create resource library model
			processResourceLibrary(configurationProject, resourceModelRoot,
					rootCpfTempDir, resourceMap, lastLayer);

			// Collect all default resources and attach them
			// to corresponding resource from variant layer
			EConfMLLayer defaultResourcesLayer = lastLayer.getParent();
			if (defaultResourcesLayer != null) {
				EMap<URI, URI> defaultResourceMap = defaultResourcesLayer
						.getResourceMap();
				// collects all resources by relative 2 global uri
				Map<URI, List<URI>> defaultReverseMap = new HashMap<URI, List<URI>>();
				for (Map.Entry<URI, URI> entry : defaultResourceMap) {
					URI local = entry.getKey();
					URI global = entry.getValue();
					List<URI> list = defaultReverseMap.get(global);
					if (list == null) {
						list = new ArrayList<URI>();
						defaultReverseMap.put(global, list);
					}
					list.add(local);
				}

				// put all default resources to temporary location
				ZipInputStream s = CPFUtil.openCPFStream(input);
				for (ZipEntry entry = s.getNextEntry(); entry != null; s
						.closeEntry(), entry = s.getNextEntry()) {
					URI entryURI = URI.createURI(entry.getName()).resolve(
							CPFUtil.CPF_BASE_URI);
					List<URI> targets = defaultReverseMap.get(entryURI);
					if (targets == null) {
						continue;
					}
					for (URI targetURI : targets) {
						String targetPath = targetURI.path();

						if (!entry.isDirectory()) {
							// copy resource to temp dir
							File file = File.createTempFile("resource", "001",
									tempDefaultResourceLibraryFilesDir);
							FileOutputStream os = new FileOutputStream(file);
							FileUtils.copyStream(s, os);
							FileUtils.closeStream(os);

							// attach file to resource in resource library
							targetPath = targetPath.replaceAll("\\\\", "/");
							String[] pathParts = targetPath.split("/");

							Directory dir = resourceModelRoot;
							// search resource
							for (int i = 0; i < pathParts.length; i++) {
								FileSystemElement child = dir
										.getChild(pathParts[i]);
								if (child != null) {
									if (i == (pathParts.length - 1)) {
										if (child instanceof com.nokia.tools.variant.resourcelibrary.model.File) {
											com.nokia.tools.variant.resourcelibrary.model.File f = (com.nokia.tools.variant.resourcelibrary.model.File) child;
											f.setDefaultResource(file);
										}
									} else {
										dir = (Directory) child;
									}
								}
							}
						}
					}
				}

				s.close();

			}

			// URIConverter converter = configurationProject.eResource()
			// .getResourceSet().getURIConverter();
			// for (Map.Entry<URI, URI> entry : resourceMap) {
			// File file = new File(rootCpfTempDir, entry.getKey().path());
			// File parent = new File(file.getParent());
			// parent.mkdirs();
			// InputStream is = null;
			// OutputStream os = null;
			// try {
			// if (entry.getValue().path().endsWith("/")) {
			// file.mkdirs();
			// } else {
			// is = converter.createInputStream(entry.getValue());
			// file.createNewFile();
			// os = new FileOutputStream(file);
			// FileUtils.copyStream(is, os);
			// }
			// } catch (Exception ex) {
			// ex.printStackTrace();
			// } finally {
			// FileUtils.closeStream(is);
			// FileUtils.closeStream(os);
			// }
			// }
		}

		long end = System.currentTimeMillis();
		// System.out.println("Load Resource Model:" + (end - start));

		return resourceModelRoot;
	}

	/**
	 * Converts {@code EList<FileSystemElement>} to {@code List<FileSystemElement>} 
	 * 
	 * @param newResources
	 * @param children
	 */
	public static void getAllResourcesAsList(
			List<FileSystemElement> newResources,
			EList<FileSystemElement> children) {
		for (FileSystemElement fileSystemElement : children) {
			if (fileSystemElement instanceof Directory) {
				Directory dir = (Directory) fileSystemElement;
				newResources.add(dir);
				getAllResourcesAsList(newResources, dir.getChildren());
			}
			if (fileSystemElement instanceof com.nokia.tools.variant.resourcelibrary.model.File) {
				com.nokia.tools.variant.resourcelibrary.model.File file = (com.nokia.tools.variant.resourcelibrary.model.File) fileSystemElement;
				newResources.add(file);
			}
		}
	}

	/**
	 * Loads images from {@link EConfMLLayer}
	 * 
	 * @param variantLayer
	 * @return ResourceModelRoot
	 * @throws IOException
	 */
	public static ResourceModelRoot loadProductImages(EConfMLLayer variantLayer)
			throws IOException {
		ResourceSet rs = variantLayer.eResource().getResourceSet();
		URIConverter converter = rs.getURIConverter();

		URI uri = URI.createURI("productimages");
		List<URI> imageURIList = new ArrayList<URI>();

		for (Map.Entry<URI, URI> entry : variantLayer.getDocumentMap()) {
			URI key = entry.getKey();
			if (key.segmentCount() <= uri.segmentCount()) {
				continue;
			}
			boolean match = true;
			for (int i = 0; i < uri.segmentCount(); i++) {
				if (!uri.segment(i).equals(key.segment(i))) {
					match = false;
					break;
				}
			}
			if (match) {
				imageURIList.add(entry.getValue());
			}
		}

		// create temporary resource library location
		ResourceModelRoot resourceModelRoot = resourcesFactory.eINSTANCE
				.createResourceModelRoot();

		File rootCpfTempDir = File.createTempFile("cpf", "_productimages");
		rootCpfTempDir.delete();
		rootCpfTempDir.mkdirs();

		resourceModelRoot.setTempDirPath(rootCpfTempDir.getAbsolutePath());

		for (URI imageURI : imageURIList) {
			String name = imageURI.lastSegment();

			// it's resource so copy it into temporary resource library
			// location
			try {
				File file = new File(rootCpfTempDir, name);
				// File parent = new File(file.getParent());
				// parent.mkdirs();
				file.createNewFile();
				InputStream is = null;
				OutputStream os = null;
				try {
					is = converter.createInputStream(imageURI);
					os = new FileOutputStream(file);
					FileUtils.copyStream(is, os);
				} finally {
					FileUtils.closeStream(is);
					FileUtils.closeStream(os);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		processFiles(resourceModelRoot, rootCpfTempDir);
		return resourceModelRoot;
	}

	/**
	 * Loads {@link ResourceModelRoot} from given {@link EConfMLLayer} and location
	 * 
	 * @param variantLayer
	 * @param text
	 * @return ResourceModelRoot
	 * @throws IOException
	 */
	public static ResourceModelRoot loadDocument(EConfMLLayer variantLayer,
			String text) throws IOException {
		ResourceSet rs = variantLayer.eResource().getResourceSet();
		URIConverter converter = rs.getURIConverter();

		URI uri = URI.createURI(text);
		List<URI> imageURIList = new ArrayList<URI>();

		for (Map.Entry<URI, URI> entry : variantLayer.getDocumentMap()) {
			URI key = entry.getKey();
			if (key.segmentCount() <= uri.segmentCount()) {
				continue;
			}
			boolean match = true;
			for (int i = 0; i < uri.segmentCount(); i++) {
				if (!uri.segment(i).equals(key.segment(i))) {
					match = false;
					break;
				}
			}
			if (match) {
				imageURIList.add(entry.getValue());
			}
		}

		// create temporary resource library location
		ResourceModelRoot resourceModelRoot = resourcesFactory.eINSTANCE
				.createResourceModelRoot();

		File rootCpfTempDir = File.createTempFile("cpf", "_" + text);
		rootCpfTempDir.delete();
		rootCpfTempDir.mkdirs();

		resourceModelRoot.setTempDirPath(rootCpfTempDir.getAbsolutePath());

		for (URI imageURI : imageURIList) {
			String name = imageURI.lastSegment();
			if (name == null || name.equals("")) {
				continue;
			}

			// it's resource so copy it into temporary resource library
			// location
			try {
				File file = new File(rootCpfTempDir, name);
				// File parent = new File(file.getParent());
				// parent.mkdirs();
				file.createNewFile();
				InputStream is = null;
				OutputStream os = null;
				try {
					is = converter.createInputStream(imageURI);
					os = new FileOutputStream(file);
					FileUtils.copyStream(is, os);
				} finally {
					FileUtils.closeStream(is);
					FileUtils.closeStream(os);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		processResourceFiles(resourceModelRoot, rootCpfTempDir, variantLayer);
		return resourceModelRoot;
	}

	/**
	 * Creates File Structure browsing given File
	 * 
	 * @param toDirectory
	 * @param fromDirectory
	 * @param variantLayer
	 */
	private static void processResourceFiles(Directory toDirectory,
			File fromDirectory, EConfMLLayer variantLayer) {
		File[] listFiles = fromDirectory.listFiles();
		for (int i = 0; i < listFiles.length; i++) {
			File file = listFiles[i];
			FileSystemElement f;
			if (file.isDirectory()) {
				f = resourcesFactory.eINSTANCE.createDirectory();
				processResourceFiles((Directory) f, file, variantLayer);
			} else {
				f = resourcesFactory.eINSTANCE.createFile();

				((com.nokia.tools.variant.resourcelibrary.model.File) f)
						.setSize(file.length());
			}
			f.setName(file.getName());
			if (toDirectory instanceof ResourceModelRoot
					&& f instanceof Directory) {
				// f.setReadOnly(true);
			}
			toDirectory.getChildren().add(f);
		}
	}

	/**
	 * Creates File Structure browsing given File
	 * 
	 * @param toDirectory
	 * @param fromDirectory
	 */
	private static void processFiles(Directory toDirectory, File fromDirectory) {
		File[] listFiles = fromDirectory.listFiles();
		for (int i = 0; i < listFiles.length; i++) {
			File file = listFiles[i];
			FileSystemElement f;
			if (file.isDirectory()) {
				f = resourcesFactory.eINSTANCE.createDirectory();
				processFiles((Directory) f, file);
			} else {
				f = resourcesFactory.eINSTANCE.createFile();

				((com.nokia.tools.variant.resourcelibrary.model.File) f)
						.setSize(file.length());
			}
			f.setName(file.getName());
			if (toDirectory instanceof ResourceModelRoot
					&& f instanceof Directory) {
				// f.setReadOnly(true);
			}
			toDirectory.getChildren().add(f);
		}
	}
	/**
	 * Recursively browse given File and creates File Structure with access rights
	 * 
	 * @param toDirectory
	 * @param fromDirectory
	 * @param resourceMap
	 * @param lastLayer
	 */	
	private static void processResourceLibrary(
			EConfigurationProject configurationProject, Directory toDirectory,
			File fromDirectory, EMap<URI, URI> resourceMap,
			EConfMLLayer lastLayer) {
		File[] listFiles = fromDirectory.listFiles();
		for (int i = 0; i < listFiles.length; i++) {
			File file = listFiles[i];
			FileSystemElement f;
			if (file.isDirectory()) {
				f = resourcesFactory.eINSTANCE.createDirectory();
				f.setName(file.getName());
				toDirectory.getChildren().add(f);

				processResourceLibrary(configurationProject, (Directory) f,
						file, resourceMap, lastLayer);
			} else {
				if (file.getName().endsWith(".tpf")) {
					f = resourcesFactory.eINSTANCE.createThemeFile();
					ThemeValidator validator = new ThemeValidator(
							configurationProject, file.getPath());
					ValidationResult validate = validator.validate();
					if (!validate.getResult().contains(EResult.VALID)) {
						((ThemeFile) f).setValidationMessage(validate
								.getMessage());
					}
				} else {
					f = resourcesFactory.eINSTANCE.createFile();
				}
				f.setName(file.getName());
				toDirectory.getChildren().add(f);

				String path = f.getPath();
				path = path.replace('\\', '/');
				URI uri = resourceMap.get(URI.createURI(path));
				if (uri.path().startsWith(lastLayer.getLayerURI().path())) {
					f.setReadOnly(false);
				} else {
					f.setReadOnly(true);
				}

				((com.nokia.tools.variant.resourcelibrary.model.File) f)
						.setSize(file.length());
			}

			EList<FileSystemElement> children = toDirectory.getChildren();
			boolean readOnly = false;
			for (FileSystemElement fse : children) {
				if (fse.isReadOnly()) {
					readOnly = true;
					break;
				}
			}
			toDirectory.setReadOnly(readOnly);

			if (toDirectory instanceof ResourceModelRoot
					&& f instanceof Directory) {
				// f.setReadOnly(true);
			}
		}
	}

	/**
	 * Loads Notes into Properties
	 * 
	 * @param configurationProject
	 * @param view
	 * @throws InvalidPropertiesFormatException
	 * @throws IOException
	 */
	public static void loadNotes(EConfigurationProject configurationProject,
			View view) throws InvalidPropertiesFormatException, IOException {
		if (configurationProject.getLastLayer() != null) {
			URIConverter converter = configurationProject.eResource()
					.getResourceSet().getURIConverter();

			EConfMLLayer variantLayer = configurationProject.getLastLayer();

			URI uri = URI.createURI(".notes");
			uri = variantLayer.getDocumentMap().get(uri);
			if (uri == null) {
				return;
			}

			InputStream is = null;
			Properties p = new Properties();

			try {
				is = converter.createInputStream(uri);
				p.load(is);
			} catch (IOException ex) {
				return;
			} finally {
				FileUtils.closeStream(is);
			}

			EList<Setting> sharedSettingInstances = view
					.getSharedSettingInstances();
			for (int i = 0; i < sharedSettingInstances.size(); i++) {
				Setting setting = sharedSettingInstances.get(i);
				String absRef = setting.getAbsRef();
				Object n = p.get(absRef);

				if (n instanceof String) {
					String note = (String) n;
					setting.setNote(note);
				}
			}
		}
	}

	/**
	 * Loads concrete summary Icon 
	 * 
	 * @return Icon
	 */
	public static Icon loadSummaryIcon() {
		URI uri = URI.createURI("summaryIcon.png");

		Icon summaryIcon = ConfmlFactory.eINSTANCE.createIcon();
		summaryIcon.setFilePath(uri.toString());
		summaryIcon.setTitle("Summary");
		return summaryIcon;
	}


	/**
	 * Loads AVR ( Additional Variation Requests ) from given {@link EConfigurationProject}
	 * 
	 * @param configurationProject
	 * @return String
	 * @throws InvalidPropertiesFormatException
	 * @throws IOException
	 */
	public static String loadAvr(EConfigurationProject configurationProject)
			throws InvalidPropertiesFormatException, IOException {
		String loadText = null;
		if (configurationProject.getLastLayer() != null) {
			URIConverter converter = configurationProject.eResource()
					.getResourceSet().getURIConverter();

			EConfMLLayer variantLayer = configurationProject.getLastLayer();

			URI uri = URI.createURI("avr.txt");
			uri = variantLayer.getDocumentMap().get(uri);
			if (uri == null) {
				return loadText;
			}

			InputStream is = null;
			BufferedReader bufferedReader = null;
			InputStreamReader inputStreamReader = null;

			try {
				is = converter.createInputStream(uri);
				inputStreamReader = new InputStreamReader(is);
				bufferedReader = new BufferedReader(inputStreamReader);

				StringBuffer sb = new StringBuffer();
				String line = null;
				while ((line = bufferedReader.readLine()) != null) {
					sb.append(line);
					sb.append("\r\n");
				}

				loadText = new String(sb);

			} catch (IOException ex) {
				return loadText;
			} finally {
				FileUtils.closeStream(is);
				if (inputStreamReader != null)
					inputStreamReader.close();
				if (bufferedReader != null)
					bufferedReader.close();
			}
		}
		return loadText;
	}

	/**
	 * 
	 * @param configurationProject
	 * @throws InvalidPropertiesFormatException
	 * @throws IOException
	 */
	public static CPFInformation loadCPFInformations(
			EConfigurationProject configurationProject)
			throws InvalidPropertiesFormatException, IOException {

		CPFInformation cpfInformation = CpfInfoFactory.eINSTANCE
				.createCPFInformation();

		if (configurationProject.getLastLayer() != null) {
			URI rootConfmlURI = configurationProject.getRootConfml();

		}
		return cpfInformation;
	}

	/**
	 * Sets the Info Property
	 * 
	 * @param properties
	 * @return CPFInformation
	 */
	private static CPFInformation loadInfo(Properties properties) {
		CPFInformation cpfInformation = CpfInfoFactory.eINSTANCE
				.createCPFInformation();

		cpfInformation.setName(properties.getProperty("cpf.name"));
		cpfInformation
				.setDescription(properties.getProperty("cpf.description"));

		cpfInformation.setViewId(properties.getProperty("cpf.viewId"));
		// cpfInformation.setDataOverrideFile(properties.getProperty(
		// "cpf.dataFile"));

		cpfInformation.setAuthor(properties.getProperty("cpf.author"));
		cpfInformation.setVersion(properties.getProperty("cpf.version"));

		cpfInformation.setProduct(properties.getProperty("cpf.product"));
		cpfInformation.setCustomer(properties.getProperty("cpf.customer"));

		cpfInformation.setPlatform(properties.getProperty("cpf.platform"));
		cpfInformation.setRelease(properties.getProperty("cpf.release"));

		cpfInformation.setDate(properties.getProperty("cpf.date"));
		cpfInformation.setOwner(properties.getProperty("cpf.owner"));

		return cpfInformation;
	}

	/**
	 * 
	 * @param configurationProject
	 * @param resourceModelRoot
	 * @throws InvalidPropertiesFormatException
	 * @throws IOException
	 */
	public static void loadRLNotes(EConfigurationProject configurationProject,
			ResourceModelRoot resourceModelRoot)
			throws InvalidPropertiesFormatException, IOException {

		if (configurationProject.getLastLayer() != null) {

			URIConverter converter = configurationProject.eResource()
					.getResourceSet().getURIConverter();

			EConfMLLayer variantLayer = configurationProject.getLastLayer();

			URI uri = variantLayer.getLayerURI();

			uri = URI.createURI(uri.toString() + "doc/.rl-notes");

			if (uri == null) {
				return;
			}

			InputStream is = null;
			Properties p = new Properties();

			try {
				is = converter.createInputStream(uri);
				p.load(is);
			} catch (IOException ex) {
				return;
			} finally {
				FileUtils.closeStream(is);
			}

			EList<FileSystemElement> children = resourceModelRoot.getChildren();
			for (int i = 0; i < children.size(); i++) {
				addNotes2RLModel(p, children.get(i));
			}
		}
	}

	/**
	 * @param p
	 * @param fileSystemElement
	 */
	private static void addNotes2RLModel(Properties p,
			FileSystemElement fileSystemElement) {

		if (fileSystemElement instanceof Directory) {
			Directory directory = (Directory) fileSystemElement;

			EList<FileSystemElement> children = directory.getChildren();

			for (int i = 0; i < children.size(); i++) {
				addNotes2RLModel(p, children.get(i));
			}
		}

		String absRef = fileSystemElement.getPath();
		String n = p.getProperty(absRef, "");

		if (n instanceof String) {
			String note = (String) n;
			fileSystemElement.setNote(note);
		}
	}

	/**
	 * Save Notes Properties
	 * 
	 * @param view
	 * @param notesFile
	 */
	public static void saveNotes(View view, OutputStream notesFile) {
		Properties p = new Properties();
		EList<Setting> sharedSettingInstances = view
				.getSharedSettingInstances();
		for (int i = 0; i < sharedSettingInstances.size(); i++) {
			Setting setting = sharedSettingInstances.get(i);
			String absRef = setting.getAbsRef();
			String note = setting.getNote();
			if (note != null) {
				p.setProperty(absRef, note);
			}
		}
		try {
			p.store(notesFile, "");
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			try {
				notesFile.flush();
			} catch (IOException e) {

				e.printStackTrace();
			}
			try {
				notesFile.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}

	/**
	 * Save AVR ( Additional Variation Requests ) Properties 
	 * 
	 * @param text
	 * @param os
	 */
	public static void saveAvr(String text, OutputStream os) {
		OutputStreamWriter outputStreamWriter = null;
		try {

			outputStreamWriter = new OutputStreamWriter(os);
			// BufferedWriter bufferedWriter = new
			// BufferedWriter(outputStreamWriter);
			outputStreamWriter.write(text);
			outputStreamWriter.flush();
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			try {
				os.flush();

			} catch (IOException e) {

				e.printStackTrace();
			}
			try {
				os.close();
				if (outputStreamWriter != null)
					outputStreamWriter.close();

			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * @param configurationProject
	 * @param resourceModelRoot
	 * @throws InvalidPropertiesFormatException
	 * @throws IOException
	 */
	public static History loadHistory(EConfigurationProject configurationProject)
			throws InvalidPropertiesFormatException, IOException {

		if (configurationProject.getLastLayer() != null) {

			URIConverter converter = configurationProject.eResource()
					.getResourceSet().getURIConverter();

			EConfMLLayer variantLayer = configurationProject.getLastLayer();

			URI uri = URI.createURI(".history");

			uri = variantLayer.getDocumentMap().get(uri);
			if (uri == null) {
				return SummaryModelFactory.eINSTANCE.createHistory();
			}

			InputStream is = null;
			Properties p = new Properties();

			try {
				is = converter.createInputStream(uri);
				p.load(is);
			} catch (IOException ex) {
				SummaryModelFactory.eINSTANCE.createHistory();
			} finally {
				FileUtils.closeStream(is);
			}

			History history = SummaryModelFactory.eINSTANCE.createHistory();

			// Iterator<Object> iterator = p.values().iterator();
			boolean newNote = true;
			Note note = null;
			int i = 0;
			while (newNote) {
				String date = p.getProperty("Date" + i);
				String content = p.getProperty("Content" + i);
				if (date != null) {
					note = SummaryModelFactory.eINSTANCE.createNote();
					note.setDate(date);
					note.setContent(content);
					history.getNote().add(note);
				} else {
					newNote = false;
				}
				i++;
			}

			// while (iterator.hasNext()) {
			// String property = (String) iterator.next();
			// if (newNote) {
			// note = SummaryModelFactory.eINSTANCE.createNote();
			// note.setDate(property);
			// newNote = false;
			// } else {
			// note.setContent(property);
			// history.getNote().add(note);
			// newNote = true;
			// }
			//
			// // note.setDate(property.g)
			//
			// // history.getNote().add(note);
			// }

			return history;
		}
		return SummaryModelFactory.eINSTANCE.createHistory();
	}

	/**
	 * Save History Properties 
	 * 
	 * @param history
	 * @param notesFile
	 */
	public static void saveHistory(History history, OutputStream notesFile) {
		Properties p = new Properties();

		EList<Note> note2 = history.getNote();

		for (int i = 0; i < note2.size(); i++) {

			Note note = note2.get(i);

			p.setProperty("Date" + i, note.getDate());
			p.setProperty("Content" + i, note.getContent());

		}
		try {
			p.store(notesFile, "");
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			try {
				notesFile.flush();
			} catch (IOException e) {

				e.printStackTrace();
			}
			try {
				notesFile.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * @param resourceModelRoot
	 * @param baos3
	 */
	public static void saveResourceLibraryNotes(
			ResourceModelRoot resourceModelRoot,
			ByteArrayOutputStream rlNotesFile) {

		Properties p = new Properties();

		EList<FileSystemElement> children = resourceModelRoot.getChildren();

		for (int i = 0; i < children.size(); i++) {
			FileSystemElement fileSystemElement = children.get(i);

			addNote2PropertyMap(p, fileSystemElement);
		}
		try {
			p.store(rlNotesFile, "");
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			try {
				rlNotesFile.flush();
			} catch (IOException e) {

				e.printStackTrace();
			}
			try {
				rlNotesFile.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}

	/**
	 * @param p
	 * @param fileSystemElement
	 */
	private static void addNote2PropertyMap(Properties p,
			FileSystemElement fileSystemElement) {

		if (fileSystemElement instanceof Directory) {
			Directory directory = (Directory) fileSystemElement;
			EList<FileSystemElement> children = directory.getChildren();

			for (int i = 0; i < children.size(); i++) {
				FileSystemElement childFileSystemElement = children.get(i);

				addNote2PropertyMap(p, childFileSystemElement);
			}
		}

		String absRef = fileSystemElement.getPath();
		String note = fileSystemElement.getNote();
		if (note != null) {
			p.setProperty(absRef, note);
		}
	}

	public static IEditorInput createInput(String filePath) {
		URI uri = URI.createFileURI(filePath);

		URIEditorInput editorInput = new FileEditorInput(uri);
		/*
		 * new IFileEditorInput() {
		 * 
		 * public IFile getFile() { return null;
		 * 
		 * }
		 * 
		 * public IStorage getStorage() throws CoreException {
		 * 
		 * return new IStorage() {
		 * 
		 * public InputStream getContents() throws CoreException {
		 * 
		 * return null; }
		 * 
		 * public IPath getFullPath() {
		 * 
		 * return new Path(filePath); }
		 * 
		 * public String getName() {
		 * 
		 * return null; }
		 * 
		 * public boolean isReadOnly() {
		 * 
		 * return false; }
		 * 
		 * @SuppressWarnings("unchecked") public Object getAdapter(Class
		 * adapter) {
		 * 
		 * return null; }
		 * 
		 * }; }
		 * 
		 * public boolean exists() {
		 * 
		 * return false; }
		 * 
		 * public ImageDescriptor getImageDescriptor() {
		 * 
		 * return null; }
		 * 
		 * public String getName() {
		 * 
		 * return filePath; }
		 * 
		 * public IPersistableElement getPersistable() {
		 * 
		 * return null; }
		 * 
		 * public String getToolTipText() {
		 * 
		 * return filePath; }
		 * 
		 * @SuppressWarnings("unchecked") public Object getAdapter(Class
		 * adapter) {
		 * 
		 * return null; }
		 * 
		 * };
		 */

		return editorInput;

	}

	/**
	 * Creates {@link ViewEditorModel} from given URI and location 
	 * 
	 * @param input
	 * @param rootConfMLPath
	 * @return ViewEditorModel
	 */
	public static ViewEditorModel createModel(URI input, String rootConfMLPath) {
		// this should be validation - if critical error return null
		OpenCPFErrors.clear();
		try {
			// can be input null and no exception?
			ResourceSet resourceSet = CPFUtil.createCPFResourceSet(input);
			// can be resourceSet null and no exception?

			List<URI> resources = enumerateCPFResources(input);

			// String dataOverrideFile = cpfMetadata.getDataOverrideFile();
			// if (dataOverrideFile == null) {
			// // it is resolved as cpf://<layer URI>/confml/data.confml
			// dataOverrideFile = "confml/data.confml";
			// }

			// map for collecting of an information about view name 2 Resource
			// in which is that view located
			Map<String, Resource> viewName2ResourceMapForAllLayers = new LinkedHashMap<String, Resource>();

			EConfigurationProject configurationProject = loadConfigurationProject(
					input, resourceSet, resources,
					viewName2ResourceMapForAllLayers, rootConfMLPath);

			// test
			try {
				AuditLogger accessLogger = new AuditLoggerImpl();
				// set ENABLE_IMPLML_CONVERSION = true; for testing purposes
				final boolean ENABLE_IMPLML_CONVERSION = false;

				if (ENABLE_IMPLML_CONVERSION) {
					JavaScriptImplmlFilesEvaluator.evaluateJavaScripts(
							configurationProject, accessLogger);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (!validateEConfigurationProject(configurationProject)) {
				return null;
			}
			configurationProject.setStorage(CPFUtil.detectStorageClass(input));

			File tempDefaultResourceLibraryFilesDir = File.createTempFile(
					"defaultResources", "");
			tempDefaultResourceLibraryFilesDir.delete();
			tempDefaultResourceLibraryFilesDir.mkdirs();

			ResourceModelRoot resourceModelRoot = CPFManager.loadResourceModel(
					input, configurationProject,
					tempDefaultResourceLibraryFilesDir);

			// Load rl notes
			loadRLNotes(configurationProject, resourceModelRoot);

			View view = CPFManager.createView(configurationProject);
			if (!validateView(view)) {
				return null;
			}

			// Is in CPFEditor
			// resourceModelRoot.eAdapters().add(new EContentAdapter() {
			// @Override
			// public void notifyChanged(Notification notification) {
			// super.notifyChanged(notification);
			//					
			// Object notifier = notification.getNotifier();
			// if (notifier instanceof FileSystemElement) {
			// // revalidate all settings in model
			// //EList<Setting> allSettings = view.getSharedSettingInstances();
			// // for (int i = 0; i < allSettings.size(); i++) {
			// //
			// // }
			// FileSystemElement element = (FileSystemElement)notifier;
			// EList<Setting> settings = element.getSettings();
			// if(settings!=null&&settings.size()>0){
			// for (Setting setting : settings) {
			// handleErrors(setting);
			// }
			// }
			// }
			//					
			// }
			// });

			Resource viewResource = null;
			// get view Resource's root element
			EMap<String, EAppView> views = configurationProject.getLastLayer()
					.getViews();
			for (Entry<?, ?> entry : views) {
				EAppView value = (EAppView) entry.getValue();
				if (value.getName().equals(
						configurationProject.getDefaultView().getName())) {

					EList<URI> uri = value.getUri();
					URI uri2 = uri.get(0);
					uri2 = URI.createURI(uri2.toString().substring(0,
							uri2.toString().indexOf("#")));
					viewResource = resourceSet.getResource(uri2, true);
				}

			}
			// Resource viewResource =
			// viewName2ResourceMapForAllLayers.get(configurationProject
			// .getViewId());
			ViewModel2ConfMLPersistenceModelConvertor viewResourceConvertor = ViewModel2ConfMLPersistenceModelConvertorFactory
					.getConvertor(viewResource);

			CPFManager.loadNotes(configurationProject, view);
			// I need this connection again
			addSettingsToResourceModel(view, resourceModelRoot);
			ViewEditorModel viewEditorModel = new ViewEditorModel();

			viewEditorModel
					.setTempDefaultResourceLibraryFilesDir(tempDefaultResourceLibraryFilesDir);

			History history = loadHistory(configurationProject);

			viewEditorModel.setViewConvertor(viewResourceConvertor);

			ResourceModelRoot loadProductImages = loadDocument(
					configurationProject.getLastLayer(), "productimages");
			ResourceModelRoot guidelinesRoot = loadDocument(
					configurationProject.getLastLayer(), "guidelines");
			String loadAvr = CPFManager.loadAvr(configurationProject);
			viewEditorModel.setAvrProperty(loadAvr);

			viewEditorModel.setView(view);
			viewEditorModel.setConfmlPath(configurationProject.getLastLayer()
					.getLayerURI().toString().concat("/confml"));
			if (input.isFile()) {
				viewEditorModel.setCpfFilePath(input.toFileString());
			} else {
				viewEditorModel.setCpfFilePath("");
			}

			viewEditorModel.setVariantContributor(configurationProject);
			viewEditorModel.setResourceModelRoot(resourceModelRoot);
			viewEditorModel.setGuidelinesRoot(guidelinesRoot);
			viewEditorModel.setProductImagesRoot(loadProductImages);

			URI rootConfmlURI = configurationProject.getRootConfml();
			Resource rootConfMLResource = configurationProject.eResource()
					.getResourceSet().getResource(rootConfmlURI, true);
			CPFInformationConvertor cpfInformationConvertor = CPFInformationConvertorFactory
					.getCPFInformationConvertor(rootConfMLResource);
			CPFInformation cpfMetadata = cpfInformationConvertor
					.loadCPFInformationFromResource(rootConfMLResource);
			viewEditorModel.setCpfInformationConvertor(cpfInformationConvertor);

			viewEditorModel.setCpfMetadata(cpfMetadata);
			viewEditorModel.setHistory(history);

			for (Resource resource : resourceSet.getResources()) {
				resource.setModified(false);
				resource.setTrackingModification(true);
			}

			// URI rootConfmlURI = configurationProject.getRootConfml();
			// Resource rootConfMLResource =
			// configurationProject.eResource().getResourceSet
			// ().getResource(rootConfmlURI, true);

			EAppIncludeElement lastInclude = ArrayUtils
					.getLast(configurationProject.getLastLayer().getIncludes());
			URI lastFile = lastInclude.getTarget();

			cpfMetadata.setDataFile(lastFile.path().substring(1));

			return viewEditorModel;

		} catch (Exception e) {
			OpenCPFErrors.setFatalError("File input error: " + e.getMessage());
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 
	 * @param view
	 * @return true if validation is ok
	 */
	private static boolean validateView(View view) {
		if (view == null) {
			OpenCPFErrors
					.setFatalError("CPF opening failed: Referenced View does not exist.");
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param configurationProject
	 * @return true if validation is ok
	 */
	private static boolean validateEConfigurationProject(
			EConfigurationProject configurationProject) {
		if (configurationProject == null) {
			OpenCPFErrors
					.setFatalError("CPF opening failed: Configuration project is not found.");
			return false;
		}
		EConfMLLayer lastLayer = configurationProject.getLastLayer();
		if (lastLayer == null) {
			OpenCPFErrors.setFatalError("CPF opening failed: No Layers found.");
			return false;
		}
		EMap<String, EAppView> views = configurationProject.getLastLayer()
				.getViews();
		if (views == null) {
			OpenCPFErrors
					.setFatalError("CPF opening failed: View is not found in this Configuration project.");
			return false;
		}
		// o=configurationProject.getLastLayer().getResourceMap();
		return true;
	}

	/**
	 * 
	 * @param cpfMetadata
	 * @param resources
	 * @return true if validation is ok
	 */
	private static boolean validateECPFMetadata(ECPFMetadata cpfMetadata) {
		if (cpfMetadata == null) {
			OpenCPFErrors
					.setFatalError("CPF opening failed: Main metadata does not exist.");
			return false;
		}
		// this is not critical (can be set later to default)
		// if(cpfMetadata.getCpfRootFile()==null){
		// OpenCPFErrors.setFatalError(
		// "Cpf root file is not set in main metadata.");
		// return false;
		// }
		return true;
	}

	/**
	 * Gets URI's list from zip file
	 * 
	 * @param input
	 * @return List<URI>
	 * @throws IOException
	 */
	public static List<URI> enumerateCPFResources(URI input) throws IOException {
		List<URI> resources = new ArrayList<URI>();
		{
			ZipInputStream zis = null;
			try {
				zis = CPFUtil.openCPFStream(input);
				for (ZipEntry zipEntry; (zipEntry = zis.getNextEntry()) != null;) {
					resources.add(URI.createURI(zipEntry.getName()).resolve(
							CPFUtil.CPF_BASE_URI));
					zis.closeEntry();
				}
			} finally {
				zis.close();
			}
		}
		return resources;
	}

	/**
	 * Loads {@link EConfigurationProject} from given input (zip)
	 * 
	 * @param input
	 * @param resourceSet
	 * @param resources
	 * @param viewName2ResourceMapForAllLayers
	 * @param rootConfMLPath
	 * @return EConfigurationProject
	 * @throws IOException
	 */
	public static EConfigurationProject loadConfigurationProject(URI input,
			ResourceSet resourceSet, List<URI> resources,
			Map<String, Resource> viewName2ResourceMapForAllLayers,
			String rootConfMLPath) throws IOException {

		long start = System.currentTimeMillis();

		ZipInputStream stream = CPFUtil.openCPFStream(input);
		for (ZipEntry entry = stream.getNextEntry(); entry != null; stream
				.closeEntry(), entry = stream.getNextEntry()) {
			URI entryURI = URI.createURI(entry.getName()).resolve(
					CPFUtil.CPF_BASE_URI);

			if (!entry.isDirectory() && entry.getName().endsWith(".confml")) {
				Resource resource = resourceSet.createResource(entryURI);
				resource.load(new FilterInputStream(stream) {
					@Override
					public void close() throws IOException {
					}
				}, null);
				resourceSet.getResources().add(resource);
			}
		}

		stream.close();

		EConfigurationProject configurationProject = EApplicationFactory.eINSTANCE
				.createEConfigurationProject();
		Resource projectResource = new ResourceImpl(CPFUtil.CPF_BASE_URI);
		projectResource.getContents().add(configurationProject);
		resourceSet.getResources().add(projectResource);

		List<URI> filterRootConfMLResources = filterRootConfMLResources(resources);

		String rootFileName = null;
		// if (cpfMetadata != null) {
		// rootFileName = cpfMetadata.getCpfRootFile();
		// viewId = cpfMetadata.getViewId();
		// }
		// if (rootFileName == null) {
		// rootFileName = "root.confml";
		// }

		// URI uri = URI.createURI(rootFileName).resolve(CPFUtil.CPF_BASE_URI);
		URI rootConfMLURI = null;

		if (rootConfMLPath != null && !rootConfMLPath.equals("")) {
			rootConfMLURI = URI.createURI(rootConfMLPath).resolve(
					CPFUtil.CPF_BASE_URI);

		} else if (filterRootConfMLResources.size() > 0) {
			rootConfMLURI = filterRootConfMLResources.get(0);
		}

		configurationProject.setRootConfml(rootConfMLURI);

		try {

			Resource resource = resourceSet.getResource(rootConfMLURI, true);
			if (resource != null) {
				AppModelFactory factory = new AppModelFactory();

				EObject object = resource.getContents().get(0);
				if (object instanceof EConfMLDocument) {
					EConfMLDocument document = (EConfMLDocument) object;
					EConfigurationElement configuration = document
							.getConfiguration();
					configurationProject.setName(configuration.getName());
					configurationProject.setConfVersion(configuration
							.getVersion());
					ContributorUtils.adaptMetadata(configuration,
							configurationProject);

					EConfMLLayer lastLayer = null;
					for (EInclude include : configuration.getIncludes()) {
						try {
							URI includeURI = URI.createURI(include.getHref());
							includeURI = includeURI.resolve(rootConfMLURI);
							URI layerURI = discoverLayerUri(includeURI,
									resources);
							EConfMLLayer layer = factory.populateConfMLLayer(
									resourceSet, layerURI, includeURI,
									resources, lastLayer,
									viewName2ResourceMapForAllLayers);
							configurationProject.getLayers().add(layer);
							lastLayer = layer;
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
				} else if (object instanceof EConfML2Document) {
					EConfML2Document document = (EConfML2Document) object;
					com.nokia.tools.vct.confml.model.confml2.EConfigurationElement configuration = document
							.getConfiguration();
					configurationProject.setName(configuration.getName());
					configurationProject.setConfVersion(configuration
							.getVersion());
					ContributorUtils.adaptMetadata(configuration,
							configurationProject);

					EConfMLLayer lastLayer = null;
					for (EInclude include : configuration.getIncludes()) {
						try {
							URI includeURI = URI.createURI(include.getHref());
							includeURI = includeURI.resolve(rootConfMLURI);
							URI layerURI = discoverLayerUri(includeURI,
									resources);
							EConfMLLayer layer = factory.populateConfMLLayer(
									resourceSet, layerURI, includeURI,
									resources, lastLayer,
									viewName2ResourceMapForAllLayers);
							configurationProject.getLayers().add(layer);
							lastLayer = layer;
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
				}
			}
		} catch (Exception ex) {
			if (ex.getCause() instanceof FileNotFoundException) {
				OpenCPFErrors
						.setFatalError("CPF opening failed: configuration root file ("
								+ rootFileName + ") does not exist.");
				return null;
			} else {
				ex.printStackTrace();
			}
		}

		EConfMLLayer confMLLayer = configurationProject.getLastLayer();
		// URI layerURI = confMLLayer.getLayerURI();
		// URI dataOverrideURI =
		// URI.createURI(dataOverrideFile).resolve(layerURI);

		EList<EConfMLLayer> layers = configurationProject.getLayers();
		for (EConfMLLayer confMLLayer1 : layers) {
			EMap<String, EAppFeature> features = confMLLayer1.getFeatures();
			Set<String> keySet = features.keySet();
			Iterator<String> iterator = keySet.iterator();
			while (iterator.hasNext()) {
				String featureRef = iterator.next();
				EAppFeature f = features.get(featureRef);
				EMap<String, EAppSetting> settings = f.getSettings();
				Set<String> sset = settings.keySet();
				sset.iterator();
			}
		}

		long end = System.currentTimeMillis();
		// System.out.println("Load Application Model: " + (end - start));

		return configurationProject;
	}

	/**
	 * 
	 * @param resources
	 *            list of URI of root confml files (files like:
	 *            cpf:///root.confml)
	 * @return
	 */
	private static List<URI> filterRootConfMLResources(List<URI> resources) {
		List<URI> rootConfMLResources = new ArrayList<URI>();

		for (URI uri : resources) {
			if (uri.segmentCount() == 1 && "confml".equals(uri.fileExtension())) {
				rootConfMLResources.add(uri);
			}
		}
		return rootConfMLResources;
	}

	private static URI relativize(URI parentURI, URI uri) {
		int i = parentURI.segmentCount();
		List<String> segments = uri.segmentsList();
		List<String> trim = segments.subList(i, segments.size());
		URI relative = EMPTY_URI.appendSegments(ArrayUtils.createCopy(
				String.class, trim));
		return relative;
	}

	static final URI EMPTY_URI = URI.createURI("");

	private static URI discoverLayerUri(URI includeURI, List<URI> resources) {
		OUTER: for (URI ptr : resources) {
			if (ptr.segmentCount() > includeURI.segmentCount()) {
				for (int i = 0; i < includeURI.segmentCount() - 1; i++) {
					if (!ptr.segment(i).equals(includeURI.segment(i))) {
						continue OUTER;
					}
				}
				if ("confml".equals(ptr.segment(includeURI.segmentCount() - 1))) {
					return includeURI.trimSegments(1).appendSegment("");
				}
			}
		}
		int count = includeURI.segmentCount();
		for (int i = count - 1; i > 0; i--) {
			if ("confml".equals(includeURI.segment(i))) {
				return includeURI.trimSegments(count - i).appendSegment("");
			}
		}
		return includeURI.trimSegments(1).appendSegment("");
	}

	/*
	 * enabled
	 * 
	 * Connects ResourceModel elements 2 settings
	 */
	private static void addSettingsToResourceModel(View view,
			ResourceModelRoot root) {
		EList<Setting> sharedSettingInstances = view
				.getSharedSettingInstances();
		for (Setting setting : sharedSettingInstances) {
			if (setting instanceof FileSystemEntrySetting) {
				FileSystemEntrySetting fileSetting = (FileSystemEntrySetting) setting;
				String localPath = fileSetting.getSourceFilePath().getPath();
				FileSystemElement element = ResourceUtil.getFileSystemElement(
						root, localPath);
				if (element != null) {
					element.getSettings().add(setting);
					// if (isIsItFileSettingWithReadOnlyLocalPath(setting)) {
					// element.setReadOnly(true);
					// }
				}
			} else if (setting instanceof SimpleSetting) {
				SimpleSetting ss = (SimpleSetting) setting;
				if (ss.getType() == TYPE.SIMPLE_FILE
						|| ss.getType() == TYPE.SIMPLE_FOLDER) {
					String localPath = ss.getValue();
					FileSystemElement element = ResourceUtil
							.getFileSystemElement(root, localPath);
					if (element != null) {
						element.getSettings().add(setting);
						if (isIsItFileSettingWithReadOnlyLocalPath(setting)) {
							element.setReadOnly(true);
						}
					}
				}
			}
		}
	}

	/**
	 * 
	 * @param s
	 * @return boolean 
	 */
	public static boolean isIsItFileSettingWithReadOnlyLocalPath(Setting s) {
		if (s instanceof SimpleSetting) {
			SimpleSetting ss = (SimpleSetting) s;
			if (ss.getType().ordinal() == TYPE.FILE_VALUE
					|| ss.getType().ordinal() == TYPE.FOLDER_VALUE) {
				return !ss.isVisible();
			}
		} else if (s instanceof FileSystemEntrySetting) {
			FileSystemEntrySetting fses = (FileSystemEntrySetting) s;
			if (!fses.isVisible()) {
				return true;
			} else {
				FilePath sourceFilePath = fses.getSourceFilePath();
				if (!sourceFilePath.isVisible()) {
					return true;
				}
			}
		}
		return false;
	}

	@Deprecated
	public static List<CPFInformation> getCPFConfigurations(String filePath) {
		return getCPFConfigurations(URI.createFileURI(filePath));
	}

	/**
	 * Gets {@code List<CPFInformation>} from ResourceSet 
	 * 
	 * @see {@link #enumerateRootConfigurations(URI, ResourceSet)}
	 * @param uri
	 * @return List<CPFInformation>
	 */
	public static List<CPFInformation> getCPFConfigurations(URI uri) {
		try {
			// can be input null and no exception?
			ResourceSet resourceSet = CPFUtil.createCPFResourceSet(uri);

			// List<CPFInformation> infos = new ArrayList<CPFInformation>();
			// infos.add(o);

			return enumerateRootConfigurations(uri, resourceSet);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Enumerates ResourceSet	 
	 * 
	 * @see {@link #parseConfigurationInfo(Resource) }
	 * @param input
	 * @param resourceSet
	 * @return List<CPFInformation>
	 * @throws IOException
	 */
	private static List<CPFInformation> enumerateRootConfigurations(URI input,
			ResourceSet resourceSet) throws IOException {
		List<CPFInformation> rootConfigurations = new ArrayList<CPFInformation>();
		{
			ZipInputStream zis = null;
			try {
				zis = CPFUtil.openCPFStream(input);
				for (ZipEntry zipEntry; (zipEntry = zis.getNextEntry()) != null;) {
					String name = zipEntry.getName();
					Path p = new Path(name);
					String[] segments = p.segments();

					if (segments.length == 1) {
						if (segments[0].endsWith(".confml")) {
							URI rootConfMLURI = URI.createURI(
									zipEntry.getName()).resolve(
									CPFUtil.CPF_BASE_URI);
							Resource rootConfMLResource = resourceSet
									.getResource(rootConfMLURI, true);
							CPFInformation ci = parseConfigurationInfo(rootConfMLResource);
							ci.setRootConfMLPath(name);
							rootConfigurations.add(ci);
						}
					}
					zis.closeEntry();
				}
			} finally {
				zis.close();
			}
		}
		return rootConfigurations;
	}

	/**
	 * Gets {@link CPFInformation} from {@link Resource}
	 * 
	 * @see {@link ConfML1CPFInformationConvertor}<br>
	 *  {@link ConfML2CPFInformationConvertor }
	 * 
	 * 
	 * @param rootConfMLResource Resource using {@code ConfML1CPFInformationConvertor} or {@code ConfML2CPFInformationConvertor }
	 * @return CPFInformation
	 */
	private static CPFInformation parseConfigurationInfo(
			Resource rootConfMLResource) {
		CPFInformation ci = null;

		if (rootConfMLResource instanceof EConfML1ResourceImpl) {
			EConfML1ResourceImpl root = (EConfML1ResourceImpl) rootConfMLResource;

			EObject contents = root.getContents().get(0);
			if (contents instanceof EConfMLDocument) {
				ConfML1CPFInformationConvertor conv = new ConfML1CPFInformationConvertor();
				ci = conv.loadCPFInformationFromResource(rootConfMLResource);
			} else if (contents instanceof EConfML2Document) {
				ConfML2CPFInformationConvertor conv = new ConfML2CPFInformationConvertor();
				ci = conv.loadCPFInformationFromResource(rootConfMLResource);
			}

		}

		return ci;
	}
}
