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

import java.io.IOException;

import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.content.IContentType;

import com.nokia.tools.variant.preview.PreviewController;

public class StaticVideoPreviewDescriptor implements IVideoPreviewDescriptor {

	private IStorage videoContent;
	private IContentType contentType;

	public StaticVideoPreviewDescriptor(IContentType contentType, IStorage content) throws IOException {
		this.videoContent = content;
		this.contentType = contentType;
	}

	public IStorage getVideoContent() {
		return videoContent;
	}

	public IContentType getVideoType() {
		return contentType;
	}

	public PreviewController createPreviewControl() {
		return new JMFVideoController();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof StaticVideoPreviewDescriptor)) {
			return false;
		}
		StaticVideoPreviewDescriptor other = (StaticVideoPreviewDescriptor)obj;
		
		return this.contentType.equals(other.contentType) && this.videoContent.equals(other.videoContent);
	}
	
	@Override
	public int hashCode() {
		return videoContent.hashCode();
	}
}
