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

package com.nokia.tools.s60ct.resources.handlers;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import com.nokia.tools.s60ct.resources.model.ELibraryDirectory;
import com.nokia.tools.s60ct.resources.model.ELibraryElement;
import com.nokia.tools.s60ct.resources.views.ResourceStorage;
import com.nokia.tools.vct.common.appmodel.EConfigurationProject;

public class ResourceTester extends PropertyTester {
	private static final String HAS_ROOTS = "hasRoots";
	private static final String IS_ROOT = "isRoot";
	private static final String IS_READONLY = "isReadOnly";
	private static final String IS_FOLDER = "isFolder";	

	public boolean test(Object receiver, String property, Object[] args,
			Object expectedValue) {
		if (receiver == null)
			return false;

		// Check that we've got valid configuration project and that it
		// contains valid resource roots
		if (PlatformUI.getWorkbench() == null)
			return false;
		if (PlatformUI.getWorkbench().getActiveWorkbenchWindow() == null)
			return false;
		if (PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().getActiveEditor() == null)
			return false;

		IWorkbenchPage page = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage();
		if (page == null) {
			return false;
		}

		IEditorPart editor = page.getActiveEditor();
		if (editor == null) {
			return false;
		}

		EConfigurationProject configurationProject = (EConfigurationProject) editor
				.getAdapter(EConfigurationProject.class);

		if (IS_ROOT.equals(property)) {
			if (configurationProject == null)
				return false;
			ResourceSet rs = configurationProject.eResource().getResourceSet();
			if (rs == null || rs.getResources().isEmpty())
				return false;

			return expectedValue.equals(rs.getResources().contains(receiver));

		} else if (HAS_ROOTS.equals(property)) {
			ResourceSet roots = configurationProject.eResource().getResourceSet();
			return expectedValue.equals(roots != null && roots.getResources().size() > 0);
		} else if (IS_READONLY.equals(property)) {
			if (receiver instanceof ResourceStorage){
				ResourceStorage rs = (ResourceStorage) receiver;
				boolean readOnly = rs.isReadOnly();
				if (readOnly) {
					return true;
				} else {
					ELibraryElement fse = rs.getFileSystemElement();
					return fse.touchedByReadonlySetting();
				}
			}
		} else if (IS_FOLDER.equals(property)) {
			if (receiver instanceof ResourceStorage){
				ResourceStorage rs = (ResourceStorage) receiver;
				return rs.getFileSystemElement() instanceof ELibraryDirectory;
			}
		}

		return false;
	}
}
