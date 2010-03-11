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
 * Description: This file is part of com.nokia.tools.variant.report component.
 */
package com.nokia.tools.variant.report.dialog;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	// Strings in dialog
	public static String CreateReportTitle;
	public static String DialogTitleText;
	public static String ReportName;
	public static String SaveAs;
	public static String Options;
	public static String DisplayAsTable;
	public static String ValidationErrors;
	public static String Notes;
	public static String ShowDescriptions;
	public static String ShowGrouping;
	public static String OpenInBrowser;
	public static String Contents;
	public static String AllSettings;
	public static String NonDefaultValues;
	public static String SettingsWithNotes;
	public static String SettingsWithErrors;
	public static String SettingsWithKeyword;

	// Messages
	public static String ReportCreated;
	public static String ReportCreatedText;
	public static String FileNotFound;
	public static String FileCantOpen;
	public static String ReportNotCreated;
	public static String ReportNotCreatedText;

	public static String SingleWebPage;

	static {
		NLS.initializeMessages(Messages.class.getName(), Messages.class);
	}
}
