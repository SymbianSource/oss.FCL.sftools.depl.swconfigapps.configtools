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

package com.nokia.tools.variant.resourcelibrary.handlers.commands;

import org.eclipse.gef.commands.Command;

import com.nokia.tools.variant.resourcelibrary.model.FileSystemElement;

public class SetNoteCommand extends Command implements IResourceLibraryCommand {

	private FileSystemElement fileSystemElement;
	private String note;
	private String oldNote;

	public SetNoteCommand(FileSystemElement fileSystemElement, String note) {
		oldNote = fileSystemElement.getNote();
		this.fileSystemElement = fileSystemElement;
		this.note = note;
	}

	@Override
	public void execute() {
		fileSystemElement.setNote(note);
	}

	@Override
	public void undo() {
		fileSystemElement.setNote(oldNote);
	}
}
