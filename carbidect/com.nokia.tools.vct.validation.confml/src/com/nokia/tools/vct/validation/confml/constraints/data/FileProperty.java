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

package com.nokia.tools.vct.validation.confml.constraints.data;

import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.core.runtime.content.IContentType;
import org.eclipse.core.runtime.content.IContentTypeManager;



/**
 * These constants are names for graphic and file properties {@link Property}. 
 * 
 */

public class FileProperty {
	// graphics
	public final static String TYPE_PROPERTY = "type";
	public final static  String MAX_BITS_PROPERTY = "maxBits";
	public final static  String MAX_WIDTH_PROPERTY = "maxWidth";
	public final static  String MAX_HEIGHT_PROPERTY = "maxHeight";
	public final static  String MIN_WIDTH_PROPERTY = "minWidth";
	public final static  String MIN_HEIGHT_PROPERTY = "minHeight";
	public final static  String WIDTH_PROPERTY = "width";
	public final static  String HEIGHT_PROPERTY = "height";
	public final static  String MAX_COLOR_PROPERTY = "maxColor";

	// file
	public final static  String MAX_FILE_SIZE_PROPERTY = "maxFileSize";
	public final static  String RECOMMENDED_FILE_SIZE_PROPERTY = "recommendedFileSize";

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

	public static final String qualName = "com.nokia.tools.variant.media";
	
	public static final QualifiedName SIZE = new QualifiedName(qualName, "size");
	public static final QualifiedName AUDIO_CODEC = new QualifiedName(qualName, "audio_codec");
	public static final QualifiedName VIDEO_CODEC = new QualifiedName(qualName, "video_codec");
	public static final QualifiedName DURATION = new QualifiedName(qualName, "duration");
	public static final QualifiedName AUDIO_FRAMERATE = new QualifiedName(qualName, "audio_framerate");
	public static final QualifiedName VIDEO_FRAMERATE = new QualifiedName(qualName, "video_framerate");
	public static final QualifiedName VIDEO_WIDTH = new QualifiedName(qualName, "video_width");
	public static final QualifiedName VIDEO_HEIGHT = new QualifiedName(qualName, "video_height");
	public static final QualifiedName AUDIO_CHANNELS = new QualifiedName(qualName, "audio_channels");
	public static final QualifiedName AUDIO_SAMPLERATE =  new QualifiedName(qualName, "audio_samplerate");

	public static final QualifiedName EMBEDDED_FILE_COUNT = new QualifiedName(qualName, "embedded_file_count");
	public static final QualifiedName COLOR_DEPTH = new QualifiedName(qualName, "color_depth");
	public static final QualifiedName FRAME_COUNT =  new QualifiedName(qualName, "frame_count");
	
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
	
}
