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
 * Description: This file is part of com.nokia.tools.vct.confml.editor.view component.
 */

package com.nokia.tools.vct.confml.editor.view.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;

import com.nokia.tools.vct.confml.editor.view.ViewsEditor;
import com.nokia.tools.vct.confml.editor.view.commands.ExpandCommand;
import com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef;

public class ExpandSettingRefAction extends Action {
	private ViewsEditor editor;
	
	public ExpandSettingRefAction(ViewsEditor editor) {
		this.editor = editor;
		setText("&Expand");
	}

	@Override
	public void run() {
		ISelection selection = editor.getViewTv().getSelection();
		StructuredSelection ss = (StructuredSelection) selection;
		ESettingRef element = (ESettingRef) ss.getFirstElement();
		expand(element);
	}

	private void expand(ESettingRef element) {
		ExpandCommand ex = new ExpandCommand(editor, element);
		editor.getCommandStack().execute(ex);
	}
}
