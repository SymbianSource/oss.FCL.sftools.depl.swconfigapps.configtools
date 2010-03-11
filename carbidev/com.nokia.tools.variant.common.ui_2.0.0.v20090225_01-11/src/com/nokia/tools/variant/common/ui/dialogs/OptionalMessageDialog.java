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
 * Description: This file is part of com.nokia.tools.variant.common.ui component.
 */

package com.nokia.tools.variant.common.ui.dialogs;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import com.nokia.tools.variant.common.ui.CommonUIPlugin;

/**
 * This is a {@link MessageDialog} which allows the user to choose that the
 * dialog isn't shown again the next time.
 * 
 * The original code is taken from JDT.
 * 
 */
public class OptionalMessageDialog extends MessageDialog {

	// String constants for widgets
	private static final String CHECKBOX_TEXT = "Do not show again";

	/** Constant for the configuration store prefix */
	private static final String STORE_ID = "OptionalMessageDialog.hide."; //$NON-NLS-1$

	/** Status code indicating the "not shown" dialog result */
	public static final int NOT_SHOWN = IDialogConstants.CLIENT_ID + 1;

	private final String id;
	private final String checkBoxText;
	private Button hideDialogCheckBox;

	/**
	 * Opens the dialog but only if the user hasn't choosen to hide it. Returns
	 * <code>NOT_SHOWN</code> if the dialog was not shown.
	 */
	public static int open(String id, Shell parent, String title,
			Image titleImage, String message, int dialogType,
			String[] buttonLabels, int defaultButtonIndex) {
		return open(id, parent, title, titleImage, message, dialogType,
				buttonLabels, defaultButtonIndex, CHECKBOX_TEXT);
	}

	public static int open(String id, Shell parent, String title,
			Image titleImage, String message, int dialogType,
			String[] buttonLabels, int defaultButtonIndex, String checkboxText) {
		if (!isDialogEnabled(id))
			return OptionalMessageDialog.NOT_SHOWN;

		MessageDialog dialog = new OptionalMessageDialog(id, parent, title,
				titleImage, message, dialogType, buttonLabels,
				defaultButtonIndex, checkboxText);
		return dialog.open();
	}

	protected OptionalMessageDialog(String id, Shell parent, String title,
			Image titleImage, String message, int dialogType,
			String[] buttonLabels, int defaultButtonIndex) {
		this(id, parent, title, titleImage, message, dialogType, buttonLabels,
				defaultButtonIndex, CHECKBOX_TEXT);
	}

	protected OptionalMessageDialog(String id, Shell parent, String title,
			Image titleImage, String message, int dialogType,
			String[] buttonLabels, int defaultButtonIndex, String checkBoxText) {
		super(parent, title, titleImage, message, dialogType, buttonLabels,
				defaultButtonIndex);
		this.id = id;
		this.checkBoxText = checkBoxText;
	}

	protected Control createCustomArea(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.marginHeight = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_MARGIN);
		layout.marginWidth = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_MARGIN);
		layout.horizontalSpacing = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_SPACING);
		composite.setLayout(layout);
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));

		hideDialogCheckBox = new Button(composite, SWT.CHECK | SWT.LEFT);
		hideDialogCheckBox.setText(checkBoxText);
		hideDialogCheckBox.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				setDialogEnabled(id, !((Button) e.widget).getSelection());
			}
		});
		applyDialogFont(hideDialogCheckBox);
		return hideDialogCheckBox;
	}

	// --------------- Configuration handling --------------

	/**
	 * Returns this dialog
	 * 
	 * @return the settings to be used
	 */
	private static IDialogSettings getDialogSettings() {
		IDialogSettings settings = CommonUIPlugin.getDefault()
				.getDialogSettings();
		settings = settings.getSection(STORE_ID);
		if (settings == null)
			settings = CommonUIPlugin.getDefault().getDialogSettings()
					.addNewSection(STORE_ID);
		return settings;
	}

	/**
	 * Answers whether the optional dialog is enabled and should be shown.
	 */
	public static boolean isDialogEnabled(String key) {
		IDialogSettings settings = getDialogSettings();
		return !settings.getBoolean(key);
	}

	/**
	 * Sets whether the optional dialog is enabled and should be shown.
	 */
	public static void setDialogEnabled(String key, boolean isEnabled) {
		IDialogSettings settings = getDialogSettings();
		settings.put(key, !isEnabled);
	}

	/**
	 * Clears all remembered information about hidden dialogs
	 */
	public static void clearAllRememberedStates() {
		IDialogSettings settings = CommonUIPlugin.getDefault()
				.getDialogSettings();
		settings.addNewSection(STORE_ID);
	}
}
