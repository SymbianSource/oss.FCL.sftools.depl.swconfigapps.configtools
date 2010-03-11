/*
* Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies). 
* All rights reserved.
* This component and the accompanying materials are made available
* under the terms of "Eclipse Public License v1.0"
* which accompanies this distribution, and is available
* at the URL "http://www.eclipse.org/legal/epl-v10.html".
*
* Initial Contributors:
* Nokia Corporation - initial contribution.
*
* Contributors:
*
* Description:
*
*/
package com.nokia.s60ct.gui.sorter;

import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreePathViewerSorter;
import org.eclipse.jface.viewers.Viewer;

public class FeatureViewerSorter extends TreePathViewerSorter {

	public int category(TreePath parentPath, Object element) {

		return super.category(parentPath, element);
	}

	public int compare(Viewer viewer, TreePath parentPath, Object e1, Object e2) {

		return super.compare(viewer, parentPath, e1, e2);
	}

	public boolean isSorterProperty(TreePath parentPath, Object element, String property) {

		return super.isSorterProperty(parentPath, element, property);
	}

	public void sort(Viewer viewer, TreePath parentPath, Object[] elements) {

		super.sort(viewer, parentPath, elements);
	}

}
