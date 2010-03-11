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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import cenrep.Bit;
import cenrep.Key;
import cenrep.KeyRange;

import com.nokia.s60ct.search.gui.SearchPane;

public class JumpToSetting implements IObjectActionDelegate
{

	protected EObject selectedObject = null;
	private String ref = null;
	
	public JumpToSetting() {
	}

	@Override
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		selectedObject =null;
		ref = null;
		if(selection instanceof IStructuredSelection)
		{
	           IStructuredSelection structedSelection = (IStructuredSelection)selection;
	           if(structedSelection.size()>0)
	           {
	        	   selectedObject=(EObject)structedSelection.getFirstElement();
	           }
	    }
		if(selectedObject!=null)
		{
			if (selectedObject instanceof Key)
			{
				Key key = (Key)selectedObject;
				ref = key.getRef();
				if (key.isBitmaskKey())
					ref = null;
			}
			else if (selectedObject instanceof Bit)
			{
				Bit bit = (Bit)selectedObject;
				ref = bit.getRef();
			}
			else if (selectedObject instanceof KeyRange)
			{
				KeyRange keyRange = (KeyRange)selectedObject;
				ref = keyRange.getRef();
			}
			
			if (ref!=null)
				action.setEnabled(true);
			else
				action.setEnabled(false);
			
		}
		else 
			action.setEnabled(false);
		
	}

	@Override
	public void run(IAction action) {

		if (ref.indexOf("/")!=-1)
			ref = ref.split("/")[1];
		SearchPane.getSearchPane().searchRef(ref, true);
	}
	
}


