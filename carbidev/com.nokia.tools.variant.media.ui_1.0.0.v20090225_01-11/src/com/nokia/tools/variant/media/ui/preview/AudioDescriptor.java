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

import com.nokia.tools.variant.preview.PreviewController;

public class AudioDescriptor implements IAudioPreviewDescriptor {

	private IStorage audioContent;
	private IContentType audioType;
	
	public AudioDescriptor(IContentType contentType, IStorage content) {
		this.audioType = contentType;
		this.audioContent = content;
	}
	
	public IContentType getAudioType() {
		return audioType;
	}
	
	public PreviewController createPreviewControl() {
		return new JMFAudioController();
	}
	
	public IStorage getAudioContent() {
		return audioContent;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof AudioDescriptor)) {
			return false;
		}
		AudioDescriptor other = (AudioDescriptor)obj;
		
		return this.audioType.equals(other.audioType) && this.audioContent.equals(other.audioContent);
	}
	
	@Override
	public int hashCode() {
		return audioContent.hashCode();
	}
}
