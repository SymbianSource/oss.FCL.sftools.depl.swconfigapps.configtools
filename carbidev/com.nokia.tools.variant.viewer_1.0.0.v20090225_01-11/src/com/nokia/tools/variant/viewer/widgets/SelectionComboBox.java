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

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Listener;
/**
 * Widget graphically represents selection setting.
 */
public class SelectionComboBox extends BaseConfMLWidget {

	private Combo combo;
	// index of position default value in combo
	public int indexDefaultValue = -1;
//	private Set<String> values;
	private List<String> values;

	public SelectionComboBox(Composite parent, int style, String string,
			WidgetOptions options) {
		super(parent, style, string, options);
		
	}

	public SelectionComboBox(Composite parent, int style, String string,
			WidgetOptions options, Image image) {
		super(parent, style, string, options, image);

	}

	public void setErrorMessage(String message) {
	}

	public void clearErrorMessage() {
	}

	@Override
	protected void buildMainControl() {

		combo = new Combo(group, SWT.READ_ONLY | SWT.DROP_DOWN);

		loadData();

		GridData gridData = new GridData();
		gridData.widthHint = 227;

		combo.setLayoutData(gridData);
		// needed for traversing
		combo.addKeyListener(new KeyListener() {

			public void keyPressed(KeyEvent e) {
				if ((e.keyCode == SWT.ARROW_DOWN || e.keyCode == SWT.ARROW_UP)
						&& e.stateMask == SWT.SHIFT) {
					e.doit = false;
				}

			}

			public void keyReleased(KeyEvent e) {

			}

		});

	}

	@Override
	protected boolean buildOptions() {
		return false;
	}

	private void loadData() {
		Set<String> keySet = options.keySet();
		values = new LinkedList<String>();
		for (WidgetOption option : options.values()){
			values.add(option.getValue());
		}
		
		
//		new keySet.toArray(new String[keySet.size()]);
		
		
		combo.setItems(keySet.toArray(new String[keySet.size()]));
	}

//	public void setInitialValue(String initialValue) {
//		if (isValidDefaultValue(initialValue)) {
//			setValue(initialValue);
//		}
//	}

	@Override
	public void setValue(String value) {
		
		int index = values.indexOf(value);
		if (index == -1){
			combo.deselectAll();
			return;
		}
//		value = options.getValue(value);
		combo.select(index);
		
		if (value == null || value.equals("")) {
			combo.deselectAll();
		}

	}

	public void refresh(String currentValue) {

	}

	@Override
	public String getValue() {

		int selectionIndex = combo.getSelectionIndex();
		if (selectionIndex == -1) {
			return "";
		}
		if (indexDefaultValue != -1)
			selectionIndex--;
		
		return values.get(selectionIndex);
	}

//	public static String findOptionValue(EList<Option> options, String comboText) {
//		for (Option o : options) {
//			if (o.getName().equals(comboText)) {
//				return o.getValue();
//			}
//		}
//		return "";
//	}
//
//	public static String findOptionName(EList<Option> options,
//			String optionValue) {
//		for (Option o : options) {
//			if (o.getValue().equals(optionValue)) {
//				return o.getName();
//			}
//		}
//		return "";
//	}

	public void addListener(final Listener listener) {
		combo.addListener(SWT.Verify, listener);
		combo.addListener(SWT.FocusIn, listener);
		combo.addListener(SWT.FocusOut, listener);
		combo.addListener(SWT.Selection, listener);
		combo.addListener(SWT.MouseDown, listener);
		combo.addDisposeListener(new DisposeListener() {

			public void widgetDisposed(DisposeEvent e) {
				combo.removeDisposeListener(this);
				combo.removeListener(SWT.Verify, listener);
				combo.removeListener(SWT.FocusIn, listener);
				combo.removeListener(SWT.FocusOut, listener);
				combo.removeListener(SWT.Selection, listener);

			}

		});
		super.addListener(listener);
	}

}
