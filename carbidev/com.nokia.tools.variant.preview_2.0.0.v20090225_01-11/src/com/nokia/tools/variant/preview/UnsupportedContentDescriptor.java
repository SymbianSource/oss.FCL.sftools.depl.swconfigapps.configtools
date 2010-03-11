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
 * Description: This file is part of com.nokia.tools.variant.preview component.
 */

package com.nokia.tools.variant.preview;

import java.io.File;

import com.nokia.tools.variant.common.core.utils.FileUtils;

/**
 * Descriptor for unsupported content types.
 */
public class UnsupportedContentDescriptor implements IPreviewDescriptor {

	private File file;

	public UnsupportedContentDescriptor(File f) {
		super();
		file = f;
	}

	public PreviewController createPreviewControl() {
		return new UnsupportedContentController();
	}

	public String getName() {
		if (file != null) {
			return file.getName();
		}

		return "";
	}

	public boolean isFile() {		
		if (file != null) {
			String ext = FileUtils.getExtension(file.getName());
			if (ext == null) {
				return false;
			} else {
				return true;
			}
		}

		return false;
	}
}
