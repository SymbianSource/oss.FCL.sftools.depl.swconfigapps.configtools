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

import org.eclipse.core.runtime.IPath;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;

import com.nokia.tools.variant.resourcelibrary.handlers.commands.MoveCommand.ChangeLPCommand;
import com.nokia.tools.variant.resourcelibrary.model.Directory;
import com.nokia.tools.variant.resourcelibrary.model.FileSystemElement;

public class RenameCommand {

	public static Command createRenameCommand(FileSystemElement fes,
			String newName) {
		
		Directory parent = (Directory)fes.eContainer();
		if (parent.getChild(newName) != null) {
			return UnexecutableCommand.INSTANCE;
		}
		CompoundCommand command = new CompoundCommand("Rename Resource");
		
		Command tmp = CopyResourcesCommand.createCopyCommand(parent, fes, newName);
		command.add(tmp);
		if (!fes.getSettings().isEmpty()) {
			IPath newPath = fes.getPath2().append(fes.getName());
			tmp = new ChangeLPCommand(fes.getSettings(), newPath);
			command.add(tmp);
		}
		command.add(RemoveCommand.createResourceRemove(fes));
		
		return command.unwrap();
	}
}
