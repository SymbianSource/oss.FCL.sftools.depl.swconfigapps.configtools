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
import configurationemf.TYPE;

public class CreateParentSettingDuplicateAction implements IObjectActionDelegate 
{
	ParentSetting parentSetting = null;
	SequenceMenuItemProvider itemProvider = new SequenceMenuItemProvider(null);
	
	@Override
	public void setActivePart(IAction action, IWorkbenchPart targetPart) 
	{
	}

	public void run(IAction action) 
	{
		EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(parentSetting);
		
		parentSetting.setCurrentExtensionPolicy(EXTENSION_POLICY.APPEND);
		List currentList = parentSetting.getFrames();
		List copy = new ArrayList();
		copy.addAll(currentList);
		int size = currentList.size();
		
		for (int index = 0; index < size; index++)
		{
			try
			{
				Command command = itemProvider.createCommand(parentSetting, editingDomain, AddCommand.class, new CommandParameter(parentSetting,ConfigurationemfPackage.eINSTANCE.getParentSetting_Frames(),null));
				editingDomain.getCommandStack().execute(command);
				Frame source = (Frame)copy.get(index);
				Frame duplicate = (Frame) parentSetting.getFrames().get(parentSetting.getFrames().size()-1);
				
				EList <LeafSettingDelegator> ls = duplicate.getLeafSettings();
				Iterator it = ls.iterator();
				while (it.hasNext())
				{
					LeafSettingDelegator lsd = (LeafSettingDelegator) it.next();
					EList <LeafSettingDelegator> ls2 = source.getLeafSettings();
					LeafSetting leafSetting = lsd.getLeafSetting();
					Iterator it2 = ls2.iterator();
					while (it2.hasNext())
					{
						LeafSettingDelegator lsd2 = (LeafSettingDelegator) it2.next();
						try
						{
							LeafSetting leafSetting2 = lsd2.getLeafSetting();
							if (leafSetting2.getAbsRef().equals(leafSetting.getAbsRef()))
							{
								if (lsd2.getValue() == null) lsd.setValue(new String(""));
								else lsd.setValue(new String(lsd2.getValue()));
							}
						}
						catch (Exception exc)
						{
							System.err.println("Error1:"+exc.toString());
							
						}
					}
				}
			}
			catch (Exception exc)
			{
				System.err.println("Error:"+exc.toString());
			}
			}
			parentSetting.setCurrentExtensionPolicy(EXTENSION_POLICY.REPLACE);
	}
	
	
	
	public void selectionChanged(IAction action, ISelection selection) 
	{
		IStructuredSelection structedSelection = (IStructuredSelection)selection;
	    Object[] objects = structedSelection.toArray();		
	    parentSetting = (ParentSetting) objects[0]; 
	    if (parentSetting.getType().equals(TYPE.SEQUENCE))
	    	action.setEnabled(true);
	    else
	    	action.setEnabled(false);
	    	
	}

}
