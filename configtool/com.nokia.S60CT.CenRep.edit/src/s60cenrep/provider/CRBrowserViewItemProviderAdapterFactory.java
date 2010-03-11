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

import org.eclipse.emf.common.notify.Adapter;

import cenrep.provider.CenrepItemProviderAdapterFactory;

public class CRBrowserViewItemProviderAdapterFactory extends
		CenrepItemProviderAdapterFactory {
	
	public CRBrowserViewItemProviderAdapterFactory() {
		super();/*!*/
	}
	
	public Adapter createKeyAdapter() {
		if (keyItemProvider == null) {
			keyItemProvider = new KeyForCRBrowserView(this);
		}

		return keyItemProvider;
	}
	
	
	public Adapter createRepositoryAdapter(){
		if(repositoryItemProvider == null){
			repositoryItemProvider = new RepositoryForCRBrowserView(this);
		}
		return repositoryItemProvider;
	}
			

}
