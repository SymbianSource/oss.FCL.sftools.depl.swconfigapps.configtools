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
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class BaseTextBox extends BaseConfMLWidget {

	protected Shell tip;
	protected Text text;

	public BaseTextBox(Composite parent, int style, String widgetLabel) {
		super(parent, style, widgetLabel);

	}

	public BaseTextBox(Composite parent, int style, String widgetLabel,WidgetOptions options, Image image) {
		super(parent, style, widgetLabel,options,image);
	}

	protected void buildMainControl() {
		Composite controls = new Composite(group, SWT.NONE);
		controls.setBackground(new Color(group.getDisplay(), 255, 255, 255));
		text = new Text(controls, SWT.BORDER);
		GridLayout gridLayout = new GridLayout(2, false);
		gridLayout.horizontalSpacing = 0;
		gridLayout.verticalSpacing = 0;
		gridLayout.marginHeight = 0;
		gridLayout.marginWidth = 0;
		gridLayout.marginBottom = 0;
		gridLayout.marginTop = 0;
		gridLayout.marginRight = 0;
		controls.setLayout(gridLayout);
		controls.setLayoutData(layoutDataForGroup());
		text.setBackground(new Color(Display.getDefault(), 255, 255, 255));
		text.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		buildOptions(controls);
	}

	protected void removeListeners() {
		super.removeListeners();
		// removeListener(text, SWT.Verify, widgetController);
		// removeListener(text, SWT.FocusIn, widgetController);
		// removeListener(text, SWT.FocusOut, widgetController);
		// removeListener(text, SWT.Modify, widgetController);
		// removeListener(text, SWT.MouseDown, widgetController);
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
		text.addDisposeListener(new DisposeListener() {

			public void widgetDisposed(DisposeEvent e) {
				text.removeDisposeListener(this);
				text.removeListener(SWT.Verify, listener);
				text.removeListener(SWT.FocusIn, listener);
				text.removeListener(SWT.FocusOut, listener);
				text.removeListener(SWT.Modify, listener);

			}

		});
		super.addListener(listener);
	}
//
//	private boolean needToCreateNewErrorToolTip(String message) {
//		return null == tip || tip.isDisposed()
//				|| !message.equals(oldErrorMessage);
//	}
//
//	private void saveOldErrorMessage(String message) {
//		this.oldErrorMessage = message;
//	}

//	public void setErrorMessage(String message) {
//
//		if (needToCreateNewErrorToolTip(message)) {
//			tip = ErrorToolTipWidget.createNewErrorToolTip(text, tip, message);
//		}
//		saveOldErrorMessage(message);
//		tip.setVisible(true);
//	}

	public void clearErrorMessage() {
		if (null != tip && !tip.isDisposed())
			tip.setVisible(false);
	}

	@SuppressWarnings("unchecked")
	public void buildWidget(Composite composite, String label, Map options) {
		buildWidget(composite, label);
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.nokia.tools.zodiac.subsystem.ui.widgets.BasicWidget#refresh(java.
	 * lang.String)
	 */
	public void refresh(String currentValue) {
		text.setText(currentValue);
		text.setSelection(text.getCharCount());
	}

	@Override
	public void setValue(String value) {
		if (text == null || text.isDisposed()) {		
			return;
		}

		if(value==null){
			value="";
		}
			if (!text.getText().equals(value)) {
				text.setText(value);
			}
			setGrayed(!isEditable());
	}

	@Override
	public String getValue()
	{
		return text.getText();	
	}
	
	public void setGrayed(boolean grayed)
	{
		text.setEnabled(!grayed);
		if (grayed)
		{
			text.setForeground(text.getDisplay().getSystemColor(SWT.COLOR_GRAY));
			label.setForeground(label.getDisplay().getSystemColor(SWT.COLOR_GRAY));
		}
		else
		{
			text.setForeground(text.getDisplay().getSystemColor(SWT.COLOR_BLACK));
			label.setForeground(label.getDisplay().getSystemColor(SWT.COLOR_BLACK));
		}
		
		setOptionsEnabled(!grayed);
		
	}
	
}
