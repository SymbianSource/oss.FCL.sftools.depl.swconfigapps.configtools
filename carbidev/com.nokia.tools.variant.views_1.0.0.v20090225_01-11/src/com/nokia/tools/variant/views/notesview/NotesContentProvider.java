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

package com.nokia.tools.variant.views.notesview;

import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

import com.nokia.tools.variant.content.confml.Setting;
import com.nokia.tools.variant.content.confml.View;


public class NotesContentProvider implements IStructuredContentProvider {

	public NotesContentProvider() {
	}

	public Object[] getElements(Object inputElement) {
		View view = (View) inputElement;
		ArrayList<Setting> settingWithNotes = new ArrayList<Setting>();
		EList<Setting> allSettings = view.getSharedSettingInstances();
		for (int i = 0; i < allSettings.size(); i++) {
			Setting setting = allSettings.get(i);
			if (!setting.isVisible()){
				continue;
			}
			String note = setting.getNote();
			if (!(note == null)) {
				if (!note.equals("")) {
					settingWithNotes.add(setting);
				}
			}
		}

		return settingWithNotes.toArray();
	}

	public void dispose() {
		

	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		

	}

}
