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
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Listener;

import com.nokia.tools.variant.viewer.Activator;
import com.nokia.tools.variant.viewer.images.PluginImages;
/**
 * Widget graphically represents boolean setting. 
 */
public class BooleanCheckBox extends BaseConfMLWidget {

	public static final String ZERO = "0";

	public static final String ONE = "1";

	public static final String FALSE_CONSTANT = "false";

	public static final String TRUE_CONSTANT = "true";

	private Boolean3State checkBox;

	private Label l;

	// private boolean firstTime = true;

	public BooleanCheckBox(Composite parent, int style, String widgetLabel) {
		super(parent, style, widgetLabel);

	}

	public BooleanCheckBox(Composite parent, int style, String widgetLabel,
			Image image) {
		super(parent, style, widgetLabel, image);

	}

	public BooleanCheckBox(Composite parent, int style, String widgetLabel,
			WidgetOptions options, Image image) {
		super(parent, style, widgetLabel, options, image);
	}

	public void setErrorMessage(String message) {
	}

	public void clearErrorMessage() {
	}

	@Override
	protected void buildMainControl() {

		checkBox = new Boolean3State(group, SWT.CHECK);
		checkBox.setText(Messages.BooleanLabel);
		checkBox.setBackground(group.getBackground());
		checkBox.setLayoutData(new GridData());
		l = new Label(group, SWT.NONE);
		l.setText(label.getText());
		GridData gridData = new GridData();

		gridData.horizontalIndent = 5;
		l.setLayoutData(gridData);
		l.setBackground(group.getBackground());
		label.setText("");
	}

	@Override
	public void attachListeners() {
		super.attachListeners();

	}

	@Override
	protected void removeListeners() {
		super.removeListeners();

	}

	@Override
	protected Layout buildContainerLayout() {
		int columnCount = (image == null) ? 3 : 4;
		if (options != null && options.size() > 0) {
			columnCount++;
		}
		GridLayout layout = new GridLayout(columnCount, false);
		return layout;
	}

	@Override
	public boolean setFocus() {
		if (checkBox.isDisposed()) {
			return false;
		}
		return checkBox.setFocus();
	}

	@Override
	protected void drawFocusUI() {
		super.drawFocusUI();
		drawCheckBoxFocusUI();
	}

	private void drawCheckBoxFocusUI() {
		checkBox.setBackground(group.getDisplay().getSystemColor(
				SWT.COLOR_WHITE));
	}

	protected void drawUnFocusUI() {
		super.drawUnFocusUI();
		drawCheckBoxUnfocusUI();
	}

	private void drawCheckBoxUnfocusUI() {
		if (!checkBox.isDisposed()) {
			checkBox.setBackground(group.getDisplay().getSystemColor(
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
			checkBox.setState(2);
			return;
		}
		if (Boolean.parseBoolean(toJavaBoolean(value))) {
			checkBox.setState(1);
		} else {
			checkBox.setState(0);
		}

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

	public void refresh(String currentValue) {

	}

	@Override
	public void select() {
		super.select();

	}

	@Override
	protected void drawDeselectUI() {
		if (!l.isDisposed()) {
			l.setBackground(group.getDisplay().getSystemColor(SWT.COLOR_WHITE));
			l.setForeground(group.getDisplay().getSystemColor(SWT.COLOR_BLACK));
			group.setBackground(group.getDisplay().getSystemColor(
					SWT.COLOR_WHITE));
			checkBox.setBackground(group.getDisplay().getSystemColor(
					SWT.COLOR_WHITE));
		}

		super.drawDeselectUI();
	}

	@Override
	protected void drawSelectUI() {
		if (!l.isDisposed()) {
			l.setBackground(PluginImages.BACKGROUND_COLOR);

			group.setBackground(PluginImages.BACKGROUND_COLOR);
			checkBox.setBackground(PluginImages.BACKGROUND_COLOR);
			super.drawSelectUI();
		}
	}

	@Override
	public void addListener(Listener listener) {
		checkBox.addListener(SWT.Selection, listener);
		checkBox.addListener(SWT.MouseDown, listener);
		checkBox.addListener(SWT.FocusIn, listener);
		l.addListener(SWT.MouseDown, listener);

		super.addListener(listener);
	}

	@Override
	public String getValue() {
		int selection = checkBox.getState();
		if (selection == 1) {
			return TRUE_CONSTANT;
		} else if (selection == 0) {
			return FALSE_CONSTANT;
		}
		return null;
	}

	public void setDefaultMark(boolean isDefault) {

		if (!isDefault) {
			l.setFont(Activator.getBoldFont());
			l.getParent().layout();

			if (l.isVisible())
				l.redraw();
		} else {
			l.setFont(Activator.getDefaultFont());
			l.getParent().layout();

			if (l.isVisible())
				l.redraw();
		}
	}
}
