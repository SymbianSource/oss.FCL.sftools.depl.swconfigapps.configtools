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
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

import com.nokia.tools.variant.confml.ui.wizards.NewConfigurationProjectWizard;

public class NewConfigurationProjectAction implements IObjectActionDelegate, IWorkbenchWindowActionDelegate {

	private ISelection selection;
	private IWorkbenchWindow workbenchWindow;
	private IWorkbenchPart workbenchPart;

	public void run(IAction action) {
		IWorkbench workbench;
		IStructuredSelection ss;
		Shell shell;
		if (workbenchPart != null) {
			shell = workbenchPart.getSite().getShell();
			workbench = workbenchPart.getSite().getWorkbenchWindow().getWorkbench(); 
		} else if (workbenchWindow != null) {
			workbench = workbenchWindow.getWorkbench(); 
			shell = workbenchWindow.getShell();
			this.selection = workbenchWindow.getSelectionService().getSelection();
		} else {
			throw new IllegalStateException();
		}

		
		if (selection instanceof IStructuredSelection) {
			ss = (IStructuredSelection)selection;
		} else {
			ss = StructuredSelection.EMPTY;
		}
		NewConfigurationProjectWizard wizard = new NewConfigurationProjectWizard();
		wizard.init(workbench, ss);

		WizardDialog dialog = new WizardDialog(shell,
				(IWizard) wizard);
		dialog.create();
		dialog.open();
	}

	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}

	public void dispose() {
		
	}

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		workbenchPart = targetPart;
	}

	public void init(IWorkbenchWindow window) {
		this.workbenchWindow = window;
	}
}
