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
 * Description: This file is part of com.nokia.tools.variant.confml.ui component.
 */

package com.nokia.tools.variant.confml.ui.popup.actions;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;

public class DeleteCommand extends Command {

	private List<EObject> objectsToRemove;

	public DeleteCommand(List<EObject> objs) {
		this.objectsToRemove = objs;	
	}

	public void execute() {
		// compute parents of removed elements
		throw new UnsupportedOperationException();
	}

}
