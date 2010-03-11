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
 * Description: This file is part of com.nokia.tools.variant.views component.
 */

package com.nokia.tools.variant.views.common;

import org.eclipse.osgi.util.NLS;

public class ViewsMessages extends NLS {
	private static final String BUNDLE_NAME = "com.nokia.tools.variant.views.common.messages";

	public static String DEFAULT_TEXT;

	// Errors view page
	public static String ERROR_COLUMN_1_NAME;
	public static String ERROR_COLUMN_2_NAME;
	public static String ERROR_COLUMN_3_NAME;
	public static String ERRORS;

	// Notes view page
	public static String NOTES;
	public static String NOTES_COLUMN_1_NAME;
	public static String NOTES_COLUMN_2_NAME;
	public static String NOTES_COLUMN_3_NAME;

	// Changes view page
	public static String CHANGES_COLUMN_1_NAME;
	public static String CHANGES_COLUMN_2_NAME;
	public static String CHANGES_COLUMN_3_NAME;
	public static String CHANGES_COLUMN_4_NAME;
	public static String CHANGES;

	// Search result view page
	public static String SEARCH_COLUMN_1_NAME;
	public static String SEARCH_COLUMN_2_NAME;
	public static String SEARCH_COLUMN_3_NAME;
	public static String MATCHES;

	static {
		// load message values from bundle file
		NLS.initializeMessages(BUNDLE_NAME, ViewsMessages.class);
	}

}
