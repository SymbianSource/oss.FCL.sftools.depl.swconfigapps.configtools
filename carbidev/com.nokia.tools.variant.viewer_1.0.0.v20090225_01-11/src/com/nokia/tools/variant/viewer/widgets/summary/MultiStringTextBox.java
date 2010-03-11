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

package com.nokia.tools.variant.viewer.widgets.summary;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import com.nokia.tools.variant.viewer.widgets.BaseTextBox;

/**
 * It represents UI component which offers multi-line input for inserting a text. 
 *
 */
public class MultiStringTextBox extends BaseTextBox{


	public MultiStringTextBox(Composite parent, int style, String widgetLabel,
			Image image) {
		super(parent, SWT.NONE, widgetLabel, image);
		
	}

	@Override
	protected void buildMainControl() {
		
		
		text = new Text(group,SWT.BORDER | SWT.MULTI |SWT.V_SCROLL | SWT.WRAP);
		GridData data = new GridData();

		data.widthHint = 227;
		data.heightHint = 60;
		text.setLayoutData(data);

	}

	@Override
	protected GridData layoutDataForLabel(int width) {
		GridData gridData = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING|GridData.VERTICAL_ALIGN_BEGINNING);
		gridData.widthHint = width;
		return gridData;
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
			int caretPosition = text.getCaretPosition();
			String selectionText = text.getSelectionText();
			String content = text.getText();
			String result = "";
			result += content.substring(0, caretPosition
					- selectionText.length());
			result += content.substring(caretPosition, content.length());
			text.setText(result);
			text.update();
		}
	}
	
}
