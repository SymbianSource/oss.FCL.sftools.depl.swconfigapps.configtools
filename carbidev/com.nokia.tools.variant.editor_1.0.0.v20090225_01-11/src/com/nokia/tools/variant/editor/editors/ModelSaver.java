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

package com.nokia.tools.variant.editor.editors;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;

import com.nokia.tools.variant.common.core.utils.FileUtils;
import com.nokia.tools.variant.common.ui.utils.ProgressBarShower;
import com.nokia.tools.variant.confml.core.model.application.EConfigurationProject;
import com.nokia.tools.variant.confml.core.model.application.EStorageClass;
import com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata;
import com.nokia.tools.variant.confml.core.operation.CPFUtil;
import com.nokia.tools.variant.content.confml.View;
import com.nokia.tools.variant.editor.cpfInfo.CPFInformation;
import com.nokia.tools.variant.editor.model.convertor.CPFInformationConvertor;
import com.nokia.tools.variant.editor.model.convertor.CPFInformationConvertorFactory;
import com.nokia.tools.variant.editor.model.convertor.UIMetadata2CPFMetadataModelConverter;
import com.nokia.tools.variant.editor.model.convertor.ViewModel2ConfMLPersistenceModelConvertor;
import com.nokia.tools.variant.editor.model.convertor.ViewModel2ConfMLPersistenceModelConvertorFactory;
import com.nokia.tools.variant.editor.model.summaryModel.UISummaryModel;
import com.nokia.tools.variant.editor.utils.CPFManager;
import com.nokia.tools.variant.resourcelibrary.model.FileSystemElement;
import com.nokia.tools.variant.resourcelibrary.model.ResourceModelRoot;

public class ModelSaver {
	/*
	 * call: From CPFEditor.doSave: ModelSaver.Save(project, monitor,
	 * viewEditorInput.getName());
	 */

	/**
	 * This will not working for crypted cpf May be later (when export will
	 * support crypted cpf with metadata)
	 * 
	 * @param input
	 * @param monitor
	 * @param cpfFilePath
	 * @param view
	 * @param viewEditorModel
	 * @param s
	 * @throws Exception
	 */
	public static void save(EConfigurationProject input,
			IProgressMonitor monitor, String cpfFilePath, View view,
			URI dataFilePath, ProgressBarShower s, CPFInformation metadata,
			ViewEditorModel viewEditorModel, UISummaryModel root)
			throws Exception {
		ViewModel2ConfMLPersistenceModelConvertor viewModel2PersistenceModelConvertorForDataFile = ViewModel2ConfMLPersistenceModelConvertorFactory
				.getConvertor(viewEditorModel.getVariantContributor()
						.eResource().getResourceSet().getResource(dataFilePath,
								true));

		viewModel2PersistenceModelConvertorForDataFile.copyValues(view, input,
				"id", dataFilePath);
		if (root != null) {
			UIMetadata2CPFMetadataModelConverter.copyUIMetadata2CpfMetadata(
					root, viewEditorModel);
		}
		URI rootConfmlURI = input.getRootConfml();
		Resource rootConfMLResource = input.eResource().getResourceSet()
				.getResource(rootConfmlURI, true);
		CPFInformationConvertor cpfInformationConvertor = CPFInformationConvertorFactory
				.getCPFInformationConvertor(rootConfMLResource);
		cpfInformationConvertor.copyCPFInformationToResource(
				rootConfMLResource, viewEditorModel.getCpfMetadata());

		String cpfTempOutputFilePath = cpfFilePath + "x";
		saveModel2CPFFile(input, cpfFilePath, cpfTempOutputFilePath, view,
				metadata, viewEditorModel);

		File filex = new File(cpfTempOutputFilePath);
		File file = new File(cpfFilePath);

		file.delete();

		if (filex.renameTo(file)) {
			filex.delete();

		} else {
			throw new Exception("Save failed, file" + " " + cpfFilePath + " "
					+ "is locked");
		}

	}

	private static void saveModel2CPFFile(EConfigurationProject input,
			String cpfInputFilePath, String cpfOutputFilePath, View view,
			CPFInformation metadata, ViewEditorModel viewEditorModel)
			throws Exception {
		URI layerURI = input.getLastLayer().getLayerURI();
		String fileString = layerURI.path();
		fileString = fileString.substring(1);
		fileString = fileString.substring(0, fileString.length() - 1);
		Path p = new Path(fileString);
		String notesName = p.append("/doc/.notes").toString();
		String historyName = p.append("/doc/.history").toString();
		String rlNotesName = p.append("/doc/.rl-notes").toString();
		String avrName = p.append("/doc/avr.txt").toString();

		ResourceSet list = input.eResource().getResourceSet();

		File tempFile = new File(cpfOutputFilePath);
		ZipOutputStream out = CPFUtil.openCPFOutputStream(tempFile, input
				.getStorage() == EStorageClass.SECURE_M0);
		ZipInputStream zis = CPFUtil.openCPFStream(new File(cpfInputFilePath));

		ResourceModelRoot root = viewEditorModel.getResourceModelRoot();
		List<FileSystemElement> resourceLibraryResources = new ArrayList<FileSystemElement>();
		CPFManager.getAllResourcesAsList(resourceLibraryResources, root
				.getChildren());

		String resourceLibraryPath = (layerURI.path() + "content").substring(1);

		for (ZipEntry zipEntry; (zipEntry = zis.getNextEntry()) != null;) {
			String name = zipEntry.getName();

			URI createURI = URI.createURI(name).resolve(CPFUtil.CPF_BASE_URI);

			Resource res = list.getResource(createURI, false);

			if (res != null && res.isModified()) {
				saveResourceIntoZipEntry(out, name, res);
			} else {
				if (name.equals(notesName) || name.endsWith(".metadata")
						|| name.equals(rlNotesName) || name.equals(historyName)
						|| name.equals(avrName)) {
					out.closeEntry();
					continue;
				}

				if (!name.startsWith(resourceLibraryPath)) {// write everything
					// except resource
					// library content
					ZipEntry newEntry = new ZipEntry(name);
					if (zipEntry.getSize() != -1) {
						newEntry.setSize(zipEntry.getSize());
					}
					newEntry.setTime(new Date().getTime());
					out.putNextEntry(newEntry);
					FileUtils.copyStream(zis, out);
					out.closeEntry();
				} else {
					out.closeEntry();
				}
			}
		}

		// write resource library content
		for (int i = 0; i < resourceLibraryResources.size(); i++) {
			FileSystemElement fse = resourceLibraryResources.get(i);
			if (fse.isReadOnly()) {
				if (fse instanceof com.nokia.tools.variant.resourcelibrary.model.File) {
					com.nokia.tools.variant.resourcelibrary.model.File file = (com.nokia.tools.variant.resourcelibrary.model.File) fse;
					File defaultResource = file.getDefaultResource();
					if (defaultResource != null) {
						final File res = new File(file.getFullPath());
						if (FileUtils.compareByContent(res, defaultResource)) {
							continue;
						}
					}
				}
			}
			String path = null;
			File f = new File(fse.getFullPath());
			ZipEntry newEntry = null;
			if (f.isFile() && f.exists()) {
				path = new Path(resourceLibraryPath + File.separator
						+ fse.getPath()).toPortableString();
				FileInputStream in = new FileInputStream(fse.getFullPath());
				newEntry = new ZipEntry(path);
				newEntry.setSize(f.length());
				newEntry.setTime(new Date().getTime());
				out.putNextEntry(newEntry);
				FileUtils.copyStream(in, out);
				in.close();
			} else {
				path = new Path(resourceLibraryPath + File.separator
						+ fse.getPath() + File.separator).toPortableString();
				newEntry = new ZipEntry(path);
				newEntry.setTime(new Date().getTime());
				out.putNextEntry(newEntry);
			}
			out.closeEntry();
		}

		// save notes
		out.putNextEntry(new ZipEntry(notesName));
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		CPFManager.saveNotes(view, baos);
		out.write(baos.toByteArray());
		out.flush();

		// save history
		out.putNextEntry(new ZipEntry(historyName));
		ByteArrayOutputStream baos5 = new ByteArrayOutputStream();
		CPFManager.saveHistory(viewEditorModel.getHistory(), baos5);
		out.write(baos5.toByteArray());
		out.flush();
		baos5.flush();
		baos5.close();

		// save avr information
		if (viewEditorModel.getAvrProperty() != null) {
			out.putNextEntry(new ZipEntry(avrName));
			ByteArrayOutputStream baos6 = new ByteArrayOutputStream();
			CPFManager.saveAvr(viewEditorModel.getAvrProperty(), baos6);
			out.write(baos6.toByteArray());
			out.flush();
			baos6.flush();
			baos6.close();
		}

		// save Resource Library notes
		ResourceModelRoot resourceModelRoot = viewEditorModel
				.getResourceModelRoot();

		if (resourceModelRoot != null) {
			out.putNextEntry(new ZipEntry(rlNotesName));
			ByteArrayOutputStream baos3 = new ByteArrayOutputStream();
			CPFManager.saveResourceLibraryNotes(resourceModelRoot, baos3);
			out.write(baos3.toByteArray());
			baos3.flush();
			baos3.close();
		}

		// close
		baos.flush();
		baos.close();
		out.flush();
		out.close();
		zis.close();
	}

	/**
	 * 
	 * @param project
	 * @param cpfFilePath
	 * @param cpfOutFilePath
	 * @param view
	 * @param metadata
	 * @param viewEditorModel
	 * @throws Exception
	 */
	public static void saveAs(EConfigurationProject project,
			String cpfFilePath, String cpfOutFilePath, View view,
			CPFInformation metadata, ViewEditorModel viewEditorModel)
			throws Exception {
		saveModel2CPFFile(project, cpfFilePath, cpfOutFilePath, view, metadata,
				viewEditorModel);
	}

	private static void saveResourceIntoZipEntry(ZipOutputStream out,
			String name, Resource res) throws IOException {
		ByteArrayOutputStream output = new ByteArrayOutputStream();

		// one from this two will working
		res.save(output, null);
		// ConfMLCore.saveResourceModel(res, output, new
		// SubProgressMonitor(monitor,1));
		InputStream in = new ByteArrayInputStream(output.toByteArray());

		out.putNextEntry(new ZipEntry(name));
		FileUtils.copyStream(in, out);
		// while ((count = in.read(data, 0, 1000)) != -1) {
		// out.write(data, 0, count);
		// }
		// output.flush();
		output.close();
		out.closeEntry();
		in.close();
	}

	public static void save(EConfigurationProject project,
			IProgressMonitor monitor, String cpfFilePath, View view,
			URI savePath, ProgressBarShower s, ECPFMetadata metadata) {
		try {
			save(project, monitor, cpfFilePath, view, savePath, s, metadata);
		} catch (Exception e) {
			s.done();
			StringWriter writer = new StringWriter();
			PrintWriter pw = new PrintWriter(writer);
			pw.println("Save Failed: " + e.getMessage());
			e.printStackTrace(pw);
			pw.flush();
			MessageDialog.openError(Display.getDefault().getActiveShell(),
					"Save failed", writer.toString());
		}

	}

}
