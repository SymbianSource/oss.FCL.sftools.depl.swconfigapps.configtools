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

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import configurationemf.ConfigurationemfFactory;

public abstract class AddChildAction implements IObjectActionDelegate {
	protected EObject selectedObject = null;
	
	
	public AddChildAction() {
	}

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		
	}

	public void run(IAction action) {
		if(isObjectReadOnly(selectedObject))return;
		createChild();

	}

	public void selectionChanged(IAction action, ISelection selection) {
		selectedObject =null;
		if(selection instanceof IStructuredSelection) {
	           IStructuredSelection structedSelection = (IStructuredSelection)selection;
	           if(structedSelection.size()>0){
	        	   selectedObject=(EObject)structedSelection.getFirstElement();
	           }
	    }
		if(selectedObject!=null&&!isObjectReadOnly(selectedObject)) action.setEnabled(true);
		else action.setEnabled(false);

	}
	//the function should set selectedChildAttribute, selectedROAttribute, childClass
	abstract protected boolean isObjectReadOnly(EObject object);
	abstract protected EReference getChildReference();
	abstract protected EClass getChildClass();
	
	private void createChild(){
		EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(selectedObject);
		Command command = AddCommand.create(editingDomain,selectedObject,
				getChildReference(),ConfigurationemfFactory.eINSTANCE.create(getChildClass()));
		if(command!=null)
			editingDomain.getCommandStack().execute(command);
	}
}
