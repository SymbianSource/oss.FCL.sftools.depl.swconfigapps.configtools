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
 * Description: This file is part of com.nokia.tools.variant.viewer component.
 */

package com.nokia.tools.s60ct.confml.editor.validation;

import org.eclipse.osgi.util.NLS;


public class Messages extends NLS {
	
	public static String VALID;
	public static String MAX_EXCL_VALUE_EXCEED;
	public static String MIN_EXCL_VALUE_UNDERRUN;
	public static String MAX_INCL_VALUE_EXCEED;
	public static String MIN_INCL_VALUE_UNDERRUN;
	public static String TOTAL_DIGITS_EXCEED;
	public static String PATTERN_NOT_MATCHED;
	public static String EXACT_LENGTH_NOT_MATCHED;
	public static String MIN_LENGTH_UNDERRUN;
	public static String MAX_LENGTH_EXCEED;
	public static String MAX_SIZE_EXCEED;
	public static String RECOMMENDED_SIZE_EXCEED;
	public static String NUMBER_OUT_OF_RANGE;
	public static String INCORRECT_NUMBER_FORMAT;
	public static String INCORRECT_BOOLEAN_FORMAT;
	public static String INCORRECT_FILE_FORMAT;
	public static String INVALID_FILE_PATH;
	public static String FILENOTEXIST;
	public static String DIRECTORYNOTEXIST;
	public static String INCORRECT_FILE_EXTENSION;
	public static String MINUS_ONLY;
	public static String NON_ALLOWED_SETTING_TYPE;
	public static String NON_EXISTED_SETTING;
	public static String NO_DESCRIPTION;
	public static String INCORRECT_SEQUENCE_SETTING;
	public static String MAX_SEQUENCES_EXCEED;
	public static String MIN_SEQUENCES_UNDERRUN;
	public static String VALUE_IS_MISSING;
	public static String INCORRECT_DURATION_FORMAT;
	public static String INCORRECT_DATE_TIME_FORMAT;
	public static String INCORRECT_TIME_FORMAT;
	public static String INCORRECT_DATE_FORMAT;
	public static String CONSTRAINT_FAILED;
	public static String MAX_COLOR_EXCEED;
	public static String MAX_BITS_EXCEED;
	public static String MAX_WIDTH_EXCEED;
	public static String MAX_HEIGHT_EXCEED;
	public static String MIN_WIDTH_NOT_REACHED;
	public static String MIN_HEIGHT_NOT_REACHED;
	public static String WIDTH_NOT_MATCHED;
	public static String HEIGHT_NOT_MATCHED;
	public static String NON_EXISTING_OPTION;
	public static String CONSTRAINT_IS_NOT_APPLICABLE;
	public static String TOO_BIG_VALUE;
	public static String NON_RELEVANT_DEPENDENCIES;
//	public static String THEME_VERSION_NOT_MATCH;	
//	public static String UNABLE_IDENTIFY;
	
	static {
		NLS.initializeMessages(Messages.class.getName(), Messages.class);
	}
}
