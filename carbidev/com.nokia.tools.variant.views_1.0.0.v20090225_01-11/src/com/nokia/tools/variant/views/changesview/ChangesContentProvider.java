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

package com.nokia.tools.variant.views.changesview;

import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

import com.nokia.tools.variant.content.confml.FilePath;
import com.nokia.tools.variant.content.confml.FileSystemEntrySetting;
import com.nokia.tools.variant.content.confml.Setting;
import com.nokia.tools.variant.content.confml.View;

/**
 * Content provider for or the table viewer located in the changes view. Input
 * element is ({@link View} from Editor UI model.
 * 
 * @see ChangesViewPage
 * @see ChangesLabelProvider
 */

public class ChangesContentProvider implements IStructuredContentProvider {

	public ChangesContentProvider() {
	}

	public Object[] getElements(Object inputElement) {
		View view = (View) inputElement;
		ArrayList<Setting> nonDefaultSettings = new ArrayList<Setting>();
		EList<Setting> allSettings = view.getSharedSettingInstances();
		for (int i = 0; i < allSettings.size(); i++) {
			Setting setting = allSettings.get(i);
			if (!setting.isDefault() && setting.isVisible()) {

				if (setting instanceof FileSystemEntrySetting) {
					FileSystemEntrySetting fileSystemSettingEntry = (FileSystemEntrySetting) setting;
					FilePath sourceFilePath = fileSystemSettingEntry
							.getSourceFilePath();
					FilePath targetFilePath = fileSystemSettingEntry
							.getTargetFilePath();
					if (isFileNonDefault(sourceFilePath)) {
						nonDefaultSettings.add(sourceFilePath);
					}
					if (isFileNonDefault(targetFilePath)) {
						nonDefaultSettings.add(targetFilePath);
					}
				} else {
					nonDefaultSettings.add(setting);
				}
			}
		}

		return nonDefaultSettings.toArray();
	}

	boolean isFileNonDefault(FilePath filePath) {
		if (!filePath.isDefault() && !filePath.isReadOnly()) {
			return true;
		}
		return false;
	}

	public void dispose() {
		

	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		

	}

}
