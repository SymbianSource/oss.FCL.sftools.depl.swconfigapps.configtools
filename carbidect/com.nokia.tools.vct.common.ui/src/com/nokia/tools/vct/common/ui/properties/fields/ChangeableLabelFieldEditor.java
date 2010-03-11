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
 * Description: This file is part of com.nokia.tools.vct.common.ui component.
 */

package com.nokia.tools.vct.common.ui.properties.fields;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.nokia.tools.vct.common.ui.utils.PixelConverter;

public class ChangeableLabelFieldEditor extends LabelFieldEditor {

	private String textValue;
	private int style;
	private StyledText textControl;

	public ChangeableLabelFieldEditor() {
		this(SWT.NONE);
	}

	public ChangeableLabelFieldEditor(int style) {
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
			textControl = createLabelControl(parent, toolkit);
			if (textValue != null)
			  textControl.setText(textValue);
			GridData gridData = createLayoutDataForText(columns - 1);
			if ((style & SWT.MULTI) != 0) {
				gridData.heightHint = new PixelConverter(parent)
						.convertHeightInCharsToPixels(4);
			}
			gridData.widthHint = 200;
			textControl.setLayoutData(gridData);
	}

	public StyledText getTextControl() {
		return textControl;
	}
	@Override
	protected StyledText createLabelControl(Composite parent, FormToolkit toolkit) {
		StyledText control = new StyledText(parent,style);//toolkit.createLabel(parent, labelText);
		control.setText(labelText);
		control.getCaret().setVisible(false);
		control.setEditable(false);
		return control;
	}

	protected Label createTextControl(Composite parent, FormToolkit toolkit) {
		Label control = toolkit.createLabel(parent, textValue, style);
		return control;
	}

	protected GridData createLayoutDataForText(int columns) {
		GridData gridData;
		if ((style & SWT.MULTI) != 0) {
			gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
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
		return new Control[] { getTextControl(), getLabelControl() };
	}

	public void setEnabled(boolean flag) {
		if (canUseControl(textControl)) {
			textControl.setEnabled(flag);
			labelControl.setEnabled(flag);
		}
	}
}
