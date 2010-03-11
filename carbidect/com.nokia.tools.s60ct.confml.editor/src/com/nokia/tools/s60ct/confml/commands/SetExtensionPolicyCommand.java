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

import com.nokia.tools.s60ct.model.confml.EExtensionPolicy;
import com.nokia.tools.s60ct.model.confml.ESequenceValue;

public class SetExtensionPolicyCommand extends AbstractSelectionCommand{

	private ESequenceValue value;
	private EExtensionPolicy policy;
//	private int index = -1;

	public SetExtensionPolicyCommand(ESequenceValue value, EExtensionPolicy policy) {
		this.policy = policy;
		this.value = value;
	}

	public void execute() {
		
		value.setExtensionPolicy(policy);
	}

	public void undo() {
		
	}

	public Object getModel() {

		return value;
	}

	public void redo() {
		System.out.println("SetExtensionPolicyCommand.redo()");
	}
	
	
}
