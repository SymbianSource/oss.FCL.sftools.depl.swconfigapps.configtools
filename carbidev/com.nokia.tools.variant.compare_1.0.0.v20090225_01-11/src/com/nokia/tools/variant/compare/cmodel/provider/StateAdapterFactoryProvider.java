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
 * Description: This file is part of com.nokia.tools.variant.compare component.
 */

package com.nokia.tools.variant.compare.cmodel.provider;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;

import com.nokia.tools.variant.compare.ICheckEnabledLabelProvider;
import com.nokia.tools.variant.compare.ITableAnnotationProvider;
import com.nokia.tools.variant.compare.ITableTooltipProvider;

public class StateAdapterFactoryProvider extends
		AdapterFactoryLabelProvider.FontAndColorProvider implements

ICheckEnabledLabelProvider, ITableTooltipProvider, ITableAnnotationProvider {

	private static final Class<?> IItemCheckEnabledProviderClass = IItemCheckEnabledProvider.class;
	private static final Class<?> ITableItemTooltipProviderClass = ITableItemTooltipProvider.class;
	private static final Class<?> ITableItemAnnotationProviderClass = ITableItemAnnotationProvider.class;

	public StateAdapterFactoryProvider(AdapterFactory arg0, Viewer arg1) {
		super(arg0, arg1);
	}

	public boolean isCheckEnabled(Object object) {
		IItemCheckEnabledProvider provider = (IItemCheckEnabledProvider) adapterFactory
				.adapt(object, IItemCheckEnabledProviderClass);
		return provider == null ? true : provider.isCheckEnabled(object);
	}

	public boolean isChecked(Object object) {
		IItemCheckEnabledProvider provider = (IItemCheckEnabledProvider) adapterFactory
				.adapt(object, IItemCheckEnabledProviderClass);
		return provider == null ? true : provider.isChecked(object);
	}

	public boolean setChecked(Object object, boolean checked) {
		IItemCheckEnabledProvider provider = (IItemCheckEnabledProvider) adapterFactory
				.adapt(object, IItemCheckEnabledProviderClass);
		return provider == null ? true : provider.setChecked(object, checked);
	}

	public String getColumnTooltip(Object object, int column) {
		ITableItemTooltipProvider provider = (ITableItemTooltipProvider) adapterFactory
				.adapt(object, ITableItemTooltipProviderClass);

		return provider == null ? null : provider.getTooltip(object, column);
	}

	public Font getAnnotationFont(Object object, int columnIndex) {
		ITableItemAnnotationProvider provider = (ITableItemAnnotationProvider) adapterFactory
				.adapt(object, ITableItemAnnotationProviderClass);

		return provider == null ? null : getFontFromObject(provider
				.getAnnotationFont(object, columnIndex));
	}

	public String getAnnotationText(Object object, int columnIndex) {
		ITableItemAnnotationProvider provider = (ITableItemAnnotationProvider) adapterFactory
				.adapt(object, ITableItemAnnotationProviderClass);

		return provider == null ? null : provider.getAnnotationText(object,
				columnIndex);
	}

	public Color getAnnotationForeground(Object object, int columnIndex) {
		ITableItemAnnotationProvider provider = (ITableItemAnnotationProvider) adapterFactory
				.adapt(object, ITableItemAnnotationProviderClass);

		return provider == null ? null : getColorFromObject(provider
				.getAnnotationForeground(object, columnIndex));
	}
}
