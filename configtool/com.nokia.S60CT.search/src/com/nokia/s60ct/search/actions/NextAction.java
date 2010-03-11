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
package com.nokia.s60ct.search.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

import com.nokia.s60ct.search.gui.SearchPane;

public class NextAction implements IWorkbenchWindowActionDelegate {

	private static IAction action = null;
	
	@Override
	public void dispose() {
		
	}

	@Override
	public void init(IWorkbenchWindow window) {
		
	}

	@Override
	public void run(IAction action) {
		SearchPane.getSearchPane().getControl().setFocus(); 
		SearchPane.getSearchPane().nextVisibleEObject();
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		this.action = action;
	}

	public static void setEnabled(boolean enabled)
	{
		if (action != null)
			action.setEnabled(enabled);
	}

}
