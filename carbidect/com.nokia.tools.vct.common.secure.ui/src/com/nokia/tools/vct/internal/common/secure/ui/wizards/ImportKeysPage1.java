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

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import com.nokia.tools.vct.internal.common.secure.ui.fields.ImportKeysFieldGroup;

public class ImportKeysPage1 extends WizardPage {
	static final String PAGE_ID = ImportKeysPage1.class.getName();

	private ImportKeysFieldGroup fieldGroup;

	public ImportKeysPage1() {
		super(PAGE_ID);
		setTitle("Importing of the keys and certificates");
		setMessage("Browse for the keys and certificates, which you want to import.");
		fieldGroup = new ImportKeysFieldGroup();
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
		List<String> names = fieldGroup.getSourceFile();
		if (names.isEmpty()) {
			setPageComplete(false);
			setMessage("Name field is required");
			return;
		}

		setPageComplete(true);
		setMessage("Press \"Finish\" to export keys");
		setErrorMessage(null);

	}

	public List<String> getSourceFile() {
		return fieldGroup.getSourceFile();
	}
}
