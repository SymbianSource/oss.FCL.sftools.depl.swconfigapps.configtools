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
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import s60ct.provider.LSDelegateItemProvider;
import s60ct.provider.S60CTItemProviderAdapterFactory;

import command.DeleteLSDSetting;

import configurationemf.ConfigurationemfPackage;
import configurationemf.Frame;
import configurationemf.LeafSetting;
import configurationemf.LeafSettingDelegator;
import configurationemf.ParentSetting;

public class DeleteLeafSettingDelegator implements IObjectActionDelegate
{

	LSDelegateItemProvider itemProvider = (LSDelegateItemProvider)(new S60CTItemProviderAdapterFactory()).createLeafSettingDelegatorAdapter();
	
	List<EObject> selectedObjects = new ArrayList<EObject>();
	
	private Object[][] RO_FEATURES=null;
	private Object[][] PARENT_FEATURE=null;
	
	public DeleteLeafSettingDelegator() {
		
	}

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		DeleteEObjectSet deleteEObjectSet = (DeleteEObjectSet)targetPart.getAdapter(DeleteEObjectSet.class);
		if(deleteEObjectSet!=null){
			RO_FEATURES=deleteEObjectSet.getRoFeatures();
			PARENT_FEATURE=deleteEObjectSet.getParentFeature();
		}else{
			RO_FEATURES=null;
			PARENT_FEATURE=null;
		}
		
	}

	public void run(IAction action) {
		for (Iterator<EObject> iterator = selectedObjects.iterator(); iterator.hasNext();) {
			EObject object = iterator.next();
			Object[] parentAndFeature = getParentAndFeature(object);
			Frame frame = (Frame)parentAndFeature[0];
			ParentSetting parentSetting = frame.getTemplateOwner();
			LeafSetting leafSetting = ((LeafSettingDelegator)object).getLeafSetting();
			EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(leafSetting);
			
			CommandParameter commandParameter = new CommandParameter(parentSetting,ConfigurationemfPackage.eINSTANCE.getParentSetting_LeafSetting(),leafSetting);
			
			Command command = itemProvider.createCommand(parentSetting, editingDomain, DeleteLSDSetting.class, commandParameter);
			editingDomain.getCommandStack().execute(command);
			
			if (command.canExecute())
			{
				frame.deleteLeafSetting(leafSetting);
			}
		}
	}
	
	private Object[] getParentAndFeature(EObject object){
		Frame frame = (Frame)object.eContainer();
		for (int i = 0; i < PARENT_FEATURE.length; i++) {
			Class klass = (Class)PARENT_FEATURE[i][0];
			EReference ref = (EReference)PARENT_FEATURE[i][1];
			if(klass.isInstance(object))
				return new Object[]{frame ,ref};
		}
		return null;
	}

	public void selectionChanged(IAction action, ISelection selection) {
		selectedObjects.clear();
		boolean isTemplate = false;
		if(selection instanceof IStructuredSelection) {
	           IStructuredSelection structedSelection = (IStructuredSelection)selection;
	           Object[] objects = structedSelection.toArray();
	           if (objects.length != 0)
	           {
		           LeafSettingDelegator lsd = (LeafSettingDelegator)objects[0];
		           Frame frame = (Frame)lsd.eContainer();
		           isTemplate = frame.isTemplate();
		           selectToBeRemoved(objects);
	           }
	    }
		if(!selectedObjects.isEmpty() && PARENT_FEATURE!=null && isTemplate){
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
		Frame frame = (Frame)object.eContainer();
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
