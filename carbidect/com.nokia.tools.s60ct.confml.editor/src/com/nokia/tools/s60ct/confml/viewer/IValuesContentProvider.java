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
package com.nokia.tools.s60ct.confml.viewer;

import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.swt.dnd.DropTargetListener;

//import com.nokia.tools.variant.editor.validation.Result;

public interface IValuesContentProvider extends ITreeContentProvider {
	String getValue(Object element);
	boolean isDirty(Object element);
	void valueChanged(String newValue, Object element);
//	public Result validate(String value,Object element);
	void contributeToToolBar(IToolBarManager manager, Object element);
	DropTargetListener getDropTargetListener(Object child);
	boolean hasNote(Object element);
	boolean isDefault(Object element);
}
