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

package com.nokia.tools.variant.resourcelibrary.actions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.actions.BaseSelectionListenerAction;
import org.eclipse.ui.dialogs.SelectionStatusDialog;
import org.eclipse.ui.part.IPageBookViewPage;

import com.nokia.tools.variant.resourcelibrary.Activator;
import com.nokia.tools.variant.resourcelibrary.handlers.commands.RenameCommand;
import com.nokia.tools.variant.resourcelibrary.handlers.commands.ResourceLibraryCommandHelper;
import com.nokia.tools.variant.resourcelibrary.model.Directory;
import com.nokia.tools.variant.resourcelibrary.model.FileSystemElement;
import com.nokia.tools.variant.resourcelibrary.views.IResourceLibraryPage;
import com.nokia.tools.variant.resourcelibrary.views.ResourceStorage;

public class RenameResourceAction extends BaseSelectionListenerAction {

	private IResourceLibraryPage page;

	public RenameResourceAction(IResourceLibraryPage page) {
		super("Rename");
		 setImageDescriptor(Activator.getImageDescriptor("icons/wordassist_co.gif"));
		this.page = page;
	}

	@Override
	protected boolean updateSelection(IStructuredSelection selection) {
		if (selection.size() != 1) {
			return false;
		}
		
		FileSystemElement fse = ((ResourceStorage)selection.getFirstElement()).getFileSystemElement();
		if (ResourceLibraryCommandHelper.checkModifyStatus(fse) != ResourceLibraryCommandHelper.STATUS_OK || fse.touchedByReadonlySetting()) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public void run() {
		CommandStack stack = page.getCommandStack();
		IStructuredSelection sel = getStructuredSelection();

		List<ResourceStorage> resources = new ArrayList<ResourceStorage>();
		for (Object obj: sel.toArray()) {
			if (obj instanceof ResourceStorage) {
				resources.add((ResourceStorage)obj);
			}
		}
		
		Shell shell = ((IPageBookViewPage)page).getSite().getShell();

		// Fetch selection
		Object element = sel.getFirstElement();
		FileSystemElement fse = ((ResourceStorage) element).getFileSystemElement();
		Directory target = (Directory) fse.eContainer();

		// Launch a dialog for fetching folder, check existence of the folder
		RenameResourceDialog diag = new RenameResourceDialog(shell, target);
		diag.setInitialSelections(new String[] {fse.getName()});
		if (diag.open() != RenameResourceDialog.OK) {
			return;
		}
		String newName = (String) diag.getFirstResult();
		Command cmd = RenameCommand.createRenameCommand(fse, newName);

		if (cmd.canExecute()) {
			stack.execute(cmd);
		} else {
			cmd.dispose();
		}

	}

	class RenameResourceDialog extends SelectionStatusDialog {

		private Directory parentContainer;
		private Text folderNameField;

		public RenameResourceDialog(Shell parent, Directory destination) {
			super(parent);
			this.parentContainer = destination;
			setTitle("Enter New Resource Name");
		}

		@Override
		public void create() {
			super.create();
			getButton(IDialogConstants.OK_ID).setEnabled(false);
		}

		@Override
		protected Control createDialogArea(Composite parent) {
			Composite composite = (Composite) super.createDialogArea(parent);
			composite.setLayout(new GridLayout());
			composite.setLayoutData(new GridData(GridData.FILL_BOTH));

			Font font = parent.getFont();
			// project specification group
			GridLayout layout = new GridLayout();
			layout.numColumns = 2;

			// new folder label
			Label folderLabel = new Label(composite, SWT.NONE);
			folderLabel.setFont(font);
			folderLabel.setText("New name:");

			// new folder name entry field
			folderNameField = new Text(composite, SWT.BORDER);
			GridData data = new GridData(GridData.FILL_HORIZONTAL);
			data.widthHint = 400;
			folderNameField.setLayoutData(data);
			folderNameField.setFont(font);
			folderLabel.setSize(folderLabel.computeSize(SWT.DEFAULT,
					SWT.DEFAULT).x, 200);
			if (!getInitialElementSelections().isEmpty()) {
				folderNameField.setText((String)getInitialElementSelections().get(0));
				folderNameField.selectAll();
			}
			folderNameField.addListener(SWT.Modify, new Listener() {
				public void handleEvent(Event event) {
					validate();
				}
			});
			

			return composite;
		}

		private void validate() {
			boolean valid = checkIfValid();
			getButton(IDialogConstants.OK_ID).setEnabled(valid);
		}

		private boolean checkIfValid() {
			// Check that the destination doesn't have a folder with the same
			// name
			String name = folderNameField.getText().trim().toLowerCase();
			if (!Path.EMPTY.isValidSegment(name)) {
				updateStatus(new Status(IStatus.ERROR, Activator.PLUGIN_ID,
						"New name is not valid."));
				return false;
			}			
			EList<FileSystemElement> children = parentContainer.getChildren();
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

		protected void okPressed() {
			setSelectionResult(new String[] { folderNameField.getText().trim() });
			super.okPressed();
		}

		@Override
		protected void computeResult() {
		}
	}
}

