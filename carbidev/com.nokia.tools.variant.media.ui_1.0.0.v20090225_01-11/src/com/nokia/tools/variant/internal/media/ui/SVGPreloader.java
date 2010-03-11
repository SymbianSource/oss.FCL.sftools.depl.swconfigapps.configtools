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

import java.net.URL;

import org.apache.batik.transcoder.TranscoderInput;
import org.eclipse.ui.IStartup;

import com.nokia.tools.variant.media.ui.svg.SVGImage;
import com.nokia.tools.variant.preview.ContentPreviewPlugin;

public class SVGPreloader implements IStartup {

	public void earlyStartup() {
		try {
			SVGImage image = new SVGImage();
			URL url = ContentPreviewPlugin.getDefault().getBundle().getEntry(
					"icons/startup.svg");
			image.setInput(new TranscoderInput(url.openStream()));
			image.getAsBufferedImage();
		} catch (Exception ex) {
			ContentPreviewPlugin.logError("Failed to lazy-load SVG image", ex);
		}
	}

}
