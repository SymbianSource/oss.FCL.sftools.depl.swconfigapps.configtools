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

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import release.Release;
import configurationemf.Desc;
import configurationemf.Option;
import configurationemf.ReleaseAttr;

public class SettingEditorFilter extends ViewerFilter {
	public static SettingEditorFilter INSTANCE = new SettingEditorFilter();
	
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if(element instanceof Option)return false;
		else if(element instanceof Desc)return false;
		else if(element instanceof ReleaseAttr){
			String firstRelease = null;
			String lastRelease = null;
			firstRelease = ((ReleaseAttr)element).getFirstRelease();
			lastRelease = ((ReleaseAttr)element).getLastRelease();
			if(firstRelease!=null)
				return Release.inRelease(firstRelease, lastRelease);
		}
		return true;
	}

}
