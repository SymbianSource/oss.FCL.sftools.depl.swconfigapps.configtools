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

import com.nokia.tools.variant.content.confml.SequenceItem;
import com.nokia.tools.variant.content.confml.SequenceSetting;


public class RemoveSequenceItemCommand extends Command {

	private SequenceSetting sequenceSetting;
	private SequenceItem sequenceItem;
	private int index;

	public RemoveSequenceItemCommand(SequenceSetting parentSq,
			SequenceItem sequenceItem) {
		this.sequenceSetting = parentSq;
		this.sequenceItem = sequenceItem;
		index = sequenceSetting.getSequenceItem().indexOf(sequenceItem);
	}

	@Override
	public void execute() {
		if (sequenceItem != null && sequenceSetting != null) {
			sequenceSetting.getSequenceItem().remove(sequenceItem);
		}
	}

	@Override
	public void undo() {
		if (sequenceItem != null && sequenceSetting != null) {
			EList<SequenceItem> items = sequenceSetting.getSequenceItem();
			if (index >= 0 && index < items.size()) {
				items.add(index, sequenceItem);
			} else {
				items.add(sequenceItem);
			}
		}
	}
}
