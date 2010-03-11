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
 * Description: This file is part of com.nokia.tools.vct.navigator.gcfml component.
 */

package com.nokia.tools.vct.navigator.gcfml;


import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import com.nokia.tools.vct.gcfml.gcfmlmodel.provider.EGCFMLItemProviderAdapterFactory;


public class GcfmlLabelProvider extends LabelProvider {

	AdapterFactoryLabelProvider provider;
	
	public GcfmlLabelProvider() {
		ComposedAdapterFactory byNameAdapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		byNameAdapterFactory.addAdapterFactory(new EGCFMLItemProviderAdapterFactory());
//		byNameAdapterFactory.addAdapterFactory(new CenrepItemProviderAdapterFactory());
//		byNameAdapterFactory.addAdapterFactory(new CRBrowserResourceAdapterFactory());

		provider = new AdapterFactoryLabelProvider(byNameAdapterFactory);
	}
	
	@Override
	public String getText(Object element) {
		return provider.getText(element);
	}
	
	@Override
	public Image getImage(Object element) {
		return provider.getImage(element);
	}
}
