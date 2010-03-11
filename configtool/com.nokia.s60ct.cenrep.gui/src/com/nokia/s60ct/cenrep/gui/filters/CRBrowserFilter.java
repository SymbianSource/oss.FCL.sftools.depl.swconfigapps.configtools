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

package com.nokia.s60ct.cenrep.gui.filters;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import release.Release;
import cenrep.Access;
import cenrep.ReleaseAttrs;
import cenrep.Value;

public class CRBrowserFilter extends ViewerFilter {
	public static final CRBrowserFilter INSTANCE = new CRBrowserFilter();
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		
		if(element instanceof Access) return false;
		else if(element instanceof Value) return false;
		if(element instanceof ReleaseAttrs){
			String firstRelease = ((ReleaseAttrs)element).getFirstRelease();
			String lastRelease = ((ReleaseAttrs)element).getLastRelease();
			return Release.inRelease(firstRelease, lastRelease);
		}
		return true;
	}

}
