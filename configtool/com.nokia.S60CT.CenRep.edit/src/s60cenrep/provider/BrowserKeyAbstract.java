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

import cenrep.provider.KeyItemProvider;

public abstract class BrowserKeyAbstract extends KeyItemProvider {

	public BrowserKeyAbstract(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public Collection getChildrenFeatures(Object object) {
		if(childrenFeatures==null){ 
			childrenFeatures = new ArrayList<EStructuralFeature>();
		}
		return super.getChildrenFeatures(object);
	}

	@Override
	public abstract  String getText(Object object);

	@Override
	public List getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			itemPropertyDescriptors = new ArrayList<IItemPropertyDescriptor>();
			addBackupPropertyDescriptor(object);
			addReadOnlyPropertyDescriptor(object);
			addTypePropertyDescriptor(object);
			addNamePropertyDescriptor(object);
			addShortIdentPropertyDescriptor(object);
			addRefPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	
	
}
