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

package com.nokia.tools.variant.resourcelibrary.views;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.Viewer;

import com.nokia.tools.variant.resourcelibrary.model.Directory;
import com.nokia.tools.variant.resourcelibrary.model.ResourceModelRoot;

public class ResourceLibraryContentProvider implements
		IResourceLibraryContentProvider {

	public ResourceLibraryContentProvider(ResourceModelRoot resorceModelRoot) {
	}

	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	public void dispose() {
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}

	public Object[] getChildren(Object parent) {
		if (parent instanceof Directory) {
			Directory dir = (Directory) parent;
			return dir.getChildren().toArray();
		}
		return new Object[0];
	}

	public Object getParent(Object element) {
		if (element instanceof ResourceModelRoot) {
			return null;
		} else if (element instanceof EObject) {
			return ((EObject)element).eContainer();
		}
		return null;
	}

	public boolean hasChildren(Object element) {
		Object[] children = getChildren(element);
		return children.length > 0;
	}

}
