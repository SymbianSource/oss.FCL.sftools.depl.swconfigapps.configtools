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
 * Description: This file is part of com.nokia.tools.variant.media.ui component.
 */

package com.nokia.tools.variant.media.ui;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.content.IContentType;
import org.eclipse.core.runtime.content.IContentTypeManager;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class MediaUIPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.nokia.tools.variant.media.ui";

	// The shared instance
	private static MediaUIPlugin plugin;

	/** Any media content type (image,video,audio, etc) */
	public static final IContentType CT_MEDIA;

	/** Any audio content type */
	public static final IContentType CT_AUDIO;

	/** Any image content type */
	public static final IContentType CT_IMAGE;

	/** SVG image content type */
	public static final IContentType CT_IMAGE_SVG;

	/** Any video content type */
	public static final IContentType CT_VIDEO;

	
	public static final QualifiedName SIZE = new QualifiedName(PLUGIN_ID, "size");
	public static final QualifiedName AUDIO_CODEC = new QualifiedName(PLUGIN_ID, "audio_codec");
	public static final QualifiedName VIDEO_CODEC = new QualifiedName(PLUGIN_ID, "video_codec");
	public static final QualifiedName DURATION = new QualifiedName(PLUGIN_ID, "duration");
	public static final QualifiedName AUDIO_FRAMERATE = new QualifiedName(PLUGIN_ID, "audio_framerate");
	public static final QualifiedName VIDEO_FRAMERATE = new QualifiedName(PLUGIN_ID, "video_framerate");
	public static final QualifiedName VIDEO_WIDTH = new QualifiedName(PLUGIN_ID, "video_width");
	public static final QualifiedName VIDEO_HEIGHT = new QualifiedName(PLUGIN_ID, "video_height");
	public static final QualifiedName AUDIO_CHANNELS = new QualifiedName(PLUGIN_ID, "audio_channels");
	public static final QualifiedName AUDIO_SAMPLERATE =  new QualifiedName(PLUGIN_ID, "audio_samplerate");

	public static final QualifiedName EMBEDDED_FILE_COUNT = new QualifiedName(PLUGIN_ID, "embedded_file_count");
	public static final QualifiedName COLOR_DEPTH = new QualifiedName(PLUGIN_ID, "color_depth");
	public static final QualifiedName FRAME_COUNT =  new QualifiedName(PLUGIN_ID, "frame_count");
	
	static {
		IContentTypeManager ctManager = Platform.getContentTypeManager();
	
		CT_MEDIA = ctManager
				.getContentType("com.nokia.tools.variant.contenttype.media");
		CT_VIDEO = ctManager
				.getContentType("com.nokia.tools.variant.contenttype.video");
		CT_AUDIO = ctManager
				.getContentType("com.nokia.tools.variant.contenttype.audio");
		CT_IMAGE = ctManager
				.getContentType("com.nokia.tools.variant.contenttype.image");
		CT_IMAGE_SVG = ctManager
				.getContentType("com.nokia.tools.variant.contenttype.image.svg");
	
	}

	/**
	 * The constructor
	 */
	public MediaUIPlugin() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
	 * )
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
	 * )
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
	public static MediaUIPlugin getDefault() {
		return plugin;
	}

	public static void logError(String message, Throwable cause) {
		plugin.getLog().log(
				new Status(IStatus.ERROR, PLUGIN_ID, message, cause));
	}

}
