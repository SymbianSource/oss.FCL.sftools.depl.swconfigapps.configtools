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

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.core.runtime.content.IContentDescriber;
import org.eclipse.core.runtime.content.IContentDescription;

import com.nokia.tools.variant.common.core.utils.FileUtils;
import com.nokia.tools.variant.media.ui.MediaUIPlugin;
import com.nokia.tools.variant.media.ui.svg.SVGImage;

public class SVGImageDescriber implements IContentDescriber {

	public SVGImageDescriber() {
		super();
	}

	public int describe(InputStream contents, IContentDescription description)
			throws IOException {
		if (description == null) {
			return INDETERMINATE;
		}

		int height = 0;
		int width = 0;
		int frames = 1;
		int colors = 0;
		long length = -1;
		File temp = File.createTempFile("temp", ".dat");
		try {
			FileOutputStream fos = new FileOutputStream(temp);
			try {
				length = FileUtils.copyStream(contents, fos);
			} finally {
				FileUtils.closeStream(fos);
			}

			SVGImage svgImage = new SVGImage(temp.toURL());
			BufferedImage bufferedImage = svgImage.getAsBufferedImage();
			java.awt.Rectangle rectangle = bufferedImage.getData().getBounds();

			width = rectangle.width;
			height = rectangle.height;
		} catch (Exception ex) {
			return INVALID;
		} finally {
			temp.delete();
		}

		description.setProperty(MediaUIPlugin.SIZE, length);
		description.setProperty(MediaUIPlugin.VIDEO_HEIGHT, height);
		description.setProperty(MediaUIPlugin.VIDEO_WIDTH, width);
		description.setProperty(MediaUIPlugin.COLOR_DEPTH, colors);
		description.setProperty(MediaUIPlugin.FRAME_COUNT, frames);

		return INDETERMINATE;
	}

	public QualifiedName[] getSupportedOptions() {
		return new QualifiedName[] { MediaUIPlugin.SIZE,
				MediaUIPlugin.VIDEO_HEIGHT, MediaUIPlugin.VIDEO_WIDTH,
				MediaUIPlugin.COLOR_DEPTH, MediaUIPlugin.FRAME_COUNT };
	}

}
