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

package com.nokia.tools.vct.internal.common.appmodel;

import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleContext;

/**
 * The ConfML core plugin.
 * 
 * This class also provides functions to access ConfML models.
 */
public class AppModelPlugin extends Plugin {

	public static final String CONFML_CONTENT_ID = "com.nokia.tools.vct.content.confml";

	// The plug-in ID
	public static final String PLUGIN_ID = "com.nokia.tools.vct.common.appmodel";

	public static final String CONFML_NATURE_ID = PLUGIN_ID
			+ ".ConfMLLayerNature";

	// The shared instance
	private static AppModelPlugin plugin;


	/**
	 * The constructor
	 */
	public AppModelPlugin() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static AppModelPlugin getDefault() {
		return plugin;
	}

	/**
	 * Log warning message
	 * 
	 * @param message
	 *            Message text
	 * @param cause
	 *            Message cause
	 */
	public static void logWarning(String message, Throwable cause) {
		log(IStatus.WARNING, message, cause);
	}

	/**
	 * Log message
	 * 
	 * @param severity
	 *            Severity to use.
	 * @param message
	 *            Message text
	 * @param cause
	 *            Message cause
	 * 
	 * @see IStatus
	 * @see ILog
	 */
	public static void log(int severity, String message, Throwable cause) {
		getDefault().getLog().log(
				new Status(severity, PLUGIN_ID, message, cause));
	}
}
