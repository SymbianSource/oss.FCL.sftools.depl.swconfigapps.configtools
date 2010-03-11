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

package com.nokia.tools.vct.internal.common.secure.ui.wizards;

import java.util.Observable;
import java.util.Observer;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import com.nokia.tools.vct.internal.common.secure.ui.fields.ExportKeysFieldGroup;

public class ExportKeysPage1 extends WizardPage {
	static final String PAGE_ID = ExportKeysPage1.class.getName();

	private ExportKeysFieldGroup fieldGroup;

	public ExportKeysPage1(int pairCount, int certCount) {
		super(PAGE_ID);
		setTitle("Exporting of the keys or certificates");
		setMessage("Browse for the destination, where you want to export.");
		fieldGroup = new ExportKeysFieldGroup();
		setPageComplete(false);
		fieldGroup.setSelectedPairKeys(pairCount);
		fieldGroup.setSelectedCerts(certCount);
		fieldGroup.addObserver(new Observer() {
			public void update(Observable o, Object arg) {
				validateFields();
			}
		});
	}

	public void createControl(Composite parent) {
		Composite control = new Composite(parent, SWT.NONE);
		control.setLayout(new GridLayout(3, false));
		fieldGroup.fillIntoGrid(control, 3);
		setControl(control);
	}

	void validateFields() {

		if (fieldGroup.getExportPrivate()) {	
			String name = fieldGroup.getKeyDestinationFile();
			if (name.trim().length() == 0) {
				setPageComplete(false);
				setMessage("Destination field is required");
				return;
			}
		} else {
			String name = fieldGroup.getCertDestinationField();
			if (name.trim().length() == 0) {
				setPageComplete(false);
				setMessage("Destination field is required");
				return;
			}
		}

		setPageComplete(true);
		setMessage("Press \"Finish\" to export keys");
		setErrorMessage(null);

	}

	public String getKeyDestinationFile() {
		return fieldGroup.getKeyDestinationFile();
	}

	public boolean getExportPrivate() {
		return fieldGroup.getExportPrivate();
	}

	public String getCertificateFolder() {
		return fieldGroup.getCertDestinationField();
	}
}
