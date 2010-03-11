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
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;

public class BooleanRadioButton extends BaseConfMLWidget {

	public static final String ZERO = "0";
	public static final String ONE = "1";
	public static final String FALSE_CONSTANT = "false";
	public static final String TRUE_CONSTANT = "true";
	private static final String FALSE = "False";
	private static final String TRUE = "True";
	private Button radioButtonForTrue = null;
	private Button radioButtonForFalse = null;
	private boolean falseRadioButtonIsSelected = true;

	public BooleanRadioButton(Composite parent, int style,String widgetLabel) {
		super( parent, style, widgetLabel);
		
		}

	public void setErrorMessage(String message) {
	}

	public void clearErrorMessage() {
	}

	@Override
	protected void buildMainControl() {
		radioButtonForTrue = new Button(group, SWT.RADIO);
		radioButtonForTrue.setText(TRUE);

		radioButtonForFalse = new Button(group, SWT.RADIO);
		radioButtonForFalse.setText(FALSE);

		radioButtonForFalse.setSelection(falseRadioButtonIsSelected);
		if (!falseRadioButtonIsSelected)
			radioButtonForTrue.setSelection(falseRadioButtonIsSelected);
		
		
	}

	@Override
	public void attachListeners() {
		super.attachListeners();

//		radioButtonForTrue.addListener(SWT.FocusIn, widgetController);
//		radioButtonForTrue.addListener(SWT.FocusOut, widgetController);
//		radioButtonForTrue.addListener(SWT.Selection, widgetController);
//		radioButtonForTrue.addListener(SWT.MouseDown, widgetController);
//		radioButtonForTrue.addDisposeListener(new DisposeListener(){
//
//			public void widgetDisposed(DisposeEvent e) {
//				radioButtonForTrue.removeDisposeListener(this);
//				radioButtonForTrue.removeListener(SWT.FocusIn, widgetController);
//				radioButtonForTrue.removeListener(SWT.FocusOut, widgetController);
//				radioButtonForTrue.removeListener(SWT.Selection, widgetController);
//				radioButtonForTrue.removeListener(SWT.MouseDown, widgetController);
//				
//			}
//			
//		});
//		radioButtonForFalse.addListener(SWT.FocusIn, widgetController);
//		radioButtonForFalse.addListener(SWT.FocusOut, widgetController);
//		radioButtonForFalse.addListener(SWT.Selection, widgetController);
//		radioButtonForFalse.addListener(SWT.MouseDown, widgetController);
//		radioButtonForFalse.addDisposeListener(new DisposeListener(){
//
//			public void widgetDisposed(DisposeEvent e) {
//				radioButtonForFalse.removeDisposeListener(this);
//				radioButtonForFalse.removeListener(SWT.FocusIn, widgetController);
//				radioButtonForFalse.removeListener(SWT.FocusOut, widgetController);
//				radioButtonForFalse.removeListener(SWT.Selection, widgetController);
//				radioButtonForFalse.removeListener(SWT.MouseDown, widgetController);
//				
//			}
//			
//		});
	}

	@Override
	protected void removeListeners() {
		super.removeListeners();

//		removeListener(radioButtonForTrue, SWT.FocusIn, widgetController);
//		removeListener(radioButtonForTrue, SWT.FocusOut, widgetController);
//		removeListener(radioButtonForTrue, SWT.Selection, widgetController);
//		removeListener(radioButtonForTrue, SWT.MouseDown, widgetController);
//		removeListener(radioButtonForFalse, SWT.FocusIn, widgetController);
//		removeListener(radioButtonForFalse, SWT.FocusOut, widgetController);
//		removeListener(radioButtonForFalse, SWT.Selection, widgetController);
//		removeListener(radioButtonForFalse, SWT.MouseDown, widgetController);
	}

	public void buildWidget(Composite composite, String label,
			Map<String, String> options) {
		buildWidget(composite, label);
	}

	@Override
	public boolean setFocus() {
//		Widget widgetThatCausedEvent = widgetController.widgetThatCausedEvent();
//		if (widgetThatCausedEvent == radioButtonForFalse) {
//			radioButtonForFalse.setSelection(true);
//		} else if (widgetThatCausedEvent == radioButtonForTrue) {
//			radioButtonForTrue.setSelection(true);
//		} else {
//			focusOneOfTheRadioButtons();
//		}
		return false;
	}

	private void focusOneOfTheRadioButtons() {
		if (radioButtonForFalse.getSelection())
			radioButtonForFalse.setFocus();
		else
			radioButtonForTrue.setFocus();
	}

	@Override
	protected void drawFocusUI() {
		super.drawFocusUI();
		drawTrueRadioButtonFocusUI();
		drawFalseRadioButtonFocusUI();
	}

	private void drawFalseRadioButtonFocusUI() {
		radioButtonForFalse.setBackground(group.getDisplay().getSystemColor(
				SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		radioButtonForFalse.setForeground(group.getDisplay().getSystemColor(
				SWT.COLOR_WIDGET_FOREGROUND));
	}

	private void drawTrueRadioButtonFocusUI() {
		radioButtonForTrue.setBackground(group.getDisplay().getSystemColor(
				SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		radioButtonForTrue.setForeground(group.getDisplay().getSystemColor(
				SWT.COLOR_WIDGET_FOREGROUND));
	}

	protected void drawUnFocusUI() {
		super.drawUnFocusUI();
		drawTrueRadioButtonUnfocusUI();
		drawFalseRadioButtonUnfocusUI();
	}

	private void drawFalseRadioButtonUnfocusUI() {
		radioButtonForFalse.setBackground(group.getDisplay().getSystemColor(
				SWT.COLOR_WIDGET_BACKGROUND));
		radioButtonForFalse.setForeground(group.getDisplay().getSystemColor(
				SWT.COLOR_WIDGET_FOREGROUND));
	}

	private void drawTrueRadioButtonUnfocusUI() {
		radioButtonForTrue.setBackground(group.getDisplay().getSystemColor(
				SWT.COLOR_WIDGET_BACKGROUND));
		radioButtonForTrue.setForeground(group.getDisplay().getSystemColor(
				SWT.COLOR_WIDGET_FOREGROUND));
	}

	/**
	 * If defaultValue is null , default value is set to false;
	 */
//	public void setDefaultValue(String defaultValue) {
//		if(defaultValue != null){
//			String toCheck = defaultValue.toLowerCase();
//			if (isValidDefaultValue(defaultValue) && isValidBooleanValue(toCheck)) {
//				setValue(toCheck);
//			}
//		}else{
//			setValue("false");
//		}
//	}

	/**
	 * If initialValue is null , initial value is set to false;
	 */
	public void setInitialValue(String initialValue) {
		if(initialValue != null){
			String toCheck = initialValue.toLowerCase();
			if (isValidDefaultValue(initialValue) && isValidBooleanValue(toCheck)) {
				setValue(toCheck);
			}
		}else{
			setValue("false");
		}
	}

	/**
	 * selects the appropriate radio button and updates the corresponding model
	 */
	public void setValue(String value) {
		if(value == null){
			return;
		}
		if (Boolean.parseBoolean(toJavaBoolean(value))) {
			radioButtonForTrue.setSelection(true);
			radioButtonForFalse.setSelection(false);
		} else {
			radioButtonForFalse.setSelection(true);
			radioButtonForTrue.setSelection(false);
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
	 * @see com.nokia.tools.zodiac.subsystem.ui.widgets.BasicWidget#refresh(java.lang.String)
	 */
	public void refresh(String currentValue) {

	}

	@Override
	public void select() {
		super.select();
		trueLabelSelectUI();
		falseLabelSelectUI();
		falseRadioButtonSelectUI();
		trueRadioButtonSelectUI();
	}

	/**
	 * Draws the UI for true Radio Button on selection
	 */
	private void trueRadioButtonSelectUI() {
		radioButtonForTrue.setBackground(group.getDisplay().getSystemColor(
				SWT.COLOR_LIST_SELECTION));
		radioButtonForTrue.setForeground(group.getDisplay().getSystemColor(
				SWT.COLOR_LIST_SELECTION_TEXT));
	}

	/**
	 * Draws the Ui for false Radio Button on selection
	 */
	private void falseRadioButtonSelectUI() {
		radioButtonForFalse.setBackground(group.getDisplay().getSystemColor(
				SWT.COLOR_LIST_SELECTION));
		radioButtonForFalse.setForeground(group.getDisplay().getSystemColor(
				SWT.COLOR_LIST_SELECTION_TEXT));
	}

	/**
	 * Draws the UI for false label on selection
	 */
	private void falseLabelSelectUI() {
/*		False.setBackground(group.getDisplay().getSystemColor(
				SWT.COLOR_LIST_SELECTION));
		False.setForeground(group.getDisplay().getSystemColor(
				SWT.COLOR_LIST_SELECTION_TEXT));
				*/
	}

	/**
	 * Draws the UI for true label on selection
	 */

	private void trueLabelSelectUI() {
/*		True.setBackground(group.getDisplay().getSystemColor(
				SWT.COLOR_LIST_SELECTION));
		True.setForeground(group.getDisplay().getSystemColor(
				SWT.COLOR_LIST_SELECTION_TEXT));
				*/
	}

//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see com.nokia.tools.zodiac.subsystem.ui.widgets.BasicWidget#update(org.eclipse.swt.widgets.Event)
//	 */
//	public void update(Event event) {
//
//		
//		/*
//		String value = getValue();
//		String newValue = asString(!radioButtonForFalse.getSelection());
//		
//		widgetController.updateModel(newValue);
//		*/
//	}

//	public void update(Event event) {
//		if (event == null) {
//			String modelValue = widgetController.getModel().getValue();
//			setValue(modelValue);
//			return;
//		}
//		String newValueFromWidget = null;
//		if (event.widget == radioButtonForTrue) {
//			newValueFromWidget = TRUE_CONSTANT;
//		} else if(event.widget == radioButtonForFalse){
//			newValueFromWidget = FALSE_CONSTANT;
//		}
//		setValue(newValueFromWidget);
//		SimpleSetting valueRef = widgetController.getModel();
//		if(valueRef != null){
//			String modelValue = valueRef.getValue();
//			if (!modelValue.equals(newValueFromWidget)) {
//				widgetController.updateModel(newValueFromWidget);
//			}
//		}else{
//			setValue(FALSE_CONSTANT);
//		}
//	}

	public Button getRadioButtonForTrue() {
		return radioButtonForTrue;
	}

	public Button getRadioButtonForFalse() {
		return radioButtonForFalse;
	}

	@Override
	public String getValue() {
		boolean selection = radioButtonForFalse.getSelection();
		if(selection){
			return TRUE_CONSTANT;
		}
		return FALSE_CONSTANT;
	}

	public void hideFromView() {
		
	}

	public void unHideFromView() {
		
	}

	public void update(Event event) {
		
	}
	
	public void setGrayed(boolean grayed)
	{
		radioButtonForTrue.setEnabled(!grayed);
		radioButtonForFalse.setEnabled(!grayed);
		
		if (grayed)
		{
			radioButtonForTrue.setForeground(radioButtonForTrue.getDisplay().getSystemColor(SWT.COLOR_GRAY));
			radioButtonForFalse.setForeground(radioButtonForFalse.getDisplay().getSystemColor(SWT.COLOR_GRAY));
			label.setForeground(label.getDisplay().getSystemColor(SWT.COLOR_GRAY));
		}
		else
		{
			radioButtonForTrue.setForeground(radioButtonForTrue.getDisplay().getSystemColor(SWT.COLOR_BLACK));
			radioButtonForFalse.setForeground(radioButtonForFalse.getDisplay().getSystemColor(SWT.COLOR_BLACK));
			label.setForeground(label.getDisplay().getSystemColor(SWT.COLOR_BLACK));
		}
	}
	
}
