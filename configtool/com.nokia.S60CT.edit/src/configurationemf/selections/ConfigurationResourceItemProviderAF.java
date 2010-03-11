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
package configurationemf.selections;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;

public class ConfigurationResourceItemProviderAF extends
		ResourceItemProviderAdapterFactory {
	
	ConfigurationResourceSetItemProvider resourceSetIP=null;
	
	
	
	public Adapter createResourceSetAdapter() {
		resourceSetIP = new ConfigurationResourceSetItemProvider(this);
		return resourceSetIP;
	}

	public ConfigurationResourceSetItemProvider getResourceSetIP() {
		return resourceSetIP;
	}

}
