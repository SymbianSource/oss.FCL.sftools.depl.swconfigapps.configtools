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
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;

import com.nokia.tools.variant.confml.ui.editors.ConfmlMetadataEditor;

/**
 * Label provider for {@link ElementTreeSelectionDialog} used in
 * {@link ConfmlMetadataEditor}.
 * 
 */
public class FileSelectionLabelProvider implements ILabelProvider {

	public Image getImage(Object element) {
		if (element instanceof IFile) {
			return PlatformUI.getWorkbench().getSharedImages().getImage(
					ISharedImages.IMG_OBJ_FILE);
		}
		if (element instanceof IContainer) {

			return PlatformUI.getWorkbench().getSharedImages().getImage(
					ISharedImages.IMG_OBJ_FOLDER);
		}
		return null;
	}

	public String getText(Object element) {

		String name = ((IResource) element).getName();

		if (name.trim().equals(""))
			return "Undefined";

		return name;
	}

	public void addListener(ILabelProviderListener listener) {
		

	}

	public void dispose() {
		

	}

	public boolean isLabelProperty(Object element, String property) {
		
		return false;
	}

	public void removeListener(ILabelProviderListener listener) {
		

	}

}
