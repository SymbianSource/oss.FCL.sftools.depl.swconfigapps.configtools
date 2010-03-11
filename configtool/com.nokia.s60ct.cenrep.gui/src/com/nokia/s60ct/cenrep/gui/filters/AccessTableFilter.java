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

import cenrep.Key;

public class AccessTableFilter extends ViewerFilter {
	
	public static final AccessTableFilter INSTANCE = new AccessTableFilter();
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if(element instanceof Key)return false;
		return true;
	}

}
