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
package com.nokia.s60ct.gui;

import org.eclipse.core.runtime.IPlatformRunnable;
import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;

import com.nokia.s60ct.gui.plugin.PluginManager;

import constants.IS60CTCommonConstants;

/**
 * This class controls all aspects of the application's execution
 */
public class Application implements IPlatformRunnable {

	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.IPlatformRunnable#run(java.lang.Object)
	 */
	  
	public static IEclipsePreferences S60Ct_Pref=null;
	
	public Object run(Object args) throws Exception {
		S60Ct_Pref = new ConfigurationScope().getNode(IS60CTCommonConstants.S60_PREFERENCES);
		for(int i=0;i<PluginManager.INSTANCE.getPluginInitializers().length;i++)
			PluginManager.INSTANCE.getPluginInitializers()[i].init();
		
		Display display = PlatformUI.createDisplay();
		try {
			int returnCode = PlatformUI.createAndRunWorkbench(display, new ApplicationWorkbenchAdvisor());
			if (returnCode == PlatformUI.RETURN_RESTART) {
				return IPlatformRunnable.EXIT_RESTART;
			}
				
			return IPlatformRunnable.EXIT_OK;
		} finally {
			display.dispose();
		}
	}
	
	
	
}
