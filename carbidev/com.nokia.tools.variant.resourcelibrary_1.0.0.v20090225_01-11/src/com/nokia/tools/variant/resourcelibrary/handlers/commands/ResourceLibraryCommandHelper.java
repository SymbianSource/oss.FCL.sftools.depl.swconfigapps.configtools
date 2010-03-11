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
import org.eclipse.gef.commands.CompoundCommand;

import com.nokia.tools.variant.content.confml.Setting;
import com.nokia.tools.variant.resourcelibrary.model.Directory;
import com.nokia.tools.variant.resourcelibrary.model.FileSystemElement;
import com.nokia.tools.variant.resourcelibrary.model.ResourceModelRoot;

public class ResourceLibraryCommandHelper {

	public static final int STATUS_OK = 0;
	public static final int STATUS_ERROR_READ_ONLY = 1;
	public static final int STATUS_ERROR_READ_ONLY_CHILD = 2;
	public static final int STATUS_ERROR_READ_ONLY_SETTING = 4;
	public static final int STATUS_ERROR_OTHER = 8;
	
	public static ResourceModelRoot getResourceModelRoot(FileSystemElement target) {
		FileSystemElement tmp = target;
		while (!(tmp instanceof ResourceModelRoot)) {
			tmp = (FileSystemElement) tmp.eContainer();
		}
		return (ResourceModelRoot)tmp;
	}
	
	public static int checkModifyStatus(FileSystemElement element) {
		int status = 0;
		
		if (element instanceof ResourceModelRoot) {
			status |= STATUS_ERROR_OTHER;
		}
		
		if (element.isReadOnly()) {
			status |= STATUS_ERROR_READ_ONLY;
		}
		if (element instanceof Directory) {
			if (ResourceLibraryCommandHelper.hasReadOnly((Directory)element)) {
				status |= STATUS_ERROR_READ_ONLY_CHILD;
			}
		}

		if (hasROSettings(element)) {
			status |= STATUS_ERROR_READ_ONLY_SETTING;
		}
			
		return status;
	}
	
	public static String getStatusLiteral(int status) {
		if (status == 0) {
			return "Operation Permitted";
		}
		if ((status & STATUS_ERROR_READ_ONLY) != 0) {
			return "Resource is read-only";
		}
		if ((status & STATUS_ERROR_READ_ONLY_CHILD) != 0) {
			return "Resource has read-only child";
		}
		if ((status & STATUS_ERROR_READ_ONLY_SETTING) != 0) {
			return "One or more read-only setting references this resource";
		}
		return "Other error";
	}

	private static boolean hasROSettings(FileSystemElement element) {
		for (Setting setting: element.getSettings()) {
			if (!setting.isVisible()) {
				return true;
			}
		}
		if (element instanceof Directory) {
			for (FileSystemElement child: ((Directory)element).getChildren()) {
				boolean flag = hasROSettings(child);
				if (flag) {
					return true;
				}
			}
		}
		
		return false;
	}

	
	public static boolean hasReadOnly(Directory dir) {
		if (dir.isReadOnly()) {
			return true;
		}
		for (FileSystemElement child : dir.getChildren()) {
			if (child.isReadOnly()) {
				return true;
			}
			if (child instanceof Directory) {
				if (hasReadOnly((Directory) child)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean containsResourceLibraryCommand(Command command) {
		if (command instanceof IResourceLibraryCommand) {
			return true;
		} else if (command instanceof CompoundCommand) {
			CompoundCommand compound = (CompoundCommand)command;
			for (Object child: compound.getCommands()) {
				if (containsResourceLibraryCommand((Command)child)) {
					return true;
				}
			}
			return false;
		} else {
			return false;
		}
	}
}
