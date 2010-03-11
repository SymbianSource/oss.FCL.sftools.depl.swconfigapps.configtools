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

package com.nokia.tools.vct.confml.editor.view.wizards;

import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IEditorInput;

import com.nokia.tools.vct.confml.editor.view.vemodel.EGroupContainer;

public class AddGroupWizard extends Wizard {

	private AddGroupWizardPageOne pageOne;
	private EGroupContainer groupContainer;
	private IEditorInput editorInput;

	public AddGroupWizard(EGroupContainer groupContainer, IEditorInput editorInput) {
		setNeedsProgressMonitor(false);
		setWindowTitle("Add new group wizard");
		this.groupContainer = groupContainer;
		this.editorInput = editorInput;
	}

	@Override
	public void addPages() {
		pageOne = new AddGroupWizardPageOne(groupContainer, editorInput);
		addPage(pageOne);
	}

	@Override
	public boolean performFinish() {
		AddGroupWizardData.name = pageOne.getGroupName();
		AddGroupWizardData.description = pageOne.getGroupDescription();
		AddGroupWizardData.imagePath = pageOne.getGroupIconPath();
		return true;
	}

}
