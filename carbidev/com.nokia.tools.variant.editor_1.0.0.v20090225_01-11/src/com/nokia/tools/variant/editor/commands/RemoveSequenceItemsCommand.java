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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.gef.commands.Command;

import com.nokia.tools.variant.content.confml.SequenceItem;
import com.nokia.tools.variant.content.confml.SequenceSetting;

public	class RemoveSequenceItemsCommand extends Command {
	private SequenceSetting parentSetting;
	private List<SequenceItem> sequenceItems;
	private Collection<SequenceItem> itemsToRemove;

	public RemoveSequenceItemsCommand(SequenceSetting parentSetting,
			Collection<SequenceItem> itemsToRemove) {
		this.parentSetting = parentSetting;
		sequenceItems = new ArrayList<SequenceItem>();
		sequenceItems.addAll(parentSetting.getSequenceItem());

		this.itemsToRemove = itemsToRemove;
	}

	@Override
	public void execute() {
		parentSetting.getSequenceItem().removeAll(itemsToRemove);
	}

	@Override
	public void undo() {
		parentSetting.getSequenceItem().clear();
		parentSetting.getSequenceItem().addAll(sequenceItems);

	}
}
