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

import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import com.nokia.tools.variant.viewer.widgets.BaseConfMLWidget;


/**
 * It represents UI component which offers single line input for inserting a text. 
 *
 */
public class ShortStringTextBox extends BaseConfMLWidget{
	int styleBox =0;
	private Label label;
	public ShortStringTextBox(Composite parent, int style, String widgetLabel,
			Image image, int styleBox) {
		super(parent, style, widgetLabel, image);
		this.styleBox=styleBox;
	}
	
	protected void buildMainControl() {

		label = new Label(group,SWT.LEFT);
		label.setBackground(group.getBackground());
		GridData data = new GridData();
		label.setLayoutData(data);

	}
	
	public void refresh(String currentValue) {
		label.setText(currentValue);
		
	}

	@Override
	public void setValue(String value) {
		if (label.isDisposed()) {
			return;
		}

		if(value==null){
			value="";
		}
			if (!label.getText().equals(value)) {
				label.setText(value);
			}

	}

	@Override
	public String getValue() {
		return label.getText();
	}
	protected Control[] getControls() {
		return new Control[] {label};
	}

	@Override
	public void clearErrorMessage() {
		
		
	}

	public void buildWidget(Composite composite, String label,
			Map<String, String> options) {
		
		
	}
	@Override
	public void addListener(Listener listener) {
		super.addListener(listener);
		label.addListener(SWT.Selection, listener);
		label.addListener(SWT.MouseDown, listener);
	}


	@Override
	protected void drawSelectUI() {
		super.drawSelectUI();
		label.setBackground(group.getBackground());
	}

	@Override
	protected void drawDeselectUI() {
		super.drawDeselectUI();
		label.setBackground(group.getBackground());
	}
	
}
