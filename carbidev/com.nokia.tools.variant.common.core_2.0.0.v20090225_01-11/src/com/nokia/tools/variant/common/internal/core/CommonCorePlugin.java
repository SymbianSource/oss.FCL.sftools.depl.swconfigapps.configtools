/*
 * Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies). 
 * All rights reserved.
 * This component and the accompanying materials are made available
 * under the terms of the License "Symbian Foundation License v1.0"
 * which accompanies this distribution, and is available
 * at the URL "http://www.symbianfoundation.org/legal/sfl-v10.html".
 * 
 * Initial Contributors:
 * Nokia Corporation - Initial contribution
 * 
 * Contributors:
 * 
 * Description: This file is part of com.nokia.tools.variant.common.core component.
 */

package com.nokia.tools.variant.common.internal.core;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleContext;

public class CommonCorePlugin extends Plugin {

	public static final String PLUGIN_ID = "com.nokia.tools.variant.common.core";
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
