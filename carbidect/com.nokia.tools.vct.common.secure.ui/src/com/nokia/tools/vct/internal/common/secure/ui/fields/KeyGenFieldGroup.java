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

package com.nokia.tools.vct.internal.common.secure.ui.fields;

import java.util.Observable;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import com.nokia.tools.vct.common.ui.wizards.dialogfields.ComboDialogField;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.DialogField;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.IDialogFieldListener;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.StringDialogField;

public class KeyGenFieldGroup extends Observable implements
		IDialogFieldListener {

	private StringDialogField nameField;
	private StringDialogField organizationField;
	private StringDialogField countryField;
	private StringDialogField stateField;
	private StringDialogField password1Field;
	private StringDialogField password2Field;
	private ComboDialogField validityField;

	public KeyGenFieldGroup() {
		nameField = new StringDialogField();
		organizationField = new StringDialogField();
		countryField = new StringDialogField();
		stateField = new StringDialogField();
		password1Field = new StringDialogField(SWT.PASSWORD | SWT.BORDER);
		password2Field = new StringDialogField(SWT.PASSWORD | SWT.BORDER);
		validityField = new ComboDialogField(SWT.READ_ONLY);

		nameField.setLabelText("Name:");
		organizationField.setLabelText("Organization:");
		countryField.setLabelText("Country:");
		stateField.setLabelText("State:");
		password1Field.setLabelText("Password:");
		password2Field.setLabelText("Confirm Password:");
		validityField.setLabelText("Valid for:");
		validityField.setItems(new String[] {"1 Year", "2 Years", "3 Years", "4 Years", "5 Years"});

		nameField.setDialogFieldListener(this);
		organizationField.setDialogFieldListener(this);
		countryField.setDialogFieldListener(this);
		stateField.setDialogFieldListener(this);
		password1Field.setDialogFieldListener(this);
		password2Field.setDialogFieldListener(this);
		validityField.setDialogFieldListener(this);
		validityField.selectItem(0);
		
		nameField.setRequired(true);
		password1Field.setRequired(true);
		password2Field.setRequired(true);
	}

	public void fillIntoGrid(Composite parent, int columns) {
		nameField.doFillIntoGrid(parent, columns);
		organizationField.doFillIntoGrid(parent, columns);
		countryField.doFillIntoGrid(parent, columns);
		stateField.doFillIntoGrid(parent, columns);
		Label sep = new Label(parent, SWT.SEPARATOR | SWT.HORIZONTAL);
		sep.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, columns,
				1));
		validityField.doFillIntoGrid(parent, columns);
		sep = new Label(parent, SWT.SEPARATOR | SWT.HORIZONTAL);
		sep.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, columns,
				1));
		
		password1Field.doFillIntoGrid(parent, columns);
		password2Field.doFillIntoGrid(parent, columns);
	}

	public void dialogFieldChanged(DialogField field) {
		setChanged();
		notifyObservers();
	}

	public String getName() {
		return nameField.getText();
	}

	public String getOrganization() {
		return organizationField.getText();
	}

	public String getCountry() {
		return countryField.getText();
	}

	public String getState() {
		return stateField.getText();
	}

	public String getPassword1() {
		return password1Field.getText();
	}

	public String getPassword2() {
		return password2Field.getText();
	}

	public int getValidity() {
		return validityField.getSelectionIndex() + 1;
	}
}
