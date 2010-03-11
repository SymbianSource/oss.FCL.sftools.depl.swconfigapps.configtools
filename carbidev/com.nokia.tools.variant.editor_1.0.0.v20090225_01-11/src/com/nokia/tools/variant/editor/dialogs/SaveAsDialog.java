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

package com.nokia.tools.variant.editor.dialogs;

import java.io.File;

import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.nokia.tools.variant.editor.Activator;
import com.nokia.tools.variant.editor.cpfInfo.CPFInformation;
import com.nokia.tools.variant.editor.editors.CPFEditor;
import com.nokia.tools.variant.editor.editors.ViewEditorModel;
import com.nokia.tools.variant.editor.listeners.SaveAsBrowseBtnListener;

/**
 * This dialog is used for entering filename and adding change notes to CPF file
 */
public class SaveAsDialog extends Dialog {

	private CPFEditor editor;

	// private CommandStack stack;
	private ViewEditorModel viewEditorModel;
	private String cpfFilePath, newLocation;
	private CPFInformation cpfMetadata;

	private final int MIN_BUTTON_WIDTH = 50;
	private final int MIN_LABEL_WIDTH = 75;

	private Button browseBtn;
	private Text projectDir;
	private Text commentsText;
	private boolean override = false;

	private String projectDirString;
	private String commentsString;

	// private boolean closeAfterSaveAs;
	// private String destZipFile;
	// private IWorkbenchPage activePage;
	private SaveAsBrowseBtnListener browseBtnListener;

	final String DLG_IMG_MESSAGE_INFO = "dialog_messasge_info_image"; //$NON-NLS-1$

	public String getNewLocation() {
		return newLocation;
	}

	public String getCpfFilePath() {
		return cpfFilePath;
	}

	public CPFInformation getCpfMetadata() {
		return cpfMetadata;
	}

	public String getProjectDir() {
		return projectDirString;
	}

	public String getCommentsText() {
		return commentsString;
	}

	/**
	 * 
	 * @param editor
	 */
	public SaveAsDialog(Shell shell, CPFEditor editor) {
		super(shell);

		setBlockOnOpen(true);

		this.editor = editor;
		this.viewEditorModel = editor.getViewEditorModel();
		this.cpfFilePath = viewEditorModel.getCpfFilePath();
		this.cpfMetadata = viewEditorModel.getCpfMetadata();
	}

	/**
	 * Configures the shell
	 * 
	 * @param shell
	 *            the shell
	 */
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setSize(550, 260);
		shell.setText("Save As");

		ImageDescriptor iconDescriptor = Activator
				.getImageDescriptor("icons/carbide_v_16x16.png");
		shell.setImage(iconDescriptor.createImage());
	}

	/**
	 * Creates the dialog's contents
	 * 
	 * @param shell
	 *            the dialog window
	 */
	protected Control createDialogArea(Composite parent) {
		GridLayout childLayout = new GridLayout(1, true);
		childLayout.marginHeight = 0;
		childLayout.marginWidth = 0;
		childLayout.verticalSpacing = 0;

		Composite workArea = new Composite(parent, SWT.NONE
				| SWT.NO_REDRAW_RESIZE);

		childLayout = new GridLayout(1, true);
		childLayout.marginHeight = 0;
		childLayout.marginWidth = 0;
		childLayout.verticalSpacing = 0;
		workArea.setLayout(childLayout);
		workArea.setLayoutData(new GridData(GridData.FILL_BOTH));

		// ---
		Composite titleComposite = new Composite(workArea, SWT.NO_REDRAW_RESIZE);
		titleComposite.setBackground(Display.getCurrent().getSystemColor(
				SWT.COLOR_WHITE));

		childLayout = new GridLayout(3, false);
		childLayout.marginHeight = 0;
		childLayout.marginWidth = 0;
		childLayout.verticalSpacing = 0;
		titleComposite.setLayout(childLayout);

		Label imgLabel = new Label(titleComposite, SWT.NO);
		imgLabel.setBackground(Display.getCurrent().getSystemColor(
				SWT.COLOR_WHITE));
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
		gridData.widthHint = 20;
		gridData.heightHint = 20;
		gridData.horizontalIndent = 10;
		imgLabel.setLayoutData(gridData);

		imgLabel.setImage(JFaceResources.getImage(DLG_IMG_MESSAGE_INFO));

		Label leftLabel = new Label(titleComposite, SWT.NO);
		leftLabel.setBackground(Display.getCurrent().getSystemColor(
				SWT.COLOR_WHITE));
		gridData = new GridData();
		gridData.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
		gridData.widthHint = 450;
		gridData.heightHint = 55;
		leftLabel.setLayoutData(gridData);

		leftLabel.setText("\n Save your changes as a new CPF.\n"
				+ " You may want to do this for creating "
				+ "a new variant or revision of your current CPF.");

		Label rightLabel = new Label(titleComposite, SWT.NO);
		rightLabel.setBackground(Display.getCurrent().getSystemColor(
				SWT.COLOR_WHITE));
		gridData = new GridData();
		gridData.horizontalAlignment = GridData.HORIZONTAL_ALIGN_END;
		gridData.widthHint = 60;
		gridData.heightHint = 60;
		rightLabel.setLayoutData(gridData);

		ImageDescriptor imageDescriptor = Activator
				.getImageDescriptor("icons/saveas_wiz.png");
		Image image = imageDescriptor.createImage();

		rightLabel.setImage(image);

		// ---
		createControls(workArea);

		// ---
		Composite btnComposite = new Composite(workArea, SWT.NO_REDRAW_RESIZE);

		childLayout = new GridLayout(2, true);
		childLayout.marginHeight = 0;
		childLayout.marginWidth = 0;
		childLayout.verticalSpacing = 0;
		btnComposite.setLayout(childLayout);

		leftLabel = new Label(btnComposite, SWT.NO);
		gridData = new GridData();
		gridData.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
		gridData.widthHint = 330;
		gridData.heightHint = 30;
		leftLabel.setLayoutData(gridData);

		Composite btnGroupComposite = new Composite(btnComposite,
				SWT.NO_REDRAW_RESIZE);

		childLayout = new GridLayout(2, true);
		childLayout.marginHeight = 0;
		childLayout.marginWidth = 0;
		childLayout.verticalSpacing = 0;
		btnGroupComposite.setLayout(childLayout);

		gridData = new GridData();
		gridData.horizontalAlignment = GridData.HORIZONTAL_ALIGN_END;
		gridData.widthHint = 150;
		gridData.heightHint = 22;
		btnGroupComposite.setLayoutData(gridData);

		// Set the OK button as the default, so
		// user can type input and press Enter
		// to dismiss
		// shell.setDefaultButton(okBtn);
		// shell.layout(true, true);
		return workArea;
	}

	/**
	 * 
	 * @param parent
	 */
	public Composite createControls(Composite parent) {
		Composite composite = null;
		try {
			composite = new Composite(parent, SWT.NATIVE);
			GridLayout gridLayout = new GridLayout(1, false);
			composite.setLayout(gridLayout);

			GridData gridData = new GridData(GridData.FILL);
			gridData.verticalAlignment = GridData.BEGINNING;
			composite.setLayoutData(gridData);

			// -------------
			Composite output = new Composite(composite, SWT.FILL);

			gridLayout = new GridLayout();
			gridLayout.numColumns = 3;
			gridData = new GridData(GridData.FILL_HORIZONTAL);

			output.setLayout(gridLayout);
			output.setLayoutData(gridData);

			// -------------
			// -------------
			Label label = new Label(output, SWT.FILL);
			label.setText("File name: ");

			gridData = new GridData();
			gridData.horizontalAlignment = SWT.LEFT;
			gridData.grabExcessHorizontalSpace = false;
			gridData.widthHint = MIN_LABEL_WIDTH;
			label.setLayoutData(gridData);

			// -------------
			projectDir = new Text(output, SWT.BORDER);
			gridData = new GridData();
			gridData.widthHint = 375;
			// gridData.grabExcessHorizontalSpace = true;
			// gridData.minimumWidth = MIN_TEXT_WIDTH;
			projectDir.setEditable(true);
			projectDir.setLayoutData(gridData);
			setProjectDir();
			projectDir.setSelection(projectDir.getText().length());

			// dest field is not editable

			// -------------
			browseBtn = new Button(output, SWT.PUSH);
			browseBtn.setText("Browse");

			gridData = new GridData();
			gridData.horizontalAlignment = GridData.FILL;
			gridData.minimumWidth = MIN_BUTTON_WIDTH;
			gridData.widthHint = MIN_BUTTON_WIDTH;
			browseBtn.setLayoutData(gridData);

			browseBtnListener = new SaveAsBrowseBtnListener(this, projectDir);
			browseBtn.addSelectionListener(browseBtnListener);

			// -------------
			// -------------
			Composite comments = new Composite(composite, SWT.FILL);
			gridLayout = new GridLayout();
			gridLayout.numColumns = 2;
			gridData = new GridData();

			comments.setLayout(gridLayout);
			comments.setLayoutData(gridData);

			label = new Label(comments, SWT.FILL);
			label.setText("Change notes: ");

			// -------------
			gridData = new GridData();
			gridData.horizontalAlignment = SWT.LEFT;
			gridData.grabExcessHorizontalSpace = false;
			gridData.widthHint = MIN_LABEL_WIDTH;
			label.setLayoutData(gridData);

			// -------------
			commentsText = new Text(comments, SWT.NONE | SWT.WRAP | SWT.BORDER
					| SWT.MULTI | SWT.V_SCROLL);

			gridData = new GridData();
			gridData.grabExcessHorizontalSpace = true;
			gridData.heightHint = 60;
			gridData.widthHint = 358;

			commentsText.setLayoutData(gridData);

			// CommentsText must contains 80 chars max !
			commentsText.addVerifyListener(new VerifyListener() {

				public void verifyText(VerifyEvent e) {

					if (isSaveAllowed(e)) {
						getButton(IDialogConstants.OK_ID).setEnabled(true);
					} else {
						getButton(IDialogConstants.OK_ID).setEnabled(false);
					}
				}
			});

		} catch (Exception e) {
			e.printStackTrace();
		}
		return composite;
	}

	private void setProjectDir() {

		File file = new File(cpfFilePath);
		String name = modifyName(file.getName().substring(0,
				file.getName().lastIndexOf(".")));
		file = new File(new Path(cpfFilePath).removeLastSegments(1)
				.toOSString());
		String[] list = file.list();
		int increment = 0;
		for (int i = 0; i < list.length; i++) {
			int lastIndexOf = list[i].lastIndexOf(".");
			String temp = "";
			if (lastIndexOf > 0) {
				temp = modifyName(list[i].substring(0, lastIndexOf));
			}
			if (name.equals(temp)) {
				increment++;
			}
		}
		if (increment > 0) {
			name = file.getPath() + "/" + name + "_" + increment + ".cpf";
			projectDir.setText(new Path(name).toOSString());
		} else {
			projectDir.setText(cpfFilePath);
		}
	}

	private String modifyName(String name) {
		if (name.contains("_")) {
			for (int i = name.lastIndexOf("_") + 1; i < name.length(); i++) {
				if (!Character.isDigit(name.charAt(i))) {
					break;
				} else if (i == name.length() - 1) {
					name = name.substring(0, name.lastIndexOf("_"));
				}
			}
		}
		return name;
	}

	private boolean isSaveAllowed(VerifyEvent e) {
		boolean result = true;
		if (projectDir.getText() == "") {
			result = false;
		}
		if (isCommentLengthOK(e)) {
			result &= true;
		}
		return result;
	}

	@Override
	public Button getButton(int id) {
		return super.getButton(id);
	}

	/**
	 * Save data and close the dialog window
	 */

	protected void okPressed() {
		projectDirString = projectDir.getText();
		commentsString = commentsText.getText();

		if (!validateProjectDir(projectDirString)) {
			MessageDialog.openError(projectDir.getShell(),
					"Wrong path specified", "Specified path \""
							+ projectDirString + "\" is not valid.");
		} else if (new Path(cpfFilePath).toOSString().equals(new Path(projectDirString).toOSString())) {
			MessageDialog.openError(projectDir.getShell(),
					"Save is not allowed", "CPF file can not be saved to specified location: \""
							+ projectDirString + "\".");
		} else {
			File file = new File(new Path(projectDirString).toOSString());
			File file2 = new File(new Path(projectDirString).removeLastSegments(
					1).toString());

			if (file.exists()) {
				if (MessageDialog.openConfirm(projectDir.getShell(),
						"Override file?", "File \"" + file.getPath()
								+ "\" already exists. Do you want to override it?")) {
					super.okPressed();
				}
			} else if (!file2.exists()) {
				if (MessageDialog.openConfirm(projectDir.getShell(),
						"Create new directory?", "Directory \"" + file.getPath()
								+ "\" does not exist. Do you want to create it?")) {
					super.okPressed();
				}
			} else {
				super.okPressed();
			}
		}
	}

	private boolean validateProjectDir(String projectDirString) {
		if (projectDirString.trim() == "" || !projectDirString.endsWith(".cpf")) {
			return false;
		}
		Path path = new Path("");
		if (!path.isValidPath(projectDirString)) {
			return false;
		}
		return true;
	}

	/**
	 * Checks the comment length Replace new line chars
	 */
	private boolean isCommentLengthOK(VerifyEvent ve) {
		String comment = commentsText.getText();
		String replaced = comment.replaceAll("\t|\r|\n|\f", "");
		int length = replaced.length();

		if (ve != null) {
			if ((ve.keyCode == SWT.BS) || (ve.keyCode == SWT.DEL)) {
				ve.doit = true; // whether no action is required
			}
			return checkLength(ve, length);
		}
		return false;
	}

	/**
	 * @param ve
	 * @param length
	 */
	private boolean checkLength(VerifyEvent ve, int length) {

		if (length > 80 || (ve.text.length() + length) > 80) {
			fireWarning(ve.text.length() + length);
			ve.doit = false;
		} else {
			ve.doit = true;
		}
		return ve.doit;
	}

	/**
	 * @param length
	 */
	private void fireWarning(int length) {
		MessageDialog.openError(commentsText.getShell(), "Warning",
				"Max is 80 characters\n" + "Current length is " + length
						+ " charracters");
	}

	public boolean isOverride() {
		return override;
	}

	public void setOverride(boolean override) {
		this.override = override;
	}

	public CPFEditor getEditor() {
		return editor;
	}

}
