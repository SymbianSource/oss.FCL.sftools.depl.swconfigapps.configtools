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

import org.eclipse.emf.common.util.EList;
import org.eclipse.gef.commands.Command;

import com.nokia.tools.variant.content.confml.Group;
import com.nokia.tools.variant.content.confml.LeafGroup;
import com.nokia.tools.variant.content.confml.ParentGroup;
import com.nokia.tools.variant.content.confml.Setting;

public class RemoveSettingFromGroupCommand extends Command {

	private Setting setting;
	int removeIndex;
	private Group group;

	public RemoveSettingFromGroupCommand(Group group, Setting s) {
		this.setting = s;
		this.group = group;
	}

	@Override
	public void execute() {

		EList<Setting> settings = group.getSettings();
		removeIndex = settings.indexOf(setting);
		if (removeIndex != -1) {
			setting.getParentGroup().remove(group);
			setting.getLeafGroup().remove(group);
			settings.remove(removeIndex);
		}
	}

	@Override
	public void undo() {
		if (removeIndex != -1)
			group.getSettings().add(removeIndex, setting);
		if (group instanceof ParentGroup) {
			setting.getParentGroup().add((ParentGroup) group);
		} else {
			setting.getLeafGroup().add((LeafGroup) group);
		}
	}
}
