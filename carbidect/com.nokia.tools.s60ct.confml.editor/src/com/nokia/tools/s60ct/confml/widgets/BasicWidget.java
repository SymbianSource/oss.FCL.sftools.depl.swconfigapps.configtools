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

package com.nokia.tools.s60ct.confml.widgets;

import java.util.Map;

import org.eclipse.swt.widgets.Composite;

public interface BasicWidget {

	public static final int SPACING = 10;
	public static final int PADDING = 5;
	public static final int DEFAULT_WIDTH_LABEL = 250;
	public static final int DEFAULT_WIDTH_DEFAULT_MARK = 70;
	public static final int WIDTH_INPUT_BOX = 250;

	public void attachListeners();

	public void buildWidget(Composite composite, String widgetLabel);

	public void dispose();

	public void select();

	public void deselect();

	public boolean isSelected();

	public void focus();

	public void unfocus();

	public void buildWidget(Composite composite, String label,
			Map<String, String> options);

	public boolean hasFocus();

	public void setValue(String oldValue);

	public String getValue();

	public void setValid(boolean isValid);

}