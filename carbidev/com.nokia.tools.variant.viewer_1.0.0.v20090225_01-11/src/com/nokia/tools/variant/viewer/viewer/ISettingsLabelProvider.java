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
 * Description: This file is part of com.nokia.tools.variant.viewer component.
 */

package com.nokia.tools.variant.viewer.viewer;

import org.eclipse.jface.viewers.ILabelProvider;

import com.nokia.tools.variant.viewer.widgets.WidgetOptions;
/**
 * Label provider for {@link SettingsViewer}
 * 
 */
public interface ISettingsLabelProvider extends ILabelProvider {
	/**
	 * 
	 * @param element
	 * @return {@link Type} of the element, which used in the viewer to
	 *         recognize what kind of widget it should create
	 */
	Type getType(Object element);

	/**
	 * 
	 * @param element
	 * @return options for the element, used for example in combo box
	 */
	WidgetOptions getOptions(Object element);
}
