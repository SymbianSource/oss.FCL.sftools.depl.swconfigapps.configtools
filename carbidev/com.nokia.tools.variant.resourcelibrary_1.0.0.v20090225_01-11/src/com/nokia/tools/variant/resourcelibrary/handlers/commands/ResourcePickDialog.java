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
 * Description: This file is part of com.nokia.tools.variant.resourcelibrary component.
 */

package com.nokia.tools.variant.resourcelibrary.handlers.commands;

import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;

import com.nokia.tools.variant.common.ui.wizards.dialogfields.DialogField;
import com.nokia.tools.variant.common.ui.wizards.dialogfields.IDialogFieldListener;
import com.nokia.tools.variant.common.ui.wizards.dialogfields.LayoutUtil;
import com.nokia.tools.variant.common.ui.wizards.dialogfields.StringDialogField;
import com.nokia.tools.variant.resourcelibrary.Activator;
import com.nokia.tools.variant.resourcelibrary.model.Directory;
import com.nokia.tools.variant.resourcelibrary.model.File;
import com.nokia.tools.variant.resourcelibrary.model.FileSystemElement;
import com.nokia.tools.variant.resourcelibrary.model.ResourceModelRoot;
import com.nokia.tools.variant.resourcelibrary.views.ResourceLibraryContentProvider;
import com.nokia.tools.variant.resourcelibrary.views.ResourceLibraryTableLabelProvider;
import com.nokia.tools.variant.resourcelibrary.views.ResourceStorage;

public class ResourcePickDialog extends ElementTreeSelectionDialog implements
		IDialogFieldListener {
	private List<ResourceStorage> resource;
	private StringDialogField dialogField;
	private Directory selected;

	public ResourcePickDialog(Shell sh, boolean isFolder, String pattern,
			List<ResourceStorage> res) {

		super(sh, new ResourceLibraryTableLabelProvider(),
				new ResourceLibraryContentProvider(
						(ResourceModelRoot) PlatformUI.getWorkbench()
								.getActiveWorkbenchWindow().getActivePage()
								.getActiveEditor().getAdapter(
										ResourceModelRoot.class)));
		resource = res;
		// Open a dialog which will pick an item from resource library
		Object adapter = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().getActiveEditor().getAdapter(
						ResourceModelRoot.class);
		if (adapter instanceof ResourceModelRoot) {
			setEmptyListMessage("No resources found for selecting");
			setAllowMultiple(false);

			if (isFolder) {
				setMessage("Pick a folder.");
			} else {
				setMessage("Pick a resource.");
			}
			setTitle("Select resource");
			setInput(adapter);
			setValidator(new ResourceValidator(isFolder, pattern));
		}
	}

	class ResourceValidator implements ISelectionStatusValidator {

		private static final String SELECT_ONE_RESOURCE = "No resources or folders selected.";
		private static final String SELECT_OK = "";

		private boolean isFolder;
		private String pattern;

		public ResourceValidator(boolean isFolder, String pattern) {
			this.isFolder = isFolder;
			this.pattern = pattern;
		}

		public IStatus validate(Object[] selection) {
			selected = null;

			if (selection == null || selection.length == 0) {
				return new Status(IStatus.ERROR, Activator.PLUGIN_ID,
						SELECT_ONE_RESOURCE);
			}
			if (selection != null && selection.length > 0) {
				if (selection[0] instanceof File) {
					if (isFolder) {
						return new Status(IStatus.ERROR, Activator.PLUGIN_ID,
								"No folder selected");
					} else {
						File file = (File) selection[0];
						IPath path = file.getPath2();
						if (pattern != "") {
							if (Pattern.matches(pattern, path.toString())) {
								return new Status(IStatus.ERROR,
										Activator.PLUGIN_ID,
										"Selected file does not match pattern "
												+ pattern + ".");
							}
						}
					}
				}
				if (selection[0] instanceof Directory) {
					selected = (Directory) selection[0];
					if (!isFolder) {
						return new Status(IStatus.ERROR, Activator.PLUGIN_ID,
								"No file selected");
					}
				}

				for (ResourceStorage res : resource) {
					String name = res.getName().toLowerCase();
					EList<FileSystemElement> children = selected.getChildren();
					for (FileSystemElement fileSystemElement : children) {
						String childName = fileSystemElement.getName()
								.toLowerCase();
						if (name.equals(childName)) {
							return new Status(IStatus.ERROR,
									Activator.PLUGIN_ID,
									"Resource already exists.");
						}
					}
				}
			}

			return new Status(IStatus.OK, Activator.PLUGIN_ID, SELECT_OK);
		}
	}

	@Override
	protected Control createContents(Composite parent) {
		// create the top level composite for the dialog
		Composite composite = new Composite(parent, 0);
		GridLayout layout = new GridLayout();
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		layout.verticalSpacing = 0;
		composite.setLayout(layout);
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));
		applyDialogFont(composite);
		// initialize the dialog units
		initializeDialogUnits(composite);
		// create the dialog area and button bar
		dialogArea = createDialogArea(composite);

		createRenameBar(composite);
		buttonBar = createButtonBar(composite);

		return composite;

	}

	private Control createRenameBar(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(2, false);
		layout.marginHeight = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_MARGIN);
		layout.marginWidth = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_MARGIN);
		layout.verticalSpacing = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_SPACING);
		layout.horizontalSpacing = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_SPACING);
		composite.setLayout(layout);
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));
		if (resource.size() == 1) {

			dialogField = new StringDialogField();
			String filename = "";
			if ((resource != null) && (resource.size() > 0)) {
				filename = resource.get(0).getName();
			}
			dialogField.setLabelText("File/Folder name: ");
			dialogField.setText(filename);
			dialogField.setDialogFieldListener(this);
			dialogField.doFillIntoGrid(composite, 2);
			LayoutUtil.setHorizontalGrabbing(dialogField
					.getTextControl(composite));
		}

		return composite;
	}

	public void dialogFieldChanged(DialogField field) {
		boolean valid = checkIfValid();
		getButton(IDialogConstants.OK_ID).setEnabled(valid);
	}

	private boolean checkIfValid() {
		String name = getFileName().toLowerCase();
		if (!Path.EMPTY.isValidPath(name)) {
			updateStatus(new Status(IStatus.ERROR, Activator.PLUGIN_ID,
					"New name is not valid."));
			return false;
		}
		EList<FileSystemElement> children = selected.getChildren();
		for (FileSystemElement fileSystemElement : children) {
			String childName = fileSystemElement.getName().toLowerCase();
			if (name.equals(childName)) {
				updateStatus(new Status(IStatus.ERROR, Activator.PLUGIN_ID,
						"Resource already exists."));
				return false;
			}
		}

		updateStatus(Status.OK_STATUS);
		return true;
	}

	public String getFileName() {
		return dialogField.getText();
	}
}
