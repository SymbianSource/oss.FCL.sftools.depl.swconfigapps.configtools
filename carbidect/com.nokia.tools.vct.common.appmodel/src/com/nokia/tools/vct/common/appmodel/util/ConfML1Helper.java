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
 * Description: This file is part of com.nokia.tools.vct.common.appmodel component.
 */

package com.nokia.tools.vct.common.appmodel.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

import com.nokia.tools.vct.common.appmodel.EAppDescriptionContainer;
import com.nokia.tools.vct.common.appmodel.EAppExpression;
import com.nokia.tools.vct.common.appmodel.EAppFeature;
import com.nokia.tools.vct.common.appmodel.EAppGroup;
import com.nokia.tools.vct.common.appmodel.EAppGroupContainer;
import com.nokia.tools.vct.common.appmodel.EAppIconContainer;
import com.nokia.tools.vct.common.appmodel.EAppOptionContainer;
import com.nokia.tools.vct.common.appmodel.EAppProperty;
import com.nokia.tools.vct.common.appmodel.EAppPropertyContainer;
import com.nokia.tools.vct.common.appmodel.EAppSequenceType;
import com.nokia.tools.vct.common.appmodel.EAppSetting;
import com.nokia.tools.vct.common.appmodel.EAppSettingOption;
import com.nokia.tools.vct.common.appmodel.EAppSettingRef;
import com.nokia.tools.vct.common.appmodel.EAppSettingType;
import com.nokia.tools.vct.common.appmodel.EAppSimpleType;
import com.nokia.tools.vct.common.appmodel.EAppTypeConstraints;
import com.nokia.tools.vct.common.appmodel.EAppValueType;
import com.nokia.tools.vct.common.appmodel.EApplicationFactory;
import com.nokia.tools.vct.confml.model.confml1.EDescriptionContainer;
import com.nokia.tools.vct.confml.model.confml1.EDescriptionElement;
import com.nokia.tools.vct.confml.model.confml1.EGroup;
import com.nokia.tools.vct.confml.model.confml1.EIconContainer;
import com.nokia.tools.vct.confml.model.confml1.EIconElement;
import com.nokia.tools.vct.confml.model.confml1.EOptionElement;
import com.nokia.tools.vct.confml.model.confml1.EPropertyElement;
import com.nokia.tools.vct.confml.model.confml1.ESettingElement;
import com.nokia.tools.vct.confml.model.xsd.ELength;
import com.nokia.tools.vct.confml.model.xsd.EMaxExclusive;
import com.nokia.tools.vct.confml.model.xsd.EMaxInclusive;
import com.nokia.tools.vct.confml.model.xsd.EMaxLength;
import com.nokia.tools.vct.confml.model.xsd.EMinExclusive;
import com.nokia.tools.vct.confml.model.xsd.EMinInclusive;
import com.nokia.tools.vct.confml.model.xsd.EMinLength;
import com.nokia.tools.vct.confml.model.xsd.EPattern;
import com.nokia.tools.vct.confml.model.xsd.ETotalDigits;

public class ConfML1Helper {

	static void populateAppSetting(EAppSetting setting,
			ESettingElement settingType) {
		handleProperties(settingType);
		populateSettingType(setting, settingType);
	}
	
	private static void handleProperties(ESettingElement settingType) {
		EList<EObject> contents = settingType.eContents();
		List<EPropertyElement> properties = new ArrayList<EPropertyElement>();
		for (EObject object : contents) {
			if (object instanceof ESettingElement) {
				ESettingElement element = (ESettingElement) object;
				EList<EObject> contents2 = element.eContents();
				for (EObject object3 : contents2) {
					if (object3 instanceof EPropertyElement) {
						properties.add((EPropertyElement) object3);
					}
				}
			}
			if (object instanceof EPropertyElement) {
				EPropertyElement element = (EPropertyElement) object;
				if (element.getName() != null) {
					properties.add(element);
				}
				
			}
		}
		settingType.getProperties().addAll(properties);
	}

	private static void populateSettingType(EAppSetting setting,
			ESettingElement settingType) {
		EAppSettingType appSettingType = adaptSettingType(settingType);
		setting.setTypeInfo(appSettingType);
	}

	static EAppSettingType adaptSettingType(ESettingElement settingType) {
		EAppSettingType appSettingType = null;

		String type = settingType.getType();
		if ("sequence".equalsIgnoreCase(type)) {
			appSettingType = adaptSequenceType(settingType);
		} else {
			appSettingType = adaptSimpleType(settingType);
		}

		return appSettingType;
	}

	static void adaptCommonTypeInfo(ESettingElement settingType,
			EAppSettingType appSettingType) {
		if (appSettingType != null) {
			appSettingType.setReadOnly("true".equalsIgnoreCase(settingType
					.getReadOnly()));
			appSettingType.setConstraint(buildAppExpression(settingType
					.getConstraint()));
			appSettingType.setRelevant(buildAppExpression(settingType
					.getRelevant()));
			appSettingType.setRequired("true".equalsIgnoreCase(settingType
					.getRequired()));

			//appSettingType.setIconDescriptor(buildIconDescriptor(settingType))
			appSettingType.setName(settingType.getName());
			adaptDescription(settingType, appSettingType);
			adaptIcon(settingType, appSettingType);

			adaptPropertyContainer(appSettingType, settingType);
		}
	}

	private static void adaptPropertyContainer(EAppPropertyContainer container,
			ESettingElement settingType) {
		EApplicationFactory factory = EApplicationFactory.eINSTANCE;

		for (EPropertyElement propertyElement : settingType.getProperties()) {
			EAppProperty appProperty = factory.createEAppProperty();
			appProperty.setName(propertyElement.getName());
			appProperty.setValue(propertyElement.getValue());
			appProperty.setUnit(propertyElement.getUnit());
			container.getProperties().add(appProperty);
		}
	}
	

	/**
	 * 
	 * @param appFactory
	 * @param appGroupContainer
	 * @param obj
	 * @param appGroup
	 */
	public static EAppGroup getAppGroup(EApplicationFactory appFactory,
			EAppGroupContainer appGroupContainer, EGroup group) {

			for (EAppGroup existingGroup : appGroupContainer.getGroups()) {
				if(existingGroup.getName().equals(group.getName())){
					return existingGroup;
				}
			}
			EAppGroup appGroup = appFactory.createEAppGroup();
			appGroup.setName(group.getName());
			ConfML1Helper.adaptDescription(group, appGroup);
			ConfML1Helper.adaptIcon(group, appGroup);
			appGroupContainer.getGroups().add(appGroup);
			return appGroup;
	}
	
	/**
	 * 
	 * @param appFactory
	 * @param appSettingLookup
	 * @param appGroup
	 * @param settingRef
	 */
	public static void populateSetting(EApplicationFactory appFactory,
			EMap<String, EAppFeature> appSettingLookup, EAppGroupContainer appGroup,
			ESettingElement settingRef) {
		
		
		EObject resolved = null;
		String[] segs = settingRef.getRef().split("/");
		String featureId = null;
		String settingId = null;
		if (segs.length > 0) {
			featureId = segs[0];
			if (segs.length > 1) {
				settingId = segs[1];
			}
		}

		EAppFeature feature = appSettingLookup.get(featureId);
		if (feature != null) {
			if ("*".equals(settingId)) {
				resolved = feature;
			} else {
				resolved = feature.getSettings().get(settingId);
			}
		}

		if (resolved instanceof EAppSetting) {
			boolean settingFound = false;
			//Check if setting ref already created for this setting
			if (appGroup instanceof EAppGroup) {
				EList<EAppSettingRef> settingRefs = ((EAppGroup)appGroup).getSettings();
				for (EAppSettingRef setting : settingRefs) {
					if (setting.getResolved().equals(resolved)) {
						//Setting ref found.
						if (setting.getResolved().getTypeInfo() instanceof EAppSequenceType) {
							//Sequence setting
							if (segs.length > 2) {
								//This is a specification of a sequence subsetting
								//Add subsetting to setting ref
								setting.getSubSettingsRef().add(segs[2]);
							} else if (segs.length == 2) {
								//This is a specification of a complete sequence setting not a sub-setting
								//set subsetting "*" (all sub-settings)
								setting.getSubSettingsRef().add("*");
							}
						}
						settingFound = true;
						break;
					}
				}
			}	
			if (!settingFound) {
				//Setting ref not found. Create it
				EAppSettingRef appSettingRef = appFactory
					.createEAppSettingRef();
				EAppSetting appSetting = (EAppSetting)resolved;

				appSettingRef.setResolved(appSetting);

				appSettingRef.setName(settingRef.getName());
				adaptDescription(settingRef, appSettingRef);
				adaptOptionContainer(settingRef, appSettingRef);
				adaptPropertyContainer(appSettingRef, settingRef);

				EAppSettingType type = appSetting.getTypeInfo();
				if (type instanceof EAppSimpleType) {
					// XSD facets are applicable only to simple values
					EAppSimpleType typeInfo = (EAppSimpleType)appSetting.getTypeInfo();
					adaptConstraints(settingRef, appSettingRef, typeInfo.getType());
				} else	if (type instanceof EAppSequenceType) {
					if (segs.length > 2) {
						//This is a specification of a sequence subsetting
						//Add subsetting to appSettingRef
						appSettingRef.getSubSettingsRef().add(segs[2]);
					}else if (segs.length == 2) {
						//This is a specification of a complete sequence setting not a sub-setting
						//set subsetting "*" (all sub-settings)
						appSettingRef.getSubSettingsRef().add("*");
					}
				}
				if (appGroup instanceof EAppGroup) {
					((EAppGroup)appGroup).getSettings().add(appSettingRef);
				}
			}
		} else if (resolved instanceof EAppFeature) {
			EAppFeature appFeature = (EAppFeature) resolved;
			for (Map.Entry<String, EAppSetting> settingEntry : appFeature
					.getSettings()) {
				EAppSettingRef appSettingRef = appFactory
						.createEAppSettingRef();

				appSettingRef.setResolved(settingEntry.getValue());

				appSettingRef.setName(settingRef.getName());
				adaptDescription(settingRef, appSettingRef);
				adaptOptionContainer(settingRef, appSettingRef);
				adaptPropertyContainer(appSettingRef, settingRef);
				
				EAppSettingType type = settingEntry.getValue().getTypeInfo();
				if (type instanceof EAppSimpleType) {
					// XSD facets are applicable only to simple values
					EAppSimpleType simple = (EAppSimpleType) type;
					adaptConstraints(settingRef, appSettingRef, simple.getType());
				}
				if (appGroup instanceof EAppGroup) {
					((EAppGroup)appGroup).getSettings().add(appSettingRef);
				}
			}
		}
	}


	/**
	 * @param source
	 * @return
	 */
	public static EAppExpression buildAppExpression(String source) {
		EAppExpression expr = EApplicationFactory.eINSTANCE
				.createEAppExpression();
		expr.setLiteral(source);
		return expr;
	}

	static EAppSettingType adaptSequenceType(ESettingElement source) {
		EAppSequenceType type = EApplicationFactory.eINSTANCE
				.createEAppSequenceType();
		adaptCommonTypeInfo(source, type);

		type.setMapKey(source.getMapKey());
		type.setMapValue(source.getMapValue());
		type.setMinOccurs(source.getMinOccurs());
		type.setMaxOccurs(source.getMaxOccurs());

		for (ESettingElement field : source.getSettings()) {
			EAppSettingType type0 = adaptSettingType(field);
			type.getTypeMap().put(field.getRef(), type0);
		}

		if (type.getTypeMap().isEmpty()) {
			type.setMapKey(null);
			type.setMapValue(null);
		} else {
			if (type.getMapKey() != null
					&& !type.getTypeMap().containsKey(type.getMapKey())) {
				type.setMapKey(null);
			}
			if (type.getMapValue() != null
					&& !type.getTypeMap().containsKey(type.getMapValue())) {
				type.setMapValue(null);
			}
		}

		return type;
	}

	static EAppSettingType adaptSimpleType(ESettingElement source) {
		EAppSimpleType type = EApplicationFactory.eINSTANCE
				.createEAppSimpleType();

		String typeString = source.getType();
		if (typeString == null || typeString.trim().length() == 0) {
			// missing type is integer
			type.setType(EAppValueType.INTEGER);
		} else if ("int".equalsIgnoreCase(typeString)) {
			type.setType(EAppValueType.INTEGER);
		} else if ("real".equalsIgnoreCase(typeString)) {
			type.setType(EAppValueType.DECIMAL);
		} else if ("boolean".equalsIgnoreCase(typeString)) {
			type.setType(EAppValueType.BOOLEAN);
		} else if ("selection".equalsIgnoreCase(typeString)) {
			type.setType(EAppValueType.SELECTION);
		} else if ("multiSelection".equalsIgnoreCase(typeString)) {
			type.setType(EAppValueType.MULTISELECTION);
		} else if ("string".equalsIgnoreCase(typeString)) {
			type.setType(EAppValueType.STRING);
		} else if ("file".equalsIgnoreCase(typeString)) {
			type.setType(EAppValueType.LOCAL_FILE);
		} else if ("folder".equalsIgnoreCase(typeString)) {
			type.setType(EAppValueType.LOCAL_FOLDER);
			// } else if ("date".equalsIgnoreCase(typeString)) {
			// type.setType(EAppValueType.DATE);
			// } else if ("dateTime".equalsIgnoreCase(typeString)) {
			// type.setType(EAppValueType.DATETIME);
			// } else if ("time".equalsIgnoreCase(typeString)) {
			// type.setType(EAppValueType.TIME);
			// } else if ("duration".equalsIgnoreCase(typeString)) {
			// type.setType(EAppValueType.DURATION);
		} else {
			// Unknown type is handled as string
			type.setType(EAppValueType.STRING);
		}
		
		adaptConstraints(source, type, type.getType());
		adaptOptionContainer(source, type);
		adaptCommonTypeInfo(source, type);
		return type;
	}

	private static void adaptConstraints(ESettingElement source,
			EAppTypeConstraints type, EAppValueType valueType) {

		for (EPattern constraint : source.getPattern()) {
			type.getPattern().add(constraint.getValue());
		}
		Integer value = null;
		for (EMinLength constraint : source.getMinLength()) {
			try {
				int newValue = Integer.parseInt(constraint.getValue());
				if (value != null) {
					value = Math.max(value, newValue);
				} else {
					value = newValue;
				}
			} catch (Exception ex) {
				// ignore
			}
		}
		type.setMinLength(value);
		value = null;
		for (EMaxLength constraint : source.getMaxLength()) {
			try {
				int newValue = Integer.parseInt(constraint.getValue());
				if (value != null) {
					value = Math.min(value, newValue);
				} else {
					value = newValue;
				}
			} catch (Exception ex) {
				// ignore
			}
		}
		type.setMaxLength(value);
		for (ELength constraint : source.getLength()) {
			try {
				int newValue = Integer.parseInt(constraint.getValue());
				type.setLength(newValue);
				break;
			} catch (Exception ex) {
				// ignore
			}
		}
		for (ETotalDigits constraint : source.getTotalDigits()) {
			try {
				int newValue = Integer.parseInt(constraint.getValue());
				type.setTotalDigits(newValue);
				break;
			} catch (Exception ex) {
				// ignore
			}
		}
		
		boolean numberType;
		switch (valueType) {
		case DECIMAL:
		case INTEGER:
			numberType = true;
			break;
		default:
			numberType = false;
		}
		
		if (numberType) {
			BigDecimal comp;
			comp = null;
			for (EMaxExclusive constraint : source.getMaxExclusive()) {
				try {
					BigDecimal newValue = new BigDecimal(constraint.getValue());
					if (comp == null) {
						comp = newValue;
					} else if (comp.compareTo(newValue) > 0) {
						comp = newValue;
					}
				} catch (Exception ex) {
					// ignore
				}
			}
			type.setMaxExclusive(comp);
			comp = null;
			for (EMaxInclusive constraint : source.getMaxInclusive()) {
				try {
					BigDecimal newValue = new BigDecimal(constraint.getValue());
					if (comp == null) {
						comp = newValue;
					} else if (comp.compareTo(newValue) > 0) {
						comp = newValue;
					}
				} catch (Exception ex) {
					// ignore
				}
			}
			type.setMaxInclusive(comp);
			comp = null;
			for (EMinExclusive constraint : source.getMinExclusive()) {
				try {
					BigDecimal newValue = new BigDecimal(constraint.getValue());
					if (comp == null) {
						comp = newValue;
					} else if (comp.compareTo(newValue) < 0) {
						comp = newValue;
					}
				} catch (Exception ex) {
					// ignore
				}
			}
			type.setMinExclusive(comp);
			comp = null;
			for (EMinInclusive constraint : source.getMinInclusive()) {
				try {
					String cValue = constraint.getValue();
					if (cValue == null) {
						continue;
					}
					BigDecimal newValue = new BigDecimal(cValue);
					if (comp == null) {
						comp = newValue;
					} else if (comp.compareTo(newValue) < 0) {
						comp = newValue;
					}
				} catch (Exception ex) {
					// ignore
				}
			}
			type.setMinInclusive(comp);
		}
	}

	private static void adaptOptionContainer(ESettingElement source,
			EAppOptionContainer container) {
		for (EOptionElement srcOption : source.getOptions()) {
			if (srcOption.getMap() != null) {
				EAppSettingOption option = EApplicationFactory.eINSTANCE
						.createEAppSettingOption();
				option.setRefValue(srcOption.getMap());
				option.setRelevant(buildAppExpression(srcOption.getRelevant()));
				container.getOptions().add(option);
			} else {
				EAppSettingOption option = EApplicationFactory.eINSTANCE
						.createEAppSettingOption();
				option.setLiteralValue(srcOption.getValue());
				option.setName(srcOption.getName());
				option.setRelevant(buildAppExpression(srcOption.getRelevant()));
				container.getOptions().add(option);
			}
		}
	}

	static boolean isNumberType(String type) {
		boolean ok = false;
		if (type == null || type.trim().length() == 0) {
			ok = true;
		} else if ("int".equalsIgnoreCase(type)) {
			ok = true;
		} else if ("integer".equalsIgnoreCase(type)) {
			ok = true;
		} else if ("real".equalsIgnoreCase(type)) {
			ok = true;
		}
		return ok;
	}

	public static void adaptDescription(EDescriptionContainer source,
			EAppDescriptionContainer target) {
		for (EDescriptionElement desc : source.getDescriptions()) {
			if (desc.getDescription() != null) {
				target.setDescription(desc.getDescription().trim());
				return;
			}
		}
	}

	public static void adaptIcon(EIconContainer source, EAppIconContainer target) {
		for (EIconElement desc : source.getIcons()) {
			if (desc.getHref() != null) {
				try {
					target.setIconURI(URI.createURI(desc.getHref().trim()));
					return;
				} catch (Exception ex) {
					// ignore
				}
			}
		}
	}

}
