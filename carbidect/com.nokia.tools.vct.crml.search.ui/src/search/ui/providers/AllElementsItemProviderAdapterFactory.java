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

package search.ui.providers;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;

import com.nokia.tools.vct.crml.crmodel.provider.ECRMLItemProviderAdapterFactory;

public class AllElementsItemProviderAdapterFactory extends
		ComposedAdapterFactory

{
	public AllElementsItemProviderAdapterFactory() {
		super(new AdapterFactory[] { new EcoreItemProviderAdapterFactory(),

		new ECRMLItemProviderAdapterFactory(),

		new ResourceItemProviderAdapterFactory() });
	}
}