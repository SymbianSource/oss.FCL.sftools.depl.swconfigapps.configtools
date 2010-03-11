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
 * Description: This file is part of com.nokia.tools.variant.preview component.
 */

package com.nokia.tools.variant.preview;

import java.net.URL;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.ImageData;


/**
 * Static image cache.
 */
public final class PluginImages {
	public static final ImageDescriptor FORWARD;
	public static final ImageDescriptor PAN;
	public static final ImageDescriptor PAUSE;
	public static final ImageDescriptor PLAY;
	public static final ImageDescriptor REWIND;
	public static final ImageDescriptor STOP;
	public static final ImageDescriptor LOOP;
	public static final ImageDescriptor ZOOM_IN;
	public static final ImageDescriptor ZOOM_OUT;
	public static final ImageDescriptor ZOOM_ORIGINAL;

	static {
		FORWARD = loadImage("forward_16_pre.png");
		PAN = loadImage("pan_16_pre.png");
		PAUSE = loadImage("pause_16_pre.png");
		PLAY = loadImage("play_16_pre.png");
		REWIND = loadImage("rewind_16_pre.png");
		STOP = loadImage("stop_16_pre.png");
		LOOP = loadImage("loop_16_pre.png");
		ZOOM_IN = loadImage("zoomin_16_pre.png");
		ZOOM_OUT = loadImage("zoomout_16_pre.png");
		ZOOM_ORIGINAL = loadImage("zoomoriginal_16_pre.png");
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
		URL entry = null;
		ImageData id = null;
		try {
			entry = ContentPreviewPlugin.getDefault().getBundle().getEntry(
					"icons/player/" + name);
			id = new ImageData(entry.openStream());
			return ImageDescriptor.createFromImageData(id);
		} catch (Exception ex) {
			ContentPreviewPlugin.logError("Failed to load icon " + name, ex);
			return null;
		} finally {
			if (id != null) {
				id = null;
			}
			if (entry != null) {
				entry = null;
			}
		}
	}
}
