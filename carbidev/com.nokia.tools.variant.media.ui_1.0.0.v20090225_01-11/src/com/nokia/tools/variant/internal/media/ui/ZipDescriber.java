/*
 * Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies). 
 * All rights reserved.
 * This component and the accompanying materials are made available
 * under the terms of the License "Eclipse Public License v1.0"
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

package com.nokia.tools.variant.internal.media.ui;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.core.runtime.content.IContentDescriber;
import org.eclipse.core.runtime.content.IContentDescription;

import com.nokia.tools.variant.common.core.utils.FileUtils;
import com.nokia.tools.variant.media.ui.MediaUIPlugin;

public class ZipDescriber implements IContentDescriber {

	public ZipDescriber() {
		super();
	}

	public int describe(InputStream contents, IContentDescription description)
			throws IOException {

		int counter = 0;
		long length = -1;
		File temp = File.createTempFile("tempzip", ".zip");
		try {
			FileOutputStream fos = new FileOutputStream(temp);
			try {
				length = FileUtils.copyStream(contents, fos);
			} finally {
				FileUtils.closeStream(fos);
			}

			ZipFile zis = new ZipFile(temp);
			Enumeration<? extends ZipEntry> en = zis.entries();
			while (en.hasMoreElements()) {
				ZipEntry zipEntry = en.nextElement();
				if (!zipEntry.isDirectory()) {
					counter++;
				}
			}
		} finally {
			temp.delete();
		}

		if (description != null) {
			description.setProperty(MediaUIPlugin.SIZE, length);
			description.setProperty(MediaUIPlugin.EMBEDDED_FILE_COUNT, counter);
		}

		return INDETERMINATE;
	}

	public QualifiedName[] getSupportedOptions() {
		return new QualifiedName[] { MediaUIPlugin.SIZE,
				MediaUIPlugin.EMBEDDED_FILE_COUNT };
	}

}
