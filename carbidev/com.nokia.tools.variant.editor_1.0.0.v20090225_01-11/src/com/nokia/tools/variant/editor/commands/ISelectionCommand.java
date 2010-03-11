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
 * Command which handles selection, if the selection is not O.K., select the
 * element
 * 
 */
public interface ISelectionCommand {
	/**
	 * Selection is O.K., if the element which is going to be edited, is
	 * selected
	 * 
	 * @return
	 */
	public boolean isSelectionOK();

	/**
	 * Select the element
	 */
	public void select();
}
