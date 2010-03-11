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

package com.nokia.tools.s60ct.confml.widgets;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Listener;

/**
 * Widget graphically represents multi-selection setting.
 */
public class MultiSelectionWidget extends BaseConfMLWidget {

	private Composite widgetComposite = null;

//	private MultiSelectionType multiSelectionType;

	private Map<String, Button> optionName2CheckBoxesMap;


	public MultiSelectionWidget(Composite parent, int style, String string,
			WidgetOptions options, Image image) {
		super(parent, style, string, options, image);
	}

	@Override
	protected void buildMainControl() {
		// for now only cechboxes are supported
//		multiSelectionType = MultiSelectionType.ComboBoxType;

		widgetComposite = new Composite(group, SWT.BORDER | SWT.RIGHT);
		GridData data = new GridData();
		data.widthHint = 160;
		Color colorWhite = GUIConstants.COLOR_WHITE;
		widgetComposite.setBackground(colorWhite);
		widgetComposite.setLayoutData(data);
		widgetComposite.setLayout(new GridLayout(1, true));
		// widgetComposite.
		// listenersToRemove.

//		if (multiSelectionType.equals(MultiSelectionType.ComboBoxType)) {
			optionName2CheckBoxesMap = new HashMap<String, Button>();

//			Set<String> optionNames = options.keySet();
			for (WidgetOption name : options.getOptions()) {
				Button checkBox = new Button(widgetComposite, SWT.CHECK);
				GridData gd = new GridData(GridData.FILL_HORIZONTAL,
						SWT.DEFAULT);
				checkBox.setLayoutData(gd);
				checkBox.setText(name.getKey());
				checkBox.setBackground(colorWhite);
				optionName2CheckBoxesMap.put(name.getValue(), checkBox);
			}
//		}

		// attachListeners();
	}

	@Override
	public void clearErrorMessage() {

	}

//	@Override
//	protected boolean buildOptions() {
//		return false;
//	}
	
	@Override
	public String getValue() {
		Collection<WidgetOption> names = options.getOptions();
		List<String> values = new ArrayList<String>();
		
		for (WidgetOption n : names) {
			if (optionName2CheckBoxesMap.get(n.getValue()).getSelection()) {
				values.add(n.getValue());
			}
		}
		return createMultiSelectionValue(values);
	}

	@Override
	public void setValue(String value) {
		// detach listeners to avoid blinking

		// parsed values
		List<String> multiSelectionValues = parseMultiSelectionValues(value);

		// list of checked option names

		Collection<WidgetOption> names = options.getOptions();
		for (WidgetOption n : names) {
			Button button = optionName2CheckBoxesMap.get(n.getValue());
			if (multiSelectionValues.contains(n.getValue())) {
				button.setSelection(true);
			} else {
				button.setSelection(false);
			}
		}

		// re-attach listeners to avoid blinking
		
		setGrayed(!isEditable());
	}

	public void attachListeners() {
		// super.attachListeners();

		
	}

	enum MultiSelectionType {
		CheckBoxType, ComboBoxType
	}

	@Override
	public void addListener(Listener listener) {
		super.addListener(listener);

		Collection<Button> checkboxes = optionName2CheckBoxesMap.values();

		for (final Button b : checkboxes) {
			b.addListener(SWT.MouseDown, listener);
			b.addListener(SWT.Selection, listener);
		}
	}

	@Override
	public void dispose() {
		Collection<Button> values = optionName2CheckBoxesMap.values();
		for (Button b : values) {
			if (!b.isDisposed()) {
				Listener[] listeners = b.getListeners(SWT.MouseDown);
				for (int i = 0; i < listeners.length; i++) {
					b.removeListener(SWT.MouseDown, listeners[i]);
				}
				listeners = b.getListeners(SWT.Selection);
				for (int i = 0; i < listeners.length; i++) {
					b.removeListener(SWT.Selection, listeners[i]);
				}
			}
		}
//		multiSelectionType = null;
		super.dispose();
	}

	@Override
	public boolean setFocus() {
		boolean checkFocus = checkFocus();
		if (checkFocus) {
			return true;
		}
		return super.setFocus();

	}

	protected boolean checkFocus() {
		for (Button b :optionName2CheckBoxesMap.values())
		if (hasFocus(b)){
			return true;
		}
		return false;
	}

	@Override
	public void deselect() {
		if (isSelected()) {
			selected = false;
			drawDeselectUI();
		}
	}

//	protected void drawDeselectUI() {
//		if (group != null && !group.isDisposed()) {
//			Color colorWhite = GUIConstants.COLOR_WHITE;
//			label.setBackground(colorWhite);
//			group.setBackground(colorWhite);
//			setBackground(colorWhite);
//			if (toolBar != null) {
//				toolBar.setBackground(colorWhite);
//			}
//			Color systemColor = group.getDisplay().getSystemColor(
//					SWT.COLOR_WIDGET_BACKGROUND);
//			label.setForeground(group.getDisplay().getSystemColor(
//					SWT.COLOR_WIDGET_FOREGROUND));
//
//			for (int i = 0; i < additionalComposites.size(); i++) {
//				additionalComposites.get(i).setBackground(colorWhite);
//			}
//			if (decorator != null && !decorator.isDisposed()) {
//				decorator.setBackground(colorWhite);
//			}
//			if (dirtyLabel != null) {
//				dirtyLabel.setBackground(systemColor);
//			}
//			group.redraw();
//		}
//	}

	@Override
	public void setGrayed(boolean grayed) {
		
		if (grayed)
		{
			for (Button b :optionName2CheckBoxesMap.values())
			{
				b.setForeground(b.getDisplay().getSystemColor(SWT.COLOR_GRAY));
				b.setEnabled(!grayed);
			}
			
			label.setForeground(label.getDisplay().getSystemColor(SWT.COLOR_GRAY));
		}
		else
		{
			for (Button b :optionName2CheckBoxesMap.values())
			{
				b.setForeground(b.getDisplay().getSystemColor(SWT.COLOR_BLACK));
				b.setEnabled(!grayed);
			}
			label.setForeground(label.getDisplay().getSystemColor(SWT.COLOR_BLACK));
		}
		
	}

	public void buildWidget(Composite composite, String label,
			Map<String, String> options) {
		
	}

	
	/**
	 * Sorts <code>multiSelectionValue</code> 's values to achieve same order between equals sets.
	 * Example value1="A" "B" C value2=C B "A" 
	 * 
	 * Result multiselections value1 & value2 are equal.
	 * @param multiSelectionValue is value to order
	 * @return ordered value of multi selection
	 */
	public static String sortMultiSelectionValue(String multiSelectionValue) {
		
		List<String> values = parseMultiSelectionValues(multiSelectionValue);
		
		
		return createMultiSelectionValue(values);
	}

	/**
	 * 
	 * @param values list of option values
	 * @return multiselection value combined from values list
	 * 
	 * example:
	 * List<String> = [A,X,Z]
	 * 
	 * retuns "A" "X" "Z"
	 * 
	 */
	public static String createMultiSelectionValue(List<String> values) {
		Collections.sort(values);
		StringBuilder sb = new StringBuilder();
		for (int i = 0 ; i < values.size() ; i++) {
			if (i > 0) {
				sb.append(' ');
			}
			
			sb.append("\"" + values.get(i) + "\"");
		}
		
		return sb.toString();
	}

	/**
	 * 
	 * @param multiSelectionValue value containing checked options of multiselection setting
	 * @return e.g. list of strings "A" "B" "C" from String "A" "B" "C" 
	 */
	public static List<String> parseMultiSelectionValues(String multiSelectionValue) {
		if (multiSelectionValue == null) {
			return new ArrayList<String>();
		}
		
		// boolean quoted value
		boolean isCurrentValueQuoted = false;
		boolean valueProcessingBegan = false;
		
		StringBuilder sb = new StringBuilder();
		List<String> values = new ArrayList<String>();
		
		for (int i = 0 ; i <= multiSelectionValue.length() ; i++) {
			if (i == multiSelectionValue.length()) {
				if (sb.length() > 0) {
					values.add(sb.toString());
				}
				break;
			}
			char c = multiSelectionValue.charAt(i);

			if (!valueProcessingBegan) {
				if (c == ' ') {// skip spaces between values
					continue;
				}
			}
			
			if (!valueProcessingBegan) {
				if (c == '"') {
					isCurrentValueQuoted = true;
					valueProcessingBegan = true;
				} else {
					isCurrentValueQuoted = false;
					valueProcessingBegan = true;
					sb.append(c);
					continue;
				}
			} else {
				if (isCurrentValueQuoted) {
					if (c == '"') {
						values.add(sb.toString());
						sb.setLength(0);
						valueProcessingBegan = false;
						isCurrentValueQuoted = false;
					} else {
						sb.append(c);
					}
				} else {
					if (c == ' ') {
						values.add(sb.toString());
						sb.setLength(0);
						valueProcessingBegan = false;
						isCurrentValueQuoted = false;
					} else {
						sb.append(c);
					}
				}
				
			}
			
		}
		return values;
	}

	/*
			if (afterFirstQuote && afterSecondQuote) {
				if (c == ' ') {
					afterFirstQuote = false;
					afterSecondQuote = false;
					continue;
				}
			}
			
			if (afterFirstQuote && c == '"') {
				values.add(sb.toString());
				afterSecondQuote = true;
			}
			
			if (!afterFirstQuote && c == '"') {
				afterFirstQuote = true;
				sb.setLength(0);
			}
			
			if (afterFirstQuote && c != '"') {
				sb.append(c);
			}

	 */
	
	
//	@Override
//	protected void disableEditing() {
//		if(optionName2CheckBoxesMap!=null){
//			Collection<Button> values = optionName2CheckBoxesMap.values();
//			for (Button button : values) {
//				if(button!=null&&!button.isDisposed()){
//					button.setEnabled(false);
//				}
//			}
//		}
//		
//	}
//
//	@Override
//	protected void enableEditing() {
//		if(optionName2CheckBoxesMap!=null){
//			Collection<Button> values = optionName2CheckBoxesMap.values();
//			for (Button button : values) {
//				if(button!=null&&!button.isDisposed()){
//					button.setEnabled(true);
//				}
//			}
//		}
//		
//	}
}
