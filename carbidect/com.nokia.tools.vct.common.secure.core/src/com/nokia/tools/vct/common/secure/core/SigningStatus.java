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

import java.security.cert.X509Certificate;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.URI;

public class SigningStatus {
	public Object modelObject;
	public boolean contentOK;
	public boolean signatureFound;
	public boolean signatureParsed;
	public boolean signatureValid;
	public Set<URI> addedFiles = new HashSet<URI>();
	public Set<URI> removedFiles = new HashSet<URI>();
	public Set<URI> tamperedFiles = new HashSet<URI>();
	public Set<URI> checkedFiles = new HashSet<URI>();
	public X509Certificate certificate;
}
