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
package adapterFactories;

import interfaces.AdapterTypes;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;

import views.IDescriptionPage;
import configurationemf.ConfigurationemfPackage;
import configurationemf.LeafSettingDelegator;
import configurationemf.Setting;

public class SettingAdapterFactory implements IAdapterFactory {

	IDescriptionPage descriptionPage = new IDescriptionPage(){
		EditingDomain domain = null;
		public String getDescValue(Object owner) {
			Setting setting = getSetting(owner);
			return setting!=null?setting.getDesc():null;
		}
		public void updateDescription( Object owner, String description )
		{
			domain = AdapterFactoryEditingDomain.getEditingDomainFor(getSetting(owner));
			Command command = SetCommand.create(domain, getSetting(owner), ConfigurationemfPackage.eINSTANCE.getAttributeAndDesc_Desc(), description);
			if(command!=null)domain.getCommandStack().execute(command);
		}
		public boolean isEditable(Object owner) {
			Setting setting = getSetting(owner);
			if(setting!=null) {
				return !setting.isRo();				
			} else {
				return false;
			}
		}
		private Setting getSetting(Object setting){
			if(setting instanceof LeafSettingDelegator)return ((LeafSettingDelegator)setting).getLeafSetting();
			else return (Setting)setting;
		}
		
	};
	
	@SuppressWarnings("unchecked")
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if(adapterType.equals(AdapterTypes.TYPE_DESCRIPTION))
			if(adaptableObject instanceof Setting 
					|| adaptableObject instanceof LeafSettingDelegator) {
				return descriptionPage;				
			}
		return null;
	}

	public Class[] getAdapterList() {
		return null;
	}

}
