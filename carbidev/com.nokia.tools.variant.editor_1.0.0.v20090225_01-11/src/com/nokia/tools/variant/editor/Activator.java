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
 * Description: This file is part of com.nokia.tools.variant.editor component.
 */

package com.nokia.tools.variant.editor;

import org.eclipse.jface.resource.FontRegistry;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.nokia.tools.variant.common.ui.utils.SWTUtil;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.nokia.tools.variant.editor";

	// The shared instance
	private static Activator plugin;
	
	private FontRegistry fonts;
	private Font BOLD_FONT;
	private Font DEFAULT_FONT;

	public static Font getBoldFont() {
		return plugin.BOLD_FONT;
	}
	
	public static Font getDefaultFont() {
		return plugin.DEFAULT_FONT;
	}
	
	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		Display d = SWTUtil.getStandardDisplay();
		d.syncExec(new Runnable() {
			public void run() {
				fonts = new FontRegistry(SWTUtil.getStandardDisplay());
				DEFAULT_FONT = fonts.defaultFont();
				BOLD_FONT = fonts.getBold("bold");
			}
		});
		
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		Display d = SWTUtil.getStandardDisplay();
		d.syncExec(new Runnable() {
			public void run() {
				BOLD_FONT.dispose();
				DEFAULT_FONT.dispose();
				BOLD_FONT = null;
				DEFAULT_FONT = null;
			}
		});
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given
	 * plug-in relative path
	 *
	 * @param path the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}
	
}
