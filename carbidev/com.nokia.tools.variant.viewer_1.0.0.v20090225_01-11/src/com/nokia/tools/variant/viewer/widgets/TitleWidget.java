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
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Listener;
/**
 * Widget graphically represents title or Confml feature.
 */
public class TitleWidget extends BaseConfMLWidget {

	private Color backgroundColor = Display.getCurrent().getSystemColor(
			SWT.COLOR_WIDGET_BACKGROUND);

	// private

	public TitleWidget(Composite parent, int style, String widgetLabel) {
		super(parent, style, widgetLabel);
	}

	@Override
	protected void initializeColors(Composite composite) {
		if (toolBar != null) {
			toolBar.setBackground(backgroundColor);
		}
	}

	/*
	 * @Override protected void buildLabel(String widgetLabel) { label = new
	 * Label(group, SWT.None);
	 * //label.setBackground(group.getDisplay().getSystemColor(SWT.COLOR_WHITE)
	 * // ); label.setText(widgetLabel); int width = DEFAULT_WIDTH_LABEL;
	 * label.setLayoutData(layoutDataForLabel(width)); //
	 * group.setBackground(label.getBackground()); }
	 */

	@Override
	protected void drawDeselectUI() {
		if (!group.isDisposed()) {
			Color bgColor = backgroundColor;
			label.setBackground(bgColor);
			group.setBackground(bgColor);
			if (toolBar != null) {
				toolBar.setBackground(bgColor);
			}
			// additonalCompositesSetBG(bgColor);

			// label.setForeground(foregroundColor);
			// errorComposite.setBackground(bgColor);
			// noteComposite.setBackground(bgColor);
			// dirtyComposite.setBackground(bgColor);
			// group.redraw();
		}
	}

	@Override
	public void clearErrorMessage() {
		

	}

	@Override
	public String getValue() {
		return label.getText();
	}

	@Override
	public void setValue(String value) {
		

	}

	public void refresh(String currentValue) {
		

	}

	public void setInitialValue(String initialValue) {
		

	}

	public Color getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(Color backgroundColor) {
		setBackground(backgroundColor);

		this.backgroundColor = backgroundColor;
		if (toolBar != null) {
			toolBar.setBackground(backgroundColor);
		}
		label.setBackground(backgroundColor);
		group.setBackground(backgroundColor);
		this.backgroundColor = backgroundColor;
	}

	public Color getForegroundColor() {
		return foregroundColor;
	}

	public void setForegroundColor(Color foregroundColor) {
		this.foregroundColor = foregroundColor;
	}

	private Color foregroundColor = Display.getCurrent().getSystemColor(
			SWT.COLOR_WIDGET_FOREGROUND);
	private Listener focusListener;

	@Override
	protected void buildMainControl() {
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.heightHint = 32;
		gd.verticalAlignment = GridData.VERTICAL_ALIGN_CENTER;
		setLayoutData(gd);

	}

	@Override
	public void addListener(Listener listener) {
		if (focusListener == null) {
			focusListener = listener;
			group.addListener(SWT.FocusIn, listener);
			label.addListener(SWT.FocusIn, listener);
			super.addListener(listener);
		}

	}

	public void setLabelFont(Font f) {
		label.setFont(f);
	}

	@Override
	public void dispose() {
		if (!group.isDisposed()) {
			group.removeListener(SWT.FocusIn, focusListener);
		}
		super.dispose();
	}

	@Override
	protected void buildLabel(String widgetLabel) {

		super.buildLabel(widgetLabel);
		GridData layoutData = new GridData();
		layoutData.verticalAlignment = GridData.FILL_HORIZONTAL;
		layoutData.verticalAlignment = GridData.CENTER;
		label.setLayoutData(layoutData);
	}
}
