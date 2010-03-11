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
 * Description: This file is part of com.nokia.tools.variant.editor component.
 */

package com.nokia.tools.variant.editor.validation;

import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.xml.datatype.DatatypeConstants;

import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.content.IContentDescription;
import org.eclipse.core.runtime.content.IContentType;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.eclipse.emf.ecore.xml.type.internal.XMLCalendar;
import org.eclipse.emf.ecore.xml.type.internal.XMLDuration;

import com.nokia.tools.variant.common.core.utils.FileUtils;
import com.nokia.tools.variant.content.confml.FilePath;
import com.nokia.tools.variant.content.confml.FileSystemEntrySetting;
import com.nokia.tools.variant.content.confml.Property;
import com.nokia.tools.variant.content.confml.SequenceSetting;
import com.nokia.tools.variant.content.confml.Setting;
import com.nokia.tools.variant.content.confml.SimpleSetting;
import com.nokia.tools.variant.editor.properties.FileProperty;
import com.nokia.tools.variant.media.ui.MediaUIPlugin;
import com.nokia.tools.variant.resourcelibrary.model.Directory;
import com.nokia.tools.variant.resourcelibrary.model.FileSystemElement;
import com.nokia.tools.variant.resourcelibrary.model.ResourceModelRoot;
import com.nokia.tools.variant.resourcelibrary.model.ThemeFile;
import com.nokia.tools.variant.resourcelibrary.resources.ResourceUtil;
import com.nokia.tools.variant.viewer.validation.EResult;
import com.nokia.tools.variant.viewer.validation.IResult;
import com.nokia.tools.variant.viewer.validation.Result;
import com.nokia.tools.variant.viewer.validation.ValidationResult;

public class SettingsValidator {

	private static final String FALSE_CONSTANT = "false";
	private static final String TRUE_CONSTANT = "true";

	private static final String DEFAULT_SIZE_UNIT = "kB";
	private static final String FILE_TYPE_SEPARATOR = "/";
	private static final String EMPTY = "";

	public static ValidationResult validateSetting(Setting setting,
			String settingValue, ResourceModelRoot root) {
		if (setting instanceof SimpleSetting) {

			String choosenOption = ((SimpleSetting) setting).getChoosenOption();
			if (choosenOption != null) {
				settingValue = choosenOption;
			}
		} else if (setting instanceof FilePath) {

			String choosenOption = ((FilePath) setting).getChoosenOption();
			if (choosenOption != null) {
				settingValue = choosenOption;
			}
		}
		return validateOptionForSetting(setting, settingValue, root);
	}

	public static ValidationResult validateOptionForSetting(Setting setting,
			String settingValue, ResourceModelRoot root) {

		ValidationResult validateConstraint = validateConstraint(setting);
		if (!validateConstraint.getResult().contains(EResult.VALID)) {
			return validateConstraint;
		}

		if (setting instanceof SequenceSetting) {
			try {
				return new ValidationResult(validateSequenceSetting(setting));
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
		}

		if (settingValue == null && !setting.isValueNull()) {
			return new ValidationResult(EResult.VALID);
		}

		if (setting instanceof FileSystemEntrySetting) {
			List<IResult> validateFileSetting = validateFileSetting(setting,
					settingValue, root);
			if (!validateFileSetting.contains(EResult.VALID)) {
				return new ValidationResult(validateFileSetting);
			} else if (settingValue != null) {
				if (settingValue.endsWith(".tpf")) {
					
					FileSystemElement child = root.findChild(new Path(settingValue));
					if(child instanceof ThemeFile){
						ThemeFile themeFile = (ThemeFile)child;
						String validationMessage = themeFile.getValidationMessage();
						if(validationMessage!=null&&!validationMessage.equals("")){
						
						return new ValidationResult(EResult.THEME_VERSION_NOT_MATCH,validationMessage);
						}
					}
					
				}
			}
			return new ValidationResult(validateFileSetting);
		}
		SimpleSetting simpleSetting = (SimpleSetting) setting;

		if (simpleSetting.getType() == com.nokia.tools.variant.content.confml.TYPE.BOOLEAN)
			return new ValidationResult(validateBooleanSetting(setting,
					settingValue));
		if (simpleSetting.getType() == com.nokia.tools.variant.content.confml.TYPE.INT)
			return new ValidationResult(validateIntSetting(setting,
					settingValue));
		if (simpleSetting.getType() == com.nokia.tools.variant.content.confml.TYPE.STRING)
			return new ValidationResult(validateStringSetting(setting,
					settingValue));
		if (simpleSetting.getType() == com.nokia.tools.variant.content.confml.TYPE.REAL)
			return new ValidationResult(validateRealSetting(setting,
					settingValue));
		if (simpleSetting.getType() == com.nokia.tools.variant.content.confml.TYPE.SIMPLE_FILE) {
			List<IResult> validateFileSetting = validateSimpleFileSetting(
					setting, settingValue, root);
			if (!validateFileSetting.contains(EResult.VALID)) {
				return new ValidationResult(validateFileSetting);
			} else if (settingValue != null) {
				if (settingValue.endsWith(".tpf")) {
				
					FileSystemElement child = root.findChild(new Path(settingValue));
					if(child instanceof ThemeFile){
						ThemeFile themeFile = (ThemeFile)child;
						String validationMessage = themeFile.getValidationMessage();
						if(validationMessage!=null&&!validationMessage.equals("")){
						return new ValidationResult(EResult.THEME_VERSION_NOT_MATCH,validationMessage);
						}
					}
				}
			}
			return new ValidationResult(validateFileSetting);
		}
		if (simpleSetting.getType() == com.nokia.tools.variant.content.confml.TYPE.SIMPLE_FOLDER)
			return new ValidationResult(validateSimpleFolderSetting(setting,
					settingValue, root));
		if (simpleSetting.getType() == com.nokia.tools.variant.content.confml.TYPE.FILE) {
			List<IResult> validateFileSetting = validateFileSetting(setting,
					settingValue, root);
			if (!validateFileSetting.contains(EResult.VALID)) {
				return new ValidationResult(validateFileSetting);
			} else if (settingValue != null) {
				if (settingValue.endsWith(".tpf")) {
					String realPath = new Path(root.getTempDirPath() + "/"
							+ settingValue).toOSString();
					FileSystemElement child = root.getChild(realPath);
					if(child instanceof ThemeFile){
						ThemeFile themeFile = (ThemeFile)child;
						String validationMessage = themeFile.getValidationMessage();
						if(validationMessage!=null&&!validationMessage.equals("")){
						return new ValidationResult(new ArrayList<IResult>(),validationMessage);
						}
					}
				}
			}
			return new ValidationResult(validateFileSetting);
		}
		if (simpleSetting.getType() == com.nokia.tools.variant.content.confml.TYPE.DATE_TIME)
			return new ValidationResult(validateDateTimeSetting(setting,
					settingValue));
		if (simpleSetting.getType() == com.nokia.tools.variant.content.confml.TYPE.DATE)
			return new ValidationResult(validateDateSetting(setting,
					settingValue));
		if (simpleSetting.getType() == com.nokia.tools.variant.content.confml.TYPE.TIME)
			return new ValidationResult(validateTimeSetting(setting,
					settingValue));
		if (simpleSetting.getType() == com.nokia.tools.variant.content.confml.TYPE.DURATION)
			return new ValidationResult(validateDurationSetting(setting,
					settingValue));
		if (simpleSetting.getType() == com.nokia.tools.variant.content.confml.TYPE.SELECTION)
			return new ValidationResult(validateSelectionSetting(setting,
					settingValue));
		if (simpleSetting.getType() == com.nokia.tools.variant.content.confml.TYPE.MULTISELECTION)
			return new ValidationResult(validateMultiSelectionSetting(setting));

		return new ValidationResult(EResult.NON_ALLOWED_SETTING_TYPE);
	}

	public static ValidationResult validateConstraint(Setting setting) {

		if (setting == null)
			return new ValidationResult(EResult.NON_EXISTED_SETTING);

		if (setting instanceof FilePath) {
			FilePath fp = (FilePath) setting;
			FileSystemEntrySetting fses = fp.getParent();

			if (fses.getConstraint() != null
					&& !fses.getConstraint().equals("")
					&& !fses.isComputedConstraint()) {
				FilePath sourceFilePath = fses.getSourceFilePath();
				FilePath targetFilePath = fses.getTargetFilePath();
				if (fp == sourceFilePath && fp.isComputedRelevant()) {
					return new ValidationResult(EResult.CONSTRAINT_FAILED,
							", constraint=" + fses.getConstraint());
				} else if (fp == targetFilePath
						&& (!sourceFilePath.isComputedRelevant() || sourceFilePath
								.isReadOnly()) && fp.isComputedRelevant()) {
					return new ValidationResult(EResult.CONSTRAINT_FAILED,
							", constraint=" + fses.getConstraint());
				}
			}
		}
		if (setting.getConstraint() != null
				&& !setting.getConstraint().equals("")
				&& setting.isComputedConstraint() == false) {
			return new ValidationResult(EResult.CONSTRAINT_FAILED,
					", constraint=" + setting.getConstraint());
		}
		return new ValidationResult(EResult.VALID);
	}

	private static EResult validateMultiSelectionSetting(Setting setting) {
		SimpleSetting simpleSetting = (SimpleSetting) setting;

		if (setting.isRequired() && setting.isValueNull()
				&& simpleSetting.getDefaultValue() == null) {
			return EResult.VALUE_IS_MISSING;
		}

		return EResult.VALID;
	}

	private static EResult validateSelectionSetting(Setting setting,
			String settingValue) {

		SimpleSetting simpleSetting = (SimpleSetting) setting;

		if (setting.isRequired() && settingValue == null
				&& simpleSetting.getDefaultValue() == null) {
			return EResult.VALUE_IS_MISSING;
		}

		return EResult.VALID;
	}

	// Confml v.1
	private static List<IResult> validateSimpleFileSetting(Setting setting,
			String settingValue, ResourceModelRoot root) {
		SimpleSetting simpleSet = (SimpleSetting) setting;

		List<IResult> resultList = new ArrayList<IResult>();

		if (setting.isRequired() && setting.isValueNull()
				&& simpleSet.getDefaultValue() == null) {

			resultList.add(EResult.VALUE_IS_MISSING);
			return resultList;
		}

		if (!fileExist(settingValue, true, root)) {
			resultList.add(EResult.FILENOTEXIST);
			return resultList;
		}

		if (settingValue != null) {
			File file = new File(settingValue);
			IContentDescription contentDescription = getContentDescription(
					file, root);

			IContentType baseType = null;
			if (contentDescription != null) {
				baseType = contentDescription.getContentType().getBaseType();
			}

			// validate SimpleSetting property
			if (simpleSet.getProperty() != null && simpleSet.getProperty().size() > 0) {
				EList<Property> properties = simpleSet.getProperty();

				resultList.clear();
				for (Property property : properties) {

					IResult result = validateProperty(file, contentDescription,
							baseType, property, root);
					if (!result.equals(EResult.VALID)) {
						resultList.add(result);
					}
				}
				if (!resultList.isEmpty()) {
					return resultList;
				}
			}
		}
		resultList.add(EResult.VALID);
		return resultList;
	}

	// Confml v.1
	private static EResult validateSimpleFolderSetting(Setting setting,
			String settingValue, ResourceModelRoot root) {
		SimpleSetting simpleSet = (SimpleSetting) setting;

		if (setting.isRequired() && setting.isValueNull()
				&& simpleSet.getDefaultValue() == null) {
			return EResult.VALUE_IS_MISSING;
		}

		if (!fileExist(settingValue, false, root)) {
			return EResult.DIRECTORYNOTEXIST;
		}

		return EResult.VALID;
	}

	private static EResult validateDurationSetting(Setting setting,
			String settingValue) {
		SimpleSetting simpleSetting = (SimpleSetting) setting;

		if (setting.isRequired() && setting.isValueNull()
				&& simpleSetting.getDefaultValue() == null) {
			return EResult.VALUE_IS_MISSING;
		}

		if (settingValue == null || EMPTY.equals(settingValue)) {
			return EResult.VALID;
		}
		String settingValueT;
		if (settingValue.length() > 10) {
			if (settingValue.charAt(10) == '-') {
				StringBuilder sb = new StringBuilder(settingValue);
				sb.setCharAt(10, 'T');
				settingValueT = sb.toString();
			} else {
				settingValueT = settingValue;
			}
		} else {
			settingValueT = settingValue;
		}

		EResult result = validateDurationSetting(settingValueT);
		if (result.equals(EResult.INCORRECT_DATE_TIME_FORMAT)) {
			if (settingValueT.length() > 10) {
				String subSequence = settingValueT.substring(0, 10);
				EResult result2 = validateDateTimeSetting(subSequence);
				if (result2.equals(EResult.INCORRECT_DATE_TIME_FORMAT)) {
					return EResult.INCORRECT_DATE_TIME_FORMAT;
				}
				String substring = settingValueT.substring(11);
				EResult result3 = validateDateTimeSetting(substring);
				if (result3.equals(EResult.INCORRECT_DATE_TIME_FORMAT)) {
					String substring2 = settingValueT.substring(10);
					EResult result4 = validateDateTimeSetting(substring2);
					if (result4.equals(EResult.INCORRECT_DATE_TIME_FORMAT)) {
						return EResult.INCORRECT_DATE_TIME_FORMAT;
					}
				}
			} else {
				return EResult.INCORRECT_DATE_TIME_FORMAT;
			}
		}
		try {
			XMLDuration duration = new XMLDuration(settingValueT);
			if ((simpleSetting.getMaxExclusive() != null)
					&& ((duration.compare((XMLDuration) simpleSetting
							.getMaxExclusive().getValue()) >= 0))) {
				return EResult.MAX_EXCL_VALUE_EXCEED;
			} else if ((simpleSetting.getMaxInclusive() != null)
					&& ((duration.compare((XMLDuration) simpleSetting
							.getMaxInclusive().getValue()) >= 0))) {
				if (duration.compare((XMLDuration) simpleSetting
						.getMaxInclusive().getValue()) == 0) {
					Number seconds = duration
							.getField(DatatypeConstants.SECONDS);
					if (seconds.doubleValue() <= ((XMLDuration) simpleSetting
							.getMaxInclusive().getValue()).getField(
							DatatypeConstants.SECONDS).doubleValue()) {
						return EResult.VALID;
					} else {
						return EResult.MAX_INCL_VALUE_EXCEED;
					}
				} else {
					return EResult.MAX_INCL_VALUE_EXCEED;
				}
			} else if ((simpleSetting.getMinExclusive() != null)
					&& ((duration.compare((XMLDuration) simpleSetting
							.getMinExclusive().getValue()) <= 0))) {
				if (duration.compare((XMLDuration) simpleSetting
						.getMinExclusive().getValue()) == 0) {
					Number seconds = duration
							.getField(DatatypeConstants.SECONDS);
					if (seconds.doubleValue() > ((XMLDuration) simpleSetting
							.getMinExclusive().getValue()).getField(
							DatatypeConstants.SECONDS).doubleValue()) {
						return EResult.VALID;
					} else {
						return EResult.MIN_EXCL_VALUE_UNDERRUN;
					}
				} else {
					return EResult.MIN_EXCL_VALUE_UNDERRUN;
				}
			} else if ((simpleSetting.getMinInclusive() != null)
					&& ((duration.compare((XMLDuration) simpleSetting
							.getMinInclusive().getValue()) < 0))) {
				return EResult.MIN_INCL_VALUE_UNDERRUN;
			} else if ((simpleSetting.getPattern() != "")
					&& !settingValueT.matches(simpleSetting.getPattern())) {
				return EResult.PATTERN_NOT_MATCHED;
			} else {
				return EResult.VALID;
			}
		} catch (IllegalArgumentException e) {
			return EResult.INCORRECT_DATE_TIME_FORMAT;
		} catch (UnsupportedOperationException e) {
			return EResult.TOO_BIG_VALUE;
		}
	}

	private static EResult validateDurationSetting(String settingValue) {
		try {
			XMLTypeFactory.eINSTANCE.createFromString(
					XMLTypePackage.Literals.DURATION, settingValue);
		} catch (IllegalArgumentException e) {
			return EResult.INCORRECT_DURATION_FORMAT;
		}
		return EResult.VALID;
	}

	private static EResult validateTimeSetting(Setting setting,
			String settingValue) {
		SimpleSetting simpleSetting = (SimpleSetting) setting;

		if (setting.isRequired() && setting.isValueNull()
				&& simpleSetting.getDefaultValue() == null) {
			return EResult.VALUE_IS_MISSING;
		}

		if (settingValue == null || EMPTY.equals(settingValue)) {
			return EResult.VALID;
		}
		try {
			XMLTypeFactory.eINSTANCE.createFromString(
					XMLTypePackage.Literals.TIME, settingValue);
			XMLCalendar calend = new XMLCalendar(settingValue, XMLCalendar.TIME);

			if ((simpleSetting.getMaxExclusive() != null)
					&& (calend.compare((XMLCalendar) simpleSetting
							.getMaxExclusive().getValue()) >= 0)) {
				return EResult.MAX_EXCL_VALUE_EXCEED;
			} else if ((simpleSetting.getMaxInclusive() != null)
					&& (calend.compare((XMLCalendar) simpleSetting
							.getMaxInclusive().getValue()) > 0)) {
				if (calend.compare((XMLCalendar) simpleSetting
						.getMaxInclusive().getValue()) == 0) {
					Number seconds = calend.getFractionalSecond();
					Number secondsCal = ((XMLCalendar) simpleSetting
							.getMaxInclusive().getValue())
							.getFractionalSecond();
					if (seconds != null && secondsCal != null) {
						if (seconds.doubleValue() <= secondsCal.doubleValue()) {
							return EResult.VALID;
						} else {
							return EResult.MAX_INCL_VALUE_EXCEED;
						}
					} else {
						return EResult.VALID;
					}
				} else {
					return EResult.MAX_INCL_VALUE_EXCEED;
				}
			} else if ((simpleSetting.getMinExclusive() != null)
					&& (calend.compare((XMLCalendar) simpleSetting
							.getMinExclusive().getValue()) <= 0)) {
				if (calend.compare((XMLCalendar) simpleSetting
						.getMinExclusive().getValue()) == 0) {
					Number seconds = calend.getFractionalSecond();
					Number secondsCal = ((XMLCalendar) simpleSetting
							.getMinExclusive().getValue())
							.getFractionalSecond();
					if (seconds != null && secondsCal != null) {
						if (seconds.doubleValue() > secondsCal.doubleValue()) {
							return EResult.VALID;
						} else {
							return EResult.MIN_EXCL_VALUE_UNDERRUN;
						}
					} else {
						return EResult.MIN_EXCL_VALUE_UNDERRUN;
					}
				} else {
					return EResult.MIN_EXCL_VALUE_UNDERRUN;
				}
			} else if ((simpleSetting.getMinInclusive() != null)
					&& (calend.compare((XMLCalendar) simpleSetting
							.getMinInclusive().getValue()) < 0)) {
				return EResult.MIN_INCL_VALUE_UNDERRUN;
			} else if ((simpleSetting.getPattern() != "")
					&& !settingValue.matches(simpleSetting.getPattern())) {
				return EResult.PATTERN_NOT_MATCHED;
			} else
				return EResult.VALID;
		} catch (IllegalArgumentException e) {
			return EResult.INCORRECT_TIME_FORMAT;
		}
		// return Result.VALID;
	}

	private static EResult validateDateSetting(Setting setting,
			String settingValue) {
		SimpleSetting simpleSetting = (SimpleSetting) setting;

		if (setting.isRequired() && setting.isValueNull()
				&& simpleSetting.getDefaultValue() == null) {
			return EResult.VALUE_IS_MISSING;
		}

		if (settingValue == null || EMPTY.equals(settingValue)) {
			return EResult.VALID;
		}
		try {
			XMLTypeFactory.eINSTANCE.createFromString(
					XMLTypePackage.Literals.DATE, settingValue);

			XMLCalendar calend = new XMLCalendar(settingValue, XMLCalendar.DATE);

			if ((simpleSetting.getMaxExclusive() != null)
					&& (calend.compare((XMLCalendar) simpleSetting
							.getMaxExclusive().getValue()) >= 0)) {
				return EResult.MAX_EXCL_VALUE_EXCEED;
			} else if ((simpleSetting.getMaxInclusive() != null)
					&& (calend.compare((XMLCalendar) simpleSetting
							.getMaxInclusive().getValue()) > 0)) {
				return EResult.MAX_INCL_VALUE_EXCEED;
			} else if ((simpleSetting.getMinExclusive() != null)
					&& (calend.compare((XMLCalendar) simpleSetting
							.getMinExclusive().getValue()) <= 0)) {
				return EResult.MIN_EXCL_VALUE_UNDERRUN;
			} else if ((simpleSetting.getMinInclusive() != null)
					&& (calend.compare((XMLCalendar) simpleSetting
							.getMinInclusive().getValue()) < 0)) {
				return EResult.MIN_INCL_VALUE_UNDERRUN;
			} else if ((simpleSetting.getPattern() != "")
					&& !settingValue.matches(simpleSetting.getPattern())) {
				return EResult.PATTERN_NOT_MATCHED;
			} else
				return EResult.VALID;
		} catch (IllegalArgumentException e) {
			return EResult.INCORRECT_DATE_FORMAT;
		}
		// return Result.VALID;
	}

	private static EResult validateDateTimeSetting(Setting setting,
			String settingValue) {
		SimpleSetting simpleSetting = (SimpleSetting) setting;

		if (setting.isRequired() && setting.isValueNull()
				&& simpleSetting.getDefaultValue() == null) {
			return EResult.VALUE_IS_MISSING;
		}

		if (settingValue == null || EMPTY.equals(settingValue)) {
			return EResult.VALID;
		}
		String settingValueT;
		if (settingValue.length() > 10) {
			if (settingValue.charAt(10) == '-') {
				StringBuilder sb = new StringBuilder(settingValue);
				sb.setCharAt(10, 'T');
				settingValueT = sb.toString();
			} else {
				settingValueT = settingValue;
			}
		} else {
			settingValueT = settingValue;
		}

		EResult result = validateDateTimeSetting(settingValueT);
		if (result.equals(EResult.INCORRECT_DATE_TIME_FORMAT)) {
			if (settingValueT.length() > 10) {
				String subSequence = settingValueT.substring(0, 10);
				EResult result2 = validateDateTimeSetting(subSequence);
				if (result2.equals(EResult.INCORRECT_DATE_TIME_FORMAT)) {
					return EResult.INCORRECT_DATE_TIME_FORMAT;
				}
				String substring = settingValueT.substring(11);
				EResult result3 = validateDateTimeSetting(substring);
				if (result3.equals(EResult.INCORRECT_DATE_TIME_FORMAT)) {
					String substring2 = settingValueT.substring(10);
					EResult result4 = validateDateTimeSetting(substring2);
					if (result4.equals(EResult.INCORRECT_DATE_TIME_FORMAT)) {
						return EResult.INCORRECT_DATE_TIME_FORMAT;
					}
				}
			} else {
				return EResult.INCORRECT_DATE_TIME_FORMAT;
			}
		}
		try {
			XMLCalendar calend = new XMLCalendar(settingValueT,
					XMLCalendar.DATETIME);
			if ((simpleSetting.getMaxExclusive() != null)
					&& (calend.compare((XMLCalendar) simpleSetting
							.getMaxExclusive().getValue()) >= 0)) {
				return EResult.MAX_EXCL_VALUE_EXCEED;
			} else if ((simpleSetting.getMaxInclusive() != null)
					&& (calend.compare((XMLCalendar) simpleSetting
							.getMaxInclusive().getValue()) >= 0)) {
				if (calend.compare((XMLCalendar) simpleSetting
						.getMaxInclusive().getValue()) == 0) {
					Number seconds = calend.getFractionalSecond();
					Number secondsCal = ((XMLCalendar) simpleSetting
							.getMaxInclusive().getValue())
							.getFractionalSecond();
					if (seconds != null && secondsCal != null) {
						if (seconds.doubleValue() <= secondsCal.doubleValue()) {
							return EResult.VALID;
						} else {
							return EResult.MAX_INCL_VALUE_EXCEED;
						}
					} else {
						return EResult.VALID;
					}
				} else {
					return EResult.MAX_INCL_VALUE_EXCEED;
				}
			} else if ((simpleSetting.getMinExclusive() != null)
					&& (calend.compare((XMLCalendar) simpleSetting
							.getMinExclusive().getValue()) <= 0)) {
				if (calend.compare((XMLCalendar) simpleSetting
						.getMinExclusive().getValue()) == 0) {
					Number seconds = calend.getFractionalSecond();
					Number secondsCal = ((XMLCalendar) simpleSetting
							.getMinExclusive().getValue())
							.getFractionalSecond();
					if (seconds != null && secondsCal != null) {
						if (seconds.doubleValue() > secondsCal.doubleValue()) {
							return EResult.VALID;
						} else {
							return EResult.MIN_EXCL_VALUE_UNDERRUN;
						}
					} else {
						return EResult.MIN_EXCL_VALUE_UNDERRUN;
					}
				} else {
					return EResult.MIN_EXCL_VALUE_UNDERRUN;
				}
			} else if ((simpleSetting.getMinInclusive() != null)
					&& (calend.compare((XMLCalendar) simpleSetting
							.getMinInclusive().getValue()) < 0)) {
				return EResult.MIN_INCL_VALUE_UNDERRUN;
			} else if ((simpleSetting.getPattern() != "")
					&& !settingValueT.matches(simpleSetting.getPattern())) {
				return EResult.PATTERN_NOT_MATCHED;
			} else
				return EResult.VALID;
		} catch (IllegalArgumentException e) {
			return EResult.INCORRECT_DATE_TIME_FORMAT;
		}

		// return Result.VALID;
	}

	private static EResult validateDateTimeSetting(String value) {
		if (value == null || value.equals("")) {
			return EResult.VALID;
		}
		try {
			XMLTypeFactory.eINSTANCE.createFromString(
					XMLTypePackage.Literals.DATE_TIME, value);
		} catch (IllegalArgumentException e) {
			return EResult.INCORRECT_DATE_TIME_FORMAT;
		}
		return EResult.VALID;
	}

	/***************************************************************************
	 * validateIntSetting
	 **************************************************************************/

	private static EResult validateIntSetting(Setting setting,
			String settingValue) {
		SimpleSetting simpleSetting = (SimpleSetting) setting;

		if (setting.isRequired() && setting.isValueNull()
				&& simpleSetting.getDefaultValue() == null) {
			return EResult.VALUE_IS_MISSING;
		}

		if (settingValue == null || EMPTY.equals(settingValue)) {
			return EResult.VALID;
		}

		try {
			if (settingValue.indexOf('.') >= 0)
				return EResult.INCORRECT_NUMBER_FORMAT;

			BigDecimal number = new BigDecimal(settingValue);

			int number_lenght = settingValue.startsWith("-") ? settingValue
					.length() - 1 : settingValue.length();

			if ((simpleSetting.getTotalDigits() != null)
					&& simpleSetting.getTotalDigits().intValue() != -1
					&& number_lenght > simpleSetting.getTotalDigits()
							.intValue()) {
				return EResult.TOTAL_DIGITS_EXCEED;
			} else if ((simpleSetting.getMaxExclusive() != null)
					&& (number.compareTo(/* >= */(BigDecimal) simpleSetting
							.getMaxExclusive().getValue()) >= 0)) {
				return EResult.MAX_EXCL_VALUE_EXCEED;
			} else if ((simpleSetting.getMaxInclusive() != null)
					&& (number.compareTo((BigDecimal) simpleSetting
							.getMaxInclusive().getValue())) > 0) {
				return EResult.MAX_INCL_VALUE_EXCEED;
			} else if ((simpleSetting.getMinExclusive() != null && (number
					.compareTo((BigDecimal) simpleSetting.getMinExclusive()
							.getValue())) <= 0)) {
				return EResult.MIN_EXCL_VALUE_UNDERRUN;
			} else if ((simpleSetting.getMinInclusive() != null)
					&& (number.compareTo((BigDecimal) simpleSetting
							.getMinInclusive().getValue())) < 0) {
				return EResult.MIN_INCL_VALUE_UNDERRUN;
			} else if ((simpleSetting.getPattern() != "")
					&& !settingValue.matches(simpleSetting.getPattern())) {
				return EResult.PATTERN_NOT_MATCHED;
			} else
				return EResult.VALID;

		} catch (NumberFormatException exc) {
			if (settingValue.matches("\\d*|-\\d+"))
				return EResult.NUMBER_OUT_OF_RANGE;
			else if (settingValue.equals("-")) {
				return EResult.MINUS_ONLY;
			}
			try {
				Double.parseDouble(settingValue);

				return EResult.VALID;
			} catch (NumberFormatException e) {

			}

		}

		return EResult.INCORRECT_NUMBER_FORMAT;
	}

	/***************************************************************************
	 * validateStringSetting
	 **************************************************************************/

	private static EResult validateStringSetting(Setting setting,
			String settingValue) {
		SimpleSetting simpleSetting = (SimpleSetting) setting;

		if (setting.isRequired() && setting.isValueNull()
				&& simpleSetting.getDefaultValue() == null) {
			return EResult.VALUE_IS_MISSING;
		}

		BigInteger maxLength = getMaxTextLength(setting);
		if (settingValue == null) {
			return EResult.VALID;
		}

		if (maxLength != null && settingValue.length() > maxLength.intValue()
				&& maxLength.intValue() != -1)
			return EResult.MAX_LENGTH_EXCEED;

		if (simpleSetting.getLength() != null) {
			if (settingValue.length() != simpleSetting.getLength().intValue()
					&& simpleSetting.getLength().intValue() != -1)
				return EResult.EXACT_LENGTH_NOT_MATCHED;
		}

		if (simpleSetting.getMinLength() != null) {
			if (settingValue.length() < simpleSetting.getMinLength().intValue())
				return EResult.MIN_LENGTH_UNDERRUN;
		}

		if (simpleSetting.getPattern() != "")
			if (!settingValue.matches(simpleSetting.getPattern()))
				return EResult.PATTERN_NOT_MATCHED;

		return EResult.VALID;
	}

	private static BigInteger getMaxTextLength(Setting setting) {
		SimpleSetting simpleSetting = (SimpleSetting) setting;
		return simpleSetting.getMaxLength();
	}

	/***************************************************************************
	 * validateFileSetting
	 **************************************************************************/
	// confml v.2
	private static List<IResult> validateFileSetting(Setting setting,
			String settingValue, ResourceModelRoot root) {

		List<IResult> resultList = new ArrayList<IResult>();

		if (setting instanceof FilePath) {
			FilePath filePath = (FilePath) setting;

			if (setting.isRequired() && setting.isValueNull()
					&& filePath != null && filePath.getDefaultPath() == null) {
				resultList.add(EResult.VALUE_IS_MISSING);
				return resultList;
			}

			if (filePath.getPattern() != "")
				if (!filePath.getPath().matches(filePath.getPattern())) {
					resultList.add(EResult.PATTERN_NOT_MATCHED);
					return resultList;
				}

			if (filePath.equals(filePath.getParent().getSourceFilePath())) {
				boolean isFile = filePath.isFile();

				boolean exist = fileExist(settingValue, isFile, root);

				if (!exist) {
					if (isFile) {
						resultList.add(EResult.FILENOTEXIST);
						return resultList;
					} else {
						resultList.add(EResult.DIRECTORYNOTEXIST);
						return resultList;
					}
				}

				// validate filePath property
				if (settingValue != null && setting.getProperty() != null && setting.getProperty().size() > 0) {
					EList<Property> properties = filePath.getProperty();
					File file = new File(settingValue);
					IContentDescription contentDescription = getContentDescription(
							file, root);

					IContentType baseType = null;
					if (contentDescription != null) {
						baseType = contentDescription.getContentType()
								.getBaseType();
					}
					resultList.clear();
					for (Property property : properties) {

						IResult result = validateProperty(file,
								contentDescription, baseType, property, root);
						if (!result.equals(EResult.VALID)) {
							resultList.add(result);
						}
					}
					if (!resultList.isEmpty()) {
						return resultList;
					}
				}
			}
			resultList.add(EResult.VALID);
			return resultList;
		}
		return resultList;
	}

	/**
	 * @param file
	 * @param contentDescription
	 * @param baseType
	 * @param property
	 * @param root
	 * @param propertyName
	 * @param value
	 */
	private static IResult validateProperty(File file,
			IContentDescription contentDescription, IContentType baseType,
			Property property, ResourceModelRoot root) {

		String propertyName = property.getName();
		String value = property.getValue();
		FileSystemElement fileSystemElement = ResourceUtil
				.getFileSystemElement(root, file.getPath());

		if (propertyName == null) {
			return EResult.VALID;
		}

		if (propertyName.compareTo(FileProperty.TYPE_PROPERTY) == 0) { // validate
			// type
			String fileName = file.getName();
			String fileExtension = FileUtils.getExtension(fileName);
			if (!isValidExtension(fileExtension, property))
				return EResult.INCORRECT_FILE_EXTENSION;

		} else if (propertyName.equals(FileProperty.MAX_BITS_PROPERTY)) {// validate
			// maximum number of units per pixel

			if (isBaseTypeValid(baseType, MediaUIPlugin.CT_IMAGE)) {
				String depth = contentDescription.getProperty(
						MediaUIPlugin.COLOR_DEPTH).toString();

				if (Integer.valueOf(depth) > Integer.valueOf(value)) {
					return EResult.MAX_BITS_EXCEED;
				}
			} else {
				return notApplicable(FileProperty.MAX_BITS_PROPERTY);
			}
		} else if (propertyName.equals(FileProperty.MAX_WIDTH_PROPERTY)) { // validate
			// maximum width of graphic in units

			if (isBaseTypeValid(baseType, MediaUIPlugin.CT_IMAGE)) {
				String width = contentDescription.getProperty(
						MediaUIPlugin.VIDEO_WIDTH).toString();

				if (Integer.valueOf(width) > Integer.valueOf(value)) {
					return EResult.MAX_WIDTH_EXCEED;
				}
			} else {
				return notApplicable(FileProperty.MAX_WIDTH_PROPERTY);
			}
		} else if (propertyName.equals(FileProperty.MAX_HEIGHT_PROPERTY)) { // validate
			// maximum height of graphic in units

			if (isBaseTypeValid(baseType, MediaUIPlugin.CT_IMAGE)) {
				String height = contentDescription.getProperty(
						MediaUIPlugin.VIDEO_HEIGHT).toString();

				if (Integer.valueOf(height) > Integer.valueOf(value)) {
					return EResult.MAX_HEIGHT_EXCEED;
				}
			} else {
				return notApplicable(FileProperty.MAX_HEIGHT_PROPERTY);
			}
		} else if (propertyName.equals(FileProperty.MIN_WIDTH_PROPERTY)) { // validate
			// minimum width of graphic in units

			if (isBaseTypeValid(baseType, MediaUIPlugin.CT_IMAGE)) {
				String width = contentDescription.getProperty(
						MediaUIPlugin.VIDEO_WIDTH).toString();

				if (Integer.valueOf(width) < Integer.valueOf(value)) {
					return EResult.MIN_WIDTH_NOT_REACHED;
				}
			} else {
				return notApplicable(FileProperty.MIN_WIDTH_PROPERTY);
			}
		} else if (propertyName.equals(FileProperty.MIN_HEIGHT_PROPERTY)) { // validate
			// minimum height of graphic in units

			if (isBaseTypeValid(baseType, MediaUIPlugin.CT_IMAGE)) {

				String height = contentDescription.getProperty(
						MediaUIPlugin.VIDEO_HEIGHT).toString();

				if (Integer.valueOf(height) < Integer.valueOf(value)) {
					return EResult.MIN_HEIGHT_NOT_REACHED;
				}
			} else {
				return notApplicable(FileProperty.MIN_HEIGHT_PROPERTY);
			}
		} else if (propertyName.equals(FileProperty.WIDTH_PROPERTY)) { // validate
			// width

			if (isBaseTypeValid(baseType, MediaUIPlugin.CT_IMAGE)) {
				String width = contentDescription.getProperty(
						MediaUIPlugin.VIDEO_WIDTH).toString();

				if (!Integer.valueOf(width).equals(Integer.valueOf(value))) {
					return EResult.WIDTH_NOT_MATCHED;
				}
			} else {
				return notApplicable(FileProperty.WIDTH_PROPERTY);
			}
		} else if (propertyName.equals(FileProperty.HEIGHT_PROPERTY)) { // validate
			// height

			if (isBaseTypeValid(baseType, MediaUIPlugin.CT_IMAGE)) {

				String height = contentDescription.getProperty(
						MediaUIPlugin.VIDEO_HEIGHT).toString();

				if (!Integer.valueOf(height).equals(Integer.valueOf(value))) {
					return EResult.HEIGHT_NOT_MATCHED;
				}
			} else {
				return notApplicable(FileProperty.HEIGHT_PROPERTY);
			}
		} else if (propertyName.equals(FileProperty.MAX_COLOR_PROPERTY)) { // validate
			// maximum number of distinct color values
			if (baseType != null) {
				if (isBaseTypeValid(baseType, MediaUIPlugin.CT_IMAGE)) {
					String depth = contentDescription.getProperty(
							MediaUIPlugin.COLOR_DEPTH).toString();
					double color = Math.pow(2, Integer.valueOf(depth));

					if (Double.valueOf(color) > Integer.valueOf(value)) {
						return EResult.MAX_COLOR_EXCEED;
					}

				} else {
					return notApplicable(FileProperty.MAX_COLOR_PROPERTY);
				}
			}
		}

		if (fileSystemElement instanceof com.nokia.tools.variant.resourcelibrary.model.File) {
			com.nokia.tools.variant.resourcelibrary.model.File fileToValidate = (com.nokia.tools.variant.resourcelibrary.model.File)

			fileSystemElement;

			if (propertyName.compareTo(FileProperty.MAX_FILE_SIZE_PROPERTY) == 0) {

				if (DEFAULT_SIZE_UNIT.equals(property.getUnit())) {
					if (getSize(fileToValidate, DEFAULT_SIZE_UNIT) > new Long(
							property.getValue())) {
						return EResult.MAX_SIZE_EXCEED;
					}
				} else if (property.getUnit().equals("MB")) {
					if (getSize(fileToValidate, "MB") > new Long(property
							.getValue())) {
						return EResult.MAX_SIZE_EXCEED;
					}
				}
			} else if (propertyName
					.compareTo(FileProperty.RECOMMENDED_FILE_SIZE_PROPERTY) == 0) {
				if (DEFAULT_SIZE_UNIT.equals(property.getUnit())) {
					if (getSize(fileToValidate, DEFAULT_SIZE_UNIT) > new Long(
							property.getValue())) {
						return EResult.RECOMMENDED_SIZE_EXCEED;
					}
				} else if (property.getUnit().equals("MB")) {
					if (getSize(fileToValidate, "MB") > new Long(property
							.getValue())) {
						return EResult.RECOMMENDED_SIZE_EXCEED;
					}
				}
			}
		}
		return EResult.VALID;
	}

	private static IResult notApplicable(String property) {
		Result result = new Result();
		result.constructMessage(Result.CONSTRAINT, property,
				Result.NOT_APPLICABLE);
		return result;
	}

	private static float getSize(
			com.nokia.tools.variant.resourcelibrary.model.File fileToValidate,
			String unit) {

		if (unit.equals(DEFAULT_SIZE_UNIT)) {
			return fileToValidate.getSize() / (float) 1024;
		} else if (unit.equals("MB")) {
			return fileToValidate.getSize() / (float) 1024 * 1024;
		}
		return fileToValidate.getSize();
	}

	private static IContentDescription getContentDescription(File file,
			ResourceModelRoot root) {

		FileSystemElement fileSystemElement = ResourceUtil
				.getFileSystemElement(root, file.getPath());

		if (fileSystemElement instanceof com.nokia.tools.variant.resourcelibrary.model.File) {
			com.nokia.tools.variant.resourcelibrary.model.File file2 = (com.nokia.tools.variant.resourcelibrary.model.File)

			fileSystemElement;

			return file2.getContentDescription();
		}
		return null;
	}

	private static boolean isBaseTypeValid(IContentType baseType,
			IContentType iContentType) {

		if (baseType != null) {
			if (MediaUIPlugin.CT_IMAGE.equals(baseType)) {
				return true;
			}
		}
		return false;
	}

	private static boolean fileExist(String sourcePath, boolean file,
			ResourceModelRoot root) {
		if (sourcePath != "" && sourcePath != null) {
			return fileExist(sourcePath, root, file);
		} else {
			return true;
		}
	}

	private static boolean fileExist(String sourcePath,
			ResourceModelRoot aResorceModelRoot, boolean file) {
		FileSystemElement element = ResourceUtil.getFileSystemElement(
				aResorceModelRoot, sourcePath);
		if (element != null) {
			if (file)
				return true;
			else if (element instanceof Directory)
				return true;
		}
		return false;
	}

	private static boolean isValidExtension(String fileExtension,
			Property property) {
		if (fileExtension == null) {
			return false;
		}

		List<String> supportedFileTypes = supportedFileTypes(property
				.getValue());
		if (supportedFileTypes.contains(fileExtension.toLowerCase()))
			return true;
		return false;
	}

	private static List<String> supportedFileTypes(
			String spaceSeparatedFileTypes) {
		List<String> extensions = new ArrayList<String>();
		String[] fileTypes = spaceSeparatedFileTypes.split(" ");
		for (String fileType : fileTypes) {
			if (fileType.contains(FILE_TYPE_SEPARATOR)) {
				extensions.add(extractFileType(fileType).toLowerCase());
			}
		}
		return extensions;
	}

	/*
	 * private boolean valid(Property fileTypeProperty) { return
	 * fileTypeProperty.getName().equals(TYPE); }
	 */

	private static String extractFileType(String fileType) {
		return fileType.substring(indexOfFileType(fileType));
	}

	private static int indexOfFileType(String fileType) {
		return fileType.indexOf(FILE_TYPE_SEPARATOR) + 1;
	}

	/***************************************************************************
	 * validateRealSetting
	 **************************************************************************/

	private static EResult validateRealSetting(Setting setting,
			String settingValue) {
		SimpleSetting simpleSetting = (SimpleSetting) setting;

		if (setting.isRequired() && setting.isValueNull()
				&& simpleSetting.getDefaultValue() == null) {
			return EResult.VALUE_IS_MISSING;
		}

		if (settingValue == null) {
			return EResult.VALID;
		}

		try {

			// 16 digits + '.' + '-'
			if (settingValue.length() > 18) {
				return EResult.INCORRECT_NUMBER_FORMAT;
			}
			if (settingValue.length() == 18) {
				if (settingValue.indexOf('.') == -1
						|| settingValue.indexOf('-') == -1)
					return EResult.INCORRECT_NUMBER_FORMAT;
			}

			if (EMPTY.equals(settingValue))
				return EResult.VALID;

			BigDecimal number = new BigDecimal(settingValue);

			if ((simpleSetting.getMaxExclusive() != null)
					&& (number.compareTo((BigDecimal) simpleSetting
							.getMaxExclusive().getValue()) >= 0)) {
				return EResult.MAX_EXCL_VALUE_EXCEED;
			} else if ((simpleSetting.getMaxInclusive() != null)
					&& (number.compareTo((BigDecimal) simpleSetting
							.getMaxInclusive().getValue()) > 0)) {
				return EResult.MAX_INCL_VALUE_EXCEED;
			} else if ((simpleSetting.getMinExclusive() != null)
					&& (number.compareTo((BigDecimal) simpleSetting
							.getMinExclusive().getValue()) <= 0)) {
				return EResult.MIN_EXCL_VALUE_UNDERRUN;
			} else if ((simpleSetting.getMinInclusive() != null)
					&& (number.compareTo((BigDecimal) simpleSetting
							.getMinInclusive().getValue()) < 0)) {
				return EResult.MIN_INCL_VALUE_UNDERRUN;
			} else if ((simpleSetting.getPattern() != "")
					&& !settingValue.matches(simpleSetting.getPattern())) {
				return EResult.PATTERN_NOT_MATCHED;
			} else
				return EResult.VALID;

		} catch (NumberFormatException exc) {
			if (settingValue.matches("([0-9]+\\.([0-9]+)|\\.[0-9]+)"))
				return EResult.NUMBER_OUT_OF_RANGE;
			else if (settingValue.equals("-")) {
				return EResult.MINUS_ONLY;
			}
			try {
				Double.parseDouble(settingValue);
				return EResult.VALID;
			} catch (NumberFormatException e) {

			}
		}

		return EResult.INCORRECT_NUMBER_FORMAT;

	}

	/***************************************************************************
	 * validateBooleanSetting
	 **************************************************************************/

	private static EResult validateBooleanSetting(Setting setting,
			String settingValue) {
		SimpleSetting simpleSetting = (SimpleSetting) setting;
		String testBoolean;

		if (settingValue == null
				|| (setting.isRequired() && setting.isValueNull() && simpleSetting
						.getDefaultValue() == null)) {
			return EResult.VALUE_IS_MISSING;
		}

		if (settingValue == null || settingValue != null
				&& settingValue.equals("")) {
			return EResult.VALID;
		}
		testBoolean = settingValue.toLowerCase();
		if (testBoolean.compareToIgnoreCase(FALSE_CONSTANT) != 0
				&& testBoolean.compareToIgnoreCase(TRUE_CONSTANT) != 0) {
			return EResult.INCORRECT_BOOLEAN_FORMAT;
		}

		if (simpleSetting.getPattern() != "") {
			StringTokenizer acceptedValues = new StringTokenizer(simpleSetting
					.getPattern(), "|");
			while (acceptedValues.hasMoreTokens()) {
				if (testBoolean.compareToIgnoreCase(acceptedValues.nextToken()) == 0)
					return EResult.VALID;
			}
			return EResult.PATTERN_NOT_MATCHED;
		}

		return EResult.VALID;
	}

	/***************************************************************************
	 * validateSequenceSetting
	 **************************************************************************/
	private static EResult validateSequenceSetting(Setting setting) {
		// List<Ref> data =
		// SequenceConfMlModelUtils.getSequenceOfValues(setting);

		SequenceSetting sequence = (SequenceSetting) setting;

		int size = sequence.getSequenceItem().size();

		if (sequence.isRequired() && size < 1) {
			return EResult.VALUE_IS_MISSING;
		}

		int minOccurs = sequence.getMinOccurs();
		int maxOccurs = sequence.getMaxOccurs();

		if (minOccurs != 0 && size < minOccurs)
			return EResult.MIN_SEQUENCES_UNDERRUN;

		if (maxOccurs != 0 && size > maxOccurs)
			return EResult.MAX_SEQUENCES_EXCEED;

		return EResult.VALID;

	}

}
