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

import java.util.HashSet;
import java.util.Set;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.IStructuredSelection;

import com.nokia.tools.vct.confml.editor.view.ViewsEditor;
import com.nokia.tools.vct.confml.editor.view.commands.AddChildCommand;
import com.nokia.tools.vct.confml.editor.view.vemodel.ERefOption;
import com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef;
import com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorFactory;
import com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorPackage;

public class AddOptionAction extends Action {

	private ViewsEditor editor;

	public AddOptionAction(ViewsEditor editor) {
		this.editor = editor;
		setText("New Option");
	}

	public void run() {
		ESettingRef container = null;
		Object selected = ((IStructuredSelection) editor.getViewTv()
				.getSelection()).getFirstElement();
		if (!(selected instanceof ESettingRef)) {
			return;
		}

		container = (ESettingRef) selected;

		Set<String> existing = new HashSet<String>();

		for (ERefOption opt : container.getOptions()) {
			existing.add(opt.getName());
		}

		ERefOption newElement = EViewEditorFactory.eINSTANCE.createERefOption();
		String prefix = "option";
		int idx = 0;
		for (;;) {
			String test = prefix + idx;
			if (!existing.contains(test)) {
				newElement.setName(test);
				break;
			}
			idx++;
		}

		newElement.setMap("");
		newElement.setRelevant("");
		newElement.setValue("");

		AddChildCommand command = new AddChildCommand(editor, container, newElement,
				EViewEditorPackage.Literals.ESETTING_REF__OPTIONS);
		editor.getCommandStack().execute(command);

	}
}
