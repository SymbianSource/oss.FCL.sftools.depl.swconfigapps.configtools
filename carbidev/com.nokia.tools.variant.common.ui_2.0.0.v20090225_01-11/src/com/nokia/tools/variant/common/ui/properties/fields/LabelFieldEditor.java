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
 * Description: This file is part of com.nokia.tools.variant.common.ui component.
 */

package com.nokia.tools.variant.common.ui.properties.fields;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.widgets.FormToolkit;

public class LabelFieldEditor extends FieldEditor {
	
	public static final String PROP_LABEL_TEXT = "PROP_LABEL_TEXT";
	
	protected String labelText = "";
	protected StyledText labelControl;

	
	@Override
	public void fillIntoGrid(Composite parent, int columns, FormToolkit toolkit) {
		labelControl = createLabelControl(parent, toolkit);
		labelControl.setLayoutData(createLayoutDataForLabel(columns));
	}
	
	public StyledText getLabelControl() {
		return labelControl;
	}
	
	protected StyledText createLabelControl(Composite parent, FormToolkit toolkit) {
		StyledText control = new StyledText(parent,SWT.NONE);//toolkit.createLabel(parent, labelText);
		control.setText(labelText);
		control.getCaret().setVisible(false);
		control.setEditable(false);
		return control;
	}
	
	protected GridData createLayoutDataForLabel(int nColumns) {
		GridData gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false);
		gridData.horizontalSpan = nColumns;
		return gridData;
	}
	
	public void setLabelText(String labelText) {
		this.labelText = labelText;
		if (canUseControl(labelControl)) {
			labelControl.setText(labelText);
		}
		setChanged();
		notifyObservers(PROP_LABEL_TEXT);
	}
	
	@Override
	protected int getNumberOfControls() {
		return 1;
	}
	
	@Override
	protected Control[] getControls() {
		return new Control[] {labelControl};
	}
}
