/*
* Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies). 
* All rights reserved.
* This component and the accompanying materials are made available
* under the terms of "Eclipse Public License v1.0"
* which accompanies this distribution, and is available
* at the URL "http://www.eclipse.org/legal/epl-v10.html".
*
* Initial Contributors:
* Nokia Corporation - initial contribution.
*
* Contributors:
*
* Description:
*
*/
package command;

import java.util.Map;

import org.eclipse.emf.common.command.AbstractCommand;

import configurationemf.Setting;

public class SetMultipleCurrentValue extends AbstractCommand {
	Map<Setting, Object> map=null;
	
	
	
	public SetMultipleCurrentValue(Map<Setting,Object> map){
		this.map = map;
	}
	
	@Override
	public boolean canExecute() {
		return true;
	}

	@Override
	public void execute() {
		for(Setting setting: map.keySet())
			setting.setCurrentValue((String)map.get(setting));

	}

	@Override
	public void redo() {

	}

	@Override
	public void undo() {
		super.undo();
	}

}
