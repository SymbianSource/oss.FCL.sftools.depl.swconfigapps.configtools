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

import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.jface.util.SafeRunnable;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.widgets.FormToolkit;

public class StringButtonFieldEditor extends StringFieldEditor {

	private String buttonText;
	private Button buttonControl;
	private IStringButtonAdapter buttonAdapter;
	
	public StringButtonFieldEditor() {
		this("", "!!button!!", null);
	}

	public StringButtonFieldEditor(String labelText, String buttonText, IStringButtonAdapter adapter) {
		setLabelText(labelText);
		setButtonText(buttonText);
		setButtonAdapter(adapter);
	}

	public void setButtonText(String buttonText) {
		this.buttonText = buttonText;
		if (canUseControl(buttonControl)) {
			buttonControl.setText(buttonText);
		}
	}
	
	public IStringButtonAdapter getButtonAdapter() {
		return buttonAdapter;
	}
	
	public void setButtonAdapter(IStringButtonAdapter buttonAdapter) {
		this.buttonAdapter = buttonAdapter;
	}
	
	@Override
	public void fillIntoGrid(Composite parent, int columns, FormToolkit toolkit) {
		super.fillIntoGrid(parent, columns - 1, toolkit);
		
		buttonControl = createButtonControl(parent, toolkit);
		buttonControl.setLayoutData(createLayoutDataForButton(1));
		buttonControl.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
				notifyStringButtonAdapter();
			}
			public void widgetSelected(SelectionEvent e) {
				notifyStringButtonAdapter();
			}
		});
	}
	
	protected void notifyStringButtonAdapter() {
		SafeRunner.run(new SafeRunnable() {
			public void run() throws Exception {
				StringButtonFieldEditor source = StringButtonFieldEditor.this;
				IStringButtonAdapter adapter = source.buttonAdapter;
				if (adapter != null) {
					adapter.changeControlPressed(source);
				}
			}
		});
	}
	
	private GridData createLayoutDataForButton(int columns) {
		GridData gd = new GridData(SWT.CENTER, SWT.CENTER, false, false);
		gd.horizontalSpan = columns;
		return gd;
	}

	protected Button createButtonControl(Composite parent, FormToolkit toolkit) {
		return toolkit.createButton(parent, buttonText, SWT.NONE);
	}

	@Override
	protected int getNumberOfControls() {
		return super.getNumberOfControls() + 1;
	}
	
	@Override
	protected Control[] getControls() {
		return new Control[] {getTextControl(), getLabelControl(), getButtonControl()};
	}

	public Button getButtonControl() {
		return buttonControl;
	}
}
