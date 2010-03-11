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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import configurationemf.ConfigurationemfPackage;
import configurationemf.RootConf;
import configurationemf.util.PrioritisedConfigurationList;

public class DeleteConfigurationAction implements IObjectActionDelegate {
	
List<EObject> selectedObjects = new ArrayList<EObject>();

	
	public DeleteConfigurationAction() {
		
	}

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
	
	}

	public void run(IAction action) {
		for (Iterator<EObject> iterator = selectedObjects.iterator(); iterator.hasNext();) {
			RootConf rootConf = (RootConf)iterator.next();
			EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(rootConf);
			Object parent = rootConf.getRoot();
			Object feature = ConfigurationemfPackage.eINSTANCE.getConfiguration();
			Command command = RemoveCommand.create(editingDomain, parent, feature, rootConf);
			if(command!=null) 
				editingDomain.getCommandStack().execute(command);
			
		}
		
		PrioritisedConfigurationList prioritisedConfigurationList = PrioritisedConfigurationList.getPrioritisedConfigurationList();
		prioritisedConfigurationList.clearPrioritisedConfigurationList();
	}
	
	

	public void selectionChanged(IAction action, ISelection selection) {
		selectedObjects.clear();
		if(selection instanceof IStructuredSelection) {
	           IStructuredSelection structedSelection = (IStructuredSelection)selection;
	           Object[] objects = structedSelection.toArray();
	           selectToBeRemoved(objects);
	    }
		if(!selectedObjects.isEmpty()){
			action.setEnabled(true);
		}
		else action.setEnabled(false);
		

	}
	
	private void selectToBeRemoved(Object[] objs){
		for (int i = 0; i < objs.length; i++) {
			EObject obj = (EObject)objs[i];
			if (obj instanceof RootConf)
			{
				RootConf conf = ((RootConf)obj).getRoot();
				if (conf != null && !conf.isReadOnly()) //root configuration cannot be deleted
					selectedObjects.add(obj); 
			}
		}
	}
	
	
}
