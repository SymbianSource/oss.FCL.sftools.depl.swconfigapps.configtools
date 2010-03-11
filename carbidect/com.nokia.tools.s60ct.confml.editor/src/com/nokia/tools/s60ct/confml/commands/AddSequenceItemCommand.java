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

import com.nokia.tools.s60ct.model.confml.ESequenceSetting;
import com.nokia.tools.s60ct.model.confml.ESequenceValue;
import com.nokia.tools.s60ct.model.confml.ESequenceValueItem;


public class AddSequenceItemCommand extends AbstractSelectionCommand {
	private ESequenceSetting setting;
	private ESequenceValueItem item;
//	private int index = -1;

	public AddSequenceItemCommand(ESequenceSetting setting, ESequenceValueItem item) {
		this.item = item;
		this.setting = setting;
	}

	public AddSequenceItemCommand(ESequenceSetting setting, ESequenceValueItem item,
			int index) {
		this.item = item;
		this.setting = setting;
	}

	public void undo() {
		setting.getItems().remove(item);
	}

	@Override
	public Object getModel() {
		return setting;
	}

	public void execute() {
		ESequenceValue seqVal = (ESequenceValue)setting.getValue();
		seqVal.getItems().add(item);	
	}

	public void redo() {
		System.out.println("REDO HERE");
	}
}
