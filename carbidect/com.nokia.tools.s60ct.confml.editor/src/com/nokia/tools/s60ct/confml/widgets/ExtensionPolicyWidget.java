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

import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import com.nokia.tools.s60ct.confml.commands.SetExtensionPolicyCommand;
import com.nokia.tools.s60ct.confml.viewer.FeatureViewer;
import com.nokia.tools.s60ct.confml.viewer.IValuesContentProvider;
import com.nokia.tools.s60ct.model.confml.EExtensionPolicy;
import com.nokia.tools.s60ct.model.confml.impl.ESequenceValueImpl;

public class ExtensionPolicyWidget extends BaseConfMLWidget {

	private Button radioButtonReplace;
	private Button radioButtonAppend;
	private Button radioButtonPrefix;
	private static final String REPLACE = "replace";
	private static final String APPEND = "append";
	private static final String PREFIX = "prefix";
	private FeatureViewer viewer = null;

	public ExtensionPolicyWidget(Composite parent, int style,String widgetLabel) {
		super( parent, style, widgetLabel);
		
		}

	public ExtensionPolicyWidget(Composite parent, int style, String widgetLabel,
			Image image) {
		super(parent, style, widgetLabel, image);
	}
			
	public void setErrorMessage(String message) {
	}

	public void clearErrorMessage() {
	}

	@Override
	protected void buildMainControl() {
		
		GridLayout gridLayout = new GridLayout(4, false);
		gridLayout.horizontalSpacing = 16;
		gridLayout.verticalSpacing = 0;
		gridLayout.marginWidth = 32;
		gridLayout.marginHeight = 0;
		group.setLayout(gridLayout);
		group.setLayoutData(new GridData(GridData.FILL_BOTH | GridData.VERTICAL_ALIGN_CENTER));
	
		
		radioButtonReplace = new Button(group, SWT.RADIO);
		radioButtonReplace.setText(REPLACE);

		radioButtonAppend = new Button(group, SWT.RADIO);
		radioButtonAppend.setText(APPEND);
		
		radioButtonPrefix = new Button(group, SWT.RADIO);
		radioButtonPrefix.setText(PREFIX);
		
		radioButtonReplace.setBackground(group.getDisplay().getSystemColor(
				SWT.COLOR_WHITE));
		radioButtonAppend.setBackground(group.getDisplay().getSystemColor(
				SWT.COLOR_WHITE));
		radioButtonPrefix.setBackground(group.getDisplay().getSystemColor(
				SWT.COLOR_WHITE));
		
		
		
		
	}

	public void setViever(FeatureViewer viewer)
	{
		this.viewer = viewer;
	}
	
	private void updateRadioButtons()
	{
		EExtensionPolicy policy = ((ESequenceValueImpl)this.getData()).getExtensionPolicy();
		if (policy!=null)
		{
			if (policy.getValue() == EExtensionPolicy.APPEND_VALUE)
			{
				radioButtonAppend.setSelection(true);
			}
			else if (policy.getValue() == EExtensionPolicy.PREFIX_VALUE)
			{
				radioButtonPrefix.setSelection(true);
			}
			else if (policy.getValue() == EExtensionPolicy.REPLACE_VALUE)
			{
				radioButtonReplace.setSelection(true);
			}
		}
	}
	
	class RadioButtonMouseListener implements MouseListener
	{
		
		public void mouseUp(MouseEvent e) {
			setExtensionPolicy();
		}
		
		public void mouseDoubleClick(MouseEvent e) {
		}
		
		public void mouseDown(MouseEvent e) {
		}
	}
	
	public void addListener(final Listener listener) {
		
		RadioButtonMouseListener mouseListener = new RadioButtonMouseListener();
		radioButtonReplace.addMouseListener(mouseListener);
		radioButtonAppend.addMouseListener(mouseListener);
		radioButtonPrefix.addMouseListener(mouseListener);
		/*
		radioButtonReplace.addListener(SWT.MouseDown,listener);
		radioButtonReplace.addDisposeListener(new DisposeListener() {

			public void widgetDisposed(DisposeEvent e) {
				radioButtonReplace.removeDisposeListener(this);
				radioButtonReplace.removeListener(SWT.MouseDown, listener);
			}
		});
		radioButtonAppend.addListener(SWT.MouseDown,listener);
		radioButtonAppend.addDisposeListener(new DisposeListener() {

			public void widgetDisposed(DisposeEvent e) {
				radioButtonAppend.removeDisposeListener(this);
				radioButtonAppend.removeListener(SWT.MouseDown, listener);
			}
		});
		radioButtonPrefix.addListener(SWT.MouseDown, listener);
		radioButtonPrefix.addDisposeListener(new DisposeListener() {

			public void widgetDisposed(DisposeEvent e) {
				radioButtonPrefix.removeDisposeListener(this);
				radioButtonPrefix.removeListener(SWT.MouseDown, listener);
			}
		});
		*/
		
		super.addListener(listener);
		updateRadioButtons();
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

		drawReplaceRadioButtonFocusUI();
		drawAppendRadioButtonFocusUI();
		drawPrefixRadioButtonFocusUI();
		//setExtensionPolicy();
		return false;
	}

	
	private void setExtensionPolicy()
	{

		EExtensionPolicy policy = null;
		
		if (radioButtonReplace.getSelection())
		{
			policy =  EExtensionPolicy.REPLACE;
			
		}
		else if (radioButtonAppend.getSelection())
		{
			policy =  EExtensionPolicy.APPEND;
		}
		else if (radioButtonPrefix.getSelection())
		{
			policy =  EExtensionPolicy.PREFIX;
		}
		
		if (policy!= null)
		{
			IContentProvider contentProvider = viewer.getContentProvider();
			IValuesContentProvider valuesContentProvider = (IValuesContentProvider) contentProvider;
			valuesContentProvider.valueChanged(policy.getName(), getData());
			viewer.refresh();	
		}
		else
		{
			System.out.println("Extension policy NULL");
		}
		
		
	}
	

	@Override
	protected void drawFocusUI() {
		super.drawFocusUI();
		System.out.println("Extension policy widget drawUnFocusUI()");
		//drawReplaceRadioButtonFocusUI();
		//drawAppendRadioButtonFocusUI();
		//drawPrefixRadioButtonFocusUI();
	}

	private void drawReplaceRadioButtonFocusUI() {
		radioButtonReplace.setBackground(group.getDisplay().getSystemColor(
				SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		radioButtonReplace.setForeground(group.getDisplay().getSystemColor(
				SWT.COLOR_WIDGET_FOREGROUND));
	}
	private void drawAppendRadioButtonFocusUI() {
		radioButtonAppend.setBackground(group.getDisplay().getSystemColor(
				SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		radioButtonAppend.setForeground(group.getDisplay().getSystemColor(
				SWT.COLOR_WIDGET_FOREGROUND));
	}
	private void drawPrefixRadioButtonFocusUI() {
		radioButtonPrefix.setBackground(group.getDisplay().getSystemColor(
				SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		radioButtonPrefix.setForeground(group.getDisplay().getSystemColor(
				SWT.COLOR_WIDGET_FOREGROUND));
	}


	protected void drawUnFocusUI() {
		super.drawUnFocusUI();
		System.out.println("Extension policy widget drawUnFocusUI()");
		drawReplaceRadioButtonUnfocusUI();
		drawAppendRadioButtonUnfocusUI();
		drawPrefixRadioButtonUnfocusUI();
	}

	private void drawReplaceRadioButtonUnfocusUI() {
		radioButtonReplace.setBackground(group.getDisplay().getSystemColor(
				SWT.COLOR_WIDGET_BACKGROUND));
		radioButtonReplace.setForeground(group.getDisplay().getSystemColor(
				SWT.COLOR_WIDGET_FOREGROUND));
	}

	private void drawAppendRadioButtonUnfocusUI() {
		radioButtonAppend.setBackground(group.getDisplay().getSystemColor(
				SWT.COLOR_WIDGET_BACKGROUND));
		radioButtonAppend.setForeground(group.getDisplay().getSystemColor(
				SWT.COLOR_WIDGET_FOREGROUND));
	}
	
	private void drawPrefixRadioButtonUnfocusUI() {
		radioButtonPrefix.setBackground(group.getDisplay().getSystemColor(
				SWT.COLOR_WIDGET_BACKGROUND));
		radioButtonPrefix.setForeground(group.getDisplay().getSystemColor(
				SWT.COLOR_WIDGET_FOREGROUND));
	}


	/**
	 * If initialValue is null , initial value is set to false;
	 */
	public void setInitialValue(String initialValue) {
		if(initialValue != null){
			setValue(initialValue);
		}else{
			setValue(REPLACE);
		}
	}

	/**
	 * selects the appropriate radio button and updates the corresponding model
	 */
	public void setValue(String value) {
		if(value == null){
			return;
		}
		if (value.equalsIgnoreCase(REPLACE))
		{
			radioButtonReplace.setSelection(true);
			radioButtonAppend.setSelection(false);
			radioButtonPrefix.setSelection(false);
		}
		else if (value.equalsIgnoreCase(APPEND))
		{
			radioButtonReplace.setSelection(false);
			radioButtonAppend.setSelection(true);
			radioButtonPrefix.setSelection(false);
		}
		else if (value.equalsIgnoreCase(PREFIX))
		{
			radioButtonReplace.setSelection(false);
			radioButtonAppend.setSelection(false);
			radioButtonPrefix.setSelection(true);
		}
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
		replaceRadioButtonSelectUI();
		appendRadioButtonSelectUI();
		prefixRadioButtonSelectUI();
	}

	/**
	 * Draws the UI for true Radio Button on selection
	 */
	private void replaceRadioButtonSelectUI() {
		radioButtonReplace.setBackground(group.getDisplay().getSystemColor(
				SWT.COLOR_LIST_SELECTION));
		radioButtonReplace.setForeground(group.getDisplay().getSystemColor(
				SWT.COLOR_LIST_SELECTION_TEXT));
	}
	
	private void prefixRadioButtonSelectUI() {
		radioButtonPrefix.setBackground(group.getDisplay().getSystemColor(
				SWT.COLOR_LIST_SELECTION));
		radioButtonPrefix.setForeground(group.getDisplay().getSystemColor(
				SWT.COLOR_LIST_SELECTION_TEXT));
	}
	
	private void appendRadioButtonSelectUI() {
		radioButtonAppend.setBackground(group.getDisplay().getSystemColor(
				SWT.COLOR_LIST_SELECTION));
		radioButtonAppend.setForeground(group.getDisplay().getSystemColor(
				SWT.COLOR_LIST_SELECTION_TEXT));
	}

	@Override
	public String getValue() {
//		boolean selection = radioButtonForFalse.getSelection();
//		if(selection){
//			return TRUE_CONSTANT;
//		}
//		return FALSE_CONSTANT;
		
		return ((ESequenceValueImpl)this.getData()).getExtensionPolicy().getName();

		//return "replace";
	}

	public void hideFromView() {
		
	}

	public void unHideFromView() {
		
	}

	public void update(Event event) {
		
	}
	
	public void setGrayed(boolean grayed)
	{
		radioButtonReplace.setEnabled(!grayed);
		radioButtonAppend.setEnabled(!grayed);
		radioButtonPrefix.setEnabled(!grayed);
		if (grayed)
		{
			label.setForeground(label.getDisplay().getSystemColor(SWT.COLOR_GRAY));
			radioButtonReplace.setForeground(radioButtonReplace.getDisplay().getSystemColor(SWT.COLOR_GRAY));
			radioButtonAppend.setForeground(radioButtonAppend.getDisplay().getSystemColor(SWT.COLOR_GRAY));
			radioButtonPrefix.setForeground(radioButtonPrefix.getDisplay().getSystemColor(SWT.COLOR_GRAY));
		}
		else
		{
			label.setForeground(label.getDisplay().getSystemColor(SWT.COLOR_BLACK));
			radioButtonReplace.setForeground(radioButtonReplace.getDisplay().getSystemColor(SWT.COLOR_BLACK));
			radioButtonAppend.setForeground(radioButtonAppend.getDisplay().getSystemColor(SWT.COLOR_BLACK));
			radioButtonPrefix.setForeground(radioButtonPrefix.getDisplay().getSystemColor(SWT.COLOR_BLACK));
		}
	}

}

