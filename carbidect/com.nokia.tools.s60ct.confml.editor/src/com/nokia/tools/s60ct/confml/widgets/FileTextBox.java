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
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

import com.nokia.tools.vct.common.ui.CommonUIPlugin;
import com.nokia.tools.vct.common.ui.ISharedImages;

/**
 * File widget
 * 
 * - The drag & drop stuff should not be here, yet it must because controller
 * does not know when the SWT controls for this get created, hence cannot hook
 * into them.
 */
public class FileTextBox extends BaseConfMLWidget {

	protected Text text;
//	private Button button;
	
	public FileTextBox(Composite parent, int style, String widgetLabel) {
		super(parent, style, widgetLabel);
	}
	
	public FileTextBox(Composite parent, int style, String widgetLabel,WidgetOptions options, Image image) {
		super(parent, style, widgetLabel,options,image);
	}
	
	@Override
	protected void buildMainControl() {
		Composite control = new Composite(group, SWT.NONE);
		GridLayout gridLayout = new GridLayout(2, false);
		gridLayout.horizontalSpacing = 0;
		gridLayout.verticalSpacing = 0;
		gridLayout.marginHeight = 0;
		gridLayout.marginWidth = 0;
		gridLayout.marginBottom = 0;
		gridLayout.marginTop = 0;
		gridLayout.marginRight = 0;
		control.setLayout(gridLayout);
		control.setLayoutData(layoutDataForGroup());
		control.setBackground(new Color(Display.getDefault(), 255, 255, 255));
		
		text = new Text(control, SWT.BORDER);
		text.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		text.setBackground(new Color(Display.getDefault(), 255, 255, 255));
		
//		button = new Button(control, SWT.BORDER | SWT.WRAP);
//		button.setImage(CommonUIPlugin.getImage(ISharedImages.ICO_BROWSE));
//		button.addListener(SWT.Selection, new Listener() {
//
//			public void handleEvent(Event event) {
//				FileDialog dialog = new FileDialog(group.getShell(), SWT.MULTI);
//				if (text != null) dialog.setFileName(text.getText());
//				String newText = dialog.open();
//				if (newText != null) {
//					text.setText(newText);
//				}
//				
//			}
//			
//		});
		
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
	
	@Override
	public void clearErrorMessage() {
		
	}

	@Override
	public String getValue() {
		return text.getText();
	}

	@Override
	public void setValue(String value) {
		if (value!=null)
			text.setText(value);
		setGrayed(!isEditable());
//		button.setEnabled(isEditable());
	}

	public void buildWidget(Composite composite, String label,
			Map<String, String> options) {
		buildMainControl();
		text.setText(label);
		buildWidget(composite, label);
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
		isGrayed = grayed;
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
	
}
