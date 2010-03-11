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

package com.nokia.tools.variant.editor.commands;

import com.nokia.tools.variant.editor.model.summaryModel.UIElement;

public class SetPropertyCommand extends AbstractSelectionCommand{
	private UIElement setting;
	private String note;
	private String oldNote;

	public SetPropertyCommand(UIElement setting, String note) {
		oldNote = setting.getNote();
		this.setting = setting;
		this.note = note;
	}

	@Override
	public void execute() {
		setting.setNote(note);
	}

	@Override
	public void undo() {
		setting.setNote(oldNote);
	}

	@Override
	public Object getModel() {

		return setting;
	}
}
