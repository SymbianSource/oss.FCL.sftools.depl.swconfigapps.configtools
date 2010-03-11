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
package com.nokia.tools.vct.navigator.sign;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

import com.nokia.tools.vct.common.core.utils.FileUtils;
import com.nokia.tools.vct.common.ui.utils.SWTUtil;

public class SigningUIPlugin extends AbstractUIPlugin {

	static SigningUIPlugin instance;
	
	public SigningUIPlugin() {
		// IMPROVEMENT Auto-generated constructor stub
	}

	
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		instance = this;
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		instance = null;
		super.stop(context);
	}
	

	/**
	 * Get shared image from plugin registry
	 * 
	 * @param key
	 *            Image key
	 * 
	 * @return Image or <code>null</code>
	 * 
	 * @see IConfmlImages
	 */
	public static Image getImage(String key) {
		return instance.getImageRegistry().get(key);
	}

	/**
	 * Get shared image descriptor from plugin registry
	 * 
	 * @param key
	 *            Image key
	 * @return Image descriptor or <code>null</code>
	 * 
	 * @see IConfmlImages
	 */
	public static ImageDescriptor getImageDescriptor(String key) {
		return instance.getImageRegistry().getDescriptor(key);
	}

	/**
	 * Populate registry with images
	 */
	@Override
	protected void initializeImageRegistry(ImageRegistry reg) {
		super.initializeImageRegistry(reg);

		registerImage(reg, ISiginginUIPluginImages.CONFML_LAYER);
		registerImage(reg, ISiginginUIPluginImages.CONFML_PROJECT);
	}
	

	/**
	 * Register single image inside the image registry.
	 * 
	 * @param reg
	 *            Image registry to use
	 * @param key
	 *            Image path (can contain substitution elements)
	 * 
	 * @see FileLocator#openStream(Bundle, IPath, boolean)
	 */
	private void registerImage(ImageRegistry reg, String key) {
		InputStream is;
		try {
			is = new BufferedInputStream(FileLocator.openStream(getBundle(),
					new Path(key), true));
		} catch (IOException e) {
			getLog().log(
					new Status(IStatus.WARNING, getBundle().getSymbolicName(),
							"Failed to load image for key '" + key + "'", e));
			return;
		}
		try {
			Image image = new Image(SWTUtil.getStandardDisplay(), is);
			reg.put(key, image);
		} finally {
			FileUtils.closeStream(is);
		}
	}
}
