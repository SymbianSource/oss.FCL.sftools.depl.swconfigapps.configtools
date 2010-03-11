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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;

import com.nokia.tools.variant.content.confml.SequenceItem;
import com.nokia.tools.variant.content.confml.SequenceSetting;


public class MoveSequenceItemCommand extends Command {

	private SequenceItem sourceItem;
	private SequenceItem targetItem;
	private int oldIndex = -1;
	private EList<SequenceItem> items;

	public MoveSequenceItemCommand(SequenceItem source, SequenceItem target) {
		this.sourceItem = source;
		this.targetItem = target;
	}

	@Override
	public void execute() {
		EObject container = sourceItem.eContainer();
		if (container instanceof SequenceSetting) {
			SequenceSetting parent = (SequenceSetting) container;
			items = parent.getSequenceItem();
			oldIndex = items.indexOf(sourceItem);
			int index = items.indexOf(targetItem);
			if (index >= 0 && oldIndex >= 0) {
				items.move(index, sourceItem);
			}
		}
	}

	@Override
	public void undo() {
		if (oldIndex >= 0 && items != null) {
			items.move(oldIndex, sourceItem);
		}
	}

}
