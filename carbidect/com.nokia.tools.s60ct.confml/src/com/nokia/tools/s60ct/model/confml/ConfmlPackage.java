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
package com.nokia.tools.s60ct.model.confml;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
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
 * @see com.nokia.tools.s60ct.model.confml.ConfmlFactory
 * @model kind="package"
 * @generated
 */
public interface ConfmlPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "confml";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.nokia.com/xml/ns/s60ct-confml";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "nsc";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ConfmlPackage eINSTANCE = com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.nokia.tools.s60ct.model.confml.EDescriptionContainer <em>EDescription Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.s60ct.model.confml.EDescriptionContainer
	 * @see com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl#getEDescriptionContainer()
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
	 * The feature id for the '<em><b>Description Uri Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDESCRIPTION_CONTAINER__DESCRIPTION_URI_TEXT = 2;

	/**
	 * The number of structural features of the '<em>EDescription Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDESCRIPTION_CONTAINER_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link com.nokia.tools.s60ct.model.confml.impl.EFeatureImpl <em>EFeature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.s60ct.model.confml.impl.EFeatureImpl
	 * @see com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl#getEFeature()
	 * @generated
	 */
	int EFEATURE = 0;

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
	 * The feature id for the '<em><b>Description Uri Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFEATURE__DESCRIPTION_URI_TEXT = EDESCRIPTION_CONTAINER__DESCRIPTION_URI_TEXT;

	/**
	 * The feature id for the '<em><b>Icon Uri Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFEATURE__ICON_URI_TITLE = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Icon Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFEATURE__ICON_URI = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Link Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFEATURE__LINK_URI = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Link Uri Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFEATURE__LINK_URI_TITLE = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Settings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFEATURE__SETTINGS = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFEATURE__REF = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFEATURE__NAME = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Relevant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFEATURE__RELEVANT = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Relevant AST</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFEATURE__RELEVANT_AST = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Computed Relevant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFEATURE__COMPUTED_RELEVANT = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>EFeature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFEATURE_FEATURE_COUNT = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 10;

	/**
	 * The meta object id for the '{@link com.nokia.tools.s60ct.model.confml.impl.ESettingImpl <em>ESetting</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.s60ct.model.confml.impl.ESettingImpl
	 * @see com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl#getESetting()
	 * @generated
	 */
	int ESETTING = 1;

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
	 * The feature id for the '<em><b>Description Uri Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING__DESCRIPTION_URI_TEXT = EDESCRIPTION_CONTAINER__DESCRIPTION_URI_TEXT;

	/**
	 * The feature id for the '<em><b>Icon Uri Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING__ICON_URI_TITLE = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Icon Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING__ICON_URI = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Link Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING__LINK_URI = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Link Uri Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING__LINK_URI_TITLE = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING__NAME = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING__REF = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Rfs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING__RFS = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING__VALUE = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING__DEFAULT_VALUE = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Default Rfs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING__DEFAULT_RFS = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING__READ_ONLY = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING__CONSTRAINT = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Relevant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING__RELEVANT = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING__REQUIRED = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING__PROPERTIES = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Deprecated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING__DEPRECATED = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Modified</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING__MODIFIED = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 16;

	/**
	 * The feature id for the '<em><b>Setdefault</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING__SETDEFAULT = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 17;

	/**
	 * The feature id for the '<em><b>Computed Relevant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING__COMPUTED_RELEVANT = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 18;

	/**
	 * The feature id for the '<em><b>Computed Constraint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING__COMPUTED_CONSTRAINT = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 19;

	/**
	 * The feature id for the '<em><b>Relevant AST</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING__RELEVANT_AST = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 20;

	/**
	 * The feature id for the '<em><b>Constraint AST</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING__CONSTRAINT_AST = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 21;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING__DEPENDENCIES = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 22;

	/**
	 * The feature id for the '<em><b>Option Dependencies</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING__OPTION_DEPENDENCIES = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 23;

	/**
	 * The feature id for the '<em><b>Value Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING__VALUE_NULL = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 24;

	/**
	 * The feature id for the '<em><b>Notes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING__NOTES = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 25;

	/**
	 * The number of structural features of the '<em>ESetting</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_FEATURE_COUNT = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 26;

	/**
	 * The meta object id for the '{@link com.nokia.tools.s60ct.model.confml.impl.ESettingOptionImpl <em>ESetting Option</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.s60ct.model.confml.impl.ESettingOptionImpl
	 * @see com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl#getESettingOption()
	 * @generated
	 */
	int ESETTING_OPTION = 2;

	/**
	 * The feature id for the '<em><b>Description Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_OPTION__DESCRIPTION_TEXT = EDESCRIPTION_CONTAINER__DESCRIPTION_TEXT;

	/**
	 * The feature id for the '<em><b>Description Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_OPTION__DESCRIPTION_URI = EDESCRIPTION_CONTAINER__DESCRIPTION_URI;

	/**
	 * The feature id for the '<em><b>Description Uri Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_OPTION__DESCRIPTION_URI_TEXT = EDESCRIPTION_CONTAINER__DESCRIPTION_URI_TEXT;

	/**
	 * The feature id for the '<em><b>Relevant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_OPTION__RELEVANT = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Relevant AST</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_OPTION__RELEVANT_AST = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Computed Relevant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_OPTION__COMPUTED_RELEVANT = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>ESetting Option</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_OPTION_FEATURE_COUNT = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.nokia.tools.s60ct.model.confml.impl.ESimpleSettingImpl <em>ESimple Setting</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.s60ct.model.confml.impl.ESimpleSettingImpl
	 * @see com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl#getESimpleSetting()
	 * @generated
	 */
	int ESIMPLE_SETTING = 3;

	/**
	 * The feature id for the '<em><b>Description Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESIMPLE_SETTING__DESCRIPTION_TEXT = ESETTING__DESCRIPTION_TEXT;

	/**
	 * The feature id for the '<em><b>Description Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESIMPLE_SETTING__DESCRIPTION_URI = ESETTING__DESCRIPTION_URI;

	/**
	 * The feature id for the '<em><b>Description Uri Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESIMPLE_SETTING__DESCRIPTION_URI_TEXT = ESETTING__DESCRIPTION_URI_TEXT;

	/**
	 * The feature id for the '<em><b>Icon Uri Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESIMPLE_SETTING__ICON_URI_TITLE = ESETTING__ICON_URI_TITLE;

	/**
	 * The feature id for the '<em><b>Icon Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESIMPLE_SETTING__ICON_URI = ESETTING__ICON_URI;

	/**
	 * The feature id for the '<em><b>Link Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESIMPLE_SETTING__LINK_URI = ESETTING__LINK_URI;

	/**
	 * The feature id for the '<em><b>Link Uri Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESIMPLE_SETTING__LINK_URI_TITLE = ESETTING__LINK_URI_TITLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESIMPLE_SETTING__NAME = ESETTING__NAME;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESIMPLE_SETTING__REF = ESETTING__REF;

	/**
	 * The feature id for the '<em><b>Rfs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESIMPLE_SETTING__RFS = ESETTING__RFS;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESIMPLE_SETTING__VALUE = ESETTING__VALUE;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESIMPLE_SETTING__DEFAULT_VALUE = ESETTING__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Default Rfs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESIMPLE_SETTING__DEFAULT_RFS = ESETTING__DEFAULT_RFS;

	/**
	 * The feature id for the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESIMPLE_SETTING__READ_ONLY = ESETTING__READ_ONLY;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESIMPLE_SETTING__CONSTRAINT = ESETTING__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Relevant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESIMPLE_SETTING__RELEVANT = ESETTING__RELEVANT;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESIMPLE_SETTING__REQUIRED = ESETTING__REQUIRED;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESIMPLE_SETTING__PROPERTIES = ESETTING__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Deprecated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESIMPLE_SETTING__DEPRECATED = ESETTING__DEPRECATED;

	/**
	 * The feature id for the '<em><b>Modified</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESIMPLE_SETTING__MODIFIED = ESETTING__MODIFIED;

	/**
	 * The feature id for the '<em><b>Setdefault</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESIMPLE_SETTING__SETDEFAULT = ESETTING__SETDEFAULT;

	/**
	 * The feature id for the '<em><b>Computed Relevant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESIMPLE_SETTING__COMPUTED_RELEVANT = ESETTING__COMPUTED_RELEVANT;

	/**
	 * The feature id for the '<em><b>Computed Constraint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESIMPLE_SETTING__COMPUTED_CONSTRAINT = ESETTING__COMPUTED_CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Relevant AST</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESIMPLE_SETTING__RELEVANT_AST = ESETTING__RELEVANT_AST;

	/**
	 * The feature id for the '<em><b>Constraint AST</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESIMPLE_SETTING__CONSTRAINT_AST = ESETTING__CONSTRAINT_AST;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESIMPLE_SETTING__DEPENDENCIES = ESETTING__DEPENDENCIES;

	/**
	 * The feature id for the '<em><b>Option Dependencies</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESIMPLE_SETTING__OPTION_DEPENDENCIES = ESETTING__OPTION_DEPENDENCIES;

	/**
	 * The feature id for the '<em><b>Value Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESIMPLE_SETTING__VALUE_NULL = ESETTING__VALUE_NULL;

	/**
	 * The feature id for the '<em><b>Notes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESIMPLE_SETTING__NOTES = ESETTING__NOTES;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESIMPLE_SETTING__TYPE = ESETTING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Min Inclusive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESIMPLE_SETTING__MIN_INCLUSIVE = ESETTING_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Max Inclusive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESIMPLE_SETTING__MAX_INCLUSIVE = ESETTING_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Min Exclusive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESIMPLE_SETTING__MIN_EXCLUSIVE = ESETTING_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Max Exclusive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESIMPLE_SETTING__MAX_EXCLUSIVE = ESETTING_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Min Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESIMPLE_SETTING__MIN_LENGTH = ESETTING_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Max Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESIMPLE_SETTING__MAX_LENGTH = ESETTING_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESIMPLE_SETTING__LENGTH = ESETTING_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESIMPLE_SETTING__PATTERN = ESETTING_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Total Digits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESIMPLE_SETTING__TOTAL_DIGITS = ESETTING_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Options</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESIMPLE_SETTING__OPTIONS = ESETTING_FEATURE_COUNT + 10;

	/**
	 * The number of structural features of the '<em>ESimple Setting</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESIMPLE_SETTING_FEATURE_COUNT = ESETTING_FEATURE_COUNT + 11;

	/**
	 * The meta object id for the '{@link com.nokia.tools.s60ct.model.confml.impl.ESequenceSettingImpl <em>ESequence Setting</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.s60ct.model.confml.impl.ESequenceSettingImpl
	 * @see com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl#getESequenceSetting()
	 * @generated
	 */
	int ESEQUENCE_SETTING = 4;

	/**
	 * The feature id for the '<em><b>Description Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESEQUENCE_SETTING__DESCRIPTION_TEXT = ESETTING__DESCRIPTION_TEXT;

	/**
	 * The feature id for the '<em><b>Description Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESEQUENCE_SETTING__DESCRIPTION_URI = ESETTING__DESCRIPTION_URI;

	/**
	 * The feature id for the '<em><b>Description Uri Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESEQUENCE_SETTING__DESCRIPTION_URI_TEXT = ESETTING__DESCRIPTION_URI_TEXT;

	/**
	 * The feature id for the '<em><b>Icon Uri Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESEQUENCE_SETTING__ICON_URI_TITLE = ESETTING__ICON_URI_TITLE;

	/**
	 * The feature id for the '<em><b>Icon Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESEQUENCE_SETTING__ICON_URI = ESETTING__ICON_URI;

	/**
	 * The feature id for the '<em><b>Link Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESEQUENCE_SETTING__LINK_URI = ESETTING__LINK_URI;

	/**
	 * The feature id for the '<em><b>Link Uri Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESEQUENCE_SETTING__LINK_URI_TITLE = ESETTING__LINK_URI_TITLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESEQUENCE_SETTING__NAME = ESETTING__NAME;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESEQUENCE_SETTING__REF = ESETTING__REF;

	/**
	 * The feature id for the '<em><b>Rfs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESEQUENCE_SETTING__RFS = ESETTING__RFS;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESEQUENCE_SETTING__VALUE = ESETTING__VALUE;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESEQUENCE_SETTING__DEFAULT_VALUE = ESETTING__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Default Rfs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESEQUENCE_SETTING__DEFAULT_RFS = ESETTING__DEFAULT_RFS;

	/**
	 * The feature id for the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESEQUENCE_SETTING__READ_ONLY = ESETTING__READ_ONLY;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESEQUENCE_SETTING__CONSTRAINT = ESETTING__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Relevant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESEQUENCE_SETTING__RELEVANT = ESETTING__RELEVANT;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESEQUENCE_SETTING__REQUIRED = ESETTING__REQUIRED;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESEQUENCE_SETTING__PROPERTIES = ESETTING__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Deprecated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESEQUENCE_SETTING__DEPRECATED = ESETTING__DEPRECATED;

	/**
	 * The feature id for the '<em><b>Modified</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESEQUENCE_SETTING__MODIFIED = ESETTING__MODIFIED;

	/**
	 * The feature id for the '<em><b>Setdefault</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESEQUENCE_SETTING__SETDEFAULT = ESETTING__SETDEFAULT;

	/**
	 * The feature id for the '<em><b>Computed Relevant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESEQUENCE_SETTING__COMPUTED_RELEVANT = ESETTING__COMPUTED_RELEVANT;

	/**
	 * The feature id for the '<em><b>Computed Constraint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESEQUENCE_SETTING__COMPUTED_CONSTRAINT = ESETTING__COMPUTED_CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Relevant AST</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESEQUENCE_SETTING__RELEVANT_AST = ESETTING__RELEVANT_AST;

	/**
	 * The feature id for the '<em><b>Constraint AST</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESEQUENCE_SETTING__CONSTRAINT_AST = ESETTING__CONSTRAINT_AST;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESEQUENCE_SETTING__DEPENDENCIES = ESETTING__DEPENDENCIES;

	/**
	 * The feature id for the '<em><b>Option Dependencies</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESEQUENCE_SETTING__OPTION_DEPENDENCIES = ESETTING__OPTION_DEPENDENCIES;

	/**
	 * The feature id for the '<em><b>Value Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESEQUENCE_SETTING__VALUE_NULL = ESETTING__VALUE_NULL;

	/**
	 * The feature id for the '<em><b>Notes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESEQUENCE_SETTING__NOTES = ESETTING__NOTES;

	/**
	 * The feature id for the '<em><b>Sub Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESEQUENCE_SETTING__SUB_TYPES = ESETTING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Min Occurs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESEQUENCE_SETTING__MIN_OCCURS = ESETTING_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Max Occurs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESEQUENCE_SETTING__MAX_OCCURS = ESETTING_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESEQUENCE_SETTING__ITEMS = ESETTING_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Template</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESEQUENCE_SETTING__TEMPLATE = ESETTING_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Map Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESEQUENCE_SETTING__MAP_KEY = ESETTING_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Map Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESEQUENCE_SETTING__MAP_VALUE = ESETTING_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Visible Sub Settings</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESEQUENCE_SETTING__VISIBLE_SUB_SETTINGS = ESETTING_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>ESequence Setting</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESEQUENCE_SETTING_FEATURE_COUNT = ESETTING_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link com.nokia.tools.s60ct.model.confml.impl.EItemSettingImpl <em>EItem Setting</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.s60ct.model.confml.impl.EItemSettingImpl
	 * @see com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl#getEItemSetting()
	 * @generated
	 */
	int EITEM_SETTING = 5;

	/**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EITEM_SETTING__NUMBER = 0;

	/**
	 * The feature id for the '<em><b>Sub Settings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EITEM_SETTING__SUB_SETTINGS = 1;

	/**
	 * The feature id for the '<em><b>Fields</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EITEM_SETTING__FIELDS = 2;

	/**
	 * The number of structural features of the '<em>EItem Setting</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EITEM_SETTING_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link com.nokia.tools.s60ct.model.confml.impl.ESubSettingValueImpl <em>ESub Setting Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.s60ct.model.confml.impl.ESubSettingValueImpl
	 * @see com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl#getESubSettingValue()
	 * @generated
	 */
	int ESUB_SETTING_VALUE = 6;

	/**
	 * The feature id for the '<em><b>Simple Setting</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESUB_SETTING_VALUE__SIMPLE_SETTING = 0;

	/**
	 * The number of structural features of the '<em>ESub Setting Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESUB_SETTING_VALUE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.nokia.tools.s60ct.model.confml.EIconContainer <em>EIcon Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.s60ct.model.confml.EIconContainer
	 * @see com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl#getEIconContainer()
	 * @generated
	 */
	int EICON_CONTAINER = 8;

	/**
	 * The feature id for the '<em><b>Icon Uri Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EICON_CONTAINER__ICON_URI_TITLE = 0;

	/**
	 * The feature id for the '<em><b>Icon Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EICON_CONTAINER__ICON_URI = 1;

	/**
	 * The number of structural features of the '<em>EIcon Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EICON_CONTAINER_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.nokia.tools.s60ct.model.confml.EResourceLocator <em>EResource Locator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.s60ct.model.confml.EResourceLocator
	 * @see com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl#getEResourceLocator()
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
	 * The meta object id for the '{@link com.nokia.tools.s60ct.model.confml.impl.ESettingValueImpl <em>ESetting Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.s60ct.model.confml.impl.ESettingValueImpl
	 * @see com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl#getESettingValue()
	 * @generated
	 */
	int ESETTING_VALUE = 10;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_VALUE__REF = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_VALUE__TYPE = 1;

	/**
	 * The feature id for the '<em><b>Map</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_VALUE__MAP = 2;

	/**
	 * The feature id for the '<em><b>Chosen Option</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_VALUE__CHOSEN_OPTION = 3;

	/**
	 * The number of structural features of the '<em>ESetting Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_VALUE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.nokia.tools.s60ct.model.confml.impl.ECompositeSettingImpl <em>EComposite Setting</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.s60ct.model.confml.impl.ECompositeSettingImpl
	 * @see com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl#getECompositeSetting()
	 * @generated
	 */
	int ECOMPOSITE_SETTING = 11;

	/**
	 * The feature id for the '<em><b>Description Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECOMPOSITE_SETTING__DESCRIPTION_TEXT = ESETTING__DESCRIPTION_TEXT;

	/**
	 * The feature id for the '<em><b>Description Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECOMPOSITE_SETTING__DESCRIPTION_URI = ESETTING__DESCRIPTION_URI;

	/**
	 * The feature id for the '<em><b>Description Uri Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECOMPOSITE_SETTING__DESCRIPTION_URI_TEXT = ESETTING__DESCRIPTION_URI_TEXT;

	/**
	 * The feature id for the '<em><b>Icon Uri Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECOMPOSITE_SETTING__ICON_URI_TITLE = ESETTING__ICON_URI_TITLE;

	/**
	 * The feature id for the '<em><b>Icon Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECOMPOSITE_SETTING__ICON_URI = ESETTING__ICON_URI;

	/**
	 * The feature id for the '<em><b>Link Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECOMPOSITE_SETTING__LINK_URI = ESETTING__LINK_URI;

	/**
	 * The feature id for the '<em><b>Link Uri Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECOMPOSITE_SETTING__LINK_URI_TITLE = ESETTING__LINK_URI_TITLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECOMPOSITE_SETTING__NAME = ESETTING__NAME;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECOMPOSITE_SETTING__REF = ESETTING__REF;

	/**
	 * The feature id for the '<em><b>Rfs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECOMPOSITE_SETTING__RFS = ESETTING__RFS;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECOMPOSITE_SETTING__VALUE = ESETTING__VALUE;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECOMPOSITE_SETTING__DEFAULT_VALUE = ESETTING__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Default Rfs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECOMPOSITE_SETTING__DEFAULT_RFS = ESETTING__DEFAULT_RFS;

	/**
	 * The feature id for the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECOMPOSITE_SETTING__READ_ONLY = ESETTING__READ_ONLY;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECOMPOSITE_SETTING__CONSTRAINT = ESETTING__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Relevant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECOMPOSITE_SETTING__RELEVANT = ESETTING__RELEVANT;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECOMPOSITE_SETTING__REQUIRED = ESETTING__REQUIRED;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECOMPOSITE_SETTING__PROPERTIES = ESETTING__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Deprecated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECOMPOSITE_SETTING__DEPRECATED = ESETTING__DEPRECATED;

	/**
	 * The feature id for the '<em><b>Modified</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECOMPOSITE_SETTING__MODIFIED = ESETTING__MODIFIED;

	/**
	 * The feature id for the '<em><b>Setdefault</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECOMPOSITE_SETTING__SETDEFAULT = ESETTING__SETDEFAULT;

	/**
	 * The feature id for the '<em><b>Computed Relevant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECOMPOSITE_SETTING__COMPUTED_RELEVANT = ESETTING__COMPUTED_RELEVANT;

	/**
	 * The feature id for the '<em><b>Computed Constraint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECOMPOSITE_SETTING__COMPUTED_CONSTRAINT = ESETTING__COMPUTED_CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Relevant AST</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECOMPOSITE_SETTING__RELEVANT_AST = ESETTING__RELEVANT_AST;

	/**
	 * The feature id for the '<em><b>Constraint AST</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECOMPOSITE_SETTING__CONSTRAINT_AST = ESETTING__CONSTRAINT_AST;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECOMPOSITE_SETTING__DEPENDENCIES = ESETTING__DEPENDENCIES;

	/**
	 * The feature id for the '<em><b>Option Dependencies</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECOMPOSITE_SETTING__OPTION_DEPENDENCIES = ESETTING__OPTION_DEPENDENCIES;

	/**
	 * The feature id for the '<em><b>Value Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECOMPOSITE_SETTING__VALUE_NULL = ESETTING__VALUE_NULL;

	/**
	 * The feature id for the '<em><b>Notes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECOMPOSITE_SETTING__NOTES = ESETTING__NOTES;

	/**
	 * The feature id for the '<em><b>Sub Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECOMPOSITE_SETTING__SUB_TYPES = ESETTING_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>EComposite Setting</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECOMPOSITE_SETTING_FEATURE_COUNT = ESETTING_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.nokia.tools.s60ct.model.confml.impl.EResourceSettingImpl <em>EResource Setting</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.s60ct.model.confml.impl.EResourceSettingImpl
	 * @see com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl#getEResourceSetting()
	 * @generated
	 */
	int ERESOURCE_SETTING = 12;

	/**
	 * The feature id for the '<em><b>Description Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERESOURCE_SETTING__DESCRIPTION_TEXT = ECOMPOSITE_SETTING__DESCRIPTION_TEXT;

	/**
	 * The feature id for the '<em><b>Description Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERESOURCE_SETTING__DESCRIPTION_URI = ECOMPOSITE_SETTING__DESCRIPTION_URI;

	/**
	 * The feature id for the '<em><b>Description Uri Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERESOURCE_SETTING__DESCRIPTION_URI_TEXT = ECOMPOSITE_SETTING__DESCRIPTION_URI_TEXT;

	/**
	 * The feature id for the '<em><b>Icon Uri Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERESOURCE_SETTING__ICON_URI_TITLE = ECOMPOSITE_SETTING__ICON_URI_TITLE;

	/**
	 * The feature id for the '<em><b>Icon Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERESOURCE_SETTING__ICON_URI = ECOMPOSITE_SETTING__ICON_URI;

	/**
	 * The feature id for the '<em><b>Link Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERESOURCE_SETTING__LINK_URI = ECOMPOSITE_SETTING__LINK_URI;

	/**
	 * The feature id for the '<em><b>Link Uri Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERESOURCE_SETTING__LINK_URI_TITLE = ECOMPOSITE_SETTING__LINK_URI_TITLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERESOURCE_SETTING__NAME = ECOMPOSITE_SETTING__NAME;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERESOURCE_SETTING__REF = ECOMPOSITE_SETTING__REF;

	/**
	 * The feature id for the '<em><b>Rfs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERESOURCE_SETTING__RFS = ECOMPOSITE_SETTING__RFS;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERESOURCE_SETTING__VALUE = ECOMPOSITE_SETTING__VALUE;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERESOURCE_SETTING__DEFAULT_VALUE = ECOMPOSITE_SETTING__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Default Rfs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERESOURCE_SETTING__DEFAULT_RFS = ECOMPOSITE_SETTING__DEFAULT_RFS;

	/**
	 * The feature id for the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERESOURCE_SETTING__READ_ONLY = ECOMPOSITE_SETTING__READ_ONLY;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERESOURCE_SETTING__CONSTRAINT = ECOMPOSITE_SETTING__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Relevant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERESOURCE_SETTING__RELEVANT = ECOMPOSITE_SETTING__RELEVANT;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERESOURCE_SETTING__REQUIRED = ECOMPOSITE_SETTING__REQUIRED;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERESOURCE_SETTING__PROPERTIES = ECOMPOSITE_SETTING__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Deprecated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERESOURCE_SETTING__DEPRECATED = ECOMPOSITE_SETTING__DEPRECATED;

	/**
	 * The feature id for the '<em><b>Modified</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERESOURCE_SETTING__MODIFIED = ECOMPOSITE_SETTING__MODIFIED;

	/**
	 * The feature id for the '<em><b>Setdefault</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERESOURCE_SETTING__SETDEFAULT = ECOMPOSITE_SETTING__SETDEFAULT;

	/**
	 * The feature id for the '<em><b>Computed Relevant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERESOURCE_SETTING__COMPUTED_RELEVANT = ECOMPOSITE_SETTING__COMPUTED_RELEVANT;

	/**
	 * The feature id for the '<em><b>Computed Constraint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERESOURCE_SETTING__COMPUTED_CONSTRAINT = ECOMPOSITE_SETTING__COMPUTED_CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Relevant AST</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERESOURCE_SETTING__RELEVANT_AST = ECOMPOSITE_SETTING__RELEVANT_AST;

	/**
	 * The feature id for the '<em><b>Constraint AST</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERESOURCE_SETTING__CONSTRAINT_AST = ECOMPOSITE_SETTING__CONSTRAINT_AST;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERESOURCE_SETTING__DEPENDENCIES = ECOMPOSITE_SETTING__DEPENDENCIES;

	/**
	 * The feature id for the '<em><b>Option Dependencies</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERESOURCE_SETTING__OPTION_DEPENDENCIES = ECOMPOSITE_SETTING__OPTION_DEPENDENCIES;

	/**
	 * The feature id for the '<em><b>Value Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERESOURCE_SETTING__VALUE_NULL = ECOMPOSITE_SETTING__VALUE_NULL;

	/**
	 * The feature id for the '<em><b>Notes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERESOURCE_SETTING__NOTES = ECOMPOSITE_SETTING__NOTES;

	/**
	 * The feature id for the '<em><b>Sub Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERESOURCE_SETTING__SUB_TYPES = ECOMPOSITE_SETTING__SUB_TYPES;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERESOURCE_SETTING__KIND = ECOMPOSITE_SETTING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Local Path</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERESOURCE_SETTING__LOCAL_PATH = ECOMPOSITE_SETTING_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Target Path</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERESOURCE_SETTING__TARGET_PATH = ECOMPOSITE_SETTING_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>EResource Setting</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERESOURCE_SETTING_FEATURE_COUNT = ECOMPOSITE_SETTING_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.nokia.tools.s60ct.model.confml.ESettingContainer <em>ESetting Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.s60ct.model.confml.ESettingContainer
	 * @see com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl#getESettingContainer()
	 * @generated
	 */
	int ESETTING_CONTAINER = 13;

	/**
	 * The feature id for the '<em><b>Sub Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_CONTAINER__SUB_TYPES = 0;

	/**
	 * The number of structural features of the '<em>ESetting Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_CONTAINER_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.nokia.tools.s60ct.model.confml.impl.ESimpleValueImpl <em>ESimple Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.s60ct.model.confml.impl.ESimpleValueImpl
	 * @see com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl#getESimpleValue()
	 * @generated
	 */
	int ESIMPLE_VALUE = 14;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESIMPLE_VALUE__REF = ESETTING_VALUE__REF;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESIMPLE_VALUE__TYPE = ESETTING_VALUE__TYPE;

	/**
	 * The feature id for the '<em><b>Map</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESIMPLE_VALUE__MAP = ESETTING_VALUE__MAP;

	/**
	 * The feature id for the '<em><b>Chosen Option</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESIMPLE_VALUE__CHOSEN_OPTION = ESETTING_VALUE__CHOSEN_OPTION;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESIMPLE_VALUE__VALUE = ESETTING_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>ESimple Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESIMPLE_VALUE_FEATURE_COUNT = ESETTING_VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.nokia.tools.s60ct.model.confml.impl.ESequenceValueImpl <em>ESequence Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.s60ct.model.confml.impl.ESequenceValueImpl
	 * @see com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl#getESequenceValue()
	 * @generated
	 */
	int ESEQUENCE_VALUE = 15;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESEQUENCE_VALUE__REF = ESETTING_VALUE__REF;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESEQUENCE_VALUE__TYPE = ESETTING_VALUE__TYPE;

	/**
	 * The feature id for the '<em><b>Map</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESEQUENCE_VALUE__MAP = ESETTING_VALUE__MAP;

	/**
	 * The feature id for the '<em><b>Chosen Option</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESEQUENCE_VALUE__CHOSEN_OPTION = ESETTING_VALUE__CHOSEN_OPTION;

	/**
	 * The feature id for the '<em><b>Template</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESEQUENCE_VALUE__TEMPLATE = ESETTING_VALUE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESEQUENCE_VALUE__ITEMS = ESETTING_VALUE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Extension Policy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESEQUENCE_VALUE__EXTENSION_POLICY = ESETTING_VALUE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>ESequence Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESEQUENCE_VALUE_FEATURE_COUNT = ESETTING_VALUE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.nokia.tools.s60ct.model.confml.ESettingValueContainer <em>ESetting Value Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.s60ct.model.confml.ESettingValueContainer
	 * @see com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl#getESettingValueContainer()
	 * @generated
	 */
	int ESETTING_VALUE_CONTAINER = 18;

	/**
	 * The feature id for the '<em><b>Sub Settings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_VALUE_CONTAINER__SUB_SETTINGS = 0;

	/**
	 * The number of structural features of the '<em>ESetting Value Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_VALUE_CONTAINER_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.nokia.tools.s60ct.model.confml.impl.ESequenceValueItemImpl <em>ESequence Value Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.s60ct.model.confml.impl.ESequenceValueItemImpl
	 * @see com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl#getESequenceValueItem()
	 * @generated
	 */
	int ESEQUENCE_VALUE_ITEM = 16;

	/**
	 * The feature id for the '<em><b>Sub Settings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESEQUENCE_VALUE_ITEM__SUB_SETTINGS = ESETTING_VALUE_CONTAINER__SUB_SETTINGS;

	/**
	 * The feature id for the '<em><b>Editable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESEQUENCE_VALUE_ITEM__EDITABLE = ESETTING_VALUE_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Frame Location Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESEQUENCE_VALUE_ITEM__FRAME_LOCATION_URI = ESETTING_VALUE_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Removed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESEQUENCE_VALUE_ITEM__REMOVED = ESETTING_VALUE_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>ESequence Value Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESEQUENCE_VALUE_ITEM_FEATURE_COUNT = ESETTING_VALUE_CONTAINER_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.nokia.tools.s60ct.model.confml.impl.ECompositeValueImpl <em>EComposite Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.s60ct.model.confml.impl.ECompositeValueImpl
	 * @see com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl#getECompositeValue()
	 * @generated
	 */
	int ECOMPOSITE_VALUE = 17;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECOMPOSITE_VALUE__REF = ESETTING_VALUE__REF;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECOMPOSITE_VALUE__TYPE = ESETTING_VALUE__TYPE;

	/**
	 * The feature id for the '<em><b>Map</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECOMPOSITE_VALUE__MAP = ESETTING_VALUE__MAP;

	/**
	 * The feature id for the '<em><b>Chosen Option</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECOMPOSITE_VALUE__CHOSEN_OPTION = ESETTING_VALUE__CHOSEN_OPTION;

	/**
	 * The feature id for the '<em><b>Sub Settings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECOMPOSITE_VALUE__SUB_SETTINGS = ESETTING_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>EComposite Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECOMPOSITE_VALUE_FEATURE_COUNT = ESETTING_VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.nokia.tools.s60ct.model.confml.impl.EResourceValueImpl <em>EResource Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.s60ct.model.confml.impl.EResourceValueImpl
	 * @see com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl#getEResourceValue()
	 * @generated
	 */
	int ERESOURCE_VALUE = 19;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERESOURCE_VALUE__REF = ECOMPOSITE_VALUE__REF;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERESOURCE_VALUE__TYPE = ECOMPOSITE_VALUE__TYPE;

	/**
	 * The feature id for the '<em><b>Map</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERESOURCE_VALUE__MAP = ECOMPOSITE_VALUE__MAP;

	/**
	 * The feature id for the '<em><b>Chosen Option</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERESOURCE_VALUE__CHOSEN_OPTION = ECOMPOSITE_VALUE__CHOSEN_OPTION;

	/**
	 * The feature id for the '<em><b>Sub Settings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERESOURCE_VALUE__SUB_SETTINGS = ECOMPOSITE_VALUE__SUB_SETTINGS;

	/**
	 * The feature id for the '<em><b>Local Path</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERESOURCE_VALUE__LOCAL_PATH = ECOMPOSITE_VALUE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Path</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERESOURCE_VALUE__TARGET_PATH = ECOMPOSITE_VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>EResource Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERESOURCE_VALUE_FEATURE_COUNT = ECOMPOSITE_VALUE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.nokia.tools.s60ct.model.confml.impl.EPropertyImpl <em>EProperty</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.s60ct.model.confml.impl.EPropertyImpl
	 * @see com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl#getEProperty()
	 * @generated
	 */
	int EPROPERTY = 20;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPROPERTY__NAME = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPROPERTY__VALUE = 1;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPROPERTY__UNIT = 2;

	/**
	 * The number of structural features of the '<em>EProperty</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPROPERTY_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link com.nokia.tools.s60ct.model.confml.ELinkContainer <em>ELink Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.s60ct.model.confml.ELinkContainer
	 * @see com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl#getELinkContainer()
	 * @generated
	 */
	int ELINK_CONTAINER = 21;

	/**
	 * The feature id for the '<em><b>Link Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELINK_CONTAINER__LINK_URI = 0;

	/**
	 * The feature id for the '<em><b>Link Uri Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELINK_CONTAINER__LINK_URI_TITLE = 1;

	/**
	 * The number of structural features of the '<em>ELink Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELINK_CONTAINER_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.nokia.tools.s60ct.model.confml.impl.EOptionMapImpl <em>EOption Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.s60ct.model.confml.impl.EOptionMapImpl
	 * @see com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl#getEOptionMap()
	 * @generated
	 */
	int EOPTION_MAP = 22;

	/**
	 * The feature id for the '<em><b>Description Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOPTION_MAP__DESCRIPTION_TEXT = ESETTING_OPTION__DESCRIPTION_TEXT;

	/**
	 * The feature id for the '<em><b>Description Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOPTION_MAP__DESCRIPTION_URI = ESETTING_OPTION__DESCRIPTION_URI;

	/**
	 * The feature id for the '<em><b>Description Uri Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOPTION_MAP__DESCRIPTION_URI_TEXT = ESETTING_OPTION__DESCRIPTION_URI_TEXT;

	/**
	 * The feature id for the '<em><b>Relevant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOPTION_MAP__RELEVANT = ESETTING_OPTION__RELEVANT;

	/**
	 * The feature id for the '<em><b>Relevant AST</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOPTION_MAP__RELEVANT_AST = ESETTING_OPTION__RELEVANT_AST;

	/**
	 * The feature id for the '<em><b>Computed Relevant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOPTION_MAP__COMPUTED_RELEVANT = ESETTING_OPTION__COMPUTED_RELEVANT;

	/**
	 * The feature id for the '<em><b>Map Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOPTION_MAP__MAP_VALUE = ESETTING_OPTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value2 Save</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOPTION_MAP__VALUE2_SAVE = ESETTING_OPTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>EOption Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOPTION_MAP_FEATURE_COUNT = ESETTING_OPTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.nokia.tools.s60ct.model.confml.impl.EOptionImpl <em>EOption</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.s60ct.model.confml.impl.EOptionImpl
	 * @see com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl#getEOption()
	 * @generated
	 */
	int EOPTION = 23;

	/**
	 * The feature id for the '<em><b>Description Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOPTION__DESCRIPTION_TEXT = ESETTING_OPTION__DESCRIPTION_TEXT;

	/**
	 * The feature id for the '<em><b>Description Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOPTION__DESCRIPTION_URI = ESETTING_OPTION__DESCRIPTION_URI;

	/**
	 * The feature id for the '<em><b>Description Uri Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOPTION__DESCRIPTION_URI_TEXT = ESETTING_OPTION__DESCRIPTION_URI_TEXT;

	/**
	 * The feature id for the '<em><b>Relevant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOPTION__RELEVANT = ESETTING_OPTION__RELEVANT;

	/**
	 * The feature id for the '<em><b>Relevant AST</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOPTION__RELEVANT_AST = ESETTING_OPTION__RELEVANT_AST;

	/**
	 * The feature id for the '<em><b>Computed Relevant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOPTION__COMPUTED_RELEVANT = ESETTING_OPTION__COMPUTED_RELEVANT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOPTION__NAME = ESETTING_OPTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOPTION__VALUE = ESETTING_OPTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Map</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOPTION__MAP = ESETTING_OPTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Map Source Setting</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOPTION__MAP_SOURCE_SETTING = ESETTING_OPTION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Option Values</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOPTION__OPTION_VALUES = ESETTING_OPTION_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>EOption</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOPTION_FEATURE_COUNT = ESETTING_OPTION_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link com.nokia.tools.s60ct.model.confml.impl.EValueEditorDocumentImpl <em>EValue Editor Document</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.s60ct.model.confml.impl.EValueEditorDocumentImpl
	 * @see com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl#getEValueEditorDocument()
	 * @generated
	 */
	int EVALUE_EDITOR_DOCUMENT = 24;

	/**
	 * The feature id for the '<em><b>Features</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUE_EDITOR_DOCUMENT__FEATURES = 0;

	/**
	 * The feature id for the '<em><b>Groups</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUE_EDITOR_DOCUMENT__GROUPS = 1;

	/**
	 * The number of structural features of the '<em>EValue Editor Document</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUE_EDITOR_DOCUMENT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.nokia.tools.s60ct.model.confml.impl.PatternImpl <em>Pattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.s60ct.model.confml.impl.PatternImpl
	 * @see com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl#getPattern()
	 * @generated
	 */
	int PATTERN = 25;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN__VALUE = 0;

	/**
	 * The number of structural features of the '<em>Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.nokia.tools.s60ct.model.confml.impl.ViewImpl <em>View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.s60ct.model.confml.impl.ViewImpl
	 * @see com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl#getView()
	 * @generated
	 */
	int VIEW = 26;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__NAME = 0;

	/**
	 * The feature id for the '<em><b>Shared Setting Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__SHARED_SETTING_INSTANCES = 1;

	/**
	 * The feature id for the '<em><b>Shared Features</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__SHARED_FEATURES = 2;

	/**
	 * The number of structural features of the '<em>View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link com.nokia.tools.s60ct.model.confml.impl.EGroupImpl <em>EGroup</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.s60ct.model.confml.impl.EGroupImpl
	 * @see com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl#getEGroup()
	 * @generated
	 */
	int EGROUP = 27;

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
	 * The feature id for the '<em><b>Description Uri Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EGROUP__DESCRIPTION_URI_TEXT = EDESCRIPTION_CONTAINER__DESCRIPTION_URI_TEXT;

	/**
	 * The feature id for the '<em><b>Features</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EGROUP__FEATURES = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Setting Order</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EGROUP__SETTING_ORDER = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EGROUP__NAME = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>EGroup</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EGROUP_FEATURE_COUNT = EDESCRIPTION_CONTAINER_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.nokia.tools.s60ct.model.confml.ESettingValueType <em>ESetting Value Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.s60ct.model.confml.ESettingValueType
	 * @see com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl#getESettingValueType()
	 * @generated
	 */
	int ESETTING_VALUE_TYPE = 28;

	/**
	 * The meta object id for the '{@link com.nokia.tools.s60ct.model.confml.EExtensionPolicy <em>EExtension Policy</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.s60ct.model.confml.EExtensionPolicy
	 * @see com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl#getEExtensionPolicy()
	 * @generated
	 */
	int EEXTENSION_POLICY = 29;

	/**
	 * The meta object id for the '{@link com.nokia.tools.s60ct.model.confml.EResourceKind <em>EResource Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.s60ct.model.confml.EResourceKind
	 * @see com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl#getEResourceKind()
	 * @generated
	 */
	int ERESOURCE_KIND = 30;

	/**
	 * The meta object id for the '<em>EJava URI</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.net.URI
	 * @see com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl#getEJavaURI()
	 * @generated
	 */
	int EJAVA_URI = 31;


	/**
	 * The meta object id for the '<em>Ecore URI</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.URI
	 * @see com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl#getEcore_URI()
	 * @generated
	 */
	int ECORE_URI = 32;


	/**
	 * Returns the meta object for class '{@link com.nokia.tools.s60ct.model.confml.EFeature <em>EFeature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EFeature</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.EFeature
	 * @generated
	 */
	EClass getEFeature();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.s60ct.model.confml.EFeature#getSettings <em>Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Settings</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.EFeature#getSettings()
	 * @see #getEFeature()
	 * @generated
	 */
	EReference getEFeature_Settings();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.EFeature#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ref</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.EFeature#getRef()
	 * @see #getEFeature()
	 * @generated
	 */
	EAttribute getEFeature_Ref();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.EFeature#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.EFeature#getName()
	 * @see #getEFeature()
	 * @generated
	 */
	EAttribute getEFeature_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.EFeature#getRelevant <em>Relevant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Relevant</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.EFeature#getRelevant()
	 * @see #getEFeature()
	 * @generated
	 */
	EAttribute getEFeature_Relevant();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.EFeature#getRelevantAST <em>Relevant AST</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Relevant AST</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.EFeature#getRelevantAST()
	 * @see #getEFeature()
	 * @generated
	 */
	EAttribute getEFeature_RelevantAST();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.EFeature#isComputedRelevant <em>Computed Relevant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Computed Relevant</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.EFeature#isComputedRelevant()
	 * @see #getEFeature()
	 * @generated
	 */
	EAttribute getEFeature_ComputedRelevant();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.s60ct.model.confml.ESetting <em>ESetting</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ESetting</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESetting
	 * @generated
	 */
	EClass getESetting();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.ESetting#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESetting#getName()
	 * @see #getESetting()
	 * @generated
	 */
	EAttribute getESetting_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.ESetting#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ref</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESetting#getRef()
	 * @see #getESetting()
	 * @generated
	 */
	EAttribute getESetting_Ref();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.ESetting#getRfs <em>Rfs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rfs</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESetting#getRfs()
	 * @see #getESetting()
	 * @generated
	 */
	EAttribute getESetting_Rfs();

	/**
	 * Returns the meta object for the containment reference '{@link com.nokia.tools.s60ct.model.confml.ESetting#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESetting#getValue()
	 * @see #getESetting()
	 * @generated
	 */
	EReference getESetting_Value();

	/**
	 * Returns the meta object for the containment reference '{@link com.nokia.tools.s60ct.model.confml.ESetting#getDefaultValue <em>Default Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Default Value</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESetting#getDefaultValue()
	 * @see #getESetting()
	 * @generated
	 */
	EReference getESetting_DefaultValue();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.ESetting#getDefaultRfs <em>Default Rfs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Rfs</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESetting#getDefaultRfs()
	 * @see #getESetting()
	 * @generated
	 */
	EAttribute getESetting_DefaultRfs();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.ESetting#isReadOnly <em>Read Only</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Read Only</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESetting#isReadOnly()
	 * @see #getESetting()
	 * @generated
	 */
	EAttribute getESetting_ReadOnly();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.ESetting#getConstraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Constraint</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESetting#getConstraint()
	 * @see #getESetting()
	 * @generated
	 */
	EAttribute getESetting_Constraint();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.ESetting#getRelevant <em>Relevant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Relevant</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESetting#getRelevant()
	 * @see #getESetting()
	 * @generated
	 */
	EAttribute getESetting_Relevant();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.ESetting#isRequired <em>Required</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Required</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESetting#isRequired()
	 * @see #getESetting()
	 * @generated
	 */
	EAttribute getESetting_Required();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.s60ct.model.confml.ESetting#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESetting#getProperties()
	 * @see #getESetting()
	 * @generated
	 */
	EReference getESetting_Properties();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.ESetting#isDeprecated <em>Deprecated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Deprecated</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESetting#isDeprecated()
	 * @see #getESetting()
	 * @generated
	 */
	EAttribute getESetting_Deprecated();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.ESetting#isModified <em>Modified</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Modified</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESetting#isModified()
	 * @see #getESetting()
	 * @generated
	 */
	EAttribute getESetting_Modified();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.ESetting#isSetdefault <em>Setdefault</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Setdefault</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESetting#isSetdefault()
	 * @see #getESetting()
	 * @generated
	 */
	EAttribute getESetting_Setdefault();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.ESetting#isComputedRelevant <em>Computed Relevant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Computed Relevant</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESetting#isComputedRelevant()
	 * @see #getESetting()
	 * @generated
	 */
	EAttribute getESetting_ComputedRelevant();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.ESetting#isComputedConstraint <em>Computed Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Computed Constraint</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESetting#isComputedConstraint()
	 * @see #getESetting()
	 * @generated
	 */
	EAttribute getESetting_ComputedConstraint();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.ESetting#getRelevantAST <em>Relevant AST</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Relevant AST</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESetting#getRelevantAST()
	 * @see #getESetting()
	 * @generated
	 */
	EAttribute getESetting_RelevantAST();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.ESetting#getConstraintAST <em>Constraint AST</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Constraint AST</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESetting#getConstraintAST()
	 * @see #getESetting()
	 * @generated
	 */
	EAttribute getESetting_ConstraintAST();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.ESetting#getDependencies <em>Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dependencies</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESetting#getDependencies()
	 * @see #getESetting()
	 * @generated
	 */
	EAttribute getESetting_Dependencies();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.ESetting#getOptionDependencies <em>Option Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Option Dependencies</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESetting#getOptionDependencies()
	 * @see #getESetting()
	 * @generated
	 */
	EAttribute getESetting_OptionDependencies();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.ESetting#isValueNull <em>Value Null</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value Null</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESetting#isValueNull()
	 * @see #getESetting()
	 * @generated
	 */
	EAttribute getESetting_ValueNull();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.ESetting#getNotes <em>Notes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Notes</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESetting#getNotes()
	 * @see #getESetting()
	 * @generated
	 */
	EAttribute getESetting_Notes();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.s60ct.model.confml.ESettingOption <em>ESetting Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ESetting Option</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESettingOption
	 * @generated
	 */
	EClass getESettingOption();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.ESettingOption#getRelevant <em>Relevant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Relevant</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESettingOption#getRelevant()
	 * @see #getESettingOption()
	 * @generated
	 */
	EAttribute getESettingOption_Relevant();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.ESettingOption#getRelevantAST <em>Relevant AST</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Relevant AST</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESettingOption#getRelevantAST()
	 * @see #getESettingOption()
	 * @generated
	 */
	EAttribute getESettingOption_RelevantAST();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.ESettingOption#isComputedRelevant <em>Computed Relevant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Computed Relevant</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESettingOption#isComputedRelevant()
	 * @see #getESettingOption()
	 * @generated
	 */
	EAttribute getESettingOption_ComputedRelevant();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.s60ct.model.confml.ESimpleSetting <em>ESimple Setting</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ESimple Setting</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESimpleSetting
	 * @generated
	 */
	EClass getESimpleSetting();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.ESimpleSetting#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESimpleSetting#getType()
	 * @see #getESimpleSetting()
	 * @generated
	 */
	EAttribute getESimpleSetting_Type();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.ESimpleSetting#getMinInclusive <em>Min Inclusive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Inclusive</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESimpleSetting#getMinInclusive()
	 * @see #getESimpleSetting()
	 * @generated
	 */
	EAttribute getESimpleSetting_MinInclusive();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.ESimpleSetting#getMaxInclusive <em>Max Inclusive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Inclusive</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESimpleSetting#getMaxInclusive()
	 * @see #getESimpleSetting()
	 * @generated
	 */
	EAttribute getESimpleSetting_MaxInclusive();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.ESimpleSetting#getMinExclusive <em>Min Exclusive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Exclusive</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESimpleSetting#getMinExclusive()
	 * @see #getESimpleSetting()
	 * @generated
	 */
	EAttribute getESimpleSetting_MinExclusive();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.ESimpleSetting#getMaxExclusive <em>Max Exclusive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Exclusive</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESimpleSetting#getMaxExclusive()
	 * @see #getESimpleSetting()
	 * @generated
	 */
	EAttribute getESimpleSetting_MaxExclusive();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.ESimpleSetting#getMinLength <em>Min Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Length</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESimpleSetting#getMinLength()
	 * @see #getESimpleSetting()
	 * @generated
	 */
	EAttribute getESimpleSetting_MinLength();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.ESimpleSetting#getMaxLength <em>Max Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Length</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESimpleSetting#getMaxLength()
	 * @see #getESimpleSetting()
	 * @generated
	 */
	EAttribute getESimpleSetting_MaxLength();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.ESimpleSetting#getLength <em>Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Length</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESimpleSetting#getLength()
	 * @see #getESimpleSetting()
	 * @generated
	 */
	EAttribute getESimpleSetting_Length();

	/**
	 * Returns the meta object for the attribute list '{@link com.nokia.tools.s60ct.model.confml.ESimpleSetting#getPattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Pattern</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESimpleSetting#getPattern()
	 * @see #getESimpleSetting()
	 * @generated
	 */
	EAttribute getESimpleSetting_Pattern();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.ESimpleSetting#getTotalDigits <em>Total Digits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Total Digits</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESimpleSetting#getTotalDigits()
	 * @see #getESimpleSetting()
	 * @generated
	 */
	EAttribute getESimpleSetting_TotalDigits();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.s60ct.model.confml.ESimpleSetting#getOptions <em>Options</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Options</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESimpleSetting#getOptions()
	 * @see #getESimpleSetting()
	 * @generated
	 */
	EReference getESimpleSetting_Options();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.s60ct.model.confml.ESequenceSetting <em>ESequence Setting</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ESequence Setting</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESequenceSetting
	 * @generated
	 */
	EClass getESequenceSetting();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.ESequenceSetting#getMinOccurs <em>Min Occurs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Occurs</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESequenceSetting#getMinOccurs()
	 * @see #getESequenceSetting()
	 * @generated
	 */
	EAttribute getESequenceSetting_MinOccurs();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.ESequenceSetting#getMaxOccurs <em>Max Occurs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Occurs</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESequenceSetting#getMaxOccurs()
	 * @see #getESequenceSetting()
	 * @generated
	 */
	EAttribute getESequenceSetting_MaxOccurs();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.s60ct.model.confml.ESequenceSetting#getItems <em>Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Items</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESequenceSetting#getItems()
	 * @see #getESequenceSetting()
	 * @generated
	 */
	EReference getESequenceSetting_Items();

	/**
	 * Returns the meta object for the containment reference '{@link com.nokia.tools.s60ct.model.confml.ESequenceSetting#getTemplate <em>Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Template</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESequenceSetting#getTemplate()
	 * @see #getESequenceSetting()
	 * @generated
	 */
	EReference getESequenceSetting_Template();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.ESequenceSetting#getMapKey <em>Map Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Map Key</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESequenceSetting#getMapKey()
	 * @see #getESequenceSetting()
	 * @generated
	 */
	EAttribute getESequenceSetting_MapKey();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.ESequenceSetting#getMapValue <em>Map Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Map Value</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESequenceSetting#getMapValue()
	 * @see #getESequenceSetting()
	 * @generated
	 */
	EAttribute getESequenceSetting_MapValue();

	/**
	 * Returns the meta object for the attribute list '{@link com.nokia.tools.s60ct.model.confml.ESequenceSetting#getVisibleSubSettings <em>Visible Sub Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Visible Sub Settings</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESequenceSetting#getVisibleSubSettings()
	 * @see #getESequenceSetting()
	 * @generated
	 */
	EAttribute getESequenceSetting_VisibleSubSettings();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.s60ct.model.confml.EItemSetting <em>EItem Setting</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EItem Setting</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.EItemSetting
	 * @generated
	 */
	EClass getEItemSetting();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.EItemSetting#getNumber <em>Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.EItemSetting#getNumber()
	 * @see #getEItemSetting()
	 * @generated
	 */
	EAttribute getEItemSetting_Number();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.s60ct.model.confml.EItemSetting#getSubSettings <em>Sub Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Settings</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.EItemSetting#getSubSettings()
	 * @see #getEItemSetting()
	 * @generated
	 */
	EReference getEItemSetting_SubSettings();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.s60ct.model.confml.EItemSetting#getFields <em>Fields</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Fields</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.EItemSetting#getFields()
	 * @see #getEItemSetting()
	 * @generated
	 */
	EReference getEItemSetting_Fields();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.s60ct.model.confml.ESubSettingValue <em>ESub Setting Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ESub Setting Value</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESubSettingValue
	 * @generated
	 */
	EClass getESubSettingValue();

	/**
	 * Returns the meta object for the reference '{@link com.nokia.tools.s60ct.model.confml.ESubSettingValue#getSimpleSetting <em>Simple Setting</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Simple Setting</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESubSettingValue#getSimpleSetting()
	 * @see #getESubSettingValue()
	 * @generated
	 */
	EReference getESubSettingValue_SimpleSetting();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.s60ct.model.confml.EDescriptionContainer <em>EDescription Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EDescription Container</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.EDescriptionContainer
	 * @generated
	 */
	EClass getEDescriptionContainer();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.EDescriptionContainer#getDescriptionText <em>Description Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description Text</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.EDescriptionContainer#getDescriptionText()
	 * @see #getEDescriptionContainer()
	 * @generated
	 */
	EAttribute getEDescriptionContainer_DescriptionText();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.EDescriptionContainer#getDescriptionUri <em>Description Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description Uri</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.EDescriptionContainer#getDescriptionUri()
	 * @see #getEDescriptionContainer()
	 * @generated
	 */
	EAttribute getEDescriptionContainer_DescriptionUri();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.EDescriptionContainer#getDescriptionUriText <em>Description Uri Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description Uri Text</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.EDescriptionContainer#getDescriptionUriText()
	 * @see #getEDescriptionContainer()
	 * @generated
	 */
	EAttribute getEDescriptionContainer_DescriptionUriText();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.s60ct.model.confml.EIconContainer <em>EIcon Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EIcon Container</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.EIconContainer
	 * @generated
	 */
	EClass getEIconContainer();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.EIconContainer#getIconUriTitle <em>Icon Uri Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Icon Uri Title</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.EIconContainer#getIconUriTitle()
	 * @see #getEIconContainer()
	 * @generated
	 */
	EAttribute getEIconContainer_IconUriTitle();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.EIconContainer#getIconUri <em>Icon Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Icon Uri</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.EIconContainer#getIconUri()
	 * @see #getEIconContainer()
	 * @generated
	 */
	EAttribute getEIconContainer_IconUri();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.s60ct.model.confml.EResourceLocator <em>EResource Locator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EResource Locator</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.EResourceLocator
	 * @generated
	 */
	EClass getEResourceLocator();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.EResourceLocator#getResourceUri <em>Resource Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resource Uri</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.EResourceLocator#getResourceUri()
	 * @see #getEResourceLocator()
	 * @generated
	 */
	EAttribute getEResourceLocator_ResourceUri();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.s60ct.model.confml.ESettingValue <em>ESetting Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ESetting Value</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESettingValue
	 * @generated
	 */
	EClass getESettingValue();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.ESettingValue#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ref</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESettingValue#getRef()
	 * @see #getESettingValue()
	 * @generated
	 */
	EAttribute getESettingValue_Ref();

	/**
	 * Returns the meta object for the reference '{@link com.nokia.tools.s60ct.model.confml.ESettingValue#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESettingValue#getType()
	 * @see #getESettingValue()
	 * @generated
	 */
	EReference getESettingValue_Type();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.ESettingValue#getMap <em>Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Map</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESettingValue#getMap()
	 * @see #getESettingValue()
	 * @generated
	 */
	EAttribute getESettingValue_Map();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.ESettingValue#getChosenOption <em>Chosen Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Chosen Option</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESettingValue#getChosenOption()
	 * @see #getESettingValue()
	 * @generated
	 */
	EAttribute getESettingValue_ChosenOption();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.s60ct.model.confml.ECompositeSetting <em>EComposite Setting</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EComposite Setting</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ECompositeSetting
	 * @generated
	 */
	EClass getECompositeSetting();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.s60ct.model.confml.EResourceSetting <em>EResource Setting</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EResource Setting</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.EResourceSetting
	 * @generated
	 */
	EClass getEResourceSetting();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.EResourceSetting#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.EResourceSetting#getKind()
	 * @see #getEResourceSetting()
	 * @generated
	 */
	EAttribute getEResourceSetting_Kind();

	/**
	 * Returns the meta object for the reference '{@link com.nokia.tools.s60ct.model.confml.EResourceSetting#getLocalPath <em>Local Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Local Path</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.EResourceSetting#getLocalPath()
	 * @see #getEResourceSetting()
	 * @generated
	 */
	EReference getEResourceSetting_LocalPath();

	/**
	 * Returns the meta object for the reference '{@link com.nokia.tools.s60ct.model.confml.EResourceSetting#getTargetPath <em>Target Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Path</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.EResourceSetting#getTargetPath()
	 * @see #getEResourceSetting()
	 * @generated
	 */
	EReference getEResourceSetting_TargetPath();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.s60ct.model.confml.ESettingContainer <em>ESetting Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ESetting Container</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESettingContainer
	 * @generated
	 */
	EClass getESettingContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.s60ct.model.confml.ESettingContainer#getSubTypes <em>Sub Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Types</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESettingContainer#getSubTypes()
	 * @see #getESettingContainer()
	 * @generated
	 */
	EReference getESettingContainer_SubTypes();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.s60ct.model.confml.ESimpleValue <em>ESimple Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ESimple Value</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESimpleValue
	 * @generated
	 */
	EClass getESimpleValue();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.ESimpleValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESimpleValue#getValue()
	 * @see #getESimpleValue()
	 * @generated
	 */
	EAttribute getESimpleValue_Value();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.s60ct.model.confml.ESequenceValue <em>ESequence Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ESequence Value</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESequenceValue
	 * @generated
	 */
	EClass getESequenceValue();

	/**
	 * Returns the meta object for the containment reference '{@link com.nokia.tools.s60ct.model.confml.ESequenceValue#getTemplate <em>Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Template</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESequenceValue#getTemplate()
	 * @see #getESequenceValue()
	 * @generated
	 */
	EReference getESequenceValue_Template();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.s60ct.model.confml.ESequenceValue#getItems <em>Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Items</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESequenceValue#getItems()
	 * @see #getESequenceValue()
	 * @generated
	 */
	EReference getESequenceValue_Items();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.ESequenceValue#getExtensionPolicy <em>Extension Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Extension Policy</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESequenceValue#getExtensionPolicy()
	 * @see #getESequenceValue()
	 * @generated
	 */
	EAttribute getESequenceValue_ExtensionPolicy();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.s60ct.model.confml.ESequenceValueItem <em>ESequence Value Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ESequence Value Item</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESequenceValueItem
	 * @generated
	 */
	EClass getESequenceValueItem();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.ESequenceValueItem#isEditable <em>Editable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Editable</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESequenceValueItem#isEditable()
	 * @see #getESequenceValueItem()
	 * @generated
	 */
	EAttribute getESequenceValueItem_Editable();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.ESequenceValueItem#getFrameLocationUri <em>Frame Location Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Frame Location Uri</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESequenceValueItem#getFrameLocationUri()
	 * @see #getESequenceValueItem()
	 * @generated
	 */
	EAttribute getESequenceValueItem_FrameLocationUri();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.ESequenceValueItem#isRemoved <em>Removed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Removed</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESequenceValueItem#isRemoved()
	 * @see #getESequenceValueItem()
	 * @generated
	 */
	EAttribute getESequenceValueItem_Removed();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.s60ct.model.confml.ECompositeValue <em>EComposite Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EComposite Value</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ECompositeValue
	 * @generated
	 */
	EClass getECompositeValue();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.s60ct.model.confml.ESettingValueContainer <em>ESetting Value Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ESetting Value Container</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESettingValueContainer
	 * @generated
	 */
	EClass getESettingValueContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.s60ct.model.confml.ESettingValueContainer#getSubSettings <em>Sub Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Settings</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESettingValueContainer#getSubSettings()
	 * @see #getESettingValueContainer()
	 * @generated
	 */
	EReference getESettingValueContainer_SubSettings();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.s60ct.model.confml.EResourceValue <em>EResource Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EResource Value</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.EResourceValue
	 * @generated
	 */
	EClass getEResourceValue();

	/**
	 * Returns the meta object for the reference '{@link com.nokia.tools.s60ct.model.confml.EResourceValue#getLocalPath <em>Local Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Local Path</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.EResourceValue#getLocalPath()
	 * @see #getEResourceValue()
	 * @generated
	 */
	EReference getEResourceValue_LocalPath();

	/**
	 * Returns the meta object for the reference '{@link com.nokia.tools.s60ct.model.confml.EResourceValue#getTargetPath <em>Target Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Path</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.EResourceValue#getTargetPath()
	 * @see #getEResourceValue()
	 * @generated
	 */
	EReference getEResourceValue_TargetPath();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.s60ct.model.confml.EProperty <em>EProperty</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EProperty</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.EProperty
	 * @generated
	 */
	EClass getEProperty();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.EProperty#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.EProperty#getName()
	 * @see #getEProperty()
	 * @generated
	 */
	EAttribute getEProperty_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.EProperty#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.EProperty#getValue()
	 * @see #getEProperty()
	 * @generated
	 */
	EAttribute getEProperty_Value();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.EProperty#getUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unit</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.EProperty#getUnit()
	 * @see #getEProperty()
	 * @generated
	 */
	EAttribute getEProperty_Unit();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.s60ct.model.confml.ELinkContainer <em>ELink Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ELink Container</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ELinkContainer
	 * @generated
	 */
	EClass getELinkContainer();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.ELinkContainer#getLinkUri <em>Link Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Link Uri</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ELinkContainer#getLinkUri()
	 * @see #getELinkContainer()
	 * @generated
	 */
	EAttribute getELinkContainer_LinkUri();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.ELinkContainer#getLinkUriTitle <em>Link Uri Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Link Uri Title</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ELinkContainer#getLinkUriTitle()
	 * @see #getELinkContainer()
	 * @generated
	 */
	EAttribute getELinkContainer_LinkUriTitle();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.s60ct.model.confml.EOptionMap <em>EOption Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EOption Map</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.EOptionMap
	 * @generated
	 */
	EClass getEOptionMap();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.EOptionMap#getMapValue <em>Map Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Map Value</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.EOptionMap#getMapValue()
	 * @see #getEOptionMap()
	 * @generated
	 */
	EAttribute getEOptionMap_MapValue();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.EOptionMap#getValue2Save <em>Value2 Save</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value2 Save</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.EOptionMap#getValue2Save()
	 * @see #getEOptionMap()
	 * @generated
	 */
	EAttribute getEOptionMap_Value2Save();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.s60ct.model.confml.EOption <em>EOption</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EOption</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.EOption
	 * @generated
	 */
	EClass getEOption();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.EOption#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.EOption#getName()
	 * @see #getEOption()
	 * @generated
	 */
	EAttribute getEOption_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.EOption#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.EOption#getValue()
	 * @see #getEOption()
	 * @generated
	 */
	EAttribute getEOption_Value();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.EOption#getMap <em>Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Map</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.EOption#getMap()
	 * @see #getEOption()
	 * @generated
	 */
	EAttribute getEOption_Map();

	/**
	 * Returns the meta object for the reference '{@link com.nokia.tools.s60ct.model.confml.EOption#getMapSourceSetting <em>Map Source Setting</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Map Source Setting</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.EOption#getMapSourceSetting()
	 * @see #getEOption()
	 * @generated
	 */
	EReference getEOption_MapSourceSetting();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.EOption#getOptionValues <em>Option Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Option Values</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.EOption#getOptionValues()
	 * @see #getEOption()
	 * @generated
	 */
	EAttribute getEOption_OptionValues();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.s60ct.model.confml.EValueEditorDocument <em>EValue Editor Document</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EValue Editor Document</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.EValueEditorDocument
	 * @generated
	 */
	EClass getEValueEditorDocument();

	/**
	 * Returns the meta object for the reference list '{@link com.nokia.tools.s60ct.model.confml.EValueEditorDocument#getFeatures <em>Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Features</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.EValueEditorDocument#getFeatures()
	 * @see #getEValueEditorDocument()
	 * @generated
	 */
	EReference getEValueEditorDocument_Features();

	/**
	 * Returns the meta object for the reference list '{@link com.nokia.tools.s60ct.model.confml.EValueEditorDocument#getGroups <em>Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Groups</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.EValueEditorDocument#getGroups()
	 * @see #getEValueEditorDocument()
	 * @generated
	 */
	EReference getEValueEditorDocument_Groups();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.s60ct.model.confml.Pattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pattern</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.Pattern
	 * @generated
	 */
	EClass getPattern();

	/**
	 * Returns the meta object for the attribute list '{@link com.nokia.tools.s60ct.model.confml.Pattern#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Value</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.Pattern#getValue()
	 * @see #getPattern()
	 * @generated
	 */
	EAttribute getPattern_Value();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.s60ct.model.confml.View <em>View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>View</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.View
	 * @generated
	 */
	EClass getView();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.View#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.View#getName()
	 * @see #getView()
	 * @generated
	 */
	EAttribute getView_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.s60ct.model.confml.View#getSharedSettingInstances <em>Shared Setting Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Shared Setting Instances</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.View#getSharedSettingInstances()
	 * @see #getView()
	 * @generated
	 */
	EReference getView_SharedSettingInstances();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.s60ct.model.confml.View#getSharedFeatures <em>Shared Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Shared Features</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.View#getSharedFeatures()
	 * @see #getView()
	 * @generated
	 */
	EReference getView_SharedFeatures();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.s60ct.model.confml.EGroup <em>EGroup</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EGroup</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.EGroup
	 * @generated
	 */
	EClass getEGroup();

	/**
	 * Returns the meta object for the reference list '{@link com.nokia.tools.s60ct.model.confml.EGroup#getFeatures <em>Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Features</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.EGroup#getFeatures()
	 * @see #getEGroup()
	 * @generated
	 */
	EReference getEGroup_Features();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.EGroup#getSettingOrder <em>Setting Order</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Setting Order</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.EGroup#getSettingOrder()
	 * @see #getEGroup()
	 * @generated
	 */
	EAttribute getEGroup_SettingOrder();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.model.confml.EGroup#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.EGroup#getName()
	 * @see #getEGroup()
	 * @generated
	 */
	EAttribute getEGroup_Name();

	/**
	 * Returns the meta object for enum '{@link com.nokia.tools.s60ct.model.confml.ESettingValueType <em>ESetting Value Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>ESetting Value Type</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.ESettingValueType
	 * @generated
	 */
	EEnum getESettingValueType();

	/**
	 * Returns the meta object for enum '{@link com.nokia.tools.s60ct.model.confml.EExtensionPolicy <em>EExtension Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EExtension Policy</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.EExtensionPolicy
	 * @generated
	 */
	EEnum getEExtensionPolicy();

	/**
	 * Returns the meta object for enum '{@link com.nokia.tools.s60ct.model.confml.EResourceKind <em>EResource Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EResource Kind</em>'.
	 * @see com.nokia.tools.s60ct.model.confml.EResourceKind
	 * @generated
	 */
	EEnum getEResourceKind();

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
	 * Returns the meta object for data type '{@link org.eclipse.emf.common.util.URI <em>Ecore URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Ecore URI</em>'.
	 * @see org.eclipse.emf.common.util.URI
	 * @model instanceClass="org.eclipse.emf.common.util.URI"
	 * @generated
	 */
	EDataType getEcore_URI();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ConfmlFactory getConfmlFactory();

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
		 * The meta object literal for the '{@link com.nokia.tools.s60ct.model.confml.impl.EFeatureImpl <em>EFeature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.s60ct.model.confml.impl.EFeatureImpl
		 * @see com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl#getEFeature()
		 * @generated
		 */
		EClass EFEATURE = eINSTANCE.getEFeature();

		/**
		 * The meta object literal for the '<em><b>Settings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EFEATURE__SETTINGS = eINSTANCE.getEFeature_Settings();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EFEATURE__REF = eINSTANCE.getEFeature_Ref();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EFEATURE__NAME = eINSTANCE.getEFeature_Name();

		/**
		 * The meta object literal for the '<em><b>Relevant</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EFEATURE__RELEVANT = eINSTANCE.getEFeature_Relevant();

		/**
		 * The meta object literal for the '<em><b>Relevant AST</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EFEATURE__RELEVANT_AST = eINSTANCE.getEFeature_RelevantAST();

		/**
		 * The meta object literal for the '<em><b>Computed Relevant</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EFEATURE__COMPUTED_RELEVANT = eINSTANCE.getEFeature_ComputedRelevant();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.s60ct.model.confml.impl.ESettingImpl <em>ESetting</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.s60ct.model.confml.impl.ESettingImpl
		 * @see com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl#getESetting()
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
		 * The meta object literal for the '<em><b>Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESETTING__REF = eINSTANCE.getESetting_Ref();

		/**
		 * The meta object literal for the '<em><b>Rfs</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESETTING__RFS = eINSTANCE.getESetting_Rfs();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ESETTING__VALUE = eINSTANCE.getESetting_Value();

		/**
		 * The meta object literal for the '<em><b>Default Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ESETTING__DEFAULT_VALUE = eINSTANCE.getESetting_DefaultValue();

		/**
		 * The meta object literal for the '<em><b>Default Rfs</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESETTING__DEFAULT_RFS = eINSTANCE.getESetting_DefaultRfs();

		/**
		 * The meta object literal for the '<em><b>Read Only</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESETTING__READ_ONLY = eINSTANCE.getESetting_ReadOnly();

		/**
		 * The meta object literal for the '<em><b>Constraint</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESETTING__CONSTRAINT = eINSTANCE.getESetting_Constraint();

		/**
		 * The meta object literal for the '<em><b>Relevant</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESETTING__RELEVANT = eINSTANCE.getESetting_Relevant();

		/**
		 * The meta object literal for the '<em><b>Required</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESETTING__REQUIRED = eINSTANCE.getESetting_Required();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ESETTING__PROPERTIES = eINSTANCE.getESetting_Properties();

		/**
		 * The meta object literal for the '<em><b>Deprecated</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESETTING__DEPRECATED = eINSTANCE.getESetting_Deprecated();

		/**
		 * The meta object literal for the '<em><b>Modified</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESETTING__MODIFIED = eINSTANCE.getESetting_Modified();

		/**
		 * The meta object literal for the '<em><b>Setdefault</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESETTING__SETDEFAULT = eINSTANCE.getESetting_Setdefault();

		/**
		 * The meta object literal for the '<em><b>Computed Relevant</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESETTING__COMPUTED_RELEVANT = eINSTANCE.getESetting_ComputedRelevant();

		/**
		 * The meta object literal for the '<em><b>Computed Constraint</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESETTING__COMPUTED_CONSTRAINT = eINSTANCE.getESetting_ComputedConstraint();

		/**
		 * The meta object literal for the '<em><b>Relevant AST</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESETTING__RELEVANT_AST = eINSTANCE.getESetting_RelevantAST();

		/**
		 * The meta object literal for the '<em><b>Constraint AST</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESETTING__CONSTRAINT_AST = eINSTANCE.getESetting_ConstraintAST();

		/**
		 * The meta object literal for the '<em><b>Dependencies</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESETTING__DEPENDENCIES = eINSTANCE.getESetting_Dependencies();

		/**
		 * The meta object literal for the '<em><b>Option Dependencies</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESETTING__OPTION_DEPENDENCIES = eINSTANCE.getESetting_OptionDependencies();

		/**
		 * The meta object literal for the '<em><b>Value Null</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESETTING__VALUE_NULL = eINSTANCE.getESetting_ValueNull();

		/**
		 * The meta object literal for the '<em><b>Notes</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESETTING__NOTES = eINSTANCE.getESetting_Notes();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.s60ct.model.confml.impl.ESettingOptionImpl <em>ESetting Option</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.s60ct.model.confml.impl.ESettingOptionImpl
		 * @see com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl#getESettingOption()
		 * @generated
		 */
		EClass ESETTING_OPTION = eINSTANCE.getESettingOption();

		/**
		 * The meta object literal for the '<em><b>Relevant</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESETTING_OPTION__RELEVANT = eINSTANCE.getESettingOption_Relevant();

		/**
		 * The meta object literal for the '<em><b>Relevant AST</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESETTING_OPTION__RELEVANT_AST = eINSTANCE.getESettingOption_RelevantAST();

		/**
		 * The meta object literal for the '<em><b>Computed Relevant</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESETTING_OPTION__COMPUTED_RELEVANT = eINSTANCE.getESettingOption_ComputedRelevant();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.s60ct.model.confml.impl.ESimpleSettingImpl <em>ESimple Setting</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.s60ct.model.confml.impl.ESimpleSettingImpl
		 * @see com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl#getESimpleSetting()
		 * @generated
		 */
		EClass ESIMPLE_SETTING = eINSTANCE.getESimpleSetting();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESIMPLE_SETTING__TYPE = eINSTANCE.getESimpleSetting_Type();

		/**
		 * The meta object literal for the '<em><b>Min Inclusive</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESIMPLE_SETTING__MIN_INCLUSIVE = eINSTANCE.getESimpleSetting_MinInclusive();

		/**
		 * The meta object literal for the '<em><b>Max Inclusive</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESIMPLE_SETTING__MAX_INCLUSIVE = eINSTANCE.getESimpleSetting_MaxInclusive();

		/**
		 * The meta object literal for the '<em><b>Min Exclusive</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESIMPLE_SETTING__MIN_EXCLUSIVE = eINSTANCE.getESimpleSetting_MinExclusive();

		/**
		 * The meta object literal for the '<em><b>Max Exclusive</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESIMPLE_SETTING__MAX_EXCLUSIVE = eINSTANCE.getESimpleSetting_MaxExclusive();

		/**
		 * The meta object literal for the '<em><b>Min Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESIMPLE_SETTING__MIN_LENGTH = eINSTANCE.getESimpleSetting_MinLength();

		/**
		 * The meta object literal for the '<em><b>Max Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESIMPLE_SETTING__MAX_LENGTH = eINSTANCE.getESimpleSetting_MaxLength();

		/**
		 * The meta object literal for the '<em><b>Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESIMPLE_SETTING__LENGTH = eINSTANCE.getESimpleSetting_Length();

		/**
		 * The meta object literal for the '<em><b>Pattern</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESIMPLE_SETTING__PATTERN = eINSTANCE.getESimpleSetting_Pattern();

		/**
		 * The meta object literal for the '<em><b>Total Digits</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESIMPLE_SETTING__TOTAL_DIGITS = eINSTANCE.getESimpleSetting_TotalDigits();

		/**
		 * The meta object literal for the '<em><b>Options</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ESIMPLE_SETTING__OPTIONS = eINSTANCE.getESimpleSetting_Options();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.s60ct.model.confml.impl.ESequenceSettingImpl <em>ESequence Setting</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.s60ct.model.confml.impl.ESequenceSettingImpl
		 * @see com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl#getESequenceSetting()
		 * @generated
		 */
		EClass ESEQUENCE_SETTING = eINSTANCE.getESequenceSetting();

		/**
		 * The meta object literal for the '<em><b>Min Occurs</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESEQUENCE_SETTING__MIN_OCCURS = eINSTANCE.getESequenceSetting_MinOccurs();

		/**
		 * The meta object literal for the '<em><b>Max Occurs</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESEQUENCE_SETTING__MAX_OCCURS = eINSTANCE.getESequenceSetting_MaxOccurs();

		/**
		 * The meta object literal for the '<em><b>Items</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ESEQUENCE_SETTING__ITEMS = eINSTANCE.getESequenceSetting_Items();

		/**
		 * The meta object literal for the '<em><b>Template</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ESEQUENCE_SETTING__TEMPLATE = eINSTANCE.getESequenceSetting_Template();

		/**
		 * The meta object literal for the '<em><b>Map Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESEQUENCE_SETTING__MAP_KEY = eINSTANCE.getESequenceSetting_MapKey();

		/**
		 * The meta object literal for the '<em><b>Map Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESEQUENCE_SETTING__MAP_VALUE = eINSTANCE.getESequenceSetting_MapValue();

		/**
		 * The meta object literal for the '<em><b>Visible Sub Settings</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESEQUENCE_SETTING__VISIBLE_SUB_SETTINGS = eINSTANCE.getESequenceSetting_VisibleSubSettings();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.s60ct.model.confml.impl.EItemSettingImpl <em>EItem Setting</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.s60ct.model.confml.impl.EItemSettingImpl
		 * @see com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl#getEItemSetting()
		 * @generated
		 */
		EClass EITEM_SETTING = eINSTANCE.getEItemSetting();

		/**
		 * The meta object literal for the '<em><b>Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EITEM_SETTING__NUMBER = eINSTANCE.getEItemSetting_Number();

		/**
		 * The meta object literal for the '<em><b>Sub Settings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EITEM_SETTING__SUB_SETTINGS = eINSTANCE.getEItemSetting_SubSettings();

		/**
		 * The meta object literal for the '<em><b>Fields</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EITEM_SETTING__FIELDS = eINSTANCE.getEItemSetting_Fields();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.s60ct.model.confml.impl.ESubSettingValueImpl <em>ESub Setting Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.s60ct.model.confml.impl.ESubSettingValueImpl
		 * @see com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl#getESubSettingValue()
		 * @generated
		 */
		EClass ESUB_SETTING_VALUE = eINSTANCE.getESubSettingValue();

		/**
		 * The meta object literal for the '<em><b>Simple Setting</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ESUB_SETTING_VALUE__SIMPLE_SETTING = eINSTANCE.getESubSettingValue_SimpleSetting();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.s60ct.model.confml.EDescriptionContainer <em>EDescription Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.s60ct.model.confml.EDescriptionContainer
		 * @see com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl#getEDescriptionContainer()
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
		 * The meta object literal for the '<em><b>Description Uri Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDESCRIPTION_CONTAINER__DESCRIPTION_URI_TEXT = eINSTANCE.getEDescriptionContainer_DescriptionUriText();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.s60ct.model.confml.EIconContainer <em>EIcon Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.s60ct.model.confml.EIconContainer
		 * @see com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl#getEIconContainer()
		 * @generated
		 */
		EClass EICON_CONTAINER = eINSTANCE.getEIconContainer();

		/**
		 * The meta object literal for the '<em><b>Icon Uri Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EICON_CONTAINER__ICON_URI_TITLE = eINSTANCE.getEIconContainer_IconUriTitle();

		/**
		 * The meta object literal for the '<em><b>Icon Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EICON_CONTAINER__ICON_URI = eINSTANCE.getEIconContainer_IconUri();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.s60ct.model.confml.EResourceLocator <em>EResource Locator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.s60ct.model.confml.EResourceLocator
		 * @see com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl#getEResourceLocator()
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
		 * The meta object literal for the '{@link com.nokia.tools.s60ct.model.confml.impl.ESettingValueImpl <em>ESetting Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.s60ct.model.confml.impl.ESettingValueImpl
		 * @see com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl#getESettingValue()
		 * @generated
		 */
		EClass ESETTING_VALUE = eINSTANCE.getESettingValue();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESETTING_VALUE__REF = eINSTANCE.getESettingValue_Ref();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ESETTING_VALUE__TYPE = eINSTANCE.getESettingValue_Type();

		/**
		 * The meta object literal for the '<em><b>Map</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESETTING_VALUE__MAP = eINSTANCE.getESettingValue_Map();

		/**
		 * The meta object literal for the '<em><b>Chosen Option</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESETTING_VALUE__CHOSEN_OPTION = eINSTANCE.getESettingValue_ChosenOption();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.s60ct.model.confml.impl.ECompositeSettingImpl <em>EComposite Setting</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.s60ct.model.confml.impl.ECompositeSettingImpl
		 * @see com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl#getECompositeSetting()
		 * @generated
		 */
		EClass ECOMPOSITE_SETTING = eINSTANCE.getECompositeSetting();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.s60ct.model.confml.impl.EResourceSettingImpl <em>EResource Setting</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.s60ct.model.confml.impl.EResourceSettingImpl
		 * @see com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl#getEResourceSetting()
		 * @generated
		 */
		EClass ERESOURCE_SETTING = eINSTANCE.getEResourceSetting();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ERESOURCE_SETTING__KIND = eINSTANCE.getEResourceSetting_Kind();

		/**
		 * The meta object literal for the '<em><b>Local Path</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERESOURCE_SETTING__LOCAL_PATH = eINSTANCE.getEResourceSetting_LocalPath();

		/**
		 * The meta object literal for the '<em><b>Target Path</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERESOURCE_SETTING__TARGET_PATH = eINSTANCE.getEResourceSetting_TargetPath();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.s60ct.model.confml.ESettingContainer <em>ESetting Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.s60ct.model.confml.ESettingContainer
		 * @see com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl#getESettingContainer()
		 * @generated
		 */
		EClass ESETTING_CONTAINER = eINSTANCE.getESettingContainer();

		/**
		 * The meta object literal for the '<em><b>Sub Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ESETTING_CONTAINER__SUB_TYPES = eINSTANCE.getESettingContainer_SubTypes();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.s60ct.model.confml.impl.ESimpleValueImpl <em>ESimple Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.s60ct.model.confml.impl.ESimpleValueImpl
		 * @see com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl#getESimpleValue()
		 * @generated
		 */
		EClass ESIMPLE_VALUE = eINSTANCE.getESimpleValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESIMPLE_VALUE__VALUE = eINSTANCE.getESimpleValue_Value();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.s60ct.model.confml.impl.ESequenceValueImpl <em>ESequence Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.s60ct.model.confml.impl.ESequenceValueImpl
		 * @see com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl#getESequenceValue()
		 * @generated
		 */
		EClass ESEQUENCE_VALUE = eINSTANCE.getESequenceValue();

		/**
		 * The meta object literal for the '<em><b>Template</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ESEQUENCE_VALUE__TEMPLATE = eINSTANCE.getESequenceValue_Template();

		/**
		 * The meta object literal for the '<em><b>Items</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ESEQUENCE_VALUE__ITEMS = eINSTANCE.getESequenceValue_Items();

		/**
		 * The meta object literal for the '<em><b>Extension Policy</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESEQUENCE_VALUE__EXTENSION_POLICY = eINSTANCE.getESequenceValue_ExtensionPolicy();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.s60ct.model.confml.impl.ESequenceValueItemImpl <em>ESequence Value Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.s60ct.model.confml.impl.ESequenceValueItemImpl
		 * @see com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl#getESequenceValueItem()
		 * @generated
		 */
		EClass ESEQUENCE_VALUE_ITEM = eINSTANCE.getESequenceValueItem();

		/**
		 * The meta object literal for the '<em><b>Editable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESEQUENCE_VALUE_ITEM__EDITABLE = eINSTANCE.getESequenceValueItem_Editable();

		/**
		 * The meta object literal for the '<em><b>Frame Location Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESEQUENCE_VALUE_ITEM__FRAME_LOCATION_URI = eINSTANCE.getESequenceValueItem_FrameLocationUri();

		/**
		 * The meta object literal for the '<em><b>Removed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESEQUENCE_VALUE_ITEM__REMOVED = eINSTANCE.getESequenceValueItem_Removed();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.s60ct.model.confml.impl.ECompositeValueImpl <em>EComposite Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.s60ct.model.confml.impl.ECompositeValueImpl
		 * @see com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl#getECompositeValue()
		 * @generated
		 */
		EClass ECOMPOSITE_VALUE = eINSTANCE.getECompositeValue();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.s60ct.model.confml.ESettingValueContainer <em>ESetting Value Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.s60ct.model.confml.ESettingValueContainer
		 * @see com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl#getESettingValueContainer()
		 * @generated
		 */
		EClass ESETTING_VALUE_CONTAINER = eINSTANCE.getESettingValueContainer();

		/**
		 * The meta object literal for the '<em><b>Sub Settings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ESETTING_VALUE_CONTAINER__SUB_SETTINGS = eINSTANCE.getESettingValueContainer_SubSettings();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.s60ct.model.confml.impl.EResourceValueImpl <em>EResource Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.s60ct.model.confml.impl.EResourceValueImpl
		 * @see com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl#getEResourceValue()
		 * @generated
		 */
		EClass ERESOURCE_VALUE = eINSTANCE.getEResourceValue();

		/**
		 * The meta object literal for the '<em><b>Local Path</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERESOURCE_VALUE__LOCAL_PATH = eINSTANCE.getEResourceValue_LocalPath();

		/**
		 * The meta object literal for the '<em><b>Target Path</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERESOURCE_VALUE__TARGET_PATH = eINSTANCE.getEResourceValue_TargetPath();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.s60ct.model.confml.impl.EPropertyImpl <em>EProperty</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.s60ct.model.confml.impl.EPropertyImpl
		 * @see com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl#getEProperty()
		 * @generated
		 */
		EClass EPROPERTY = eINSTANCE.getEProperty();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPROPERTY__NAME = eINSTANCE.getEProperty_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPROPERTY__VALUE = eINSTANCE.getEProperty_Value();

		/**
		 * The meta object literal for the '<em><b>Unit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPROPERTY__UNIT = eINSTANCE.getEProperty_Unit();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.s60ct.model.confml.ELinkContainer <em>ELink Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.s60ct.model.confml.ELinkContainer
		 * @see com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl#getELinkContainer()
		 * @generated
		 */
		EClass ELINK_CONTAINER = eINSTANCE.getELinkContainer();

		/**
		 * The meta object literal for the '<em><b>Link Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELINK_CONTAINER__LINK_URI = eINSTANCE.getELinkContainer_LinkUri();

		/**
		 * The meta object literal for the '<em><b>Link Uri Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELINK_CONTAINER__LINK_URI_TITLE = eINSTANCE.getELinkContainer_LinkUriTitle();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.s60ct.model.confml.impl.EOptionMapImpl <em>EOption Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.s60ct.model.confml.impl.EOptionMapImpl
		 * @see com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl#getEOptionMap()
		 * @generated
		 */
		EClass EOPTION_MAP = eINSTANCE.getEOptionMap();

		/**
		 * The meta object literal for the '<em><b>Map Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EOPTION_MAP__MAP_VALUE = eINSTANCE.getEOptionMap_MapValue();

		/**
		 * The meta object literal for the '<em><b>Value2 Save</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EOPTION_MAP__VALUE2_SAVE = eINSTANCE.getEOptionMap_Value2Save();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.s60ct.model.confml.impl.EOptionImpl <em>EOption</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.s60ct.model.confml.impl.EOptionImpl
		 * @see com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl#getEOption()
		 * @generated
		 */
		EClass EOPTION = eINSTANCE.getEOption();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EOPTION__NAME = eINSTANCE.getEOption_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EOPTION__VALUE = eINSTANCE.getEOption_Value();

		/**
		 * The meta object literal for the '<em><b>Map</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EOPTION__MAP = eINSTANCE.getEOption_Map();

		/**
		 * The meta object literal for the '<em><b>Map Source Setting</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EOPTION__MAP_SOURCE_SETTING = eINSTANCE.getEOption_MapSourceSetting();

		/**
		 * The meta object literal for the '<em><b>Option Values</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EOPTION__OPTION_VALUES = eINSTANCE.getEOption_OptionValues();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.s60ct.model.confml.impl.EValueEditorDocumentImpl <em>EValue Editor Document</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.s60ct.model.confml.impl.EValueEditorDocumentImpl
		 * @see com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl#getEValueEditorDocument()
		 * @generated
		 */
		EClass EVALUE_EDITOR_DOCUMENT = eINSTANCE.getEValueEditorDocument();

		/**
		 * The meta object literal for the '<em><b>Features</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVALUE_EDITOR_DOCUMENT__FEATURES = eINSTANCE.getEValueEditorDocument_Features();

		/**
		 * The meta object literal for the '<em><b>Groups</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVALUE_EDITOR_DOCUMENT__GROUPS = eINSTANCE.getEValueEditorDocument_Groups();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.s60ct.model.confml.impl.PatternImpl <em>Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.s60ct.model.confml.impl.PatternImpl
		 * @see com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl#getPattern()
		 * @generated
		 */
		EClass PATTERN = eINSTANCE.getPattern();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PATTERN__VALUE = eINSTANCE.getPattern_Value();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.s60ct.model.confml.impl.ViewImpl <em>View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.s60ct.model.confml.impl.ViewImpl
		 * @see com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl#getView()
		 * @generated
		 */
		EClass VIEW = eINSTANCE.getView();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIEW__NAME = eINSTANCE.getView_Name();

		/**
		 * The meta object literal for the '<em><b>Shared Setting Instances</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIEW__SHARED_SETTING_INSTANCES = eINSTANCE.getView_SharedSettingInstances();

		/**
		 * The meta object literal for the '<em><b>Shared Features</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIEW__SHARED_FEATURES = eINSTANCE.getView_SharedFeatures();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.s60ct.model.confml.impl.EGroupImpl <em>EGroup</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.s60ct.model.confml.impl.EGroupImpl
		 * @see com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl#getEGroup()
		 * @generated
		 */
		EClass EGROUP = eINSTANCE.getEGroup();

		/**
		 * The meta object literal for the '<em><b>Features</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EGROUP__FEATURES = eINSTANCE.getEGroup_Features();

		/**
		 * The meta object literal for the '<em><b>Setting Order</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EGROUP__SETTING_ORDER = eINSTANCE.getEGroup_SettingOrder();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EGROUP__NAME = eINSTANCE.getEGroup_Name();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.s60ct.model.confml.ESettingValueType <em>ESetting Value Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.s60ct.model.confml.ESettingValueType
		 * @see com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl#getESettingValueType()
		 * @generated
		 */
		EEnum ESETTING_VALUE_TYPE = eINSTANCE.getESettingValueType();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.s60ct.model.confml.EExtensionPolicy <em>EExtension Policy</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.s60ct.model.confml.EExtensionPolicy
		 * @see com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl#getEExtensionPolicy()
		 * @generated
		 */
		EEnum EEXTENSION_POLICY = eINSTANCE.getEExtensionPolicy();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.s60ct.model.confml.EResourceKind <em>EResource Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.s60ct.model.confml.EResourceKind
		 * @see com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl#getEResourceKind()
		 * @generated
		 */
		EEnum ERESOURCE_KIND = eINSTANCE.getEResourceKind();

		/**
		 * The meta object literal for the '<em>EJava URI</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.net.URI
		 * @see com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl#getEJavaURI()
		 * @generated
		 */
		EDataType EJAVA_URI = eINSTANCE.getEJavaURI();

		/**
		 * The meta object literal for the '<em>Ecore URI</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.common.util.URI
		 * @see com.nokia.tools.s60ct.model.confml.impl.ConfmlPackageImpl#getEcore_URI()
		 * @generated
		 */
		EDataType ECORE_URI = eINSTANCE.getEcore_URI();

	}

} //ConfmlPackage
