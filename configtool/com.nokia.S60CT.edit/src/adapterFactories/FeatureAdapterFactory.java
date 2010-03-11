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
/**
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
import configurationemf.ConfigurationemfPackage;
import configurationemf.Feature;
import configurationemf.impl.FeatureImpl;

public class FeatureAdapterFactory implements IAdapterFactory {

	IDescriptionPage descriptionPage = new IDescriptionPage(){
		EditingDomain domain = null;
		
		public String getDescValue(Object owner) {
			Feature feature = (Feature)owner;
			return feature.getDesc()!=null?feature.getDesc():null;
		}
		
		public void updateDescription( Object owner, String description ){
			EObject eObject = (EObject)owner;
			domain = AdapterFactoryEditingDomain.getEditingDomainFor(eObject);
			Command command = SetCommand.create(domain, owner, ConfigurationemfPackage.eINSTANCE.getAttributeAndDesc_Desc(), description);
			if(command!=null)domain.getCommandStack().execute(command);
		}
		public boolean isEditable(Object owner) {
			return !((Feature)owner).isReadOnly();
		}
		};
	
	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.IAdapterFactory#getAdapter(java.lang.Object, java.lang.Class)
	 */
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if(adapterType.equals(AdapterTypes.TYPE_DESCRIPTION))
			return descriptionPage; 
			
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.IAdapterFactory#getAdapterList()
	 */
	public Class[] getAdapterList() {
		return new Class[]{
			IDescriptionPage.class,
			FeatureImpl.class
		};
	}

}
