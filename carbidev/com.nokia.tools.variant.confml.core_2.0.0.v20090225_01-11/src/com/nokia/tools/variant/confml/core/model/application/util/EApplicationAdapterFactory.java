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

import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.common.util.URI;
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
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.nokia.tools.variant.confml.core.model.application.EApplicationPackage
 * @generated
 */
public class EApplicationAdapterFactory extends AdapterFactoryImpl {
	/**
     * The cached model package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static EApplicationPackage modelPackage;

	/**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EApplicationAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = EApplicationPackage.eINSTANCE;
        }
    }

	/**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
	@Override
	public boolean isFactoryForType(Object object) {
        if (object == modelPackage) {
            return true;
        }
        if (object instanceof EObject) {
            return ((EObject)object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

	/**
     * The switch that delegates to the <code>createXXX</code> methods.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected EApplicationSwitch<Adapter> modelSwitch =
		new EApplicationSwitch<Adapter>() {
            @Override
            public Adapter caseEConfMLLayer(EConfMLLayer object) {
                return createEConfMLLayerAdapter();
            }
            @Override
            public Adapter caseEAppFeature(EAppFeature object) {
                return createEAppFeatureAdapter();
            }
            @Override
            public Adapter caseEAppSettingData(EAppSettingData object) {
                return createEAppSettingDataAdapter();
            }
            @Override
            public Adapter caseEAppViewEntry(Map.Entry<String, EAppView> object) {
                return createEAppViewEntryAdapter();
            }
            @Override
            public Adapter caseEAppView(EAppView object) {
                return createEAppViewAdapter();
            }
            @Override
            public Adapter caseEAppGroup(EAppGroup object) {
                return createEAppGroupAdapter();
            }
            @Override
            public Adapter caseEAppGroupContainer(EAppGroupContainer object) {
                return createEAppGroupContainerAdapter();
            }
            @Override
            public Adapter caseEAppSettingRef(EAppSettingRef object) {
                return createEAppSettingRefAdapter();
            }
            @Override
            public Adapter caseEAppSettingEntry(Map.Entry<String, EAppSetting> object) {
                return createEAppSettingEntryAdapter();
            }
            @Override
            public Adapter caseEAppFeatureEntry(Map.Entry<String, EAppFeature> object) {
                return createEAppFeatureEntryAdapter();
            }
            @Override
            public Adapter caseEAppSimpleData(EAppSimpleData object) {
                return createEAppSimpleDataAdapter();
            }
            @Override
            public Adapter caseEAppCompositeData(EAppCompositeData object) {
                return createEAppCompositeDataAdapter();
            }
            @Override
            public Adapter caseEAppSequenceData(EAppSequenceData object) {
                return createEAppSequenceDataAdapter();
            }
            @Override
            public Adapter caseEAppSequenceDataItem(EAppSequenceDataItem object) {
                return createEAppSequenceDataItemAdapter();
            }
            @Override
            public Adapter caseEAppDataContainer(EAppDataContainer object) {
                return createEAppDataContainerAdapter();
            }
            @Override
            public Adapter caseEAppResourceData(EAppResourceData object) {
                return createEAppResourceDataAdapter();
            }
            @Override
            public Adapter caseEAppExpression(EAppExpression object) {
                return createEAppExpressionAdapter();
            }
            @Override
            public Adapter caseEAppSettingType(EAppSettingType object) {
                return createEAppSettingTypeAdapter();
            }
            @Override
            public Adapter caseEAppSimpleType(EAppSimpleType object) {
                return createEAppSimpleTypeAdapter();
            }
            @Override
            public Adapter caseEAppSequenceType(EAppSequenceType object) {
                return createEAppSequenceTypeAdapter();
            }
            @Override
            public Adapter caseEAppCompositeType(EAppCompositeType object) {
                return createEAppCompositeTypeAdapter();
            }
            @Override
            public Adapter caseEAppTypeContainer(EAppTypeContainer object) {
                return createEAppTypeContainerAdapter();
            }
            @Override
            public Adapter caseEAppResourceType(EAppResourceType object) {
                return createEAppResourceTypeAdapter();
            }
            @Override
            public Adapter caseEAppSettingOption(EAppSettingOption object) {
                return createEAppSettingOptionAdapter();
            }
            @Override
            public Adapter caseEAppOptionContainer(EAppOptionContainer object) {
                return createEAppOptionContainerAdapter();
            }
            @Override
            public Adapter caseEAppSettingTypeEntry(Map.Entry<String, EAppSettingType> object) {
                return createEAppSettingTypeEntryAdapter();
            }
            @Override
            public Adapter caseEAppSetting(EAppSetting object) {
                return createEAppSettingAdapter();
            }
            @Override
            public Adapter caseEAppSubSettingDataEntry(Map.Entry<String, EAppSettingData> object) {
                return createEAppSubSettingDataEntryAdapter();
            }
            @Override
            public Adapter caseEAppRfsInfo(EAppRfsInfo object) {
                return createEAppRfsInfoAdapter();
            }
            @Override
            public Adapter caseEAppDescriptionContainer(EAppDescriptionContainer object) {
                return createEAppDescriptionContainerAdapter();
            }
            @Override
            public Adapter caseEAppIconContainer(EAppIconContainer object) {
                return createEAppIconContainerAdapter();
            }
            @Override
            public Adapter caseEAppNamedItem(EAppNamedItem object) {
                return createEAppNamedItemAdapter();
            }
            @Override
            public Adapter caseEAppPropertyContainer(EAppPropertyContainer object) {
                return createEAppPropertyContainerAdapter();
            }
            @Override
            public Adapter caseEAppProperty(EAppProperty object) {
                return createEAppPropertyAdapter();
            }
            @Override
            public Adapter caseEAppResourceEntry(Map.Entry<URI, URI> object) {
                return createEAppResourceEntryAdapter();
            }
            @Override
            public Adapter caseEConfigurationProject(EConfigurationProject object) {
                return createEConfigurationProjectAdapter();
            }
            @Override
            public Adapter caseEAppMetadata(EAppMetadata object) {
                return createEAppMetadataAdapter();
            }
            @Override
            public Adapter caseEAppIncludeElement(EAppIncludeElement object) {
                return createEAppIncludeElementAdapter();
            }
            @Override
            public Adapter caseESourceLocator(ESourceLocator object) {
                return createESourceLocatorAdapter();
            }
            @Override
            public Adapter defaultCase(EObject object) {
                return createEObjectAdapter();
            }
        };

	/**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param target the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
	@Override
	public Adapter createAdapter(Notifier target) {
        return modelSwitch.doSwitch((EObject)target);
    }


	/**
     * Creates a new adapter for an object of class '{@link com.nokia.tools.variant.confml.core.model.application.EConfMLLayer <em>EConf ML Layer</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.nokia.tools.variant.confml.core.model.application.EConfMLLayer
     * @generated
     */
	public Adapter createEConfMLLayerAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.nokia.tools.variant.confml.core.model.application.EAppFeature <em>EApp Feature</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppFeature
     * @generated
     */
	public Adapter createEAppFeatureAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.nokia.tools.variant.confml.core.model.application.EAppSettingData <em>EApp Setting Data</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppSettingData
     * @generated
     */
	public Adapter createEAppSettingDataAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>EApp View Entry</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see java.util.Map.Entry
     * @generated
     */
	public Adapter createEAppViewEntryAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.nokia.tools.variant.confml.core.model.application.EAppSetting <em>EApp Setting</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppSetting
     * @generated
     */
	public Adapter createEAppSettingAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>EApp Sub Setting Data Entry</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see java.util.Map.Entry
     * @generated
     */
	public Adapter createEAppSubSettingDataEntryAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.nokia.tools.variant.confml.core.model.application.EAppRfsInfo <em>EApp Rfs Info</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppRfsInfo
     * @generated
     */
	public Adapter createEAppRfsInfoAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.nokia.tools.variant.confml.core.model.application.EAppDescriptionContainer <em>EApp Description Container</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppDescriptionContainer
     * @generated
     */
	public Adapter createEAppDescriptionContainerAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.nokia.tools.variant.confml.core.model.application.EAppIconContainer <em>EApp Icon Container</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppIconContainer
     * @generated
     */
	public Adapter createEAppIconContainerAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.nokia.tools.variant.confml.core.model.application.EAppNamedItem <em>EApp Named Item</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppNamedItem
     * @generated
     */
	public Adapter createEAppNamedItemAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.nokia.tools.variant.confml.core.model.application.EAppPropertyContainer <em>EApp Property Container</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppPropertyContainer
     * @generated
     */
	public Adapter createEAppPropertyContainerAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.nokia.tools.variant.confml.core.model.application.EAppProperty <em>EApp Property</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppProperty
     * @generated
     */
	public Adapter createEAppPropertyAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>EApp Resource Entry</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see java.util.Map.Entry
     * @generated
     */
	public Adapter createEAppResourceEntryAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.nokia.tools.variant.confml.core.model.application.EConfigurationProject <em>EConfiguration Project</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.nokia.tools.variant.confml.core.model.application.EConfigurationProject
     * @generated
     */
	public Adapter createEConfigurationProjectAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.nokia.tools.variant.confml.core.model.application.EAppMetadata <em>EApp Metadata</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppMetadata
     * @generated
     */
	public Adapter createEAppMetadataAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.nokia.tools.variant.confml.core.model.application.EAppIncludeElement <em>EApp Include Element</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppIncludeElement
     * @generated
     */
	public Adapter createEAppIncludeElementAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.nokia.tools.variant.confml.core.model.core.ESourceLocator <em>ESource Locator</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.nokia.tools.variant.confml.core.model.core.ESourceLocator
     * @generated
     */
	public Adapter createESourceLocatorAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.nokia.tools.variant.confml.core.model.application.EAppView <em>EApp View</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppView
     * @generated
     */
	public Adapter createEAppViewAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.nokia.tools.variant.confml.core.model.application.EAppGroup <em>EApp Group</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppGroup
     * @generated
     */
	public Adapter createEAppGroupAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.nokia.tools.variant.confml.core.model.application.EAppGroupContainer <em>EApp Group Container</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppGroupContainer
     * @generated
     */
	public Adapter createEAppGroupContainerAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.nokia.tools.variant.confml.core.model.application.EAppSettingRef <em>EApp Setting Ref</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppSettingRef
     * @generated
     */
	public Adapter createEAppSettingRefAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>EApp Setting Entry</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see java.util.Map.Entry
     * @generated
     */
	public Adapter createEAppSettingEntryAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>EApp Feature Entry</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see java.util.Map.Entry
     * @generated
     */
	public Adapter createEAppFeatureEntryAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.nokia.tools.variant.confml.core.model.application.EAppSimpleData <em>EApp Simple Data</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppSimpleData
     * @generated
     */
	public Adapter createEAppSimpleDataAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.nokia.tools.variant.confml.core.model.application.EAppCompositeData <em>EApp Composite Data</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppCompositeData
     * @generated
     */
	public Adapter createEAppCompositeDataAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.nokia.tools.variant.confml.core.model.application.EAppSequenceData <em>EApp Sequence Data</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppSequenceData
     * @generated
     */
	public Adapter createEAppSequenceDataAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.nokia.tools.variant.confml.core.model.application.EAppSequenceDataItem <em>EApp Sequence Data Item</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppSequenceDataItem
     * @generated
     */
	public Adapter createEAppSequenceDataItemAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.nokia.tools.variant.confml.core.model.application.EAppDataContainer <em>EApp Data Container</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppDataContainer
     * @generated
     */
	public Adapter createEAppDataContainerAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.nokia.tools.variant.confml.core.model.application.EAppResourceData <em>EApp Resource Data</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppResourceData
     * @generated
     */
	public Adapter createEAppResourceDataAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.nokia.tools.variant.confml.core.model.application.EAppExpression <em>EApp Expression</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppExpression
     * @generated
     */
	public Adapter createEAppExpressionAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.nokia.tools.variant.confml.core.model.application.EAppSettingType <em>EApp Setting Type</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppSettingType
     * @generated
     */
	public Adapter createEAppSettingTypeAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.nokia.tools.variant.confml.core.model.application.EAppSimpleType <em>EApp Simple Type</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppSimpleType
     * @generated
     */
	public Adapter createEAppSimpleTypeAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.nokia.tools.variant.confml.core.model.application.EAppSequenceType <em>EApp Sequence Type</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppSequenceType
     * @generated
     */
	public Adapter createEAppSequenceTypeAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.nokia.tools.variant.confml.core.model.application.EAppCompositeType <em>EApp Composite Type</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppCompositeType
     * @generated
     */
	public Adapter createEAppCompositeTypeAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.nokia.tools.variant.confml.core.model.application.EAppTypeContainer <em>EApp Type Container</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppTypeContainer
     * @generated
     */
	public Adapter createEAppTypeContainerAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.nokia.tools.variant.confml.core.model.application.EAppResourceType <em>EApp Resource Type</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppResourceType
     * @generated
     */
	public Adapter createEAppResourceTypeAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.nokia.tools.variant.confml.core.model.application.EAppSettingOption <em>EApp Setting Option</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppSettingOption
     * @generated
     */
	public Adapter createEAppSettingOptionAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.nokia.tools.variant.confml.core.model.application.EAppOptionContainer <em>EApp Option Container</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppOptionContainer
     * @generated
     */
	public Adapter createEAppOptionContainerAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>EApp Setting Type Entry</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see java.util.Map.Entry
     * @generated
     */
	public Adapter createEAppSettingTypeEntryAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for the default case.
     * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @generated
     */
	public Adapter createEObjectAdapter() {
        return null;
    }

} //EApplicationAdapterFactory
