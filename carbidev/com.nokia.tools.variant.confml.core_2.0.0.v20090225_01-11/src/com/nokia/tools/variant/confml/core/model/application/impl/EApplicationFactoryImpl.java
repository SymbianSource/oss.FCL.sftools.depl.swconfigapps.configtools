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
 * Description: This file is part of com.nokia.tools.variant.confml.core component.
 */

package com.nokia.tools.variant.confml.core.model.application.impl;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.nokia.tools.variant.confml.core.model.application.EAppExpression;
import com.nokia.tools.variant.confml.core.model.application.EAppFeature;
import com.nokia.tools.variant.confml.core.model.application.EAppGroup;
import com.nokia.tools.variant.confml.core.model.application.EAppIncludeElement;
import com.nokia.tools.variant.confml.core.model.application.EAppProperty;
import com.nokia.tools.variant.confml.core.model.application.EAppResourceData;
import com.nokia.tools.variant.confml.core.model.application.EAppResourceType;
import com.nokia.tools.variant.confml.core.model.application.EAppRfsInfo;
import com.nokia.tools.variant.confml.core.model.application.EAppSequenceData;
import com.nokia.tools.variant.confml.core.model.application.EAppSequenceDataItem;
import com.nokia.tools.variant.confml.core.model.application.EAppSequenceType;
import com.nokia.tools.variant.confml.core.model.application.EAppSetting;
import com.nokia.tools.variant.confml.core.model.application.EAppSettingData;
import com.nokia.tools.variant.confml.core.model.application.EAppSettingOption;
import com.nokia.tools.variant.confml.core.model.application.EAppSettingRef;
import com.nokia.tools.variant.confml.core.model.application.EAppSettingType;
import com.nokia.tools.variant.confml.core.model.application.EAppSimpleData;
import com.nokia.tools.variant.confml.core.model.application.EAppSimpleType;
import com.nokia.tools.variant.confml.core.model.application.EAppValueType;
import com.nokia.tools.variant.confml.core.model.application.EAppView;
import com.nokia.tools.variant.confml.core.model.application.EApplicationFactory;
import com.nokia.tools.variant.confml.core.model.application.EApplicationPackage;
import com.nokia.tools.variant.confml.core.model.application.EConfMLLayer;
import com.nokia.tools.variant.confml.core.model.application.EConfigurationProject;
import com.nokia.tools.variant.confml.core.model.application.EStorageClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EApplicationFactoryImpl extends EFactoryImpl implements EApplicationFactory {
	/**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static EApplicationFactory init() {
        try {
            EApplicationFactory theEApplicationFactory = (EApplicationFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.nokia.com/xml/ns/confml-core/application"); 
            if (theEApplicationFactory != null) {
                return theEApplicationFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new EApplicationFactoryImpl();
    }

	/**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EApplicationFactoryImpl() {
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
            case EApplicationPackage.ECONF_ML_LAYER: return createEConfMLLayer();
            case EApplicationPackage.EAPP_FEATURE: return createEAppFeature();
            case EApplicationPackage.EAPP_VIEW_ENTRY: return (EObject)createEAppViewEntry();
            case EApplicationPackage.EAPP_VIEW: return createEAppView();
            case EApplicationPackage.EAPP_GROUP: return createEAppGroup();
            case EApplicationPackage.EAPP_SETTING_REF: return createEAppSettingRef();
            case EApplicationPackage.EAPP_SETTING_ENTRY: return (EObject)createEAppSettingEntry();
            case EApplicationPackage.EAPP_FEATURE_ENTRY: return (EObject)createEAppFeatureEntry();
            case EApplicationPackage.EAPP_SIMPLE_DATA: return createEAppSimpleData();
            case EApplicationPackage.EAPP_SEQUENCE_DATA: return createEAppSequenceData();
            case EApplicationPackage.EAPP_SEQUENCE_DATA_ITEM: return createEAppSequenceDataItem();
            case EApplicationPackage.EAPP_RESOURCE_DATA: return createEAppResourceData();
            case EApplicationPackage.EAPP_EXPRESSION: return createEAppExpression();
            case EApplicationPackage.EAPP_SIMPLE_TYPE: return createEAppSimpleType();
            case EApplicationPackage.EAPP_SEQUENCE_TYPE: return createEAppSequenceType();
            case EApplicationPackage.EAPP_RESOURCE_TYPE: return createEAppResourceType();
            case EApplicationPackage.EAPP_SETTING_OPTION: return createEAppSettingOption();
            case EApplicationPackage.EAPP_SETTING_TYPE_ENTRY: return (EObject)createEAppSettingTypeEntry();
            case EApplicationPackage.EAPP_SETTING: return createEAppSetting();
            case EApplicationPackage.EAPP_SUB_SETTING_DATA_ENTRY: return (EObject)createEAppSubSettingDataEntry();
            case EApplicationPackage.EAPP_RFS_INFO: return createEAppRfsInfo();
            case EApplicationPackage.EAPP_PROPERTY: return createEAppProperty();
            case EApplicationPackage.EAPP_RESOURCE_ENTRY: return (EObject)createEAppResourceEntry();
            case EApplicationPackage.ECONFIGURATION_PROJECT: return createEConfigurationProject();
            case EApplicationPackage.EAPP_INCLUDE_ELEMENT: return createEAppIncludeElement();
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
            case EApplicationPackage.EAPP_VALUE_TYPE:
                return createEAppValueTypeFromString(eDataType, initialValue);
            case EApplicationPackage.ESTORAGE_CLASS:
                return createEStorageClassFromString(eDataType, initialValue);
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
            case EApplicationPackage.EAPP_VALUE_TYPE:
                return convertEAppValueTypeToString(eDataType, instanceValue);
            case EApplicationPackage.ESTORAGE_CLASS:
                return convertEStorageClassToString(eDataType, instanceValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EConfMLLayer createEConfMLLayer() {
        EConfMLLayerImpl eConfMLLayer = new EConfMLLayerImpl();
        return eConfMLLayer;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAppFeature createEAppFeature() {
        EAppFeatureImpl eAppFeature = new EAppFeatureImpl();
        return eAppFeature;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Map.Entry<String, EAppView> createEAppViewEntry() {
        EAppViewEntryImpl eAppViewEntry = new EAppViewEntryImpl();
        return eAppViewEntry;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAppView createEAppView() {
        EAppViewImpl eAppView = new EAppViewImpl();
        return eAppView;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAppGroup createEAppGroup() {
        EAppGroupImpl eAppGroup = new EAppGroupImpl();
        return eAppGroup;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAppSettingRef createEAppSettingRef() {
        EAppSettingRefImpl eAppSettingRef = new EAppSettingRefImpl();
        return eAppSettingRef;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Map.Entry<String, EAppSetting> createEAppSettingEntry() {
        EAppSettingEntryImpl eAppSettingEntry = new EAppSettingEntryImpl();
        return eAppSettingEntry;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Map.Entry<String, EAppFeature> createEAppFeatureEntry() {
        EAppFeatureEntryImpl eAppFeatureEntry = new EAppFeatureEntryImpl();
        return eAppFeatureEntry;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAppSimpleData createEAppSimpleData() {
        EAppSimpleDataImpl eAppSimpleData = new EAppSimpleDataImpl();
        return eAppSimpleData;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAppSequenceData createEAppSequenceData() {
        EAppSequenceDataImpl eAppSequenceData = new EAppSequenceDataImpl();
        return eAppSequenceData;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAppSequenceDataItem createEAppSequenceDataItem() {
        EAppSequenceDataItemImpl eAppSequenceDataItem = new EAppSequenceDataItemImpl();
        return eAppSequenceDataItem;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAppResourceData createEAppResourceData() {
        EAppResourceDataImpl eAppResourceData = new EAppResourceDataImpl();
        return eAppResourceData;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAppExpression createEAppExpression() {
        EAppExpressionImpl eAppExpression = new EAppExpressionImpl();
        return eAppExpression;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAppSimpleType createEAppSimpleType() {
        EAppSimpleTypeImpl eAppSimpleType = new EAppSimpleTypeImpl();
        return eAppSimpleType;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAppSequenceType createEAppSequenceType() {
        EAppSequenceTypeImpl eAppSequenceType = new EAppSequenceTypeImpl();
        return eAppSequenceType;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAppResourceType createEAppResourceType() {
        EAppResourceTypeImpl eAppResourceType = new EAppResourceTypeImpl();
        return eAppResourceType;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAppSettingOption createEAppSettingOption() {
        EAppSettingOptionImpl eAppSettingOption = new EAppSettingOptionImpl();
        return eAppSettingOption;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Map.Entry<String, EAppSettingType> createEAppSettingTypeEntry() {
        EAppSettingTypeEntryImpl eAppSettingTypeEntry = new EAppSettingTypeEntryImpl();
        return eAppSettingTypeEntry;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAppSetting createEAppSetting() {
        EAppSettingImpl eAppSetting = new EAppSettingImpl();
        return eAppSetting;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Map.Entry<String, EAppSettingData> createEAppSubSettingDataEntry() {
        EAppSubSettingDataEntryImpl eAppSubSettingDataEntry = new EAppSubSettingDataEntryImpl();
        return eAppSubSettingDataEntry;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAppRfsInfo createEAppRfsInfo() {
        EAppRfsInfoImpl eAppRfsInfo = new EAppRfsInfoImpl();
        return eAppRfsInfo;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAppProperty createEAppProperty() {
        EAppPropertyImpl eAppProperty = new EAppPropertyImpl();
        return eAppProperty;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Map.Entry<URI, URI> createEAppResourceEntry() {
        EAppResourceEntryImpl eAppResourceEntry = new EAppResourceEntryImpl();
        return eAppResourceEntry;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EConfigurationProject createEConfigurationProject() {
        EConfigurationProjectImpl eConfigurationProject = new EConfigurationProjectImpl();
        return eConfigurationProject;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAppIncludeElement createEAppIncludeElement() {
        EAppIncludeElementImpl eAppIncludeElement = new EAppIncludeElementImpl();
        return eAppIncludeElement;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAppValueType createEAppValueTypeFromString(EDataType eDataType, String initialValue) {
        EAppValueType result = EAppValueType.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String convertEAppValueTypeToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EStorageClass createEStorageClassFromString(EDataType eDataType, String initialValue) {
        EStorageClass result = EStorageClass.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String convertEStorageClassToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EApplicationPackage getEApplicationPackage() {
        return (EApplicationPackage)getEPackage();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
	@Deprecated
	public static EApplicationPackage getPackage() {
        return EApplicationPackage.eINSTANCE;
    }

} //EApplicationFactoryImpl
