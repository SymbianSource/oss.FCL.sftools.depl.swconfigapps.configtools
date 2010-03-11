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

package com.nokia.tools.vct.internal.common.secure.ui.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.wizard.WizardDialog;

import com.nokia.tools.vct.internal.common.secure.ui.wizards.ExportKeysWizard;

public class ExportKeysAction extends Action {

	private StructuredViewer viewer;
	
	public ExportKeysAction(StructuredViewer viewer) {
		this.viewer = viewer;
		setEnabled(!viewer.getSelection().isEmpty());
		setText("Export Keys");
	}

	@Override
	public void run() {
		Object[] selection = ((IStructuredSelection)viewer.getSelection()).toArray();
		ExportKeysWizard wizard = new ExportKeysWizard(selection);
		WizardDialog dialog = new WizardDialog(viewer.getControl().getShell(), wizard);
		dialog.open();
	}

}
