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
package com.nokia.s60ct.cenrep.gui.Actions;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import s60cenrep.provider.RepositoryForCRBrowserView;
import cenrep.CenrepPackage;

public class AddKeyAction implements IObjectActionDelegate {
	
	final static String SIMPLE_KEY = "new.repository.simpleKey";
	final static String BITMASK = "new.repository.bitmaskKey";
	final static String RANGE = "new.repository.rangeKey";

	EObject repository = null;
	ItemProviderAdapter itemProvider = new RepositoryForCRBrowserView(null);

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {

	}

	@Override
	public void run(IAction action) {
		String actionId = action.getId();
		EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(repository);
		Command command = null;
		if(actionId.compareTo(SIMPLE_KEY)==0){
			//add simple key
			command = itemProvider.createCommand(repository, editingDomain, 
					AddCommand.class, new CommandParameter(repository,CenrepPackage.eINSTANCE.getRepository_SimpleKeys(),null));
		}else if(actionId.compareTo(BITMASK)==0){
			//add bitmask
			command = itemProvider.createCommand(repository, editingDomain, 
					AddCommand.class, new CommandParameter(repository,CenrepPackage.eINSTANCE.getRepository_BitmaskKeys(),null));
		}else if(actionId.compareTo(RANGE)==0){
			//add range
			command = itemProvider.createCommand(repository, editingDomain, 
					AddCommand.class, new CommandParameter(repository,CenrepPackage.eINSTANCE.getRepository_RangeKey(),null));
		}
		if(command!=null){
			editingDomain.getCommandStack().execute(command);
		}
	}

	public void selectionChanged(IAction action, ISelection selection) {
		repository =null;
		if(selection instanceof IStructuredSelection) {
	           IStructuredSelection structedSelection = (IStructuredSelection)selection;
	           if(structedSelection.size()>0){
	        	   repository=(EObject)structedSelection.getFirstElement();
	           }
	    }
	}
	
}
