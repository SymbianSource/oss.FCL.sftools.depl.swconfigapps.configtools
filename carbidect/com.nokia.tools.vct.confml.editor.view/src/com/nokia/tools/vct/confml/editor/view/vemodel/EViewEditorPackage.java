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
 * Description: This file is part of com.nokia.tools.vct.confml.editor.view component.
 */

package com.nokia.tools.vct.confml.editor.view.vemodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorFactory
 * @model kind="package"
 * @generated
 */
public interface EViewEditorPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "vemodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://view_editor/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "vemodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EViewEditorPackage eINSTANCE = com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewEditorPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewsEditorDocumentImpl <em>EViews Editor Document</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewsEditorDocumentImpl
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewEditorPackageImpl#getEViewsEditorDocument()
	 * @generated
	 */
	int EVIEWS_EDITOR_DOCUMENT = 0;

	/**
	 * The feature id for the '<em><b>Views</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVIEWS_EDITOR_DOCUMENT__VIEWS = 0;

	/**
	 * The feature id for the '<em><b>Use Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVIEWS_EDITOR_DOCUMENT__USE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Features</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVIEWS_EDITOR_DOCUMENT__FEATURES = 2;

	/**
	 * The feature id for the '<em><b>All Views</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVIEWS_EDITOR_DOCUMENT__ALL_VIEWS = 3;

	/**
	 * The number of structural features of the '<em>EViews Editor Document</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVIEWS_EDITOR_DOCUMENT_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.confml.editor.view.vemodel.EGroupContainer <em>EGroup Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EGroupContainer
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewEditorPackageImpl#getEGroupContainer()
	 * @generated
	 */
	int EGROUP_CONTAINER = 3;

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewImpl <em>EView</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewImpl
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewEditorPackageImpl#getEView()
	 * @generated
	 */
	int EVIEW = 1;

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.confml.editor.view.vemodel.impl.EGroupImpl <em>EGroup</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.impl.EGroupImpl
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewEditorPackageImpl#getEGroup()
	 * @generated
	 */
	int EGROUP = 2;

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.confml.editor.view.vemodel.impl.ESettingRefImpl <em>ESetting Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.impl.ESettingRefImpl
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewEditorPackageImpl#getESettingRef()
	 * @generated
	 */
	int ESETTING_REF = 4;

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.confml.editor.view.vemodel.EDescriptionContainer <em>EDescription Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EDescriptionContainer
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewEditorPackageImpl#getEDescriptionContainer()
	 * @generated
	 */
	int EDESCRIPTION_CONTAINER = 7;

	/**
	 * The feature id for the '<em><b>Description Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDESCRIPTION_CONTAINER__DESCRIPTION_TEXT = 0;

	/**
	 * The feature id for the '<em><b>Description Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDESCRIPTION_CONTAINER__DESCRIPTION_URI = 1;

	/**
	 * The feature id for the '<em><b>Description Uri Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDESCRIPTION_CONTAINER__DESCRIPTION_URI_TITLE = 2;

	/**
	 * The number of structural features of the '<em>EDescription Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDESCRIPTION_CONTAINER_FEATURE_COUNT = 3;

	/**
	 * The feature id for the '<em><b>Description Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVIEW__DESCRIPTION_TEXT = EDESCRIPTION_CONTAINER__DESCRIPTION_TEXT;

	/**
	 * The feature id for the '<em><b>Description Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVIEW__DESCRIPTION_URI = EDESCRIPTION_CONTAINER__DESCRIPTION_URI;

	/**
	 * The feature id for the '<em><b>Description Uri Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVIEW__DESCRIPTION_URI_TITLE = EDESCRIPTION_CONTAINER__DESCRIPTION_URI_TITLE;

	/**
	 * The feature id for the '<em><b>Icon Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVIEW__ICON_URI = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Icon Uri Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVIEW__ICON_URI_TITLE = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Groups And Views</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVIEW__GROUPS_AND_VIEWS = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVIEW__NAME = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVIEW__ID = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Inclusion URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVIEW__INCLUSION_URI = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>File URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVIEW__FILE_URI = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>EView</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVIEW_FEATURE_COUNT = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Description Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EGROUP__DESCRIPTION_TEXT = EDESCRIPTION_CONTAINER__DESCRIPTION_TEXT;

	/**
	 * The feature id for the '<em><b>Description Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EGROUP__DESCRIPTION_URI = EDESCRIPTION_CONTAINER__DESCRIPTION_URI;

	/**
	 * The feature id for the '<em><b>Description Uri Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EGROUP__DESCRIPTION_URI_TITLE = EDESCRIPTION_CONTAINER__DESCRIPTION_URI_TITLE;

	/**
	 * The feature id for the '<em><b>Icon Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EGROUP__ICON_URI = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Icon Uri Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EGROUP__ICON_URI_TITLE = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Groups And Views</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EGROUP__GROUPS_AND_VIEWS = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EGROUP__NAME = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Refs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EGROUP__REFS = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>EGroup</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EGROUP_FEATURE_COUNT = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Groups And Views</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EGROUP_CONTAINER__GROUPS_AND_VIEWS = 0;

	/**
	 * The number of structural features of the '<em>EGroup Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EGROUP_CONTAINER_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Description Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_REF__DESCRIPTION_TEXT = EDESCRIPTION_CONTAINER__DESCRIPTION_TEXT;

	/**
	 * The feature id for the '<em><b>Description Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_REF__DESCRIPTION_URI = EDESCRIPTION_CONTAINER__DESCRIPTION_URI;

	/**
	 * The feature id for the '<em><b>Description Uri Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_REF__DESCRIPTION_URI_TITLE = EDESCRIPTION_CONTAINER__DESCRIPTION_URI_TITLE;

	/**
	 * The feature id for the '<em><b>Feature Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_REF__FEATURE_ID = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Setting Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_REF__SETTING_ID = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_REF__TARGET = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_REF__NAME = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Min Inclusive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_REF__MIN_INCLUSIVE = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Max Inclusive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_REF__MAX_INCLUSIVE = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Min Exclusive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_REF__MIN_EXCLUSIVE = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Max Exclusive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_REF__MAX_EXCLUSIVE = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_REF__LENGTH = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Max Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_REF__MAX_LENGTH = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Min Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_REF__MIN_LENGTH = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Patterns</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_REF__PATTERNS = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Options</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_REF__OPTIONS = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_REF__PROPERTIES = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 13;

	/**
	 * The number of structural features of the '<em>ESetting Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_REF_FEATURE_COUNT = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 14;

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.confml.editor.view.vemodel.impl.EFeatureImpl <em>EFeature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.impl.EFeatureImpl
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewEditorPackageImpl#getEFeature()
	 * @generated
	 */
	int EFEATURE = 5;

	/**
	 * The feature id for the '<em><b>Description Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFEATURE__DESCRIPTION_TEXT = EDESCRIPTION_CONTAINER__DESCRIPTION_TEXT;

	/**
	 * The feature id for the '<em><b>Description Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFEATURE__DESCRIPTION_URI = EDESCRIPTION_CONTAINER__DESCRIPTION_URI;

	/**
	 * The feature id for the '<em><b>Description Uri Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFEATURE__DESCRIPTION_URI_TITLE = EDESCRIPTION_CONTAINER__DESCRIPTION_URI_TITLE;

	/**
	 * The feature id for the '<em><b>Resource Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFEATURE__RESOURCE_URI = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFEATURE__REFS = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Settings</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFEATURE__SETTINGS = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFEATURE__NAME = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>EFeature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFEATURE_FEATURE_COUNT = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.confml.editor.view.vemodel.impl.ESettingEntryImpl <em>ESetting Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.impl.ESettingEntryImpl
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewEditorPackageImpl#getESettingEntry()
	 * @generated
	 */
	int ESETTING_ENTRY = 6;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>ESetting Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.confml.editor.view.vemodel.EIconContainer <em>EIcon Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EIconContainer
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewEditorPackageImpl#getEIconContainer()
	 * @generated
	 */
	int EICON_CONTAINER = 8;

	/**
	 * The feature id for the '<em><b>Icon Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EICON_CONTAINER__ICON_URI = 0;

	/**
	 * The feature id for the '<em><b>Icon Uri Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EICON_CONTAINER__ICON_URI_TITLE = 1;

	/**
	 * The number of structural features of the '<em>EIcon Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EICON_CONTAINER_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.confml.editor.view.vemodel.EResourceLocator <em>EResource Locator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EResourceLocator
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewEditorPackageImpl#getEResourceLocator()
	 * @generated
	 */
	int ERESOURCE_LOCATOR = 9;

	/**
	 * The feature id for the '<em><b>Resource Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERESOURCE_LOCATOR__RESOURCE_URI = 0;

	/**
	 * The number of structural features of the '<em>EResource Locator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERESOURCE_LOCATOR_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.confml.editor.view.vemodel.ERefTarget <em>ERef Target</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.ERefTarget
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewEditorPackageImpl#getERefTarget()
	 * @generated
	 */
	int EREF_TARGET = 10;

	/**
	 * The feature id for the '<em><b>Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREF_TARGET__REFS = 0;

	/**
	 * The number of structural features of the '<em>ERef Target</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREF_TARGET_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.confml.editor.view.vemodel.impl.EFeatureEntryImpl <em>EFeature Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.impl.EFeatureEntryImpl
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewEditorPackageImpl#getEFeatureEntry()
	 * @generated
	 */
	int EFEATURE_ENTRY = 11;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFEATURE_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFEATURE_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>EFeature Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFEATURE_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.confml.editor.view.vemodel.impl.ESettingImpl <em>ESetting</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.impl.ESettingImpl
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewEditorPackageImpl#getESetting()
	 * @generated
	 */
	int ESETTING = 12;

	/**
	 * The feature id for the '<em><b>Description Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING__DESCRIPTION_TEXT = EDESCRIPTION_CONTAINER__DESCRIPTION_TEXT;

	/**
	 * The feature id for the '<em><b>Description Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING__DESCRIPTION_URI = EDESCRIPTION_CONTAINER__DESCRIPTION_URI;

	/**
	 * The feature id for the '<em><b>Description Uri Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING__DESCRIPTION_URI_TITLE = EDESCRIPTION_CONTAINER__DESCRIPTION_URI_TITLE;

	/**
	 * The feature id for the '<em><b>Resource Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING__RESOURCE_URI = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING__REFS = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING__NAME = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING__READ_ONLY = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Sub Settings</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING__SUB_SETTINGS = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>ESetting</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_FEATURE_COUNT = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewEntryImpl <em>EView Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewEntryImpl
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewEditorPackageImpl#getEViewEntry()
	 * @generated
	 */
	int EVIEW_ENTRY = 13;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVIEW_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVIEW_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>EView Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVIEW_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.confml.editor.view.vemodel.impl.ERefPropertyImpl <em>ERef Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.impl.ERefPropertyImpl
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewEditorPackageImpl#getERefProperty()
	 * @generated
	 */
	int EREF_PROPERTY = 14;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREF_PROPERTY__NAME = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREF_PROPERTY__VALUE = 1;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREF_PROPERTY__UNIT = 2;

	/**
	 * The number of structural features of the '<em>ERef Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREF_PROPERTY_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.confml.editor.view.vemodel.impl.ERefOptionImpl <em>ERef Option</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.impl.ERefOptionImpl
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewEditorPackageImpl#getERefOption()
	 * @generated
	 */
	int EREF_OPTION = 15;

	/**
	 * The feature id for the '<em><b>Map</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREF_OPTION__MAP = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREF_OPTION__NAME = 1;

	/**
	 * The feature id for the '<em><b>Relevant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREF_OPTION__RELEVANT = 2;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREF_OPTION__VALUE = 3;

	/**
	 * The number of structural features of the '<em>ERef Option</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREF_OPTION_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.confml.editor.view.vemodel.impl.EGroupEntryImpl <em>EGroup Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.impl.EGroupEntryImpl
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewEditorPackageImpl#getEGroupEntry()
	 * @generated
	 */
	int EGROUP_ENTRY = 16;

	/**
	 * The feature id for the '<em><b>Groups And Views</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EGROUP_ENTRY__GROUPS_AND_VIEWS = EGROUP_CONTAINER__GROUPS_AND_VIEWS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EGROUP_ENTRY__NAME = EGROUP_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>EGroup Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EGROUP_ENTRY_FEATURE_COUNT = EGROUP_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '<em>EJava URI</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.net.URI
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewEditorPackageImpl#getEJavaURI()
	 * @generated
	 */
	int EJAVA_URI = 17;


	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.confml.editor.view.vemodel.EViewsEditorDocument <em>EViews Editor Document</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EViews Editor Document</em>'.
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EViewsEditorDocument
	 * @generated
	 */
	EClass getEViewsEditorDocument();

	/**
	 * Returns the meta object for the map '{@link com.nokia.tools.vct.confml.editor.view.vemodel.EViewsEditorDocument#getViews <em>Views</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Views</em>'.
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EViewsEditorDocument#getViews()
	 * @see #getEViewsEditorDocument()
	 * @generated
	 */
	EReference getEViewsEditorDocument_Views();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.confml.editor.view.vemodel.EViewsEditorDocument#getUseCount <em>Use Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Use Count</em>'.
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EViewsEditorDocument#getUseCount()
	 * @see #getEViewsEditorDocument()
	 * @generated
	 */
	EAttribute getEViewsEditorDocument_UseCount();

	/**
	 * Returns the meta object for the map '{@link com.nokia.tools.vct.confml.editor.view.vemodel.EViewsEditorDocument#getFeatures <em>Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Features</em>'.
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EViewsEditorDocument#getFeatures()
	 * @see #getEViewsEditorDocument()
	 * @generated
	 */
	EReference getEViewsEditorDocument_Features();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.vct.confml.editor.view.vemodel.EViewsEditorDocument#getAllViews <em>All Views</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>All Views</em>'.
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EViewsEditorDocument#getAllViews()
	 * @see #getEViewsEditorDocument()
	 * @generated
	 */
	EReference getEViewsEditorDocument_AllViews();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.confml.editor.view.vemodel.EView <em>EView</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EView</em>'.
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EView
	 * @generated
	 */
	EClass getEView();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.confml.editor.view.vemodel.EView#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EView#getId()
	 * @see #getEView()
	 * @generated
	 */
	EAttribute getEView_Id();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.confml.editor.view.vemodel.EView#getInclusionURI <em>Inclusion URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Inclusion URI</em>'.
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EView#getInclusionURI()
	 * @see #getEView()
	 * @generated
	 */
	EAttribute getEView_InclusionURI();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.confml.editor.view.vemodel.EView#getFileURI <em>File URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File URI</em>'.
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EView#getFileURI()
	 * @see #getEView()
	 * @generated
	 */
	EAttribute getEView_FileURI();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.confml.editor.view.vemodel.EGroup <em>EGroup</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EGroup</em>'.
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EGroup
	 * @generated
	 */
	EClass getEGroup();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.vct.confml.editor.view.vemodel.EGroup#getRefs <em>Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Refs</em>'.
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EGroup#getRefs()
	 * @see #getEGroup()
	 * @generated
	 */
	EReference getEGroup_Refs();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.confml.editor.view.vemodel.EGroupContainer <em>EGroup Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EGroup Container</em>'.
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EGroupContainer
	 * @generated
	 */
	EClass getEGroupContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.vct.confml.editor.view.vemodel.EGroupContainer#getGroupsAndViews <em>Groups And Views</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Groups And Views</em>'.
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EGroupContainer#getGroupsAndViews()
	 * @see #getEGroupContainer()
	 * @generated
	 */
	EReference getEGroupContainer_GroupsAndViews();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef <em>ESetting Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ESetting Ref</em>'.
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef
	 * @generated
	 */
	EClass getESettingRef();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef#getFeatureId <em>Feature Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Feature Id</em>'.
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef#getFeatureId()
	 * @see #getESettingRef()
	 * @generated
	 */
	EAttribute getESettingRef_FeatureId();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef#getSettingId <em>Setting Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Setting Id</em>'.
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef#getSettingId()
	 * @see #getESettingRef()
	 * @generated
	 */
	EAttribute getESettingRef_SettingId();

	/**
	 * Returns the meta object for the reference '{@link com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef#getTarget()
	 * @see #getESettingRef()
	 * @generated
	 */
	EReference getESettingRef_Target();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef#getName()
	 * @see #getESettingRef()
	 * @generated
	 */
	EAttribute getESettingRef_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef#getMinInclusive <em>Min Inclusive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Inclusive</em>'.
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef#getMinInclusive()
	 * @see #getESettingRef()
	 * @generated
	 */
	EAttribute getESettingRef_MinInclusive();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef#getMaxInclusive <em>Max Inclusive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Inclusive</em>'.
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef#getMaxInclusive()
	 * @see #getESettingRef()
	 * @generated
	 */
	EAttribute getESettingRef_MaxInclusive();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef#getMinExclusive <em>Min Exclusive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Exclusive</em>'.
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef#getMinExclusive()
	 * @see #getESettingRef()
	 * @generated
	 */
	EAttribute getESettingRef_MinExclusive();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef#getMaxExclusive <em>Max Exclusive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Exclusive</em>'.
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef#getMaxExclusive()
	 * @see #getESettingRef()
	 * @generated
	 */
	EAttribute getESettingRef_MaxExclusive();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef#getLength <em>Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Length</em>'.
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef#getLength()
	 * @see #getESettingRef()
	 * @generated
	 */
	EAttribute getESettingRef_Length();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef#getMaxLength <em>Max Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Length</em>'.
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef#getMaxLength()
	 * @see #getESettingRef()
	 * @generated
	 */
	EAttribute getESettingRef_MaxLength();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef#getMinLength <em>Min Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Length</em>'.
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef#getMinLength()
	 * @see #getESettingRef()
	 * @generated
	 */
	EAttribute getESettingRef_MinLength();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef#getPatterns <em>Patterns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Patterns</em>'.
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef#getPatterns()
	 * @see #getESettingRef()
	 * @generated
	 */
	EAttribute getESettingRef_Patterns();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef#getOptions <em>Options</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Options</em>'.
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef#getOptions()
	 * @see #getESettingRef()
	 * @generated
	 */
	EReference getESettingRef_Options();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef#getProperties()
	 * @see #getESettingRef()
	 * @generated
	 */
	EReference getESettingRef_Properties();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.confml.editor.view.vemodel.EFeature <em>EFeature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EFeature</em>'.
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EFeature
	 * @generated
	 */
	EClass getEFeature();

	/**
	 * Returns the meta object for the map '{@link com.nokia.tools.vct.confml.editor.view.vemodel.EFeature#getSettings <em>Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Settings</em>'.
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EFeature#getSettings()
	 * @see #getEFeature()
	 * @generated
	 */
	EReference getEFeature_Settings();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.confml.editor.view.vemodel.EFeature#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EFeature#getName()
	 * @see #getEFeature()
	 * @generated
	 */
	EAttribute getEFeature_Name();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>ESetting Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ESetting Entry</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString" keyRequired="true"
	 *        valueType="com.nokia.tools.vct.confml.editor.view.vemodel.ESetting" valueContainment="true" valueRequired="true"
	 * @generated
	 */
	EClass getESettingEntry();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getESettingEntry()
	 * @generated
	 */
	EAttribute getESettingEntry_Key();

	/**
	 * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getESettingEntry()
	 * @generated
	 */
	EReference getESettingEntry_Value();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.confml.editor.view.vemodel.EDescriptionContainer <em>EDescription Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EDescription Container</em>'.
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EDescriptionContainer
	 * @generated
	 */
	EClass getEDescriptionContainer();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.confml.editor.view.vemodel.EDescriptionContainer#getDescriptionText <em>Description Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description Text</em>'.
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EDescriptionContainer#getDescriptionText()
	 * @see #getEDescriptionContainer()
	 * @generated
	 */
	EAttribute getEDescriptionContainer_DescriptionText();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.confml.editor.view.vemodel.EDescriptionContainer#getDescriptionUri <em>Description Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description Uri</em>'.
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EDescriptionContainer#getDescriptionUri()
	 * @see #getEDescriptionContainer()
	 * @generated
	 */
	EAttribute getEDescriptionContainer_DescriptionUri();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.confml.editor.view.vemodel.EDescriptionContainer#getDescriptionUriTitle <em>Description Uri Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description Uri Title</em>'.
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EDescriptionContainer#getDescriptionUriTitle()
	 * @see #getEDescriptionContainer()
	 * @generated
	 */
	EAttribute getEDescriptionContainer_DescriptionUriTitle();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.confml.editor.view.vemodel.EIconContainer <em>EIcon Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EIcon Container</em>'.
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EIconContainer
	 * @generated
	 */
	EClass getEIconContainer();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.confml.editor.view.vemodel.EIconContainer#getIconUri <em>Icon Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Icon Uri</em>'.
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EIconContainer#getIconUri()
	 * @see #getEIconContainer()
	 * @generated
	 */
	EAttribute getEIconContainer_IconUri();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.confml.editor.view.vemodel.EIconContainer#getIconUriTitle <em>Icon Uri Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Icon Uri Title</em>'.
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EIconContainer#getIconUriTitle()
	 * @see #getEIconContainer()
	 * @generated
	 */
	EAttribute getEIconContainer_IconUriTitle();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.confml.editor.view.vemodel.EResourceLocator <em>EResource Locator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EResource Locator</em>'.
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EResourceLocator
	 * @generated
	 */
	EClass getEResourceLocator();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.confml.editor.view.vemodel.EResourceLocator#getResourceUri <em>Resource Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resource Uri</em>'.
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EResourceLocator#getResourceUri()
	 * @see #getEResourceLocator()
	 * @generated
	 */
	EAttribute getEResourceLocator_ResourceUri();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.confml.editor.view.vemodel.ERefTarget <em>ERef Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ERef Target</em>'.
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.ERefTarget
	 * @generated
	 */
	EClass getERefTarget();

	/**
	 * Returns the meta object for the reference list '{@link com.nokia.tools.vct.confml.editor.view.vemodel.ERefTarget#getRefs <em>Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Refs</em>'.
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.ERefTarget#getRefs()
	 * @see #getERefTarget()
	 * @generated
	 */
	EReference getERefTarget_Refs();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>EFeature Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EFeature Entry</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString" keyRequired="true"
	 *        valueType="com.nokia.tools.vct.confml.editor.view.vemodel.EFeature" valueContainment="true" valueRequired="true"
	 * @generated
	 */
	EClass getEFeatureEntry();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEFeatureEntry()
	 * @generated
	 */
	EAttribute getEFeatureEntry_Key();

	/**
	 * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEFeatureEntry()
	 * @generated
	 */
	EReference getEFeatureEntry_Value();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.confml.editor.view.vemodel.ESetting <em>ESetting</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ESetting</em>'.
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.ESetting
	 * @generated
	 */
	EClass getESetting();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.confml.editor.view.vemodel.ESetting#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.ESetting#getName()
	 * @see #getESetting()
	 * @generated
	 */
	EAttribute getESetting_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.confml.editor.view.vemodel.ESetting#isReadOnly <em>Read Only</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Read Only</em>'.
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.ESetting#isReadOnly()
	 * @see #getESetting()
	 * @generated
	 */
	EAttribute getESetting_ReadOnly();

	/**
	 * Returns the meta object for the map '{@link com.nokia.tools.vct.confml.editor.view.vemodel.ESetting#getSubSettings <em>Sub Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Sub Settings</em>'.
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.ESetting#getSubSettings()
	 * @see #getESetting()
	 * @generated
	 */
	EReference getESetting_SubSettings();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>EView Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EView Entry</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString" keyRequired="true"
	 *        valueType="com.nokia.tools.vct.confml.editor.view.vemodel.EView" valueContainment="true" valueRequired="true"
	 * @generated
	 */
	EClass getEViewEntry();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEViewEntry()
	 * @generated
	 */
	EAttribute getEViewEntry_Key();

	/**
	 * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEViewEntry()
	 * @generated
	 */
	EReference getEViewEntry_Value();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.confml.editor.view.vemodel.ERefProperty <em>ERef Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ERef Property</em>'.
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.ERefProperty
	 * @generated
	 */
	EClass getERefProperty();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.confml.editor.view.vemodel.ERefProperty#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.ERefProperty#getName()
	 * @see #getERefProperty()
	 * @generated
	 */
	EAttribute getERefProperty_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.confml.editor.view.vemodel.ERefProperty#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.ERefProperty#getValue()
	 * @see #getERefProperty()
	 * @generated
	 */
	EAttribute getERefProperty_Value();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.confml.editor.view.vemodel.ERefProperty#getUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unit</em>'.
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.ERefProperty#getUnit()
	 * @see #getERefProperty()
	 * @generated
	 */
	EAttribute getERefProperty_Unit();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.confml.editor.view.vemodel.ERefOption <em>ERef Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ERef Option</em>'.
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.ERefOption
	 * @generated
	 */
	EClass getERefOption();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.confml.editor.view.vemodel.ERefOption#getMap <em>Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Map</em>'.
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.ERefOption#getMap()
	 * @see #getERefOption()
	 * @generated
	 */
	EAttribute getERefOption_Map();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.confml.editor.view.vemodel.ERefOption#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.ERefOption#getName()
	 * @see #getERefOption()
	 * @generated
	 */
	EAttribute getERefOption_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.confml.editor.view.vemodel.ERefOption#getRelevant <em>Relevant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Relevant</em>'.
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.ERefOption#getRelevant()
	 * @see #getERefOption()
	 * @generated
	 */
	EAttribute getERefOption_Relevant();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.confml.editor.view.vemodel.ERefOption#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.ERefOption#getValue()
	 * @see #getERefOption()
	 * @generated
	 */
	EAttribute getERefOption_Value();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.confml.editor.view.vemodel.EGroupEntry <em>EGroup Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EGroup Entry</em>'.
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EGroupEntry
	 * @generated
	 */
	EClass getEGroupEntry();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.confml.editor.view.vemodel.EGroupEntry#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EGroupEntry#getName()
	 * @see #getEGroupEntry()
	 * @generated
	 */
	EAttribute getEGroupEntry_Name();

	/**
	 * Returns the meta object for data type '{@link java.net.URI <em>EJava URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>EJava URI</em>'.
	 * @see java.net.URI
	 * @model instanceClass="java.net.URI"
	 * @generated
	 */
	EDataType getEJavaURI();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EViewEditorFactory getEViewEditorFactory();

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
		 * The meta object literal for the '{@link com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewsEditorDocumentImpl <em>EViews Editor Document</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewsEditorDocumentImpl
		 * @see com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewEditorPackageImpl#getEViewsEditorDocument()
		 * @generated
		 */
		EClass EVIEWS_EDITOR_DOCUMENT = eINSTANCE.getEViewsEditorDocument();

		/**
		 * The meta object literal for the '<em><b>Views</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVIEWS_EDITOR_DOCUMENT__VIEWS = eINSTANCE.getEViewsEditorDocument_Views();

		/**
		 * The meta object literal for the '<em><b>Use Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVIEWS_EDITOR_DOCUMENT__USE_COUNT = eINSTANCE.getEViewsEditorDocument_UseCount();

		/**
		 * The meta object literal for the '<em><b>Features</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVIEWS_EDITOR_DOCUMENT__FEATURES = eINSTANCE.getEViewsEditorDocument_Features();

		/**
		 * The meta object literal for the '<em><b>All Views</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVIEWS_EDITOR_DOCUMENT__ALL_VIEWS = eINSTANCE.getEViewsEditorDocument_AllViews();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewImpl <em>EView</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewImpl
		 * @see com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewEditorPackageImpl#getEView()
		 * @generated
		 */
		EClass EVIEW = eINSTANCE.getEView();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVIEW__ID = eINSTANCE.getEView_Id();

		/**
		 * The meta object literal for the '<em><b>Inclusion URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVIEW__INCLUSION_URI = eINSTANCE.getEView_InclusionURI();

		/**
		 * The meta object literal for the '<em><b>File URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVIEW__FILE_URI = eINSTANCE.getEView_FileURI();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.confml.editor.view.vemodel.impl.EGroupImpl <em>EGroup</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.confml.editor.view.vemodel.impl.EGroupImpl
		 * @see com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewEditorPackageImpl#getEGroup()
		 * @generated
		 */
		EClass EGROUP = eINSTANCE.getEGroup();

		/**
		 * The meta object literal for the '<em><b>Refs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EGROUP__REFS = eINSTANCE.getEGroup_Refs();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.confml.editor.view.vemodel.EGroupContainer <em>EGroup Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EGroupContainer
		 * @see com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewEditorPackageImpl#getEGroupContainer()
		 * @generated
		 */
		EClass EGROUP_CONTAINER = eINSTANCE.getEGroupContainer();

		/**
		 * The meta object literal for the '<em><b>Groups And Views</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EGROUP_CONTAINER__GROUPS_AND_VIEWS = eINSTANCE.getEGroupContainer_GroupsAndViews();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.confml.editor.view.vemodel.impl.ESettingRefImpl <em>ESetting Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.confml.editor.view.vemodel.impl.ESettingRefImpl
		 * @see com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewEditorPackageImpl#getESettingRef()
		 * @generated
		 */
		EClass ESETTING_REF = eINSTANCE.getESettingRef();

		/**
		 * The meta object literal for the '<em><b>Feature Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESETTING_REF__FEATURE_ID = eINSTANCE.getESettingRef_FeatureId();

		/**
		 * The meta object literal for the '<em><b>Setting Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESETTING_REF__SETTING_ID = eINSTANCE.getESettingRef_SettingId();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ESETTING_REF__TARGET = eINSTANCE.getESettingRef_Target();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESETTING_REF__NAME = eINSTANCE.getESettingRef_Name();

		/**
		 * The meta object literal for the '<em><b>Min Inclusive</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESETTING_REF__MIN_INCLUSIVE = eINSTANCE.getESettingRef_MinInclusive();

		/**
		 * The meta object literal for the '<em><b>Max Inclusive</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESETTING_REF__MAX_INCLUSIVE = eINSTANCE.getESettingRef_MaxInclusive();

		/**
		 * The meta object literal for the '<em><b>Min Exclusive</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESETTING_REF__MIN_EXCLUSIVE = eINSTANCE.getESettingRef_MinExclusive();

		/**
		 * The meta object literal for the '<em><b>Max Exclusive</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESETTING_REF__MAX_EXCLUSIVE = eINSTANCE.getESettingRef_MaxExclusive();

		/**
		 * The meta object literal for the '<em><b>Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESETTING_REF__LENGTH = eINSTANCE.getESettingRef_Length();

		/**
		 * The meta object literal for the '<em><b>Max Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESETTING_REF__MAX_LENGTH = eINSTANCE.getESettingRef_MaxLength();

		/**
		 * The meta object literal for the '<em><b>Min Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESETTING_REF__MIN_LENGTH = eINSTANCE.getESettingRef_MinLength();

		/**
		 * The meta object literal for the '<em><b>Patterns</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESETTING_REF__PATTERNS = eINSTANCE.getESettingRef_Patterns();

		/**
		 * The meta object literal for the '<em><b>Options</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ESETTING_REF__OPTIONS = eINSTANCE.getESettingRef_Options();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ESETTING_REF__PROPERTIES = eINSTANCE.getESettingRef_Properties();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.confml.editor.view.vemodel.impl.EFeatureImpl <em>EFeature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.confml.editor.view.vemodel.impl.EFeatureImpl
		 * @see com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewEditorPackageImpl#getEFeature()
		 * @generated
		 */
		EClass EFEATURE = eINSTANCE.getEFeature();

		/**
		 * The meta object literal for the '<em><b>Settings</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EFEATURE__SETTINGS = eINSTANCE.getEFeature_Settings();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EFEATURE__NAME = eINSTANCE.getEFeature_Name();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.confml.editor.view.vemodel.impl.ESettingEntryImpl <em>ESetting Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.confml.editor.view.vemodel.impl.ESettingEntryImpl
		 * @see com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewEditorPackageImpl#getESettingEntry()
		 * @generated
		 */
		EClass ESETTING_ENTRY = eINSTANCE.getESettingEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESETTING_ENTRY__KEY = eINSTANCE.getESettingEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ESETTING_ENTRY__VALUE = eINSTANCE.getESettingEntry_Value();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.confml.editor.view.vemodel.EDescriptionContainer <em>EDescription Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EDescriptionContainer
		 * @see com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewEditorPackageImpl#getEDescriptionContainer()
		 * @generated
		 */
		EClass EDESCRIPTION_CONTAINER = eINSTANCE.getEDescriptionContainer();

		/**
		 * The meta object literal for the '<em><b>Description Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDESCRIPTION_CONTAINER__DESCRIPTION_TEXT = eINSTANCE.getEDescriptionContainer_DescriptionText();

		/**
		 * The meta object literal for the '<em><b>Description Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDESCRIPTION_CONTAINER__DESCRIPTION_URI = eINSTANCE.getEDescriptionContainer_DescriptionUri();

		/**
		 * The meta object literal for the '<em><b>Description Uri Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDESCRIPTION_CONTAINER__DESCRIPTION_URI_TITLE = eINSTANCE.getEDescriptionContainer_DescriptionUriTitle();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.confml.editor.view.vemodel.EIconContainer <em>EIcon Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EIconContainer
		 * @see com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewEditorPackageImpl#getEIconContainer()
		 * @generated
		 */
		EClass EICON_CONTAINER = eINSTANCE.getEIconContainer();

		/**
		 * The meta object literal for the '<em><b>Icon Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EICON_CONTAINER__ICON_URI = eINSTANCE.getEIconContainer_IconUri();

		/**
		 * The meta object literal for the '<em><b>Icon Uri Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EICON_CONTAINER__ICON_URI_TITLE = eINSTANCE.getEIconContainer_IconUriTitle();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.confml.editor.view.vemodel.EResourceLocator <em>EResource Locator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EResourceLocator
		 * @see com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewEditorPackageImpl#getEResourceLocator()
		 * @generated
		 */
		EClass ERESOURCE_LOCATOR = eINSTANCE.getEResourceLocator();

		/**
		 * The meta object literal for the '<em><b>Resource Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ERESOURCE_LOCATOR__RESOURCE_URI = eINSTANCE.getEResourceLocator_ResourceUri();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.confml.editor.view.vemodel.ERefTarget <em>ERef Target</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.confml.editor.view.vemodel.ERefTarget
		 * @see com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewEditorPackageImpl#getERefTarget()
		 * @generated
		 */
		EClass EREF_TARGET = eINSTANCE.getERefTarget();

		/**
		 * The meta object literal for the '<em><b>Refs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EREF_TARGET__REFS = eINSTANCE.getERefTarget_Refs();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.confml.editor.view.vemodel.impl.EFeatureEntryImpl <em>EFeature Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.confml.editor.view.vemodel.impl.EFeatureEntryImpl
		 * @see com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewEditorPackageImpl#getEFeatureEntry()
		 * @generated
		 */
		EClass EFEATURE_ENTRY = eINSTANCE.getEFeatureEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EFEATURE_ENTRY__KEY = eINSTANCE.getEFeatureEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EFEATURE_ENTRY__VALUE = eINSTANCE.getEFeatureEntry_Value();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.confml.editor.view.vemodel.impl.ESettingImpl <em>ESetting</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.confml.editor.view.vemodel.impl.ESettingImpl
		 * @see com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewEditorPackageImpl#getESetting()
		 * @generated
		 */
		EClass ESETTING = eINSTANCE.getESetting();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESETTING__NAME = eINSTANCE.getESetting_Name();

		/**
		 * The meta object literal for the '<em><b>Read Only</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESETTING__READ_ONLY = eINSTANCE.getESetting_ReadOnly();

		/**
		 * The meta object literal for the '<em><b>Sub Settings</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ESETTING__SUB_SETTINGS = eINSTANCE.getESetting_SubSettings();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewEntryImpl <em>EView Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewEntryImpl
		 * @see com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewEditorPackageImpl#getEViewEntry()
		 * @generated
		 */
		EClass EVIEW_ENTRY = eINSTANCE.getEViewEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVIEW_ENTRY__KEY = eINSTANCE.getEViewEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVIEW_ENTRY__VALUE = eINSTANCE.getEViewEntry_Value();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.confml.editor.view.vemodel.impl.ERefPropertyImpl <em>ERef Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.confml.editor.view.vemodel.impl.ERefPropertyImpl
		 * @see com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewEditorPackageImpl#getERefProperty()
		 * @generated
		 */
		EClass EREF_PROPERTY = eINSTANCE.getERefProperty();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EREF_PROPERTY__NAME = eINSTANCE.getERefProperty_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EREF_PROPERTY__VALUE = eINSTANCE.getERefProperty_Value();

		/**
		 * The meta object literal for the '<em><b>Unit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EREF_PROPERTY__UNIT = eINSTANCE.getERefProperty_Unit();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.confml.editor.view.vemodel.impl.ERefOptionImpl <em>ERef Option</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.confml.editor.view.vemodel.impl.ERefOptionImpl
		 * @see com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewEditorPackageImpl#getERefOption()
		 * @generated
		 */
		EClass EREF_OPTION = eINSTANCE.getERefOption();

		/**
		 * The meta object literal for the '<em><b>Map</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EREF_OPTION__MAP = eINSTANCE.getERefOption_Map();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EREF_OPTION__NAME = eINSTANCE.getERefOption_Name();

		/**
		 * The meta object literal for the '<em><b>Relevant</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EREF_OPTION__RELEVANT = eINSTANCE.getERefOption_Relevant();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EREF_OPTION__VALUE = eINSTANCE.getERefOption_Value();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.confml.editor.view.vemodel.impl.EGroupEntryImpl <em>EGroup Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.confml.editor.view.vemodel.impl.EGroupEntryImpl
		 * @see com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewEditorPackageImpl#getEGroupEntry()
		 * @generated
		 */
		EClass EGROUP_ENTRY = eINSTANCE.getEGroupEntry();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EGROUP_ENTRY__NAME = eINSTANCE.getEGroupEntry_Name();

		/**
		 * The meta object literal for the '<em>EJava URI</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.net.URI
		 * @see com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewEditorPackageImpl#getEJavaURI()
		 * @generated
		 */
		EDataType EJAVA_URI = eINSTANCE.getEJavaURI();

	}

} //EViewEditorPackage
