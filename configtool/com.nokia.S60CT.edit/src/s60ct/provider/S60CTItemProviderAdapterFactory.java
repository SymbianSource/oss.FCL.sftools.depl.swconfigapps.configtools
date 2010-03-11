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

import interfaces.CellModifier;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.edit.provider.ITableItemLabelProvider;

import configurationemf.ICellEditorProvider;
import configurationemf.IDynamicColumnProvider;
import configurationemf.IPVContentProvider;
import configurationemf.ISequenceValueProvider;
import configurationemf.provider.ConfigurationemfItemProviderAdapterFactory;


public class S60CTItemProviderAdapterFactory extends
		ConfigurationemfItemProviderAdapterFactory {

	
	public Adapter createParentSettingAdapter() {
		if (parentSettingItemProvider == null) {
			parentSettingItemProvider = new ParentSettingForFeatureView(this);
		}

		return parentSettingItemProvider;
	}
	
	

	
	@Override
	public Adapter createFrameAdapter() {
		if (frameItemProvider == null) {
			frameItemProvider = new FrameItemProvider(this);
		}

		return frameItemProvider;
	}

	LSDelegateItemProvider lSDelegatorItemProvider=null;


	@Override
	public Adapter createLeafSettingDelegatorAdapter() {
		if (lSDelegatorItemProvider == null) {
			lSDelegatorItemProvider = new LSDelegateItemProvider(this);
		}

		return lSDelegatorItemProvider;
	}
	
	public Adapter createGSettingAdapter() {
		if (gSettingItemProvider == null) {
			gSettingItemProvider = new GSettingForSettingEditor(this);
		}
		return gSettingItemProvider;
	}
	
	
	/* (non-Javadoc)
	 * @see configurationemf.provider.ConfigurationemfItemProviderAdapterFactory#createParentGroupAdapter()
	 */
	public Adapter createParentGroupAdapter() {
		if (parentGroupItemProvider == null) {
			parentGroupItemProvider = new GroupForSettingEditor(this);
		}
		return parentGroupItemProvider;
	}

	public Adapter createRootConfAdapter() {
		if (rootConfItemProvider == null) {
			rootConfItemProvider = new RootConfForFeatureView(this);
		}
		return rootConfItemProvider;
	}

	
	
	public S60CTItemProviderAdapterFactory() {
		super();
		supportedTypes.add(ITableItemLabelProvider.class);
		supportedTypes.add(IDynamicColumnProvider.class);
		supportedTypes.add(IPVContentProvider.class);
		supportedTypes.add(ISequenceValueProvider.class);
		supportedTypes.add(ICellEditorProvider.class);
		supportedTypes.add(CellModifier.class);
	}
	
	
}
