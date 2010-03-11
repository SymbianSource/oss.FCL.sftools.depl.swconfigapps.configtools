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

import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class InflatableLabel extends Label {

	private String text = "";
	private int maxPixels = 100;

	public InflatableLabel(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	protected void checkSubclass() {

	}

	public void setText(String string) {
		this.setToolTipText(string);
		text = string;
		GC gc = new GC(this);
		Point extent = gc.textExtent(string);//$NON-NLS-1$
		if (maxPixels >= extent.x) {
			super.setText(string);
		} else {
			int length = string.length() * maxPixels / extent.x;
			String substring = string.substring(0, length - 3) + "...";
			// check it again and take one char by one, until max pixel is
			// ok
			super.setText(substring);
		}
		gc.dispose();
	}

	public String getText() {
		return text;
	}

	public int getMaxPixels() {
		return maxPixels;
	}

	public void setMaxPixels(int maxPixels) {
		this.maxPixels = maxPixels;
		setText(text);
	}

	@Override
	public void setFont(Font font) {
		super.setFont(font);
		setText(text);
	}
}
