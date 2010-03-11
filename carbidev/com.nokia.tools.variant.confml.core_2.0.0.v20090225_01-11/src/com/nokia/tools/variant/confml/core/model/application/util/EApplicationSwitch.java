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

package com.nokia.tools.variant.confml.core.model.application.util;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import com.nokia.tools.variant.confml.core.model.application.EAppCompositeData;
import com.nokia.tools.variant.confml.core.model.application.EAppCompositeType;
import com.nokia.tools.variant.confml.core.model.application.EAppDataContainer;
import com.nokia.tools.variant.confml.core.model.application.EAppDescriptionContainer;
import com.nokia.tools.variant.confml.core.model.application.EAppExpression;
import com.nokia.tools.variant.confml.core.model.application.EAppFeature;
import com.nokia.tools.variant.confml.core.model.application.EAppGroup;
import com.nokia.tools.variant.confml.core.model.application.EAppGroupContainer;
import com.nokia.tools.variant.confml.core.model.application.EAppIconContainer;
import com.nokia.tools.variant.confml.core.model.application.EAppIncludeElement;
import com.nokia.tools.variant.confml.core.model.application.EAppMetadata;
import com.nokia.tools.variant.confml.core.model.application.EAppNamedItem;
import com.nokia.tools.variant.confml.core.model.application.EAppOptionContainer;
import com.nokia.tools.variant.confml.core.model.application.EAppProperty;
import com.nokia.tools.variant.confml.core.model.application.EAppPropertyContainer;
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
import com.nokia.tools.variant.confml.core.model.application.EAppTypeContainer;
import com.nokia.tools.variant.confml.core.model.application.EAppView;
import com.nokia.tools.variant.confml.core.model.application.EApplicationPackage;
import com.nokia.tools.variant.confml.core.model.application.EConfMLLayer;
import com.nokia.tools.variant.confml.core.model.application.EConfigurationProject;
import com.nokia.tools.variant.confml.core.model.core.ESourceLocator;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see com.nokia.tools.variant.confml.core.model.application.EApplicationPackage
 * @generated
 */
public class EApplicationSwitch<T> {
	/**
     * The cached model package
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static EApplicationPackage modelPackage;

	/**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EApplicationSwitch() {
        if (modelPackage == null) {
            modelPackage = EApplicationPackage.eINSTANCE;
        }
    }

	/**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
	public T doSwitch(EObject theEObject) {
        return doSwitch(theEObject.eClass(), theEObject);
    }

	/**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
        if (theEClass.eContainer() == modelPackage) {
            return doSwitch(theEClass.getClassifierID(), theEObject);
        }
        else {
            List<EClass> eSuperTypes = theEClass.getESuperTypes();
            return
                eSuperTypes.isEmpty() ?
                    defaultCase(theEObject) :
                    doSwitch(eSuperTypes.get(0), theEObject);
        }
    }

	/**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
	protected T doSwitch(int classifierID, EObject theEObject) {
        switch (classifierID) {
            case EApplicationPackage.ECONF_ML_LAYER: {
                EConfMLLayer eConfMLLayer = (EConfMLLayer)theEObject;
                T result = caseEConfMLLayer(eConfMLLayer);
                if (result == null) result = caseEAppMetadata(eConfMLLayer);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case EApplicationPackage.EAPP_FEATURE: {
                EAppFeature eAppFeature = (EAppFeature)theEObject;
                T result = caseEAppFeature(eAppFeature);
                if (result == null) result = caseEAppDescriptionContainer(eAppFeature);
                if (result == null) result = caseEAppIconContainer(eAppFeature);
                if (result == null) result = caseEAppNamedItem(eAppFeature);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case EApplicationPackage.EAPP_SETTING_DATA: {
                EAppSettingData eAppSettingData = (EAppSettingData)theEObject;
                T result = caseEAppSettingData(eAppSettingData);
                if (result == null) result = caseESourceLocator(eAppSettingData);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case EApplicationPackage.EAPP_VIEW_ENTRY: {
                @SuppressWarnings("unchecked") Map.Entry<String, EAppView> eAppViewEntry = (Map.Entry<String, EAppView>)theEObject;
                T result = caseEAppViewEntry(eAppViewEntry);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case EApplicationPackage.EAPP_VIEW: {
                EAppView eAppView = (EAppView)theEObject;
                T result = caseEAppView(eAppView);
                if (result == null) result = caseEAppGroupContainer(eAppView);
                if (result == null) result = caseEAppDescriptionContainer(eAppView);
                if (result == null) result = caseEAppIconContainer(eAppView);
                if (result == null) result = caseEAppNamedItem(eAppView);
                if (result == null) result = caseESourceLocator(eAppView);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case EApplicationPackage.EAPP_GROUP: {
                EAppGroup eAppGroup = (EAppGroup)theEObject;
                T result = caseEAppGroup(eAppGroup);
                if (result == null) result = caseEAppGroupContainer(eAppGroup);
                if (result == null) result = caseEAppDescriptionContainer(eAppGroup);
                if (result == null) result = caseEAppIconContainer(eAppGroup);
                if (result == null) result = caseEAppNamedItem(eAppGroup);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case EApplicationPackage.EAPP_GROUP_CONTAINER: {
                EAppGroupContainer eAppGroupContainer = (EAppGroupContainer)theEObject;
                T result = caseEAppGroupContainer(eAppGroupContainer);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case EApplicationPackage.EAPP_SETTING_REF: {
                EAppSettingRef eAppSettingRef = (EAppSettingRef)theEObject;
                T result = caseEAppSettingRef(eAppSettingRef);
                if (result == null) result = caseEAppPropertyContainer(eAppSettingRef);
                if (result == null) result = caseEAppOptionContainer(eAppSettingRef);
                if (result == null) result = caseEAppDescriptionContainer(eAppSettingRef);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case EApplicationPackage.EAPP_SETTING_ENTRY: {
                @SuppressWarnings("unchecked") Map.Entry<String, EAppSetting> eAppSettingEntry = (Map.Entry<String, EAppSetting>)theEObject;
                T result = caseEAppSettingEntry(eAppSettingEntry);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case EApplicationPackage.EAPP_FEATURE_ENTRY: {
                @SuppressWarnings("unchecked") Map.Entry<String, EAppFeature> eAppFeatureEntry = (Map.Entry<String, EAppFeature>)theEObject;
                T result = caseEAppFeatureEntry(eAppFeatureEntry);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case EApplicationPackage.EAPP_SIMPLE_DATA: {
                EAppSimpleData eAppSimpleData = (EAppSimpleData)theEObject;
                T result = caseEAppSimpleData(eAppSimpleData);
                if (result == null) result = caseEAppSettingData(eAppSimpleData);
                if (result == null) result = caseESourceLocator(eAppSimpleData);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case EApplicationPackage.EAPP_COMPOSITE_DATA: {
                EAppCompositeData eAppCompositeData = (EAppCompositeData)theEObject;
                T result = caseEAppCompositeData(eAppCompositeData);
                if (result == null) result = caseEAppSettingData(eAppCompositeData);
                if (result == null) result = caseEAppDataContainer(eAppCompositeData);
                if (result == null) result = caseESourceLocator(eAppCompositeData);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case EApplicationPackage.EAPP_SEQUENCE_DATA: {
                EAppSequenceData eAppSequenceData = (EAppSequenceData)theEObject;
                T result = caseEAppSequenceData(eAppSequenceData);
                if (result == null) result = caseEAppSettingData(eAppSequenceData);
                if (result == null) result = caseESourceLocator(eAppSequenceData);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case EApplicationPackage.EAPP_SEQUENCE_DATA_ITEM: {
                EAppSequenceDataItem eAppSequenceDataItem = (EAppSequenceDataItem)theEObject;
                T result = caseEAppSequenceDataItem(eAppSequenceDataItem);
                if (result == null) result = caseEAppDataContainer(eAppSequenceDataItem);
                if (result == null) result = caseESourceLocator(eAppSequenceDataItem);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case EApplicationPackage.EAPP_DATA_CONTAINER: {
                EAppDataContainer eAppDataContainer = (EAppDataContainer)theEObject;
                T result = caseEAppDataContainer(eAppDataContainer);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case EApplicationPackage.EAPP_RESOURCE_DATA: {
                EAppResourceData eAppResourceData = (EAppResourceData)theEObject;
                T result = caseEAppResourceData(eAppResourceData);
                if (result == null) result = caseEAppCompositeData(eAppResourceData);
                if (result == null) result = caseEAppSettingData(eAppResourceData);
                if (result == null) result = caseEAppDataContainer(eAppResourceData);
                if (result == null) result = caseESourceLocator(eAppResourceData);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case EApplicationPackage.EAPP_EXPRESSION: {
                EAppExpression eAppExpression = (EAppExpression)theEObject;
                T result = caseEAppExpression(eAppExpression);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case EApplicationPackage.EAPP_SETTING_TYPE: {
                EAppSettingType eAppSettingType = (EAppSettingType)theEObject;
                T result = caseEAppSettingType(eAppSettingType);
                if (result == null) result = caseEAppDescriptionContainer(eAppSettingType);
                if (result == null) result = caseEAppIconContainer(eAppSettingType);
                if (result == null) result = caseEAppNamedItem(eAppSettingType);
                if (result == null) result = caseEAppPropertyContainer(eAppSettingType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case EApplicationPackage.EAPP_SIMPLE_TYPE: {
                EAppSimpleType eAppSimpleType = (EAppSimpleType)theEObject;
                T result = caseEAppSimpleType(eAppSimpleType);
                if (result == null) result = caseEAppSettingType(eAppSimpleType);
                if (result == null) result = caseEAppOptionContainer(eAppSimpleType);
                if (result == null) result = caseEAppDescriptionContainer(eAppSimpleType);
                if (result == null) result = caseEAppIconContainer(eAppSimpleType);
                if (result == null) result = caseEAppNamedItem(eAppSimpleType);
                if (result == null) result = caseEAppPropertyContainer(eAppSimpleType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case EApplicationPackage.EAPP_SEQUENCE_TYPE: {
                EAppSequenceType eAppSequenceType = (EAppSequenceType)theEObject;
                T result = caseEAppSequenceType(eAppSequenceType);
                if (result == null) result = caseEAppTypeContainer(eAppSequenceType);
                if (result == null) result = caseEAppSettingType(eAppSequenceType);
                if (result == null) result = caseEAppDescriptionContainer(eAppSequenceType);
                if (result == null) result = caseEAppIconContainer(eAppSequenceType);
                if (result == null) result = caseEAppNamedItem(eAppSequenceType);
                if (result == null) result = caseEAppPropertyContainer(eAppSequenceType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case EApplicationPackage.EAPP_COMPOSITE_TYPE: {
                EAppCompositeType eAppCompositeType = (EAppCompositeType)theEObject;
                T result = caseEAppCompositeType(eAppCompositeType);
                if (result == null) result = caseEAppTypeContainer(eAppCompositeType);
                if (result == null) result = caseEAppSettingType(eAppCompositeType);
                if (result == null) result = caseEAppDescriptionContainer(eAppCompositeType);
                if (result == null) result = caseEAppIconContainer(eAppCompositeType);
                if (result == null) result = caseEAppNamedItem(eAppCompositeType);
                if (result == null) result = caseEAppPropertyContainer(eAppCompositeType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case EApplicationPackage.EAPP_TYPE_CONTAINER: {
                EAppTypeContainer eAppTypeContainer = (EAppTypeContainer)theEObject;
                T result = caseEAppTypeContainer(eAppTypeContainer);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case EApplicationPackage.EAPP_RESOURCE_TYPE: {
                EAppResourceType eAppResourceType = (EAppResourceType)theEObject;
                T result = caseEAppResourceType(eAppResourceType);
                if (result == null) result = caseEAppCompositeType(eAppResourceType);
                if (result == null) result = caseEAppTypeContainer(eAppResourceType);
                if (result == null) result = caseEAppSettingType(eAppResourceType);
                if (result == null) result = caseEAppDescriptionContainer(eAppResourceType);
                if (result == null) result = caseEAppIconContainer(eAppResourceType);
                if (result == null) result = caseEAppNamedItem(eAppResourceType);
                if (result == null) result = caseEAppPropertyContainer(eAppResourceType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case EApplicationPackage.EAPP_SETTING_OPTION: {
                EAppSettingOption eAppSettingOption = (EAppSettingOption)theEObject;
                T result = caseEAppSettingOption(eAppSettingOption);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case EApplicationPackage.EAPP_OPTION_CONTAINER: {
                EAppOptionContainer eAppOptionContainer = (EAppOptionContainer)theEObject;
                T result = caseEAppOptionContainer(eAppOptionContainer);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case EApplicationPackage.EAPP_SETTING_TYPE_ENTRY: {
                @SuppressWarnings("unchecked") Map.Entry<String, EAppSettingType> eAppSettingTypeEntry = (Map.Entry<String, EAppSettingType>)theEObject;
                T result = caseEAppSettingTypeEntry(eAppSettingTypeEntry);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case EApplicationPackage.EAPP_SETTING: {
                EAppSetting eAppSetting = (EAppSetting)theEObject;
                T result = caseEAppSetting(eAppSetting);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case EApplicationPackage.EAPP_SUB_SETTING_DATA_ENTRY: {
                @SuppressWarnings("unchecked") Map.Entry<String, EAppSettingData> eAppSubSettingDataEntry = (Map.Entry<String, EAppSettingData>)theEObject;
                T result = caseEAppSubSettingDataEntry(eAppSubSettingDataEntry);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case EApplicationPackage.EAPP_RFS_INFO: {
                EAppRfsInfo eAppRfsInfo = (EAppRfsInfo)theEObject;
                T result = caseEAppRfsInfo(eAppRfsInfo);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case EApplicationPackage.EAPP_DESCRIPTION_CONTAINER: {
                EAppDescriptionContainer eAppDescriptionContainer = (EAppDescriptionContainer)theEObject;
                T result = caseEAppDescriptionContainer(eAppDescriptionContainer);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case EApplicationPackage.EAPP_ICON_CONTAINER: {
                EAppIconContainer eAppIconContainer = (EAppIconContainer)theEObject;
                T result = caseEAppIconContainer(eAppIconContainer);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case EApplicationPackage.EAPP_NAMED_ITEM: {
                EAppNamedItem eAppNamedItem = (EAppNamedItem)theEObject;
                T result = caseEAppNamedItem(eAppNamedItem);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case EApplicationPackage.EAPP_PROPERTY_CONTAINER: {
                EAppPropertyContainer eAppPropertyContainer = (EAppPropertyContainer)theEObject;
                T result = caseEAppPropertyContainer(eAppPropertyContainer);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case EApplicationPackage.EAPP_PROPERTY: {
                EAppProperty eAppProperty = (EAppProperty)theEObject;
                T result = caseEAppProperty(eAppProperty);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case EApplicationPackage.EAPP_RESOURCE_ENTRY: {
                @SuppressWarnings("unchecked") Map.Entry<URI, URI> eAppResourceEntry = (Map.Entry<URI, URI>)theEObject;
                T result = caseEAppResourceEntry(eAppResourceEntry);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case EApplicationPackage.ECONFIGURATION_PROJECT: {
                EConfigurationProject eConfigurationProject = (EConfigurationProject)theEObject;
                T result = caseEConfigurationProject(eConfigurationProject);
                if (result == null) result = caseEAppMetadata(eConfigurationProject);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case EApplicationPackage.EAPP_METADATA: {
                EAppMetadata eAppMetadata = (EAppMetadata)theEObject;
                T result = caseEAppMetadata(eAppMetadata);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case EApplicationPackage.EAPP_INCLUDE_ELEMENT: {
                EAppIncludeElement eAppIncludeElement = (EAppIncludeElement)theEObject;
                T result = caseEAppIncludeElement(eAppIncludeElement);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            default: return defaultCase(theEObject);
        }
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>EConf ML Layer</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EConf ML Layer</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseEConfMLLayer(EConfMLLayer object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>EApp Feature</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EApp Feature</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseEAppFeature(EAppFeature object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>EApp Setting Data</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EApp Setting Data</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseEAppSettingData(EAppSettingData object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>EApp View Entry</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EApp View Entry</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseEAppViewEntry(Map.Entry<String, EAppView> object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>EApp Setting</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EApp Setting</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseEAppSetting(EAppSetting object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>EApp Sub Setting Data Entry</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EApp Sub Setting Data Entry</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseEAppSubSettingDataEntry(Map.Entry<String, EAppSettingData> object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>EApp Rfs Info</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EApp Rfs Info</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseEAppRfsInfo(EAppRfsInfo object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>EApp Description Container</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EApp Description Container</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseEAppDescriptionContainer(EAppDescriptionContainer object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>EApp Icon Container</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EApp Icon Container</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseEAppIconContainer(EAppIconContainer object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>EApp Named Item</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EApp Named Item</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseEAppNamedItem(EAppNamedItem object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>EApp Property Container</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EApp Property Container</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseEAppPropertyContainer(EAppPropertyContainer object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>EApp Property</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EApp Property</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseEAppProperty(EAppProperty object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>EApp Resource Entry</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EApp Resource Entry</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseEAppResourceEntry(Map.Entry<URI, URI> object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>EConfiguration Project</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EConfiguration Project</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseEConfigurationProject(EConfigurationProject object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>EApp Metadata</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EApp Metadata</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseEAppMetadata(EAppMetadata object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>EApp Include Element</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EApp Include Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseEAppIncludeElement(EAppIncludeElement object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>ESource Locator</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>ESource Locator</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseESourceLocator(ESourceLocator object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>EApp View</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EApp View</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseEAppView(EAppView object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>EApp Group</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EApp Group</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseEAppGroup(EAppGroup object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>EApp Group Container</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EApp Group Container</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseEAppGroupContainer(EAppGroupContainer object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>EApp Setting Ref</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EApp Setting Ref</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseEAppSettingRef(EAppSettingRef object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>EApp Setting Entry</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EApp Setting Entry</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseEAppSettingEntry(Map.Entry<String, EAppSetting> object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>EApp Feature Entry</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EApp Feature Entry</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseEAppFeatureEntry(Map.Entry<String, EAppFeature> object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>EApp Simple Data</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EApp Simple Data</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseEAppSimpleData(EAppSimpleData object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>EApp Composite Data</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EApp Composite Data</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseEAppCompositeData(EAppCompositeData object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>EApp Sequence Data</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EApp Sequence Data</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseEAppSequenceData(EAppSequenceData object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>EApp Sequence Data Item</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EApp Sequence Data Item</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseEAppSequenceDataItem(EAppSequenceDataItem object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>EApp Data Container</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EApp Data Container</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseEAppDataContainer(EAppDataContainer object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>EApp Resource Data</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EApp Resource Data</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseEAppResourceData(EAppResourceData object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>EApp Expression</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EApp Expression</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseEAppExpression(EAppExpression object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>EApp Setting Type</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EApp Setting Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseEAppSettingType(EAppSettingType object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>EApp Simple Type</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EApp Simple Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseEAppSimpleType(EAppSimpleType object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>EApp Sequence Type</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EApp Sequence Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseEAppSequenceType(EAppSequenceType object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>EApp Composite Type</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EApp Composite Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseEAppCompositeType(EAppCompositeType object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>EApp Type Container</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EApp Type Container</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseEAppTypeContainer(EAppTypeContainer object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>EApp Resource Type</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EApp Resource Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseEAppResourceType(EAppResourceType object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>EApp Setting Option</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EApp Setting Option</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseEAppSettingOption(EAppSettingOption object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>EApp Option Container</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EApp Option Container</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseEAppOptionContainer(EAppOptionContainer object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>EApp Setting Type Entry</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EApp Setting Type Entry</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseEAppSettingTypeEntry(Map.Entry<String, EAppSettingType> object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
	public T defaultCase(EObject object) {
        return null;
    }

} //EApplicationSwitch
