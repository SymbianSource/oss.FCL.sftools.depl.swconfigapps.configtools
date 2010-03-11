/*
 * Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies). 
 * All rights reserved.
 * This component and the accompanying materials are made available
 * under the terms of the License "Symbian Foundation License v1.0"
 * which accompanies this distribution, and is available
 * at the URL "http://www.symbianfoundation.org/legal/sfl-v10.html".
 * 
 * Initial Contributors:
 * Nokia Corporation - Initial contribution
 * 
 * Contributors:
 * 
 * Description: This file is part of com.nokia.tools.variant.media.ui component.
 */

package com.nokia.tools.variant.internal.media.ui;

import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.content.IContentDescription;

import com.nokia.tools.variant.media.ui.MediaUIPlugin;
import com.nokia.tools.variant.media.ui.preview.ImagePreviewDescriptor;
import com.nokia.tools.variant.preview.IPreviewDescriptor;
import com.nokia.tools.variant.preview.IPreviewDescriptorFactory;
import com.nokia.tools.variant.preview.UnsupportedContentDescriptor;

public class ImageDescriptorFactory implements IPreviewDescriptorFactory {

	public IPreviewDescriptor createPreviewDescriptor(IStorage source,
			IContentDescription description) {
		try {
			return new ImagePreviewDescriptor(description.getContentType(), source);
		} catch (Exception ex) {
			MediaUIPlugin.logError("Failed to construct image descriptor",
					ex);
			return new UnsupportedContentDescriptor(null);
		}
	}

}
