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

import com.nokia.tools.variant.editor.model.summaryModel.UIElement;

public class ChangeMetadataValueCommand extends AbstractSelectionCommand {

	private String value;
	public String getValue() {
		return value;
	}

	private String oldValue;
	private UIElement element;

	public UIElement getElement() {
		return element;
	}

	public ChangeMetadataValueCommand(String value, UIElement element) {
		oldValue = element.getValue();
		this.value = value;
		this.element = element;
	}

	public void execute() {
		element.setValue(value);
	}

	@Override
	public void undo() {
		element.setValue(oldValue);
	}

	@Override
	public void redo() {
		execute();
	}

	@Override
	public Object getModel() {
		return element;
	}
}
