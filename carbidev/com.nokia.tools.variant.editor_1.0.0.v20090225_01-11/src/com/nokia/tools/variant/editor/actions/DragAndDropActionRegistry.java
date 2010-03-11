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

package com.nokia.tools.variant.editor.actions;

import org.eclipse.jface.action.Action;

import com.nokia.tools.variant.editor.model.UISetting;

/**
 * This class stores starting
 * <code>com.nokia.tools.variant.editor.model.UISetting</code> and
 * <code>org.eclipse.jface.action.Action</code> due moving sequence items.
 */
public class DragAndDropActionRegistry {
	private static Action action;
	private static UISetting startUISetting;

	public static UISetting getStartUISetting() {
		return startUISetting;
	}

	public static void setStartUISettingWidget(UISetting startUISetting) {
		DragAndDropActionRegistry.startUISetting = startUISetting;
	}

	public static Action getAction() {
		return action;
	}

	public static void setAction(Action action) {
		DragAndDropActionRegistry.action = action;
	}

}
