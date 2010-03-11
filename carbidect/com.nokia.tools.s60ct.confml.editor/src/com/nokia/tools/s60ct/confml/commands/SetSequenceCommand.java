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

import com.nokia.tools.s60ct.model.confml.ESequenceValueItem;

public class SetSequenceCommand extends AbstractSelectionCommand
{
	private ESequenceValueItem item;
	private EList <ESequenceValueItem> items = null;
	private int index = -1;

	public SetSequenceCommand(ESequenceValueItem item,EList<ESequenceValueItem> items, int index) {
		this.item = item;
		this.items = items;
		this.index = index;
	}


	public void execute() 
	{
		items.set(index, item);
	}

	public void undo() {
		items.remove(item);
	}

	public Object getModel() {

		return items;
	}


	public void redo() {
		System.out.println("SetSequenceCommand.redo()");
	}

}
