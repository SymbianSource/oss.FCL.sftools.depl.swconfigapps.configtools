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

package com.nokia.s60ct.gui.viewer;

import java.util.Map;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

import configurationemf.ICellEditorProvider;
import configurationemf.IDynamicColumnProvider;
import configurationemf.IPVContentProvider;
import configurationemf.ISequenceValueProvider;

public class DCAdapterFactoryLabelProvider extends AdapterFactoryLabelProvider 
	implements IDynamicColumnProvider, IPVContentProvider, ISequenceValueProvider, ICellEditorProvider {
	
	private static final Class IDynamicColumnProviderClass = IDynamicColumnProvider.class;
	private static final Class IPVContentProviderClass = IPVContentProvider.class;
	private static final Class ISequenceValueProviderClass = ISequenceValueProvider.class;
	private static final Class ICellEditorProviderClass = ICellEditorProvider.class;
	
	public DCAdapterFactoryLabelProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	public Map getConfValues(Object object) {
		IDynamicColumnProvider dynamicColumnProvider = (IDynamicColumnProvider)adapterFactory.adapt(object, IDynamicColumnProviderClass);
		return dynamicColumnProvider!=null?dynamicColumnProvider.getConfValues(object):null;
	}

	public String[] getPossibleValues(Object object) {
		IPVContentProvider possibleValueProvider = (IPVContentProvider)adapterFactory.adapt(object, IPVContentProviderClass);
		return possibleValueProvider!=null?possibleValueProvider.getPossibleValues(object):null;
	}

	public Object getValue(Object object) {
		IPVContentProvider possibleValueProvider = (IPVContentProvider)adapterFactory.adapt(object, IPVContentProviderClass);
		return possibleValueProvider!=null?possibleValueProvider.getValue(object):null;
	}

	public Map getPairItems(Object setting, int column) {
		ICellEditorProvider cellEditorProvider = (ICellEditorProvider)adapterFactory.adapt(setting, ICellEditorProviderClass);
		return cellEditorProvider!=null?cellEditorProvider.getPairItems(setting, column):null;
	}

	public int getCellEditor(Object setting, int column) {
		ICellEditorProvider cellEditorProvider = (ICellEditorProvider)adapterFactory.adapt(setting, ICellEditorProviderClass);
		return cellEditorProvider!=null?cellEditorProvider.getCellEditor(setting, column):ICellEditorProvider.NO_EDITOR;
	}

	public String getValueForFrame(Object leafSetting, int nFrame) {
		ISequenceValueProvider sequenceValueProvider = (ISequenceValueProvider)adapterFactory.adapt(leafSetting, ISequenceValueProviderClass);
		return sequenceValueProvider!=null?sequenceValueProvider.getValueForFrame(leafSetting, nFrame):null;
	}

	public int getSequenceNumber(Object leafSetting) {
		IDynamicColumnProvider dynamicColumnProvider = (IDynamicColumnProvider)adapterFactory.adapt(leafSetting, IDynamicColumnProviderClass);
		return dynamicColumnProvider!=null?dynamicColumnProvider.getSequenceNumber(leafSetting):0;
	}
	
	
}
