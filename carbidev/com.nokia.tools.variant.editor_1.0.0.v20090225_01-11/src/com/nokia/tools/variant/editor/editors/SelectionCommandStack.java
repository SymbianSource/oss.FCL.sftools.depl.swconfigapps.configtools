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

package com.nokia.tools.variant.editor.editors;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;

import com.nokia.tools.variant.editor.commands.ISelectionCommand;
/**
 * Select widget used for editing element, before undo/redo 
 * 
 */
public class SelectionCommandStack extends CommandStack {
	@Override
	public void undo() {
		Command undoCommand = getUndoCommand();
		if (undoCommand instanceof ISelectionCommand) {
			ISelectionCommand selectionCommand = (ISelectionCommand) undoCommand;
			if (selectionCommand.isSelectionOK()) {
				super.undo();
			} else {
				selectionCommand.select();
			}
		} else {

			super.undo();
		}
	}

	@Override
	public void redo() {
		Command undoCommand = getRedoCommand();
		if (undoCommand instanceof ISelectionCommand) {
			ISelectionCommand selectionCommand = (ISelectionCommand) undoCommand;
			if (selectionCommand.isSelectionOK()) {
				super.redo();
			} else {
				selectionCommand.select();
			}
		} else {

			super.redo();
		}
	}
}
