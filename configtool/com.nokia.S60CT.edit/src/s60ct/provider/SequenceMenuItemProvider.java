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
package s60ct.provider;

import interfaces.ISequenceSettingMenu;

import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import command.AddFrameCommand;
import command.EmptySequenceCommand;
import command.RemoveFrameCommand;
import command.ShowDefaultCommand;

import configurationemf.Configuration;
import configurationemf.ConfigurationemfPackage;
import configurationemf.EXTENSION_POLICY;
import configurationemf.Frame;
import configurationemf.ParentSetting;
import configurationemf.Ref;

public class SequenceMenuItemProvider extends ItemProviderAdapter implements
		ISequenceSettingMenu {

	public SequenceMenuItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
		
	}

	@Override
	public EXTENSION_POLICY getExtensionPolicy(Object setting) {
		return ((ParentSetting)setting).getCurrentExtensionPolicy();
	}

	@Override
	public boolean isAddAllowed(Object setting) {
		ParentSetting pSetting = (ParentSetting)setting;
		return pSetting.canAddFrame();
	}

	@Override
	public boolean isAllowedPolicy(Object setting, EXTENSION_POLICY policy) {
		return ((ParentSetting)setting).canSetExtPolicy(policy);
	}

	@Override
	public boolean isRemoveItemAllowed(Object parent, Object child) {
		ParentSetting pSetting = (ParentSetting)parent;
		Frame frame = (Frame)child;
		return pSetting.canRemoveFrame(frame);
	}

	@Override
	public boolean isSequenceEmpty(Object setting) {
		ParentSetting pSetting = (ParentSetting)setting;
		List<Ref> refs = pSetting.getRefs();
		Configuration currentConf = pSetting.getCurrentConf();
		for(Ref ref : refs){
			if(ref.getConfiguration().equals(currentConf)&&ref.isEmpty())return true;
		}
		return false;
	}

	@Override
	public Command createCommand(Object object, EditingDomain domain,
			Class<? extends Command> commandClass,
			CommandParameter commandParameter) {
		if(commandParameter.feature==ConfigurationemfPackage.eINSTANCE.getParentSetting_Frames()){
			if(commandClass==RemoveCommand.class){//remove single frame command
				return  new RemoveFrameCommand(domain,commandParameter.getEOwner(),commandParameter.value);
			}else if(commandClass==RemoveFrameCommand.class){//remove all my current frames
				return  new RemoveFrameCommand(domain,commandParameter.getEOwner());
			}else if(commandClass==EmptySequenceCommand.class){//remove all, and make empty
				return  new EmptySequenceCommand(domain,commandParameter.getEOwner());
			}else if(commandClass==AddCommand.class){
				return new AddFrameCommand(domain,commandParameter.getEOwner());
			}else if(commandClass==ShowDefaultCommand.class){
				return new ShowDefaultCommand(domain,commandParameter.getEOwner());
			}
			
		}
		return super.createCommand(object, domain, commandClass, commandParameter);
	}

	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(ParentSetting.class)) {
			case ConfigurationemfPackage.PARENT_SETTING__CURRENT_EXTENSION_POLICY:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
			case ConfigurationemfPackage.PARENT_SETTING__TYPE:
					fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, true));
				return;
			
		}
		super.notifyChanged(notification);
	}
	
	
}
