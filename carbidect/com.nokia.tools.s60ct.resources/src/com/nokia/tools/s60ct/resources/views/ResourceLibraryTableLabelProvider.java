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
 * Description: This file is part of com.nokia.tools.variant.resourcelibrary component.
 */

package com.nokia.tools.s60ct.resources.views;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.ITableColorProvider;
import org.eclipse.jface.viewers.ITableFontProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import com.nokia.tools.s60ct.content.confml.FileSystemEntrySetting;
import com.nokia.tools.s60ct.content.confml.Setting;
import com.nokia.tools.s60ct.resources.Activator;
import com.nokia.tools.s60ct.resources.model.ELibraryDirectory;
import com.nokia.tools.s60ct.resources.model.ELibraryElement;
import com.nokia.tools.s60ct.resources.model.ELibraryFile;
import com.nokia.tools.s60ct.resources.resources.ResourceCategories;


public class ResourceLibraryTableLabelProvider extends LabelProvider implements
		ITableLabelProvider, ITableColorProvider, ITableFontProvider {

	public Image getColumnImage(Object obj, int col) {
		ELibraryElement res = (ELibraryElement) obj;

		switch (col) {
		case 0:
			// In case of folder, return standard folder
			if (res instanceof ELibraryDirectory) {
				return PlatformUI.getWorkbench().getSharedImages().getImage(
						ISharedImages.IMG_OBJ_FOLDER);
			}

			// In case of other resource, return the icon for corresponding
			// resource type. Trust that ResourceCategory will always be
			// returned
			return ResourceCategories.getResourceCategory(res).getIcon();

		case 2:
			if (res.getNote() != null) {
				if (res.getNote().length() > 0) {
					return ResourceCategories.loadIcon("icons/mrk_notes.gif");
				}
			}

		default:
			return null;
		}

	}

	public String getColumnText(Object obj, int col) {
		ELibraryElement res = (ELibraryElement) obj;

		switch (col) {
		case 0:
			return res.getName();
		case 1:
			if (res instanceof ELibraryFile) {

				return getNiceSize(((ELibraryFile) res).getSize());

			}
			// return ResourceCategories.getResourceCategoryText(res);
		case 2:
			break; // note - icon only
		}

		return null;
	}

	private String getNiceSize(long size) {

		if (size < 1024) {
			return String.valueOf(size) + " B";
		}

		String result = "" + size/1024;

		int length = result.length();
		if (length > 3) {
			if (length > 6) {
				result = result.subSequence(0, length - 6) + " "
						+ result.subSequence(length - 6, length - 3) + " "
						+ result.subSequence(length - 3, length);
			} else {
				result = result.subSequence(0, length - 3) + " "
						+ result.subSequence(length - 3, length);

			}
		}
		result = result + " KB";
		return result;
	}

	@Override
	public Image getImage(Object element) {
		return getColumnImage(element, 0);
	}

	@Override
	public String getText(Object element) {
		return getColumnText(element, 0);
	}
	
	public Color getBackground(Object element, int columnIndex) {
		return null;
	}
	
	public Color getForeground(Object element, int columnIndex) {
		if (element instanceof ELibraryElement) {
			ELibraryElement fse = (ELibraryElement) element;
			boolean isPointedByReadOnlySetting = isFilePointedByReadOnlySetting(fse.getSettings());
			if (fse.isReadOnly() || isPointedByReadOnlySetting) {
				return Display.getCurrent().getSystemColor(SWT.COLOR_GRAY);
			}
		}
		return null;
	}

	public Font getFont(Object element, int columnIndex) {
		if (columnIndex == 0) {
			if (element instanceof ELibraryElement) {
				ELibraryElement fse = (ELibraryElement) element;
				boolean isPointedByReadOnlySetting = isFilePointedByReadOnlySetting(fse.getSettings());
				if (isPointedByReadOnlySetting) {// use italic font for read only, because of FileSetting has attribute readOnly="true"
					return Activator.getItalicFont();
				}
			}
		}
		return null;
	}

	private boolean isFilePointedByReadOnlySetting(EList<Setting> settings) {
		for (int i = 0 ; i < settings.size() ; i++) {
			Setting setting = settings.get(i);
			if (!setting.isVisible()) {
				return true;
			}
			if (setting instanceof FileSystemEntrySetting) {
				FileSystemEntrySetting fs = (FileSystemEntrySetting) setting;
				if (fs.getSourceFilePath().isPathReadOnly()) {
					return true;
				}
			}

		}
		return false;
	}
}
