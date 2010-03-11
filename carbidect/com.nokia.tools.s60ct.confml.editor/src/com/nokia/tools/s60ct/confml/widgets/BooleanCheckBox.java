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

import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Listener;

import com.nokia.tools.s60ct.confml.editor.Activator;


public class BooleanCheckBox extends BaseConfMLWidget {

	public static final String ZERO = "0";

	public static final String ONE = "1";

	public static final String FALSE_CONSTANT = "false";

	public static final String TRUE_CONSTANT = "true";

	private Button checkBox;

	//private Label l;

	private Composite control;

	public BooleanCheckBox(Composite parent, int style, String widgetLabel) {
		super(parent, style, widgetLabel);

	}
	public BooleanCheckBox(Composite parent, int style, String widgetLabel,WidgetOptions options, Image image) {
		super(parent, style, widgetLabel,options,image);

	}

	public void setErrorMessage(String message) {
	}

	public void clearErrorMessage() {
	}

	@Override
	protected void buildMainControl() {
		control = new Composite(group, SWT.NONE);
		GridLayout gridLayout = new GridLayout();
		gridLayout.horizontalSpacing = 0;
		gridLayout.verticalSpacing = 0;
		gridLayout.marginHeight = 0;
		gridLayout.marginWidth = 0;
		gridLayout.marginBottom = 0;
		gridLayout.marginTop = 0;
		gridLayout.marginRight = 0;
		gridLayout.numColumns = 2;
		control.setLayout(gridLayout);
		control.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		control.setBackground(group.getBackground());
		checkBox = new Button(control, SWT.CHECK);
//		checkBox.setText(Messages.BooleanLabel);
		checkBox.setBackground(control.getBackground());
		//checkBox.setLayoutData(new GridData());
//		l = new Label(control, SWT.NONE);
//		System.out.println(label.getText());
//		l.setText(label.getText());
		
		GridData gridData = new GridData();
		gridData.horizontalIndent = 5;
//		gridData.widthHint = 100;
//		l.setLayoutData(gridData);
//		l.setBackground(control.getBackground());
//		l.pack();
//		
		
	
		
	}

	
	
	
	public void bold(boolean bold)
	{
		if (bold)
		{
			label.setFont(Activator.getBoldFont());
		}
		else
		{
			label.setFont(Activator.getDefaultFont());
		}
		
		label.redraw();
		label.redraw();
	}
	
	@Override
	public void attachListeners() {
		super.attachListeners();

	}

	@Override
	protected void removeListeners() {
		super.removeListeners();

	}

	public void buildWidget(Composite composite, String label,
			Map<String, String> options) {
		buildWidget(composite, label);
	}

	@Override
	public boolean setFocus() {
		if (!isDisposed()) {
			return checkBox.setFocus();
		} else {
			return false;
		}
	}

	@Override
	protected void drawFocusUI() {
		super.drawFocusUI();
		drawCheckBoxFocusUI();
	}

	private void drawCheckBoxFocusUI() {
		if (!control.isDisposed()) {
			control.setBackground(GUIConstants.COLOR_LIGHT_BLUE);
		}
	}

	protected void drawUnFocusUI() {
		super.drawUnFocusUI();
		drawCheckBoxUnfocusUI();
	}

	private void drawCheckBoxUnfocusUI() {
		if (!control.isDisposed()) {
			control.setBackground(group.getDisplay().getSystemColor(
					SWT.COLOR_WHITE));
		}
	}

	/**
	 * If initialValue is null , initial value is set to false;
	 */
	public void setInitialValue(String initialValue) {
		if (initialValue != null) {
			String toCheck = initialValue.toLowerCase();
			if (isValidDefaultValue(initialValue)
					&& isValidBooleanValue(toCheck)) {
				setValue(toCheck);
			}
		} else {
			setValue("false");
		}
	}

	/**
	 * selects the appropriate radio button and updates the corresponding model
	 */
	public void setValue(String value) {
		if (value == null) {
			return;
		}
		if (Boolean.parseBoolean(toJavaBoolean(value))) {
			checkBox.setSelection(true);
		} else {
			checkBox.setSelection(false);
		}
		setGrayed(!isEditable());
	}

	private boolean isValidBooleanValue(String toCheck) {
		return isOneOrZero(toCheck) || TRUE_CONSTANT.equals(toCheck)
				|| FALSE_CONSTANT.equals(toCheck);
	}

	private boolean isOneOrZero(String toCheck) {
		return ONE.equals(toCheck) || ZERO.equals(toCheck);
	}

	private String toJavaBoolean(String toCheck) {
		if (!isOneOrZero(toCheck))
			return toCheck;
		return toCheck.equals(ONE) ? TRUE_CONSTANT : FALSE_CONSTANT;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.nokia.tools.zodiac.subsystem.ui.widgets.BasicWidget#refresh(java.
	 * lang.String)
	 */
	public void refresh(String currentValue) {

	}

	@Override
	public void select() {
		super.select();

	}

	@Override
	protected void drawDeselectUI() {
		drawCheckBoxUnfocusUI();
	}

	@Override
	protected void drawSelectUI() {
		drawCheckBoxFocusUI();
	}

	@Override
	public void addListener(Listener listener) {
		checkBox.addListener(SWT.Selection, listener);
		checkBox.addListener(SWT.MouseDown, listener);
		checkBox.addListener(SWT.FocusIn, listener);
//		l.addListener(SWT.MouseDown, listener);

		super.addListener(listener);
	}

	@Override
	public String getValue() {
		boolean selection = checkBox.getSelection();
		if (selection) {
			return TRUE_CONSTANT;
		}
		return FALSE_CONSTANT;
	}
	
	public void setGrayed(boolean grayed)
	{
		checkBox.setEnabled(!grayed);
		if (grayed)
		{
			checkBox.setForeground(checkBox.getDisplay().getSystemColor(SWT.COLOR_GRAY));
			label.setForeground(label.getDisplay().getSystemColor(SWT.COLOR_GRAY));
		}
		else
		{
			checkBox.setForeground(checkBox.getDisplay().getSystemColor(SWT.COLOR_BLACK));
			label.setForeground(label.getDisplay().getSystemColor(SWT.COLOR_BLACK));
		}
	}

	
}
