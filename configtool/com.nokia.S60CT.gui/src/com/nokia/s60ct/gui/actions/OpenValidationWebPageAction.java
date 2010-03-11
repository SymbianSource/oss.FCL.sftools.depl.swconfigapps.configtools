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

import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.osgi.service.prefs.Preferences;

import constants.IS60CTCommonConstants;

public class OpenValidationWebPageAction implements IViewActionDelegate {

	Object selectedObject = null;
	private static final String VALIDATION_NODE="VALIDATION";
	private static final String VALIDATION_URL="URL";
	private String webPageURL=null;
	
	@Override
	public void init(IViewPart view) {

	}

	@Override
	public void run(IAction action) {
		if (getValidationWebPageURL()!= null)
			OpenValidationWebPage.openPage(selectedObject, getValidationWebPageURL());

	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		if(selection instanceof IStructuredSelection) {
	           IStructuredSelection structedSelection = (IStructuredSelection)selection;
	           Object[] objects = structedSelection.toArray();
	           if (objects.length == 1 && getValidationWebPageURL()!= null)
	           {
	        	   selectedObject = objects[0];
	        	   action.setEnabled(true);
	           }
	           else
	        	   action.setEnabled(false);
	    }
	}
	
	private String getValidationWebPageURL(){
		if(webPageURL==null){
			IEclipsePreferences ePref= new ConfigurationScope().getNode(IS60CTCommonConstants.S60_PREFERENCES);
			Preferences pref=ePref.node(VALIDATION_NODE);
			webPageURL = pref.get(VALIDATION_URL, null);
		}
		return webPageURL;
	}
	
}
