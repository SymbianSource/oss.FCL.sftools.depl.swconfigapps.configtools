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

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;

public class StringTextBox extends BaseTextBox {

	public StringTextBox(Composite parent, int style, String widgetLabel) {
		super(parent, style, widgetLabel);

	}

	public StringTextBox(Composite parent, int style, String widgetLabel,WidgetOptions options, Image image) {
		super(parent, style, widgetLabel,options,image);

	}

	public void setValid(boolean isValid) {
		if (isValid)
			this.text.setBackground(GUIConstants.COLOR_WHITE);
		else
			this.text.setBackground(GUIConstants.COLOR_ERROROUS_RED);
	}

}
