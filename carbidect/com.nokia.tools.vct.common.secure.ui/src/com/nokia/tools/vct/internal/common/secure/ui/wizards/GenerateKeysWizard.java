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

import java.security.KeyPair;
import java.security.cert.X509Certificate;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.wizard.Wizard;

import com.nokia.tools.vct.common.secure.core.IKeyStoreManager;
import com.nokia.tools.vct.common.secure.core.SecurityCorePlugin;
import com.nokia.tools.vct.secure.common.ui.SecurityUI;

public class GenerateKeysWizard extends Wizard {

	private GenerateKeysPage1 page1;
	private KeyPair keyPair;
	private X509Certificate certificate;
	
	private static final String TITLE_IMAGE_PATH = "icons/handle_keys.png";
	
	public GenerateKeysWizard() {
		setWindowTitle("Generate key wizard");
		setDefaultPageImageDescriptor(SecurityUI.getImageDescriptor(TITLE_IMAGE_PATH));
	}
	
	@Override
	public void addPages() {
		page1 = new GenerateKeysPage1();
		addPage(page1);
	}
	
	@Override
	public boolean performFinish() {
		
		IKeyStoreManager manager = SecurityCorePlugin.getKeyStoreManager();
		KeyPair keyPair;
		try {
			keyPair = manager.generateKeyPair();
		} catch (CoreException e) {
			// IMPROVEMENT Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		Map<String,String> fields = page1.getFieldsMap();
		int years = page1.getValidityYears();
		String password = page1.getPassword();
		
		X509Certificate certificate;
		try {
			certificate = manager.createCertificate(keyPair, years, fields);
		} catch (CoreException e) {
			// IMPROVEMENT Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		try {
			manager.addCertificate(certificate, keyPair.getPrivate(), password);
		} catch (CoreException e) {
			// IMPROVEMENT Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		this.keyPair = keyPair;
		this.certificate = certificate;
		
		return true;
	}
	
	public KeyPair getKeyPair() {
		return keyPair;
	}
	
	public X509Certificate getCertificate() {
		return certificate;
	}
	
}
