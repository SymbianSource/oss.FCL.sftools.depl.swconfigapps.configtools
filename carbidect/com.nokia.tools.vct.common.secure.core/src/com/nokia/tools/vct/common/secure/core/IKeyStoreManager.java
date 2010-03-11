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
 * Description: This file is part of com.nokia.tools.vct.common.secure.core component.
 */

package com.nokia.tools.vct.common.secure.core;

import java.io.InputStream;
import java.io.OutputStream;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;

public interface IKeyStoreManager {

	void addListener(IKeyStoreListener listener);

	void removeListener(IKeyStoreListener listener);

	KeyPair generateKeyPair() throws CoreException;

	X509Certificate createCertificate(KeyPair keys, int years,
			Map<String, String> fields) throws CoreException;

	void addCertificate(X509Certificate certificate, PrivateKey privateKey,
			String password) throws CoreException;

	IKeyStoreEntry[] listEntries();

	void removeEntry(IKeyStoreEntry entry) throws CoreException;

	PrivateKey getPrivateKey(IKeyStoreEntry entry, String password)
			throws CoreException;

	X509Certificate getCertificate(IKeyStoreEntry entry);
	
	List<IKeyStoreEntry> importCertificate(InputStream is) throws CoreException;
	
	List<IKeyStoreEntry> importEntries(InputStream is, Map<String, String> alias2password) throws CoreException;

	void exportEntries(List<IKeyStoreEntry> entries, List<String> entryPassList,
			 OutputStream os, String certificateFolder) throws CoreException;

	IKeyStoreEntry getDefaultEntry();
	void setDefaultEntry(IKeyStoreEntry entry);
	
	String getPasswordCookie();
	void setPasswordCookie(String password);
	boolean checkPassword(IKeyStoreEntry entry, String passphrase);
	
	// cert information
	String getName(X509Certificate x509);
	String getOrganization(X509Certificate x509);
	
}
