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

import com.nokia.tools.variant.content.confml.FileSystemEntrySetting;

public class ChangeFileSettingSourceCommand extends AbstractSelectionCommand {

	protected FileSystemEntrySetting setting;
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
	public ChangeFileSettingSourceCommand(FileSystemEntrySetting setting,
			String value, boolean isInLastLayer) {

		this.oldIsInLastLayer = setting.getSourceFilePath().isContainedInLastLayer();
		this.isInLastLayer = isInLastLayer;
		this.oldValue = setting.getSourceFilePath().getPath();
		this.value = value;
		this.setting = setting;

	}

	public void execute() {
		setting.getSourceFilePath().setContainedInLastLayer(isInLastLayer);
		setting.getSourceFilePath().setPath(value);
		if (value == null)
			setting.setValueNull(true);
		else
			setting.setValueNull(false);
	}

	@Override
	public void undo() {
		setting.getSourceFilePath().setContainedInLastLayer(oldIsInLastLayer);
		setting.getSourceFilePath().setPath(oldValue);
		if (value == null)
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
