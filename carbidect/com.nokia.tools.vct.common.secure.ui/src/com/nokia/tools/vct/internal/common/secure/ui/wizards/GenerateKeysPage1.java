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

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import com.nokia.tools.vct.internal.common.secure.ui.fields.KeyGenFieldGroup;

public class GenerateKeysPage1 extends WizardPage {

	static final String PAGE_ID = GenerateKeysPage1.class.getName();

	private KeyGenFieldGroup keyGenFields;

	public GenerateKeysPage1() {
		super(PAGE_ID);
		setTitle("Generate key pair");
		setMessage("Fill necessary information for generating of the new key pair.");
		
		keyGenFields = new KeyGenFieldGroup();
		keyGenFields.addObserver(new Observer() {
			public void update(Observable o, Object arg) {
				validateFields();
			}
		});
		setPageComplete(false);
	}

	public void createControl(Composite parent) {
		Composite control = new Composite(parent, SWT.NONE);

		control.setLayout(new GridLayout(3, false));
		keyGenFields.fillIntoGrid(control, 3);

		setControl(control);
	}

	void validateFields() {
		String name = keyGenFields.getName();
		if (name.trim().length() == 0) {
			setPageComplete(false);
			setMessage("Name field is required");
			return;
		}
		
		String pass1 = keyGenFields.getPassword1();
		if (pass1.length() < 5) {
			setPageComplete(false);
			setErrorMessage("Password must be at least 5 characters");
			setMessage(null);
			return;
		}
		String pass2 = keyGenFields.getPassword2();
		if (!pass1.equals(pass2)) {
			setPageComplete(false);
			setErrorMessage("Passwords do not match");
			setMessage(null);
			return;
		}
		setPageComplete(true);
		setMessage("Press \"Finish\" to generate certificate and key pair");
		setErrorMessage(null);
	}

	public Map<String, String> getFieldsMap() {
		Map<String,String> result = new HashMap<String, String>();
		
		result.put("CN", keyGenFields.getName());
		result.put("O", keyGenFields.getName());
		result.put("OU", keyGenFields.getOrganization());
		result.put("C", keyGenFields.getCountry());
		result.put("ST", keyGenFields.getState());
		
		return result;
	}

	
	public String getPassword() {
		return keyGenFields.getPassword1();
	}
	
	public int getValidityYears() {
		return keyGenFields.getValidity();
	}

}
