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

import com.nokia.tools.variant.content.confml.SequenceItem;
import com.nokia.tools.variant.content.confml.SequenceSetting;

public class AddSequenceItemCommand extends AbstractSelectionCommand {
	private SequenceSetting setting;
	private SequenceItem item;
	private int index = -1;

	public AddSequenceItemCommand(SequenceSetting setting, SequenceItem item) {
		this.item = item;
		this.setting = setting;
	}

	public AddSequenceItemCommand(SequenceSetting setting, SequenceItem item,
			int index) {
		this.item = item;
		this.setting = setting;
		this.index = index;
	}

	@Override
	public void execute() {
		EList<SequenceItem> sequenceItems = setting.getSequenceItem();
		if (index >= 0 && index <= sequenceItems.size()) {
			sequenceItems.add(index, item);
		} else {
			sequenceItems.add(item);
		}
	}

	@Override
	public void undo() {
		setting.getSequenceItem().remove(item);
	}

	@Override
	public Object getModel() {

		return setting;
	}
}
