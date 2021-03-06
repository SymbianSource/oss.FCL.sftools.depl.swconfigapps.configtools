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

package com.nokia.tools.variant.viewer.widgets;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
/**
 * Widget graphically represents string setting.
 */
public class StringTextBox extends BaseTextBox {

	public StringTextBox(Composite parent, int style, String widgetLabel) {
		super(parent, style, widgetLabel);

	}

	public StringTextBox(Composite parent, int style, String widgetLabel, Image image) {
		super(parent, style, widgetLabel, image);

	}

	public StringTextBox(Composite parent, int style, String widgetLabel, WidgetOptions options, Image image) {
		super(parent, style, widgetLabel, options, image);
	}

	public void setValid(boolean isValid) {
		if (isValid)
			this.text.setBackground(GUIConstants.COLOR_WHITE);
		else
			this.text.setBackground(GUIConstants.COLOR_ERROROUS_RED);
	}
	
	@Override
	public void cut() {
		text.cut();
	}
	
	@Override
	public void copy() {
		text.copy();
	}
	
	@Override
	public void paste() {
		text.paste();
	}
	
	@Override
	public void delete() {
		synchronized (text) {			
			Point selection = text.getSelection();			
			String content = text.getText();			
			String result = content.substring(0, selection.x);
			result += content.substring(selection.y, content.length());
			text.setText(result);
			text.update();
		}		
	}	

}
