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

package com.nokia.tools.variant.media.ui.preview;

import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.content.IContentType;
import org.eclipse.swt.graphics.ImageData;

import com.nokia.tools.variant.preview.PreviewController;

/**
 * Descriptor implementation for startup/shutdown frame animations with audio
 * channel
 * 
 * @see IFrameAnimationDescriptor
 */
public class FrameAnimationDescriptor extends ImagePreviewDescriptor implements
		IFrameAnimationDescriptor {

	protected IContentType audioType;
	protected IStorage audioContent;
	
	public FrameAnimationDescriptor(IContentType imageType, IStorage imageContent,
			IContentType audioType, IStorage audioContent) throws Exception {
		this(new ImagePreviewDescriptor().buildImageData(imageType, imageContent),
				audioType, audioContent);
	}

	public FrameAnimationDescriptor(ImageData[] images, IContentType audioType,
			IStorage audioContent) throws Exception {
		super(images);
		this.audioType = audioType;
		this.audioContent = audioContent;
	}

	public PreviewController createPreviewControl() {
		return new ImagePreviewController();
	}

	public IStorage getAudioContent() {
		return audioContent;
	}

	public IContentType getAudioType() {
		return audioType;
	}
}
