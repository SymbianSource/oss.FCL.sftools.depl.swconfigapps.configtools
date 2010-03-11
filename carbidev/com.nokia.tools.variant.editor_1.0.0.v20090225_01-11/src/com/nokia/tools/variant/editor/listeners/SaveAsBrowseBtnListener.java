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

package com.nokia.tools.variant.editor.listeners;

import java.io.File;

import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import com.nokia.tools.variant.editor.dialogs.SaveAsDialog;
import com.nokia.tools.variant.editor.editors.CPFEditor;

public class SaveAsBrowseBtnListener implements SelectionListener {

	private SaveAsDialog saveAsDialog;
	private Text projectDir;
	private boolean rewrite = true;
	private File file;
	private String dir;
	private StringBuffer disabledChars = new StringBuffer(">';");
	private Shell shell;
	private MessageBox messageBox;

	/**
	 * @param parent
	 * @param pathText
	 */
	public SaveAsBrowseBtnListener(SaveAsDialog saveAsDialog, Text projectDir) {
		super();
		this.saveAsDialog = saveAsDialog;
		this.projectDir = projectDir;
	}

	// not implemented
	public void widgetDefaultSelected(SelectionEvent e) {
	}

	/**
	 * 
	 */
	public void widgetSelected(SelectionEvent e) {
		shell = saveAsDialog.getShell();
		FileDialog dlg = new FileDialog(shell, SWT.SAVE);
		dlg.setText("Save As");
		dlg.setFilterExtensions(new String[] { "*.cpf" });
		// dlg.setOverwrite(true);

		dir = dlg.open();

		if (dir != null) {
			if (dir.endsWith(".cpf")) {
				projectDir.setText(dir);
			} else {
				dir += ".cpf";
				projectDir.setText(dir);
			}

			// check correct file path spelling ..
			if (!isPathCorrect()) {
				saveAsDialog.getButton(0).setEnabled(false);
				projectDir.setText("");
				return;
			}

			// check for folders ( / )
			if (!checkFolders(dir)) {
				saveAsDialog.getButton(0).setEnabled(false);
				projectDir.setText("");
				return;
			}

			// check file doesn't exist yet
			if (!existCPF(dir)) {
				saveAsDialog.getButton(IDialogConstants.OK_ID).setEnabled(true);
				return;
			}

			// file exists but don't want to rewrite
			if (!wantRewrite()) {
				saveAsDialog.getButton(IDialogConstants.OK_ID)
						.setEnabled(false);
				projectDir.setText("");
				return;
			}

			saveAsDialog.setOverride(true);
			// file exists and is opened - setup save action
			if (wantToSaveIntoOtherOpenedProject(dir)) {
				saveAsDialog.getButton(IDialogConstants.OK_ID)
						.setEnabled(false);
				projectDir.setText("");
				return;
			}
			// dialog canceled / ok
			if (dir == "" || dir == null) {
				saveAsDialog.getButton(IDialogConstants.OK_ID)
						.setEnabled(false);
			} else {
				saveAsDialog.getButton(IDialogConstants.OK_ID).setEnabled(true);
			}
		}
	}

	/**
	 * 
	 * @return
	 */
	private boolean isPathCorrect() {

		for (int i = 0; i < disabledChars.length(); i++) {
			char checkChar = disabledChars.charAt(i);
			if (dir.contains(String.valueOf(checkChar))) {
				SaveAsPathCheckerDialog saveAsMessageDialog = new SaveAsPathCheckerDialog(
						dir, i, checkChar, saveAsDialog.getShell());
				saveAsMessageDialog.open();
				return false;
			}
		}
		return true;
	}

	/**
	 * File exists
	 * 
	 * @param dir
	 * @return
	 */
	public boolean existCPF(String dir) {
		try {
			file = new File(dir);
			if (!file.exists()) {
				saveAsDialog.getButton(0).setFocus();
				return false;
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return true;
	}

	private boolean checkFolders(String dir2) {

		Path path = new Path(dir);

		if (! path.isValidPath(dir2)
				|| (path.lastSegment().length() <= (".cpf".length()))) {
					
			messageBox = new MessageBox(shell, SWT.ICON_WARNING
					| SWT.OK);
			messageBox.setText("Warning");
			messageBox.setMessage("Path is not valid.");
			messageBox.open();
			return false;
		}

		String checkPath = path.getDevice() + "\\";

		String[] segments = path.segments();

		for (int i = 0; i < segments.length - 1; i++) {
			checkPath += segments[i] + "\\";
			File checkFolder = new File(checkPath);
			if (!checkFolder.exists()) {
				if (!createFolder(checkFolder)) {
					return false;
				} else {
					checkFolder.mkdirs();
				}
			}
		}
		return true;
	}

	private boolean createFolder(File checkFolder) {
		messageBox = new MessageBox(shell, SWT.ICON_WARNING
				| SWT.YES | SWT.NO);
		messageBox.setText("Warning");
		messageBox.setMessage("Foder " + checkFolder.getPath()
				+ " does not exist \n\n " + "Create folder ?");

		if (messageBox.open() == SWT.YES) {
			return true;
		}
		return false;
	}

	/**
	 * Want to rewrite existing cpf ?
	 * 
	 * @return
	 */
	private boolean wantRewrite() {

		rewrite = MessageDialog.openQuestion(saveAsDialog.getShell(),
				"Selected File Exists", "Overwrite existing CPF file ?");

		return rewrite;
	}

	/**
	 * Disable save as action into other opened project Allow save as action
	 * into the same project (save)
	 * 
	 * @param page
	 * @return
	 */
	public boolean wantToSaveIntoOtherOpenedProject(final String destPath) {
		final IWorkbenchPage activePage = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage();

		if (activePage != null) {

			IEditorReference[] editorReferences = activePage
					.getEditorReferences();

			for (IEditorReference editorReference : editorReferences) {

				final IEditorPart editor = editorReference.getEditor(false);

				if (editor instanceof CPFEditor) {

					String cpfPath = ((CPFEditor) editor).getFullPath()
							.toString();

					// need to correct path
					cpfPath = new File(cpfPath).getAbsolutePath();

					if (cpfPath.equals(dir)) {

						// shower.done();
						Display.getDefault().asyncExec(new Runnable() {

							public void run() {
								activePage.bringToTop(editor);
								Path path = new Path(destPath);
								String[] segments = path.segments();
								MessageDialog
										.openInformation(
												Display.getDefault()
														.getActiveShell(),
												"One CPF cannot be opened twice",
												"File"
														+ " "
														+ segments[segments.length - 1]
														+ " "
														+ "has already been opened.\n"
														+ "Can not rewrite other opened CPF.");

							}
						});
						return true;
					}
				}
			}
		}
		return false;
	}

	@Deprecated
	public void removeFile() {

		if (!file.delete()) {

			MessageDialog.openError(saveAsDialog.getShell(), "Error",
					"Unable to delete file");
			saveAsDialog.getButton(0).setEnabled(false);
			return;

		} else {

			// checkExistingCPF(dir);
		}

	}

}
