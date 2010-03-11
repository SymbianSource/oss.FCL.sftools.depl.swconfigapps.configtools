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

import com.nokia.tools.vct.common.appmodel.*;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

import com.nokia.tools.vct.common.appmodel.EAppCompositeData;
import com.nokia.tools.vct.common.appmodel.EAppCompositeType;
import com.nokia.tools.vct.common.appmodel.EAppDataContainer;
import com.nokia.tools.vct.common.appmodel.EAppDescriptionContainer;
import com.nokia.tools.vct.common.appmodel.EAppExpression;
import com.nokia.tools.vct.common.appmodel.EAppFeature;
import com.nokia.tools.vct.common.appmodel.EAppGroup;
import com.nokia.tools.vct.common.appmodel.EAppGroupContainer;
import com.nokia.tools.vct.common.appmodel.EAppIconContainer;
import com.nokia.tools.vct.common.appmodel.EAppIncludeElement;
import com.nokia.tools.vct.common.appmodel.EAppMetadata;
import com.nokia.tools.vct.common.appmodel.EAppNamedItem;
import com.nokia.tools.vct.common.appmodel.EAppOptionContainer;
import com.nokia.tools.vct.common.appmodel.EAppProperty;
import com.nokia.tools.vct.common.appmodel.EAppPropertyContainer;
import com.nokia.tools.vct.common.appmodel.EAppResourceData;
import com.nokia.tools.vct.common.appmodel.EAppResourceType;
import com.nokia.tools.vct.common.appmodel.EAppRfsInfo;
import com.nokia.tools.vct.common.appmodel.EAppSequenceData;
import com.nokia.tools.vct.common.appmodel.EAppSequenceDataItem;
import com.nokia.tools.vct.common.appmodel.EAppSequenceType;
import com.nokia.tools.vct.common.appmodel.EAppSetting;
import com.nokia.tools.vct.common.appmodel.EAppSettingData;
import com.nokia.tools.vct.common.appmodel.EAppSettingOption;
import com.nokia.tools.vct.common.appmodel.EAppSettingRef;
import com.nokia.tools.vct.common.appmodel.EAppSettingType;
import com.nokia.tools.vct.common.appmodel.EAppSimpleData;
import com.nokia.tools.vct.common.appmodel.EAppSimpleType;
import com.nokia.tools.vct.common.appmodel.EAppTypeConstraints;
import com.nokia.tools.vct.common.appmodel.EAppTypeContainer;
import com.nokia.tools.vct.common.appmodel.EAppView;
import com.nokia.tools.vct.common.appmodel.EApplicationPackage;
import com.nokia.tools.vct.common.appmodel.EConfMLLayer;
import com.nokia.tools.vct.common.appmodel.EConfigurationProject;
import com.nokia.tools.vct.common.appmodel.ESourceLocator;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage
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
			public Adapter caseEAppTypeConstraints(EAppTypeConstraints object) {
				return createEAppTypeConstraintsAdapter();
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
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.common.appmodel.EConfMLLayer <em>EConf ML Layer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.common.appmodel.EConfMLLayer
	 * @generated
	 */
	public Adapter createEConfMLLayerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.common.appmodel.EAppFeature <em>EApp Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.common.appmodel.EAppFeature
	 * @generated
	 */
	public Adapter createEAppFeatureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.common.appmodel.EAppSettingData <em>EApp Setting Data</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.common.appmodel.EAppSettingData
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
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.common.appmodel.EAppSetting <em>EApp Setting</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.common.appmodel.EAppSetting
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
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.common.appmodel.EAppRfsInfo <em>EApp Rfs Info</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.common.appmodel.EAppRfsInfo
	 * @generated
	 */
	public Adapter createEAppRfsInfoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.common.appmodel.EAppDescriptionContainer <em>EApp Description Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.common.appmodel.EAppDescriptionContainer
	 * @generated
	 */
	public Adapter createEAppDescriptionContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.common.appmodel.EAppIconContainer <em>EApp Icon Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.common.appmodel.EAppIconContainer
	 * @generated
	 */
	public Adapter createEAppIconContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.common.appmodel.EAppNamedItem <em>EApp Named Item</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.common.appmodel.EAppNamedItem
	 * @generated
	 */
	public Adapter createEAppNamedItemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.common.appmodel.EAppPropertyContainer <em>EApp Property Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.common.appmodel.EAppPropertyContainer
	 * @generated
	 */
	public Adapter createEAppPropertyContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.common.appmodel.EAppProperty <em>EApp Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.common.appmodel.EAppProperty
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
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.common.appmodel.EConfigurationProject <em>EConfiguration Project</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.common.appmodel.EConfigurationProject
	 * @generated
	 */
	public Adapter createEConfigurationProjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.common.appmodel.EAppMetadata <em>EApp Metadata</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.common.appmodel.EAppMetadata
	 * @generated
	 */
	public Adapter createEAppMetadataAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.common.appmodel.EAppIncludeElement <em>EApp Include Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.common.appmodel.EAppIncludeElement
	 * @generated
	 */
	public Adapter createEAppIncludeElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.common.appmodel.EAppTypeConstraints <em>EApp Type Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.common.appmodel.EAppTypeConstraints
	 * @generated
	 */
	public Adapter createEAppTypeConstraintsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.common.appmodel.ESourceLocator <em>ESource Locator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.common.appmodel.ESourceLocator
	 * @generated
	 */
	public Adapter createESourceLocatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.common.appmodel.EAppView <em>EApp View</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.common.appmodel.EAppView
	 * @generated
	 */
	public Adapter createEAppViewAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.common.appmodel.EAppGroup <em>EApp Group</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.common.appmodel.EAppGroup
	 * @generated
	 */
	public Adapter createEAppGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.common.appmodel.EAppGroupContainer <em>EApp Group Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.common.appmodel.EAppGroupContainer
	 * @generated
	 */
	public Adapter createEAppGroupContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.common.appmodel.EAppSettingRef <em>EApp Setting Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.common.appmodel.EAppSettingRef
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
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.common.appmodel.EAppSimpleData <em>EApp Simple Data</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.common.appmodel.EAppSimpleData
	 * @generated
	 */
	public Adapter createEAppSimpleDataAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.common.appmodel.EAppCompositeData <em>EApp Composite Data</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.common.appmodel.EAppCompositeData
	 * @generated
	 */
	public Adapter createEAppCompositeDataAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.common.appmodel.EAppSequenceData <em>EApp Sequence Data</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.common.appmodel.EAppSequenceData
	 * @generated
	 */
	public Adapter createEAppSequenceDataAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.common.appmodel.EAppSequenceDataItem <em>EApp Sequence Data Item</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.common.appmodel.EAppSequenceDataItem
	 * @generated
	 */
	public Adapter createEAppSequenceDataItemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.common.appmodel.EAppDataContainer <em>EApp Data Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.common.appmodel.EAppDataContainer
	 * @generated
	 */
	public Adapter createEAppDataContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.common.appmodel.EAppResourceData <em>EApp Resource Data</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.common.appmodel.EAppResourceData
	 * @generated
	 */
	public Adapter createEAppResourceDataAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.common.appmodel.EAppExpression <em>EApp Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.common.appmodel.EAppExpression
	 * @generated
	 */
	public Adapter createEAppExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.common.appmodel.EAppSettingType <em>EApp Setting Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.common.appmodel.EAppSettingType
	 * @generated
	 */
	public Adapter createEAppSettingTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.common.appmodel.EAppSimpleType <em>EApp Simple Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.common.appmodel.EAppSimpleType
	 * @generated
	 */
	public Adapter createEAppSimpleTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.common.appmodel.EAppSequenceType <em>EApp Sequence Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.common.appmodel.EAppSequenceType
	 * @generated
	 */
	public Adapter createEAppSequenceTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.common.appmodel.EAppCompositeType <em>EApp Composite Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.common.appmodel.EAppCompositeType
	 * @generated
	 */
	public Adapter createEAppCompositeTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.common.appmodel.EAppTypeContainer <em>EApp Type Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.common.appmodel.EAppTypeContainer
	 * @generated
	 */
	public Adapter createEAppTypeContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.common.appmodel.EAppResourceType <em>EApp Resource Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.common.appmodel.EAppResourceType
	 * @generated
	 */
	public Adapter createEAppResourceTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.common.appmodel.EAppSettingOption <em>EApp Setting Option</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.common.appmodel.EAppSettingOption
	 * @generated
	 */
	public Adapter createEAppSettingOptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.common.appmodel.EAppOptionContainer <em>EApp Option Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.common.appmodel.EAppOptionContainer
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
