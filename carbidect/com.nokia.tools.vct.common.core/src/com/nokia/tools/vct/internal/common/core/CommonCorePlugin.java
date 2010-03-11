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
package com.nokia.tools.vct.internal.common.core;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleContext;

public class CommonCorePlugin extends Plugin {

	public static final String PLUGIN_ID = "com.nokia.tools.vct.common.core";
	static CommonCorePlugin instance;

	public CommonCorePlugin() {
		super();
	}
	
	public static CommonCorePlugin getInstance() {
		return instance;
	}

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		instance = this;
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
		instance = null;
	}

	public static void logWarning(String message, Throwable cause) {
		log(IStatus.WARNING, message, cause);
	}

	public static void logError(String message, Throwable cause) {
		log(IStatus.ERROR, message, cause);
	}

	public static void log(int status, String message, Throwable cause) {
		instance.getLog().log(new Status(status, PLUGIN_ID, message, cause));
	}
}
