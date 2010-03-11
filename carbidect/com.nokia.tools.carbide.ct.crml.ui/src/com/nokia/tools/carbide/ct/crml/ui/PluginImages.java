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
package com.nokia.tools.carbide.ct.crml.ui;

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
	
	public static final Image REPOSITORY;
	public static final Image DESCRIPTION;
	public static final Image SIMPLEKEY;
	public static final Image BITMASKKEY;
	public static final Image RANGEKEY;
	public static final Image BIT;
	public static final Image XML;
	public static final Image ACCESS;
	public static final Image GENERIC;


	
	static {
	
		REPOSITORY = new Image(Display.getCurrent(),CRMLUIActivator.getImageDescriptor("icons/Repository.gif").getImageData());
		DESCRIPTION = new Image(Display.getCurrent(),CRMLUIActivator.getImageDescriptor("icons/desc.gif").getImageData());
		SIMPLEKEY =  new Image(Display.getCurrent(),CRMLUIActivator.getImageDescriptor("icons/Key.gif").getImageData());
		BITMASKKEY =  new Image(Display.getCurrent(),CRMLUIActivator.getImageDescriptor("icons/KeyWithBits.gif").getImageData());
		RANGEKEY =  new Image(Display.getCurrent(),CRMLUIActivator.getImageDescriptor("icons/KeyRange.gif").getImageData());
		BIT = new Image(Display.getCurrent(),CRMLUIActivator.getImageDescriptor("icons/Bit1.gif").getImageData());
		ACCESS = new Image(Display.getCurrent(),CRMLUIActivator.getImageDescriptor("icons/generic.gif").getImageData());
		XML = new Image(Display.getCurrent(),CRMLUIActivator.getImageDescriptor("icons/fil_xml.gif").getImageData());
		GENERIC = new Image(Display.getCurrent(),CRMLUIActivator.getImageDescriptor("icons/generic.gif").getImageData());
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
			URL entry = CRMLUIActivator.getDefault().getBundle().getEntry(
					"icons/" + name);
			ImageData id = new ImageData(entry.openStream());
			return ImageDescriptor.createFromImageData(id);
		} catch (Exception ex) {
			CRMLUIActivator.getDefault().getLog().log(new Status(IStatus.ERROR, CRMLUIActivator.PLUGIN_ID,"Failed to load icon " + name, ex));
			return null;
		}
	}

	
}
