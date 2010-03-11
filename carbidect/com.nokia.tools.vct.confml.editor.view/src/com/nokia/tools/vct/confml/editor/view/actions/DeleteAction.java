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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.IStructuredSelection;

import com.nokia.tools.vct.confml.editor.view.ViewsEditor;
import com.nokia.tools.vct.confml.editor.view.commands.DeleteCommand;
import com.nokia.tools.vct.confml.editor.view.vemodel.EGroup;
import com.nokia.tools.vct.confml.editor.view.vemodel.ERefOption;
import com.nokia.tools.vct.confml.editor.view.vemodel.ERefProperty;
import com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef;
import com.nokia.tools.vct.confml.editor.view.vemodel.EView;

public class DeleteAction extends Action {

	private ViewsEditor editor;

	public DeleteAction(ViewsEditor editor) {
		this.editor = editor;
		setText("&Delete");
	}

	@Override
	public void run() {
		super.run();

		List<EObject> list = new ArrayList<EObject>();
		IStructuredSelection selection = (IStructuredSelection) editor
				.getViewTv().getSelection();
		Object[] selected = selection.toArray();
		for (Object o : selected) {
			if (o instanceof EGroup || o instanceof ESettingRef
					|| o instanceof ERefOption || o instanceof ERefProperty
					|| o instanceof EView) { //no further check of the view, but delete should be enabled only for views included directly under root view
				list.add((EObject) o);
			}
		}
		DeleteCommand dc = new DeleteCommand(editor, list);
		editor.getCommandStack().execute(dc);
	}
}
