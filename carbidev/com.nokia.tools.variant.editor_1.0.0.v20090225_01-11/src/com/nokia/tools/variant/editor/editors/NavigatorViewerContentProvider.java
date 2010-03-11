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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import com.nokia.tools.variant.content.confml.LeafGroup;
import com.nokia.tools.variant.content.confml.ParentGroup;
import com.nokia.tools.variant.content.confml.Setting;
import com.nokia.tools.variant.content.confml.View;
import com.nokia.tools.variant.editor.summary.SummaryParentGroup;


public class NavigatorViewerContentProvider  implements
ITreeContentProvider{
	public void dispose() {

	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

	}

	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof ParentGroup) {
			EList<LeafGroup> leafGroups = ((ParentGroup) parentElement).getLeafGroup();
			if (parentElement instanceof SummaryParentGroup) {
				return leafGroups.toArray();
			}
			List<LeafGroup> filteredGroups = filterLeafGroups(leafGroups);
			return filteredGroups.toArray();
		}
		 return new Object[0];
	}

	/**
	 * Remove groups which contain only readOnly settings.
	 * @param leafGroups list of LeafGroups to filter
	 * @return list of groups which has at least one setting to display
	 */
	private List<LeafGroup> filterLeafGroups(EList<LeafGroup> leafGroups) {
		List<LeafGroup> filteredGroups = new ArrayList<LeafGroup>();
		
		for (int i = 0 ; i < leafGroups.size() ; i++) {
			LeafGroup lg = leafGroups.get(i);
			EList<Setting> settings = lg.getSettings();
			
			boolean visible = false;
			for (int j = 0 ; j < settings.size() ; j++) {
				if (settings.get(j).isVisible()) {
					visible = true;
				}
			}
			if (visible) {
				filteredGroups.add(lg);
			}
		}
		
		return filteredGroups;
	}

	public Object getParent(Object element) {

		return null;
	}

	public boolean hasChildren(Object element) {
		if (getChildren(element).length > 0) {
			return true;
		}
		return false;
	}

	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof View) {
			return ((View) inputElement).getParentGroup().toArray();
		}
		 return new Object[0];
	}

}
