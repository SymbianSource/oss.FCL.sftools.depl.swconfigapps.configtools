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
 * Description: This file is part of com.nokia.tools.variant.views component.
 */

package com.nokia.tools.variant.views.errorview;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

import com.nokia.tools.variant.content.confml.FilePath;
import com.nokia.tools.variant.content.confml.FileSystemEntrySetting;
import com.nokia.tools.variant.content.confml.Setting;
import com.nokia.tools.variant.views.errormodel.Error;

public class ErrorsLabelProvider implements ITableLabelProvider {

	public Image getColumnImage(Object element, int columnIndex) {
		
		return null;
	}

	public String getColumnText(Object element, int columnIndex) {
		Error error = (Error) element;
		switch (columnIndex) {
		case 0:
			Setting setting = error.getSetting();
			if (setting instanceof FilePath) {
				FilePath fileSetting = (FilePath) setting;
				FileSystemEntrySetting parent = fileSetting.getParent();
				if (fileSetting.equals(parent.getTargetFilePath())) {
					return error.getSetting().getName()
							+ " - Location in Phone";
				}

			}
			return error.getSetting().getName();
		case 1:
			return getTextWithoutSpecialChars(error.getDescription());
		case 2:
			return error.getLocation();
		}
		return null;
	}

	private String getTextWithoutSpecialChars(String input) {
		String result = "";
		if (input != null) {
			result = input.replaceAll("\n", " ");
			result = result.replaceAll("\t", " ");
			result = result.replaceAll("\\s+", " ");
			return result;
		} else
			return "";
	}

	public void addListener(ILabelProviderListener listener) {
		

	}

	public void dispose() {
		

	}

	public boolean isLabelProperty(Object element, String property) {
		
		return false;
	}

	public void removeListener(ILabelProviderListener listener) {
		

	}

}
