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

import com.nokia.tools.variant.content.confml.FilePath;
import com.nokia.tools.variant.content.confml.SimpleSetting;

public class ChangeFileSettingCommand extends AbstractSelectionCommand {

	protected Object setting;
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
	public ChangeFileSettingCommand(FilePath setting, String value,
			boolean isInLastLayer) {

		this.oldIsInLastLayer = setting.isContainedInLastLayer();
		this.isInLastLayer = isInLastLayer;
		this.oldValue = setting.getPath();
		this.value = value;
		this.setting = setting;

	}

	/**
	 * 
	 * @param setting
	 *            The widgetController for the widget whose model got changed
	 * @param basicWidget
	 * @param basicWidget
	 * @param widgetMediator
	 */
	public ChangeFileSettingCommand(SimpleSetting setting, String value,
			boolean isInLastLayer) {

		this.oldIsInLastLayer = setting.isContainedInLastLayer();
		this.isInLastLayer = isInLastLayer;
		this.oldValue = setting.getValue();
		this.value = value;
		this.setting = setting;

	}

	public void execute() {
		if (setting instanceof SimpleSetting) {
			SimpleSetting fileType1 = (SimpleSetting) setting;
			fileType1.setContainedInLastLayer(isInLastLayer);
			fileType1.setValue(value);
			if (value == null) {
				fileType1.setValueNull(true);
			} else {
				fileType1.setValueNull(false);
			}
			setting = fileType1;
		} else if (setting instanceof FilePath) {
			FilePath fileType2 = (FilePath) setting;
			fileType2.setContainedInLastLayer(isInLastLayer);
			fileType2.setPath(value);
			if (value == null) {
				fileType2.setValueNull(true);
			} else {
				fileType2.setValueNull(false);
			}
			setting = fileType2;
		}
	}

	@Override
	public void undo() {
		if (setting instanceof SimpleSetting) {
			SimpleSetting fileType1 = (SimpleSetting) setting;
			fileType1.setContainedInLastLayer(oldIsInLastLayer);
			fileType1.setValue(oldValue);
			if (value == null) {
				fileType1.setValueNull(true);
			} else {
				fileType1.setValueNull(false);
			}
			setting = fileType1;
		} else if (setting instanceof FilePath) {
			FilePath fileType2 = (FilePath) setting;
			fileType2.setContainedInLastLayer(oldIsInLastLayer);
			fileType2.setPath(oldValue);
			if (value == null) {
				fileType2.setValueNull(true);
			} else {
				fileType2.setValueNull(false);
			}
			setting = fileType2;
		}
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
