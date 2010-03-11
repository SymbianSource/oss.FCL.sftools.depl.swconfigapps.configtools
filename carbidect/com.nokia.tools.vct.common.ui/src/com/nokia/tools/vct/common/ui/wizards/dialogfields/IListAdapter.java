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
 * Description: This file is part of com.nokia.tools.vct.common.ui component.
 */

package com.nokia.tools.vct.common.ui.wizards.dialogfields;

public interface IListAdapter {
	
	/**
	 * A button from the button bar has been pressed.
	 */
	void customButtonPressed(ListDialogField field, int index);
	
	/**
	 * The selection of the list has changed.
	 */	
	void selectionChanged(ListDialogField field);
	
	/**
	 * En entry in the list has been double clicked
	 */
	void doubleClicked(ListDialogField field);	

}
