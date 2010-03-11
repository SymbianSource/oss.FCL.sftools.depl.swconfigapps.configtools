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
 * Description: This file is part of com.nokia.tools.variant.confml.ui component.
 */

package com.nokia.tools.variant.confml.ui.wizards;

import java.io.File;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;

import com.nokia.tools.vct.common.ui.wizards.dialogfields.DialogField;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.IDialogFieldListener;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.IStringButtonAdapter;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.LayoutUtil;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.SelectionButtonDialogField;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.StringButtonDialogField;

public class ImportImplMLWizardPage extends WizardPage {

	private final class TargetProject extends Observable implements IDialogFieldListener, IStringButtonAdapter {
		protected final StringButtonDialogField targetFolder;
		
		public TargetProject() {
			// SWT.DROP_DOWN | SWT.SIMPLE | SWT.READ_ONLY
			targetFolder = new StringButtonDialogField(this);
			targetFolder.setDialogFieldListener(this);
			targetFolder.setLabelText("Destination:");
		}
		
		public void dialogFieldChanged(DialogField field) {
			fireEvent();
		}
		
		public void changeControlPressed(DialogField field) {
			
			
		}
		
		public void setDestination(String value) {
			targetFolder.setText(value);
		}
		
		public String getProjectField() {
			return targetFolder.getText();
		}
		
		protected void fireEvent() {
			setChanged();
			notifyObservers();
		}
		
		public Control createControl(Composite composite) {
			final int numColumns = 3;

			Group group = new Group(composite, SWT.NONE);
			group.setLayout(initGridLayout(new GridLayout(numColumns, false),
					true));
			group.setText("Destination");

			targetFolder.doFillIntoGrid(group, numColumns);

			LayoutUtil.setHorizontalGrabbing(targetFolder.getTextControl(null));

			return group;
		}
	}
	
	private final class SelectionGroup extends Observable implements
			IDialogFieldListener, IStringButtonAdapter {

		protected final SelectionButtonDialogField importDirectoryRadio;
		protected final SelectionButtonDialogField importFileRadio;
		protected final StringButtonDialogField fileLocation;
		protected final StringButtonDialogField directoryLocation;

		protected String lastFileLocation;
		protected String lastDirectoryLocation;

		public SelectionGroup() {
			lastFileLocation = ""; //$NON-NLS-1$
			lastDirectoryLocation = ""; //$NON-NLS-1$

			importDirectoryRadio = new SelectionButtonDialogField(SWT.RADIO);
			importDirectoryRadio.setDialogFieldListener(this);
			importDirectoryRadio.setLabelText("Import from a directory");

			importFileRadio = new SelectionButtonDialogField(SWT.RADIO);
			importFileRadio.setDialogFieldListener(this);
			importFileRadio.setLabelText("Import single file");

			fileLocation = new StringButtonDialogField(this);
			fileLocation.setDialogFieldListener(this);
			fileLocation.setLabelText("File Location:");
			fileLocation.setButtonLabel("Browse...");

			directoryLocation = new StringButtonDialogField(this);
			directoryLocation.setDialogFieldListener(this);
			directoryLocation.setLabelText("Directory Location:");
			directoryLocation.setButtonLabel("Browse...");

			importFileRadio.attachDialogFields(fileLocation);
			importDirectoryRadio.attachDialogFields(directoryLocation);

			importDirectoryRadio.setSelection(true);
			importFileRadio.setSelection(false);
		}

		public Control createControl(Composite composite) {
			final int numColumns = 3;

			Group group = new Group(composite, SWT.NONE);
			group.setLayout(initGridLayout(new GridLayout(numColumns, false),
					true));
			group.setText("Import Source");

			importDirectoryRadio.doFillIntoGrid(group, numColumns);
			directoryLocation.doFillIntoGrid(group, numColumns);
			importFileRadio.doFillIntoGrid(group, numColumns);
			fileLocation.doFillIntoGrid(group, numColumns);

			LayoutUtil.setHorizontalGrabbing(directoryLocation
					.getTextControl(group));
			LayoutUtil
					.setHorizontalGrabbing(fileLocation.getTextControl(group));

			importDirectoryRadio.setSelection(true);
			importFileRadio.setSelection(false);

			return group;
		}

		public void changeControlPressed(DialogField field) {
			if (field == fileLocation) {
				File f = new File(fileLocation.getText());
				if (!f.exists()) {
					f = null;
				}
				File d = getFile(f, new String[] { "ConfML File (*.confml)" },
						new String[] { "*.confml" });
				if (d == null) {
					// fileLocation.setText("");
				} else {
					fileLocation.setText(d.getAbsolutePath());
				}
			} else if (field == directoryLocation) {
				File f = new File(directoryLocation.getText());
				if (!f.exists()) {
					f = null;
				}
				File d = getDirectory(f);
				if (d != null) {
					directoryLocation.setText(d.getAbsolutePath());
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

		/**
		 * Helper that opens the directory chooser dialog.
		 * 
		 * @param startingDirectory
		 *            The directory the dialog will open in.
		 * @return File File or <code>null</code>.
		 * 
		 */
		private File getDirectory(File startingDirectory) {
			DirectoryDialog fileDialog = new DirectoryDialog(getShell(),
					SWT.OPEN);
			if (startingDirectory != null) {
				fileDialog.setFilterPath(startingDirectory.getPath());
			}
			String dir = fileDialog.open();
			if (dir != null) {
				dir = dir.trim();
				if (dir.length() > 0) {
					return new File(dir);
				}
			}

			return null;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Observer#update(java.util.Observable,
		 * java.lang.Object)
		 */
		public void update(Observable o, Object arg) {
			if (isDirectoryImportSelected()) {
				directoryLocation.setText("");
			} else {
				fileLocation.setText("");
			}
			fireEvent();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.jdt.internal.ui.wizards.dialogfields.IDialogFieldListener
		 * #dialogFieldChanged(org.eclipse.jdt.internal.ui.wizards.dialogfields.
		 * DialogField)
		 */
		public void dialogFieldChanged(DialogField field) {
			if (field == importDirectoryRadio || field == importFileRadio) {
				if (isDirectoryImportSelected()) {
					lastFileLocation = fileLocation.getText();
					fileLocation.setText("");
					directoryLocation.setText(lastDirectoryLocation);
				} else {
					lastDirectoryLocation = directoryLocation.getText();
					directoryLocation.setText("");
					fileLocation.setText(lastFileLocation);
				}
			}
			fireEvent();
		}

		protected void fireEvent() {
			setChanged();
			notifyObservers();
		}

		public boolean isDirectoryImportSelected() {
			return importDirectoryRadio.isSelected();
		}

	}

	final class ImportOptions extends Observable implements IDialogFieldListener {
		protected final SelectionButtonDialogField makeLinks;

		public ImportOptions() {
			
			makeLinks = new SelectionButtonDialogField(SWT.CHECK);
			makeLinks.setDialogFieldListener(this);
			makeLinks.setLabelText("Create only links");
//			makeLinks.setToolTipText("Create links instead of copying files");
			makeLinks.setSelection(false);
		}
		
		public void dialogFieldChanged(DialogField field) {
			fireEvent();
		}

		protected void fireEvent() {
			setChanged();
			notifyObservers();
		}

		public Control createControl(Composite composite) {
			final int numColumns = 3;

			Group group = new Group(composite, SWT.NONE);
			group.setLayout(initGridLayout(new GridLayout(numColumns, false),
					true));
			group.setText("Import Options");

			makeLinks.doFillIntoGrid(group, numColumns);


			LayoutUtil
			.setHorizontalGrabbing(makeLinks.getSelectionButton(null));

			return group;
		}
	}
	
	final class Validator implements Observer {
		public void update(Observable o, Object arg) {
			String field = targetProjectGroup.getProjectField();
			if (field.length() == 0) {
				setPageComplete(false);
				setErrorMessage(null);
				setMessage("Select target project");
				return;
			}

			IFolder folder = ResourcesPlugin.getWorkspace().getRoot().getFolder(new Path(field));
			if (!folder.isAccessible()) {
				setPageComplete(false);
				setErrorMessage("Project name: wrong value");
				setMessage(null);
				return;
			}
			String path;
			if (selectionGroup.isDirectoryImportSelected()) {
				path = selectionGroup.directoryLocation.getText().trim();
			} else {
				path = selectionGroup.fileLocation.getText().trim();
			}
			if (path.length() == 0) {
				setPageComplete(false);
				setErrorMessage("Source path: the value can not be empty");
				setMessage(null);
				return;
			}
			File file = new File(path);
			if (!file.exists()) {
				setPageComplete(false);
				setErrorMessage("Source path: the resource does not exist");
				setMessage(null);
				return;
			}
			if (selectionGroup.isDirectoryImportSelected() && !file.isDirectory()) {
				setPageComplete(false);
				setErrorMessage("Source path: the target must point to a directory");
				setMessage(null);
				return;
			}
			if (!selectionGroup.isDirectoryImportSelected() && file.isDirectory()) {
				setPageComplete(false);
				setErrorMessage("Source path: the target must point to a file");
				setMessage(null);
				return;
			}
			
			
			setPageComplete(true);
			setErrorMessage(null);
			setMessage(null);
			return;
			
		}
	}
	
	final SelectionGroup selectionGroup;
	final TargetProject targetProjectGroup;
	final ImportOptions importOptions;
	final Validator validator;
	
	public ImportImplMLWizardPage() {
		super("ImportConfMLPageOne");
		setTitle("ImplML Import Wizard"); // NON-NLS-1
		setDescription("Import a file or set of ImplMLs from the local file system into the workspace"); // NON
																											// -
																											// NLS
																											// -
																											// 1

		targetProjectGroup = new TargetProject();
		selectionGroup = new SelectionGroup();
		importOptions = new ImportOptions();
		validator = new Validator();
		targetProjectGroup.addObserver(validator);
		selectionGroup.addObserver(validator);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.dialogs.WizardNewFileCreationPage#createAdvancedControls
	 * (org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		initializeDialogUnits(parent);

		final Composite composite = new Composite(parent, SWT.NULL);
		composite.setFont(parent.getFont());
		composite.setLayout(initGridLayout(new GridLayout(1, false), true));
		composite.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));

		Control control;

		control = targetProjectGroup.createControl(composite);
		control.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
		
		control = selectionGroup.createControl(composite);
		control.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

		control = importOptions.createControl(composite);
		control.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
		
		setControl(composite);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.dialogs.WizardNewFileCreationPage#createLinkTarget()
	 */
	protected void createLinkTarget() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.dialogs.WizardNewFileCreationPage#getNewFileLabel()
	 */
	protected String getNewFileLabel() {
		return "New File Name:"; // NON-NLS-1
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.dialogs.WizardNewFileCreationPage#validateLinkedResource()
	 */
	protected IStatus validateLinkedResource() {
		return new Status(IStatus.OK, "com.nokia.tools.variant.confml.ui",
				IStatus.OK, "", null); // NON-NLS-1 //NON-NLS-2
	}

	private GridLayout initGridLayout(GridLayout layout, boolean margins) {
		layout.horizontalSpacing = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_SPACING);
		layout.verticalSpacing = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_SPACING);
		if (margins) {
			layout.marginWidth = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_MARGIN);
			layout.marginHeight = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_MARGIN);
		} else {
			layout.marginWidth = 0;
			layout.marginHeight = 0;
		}
		return layout;
	}

	public boolean isDirectoryImportSelected() {
		return selectionGroup.isDirectoryImportSelected();
	}

	public File getSourceDirectory() {
		return new File(selectionGroup.directoryLocation.getText().trim());
	}

	public File getSourceFile() {
		return new File(selectionGroup.fileLocation.getText().trim());
	}

	public void setSourceFolder(IFolder folder) {
		targetProjectGroup.setDestination(folder == null ? "" :folder.getFullPath().toPortableString());
	}

	public String getProjectName() {
		return targetProjectGroup.getProjectField();
	}
	
	public boolean isMakeLinks() {
		return importOptions.makeLinks.isSelected();
	}
}
