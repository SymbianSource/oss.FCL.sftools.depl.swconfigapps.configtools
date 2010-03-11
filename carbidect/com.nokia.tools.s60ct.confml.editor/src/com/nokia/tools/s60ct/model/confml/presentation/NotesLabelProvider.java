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

package com.nokia.tools.s60ct.model.confml.presentation;

import java.util.Map.Entry;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

import com.nokia.tools.vct.common.appmodel.EAppSetting;
import com.nokia.tools.vct.common.appmodel.EAppSettingType;

public class NotesLabelProvider implements ITableLabelProvider {

	public Image getColumnImage(Object element, int columnIndex) {
		
		return null;
	}

	public String getColumnText(Object element, int columnIndex) 
	{
		Entry entry = (Entry)element;
		
		switch (columnIndex) {
		case 0:
			Object eAppObject = entry.getKey();
			if (eAppObject instanceof EAppSetting)
			{
				EAppSetting setting = (EAppSetting)eAppObject;
				return setting.getTypeInfo().getName();
			}
			if (eAppObject instanceof EAppSettingType)
			{
				EAppSettingType settingType = (EAppSettingType)eAppObject;
				return settingType.getName();
			}
			
		case 1:
			String note = (String)entry.getValue();
			return getTextWithoutSpecialChars(note);
		}
		return "";
	}

	public void addListener(ILabelProviderListener listener) {
		

	}

	private String getTextWithoutSpecialChars(String input) {
		String result = input;
		if (input != null) {
			result = result.replaceAll("[' ']+", " ");
			result = result.replaceAll("\t+", "");
			result = result.replaceAll("\r", "");
			result = result.replaceAll("\n+", " ");
			result = result.replaceAll("\n ", " ");
			return result;
		} else
			return null;
	}
	
	public void dispose() {
		

	}

	public boolean isLabelProperty(Object element, String property) {
		
		return false;
	}

	public void removeListener(ILabelProviderListener listener) {
		

	}

}
