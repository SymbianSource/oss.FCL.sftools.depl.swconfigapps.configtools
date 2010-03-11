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

import java.util.regex.Pattern;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;

import com.nokia.tools.variant.resourcelibrary.Activator;
import com.nokia.tools.variant.resourcelibrary.model.Directory;
import com.nokia.tools.variant.resourcelibrary.model.File;
import com.nokia.tools.variant.resourcelibrary.model.ResourceModelRoot;
import com.nokia.tools.variant.resourcelibrary.views.IResourceLibraryContentProvider;
import com.nokia.tools.variant.resourcelibrary.views.ResourceLibraryContentProvider;
import com.nokia.tools.variant.resourcelibrary.views.ResourceLibraryTableLabelProvider;

/**
 * This dialog is used for browsing files or folders from Resource library
 */
public class ResourcePickDialog extends ElementTreeSelectionDialog {

	public ResourcePickDialog(Shell sh, boolean isFolder, String pattern) {

		super(sh, new ResourceLibraryTableLabelProvider(),
				new ResourceLibraryContentProvider(
						(ResourceModelRoot) PlatformUI.getWorkbench()
								.getActiveWorkbenchWindow().getActivePage()
								.getActiveEditor().getAdapter(
										ResourceModelRoot.class)));
		// Open a dialog which will pick an item from resource library
		Object adapter = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().getActiveEditor().getAdapter(
						ResourceModelRoot.class);
		if (adapter instanceof ResourceModelRoot) {
			IResourceLibraryContentProvider lib = new ResourceLibraryContentProvider(
					((ResourceModelRoot) adapter));

			// IResourceLibraryContentProvider lib =
			// (IResourceLibraryContentProvider)
			// PlatformUI.getWorkbench().getActiveWorkbenchWindow()
			// .getActivePage().getActiveEditor()
			// .getAdapter(IResourceLibraryContentProvider.class);

			setEmptyListMessage("No resources found for selecting");
			setAllowMultiple(false);

			if (isFolder) {
				setMessage("Pick a folder to utilize for this setting.");
			} else {
				setMessage("Pick a resource to utilize for this setting.");
			}
			setTitle("Select resource");
			setInput(adapter);
			setValidator(new ResourceValidator(isFolder, pattern));
			// setComparator(new
			// SimpleResourceComparator(this.getTreeViewer()));
		}
	}

	// class ResourceFilter extends ViewerFilter {
	//
	// @Override
	// public boolean select(Viewer viewer, Object parentElement,
	// Object element) {
	// IResource res = (IResource) element;
	//
	// return res.getType() == IResource.FILE;
	// }
	// }

	class ResourceValidator implements ISelectionStatusValidator {

		private static final String SELECT_ONE_RESOURCE = "No resources or folders selected.";
		private static final String SELECT_FILE_RESOURCE = "Only resource selection is permitted.";
		private static final String SELECT_FOLDER_RESOURCE = "Only folder selection is permitted.";
		private static final String SELECT_OK = "";

		private boolean isFolder;
		private String pattern;

		public ResourceValidator(boolean isFolder, String pattern) {
			this.isFolder = isFolder;
			this.pattern = pattern;
		}

		public IStatus validate(Object[] selection) {

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
						String path = file.getPath();
						if (pattern != "") {
							if (Pattern.matches(pattern, path)) {
								return new Status(IStatus.ERROR,
										Activator.PLUGIN_ID,
										"Selected file does not match pattern "
												+ pattern + ".");
							}
						}
					}
				}
				if (selection[0] instanceof Directory) {
					if (!isFolder) {
						return new Status(IStatus.ERROR, Activator.PLUGIN_ID,
								"No file selected");
					}
				}
			}
			return new Status(IStatus.OK, Activator.PLUGIN_ID, SELECT_OK);

			// Allow only single selection
			// IResource res = (IResource) selection[0];
			// int type = res.getType();
			//
			// if (isFolder) {
			// if (type == IResource.FOLDER)
			// return new Status(IStatus.OK, Activator.PLUGIN_ID,
			// SELECT_OK);
			// return new Status(IStatus.ERROR, Activator.PLUGIN_ID,
			// SELECT_FOLDER_RESOURCE);
			//
			// } else {
			// if (type == IResource.FILE)
			// return new Status(IStatus.OK, Activator.PLUGIN_ID,
			// SELECT_OK);
			// return new Status(IStatus.ERROR, Activator.PLUGIN_ID,
			// SELECT_FILE_RESOURCE);
			// }
		}
	}

}
