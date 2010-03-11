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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.command.AbstractCommand;

import com.nokia.tools.s60ct.model.confml.ESequenceSetting;
import com.nokia.tools.s60ct.model.confml.ESequenceValue;
import com.nokia.tools.s60ct.model.confml.ESequenceValueItem;




public class RemoveSequenceItemCommand extends AbstractCommand {

	private ESequenceSetting sequenceSetting;
	private ESequenceValueItem sequenceItem;
	private int index;

	public RemoveSequenceItemCommand(ESequenceSetting parentSq,
			ESequenceValueItem sequenceItem) {
		this.sequenceSetting = parentSq;
		this.sequenceItem = sequenceItem;
		index = ((ESequenceValue)sequenceSetting.getValue()).getItems().indexOf(sequenceItem);
	}

	public void execute() {
		if (sequenceItem != null && sequenceSetting != null) {
			sequenceItem.setRemoved(true);
		}
	}

	public void undo() {
		if (sequenceItem != null && sequenceSetting != null) {
			EList<ESequenceValueItem> items = ((ESequenceValue)sequenceSetting.getValue()).getItems();
			if (index >= 0 && index < items.size()) {
				items.add(index, sequenceItem);
			} else {
				items.add(sequenceItem);
			}
		}
	}

	@Override
	protected boolean prepare() {
		return true;
	}

	public void redo() {
		System.out.println("RemoveSequenceItem redo()");
	}
}
