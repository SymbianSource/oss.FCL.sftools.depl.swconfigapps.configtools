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

import com.nokia.tools.variant.content.confml.SimpleSetting;

public class ChangeSettingValueCommand extends AbstractSelectionCommand {

	protected SimpleSetting setting;
	private String value;
	private String oldValue;
	private boolean oldIsInLastLayer;
	private boolean isInLastLayer;

	/**
	 * 
	 * @param setting
	 *            The widgetController for the widget whose model got changed
	 * @param basicWidget
	 * @param basicWidget
	 * @param widgetMediator
	 */
	public ChangeSettingValueCommand(SimpleSetting setting, String value,
			boolean isInLastLayer) {
		this.oldIsInLastLayer = setting.isContainedInLastLayer();
		this.isInLastLayer = isInLastLayer;
		this.oldValue = setting.getValue();
		this.value = value;
		this.setting = setting;
	}

	public void execute() {
		// if value of setting "is" in last layer than setting has changing mark
		setting.setContainedInLastLayer(isInLastLayer);
		setting.setValue(value);
		if (value == null)
			setting.setValueNull(true);
		else 
			setting.setValueNull(false);
	}

	@Override
	public void undo() {
		setting.setContainedInLastLayer(oldIsInLastLayer);
		setting.setValue(oldValue);
		if (oldValue == null)
			setting.setValueNull(true);
		else 
			setting.setValueNull(false);
		
	}

	@Override
	public void redo() {
		execute();
	}

	@Override
	public Object getModel() {
		return setting;
	}
}
