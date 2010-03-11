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

import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import com.nokia.tools.vct.common.appmodel.EAppDescriptionContainer;
import com.nokia.tools.vct.common.appmodel.EAppExpression;
import com.nokia.tools.vct.common.appmodel.EAppFeature;
import com.nokia.tools.vct.common.appmodel.EAppGroup;
import com.nokia.tools.vct.common.appmodel.EAppGroupContainer;
import com.nokia.tools.vct.common.appmodel.EAppIconContainer;
import com.nokia.tools.vct.common.appmodel.EAppOptionContainer;
import com.nokia.tools.vct.common.appmodel.EAppProperty;
import com.nokia.tools.vct.common.appmodel.EAppPropertyContainer;
import com.nokia.tools.vct.common.appmodel.EAppResourceType;
import com.nokia.tools.vct.common.appmodel.EAppSequenceType;
import com.nokia.tools.vct.common.appmodel.EAppSetting;
import com.nokia.tools.vct.common.appmodel.EAppSettingOption;
import com.nokia.tools.vct.common.appmodel.EAppSettingRef;
import com.nokia.tools.vct.common.appmodel.EAppSettingType;
import com.nokia.tools.vct.common.appmodel.EAppSimpleType;
import com.nokia.tools.vct.common.appmodel.EAppTypeConstraints;
import com.nokia.tools.vct.common.appmodel.EAppValueType;
import com.nokia.tools.vct.common.appmodel.EApplicationFactory;
import com.nokia.tools.vct.confml.model.confml2.EDescriptionContainer;
import com.nokia.tools.vct.confml.model.confml2.EDescriptionElement;
import com.nokia.tools.vct.confml.model.confml2.EGroup;
import com.nokia.tools.vct.confml.model.confml2.EIconContainer;
import com.nokia.tools.vct.confml.model.confml2.EIconElement;
import com.nokia.tools.vct.confml.model.confml2.ELocalPathElement;
import com.nokia.tools.vct.confml.model.confml2.EOptionElement;
import com.nokia.tools.vct.confml.model.confml2.EPropertyElement;
import com.nokia.tools.vct.confml.model.confml2.ESettingElement;
import com.nokia.tools.vct.confml.model.confml2.ETargetPathElement;
import com.nokia.tools.vct.confml.model.xsd.ELength;
import com.nokia.tools.vct.confml.model.xsd.EMaxExclusive;
import com.nokia.tools.vct.confml.model.xsd.EMaxInclusive;
import com.nokia.tools.vct.confml.model.xsd.EMaxLength;
import com.nokia.tools.vct.confml.model.xsd.EMinExclusive;
import com.nokia.tools.vct.confml.model.xsd.EMinInclusive;
import com.nokia.tools.vct.confml.model.xsd.EMinLength;
import com.nokia.tools.vct.confml.model.xsd.EPattern;
import com.nokia.tools.vct.confml.model.xsd.ETotalDigits;

public class ConfML2Helper {

	static void populateAppSetting(EAppSetting setting,
			ESettingElement settingType) {
		copyChildSettingPropertiesToParent(settingType);
		populateSettingType(setting, settingType);
	}

	private static void copyChildSettingPropertiesToParent(ESettingElement settingType) {
		// This stops properties of settings within sequence types being moved to the sequence setting.
		if("sequence".equals(settingType.getType())){
			for (EObject object : settingType.eContents()) {
				if (object instanceof ESettingElement) {
					copyChildSettingPropertiesToParent((ESettingElement)object);
				}
			}
			return;
		}
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
				properties.add((EPropertyElement) object);
			}
		}
		// This "addAll" will remove the properties from their parent and will 
		// add them to the settingType
		settingType.getProperties().addAll(properties);
	}

	static void populateSettingType(EAppSetting setting,
			ESettingElement settingType) {
		EAppSettingType appSettingType = adaptSettingType(settingType);
		setting.setTypeInfo(appSettingType);
	}

	static EAppSettingType adaptSettingType(ESettingElement settingType) {
		EAppSettingType appSettingType = null;

		String type = settingType.getType();
		if ("sequence".equalsIgnoreCase(type)) {
			appSettingType = adaptSequenceType(settingType);
		} else if ("file".equalsIgnoreCase(type)) {
			appSettingType = adaptResourceType(settingType);
		} else if ("folder".equalsIgnoreCase(type)) {
			appSettingType = adaptResourceType(settingType);
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
			// ;
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
			EAppGroupContainer appGroupContainer, EGroup group ) {

		for (EAppGroup existingGroup : appGroupContainer.getGroups()) {
			if (existingGroup.getName().equals(group.getName())) {
				return existingGroup;
			}
		}

		EAppGroup appGroup = appFactory.createEAppGroup();
		appGroup.setName(group.getName());
		adaptDescription(group, appGroup);
		adaptIcon(group, appGroup);
		appGroupContainer.getGroups().add(appGroup);
		return appGroup;
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

	static EAppSettingType adaptResourceType(ESettingElement source) {
		EAppResourceType type = EApplicationFactory.eINSTANCE
				.createEAppResourceType();
		adaptCommonTypeInfo(source, type);
		boolean isFile = "file".equalsIgnoreCase(source.getType());

		ELocalPathElement lpe = source.getLocalPath();
		if (lpe != null) {
			EAppSettingType type0 = adaptPathElement(lpe, isFile);
			type.getTypeMap().put("localPath", type0);
		}
		ETargetPathElement tpe = source.getTargetPath();
		if (tpe != null) {
			EAppSettingType type0 = adaptPathElement(tpe);
			type.getTypeMap().put("targetPath", type0);
		}

		for (ESettingElement subSetting : source.getSettings()) {
			EAppSettingType type0 = adaptSettingType(subSetting);
			type.getTypeMap().put(subSetting.getRef(), type0);
		}
		EAppSettingType localPath = type.getTypeMap().get("localPath");
		if (localPath == null) {
			EAppSimpleType tmp = EApplicationFactory.eINSTANCE
					.createEAppSimpleType();
			tmp.setType(isFile ? EAppValueType.LOCAL_FILE
					: EAppValueType.LOCAL_FOLDER);
			type.getTypeMap().put("localPath", tmp);
			adaptOptionContainer(source, tmp);
			localPath = tmp;
		}
		type.setLocalPath(localPath);
		EAppSettingType targetPath = type.getTypeMap().get("targetPath");
		if (targetPath == null) {
			EAppSimpleType tmp = EApplicationFactory.eINSTANCE
					.createEAppSimpleType();
			tmp.setType(EAppValueType.STRING);
			type.getTypeMap().put("targetPath", tmp);
			targetPath = tmp;
		}
		type.setTargetPath(targetPath);
		type.setFile(isFile);
		
		//Apply the file patterns
		//
		for (EPattern constraint : source.getPattern()) {
			type.getPattern().add(constraint.getValue());
		}
		return type;
	}

	private static EAppSettingType adaptPathElement(ELocalPathElement lpe,
			boolean isFile) {
		EAppSimpleType type0 = EApplicationFactory.eINSTANCE
				.createEAppSimpleType();
		type0.setConstraint(buildAppExpression(lpe.getConstraint()));
		type0.setName("locaPath");
		type0.setReadOnly("true".equalsIgnoreCase(lpe.getReadOnly()));
		type0.setRequired("true".equalsIgnoreCase(lpe.getRequired()));
		type0.setType(isFile ? EAppValueType.LOCAL_FILE
				: EAppValueType.LOCAL_FOLDER);

		if (lpe.getMap() != null) {
			EAppSettingOption option = EApplicationFactory.eINSTANCE
					.createEAppSettingOption();
			option.setRefValue(lpe.getMap());
			type0.getOptions().add(option);
		}

		adaptDescription(lpe, type0);
		adaptIcon(lpe, type0);
		// adaptLink(lpe, type0);
		
		// Apply the patterns
		//
		for (EPattern constraint : lpe.getPattern()) {
			type0.getPattern().add(constraint.getValue());
		}
		return type0;
	}

	private static EAppSettingType adaptPathElement(ETargetPathElement tpe) {
		EAppSimpleType type0 = EApplicationFactory.eINSTANCE
				.createEAppSimpleType();
		type0.setConstraint(buildAppExpression(tpe.getConstraint()));
		type0.setName("targetPath");
		type0.setReadOnly("true".equalsIgnoreCase(tpe.getReadOnly()));
		type0.setRequired("true".equalsIgnoreCase(tpe.getRequired()));

		if (tpe.getMap() != null) {
			EAppSettingOption option = EApplicationFactory.eINSTANCE
					.createEAppSettingOption();
			option.setRefValue(tpe.getMap());
			type0.getOptions().add(option);
		}

		type0.setType(EAppValueType.STRING);
		adaptDescription(tpe, type0);
		adaptIcon(tpe, type0);
		// adaptLink(lpe, type0);
		
		// Apply the patterns
		//
		for (EPattern constraint : tpe.getPattern()) {
			type0.getPattern().add(constraint.getValue());
		}
		return type0;
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
			EObject container = source.eContainer();
			boolean deduced = false;
			if (container instanceof ESettingElement) {
				ESettingElement parent = (ESettingElement) container;
				String parentType = parent.getType();
				String ref = source.getRef();
				if ("file".equalsIgnoreCase(parentType)) {
					if ("localPath".equals(ref)) {
						type.setType(EAppValueType.LOCAL_FILE);
						deduced = true;
					} else if ("targetPath".equals(ref)) {
						type.setType(EAppValueType.STRING);
						deduced = true;
					}

				} else if ("folder".equalsIgnoreCase(parentType)) {
					if ("localPath".equals(ref)) {
						type.setType(EAppValueType.LOCAL_FOLDER);
						deduced = true;
					} else if ("targetPath".equals(ref)) {
						type.setType(EAppValueType.STRING);
						deduced = true;
					}

				}
			}

			if (!deduced) {
				type.setType(EAppValueType.INTEGER);
			}
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
		} else if ("date".equalsIgnoreCase(typeString)) {
			type.setType(EAppValueType.DATE);
		} else if ("dateTime".equalsIgnoreCase(typeString)) {
			type.setType(EAppValueType.DATETIME);
		} else if ("time".equalsIgnoreCase(typeString)) {
			type.setType(EAppValueType.TIME);
		} else if ("duration".equalsIgnoreCase(typeString)) {
			type.setType(EAppValueType.DURATION);
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
		populateConstraints(source, type, valueType);

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

	private static void populateConstraints(ESettingElement source,
			EAppTypeConstraints type, EAppValueType valueType) {
		Object comp = null;
		EDataType dataType = null;

		String typeLiteral = source.getType();
		if (typeLiteral != null) {
			typeLiteral = typeLiteral.trim();
		}

		if (typeLiteral == null || typeLiteral.length() == 0) {
			typeLiteral = "int";
		}

		switch (valueType) {
		case INTEGER:
		case DECIMAL:
			dataType = XMLTypePackage.Literals.DECIMAL;
			break;
		case DATE:
			dataType = XMLTypePackage.Literals.DATE;
			break;
		case DATETIME:
			dataType = XMLTypePackage.Literals.DATE_TIME;
			break;
		case TIME:
			dataType = XMLTypePackage.Literals.TIME;
			break;
		case DURATION:
			dataType = XMLTypePackage.Literals.DURATION;
			break;
		}
		
		if (dataType != null) {

			XMLTypeFactory factory = XMLTypeFactory.eINSTANCE;

			for (EMaxExclusive constraint : source.getMaxExclusive()) {
				try {
					Object newValue = factory.createFromString(dataType,
							constraint.getValue());
					if (comp == null) {
						comp = newValue;
					} else if (doCompare(comp, newValue) == DatatypeConstants.GREATER) {
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
					Object newValue = factory.createFromString(dataType,
							constraint.getValue());
					if (comp == null) {
						comp = newValue;
					} else if (doCompare(comp, newValue) == DatatypeConstants.GREATER) {
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
					Object newValue = factory.createFromString(dataType,
							constraint.getValue());
					if (comp == null) {
						comp = newValue;
					} else if (doCompare(comp, newValue) == DatatypeConstants.LESSER) {
						comp = newValue;
					}
				} catch (Exception ex) {
					// ignore
					ex.printStackTrace();
				}
			}
			type.setMinExclusive(comp);
			comp = null;
			for (EMinInclusive constraint : source.getMinInclusive()) {
				try {
					Object newValue = factory.createFromString(dataType,
							constraint.getValue());
					if (comp == null) {
						comp = newValue;
					} else if (doCompare(comp, newValue) == DatatypeConstants.LESSER) {
						comp = newValue;
					}
				} catch (Exception ex) {
					// ignore
				}
			}
			type.setMinInclusive(comp);
		}
	}

	private static int doCompare(Object comp, Object newValue) {
		if (comp instanceof BigDecimal && newValue instanceof BigDecimal) {
			int result = ((BigDecimal) comp).compareTo((BigDecimal) newValue);

			return result > 0 ? DatatypeConstants.GREATER
					: result < 0 ? DatatypeConstants.LESSER
							: DatatypeConstants.EQUAL;
		}
		if (comp instanceof XMLGregorianCalendar
				&& newValue instanceof XMLGregorianCalendar) {
			XMLGregorianCalendar c0 = (XMLGregorianCalendar) comp;
			XMLGregorianCalendar c1 = (XMLGregorianCalendar) newValue;
			return c0.compare(c1);
		}
		if (comp instanceof Duration && newValue instanceof Duration) {
			Duration c0 = (Duration) comp;
			Duration c1 = (Duration) newValue;
			return c0.compare(c1);
		}
		return DatatypeConstants.INDETERMINATE;
	}

	static boolean isNumberType(String type) {
		boolean ok = false;
		if ("int".equalsIgnoreCase(type)) {
			ok = true;
		} else if ("integer".equalsIgnoreCase(type)) {
			ok = true;
		} else if ("real".equalsIgnoreCase(type)) {
			ok = true;
		}
		return ok;
	}

	static boolean isDateType(String type) {
		return "date".equalsIgnoreCase(type)
				|| "dateTime".equalsIgnoreCase(type)
				|| "time".equalsIgnoreCase(type)
				|| "duration".equalsIgnoreCase(type);
	}

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
			if (appGroup instanceof EAppGroup) {
				//Check if setting ref already created for this setting
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
