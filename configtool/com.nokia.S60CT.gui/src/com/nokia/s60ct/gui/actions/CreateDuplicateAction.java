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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import s60ct.provider.SequenceMenuItemProvider;
import configurationemf.ConfigurationemfPackage;
import configurationemf.EXTENSION_POLICY;
import configurationemf.Frame;
import configurationemf.LeafSetting;
import configurationemf.LeafSettingDelegator;
import configurationemf.ParentSetting;

public class CreateDuplicateAction implements IObjectActionDelegate 
{
	List<EObject> selectedObjects = new ArrayList<EObject>();
	SequenceMenuItemProvider itemProvider = new SequenceMenuItemProvider(null);
	Frame frame = null;
	

	@Override
	public void setActivePart(IAction action, IWorkbenchPart targetPart) 
	{
		ParentSetting parentSetting = (ParentSetting) frame.eContainer();
		EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(parentSetting);
	}



	public void run(IAction action) 
	{
		ParentSetting parentSetting = (ParentSetting) frame.eContainer();
		EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(parentSetting);
		
		EXTENSION_POLICY ex = parentSetting.getCurrentExtensionPolicy();

		Command command = itemProvider.createCommand(parentSetting, editingDomain, AddCommand.class, new CommandParameter(parentSetting,ConfigurationemfPackage.eINSTANCE.getParentSetting_Frames(),null));
		editingDomain.getCommandStack().execute(command);
		
		List currentList = parentSetting.getMyCurrentFrames();
		Frame duplicate = (Frame) currentList.get(currentList.size()-1);

		EList <LeafSettingDelegator> ls = duplicate.getLeafSettings();
		Iterator it = ls.iterator();
		while (it.hasNext())
		{
			LeafSettingDelegator lsd = (LeafSettingDelegator) it.next();
			LeafSetting leafSetting = lsd.getLeafSetting(); 
			EList <LeafSettingDelegator> ls2 = frame.getLeafSettings();
			Iterator it2 = ls2.iterator();
			while (it2.hasNext())
			{
				LeafSettingDelegator lsd2 = (LeafSettingDelegator) it2.next();
				LeafSetting leafSetting2 =lsd2.getLeafSetting(); 
				if (leafSetting2.getAbsRef().equals(leafSetting.getAbsRef()))
				{
					if (lsd2.getValue() == null) lsd.setValue(new String(""));
					else lsd.setValue(new String(lsd2.getValue()));

				}
			}
		}
		
	}
	
	
	public void selectionChanged(IAction action, ISelection selection) 
	{
		selectedObjects.clear();
		if(selection instanceof IStructuredSelection)
		{
	       IStructuredSelection structedSelection = (IStructuredSelection)selection;
	       Object[] objects = structedSelection.toArray();
	       if (objects.length != 0)
	       {
	           Frame frame = (Frame)objects[0];
	           
	           if (frame.isTemplate())
	           {
	        	   action.setEnabled(false);
	           }
	           else
	           {
	        	   this.frame = frame;
	        	   action.setEnabled(true);
	           }
	       }
	    }
		
	}

}
