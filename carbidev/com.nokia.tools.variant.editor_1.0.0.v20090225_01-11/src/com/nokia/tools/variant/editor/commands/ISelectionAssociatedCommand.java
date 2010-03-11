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

/**
 * a Command that changes selection and is joined to the commands
 * that work with the same model and are performed at once during undo/redo action
 * 
 */
public interface ISelectionAssociatedCommand extends ISelectionCommand{
	
	/**
	 * 
	 * @return model with which this command works
	 */
	public Object getSelectionElement();
}
