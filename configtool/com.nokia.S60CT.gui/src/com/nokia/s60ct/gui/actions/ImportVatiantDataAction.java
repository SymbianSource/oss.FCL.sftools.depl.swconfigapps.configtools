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

import org.eclipse.emf.common.ui.action.WorkbenchWindowActionDelegate;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;

import com.nokia.s60ct.gui.wizard.VariantDataImportWizard;

import configurationemf.RootConf;
import configurationemf.util.VariantDataManager;

public class ImportVatiantDataAction extends WorkbenchWindowActionDelegate
			implements IObjectActionDelegate {
	
	
	VariantDataManager manager = new VariantDataManager();
	IWorkbenchWindow window=null;
	RootConf rootConf=null;
	//action ids
	public static final String SINGLE_IMPORT_ID = "import.single.vd.action";
	public static final String CHAIN_IMPORT_ID = "import.chain.vd.action";
	
	public ImportVatiantDataAction() {
	}

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		window=targetPart.getSite().getWorkbenchWindow();
	}

	public void run(IAction action) {
		VariantDataImportWizard wizard = new VariantDataImportWizard(rootConf,action.getId());
		WizardDialog wizardDialog = new WizardDialog(getWindow().getShell(), wizard){

			@Override
			protected Button createButton(Composite parent, int id,
					String label, boolean defaultButton) {
				if(id==IDialogConstants.FINISH_ID){
					Button finish = super.createButton(parent, id, label, defaultButton);
					finish.setVisible(false);
					return finish;
				}else
					return super.createButton(parent, id, label, defaultButton);
			}

			@Override
			protected void createButtonsForButtonBar(Composite parent) {
				super.createButtonsForButtonBar(parent);
				Button cancel = this.getButton(IDialogConstants.CANCEL_ID);
				cancel.setText("Done");
			}
			
		};
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
