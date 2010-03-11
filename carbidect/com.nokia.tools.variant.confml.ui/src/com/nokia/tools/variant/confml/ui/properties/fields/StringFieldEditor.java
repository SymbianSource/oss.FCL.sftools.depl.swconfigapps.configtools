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
 * Description: This file is part of com.nokia.tools.variant.confml.ui component.
 */

package com.nokia.tools.variant.confml.ui.properties.fields;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.nokia.tools.vct.common.ui.utils.PixelConverter;

public class StringFieldEditor extends LabelFieldEditor {

	private String textValue;
	private int style;
	private Text textControl;
	
	public StringFieldEditor() {
		this(SWT.NONE);
	}
	
	public StringFieldEditor(int style) {
		this.style = style;
	}
	
	public void setTextValue(String textValue) {
		this.textValue = textValue;
		if (canUseControl(textControl)) {
			textControl.setText(textValue);
		}
	}
	
	public String getTextValue() {
		return textValue;
	}
	
	@Override
	public void fillIntoGrid(Composite parent, int columns, FormToolkit toolkit) {
		super.fillIntoGrid(parent, 1, toolkit);
		
		textControl = createTextControl(parent, toolkit);
		GridData gridData = createLayoutDataForText(columns - 1);
		if ((style & SWT.MULTI) != 0) {
			gridData.minimumHeight = new PixelConverter(parent).convertHeightInCharsToPixels(4);
		}
		textControl.setLayoutData(gridData);
		textControl.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				textValue = textControl.getText();
				setChanged();
				notifyObservers();
			}
		});
	}
	
	public Text getTextControl() {
		return textControl;
	}
	
	protected Text createTextControl(Composite parent, FormToolkit toolkit) {
		Text control = toolkit.createText(parent, textValue, style);
		control.setEditable(editable);
		return control;
	}
	
	protected GridData createLayoutDataForText(int columns) {
		GridData gridData;
		if ((style & SWT.MULTI) != 0) {
			gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		} else {
			gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
		}
		gridData.horizontalSpan = columns;
		return gridData;
	}
	
	@Override
	protected GridData createLayoutDataForLabel(int columns) {
		GridData data = super.createLayoutDataForLabel(columns);
		data.verticalAlignment = SWT.TOP;
		return data;
	}
	
	@Override
	protected int getNumberOfControls() {
		return 2;
	}
	
	@Override
	protected Control[] getControls() {
		return new Control[] {getTextControl(), getLabelControl()};
	}
	
	private boolean editable = true;
	
	public void setEditable(boolean flag) {
		this.editable = flag;
		if (canUseControl(textControl)) {
			textControl.setEditable(flag);
		}
	}
}
