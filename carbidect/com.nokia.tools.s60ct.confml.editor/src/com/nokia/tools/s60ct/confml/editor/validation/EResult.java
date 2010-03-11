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

public enum EResult implements IResult{

	VALID,

	MAX_EXCL_VALUE_EXCEED,

	MIN_EXCL_VALUE_UNDERRUN,

	MAX_INCL_VALUE_EXCEED,

	MIN_INCL_VALUE_UNDERRUN,

	TOTAL_DIGITS_EXCEED,

	PATTERN_NOT_MATCHED,

	EXACT_LENGTH_NOT_MATCHED,

	MIN_LENGTH_UNDERRUN,

	MAX_LENGTH_EXCEED,

	MAX_SIZE_EXCEED,
	
	RECOMMENDED_SIZE_EXCEED,

	NUMBER_OUT_OF_RANGE,

	INCORRECT_NUMBER_FORMAT,

	INCORRECT_BOOLEAN_FORMAT,

	INCORRECT_FILE_FORMAT,

	INVALID_FILE_PATH,

	FILENOTEXIST,

	DIRECTORYNOTEXIST,

	INCORRECT_FILE_EXTENSION,

	MINUS_ONLY,

	NON_ALLOWED_SETTING_TYPE,

	NON_EXISTED_SETTING,

	INCORRECT_SEQUENCE_SETTING,

	MAX_SEQUENCES_EXCEED,

	MIN_SEQUENCES_UNDERRUN, INCORRECT_DATE_FORMAT, INCORRECT_TIME_FORMAT, INCORRECT_DATE_TIME_FORMAT, INCORRECT_DURATION_FORMAT, VALUE_IS_MISSING,

	CONSTRAINT_FAILED,

	MAX_COLOR_EXCEED, MAX_BITS_EXCEED, MAX_WIDTH_EXCEED, MAX_HEIGHT_EXCEED, MIN_WIDTH_NOT_REACHED, MIN_HEIGHT_NOT_REACHED, WIDTH_NOT_MATCHED, HEIGHT_NOT_MATCHED, NON_EXISTING_OPTION,
	
	CONSTRAINT_IS_NOT_APPLICABLE,
	
	TOO_BIG_VALUE,
	
	THEME_VERSION_NOT_MATCH,
	
	UNABLE_IDENTIFY,
	NON_RELEVANT_DEPENDENCIES
	;
	
	private String faultDescription = "";
	
	public String getErrorDescription() {
		switch (this) {
		case INCORRECT_DURATION_FORMAT:
			return Messages.INCORRECT_DURATION_FORMAT;
		case INCORRECT_DATE_TIME_FORMAT:
			return Messages.INCORRECT_DATE_TIME_FORMAT;
		case INCORRECT_TIME_FORMAT:
			return Messages.INCORRECT_TIME_FORMAT;
		case INCORRECT_DATE_FORMAT:
			return Messages.INCORRECT_DATE_FORMAT;
		case VALUE_IS_MISSING:
			return Messages.VALUE_IS_MISSING;
		case VALID:
			return Messages.VALID;
		case MAX_EXCL_VALUE_EXCEED:
			return Messages.MAX_EXCL_VALUE_EXCEED;
		case MIN_EXCL_VALUE_UNDERRUN:
			return Messages.MIN_EXCL_VALUE_UNDERRUN;
		case MAX_INCL_VALUE_EXCEED:
			return Messages.MAX_INCL_VALUE_EXCEED;
		case MIN_INCL_VALUE_UNDERRUN:
			return Messages.MIN_INCL_VALUE_UNDERRUN;
		case TOTAL_DIGITS_EXCEED:
			return Messages.TOTAL_DIGITS_EXCEED;
		case PATTERN_NOT_MATCHED:
			return Messages.PATTERN_NOT_MATCHED;
		case EXACT_LENGTH_NOT_MATCHED:
			return Messages.EXACT_LENGTH_NOT_MATCHED;
		case MIN_LENGTH_UNDERRUN:
			return Messages.MIN_LENGTH_UNDERRUN;
		case MAX_LENGTH_EXCEED:
			return Messages.MAX_LENGTH_EXCEED;
		case MAX_SIZE_EXCEED:
			return Messages.MAX_SIZE_EXCEED;
		case RECOMMENDED_SIZE_EXCEED:
			return Messages.RECOMMENDED_SIZE_EXCEED;
		case NUMBER_OUT_OF_RANGE:
			return Messages.NUMBER_OUT_OF_RANGE;
		case INCORRECT_NUMBER_FORMAT:
			return Messages.INCORRECT_NUMBER_FORMAT;
		case INCORRECT_BOOLEAN_FORMAT:
			return Messages.INCORRECT_BOOLEAN_FORMAT;
		case INCORRECT_FILE_FORMAT:
			return Messages.INCORRECT_FILE_FORMAT;
		case INVALID_FILE_PATH:
			return Messages.INVALID_FILE_PATH;
		case FILENOTEXIST:
			return Messages.FILENOTEXIST;
		case DIRECTORYNOTEXIST:
			return Messages.DIRECTORYNOTEXIST;
		case INCORRECT_FILE_EXTENSION:
			return Messages.INCORRECT_FILE_EXTENSION;
		case MINUS_ONLY:
			return Messages.MINUS_ONLY;
		case NON_ALLOWED_SETTING_TYPE:
			return Messages.NON_ALLOWED_SETTING_TYPE;
		case NON_EXISTED_SETTING:
			return Messages.NON_EXISTED_SETTING;
		case INCORRECT_SEQUENCE_SETTING:
			return Messages.INCORRECT_SEQUENCE_SETTING;
		case MAX_SEQUENCES_EXCEED:
			return Messages.MAX_SEQUENCES_EXCEED;
		case MIN_SEQUENCES_UNDERRUN:
			return Messages.MIN_SEQUENCES_UNDERRUN;
		case CONSTRAINT_FAILED:
			return Messages.CONSTRAINT_FAILED;
//		case THEME_VERSION_NOT_MATCH:
//			return Messages.THEME_VERSION_NOT_MATCH;
//		case UNABLE_IDENTIFY:
//			return Messages.UNABLE_IDENTIFY;

		case MAX_COLOR_EXCEED:
			return Messages.MAX_COLOR_EXCEED;
		case MAX_BITS_EXCEED:
			return Messages.MAX_BITS_EXCEED;
		case MAX_WIDTH_EXCEED:
			return Messages.MAX_WIDTH_EXCEED;
		case MAX_HEIGHT_EXCEED:
			return Messages.MAX_HEIGHT_EXCEED;
		case MIN_WIDTH_NOT_REACHED:
			return Messages.MIN_WIDTH_NOT_REACHED;
		case MIN_HEIGHT_NOT_REACHED:
			return Messages.MIN_HEIGHT_NOT_REACHED;
		case WIDTH_NOT_MATCHED:
			return Messages.WIDTH_NOT_MATCHED;
		case HEIGHT_NOT_MATCHED:
			return Messages.HEIGHT_NOT_MATCHED;
		case NON_EXISTING_OPTION:
			return Messages.NON_EXISTING_OPTION;
		case CONSTRAINT_IS_NOT_APPLICABLE:
			return Messages.CONSTRAINT_IS_NOT_APPLICABLE;
		case TOO_BIG_VALUE:
			return Messages.TOO_BIG_VALUE;
		case NON_RELEVANT_DEPENDENCIES:
			return Messages.NON_RELEVANT_DEPENDENCIES;
		default:
			return "";
		}
	}

	public String getFaultDescription() {
		return faultDescription;
	}
	
	public void setFaultDescription(String faultDescription) {
		if(!faultDescription.equals("") && faultDescription != null) {
			this.faultDescription = " (" + faultDescription + ")";
		} else {
			this.faultDescription = "";
		}
	}
	
}
