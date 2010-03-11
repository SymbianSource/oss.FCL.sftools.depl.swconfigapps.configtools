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
 * Description: This file is part of com.nokia.tools.carbide.validation.core component.
 */

package com.nokia.tools.carbide.validation.core;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "com.nokia.tools.carbide.confml.internal.core.validation.messages"; //$NON-NLS-1$
	public static String SETTING_13;
	public static String SETTING_DESCRIPTION_MISSING;
	public static String SETTING_ID_MISSING;
	public static String SETTING_NAME_MISSING;
	public static String SETTING_TYPE_MISSING;
	public static String SETTING_XMI_ID_MISSING;
	public static String MAX_EXCL_VALUE_EXCEED;
	public static String MIN_EXCL_VALUE_UNDERRUN;
	public static String MAX_INCL_VALUE_EXCEED;
	public static String MIN_INCL_VALUE_UNDERRUN;
	public static String TOTAL_DIGITS_EXCEED;
	public static String PATTERN_NOT_MATCHED;
	public static String EXACT_LENGTH_NOT_MATCHED;
	public static String MIN_LENGTH_UNDERRUN;
	public static String MAX_LENGTH_EXCEED;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
