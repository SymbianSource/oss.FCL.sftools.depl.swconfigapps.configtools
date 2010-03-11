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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;

import views.IDescriptionPage;

import cenrep.CenrepPackage;
import cenrep.Key;

public class KeyAdapterFactory implements IAdapterFactory{
	private IDescriptionPage keyDescriptionPage = new IDescriptionPage(){
		public String getDescValue(Object owner) {
			return ((Key)owner).getDesc();
		}
		public void updateDescription( Object owner, String description )
		{
			EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor((EObject)owner);
			Command command	= SetCommand.create(domain, owner, CenrepPackage.eINSTANCE.getAttributeAndDescription_Desc(), description);
			if(command!=null)domain.getCommandStack().execute(command);
		}
		public boolean isEditable(Object owner) {
			return true;
		}
	};
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if(adapterType.equals(AdapterTypes.TYPE_DESCRIPTION))
			return keyDescriptionPage;
		return null;
	}

	public Class[] getAdapterList() {
		return null;
	}

}
