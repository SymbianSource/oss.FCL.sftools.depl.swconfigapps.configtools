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

import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.wizard.Wizard;

import com.nokia.s60ct.gui.S60CtEditorPlugin;

import configurationemf.ConfigurationemfPackage;
import configurationemf.RootConf;
import configurationemf.util.PrioritisedConfigurationList;

public class BasedOnConfWizard extends Wizard {
	
	protected AddBasedOnWizardPage addBasedOnPage; 
	protected RootConf rootConf=null;
	protected EStructuralFeature feature = ConfigurationemfPackage.eINSTANCE.getRootConf_Include();
	
	public BasedOnConfWizard(RootConf rootConf){
		this.rootConf=rootConf;
	}
	
	public boolean performFinish() {
		if(addBasedOnPage.isChanged()){
			List<RootConf> basedOnList = addBasedOnPage.getBasedOnList();
			List<RootConf> intialList = addBasedOnPage.rootConf.getInclude();
			addBasedOnPage.rootConf.getInclude().removeAll(intialList);
			
			PrioritisedConfigurationList prioritisedConfigurationList = PrioritisedConfigurationList.getPrioritisedConfigurationList();
			prioritisedConfigurationList.clearPrioritisedConfigurationList();
			
			Command command = null;
			EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(rootConf);
			command=AddCommand.create(domain, rootConf, feature, basedOnList);
			if(command!=null){
				domain.getCommandStack().execute(command);
			}
			
		}
		return true;
	}
	
	
	public void addPages() {
		addBasedOnPage = new AddBasedOnWizardPage("page");
		addBasedOnPage.init(rootConf);
		addBasedOnPage.setTitle(S60CtEditorPlugin.INSTANCE.getString("_UI_AddBasedOnWizard_label"));
		addBasedOnPage.setDescription(S60CtEditorPlugin.INSTANCE.getString("_UI_AddBasedOnWizard_description"));
		addPage(addBasedOnPage);
	}

}
