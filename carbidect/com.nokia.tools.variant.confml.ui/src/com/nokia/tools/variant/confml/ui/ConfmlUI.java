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
 * Description: This file is part of com.nokia.tools.variant.confml.ui component.
 */

package com.nokia.tools.variant.confml.ui;

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

/**
 * ConfML UI Plugin / Activator
 * 
 */
public class ConfmlUI extends AbstractUIPlugin {

	public static final String PLUGIN_ID = "com.nokia.tools.variant.confml.ui";
	public static final String VIEW_EDITOR_ID = "com.nokia.tools.variant.editor.ViewEditor";

	static ConfmlUI instance;

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

	public static ConfmlUI getInstance() {
		return instance;
	}

	public static void logWarning(Throwable cause) {
		log(IStatus.WARNING, "Internal error", cause);
	}

	public static void log(int status, String message, Throwable cause) {
		instance.getLog().log(new Status(status, PLUGIN_ID, message, cause));
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

		registerImage(reg, IConfmlImages.DEC_INHERITED);
		registerImage(reg, IConfmlImages.DEC_ALERT);
		registerImage(reg, IConfmlImages.DEC_ERROR);

		registerImage(reg, IConfmlImages.EDI_FEATURE);
		registerImage(reg, IConfmlImages.EDI_GROUP);
		registerImage(reg, IConfmlImages.EDI_SETTING);
		registerImage(reg, IConfmlImages.EDI_VIEW);

		registerImage(reg, IConfmlImages.FIL_CONFML);
		registerImage(reg, IConfmlImages.FIL_IMAGE);
		registerImage(reg, IConfmlImages.FIL_IMPLML);
		registerImage(reg, IConfmlImages.FIL_XML);

		registerImage(reg, IConfmlImages.FLD_CONFML);
		registerImage(reg, IConfmlImages.FLD_CONTENT);
		registerImage(reg, IConfmlImages.FLD_FEATURESET);
		registerImage(reg, IConfmlImages.FLD_IMPLML);
		registerImage(reg, IConfmlImages.FLD_NOTES);
		registerImage(reg, IConfmlImages.FLD_PARENTS);
		registerImage(reg, IConfmlImages.FLD_PROJECT);
		registerImage(reg, IConfmlImages.FLD_LAYER);
		registerImage(reg, IConfmlImages.FLD_RESOURCES);
		registerImage(reg, IConfmlImages.FLD_VIEWSET);
		
		registerImage(reg, IConfmlImages.ICO_CLEAR);
		registerImage(reg, IConfmlImages.ICO_CLEAR_DIS);
		registerImage(reg, IConfmlImages.ICO_COLLAPSEALL);
		registerImage(reg, IConfmlImages.ICO_EXPANDALL);
		registerImage(reg, IConfmlImages.ICO_FILTER);
		registerImage(reg, IConfmlImages.ICO_SYNC);

		registerImage(reg, IConfmlImages.RFS_FEATURE);
		registerImage(reg, IConfmlImages.RFS_SETTING);

		registerImage(reg, IConfmlImages.DAT_FEATURE);
		registerImage(reg, IConfmlImages.DAT_SETTING);
		
		registerImage(reg, IConfmlImages.TYP_FEATURE);
		registerImage(reg, IConfmlImages.TYP_SETTING);

		registerImage(reg, IConfmlImages.TAB_CONFML_NAVIAGATOR);
		registerImage(reg, IConfmlImages.TAB_NAVIGATOR);
		registerImage(reg, IConfmlImages.TAB_PREVIEW);
		registerImage(reg, IConfmlImages.TAB_PROBLEMS);
		registerImage(reg, IConfmlImages.TAB_PROPERTIES);
		
		registerImage(reg, IConfmlImages.DELETE);

//		registerImage(reg, IConfmlImages.OBJ_SETTING);
//		registerImage(reg, IConfmlImages.OBJ_SAMPLE);
//
//		registerImage(reg, IConfmlImages.COLLAPSE_ALL);
//		registerImage(reg, IConfmlImages.EXPAND_ALL);
//		registerImage(reg, IConfmlImages.FILTER);
//		registerImage(reg, IConfmlImages.SYNCED);
//		registerImage(reg, IConfmlImages.DELETE_EDIT);
//		registerImage(reg, IConfmlImages.ERROR_CO);
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
					new Status(IStatus.WARNING, PLUGIN_ID,
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
