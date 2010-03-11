package com.nokia.tools.s60ct.confml.widgets;
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

import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;

import com.nokia.tools.s60ct.resources.Activator;
import com.nokia.tools.s60ct.resources.model.ELibraryDirectory;
import com.nokia.tools.s60ct.resources.model.ELibraryFile;
import com.nokia.tools.s60ct.resources.model.ELibraryRoot;
import com.nokia.tools.s60ct.resources.views.IResourceLibraryContentProvider;
import com.nokia.tools.s60ct.resources.views.ResourceLibraryContentProvider;
import com.nokia.tools.s60ct.resources.views.ResourceLibraryTableLabelProvider;

/**
 * This dialog is used for browsing files or folders from Resource library
 */
public class ResourcePickDialog extends ElementTreeSelectionDialog {

	public ResourcePickDialog(Shell sh, boolean isFolder, List<String> pattern) {

		super(sh, new ResourceLibraryTableLabelProvider(),
				new ResourceLibraryContentProvider(
						(ELibraryRoot) PlatformUI.getWorkbench()
								.getActiveWorkbenchWindow().getActivePage()
								.getActiveEditor().getAdapter(
										ELibraryRoot.class)));
		// Open a dialog which will pick an item from resource library
		Object adapter = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().getActiveEditor().getAdapter(
						ELibraryRoot.class);
		if (adapter instanceof ELibraryRoot) {
			IResourceLibraryContentProvider lib = new ResourceLibraryContentProvider(
					((ELibraryRoot) adapter));

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
		private List<String> pattern;

		public ResourceValidator(boolean isFolder, List<String> pattern2) {
			this.isFolder = isFolder;
			this.pattern = pattern2;
		}

		public IStatus validate(Object[] selection) {

			if (selection == null || selection.length == 0) {
				return new Status(IStatus.ERROR, Activator.PLUGIN_ID,
						SELECT_ONE_RESOURCE);
			}
			if (selection != null && selection.length > 0) {
				if (selection[0] instanceof ELibraryFile) {
					if (isFolder) {
						return new Status(IStatus.ERROR, Activator.PLUGIN_ID,
								"No folder selected");
					} else {
						ELibraryFile file = (ELibraryFile) selection[0];
						String path = file.getPath();
						if (pattern.size()>0) {
							for (String patternString : pattern) {
								if (Pattern.matches(patternString, path)) {
									return new Status(IStatus.ERROR,
											Activator.PLUGIN_ID,
											"Selected file does not match pattern "
													+ pattern + ".");
								}
							}
						
						}
					}
				}
				if (selection[0] instanceof ELibraryDirectory) {
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
