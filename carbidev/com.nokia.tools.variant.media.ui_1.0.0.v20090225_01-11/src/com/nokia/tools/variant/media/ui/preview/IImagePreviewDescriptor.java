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

import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;

import com.nokia.tools.variant.preview.IPreviewDescriptor;

public interface IImagePreviewDescriptor extends IPreviewDescriptor {
	int getFrameCount();

	ImageData getFrame(int frame);
	
	ImageLoader getImageLoader();
}
