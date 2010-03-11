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

import interfaces.DeleteEObjectSet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import s60ct.provider.SequenceMenuItemProvider;
import configurationemf.ConfigurationemfPackage;
import configurationemf.Frame;
import configurationemf.ParentSetting;

public class DeleteFrameAction implements IObjectActionDelegate
{
	List<EObject> selectedObjects = new ArrayList<EObject>();
	
	SequenceMenuItemProvider itemProvider = new SequenceMenuItemProvider(null);
	
	private Object[][] RO_FEATURES=null;
	
	public DeleteFrameAction() {
	}

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		DeleteEObjectSet deleteEObjectSet = (DeleteEObjectSet)targetPart.getAdapter(DeleteEObjectSet.class);
		if(deleteEObjectSet!=null){
			RO_FEATURES=deleteEObjectSet.getRoFeatures();
		}else{
			RO_FEATURES=null;
		}
	}

	public void run(IAction action) {
		for (Iterator<EObject> iterator = selectedObjects.iterator(); iterator.hasNext();) {
			EObject object = iterator.next();
			Frame frame = (Frame)object;
			ParentSetting parentSetting = (ParentSetting)frame.eContainer();
			EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(parentSetting);
			Command command = itemProvider.createCommand(parentSetting, editingDomain, RemoveCommand.class, new CommandParameter(parentSetting,ConfigurationemfPackage.eINSTANCE.getParentSetting_Frames(),frame));
			editingDomain.getCommandStack().execute(command);
		}
	}

	public void selectionChanged(IAction action, ISelection selection) {
		selectedObjects.clear();
		boolean isTemplate = false;
		if(selection instanceof IStructuredSelection) {
	           IStructuredSelection structedSelection = (IStructuredSelection)selection;
	           Object[] objects = structedSelection.toArray();
	           if (objects.length != 0)
	           {
		           Frame frame = (Frame)objects[0];
		           isTemplate = frame.isTemplate();
		           selectToBeRemoved(objects);
	           }
	    }
		if(!selectedObjects.isEmpty() && !isTemplate){
			action.setEnabled(true);
		}
		else action.setEnabled(false);
	}
	
	private void selectToBeRemoved(Object[] objs){
		for (int i = 0; i < objs.length; i++) {
			EObject obj = (EObject)objs[i];
			if(!isParentRO(obj)) selectedObjects.add(obj);
		}
	}
	
	private boolean isParentRO(final EObject object){
		
		Frame frame = (Frame)object;
		ParentSetting setting = frame.getTemplateOwner();
		if(frame!=null&&RO_FEATURES!=null){
			for (int i = 0; i < RO_FEATURES.length; i++) {
				Class klass = (Class)RO_FEATURES[i][0];
				EAttribute roAttr = (EAttribute)RO_FEATURES[i][1];
				if(klass.isInstance(setting))return (Boolean)setting.eGet(roAttr);
			}
		}
		return false;
	}

}
