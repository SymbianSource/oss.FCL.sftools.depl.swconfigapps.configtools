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
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;

import com.nokia.tools.vct.common.ui.wizards.dialogfields.DialogField;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.IDialogFieldListener;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.IStringButtonAdapter;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.LayoutUtil;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.SelectionButtonDialogField;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.StringButtonDialogField;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.StringDialogField;

public class ExportKeysFieldGroup extends Observable implements
		IDialogFieldListener, IStringButtonAdapter {

	private StringDialogField keysSelectedField;
	private StringButtonDialogField keyDestinationField;
	private SelectionButtonDialogField privateField;

	private StringDialogField certSelectedField;
	private StringButtonDialogField certDestinationField;

	public ExportKeysFieldGroup() {
		keysSelectedField = new StringDialogField(SWT.BORDER | SWT.READ_ONLY);
		keyDestinationField = new StringButtonDialogField(this);
		privateField = new SelectionButtonDialogField(SWT.CHECK);
		certSelectedField = new StringDialogField(SWT.BORDER | SWT.READ_ONLY);
		certDestinationField = new StringButtonDialogField(this);

		keysSelectedField.setLabelText("Exporting Pairs:");
		keyDestinationField.setLabelText("Destination:");
		keyDestinationField.setEnabled(false);

		privateField
				.setLabelText("Export Pairs - private keys and certificates");

		keyDestinationField.setDialogFieldListener(this);
		privateField.setDialogFieldListener(this);

		certSelectedField.setLabelText("Exporting Certificates");
		certDestinationField.setLabelText("Destination");
	}

	public void fillIntoGrid(Composite parent, int columns) {

		privateField.doFillIntoGrid(parent, columns);

		keysSelectedField.doFillIntoGrid(parent, columns);
		keyDestinationField.doFillIntoGrid(parent, columns);

		Label sep2 = new Label(parent, SWT.SEPARATOR | SWT.HORIZONTAL);
		sep2.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false,
				columns, 1));

		certSelectedField.doFillIntoGrid(parent, columns);
		certDestinationField.doFillIntoGrid(parent, columns);

		LayoutUtil
				.setHorizontalGrabbing(keysSelectedField.getTextControl(null));
		LayoutUtil.setHorizontalGrabbing(keyDestinationField
				.getTextControl(null));
		LayoutUtil.setHorizontalGrabbing(privateField.getSelectionButton(null));
		LayoutUtil
				.setHorizontalGrabbing(certSelectedField.getTextControl(null));
		LayoutUtil.setHorizontalGrabbing(certDestinationField
				.getTextControl(null));
	}

	public void dialogFieldChanged(DialogField field) {

		if (field == privateField) {
			if (privateField.isSelected()) {
				keyDestinationField.setEnabled(true);
				certDestinationField.setEnabled(false);
			} else {
				keyDestinationField.setEnabled(false);
				certDestinationField.setEnabled(true);
			}
		}

		setChanged();
		notifyObservers();
	}

	public void changeControlPressed(DialogField field) {
		if (field == keyDestinationField) {
			FileDialog dialog = new FileDialog(Display.getCurrent()
					.getActiveShell(), SWT.SAVE);
			dialog.setFilterExtensions(new String[] { "*.p12" });
			dialog
					.setFilterNames(new String[] { "Personal Information Exchange (*.p12)" });
			String result = dialog.open();
			if (result != null) {
				keyDestinationField.setText(result);
				setChanged();
				notifyObservers();
			}
		}

		if (field == certDestinationField) {
			DirectoryDialog dialog = new DirectoryDialog(Display.getCurrent()
					.getActiveShell());
			dialog.setMessage("Select key destination.");
			String result = dialog.open();
			if (result != null) {
				certDestinationField.setText(result);
				setChanged();
				notifyObservers();
			}
		}
	}

	public String getKeyDestinationFile() {
		return keyDestinationField.getText();
	}

	public boolean getExportPrivate() {
		return privateField.isSelected();
	}

	public String getCertDestinationField() {
		return certDestinationField.getText();
	}

	public void setSelectedPairKeys(int count) {
		keysSelectedField.setText(String.valueOf(count));
		if (count==0) {
			privateField.setEnabled(false);
			keysSelectedField.setEnabled(false);
		}
	}
	
	public void setSelectedCerts(int count) {
		certSelectedField.setText(String.valueOf(count));
	}
}
