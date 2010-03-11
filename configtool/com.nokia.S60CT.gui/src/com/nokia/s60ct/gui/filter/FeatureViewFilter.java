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

package com.nokia.s60ct.gui.filter;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import configurationemf.Desc;
import configurationemf.RootConf;
import configurationemf.Setting;

public class FeatureViewFilter extends ViewerFilter {
	
	public static final FeatureViewFilter INSTANCE = new FeatureViewFilter();
	
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		
		if (element instanceof Desc) {
			return false;
		}
		return true;
	}

	public Object[] filter(Viewer viewer, Object parent, Object[] elements) {
		if(parent instanceof ResourceSet){
			List list = new ArrayList();
			for(int i=0;i<elements.length;i++){
				Resource resource = (Resource)elements[i];
				if (resource != null && resource.getContents().size()>0){
					RootConf rc=(RootConf)resource.getContents().get(0);
					if(rc.getRoot()==null)list.add(rc);
				}
			}
			return list.toArray();
		}else if(parent instanceof Setting)
			return new Object[0];
		else 
			return super.filter(viewer, parent, elements);
	}

	public Object[] filter(Viewer viewer, TreePath parentPath, Object[] elements) {
		return super.filter(viewer, parentPath, elements);
	}

	public boolean isFilterProperty(Object element, String property) {
		return super.isFilterProperty(element, property);
	}
	
}
