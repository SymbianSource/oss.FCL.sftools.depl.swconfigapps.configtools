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
package com.nokia.tools.s60ct.javaversionchecker;

import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.progress.UIJob;

import com.nokia.tools.s60ct.javaversionchecker.ui.ShowDialogJob;

/**
 * 
 */
public class JavaVersionCheckerStartup implements IStartup {
	

	
	/**
	 * Called at startup. Logs environment and shows jre version warning if not disabled in plugin preferences.
	 * @see IStartup
	 */
	public void earlyStartup() {
		EnviromentLogger.logEnvironment();
		
		if (isDialogEnabled() && !JavaVersionChecker.isCurrentJreSupported()){
			showDialog();	
		}
	}

	/**
	 * Show warning dialog.
	 */
	private void showDialog() {
		UIJob job;
		ILog logger;
		Status status; 
		
		try {
			job = new ShowDialogJob("ShowWarningDialog");
			job.setSystem(true);
			job.schedule();
		} catch (Exception e) {
			logger = Activator.getDefault().getLog();
			status = new Status(IStatus.WARNING, Activator.PLUGIN_ID, e.getMessage());
			logger.log(status);
		}
	}
	
	/**
	 * Checks from configuration is showing of dialog disabled.
	 * 
	 * @return returns true if showing dialog is disabled in configuration
	 */
	public boolean isDialogEnabled(){
		boolean ret;

		if (Activator.getDefault().getPluginPreferences().contains(PreferenceConstants.P_DISABLE_JDK_WARNING) && 
				Activator.getDefault().getPluginPreferences().getBoolean(PreferenceConstants.P_DISABLE_JDK_WARNING)){
			ret = false;
		}else{
			ret= true;
		}
		
		return ret;
	}
	

}
