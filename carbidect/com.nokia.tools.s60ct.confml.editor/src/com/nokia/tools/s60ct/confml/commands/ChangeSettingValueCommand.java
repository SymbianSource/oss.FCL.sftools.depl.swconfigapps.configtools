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
package com.nokia.tools.s60ct.confml.commands;




import org.eclipse.emf.common.command.AbstractCommand;

import com.nokia.tools.s60ct.model.confml.EResourceSetting;
import com.nokia.tools.s60ct.model.confml.ESimpleSetting;
import com.nokia.tools.s60ct.model.confml.ESimpleValue;


public class ChangeSettingValueCommand extends AbstractCommand {

	protected ESimpleValue settingValue;
	private String newValue;
	private String oldValue;

	/**
	 * 
	 * @param sValue
	 *            The widgetController for the widget whose model got changed
	 * @param basicWidget
	 * @param basicWidget
	 * @param widgetMediator
	 */
	public ChangeSettingValueCommand(ESimpleValue sValue, String nValue) {
		oldValue = sValue.getValue();
		this.settingValue = sValue;
		this.newValue = nValue;
	}

	@Override
	protected boolean prepare() {
		return true;
	}

	public void execute() {
		settingValue.setValue(newValue);
		if (settingValue.getType() instanceof ESimpleSetting)
		{
			ESimpleSetting sSetting = (ESimpleSetting) settingValue.getType();
			sSetting.setModified(true);
		}
		else if (settingValue.getType() instanceof EResourceSetting)
		{
			EResourceSetting rSetting = (EResourceSetting) settingValue.getType();
			rSetting.setModified(true);
		} 
	}

	@Override
	public void undo() {
		settingValue.setValue(oldValue);
	}

	public void redo() {
		execute();
	}
}
