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

package com.nokia.s60ct.gui.actions;

import java.util.List;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.events.SelectionEvent;

import configurationemf.Frame;
import configurationemf.ParentSetting;

public class MoveDownFrameAction extends MoveFrameAction 
{
	public void selectionChanged(IAction action, ISelection selection) 
	{
		selectedObjects.clear();
		if(selection instanceof IStructuredSelection)
		{
           IStructuredSelection structedSelection = (IStructuredSelection)selection;
           Object[] objects = structedSelection.toArray();
           if (objects.length != 0)
           {
	           Frame frame = (Frame)objects[0];
	           
	           if (frame.isTemplate())
	           {
	        	   action.setEnabled(false);
	           }
	           else
	           {
	        	   this.frame = frame;
	        	   ParentSetting parentSetting = (ParentSetting) frame.eContainer();
	        	  
	        	   List myFrames = parentSetting.getMyCurrentFrames();
	        	  
	        	   for (int i = 0 ; i < myFrames.size()-1 ; i++)
	        	   {
	        		   if (frame.equals(myFrames.get(i)))
	        		   {
	        			   action.setEnabled(true);
	        			   return;
	        		   }
	        	   }
	        	   action.setEnabled(false);
	           }
           }
	    }
	}
		
		public void widgetSelected(SelectionEvent e)
		{
			this.move(false);
		}
		
		
}
