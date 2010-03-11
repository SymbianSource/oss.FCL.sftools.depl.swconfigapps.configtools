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

package com.nokia.tools.variant.editor.editors;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import com.nokia.tools.variant.editor.model.UIGroup;
/**
 * Filters empty groups
 * 
 */
public class SettingsViewerFilter extends ViewerFilter {

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if (element instanceof UIGroup) {
			UIGroup uiGroup = (UIGroup) element;
			EList<UIGroup> uiGroups = uiGroup.getUiGroups();
			if (uiGroups.size() == 0
					&& uiGroup.getUiSettings().size() == 0) {
				return false;
			}
			if (uiGroups.size() != 0
					&& uiGroup.getUiSettings().size() == 0) {
				for (UIGroup group : uiGroups) {
					if(group.getUiSettings().size()>0){
						return true;
					}
				}
				return false;
			}
		}
		return true;
	}

}
