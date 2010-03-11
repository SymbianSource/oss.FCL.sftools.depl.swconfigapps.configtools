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

package com.nokia.tools.s60ct.confml.editor.validation;

import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import javax.xml.datatype.DatatypeConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.eclipse.core.internal.expressions.Property;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.content.IContentDescription;
import org.eclipse.core.runtime.content.IContentType;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.eclipse.emf.ecore.xml.type.internal.XMLCalendar;
import org.eclipse.emf.ecore.xml.type.internal.XMLDuration;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.nokia.tools.s60ct.model.confml.EResourceSetting;
import com.nokia.tools.s60ct.model.confml.ESequenceSetting;
import com.nokia.tools.s60ct.model.confml.ESetting;
import com.nokia.tools.s60ct.model.confml.ESettingValueType;
import com.nokia.tools.s60ct.model.confml.ESimpleSetting;
import com.nokia.tools.s60ct.model.confml.ESimpleValue;
import com.nokia.tools.s60ct.model.confml.View;
import com.nokia.tools.s60ct.resources.model.ELibraryDirectory;
import com.nokia.tools.s60ct.resources.model.ELibraryElement;
import com.nokia.tools.s60ct.resources.model.ELibraryFile;
import com.nokia.tools.s60ct.resources.model.ELibraryRoot;
import com.nokia.tools.s60ct.resources.resources.ResourceUtil;
import com.nokia.tools.vct.common.core.utils.FileUtils;


public class SettingsValidator {

	private static final String FALSE_CONSTANT = "false";
	private static final String TRUE_CONSTANT = "true";

	private static final String DEFAULT_SIZE_UNIT = "kB";
	private static final String FILE_TYPE_SEPARATOR = "/";
	private static final String EMPTY = "";

//	public static ValidationResult validateSetting(ESetting setting,
//			String settingValue, ELibraryRoot root) {
//		if (setting instanceof ESimpleSetting) {
//
//			String choosenOption = ((ESimpleSetting) setting).getChosenOption();
//			if (choosenOption != null) {
//				settingValue = choosenOption;
//			}
//		} 
////		else if (setting instanceof EResourceSetting) {
////
////			String chosenOption = ((EResourceSetting) setting).getChosenOption();
////			if (chosenOption != null) {
////				settingValue = chosenOption;
////			}
////		}
//		return validateOptionForSetting(setting, settingValue, root);
//	}

	public static ValidationResult validateOptionForSetting(ESetting setting,
			String settingValue, ELibraryRoot root) {

		ValidationResult validateConstraint = validateConstraint(setting);
		if (!validateConstraint.getResult().contains(EResult.VALID)) {
			return validateConstraint;
		}
		
//		ValidationResult validate = validate(setting, settingValue, root);
//		if (!validate.getResult().contains(EResult.VALID)) {
//			return validate;
//		}

		//return validate;
		return validateRelevantDependencies(setting);
	}

//	private static ValidationResult validate(ESetting setting,
//			String settingValue, ELibraryRoot root) {
//		if (setting instanceof ESequenceSetting) {
//			try 
//			{
//				return new ValidationResult(validateSequenceSetting(setting));
//			} catch (RuntimeException e) {
//				e.printStackTrace();
//			}
//		}
//
//		if (settingValue == null && !setting.isValueNull()) {
//			return new ValidationResult(EResult.VALID);
//		}
//
//		if (setting instanceof EResourceSetting) {
//			List<IResult> validateFileSetting = validateFileSetting(setting,
//					settingValue, root);
//			if (!validateFileSetting.contains(EResult.VALID)) {
//				return new ValidationResult(validateFileSetting);
//			}
//			// else if (settingValue != null) {
//			// if (settingValue.endsWith(".tpf")) {
//			// FileSystemElement child = root.findChild(new Path(
//			// settingValue));
//			// if (child instanceof ThemeFile) {
//			// ThemeFile themeFile = (ThemeFile) child;
//			// String validationMessage = themeFile
//			// .getValidationMessage();
//			// if (validationMessage != null
//			// && !validationMessage.equals("")) {
//			//
//			// return new ValidationResult(
//			// EResult.THEME_VERSION_NOT_MATCH,
//			// validationMessage);
//			// }
//			// }
//			//
//			// }
//			// }
//			return new ValidationResult(validateFileSetting);
//		}
//		ESimpleSetting simpleSetting = (ESimpleSetting) setting;
//
//		if (simpleSetting.getType() == ESettingValueType.BOOLEAN)
//			return new ValidationResult(validateBooleanSetting(setting,
//					settingValue));
//		if (simpleSetting.getType() == ESettingValueType.INTEGER)
//			return new ValidationResult(validateIntSetting(setting,
//					settingValue));
//		if (simpleSetting.getType() == ESettingValueType.STRING)
//			return new ValidationResult(validateStringSetting(setting,
//					settingValue));
//		if (simpleSetting.getType() == ESettingValueType.DECIMAL)
//			return new ValidationResult(validateRealSetting(setting,
//					settingValue));
//		if (simpleSetting.getType() == ESettingValueType.FILE) {
//			List<IResult> validateFileSetting = validateSimpleFileSetting(
//					setting, settingValue, root);
//			if (!validateFileSetting.contains(EResult.VALID)) {
//				return new ValidationResult(validateFileSetting);
//			}
//			// else if (settingValue != null) {
//			// if (settingValue.endsWith(".tpf")) {
//			// FileSystemElement child = root.findChild(new Path(
//			// settingValue));
//			// if (child instanceof ThemeFile) {
//			// ThemeFile themeFile = (ThemeFile) child;
//			// String validationMessage = themeFile
//			// .getValidationMessage();
//			// if (validationMessage != null
//			// && !validationMessage.equals("")) {
//			// return new ValidationResult(
//			// EResult.THEME_VERSION_NOT_MATCH,
//			// validationMessage);
//			// }
//			// }
//			// }
//			// }
//			return new ValidationResult(validateFileSetting);
//		}
//		if (simpleSetting.getType() == ESettingValueType.FOLDER)
//			return new ValidationResult(validateSimpleFolderSetting(setting,
//					settingValue, root));
//		if (simpleSetting.getType() == ESettingValueType.FILE) {
//			List<IResult> validateFileSetting = validateFileSetting(setting,
//					settingValue, root);
//			if (!validateFileSetting.contains(EResult.VALID)) {
//				return new ValidationResult(validateFileSetting);
//			}
//			// else if (settingValue != null) {
//			// if (settingValue.endsWith(".tpf")) {
//			// String realPath = new Path(root.getTempDirPath() + "/"
//			// + settingValue).toOSString();
//			// FileSystemElement child = root.getChild(realPath);
//			// if (child instanceof ThemeFile) {
//			// ThemeFile themeFile = (ThemeFile) child;
//			// String validationMessage = themeFile
//			// .getValidationMessage();
//			// if (validationMessage != null
//			// && !validationMessage.equals("")) {
//			// return new ValidationResult(
//			// new ArrayList<IResult>(), validationMessage);
//			// }
//			// }
//			// }
//			// }
//			return new ValidationResult(validateFileSetting);
//		}
//		if (simpleSetting.getType() == ESettingValueType.DATETIME)
//			return new ValidationResult(validateDateTimeSetting(setting,
//					settingValue));
//		if (simpleSetting.getType() == ESettingValueType.DATE)
//			return new ValidationResult(validateDateSetting(setting,
//					settingValue));
//		if (simpleSetting.getType() == ESettingValueType.TIME)
//			return new ValidationResult(validateTimeSetting(setting,
//					settingValue));
//		if (simpleSetting.getType() == ESettingValueType.DURATION)
//			return new ValidationResult(validateDurationSetting(setting,
//					settingValue));
//		if (simpleSetting.getType() == ESettingValueType.SELECTION)
//			return new ValidationResult(validateSelectionSetting(setting,
//					settingValue));
//		if (simpleSetting.getType() == ESettingValueType.MULTISELECTION)
//			return new ValidationResult(validateMultiSelectionSetting(setting));
//
//		return new ValidationResult(EResult.NON_ALLOWED_SETTING_TYPE);
//	}

	public static ValidationResult validateConstraint(ESetting setting) {

		if (setting == null)
			return new ValidationResult(EResult.NON_EXISTED_SETTING);

		if (setting instanceof EResourceSetting) {
			EResourceSetting rs = (EResourceSetting) setting;
		
			if (rs.getConstraint() != null
					&& !rs.getConstraint().equals("")
					&& !rs.isComputedConstraint()) {
				ESetting sourceEResourceSetting = rs.getLocalPath();
				ESetting targetEResourceSetting = rs.getTargetPath();
				if (rs == sourceEResourceSetting && rs.isComputedRelevant()) {
					return new ValidationResult(EResult.CONSTRAINT_FAILED,
							", constraint=" + rs.getConstraint());
				} else if (rs == targetEResourceSetting
						&& (!sourceEResourceSetting.isComputedRelevant() || sourceEResourceSetting
								.isReadOnly()) && rs.isComputedRelevant()) {
					return new ValidationResult(EResult.CONSTRAINT_FAILED,
							", constraint=" + rs.getConstraint());
				}
			}
		}
		if (setting.getConstraint() != null
				&& !setting.getConstraint().equals("")
				&& !setting.isComputedConstraint()) {
			return new ValidationResult(EResult.CONSTRAINT_FAILED,
					", constraint=" + setting.getConstraint());
		}
		return new ValidationResult(EResult.VALID);
	}

	public static ValidationResult validateRelevantDependencies(ESetting setting) {

		if (setting == null)
			return new ValidationResult(EResult.NON_EXISTED_SETTING);
		if (setting instanceof ESimpleSetting) {
			ESimpleSetting simpleSetting = (ESimpleSetting) setting;
			ESimpleValue sVal = (ESimpleValue)simpleSetting.getValue();
			if (sVal==null)
			{
				return new ValidationResult(EResult.VALID);
			}
			String chosenOption = sVal.getChosenOption();
			String value = sVal.getValue();
			if (value==null)
			{
				return new ValidationResult(EResult.VALID);
			}
			if (chosenOption != null && value.contains("[")) {

				value = value.substring(0, value.indexOf("["));
				EObject e = setting;
				while (e != null && !(e instanceof View)) {
					e = e.eContainer();
				}
				if (e instanceof View) 
				{
					View view = (View) e;
					EList<ESetting> sharedSettingInstances = view
							.getSharedSettingInstances();
					for (int i = 0; i < sharedSettingInstances.size(); i++) {
						ESetting sharedSetting = sharedSettingInstances.get(i);
						if (sharedSetting.getAbsRef().equals(value)) {
							if (sharedSetting.isComputedRelevant()) {
								return new ValidationResult(EResult.VALID);
							} else {
								return new ValidationResult(
										EResult.NON_RELEVANT_DEPENDENCIES);
							}
						}
//						if (sharedSetting instanceof ESequenceSetting) {
//							ESequenceSetting sequenceSetting = (ESequenceSetting) sharedSetting;
//							EList<ESequenceItem> sequenceItems = sequenceSetting
//									.getSequenceItem();
//							for (int j = 0; j < sequenceItems.size(); j++) {
//								ESequenceItem sequenceItem = sequenceItems
//										.get(j);
//								EList<Setting> sequenceItemSettings = sequenceItem
//										.getSetting();
//								for (int k = 0; k < sequenceItemSettings.size(); k++) {
//									Setting sequenceItemSetting = sequenceItemSettings
//											.get(k);
//									if (sequenceItemSetting.getAbsRef().equals(
//											value)) {
//										if (sequenceItemSetting
//												.isComputedRelevant()) {
//											return new ValidationResult(
//													EResult.VALID);
//										} else {
//											return new ValidationResult(
//													EResult.NON_RELEVANT_DEPENDENCIES);
//										}
//									}
//								}
//							}
//						}
					}
				}

			}
		}

		return new ValidationResult(EResult.VALID);
	}

//	private static EResult validateMultiSelectionSetting(ESetting setting) {
//		ESimpleSetting simpleSetting = (ESimpleSetting) setting;
//
//		if (setting.isRequired() && setting.isValueNull()
//				&& simpleSetting.getDefaultValue() == null) {
//			return EResult.VALUE_IS_MISSING;
//		}
//
//		return EResult.VALID;
//	}

//	private static EResult validateSelectionSetting(ESetting setting,
//			String settingValue) {
//
//		ESimpleSetting simpleSetting = (ESimpleSetting) setting;
//
//		if (setting.isRequired() && settingValue == null
//				&& simpleSetting.getDefaultValue() == null) {
//			return EResult.VALUE_IS_MISSING;
//		}
//
//		return EResult.VALID;
//	}

	// Confml v.1
//	private static List<IResult> validateSimpleFileSetting(ESetting setting,
//			String settingValue, ELibraryRoot root) {
//		ESimpleSetting simpleSet = (ESimpleSetting) setting;
//
//		List<IResult> resultList = new ArrayList<IResult>();
//
//		if (setting.isRequired() && setting.isValueNull()
//				&& simpleSet.getDefaultValue() == null) {
//
//			resultList.add(EResult.VALUE_IS_MISSING);
//			return resultList;
//		}
//
//		if (!fileExist(settingValue, true, root)) {
//			EResult result = EResult.FILENOTEXIST;
//			result.setFaultDescription(settingValue);
//			resultList.add(result);
//			return resultList;
//		}
//
//		if (settingValue != null) {
//
//			File file = new File(settingValue);
//			EResult patternResult = validatePattern((new Path(settingValue))
//					.lastSegment(), simpleSet);
//			if (!patternResult.equals(EResult.VALID)) {
//				resultList.add(patternResult);
//				return resultList;
//			}
//			IContentDescription contentDescription = getContentDescription(
//					file, root);
//
//			IContentType baseType = null;
//			if (contentDescription != null) {
//				baseType = contentDescription.getContentType().getBaseType();
//			}
//
//			// validate SimpleSetting property
//			EList<Property> properties = simpleSet.getProperty();
//
//			resultList.clear();
//			for (Property property : properties) {
//
//				IResult result = validateProperty(file, contentDescription,
//						baseType, property, root);
//				if (!result.equals(EResult.VALID)) {
//					resultList.add(result);
//				}
//			}
//
//			if (contentDescription != null) {
//				IContentType type = contentDescription.getContentType();
//				if (type != null && type.isKindOf(MediaUIPlugin.CT_IMAGE_SVG)) {
//					IResult result = validateSVG(root, settingValue);
//					if (!result.equals(EResult.VALID)) {
//						resultList.add(result);
//					}
//				}
//			}
//
//			if (!resultList.isEmpty()) {
//				return resultList;
//			}
//
//		}
//		resultList.add(EResult.VALID);
//		return resultList;
//	}

	/**
	 * Validate SVG contents.
	 * 
	 * @param root
	 * @param file
	 * @return
	 */
//	private static IResult validateSVG(ELibraryRoot root, String localPath) {
//
//		File file = new File(root.getTempDirPath(), localPath);
//		if (!file.isFile()) {
//			// it is not a file, so it is OK from this point of view
//			return EResult.VALID;
//		}
//
//		try {
//			DocumentBuilderFactory factory = DocumentBuilderFactory
//					.newInstance();
//			factory.setNamespaceAware(true);
//			factory.setXIncludeAware(false);
//			DocumentBuilder builder = factory.newDocumentBuilder();
//			Document document = builder.parse(file);
//
//			NodeList nodes = document.getElementsByTagNameNS(
//					"http://www.w3.org/2000/svg", "image");
//			for (int i = 0; i < nodes.getLength(); i++) {
//				Element image = (Element) nodes.item(i);
//				String href = image.getAttributeNS(
//						"http://www.w3.org/1999/xlink", "href");
//				if (href.length() == 0) {
//					continue;
//				}
//
//				if (href.startsWith("data:")) {
//					return new Result()
//							.constructMessage("Embedded data is not allowed for SVG images");
//				}
//			}
//		} catch (Exception ex) {
//			// ignore
//		}
//
//		return EResult.VALID;
//	}

	// Confml v.1
//	private static IResult validateSimpleFolderSetting(ESetting setting,
//			String settingValue, ELibraryRoot root) {
//		ESimpleSetting simpleSet = (ESimpleSetting) setting;
//
//		if (setting.isRequired() && setting.isValueNull()
//				&& simpleSet.getDefaultValue() == null) {
//			return EResult.VALUE_IS_MISSING;
//		}
//
//		if (!fileExist(settingValue, false, root)) {
//			EResult result = EResult.DIRECTORYNOTEXIST;
//			result.setFaultDescription(settingValue);
//			return result;
//		}
//		IResult validateFolder = validateFolder(setting, settingValue, root);
//		return validateFolder;
//	}

//	private static EResult validateDurationSetting(ESetting setting,
//			String settingValue) {
//		ESimpleSetting simpleSetting = (ESimpleSetting) setting;
//
//		if (setting.isRequired() && setting.isValueNull()
//				&& simpleSetting.getDefaultValue() == null) {
//			return EResult.VALUE_IS_MISSING;
//		}
//
//		if (settingValue == null || EMPTY.equals(settingValue)) {
//			return EResult.VALID;
//		}
//		String settingValueT;
//		if (settingValue.length() > 10) {
//			if (settingValue.charAt(10) == '-') {
//				StringBuilder sb = new StringBuilder(settingValue);
//				sb.setCharAt(10, 'T');
//				settingValueT = sb.toString();
//			} else {
//				settingValueT = settingValue;
//			}
//		} else {
//			settingValueT = settingValue;
//		}
//
//		EResult result = validateDurationSetting(settingValueT);
//		if (result.equals(EResult.INCORRECT_DATE_TIME_FORMAT)) {
//			if (settingValueT.length() > 10) {
//				String subSequence = settingValueT.substring(0, 10);
//				EResult result2 = validateDateTimeSetting(subSequence);
//				if (result2.equals(EResult.INCORRECT_DATE_TIME_FORMAT)) {
//					EResult resultToRet = EResult.INCORRECT_DATE_TIME_FORMAT;
//					resultToRet.setFaultDescription("Incorrect symbol(s)");
//					return resultToRet;
//				}
//				String substring = settingValueT.substring(11);
//				EResult result3 = validateDateTimeSetting(substring);
//				if (result3.equals(EResult.INCORRECT_DATE_TIME_FORMAT)) {
//					String substring2 = settingValueT.substring(10);
//					EResult result4 = validateDateTimeSetting(substring2);
//					if (result4.equals(EResult.INCORRECT_DATE_TIME_FORMAT)) {
//						EResult resultToRet = EResult.INCORRECT_DATE_TIME_FORMAT;
//						resultToRet.setFaultDescription("Incorrect symbol(s)");
//						return resultToRet;
//					}
//				}
//			} else {
//				EResult resultToRet = EResult.INCORRECT_DATE_TIME_FORMAT;
//				resultToRet.setFaultDescription("Incorrect symbol(s)");
//				return resultToRet;
//			}
//		}
//		try {
//			XMLDuration duration = new XMLDuration(settingValueT);
//			
//			if ((simpleSetting.getMaxExclusive() != null)
//					&& ((duration.compare(new XMLDuration(simpleSetting.getMaxExclusive())) >= 0))) {
//				EResult resultToRet = EResult.MAX_EXCL_VALUE_EXCEED;
//				resultToRet
//						.setFaultDescription(settingValue
//								+ " !< "
//								+ simpleSetting.getMaxExclusive());
//				return resultToRet;
//			} else if ((simpleSetting.getMaxInclusive() != null)
//					&& ((duration.compare(new XMLDuration(simpleSetting.getMaxInclusive())) >= 0))) {
//				if (duration.compare(new XMLDuration(simpleSetting.getMaxInclusive())) == 0) {
//					Number seconds = duration
//							.getField(DatatypeConstants.SECONDS);
//					if (seconds.doubleValue() <= (new XMLDuration(simpleSetting.getMaxInclusive())).getField(
//							DatatypeConstants.SECONDS).doubleValue()) {
//						return EResult.VALID;
//					} else {
//						EResult resultToRet = EResult.MAX_INCL_VALUE_EXCEED;
//						resultToRet.setFaultDescription(settingValue
//								+ " > "
//								+ simpleSetting.getMaxInclusive());
//						return resultToRet;
//					}
//				} else {
//					EResult resultToRet = EResult.MAX_INCL_VALUE_EXCEED;
//					resultToRet.setFaultDescription(settingValue
//							+ " > "
//							+ simpleSetting.getMaxInclusive());
//					return resultToRet;
//				}
//			} else if ((simpleSetting.getMinExclusive() != null)
//					&& ((duration.compare(new XMLDuration(simpleSetting.getMinExclusive())) <= 0))) {
//				if (duration.compare(new XMLDuration(simpleSetting.getMinExclusive())) == 0) {
//					Number seconds = duration
//							.getField(DatatypeConstants.SECONDS);
//					if (seconds.doubleValue() > (new XMLDuration(simpleSetting.getMinExclusive())).getField(
//							DatatypeConstants.SECONDS).doubleValue()) {
//						return EResult.VALID;
//					} else {
//						EResult resultToRet = EResult.MIN_EXCL_VALUE_UNDERRUN;
//						resultToRet.setFaultDescription(settingValue
//								+ " !> "
//								+ simpleSetting.getMinExclusive());
//						return resultToRet;
//					}
//				} else {
//					EResult resultToRet = EResult.MIN_EXCL_VALUE_UNDERRUN;
//					resultToRet.setFaultDescription(settingValue
//							+ " !> "
//							+ simpleSetting.getMinExclusive());
//					return resultToRet;
//				}
//			} else if ((simpleSetting.getMinInclusive() != null)
//					&& ((duration.compare(new XMLDuration(simpleSetting.getMinInclusive())) < 0))) {
//				EResult resultToRet = EResult.MIN_INCL_VALUE_UNDERRUN;
//				resultToRet
//						.setFaultDescription(settingValue
//								+ " < "
//								+ simpleSetting.getMinInclusive());
//				return resultToRet;
//			}
//			return validatePattern(settingValue, simpleSetting);
//		} catch (IllegalArgumentException e) {
//			EResult resultToRet = EResult.INCORRECT_DATE_TIME_FORMAT;
//			resultToRet.setFaultDescription("Incorrect symbol(s)");
//			return resultToRet;
//		} catch (UnsupportedOperationException e) {
//			EResult resultToRet = EResult.TOO_BIG_VALUE;
//			resultToRet.setFaultDescription(settingValue);
//			return resultToRet;
//		}
//	}

//	private static EResult validateDurationSetting(String settingValue) {
//		try {
//			XMLTypeFactory.eINSTANCE.createFromString(
//					XMLTypePackage.Literals.DURATION, settingValue);
//		} catch (IllegalArgumentException e) {
//			EResult resultToRet = EResult.INCORRECT_DURATION_FORMAT;
//			resultToRet.setFaultDescription("Incorrect symbol(s)");
//			return resultToRet;
//		}
//		return EResult.VALID;
//	}

//	private static EResult validateTimeSetting(ESetting setting,
//			String settingValue) {
//		ESimpleSetting simpleSetting = (ESimpleSetting) setting;
//
//		if (setting.isRequired() && setting.isValueNull()
//				&& simpleSetting.getDefaultValue() == null) {
//			return EResult.VALUE_IS_MISSING;
//		}
//
//		if (settingValue == null || EMPTY.equals(settingValue)) {
//			return EResult.VALID;
//		}
//		try {
//			XMLTypeFactory.eINSTANCE.createFromString(
//					XMLTypePackage.Literals.TIME, settingValue);
//			XMLCalendar calend = new XMLCalendar(settingValue, XMLCalendar.TIME);
//
//			if ((simpleSetting.getMaxExclusive() != null)
//					&& (calend.compare(new XMLCalendar(simpleSetting.getMaxExclusive(),XMLCalendar.TIME)) >= 0)) {
//				EResult result = EResult.MAX_EXCL_VALUE_EXCEED;
//				result
//						.setFaultDescription(settingValue
//								+ " !< "
//								+ simpleSetting.getMaxExclusive());
//				return result;
//			} else if ((simpleSetting.getMaxInclusive() != null)
//					&& (calend.compare(new XMLCalendar(simpleSetting.getMaxInclusive(),XMLCalendar.TIME)) > 0)) {
//				if (calend.compare(new XMLCalendar(simpleSetting.getMaxInclusive(),XMLCalendar.TIME)) == 0) {
//					Number seconds = calend.getFractionalSecond();
//					Number secondsCal = (new XMLCalendar(simpleSetting.getMaxInclusive(),XMLCalendar.TIME))
//							.getFractionalSecond();
//					if (seconds != null && secondsCal != null) {
//						if (seconds.doubleValue() <= secondsCal.doubleValue()) {
//							return EResult.VALID;
//						} else {
//							EResult result = EResult.MAX_INCL_VALUE_EXCEED;
//							result.setFaultDescription(settingValue
//									+ " > "
//									+ simpleSetting.getMaxInclusive());
//							return result;
//						}
//					} else {
//						return EResult.VALID;
//					}
//				} else {
//					EResult result = EResult.MAX_INCL_VALUE_EXCEED;
//					result.setFaultDescription(settingValue
//							+ " > "
//							+ simpleSetting.getMaxInclusive());
//					return result;
//				}
//			} else if ((simpleSetting.getMinExclusive() != null)
//					&& (calend.compare(new XMLCalendar(simpleSetting.getMinExclusive(),XMLCalendar.TIME)) <= 0)) {
//				if (calend.compare(new XMLCalendar(simpleSetting.getMinExclusive(),XMLCalendar.TIME)) == 0) {
//					Number seconds = calend.getFractionalSecond();
//					Number secondsCal = (new XMLCalendar(simpleSetting.getMinExclusive(),XMLCalendar.TIME))
//							.getFractionalSecond();
//					if (seconds != null && secondsCal != null) {
//						if (seconds.doubleValue() > secondsCal.doubleValue()) {
//							return EResult.VALID;
//						} else {
//							EResult result = EResult.MIN_EXCL_VALUE_UNDERRUN;
//							result.setFaultDescription(settingValue
//									+ " !> "
//									+ simpleSetting.getMinExclusive());
//							return result;
//						}
//					} else {
//						EResult result = EResult.MIN_EXCL_VALUE_UNDERRUN;
//						result.setFaultDescription(settingValue
//								+ " !> "
//								+ simpleSetting.getMinExclusive());
//						return result;
//					}
//				} else {
//					EResult result = EResult.MIN_EXCL_VALUE_UNDERRUN;
//					result.setFaultDescription(settingValue
//							+ " !> "
//							+ simpleSetting.getMinExclusive());
//					return result;
//				}
//			} else if ((simpleSetting.getMinInclusive() != null)
//					&& (calend.compare(new XMLCalendar(simpleSetting.getMinInclusive(),XMLCalendar.TIME)) < 0)) {
//				EResult result = EResult.MIN_INCL_VALUE_UNDERRUN;
//				result
//						.setFaultDescription(settingValue
//								+ " < "
//								+ simpleSetting.getMinInclusive());
//				return result;
//			}
//			return validatePattern(settingValue, simpleSetting);
//		} catch (IllegalArgumentException e) {
//			EResult result = EResult.INCORRECT_TIME_FORMAT;
//			result.setFaultDescription("Incorrect symbol(s)");
//			return result;
//		}
//		// return Result.VALID;
//	}

//	private static EResult validateDateSetting(ESetting setting,
//			String settingValue) {
//		ESimpleSetting simpleSetting = (ESimpleSetting) setting;
//
//		if (setting.isRequired() && setting.isValueNull()
//				&& simpleSetting.getDefaultValue() == null) {
//			return EResult.VALUE_IS_MISSING;
//		}
//
//		if (settingValue == null || EMPTY.equals(settingValue)) {
//			return EResult.VALID;
//		}
//		try {
//			XMLTypeFactory.eINSTANCE.createFromString(
//					XMLTypePackage.Literals.DATE, settingValue);
//
//			XMLCalendar calend = new XMLCalendar(settingValue, XMLCalendar.DATE);
//
//			if ((simpleSetting.getMaxExclusive() != null)
//					&& (calend.compare(new XMLCalendar(simpleSetting.getMaxExclusive(),XMLCalendar.DATE)) >= 0)) {
//				EResult result = EResult.MAX_EXCL_VALUE_EXCEED;
//				result
//						.setFaultDescription(settingValue
//								+ " !< "
//								+ simpleSetting.getMaxExclusive());
//				return result;
//			} else if ((simpleSetting.getMaxInclusive() != null)
//					&& (calend.compare(new XMLCalendar(simpleSetting.getMaxInclusive(),XMLCalendar.DATE)) > 0)) {
//				EResult result = EResult.MAX_INCL_VALUE_EXCEED;
//				result
//						.setFaultDescription(settingValue
//								+ " > "
//								+ simpleSetting.getMaxInclusive());
//				return result;
//			} else if ((simpleSetting.getMinExclusive() != null)
//					&& (calend.compare(new XMLCalendar(simpleSetting.getMinExclusive(),XMLCalendar.DATE)) <= 0)) {
//				EResult result = EResult.MIN_EXCL_VALUE_UNDERRUN;
//				result
//						.setFaultDescription(settingValue
//								+ " !> "
//								+ simpleSetting.getMinExclusive());
//				return result;
//			} else if ((simpleSetting.getMinInclusive() != null)
//					&& (calend.compare(new XMLCalendar(simpleSetting.getMinInclusive(),XMLCalendar.DATE)) < 0)) {
//				EResult result = EResult.MIN_INCL_VALUE_UNDERRUN;
//				result
//						.setFaultDescription(settingValue
//								+ " < "
//								+ simpleSetting.getMinInclusive());
//				return result;
//			}
//			return validatePattern(settingValue, simpleSetting);
//		} catch (IllegalArgumentException e) {
//			EResult result = EResult.INCORRECT_DATE_FORMAT;
//			result.setFaultDescription("Incorrect symbol(s)");
//			return result;
//		}
//		// return Result.VALID;
//	}

//	private static EResult validateDateTimeSetting(ESetting setting,
//			String settingValue) {
//		ESimpleSetting simpleSetting = (ESimpleSetting) setting;
//
//		if (setting.isRequired() && setting.isValueNull()
//				&& simpleSetting.getDefaultValue() == null) {
//			return EResult.VALUE_IS_MISSING;
//		}
//
//		if (settingValue == null || EMPTY.equals(settingValue)) {
//			return EResult.VALID;
//		}
//		String settingValueT;
//		if (settingValue.length() > 10) {
//			if (settingValue.charAt(10) == '-') {
//				StringBuilder sb = new StringBuilder(settingValue);
//				sb.setCharAt(10, 'T');
//				settingValueT = sb.toString();
//			} else {
//				settingValueT = settingValue;
//			}
//		} else {
//			settingValueT = settingValue;
//		}
//
//		EResult result = validateDateTimeSetting(settingValueT);
//		if (result.equals(EResult.INCORRECT_DATE_TIME_FORMAT)) {
//			if (settingValueT.length() > 10) {
//				String subSequence = settingValueT.substring(0, 10);
//				EResult result2 = validateDateTimeSetting(subSequence);
//				if (result2.equals(EResult.INCORRECT_DATE_TIME_FORMAT)) {
//					EResult resultToRet = EResult.INCORRECT_DATE_TIME_FORMAT;
//					resultToRet.setFaultDescription("Incorrect symbol(s)");
//					return resultToRet;
//				}
//				String substring = settingValueT.substring(11);
//				EResult result3 = validateDateTimeSetting(substring);
//				if (result3.equals(EResult.INCORRECT_DATE_TIME_FORMAT)) {
//					String substring2 = settingValueT.substring(10);
//					EResult result4 = validateDateTimeSetting(substring2);
//					if (result4.equals(EResult.INCORRECT_DATE_TIME_FORMAT)) {
//						EResult resultToRet = EResult.INCORRECT_DATE_TIME_FORMAT;
//						resultToRet.setFaultDescription("Incorrect symbol(s)");
//						return resultToRet;
//					}
//				}
//			} else {
//				EResult resultToRet = EResult.INCORRECT_DATE_TIME_FORMAT;
//				resultToRet.setFaultDescription("Incorrect symbol(s)");
//				return resultToRet;
//			}
//		}
//		try {
//			XMLCalendar calend = new XMLCalendar(settingValueT,
//					XMLCalendar.DATETIME);
//			if ((simpleSetting.getMaxExclusive() != null)
//					&& (calend.compare(new XMLCalendar(simpleSetting.getMaxExclusive(),XMLCalendar.DATETIME)) >= 0)) {
//				EResult resultToRet = EResult.MAX_EXCL_VALUE_EXCEED;
//				resultToRet
//						.setFaultDescription(settingValue
//								+ " !< "
//								+ simpleSetting.getMaxExclusive());
//				return resultToRet;
//			} else if ((simpleSetting.getMaxInclusive() != null)
//					&& (calend.compare(new XMLCalendar(simpleSetting.getMaxInclusive(),XMLCalendar.DATETIME)) >= 0)) {
//				if (calend.compare(new XMLCalendar(simpleSetting.getMaxInclusive(),XMLCalendar.DATETIME)) == 0) {
//					Number seconds = calend.getFractionalSecond();
//					Number secondsCal = (new XMLCalendar(simpleSetting.getMaxInclusive(),XMLCalendar.DATETIME))
//							.getFractionalSecond();
//					if (seconds != null && secondsCal != null) {
//						if (seconds.doubleValue() <= secondsCal.doubleValue()) {
//							return EResult.VALID;
//						} else {
//							EResult resultToRet = EResult.MAX_INCL_VALUE_EXCEED;
//							resultToRet.setFaultDescription(settingValue
//									+ " > "
//									+ simpleSetting.getMaxInclusive());
//							return resultToRet;
//						}
//					} else {
//						return EResult.VALID;
//					}
//				} else {
//					EResult resultToRet = EResult.MAX_INCL_VALUE_EXCEED;
//					resultToRet.setFaultDescription(settingValue
//							+ " > "
//							+ simpleSetting.getMaxInclusive());
//					return resultToRet;
//				}
//			} else if ((simpleSetting.getMinExclusive() != null)
//					&& (calend.compare(new XMLCalendar(simpleSetting.getMinExclusive(),XMLCalendar.DATETIME)) <= 0)) {
//				if (calend.compare(new XMLCalendar(simpleSetting.getMinExclusive(),XMLCalendar.DATETIME)) == 0) {
//					Number seconds = calend.getFractionalSecond();
//					Number secondsCal = (new XMLCalendar(simpleSetting.getMinExclusive(),XMLCalendar.DATETIME))
//							.getFractionalSecond();
//					if (seconds != null && secondsCal != null) {
//						if (seconds.doubleValue() > secondsCal.doubleValue()) {
//							return EResult.VALID;
//						} else {
//							EResult resultToRet = EResult.MIN_EXCL_VALUE_UNDERRUN;
//							resultToRet.setFaultDescription(settingValue
//									+ " !> "
//									+ simpleSetting.getMinExclusive());
//							return resultToRet;
//						}
//					} else {
//						EResult resultToRet = EResult.MIN_EXCL_VALUE_UNDERRUN;
//						resultToRet.setFaultDescription(settingValue
//								+ " !> "
//								+ simpleSetting.getMinExclusive());
//						return resultToRet;
//					}
//				} else {
//					EResult resultToRet = EResult.MIN_EXCL_VALUE_UNDERRUN;
//					resultToRet.setFaultDescription(settingValue
//							+ " !> "
//							+ simpleSetting.getMinExclusive());
//					return resultToRet;
//				}
//			} else if ((simpleSetting.getMinInclusive() != null)
//					&& (calend.compare(new XMLCalendar(simpleSetting.getMinInclusive(),XMLCalendar.DATETIME)) < 0)) {
//				EResult resultToRet = EResult.MIN_INCL_VALUE_UNDERRUN;
//				resultToRet
//						.setFaultDescription(settingValue
//								+ " < "
//								+ simpleSetting.getMinInclusive());
//				return resultToRet;
//			}
//			return validatePattern(settingValueT, simpleSetting);
//		} catch (IllegalArgumentException e) {
//			EResult resultToRet = EResult.INCORRECT_DATE_TIME_FORMAT;
//			resultToRet.setFaultDescription("Incorrect symbol(s)");
//			return resultToRet;
//		}
//
//		// return Result.VALID;
//	}

//	private static EResult validateDateTimeSetting(String value) {
//		if (value == null || value.equals("")) {
//			return EResult.VALID;
//		}
//		try {
//			XMLTypeFactory.eINSTANCE.createFromString(
//					XMLTypePackage.Literals.DATE_TIME, value);
//		} catch (IllegalArgumentException e) {
//			EResult result = EResult.INCORRECT_DATE_TIME_FORMAT;
//			result.setFaultDescription("Incorrect symbol(s)");
//			return result;
//		}
//		return EResult.VALID;
//	}

	/***************************************************************************
	 * validateIntSetting
	 **************************************************************************/

//	private static EResult validateIntSetting(ESetting setting,
//			String settingValue) {
//		ESimpleSetting simpleSetting = (ESimpleSetting) setting;
//
//		if (setting.isRequired() && setting.isValueNull()
//				&& simpleSetting.getDefaultValue() == null) {
//			return EResult.VALUE_IS_MISSING;
//		}
//
//		if (settingValue == null || EMPTY.equals(settingValue)) {
//			return EResult.VALID;
//		}
//
//		try {
//			if (settingValue.indexOf('.') >= 0) {
//				EResult result = EResult.INCORRECT_NUMBER_FORMAT;
//				result.setFaultDescription("Token \".\"");
//				return result;
//			}
//
//			BigDecimal number = new BigDecimal(settingValue);
//
//			int number_lenght = settingValue.startsWith("-") ? settingValue
//					.length() - 1 : settingValue.length();
//
//			if ((simpleSetting.getTotalDigits() != null)
//					&& simpleSetting.getTotalDigits().intValue() != -1
//					&& number_lenght > simpleSetting.getTotalDigits()
//							.intValue()) {
//				EResult result = EResult.TOTAL_DIGITS_EXCEED;
//				result.setFaultDescription(number_lenght + " > "
//						+ simpleSetting.getTotalDigits().intValue());
//				return result;
//			} else if ((simpleSetting.getMaxExclusive() != null)
//					&& (number.compareTo(new BigDecimal(simpleSetting.getMaxExclusive())) >= 0)) {
//				EResult result = EResult.MAX_EXCL_VALUE_EXCEED;
//				result
//						.setFaultDescription(settingValue
//								+ " !< "
//								+ simpleSetting.getMaxExclusive());
//				return result;
//			} else if ((simpleSetting.getMaxInclusive() != null)
//					&& (number.compareTo(new BigDecimal(simpleSetting.getMaxInclusive()))) > 0) {
//				EResult result = EResult.MAX_INCL_VALUE_EXCEED;
//				result
//						.setFaultDescription(settingValue
//								+ " > "
//								+ simpleSetting.getMaxInclusive());
//				return result;
//			} else if ((simpleSetting.getMinExclusive() != null && (number
//					.compareTo(new BigDecimal(simpleSetting.getMinExclusive()))) <= 0)) {
//				EResult result = EResult.MIN_EXCL_VALUE_UNDERRUN;
//				result
//						.setFaultDescription(settingValue
//								+ " !> "
//								+ simpleSetting.getMinExclusive());
//				return result;
//			} else if ((simpleSetting.getMinInclusive() != null)
//					&& (number.compareTo(new BigDecimal(simpleSetting.getMinInclusive()))) < 0) {
//				EResult result = EResult.MIN_INCL_VALUE_UNDERRUN;
//				result
//						.setFaultDescription(settingValue
//								+ " < "
//								+ simpleSetting.getMinInclusive());
//				return result;
//			}
//			return validatePattern(settingValue, simpleSetting);
//
//		} catch (NumberFormatException exc) {
//			if (settingValue.matches("\\d*|-\\d+"))
//				return EResult.NUMBER_OUT_OF_RANGE;
//			else if (settingValue.equals("-")) {
//				return EResult.MINUS_ONLY;
//			} else if (settingValue.matches(".*[^0-9]+.*")) {
//				EResult result = EResult.INCORRECT_NUMBER_FORMAT;
//				result.setFaultDescription("Incorrect symbol(s)");
//				return result;
//			}
//			try {
//
//				Double.parseDouble(settingValue);
//
//				return EResult.VALID;
//			} catch (NumberFormatException e) {
//
//			}
//
//		}
//
//		EResult result = EResult.INCORRECT_NUMBER_FORMAT;
//		result.setFaultDescription("Incorrect symbol(s)");
//		return result;
//	}

	/***************************************************************************
	 * validateStringSetting
	 **************************************************************************/

//	private static EResult validateStringSetting(ESetting setting,
//			String settingValue) {
//		ESimpleSetting simpleSetting = (ESimpleSetting) setting;
//
//		if (setting.isRequired() && setting.isValueNull()
//				&& simpleSetting.getDefaultValue() == null) {
//			return EResult.VALUE_IS_MISSING;
//		}
//
//		BigInteger maxLength = getMaxTextLength(setting);
//		if (settingValue == null) {
//			return EResult.VALID;
//		}
//
//		if (maxLength != null && settingValue.length() > maxLength.intValue()
//				&& maxLength.intValue() != -1) {
//			EResult result = EResult.MAX_LENGTH_EXCEED;
//			result.setFaultDescription(settingValue.length() + " > "
//					+ maxLength.intValue());
//			return result;
//		}
//
//		if (simpleSetting.getLength() != null) {
//			if (settingValue.length() != simpleSetting.getLength().intValue()
//					&& simpleSetting.getLength().intValue() != -1) {
//				EResult result = EResult.EXACT_LENGTH_NOT_MATCHED;
//				result.setFaultDescription(settingValue.length() + " != "
//						+ simpleSetting.getLength().intValue());
//				return result;
//			}
//		}
//
//		if (simpleSetting.getMinLength() != null) {
//			if (settingValue.length() < simpleSetting.getMinLength().intValue()) {
//				EResult result = EResult.MIN_LENGTH_UNDERRUN;
//				result.setFaultDescription(settingValue.length() + " < "
//						+ simpleSetting.getMinLength().intValue());
//				return result;
//			}
//		}
//		return validatePattern(settingValue, simpleSetting);
//
//	}

//	private static BigInteger getMaxTextLength(ESetting setting) {
//		ESimpleSetting simpleSetting = (ESimpleSetting) setting;
//		return simpleSetting.getMaxLength();
//	}

	/***************************************************************************
	 * validateFileSetting
	 **************************************************************************/
	// confml v.2
//	private static List<IResult> validateFileSetting(ESetting setting,
//			String settingValue, ELibraryRoot root) {
//
//		List<IResult> resultList = new ArrayList<IResult>();
//
//		if (setting instanceof EResourceSetting) {
//			EResourceSetting filePath = (EResourceSetting) setting;
//
//			if (setting.isRequired() && setting.isValueNull()
//					&& filePath != null && filePath.getDefaultPath() == null) {
//				resultList.add(EResult.VALUE_IS_MISSING);
//				return resultList;
//			}
//
//			String path = filePath.getPath();
//
//			if (path != null && filePath.getPattern() != "") {
//				Path p = new Path(path);
//				if (!p.lastSegment().matches(filePath.getPattern())) {
//					EResult result = EResult.PATTERN_NOT_MATCHED;
//					result.setFaultDescription(filePath.getPattern());
//					resultList.add(result);
//					return resultList;
//				}
//			}
//			if (filePath.equals(filePath.getParent().getSourceEResourceSetting())) {
//				boolean isFile = filePath.isFile();
//				if (settingValue != null && settingValue.contains("[key=")
//						&& settingValue.contains("]")) {
//					String substring = settingValue.substring(path
//							.indexOf("[key="));
//					if (substring.contains("]")) {
//						settingValue = substring.substring(6, substring
//								.indexOf("]") - 1);
//					}
//				}
//				boolean exist = fileExist(settingValue, isFile, root);
//
//				if (!exist) {
//					if (isFile) {
//						EResult result = EResult.FILENOTEXIST;
//						result.setFaultDescription(settingValue);
//						resultList.add(result);
//						return resultList;
//					} else {
//						EResult result = EResult.DIRECTORYNOTEXIST;
//						result.setFaultDescription(settingValue);
//						resultList.add(result);
//						return resultList;
//					}
//				}
//				if (isFile) {
//					return validateFile(setting, settingValue, root, resultList);
//				} else {
//					IResult result = validateFolder(setting, settingValue, root);
//					resultList.add(result);
//					return resultList;
//
//				}
//			}
//			resultList.add(EResult.VALID);
//			return resultList;
//		}
//		return resultList;
//	}

//	private static List<IResult> validateFile(ESetting setting,
//			String settingValue, ELibraryRoot root, List<IResult> resultList) {
//		Setting filePath = (Setting) setting;
//		// validate filePath property
//		if (settingValue != null) {
//			EList<Property> properties = filePath.getProperty();
//			File file = new File(settingValue);
//			IContentDescription contentDescription = getContentDescription(
//					file, root);
//
//			IContentType baseType = null;
//			if (contentDescription != null) {
//				baseType = contentDescription.getContentType().getBaseType();
//			}
//			resultList.clear();
//			for (Property property : properties) {
//
//				IResult result = validateProperty(file, contentDescription,
//						baseType, property, root);
//				if (!result.equals(EResult.VALID)) {
//					resultList.add(result);
//				}
//			}
//
//			if (contentDescription != null) {
//				IContentType type = contentDescription.getContentType();
//				if (type != null && type.isKindOf(MediaUIPlugin.CT_IMAGE_SVG)) {
//					IResult result = validateSVG(root, settingValue);
//					if (!result.equals(EResult.VALID)) {
//						resultList.add(result);
//					}
//				}
//			}
//
//			if (!resultList.isEmpty()) {
//				return resultList;
//			}
//		}
//		resultList.add(EResult.VALID);
//		return resultList;
//	}

//	private static IResult validateFolder(ESetting setting, String settingValue,
//			ELibraryRoot root) {
//		ELibraryElement fileSystemElement = ResourceUtil.getFileSystemElement(
//				root, settingValue);
//
//		if (fileSystemElement instanceof ELibraryDirectory) {
//			ELibraryDirectory d = (ELibraryDirectory) fileSystemElement;
//			EList<ELibraryElement> children = d.getChildren();
//			for (int i = 0; i < children.size(); i++) {
//				ELibraryElement fileSystemElement2 = children.get(i);
//				if (fileSystemElement2 instanceof ELibraryDirectory) {
//					IResult validateFolder = validateFolder(setting,
//							fileSystemElement2.getPath(), root);
//					if (!validateFolder.equals(EResult.VALID)) {
//						return validateFolder;
//					}
//				} else {
//					List<IResult> validateFileSetting = validateFile(setting,
//							fileSystemElement2.getPath(), root,
//							new ArrayList<IResult>());
//					if (!validateFileSetting.isEmpty()
//							&& !validateFileSetting.contains(EResult.VALID)
//							&& !validateFileSetting
//									.contains(EResult.CONSTRAINT_IS_NOT_APPLICABLE)) {
//						IResult result = (IResult) validateFileSetting.get(0);
//						String errorDescription = result.getErrorDescription();
//						if (errorDescription != null
//								&& !errorDescription
//										.contains(Result.NOT_APPLICABLE)) {
//							return result;
//						}
//
//					}
//				}
//			}
//
//		}
//		return EResult.VALID;
//	}

	/**
	 * @param file
	 * @param contentDescription
	 * @param baseType
	 * @param property
	 * @param root
	 * @param propertyName
	 * @param value
	 */
//	private static IResult validateProperty(File file,
//			IContentDescription contentDescription, IContentType baseType,
//			Property property, ELibraryRoot root) {
//
//		String propertyName = property.getName();
//		String value = property.getValue();
//		ELibraryElement fileSystemElement = ResourceUtil.getFileSystemElement(
//				root, file.getPath());
//
//		if (propertyName == null) {
//			return EResult.VALID;
//		}
//
//		if (propertyName.compareTo(FileProperty.TYPE_PROPERTY) == 0) { // validate
//			// type
//			String fileName = file.getName();
//			String fileExtension = FileUtils.getExtension(fileName);
//			if (!isValidExtension(fileExtension, property)) {
//				EResult result = EResult.INCORRECT_FILE_EXTENSION;
//				result.setFaultDescription("." + fileExtension + " instead of "
//						+ value);
//				return result;
//			}
//
//		} else if (propertyName.equals(FileProperty.MAX_BITS_PROPERTY)) {// validate
//			// maximum number of units per pixel
//
//			if (isBaseTypeValid(baseType, MediaUIPlugin.CT_IMAGE)) {
//				String depth = contentDescription.getProperty(
//						MediaUIPlugin.COLOR_DEPTH).toString();
//
//				if (Integer.valueOf(depth) > Integer.valueOf(value)) {
//					EResult result = EResult.MAX_BITS_EXCEED;
//					result.setFaultDescription(depth + " bits > " + value
//							+ " bits");
//					return result;
//				}
//			} else {
//				return notApplicable(FileProperty.MAX_BITS_PROPERTY);
//			}
//		} else if (propertyName.equals(FileProperty.MAX_WIDTH_PROPERTY)) { // validate
//			// maximum width of graphic in units
//
//			if (isBaseTypeValid(baseType, MediaUIPlugin.CT_IMAGE)) {
//				String width = contentDescription.getProperty(
//						MediaUIPlugin.VIDEO_WIDTH).toString();
//
//				if (Integer.valueOf(width) > Integer.valueOf(value)) {
//					EResult result = EResult.MAX_WIDTH_EXCEED;
//					result.setFaultDescription(width + " pixel > " + value
//							+ " pixel");
//					return result;
//				}
//			} else {
//				return notApplicable(FileProperty.MAX_WIDTH_PROPERTY);
//			}
//		} else if (propertyName.equals(FileProperty.MAX_HEIGHT_PROPERTY)) { // validate
//			// maximum height of graphic in units
//
//			if (isBaseTypeValid(baseType, MediaUIPlugin.CT_IMAGE)) {
//				String height = contentDescription.getProperty(
//						MediaUIPlugin.VIDEO_HEIGHT).toString();
//
//				if (Integer.valueOf(height) > Integer.valueOf(value)) {
//					EResult result = EResult.MAX_HEIGHT_EXCEED;
//					result.setFaultDescription(height + " pixel > " + value
//							+ " pixel");
//					return result;
//				}
//			} else {
//				return notApplicable(FileProperty.MAX_HEIGHT_PROPERTY);
//			}
//		} else if (propertyName.equals(FileProperty.MIN_WIDTH_PROPERTY)) { // validate
//			// minimum width of graphic in units
//
//			if (isBaseTypeValid(baseType, MediaUIPlugin.CT_IMAGE)) {
//				String width = contentDescription.getProperty(
//						MediaUIPlugin.VIDEO_WIDTH).toString();
//
//				if (Integer.valueOf(width) < Integer.valueOf(value)) {
//					EResult result = EResult.MIN_WIDTH_NOT_REACHED;
//					result.setFaultDescription(width + " pixel < " + value
//							+ " pixel");
//					return result;
//				}
//			} else {
//				return notApplicable(FileProperty.MIN_WIDTH_PROPERTY);
//			}
//		} else if (propertyName.equals(FileProperty.MIN_HEIGHT_PROPERTY)) { // validate
//			// minimum height of graphic in units
//
//			if (isBaseTypeValid(baseType, MediaUIPlugin.CT_IMAGE)) {
//
//				String height = contentDescription.getProperty(
//						MediaUIPlugin.VIDEO_HEIGHT).toString();
//
//				if (Integer.valueOf(height) < Integer.valueOf(value)) {
//					EResult result = EResult.MIN_HEIGHT_NOT_REACHED;
//					result.setFaultDescription(height + " pixel < " + value
//							+ " pixel");
//					return result;
//				}
//			} else {
//				return notApplicable(FileProperty.MIN_HEIGHT_PROPERTY);
//			}
//		} else if (propertyName.equals(FileProperty.WIDTH_PROPERTY)) { // validate
//			// width
//
//			if (isBaseTypeValid(baseType, MediaUIPlugin.CT_IMAGE)) {
//				String width = contentDescription.getProperty(
//						MediaUIPlugin.VIDEO_WIDTH).toString();
//
//				if (!Integer.valueOf(width).equals(Integer.valueOf(value))) {
//					EResult result = EResult.WIDTH_NOT_MATCHED;
//					result.setFaultDescription(width + " pixel != " + value
//							+ " pixel");
//					return result;
//				}
//			} else {
//				return notApplicable(FileProperty.WIDTH_PROPERTY);
//			}
//		} else if (propertyName.equals(FileProperty.HEIGHT_PROPERTY)) { // validate
//			// height
//
//			if (isBaseTypeValid(baseType, MediaUIPlugin.CT_IMAGE)) {
//
//				String height = contentDescription.getProperty(
//						MediaUIPlugin.VIDEO_HEIGHT).toString();
//
//				if (!Integer.valueOf(height).equals(Integer.valueOf(value))) {
//					EResult result = EResult.HEIGHT_NOT_MATCHED;
//					result.setFaultDescription(height + " pixel != " + value
//							+ " pixel");
//					return result;
//				}
//			} else {
//				return notApplicable(FileProperty.HEIGHT_PROPERTY);
//			}
//		} else if (propertyName.equals(FileProperty.MAX_COLOR_PROPERTY)) { // validate
//			// maximum number of distinct color values
//			if (baseType != null) {
//				if (isBaseTypeValid(baseType, MediaUIPlugin.CT_IMAGE)) {
//					String filePath = root.getTempDirPath() + File.separator
//							+ file.getPath();
//
//					ImageData[] load = new ImageLoader().load(filePath);
//
//					final Set<Integer> distinctColors = new HashSet<Integer>();
//
//					for (ImageData imageData : load) {
//						for (int x = 0; x < imageData.width; x++) {
//							for (int y = 0; y < imageData.height; y++) {
//								int pixel = imageData.getPixel(x, y);
//								distinctColors.add(pixel);
//							}
//						}
//					}
//					int color = distinctColors.size();
//
//					if (color > Integer.valueOf(value)) {
//						EResult result = EResult.MAX_COLOR_EXCEED;
//						result.setFaultDescription(color + " > " + value);
//						return result;
//					}
//
//				} else {
//					return notApplicable(FileProperty.MAX_COLOR_PROPERTY);
//				}
//			}
//		}
//
//		if (fileSystemElement instanceof ELibraryFile) {
//			ELibraryFile fileToValidate = (ELibraryFile)fileSystemElement;
//
//			if (propertyName.compareTo(FileProperty.MAX_FILE_SIZE_PROPERTY) == 0) {
//
//				if (DEFAULT_SIZE_UNIT.equals(property.getUnit())) {
//					if (getSize(fileToValidate, DEFAULT_SIZE_UNIT) > new Long(
//							property.getValue())) {
//						EResult result = EResult.MAX_SIZE_EXCEED;
//						result.setFaultDescription(getSize(fileToValidate,
//								DEFAULT_SIZE_UNIT)
//								+ " kB > " + value + " kB");
//						return result;
//					}
//				} else if (property.getUnit().equals("MB")) {
//					if (getSize(fileToValidate, "MB") > new Long(property
//							.getValue())) {
//						EResult result = EResult.MAX_SIZE_EXCEED;
//						result
//								.setFaultDescription(getSize(fileToValidate,
//										"MB")
//										+ " MB > " + value + " MB");
//						return result;
//					}
//				}
//			} else if (propertyName
//					.compareTo(FileProperty.RECOMMENDED_FILE_SIZE_PROPERTY) == 0) {
//				if (DEFAULT_SIZE_UNIT.equals(property.getUnit())) {
//					if (getSize(fileToValidate, DEFAULT_SIZE_UNIT) > new Long(
//							property.getValue())) {
//						EResult result = EResult.RECOMMENDED_SIZE_EXCEED;
//						result.setFaultDescription(getSize(fileToValidate,
//								DEFAULT_SIZE_UNIT)
//								+ " kB > " + value + " kB");
//						return result;
//					}
//				} else if (property.getUnit().equals("MB")) {
//					if (getSize(fileToValidate, "MB") > new Long(property
//							.getValue())) {
//						EResult result = EResult.RECOMMENDED_SIZE_EXCEED;
//						result
//								.setFaultDescription(getSize(fileToValidate,
//										"MB")
//										+ " MB > " + value + " MB");
//						return result;
//					}
//				}
//			}
//		}
//		return EResult.VALID;
//	}

//	private static IResult notApplicable(String property) {
//		Result result = new Result();
//		result.constructMessage(Result.CONSTRAINT, property,
//				Result.NOT_APPLICABLE);
//		return result;
//	}

//	private static float getSize(
//			ELibraryFile fileToValidate,
//			String unit) {
//
//		if (unit.equals(DEFAULT_SIZE_UNIT)) {
//			return fileToValidate.getSize() / (float) 1024;
//		} else if (unit.equals("MB")) {
//			return fileToValidate.getSize() / (float) 1024 * 1024;
//		}
//		return fileToValidate.getSize();
//	}

//	private static IContentDescription getContentDescription(File file,
//			ELibraryRoot root) {
//
//		ELibraryElement fileSystemElement = ResourceUtil.getFileSystemElement(
//				root, file.getPath());
//
//		if (fileSystemElement instanceof ELibraryFile) {
//			ELibraryFile file2 = (ELibraryFile)fileSystemElement;
//
//			return file2.getContentDescription();
//		}
//		return null;
//	}

//	private static boolean isBaseTypeValid(IContentType baseType,
//			IContentType iContentType) {
//
//		if (baseType != null) {
//			if (MediaUIPlugin.CT_IMAGE.equals(baseType)) {
//				return true;
//			}
//		}
//		return false;
//	}

//	private static boolean fileExist(String sourcePath, boolean file,
//			ELibraryRoot root) {
//		if (sourcePath != "" && sourcePath != null) {
//			return fileExist(sourcePath, root, file);
//		} else {
//			return true;
//		}
//	}

//	private static boolean fileExist(String sourcePath,
//			ELibraryRoot aResorceModelRoot, boolean file) {
//		ELibraryElement element = ResourceUtil.getFileSystemElement(
//				aResorceModelRoot, sourcePath);
//		if (element != null) {
//			if (file)
//				return true;
//			else if (element instanceof ELibraryDirectory)
//				return true;
//		}
//		return false;
//	}

//	private static boolean isValidExtension(String fileExtension,
//			Property property) {
//		if (fileExtension == null) {
//			return false;
//		}
//
//		List<String> supportedFileTypes = supportedFileTypes(property
//				.getValue());
//		if (supportedFileTypes.contains(fileExtension.toLowerCase()))
//			return true;
//		return false;
//	}

//	private static List<String> supportedFileTypes(
//			String spaceSeparatedFileTypes) {
//		List<String> extensions = new ArrayList<String>();
//		String[] fileTypes = spaceSeparatedFileTypes.split(" ");
//		for (String fileType : fileTypes) {
//			if (fileType.contains(FILE_TYPE_SEPARATOR)) {
//				extensions.add(extractFileType(fileType).toLowerCase());
//			}
//		}
//		return extensions;
//	}

	/*
	 * private boolean valid(Property fileTypeProperty) { return
	 * fileTypeProperty.getName().equals(TYPE); }
	 */

//	private static String extractFileType(String fileType) {
//		return fileType.substring(indexOfFileType(fileType));
//	}
//
//	private static int indexOfFileType(String fileType) {
//		return fileType.indexOf(FILE_TYPE_SEPARATOR) + 1;
//	}

	/***************************************************************************
	 * validateRealSetting
	 **************************************************************************/

//	private static EResult validateRealSetting(ESetting setting,
//			String settingValue) {
//		ESimpleSetting simpleSetting = (ESimpleSetting) setting;
//
//		if (setting.isRequired() && setting.isValueNull()
//				&& simpleSetting.getDefaultValue() == null) {
//			return EResult.VALUE_IS_MISSING;
//		}
//
//		if (settingValue == null) {
//			return EResult.VALID;
//		}
//
//		try {
//
//			// 16 digits + '.' + '-'
//			if (settingValue.length() > 18) {
//				EResult result = EResult.INCORRECT_NUMBER_FORMAT;
//				result.setFaultDescription("Incorrect symbol(s)");
//				return result;
//			}
//			if (settingValue.length() == 18) {
//				if (settingValue.indexOf('.') == -1
//						|| settingValue.indexOf('-') == -1) {
//					EResult result = EResult.INCORRECT_NUMBER_FORMAT;
//					result.setFaultDescription("Incorrect symbol(s)");
//					return result;
//				}
//			}
//			// if the setting value ends char 'f' then Java indentifies this
//			// string as number,
//			// but it's not correct behaviour for the Setting validator
//			if (settingValue.indexOf('f') != -1) {
//				EResult result = EResult.INCORRECT_NUMBER_FORMAT;
//				result.setFaultDescription("Incorrect symbol(s)");
//				return result;
//			}
//
//			if (EMPTY.equals(settingValue))
//				return EResult.VALID;
//
//			BigDecimal number = new BigDecimal(settingValue);
//
//			if ((simpleSetting.getMaxExclusive() != null)
//					&& (number.compareTo(new BigDecimal(simpleSetting.getMaxExclusive())) >= 0)) {
//				EResult result = EResult.MAX_EXCL_VALUE_EXCEED;
//				result
//						.setFaultDescription(settingValue
//								+ " !< "
//								+ simpleSetting.getMaxExclusive());
//				return result;
//			} else if ((simpleSetting.getMaxInclusive() != null)
//					&& (number.compareTo(new BigDecimal(simpleSetting.getMaxInclusive())) > 0)) {
//				EResult result = EResult.MAX_INCL_VALUE_EXCEED;
//				result
//						.setFaultDescription(settingValue
//								+ " > "
//								+ simpleSetting.getMaxInclusive());
//				return result;
//			} else if ((simpleSetting.getMinExclusive() != null)
//					&& (number.compareTo(new BigDecimal(simpleSetting.getMinExclusive())) <= 0)) {
//				EResult result = EResult.MIN_EXCL_VALUE_UNDERRUN;
//				result
//						.setFaultDescription(settingValue
//								+ " !> "
//								+ simpleSetting.getMinExclusive());
//				return result;
//			} else if ((simpleSetting.getMinInclusive() != null)
//					&& (number.compareTo(new BigDecimal(simpleSetting.getMinInclusive())) < 0)) {
//				EResult result = EResult.MIN_INCL_VALUE_UNDERRUN;
//				result
//						.setFaultDescription(settingValue
//								+ " < "
//								+ simpleSetting.getMinInclusive());
//				return result;
//			} else if ((simpleSetting.getPattern().size() > 0)) {
//				return validatePattern(settingValue, simpleSetting);
//
//			} else {
//				return EResult.VALID;
//			}
//
//		} catch (NumberFormatException exc) {
//			if (settingValue.matches("([0-9]+\\.([0-9]+)|\\.[0-9]+)")) {
//				EResult result = EResult.NUMBER_OUT_OF_RANGE;
//				result.setFaultDescription(settingValue);
//				return result;
//			} else if (settingValue.equals("-")) {
//				return EResult.MINUS_ONLY;
//			}
//			try {
//				Double.parseDouble(settingValue);
//				return EResult.VALID;
//			} catch (NumberFormatException e) {
//
//			}
//		}
//
//		EResult result = EResult.INCORRECT_NUMBER_FORMAT;
//		result.setFaultDescription("Incorrect symbol(s)");
//		return result;
//
//	}

//	private static EResult validatePattern(String settingValue,
//			ESimpleSetting simpleSetting) {
//		EList<String> patternList = simpleSetting.getPattern();
//		if (patternList.size() == 0) {
//			return EResult.VALID;
//		}
//		
//		for (String patternValue : patternList) {
//			if (patternValue != null && !patternValue.equals("")) {
//				EResult matchPattern = matchPattern(settingValue, patternValue);
//				if (matchPattern == EResult.PATTERN_NOT_MATCHED)
//					return matchPattern;
//			}
//
//		}
//		
//
//		EResult result = EResult.VALID;
//		return result;
//	}
	
//	private static EResult matchPattern(String settingValue, String pattern){
//		
//		if (settingValue.matches(pattern)) {
//			return EResult.VALID;
//		}
//		
//		EResult result = EResult.PATTERN_NOT_MATCHED;
//		String fault = pattern.toString();
//		if (fault.charAt(0) == '[' && fault.charAt(fault.length() - 1) == ']') {
//			fault = fault.substring(1, fault.length() - 1);
//		}
//		result.setFaultDescription(fault);
//		return result;
//		
//	}

	/***************************************************************************
	 * validateBooleanSetting
	 **************************************************************************/

//	private static EResult validateBooleanSetting(ESetting setting,
//			String settingValue) {
//		ESimpleSetting simpleSetting = (ESimpleSetting) setting;
//		String testBoolean;
//
//		if (settingValue == null
//				|| (setting.isRequired() && setting.isValueNull() && simpleSetting
//						.getDefaultValue() == null)) {
//			return EResult.VALUE_IS_MISSING;
//		}
//
//		if (settingValue == null || settingValue != null
//				&& settingValue.equals("")) {
//			return EResult.VALID;
//		}
//		testBoolean = settingValue.toLowerCase();
//		if (testBoolean.compareToIgnoreCase(FALSE_CONSTANT) != 0
//				&& testBoolean.compareToIgnoreCase(TRUE_CONSTANT) != 0) {
//			EResult result = EResult.INCORRECT_BOOLEAN_FORMAT;
//			result.setFaultDescription("Incorrect symbol(s)");
//			return result;
//		}
//		EList<String> patternList = simpleSetting.getPattern();
//		
//		for (String pattern : patternList) {
//			if (pattern!=null && !pattern.equals("")){
//				StringTokenizer acceptedValues = new StringTokenizer(pattern, "|");
//				boolean isValid = false;
//				while (acceptedValues.hasMoreTokens()) {
//					if (testBoolean.compareToIgnoreCase(acceptedValues
//							.nextToken()) == 0) {
//						isValid = true;
//						break;
//					}
//				}
//				if (!isValid) {
//					EResult result = EResult.PATTERN_NOT_MATCHED;
//					String fault = pattern;
//					if (fault.charAt(0) == '['
//							&& fault.charAt(fault.length() - 1) == ']') {
//						fault = fault.substring(1, fault.length() - 1);
//					}
//					result.setFaultDescription(fault);
//					return result;
//				}
//			}
//
//		}
//	
//		return EResult.VALID;
//	}

	/***************************************************************************
	 * validateSequenceSetting
	 **************************************************************************/
//	private static EResult validateSequenceSetting(ESetting setting) {
//		// List<Ref> data =
//		// SequenceConfMlModelUtils.getSequenceOfValues(setting);
//
//		ESequenceSetting sequence = (ESequenceSetting) setting;
//
//		int size = sequence.getItems().size();
//
//		if (sequence.isRequired() && size < 1) {
//			return EResult.VALUE_IS_MISSING;
//		}
//
//		int minOccurs = 0;
//		int maxOccurs = 0;
//		
//		if (sequence.getMinOccurs()!=null)
//			minOccurs = sequence.getMinOccurs().intValue();
//		if (sequence.getMaxOccurs()!=null)
//		maxOccurs = sequence.getMaxOccurs().intValue();
//
//		if (minOccurs != 0 && size < minOccurs) {
//			EResult result = EResult.MIN_SEQUENCES_UNDERRUN;
//			result.setFaultDescription(size + " < " + minOccurs);
//			return result;
//		}
//
//		if (maxOccurs != 0 && size > maxOccurs) {
//			EResult result = EResult.MAX_SEQUENCES_EXCEED;
//			result.setFaultDescription(size + " > " + maxOccurs);
//			return result;
//		}
//
//		return EResult.VALID;
//
//	}

}
