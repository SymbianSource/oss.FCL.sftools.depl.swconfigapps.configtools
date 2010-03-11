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

package com.nokia.tools.variant.editor.properties;

import org.eclipse.gef.commands.CommandStack;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPart;

import com.nokia.tools.variant.content.confml.Setting;
import com.nokia.tools.variant.editor.commands.SetNoteCommand;

/**
 * This listener handle these events : "ENTER" key in the Text widget, focus is
 * out from Text widget or widget is disposed. In these cases, the widget is
 * updated (command is executed). This listener is applicable only for note
 * Text.
 * 
 */
public class NoteTextBoxListener implements Listener {

	private Text textBox;
	private Setting setting;
	private IWorkbenchPart activeEditor;

	public NoteTextBoxListener(Text textBox, Setting setting,
			IWorkbenchPart activeEditor) {
		this.textBox = textBox;
		this.setting = setting;
		this.activeEditor = activeEditor;
	}

	public void handleEvent(Event event) {

		switch (event.type) {
		case SWT.KeyDown:
			if (event.character == '\r') {
				updateTextBox();
			}
			break;

		case SWT.FocusOut:
			updateTextBox();
			break;

		case SWT.Dispose:
			updateTextBox();
			break;
		}
	}

	private void updateTextBox() {
		String textValue = textBox.getText();
		String note = setting.getNote();
		if (note == null) {
			note = "";
		}
		if (textValue != null && !textValue.equals(note)) {
			SetNoteCommand command = new SetNoteCommand(setting, textValue);
			executeCommand(command, activeEditor);
		}
	}

	/**
	 * Executes specified command on current editor.
	 * 
	 * @param command
	 *            command to execute
	 * @param editor
	 *            editor where the command is executed
	 */
	private void executeCommand(SetNoteCommand command, IWorkbenchPart editor) {
		Object adapter = editor.getAdapter(CommandStack.class);
		if (adapter instanceof CommandStack) {
			((CommandStack) adapter).execute(command);
		}
	}
}
