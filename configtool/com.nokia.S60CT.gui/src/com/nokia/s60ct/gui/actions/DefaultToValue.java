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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

import com.nokia.s60ct.gui.editors.ConfigurationBrowser;

import configurationemf.ConfigurationemfPackage;
import configurationemf.Frame;
import configurationemf.LeafSettingDelegator;
import configurationemf.ParentSetting;
import configurationemf.TYPE;

public class DefaultToValue  implements  IViewActionDelegate, IObjectActionDelegate { 

	ParentSetting setting =null;
	LeafSettingDelegator lsd =null;
	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		EObject selectedObject=null;
		if(selection instanceof IStructuredSelection) {
	           IStructuredSelection structedSelection = (IStructuredSelection)selection;
	           if(structedSelection.size()>0){
	        	   selectedObject=(EObject)structedSelection.getFirstElement();
	           }
	    }
		if (selectedObject instanceof ParentSetting)
		{
			action.setText("Use Default Value");
			setting = (ParentSetting)selectedObject;
			if(setting!=null && !setting.isReadOnly() && setting.getType()!=TYPE.SEQUENCE) 
				action.setEnabled(true);
			else
				action.setEnabled(false);
		}
		else if (selectedObject instanceof LeafSettingDelegator)
		{
			action.setText("Use Template Value");
			lsd = (LeafSettingDelegator)selectedObject;
			Frame frame = (Frame)lsd.eContainer();
			if(lsd!=null && lsd.canModifyValue() && !lsd.getLeafSetting().isReadOnly() && !frame.isTemplate()) 
				action.setEnabled(true);
			else
				action.setEnabled(false);
		}
		else
		{
			setting = null;
			lsd = null;
			action.setEnabled(false);

		}
	}

	public DefaultToValue() {
		
	}

	public void run(IAction action) {
		if (setting!=null)
		{
			String defaultValue= setting.getDefaultValue();
			setting.setCurrentValue(defaultValue);
			ConfigurationBrowser activeEditor = (ConfigurationBrowser)PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
			EditingDomain domain = activeEditor.getEditingDomain();
			Command command = SetCommand.create(domain, setting, ConfigurationemfPackage.eINSTANCE.getSetting_CurrentValue(), defaultValue);
			if(command!=null)
				domain.getCommandStack().execute(command);
		}
		else if (lsd!=null)
		{
			String templateValue = "";
			ParentSetting parentSetting = (ParentSetting)lsd.getLeafSetting().eContainer();
			for (LeafSettingDelegator templateLSD : parentSetting.getTemplate().getLeafSettings())
			{
				if (templateLSD.getLeafSetting().getRef().equals(lsd.getLeafSetting().getRef()))
				{
					templateValue = templateLSD.getValue();
					break;
				}
			}
			ConfigurationBrowser activeEditor = (ConfigurationBrowser)PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
			EditingDomain domain = activeEditor.getEditingDomain();
			Command command = SetCommand.create(domain, lsd, ConfigurationemfPackage.eINSTANCE.getSetting_CurrentValue(), templateValue);
			if(command!=null)
				domain.getCommandStack().execute(command);
		}
	}

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
	}

	public void init(IViewPart view) {	
	}
}
