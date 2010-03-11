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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import com.nokia.tools.vct.common.appmodel.EConfMLLayer;

/**
 * This class provides the content for the tree in FileTree
 */

public class IconSelectionContentProvider implements ITreeContentProvider {
	/** Root container for image selection */
	private EConfMLLayer input;

	public Object[] getChildren(final Object element) {
		if (element instanceof EConfMLLayer) {
			EConfMLLayer layer = (EConfMLLayer) element;

			List<URI> uris = new ArrayList<URI>();

			for (URI uri : layer.getDocumentMap().keySet()) {
				String ext = uri.fileExtension();
				if (ext != null
						&& (ext.equalsIgnoreCase("jpg")
								|| ext.equalsIgnoreCase("jpe")
								|| ext.equalsIgnoreCase("jpeg")
								|| ext.equalsIgnoreCase("png")
								|| ext.equalsIgnoreCase("gif") || ext
								.equalsIgnoreCase("bmp"))) {
					uris.add(uri);
				}
			}
			return uris.toArray();
		}

		return new Object[0]; 
	}

	public Object getParent(Object child) {
		if (child instanceof EConfMLLayer) {
			return null;
		} else if (child instanceof URI) {
			return input;
		} else {
			return null;
		}
	}

	public boolean hasChildren(Object element) {
		Object[] obj = getChildren(element);
		return obj.length > 0;
	}

	public Object[] getElements(Object element) {
		return getChildren(element);
	}

	public void dispose() {
	}

	public void inputChanged(Viewer arg0, Object arg1, Object newInput) {
		input = (EConfMLLayer) newInput;
	}
}
