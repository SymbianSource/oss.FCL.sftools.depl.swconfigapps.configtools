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
 * Description: This file is part of com.nokia.tools.vct.navigator.confml component.
 */

package com.nokia.tools.vct.navigator.confml;


import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import com.nokia.tools.vct.confml.model.confml1.edit.provider.EConfML1ItemProviderAdapterFactory;
import com.nokia.tools.vct.confml.model.confml1.include.provider.EConfMLIncludeItemProviderAdapterFactory;
import com.nokia.tools.vct.confml.model.confml2.provider.EConfML2ItemProviderAdapterFactory;


public class ConfmlLabelProvider extends LabelProvider {

	AdapterFactoryLabelProvider provider;
	
	public ConfmlLabelProvider() {
		ComposedAdapterFactory byNameAdapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		byNameAdapterFactory.addAdapterFactory(new EConfML1ItemProviderAdapterFactory());
		byNameAdapterFactory.addAdapterFactory(new EConfML2ItemProviderAdapterFactory());
		byNameAdapterFactory.addAdapterFactory(new EConfMLIncludeItemProviderAdapterFactory());

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
