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
package com.nokia.tools.variant.editor.actions;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.internal.ActiveEditorAction;
import org.eclipse.ui.internal.WorkbenchImages;

import com.nokia.tools.variant.common.core.utils.FileUtils;
import com.nokia.tools.variant.confml.core.model.application.EConfigurationProject;
import com.nokia.tools.variant.content.confml.FileSystemEntrySetting;
import com.nokia.tools.variant.content.confml.Setting;
import com.nokia.tools.variant.editor.editors.CPFEditor;
import com.nokia.tools.variant.editor.model.convertor.ViewModel2ConfMLPersistenceModelConvertor;
import com.nokia.tools.variant.editor.model.convertor.ViewModel2ConfMLPersistenceModelConvertorFactory;

@SuppressWarnings("restriction")
public class ExportDataAsConfML extends ActiveEditorAction {
	// implements IWorkbenchWindowActionDelegate{
	public static final String TEXT = "Export Data As ConfML";
	private static final String FILESETTINGFOUNDMESSAGE = "Warning: File and Folder type settings can not be saved in the form of a single confml file.";
	private static final String FILESETTINGFOUNDTITLE = "File Or Folder Setting Warning";
	private CPFEditor editor;

	public ExportDataAsConfML(IWorkbenchWindow window) {
		super(TEXT, window);
		setText(TEXT);
		// tooltip
		setToolTipText(TEXT);
		setId("exportdata");
		// now it look like save
		setImageDescriptor(WorkbenchImages
				.getImageDescriptor(ISharedImages.IMG_ETOOL_SAVEALL_EDIT));
		setDisabledImageDescriptor(WorkbenchImages
		// IMG_ETOOL_SAVEALL_EDIT_DISABLED
				.getImageDescriptor(ISharedImages.IMG_ETOOL_SAVEALL_EDIT_DISABLED));
		setActionDefinitionId("com.nokia.tools.variant.editor.actions.ExportDataAsConfML"); //$NON-NLS-1$
		// ((WorkbenchWindow)window).addBackgroundSaveListener(this);
	}

	/**
	 * Happens after click on the action
	 */
	public void run() {
		IEditorPart ed = getActiveEditor();
		if (ed != null && ed instanceof CPFEditor) {
			editor = (CPFEditor) ed;
			EConfigurationProject input = editor.getProject();
			ResourceSet list = input.eResource().getResourceSet();
			URI pathToSave = editor.getSavePath();
			Resource res = list.getResource(pathToSave, true);
			String outputPath = openFileDialog();
			// dialog canceled / ok
			if (outputPath == "" || outputPath == null) {
				return;
			}
			ViewModel2ConfMLPersistenceModelConvertor viewModel2PersistenceModelConvertorForDataFile = ViewModel2ConfMLPersistenceModelConvertorFactory
					.getConvertor(res);
			viewModel2PersistenceModelConvertorForDataFile.copyValues(editor
					.getViewEditorModel().getView(), input, "id", pathToSave);
			save(res, outputPath);
			if (isSomeFileOrFolderSettingChanged(list)) {
				mouseAndNervesDestroyerDialog();
			}
		}
	}

	/**
	 * save data
	 * 
	 * @param res
	 * @param outputPath
	 */
	private void save(Resource res, String outputPath) {
		try {
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			res.save(output, null);
			InputStream in = new ByteArrayInputStream(output.toByteArray());
			OutputStream out = new FileOutputStream(outputPath);
			FileUtils.copyStream(in, out);
			output.close();
			out.close();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open File Dialog
	 * 
	 * @return pathToSave
	 */
	private String openFileDialog() {
		FileDialog dialog = new FileDialog(editor.getSite().getShell(),
				SWT.SAVE);
		dialog.setText(TEXT);
		dialog.setFilterExtensions(new String[] { "*.confml" });
		String editorPath = editor.getViewEditorModel().getCpfFilePath();
		File file = new File(editorPath);
		dialog.setFilterPath(file.getParentFile().getAbsolutePath());
		dialog.setFileName(generateUntitledName());

		String dir = dialog.open();

		if (dir != null) {
			if (dir.endsWith(".confml")) {
				return dir;
			} else {
				dir += ".confml";
				return dir;
			}
		}
		return null;
	}

	/**
	 * Generate name of confml file
	 * 
	 * @return
	 */
	private String generateUntitledName() {
		int number = 1;
		String editorPath = editor.getViewEditorModel().getCpfFilePath();
		File file = new File(editorPath);
		String name = file.getName();
		int idx = name.lastIndexOf('.');
		if (idx > 0) {
			name = name.substring(0, idx);
		}
		String filePath;
		do {
			if (number < 10) {
				filePath = file.getParent() + File.separator + name + "_data_0"
						+ number + ".confml";
			} else {
				filePath = file.getParent() + File.separator + name + "_data_"
						+ number + ".confml";
			}
			file = new File(filePath);
			number++;
		} while (file.exists());
		return filePath;
	}

	/**
	 * Look to model if some file or folder setting is changed.
	 * 
	 * @param list
	 * @return
	 */
	private boolean isSomeFileOrFolderSettingChanged(ResourceSet list) {
		EList<Setting> allSettings = editor.getViewEditorModel().getView()
				.getSharedSettingInstances();
		for (int i = 0; i < allSettings.size(); i++) {
			Setting setting = allSettings.get(i);
			if (!setting.isDefault() && setting.isVisible()) {
				if (setting instanceof FileSystemEntrySetting) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * open warning dialog
	 */
	private void mouseAndNervesDestroyerDialog() {
		MessageDialog.openWarning(Display.getCurrent().getActiveShell(),
				FILESETTINGFOUNDTITLE, FILESETTINGFOUNDMESSAGE);
	}
}
