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

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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

	private static final int VISIBLE_ITEMS_COUNT = 30;

	private Combo combo;
	// index of position default value in combo
	public int indexDefaultValue = -1;
	// private Set<String> values;
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

//	@Override
//	protected boolean buildOptions() {
//		return false;
//	}

	public void refreshOptions()
	{
		String v = getValue();
		loadData();
		setValue(v);
	}
	
	private void loadData() {
		StringBuilder toolTipText = new StringBuilder();
		toolTipText.append("Available choices:\n");
		Set<WidgetOption> opt = options.getOptions();
		String[] keys = new String[opt.size()];
		values = new LinkedList<String>();
		int i = 0, size = options.size();
		for (WidgetOption option : options.getOptions()) {
			String value = option.getValue();
			String key = option.getKey();
			
			values.add(value);
			

			String mapValue = option.getMapValue();
			if (mapValue != null) {
				key = mapValue;
			}
			toolTipText.append(key);// .append(" (").append(value).append(")");
			if (i < size - 1) {
				toolTipText.append("\n");
			}

			keys[i] = key;
			i++;
		}

		combo.setVisibleItemCount(VISIBLE_ITEMS_COUNT);
		combo.setItems(keys);
		combo.setToolTipText(toolTipText.toString());
	}

	@Override
	public void setValue(String value) {
		if (combo == null || combo.isDisposed()) {
			return;
		}
		
		setGrayed(!isEditable());
		
		int index = values.indexOf(value);
		if (index == -1) {

			combo.deselectAll();
			if (value == null) {
				return;
			}

			WidgetOption selectedWidgetOption = null;

			Set<WidgetOption> options3 = options.getOptions();
			for (WidgetOption widgetOption : options3) {
				String key = widgetOption.getKey();
				if (value.equals(key)) {
					selectedWidgetOption = widgetOption;
				}
			}

			String[] items = combo.getItems();
			if (selectedWidgetOption != null) {
				for (int i = 0; i < items.length; i++) {
					String itemValue = items[i];
					String mapValue = selectedWidgetOption.getMapValue();
					if (itemValue.equals(mapValue))
						combo.select(i);

				}
			}

			for (int i = 0; i < items.length; i++) {
				String itemValue = items[i];
				if (value.equals(itemValue)) {
					combo.select(i);
					return;
				}

			}

			return;
		}

		combo.select(index);

		if (value == null) {
			combo.deselectAll();
		}

	}

//	public void refresh(String currentValue) {
//
//	}

	@Override
	public String getValue() {
		if (combo == null || combo.isDisposed()) {
			return "";
		}
		int selectionIndex = combo.getSelectionIndex();
		if (selectionIndex == -1) {
			return "";
		}
		if (indexDefaultValue != -1)
			selectionIndex--;

		String value = values.get(selectionIndex);

		Set<WidgetOption> options1 = options.getOptions();
		for (WidgetOption widgetOption : options1) {
			String widgetValue = widgetOption.getValue();
			if (value.equals(widgetValue)) {
				value = widgetOption.getValue();
				break;
			}
		}
		return value;
	}

	// public static String findOptionValue(EList<Option> options, String
	// comboText) {
	// for (Option o : options) {
	// if (o.getName().equals(comboText)) {
	// return o.getValue();
	// }
	// }
	// return "";
	// }
	//
	// public static String findOptionName(EList<Option> options,
	// String optionValue) {
	// for (Option o : options) {
	// if (o.getValue().equals(optionValue)) {
	// return o.getName();
	// }
	// }
	// return "";
	// }

	public void addListener(final Listener listener) {
		//combo.addListener(SWT.Verify, listener);
		combo.addListener(SWT.FocusIn, listener);
		//combo.addListener(SWT.FocusOut, listener);
		combo.addListener(SWT.Selection, listener);
		//combo.addListener(SWT.MouseDown, listener);
		combo.addDisposeListener(new DisposeListener() {

			public void widgetDisposed(DisposeEvent e) {
				combo.removeDisposeListener(this);
				//combo.removeListener(SWT.Verify, listener);
				combo.removeListener(SWT.FocusIn, listener);
				//combo.removeListener(SWT.FocusOut, listener);
				combo.removeListener(SWT.Selection, listener);
				//combo.removeListener(SWT.MouseDown, listener);
			}

		});
		super.addListener(listener);
	}

	@Override
	public void setGrayed(boolean grayed) {
		combo.setEnabled(!grayed);
		if (grayed)
		{
			combo.setForeground(combo.getDisplay().getSystemColor(SWT.COLOR_GRAY));
			label.setForeground(label.getDisplay().getSystemColor(SWT.COLOR_GRAY));
		}
		else
		{
			combo.setForeground(combo.getDisplay().getSystemColor(SWT.COLOR_BLACK));
			label.setForeground(label.getDisplay().getSystemColor(SWT.COLOR_BLACK));
		}
		
	}

	public void buildWidget(Composite composite, String label, Map options) {
		buildWidget(composite, label);
	}

//	@Override
//	protected void disableEditing() {
//		if (combo != null && !combo.isDisposed()) {
//			combo.setEnabled(false);
//		}
//
//	}
//
//	@Override
//	protected void enableEditing() {
//
//		if (combo != null && !combo.isDisposed()) {
//			combo.setEnabled(true);
//		}
//	}

}
