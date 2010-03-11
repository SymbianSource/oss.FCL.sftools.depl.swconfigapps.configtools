/*
 * Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies). 
 * All rights reserved.
 * This component and the accompanying materials are made available
 * under the terms of "Eclipse Public License v1.0"
 * which accompanies this distribution, and is available
 * at the URL "http://www.eclipse.org/legal/epl-v10.html".
 * 
 * Initial Contributors:
 * Nokia Corporation - Initial contribution
 * 
 * Contributors:
 * 
 * Description: This file is part of com.nokia.tools.vct.confml.search.ui component.
 */

package search.ui.providers;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;

import com.nokia.tools.vct.confml.model.confml1.edit.provider.EConfML1ItemProviderAdapterFactory;
import com.nokia.tools.vct.confml.model.xsd.provider.EXSDFacetItemProviderAdapterFactory;

public class AllElementsItemProviderAdapterFactory extends
		ComposedAdapterFactory

{
	public AllElementsItemProviderAdapterFactory() {
		super(new AdapterFactory[] { new EcoreItemProviderAdapterFactory(),

		new EConfML1ItemProviderAdapterFactory(),

		new EXSDFacetItemProviderAdapterFactory(),

		new ResourceItemProviderAdapterFactory() });
	}
}
