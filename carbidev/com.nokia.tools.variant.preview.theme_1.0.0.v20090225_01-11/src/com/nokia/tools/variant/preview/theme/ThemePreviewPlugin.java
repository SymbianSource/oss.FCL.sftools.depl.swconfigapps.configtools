/*
 * Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies). 
 * All rights reserved.
 * This component and the accompanying materials are made available
 * under the terms of "Eclipse Public License v1.0"
 * which accompanies this distribution, and is available
 * at the URL "http://www.eclipse.org/legal/epl-v10.html".
 * 
 * Initial Contributors:
 * Nokia Corporation - Initial contribution
 * 
 * Contributors:
 * 
 * Description: This file is part of com.nokia.tools.variant.preview.theme component.
 */

package com.nokia.tools.variant.preview.theme;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class ThemePreviewPlugin extends AbstractUIPlugin {

	public static final String PLUGIN_ID = "com.nokia.tools.variant.preview.theme";

	private static ThemePreviewPlugin plugin;

	public ThemePreviewPlugin() {
		// default
	}
	
	/**
	 * Returns the shared instance.
	 */
	public static ThemePreviewPlugin getDefault() {
		return plugin;
	}


	public static void logError(String message, Throwable cause) {
		plugin.getLog().log(
				new Status(IStatus.ERROR, PLUGIN_ID, message, cause));
	}

	@Override
	public void start(BundleContext context) throws Exception {
		plugin = this;
		super.start(context);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
		plugin = null;
	}
}
