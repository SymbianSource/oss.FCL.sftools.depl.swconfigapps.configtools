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

package com.nokia.tools.variant.confml.ui.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import com.nokia.tools.variant.confml.ui.wizards.ExportCPFWizard;

public class ExportCPFAction implements IViewActionDelegate {	

	public void init(IViewPart view) {
		

	}

	public void run(IAction action) {
		
		ViewPart viewPart = (ViewPart) PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage().getActivePart();
		ISelection selection = viewPart.getViewSite().getSelectionProvider()
				.getSelection();

		ExportCPFWizard exportCPFWizard = new ExportCPFWizard();
		exportCPFWizard.init(PlatformUI.getWorkbench(),
				(IStructuredSelection) selection);

		WizardDialog dialog = new WizardDialog(viewPart.getSite().getShell(),
				exportCPFWizard);
		dialog.create();
		dialog.open();
	}

	public void selectionChanged(IAction action, ISelection selection) {
		

	}
}
