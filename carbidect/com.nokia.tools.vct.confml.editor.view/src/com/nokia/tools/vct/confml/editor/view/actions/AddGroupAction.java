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
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;

import com.nokia.tools.vct.confml.editor.view.ViewsEditor;
import com.nokia.tools.vct.confml.editor.view.commands.AddGroupCommand;
import com.nokia.tools.vct.confml.editor.view.vemodel.EGroup;
import com.nokia.tools.vct.confml.editor.view.vemodel.EGroupContainer;
import com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorFactory;
import com.nokia.tools.vct.confml.editor.view.wizards.AddGroupWizard;
import com.nokia.tools.vct.confml.editor.view.wizards.AddGroupWizardData;

public class AddGroupAction extends Action {

	private ViewsEditor editor;
	private GroupType type;

	public AddGroupAction(ViewsEditor editor, GroupType type) {
		this.editor = editor;
		this.type = type;
		switch (type) {
		case CHILD_GROUP:
			setText("New &Child Group");
			break;
		case SIBLING_GROUP:
			setText("New &Sibling Group");
			break;
		}
	}

	public void run() {
		EGroup group = EViewEditorFactory.eINSTANCE.createEGroup();
		EGroupContainer groupContainer = null;
		Object selected = ((IStructuredSelection) editor.getViewTv()
				.getSelection()).getFirstElement();
		if (!(selected instanceof EGroupContainer)) {
			return;
		}
		switch (type) {
		case CHILD_GROUP:
			// Views & Groups
			groupContainer = (EGroupContainer) selected;
			break;
		case SIBLING_GROUP:
			// Groups
			groupContainer = (EGroupContainer) ((EGroupContainer) selected)
					.eContainer();
		}

		WizardDialog dlg = new WizardDialog(Display.getCurrent()
				.getActiveShell(), new AddGroupWizard(groupContainer, editor.getEditorInput()));
		dlg.setMinimumPageSize(300, 135);
		dlg.setPageSize(300, 140);
		dlg.open();

		if (dlg.getReturnCode() != Dialog.CANCEL) {
			if (AddGroupWizardData.name != null
					&& !AddGroupWizardData.name.equals("")
					&& AddGroupWizardData.description != null
					&& !AddGroupWizardData.description.equals("")) {
				group.setDescriptionText(AddGroupWizardData.description);
				group.setName(AddGroupWizardData.name);
				if (AddGroupWizardData.imagePath != null
						&& !AddGroupWizardData.imagePath.equals("")) {
					group.setIconUri(AddGroupWizardData.imagePath);
				}
				AddGroupCommand command = new AddGroupCommand(editor,
						groupContainer, group);
				editor.getCommandStack().execute(command);
			}
		}
	}
}
