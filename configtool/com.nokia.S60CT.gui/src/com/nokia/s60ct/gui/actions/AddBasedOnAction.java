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

package com.nokia.s60ct.gui.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;

import com.nokia.s60ct.gui.wizard.BasedOnConfWizard;

import configurationemf.RootConf;

public class AddBasedOnAction implements IObjectActionDelegate {
	IWorkbenchWindow window=null;
	RootConf rootConf=null;
	
	public AddBasedOnAction() {
	}

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		window=targetPart.getSite().getWorkbenchWindow();
	}

	public void run(IAction action) {
		BasedOnConfWizard wizard = new BasedOnConfWizard(rootConf);
		WizardDialog wizardDialog = new WizardDialog(getWindow().getShell(), wizard);
		wizardDialog.open();
	}

	public void selectionChanged(IAction action, ISelection selection) {
		rootConf =null;
		if(selection instanceof IStructuredSelection) {
	           IStructuredSelection structedSelection = (IStructuredSelection)selection;
	           if(structedSelection.size()>0){
	        	   rootConf=(RootConf)structedSelection.getFirstElement();
	           }
	    }
		if(rootConf!=null&&!rootConf.isReadOnly()) action.setEnabled(true);
		else action.setEnabled(false);
	}

	public IWorkbenchWindow getWindow() {
		return window;
	}

}
