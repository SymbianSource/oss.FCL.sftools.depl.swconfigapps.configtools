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
package cellEditors;

import org.eclipse.jface.viewers.DialogCellEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;

public class FileCellEditor extends DialogCellEditor {

	public FileCellEditor() {
		// Auto-generated constructor stub
		// Should this call super()?
	}

	public FileCellEditor(Composite parent) {
		super(parent);
		// Auto-generated constructor stub
	}

	public FileCellEditor(Composite parent, int style) {
		super(parent, style);
		// Auto-generated constructor stub
	}

	protected Object openDialogBox(Control cellEditorWindow) {
		FileDialog folderDialog = new FileDialog(cellEditorWindow.getShell());
		String result = folderDialog.open();
		return result;
	}

}
