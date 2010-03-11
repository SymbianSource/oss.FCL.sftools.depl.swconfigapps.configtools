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

package com.nokia.tools.variant.confml.ui.dialogs;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;

import com.nokia.tools.variant.confml.ui.editors.ConfmlMetadataEditor;

/**
 * Content provider for {@link ElementTreeSelectionDialog} used in
 * {@link ConfmlMetadataEditor}.
 * 
 */
public class FileSelectionContentProvider implements ITreeContentProvider {

	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof IFile)
			return null;
		if (parentElement instanceof IContainer) {
			try {
				return ((IContainer) parentElement).members();
			} catch (CoreException e) {
				
				e.printStackTrace();
			}
		}
		return null;
	}

	public Object getParent(Object element) {
		return ((IFile) element).getParent();
	}

	public boolean hasChildren(Object element) {
		Object[] obj = getChildren(element);
		return obj == null ? false : obj.length > 0;
	}

	public Object[] getElements(Object inputElement) {
		IResource[] members = null;
		try {
			members = ((IProject) inputElement).members();
		} catch (CoreException e) {
			
			e.printStackTrace();
		}
		return members;
	}

	public void dispose() {
		

	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}

}
