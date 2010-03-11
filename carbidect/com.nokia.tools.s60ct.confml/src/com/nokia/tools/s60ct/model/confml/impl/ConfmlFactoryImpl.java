/*
* Copyright (c) 2007 Nokia Corporation and/or its subsidiary(-ies). 
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
package com.nokia.tools.s60ct.model.confml.impl;

import com.nokia.tools.s60ct.model.confml.*;
import java.net.URI;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.nokia.tools.s60ct.model.confml.ConfmlFactory;
import com.nokia.tools.s60ct.model.confml.ConfmlPackage;
import com.nokia.tools.s60ct.model.confml.EExtensionPolicy;
import com.nokia.tools.s60ct.model.confml.EFeature;
import com.nokia.tools.s60ct.model.confml.EItemSetting;
import com.nokia.tools.s60ct.model.confml.EOption;
import com.nokia.tools.s60ct.model.confml.EOptionMap;
import com.nokia.tools.s60ct.model.confml.EProperty;
import com.nokia.tools.s60ct.model.confml.EResourceKind;
import com.nokia.tools.s60ct.model.confml.EResourceSetting;
import com.nokia.tools.s60ct.model.confml.EResourceValue;
import com.nokia.tools.s60ct.model.confml.ESequenceSetting;
import com.nokia.tools.s60ct.model.confml.ESequenceValue;
import com.nokia.tools.s60ct.model.confml.ESequenceValueItem;
import com.nokia.tools.s60ct.model.confml.ESettingValueType;
import com.nokia.tools.s60ct.model.confml.ESimpleSetting;
import com.nokia.tools.s60ct.model.confml.ESimpleValue;
import com.nokia.tools.s60ct.model.confml.ESubSettingValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ConfmlFactoryImpl extends EFactoryImpl implements ConfmlFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ConfmlFactory init() {
		try {
			ConfmlFactory theConfmlFactory = (ConfmlFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.nokia.com/xml/ns/s60ct-confml"); 
			if (theConfmlFactory != null) {
				return theConfmlFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ConfmlFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfmlFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ConfmlPackage.EFEATURE: return createEFeature();
			case ConfmlPackage.ESIMPLE_SETTING: return createESimpleSetting();
			case ConfmlPackage.ESEQUENCE_SETTING: return createESequenceSetting();
			case ConfmlPackage.EITEM_SETTING: return createEItemSetting();
			case ConfmlPackage.ESUB_SETTING_VALUE: return createESubSettingValue();
			case ConfmlPackage.ERESOURCE_SETTING: return createEResourceSetting();
			case ConfmlPackage.ESIMPLE_VALUE: return createESimpleValue();
			case ConfmlPackage.ESEQUENCE_VALUE: return createESequenceValue();
			case ConfmlPackage.ESEQUENCE_VALUE_ITEM: return createESequenceValueItem();
			case ConfmlPackage.ERESOURCE_VALUE: return createEResourceValue();
			case ConfmlPackage.EPROPERTY: return createEProperty();
			case ConfmlPackage.EOPTION_MAP: return createEOptionMap();
			case ConfmlPackage.EOPTION: return createEOption();
			case ConfmlPackage.EVALUE_EDITOR_DOCUMENT: return createEValueEditorDocument();
			case ConfmlPackage.PATTERN: return createPattern();
			case ConfmlPackage.VIEW: return createView();
			case ConfmlPackage.EGROUP: return createEGroup();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case ConfmlPackage.ESETTING_VALUE_TYPE:
				return createESettingValueTypeFromString(eDataType, initialValue);
			case ConfmlPackage.EEXTENSION_POLICY:
				return createEExtensionPolicyFromString(eDataType, initialValue);
			case ConfmlPackage.ERESOURCE_KIND:
				return createEResourceKindFromString(eDataType, initialValue);
			case ConfmlPackage.EJAVA_URI:
				return createEJavaURIFromString(eDataType, initialValue);
			case ConfmlPackage.ECORE_URI:
				return createEcore_URIFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case ConfmlPackage.ESETTING_VALUE_TYPE:
				return convertESettingValueTypeToString(eDataType, instanceValue);
			case ConfmlPackage.EEXTENSION_POLICY:
				return convertEExtensionPolicyToString(eDataType, instanceValue);
			case ConfmlPackage.ERESOURCE_KIND:
				return convertEResourceKindToString(eDataType, instanceValue);
			case ConfmlPackage.EJAVA_URI:
				return convertEJavaURIToString(eDataType, instanceValue);
			case ConfmlPackage.ECORE_URI:
				return convertEcore_URIToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EFeature createEFeature() {
		EFeatureImpl eFeature = new EFeatureImpl();
		return eFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ESimpleSetting createESimpleSetting() {
		ESimpleSettingImpl eSimpleSetting = new ESimpleSettingImpl();
		return eSimpleSetting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ESequenceSetting createESequenceSetting() {
		ESequenceSettingImpl eSequenceSetting = new ESequenceSettingImpl();
		return eSequenceSetting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EItemSetting createEItemSetting() {
		EItemSettingImpl eItemSetting = new EItemSettingImpl();
		return eItemSetting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ESubSettingValue createESubSettingValue() {
		ESubSettingValueImpl eSubSettingValue = new ESubSettingValueImpl();
		return eSubSettingValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EResourceSetting createEResourceSetting() {
		EResourceSettingImpl eResourceSetting = new EResourceSettingImpl();
		return eResourceSetting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ESimpleValue createESimpleValue() {
		ESimpleValueImpl eSimpleValue = new ESimpleValueImpl();
		return eSimpleValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ESequenceValue createESequenceValue() {
		ESequenceValueImpl eSequenceValue = new ESequenceValueImpl();
		return eSequenceValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ESequenceValueItem createESequenceValueItem() {
		ESequenceValueItemImpl eSequenceValueItem = new ESequenceValueItemImpl();
		return eSequenceValueItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EResourceValue createEResourceValue() {
		EResourceValueImpl eResourceValue = new EResourceValueImpl();
		return eResourceValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EProperty createEProperty() {
		EPropertyImpl eProperty = new EPropertyImpl();
		return eProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOptionMap createEOptionMap() {
		EOptionMapImpl eOptionMap = new EOptionMapImpl();
		return eOptionMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOption createEOption() {
		EOptionImpl eOption = new EOptionImpl();
		return eOption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EValueEditorDocument createEValueEditorDocument() {
		EValueEditorDocumentImpl eValueEditorDocument = new EValueEditorDocumentImpl();
		return eValueEditorDocument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pattern createPattern() {
		PatternImpl pattern = new PatternImpl();
		return pattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public View createView() {
		ViewImpl view = new ViewImpl();
		return view;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EGroup createEGroup() {
		EGroupImpl eGroup = new EGroupImpl();
		return eGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ESettingValueType createESettingValueTypeFromString(EDataType eDataType, String initialValue) {
		ESettingValueType result = ESettingValueType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertESettingValueTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EExtensionPolicy createEExtensionPolicyFromString(EDataType eDataType, String initialValue) {
		EExtensionPolicy result = EExtensionPolicy.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEExtensionPolicyToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EResourceKind createEResourceKindFromString(EDataType eDataType, String initialValue) {
		EResourceKind result = EResourceKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEResourceKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public URI createEJavaURIFromString(EDataType eDataType, String initialValue) {
		return (URI)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEJavaURIToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.emf.common.util.URI createEcore_URIFromString(EDataType eDataType, String initialValue) {
		return (org.eclipse.emf.common.util.URI)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEcore_URIToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfmlPackage getConfmlPackage() {
		return (ConfmlPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ConfmlPackage getPackage() {
		return ConfmlPackage.eINSTANCE;
	}

} //ConfmlFactoryImpl
