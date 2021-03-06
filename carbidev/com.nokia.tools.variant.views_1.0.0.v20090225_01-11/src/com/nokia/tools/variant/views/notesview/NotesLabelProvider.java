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
 * Description: This file is part of com.nokia.tools.variant.views component.
 */

package com.nokia.tools.variant.views.notesview;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

import com.nokia.tools.variant.content.confml.LeafGroup;
import com.nokia.tools.variant.content.confml.ParentGroup;
import com.nokia.tools.variant.content.confml.Setting;

public class NotesLabelProvider implements ITableLabelProvider {

	public Image getColumnImage(Object element, int columnIndex) {
		
		return null;
	}

	public String getColumnText(Object element, int columnIndex) {
		Setting setting = (Setting) element;
		switch (columnIndex) {
		case 0:
			return setting.getName();
		case 1:
			return setting.getNote().replaceAll("\t|\r|\n|\f", " ");
		case 2:
			String location = "";
			if (setting.getLeafGroup().size() > 0) {
				LeafGroup leafGroup = setting.getLeafGroup().get(0);
				EObject container = leafGroup.eContainer();
				if (container instanceof ParentGroup) {
					ParentGroup parentGroup = (ParentGroup) container;
					location = parentGroup.getName() + " - "
							+ leafGroup.getName();
				}
			} else if (setting.getParentGroup().size() > 0) {
				ParentGroup parentGroup = setting.getParentGroup().get(0);
				location = parentGroup.getName();
			}
			return location;
		}
		return null;
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
