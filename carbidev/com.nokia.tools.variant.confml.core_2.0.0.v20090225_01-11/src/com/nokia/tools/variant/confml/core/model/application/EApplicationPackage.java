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

package com.nokia.tools.variant.confml.core.model.application;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import com.nokia.tools.variant.confml.core.model.core.EConfmlRootPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.nokia.tools.variant.confml.core.model.application.EApplicationFactory
 * @model kind="package"
 * @generated
 */
public interface EApplicationPackage extends EPackage {
	/**
     * The package name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNAME = "application";

	/**
     * The package namespace URI.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_URI = "http://www.nokia.com/xml/ns/confml-core/application";

	/**
     * The package namespace name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_PREFIX = "a";

	/**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	EApplicationPackage eINSTANCE = com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl.init();

	/**
     * The meta object id for the '{@link com.nokia.tools.variant.confml.core.model.application.EAppMetadata <em>EApp Metadata</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.nokia.tools.variant.confml.core.model.application.EAppMetadata
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppMetadata()
     * @generated
     */
	int EAPP_METADATA = 36;

	/**
     * The feature id for the '<em><b>Date</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_METADATA__DATE = 0;

	/**
     * The feature id for the '<em><b>Owner</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_METADATA__OWNER = 1;

	/**
     * The feature id for the '<em><b>Editor</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_METADATA__EDITOR = 2;

	/**
     * The feature id for the '<em><b>Status</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_METADATA__STATUS = 3;

	/**
     * The feature id for the '<em><b>Version</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_METADATA__VERSION = 4;

	/**
     * The feature id for the '<em><b>Platform</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_METADATA__PLATFORM = 5;

	/**
     * The feature id for the '<em><b>Product</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_METADATA__PRODUCT = 6;

	/**
     * The feature id for the '<em><b>Release</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_METADATA__RELEASE = 7;

	/**
     * The feature id for the '<em><b>Customer</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_METADATA__CUSTOMER = 8;

	/**
     * The feature id for the '<em><b>Origin</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_METADATA__ORIGIN = 9;

	/**
     * The feature id for the '<em><b>Target</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_METADATA__TARGET = 10;

	/**
     * The feature id for the '<em><b>Meta Id</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_METADATA__META_ID = 11;

	/**
     * The number of structural features of the '<em>EApp Metadata</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_METADATA_FEATURE_COUNT = 12;

	/**
     * The meta object id for the '{@link com.nokia.tools.variant.confml.core.model.application.impl.EConfMLLayerImpl <em>EConf ML Layer</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EConfMLLayerImpl
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEConfMLLayer()
     * @generated
     */
	int ECONF_ML_LAYER = 0;

	/**
     * The feature id for the '<em><b>Date</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ECONF_ML_LAYER__DATE = EAPP_METADATA__DATE;

	/**
     * The feature id for the '<em><b>Owner</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ECONF_ML_LAYER__OWNER = EAPP_METADATA__OWNER;

	/**
     * The feature id for the '<em><b>Editor</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ECONF_ML_LAYER__EDITOR = EAPP_METADATA__EDITOR;

	/**
     * The feature id for the '<em><b>Status</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ECONF_ML_LAYER__STATUS = EAPP_METADATA__STATUS;

	/**
     * The feature id for the '<em><b>Version</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ECONF_ML_LAYER__VERSION = EAPP_METADATA__VERSION;

	/**
     * The feature id for the '<em><b>Platform</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ECONF_ML_LAYER__PLATFORM = EAPP_METADATA__PLATFORM;

	/**
     * The feature id for the '<em><b>Product</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ECONF_ML_LAYER__PRODUCT = EAPP_METADATA__PRODUCT;

	/**
     * The feature id for the '<em><b>Release</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ECONF_ML_LAYER__RELEASE = EAPP_METADATA__RELEASE;

	/**
     * The feature id for the '<em><b>Customer</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ECONF_ML_LAYER__CUSTOMER = EAPP_METADATA__CUSTOMER;

	/**
     * The feature id for the '<em><b>Origin</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ECONF_ML_LAYER__ORIGIN = EAPP_METADATA__ORIGIN;

	/**
     * The feature id for the '<em><b>Target</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ECONF_ML_LAYER__TARGET = EAPP_METADATA__TARGET;

	/**
     * The feature id for the '<em><b>Meta Id</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ECONF_ML_LAYER__META_ID = EAPP_METADATA__META_ID;

	/**
     * The feature id for the '<em><b>Features</b></em>' map.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ECONF_ML_LAYER__FEATURES = EAPP_METADATA_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Views</b></em>' map.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ECONF_ML_LAYER__VIEWS = EAPP_METADATA_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Resource Map</b></em>' map.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ECONF_ML_LAYER__RESOURCE_MAP = EAPP_METADATA_FEATURE_COUNT + 2;

	/**
     * The feature id for the '<em><b>Document Map</b></em>' map.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ECONF_ML_LAYER__DOCUMENT_MAP = EAPP_METADATA_FEATURE_COUNT + 3;

	/**
     * The feature id for the '<em><b>Impl Map</b></em>' map.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ECONF_ML_LAYER__IMPL_MAP = EAPP_METADATA_FEATURE_COUNT + 4;

	/**
     * The feature id for the '<em><b>Layer Files</b></em>' attribute list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ECONF_ML_LAYER__LAYER_FILES = EAPP_METADATA_FEATURE_COUNT + 5;

	/**
     * The feature id for the '<em><b>Parent</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ECONF_ML_LAYER__PARENT = EAPP_METADATA_FEATURE_COUNT + 6;

	/**
     * The feature id for the '<em><b>Root Confml</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ECONF_ML_LAYER__ROOT_CONFML = EAPP_METADATA_FEATURE_COUNT + 7;

	/**
     * The feature id for the '<em><b>Layer URI</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ECONF_ML_LAYER__LAYER_URI = EAPP_METADATA_FEATURE_COUNT + 8;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ECONF_ML_LAYER__NAME = EAPP_METADATA_FEATURE_COUNT + 9;

	/**
     * The feature id for the '<em><b>Includes</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ECONF_ML_LAYER__INCLUDES = EAPP_METADATA_FEATURE_COUNT + 10;

	/**
     * The number of structural features of the '<em>EConf ML Layer</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ECONF_ML_LAYER_FEATURE_COUNT = EAPP_METADATA_FEATURE_COUNT + 11;

	/**
     * The meta object id for the '{@link com.nokia.tools.variant.confml.core.model.application.EAppDescriptionContainer <em>EApp Description Container</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.nokia.tools.variant.confml.core.model.application.EAppDescriptionContainer
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppDescriptionContainer()
     * @generated
     */
	int EAPP_DESCRIPTION_CONTAINER = 29;

	/**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_DESCRIPTION_CONTAINER__DESCRIPTION = 0;

	/**
     * The number of structural features of the '<em>EApp Description Container</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_DESCRIPTION_CONTAINER_FEATURE_COUNT = 1;

	/**
     * The meta object id for the '{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppFeatureImpl <em>EApp Feature</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EAppFeatureImpl
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppFeature()
     * @generated
     */
	int EAPP_FEATURE = 1;

	/**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_FEATURE__DESCRIPTION = EAPP_DESCRIPTION_CONTAINER__DESCRIPTION;

	/**
     * The feature id for the '<em><b>Icon Descriptor</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_FEATURE__ICON_DESCRIPTOR = EAPP_DESCRIPTION_CONTAINER_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Icon Title</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_FEATURE__ICON_TITLE = EAPP_DESCRIPTION_CONTAINER_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Icon URI</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_FEATURE__ICON_URI = EAPP_DESCRIPTION_CONTAINER_FEATURE_COUNT + 2;

	/**
     * The meta object id for the '{@link com.nokia.tools.variant.confml.core.model.application.EAppSettingData <em>EApp Setting Data</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.nokia.tools.variant.confml.core.model.application.EAppSettingData
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppSettingData()
     * @generated
     */
	int EAPP_SETTING_DATA = 2;

	/**
     * The meta object id for the '{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppSettingImpl <em>EApp Setting</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EAppSettingImpl
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppSetting()
     * @generated
     */
	int EAPP_SETTING = 26;

	/**
     * The meta object id for the '{@link com.nokia.tools.variant.confml.core.model.application.EAppGroupContainer <em>EApp Group Container</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.nokia.tools.variant.confml.core.model.application.EAppGroupContainer
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppGroupContainer()
     * @generated
     */
	int EAPP_GROUP_CONTAINER = 6;

	/**
     * The meta object id for the '{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppViewImpl <em>EApp View</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EAppViewImpl
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppView()
     * @generated
     */
	int EAPP_VIEW = 4;

	/**
     * The meta object id for the '{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppGroupImpl <em>EApp Group</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EAppGroupImpl
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppGroup()
     * @generated
     */
	int EAPP_GROUP = 5;

	/**
     * The meta object id for the '{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppSettingRefImpl <em>EApp Setting Ref</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EAppSettingRefImpl
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppSettingRef()
     * @generated
     */
	int EAPP_SETTING_REF = 7;

	/**
     * The meta object id for the '{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppSettingEntryImpl <em>EApp Setting Entry</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EAppSettingEntryImpl
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppSettingEntry()
     * @generated
     */
	int EAPP_SETTING_ENTRY = 8;

	/**
     * The meta object id for the '{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppFeatureEntryImpl <em>EApp Feature Entry</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EAppFeatureEntryImpl
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppFeatureEntry()
     * @generated
     */
	int EAPP_FEATURE_ENTRY = 9;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_FEATURE__NAME = EAPP_DESCRIPTION_CONTAINER_FEATURE_COUNT + 3;

	/**
     * The feature id for the '<em><b>Settings</b></em>' map.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_FEATURE__SETTINGS = EAPP_DESCRIPTION_CONTAINER_FEATURE_COUNT + 4;

	/**
     * The feature id for the '<em><b>Relevant</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_FEATURE__RELEVANT = EAPP_DESCRIPTION_CONTAINER_FEATURE_COUNT + 5;

	/**
     * The feature id for the '<em><b>Ref</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_FEATURE__REF = EAPP_DESCRIPTION_CONTAINER_FEATURE_COUNT + 6;

	/**
     * The number of structural features of the '<em>EApp Feature</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_FEATURE_FEATURE_COUNT = EAPP_DESCRIPTION_CONTAINER_FEATURE_COUNT + 7;

	/**
     * The feature id for the '<em><b>Uri</b></em>' attribute list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SETTING_DATA__URI = EConfmlRootPackage.ESOURCE_LOCATOR__URI;

	/**
     * The feature id for the '<em><b>Type Info</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SETTING_DATA__TYPE_INFO = EConfmlRootPackage.ESOURCE_LOCATOR_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>EApp Setting Data</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SETTING_DATA_FEATURE_COUNT = EConfmlRootPackage.ESOURCE_LOCATOR_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppViewEntryImpl <em>EApp View Entry</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EAppViewEntryImpl
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppViewEntry()
     * @generated
     */
	int EAPP_VIEW_ENTRY = 3;

	/**
     * The feature id for the '<em><b>Key</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_VIEW_ENTRY__KEY = 0;

	/**
     * The feature id for the '<em><b>Value</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_VIEW_ENTRY__VALUE = 1;

	/**
     * The number of structural features of the '<em>EApp View Entry</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_VIEW_ENTRY_FEATURE_COUNT = 2;

	/**
     * The feature id for the '<em><b>Groups</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_GROUP_CONTAINER__GROUPS = 0;

	/**
     * The number of structural features of the '<em>EApp Group Container</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_GROUP_CONTAINER_FEATURE_COUNT = 1;

	/**
     * The feature id for the '<em><b>Groups</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_VIEW__GROUPS = EAPP_GROUP_CONTAINER__GROUPS;

	/**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_VIEW__DESCRIPTION = EAPP_GROUP_CONTAINER_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Icon Descriptor</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_VIEW__ICON_DESCRIPTOR = EAPP_GROUP_CONTAINER_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Icon Title</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_VIEW__ICON_TITLE = EAPP_GROUP_CONTAINER_FEATURE_COUNT + 2;

	/**
     * The feature id for the '<em><b>Icon URI</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_VIEW__ICON_URI = EAPP_GROUP_CONTAINER_FEATURE_COUNT + 3;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_VIEW__NAME = EAPP_GROUP_CONTAINER_FEATURE_COUNT + 4;

	/**
     * The feature id for the '<em><b>Uri</b></em>' attribute list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_VIEW__URI = EAPP_GROUP_CONTAINER_FEATURE_COUNT + 5;

	/**
     * The number of structural features of the '<em>EApp View</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_VIEW_FEATURE_COUNT = EAPP_GROUP_CONTAINER_FEATURE_COUNT + 6;

	/**
     * The feature id for the '<em><b>Groups</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_GROUP__GROUPS = EAPP_GROUP_CONTAINER__GROUPS;

	/**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_GROUP__DESCRIPTION = EAPP_GROUP_CONTAINER_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Icon Descriptor</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_GROUP__ICON_DESCRIPTOR = EAPP_GROUP_CONTAINER_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Icon Title</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_GROUP__ICON_TITLE = EAPP_GROUP_CONTAINER_FEATURE_COUNT + 2;

	/**
     * The feature id for the '<em><b>Icon URI</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_GROUP__ICON_URI = EAPP_GROUP_CONTAINER_FEATURE_COUNT + 3;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_GROUP__NAME = EAPP_GROUP_CONTAINER_FEATURE_COUNT + 4;

	/**
     * The feature id for the '<em><b>Settings</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_GROUP__SETTINGS = EAPP_GROUP_CONTAINER_FEATURE_COUNT + 5;

	/**
     * The number of structural features of the '<em>EApp Group</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_GROUP_FEATURE_COUNT = EAPP_GROUP_CONTAINER_FEATURE_COUNT + 6;

	/**
     * The meta object id for the '{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppSimpleDataImpl <em>EApp Simple Data</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EAppSimpleDataImpl
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppSimpleData()
     * @generated
     */
	int EAPP_SIMPLE_DATA = 10;

	/**
     * The meta object id for the '{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppCompositeDataImpl <em>EApp Composite Data</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EAppCompositeDataImpl
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppCompositeData()
     * @generated
     */
	int EAPP_COMPOSITE_DATA = 11;

	/**
     * The meta object id for the '{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppSequenceDataImpl <em>EApp Sequence Data</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EAppSequenceDataImpl
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppSequenceData()
     * @generated
     */
	int EAPP_SEQUENCE_DATA = 12;

	/**
     * The meta object id for the '{@link com.nokia.tools.variant.confml.core.model.application.EAppDataContainer <em>EApp Data Container</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.nokia.tools.variant.confml.core.model.application.EAppDataContainer
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppDataContainer()
     * @generated
     */
	int EAPP_DATA_CONTAINER = 14;

	/**
     * The meta object id for the '{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppSequenceDataItemImpl <em>EApp Sequence Data Item</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EAppSequenceDataItemImpl
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppSequenceDataItem()
     * @generated
     */
	int EAPP_SEQUENCE_DATA_ITEM = 13;

	/**
     * The meta object id for the '{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppResourceDataImpl <em>EApp Resource Data</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EAppResourceDataImpl
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppResourceData()
     * @generated
     */
	int EAPP_RESOURCE_DATA = 15;

	/**
     * The meta object id for the '{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppExpressionImpl <em>EApp Expression</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EAppExpressionImpl
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppExpression()
     * @generated
     */
	int EAPP_EXPRESSION = 16;

	/**
     * The meta object id for the '{@link com.nokia.tools.variant.confml.core.model.application.EAppSettingType <em>EApp Setting Type</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.nokia.tools.variant.confml.core.model.application.EAppSettingType
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppSettingType()
     * @generated
     */
	int EAPP_SETTING_TYPE = 17;

	/**
     * The meta object id for the '{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppSimpleTypeImpl <em>EApp Simple Type</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EAppSimpleTypeImpl
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppSimpleType()
     * @generated
     */
	int EAPP_SIMPLE_TYPE = 18;

	/**
     * The meta object id for the '{@link com.nokia.tools.variant.confml.core.model.application.EAppTypeContainer <em>EApp Type Container</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.nokia.tools.variant.confml.core.model.application.EAppTypeContainer
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppTypeContainer()
     * @generated
     */
	int EAPP_TYPE_CONTAINER = 21;

	/**
     * The meta object id for the '{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppSequenceTypeImpl <em>EApp Sequence Type</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EAppSequenceTypeImpl
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppSequenceType()
     * @generated
     */
	int EAPP_SEQUENCE_TYPE = 19;

	/**
     * The meta object id for the '{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppCompositeTypeImpl <em>EApp Composite Type</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EAppCompositeTypeImpl
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppCompositeType()
     * @generated
     */
	int EAPP_COMPOSITE_TYPE = 20;

	/**
     * The meta object id for the '{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppResourceTypeImpl <em>EApp Resource Type</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EAppResourceTypeImpl
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppResourceType()
     * @generated
     */
	int EAPP_RESOURCE_TYPE = 22;

	/**
     * The meta object id for the '{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppSettingOptionImpl <em>EApp Setting Option</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EAppSettingOptionImpl
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppSettingOption()
     * @generated
     */
	int EAPP_SETTING_OPTION = 23;

	/**
     * The meta object id for the '{@link com.nokia.tools.variant.confml.core.model.application.EAppOptionContainer <em>EApp Option Container</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.nokia.tools.variant.confml.core.model.application.EAppOptionContainer
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppOptionContainer()
     * @generated
     */
	int EAPP_OPTION_CONTAINER = 24;

	/**
     * The meta object id for the '{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppSettingTypeEntryImpl <em>EApp Setting Type Entry</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EAppSettingTypeEntryImpl
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppSettingTypeEntry()
     * @generated
     */
	int EAPP_SETTING_TYPE_ENTRY = 25;

	/**
     * The meta object id for the '{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppSubSettingDataEntryImpl <em>EApp Sub Setting Data Entry</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EAppSubSettingDataEntryImpl
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppSubSettingDataEntry()
     * @generated
     */
	int EAPP_SUB_SETTING_DATA_ENTRY = 27;

	/**
     * The meta object id for the '{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppRfsInfoImpl <em>EApp Rfs Info</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EAppRfsInfoImpl
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppRfsInfo()
     * @generated
     */
	int EAPP_RFS_INFO = 28;

	/**
     * The meta object id for the '{@link com.nokia.tools.variant.confml.core.model.application.EAppIconContainer <em>EApp Icon Container</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.nokia.tools.variant.confml.core.model.application.EAppIconContainer
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppIconContainer()
     * @generated
     */
	int EAPP_ICON_CONTAINER = 30;

	/**
     * The meta object id for the '{@link com.nokia.tools.variant.confml.core.model.application.EAppNamedItem <em>EApp Named Item</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.nokia.tools.variant.confml.core.model.application.EAppNamedItem
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppNamedItem()
     * @generated
     */
	int EAPP_NAMED_ITEM = 31;

	/**
     * The meta object id for the '{@link com.nokia.tools.variant.confml.core.model.application.EAppPropertyContainer <em>EApp Property Container</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.nokia.tools.variant.confml.core.model.application.EAppPropertyContainer
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppPropertyContainer()
     * @generated
     */
	int EAPP_PROPERTY_CONTAINER = 32;

	/**
     * The feature id for the '<em><b>Properties</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_PROPERTY_CONTAINER__PROPERTIES = 0;

	/**
     * The number of structural features of the '<em>EApp Property Container</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_PROPERTY_CONTAINER_FEATURE_COUNT = 1;

	/**
     * The feature id for the '<em><b>Properties</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SETTING_REF__PROPERTIES = EAPP_PROPERTY_CONTAINER__PROPERTIES;

	/**
     * The feature id for the '<em><b>Options</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SETTING_REF__OPTIONS = EAPP_PROPERTY_CONTAINER_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SETTING_REF__DESCRIPTION = EAPP_PROPERTY_CONTAINER_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Resolved</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SETTING_REF__RESOLVED = EAPP_PROPERTY_CONTAINER_FEATURE_COUNT + 2;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SETTING_REF__NAME = EAPP_PROPERTY_CONTAINER_FEATURE_COUNT + 3;

	/**
     * The number of structural features of the '<em>EApp Setting Ref</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SETTING_REF_FEATURE_COUNT = EAPP_PROPERTY_CONTAINER_FEATURE_COUNT + 4;

	/**
     * The feature id for the '<em><b>Key</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SETTING_ENTRY__KEY = 0;

	/**
     * The feature id for the '<em><b>Value</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SETTING_ENTRY__VALUE = 1;

	/**
     * The number of structural features of the '<em>EApp Setting Entry</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SETTING_ENTRY_FEATURE_COUNT = 2;

	/**
     * The feature id for the '<em><b>Value</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_FEATURE_ENTRY__VALUE = 0;

	/**
     * The feature id for the '<em><b>Key</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_FEATURE_ENTRY__KEY = 1;

	/**
     * The number of structural features of the '<em>EApp Feature Entry</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_FEATURE_ENTRY_FEATURE_COUNT = 2;

	/**
     * The feature id for the '<em><b>Uri</b></em>' attribute list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SIMPLE_DATA__URI = EAPP_SETTING_DATA__URI;

	/**
     * The feature id for the '<em><b>Type Info</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SIMPLE_DATA__TYPE_INFO = EAPP_SETTING_DATA__TYPE_INFO;

	/**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SIMPLE_DATA__VALUE = EAPP_SETTING_DATA_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Map</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SIMPLE_DATA__MAP = EAPP_SETTING_DATA_FEATURE_COUNT + 1;

	/**
     * The number of structural features of the '<em>EApp Simple Data</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SIMPLE_DATA_FEATURE_COUNT = EAPP_SETTING_DATA_FEATURE_COUNT + 2;

	/**
     * The feature id for the '<em><b>Uri</b></em>' attribute list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_COMPOSITE_DATA__URI = EAPP_SETTING_DATA__URI;

	/**
     * The feature id for the '<em><b>Type Info</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_COMPOSITE_DATA__TYPE_INFO = EAPP_SETTING_DATA__TYPE_INFO;

	/**
     * The feature id for the '<em><b>Sub Settings</b></em>' map.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_COMPOSITE_DATA__SUB_SETTINGS = EAPP_SETTING_DATA_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>EApp Composite Data</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_COMPOSITE_DATA_FEATURE_COUNT = EAPP_SETTING_DATA_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Uri</b></em>' attribute list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SEQUENCE_DATA__URI = EAPP_SETTING_DATA__URI;

	/**
     * The feature id for the '<em><b>Type Info</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SEQUENCE_DATA__TYPE_INFO = EAPP_SETTING_DATA__TYPE_INFO;

	/**
     * The feature id for the '<em><b>Items</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SEQUENCE_DATA__ITEMS = EAPP_SETTING_DATA_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Template</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SEQUENCE_DATA__TEMPLATE = EAPP_SETTING_DATA_FEATURE_COUNT + 1;

	/**
     * The number of structural features of the '<em>EApp Sequence Data</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SEQUENCE_DATA_FEATURE_COUNT = EAPP_SETTING_DATA_FEATURE_COUNT + 2;

	/**
     * The feature id for the '<em><b>Sub Settings</b></em>' map.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_DATA_CONTAINER__SUB_SETTINGS = 0;

	/**
     * The number of structural features of the '<em>EApp Data Container</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_DATA_CONTAINER_FEATURE_COUNT = 1;

	/**
     * The feature id for the '<em><b>Sub Settings</b></em>' map.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SEQUENCE_DATA_ITEM__SUB_SETTINGS = EAPP_DATA_CONTAINER__SUB_SETTINGS;

	/**
     * The feature id for the '<em><b>Uri</b></em>' attribute list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SEQUENCE_DATA_ITEM__URI = EAPP_DATA_CONTAINER_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>EApp Sequence Data Item</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SEQUENCE_DATA_ITEM_FEATURE_COUNT = EAPP_DATA_CONTAINER_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Uri</b></em>' attribute list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_RESOURCE_DATA__URI = EAPP_COMPOSITE_DATA__URI;

	/**
     * The feature id for the '<em><b>Type Info</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_RESOURCE_DATA__TYPE_INFO = EAPP_COMPOSITE_DATA__TYPE_INFO;

	/**
     * The feature id for the '<em><b>Sub Settings</b></em>' map.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_RESOURCE_DATA__SUB_SETTINGS = EAPP_COMPOSITE_DATA__SUB_SETTINGS;

	/**
     * The feature id for the '<em><b>Local Path</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_RESOURCE_DATA__LOCAL_PATH = EAPP_COMPOSITE_DATA_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Target Path</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_RESOURCE_DATA__TARGET_PATH = EAPP_COMPOSITE_DATA_FEATURE_COUNT + 1;

	/**
     * The number of structural features of the '<em>EApp Resource Data</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_RESOURCE_DATA_FEATURE_COUNT = EAPP_COMPOSITE_DATA_FEATURE_COUNT + 2;

	/**
     * The feature id for the '<em><b>Literal</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_EXPRESSION__LITERAL = 0;

	/**
     * The number of structural features of the '<em>EApp Expression</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_EXPRESSION_FEATURE_COUNT = 1;

	/**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SETTING_TYPE__DESCRIPTION = EAPP_DESCRIPTION_CONTAINER__DESCRIPTION;

	/**
     * The feature id for the '<em><b>Icon Descriptor</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SETTING_TYPE__ICON_DESCRIPTOR = EAPP_DESCRIPTION_CONTAINER_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Icon Title</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SETTING_TYPE__ICON_TITLE = EAPP_DESCRIPTION_CONTAINER_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Icon URI</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SETTING_TYPE__ICON_URI = EAPP_DESCRIPTION_CONTAINER_FEATURE_COUNT + 2;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SETTING_TYPE__NAME = EAPP_DESCRIPTION_CONTAINER_FEATURE_COUNT + 3;

	/**
     * The feature id for the '<em><b>Properties</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SETTING_TYPE__PROPERTIES = EAPP_DESCRIPTION_CONTAINER_FEATURE_COUNT + 4;

	/**
     * The feature id for the '<em><b>Read Only</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SETTING_TYPE__READ_ONLY = EAPP_DESCRIPTION_CONTAINER_FEATURE_COUNT + 5;

	/**
     * The feature id for the '<em><b>Constraint</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SETTING_TYPE__CONSTRAINT = EAPP_DESCRIPTION_CONTAINER_FEATURE_COUNT + 6;

	/**
     * The feature id for the '<em><b>Relevant</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SETTING_TYPE__RELEVANT = EAPP_DESCRIPTION_CONTAINER_FEATURE_COUNT + 7;

	/**
     * The feature id for the '<em><b>Required</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SETTING_TYPE__REQUIRED = EAPP_DESCRIPTION_CONTAINER_FEATURE_COUNT + 8;

	/**
     * The feature id for the '<em><b>Deprecated</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SETTING_TYPE__DEPRECATED = EAPP_DESCRIPTION_CONTAINER_FEATURE_COUNT + 9;

	/**
     * The number of structural features of the '<em>EApp Setting Type</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SETTING_TYPE_FEATURE_COUNT = EAPP_DESCRIPTION_CONTAINER_FEATURE_COUNT + 10;

	/**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SIMPLE_TYPE__DESCRIPTION = EAPP_SETTING_TYPE__DESCRIPTION;

	/**
     * The feature id for the '<em><b>Icon Descriptor</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SIMPLE_TYPE__ICON_DESCRIPTOR = EAPP_SETTING_TYPE__ICON_DESCRIPTOR;

	/**
     * The feature id for the '<em><b>Icon Title</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SIMPLE_TYPE__ICON_TITLE = EAPP_SETTING_TYPE__ICON_TITLE;

	/**
     * The feature id for the '<em><b>Icon URI</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SIMPLE_TYPE__ICON_URI = EAPP_SETTING_TYPE__ICON_URI;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SIMPLE_TYPE__NAME = EAPP_SETTING_TYPE__NAME;

	/**
     * The feature id for the '<em><b>Properties</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SIMPLE_TYPE__PROPERTIES = EAPP_SETTING_TYPE__PROPERTIES;

	/**
     * The feature id for the '<em><b>Read Only</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SIMPLE_TYPE__READ_ONLY = EAPP_SETTING_TYPE__READ_ONLY;

	/**
     * The feature id for the '<em><b>Constraint</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SIMPLE_TYPE__CONSTRAINT = EAPP_SETTING_TYPE__CONSTRAINT;

	/**
     * The feature id for the '<em><b>Relevant</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SIMPLE_TYPE__RELEVANT = EAPP_SETTING_TYPE__RELEVANT;

	/**
     * The feature id for the '<em><b>Required</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SIMPLE_TYPE__REQUIRED = EAPP_SETTING_TYPE__REQUIRED;

	/**
     * The feature id for the '<em><b>Deprecated</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SIMPLE_TYPE__DEPRECATED = EAPP_SETTING_TYPE__DEPRECATED;

	/**
     * The feature id for the '<em><b>Options</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SIMPLE_TYPE__OPTIONS = EAPP_SETTING_TYPE_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Min Inclusive</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SIMPLE_TYPE__MIN_INCLUSIVE = EAPP_SETTING_TYPE_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Max Inclusive</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SIMPLE_TYPE__MAX_INCLUSIVE = EAPP_SETTING_TYPE_FEATURE_COUNT + 2;

	/**
     * The feature id for the '<em><b>Min Exclusive</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SIMPLE_TYPE__MIN_EXCLUSIVE = EAPP_SETTING_TYPE_FEATURE_COUNT + 3;

	/**
     * The feature id for the '<em><b>Max Exclusive</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SIMPLE_TYPE__MAX_EXCLUSIVE = EAPP_SETTING_TYPE_FEATURE_COUNT + 4;

	/**
     * The feature id for the '<em><b>Min Length</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SIMPLE_TYPE__MIN_LENGTH = EAPP_SETTING_TYPE_FEATURE_COUNT + 5;

	/**
     * The feature id for the '<em><b>Length</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SIMPLE_TYPE__LENGTH = EAPP_SETTING_TYPE_FEATURE_COUNT + 6;

	/**
     * The feature id for the '<em><b>Max Length</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SIMPLE_TYPE__MAX_LENGTH = EAPP_SETTING_TYPE_FEATURE_COUNT + 7;

	/**
     * The feature id for the '<em><b>Total Digits</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SIMPLE_TYPE__TOTAL_DIGITS = EAPP_SETTING_TYPE_FEATURE_COUNT + 8;

	/**
     * The feature id for the '<em><b>Pattern</b></em>' attribute list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SIMPLE_TYPE__PATTERN = EAPP_SETTING_TYPE_FEATURE_COUNT + 9;

	/**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SIMPLE_TYPE__TYPE = EAPP_SETTING_TYPE_FEATURE_COUNT + 10;

	/**
     * The number of structural features of the '<em>EApp Simple Type</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SIMPLE_TYPE_FEATURE_COUNT = EAPP_SETTING_TYPE_FEATURE_COUNT + 11;

	/**
     * The feature id for the '<em><b>Type Map</b></em>' map.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_TYPE_CONTAINER__TYPE_MAP = 0;

	/**
     * The number of structural features of the '<em>EApp Type Container</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_TYPE_CONTAINER_FEATURE_COUNT = 1;

	/**
     * The feature id for the '<em><b>Type Map</b></em>' map.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SEQUENCE_TYPE__TYPE_MAP = EAPP_TYPE_CONTAINER__TYPE_MAP;

	/**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SEQUENCE_TYPE__DESCRIPTION = EAPP_TYPE_CONTAINER_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Icon Descriptor</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SEQUENCE_TYPE__ICON_DESCRIPTOR = EAPP_TYPE_CONTAINER_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Icon Title</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SEQUENCE_TYPE__ICON_TITLE = EAPP_TYPE_CONTAINER_FEATURE_COUNT + 2;

	/**
     * The feature id for the '<em><b>Icon URI</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SEQUENCE_TYPE__ICON_URI = EAPP_TYPE_CONTAINER_FEATURE_COUNT + 3;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SEQUENCE_TYPE__NAME = EAPP_TYPE_CONTAINER_FEATURE_COUNT + 4;

	/**
     * The feature id for the '<em><b>Properties</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SEQUENCE_TYPE__PROPERTIES = EAPP_TYPE_CONTAINER_FEATURE_COUNT + 5;

	/**
     * The feature id for the '<em><b>Read Only</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SEQUENCE_TYPE__READ_ONLY = EAPP_TYPE_CONTAINER_FEATURE_COUNT + 6;

	/**
     * The feature id for the '<em><b>Constraint</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SEQUENCE_TYPE__CONSTRAINT = EAPP_TYPE_CONTAINER_FEATURE_COUNT + 7;

	/**
     * The feature id for the '<em><b>Relevant</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SEQUENCE_TYPE__RELEVANT = EAPP_TYPE_CONTAINER_FEATURE_COUNT + 8;

	/**
     * The feature id for the '<em><b>Required</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SEQUENCE_TYPE__REQUIRED = EAPP_TYPE_CONTAINER_FEATURE_COUNT + 9;

	/**
     * The feature id for the '<em><b>Deprecated</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SEQUENCE_TYPE__DEPRECATED = EAPP_TYPE_CONTAINER_FEATURE_COUNT + 10;

	/**
     * The feature id for the '<em><b>Min Occurs</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SEQUENCE_TYPE__MIN_OCCURS = EAPP_TYPE_CONTAINER_FEATURE_COUNT + 11;

	/**
     * The feature id for the '<em><b>Max Occurs</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SEQUENCE_TYPE__MAX_OCCURS = EAPP_TYPE_CONTAINER_FEATURE_COUNT + 12;

	/**
     * The feature id for the '<em><b>Map Key</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SEQUENCE_TYPE__MAP_KEY = EAPP_TYPE_CONTAINER_FEATURE_COUNT + 13;

	/**
     * The feature id for the '<em><b>Map Value</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SEQUENCE_TYPE__MAP_VALUE = EAPP_TYPE_CONTAINER_FEATURE_COUNT + 14;

	/**
     * The number of structural features of the '<em>EApp Sequence Type</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SEQUENCE_TYPE_FEATURE_COUNT = EAPP_TYPE_CONTAINER_FEATURE_COUNT + 15;

	/**
     * The feature id for the '<em><b>Type Map</b></em>' map.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_COMPOSITE_TYPE__TYPE_MAP = EAPP_TYPE_CONTAINER__TYPE_MAP;

	/**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_COMPOSITE_TYPE__DESCRIPTION = EAPP_TYPE_CONTAINER_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Icon Descriptor</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_COMPOSITE_TYPE__ICON_DESCRIPTOR = EAPP_TYPE_CONTAINER_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Icon Title</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_COMPOSITE_TYPE__ICON_TITLE = EAPP_TYPE_CONTAINER_FEATURE_COUNT + 2;

	/**
     * The feature id for the '<em><b>Icon URI</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_COMPOSITE_TYPE__ICON_URI = EAPP_TYPE_CONTAINER_FEATURE_COUNT + 3;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_COMPOSITE_TYPE__NAME = EAPP_TYPE_CONTAINER_FEATURE_COUNT + 4;

	/**
     * The feature id for the '<em><b>Properties</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_COMPOSITE_TYPE__PROPERTIES = EAPP_TYPE_CONTAINER_FEATURE_COUNT + 5;

	/**
     * The feature id for the '<em><b>Read Only</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_COMPOSITE_TYPE__READ_ONLY = EAPP_TYPE_CONTAINER_FEATURE_COUNT + 6;

	/**
     * The feature id for the '<em><b>Constraint</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_COMPOSITE_TYPE__CONSTRAINT = EAPP_TYPE_CONTAINER_FEATURE_COUNT + 7;

	/**
     * The feature id for the '<em><b>Relevant</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_COMPOSITE_TYPE__RELEVANT = EAPP_TYPE_CONTAINER_FEATURE_COUNT + 8;

	/**
     * The feature id for the '<em><b>Required</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_COMPOSITE_TYPE__REQUIRED = EAPP_TYPE_CONTAINER_FEATURE_COUNT + 9;

	/**
     * The feature id for the '<em><b>Deprecated</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_COMPOSITE_TYPE__DEPRECATED = EAPP_TYPE_CONTAINER_FEATURE_COUNT + 10;

	/**
     * The number of structural features of the '<em>EApp Composite Type</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_COMPOSITE_TYPE_FEATURE_COUNT = EAPP_TYPE_CONTAINER_FEATURE_COUNT + 11;

	/**
     * The feature id for the '<em><b>Type Map</b></em>' map.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_RESOURCE_TYPE__TYPE_MAP = EAPP_COMPOSITE_TYPE__TYPE_MAP;

	/**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_RESOURCE_TYPE__DESCRIPTION = EAPP_COMPOSITE_TYPE__DESCRIPTION;

	/**
     * The feature id for the '<em><b>Icon Descriptor</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_RESOURCE_TYPE__ICON_DESCRIPTOR = EAPP_COMPOSITE_TYPE__ICON_DESCRIPTOR;

	/**
     * The feature id for the '<em><b>Icon Title</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_RESOURCE_TYPE__ICON_TITLE = EAPP_COMPOSITE_TYPE__ICON_TITLE;

	/**
     * The feature id for the '<em><b>Icon URI</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_RESOURCE_TYPE__ICON_URI = EAPP_COMPOSITE_TYPE__ICON_URI;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_RESOURCE_TYPE__NAME = EAPP_COMPOSITE_TYPE__NAME;

	/**
     * The feature id for the '<em><b>Properties</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_RESOURCE_TYPE__PROPERTIES = EAPP_COMPOSITE_TYPE__PROPERTIES;

	/**
     * The feature id for the '<em><b>Read Only</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_RESOURCE_TYPE__READ_ONLY = EAPP_COMPOSITE_TYPE__READ_ONLY;

	/**
     * The feature id for the '<em><b>Constraint</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_RESOURCE_TYPE__CONSTRAINT = EAPP_COMPOSITE_TYPE__CONSTRAINT;

	/**
     * The feature id for the '<em><b>Relevant</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_RESOURCE_TYPE__RELEVANT = EAPP_COMPOSITE_TYPE__RELEVANT;

	/**
     * The feature id for the '<em><b>Required</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_RESOURCE_TYPE__REQUIRED = EAPP_COMPOSITE_TYPE__REQUIRED;

	/**
     * The feature id for the '<em><b>Deprecated</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_RESOURCE_TYPE__DEPRECATED = EAPP_COMPOSITE_TYPE__DEPRECATED;

	/**
     * The feature id for the '<em><b>File</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_RESOURCE_TYPE__FILE = EAPP_COMPOSITE_TYPE_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Local Path</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_RESOURCE_TYPE__LOCAL_PATH = EAPP_COMPOSITE_TYPE_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Target Path</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_RESOURCE_TYPE__TARGET_PATH = EAPP_COMPOSITE_TYPE_FEATURE_COUNT + 2;

	/**
     * The number of structural features of the '<em>EApp Resource Type</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_RESOURCE_TYPE_FEATURE_COUNT = EAPP_COMPOSITE_TYPE_FEATURE_COUNT + 3;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SETTING_OPTION__NAME = 0;

	/**
     * The feature id for the '<em><b>Literal Value</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SETTING_OPTION__LITERAL_VALUE = 1;

	/**
     * The feature id for the '<em><b>Relevant</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SETTING_OPTION__RELEVANT = 2;

	/**
     * The feature id for the '<em><b>Ref Value</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SETTING_OPTION__REF_VALUE = 3;

	/**
     * The number of structural features of the '<em>EApp Setting Option</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SETTING_OPTION_FEATURE_COUNT = 4;

	/**
     * The feature id for the '<em><b>Options</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_OPTION_CONTAINER__OPTIONS = 0;

	/**
     * The number of structural features of the '<em>EApp Option Container</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_OPTION_CONTAINER_FEATURE_COUNT = 1;

	/**
     * The feature id for the '<em><b>Key</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SETTING_TYPE_ENTRY__KEY = 0;

	/**
     * The feature id for the '<em><b>Value</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SETTING_TYPE_ENTRY__VALUE = 1;

	/**
     * The number of structural features of the '<em>EApp Setting Type Entry</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SETTING_TYPE_ENTRY_FEATURE_COUNT = 2;

	/**
     * The feature id for the '<em><b>Rfs Info</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SETTING__RFS_INFO = 0;

	/**
     * The feature id for the '<em><b>Type Info</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SETTING__TYPE_INFO = 1;

	/**
     * The feature id for the '<em><b>Value Info</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SETTING__VALUE_INFO = 2;

	/**
     * The feature id for the '<em><b>Ref</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SETTING__REF = 3;

	/**
     * The number of structural features of the '<em>EApp Setting</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SETTING_FEATURE_COUNT = 4;

	/**
     * The feature id for the '<em><b>Key</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SUB_SETTING_DATA_ENTRY__KEY = 0;

	/**
     * The feature id for the '<em><b>Value</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SUB_SETTING_DATA_ENTRY__VALUE = 1;

	/**
     * The number of structural features of the '<em>EApp Sub Setting Data Entry</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_SUB_SETTING_DATA_ENTRY_FEATURE_COUNT = 2;

	/**
     * The feature id for the '<em><b>Rfs</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_RFS_INFO__RFS = 0;

	/**
     * The number of structural features of the '<em>EApp Rfs Info</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_RFS_INFO_FEATURE_COUNT = 1;

	/**
     * The feature id for the '<em><b>Icon Descriptor</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_ICON_CONTAINER__ICON_DESCRIPTOR = 0;

	/**
     * The feature id for the '<em><b>Icon Title</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_ICON_CONTAINER__ICON_TITLE = 1;

	/**
     * The feature id for the '<em><b>Icon URI</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_ICON_CONTAINER__ICON_URI = 2;

	/**
     * The number of structural features of the '<em>EApp Icon Container</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_ICON_CONTAINER_FEATURE_COUNT = 3;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_NAMED_ITEM__NAME = 0;

	/**
     * The number of structural features of the '<em>EApp Named Item</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_NAMED_ITEM_FEATURE_COUNT = 1;

	/**
     * The meta object id for the '{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppPropertyImpl <em>EApp Property</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EAppPropertyImpl
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppProperty()
     * @generated
     */
	int EAPP_PROPERTY = 33;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_PROPERTY__NAME = 0;

	/**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_PROPERTY__VALUE = 1;

	/**
     * The feature id for the '<em><b>Unit</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_PROPERTY__UNIT = 2;

	/**
     * The number of structural features of the '<em>EApp Property</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_PROPERTY_FEATURE_COUNT = 3;

	/**
     * The meta object id for the '{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppResourceEntryImpl <em>EApp Resource Entry</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EAppResourceEntryImpl
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppResourceEntry()
     * @generated
     */
	int EAPP_RESOURCE_ENTRY = 34;

	/**
     * The feature id for the '<em><b>Key</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_RESOURCE_ENTRY__KEY = 0;

	/**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_RESOURCE_ENTRY__VALUE = 1;

	/**
     * The number of structural features of the '<em>EApp Resource Entry</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_RESOURCE_ENTRY_FEATURE_COUNT = 2;

	/**
     * The meta object id for the '{@link com.nokia.tools.variant.confml.core.model.application.impl.EConfigurationProjectImpl <em>EConfiguration Project</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EConfigurationProjectImpl
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEConfigurationProject()
     * @generated
     */
	int ECONFIGURATION_PROJECT = 35;

	/**
     * The feature id for the '<em><b>Date</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ECONFIGURATION_PROJECT__DATE = EAPP_METADATA__DATE;

	/**
     * The feature id for the '<em><b>Owner</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ECONFIGURATION_PROJECT__OWNER = EAPP_METADATA__OWNER;

	/**
     * The feature id for the '<em><b>Editor</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ECONFIGURATION_PROJECT__EDITOR = EAPP_METADATA__EDITOR;

	/**
     * The feature id for the '<em><b>Status</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ECONFIGURATION_PROJECT__STATUS = EAPP_METADATA__STATUS;

	/**
     * The feature id for the '<em><b>Version</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ECONFIGURATION_PROJECT__VERSION = EAPP_METADATA__VERSION;

	/**
     * The feature id for the '<em><b>Platform</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ECONFIGURATION_PROJECT__PLATFORM = EAPP_METADATA__PLATFORM;

	/**
     * The feature id for the '<em><b>Product</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ECONFIGURATION_PROJECT__PRODUCT = EAPP_METADATA__PRODUCT;

	/**
     * The feature id for the '<em><b>Release</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ECONFIGURATION_PROJECT__RELEASE = EAPP_METADATA__RELEASE;

	/**
     * The feature id for the '<em><b>Customer</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ECONFIGURATION_PROJECT__CUSTOMER = EAPP_METADATA__CUSTOMER;

	/**
     * The feature id for the '<em><b>Origin</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ECONFIGURATION_PROJECT__ORIGIN = EAPP_METADATA__ORIGIN;

	/**
     * The feature id for the '<em><b>Target</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ECONFIGURATION_PROJECT__TARGET = EAPP_METADATA__TARGET;

	/**
     * The feature id for the '<em><b>Meta Id</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ECONFIGURATION_PROJECT__META_ID = EAPP_METADATA__META_ID;

	/**
     * The feature id for the '<em><b>Layers</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ECONFIGURATION_PROJECT__LAYERS = EAPP_METADATA_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Last Layer</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ECONFIGURATION_PROJECT__LAST_LAYER = EAPP_METADATA_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Root Confml</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ECONFIGURATION_PROJECT__ROOT_CONFML = EAPP_METADATA_FEATURE_COUNT + 2;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ECONFIGURATION_PROJECT__NAME = EAPP_METADATA_FEATURE_COUNT + 3;

	/**
     * The feature id for the '<em><b>Storage</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ECONFIGURATION_PROJECT__STORAGE = EAPP_METADATA_FEATURE_COUNT + 4;

	/**
     * The feature id for the '<em><b>Conf Version</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ECONFIGURATION_PROJECT__CONF_VERSION = EAPP_METADATA_FEATURE_COUNT + 5;

	/**
     * The feature id for the '<em><b>Default View</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ECONFIGURATION_PROJECT__DEFAULT_VIEW = EAPP_METADATA_FEATURE_COUNT + 6;

	/**
     * The number of structural features of the '<em>EConfiguration Project</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ECONFIGURATION_PROJECT_FEATURE_COUNT = EAPP_METADATA_FEATURE_COUNT + 7;

	/**
     * The meta object id for the '{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppIncludeElementImpl <em>EApp Include Element</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EAppIncludeElementImpl
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppIncludeElement()
     * @generated
     */
	int EAPP_INCLUDE_ELEMENT = 37;

	/**
     * The feature id for the '<em><b>Source</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_INCLUDE_ELEMENT__SOURCE = 0;

	/**
     * The feature id for the '<em><b>Target</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_INCLUDE_ELEMENT__TARGET = 1;

	/**
     * The number of structural features of the '<em>EApp Include Element</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EAPP_INCLUDE_ELEMENT_FEATURE_COUNT = 2;

	/**
     * The meta object id for the '{@link com.nokia.tools.variant.confml.core.model.application.EAppValueType <em>EApp Value Type</em>}' enum.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.nokia.tools.variant.confml.core.model.application.EAppValueType
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppValueType()
     * @generated
     */
	int EAPP_VALUE_TYPE = 38;


	/**
     * The meta object id for the '{@link com.nokia.tools.variant.confml.core.model.application.EStorageClass <em>EStorage Class</em>}' enum.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.nokia.tools.variant.confml.core.model.application.EStorageClass
     * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEStorageClass()
     * @generated
     */
	int ESTORAGE_CLASS = 39;


	/**
     * Returns the meta object for class '{@link com.nokia.tools.variant.confml.core.model.application.EConfMLLayer <em>EConf ML Layer</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>EConf ML Layer</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EConfMLLayer
     * @generated
     */
	EClass getEConfMLLayer();

	/**
     * Returns the meta object for the map '{@link com.nokia.tools.variant.confml.core.model.application.EConfMLLayer#getFeatures <em>Features</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the map '<em>Features</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EConfMLLayer#getFeatures()
     * @see #getEConfMLLayer()
     * @generated
     */
	EReference getEConfMLLayer_Features();

	/**
     * Returns the meta object for the map '{@link com.nokia.tools.variant.confml.core.model.application.EConfMLLayer#getViews <em>Views</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the map '<em>Views</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EConfMLLayer#getViews()
     * @see #getEConfMLLayer()
     * @generated
     */
	EReference getEConfMLLayer_Views();

	/**
     * Returns the meta object for the map '{@link com.nokia.tools.variant.confml.core.model.application.EConfMLLayer#getResourceMap <em>Resource Map</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the map '<em>Resource Map</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EConfMLLayer#getResourceMap()
     * @see #getEConfMLLayer()
     * @generated
     */
	EReference getEConfMLLayer_ResourceMap();

	/**
     * Returns the meta object for the map '{@link com.nokia.tools.variant.confml.core.model.application.EConfMLLayer#getDocumentMap <em>Document Map</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the map '<em>Document Map</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EConfMLLayer#getDocumentMap()
     * @see #getEConfMLLayer()
     * @generated
     */
	EReference getEConfMLLayer_DocumentMap();

	/**
     * Returns the meta object for the map '{@link com.nokia.tools.variant.confml.core.model.application.EConfMLLayer#getImplMap <em>Impl Map</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the map '<em>Impl Map</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EConfMLLayer#getImplMap()
     * @see #getEConfMLLayer()
     * @generated
     */
	EReference getEConfMLLayer_ImplMap();

	/**
     * Returns the meta object for the attribute list '{@link com.nokia.tools.variant.confml.core.model.application.EConfMLLayer#getLayerFiles <em>Layer Files</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Layer Files</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EConfMLLayer#getLayerFiles()
     * @see #getEConfMLLayer()
     * @generated
     */
	EAttribute getEConfMLLayer_LayerFiles();

	/**
     * Returns the meta object for the reference '{@link com.nokia.tools.variant.confml.core.model.application.EConfMLLayer#getParent <em>Parent</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Parent</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EConfMLLayer#getParent()
     * @see #getEConfMLLayer()
     * @generated
     */
	EReference getEConfMLLayer_Parent();

	/**
     * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.application.EConfMLLayer#getRootConfml <em>Root Confml</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Root Confml</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EConfMLLayer#getRootConfml()
     * @see #getEConfMLLayer()
     * @generated
     */
	EAttribute getEConfMLLayer_RootConfml();

	/**
     * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.application.EConfMLLayer#getLayerURI <em>Layer URI</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Layer URI</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EConfMLLayer#getLayerURI()
     * @see #getEConfMLLayer()
     * @generated
     */
	EAttribute getEConfMLLayer_LayerURI();

	/**
     * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.application.EConfMLLayer#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EConfMLLayer#getName()
     * @see #getEConfMLLayer()
     * @generated
     */
	EAttribute getEConfMLLayer_Name();

	/**
     * Returns the meta object for the containment reference list '{@link com.nokia.tools.variant.confml.core.model.application.EConfMLLayer#getIncludes <em>Includes</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Includes</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EConfMLLayer#getIncludes()
     * @see #getEConfMLLayer()
     * @generated
     */
	EReference getEConfMLLayer_Includes();

	/**
     * Returns the meta object for class '{@link com.nokia.tools.variant.confml.core.model.application.EAppFeature <em>EApp Feature</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>EApp Feature</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppFeature
     * @generated
     */
	EClass getEAppFeature();

	/**
     * Returns the meta object for the map '{@link com.nokia.tools.variant.confml.core.model.application.EAppFeature#getSettings <em>Settings</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the map '<em>Settings</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppFeature#getSettings()
     * @see #getEAppFeature()
     * @generated
     */
	EReference getEAppFeature_Settings();

	/**
     * Returns the meta object for the containment reference '{@link com.nokia.tools.variant.confml.core.model.application.EAppFeature#getRelevant <em>Relevant</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Relevant</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppFeature#getRelevant()
     * @see #getEAppFeature()
     * @generated
     */
	EReference getEAppFeature_Relevant();

	/**
     * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.application.EAppFeature#getRef <em>Ref</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Ref</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppFeature#getRef()
     * @see #getEAppFeature()
     * @generated
     */
	EAttribute getEAppFeature_Ref();

	/**
     * Returns the meta object for class '{@link com.nokia.tools.variant.confml.core.model.application.EAppSettingData <em>EApp Setting Data</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>EApp Setting Data</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppSettingData
     * @generated
     */
	EClass getEAppSettingData();

	/**
     * Returns the meta object for the reference '{@link com.nokia.tools.variant.confml.core.model.application.EAppSettingData#getTypeInfo <em>Type Info</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Type Info</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppSettingData#getTypeInfo()
     * @see #getEAppSettingData()
     * @generated
     */
	EReference getEAppSettingData_TypeInfo();

	/**
     * Returns the meta object for class '{@link java.util.Map.Entry <em>EApp View Entry</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>EApp View Entry</em>'.
     * @see java.util.Map.Entry
     * @model keyDataType="org.eclipse.emf.ecore.EString" keyRequired="true"
     *        valueType="com.nokia.tools.variant.confml.core.model.application.EAppView" valueContainment="true" valueRequired="true"
     * @generated
     */
	EClass getEAppViewEntry();

	/**
     * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Key</em>'.
     * @see java.util.Map.Entry
     * @see #getEAppViewEntry()
     * @generated
     */
	EAttribute getEAppViewEntry_Key();

	/**
     * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Value</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Value</em>'.
     * @see java.util.Map.Entry
     * @see #getEAppViewEntry()
     * @generated
     */
	EReference getEAppViewEntry_Value();

	/**
     * Returns the meta object for class '{@link com.nokia.tools.variant.confml.core.model.application.EAppSetting <em>EApp Setting</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>EApp Setting</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppSetting
     * @generated
     */
	EClass getEAppSetting();

	/**
     * Returns the meta object for the containment reference '{@link com.nokia.tools.variant.confml.core.model.application.EAppSetting#getValueInfo <em>Value Info</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Value Info</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppSetting#getValueInfo()
     * @see #getEAppSetting()
     * @generated
     */
	EReference getEAppSetting_ValueInfo();

	/**
     * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.application.EAppSetting#getRef <em>Ref</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Ref</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppSetting#getRef()
     * @see #getEAppSetting()
     * @generated
     */
	EAttribute getEAppSetting_Ref();

	/**
     * Returns the meta object for class '{@link java.util.Map.Entry <em>EApp Sub Setting Data Entry</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>EApp Sub Setting Data Entry</em>'.
     * @see java.util.Map.Entry
     * @model keyDataType="org.eclipse.emf.ecore.EString"
     *        valueType="com.nokia.tools.variant.confml.core.model.application.EAppSettingData" valueRequired="true"
     * @generated
     */
	EClass getEAppSubSettingDataEntry();

	/**
     * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Key</em>'.
     * @see java.util.Map.Entry
     * @see #getEAppSubSettingDataEntry()
     * @generated
     */
	EAttribute getEAppSubSettingDataEntry_Key();

	/**
     * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Value</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Value</em>'.
     * @see java.util.Map.Entry
     * @see #getEAppSubSettingDataEntry()
     * @generated
     */
	EReference getEAppSubSettingDataEntry_Value();

	/**
     * Returns the meta object for class '{@link com.nokia.tools.variant.confml.core.model.application.EAppRfsInfo <em>EApp Rfs Info</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>EApp Rfs Info</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppRfsInfo
     * @generated
     */
	EClass getEAppRfsInfo();

	/**
     * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.application.EAppRfsInfo#isRfs <em>Rfs</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Rfs</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppRfsInfo#isRfs()
     * @see #getEAppRfsInfo()
     * @generated
     */
	EAttribute getEAppRfsInfo_Rfs();

	/**
     * Returns the meta object for class '{@link com.nokia.tools.variant.confml.core.model.application.EAppDescriptionContainer <em>EApp Description Container</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>EApp Description Container</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppDescriptionContainer
     * @generated
     */
	EClass getEAppDescriptionContainer();

	/**
     * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.application.EAppDescriptionContainer#getDescription <em>Description</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Description</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppDescriptionContainer#getDescription()
     * @see #getEAppDescriptionContainer()
     * @generated
     */
	EAttribute getEAppDescriptionContainer_Description();

	/**
     * Returns the meta object for class '{@link com.nokia.tools.variant.confml.core.model.application.EAppIconContainer <em>EApp Icon Container</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>EApp Icon Container</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppIconContainer
     * @generated
     */
	EClass getEAppIconContainer();

	/**
     * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.application.EAppIconContainer#getIconDescriptor <em>Icon Descriptor</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Icon Descriptor</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppIconContainer#getIconDescriptor()
     * @see #getEAppIconContainer()
     * @generated
     */
	EAttribute getEAppIconContainer_IconDescriptor();

	/**
     * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.application.EAppIconContainer#getIconTitle <em>Icon Title</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Icon Title</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppIconContainer#getIconTitle()
     * @see #getEAppIconContainer()
     * @generated
     */
	EAttribute getEAppIconContainer_IconTitle();

	/**
     * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.application.EAppIconContainer#getIconURI <em>Icon URI</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Icon URI</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppIconContainer#getIconURI()
     * @see #getEAppIconContainer()
     * @generated
     */
	EAttribute getEAppIconContainer_IconURI();

	/**
     * Returns the meta object for class '{@link com.nokia.tools.variant.confml.core.model.application.EAppNamedItem <em>EApp Named Item</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>EApp Named Item</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppNamedItem
     * @generated
     */
	EClass getEAppNamedItem();

	/**
     * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.application.EAppNamedItem#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppNamedItem#getName()
     * @see #getEAppNamedItem()
     * @generated
     */
	EAttribute getEAppNamedItem_Name();

	/**
     * Returns the meta object for class '{@link com.nokia.tools.variant.confml.core.model.application.EAppPropertyContainer <em>EApp Property Container</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>EApp Property Container</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppPropertyContainer
     * @generated
     */
	EClass getEAppPropertyContainer();

	/**
     * Returns the meta object for the containment reference list '{@link com.nokia.tools.variant.confml.core.model.application.EAppPropertyContainer#getProperties <em>Properties</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Properties</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppPropertyContainer#getProperties()
     * @see #getEAppPropertyContainer()
     * @generated
     */
	EReference getEAppPropertyContainer_Properties();

	/**
     * Returns the meta object for class '{@link com.nokia.tools.variant.confml.core.model.application.EAppProperty <em>EApp Property</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>EApp Property</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppProperty
     * @generated
     */
	EClass getEAppProperty();

	/**
     * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.application.EAppProperty#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppProperty#getName()
     * @see #getEAppProperty()
     * @generated
     */
	EAttribute getEAppProperty_Name();

	/**
     * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.application.EAppProperty#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppProperty#getValue()
     * @see #getEAppProperty()
     * @generated
     */
	EAttribute getEAppProperty_Value();

	/**
     * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.application.EAppProperty#getUnit <em>Unit</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Unit</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppProperty#getUnit()
     * @see #getEAppProperty()
     * @generated
     */
	EAttribute getEAppProperty_Unit();

	/**
     * Returns the meta object for class '{@link java.util.Map.Entry <em>EApp Resource Entry</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>EApp Resource Entry</em>'.
     * @see java.util.Map.Entry
     * @model keyDataType="com.nokia.tools.variant.confml.core.model.core.Ecore_URI" keyRequired="true"
     *        valueDataType="com.nokia.tools.variant.confml.core.model.core.Ecore_URI" valueRequired="true"
     * @generated
     */
	EClass getEAppResourceEntry();

	/**
     * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Key</em>'.
     * @see java.util.Map.Entry
     * @see #getEAppResourceEntry()
     * @generated
     */
	EAttribute getEAppResourceEntry_Key();

	/**
     * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see java.util.Map.Entry
     * @see #getEAppResourceEntry()
     * @generated
     */
	EAttribute getEAppResourceEntry_Value();

	/**
     * Returns the meta object for class '{@link com.nokia.tools.variant.confml.core.model.application.EConfigurationProject <em>EConfiguration Project</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>EConfiguration Project</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EConfigurationProject
     * @generated
     */
	EClass getEConfigurationProject();

	/**
     * Returns the meta object for the containment reference list '{@link com.nokia.tools.variant.confml.core.model.application.EConfigurationProject#getLayers <em>Layers</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Layers</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EConfigurationProject#getLayers()
     * @see #getEConfigurationProject()
     * @generated
     */
	EReference getEConfigurationProject_Layers();

	/**
     * Returns the meta object for the reference '{@link com.nokia.tools.variant.confml.core.model.application.EConfigurationProject#getLastLayer <em>Last Layer</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Last Layer</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EConfigurationProject#getLastLayer()
     * @see #getEConfigurationProject()
     * @generated
     */
	EReference getEConfigurationProject_LastLayer();

	/**
     * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.application.EConfigurationProject#getRootConfml <em>Root Confml</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Root Confml</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EConfigurationProject#getRootConfml()
     * @see #getEConfigurationProject()
     * @generated
     */
	EAttribute getEConfigurationProject_RootConfml();

	/**
     * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.application.EConfigurationProject#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EConfigurationProject#getName()
     * @see #getEConfigurationProject()
     * @generated
     */
	EAttribute getEConfigurationProject_Name();

	/**
     * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.application.EConfigurationProject#getStorage <em>Storage</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Storage</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EConfigurationProject#getStorage()
     * @see #getEConfigurationProject()
     * @generated
     */
	EAttribute getEConfigurationProject_Storage();

	/**
     * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.application.EConfigurationProject#getConfVersion <em>Conf Version</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Conf Version</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EConfigurationProject#getConfVersion()
     * @see #getEConfigurationProject()
     * @generated
     */
	EAttribute getEConfigurationProject_ConfVersion();

	/**
     * Returns the meta object for the reference '{@link com.nokia.tools.variant.confml.core.model.application.EConfigurationProject#getDefaultView <em>Default View</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Default View</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EConfigurationProject#getDefaultView()
     * @see #getEConfigurationProject()
     * @generated
     */
	EReference getEConfigurationProject_DefaultView();

	/**
     * Returns the meta object for class '{@link com.nokia.tools.variant.confml.core.model.application.EAppMetadata <em>EApp Metadata</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>EApp Metadata</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppMetadata
     * @generated
     */
	EClass getEAppMetadata();

	/**
     * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.application.EAppMetadata#getDate <em>Date</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Date</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppMetadata#getDate()
     * @see #getEAppMetadata()
     * @generated
     */
	EAttribute getEAppMetadata_Date();

	/**
     * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.application.EAppMetadata#getOwner <em>Owner</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Owner</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppMetadata#getOwner()
     * @see #getEAppMetadata()
     * @generated
     */
	EAttribute getEAppMetadata_Owner();

	/**
     * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.application.EAppMetadata#getEditor <em>Editor</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Editor</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppMetadata#getEditor()
     * @see #getEAppMetadata()
     * @generated
     */
	EAttribute getEAppMetadata_Editor();

	/**
     * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.application.EAppMetadata#getStatus <em>Status</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Status</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppMetadata#getStatus()
     * @see #getEAppMetadata()
     * @generated
     */
	EAttribute getEAppMetadata_Status();

	/**
     * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.application.EAppMetadata#getVersion <em>Version</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Version</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppMetadata#getVersion()
     * @see #getEAppMetadata()
     * @generated
     */
	EAttribute getEAppMetadata_Version();

	/**
     * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.application.EAppMetadata#getPlatform <em>Platform</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Platform</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppMetadata#getPlatform()
     * @see #getEAppMetadata()
     * @generated
     */
	EAttribute getEAppMetadata_Platform();

	/**
     * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.application.EAppMetadata#getProduct <em>Product</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Product</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppMetadata#getProduct()
     * @see #getEAppMetadata()
     * @generated
     */
	EAttribute getEAppMetadata_Product();

	/**
     * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.application.EAppMetadata#getRelease <em>Release</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Release</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppMetadata#getRelease()
     * @see #getEAppMetadata()
     * @generated
     */
	EAttribute getEAppMetadata_Release();

	/**
     * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.application.EAppMetadata#getCustomer <em>Customer</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Customer</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppMetadata#getCustomer()
     * @see #getEAppMetadata()
     * @generated
     */
	EAttribute getEAppMetadata_Customer();

	/**
     * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.application.EAppMetadata#getOrigin <em>Origin</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Origin</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppMetadata#getOrigin()
     * @see #getEAppMetadata()
     * @generated
     */
	EAttribute getEAppMetadata_Origin();

	/**
     * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.application.EAppMetadata#getTarget <em>Target</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Target</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppMetadata#getTarget()
     * @see #getEAppMetadata()
     * @generated
     */
	EAttribute getEAppMetadata_Target();

	/**
     * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.application.EAppMetadata#getMetaId <em>Meta Id</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Meta Id</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppMetadata#getMetaId()
     * @see #getEAppMetadata()
     * @generated
     */
	EAttribute getEAppMetadata_MetaId();

	/**
     * Returns the meta object for class '{@link com.nokia.tools.variant.confml.core.model.application.EAppIncludeElement <em>EApp Include Element</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>EApp Include Element</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppIncludeElement
     * @generated
     */
	EClass getEAppIncludeElement();

	/**
     * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.application.EAppIncludeElement#getSource <em>Source</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Source</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppIncludeElement#getSource()
     * @see #getEAppIncludeElement()
     * @generated
     */
	EAttribute getEAppIncludeElement_Source();

	/**
     * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.application.EAppIncludeElement#getTarget <em>Target</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Target</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppIncludeElement#getTarget()
     * @see #getEAppIncludeElement()
     * @generated
     */
	EAttribute getEAppIncludeElement_Target();

	/**
     * Returns the meta object for the containment reference '{@link com.nokia.tools.variant.confml.core.model.application.EAppSetting#getRfsInfo <em>Rfs Info</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Rfs Info</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppSetting#getRfsInfo()
     * @see #getEAppSetting()
     * @generated
     */
	EReference getEAppSetting_RfsInfo();

	/**
     * Returns the meta object for the containment reference '{@link com.nokia.tools.variant.confml.core.model.application.EAppSetting#getTypeInfo <em>Type Info</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Type Info</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppSetting#getTypeInfo()
     * @see #getEAppSetting()
     * @generated
     */
	EReference getEAppSetting_TypeInfo();

	/**
     * Returns the meta object for class '{@link com.nokia.tools.variant.confml.core.model.application.EAppView <em>EApp View</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>EApp View</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppView
     * @generated
     */
	EClass getEAppView();

	/**
     * Returns the meta object for class '{@link com.nokia.tools.variant.confml.core.model.application.EAppGroup <em>EApp Group</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>EApp Group</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppGroup
     * @generated
     */
	EClass getEAppGroup();

	/**
     * Returns the meta object for the containment reference list '{@link com.nokia.tools.variant.confml.core.model.application.EAppGroup#getSettings <em>Settings</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Settings</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppGroup#getSettings()
     * @see #getEAppGroup()
     * @generated
     */
	EReference getEAppGroup_Settings();

	/**
     * Returns the meta object for class '{@link com.nokia.tools.variant.confml.core.model.application.EAppGroupContainer <em>EApp Group Container</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>EApp Group Container</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppGroupContainer
     * @generated
     */
	EClass getEAppGroupContainer();

	/**
     * Returns the meta object for the containment reference list '{@link com.nokia.tools.variant.confml.core.model.application.EAppGroupContainer#getGroups <em>Groups</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Groups</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppGroupContainer#getGroups()
     * @see #getEAppGroupContainer()
     * @generated
     */
	EReference getEAppGroupContainer_Groups();

	/**
     * Returns the meta object for class '{@link com.nokia.tools.variant.confml.core.model.application.EAppSettingRef <em>EApp Setting Ref</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>EApp Setting Ref</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppSettingRef
     * @generated
     */
	EClass getEAppSettingRef();

	/**
     * Returns the meta object for the reference '{@link com.nokia.tools.variant.confml.core.model.application.EAppSettingRef#getResolved <em>Resolved</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Resolved</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppSettingRef#getResolved()
     * @see #getEAppSettingRef()
     * @generated
     */
	EReference getEAppSettingRef_Resolved();

	/**
     * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.application.EAppSettingRef#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppSettingRef#getName()
     * @see #getEAppSettingRef()
     * @generated
     */
	EAttribute getEAppSettingRef_Name();

	/**
     * Returns the meta object for class '{@link java.util.Map.Entry <em>EApp Setting Entry</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>EApp Setting Entry</em>'.
     * @see java.util.Map.Entry
     * @model keyDataType="org.eclipse.emf.ecore.EString" keyRequired="true"
     *        valueType="com.nokia.tools.variant.confml.core.model.application.EAppSetting" valueContainment="true" valueRequired="true"
     * @generated
     */
	EClass getEAppSettingEntry();

	/**
     * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Key</em>'.
     * @see java.util.Map.Entry
     * @see #getEAppSettingEntry()
     * @generated
     */
	EAttribute getEAppSettingEntry_Key();

	/**
     * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Value</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Value</em>'.
     * @see java.util.Map.Entry
     * @see #getEAppSettingEntry()
     * @generated
     */
	EReference getEAppSettingEntry_Value();

	/**
     * Returns the meta object for class '{@link java.util.Map.Entry <em>EApp Feature Entry</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>EApp Feature Entry</em>'.
     * @see java.util.Map.Entry
     * @model features="value key" 
     *        valueType="com.nokia.tools.variant.confml.core.model.application.EAppFeature" valueContainment="true" valueRequired="true"
     *        keyDataType="org.eclipse.emf.ecore.EString" keyRequired="true"
     * @generated
     */
	EClass getEAppFeatureEntry();

	/**
     * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Value</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Value</em>'.
     * @see java.util.Map.Entry
     * @see #getEAppFeatureEntry()
     * @generated
     */
	EReference getEAppFeatureEntry_Value();

	/**
     * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Key</em>'.
     * @see java.util.Map.Entry
     * @see #getEAppFeatureEntry()
     * @generated
     */
	EAttribute getEAppFeatureEntry_Key();

	/**
     * Returns the meta object for class '{@link com.nokia.tools.variant.confml.core.model.application.EAppSimpleData <em>EApp Simple Data</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>EApp Simple Data</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppSimpleData
     * @generated
     */
	EClass getEAppSimpleData();

	/**
     * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.application.EAppSimpleData#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppSimpleData#getValue()
     * @see #getEAppSimpleData()
     * @generated
     */
	EAttribute getEAppSimpleData_Value();

	/**
     * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.application.EAppSimpleData#getMap <em>Map</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Map</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppSimpleData#getMap()
     * @see #getEAppSimpleData()
     * @generated
     */
	EAttribute getEAppSimpleData_Map();

	/**
     * Returns the meta object for class '{@link com.nokia.tools.variant.confml.core.model.application.EAppCompositeData <em>EApp Composite Data</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>EApp Composite Data</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppCompositeData
     * @generated
     */
	EClass getEAppCompositeData();

	/**
     * Returns the meta object for class '{@link com.nokia.tools.variant.confml.core.model.application.EAppSequenceData <em>EApp Sequence Data</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>EApp Sequence Data</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppSequenceData
     * @generated
     */
	EClass getEAppSequenceData();

	/**
     * Returns the meta object for the containment reference list '{@link com.nokia.tools.variant.confml.core.model.application.EAppSequenceData#getItems <em>Items</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Items</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppSequenceData#getItems()
     * @see #getEAppSequenceData()
     * @generated
     */
	EReference getEAppSequenceData_Items();

	/**
     * Returns the meta object for the containment reference '{@link com.nokia.tools.variant.confml.core.model.application.EAppSequenceData#getTemplate <em>Template</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Template</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppSequenceData#getTemplate()
     * @see #getEAppSequenceData()
     * @generated
     */
	EReference getEAppSequenceData_Template();

	/**
     * Returns the meta object for class '{@link com.nokia.tools.variant.confml.core.model.application.EAppSequenceDataItem <em>EApp Sequence Data Item</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>EApp Sequence Data Item</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppSequenceDataItem
     * @generated
     */
	EClass getEAppSequenceDataItem();

	/**
     * Returns the meta object for class '{@link com.nokia.tools.variant.confml.core.model.application.EAppDataContainer <em>EApp Data Container</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>EApp Data Container</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppDataContainer
     * @generated
     */
	EClass getEAppDataContainer();

	/**
     * Returns the meta object for the map '{@link com.nokia.tools.variant.confml.core.model.application.EAppDataContainer#getSubSettings <em>Sub Settings</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the map '<em>Sub Settings</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppDataContainer#getSubSettings()
     * @see #getEAppDataContainer()
     * @generated
     */
	EReference getEAppDataContainer_SubSettings();

	/**
     * Returns the meta object for class '{@link com.nokia.tools.variant.confml.core.model.application.EAppResourceData <em>EApp Resource Data</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>EApp Resource Data</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppResourceData
     * @generated
     */
	EClass getEAppResourceData();

	/**
     * Returns the meta object for the reference '{@link com.nokia.tools.variant.confml.core.model.application.EAppResourceData#getLocalPath <em>Local Path</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Local Path</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppResourceData#getLocalPath()
     * @see #getEAppResourceData()
     * @generated
     */
	EReference getEAppResourceData_LocalPath();

	/**
     * Returns the meta object for the reference '{@link com.nokia.tools.variant.confml.core.model.application.EAppResourceData#getTargetPath <em>Target Path</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Target Path</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppResourceData#getTargetPath()
     * @see #getEAppResourceData()
     * @generated
     */
	EReference getEAppResourceData_TargetPath();

	/**
     * Returns the meta object for class '{@link com.nokia.tools.variant.confml.core.model.application.EAppExpression <em>EApp Expression</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>EApp Expression</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppExpression
     * @generated
     */
	EClass getEAppExpression();

	/**
     * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.application.EAppExpression#getLiteral <em>Literal</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Literal</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppExpression#getLiteral()
     * @see #getEAppExpression()
     * @generated
     */
	EAttribute getEAppExpression_Literal();

	/**
     * Returns the meta object for class '{@link com.nokia.tools.variant.confml.core.model.application.EAppSettingType <em>EApp Setting Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>EApp Setting Type</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppSettingType
     * @generated
     */
	EClass getEAppSettingType();

	/**
     * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.application.EAppSettingType#isReadOnly <em>Read Only</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Read Only</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppSettingType#isReadOnly()
     * @see #getEAppSettingType()
     * @generated
     */
	EAttribute getEAppSettingType_ReadOnly();

	/**
     * Returns the meta object for the containment reference '{@link com.nokia.tools.variant.confml.core.model.application.EAppSettingType#getConstraint <em>Constraint</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Constraint</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppSettingType#getConstraint()
     * @see #getEAppSettingType()
     * @generated
     */
	EReference getEAppSettingType_Constraint();

	/**
     * Returns the meta object for the containment reference '{@link com.nokia.tools.variant.confml.core.model.application.EAppSettingType#getRelevant <em>Relevant</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Relevant</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppSettingType#getRelevant()
     * @see #getEAppSettingType()
     * @generated
     */
	EReference getEAppSettingType_Relevant();

	/**
     * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.application.EAppSettingType#isRequired <em>Required</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Required</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppSettingType#isRequired()
     * @see #getEAppSettingType()
     * @generated
     */
	EAttribute getEAppSettingType_Required();

	/**
     * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.application.EAppSettingType#isDeprecated <em>Deprecated</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Deprecated</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppSettingType#isDeprecated()
     * @see #getEAppSettingType()
     * @generated
     */
	EAttribute getEAppSettingType_Deprecated();

	/**
     * Returns the meta object for class '{@link com.nokia.tools.variant.confml.core.model.application.EAppSimpleType <em>EApp Simple Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>EApp Simple Type</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppSimpleType
     * @generated
     */
	EClass getEAppSimpleType();

	/**
     * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.application.EAppSimpleType#getMinInclusive <em>Min Inclusive</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Min Inclusive</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppSimpleType#getMinInclusive()
     * @see #getEAppSimpleType()
     * @generated
     */
	EAttribute getEAppSimpleType_MinInclusive();

	/**
     * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.application.EAppSimpleType#getMaxInclusive <em>Max Inclusive</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Max Inclusive</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppSimpleType#getMaxInclusive()
     * @see #getEAppSimpleType()
     * @generated
     */
	EAttribute getEAppSimpleType_MaxInclusive();

	/**
     * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.application.EAppSimpleType#getMinExclusive <em>Min Exclusive</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Min Exclusive</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppSimpleType#getMinExclusive()
     * @see #getEAppSimpleType()
     * @generated
     */
	EAttribute getEAppSimpleType_MinExclusive();

	/**
     * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.application.EAppSimpleType#getMaxExclusive <em>Max Exclusive</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Max Exclusive</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppSimpleType#getMaxExclusive()
     * @see #getEAppSimpleType()
     * @generated
     */
	EAttribute getEAppSimpleType_MaxExclusive();

	/**
     * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.application.EAppSimpleType#getMinLength <em>Min Length</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Min Length</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppSimpleType#getMinLength()
     * @see #getEAppSimpleType()
     * @generated
     */
	EAttribute getEAppSimpleType_MinLength();

	/**
     * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.application.EAppSimpleType#getLength <em>Length</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Length</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppSimpleType#getLength()
     * @see #getEAppSimpleType()
     * @generated
     */
	EAttribute getEAppSimpleType_Length();

	/**
     * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.application.EAppSimpleType#getMaxLength <em>Max Length</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Max Length</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppSimpleType#getMaxLength()
     * @see #getEAppSimpleType()
     * @generated
     */
	EAttribute getEAppSimpleType_MaxLength();

	/**
     * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.application.EAppSimpleType#getTotalDigits <em>Total Digits</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Total Digits</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppSimpleType#getTotalDigits()
     * @see #getEAppSimpleType()
     * @generated
     */
	EAttribute getEAppSimpleType_TotalDigits();

	/**
     * Returns the meta object for the attribute list '{@link com.nokia.tools.variant.confml.core.model.application.EAppSimpleType#getPattern <em>Pattern</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Pattern</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppSimpleType#getPattern()
     * @see #getEAppSimpleType()
     * @generated
     */
	EAttribute getEAppSimpleType_Pattern();

	/**
     * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.application.EAppSimpleType#getType <em>Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Type</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppSimpleType#getType()
     * @see #getEAppSimpleType()
     * @generated
     */
	EAttribute getEAppSimpleType_Type();

	/**
     * Returns the meta object for class '{@link com.nokia.tools.variant.confml.core.model.application.EAppSequenceType <em>EApp Sequence Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>EApp Sequence Type</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppSequenceType
     * @generated
     */
	EClass getEAppSequenceType();

	/**
     * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.application.EAppSequenceType#getMinOccurs <em>Min Occurs</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Min Occurs</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppSequenceType#getMinOccurs()
     * @see #getEAppSequenceType()
     * @generated
     */
	EAttribute getEAppSequenceType_MinOccurs();

	/**
     * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.application.EAppSequenceType#getMaxOccurs <em>Max Occurs</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Max Occurs</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppSequenceType#getMaxOccurs()
     * @see #getEAppSequenceType()
     * @generated
     */
	EAttribute getEAppSequenceType_MaxOccurs();

	/**
     * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.application.EAppSequenceType#getMapKey <em>Map Key</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Map Key</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppSequenceType#getMapKey()
     * @see #getEAppSequenceType()
     * @generated
     */
	EAttribute getEAppSequenceType_MapKey();

	/**
     * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.application.EAppSequenceType#getMapValue <em>Map Value</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Map Value</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppSequenceType#getMapValue()
     * @see #getEAppSequenceType()
     * @generated
     */
	EAttribute getEAppSequenceType_MapValue();

	/**
     * Returns the meta object for class '{@link com.nokia.tools.variant.confml.core.model.application.EAppCompositeType <em>EApp Composite Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>EApp Composite Type</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppCompositeType
     * @generated
     */
	EClass getEAppCompositeType();

	/**
     * Returns the meta object for class '{@link com.nokia.tools.variant.confml.core.model.application.EAppTypeContainer <em>EApp Type Container</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>EApp Type Container</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppTypeContainer
     * @generated
     */
	EClass getEAppTypeContainer();

	/**
     * Returns the meta object for the map '{@link com.nokia.tools.variant.confml.core.model.application.EAppTypeContainer#getTypeMap <em>Type Map</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the map '<em>Type Map</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppTypeContainer#getTypeMap()
     * @see #getEAppTypeContainer()
     * @generated
     */
	EReference getEAppTypeContainer_TypeMap();

	/**
     * Returns the meta object for class '{@link com.nokia.tools.variant.confml.core.model.application.EAppResourceType <em>EApp Resource Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>EApp Resource Type</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppResourceType
     * @generated
     */
	EClass getEAppResourceType();

	/**
     * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.application.EAppResourceType#isFile <em>File</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>File</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppResourceType#isFile()
     * @see #getEAppResourceType()
     * @generated
     */
	EAttribute getEAppResourceType_File();

	/**
     * Returns the meta object for the reference '{@link com.nokia.tools.variant.confml.core.model.application.EAppResourceType#getLocalPath <em>Local Path</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Local Path</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppResourceType#getLocalPath()
     * @see #getEAppResourceType()
     * @generated
     */
	EReference getEAppResourceType_LocalPath();

	/**
     * Returns the meta object for the reference '{@link com.nokia.tools.variant.confml.core.model.application.EAppResourceType#getTargetPath <em>Target Path</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Target Path</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppResourceType#getTargetPath()
     * @see #getEAppResourceType()
     * @generated
     */
	EReference getEAppResourceType_TargetPath();

	/**
     * Returns the meta object for class '{@link com.nokia.tools.variant.confml.core.model.application.EAppSettingOption <em>EApp Setting Option</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>EApp Setting Option</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppSettingOption
     * @generated
     */
	EClass getEAppSettingOption();

	/**
     * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.application.EAppSettingOption#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppSettingOption#getName()
     * @see #getEAppSettingOption()
     * @generated
     */
	EAttribute getEAppSettingOption_Name();

	/**
     * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.application.EAppSettingOption#getLiteralValue <em>Literal Value</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Literal Value</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppSettingOption#getLiteralValue()
     * @see #getEAppSettingOption()
     * @generated
     */
	EAttribute getEAppSettingOption_LiteralValue();

	/**
     * Returns the meta object for the containment reference '{@link com.nokia.tools.variant.confml.core.model.application.EAppSettingOption#getRelevant <em>Relevant</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Relevant</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppSettingOption#getRelevant()
     * @see #getEAppSettingOption()
     * @generated
     */
	EReference getEAppSettingOption_Relevant();

	/**
     * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.application.EAppSettingOption#getRefValue <em>Ref Value</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Ref Value</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppSettingOption#getRefValue()
     * @see #getEAppSettingOption()
     * @generated
     */
	EAttribute getEAppSettingOption_RefValue();

	/**
     * Returns the meta object for class '{@link com.nokia.tools.variant.confml.core.model.application.EAppOptionContainer <em>EApp Option Container</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>EApp Option Container</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppOptionContainer
     * @generated
     */
	EClass getEAppOptionContainer();

	/**
     * Returns the meta object for the containment reference list '{@link com.nokia.tools.variant.confml.core.model.application.EAppOptionContainer#getOptions <em>Options</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Options</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppOptionContainer#getOptions()
     * @see #getEAppOptionContainer()
     * @generated
     */
	EReference getEAppOptionContainer_Options();

	/**
     * Returns the meta object for class '{@link java.util.Map.Entry <em>EApp Setting Type Entry</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>EApp Setting Type Entry</em>'.
     * @see java.util.Map.Entry
     * @model keyDataType="org.eclipse.emf.ecore.EString" keyRequired="true"
     *        valueType="com.nokia.tools.variant.confml.core.model.application.EAppSettingType" valueContainment="true" valueRequired="true"
     * @generated
     */
	EClass getEAppSettingTypeEntry();

	/**
     * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Key</em>'.
     * @see java.util.Map.Entry
     * @see #getEAppSettingTypeEntry()
     * @generated
     */
	EAttribute getEAppSettingTypeEntry_Key();

	/**
     * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Value</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Value</em>'.
     * @see java.util.Map.Entry
     * @see #getEAppSettingTypeEntry()
     * @generated
     */
	EReference getEAppSettingTypeEntry_Value();

	/**
     * Returns the meta object for enum '{@link com.nokia.tools.variant.confml.core.model.application.EAppValueType <em>EApp Value Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for enum '<em>EApp Value Type</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EAppValueType
     * @generated
     */
	EEnum getEAppValueType();

	/**
     * Returns the meta object for enum '{@link com.nokia.tools.variant.confml.core.model.application.EStorageClass <em>EStorage Class</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for enum '<em>EStorage Class</em>'.
     * @see com.nokia.tools.variant.confml.core.model.application.EStorageClass
     * @generated
     */
	EEnum getEStorageClass();

	/**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
	EApplicationFactory getEApplicationFactory();

	/**
     * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
     * @generated
     */
	interface Literals {
		/**
         * The meta object literal for the '{@link com.nokia.tools.variant.confml.core.model.application.impl.EConfMLLayerImpl <em>EConf ML Layer</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EConfMLLayerImpl
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEConfMLLayer()
         * @generated
         */
		EClass ECONF_ML_LAYER = eINSTANCE.getEConfMLLayer();

		/**
         * The meta object literal for the '<em><b>Features</b></em>' map feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference ECONF_ML_LAYER__FEATURES = eINSTANCE.getEConfMLLayer_Features();

		/**
         * The meta object literal for the '<em><b>Views</b></em>' map feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference ECONF_ML_LAYER__VIEWS = eINSTANCE.getEConfMLLayer_Views();

		/**
         * The meta object literal for the '<em><b>Resource Map</b></em>' map feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference ECONF_ML_LAYER__RESOURCE_MAP = eINSTANCE.getEConfMLLayer_ResourceMap();

		/**
         * The meta object literal for the '<em><b>Document Map</b></em>' map feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference ECONF_ML_LAYER__DOCUMENT_MAP = eINSTANCE.getEConfMLLayer_DocumentMap();

		/**
         * The meta object literal for the '<em><b>Impl Map</b></em>' map feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference ECONF_ML_LAYER__IMPL_MAP = eINSTANCE.getEConfMLLayer_ImplMap();

		/**
         * The meta object literal for the '<em><b>Layer Files</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute ECONF_ML_LAYER__LAYER_FILES = eINSTANCE.getEConfMLLayer_LayerFiles();

		/**
         * The meta object literal for the '<em><b>Parent</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference ECONF_ML_LAYER__PARENT = eINSTANCE.getEConfMLLayer_Parent();

		/**
         * The meta object literal for the '<em><b>Root Confml</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute ECONF_ML_LAYER__ROOT_CONFML = eINSTANCE.getEConfMLLayer_RootConfml();

		/**
         * The meta object literal for the '<em><b>Layer URI</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute ECONF_ML_LAYER__LAYER_URI = eINSTANCE.getEConfMLLayer_LayerURI();

		/**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute ECONF_ML_LAYER__NAME = eINSTANCE.getEConfMLLayer_Name();

		/**
         * The meta object literal for the '<em><b>Includes</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference ECONF_ML_LAYER__INCLUDES = eINSTANCE.getEConfMLLayer_Includes();

		/**
         * The meta object literal for the '{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppFeatureImpl <em>EApp Feature</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EAppFeatureImpl
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppFeature()
         * @generated
         */
		EClass EAPP_FEATURE = eINSTANCE.getEAppFeature();

		/**
         * The meta object literal for the '<em><b>Settings</b></em>' map feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference EAPP_FEATURE__SETTINGS = eINSTANCE.getEAppFeature_Settings();

		/**
         * The meta object literal for the '<em><b>Relevant</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference EAPP_FEATURE__RELEVANT = eINSTANCE.getEAppFeature_Relevant();

		/**
         * The meta object literal for the '<em><b>Ref</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute EAPP_FEATURE__REF = eINSTANCE.getEAppFeature_Ref();

		/**
         * The meta object literal for the '{@link com.nokia.tools.variant.confml.core.model.application.EAppSettingData <em>EApp Setting Data</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.nokia.tools.variant.confml.core.model.application.EAppSettingData
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppSettingData()
         * @generated
         */
		EClass EAPP_SETTING_DATA = eINSTANCE.getEAppSettingData();

		/**
         * The meta object literal for the '<em><b>Type Info</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference EAPP_SETTING_DATA__TYPE_INFO = eINSTANCE.getEAppSettingData_TypeInfo();

		/**
         * The meta object literal for the '{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppViewEntryImpl <em>EApp View Entry</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EAppViewEntryImpl
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppViewEntry()
         * @generated
         */
		EClass EAPP_VIEW_ENTRY = eINSTANCE.getEAppViewEntry();

		/**
         * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute EAPP_VIEW_ENTRY__KEY = eINSTANCE.getEAppViewEntry_Key();

		/**
         * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference EAPP_VIEW_ENTRY__VALUE = eINSTANCE.getEAppViewEntry_Value();

		/**
         * The meta object literal for the '{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppSettingImpl <em>EApp Setting</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EAppSettingImpl
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppSetting()
         * @generated
         */
		EClass EAPP_SETTING = eINSTANCE.getEAppSetting();

		/**
         * The meta object literal for the '<em><b>Value Info</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference EAPP_SETTING__VALUE_INFO = eINSTANCE.getEAppSetting_ValueInfo();

		/**
         * The meta object literal for the '<em><b>Ref</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute EAPP_SETTING__REF = eINSTANCE.getEAppSetting_Ref();

		/**
         * The meta object literal for the '{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppSubSettingDataEntryImpl <em>EApp Sub Setting Data Entry</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EAppSubSettingDataEntryImpl
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppSubSettingDataEntry()
         * @generated
         */
		EClass EAPP_SUB_SETTING_DATA_ENTRY = eINSTANCE.getEAppSubSettingDataEntry();

		/**
         * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute EAPP_SUB_SETTING_DATA_ENTRY__KEY = eINSTANCE.getEAppSubSettingDataEntry_Key();

		/**
         * The meta object literal for the '<em><b>Value</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference EAPP_SUB_SETTING_DATA_ENTRY__VALUE = eINSTANCE.getEAppSubSettingDataEntry_Value();

		/**
         * The meta object literal for the '{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppRfsInfoImpl <em>EApp Rfs Info</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EAppRfsInfoImpl
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppRfsInfo()
         * @generated
         */
		EClass EAPP_RFS_INFO = eINSTANCE.getEAppRfsInfo();

		/**
         * The meta object literal for the '<em><b>Rfs</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute EAPP_RFS_INFO__RFS = eINSTANCE.getEAppRfsInfo_Rfs();

		/**
         * The meta object literal for the '{@link com.nokia.tools.variant.confml.core.model.application.EAppDescriptionContainer <em>EApp Description Container</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.nokia.tools.variant.confml.core.model.application.EAppDescriptionContainer
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppDescriptionContainer()
         * @generated
         */
		EClass EAPP_DESCRIPTION_CONTAINER = eINSTANCE.getEAppDescriptionContainer();

		/**
         * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute EAPP_DESCRIPTION_CONTAINER__DESCRIPTION = eINSTANCE.getEAppDescriptionContainer_Description();

		/**
         * The meta object literal for the '{@link com.nokia.tools.variant.confml.core.model.application.EAppIconContainer <em>EApp Icon Container</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.nokia.tools.variant.confml.core.model.application.EAppIconContainer
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppIconContainer()
         * @generated
         */
		EClass EAPP_ICON_CONTAINER = eINSTANCE.getEAppIconContainer();

		/**
         * The meta object literal for the '<em><b>Icon Descriptor</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute EAPP_ICON_CONTAINER__ICON_DESCRIPTOR = eINSTANCE.getEAppIconContainer_IconDescriptor();

		/**
         * The meta object literal for the '<em><b>Icon Title</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute EAPP_ICON_CONTAINER__ICON_TITLE = eINSTANCE.getEAppIconContainer_IconTitle();

		/**
         * The meta object literal for the '<em><b>Icon URI</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute EAPP_ICON_CONTAINER__ICON_URI = eINSTANCE.getEAppIconContainer_IconURI();

		/**
         * The meta object literal for the '{@link com.nokia.tools.variant.confml.core.model.application.EAppNamedItem <em>EApp Named Item</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.nokia.tools.variant.confml.core.model.application.EAppNamedItem
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppNamedItem()
         * @generated
         */
		EClass EAPP_NAMED_ITEM = eINSTANCE.getEAppNamedItem();

		/**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute EAPP_NAMED_ITEM__NAME = eINSTANCE.getEAppNamedItem_Name();

		/**
         * The meta object literal for the '{@link com.nokia.tools.variant.confml.core.model.application.EAppPropertyContainer <em>EApp Property Container</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.nokia.tools.variant.confml.core.model.application.EAppPropertyContainer
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppPropertyContainer()
         * @generated
         */
		EClass EAPP_PROPERTY_CONTAINER = eINSTANCE.getEAppPropertyContainer();

		/**
         * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference EAPP_PROPERTY_CONTAINER__PROPERTIES = eINSTANCE.getEAppPropertyContainer_Properties();

		/**
         * The meta object literal for the '{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppPropertyImpl <em>EApp Property</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EAppPropertyImpl
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppProperty()
         * @generated
         */
		EClass EAPP_PROPERTY = eINSTANCE.getEAppProperty();

		/**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute EAPP_PROPERTY__NAME = eINSTANCE.getEAppProperty_Name();

		/**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute EAPP_PROPERTY__VALUE = eINSTANCE.getEAppProperty_Value();

		/**
         * The meta object literal for the '<em><b>Unit</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute EAPP_PROPERTY__UNIT = eINSTANCE.getEAppProperty_Unit();

		/**
         * The meta object literal for the '{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppResourceEntryImpl <em>EApp Resource Entry</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EAppResourceEntryImpl
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppResourceEntry()
         * @generated
         */
		EClass EAPP_RESOURCE_ENTRY = eINSTANCE.getEAppResourceEntry();

		/**
         * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute EAPP_RESOURCE_ENTRY__KEY = eINSTANCE.getEAppResourceEntry_Key();

		/**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute EAPP_RESOURCE_ENTRY__VALUE = eINSTANCE.getEAppResourceEntry_Value();

		/**
         * The meta object literal for the '{@link com.nokia.tools.variant.confml.core.model.application.impl.EConfigurationProjectImpl <em>EConfiguration Project</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EConfigurationProjectImpl
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEConfigurationProject()
         * @generated
         */
		EClass ECONFIGURATION_PROJECT = eINSTANCE.getEConfigurationProject();

		/**
         * The meta object literal for the '<em><b>Layers</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference ECONFIGURATION_PROJECT__LAYERS = eINSTANCE.getEConfigurationProject_Layers();

		/**
         * The meta object literal for the '<em><b>Last Layer</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference ECONFIGURATION_PROJECT__LAST_LAYER = eINSTANCE.getEConfigurationProject_LastLayer();

		/**
         * The meta object literal for the '<em><b>Root Confml</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute ECONFIGURATION_PROJECT__ROOT_CONFML = eINSTANCE.getEConfigurationProject_RootConfml();

		/**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute ECONFIGURATION_PROJECT__NAME = eINSTANCE.getEConfigurationProject_Name();

		/**
         * The meta object literal for the '<em><b>Storage</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute ECONFIGURATION_PROJECT__STORAGE = eINSTANCE.getEConfigurationProject_Storage();

		/**
         * The meta object literal for the '<em><b>Conf Version</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute ECONFIGURATION_PROJECT__CONF_VERSION = eINSTANCE.getEConfigurationProject_ConfVersion();

		/**
         * The meta object literal for the '<em><b>Default View</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference ECONFIGURATION_PROJECT__DEFAULT_VIEW = eINSTANCE.getEConfigurationProject_DefaultView();

		/**
         * The meta object literal for the '{@link com.nokia.tools.variant.confml.core.model.application.EAppMetadata <em>EApp Metadata</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.nokia.tools.variant.confml.core.model.application.EAppMetadata
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppMetadata()
         * @generated
         */
		EClass EAPP_METADATA = eINSTANCE.getEAppMetadata();

		/**
         * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute EAPP_METADATA__DATE = eINSTANCE.getEAppMetadata_Date();

		/**
         * The meta object literal for the '<em><b>Owner</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute EAPP_METADATA__OWNER = eINSTANCE.getEAppMetadata_Owner();

		/**
         * The meta object literal for the '<em><b>Editor</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute EAPP_METADATA__EDITOR = eINSTANCE.getEAppMetadata_Editor();

		/**
         * The meta object literal for the '<em><b>Status</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute EAPP_METADATA__STATUS = eINSTANCE.getEAppMetadata_Status();

		/**
         * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute EAPP_METADATA__VERSION = eINSTANCE.getEAppMetadata_Version();

		/**
         * The meta object literal for the '<em><b>Platform</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute EAPP_METADATA__PLATFORM = eINSTANCE.getEAppMetadata_Platform();

		/**
         * The meta object literal for the '<em><b>Product</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute EAPP_METADATA__PRODUCT = eINSTANCE.getEAppMetadata_Product();

		/**
         * The meta object literal for the '<em><b>Release</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute EAPP_METADATA__RELEASE = eINSTANCE.getEAppMetadata_Release();

		/**
         * The meta object literal for the '<em><b>Customer</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute EAPP_METADATA__CUSTOMER = eINSTANCE.getEAppMetadata_Customer();

		/**
         * The meta object literal for the '<em><b>Origin</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute EAPP_METADATA__ORIGIN = eINSTANCE.getEAppMetadata_Origin();

		/**
         * The meta object literal for the '<em><b>Target</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute EAPP_METADATA__TARGET = eINSTANCE.getEAppMetadata_Target();

		/**
         * The meta object literal for the '<em><b>Meta Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute EAPP_METADATA__META_ID = eINSTANCE.getEAppMetadata_MetaId();

		/**
         * The meta object literal for the '{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppIncludeElementImpl <em>EApp Include Element</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EAppIncludeElementImpl
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppIncludeElement()
         * @generated
         */
		EClass EAPP_INCLUDE_ELEMENT = eINSTANCE.getEAppIncludeElement();

		/**
         * The meta object literal for the '<em><b>Source</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute EAPP_INCLUDE_ELEMENT__SOURCE = eINSTANCE.getEAppIncludeElement_Source();

		/**
         * The meta object literal for the '<em><b>Target</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute EAPP_INCLUDE_ELEMENT__TARGET = eINSTANCE.getEAppIncludeElement_Target();

		/**
         * The meta object literal for the '<em><b>Rfs Info</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference EAPP_SETTING__RFS_INFO = eINSTANCE.getEAppSetting_RfsInfo();

		/**
         * The meta object literal for the '<em><b>Type Info</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference EAPP_SETTING__TYPE_INFO = eINSTANCE.getEAppSetting_TypeInfo();

		/**
         * The meta object literal for the '{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppViewImpl <em>EApp View</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EAppViewImpl
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppView()
         * @generated
         */
		EClass EAPP_VIEW = eINSTANCE.getEAppView();

		/**
         * The meta object literal for the '{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppGroupImpl <em>EApp Group</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EAppGroupImpl
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppGroup()
         * @generated
         */
		EClass EAPP_GROUP = eINSTANCE.getEAppGroup();

		/**
         * The meta object literal for the '<em><b>Settings</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference EAPP_GROUP__SETTINGS = eINSTANCE.getEAppGroup_Settings();

		/**
         * The meta object literal for the '{@link com.nokia.tools.variant.confml.core.model.application.EAppGroupContainer <em>EApp Group Container</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.nokia.tools.variant.confml.core.model.application.EAppGroupContainer
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppGroupContainer()
         * @generated
         */
		EClass EAPP_GROUP_CONTAINER = eINSTANCE.getEAppGroupContainer();

		/**
         * The meta object literal for the '<em><b>Groups</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference EAPP_GROUP_CONTAINER__GROUPS = eINSTANCE.getEAppGroupContainer_Groups();

		/**
         * The meta object literal for the '{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppSettingRefImpl <em>EApp Setting Ref</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EAppSettingRefImpl
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppSettingRef()
         * @generated
         */
		EClass EAPP_SETTING_REF = eINSTANCE.getEAppSettingRef();

		/**
         * The meta object literal for the '<em><b>Resolved</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference EAPP_SETTING_REF__RESOLVED = eINSTANCE.getEAppSettingRef_Resolved();

		/**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute EAPP_SETTING_REF__NAME = eINSTANCE.getEAppSettingRef_Name();

		/**
         * The meta object literal for the '{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppSettingEntryImpl <em>EApp Setting Entry</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EAppSettingEntryImpl
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppSettingEntry()
         * @generated
         */
		EClass EAPP_SETTING_ENTRY = eINSTANCE.getEAppSettingEntry();

		/**
         * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute EAPP_SETTING_ENTRY__KEY = eINSTANCE.getEAppSettingEntry_Key();

		/**
         * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference EAPP_SETTING_ENTRY__VALUE = eINSTANCE.getEAppSettingEntry_Value();

		/**
         * The meta object literal for the '{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppFeatureEntryImpl <em>EApp Feature Entry</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EAppFeatureEntryImpl
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppFeatureEntry()
         * @generated
         */
		EClass EAPP_FEATURE_ENTRY = eINSTANCE.getEAppFeatureEntry();

		/**
         * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference EAPP_FEATURE_ENTRY__VALUE = eINSTANCE.getEAppFeatureEntry_Value();

		/**
         * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute EAPP_FEATURE_ENTRY__KEY = eINSTANCE.getEAppFeatureEntry_Key();

		/**
         * The meta object literal for the '{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppSimpleDataImpl <em>EApp Simple Data</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EAppSimpleDataImpl
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppSimpleData()
         * @generated
         */
		EClass EAPP_SIMPLE_DATA = eINSTANCE.getEAppSimpleData();

		/**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute EAPP_SIMPLE_DATA__VALUE = eINSTANCE.getEAppSimpleData_Value();

		/**
         * The meta object literal for the '<em><b>Map</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute EAPP_SIMPLE_DATA__MAP = eINSTANCE.getEAppSimpleData_Map();

		/**
         * The meta object literal for the '{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppCompositeDataImpl <em>EApp Composite Data</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EAppCompositeDataImpl
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppCompositeData()
         * @generated
         */
		EClass EAPP_COMPOSITE_DATA = eINSTANCE.getEAppCompositeData();

		/**
         * The meta object literal for the '{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppSequenceDataImpl <em>EApp Sequence Data</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EAppSequenceDataImpl
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppSequenceData()
         * @generated
         */
		EClass EAPP_SEQUENCE_DATA = eINSTANCE.getEAppSequenceData();

		/**
         * The meta object literal for the '<em><b>Items</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference EAPP_SEQUENCE_DATA__ITEMS = eINSTANCE.getEAppSequenceData_Items();

		/**
         * The meta object literal for the '<em><b>Template</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference EAPP_SEQUENCE_DATA__TEMPLATE = eINSTANCE.getEAppSequenceData_Template();

		/**
         * The meta object literal for the '{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppSequenceDataItemImpl <em>EApp Sequence Data Item</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EAppSequenceDataItemImpl
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppSequenceDataItem()
         * @generated
         */
		EClass EAPP_SEQUENCE_DATA_ITEM = eINSTANCE.getEAppSequenceDataItem();

		/**
         * The meta object literal for the '{@link com.nokia.tools.variant.confml.core.model.application.EAppDataContainer <em>EApp Data Container</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.nokia.tools.variant.confml.core.model.application.EAppDataContainer
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppDataContainer()
         * @generated
         */
		EClass EAPP_DATA_CONTAINER = eINSTANCE.getEAppDataContainer();

		/**
         * The meta object literal for the '<em><b>Sub Settings</b></em>' map feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference EAPP_DATA_CONTAINER__SUB_SETTINGS = eINSTANCE.getEAppDataContainer_SubSettings();

		/**
         * The meta object literal for the '{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppResourceDataImpl <em>EApp Resource Data</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EAppResourceDataImpl
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppResourceData()
         * @generated
         */
		EClass EAPP_RESOURCE_DATA = eINSTANCE.getEAppResourceData();

		/**
         * The meta object literal for the '<em><b>Local Path</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference EAPP_RESOURCE_DATA__LOCAL_PATH = eINSTANCE.getEAppResourceData_LocalPath();

		/**
         * The meta object literal for the '<em><b>Target Path</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference EAPP_RESOURCE_DATA__TARGET_PATH = eINSTANCE.getEAppResourceData_TargetPath();

		/**
         * The meta object literal for the '{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppExpressionImpl <em>EApp Expression</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EAppExpressionImpl
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppExpression()
         * @generated
         */
		EClass EAPP_EXPRESSION = eINSTANCE.getEAppExpression();

		/**
         * The meta object literal for the '<em><b>Literal</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute EAPP_EXPRESSION__LITERAL = eINSTANCE.getEAppExpression_Literal();

		/**
         * The meta object literal for the '{@link com.nokia.tools.variant.confml.core.model.application.EAppSettingType <em>EApp Setting Type</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.nokia.tools.variant.confml.core.model.application.EAppSettingType
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppSettingType()
         * @generated
         */
		EClass EAPP_SETTING_TYPE = eINSTANCE.getEAppSettingType();

		/**
         * The meta object literal for the '<em><b>Read Only</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute EAPP_SETTING_TYPE__READ_ONLY = eINSTANCE.getEAppSettingType_ReadOnly();

		/**
         * The meta object literal for the '<em><b>Constraint</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference EAPP_SETTING_TYPE__CONSTRAINT = eINSTANCE.getEAppSettingType_Constraint();

		/**
         * The meta object literal for the '<em><b>Relevant</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference EAPP_SETTING_TYPE__RELEVANT = eINSTANCE.getEAppSettingType_Relevant();

		/**
         * The meta object literal for the '<em><b>Required</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute EAPP_SETTING_TYPE__REQUIRED = eINSTANCE.getEAppSettingType_Required();

		/**
         * The meta object literal for the '<em><b>Deprecated</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute EAPP_SETTING_TYPE__DEPRECATED = eINSTANCE.getEAppSettingType_Deprecated();

		/**
         * The meta object literal for the '{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppSimpleTypeImpl <em>EApp Simple Type</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EAppSimpleTypeImpl
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppSimpleType()
         * @generated
         */
		EClass EAPP_SIMPLE_TYPE = eINSTANCE.getEAppSimpleType();

		/**
         * The meta object literal for the '<em><b>Min Inclusive</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute EAPP_SIMPLE_TYPE__MIN_INCLUSIVE = eINSTANCE.getEAppSimpleType_MinInclusive();

		/**
         * The meta object literal for the '<em><b>Max Inclusive</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute EAPP_SIMPLE_TYPE__MAX_INCLUSIVE = eINSTANCE.getEAppSimpleType_MaxInclusive();

		/**
         * The meta object literal for the '<em><b>Min Exclusive</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute EAPP_SIMPLE_TYPE__MIN_EXCLUSIVE = eINSTANCE.getEAppSimpleType_MinExclusive();

		/**
         * The meta object literal for the '<em><b>Max Exclusive</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute EAPP_SIMPLE_TYPE__MAX_EXCLUSIVE = eINSTANCE.getEAppSimpleType_MaxExclusive();

		/**
         * The meta object literal for the '<em><b>Min Length</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute EAPP_SIMPLE_TYPE__MIN_LENGTH = eINSTANCE.getEAppSimpleType_MinLength();

		/**
         * The meta object literal for the '<em><b>Length</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute EAPP_SIMPLE_TYPE__LENGTH = eINSTANCE.getEAppSimpleType_Length();

		/**
         * The meta object literal for the '<em><b>Max Length</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute EAPP_SIMPLE_TYPE__MAX_LENGTH = eINSTANCE.getEAppSimpleType_MaxLength();

		/**
         * The meta object literal for the '<em><b>Total Digits</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute EAPP_SIMPLE_TYPE__TOTAL_DIGITS = eINSTANCE.getEAppSimpleType_TotalDigits();

		/**
         * The meta object literal for the '<em><b>Pattern</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute EAPP_SIMPLE_TYPE__PATTERN = eINSTANCE.getEAppSimpleType_Pattern();

		/**
         * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute EAPP_SIMPLE_TYPE__TYPE = eINSTANCE.getEAppSimpleType_Type();

		/**
         * The meta object literal for the '{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppSequenceTypeImpl <em>EApp Sequence Type</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EAppSequenceTypeImpl
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppSequenceType()
         * @generated
         */
		EClass EAPP_SEQUENCE_TYPE = eINSTANCE.getEAppSequenceType();

		/**
         * The meta object literal for the '<em><b>Min Occurs</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute EAPP_SEQUENCE_TYPE__MIN_OCCURS = eINSTANCE.getEAppSequenceType_MinOccurs();

		/**
         * The meta object literal for the '<em><b>Max Occurs</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute EAPP_SEQUENCE_TYPE__MAX_OCCURS = eINSTANCE.getEAppSequenceType_MaxOccurs();

		/**
         * The meta object literal for the '<em><b>Map Key</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute EAPP_SEQUENCE_TYPE__MAP_KEY = eINSTANCE.getEAppSequenceType_MapKey();

		/**
         * The meta object literal for the '<em><b>Map Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute EAPP_SEQUENCE_TYPE__MAP_VALUE = eINSTANCE.getEAppSequenceType_MapValue();

		/**
         * The meta object literal for the '{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppCompositeTypeImpl <em>EApp Composite Type</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EAppCompositeTypeImpl
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppCompositeType()
         * @generated
         */
		EClass EAPP_COMPOSITE_TYPE = eINSTANCE.getEAppCompositeType();

		/**
         * The meta object literal for the '{@link com.nokia.tools.variant.confml.core.model.application.EAppTypeContainer <em>EApp Type Container</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.nokia.tools.variant.confml.core.model.application.EAppTypeContainer
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppTypeContainer()
         * @generated
         */
		EClass EAPP_TYPE_CONTAINER = eINSTANCE.getEAppTypeContainer();

		/**
         * The meta object literal for the '<em><b>Type Map</b></em>' map feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference EAPP_TYPE_CONTAINER__TYPE_MAP = eINSTANCE.getEAppTypeContainer_TypeMap();

		/**
         * The meta object literal for the '{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppResourceTypeImpl <em>EApp Resource Type</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EAppResourceTypeImpl
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppResourceType()
         * @generated
         */
		EClass EAPP_RESOURCE_TYPE = eINSTANCE.getEAppResourceType();

		/**
         * The meta object literal for the '<em><b>File</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute EAPP_RESOURCE_TYPE__FILE = eINSTANCE.getEAppResourceType_File();

		/**
         * The meta object literal for the '<em><b>Local Path</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference EAPP_RESOURCE_TYPE__LOCAL_PATH = eINSTANCE.getEAppResourceType_LocalPath();

		/**
         * The meta object literal for the '<em><b>Target Path</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference EAPP_RESOURCE_TYPE__TARGET_PATH = eINSTANCE.getEAppResourceType_TargetPath();

		/**
         * The meta object literal for the '{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppSettingOptionImpl <em>EApp Setting Option</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EAppSettingOptionImpl
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppSettingOption()
         * @generated
         */
		EClass EAPP_SETTING_OPTION = eINSTANCE.getEAppSettingOption();

		/**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute EAPP_SETTING_OPTION__NAME = eINSTANCE.getEAppSettingOption_Name();

		/**
         * The meta object literal for the '<em><b>Literal Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute EAPP_SETTING_OPTION__LITERAL_VALUE = eINSTANCE.getEAppSettingOption_LiteralValue();

		/**
         * The meta object literal for the '<em><b>Relevant</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference EAPP_SETTING_OPTION__RELEVANT = eINSTANCE.getEAppSettingOption_Relevant();

		/**
         * The meta object literal for the '<em><b>Ref Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute EAPP_SETTING_OPTION__REF_VALUE = eINSTANCE.getEAppSettingOption_RefValue();

		/**
         * The meta object literal for the '{@link com.nokia.tools.variant.confml.core.model.application.EAppOptionContainer <em>EApp Option Container</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.nokia.tools.variant.confml.core.model.application.EAppOptionContainer
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppOptionContainer()
         * @generated
         */
		EClass EAPP_OPTION_CONTAINER = eINSTANCE.getEAppOptionContainer();

		/**
         * The meta object literal for the '<em><b>Options</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference EAPP_OPTION_CONTAINER__OPTIONS = eINSTANCE.getEAppOptionContainer_Options();

		/**
         * The meta object literal for the '{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppSettingTypeEntryImpl <em>EApp Setting Type Entry</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EAppSettingTypeEntryImpl
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppSettingTypeEntry()
         * @generated
         */
		EClass EAPP_SETTING_TYPE_ENTRY = eINSTANCE.getEAppSettingTypeEntry();

		/**
         * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute EAPP_SETTING_TYPE_ENTRY__KEY = eINSTANCE.getEAppSettingTypeEntry_Key();

		/**
         * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference EAPP_SETTING_TYPE_ENTRY__VALUE = eINSTANCE.getEAppSettingTypeEntry_Value();

		/**
         * The meta object literal for the '{@link com.nokia.tools.variant.confml.core.model.application.EAppValueType <em>EApp Value Type</em>}' enum.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.nokia.tools.variant.confml.core.model.application.EAppValueType
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEAppValueType()
         * @generated
         */
		EEnum EAPP_VALUE_TYPE = eINSTANCE.getEAppValueType();

		/**
         * The meta object literal for the '{@link com.nokia.tools.variant.confml.core.model.application.EStorageClass <em>EStorage Class</em>}' enum.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.nokia.tools.variant.confml.core.model.application.EStorageClass
         * @see com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl#getEStorageClass()
         * @generated
         */
		EEnum ESTORAGE_CLASS = eINSTANCE.getEStorageClass();

	}

} //EApplicationPackage
