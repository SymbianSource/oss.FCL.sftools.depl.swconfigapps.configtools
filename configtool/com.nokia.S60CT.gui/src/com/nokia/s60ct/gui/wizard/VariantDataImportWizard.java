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
package com.nokia.s60ct.gui.wizard;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IWorkbench;

import com.nokia.s60ct.gui.S60CtEditorPlugin;
import com.nokia.s60ct.gui.actions.ImportVatiantDataAction;

import configurationemf.RootConf;

public class VariantDataImportWizard extends Wizard {
	
	private static final String SINGLE_VD_DESCRIPTION = "_UI_Wizard_VD_SingleImport_description";
	private static final String SINGLE_VD_WIZARD_LABEL = "_UI_VD_SingleImportWizard_label";
	private static final String CHAIN_VD_DESCRIPTION = "_UI_Wizard_VD_ChainImport_description";
	private static final String CHAIN_VD_WIZARD_LABEL = "_UI_VD_ChainImportWizard_label";
	
	protected VariantDataImportWizardPage vdImportPage=null;
	protected IStructuredSelection selection;

	protected IWorkbench workbench;
	
	RootConf conf=null;
	String actionId=null;

	public VariantDataImportWizard(){
		
	}

	public VariantDataImportWizard(RootConf conf, String actionId){
		this.conf=conf;
		this.actionId=actionId;
	}

	public void addPages() {
		vdImportPage = new VariantDataImportWizardPage("Variant Data Import");
		vdImportPage.init(conf, actionId);
		if(actionId.equals(ImportVatiantDataAction.SINGLE_IMPORT_ID)){
			vdImportPage.setTitle(S60CtEditorPlugin.INSTANCE.getString(SINGLE_VD_WIZARD_LABEL));
			vdImportPage.setDescription(S60CtEditorPlugin.INSTANCE.getString(SINGLE_VD_DESCRIPTION));
		}else if(actionId.equals(ImportVatiantDataAction.CHAIN_IMPORT_ID)){
			vdImportPage.setTitle(S60CtEditorPlugin.INSTANCE.getString(CHAIN_VD_WIZARD_LABEL));
			vdImportPage.setDescription(S60CtEditorPlugin.INSTANCE.getString(CHAIN_VD_DESCRIPTION));
		}
		addPage(vdImportPage);
	}


		/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		return true;
	}




}
