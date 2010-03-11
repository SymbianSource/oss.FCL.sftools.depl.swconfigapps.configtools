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
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;

public class CRBrowserResourceAdapterFactory extends
		ResourceItemProviderAdapterFactory {
	
	@Override
	public Adapter createResourceAdapter() {
		return new BrowserResourceItemProvider(this);
	}
	
}
