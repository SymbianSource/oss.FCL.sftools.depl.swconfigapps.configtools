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

import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;

import com.nokia.tools.variant.common.core.utils.ArrayUtils;
import com.nokia.tools.variant.content.confml.FileSystemEntrySetting;
import com.nokia.tools.variant.content.confml.Setting;
import com.nokia.tools.variant.content.confml.SimpleSetting;
import com.nokia.tools.variant.resourcelibrary.model.Directory;
import com.nokia.tools.variant.resourcelibrary.model.FileSystemElement;

public class MoveCommand{

	public static Command createMoveCommand(Directory target, List<? extends FileSystemElement> sources) {
		CompoundCommand command = new CompoundCommand("Move Resources");
		
		for (FileSystemElement element: sources) {
			Command tmp = CopyResourcesCommand.createCopyCommand(target, element);
			command.add(tmp);
			if (!element.getSettings().isEmpty()) {
				IPath newPath = target.getPath2().append(element.getName());
				tmp = new ChangeLPCommand(element.getSettings(), newPath);
				command.add(tmp);
			}
		}
		for (FileSystemElement element: sources) {
			command.add(RemoveCommand.createResourceRemove(element));
		}
		
		return command.unwrap();
	}
	
	static class ChangeLPCommand extends Command {
		private Setting[] settings;
		private String[] oldPaths;
		private IPath newPath;
		
		public ChangeLPCommand(List<Setting> settings, IPath newPath) {
			super("Update Local Path");
			
			this.settings = ArrayUtils.createCopy(Setting.class, settings);
			this.oldPaths = new String[settings.size()];
			this.newPath = newPath;
		}
		
		@Override
		public boolean canExecute() {
			for (int i = 0; i < settings.length; i++) {
				Setting setting = (Setting)settings[i];
				if (setting instanceof FileSystemEntrySetting) {
					if (((FileSystemEntrySetting)setting).getSourceFilePath().isPathReadOnly()) {
						return false;
					}
				} else if (setting instanceof SimpleSetting) {
					if (!((SimpleSetting)setting).isVisible()) {
						return false;
					}
				} else {
					return false;
				}
			}
			return true;
		}
		
		@Override
		public void execute() {
			String path = newPath.toPortableString();
			
			for (int i = 0; i < settings.length; i++) {
				Setting setting = settings[i];
				if (setting instanceof FileSystemEntrySetting) {
					FileSystemEntrySetting typed = (FileSystemEntrySetting)setting;
					oldPaths[i] = typed.isDefault() ? null : typed.getSourceFilePath().getPath();
					typed.getSourceFilePath().getPath();
				} else if (setting instanceof SimpleSetting) {
					SimpleSetting typed = (SimpleSetting)setting;
					oldPaths[i] = typed.isDefault() ? null : typed.getValue();
					typed.setValue(path);
				}
			}
		}
		
		@Override
		public void undo() {
			for (int i = 0; i < settings.length; i++) {
				Setting setting = settings[i];
				if (setting instanceof FileSystemEntrySetting) {
					FileSystemEntrySetting typed = (FileSystemEntrySetting)setting;
					typed.getSourceFilePath().setPath(oldPaths[i]);
				} else if (setting instanceof SimpleSetting) {
					SimpleSetting typed = (SimpleSetting)setting;
					typed.setValue(oldPaths[i]);
				}
			}
		}
	}

}
