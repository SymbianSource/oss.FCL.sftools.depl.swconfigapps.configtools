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

package s60ct.provider;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.edit.provider.ITableItemLabelProvider;

import configurationemf.provider.ConfigurationemfItemProviderAdapterFactory;

public class ViewEditorItemProviderAdapterFactory extends
		ConfigurationemfItemProviderAdapterFactory {

	public ViewEditorItemProviderAdapterFactory() {
		super();
		supportedTypes.add(ITableItemLabelProvider.class);
	}
	public Adapter createViewAdapter() {
		if (viewItemProvider == null) {
			viewItemProvider = new ViewForViewEditor(this);
		}
		return viewItemProvider;
	}

	public Adapter createGSettingAdapter() {
		if (gSettingItemProvider == null) {
			gSettingItemProvider = new GSettingForViewEditor(this);
		}
		return gSettingItemProvider;
	}

	public Adapter createGroupAdapter() {
		if ( parentGroupItemProvider == null) {
			parentGroupItemProvider = new GroupForViewEditor(this);
		}
		return parentGroupItemProvider;
	}
	public Adapter createLeafGroupAdapter() {
		if ( leafGroupItemProvider == null) {
			leafGroupItemProvider = new LeafGroupForViewEditor(this);
		}
		return leafGroupItemProvider;
	}
	
		
}
