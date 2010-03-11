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

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * Basic widget for edit settings.
 */
public class BaseTextBox extends BaseConfMLWidget {

	protected Shell tip;
	protected Text text;

	public BaseTextBox(Composite parent, int style, String widgetLabel) {
		super(parent, style, widgetLabel);

	}

	public BaseTextBox(Composite parent, int style, String widgetLabel,
			Image image) {
		super(parent, style, widgetLabel, image);
	}

	public BaseTextBox(Composite parent, int style, String widgetLabel,
			WidgetOptions options, Image image) {
		super(parent, style, widgetLabel, options, image);
	}

	protected void buildMainControl() {

		text = new Text(group, SWT.BORDER);

		text.setBackground(new Color(Display.getDefault(), 255, 255, 255));
		GridData gridData = new GridData();
		gridData.widthHint = TEXT_WIDTH_HINT;
		text.setLayoutData(gridData);

	}

	protected void removeListeners() {
		super.removeListeners();

	}

	public void attachListeners() {
		super.attachListeners();

	}

	public void addListener(final Listener listener) {
		text.addListener(SWT.Verify, listener);
		text.addListener(SWT.FocusIn, listener);
		text.addListener(SWT.FocusOut, listener);
		text.addListener(SWT.Modify, listener);
		text.addListener(SWT.MouseDown, listener);
		text.addListener(SWT.KeyDown, listener);
		text.addListener(SWT.Dispose, listener);
		text.addDisposeListener(new DisposeListener() {

			public void widgetDisposed(DisposeEvent e) {
				text.removeDisposeListener(this);
				text.removeListener(SWT.Verify, listener);
				text.removeListener(SWT.FocusIn, listener);
				text.removeListener(SWT.FocusOut, listener);
				text.removeListener(SWT.Modify, listener);
				text.removeListener(SWT.KeyDown, listener);
				text.removeListener(SWT.Dispose, listener);
			}

		});
		super.addListener(listener);
	}

	public void clearErrorMessage() {
		if (null != tip && !tip.isDisposed())
			tip.setVisible(false);
	}

	@Override
	public boolean setFocus() {
		if (!text.isDisposed()) {
			if (!text.isFocusControl()) {
				text.setFocus();
				return true;
			}
		}
		return false;
	}

	protected void editable(boolean editable) {
		text.setEditable(editable);
	}

	public Text getControl() {
		return text;
	}

	// public void setDefaultValue(String defaultValue) {
	// if (isValidDefaultValue(defaultValue)) {
	// setValue(defaultValue);
	// }
	// }

	public void setInitialValue(String initialValue) {
		// System.out.println("Initial:...");
		if (isValidDefaultValue(initialValue)) {
			setValue(initialValue);
		}
	}

	public void refresh(String currentValue) {
		text.setText(currentValue);
		text.setSelection(text.getCharCount());
	}

	@Override
	public void setValue(String value) {
		if (text.isDisposed()) {
			return;
		}

		if (value == null) {
			value = "";
		}
		if (!text.getText().equals(value)) {
			text.setText(value);
		}

	}

	@Override
	public String getValue() {
		if (text != null && !text.isDisposed()) {
			return text.getText();
		}
		return "";
	}

}
