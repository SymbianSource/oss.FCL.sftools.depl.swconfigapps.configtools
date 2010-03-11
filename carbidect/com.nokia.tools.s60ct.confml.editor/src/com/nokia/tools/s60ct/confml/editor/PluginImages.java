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
package com.nokia.tools.s60ct.confml.editor;

import java.net.URL;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;



/**
 * Static image cache.
 */
public final class PluginImages {
	public static final ImageDescriptor EXPAND_ALL;
	public static final ImageDescriptor COLLAPSE_ALL;
	public static final ImageDescriptor ADD;
	public static final ImageDescriptor DELETE;
	public static final ImageDescriptor EMPTY_SEQUENCE;
	public static final ImageDescriptor BROWSE;
	public static final Image ERROR_SORTER;
	public static final Image SORTER;
	public static final int SORTER_IMAGE_SIZE = 8;
	public static final Image NOTE;
	public static final Image DIRTY;
	public static final Image FILE;
	public static final Color BACKGROUND_COLOR;
	public static final Image MRK_NOTE;
	public static final Image MRK_DIRTY;
	public static final Image MRK_ERROR;
	public static final Image ERROR;
	public static final Image WARNING;
	public static final Image CLEAR;
	public static final Image CHECKED;

	
	static {
		MRK_ERROR = new Image(Display.getCurrent(),Activator.getImageDescriptor("icons/mrk_error.gif").getImageData());
		MRK_DIRTY = new Image(Display.getCurrent(),Activator.getImageDescriptor("icons/mrk_dirty.gif").getImageData());
		MRK_NOTE = new Image(Display.getCurrent(),Activator.getImageDescriptor("icons/mrk_notes.gif").getImageData());
		ERROR = new Image(Display.getCurrent(),Activator.getImageDescriptor("icons/Error.gif").getImageData());
		CHECKED = new Image(Display.getCurrent(),Activator.getImageDescriptor("icons/checked.gif").getImageData());
		WARNING = new Image(Display.getCurrent(),Activator.getImageDescriptor("icons/Warning.gif").getImageData());
		CLEAR = new Image(Display.getCurrent(),Activator.getImageDescriptor("icons/Clear.gif").getImageData());
		BACKGROUND_COLOR = new Color(null, 232, 242, 255);
		EXPAND_ALL = loadImage("expandall.gif");
		COLLAPSE_ALL = loadImage("collapseall.gif");
		ADD = loadImage("add.gif");
		BROWSE = loadImage("browse.gif");
		DELETE = loadImage("delete.gif");
		ERROR_SORTER = new Image(Display.getCurrent(),Activator.getImageDescriptor("icons/srt_error.png").getImageData());
		SORTER = new Image(Display.getCurrent(),createSorterImage());
		NOTE = new Image(Display.getCurrent(),Activator.getImageDescriptor("icons/srt_note.png").getImageData());
		DIRTY = new Image(Display.getCurrent(),Activator.getImageDescriptor("icons/srt_dirty.png").getImageData());
		FILE =  new Image(Display.getCurrent(),Activator.getImageDescriptor("icons/file_icont.gif").getImageData());
		EMPTY_SEQUENCE = loadImage("empty.gif");
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
			URL entry = Activator.getDefault().getBundle().getEntry(
					"icons/" + name);
			ImageData id = new ImageData(entry.openStream());
			return ImageDescriptor.createFromImageData(id);
		} catch (Exception ex) {
			Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID,"Failed to load icon " + name, ex));
			return null;
		}
	}

	public static ImageData createSorterImage() {
		Display display = Display.getCurrent();
		Image image = new Image(display, SORTER_IMAGE_SIZE+4, SORTER_IMAGE_SIZE);
	    Rectangle bounds = image.getBounds();
	    GC gc = new GC(image);
	    gc.setForeground(display.getSystemColor(SWT.COLOR_BLACK));
	    gc.drawRectangle(0, 0, bounds.height-1,bounds.height-1);
	    gc.drawLine(bounds.height+2, 1, bounds.height+2, bounds.height-1);
	    gc.dispose();
	    ImageData data = image.getImageData();
	    data.transparentPixel = data.getPixel(2, 2);
	    return data;
	}

	public static ImageData createErrorSorterImage() {
		Display display = Display.getCurrent();
		Image image = new Image(display, SORTER_IMAGE_SIZE+4, SORTER_IMAGE_SIZE);
	    Rectangle bounds = image.getBounds();
	    GC gc = new GC(image);
	    gc.setForeground(display.getSystemColor(SWT.COLOR_BLACK));
	    gc.drawOval(0, 0, bounds.height-1,bounds.height-1);
	    gc.drawLine(bounds.height+2, 1, bounds.height+2, bounds.height-1);
	    gc.dispose();
	    ImageData data = image.getImageData();
	    data.transparentPixel = data.getPixel(0, 0);
	    return data;
	}
	public static ImageData createNoteImage() {
		Display display = Display.getCurrent();
		Image image = new Image(display, SORTER_IMAGE_SIZE+4, SORTER_IMAGE_SIZE);
	    Rectangle bounds = image.getBounds();
	    GC gc = new GC(image);
	    gc.setForeground(display.getSystemColor(SWT.COLOR_BLACK));
	    gc.drawOval(0, 0, bounds.height-1,bounds.height-1);
	    gc.drawLine(bounds.height+2, 1, bounds.height+2, bounds.height-1);
	    gc.dispose();
	    ImageData data = image.getImageData();
	    data.transparentPixel = data.getPixel(0, 0);
	    return data;
	}
}
