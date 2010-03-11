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

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.actions.BaseSelectionListenerAction;

import com.nokia.tools.variant.common.ui.utils.SWTUtil;
import com.nokia.tools.variant.resourcelibrary.Activator;
import com.nokia.tools.variant.resourcelibrary.handlers.commands.ImportCommand;
import com.nokia.tools.variant.resourcelibrary.model.Directory;
import com.nokia.tools.variant.resourcelibrary.resources.ResourceCategories;
import com.nokia.tools.variant.resourcelibrary.resources.ResourceCategory;
import com.nokia.tools.variant.resourcelibrary.views.IResourceLibraryPage;
import com.nokia.tools.variant.resourcelibrary.views.ResourceStorage;

public class ImportResourceAction extends BaseSelectionListenerAction {
	public static final String IMPORT_FAIL_STRING = "Failed to import some of the selected resources";

	public static final String IMPORT_DIALOG_STRING = "Import Resource(s)";

	public static final String REPLACE_RESOURCE_STRING = "Replace existing resource '%s'";

	public static final String ALL_FILES_STRING = "All Files (*.*)";
	public static final String ALL_FILES_EXT = "*";

	private IResourceLibraryPage page;

	public ImportResourceAction(IResourceLibraryPage page) {
		super("Import Resources");
		setImageDescriptor(Activator
				.getImageDescriptor("icons/import_16_tlb.png"));
		this.page = page;
	}

	@Override
	protected boolean updateSelection(IStructuredSelection selection) {
		return selection.isEmpty() || selection.size() == 1;
	}

	@Override
	public void run() {
		CommandStack stack = page.getCommandStack();
		IStructuredSelection sel = getStructuredSelection();

		List<ResourceStorage> resources = new ArrayList<ResourceStorage>();
		for (Object obj : sel.toArray()) {
			if (obj instanceof ResourceStorage) {
				resources.add((ResourceStorage) obj);
			}
		}

		Shell shell = SWTUtil.getStandardDisplay().getActiveShell();

		// Open a dialog for importing file
		List<File> files = getImportedFiles(shell);
		if (files == null || files.isEmpty()) {
			return;
		}

		// Fetch destination for the file
		Directory destination = getDestination(sel);

		// Assume destination is a directory, create local representation
		if (destination == null) {
			return;
		}
		assert (destination != null);

		Command command = ImportCommand.createImportCommand(destination, files);
		if (command.canExecute()) {
			stack.execute(command);
		} else {
			command.dispose();
		}
	}

	public Directory getDestination(IStructuredSelection sel) {

		// Fetch selection
		Object element = sel.getFirstElement();
		if (element instanceof ResourceStorage) {
			ResourceStorage rs = (ResourceStorage) element;
			if (rs.getFileSystemElement() instanceof Directory) {
				return (Directory) rs.getFileSystemElement();
			} else if (rs.getFileSystemElement() instanceof com.nokia.tools.variant.resourcelibrary.model.File) {
				com.nokia.tools.variant.resourcelibrary.model.File f = (com.nokia.tools.variant.resourcelibrary.model.File) rs
						.getFileSystemElement();
				return (Directory) f.eContainer();
			}
		} else if (element == null) {
			return page.getResourceModelRoot();
		}
		return null;
	}

	private List<File> getImportedFiles(Shell shell) {

		// Fetch a new native file dialog
		FileDialog dialog = new FileDialog(shell, SWT.MULTI);

		// Parse categories
		List<ResourceCategory> categories = ResourceCategories.getCategories();
		ArrayList<String> extensions = new java.util.ArrayList<String>();
		ArrayList<String> names = new java.util.ArrayList<String>();
		// Add (all files)
		names.add(ALL_FILES_STRING);
		extensions.add(ALL_FILES_EXT);

		for (ResourceCategory cat : categories) {
			names.add(cat.toString());
			extensions.add(cat.getExtensionsString());
		}

		dialog.setFilterNames(names.toArray(new String[names.size()]));
		dialog
				.setFilterExtensions(extensions
						.toArray(new String[names.size()]));
		dialog.setText(IMPORT_DIALOG_STRING);

		// Open the dialog
		if (dialog.open() == null)
			return new ArrayList<File>(0);

		// Collect the contents
		String[] fileNames = dialog.getFileNames();
		String filterPath = dialog.getFilterPath();

		ArrayList<File> resources = new ArrayList<File>(fileNames.length);
		for (String relPath : fileNames) {
			File f = new File(filterPath + File.separatorChar + relPath);

			// Add the file to resources. Don't check its validity here
			resources.add(f);
		}

		return resources;
	}

}
