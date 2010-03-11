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
package com.nokia.tools.s60ct.javaversionchecker;

/**
 * Generates ui messages for {@link JavaVersionChecker}
 *
 */
public class MessageGenerator {
	private static final String TITLE = "Nokia S60 ConfigurationTool JRE integration warning";

	public static String generateMessage(){
		StringBuffer sb = new StringBuffer();
		sb.append("You are using not officially supported JRE: \n");
		sb.append(JavaVersionChecker.getCurrentVendorAndVersion());
		sb.append("\n\nOfficially supported JREs: \n");
		sb.append(JavaVersionChecker.getSupportedJreNames());
		sb.append("<a>Download JRE</a>\n");
		return sb.toString();
	}
	
	public static String generateTitle(){
		return TITLE;
	}
	
}
