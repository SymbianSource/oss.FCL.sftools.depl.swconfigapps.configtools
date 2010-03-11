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
 * Description: This file is part of com.nokia.tools.variant.compare.ui component.
 */

package com.nokia.tools.variant.compare.ui.wizards;

import java.io.File;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;

import com.nokia.tools.variant.common.core.utils.FileUtils;
import com.nokia.tools.variant.common.ui.utils.PixelConverter;
import com.nokia.tools.variant.common.ui.wizards.dialogfields.DialogField;
import com.nokia.tools.variant.common.ui.wizards.dialogfields.IDialogFieldListener;
import com.nokia.tools.variant.common.ui.wizards.dialogfields.IStringButtonAdapter;
import com.nokia.tools.variant.common.ui.wizards.dialogfields.LayoutUtil;
import com.nokia.tools.variant.common.ui.wizards.dialogfields.StringButtonDialogField;
import com.nokia.tools.variant.common.ui.wizards.dialogfields.StringDialogField;

public class ImportDataWizardPageOne extends WizardPage {

	public static final String PAGE_ID = "ImportDataWizardPageOne";

	/**
	 * If CPF is opened, then is automatically set as target CPF
	 */
	private boolean cpfOpened = false;

	public void setCpfOpened(boolean cpfOpened) {
		this.cpfOpened = cpfOpened;
	}

	private final class SelectionGroup extends Observable implements
			IDialogFieldListener, IStringButtonAdapter {

		protected final StringDialogField targetLocation;
		protected final StringButtonDialogField sourceLocationBtn;
		protected final StringButtonDialogField targetLocationBtn;

		public SelectionGroup() {
			targetLocation = new StringDialogField(SWT.READ_ONLY);
			targetLocation.setLabelText("Target File:");

			targetLocationBtn = new StringButtonDialogField(this);
			targetLocationBtn.setDialogFieldListener(this);
			targetLocationBtn.setLabelText("Target File:");
			targetLocationBtn.setButtonLabel("Browse...");

			sourceLocationBtn = new StringButtonDialogField(this);
			sourceLocationBtn.setDialogFieldListener(this);
			sourceLocationBtn.setLabelText("Source File:");
			sourceLocationBtn.setButtonLabel("Browse...");
		}

		public Control createControl(Composite composite) {
			final int numColumns = 3;

			Composite group = new Composite(composite, SWT.NONE);
			group.setLayout(initGridLayout(new GridLayout(numColumns, false),
					false));
			if (cpfOpened) {
				targetLocation.doFillIntoGrid(group, numColumns);
			} else {
				targetLocationBtn.doFillIntoGrid(group, numColumns);
			}
			sourceLocationBtn.doFillIntoGrid(group, numColumns);

			LayoutUtil.setHorizontalGrabbing(sourceLocationBtn
					.getTextControl(group));

			return group;
		}

		public void changeControlPressed(DialogField field) {
			if (field == sourceLocationBtn) {
				File f = new File(sourceLocationBtn.getText());
				if (!f.exists()) {
					f = null;
				}
				File d = getFile(f, new String[] {
						"All Supported Sources (*.cpf; *.confml)",
						"CPF File (*.cpf)", "ConfML Data File (*.confml)" },
						new String[] { "*.cpf;*.confml", "*.cpf", "*.confml" });
				if (d == null) {
					// fileLocation.setText("");
				} else {
					sourceLocationBtn.setText(d.getAbsolutePath());
				}
			}

			if (field == targetLocationBtn) {
				File f = new File(targetLocationBtn.getText());
				if (!f.exists()) {
					f = null;
				}
				File d = getFile(f, new String[] {
						"All Supported Sources (*.cpf; *.confml)",
						"CPF File (*.cpf)", "ConfML Data File (*.confml)" },
						new String[] { "*.cpf;*.confml", "*.cpf", "*.confml" });
				if (d != null) {
					targetLocationBtn.setText(d.getAbsolutePath());
				}
			}
		}

		/**
		 * Helper to open the file chooser dialog.
		 * 
		 * @param startingDirectory
		 *            the directory to open the dialog on.
		 * @return File The File the user selected or <code>null</code> if they
		 *         do not.
		 */
		private File getFile(File startingDirectory, String[] names,
				String[] ext) {

			FileDialog dialog = new FileDialog(getShell(), SWT.OPEN);
			if (startingDirectory != null) {
				dialog.setFileName(startingDirectory.getPath());
			}
			dialog.setFilterExtensions(ext);
			dialog.setFilterNames(names);
			String file = dialog.open();
			if (file != null) {
				file = file.trim();
				if (file.length() > 0) {
					return new File(file);
				}
			}

			return null;
		}

		public void dialogFieldChanged(DialogField field) {

			fireEvent();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Observer#update(java.util.Observable,
		 * java.lang.Object)
		 */
		public void update(Observable o, Object arg) {
			fireEvent();
		}

		protected void fireEvent() {
			setChanged();
			notifyObservers();
		}

	}

	public File getSelectedSourceFile() {
		return new File(selectionGroup.sourceLocationBtn.getText());
	}

	public File getSelectedTargetFile() {
		return new File(selectionGroup.targetLocationBtn.getText());
	}

	private class Validator implements Observer {
		public void update(Observable o, Object arg) {
			String sourcePath = selectionGroup.sourceLocationBtn.getText();
			String targetPath = selectionGroup.targetLocationBtn.getText();

			if (!cpfOpened) {
				// target file validation
				if (targetPath.length() == 0) {
					setPageComplete(false);
					setMessage("Specify the target file path");
					selectionGroup.targetLocationBtn.setErrorMessage(null);
					return;
				}

				File targetFile = new File(targetPath);
				if (!targetFile.exists()) {
					setPageComplete(false);
					setErrorMessage("The target file does not exist");
					selectionGroup.targetLocationBtn
							.setErrorMessage("Specify valid file name");
					return;
				}

				if (targetFile.isDirectory()) {
					setPageComplete(false);
					setErrorMessage("The specified name must point to a file");
					selectionGroup.targetLocationBtn
							.setErrorMessage("Specify valid file name");
					return;
				}

				String targetExt = FileUtils.getExtension(targetFile);
				if (!"cpf".equals(targetExt)) {
					setPageComplete(false);
					setErrorMessage("The file must have '.cpf' extension");
					selectionGroup.sourceLocationBtn
							.setErrorMessage("Specify valid file name");
					return;
				}
				selectionGroup.targetLocationBtn.setErrorMessage(null);
			}

			// source file validation
			if (sourcePath.length() == 0) {
				setPageComplete(false);
				setMessage("Specify the source file path");
				selectionGroup.sourceLocationBtn.setErrorMessage(null);
				return;
			}
			File sourceFile = new File(sourcePath);
			if (!sourceFile.exists()) {
				setPageComplete(false);
				setErrorMessage("The source file does not exist");
				selectionGroup.sourceLocationBtn
						.setErrorMessage("Specify valid file name");
				return;
			}
			if (sourceFile.isDirectory()) {
				setPageComplete(false);
				setErrorMessage("The specified name must point to a file");
				selectionGroup.sourceLocationBtn
						.setErrorMessage("Specify valid file name");
				return;
			}
			String sourceExt = FileUtils.getExtension(sourceFile);
			if (!"cpf".equals(sourceExt) && !"confml".equals(sourceExt)) {
				setPageComplete(false);
				setErrorMessage("The file must have '.cpf' or '.confml' extension");
				selectionGroup.sourceLocationBtn
						.setErrorMessage("Specify valid file name");
				return;
			}
			selectionGroup.sourceLocationBtn.setErrorMessage(null);

			setPageComplete(true);
			setErrorMessage(null);
			setMessage(null);
		}
	}

	SelectionGroup selectionGroup = new SelectionGroup();
	Validator validator = new Validator();

	public ImportDataWizardPageOne() {
		super(PAGE_ID);
		setPageComplete(false);

		if (cpfOpened) {
			setTitle("Select file to import from");
		} else {
			setTitle("Select file to import ");
		}

		setDescription("You can import data into opened CPF from another CPF file or ConfML data file");

		selectionGroup = new SelectionGroup();
		validator = new Validator();
		selectionGroup.addObserver(validator);
	}

	public void createControl(Composite parent) {
		pixelConverter = new PixelConverter(parent);
		Composite content = new Composite(parent, SWT.NONE);
		content.setLayout(initGridLayout(new GridLayout(3, false), true));
		Control control = selectionGroup.createControl(content);
		control
				.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3,
						1));
		setControl(content);
	}

	private PixelConverter pixelConverter;

	private GridLayout initGridLayout(GridLayout layout, boolean margins) {
		layout.horizontalSpacing = pixelConverter
				.convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_SPACING);
		layout.verticalSpacing = pixelConverter
				.convertHorizontalDLUsToPixels(IDialogConstants.VERTICAL_SPACING);
		if (margins) {
			layout.marginWidth = pixelConverter
					.convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_MARGIN);
			layout.marginHeight = pixelConverter
					.convertHorizontalDLUsToPixels(IDialogConstants.VERTICAL_MARGIN);
		} else {
			layout.marginWidth = 0;
			layout.marginHeight = 0;
		}
		return layout;
	}

	public void setTargetFile(String location) {
		selectionGroup.targetLocation.setText(location);
	}

}
