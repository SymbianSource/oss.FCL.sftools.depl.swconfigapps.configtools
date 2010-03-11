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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EStructuralFeature;

import cenrep.CenrepPackage;
import cenrep.provider.CenrepItemProviderAdapterFactory;
import cenrep.provider.KeyRangeItemProvider;

public class BrowserByNameAdapterFactory extends
		CenrepItemProviderAdapterFactory {

	@Override
	public Adapter createKeyAdapter() {
		if (keyItemProvider == null) {
			keyItemProvider = new BrowserKeyByName(this);
		}
		return keyItemProvider;
	}

	@Override
	public Adapter createRepositoryAdapter() {
		if (repositoryItemProvider == null) {
			repositoryItemProvider = new BrowserRepositoryByName(this);
		}

		return repositoryItemProvider;
	}
	
	
	public Adapter createKeyRangeAdapter() {
		if (keyRangeItemProvider == null) {
			keyRangeItemProvider = new KeyRangeItemProvider(this){
				
				public Collection getChildrenFeatures(Object object) {
					if(childrenFeatures==null){
						childrenFeatures = new ArrayList<EStructuralFeature>();
						childrenFeatures.remove(CenrepPackage.Literals.IACCESSABLE__ACCESS);
					}
					return childrenFeatures;
				}
			};
			
		}

		return keyRangeItemProvider;
	}
	
}
