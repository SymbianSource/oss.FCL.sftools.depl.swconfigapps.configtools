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
 * Description: This file is part of com.nokia.tools.vct.confml.editor.include component.
 */

package com.nokia.tools.vct.confml.editor.include.xincmodel.util;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;

import com.nokia.tools.vct.confml.editor.include.xincmodel.EDocument;
import com.nokia.tools.vct.confml.editor.include.xincmodel.EProjectFile;
import com.nokia.tools.vct.confml.editor.include.xincmodel.EProjectFolder;
import com.nokia.tools.vct.confml.editor.include.xincmodel.EProjectResource;

public class EXincModelUtils {
	public static EProjectFile findTargetFile(EDocument document, String href) {
		EProjectFile targetFile = null;
		if (href != null) {
			URI docURI = document.eResource().getURI();
			URI uri = URI.createURI(href).resolve(docURI);
			String[] segs = uri.segments();
			int segPtr = 2;
			EList<EProjectResource> folderPtr = document.getResources();
			OUTER:
			for (segPtr = 2; segPtr < segs.length - 1; segPtr++) {
				String name = segs[segPtr];
				
				for (EProjectResource res: folderPtr) {
					if (res instanceof EProjectFolder && res.getName().equals(name)) {
						folderPtr = ((EProjectFolder)res).getResources();
						continue OUTER;
					}
				}
				// not found
				folderPtr = null;
				break;
			}
			if (folderPtr != null) {
				String name = segs[segs.length - 1];
				for (EProjectResource res: folderPtr) {
					if (res instanceof EProjectFile && res.getName().equals(name)) {
						targetFile = (EProjectFile)res;
						break;
					}
				}
			}

		}
		return targetFile;
	}

	public static String normalizeHref(String str) {
		if (str != null) {
			str = str.trim();
			if (str.length() == 0) {
				str = null;
			}
		}
		return str;
	}

}
