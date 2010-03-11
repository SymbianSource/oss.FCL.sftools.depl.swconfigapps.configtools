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
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPart;

import com.nokia.tools.variant.confml.ui.wizards.ExportCPFWizard;

public class ExportAction implements IViewActionDelegate, IObjectActionDelegate {

	private ISelection selection;
	private IWorkbench workbench;

	public void run(IAction action) {

		if (!(selection instanceof IStructuredSelection) || selection == null
				|| workbench == null) {
			return;
		}

		ExportCPFWizard exportCPFWizard = new ExportCPFWizard();
		exportCPFWizard.init(workbench, (IStructuredSelection) selection);
		exportCPFWizard.setDialogSettings(new DialogSettings(""));

		WizardDialog dialog = new WizardDialog(workbench
				.getActiveWorkbenchWindow().getShell(), exportCPFWizard);
		dialog.create();
		dialog.open();
	}

	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}

	public void init(IViewPart view) {
		this.workbench = view.getSite().getWorkbenchWindow().getWorkbench();
	}

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		if (workbench == null)
			workbench = targetPart.getSite().getWorkbenchWindow()
					.getWorkbench();
	}

}
