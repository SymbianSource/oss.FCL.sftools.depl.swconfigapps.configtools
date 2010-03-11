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
 * Description: This file is part of com.nokia.tools.variant.confml.ui component.
 */

package com.nokia.tools.variant.confml.ui.popup.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.DialogSettings;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.internal.dialogs.NewWizard;

@SuppressWarnings("restriction")
public class NewAction implements IViewActionDelegate {

	private ISelection selection;
	private IWorkbench workbench;

	public void run(IAction action) {

		if (!(selection instanceof IStructuredSelection) || selection == null
				|| workbench == null) {
			return;
		}

		NewWizard nw = new NewWizard();
		nw.init(workbench, (IStructuredSelection) selection);
		nw.setDialogSettings(new DialogSettings(""));

		WizardDialog dialog = new WizardDialog(workbench
				.getActiveWorkbenchWindow().getShell(), nw);
		dialog.create();
		dialog.open();
	}

	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}

	public void init(IViewPart view) {
		this.workbench = view.getSite().getWorkbenchWindow().getWorkbench();
	}

}
