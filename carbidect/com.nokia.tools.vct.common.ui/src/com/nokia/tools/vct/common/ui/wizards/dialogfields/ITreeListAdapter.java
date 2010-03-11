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

import org.eclipse.swt.events.KeyEvent;

public interface ITreeListAdapter {
	
	/**
	 * A button from the button bar has been pressed.
	 */
	void customButtonPressed(TreeListDialogField field, int index);
	
	/**
	 * The selection of the list has changed.
	 */	
	void selectionChanged(TreeListDialogField field);

	/**
	 * The list has been double clicked
	 */
	void doubleClicked(TreeListDialogField field);

	/**
	 * A key has been pressed
	 */
	void keyPressed(TreeListDialogField field, KeyEvent event);

	Object[] getChildren(TreeListDialogField field, Object element);

	Object getParent(TreeListDialogField field, Object element);

	boolean hasChildren(TreeListDialogField field, Object element);

}
