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

import interfaces.CellModifier;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.edit.provider.ITableItemLabelProvider;

import cenrep.provider.CenrepItemProviderAdapterFactory;

public class SimpleKeyAdapterFactory extends CenrepItemProviderAdapterFactory {

	public SimpleKeyAdapterFactory() {
		super();
		supportedTypes.add(ITableItemLabelProvider.class);
		supportedTypes.add(CellModifier.class);
	}

	@Override
	public Adapter createKeyAdapter() {
		if (keyItemProvider == null) {
			keyItemProvider = new SimpleKeyItemProvider(this);
		}

		return keyItemProvider;
	}

	@Override
	public Adapter createRepositoryAdapter() {
		if (keyItemProvider == null) {
			keyItemProvider = new SimpleKeyItemProvider(this);
		}

		return keyItemProvider;
	}
	
}
