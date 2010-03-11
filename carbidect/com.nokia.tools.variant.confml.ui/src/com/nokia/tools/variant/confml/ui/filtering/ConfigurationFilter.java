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
package com.nokia.tools.variant.confml.ui.filtering;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.views.navigator.ResourcePatternFilter;

import com.nokia.tools.vct.common.appmodel.EAppFeature;
import com.nokia.tools.vct.common.appmodel.EAppGroup;


public class ConfigurationFilter extends ResourcePatternFilter {

	public ConfigurationFilter() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		// TODO Auto-generated method stub
		if (element instanceof IFile)
		{
			IFile file = (IFile)element;
			String itemName = file.getName().toLowerCase();
			String[] patterns = getPatterns();
			if (patterns.length==0)
				return true;
			if (itemName.indexOf(patterns[0].toLowerCase())!=-1)
				return true;
			else
				return false;
		}
		else if (element instanceof EAppFeature)
		{
			EAppFeature feature = (EAppFeature)element;
			if (feature.getName()==null)
				return false;
			String itemName = feature.getName().toLowerCase();
			String[] patterns = getPatterns();
			if (patterns.length==0)
				return true;
			if (itemName.indexOf(patterns[0].toLowerCase())!=-1)
				return true;
			else
				return false;
		}
		else if (element instanceof EAppGroup)
		{
			EAppGroup group = (EAppGroup)element;
			if (group.getName()==null)
				return false;
			String itemName = group.getName().toLowerCase();
			String[] patterns = getPatterns();
			if (patterns.length==0)
				return true;
			if (itemName.indexOf(patterns[0].toLowerCase())!=-1)
				return true;
			else
			{
				return selectSubGroupsRecursive(group, patterns[0]);
			}
		}
		return true;
	}
	
	private boolean selectSubGroupsRecursive(EAppGroup group, String pattern)
	{
		for (EAppGroup subGroups : group.getGroups())
		{
			if (subGroups.getName()==null)
				continue;
			String itemName = subGroups.getName().toLowerCase();
			if (itemName.indexOf(pattern.toLowerCase())!=-1)
				return true;
			boolean b =  selectSubGroupsRecursive(subGroups, pattern);
			if (b)
				return true;
		}
		return false;
	}

}
