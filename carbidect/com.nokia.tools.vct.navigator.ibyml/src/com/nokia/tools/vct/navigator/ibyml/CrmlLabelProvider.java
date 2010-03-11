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
 * Description: This file is part of com.nokia.tools.vct.navigator.ibyml component.
 */

package com.nokia.tools.vct.navigator.ibyml;


import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import com.nokia.tools.vct.ibyml.ibymodel.provider.EIBYModelItemProviderAdapterFactory;


public class CrmlLabelProvider extends LabelProvider {

	AdapterFactoryLabelProvider provider;
	
	public CrmlLabelProvider() {
		ComposedAdapterFactory byNameAdapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		byNameAdapterFactory.addAdapterFactory(new EIBYModelItemProviderAdapterFactory());

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
