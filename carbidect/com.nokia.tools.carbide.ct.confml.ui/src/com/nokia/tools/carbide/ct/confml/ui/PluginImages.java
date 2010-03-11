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
package com.nokia.tools.carbide.ct.confml.ui;

import java.net.URL;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Display;



/**
 * Static image cache.
 */
public final class PluginImages {
	
	public static final Image FEATURE;
	public static final Image SETTING;
	public static final Image CONFIGURATION1;
	public static final Image CONFIGURATION2;
	public static final Image DESCRIPTION;
	public static final Image DATA_FEATURE;
	public static final Image DATA_SETTING;
	public static final Image RFS_FEATURE;
	public static final Image RFS_SETTING;
	public static final Image INCLUDE;
	public static final Image XML;
	public static final Image VIEW;
	public static final Image GROUP;
	public static final Image OPTION;
	public static final Image GENERIC;


	
	static {
	
		FEATURE = new Image(Display.getCurrent(),ConfMLUIActivator.getImageDescriptor("icons/edi_feature.gif").getImageData());
		SETTING = new Image(Display.getCurrent(),ConfMLUIActivator.getImageDescriptor("icons/edi_setting.gif").getImageData());
		CONFIGURATION1 =  new Image(Display.getCurrent(),ConfMLUIActivator.getImageDescriptor("icons/EConfMLDocument.gif").getImageData());
		CONFIGURATION2 =  new Image(Display.getCurrent(),ConfMLUIActivator.getImageDescriptor("icons/EConfML2Document.gif").getImageData());
		DESCRIPTION =  new Image(Display.getCurrent(),ConfMLUIActivator.getImageDescriptor("icons/desc.gif").getImageData());
		DATA_FEATURE = new Image(Display.getCurrent(),ConfMLUIActivator.getImageDescriptor("icons/dat_feature.gif").getImageData());
		DATA_SETTING = new Image(Display.getCurrent(),ConfMLUIActivator.getImageDescriptor("icons/dat_setting.gif").getImageData());
		RFS_FEATURE = new Image(Display.getCurrent(),ConfMLUIActivator.getImageDescriptor("icons/rfs_feature.gif").getImageData());
		RFS_SETTING = new Image(Display.getCurrent(),ConfMLUIActivator.getImageDescriptor("icons/rfs_setting.gif").getImageData());
		INCLUDE = new Image(Display.getCurrent(),ConfMLUIActivator.getImageDescriptor("icons/EInclude.gif").getImageData());
		XML = new Image(Display.getCurrent(),ConfMLUIActivator.getImageDescriptor("icons/fil_xml.gif").getImageData());
		VIEW = new Image(Display.getCurrent(),ConfMLUIActivator.getImageDescriptor("icons/edi_view.gif").getImageData());
		GROUP = new Image(Display.getCurrent(),ConfMLUIActivator.getImageDescriptor("icons/edi_group.gif").getImageData());
		OPTION = new Image(Display.getCurrent(),ConfMLUIActivator.getImageDescriptor("icons/option.gif").getImageData());
		GENERIC = new Image(Display.getCurrent(),ConfMLUIActivator.getImageDescriptor("icons/generic.gif").getImageData());
	}

	/**
	 * Preloads image into backbuffer and then wraps into
	 * {@link ImageDescriptor}
	 * 
	 * @param name
	 *            image name
	 * @return
	 */
	private static ImageDescriptor loadImage(String name) {
		try {
			URL entry = ConfMLUIActivator.getDefault().getBundle().getEntry(
					"icons/" + name);
			ImageData id = new ImageData(entry.openStream());
			return ImageDescriptor.createFromImageData(id);
		} catch (Exception ex) {
			ConfMLUIActivator.getDefault().getLog().log(new Status(IStatus.ERROR, ConfMLUIActivator.PLUGIN_ID,"Failed to load icon " + name, ex));
			return null;
		}
	}

	
}
