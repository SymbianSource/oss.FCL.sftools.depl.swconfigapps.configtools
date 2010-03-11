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
package com.nokia.s60ct.messages;


import org.eclipse.osgi.util.NLS;

public class ValidationMessages extends NLS {

	private static final String BUNDLE_NAME = "com.nokia.S60CT.messages.ValidationMessages"; //$NON-NLS-1$
	
	public static String message_exception;
	public static String BatchValidationDelegate_title;
	public final static String BatchValidationDelegate_successMessage="Validation passed.";
	public final static String BatchValidationDelegate_errorMessage="Validation failed in the following areas (click OK to select problem elements in the editor):";
	public static String EnableLiveValidationDelegate_title;
	public static String Validation_error;
	public static String Validation_warn;
	public static String Validation_note;
	public static String Validation_problems;
	public static String Validation_rollback;
	public static String Console_Name;

//	static {
//		NLS.initializeMessages(BUNDLE_NAME, ValidationMessages.class);
//	}
}
