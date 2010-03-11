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
 * Description: This file is part of com.nokia.tools.variant.editor component.
 */

package com.nokia.tools.variant.editor.summary;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

import com.nokia.tools.variant.editor.model.summaryModel.Note;

public class TableLabelProvider implements ITableLabelProvider {

	public Image getColumnImage(Object element, int columnIndex) {
		
		return null;
	}

	public String getColumnText(Object element, int columnIndex) {
		Note note = (Note) element;
		switch (columnIndex) {
		case 0:
			return note.getDate();
		case 1:
			return note.getContent();
		}
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
