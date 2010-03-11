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
 * Description: This file is part of com.nokia.tools.vct.confml.editor.view component.
 */

package com.nokia.tools.vct.confml.editor.view.actions;

import java.util.List;

import org.eclipse.gef.commands.CommandStack;
import org.eclipse.jface.action.Action;

import com.nokia.tools.vct.common.core.utils.ArrayUtils;
import com.nokia.tools.vct.confml.editor.view.ViewsEditor;
import com.nokia.tools.vct.confml.editor.view.commands.AddSettingCommand;
import com.nokia.tools.vct.confml.editor.view.vemodel.EGroup;
import com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef;

public class AddSettingAction extends Action {
	private EGroup subgroup = null;
	private ESettingRef[] transformedSettings = null;
	private int index;
	private CommandStack commandStack;
	private ViewsEditor editor;

	public AddSettingAction(ViewsEditor editor, CommandStack commandStack, EGroup group,
			List<ESettingRef> added, int index) {
		this.editor = editor;
		this.commandStack = commandStack;
		this.subgroup = group;
		this.transformedSettings= ArrayUtils.createCopy(ESettingRef.class, added);
		this.index = index;
	}

	public void run() {
		if (transformedSettings.length > 0) {
			AddSettingCommand addSettingCommand = new AddSettingCommand(editor, 
					subgroup, index, transformedSettings);
			commandStack.execute(addSettingCommand);
		}
	}

}
