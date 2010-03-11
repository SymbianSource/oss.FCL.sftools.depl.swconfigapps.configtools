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
 * Description: This file is part of com.nokia.tools.variant.content.confml.model component.
 */

package com.nokia.tools.s60ct.content.confml;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

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
 * @see com.nokia.tools.s60ct.content.confml.ConfmlFactory
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
	String eNS_URI = "http///confml.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "confml";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ConfmlPackage eINSTANCE = com.nokia.tools.s60ct.content.confml.impl.ConfmlPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.nokia.tools.s60ct.content.confml.impl.GroupImpl <em>Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.s60ct.content.confml.impl.GroupImpl
	 * @see com.nokia.tools.s60ct.content.confml.impl.ConfmlPackageImpl#getGroup()
	 * @generated
	 */
	int GROUP = 9;

	/**
	 * The feature id for the '<em><b>Desc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__DESC = 0;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__ICON = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__NAME = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__ID = 3;

	/**
	 * The feature id for the '<em><b>Settings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__SETTINGS = 4;

	/**
	 * The number of structural features of the '<em>Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link com.nokia.tools.s60ct.content.confml.impl.ParentGroupImpl <em>Parent Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.s60ct.content.confml.impl.ParentGroupImpl
	 * @see com.nokia.tools.s60ct.content.confml.impl.ConfmlPackageImpl#getParentGroup()
	 * @generated
	 */
	int PARENT_GROUP = 0;

	/**
	 * The feature id for the '<em><b>Desc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_GROUP__DESC = GROUP__DESC;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_GROUP__ICON = GROUP__ICON;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_GROUP__NAME = GROUP__NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_GROUP__ID = GROUP__ID;

	/**
	 * The feature id for the '<em><b>Settings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_GROUP__SETTINGS = GROUP__SETTINGS;

	/**
	 * The feature id for the '<em><b>Leaf Group</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_GROUP__LEAF_GROUP = GROUP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Parent Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_GROUP_FEATURE_COUNT = GROUP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.nokia.tools.s60ct.content.confml.impl.LeafGroupImpl <em>Leaf Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.s60ct.content.confml.impl.LeafGroupImpl
	 * @see com.nokia.tools.s60ct.content.confml.impl.ConfmlPackageImpl#getLeafGroup()
	 * @generated
	 */
	int LEAF_GROUP = 1;

	/**
	 * The feature id for the '<em><b>Desc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_GROUP__DESC = GROUP__DESC;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_GROUP__ICON = GROUP__ICON;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_GROUP__NAME = GROUP__NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_GROUP__ID = GROUP__ID;

	/**
	 * The feature id for the '<em><b>Settings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_GROUP__SETTINGS = GROUP__SETTINGS;

	/**
	 * The number of structural features of the '<em>Leaf Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_GROUP_FEATURE_COUNT = GROUP_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.nokia.tools.s60ct.content.confml.impl.SettingImpl <em>Setting</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.s60ct.content.confml.impl.SettingImpl
	 * @see com.nokia.tools.s60ct.content.confml.impl.ConfmlPackageImpl#getSetting()
	 * @generated
	 */
	int SETTING = 6;

	/**
	 * The feature id for the '<em><b>Abs Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__ABS_REF = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__NAME = 1;

	/**
	 * The feature id for the '<em><b>Property</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__PROPERTY = 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__DESCRIPTION = 3;

	/**
	 * The feature id for the '<em><b>Leaf Group</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__LEAF_GROUP = 4;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__TYPE = 5;

	/**
	 * The feature id for the '<em><b>Rfs Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__RFS_VALUE = 6;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__FEATURE_NAME = 7;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__NOTE = 8;

	/**
	 * The feature id for the '<em><b>Relevant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__RELEVANT = 9;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__REQUIRED = 10;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__CONSTRAINT = 11;

	/**
	 * The feature id for the '<em><b>Computed Relevant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__COMPUTED_RELEVANT = 12;

	/**
	 * The feature id for the '<em><b>Computed Constraint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__COMPUTED_CONSTRAINT = 13;

	/**
	 * The feature id for the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__READ_ONLY = 14;

	/**
	 * The feature id for the '<em><b>Value Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__VALUE_NULL = 15;

	/**
	 * The feature id for the '<em><b>Name Override</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__NAME_OVERRIDE = 16;

	/**
	 * The feature id for the '<em><b>Description Override</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__DESCRIPTION_OVERRIDE = 17;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__DEPENDENCIES = 18;

	/**
	 * The feature id for the '<em><b>Option</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__OPTION = 19;

	/**
	 * The feature id for the '<em><b>Parent Group</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__PARENT_GROUP = 20;

	/**
	 * The feature id for the '<em><b>Option Dependencies</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__OPTION_DEPENDENCIES = 21;

	/**
	 * The feature id for the '<em><b>Relevant AST</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__RELEVANT_AST = 22;

	/**
	 * The feature id for the '<em><b>Constraint AST</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__CONSTRAINT_AST = 23;

	/**
	 * The feature id for the '<em><b>Group Option Map</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__GROUP_OPTION_MAP = 24;

	/**
	 * The number of structural features of the '<em>Setting</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING_FEATURE_COUNT = 25;

	/**
	 * The meta object id for the '{@link com.nokia.tools.s60ct.content.confml.impl.SimpleSettingImpl <em>Simple Setting</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.s60ct.content.confml.impl.SimpleSettingImpl
	 * @see com.nokia.tools.s60ct.content.confml.impl.ConfmlPackageImpl#getSimpleSetting()
	 * @generated
	 */
	int SIMPLE_SETTING = 2;

	/**
	 * The feature id for the '<em><b>Abs Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SETTING__ABS_REF = SETTING__ABS_REF;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SETTING__NAME = SETTING__NAME;

	/**
	 * The feature id for the '<em><b>Property</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SETTING__PROPERTY = SETTING__PROPERTY;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SETTING__DESCRIPTION = SETTING__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Leaf Group</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SETTING__LEAF_GROUP = SETTING__LEAF_GROUP;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SETTING__TYPE = SETTING__TYPE;

	/**
	 * The feature id for the '<em><b>Rfs Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SETTING__RFS_VALUE = SETTING__RFS_VALUE;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SETTING__FEATURE_NAME = SETTING__FEATURE_NAME;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SETTING__NOTE = SETTING__NOTE;

	/**
	 * The feature id for the '<em><b>Relevant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SETTING__RELEVANT = SETTING__RELEVANT;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SETTING__REQUIRED = SETTING__REQUIRED;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SETTING__CONSTRAINT = SETTING__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Computed Relevant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SETTING__COMPUTED_RELEVANT = SETTING__COMPUTED_RELEVANT;

	/**
	 * The feature id for the '<em><b>Computed Constraint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SETTING__COMPUTED_CONSTRAINT = SETTING__COMPUTED_CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SETTING__READ_ONLY = SETTING__READ_ONLY;

	/**
	 * The feature id for the '<em><b>Value Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SETTING__VALUE_NULL = SETTING__VALUE_NULL;

	/**
	 * The feature id for the '<em><b>Name Override</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SETTING__NAME_OVERRIDE = SETTING__NAME_OVERRIDE;

	/**
	 * The feature id for the '<em><b>Description Override</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SETTING__DESCRIPTION_OVERRIDE = SETTING__DESCRIPTION_OVERRIDE;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SETTING__DEPENDENCIES = SETTING__DEPENDENCIES;

	/**
	 * The feature id for the '<em><b>Option</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SETTING__OPTION = SETTING__OPTION;

	/**
	 * The feature id for the '<em><b>Parent Group</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SETTING__PARENT_GROUP = SETTING__PARENT_GROUP;

	/**
	 * The feature id for the '<em><b>Option Dependencies</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SETTING__OPTION_DEPENDENCIES = SETTING__OPTION_DEPENDENCIES;

	/**
	 * The feature id for the '<em><b>Relevant AST</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SETTING__RELEVANT_AST = SETTING__RELEVANT_AST;

	/**
	 * The feature id for the '<em><b>Constraint AST</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SETTING__CONSTRAINT_AST = SETTING__CONSTRAINT_AST;

	/**
	 * The feature id for the '<em><b>Group Option Map</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SETTING__GROUP_OPTION_MAP = SETTING__GROUP_OPTION_MAP;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SETTING__DEFAULT_VALUE = SETTING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SETTING__VALUE = SETTING_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Last Saved Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SETTING__LAST_SAVED_VALUE = SETTING_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Min Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SETTING__MIN_LENGTH = SETTING_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Max Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SETTING__MAX_LENGTH = SETTING_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SETTING__LENGTH = SETTING_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SETTING__PATTERN = SETTING_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Total Digits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SETTING__TOTAL_DIGITS = SETTING_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Max Exclusive</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SETTING__MAX_EXCLUSIVE = SETTING_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Min Exclusive</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SETTING__MIN_EXCLUSIVE = SETTING_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Max Inclusive</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SETTING__MAX_INCLUSIVE = SETTING_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Min Inclusive</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SETTING__MIN_INCLUSIVE = SETTING_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Contained In Last Layer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SETTING__CONTAINED_IN_LAST_LAYER = SETTING_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Last Saved In Last Layer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SETTING__LAST_SAVED_IN_LAST_LAYER = SETTING_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Chosen Option</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SETTING__CHOSEN_OPTION = SETTING_FEATURE_COUNT + 14;

	/**
	 * The number of structural features of the '<em>Simple Setting</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SETTING_FEATURE_COUNT = SETTING_FEATURE_COUNT + 15;

	/**
	 * The meta object id for the '{@link com.nokia.tools.s60ct.content.confml.impl.IconImpl <em>Icon</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.s60ct.content.confml.impl.IconImpl
	 * @see com.nokia.tools.s60ct.content.confml.impl.ConfmlPackageImpl#getIcon()
	 * @generated
	 */
	int ICON = 3;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICON__TITLE = 0;

	/**
	 * The feature id for the '<em><b>Href</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICON__HREF = 1;

	/**
	 * The feature id for the '<em><b>File Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICON__FILE_PATH = 2;

	/**
	 * The number of structural features of the '<em>Icon</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICON_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link com.nokia.tools.s60ct.content.confml.impl.ViewImpl <em>View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.s60ct.content.confml.impl.ViewImpl
	 * @see com.nokia.tools.s60ct.content.confml.impl.ConfmlPackageImpl#getView()
	 * @generated
	 */
	int VIEW = 4;

	/**
	 * The feature id for the '<em><b>Parent Group</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__PARENT_GROUP = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__NAME = 1;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__ICON = 2;

	/**
	 * The feature id for the '<em><b>Shared Setting Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__SHARED_SETTING_INSTANCES = 3;

	/**
	 * The feature id for the '<em><b>Shared Features</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__SHARED_FEATURES = 4;

	/**
	 * The number of structural features of the '<em>View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link com.nokia.tools.s60ct.content.confml.impl.SequenceSettingImpl <em>Sequence Setting</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.s60ct.content.confml.impl.SequenceSettingImpl
	 * @see com.nokia.tools.s60ct.content.confml.impl.ConfmlPackageImpl#getSequenceSetting()
	 * @generated
	 */
	int SEQUENCE_SETTING = 5;

	/**
	 * The feature id for the '<em><b>Abs Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_SETTING__ABS_REF = SETTING__ABS_REF;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_SETTING__NAME = SETTING__NAME;

	/**
	 * The feature id for the '<em><b>Property</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_SETTING__PROPERTY = SETTING__PROPERTY;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_SETTING__DESCRIPTION = SETTING__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Leaf Group</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_SETTING__LEAF_GROUP = SETTING__LEAF_GROUP;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_SETTING__TYPE = SETTING__TYPE;

	/**
	 * The feature id for the '<em><b>Rfs Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_SETTING__RFS_VALUE = SETTING__RFS_VALUE;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_SETTING__FEATURE_NAME = SETTING__FEATURE_NAME;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_SETTING__NOTE = SETTING__NOTE;

	/**
	 * The feature id for the '<em><b>Relevant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_SETTING__RELEVANT = SETTING__RELEVANT;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_SETTING__REQUIRED = SETTING__REQUIRED;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_SETTING__CONSTRAINT = SETTING__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Computed Relevant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_SETTING__COMPUTED_RELEVANT = SETTING__COMPUTED_RELEVANT;

	/**
	 * The feature id for the '<em><b>Computed Constraint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_SETTING__COMPUTED_CONSTRAINT = SETTING__COMPUTED_CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_SETTING__READ_ONLY = SETTING__READ_ONLY;

	/**
	 * The feature id for the '<em><b>Value Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_SETTING__VALUE_NULL = SETTING__VALUE_NULL;

	/**
	 * The feature id for the '<em><b>Name Override</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_SETTING__NAME_OVERRIDE = SETTING__NAME_OVERRIDE;

	/**
	 * The feature id for the '<em><b>Description Override</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_SETTING__DESCRIPTION_OVERRIDE = SETTING__DESCRIPTION_OVERRIDE;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_SETTING__DEPENDENCIES = SETTING__DEPENDENCIES;

	/**
	 * The feature id for the '<em><b>Option</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_SETTING__OPTION = SETTING__OPTION;

	/**
	 * The feature id for the '<em><b>Parent Group</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_SETTING__PARENT_GROUP = SETTING__PARENT_GROUP;

	/**
	 * The feature id for the '<em><b>Option Dependencies</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_SETTING__OPTION_DEPENDENCIES = SETTING__OPTION_DEPENDENCIES;

	/**
	 * The feature id for the '<em><b>Relevant AST</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_SETTING__RELEVANT_AST = SETTING__RELEVANT_AST;

	/**
	 * The feature id for the '<em><b>Constraint AST</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_SETTING__CONSTRAINT_AST = SETTING__CONSTRAINT_AST;

	/**
	 * The feature id for the '<em><b>Group Option Map</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_SETTING__GROUP_OPTION_MAP = SETTING__GROUP_OPTION_MAP;

	/**
	 * The feature id for the '<em><b>Default Structure</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_SETTING__DEFAULT_STRUCTURE = SETTING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Template</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_SETTING__TEMPLATE = SETTING_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Sequence Item</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_SETTING__SEQUENCE_ITEM = SETTING_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Min Occurs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_SETTING__MIN_OCCURS = SETTING_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Max Occurs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_SETTING__MAX_OCCURS = SETTING_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Last Saved Structure</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_SETTING__LAST_SAVED_STRUCTURE = SETTING_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Map Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_SETTING__MAP_KEY = SETTING_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Map Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_SETTING__MAP_VALUE = SETTING_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Sequence Setting</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_SETTING_FEATURE_COUNT = SETTING_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link com.nokia.tools.s60ct.content.confml.impl.SequenceItemImpl <em>Sequence Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.s60ct.content.confml.impl.SequenceItemImpl
	 * @see com.nokia.tools.s60ct.content.confml.impl.ConfmlPackageImpl#getSequenceItem()
	 * @generated
	 */
	int SEQUENCE_ITEM = 7;

	/**
	 * The feature id for the '<em><b>Setting</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_ITEM__SETTING = 0;

	/**
	 * The number of structural features of the '<em>Sequence Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_ITEM_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.nokia.tools.s60ct.content.confml.impl.OptionImpl <em>Option</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.s60ct.content.confml.impl.OptionImpl
	 * @see com.nokia.tools.s60ct.content.confml.impl.ConfmlPackageImpl#getOption()
	 * @generated
	 */
	int OPTION = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION__VALUE = 1;

	/**
	 * The feature id for the '<em><b>Relevant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION__RELEVANT = 2;

	/**
	 * The feature id for the '<em><b>Map</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION__MAP = 3;

	/**
	 * The feature id for the '<em><b>Map Source Setting</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION__MAP_SOURCE_SETTING = 4;

	/**
	 * The feature id for the '<em><b>Option Values</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION__OPTION_VALUES = 5;

	/**
	 * The feature id for the '<em><b>Relevant AST</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION__RELEVANT_AST = 6;

	/**
	 * The number of structural features of the '<em>Option</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link com.nokia.tools.s60ct.content.confml.impl.PropertyImpl <em>Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.s60ct.content.confml.impl.PropertyImpl
	 * @see com.nokia.tools.s60ct.content.confml.impl.ConfmlPackageImpl#getProperty()
	 * @generated
	 */
	int PROPERTY = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__NAME = 0;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__UNIT = 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__VALUE = 2;

	/**
	 * The number of structural features of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link com.nokia.tools.s60ct.content.confml.impl.FileSystemEntrySettingImpl <em>File System Entry Setting</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.s60ct.content.confml.impl.FileSystemEntrySettingImpl
	 * @see com.nokia.tools.s60ct.content.confml.impl.ConfmlPackageImpl#getFileSystemEntrySetting()
	 * @generated
	 */
	int FILE_SYSTEM_ENTRY_SETTING = 11;

	/**
	 * The feature id for the '<em><b>Abs Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_ENTRY_SETTING__ABS_REF = SETTING__ABS_REF;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_ENTRY_SETTING__NAME = SETTING__NAME;

	/**
	 * The feature id for the '<em><b>Property</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_ENTRY_SETTING__PROPERTY = SETTING__PROPERTY;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_ENTRY_SETTING__DESCRIPTION = SETTING__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Leaf Group</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_ENTRY_SETTING__LEAF_GROUP = SETTING__LEAF_GROUP;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_ENTRY_SETTING__TYPE = SETTING__TYPE;

	/**
	 * The feature id for the '<em><b>Rfs Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_ENTRY_SETTING__RFS_VALUE = SETTING__RFS_VALUE;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_ENTRY_SETTING__FEATURE_NAME = SETTING__FEATURE_NAME;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_ENTRY_SETTING__NOTE = SETTING__NOTE;

	/**
	 * The feature id for the '<em><b>Relevant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_ENTRY_SETTING__RELEVANT = SETTING__RELEVANT;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_ENTRY_SETTING__REQUIRED = SETTING__REQUIRED;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_ENTRY_SETTING__CONSTRAINT = SETTING__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Computed Relevant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_ENTRY_SETTING__COMPUTED_RELEVANT = SETTING__COMPUTED_RELEVANT;

	/**
	 * The feature id for the '<em><b>Computed Constraint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_ENTRY_SETTING__COMPUTED_CONSTRAINT = SETTING__COMPUTED_CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_ENTRY_SETTING__READ_ONLY = SETTING__READ_ONLY;

	/**
	 * The feature id for the '<em><b>Value Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_ENTRY_SETTING__VALUE_NULL = SETTING__VALUE_NULL;

	/**
	 * The feature id for the '<em><b>Name Override</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_ENTRY_SETTING__NAME_OVERRIDE = SETTING__NAME_OVERRIDE;

	/**
	 * The feature id for the '<em><b>Description Override</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_ENTRY_SETTING__DESCRIPTION_OVERRIDE = SETTING__DESCRIPTION_OVERRIDE;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_ENTRY_SETTING__DEPENDENCIES = SETTING__DEPENDENCIES;

	/**
	 * The feature id for the '<em><b>Option</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_ENTRY_SETTING__OPTION = SETTING__OPTION;

	/**
	 * The feature id for the '<em><b>Parent Group</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_ENTRY_SETTING__PARENT_GROUP = SETTING__PARENT_GROUP;

	/**
	 * The feature id for the '<em><b>Option Dependencies</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_ENTRY_SETTING__OPTION_DEPENDENCIES = SETTING__OPTION_DEPENDENCIES;

	/**
	 * The feature id for the '<em><b>Relevant AST</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_ENTRY_SETTING__RELEVANT_AST = SETTING__RELEVANT_AST;

	/**
	 * The feature id for the '<em><b>Constraint AST</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_ENTRY_SETTING__CONSTRAINT_AST = SETTING__CONSTRAINT_AST;

	/**
	 * The feature id for the '<em><b>Group Option Map</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_ENTRY_SETTING__GROUP_OPTION_MAP = SETTING__GROUP_OPTION_MAP;

	/**
	 * The feature id for the '<em><b>File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_ENTRY_SETTING__FILE = SETTING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source File Path</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_ENTRY_SETTING__SOURCE_FILE_PATH = SETTING_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Target File Path</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_ENTRY_SETTING__TARGET_FILE_PATH = SETTING_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Chosen Option</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_ENTRY_SETTING__CHOSEN_OPTION = SETTING_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_ENTRY_SETTING__PATTERN = SETTING_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>File System Entry Setting</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_ENTRY_SETTING_FEATURE_COUNT = SETTING_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link com.nokia.tools.s60ct.content.confml.impl.FeatureImpl <em>Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.s60ct.content.confml.impl.FeatureImpl
	 * @see com.nokia.tools.s60ct.content.confml.impl.ConfmlPackageImpl#getFeature()
	 * @generated
	 */
	int FEATURE = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__REF = 1;

	/**
	 * The feature id for the '<em><b>Relevant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__RELEVANT = 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__DESCRIPTION = 3;

	/**
	 * The feature id for the '<em><b>Icon Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__ICON_TITLE = 4;

	/**
	 * The feature id for the '<em><b>Icon Descriptor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__ICON_DESCRIPTOR = 5;

	/**
	 * The feature id for the '<em><b>Icon URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__ICON_URI = 6;

	/**
	 * The feature id for the '<em><b>Computed Relevant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__COMPUTED_RELEVANT = 7;

	/**
	 * The feature id for the '<em><b>Relevant AST</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__RELEVANT_AST = 8;

	/**
	 * The number of structural features of the '<em>Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_FEATURE_COUNT = 9;

	/**
	 * The meta object id for the '{@link com.nokia.tools.s60ct.content.confml.impl.MinInclusiveImpl <em>Min Inclusive</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.s60ct.content.confml.impl.MinInclusiveImpl
	 * @see com.nokia.tools.s60ct.content.confml.impl.ConfmlPackageImpl#getMinInclusive()
	 * @generated
	 */
	int MIN_INCLUSIVE = 13;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIN_INCLUSIVE__VALUE = EcorePackage.EOBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Min Inclusive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIN_INCLUSIVE_FEATURE_COUNT = EcorePackage.EOBJECT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.nokia.tools.s60ct.content.confml.impl.MaxInclusiveImpl <em>Max Inclusive</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.s60ct.content.confml.impl.MaxInclusiveImpl
	 * @see com.nokia.tools.s60ct.content.confml.impl.ConfmlPackageImpl#getMaxInclusive()
	 * @generated
	 */
	int MAX_INCLUSIVE = 14;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAX_INCLUSIVE__VALUE = EcorePackage.EOBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Max Inclusive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAX_INCLUSIVE_FEATURE_COUNT = EcorePackage.EOBJECT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.nokia.tools.s60ct.content.confml.impl.MaxExclusiveImpl <em>Max Exclusive</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.s60ct.content.confml.impl.MaxExclusiveImpl
	 * @see com.nokia.tools.s60ct.content.confml.impl.ConfmlPackageImpl#getMaxExclusive()
	 * @generated
	 */
	int MAX_EXCLUSIVE = 15;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAX_EXCLUSIVE__VALUE = EcorePackage.EOBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Max Exclusive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAX_EXCLUSIVE_FEATURE_COUNT = EcorePackage.EOBJECT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.nokia.tools.s60ct.content.confml.impl.MinExclusiveImpl <em>Min Exclusive</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.s60ct.content.confml.impl.MinExclusiveImpl
	 * @see com.nokia.tools.s60ct.content.confml.impl.ConfmlPackageImpl#getMinExclusive()
	 * @generated
	 */
	int MIN_EXCLUSIVE = 16;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIN_EXCLUSIVE__VALUE = EcorePackage.EOBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Min Exclusive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIN_EXCLUSIVE_FEATURE_COUNT = EcorePackage.EOBJECT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.nokia.tools.s60ct.content.confml.impl.FilePathImpl <em>File Path</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.s60ct.content.confml.impl.FilePathImpl
	 * @see com.nokia.tools.s60ct.content.confml.impl.ConfmlPackageImpl#getFilePath()
	 * @generated
	 */
	int FILE_PATH = 17;

	/**
	 * The feature id for the '<em><b>Abs Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_PATH__ABS_REF = FILE_SYSTEM_ENTRY_SETTING__ABS_REF;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_PATH__NAME = FILE_SYSTEM_ENTRY_SETTING__NAME;

	/**
	 * The feature id for the '<em><b>Property</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_PATH__PROPERTY = FILE_SYSTEM_ENTRY_SETTING__PROPERTY;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_PATH__DESCRIPTION = FILE_SYSTEM_ENTRY_SETTING__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Leaf Group</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_PATH__LEAF_GROUP = FILE_SYSTEM_ENTRY_SETTING__LEAF_GROUP;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_PATH__TYPE = FILE_SYSTEM_ENTRY_SETTING__TYPE;

	/**
	 * The feature id for the '<em><b>Rfs Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_PATH__RFS_VALUE = FILE_SYSTEM_ENTRY_SETTING__RFS_VALUE;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_PATH__FEATURE_NAME = FILE_SYSTEM_ENTRY_SETTING__FEATURE_NAME;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_PATH__NOTE = FILE_SYSTEM_ENTRY_SETTING__NOTE;

	/**
	 * The feature id for the '<em><b>Relevant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_PATH__RELEVANT = FILE_SYSTEM_ENTRY_SETTING__RELEVANT;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_PATH__REQUIRED = FILE_SYSTEM_ENTRY_SETTING__REQUIRED;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_PATH__CONSTRAINT = FILE_SYSTEM_ENTRY_SETTING__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Computed Relevant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_PATH__COMPUTED_RELEVANT = FILE_SYSTEM_ENTRY_SETTING__COMPUTED_RELEVANT;

	/**
	 * The feature id for the '<em><b>Computed Constraint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_PATH__COMPUTED_CONSTRAINT = FILE_SYSTEM_ENTRY_SETTING__COMPUTED_CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_PATH__READ_ONLY = FILE_SYSTEM_ENTRY_SETTING__READ_ONLY;

	/**
	 * The feature id for the '<em><b>Value Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_PATH__VALUE_NULL = FILE_SYSTEM_ENTRY_SETTING__VALUE_NULL;

	/**
	 * The feature id for the '<em><b>Name Override</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_PATH__NAME_OVERRIDE = FILE_SYSTEM_ENTRY_SETTING__NAME_OVERRIDE;

	/**
	 * The feature id for the '<em><b>Description Override</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_PATH__DESCRIPTION_OVERRIDE = FILE_SYSTEM_ENTRY_SETTING__DESCRIPTION_OVERRIDE;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_PATH__DEPENDENCIES = FILE_SYSTEM_ENTRY_SETTING__DEPENDENCIES;

	/**
	 * The feature id for the '<em><b>Option</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_PATH__OPTION = FILE_SYSTEM_ENTRY_SETTING__OPTION;

	/**
	 * The feature id for the '<em><b>Parent Group</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_PATH__PARENT_GROUP = FILE_SYSTEM_ENTRY_SETTING__PARENT_GROUP;

	/**
	 * The feature id for the '<em><b>Option Dependencies</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_PATH__OPTION_DEPENDENCIES = FILE_SYSTEM_ENTRY_SETTING__OPTION_DEPENDENCIES;

	/**
	 * The feature id for the '<em><b>Relevant AST</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_PATH__RELEVANT_AST = FILE_SYSTEM_ENTRY_SETTING__RELEVANT_AST;

	/**
	 * The feature id for the '<em><b>Constraint AST</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_PATH__CONSTRAINT_AST = FILE_SYSTEM_ENTRY_SETTING__CONSTRAINT_AST;

	/**
	 * The feature id for the '<em><b>Group Option Map</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_PATH__GROUP_OPTION_MAP = FILE_SYSTEM_ENTRY_SETTING__GROUP_OPTION_MAP;

	/**
	 * The feature id for the '<em><b>File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_PATH__FILE = FILE_SYSTEM_ENTRY_SETTING__FILE;

	/**
	 * The feature id for the '<em><b>Source File Path</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_PATH__SOURCE_FILE_PATH = FILE_SYSTEM_ENTRY_SETTING__SOURCE_FILE_PATH;

	/**
	 * The feature id for the '<em><b>Target File Path</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_PATH__TARGET_FILE_PATH = FILE_SYSTEM_ENTRY_SETTING__TARGET_FILE_PATH;

	/**
	 * The feature id for the '<em><b>Chosen Option</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_PATH__CHOSEN_OPTION = FILE_SYSTEM_ENTRY_SETTING__CHOSEN_OPTION;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_PATH__PATTERN = FILE_SYSTEM_ENTRY_SETTING__PATTERN;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_PATH__PATH = FILE_SYSTEM_ENTRY_SETTING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Last Saved Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_PATH__LAST_SAVED_PATH = FILE_SYSTEM_ENTRY_SETTING_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Default Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_PATH__DEFAULT_PATH = FILE_SYSTEM_ENTRY_SETTING_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Path Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_PATH__PATH_READ_ONLY = FILE_SYSTEM_ENTRY_SETTING_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Path Name Override</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_PATH__PATH_NAME_OVERRIDE = FILE_SYSTEM_ENTRY_SETTING_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Path Description Override</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_PATH__PATH_DESCRIPTION_OVERRIDE = FILE_SYSTEM_ENTRY_SETTING_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_PATH__PARENT = FILE_SYSTEM_ENTRY_SETTING_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Contained In Last Layer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_PATH__CONTAINED_IN_LAST_LAYER = FILE_SYSTEM_ENTRY_SETTING_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Last Saved In Last Layer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_PATH__LAST_SAVED_IN_LAST_LAYER = FILE_SYSTEM_ENTRY_SETTING_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>File Path</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_PATH_FEATURE_COUNT = FILE_SYSTEM_ENTRY_SETTING_FEATURE_COUNT + 9;

	/**
	 * The meta object id for the '{@link com.nokia.tools.s60ct.content.confml.impl.OptionMapEntryImpl <em>Option Map Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.s60ct.content.confml.impl.OptionMapEntryImpl
	 * @see com.nokia.tools.s60ct.content.confml.impl.ConfmlPackageImpl#getOptionMapEntry()
	 * @generated
	 */
	int OPTION_MAP_ENTRY = 18;

	/**
	 * The feature id for the '<em><b>Value2 Save</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION_MAP_ENTRY__VALUE2_SAVE = 0;

	/**
	 * The feature id for the '<em><b>Map Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION_MAP_ENTRY__MAP_VALUE = 1;

	/**
	 * The number of structural features of the '<em>Option Map Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION_MAP_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.nokia.tools.s60ct.content.confml.TYPE <em>TYPE</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.s60ct.content.confml.TYPE
	 * @see com.nokia.tools.s60ct.content.confml.impl.ConfmlPackageImpl#getTYPE()
	 * @generated
	 */
	int TYPE = 19;

	/**
	 * The meta object id for the '<em>URI</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.URI
	 * @see com.nokia.tools.s60ct.content.confml.impl.ConfmlPackageImpl#getURI()
	 * @generated
	 */
	int URI = 20;

	/**
	 * The meta object id for the '<em>Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Object
	 * @see com.nokia.tools.s60ct.content.confml.impl.ConfmlPackageImpl#getObject()
	 * @generated
	 */
	int OBJECT = 21;


	/**
	 * Returns the meta object for class '{@link com.nokia.tools.s60ct.content.confml.ParentGroup <em>Parent Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parent Group</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.ParentGroup
	 * @generated
	 */
	EClass getParentGroup();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.s60ct.content.confml.ParentGroup#getLeafGroup <em>Leaf Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Leaf Group</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.ParentGroup#getLeafGroup()
	 * @see #getParentGroup()
	 * @generated
	 */
	EReference getParentGroup_LeafGroup();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.s60ct.content.confml.LeafGroup <em>Leaf Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Leaf Group</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.LeafGroup
	 * @generated
	 */
	EClass getLeafGroup();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.s60ct.content.confml.SimpleSetting <em>Simple Setting</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Setting</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.SimpleSetting
	 * @generated
	 */
	EClass getSimpleSetting();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.SimpleSetting#getDefaultValue <em>Default Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Value</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.SimpleSetting#getDefaultValue()
	 * @see #getSimpleSetting()
	 * @generated
	 */
	EAttribute getSimpleSetting_DefaultValue();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.SimpleSetting#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.SimpleSetting#getValue()
	 * @see #getSimpleSetting()
	 * @generated
	 */
	EAttribute getSimpleSetting_Value();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.SimpleSetting#getLastSavedValue <em>Last Saved Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Saved Value</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.SimpleSetting#getLastSavedValue()
	 * @see #getSimpleSetting()
	 * @generated
	 */
	EAttribute getSimpleSetting_LastSavedValue();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.SimpleSetting#getMinLength <em>Min Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Length</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.SimpleSetting#getMinLength()
	 * @see #getSimpleSetting()
	 * @generated
	 */
	EAttribute getSimpleSetting_MinLength();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.SimpleSetting#getMaxLength <em>Max Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Length</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.SimpleSetting#getMaxLength()
	 * @see #getSimpleSetting()
	 * @generated
	 */
	EAttribute getSimpleSetting_MaxLength();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.SimpleSetting#getLength <em>Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Length</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.SimpleSetting#getLength()
	 * @see #getSimpleSetting()
	 * @generated
	 */
	EAttribute getSimpleSetting_Length();

	/**
	 * Returns the meta object for the reference '{@link com.nokia.tools.s60ct.content.confml.SimpleSetting#getMaxInclusive <em>Max Inclusive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Max Inclusive</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.SimpleSetting#getMaxInclusive()
	 * @see #getSimpleSetting()
	 * @generated
	 */
	EReference getSimpleSetting_MaxInclusive();

	/**
	 * Returns the meta object for the reference '{@link com.nokia.tools.s60ct.content.confml.SimpleSetting#getMaxExclusive <em>Max Exclusive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Max Exclusive</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.SimpleSetting#getMaxExclusive()
	 * @see #getSimpleSetting()
	 * @generated
	 */
	EReference getSimpleSetting_MaxExclusive();

	/**
	 * Returns the meta object for the reference '{@link com.nokia.tools.s60ct.content.confml.SimpleSetting#getMinInclusive <em>Min Inclusive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Min Inclusive</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.SimpleSetting#getMinInclusive()
	 * @see #getSimpleSetting()
	 * @generated
	 */
	EReference getSimpleSetting_MinInclusive();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.SimpleSetting#isContainedInLastLayer <em>Contained In Last Layer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Contained In Last Layer</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.SimpleSetting#isContainedInLastLayer()
	 * @see #getSimpleSetting()
	 * @generated
	 */
	EAttribute getSimpleSetting_ContainedInLastLayer();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.SimpleSetting#isLastSavedInLastLayer <em>Last Saved In Last Layer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Saved In Last Layer</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.SimpleSetting#isLastSavedInLastLayer()
	 * @see #getSimpleSetting()
	 * @generated
	 */
	EAttribute getSimpleSetting_LastSavedInLastLayer();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.SimpleSetting#getChosenOption <em>Chosen Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Chosen Option</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.SimpleSetting#getChosenOption()
	 * @see #getSimpleSetting()
	 * @generated
	 */
	EAttribute getSimpleSetting_ChosenOption();

	/**
	 * Returns the meta object for the reference '{@link com.nokia.tools.s60ct.content.confml.SimpleSetting#getMinExclusive <em>Min Exclusive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Min Exclusive</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.SimpleSetting#getMinExclusive()
	 * @see #getSimpleSetting()
	 * @generated
	 */
	EReference getSimpleSetting_MinExclusive();

	/**
	 * Returns the meta object for the attribute list '{@link com.nokia.tools.s60ct.content.confml.SimpleSetting#getPattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Pattern</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.SimpleSetting#getPattern()
	 * @see #getSimpleSetting()
	 * @generated
	 */
	EAttribute getSimpleSetting_Pattern();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.SimpleSetting#getTotalDigits <em>Total Digits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Total Digits</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.SimpleSetting#getTotalDigits()
	 * @see #getSimpleSetting()
	 * @generated
	 */
	EAttribute getSimpleSetting_TotalDigits();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.s60ct.content.confml.Icon <em>Icon</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Icon</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.Icon
	 * @generated
	 */
	EClass getIcon();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.Icon#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.Icon#getTitle()
	 * @see #getIcon()
	 * @generated
	 */
	EAttribute getIcon_Title();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.Icon#getHref <em>Href</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Href</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.Icon#getHref()
	 * @see #getIcon()
	 * @generated
	 */
	EAttribute getIcon_Href();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.Icon#getFilePath <em>File Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File Path</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.Icon#getFilePath()
	 * @see #getIcon()
	 * @generated
	 */
	EAttribute getIcon_FilePath();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.s60ct.content.confml.View <em>View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>View</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.View
	 * @generated
	 */
	EClass getView();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.s60ct.content.confml.View#getParentGroup <em>Parent Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parent Group</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.View#getParentGroup()
	 * @see #getView()
	 * @generated
	 */
	EReference getView_ParentGroup();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.View#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.View#getName()
	 * @see #getView()
	 * @generated
	 */
	EAttribute getView_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.s60ct.content.confml.View#getIcon <em>Icon</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Icon</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.View#getIcon()
	 * @see #getView()
	 * @generated
	 */
	EReference getView_Icon();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.s60ct.content.confml.View#getSharedSettingInstances <em>Shared Setting Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Shared Setting Instances</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.View#getSharedSettingInstances()
	 * @see #getView()
	 * @generated
	 */
	EReference getView_SharedSettingInstances();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.s60ct.content.confml.View#getSharedFeatures <em>Shared Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Shared Features</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.View#getSharedFeatures()
	 * @see #getView()
	 * @generated
	 */
	EReference getView_SharedFeatures();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.s60ct.content.confml.SequenceSetting <em>Sequence Setting</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sequence Setting</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.SequenceSetting
	 * @generated
	 */
	EClass getSequenceSetting();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.s60ct.content.confml.SequenceSetting#getDefaultStructure <em>Default Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Default Structure</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.SequenceSetting#getDefaultStructure()
	 * @see #getSequenceSetting()
	 * @generated
	 */
	EReference getSequenceSetting_DefaultStructure();

	/**
	 * Returns the meta object for the containment reference '{@link com.nokia.tools.s60ct.content.confml.SequenceSetting#getTemplate <em>Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Template</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.SequenceSetting#getTemplate()
	 * @see #getSequenceSetting()
	 * @generated
	 */
	EReference getSequenceSetting_Template();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.s60ct.content.confml.SequenceSetting#getSequenceItem <em>Sequence Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sequence Item</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.SequenceSetting#getSequenceItem()
	 * @see #getSequenceSetting()
	 * @generated
	 */
	EReference getSequenceSetting_SequenceItem();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.SequenceSetting#getMinOccurs <em>Min Occurs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Occurs</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.SequenceSetting#getMinOccurs()
	 * @see #getSequenceSetting()
	 * @generated
	 */
	EAttribute getSequenceSetting_MinOccurs();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.SequenceSetting#getMaxOccurs <em>Max Occurs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Occurs</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.SequenceSetting#getMaxOccurs()
	 * @see #getSequenceSetting()
	 * @generated
	 */
	EAttribute getSequenceSetting_MaxOccurs();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.s60ct.content.confml.SequenceSetting#getLastSavedStructure <em>Last Saved Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Last Saved Structure</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.SequenceSetting#getLastSavedStructure()
	 * @see #getSequenceSetting()
	 * @generated
	 */
	EReference getSequenceSetting_LastSavedStructure();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.SequenceSetting#getMapKey <em>Map Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Map Key</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.SequenceSetting#getMapKey()
	 * @see #getSequenceSetting()
	 * @generated
	 */
	EAttribute getSequenceSetting_MapKey();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.SequenceSetting#getMapValue <em>Map Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Map Value</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.SequenceSetting#getMapValue()
	 * @see #getSequenceSetting()
	 * @generated
	 */
	EAttribute getSequenceSetting_MapValue();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.s60ct.content.confml.Setting <em>Setting</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Setting</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.Setting
	 * @generated
	 */
	EClass getSetting();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.Setting#getAbsRef <em>Abs Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Abs Ref</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.Setting#getAbsRef()
	 * @see #getSetting()
	 * @generated
	 */
	EAttribute getSetting_AbsRef();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.Setting#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.Setting#getName()
	 * @see #getSetting()
	 * @generated
	 */
	EAttribute getSetting_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.s60ct.content.confml.Setting#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Property</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.Setting#getProperty()
	 * @see #getSetting()
	 * @generated
	 */
	EReference getSetting_Property();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.Setting#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.Setting#getDescription()
	 * @see #getSetting()
	 * @generated
	 */
	EAttribute getSetting_Description();

	/**
	 * Returns the meta object for the reference list '{@link com.nokia.tools.s60ct.content.confml.Setting#getLeafGroup <em>Leaf Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Leaf Group</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.Setting#getLeafGroup()
	 * @see #getSetting()
	 * @generated
	 */
	EReference getSetting_LeafGroup();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.Setting#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.Setting#getType()
	 * @see #getSetting()
	 * @generated
	 */
	EAttribute getSetting_Type();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.Setting#isRfsValue <em>Rfs Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rfs Value</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.Setting#isRfsValue()
	 * @see #getSetting()
	 * @generated
	 */
	EAttribute getSetting_RfsValue();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.Setting#getFeatureName <em>Feature Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Feature Name</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.Setting#getFeatureName()
	 * @see #getSetting()
	 * @generated
	 */
	EAttribute getSetting_FeatureName();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.Setting#getNote <em>Note</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Note</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.Setting#getNote()
	 * @see #getSetting()
	 * @generated
	 */
	EAttribute getSetting_Note();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.Setting#getRelevant <em>Relevant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Relevant</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.Setting#getRelevant()
	 * @see #getSetting()
	 * @generated
	 */
	EAttribute getSetting_Relevant();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.Setting#isRequired <em>Required</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Required</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.Setting#isRequired()
	 * @see #getSetting()
	 * @generated
	 */
	EAttribute getSetting_Required();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.Setting#getConstraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Constraint</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.Setting#getConstraint()
	 * @see #getSetting()
	 * @generated
	 */
	EAttribute getSetting_Constraint();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.Setting#isComputedRelevant <em>Computed Relevant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Computed Relevant</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.Setting#isComputedRelevant()
	 * @see #getSetting()
	 * @generated
	 */
	EAttribute getSetting_ComputedRelevant();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.Setting#isComputedConstraint <em>Computed Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Computed Constraint</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.Setting#isComputedConstraint()
	 * @see #getSetting()
	 * @generated
	 */
	EAttribute getSetting_ComputedConstraint();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.Setting#isReadOnly <em>Read Only</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Read Only</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.Setting#isReadOnly()
	 * @see #getSetting()
	 * @generated
	 */
	EAttribute getSetting_ReadOnly();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.Setting#isValueNull <em>Value Null</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value Null</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.Setting#isValueNull()
	 * @see #getSetting()
	 * @generated
	 */
	EAttribute getSetting_ValueNull();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.Setting#getNameOverride <em>Name Override</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name Override</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.Setting#getNameOverride()
	 * @see #getSetting()
	 * @generated
	 */
	EAttribute getSetting_NameOverride();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.Setting#getDescriptionOverride <em>Description Override</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description Override</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.Setting#getDescriptionOverride()
	 * @see #getSetting()
	 * @generated
	 */
	EAttribute getSetting_DescriptionOverride();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.Setting#getDependencies <em>Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dependencies</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.Setting#getDependencies()
	 * @see #getSetting()
	 * @generated
	 */
	EAttribute getSetting_Dependencies();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.s60ct.content.confml.Setting#getOption <em>Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Option</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.Setting#getOption()
	 * @see #getSetting()
	 * @generated
	 */
	EReference getSetting_Option();

	/**
	 * Returns the meta object for the reference list '{@link com.nokia.tools.s60ct.content.confml.Setting#getParentGroup <em>Parent Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Parent Group</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.Setting#getParentGroup()
	 * @see #getSetting()
	 * @generated
	 */
	EReference getSetting_ParentGroup();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.Setting#getOptionDependencies <em>Option Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Option Dependencies</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.Setting#getOptionDependencies()
	 * @see #getSetting()
	 * @generated
	 */
	EAttribute getSetting_OptionDependencies();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.Setting#getRelevantAST <em>Relevant AST</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Relevant AST</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.Setting#getRelevantAST()
	 * @see #getSetting()
	 * @generated
	 */
	EAttribute getSetting_RelevantAST();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.Setting#getConstraintAST <em>Constraint AST</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Constraint AST</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.Setting#getConstraintAST()
	 * @see #getSetting()
	 * @generated
	 */
	EAttribute getSetting_ConstraintAST();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.Setting#getGroupOptionMap <em>Group Option Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Group Option Map</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.Setting#getGroupOptionMap()
	 * @see #getSetting()
	 * @generated
	 */
	EAttribute getSetting_GroupOptionMap();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.s60ct.content.confml.SequenceItem <em>Sequence Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sequence Item</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.SequenceItem
	 * @generated
	 */
	EClass getSequenceItem();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.s60ct.content.confml.SequenceItem#getSetting <em>Setting</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Setting</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.SequenceItem#getSetting()
	 * @see #getSequenceItem()
	 * @generated
	 */
	EReference getSequenceItem_Setting();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.s60ct.content.confml.Option <em>Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Option</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.Option
	 * @generated
	 */
	EClass getOption();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.Option#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.Option#getName()
	 * @see #getOption()
	 * @generated
	 */
	EAttribute getOption_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.Option#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.Option#getValue()
	 * @see #getOption()
	 * @generated
	 */
	EAttribute getOption_Value();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.Option#getRelevant <em>Relevant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Relevant</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.Option#getRelevant()
	 * @see #getOption()
	 * @generated
	 */
	EAttribute getOption_Relevant();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.Option#getMap <em>Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Map</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.Option#getMap()
	 * @see #getOption()
	 * @generated
	 */
	EAttribute getOption_Map();

	/**
	 * Returns the meta object for the reference '{@link com.nokia.tools.s60ct.content.confml.Option#getMapSourceSetting <em>Map Source Setting</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Map Source Setting</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.Option#getMapSourceSetting()
	 * @see #getOption()
	 * @generated
	 */
	EReference getOption_MapSourceSetting();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.Option#getOptionValues <em>Option Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Option Values</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.Option#getOptionValues()
	 * @see #getOption()
	 * @generated
	 */
	EAttribute getOption_OptionValues();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.Option#getRelevantAST <em>Relevant AST</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Relevant AST</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.Option#getRelevantAST()
	 * @see #getOption()
	 * @generated
	 */
	EAttribute getOption_RelevantAST();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.s60ct.content.confml.Group <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Group</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.Group
	 * @generated
	 */
	EClass getGroup();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.Group#getDesc <em>Desc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Desc</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.Group#getDesc()
	 * @see #getGroup()
	 * @generated
	 */
	EAttribute getGroup_Desc();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.s60ct.content.confml.Group#getIcon <em>Icon</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Icon</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.Group#getIcon()
	 * @see #getGroup()
	 * @generated
	 */
	EReference getGroup_Icon();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.Group#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.Group#getName()
	 * @see #getGroup()
	 * @generated
	 */
	EAttribute getGroup_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.Group#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.Group#getId()
	 * @see #getGroup()
	 * @generated
	 */
	EAttribute getGroup_Id();

	/**
	 * Returns the meta object for the reference list '{@link com.nokia.tools.s60ct.content.confml.Group#getSettings <em>Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Settings</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.Group#getSettings()
	 * @see #getGroup()
	 * @generated
	 */
	EReference getGroup_Settings();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.s60ct.content.confml.Property <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.Property
	 * @generated
	 */
	EClass getProperty();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.Property#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.Property#getName()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.Property#getUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unit</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.Property#getUnit()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Unit();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.Property#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.Property#getValue()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Value();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.s60ct.content.confml.FileSystemEntrySetting <em>File System Entry Setting</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File System Entry Setting</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.FileSystemEntrySetting
	 * @generated
	 */
	EClass getFileSystemEntrySetting();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.FileSystemEntrySetting#isFile <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.FileSystemEntrySetting#isFile()
	 * @see #getFileSystemEntrySetting()
	 * @generated
	 */
	EAttribute getFileSystemEntrySetting_File();

	/**
	 * Returns the meta object for the containment reference '{@link com.nokia.tools.s60ct.content.confml.FileSystemEntrySetting#getSourceFilePath <em>Source File Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Source File Path</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.FileSystemEntrySetting#getSourceFilePath()
	 * @see #getFileSystemEntrySetting()
	 * @generated
	 */
	EReference getFileSystemEntrySetting_SourceFilePath();

	/**
	 * Returns the meta object for the containment reference '{@link com.nokia.tools.s60ct.content.confml.FileSystemEntrySetting#getTargetFilePath <em>Target File Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target File Path</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.FileSystemEntrySetting#getTargetFilePath()
	 * @see #getFileSystemEntrySetting()
	 * @generated
	 */
	EReference getFileSystemEntrySetting_TargetFilePath();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.FileSystemEntrySetting#getChosenOption <em>Chosen Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Chosen Option</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.FileSystemEntrySetting#getChosenOption()
	 * @see #getFileSystemEntrySetting()
	 * @generated
	 */
	EAttribute getFileSystemEntrySetting_ChosenOption();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.FileSystemEntrySetting#getPattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pattern</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.FileSystemEntrySetting#getPattern()
	 * @see #getFileSystemEntrySetting()
	 * @generated
	 */
	EAttribute getFileSystemEntrySetting_Pattern();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.s60ct.content.confml.Feature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.Feature
	 * @generated
	 */
	EClass getFeature();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.Feature#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.Feature#getName()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.Feature#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ref</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.Feature#getRef()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_Ref();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.Feature#getRelevant <em>Relevant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Relevant</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.Feature#getRelevant()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_Relevant();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.Feature#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.Feature#getDescription()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_Description();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.Feature#getIconTitle <em>Icon Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Icon Title</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.Feature#getIconTitle()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_IconTitle();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.Feature#getIconDescriptor <em>Icon Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Icon Descriptor</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.Feature#getIconDescriptor()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_IconDescriptor();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.Feature#getIconURI <em>Icon URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Icon URI</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.Feature#getIconURI()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_IconURI();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.Feature#isComputedRelevant <em>Computed Relevant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Computed Relevant</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.Feature#isComputedRelevant()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_ComputedRelevant();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.Feature#getRelevantAST <em>Relevant AST</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Relevant AST</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.Feature#getRelevantAST()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_RelevantAST();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.s60ct.content.confml.MinInclusive <em>Min Inclusive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Min Inclusive</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.MinInclusive
	 * @generated
	 */
	EClass getMinInclusive();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.MinInclusive#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.MinInclusive#getValue()
	 * @see #getMinInclusive()
	 * @generated
	 */
	EAttribute getMinInclusive_Value();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.s60ct.content.confml.MaxInclusive <em>Max Inclusive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Max Inclusive</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.MaxInclusive
	 * @generated
	 */
	EClass getMaxInclusive();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.MaxInclusive#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.MaxInclusive#getValue()
	 * @see #getMaxInclusive()
	 * @generated
	 */
	EAttribute getMaxInclusive_Value();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.s60ct.content.confml.MaxExclusive <em>Max Exclusive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Max Exclusive</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.MaxExclusive
	 * @generated
	 */
	EClass getMaxExclusive();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.MaxExclusive#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.MaxExclusive#getValue()
	 * @see #getMaxExclusive()
	 * @generated
	 */
	EAttribute getMaxExclusive_Value();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.s60ct.content.confml.MinExclusive <em>Min Exclusive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Min Exclusive</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.MinExclusive
	 * @generated
	 */
	EClass getMinExclusive();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.MinExclusive#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.MinExclusive#getValue()
	 * @see #getMinExclusive()
	 * @generated
	 */
	EAttribute getMinExclusive_Value();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.s60ct.content.confml.FilePath <em>File Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File Path</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.FilePath
	 * @generated
	 */
	EClass getFilePath();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.FilePath#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.FilePath#getPath()
	 * @see #getFilePath()
	 * @generated
	 */
	EAttribute getFilePath_Path();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.FilePath#getLastSavedPath <em>Last Saved Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Saved Path</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.FilePath#getLastSavedPath()
	 * @see #getFilePath()
	 * @generated
	 */
	EAttribute getFilePath_LastSavedPath();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.FilePath#getDefaultPath <em>Default Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Path</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.FilePath#getDefaultPath()
	 * @see #getFilePath()
	 * @generated
	 */
	EAttribute getFilePath_DefaultPath();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.FilePath#isPathReadOnly <em>Path Read Only</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path Read Only</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.FilePath#isPathReadOnly()
	 * @see #getFilePath()
	 * @generated
	 */
	EAttribute getFilePath_PathReadOnly();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.FilePath#getPathNameOverride <em>Path Name Override</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path Name Override</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.FilePath#getPathNameOverride()
	 * @see #getFilePath()
	 * @generated
	 */
	EAttribute getFilePath_PathNameOverride();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.FilePath#getPathDescriptionOverride <em>Path Description Override</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path Description Override</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.FilePath#getPathDescriptionOverride()
	 * @see #getFilePath()
	 * @generated
	 */
	EAttribute getFilePath_PathDescriptionOverride();

	/**
	 * Returns the meta object for the reference '{@link com.nokia.tools.s60ct.content.confml.FilePath#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.FilePath#getParent()
	 * @see #getFilePath()
	 * @generated
	 */
	EReference getFilePath_Parent();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.FilePath#isContainedInLastLayer <em>Contained In Last Layer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Contained In Last Layer</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.FilePath#isContainedInLastLayer()
	 * @see #getFilePath()
	 * @generated
	 */
	EAttribute getFilePath_ContainedInLastLayer();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.FilePath#isLastSavedInLastLayer <em>Last Saved In Last Layer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Saved In Last Layer</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.FilePath#isLastSavedInLastLayer()
	 * @see #getFilePath()
	 * @generated
	 */
	EAttribute getFilePath_LastSavedInLastLayer();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.s60ct.content.confml.OptionMapEntry <em>Option Map Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Option Map Entry</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.OptionMapEntry
	 * @generated
	 */
	EClass getOptionMapEntry();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.OptionMapEntry#getValue2Save <em>Value2 Save</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value2 Save</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.OptionMapEntry#getValue2Save()
	 * @see #getOptionMapEntry()
	 * @generated
	 */
	EAttribute getOptionMapEntry_Value2Save();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.content.confml.OptionMapEntry#getMapValue <em>Map Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Map Value</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.OptionMapEntry#getMapValue()
	 * @see #getOptionMapEntry()
	 * @generated
	 */
	EAttribute getOptionMapEntry_MapValue();

	/**
	 * Returns the meta object for enum '{@link com.nokia.tools.s60ct.content.confml.TYPE <em>TYPE</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>TYPE</em>'.
	 * @see com.nokia.tools.s60ct.content.confml.TYPE
	 * @generated
	 */
	EEnum getTYPE();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.emf.common.util.URI <em>URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>URI</em>'.
	 * @see org.eclipse.emf.common.util.URI
	 * @model instanceClass="org.eclipse.emf.common.util.URI"
	 * @generated
	 */
	EDataType getURI();

	/**
	 * Returns the meta object for data type '{@link java.lang.Object <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Object</em>'.
	 * @see java.lang.Object
	 * @model instanceClass="java.lang.Object"
	 * @generated
	 */
	EDataType getObject();

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
		 * The meta object literal for the '{@link com.nokia.tools.s60ct.content.confml.impl.ParentGroupImpl <em>Parent Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.s60ct.content.confml.impl.ParentGroupImpl
		 * @see com.nokia.tools.s60ct.content.confml.impl.ConfmlPackageImpl#getParentGroup()
		 * @generated
		 */
		EClass PARENT_GROUP = eINSTANCE.getParentGroup();

		/**
		 * The meta object literal for the '<em><b>Leaf Group</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARENT_GROUP__LEAF_GROUP = eINSTANCE.getParentGroup_LeafGroup();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.s60ct.content.confml.impl.LeafGroupImpl <em>Leaf Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.s60ct.content.confml.impl.LeafGroupImpl
		 * @see com.nokia.tools.s60ct.content.confml.impl.ConfmlPackageImpl#getLeafGroup()
		 * @generated
		 */
		EClass LEAF_GROUP = eINSTANCE.getLeafGroup();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.s60ct.content.confml.impl.SimpleSettingImpl <em>Simple Setting</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.s60ct.content.confml.impl.SimpleSettingImpl
		 * @see com.nokia.tools.s60ct.content.confml.impl.ConfmlPackageImpl#getSimpleSetting()
		 * @generated
		 */
		EClass SIMPLE_SETTING = eINSTANCE.getSimpleSetting();

		/**
		 * The meta object literal for the '<em><b>Default Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_SETTING__DEFAULT_VALUE = eINSTANCE.getSimpleSetting_DefaultValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_SETTING__VALUE = eINSTANCE.getSimpleSetting_Value();

		/**
		 * The meta object literal for the '<em><b>Last Saved Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_SETTING__LAST_SAVED_VALUE = eINSTANCE.getSimpleSetting_LastSavedValue();

		/**
		 * The meta object literal for the '<em><b>Min Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_SETTING__MIN_LENGTH = eINSTANCE.getSimpleSetting_MinLength();

		/**
		 * The meta object literal for the '<em><b>Max Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_SETTING__MAX_LENGTH = eINSTANCE.getSimpleSetting_MaxLength();

		/**
		 * The meta object literal for the '<em><b>Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_SETTING__LENGTH = eINSTANCE.getSimpleSetting_Length();

		/**
		 * The meta object literal for the '<em><b>Max Inclusive</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMPLE_SETTING__MAX_INCLUSIVE = eINSTANCE.getSimpleSetting_MaxInclusive();

		/**
		 * The meta object literal for the '<em><b>Max Exclusive</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMPLE_SETTING__MAX_EXCLUSIVE = eINSTANCE.getSimpleSetting_MaxExclusive();

		/**
		 * The meta object literal for the '<em><b>Min Inclusive</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMPLE_SETTING__MIN_INCLUSIVE = eINSTANCE.getSimpleSetting_MinInclusive();

		/**
		 * The meta object literal for the '<em><b>Contained In Last Layer</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_SETTING__CONTAINED_IN_LAST_LAYER = eINSTANCE.getSimpleSetting_ContainedInLastLayer();

		/**
		 * The meta object literal for the '<em><b>Last Saved In Last Layer</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_SETTING__LAST_SAVED_IN_LAST_LAYER = eINSTANCE.getSimpleSetting_LastSavedInLastLayer();

		/**
		 * The meta object literal for the '<em><b>Chosen Option</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_SETTING__CHOSEN_OPTION = eINSTANCE.getSimpleSetting_ChosenOption();

		/**
		 * The meta object literal for the '<em><b>Min Exclusive</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMPLE_SETTING__MIN_EXCLUSIVE = eINSTANCE.getSimpleSetting_MinExclusive();

		/**
		 * The meta object literal for the '<em><b>Pattern</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_SETTING__PATTERN = eINSTANCE.getSimpleSetting_Pattern();

		/**
		 * The meta object literal for the '<em><b>Total Digits</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_SETTING__TOTAL_DIGITS = eINSTANCE.getSimpleSetting_TotalDigits();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.s60ct.content.confml.impl.IconImpl <em>Icon</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.s60ct.content.confml.impl.IconImpl
		 * @see com.nokia.tools.s60ct.content.confml.impl.ConfmlPackageImpl#getIcon()
		 * @generated
		 */
		EClass ICON = eINSTANCE.getIcon();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ICON__TITLE = eINSTANCE.getIcon_Title();

		/**
		 * The meta object literal for the '<em><b>Href</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ICON__HREF = eINSTANCE.getIcon_Href();

		/**
		 * The meta object literal for the '<em><b>File Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ICON__FILE_PATH = eINSTANCE.getIcon_FilePath();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.s60ct.content.confml.impl.ViewImpl <em>View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.s60ct.content.confml.impl.ViewImpl
		 * @see com.nokia.tools.s60ct.content.confml.impl.ConfmlPackageImpl#getView()
		 * @generated
		 */
		EClass VIEW = eINSTANCE.getView();

		/**
		 * The meta object literal for the '<em><b>Parent Group</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIEW__PARENT_GROUP = eINSTANCE.getView_ParentGroup();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIEW__NAME = eINSTANCE.getView_Name();

		/**
		 * The meta object literal for the '<em><b>Icon</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIEW__ICON = eINSTANCE.getView_Icon();

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
		 * The meta object literal for the '{@link com.nokia.tools.s60ct.content.confml.impl.SequenceSettingImpl <em>Sequence Setting</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.s60ct.content.confml.impl.SequenceSettingImpl
		 * @see com.nokia.tools.s60ct.content.confml.impl.ConfmlPackageImpl#getSequenceSetting()
		 * @generated
		 */
		EClass SEQUENCE_SETTING = eINSTANCE.getSequenceSetting();

		/**
		 * The meta object literal for the '<em><b>Default Structure</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEQUENCE_SETTING__DEFAULT_STRUCTURE = eINSTANCE.getSequenceSetting_DefaultStructure();

		/**
		 * The meta object literal for the '<em><b>Template</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEQUENCE_SETTING__TEMPLATE = eINSTANCE.getSequenceSetting_Template();

		/**
		 * The meta object literal for the '<em><b>Sequence Item</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEQUENCE_SETTING__SEQUENCE_ITEM = eINSTANCE.getSequenceSetting_SequenceItem();

		/**
		 * The meta object literal for the '<em><b>Min Occurs</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEQUENCE_SETTING__MIN_OCCURS = eINSTANCE.getSequenceSetting_MinOccurs();

		/**
		 * The meta object literal for the '<em><b>Max Occurs</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEQUENCE_SETTING__MAX_OCCURS = eINSTANCE.getSequenceSetting_MaxOccurs();

		/**
		 * The meta object literal for the '<em><b>Last Saved Structure</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEQUENCE_SETTING__LAST_SAVED_STRUCTURE = eINSTANCE.getSequenceSetting_LastSavedStructure();

		/**
		 * The meta object literal for the '<em><b>Map Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEQUENCE_SETTING__MAP_KEY = eINSTANCE.getSequenceSetting_MapKey();

		/**
		 * The meta object literal for the '<em><b>Map Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEQUENCE_SETTING__MAP_VALUE = eINSTANCE.getSequenceSetting_MapValue();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.s60ct.content.confml.impl.SettingImpl <em>Setting</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.s60ct.content.confml.impl.SettingImpl
		 * @see com.nokia.tools.s60ct.content.confml.impl.ConfmlPackageImpl#getSetting()
		 * @generated
		 */
		EClass SETTING = eINSTANCE.getSetting();

		/**
		 * The meta object literal for the '<em><b>Abs Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTING__ABS_REF = eINSTANCE.getSetting_AbsRef();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTING__NAME = eINSTANCE.getSetting_Name();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SETTING__PROPERTY = eINSTANCE.getSetting_Property();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTING__DESCRIPTION = eINSTANCE.getSetting_Description();

		/**
		 * The meta object literal for the '<em><b>Leaf Group</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SETTING__LEAF_GROUP = eINSTANCE.getSetting_LeafGroup();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTING__TYPE = eINSTANCE.getSetting_Type();

		/**
		 * The meta object literal for the '<em><b>Rfs Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTING__RFS_VALUE = eINSTANCE.getSetting_RfsValue();

		/**
		 * The meta object literal for the '<em><b>Feature Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTING__FEATURE_NAME = eINSTANCE.getSetting_FeatureName();

		/**
		 * The meta object literal for the '<em><b>Note</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTING__NOTE = eINSTANCE.getSetting_Note();

		/**
		 * The meta object literal for the '<em><b>Relevant</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTING__RELEVANT = eINSTANCE.getSetting_Relevant();

		/**
		 * The meta object literal for the '<em><b>Required</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTING__REQUIRED = eINSTANCE.getSetting_Required();

		/**
		 * The meta object literal for the '<em><b>Constraint</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTING__CONSTRAINT = eINSTANCE.getSetting_Constraint();

		/**
		 * The meta object literal for the '<em><b>Computed Relevant</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTING__COMPUTED_RELEVANT = eINSTANCE.getSetting_ComputedRelevant();

		/**
		 * The meta object literal for the '<em><b>Computed Constraint</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTING__COMPUTED_CONSTRAINT = eINSTANCE.getSetting_ComputedConstraint();

		/**
		 * The meta object literal for the '<em><b>Read Only</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTING__READ_ONLY = eINSTANCE.getSetting_ReadOnly();

		/**
		 * The meta object literal for the '<em><b>Value Null</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTING__VALUE_NULL = eINSTANCE.getSetting_ValueNull();

		/**
		 * The meta object literal for the '<em><b>Name Override</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTING__NAME_OVERRIDE = eINSTANCE.getSetting_NameOverride();

		/**
		 * The meta object literal for the '<em><b>Description Override</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTING__DESCRIPTION_OVERRIDE = eINSTANCE.getSetting_DescriptionOverride();

		/**
		 * The meta object literal for the '<em><b>Dependencies</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTING__DEPENDENCIES = eINSTANCE.getSetting_Dependencies();

		/**
		 * The meta object literal for the '<em><b>Option</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SETTING__OPTION = eINSTANCE.getSetting_Option();

		/**
		 * The meta object literal for the '<em><b>Parent Group</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SETTING__PARENT_GROUP = eINSTANCE.getSetting_ParentGroup();

		/**
		 * The meta object literal for the '<em><b>Option Dependencies</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTING__OPTION_DEPENDENCIES = eINSTANCE.getSetting_OptionDependencies();

		/**
		 * The meta object literal for the '<em><b>Relevant AST</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTING__RELEVANT_AST = eINSTANCE.getSetting_RelevantAST();

		/**
		 * The meta object literal for the '<em><b>Constraint AST</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTING__CONSTRAINT_AST = eINSTANCE.getSetting_ConstraintAST();

		/**
		 * The meta object literal for the '<em><b>Group Option Map</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTING__GROUP_OPTION_MAP = eINSTANCE.getSetting_GroupOptionMap();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.s60ct.content.confml.impl.SequenceItemImpl <em>Sequence Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.s60ct.content.confml.impl.SequenceItemImpl
		 * @see com.nokia.tools.s60ct.content.confml.impl.ConfmlPackageImpl#getSequenceItem()
		 * @generated
		 */
		EClass SEQUENCE_ITEM = eINSTANCE.getSequenceItem();

		/**
		 * The meta object literal for the '<em><b>Setting</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEQUENCE_ITEM__SETTING = eINSTANCE.getSequenceItem_Setting();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.s60ct.content.confml.impl.OptionImpl <em>Option</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.s60ct.content.confml.impl.OptionImpl
		 * @see com.nokia.tools.s60ct.content.confml.impl.ConfmlPackageImpl#getOption()
		 * @generated
		 */
		EClass OPTION = eINSTANCE.getOption();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPTION__NAME = eINSTANCE.getOption_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPTION__VALUE = eINSTANCE.getOption_Value();

		/**
		 * The meta object literal for the '<em><b>Relevant</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPTION__RELEVANT = eINSTANCE.getOption_Relevant();

		/**
		 * The meta object literal for the '<em><b>Map</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPTION__MAP = eINSTANCE.getOption_Map();

		/**
		 * The meta object literal for the '<em><b>Map Source Setting</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPTION__MAP_SOURCE_SETTING = eINSTANCE.getOption_MapSourceSetting();

		/**
		 * The meta object literal for the '<em><b>Option Values</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPTION__OPTION_VALUES = eINSTANCE.getOption_OptionValues();

		/**
		 * The meta object literal for the '<em><b>Relevant AST</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPTION__RELEVANT_AST = eINSTANCE.getOption_RelevantAST();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.s60ct.content.confml.impl.GroupImpl <em>Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.s60ct.content.confml.impl.GroupImpl
		 * @see com.nokia.tools.s60ct.content.confml.impl.ConfmlPackageImpl#getGroup()
		 * @generated
		 */
		EClass GROUP = eINSTANCE.getGroup();

		/**
		 * The meta object literal for the '<em><b>Desc</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GROUP__DESC = eINSTANCE.getGroup_Desc();

		/**
		 * The meta object literal for the '<em><b>Icon</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GROUP__ICON = eINSTANCE.getGroup_Icon();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GROUP__NAME = eINSTANCE.getGroup_Name();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GROUP__ID = eINSTANCE.getGroup_Id();

		/**
		 * The meta object literal for the '<em><b>Settings</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GROUP__SETTINGS = eINSTANCE.getGroup_Settings();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.s60ct.content.confml.impl.PropertyImpl <em>Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.s60ct.content.confml.impl.PropertyImpl
		 * @see com.nokia.tools.s60ct.content.confml.impl.ConfmlPackageImpl#getProperty()
		 * @generated
		 */
		EClass PROPERTY = eINSTANCE.getProperty();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__NAME = eINSTANCE.getProperty_Name();

		/**
		 * The meta object literal for the '<em><b>Unit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__UNIT = eINSTANCE.getProperty_Unit();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__VALUE = eINSTANCE.getProperty_Value();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.s60ct.content.confml.impl.FileSystemEntrySettingImpl <em>File System Entry Setting</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.s60ct.content.confml.impl.FileSystemEntrySettingImpl
		 * @see com.nokia.tools.s60ct.content.confml.impl.ConfmlPackageImpl#getFileSystemEntrySetting()
		 * @generated
		 */
		EClass FILE_SYSTEM_ENTRY_SETTING = eINSTANCE.getFileSystemEntrySetting();

		/**
		 * The meta object literal for the '<em><b>File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_SYSTEM_ENTRY_SETTING__FILE = eINSTANCE.getFileSystemEntrySetting_File();

		/**
		 * The meta object literal for the '<em><b>Source File Path</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FILE_SYSTEM_ENTRY_SETTING__SOURCE_FILE_PATH = eINSTANCE.getFileSystemEntrySetting_SourceFilePath();

		/**
		 * The meta object literal for the '<em><b>Target File Path</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FILE_SYSTEM_ENTRY_SETTING__TARGET_FILE_PATH = eINSTANCE.getFileSystemEntrySetting_TargetFilePath();

		/**
		 * The meta object literal for the '<em><b>Chosen Option</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_SYSTEM_ENTRY_SETTING__CHOSEN_OPTION = eINSTANCE.getFileSystemEntrySetting_ChosenOption();

		/**
		 * The meta object literal for the '<em><b>Pattern</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_SYSTEM_ENTRY_SETTING__PATTERN = eINSTANCE.getFileSystemEntrySetting_Pattern();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.s60ct.content.confml.impl.FeatureImpl <em>Feature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.s60ct.content.confml.impl.FeatureImpl
		 * @see com.nokia.tools.s60ct.content.confml.impl.ConfmlPackageImpl#getFeature()
		 * @generated
		 */
		EClass FEATURE = eINSTANCE.getFeature();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE__NAME = eINSTANCE.getFeature_Name();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE__REF = eINSTANCE.getFeature_Ref();

		/**
		 * The meta object literal for the '<em><b>Relevant</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE__RELEVANT = eINSTANCE.getFeature_Relevant();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE__DESCRIPTION = eINSTANCE.getFeature_Description();

		/**
		 * The meta object literal for the '<em><b>Icon Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE__ICON_TITLE = eINSTANCE.getFeature_IconTitle();

		/**
		 * The meta object literal for the '<em><b>Icon Descriptor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE__ICON_DESCRIPTOR = eINSTANCE.getFeature_IconDescriptor();

		/**
		 * The meta object literal for the '<em><b>Icon URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE__ICON_URI = eINSTANCE.getFeature_IconURI();

		/**
		 * The meta object literal for the '<em><b>Computed Relevant</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE__COMPUTED_RELEVANT = eINSTANCE.getFeature_ComputedRelevant();

		/**
		 * The meta object literal for the '<em><b>Relevant AST</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE__RELEVANT_AST = eINSTANCE.getFeature_RelevantAST();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.s60ct.content.confml.impl.MinInclusiveImpl <em>Min Inclusive</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.s60ct.content.confml.impl.MinInclusiveImpl
		 * @see com.nokia.tools.s60ct.content.confml.impl.ConfmlPackageImpl#getMinInclusive()
		 * @generated
		 */
		EClass MIN_INCLUSIVE = eINSTANCE.getMinInclusive();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MIN_INCLUSIVE__VALUE = eINSTANCE.getMinInclusive_Value();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.s60ct.content.confml.impl.MaxInclusiveImpl <em>Max Inclusive</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.s60ct.content.confml.impl.MaxInclusiveImpl
		 * @see com.nokia.tools.s60ct.content.confml.impl.ConfmlPackageImpl#getMaxInclusive()
		 * @generated
		 */
		EClass MAX_INCLUSIVE = eINSTANCE.getMaxInclusive();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAX_INCLUSIVE__VALUE = eINSTANCE.getMaxInclusive_Value();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.s60ct.content.confml.impl.MaxExclusiveImpl <em>Max Exclusive</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.s60ct.content.confml.impl.MaxExclusiveImpl
		 * @see com.nokia.tools.s60ct.content.confml.impl.ConfmlPackageImpl#getMaxExclusive()
		 * @generated
		 */
		EClass MAX_EXCLUSIVE = eINSTANCE.getMaxExclusive();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAX_EXCLUSIVE__VALUE = eINSTANCE.getMaxExclusive_Value();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.s60ct.content.confml.impl.MinExclusiveImpl <em>Min Exclusive</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.s60ct.content.confml.impl.MinExclusiveImpl
		 * @see com.nokia.tools.s60ct.content.confml.impl.ConfmlPackageImpl#getMinExclusive()
		 * @generated
		 */
		EClass MIN_EXCLUSIVE = eINSTANCE.getMinExclusive();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MIN_EXCLUSIVE__VALUE = eINSTANCE.getMinExclusive_Value();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.s60ct.content.confml.impl.FilePathImpl <em>File Path</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.s60ct.content.confml.impl.FilePathImpl
		 * @see com.nokia.tools.s60ct.content.confml.impl.ConfmlPackageImpl#getFilePath()
		 * @generated
		 */
		EClass FILE_PATH = eINSTANCE.getFilePath();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_PATH__PATH = eINSTANCE.getFilePath_Path();

		/**
		 * The meta object literal for the '<em><b>Last Saved Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_PATH__LAST_SAVED_PATH = eINSTANCE.getFilePath_LastSavedPath();

		/**
		 * The meta object literal for the '<em><b>Default Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_PATH__DEFAULT_PATH = eINSTANCE.getFilePath_DefaultPath();

		/**
		 * The meta object literal for the '<em><b>Path Read Only</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_PATH__PATH_READ_ONLY = eINSTANCE.getFilePath_PathReadOnly();

		/**
		 * The meta object literal for the '<em><b>Path Name Override</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_PATH__PATH_NAME_OVERRIDE = eINSTANCE.getFilePath_PathNameOverride();

		/**
		 * The meta object literal for the '<em><b>Path Description Override</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_PATH__PATH_DESCRIPTION_OVERRIDE = eINSTANCE.getFilePath_PathDescriptionOverride();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FILE_PATH__PARENT = eINSTANCE.getFilePath_Parent();

		/**
		 * The meta object literal for the '<em><b>Contained In Last Layer</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_PATH__CONTAINED_IN_LAST_LAYER = eINSTANCE.getFilePath_ContainedInLastLayer();

		/**
		 * The meta object literal for the '<em><b>Last Saved In Last Layer</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_PATH__LAST_SAVED_IN_LAST_LAYER = eINSTANCE.getFilePath_LastSavedInLastLayer();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.s60ct.content.confml.impl.OptionMapEntryImpl <em>Option Map Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.s60ct.content.confml.impl.OptionMapEntryImpl
		 * @see com.nokia.tools.s60ct.content.confml.impl.ConfmlPackageImpl#getOptionMapEntry()
		 * @generated
		 */
		EClass OPTION_MAP_ENTRY = eINSTANCE.getOptionMapEntry();

		/**
		 * The meta object literal for the '<em><b>Value2 Save</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPTION_MAP_ENTRY__VALUE2_SAVE = eINSTANCE.getOptionMapEntry_Value2Save();

		/**
		 * The meta object literal for the '<em><b>Map Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPTION_MAP_ENTRY__MAP_VALUE = eINSTANCE.getOptionMapEntry_MapValue();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.s60ct.content.confml.TYPE <em>TYPE</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.s60ct.content.confml.TYPE
		 * @see com.nokia.tools.s60ct.content.confml.impl.ConfmlPackageImpl#getTYPE()
		 * @generated
		 */
		EEnum TYPE = eINSTANCE.getTYPE();

		/**
		 * The meta object literal for the '<em>URI</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.common.util.URI
		 * @see com.nokia.tools.s60ct.content.confml.impl.ConfmlPackageImpl#getURI()
		 * @generated
		 */
		EDataType URI = eINSTANCE.getURI();

		/**
		 * The meta object literal for the '<em>Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Object
		 * @see com.nokia.tools.s60ct.content.confml.impl.ConfmlPackageImpl#getObject()
		 * @generated
		 */
		EDataType OBJECT = eINSTANCE.getObject();

	}

} //ConfmlPackage
