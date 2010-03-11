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
 * Description: This file is part of com.nokia.tools.vct.imaker.core component.
 */

package com.nokia.tools.vct.imaker.core;

import java.io.IOException;
import java.net.URI;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

import com.nokia.tools.vct.internal.imaker.core.ImageMaker;

/**
 * The activator class controls the plug-in life cycle
 */
public class ImakerCore extends Plugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.nokia.tools.variant.imaker.core";

	// The shared instance
	private static ImakerCore plugin;

	/**
	 * The constructor
	 */
	public ImakerCore() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
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
	public static ImakerCore getDefault() {
		return plugin;
	}

	public static IImageMaker getImageMaker(URI drive) throws IOException {
		return ImageMaker.getInstance(drive);
	}

}
