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

package s60cenrep.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;

import cenrep.CenrepPackage;
import cenrep.provider.RepositoryItemProvider;

public abstract class BrowserRepositoryAbstract extends RepositoryItemProvider {
	public BrowserRepositoryAbstract(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}
	
	public Collection getChildrenFeatures(Object object) {
		if(childrenFeatures==null){
			childrenFeatures = new ArrayList<EStructuralFeature>();
			childrenFeatures.add(CenrepPackage.Literals.REPOSITORY__KEY);
			childrenFeatures.add(CenrepPackage.Literals.REPOSITORY__RANGE_KEY);
		}
		return childrenFeatures;
	}

	@Override
	public abstract String getText(Object object);

	@Override
	public List getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			itemPropertyDescriptors = new ArrayList<IItemPropertyDescriptor>();
			
			addBackupPropertyDescriptor(object);
			addUidNamePropertyDescriptor(object);
			addUidValuePropertyDescriptor(object);
			addVersionPropertyDescriptor(object);
			addOwnerPropertyDescriptor(object);
			addRfsPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	
	
}
