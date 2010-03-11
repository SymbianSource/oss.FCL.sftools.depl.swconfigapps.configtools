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

import com.nokia.tools.variant.content.confml.Setting;
import com.nokia.tools.variant.content.confml.View;


public class RemoveSharedInstanceSettingFromViewCommand extends Command {

	private Setting setting;
	private int removeIndex;
	private View view;

	public RemoveSharedInstanceSettingFromViewCommand(View view, Setting s) {
		this.setting = s;
		this.view = view;
	}
	
	@Override
	public void execute() {
		
		EList<Setting> settings = view.getSharedSettingInstances();
		removeIndex = settings.indexOf(setting);
		if(removeIndex!=-1){
		settings.remove(removeIndex);
		
		
		}
		
	}
	
	@Override
	public void undo() {
//		if(removeIndex!=-1)
		view.getSharedSettingInstances().add(/*removeIndex,*/ setting);
	}
}
