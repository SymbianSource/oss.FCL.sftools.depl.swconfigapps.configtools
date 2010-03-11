/**
 * Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies). 
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
 * $Id$
 */
package com.nokia.tools.carbide.ct.confml.model.confml2;

import com.nokia.tools.carbide.ct.confml.model.confml1.EConfML1Package;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfML2Factory
 * @model kind="package"
 * @generated
 */
public interface EConfML2Package extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "confml2";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.s60.com/xml/confml/2";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "confml";

	/**
	 * The package content type ID.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eCONTENT_TYPE = "com.nokia.tools.carbide.ct.content.confml2";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EConfML2Package eINSTANCE = com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2PackageImpl
			.init();

	/**
	 * The meta object id for the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.impl.ECommonAttrsImpl <em>ECommon Attrs</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.ECommonAttrsImpl
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2PackageImpl#getECommonAttrs()
	 * @generated
	 */
	int ECOMMON_ATTRS = 26;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECOMMON_ATTRS__ID = 0;

	/**
	 * The number of structural features of the '<em>ECommon Attrs</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECOMMON_ATTRS_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfigurationElementImpl <em>EConfiguration Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfigurationElementImpl
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2PackageImpl#getEConfigurationElement()
	 * @generated
	 */
	int ECONFIGURATION_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECONFIGURATION_ELEMENT__ID = ECOMMON_ATTRS__ID;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECONFIGURATION_ELEMENT__CONTENTS = ECOMMON_ATTRS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECONFIGURATION_ELEMENT__LINKS = ECOMMON_ATTRS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Icons</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECONFIGURATION_ELEMENT__ICONS = ECOMMON_ATTRS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Descriptions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECONFIGURATION_ELEMENT__DESCRIPTIONS = ECOMMON_ATTRS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Metas</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECONFIGURATION_ELEMENT__METAS = ECOMMON_ATTRS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Configurations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECONFIGURATION_ELEMENT__CONFIGURATIONS = ECOMMON_ATTRS_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Features</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECONFIGURATION_ELEMENT__FEATURES = ECOMMON_ATTRS_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Views</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECONFIGURATION_ELEMENT__VIEWS = ECOMMON_ATTRS_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECONFIGURATION_ELEMENT__DATA = ECOMMON_ATTRS_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Rfs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECONFIGURATION_ELEMENT__RFS = ECOMMON_ATTRS_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECONFIGURATION_ELEMENT__NAME = ECOMMON_ATTRS_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECONFIGURATION_ELEMENT__VERSION = ECOMMON_ATTRS_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Includes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECONFIGURATION_ELEMENT__INCLUDES = ECOMMON_ATTRS_FEATURE_COUNT + 12;

	/**
	 * The number of structural features of the '<em>EConfiguration Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECONFIGURATION_ELEMENT_FEATURE_COUNT = ECOMMON_ATTRS_FEATURE_COUNT + 13;

	/**
	 * The meta object id for the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EContents <em>EContents</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EContents
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2PackageImpl#getEContents()
	 * @generated
	 */
	int ECONTENTS = 1;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECONTENTS__CONTENTS = 0;

	/**
	 * The number of structural features of the '<em>EContents</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECONTENTS_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.impl.EFeatureElementImpl <em>EFeature Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EFeatureElementImpl
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2PackageImpl#getEFeatureElement()
	 * @generated
	 */
	int EFEATURE_ELEMENT = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFEATURE_ELEMENT__ID = ECOMMON_ATTRS__ID;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFEATURE_ELEMENT__CONTENTS = ECOMMON_ATTRS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Descriptions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFEATURE_ELEMENT__DESCRIPTIONS = ECOMMON_ATTRS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFEATURE_ELEMENT__LINKS = ECOMMON_ATTRS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Settings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFEATURE_ELEMENT__SETTINGS = ECOMMON_ATTRS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Icons</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFEATURE_ELEMENT__ICONS = ECOMMON_ATTRS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFEATURE_ELEMENT__REF = ECOMMON_ATTRS_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFEATURE_ELEMENT__NAME = ECOMMON_ATTRS_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Relevant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFEATURE_ELEMENT__RELEVANT = ECOMMON_ATTRS_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>EFeature Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFEATURE_ELEMENT_FEATURE_COUNT = ECOMMON_ATTRS_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.impl.EFeatureDataImpl <em>EFeature Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EFeatureDataImpl
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2PackageImpl#getEFeatureData()
	 * @generated
	 */
	int EFEATURE_DATA = 3;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFEATURE_DATA__REF = EConfML1Package.EREF_NAMED_ELEMENT__REF;

	/**
	 * The feature id for the '<em><b>Settings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFEATURE_DATA__SETTINGS = EConfML1Package.EREF_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>EFeature Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFEATURE_DATA_FEATURE_COUNT = EConfML1Package.EREF_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingTypeContainer <em>ESetting Type Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.ESettingTypeContainer
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2PackageImpl#getESettingTypeContainer()
	 * @generated
	 */
	int ESETTING_TYPE_CONTAINER = 4;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_TYPE_CONTAINER__CONTENTS = ECONTENTS__CONTENTS;

	/**
	 * The feature id for the '<em><b>Settings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_TYPE_CONTAINER__SETTINGS = ECONTENTS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>ESetting Type Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_TYPE_CONTAINER_FEATURE_COUNT = ECONTENTS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.impl.ESettingElementImpl <em>ESetting Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.ESettingElementImpl
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2PackageImpl#getESettingElement()
	 * @generated
	 */
	int ESETTING_ELEMENT = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_ELEMENT__ID = ECOMMON_ATTRS__ID;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_ELEMENT__CONTENTS = ECOMMON_ATTRS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Descriptions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_ELEMENT__DESCRIPTIONS = ECOMMON_ATTRS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_ELEMENT__LINKS = ECOMMON_ATTRS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Settings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_ELEMENT__SETTINGS = ECOMMON_ATTRS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Icons</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_ELEMENT__ICONS = ECOMMON_ATTRS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_ELEMENT__REF = ECOMMON_ATTRS_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_ELEMENT__READ_ONLY = ECOMMON_ATTRS_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Relevant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_ELEMENT__RELEVANT = ECOMMON_ATTRS_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_ELEMENT__REQUIRED = ECOMMON_ATTRS_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Map Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_ELEMENT__MAP_KEY = ECOMMON_ATTRS_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Map Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_ELEMENT__MAP_VALUE = ECOMMON_ATTRS_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_ELEMENT__NAME = ECOMMON_ATTRS_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_ELEMENT__CONSTRAINT = ECOMMON_ATTRS_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Options</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_ELEMENT__OPTIONS = ECOMMON_ATTRS_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_ELEMENT__PROPERTIES = ECOMMON_ATTRS_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_ELEMENT__TYPE = ECOMMON_ATTRS_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Min Occurs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_ELEMENT__MIN_OCCURS = ECOMMON_ATTRS_FEATURE_COUNT + 16;

	/**
	 * The feature id for the '<em><b>Max Occurs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_ELEMENT__MAX_OCCURS = ECOMMON_ATTRS_FEATURE_COUNT + 17;

	/**
	 * The feature id for the '<em><b>Min Exclusive</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_ELEMENT__MIN_EXCLUSIVE = ECOMMON_ATTRS_FEATURE_COUNT + 18;

	/**
	 * The feature id for the '<em><b>Max Exclusive</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_ELEMENT__MAX_EXCLUSIVE = ECOMMON_ATTRS_FEATURE_COUNT + 19;

	/**
	 * The feature id for the '<em><b>Min Inclusive</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_ELEMENT__MIN_INCLUSIVE = ECOMMON_ATTRS_FEATURE_COUNT + 20;

	/**
	 * The feature id for the '<em><b>Max Inclusive</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_ELEMENT__MAX_INCLUSIVE = ECOMMON_ATTRS_FEATURE_COUNT + 21;

	/**
	 * The feature id for the '<em><b>Min Length</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_ELEMENT__MIN_LENGTH = ECOMMON_ATTRS_FEATURE_COUNT + 22;

	/**
	 * The feature id for the '<em><b>Max Length</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_ELEMENT__MAX_LENGTH = ECOMMON_ATTRS_FEATURE_COUNT + 23;

	/**
	 * The feature id for the '<em><b>Length</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_ELEMENT__LENGTH = ECOMMON_ATTRS_FEATURE_COUNT + 24;

	/**
	 * The feature id for the '<em><b>Total Digits</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_ELEMENT__TOTAL_DIGITS = ECOMMON_ATTRS_FEATURE_COUNT + 25;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_ELEMENT__PATTERN = ECOMMON_ATTRS_FEATURE_COUNT + 26;

	/**
	 * The feature id for the '<em><b>Local Path</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_ELEMENT__LOCAL_PATH = ECOMMON_ATTRS_FEATURE_COUNT + 27;

	/**
	 * The feature id for the '<em><b>Target Path</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_ELEMENT__TARGET_PATH = ECOMMON_ATTRS_FEATURE_COUNT + 28;

	/**
	 * The number of structural features of the '<em>ESetting Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_ELEMENT_FEATURE_COUNT = ECOMMON_ATTRS_FEATURE_COUNT + 29;

	/**
	 * The meta object id for the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingDataContainer <em>ESetting Data Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.ESettingDataContainer
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2PackageImpl#getESettingDataContainer()
	 * @generated
	 */
	int ESETTING_DATA_CONTAINER = 6;

	/**
	 * The feature id for the '<em><b>Settings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_DATA_CONTAINER__SETTINGS = 0;

	/**
	 * The number of structural features of the '<em>ESetting Data Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_DATA_CONTAINER_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.impl.ESettingDataImpl <em>ESetting Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.ESettingDataImpl
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2PackageImpl#getESettingData()
	 * @generated
	 */
	int ESETTING_DATA = 7;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_DATA__REF = EConfML1Package.EREF_NAMED_ELEMENT__REF;

	/**
	 * The feature id for the '<em><b>Settings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_DATA__SETTINGS = EConfML1Package.EREF_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_DATA__TEMPLATE = EConfML1Package.EREF_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Extension Policy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_DATA__EXTENSION_POLICY = EConfML1Package.EREF_NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_DATA__VALUE = EConfML1Package.EREF_NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_DATA__TEXT = EConfML1Package.EREF_NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Map</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_DATA__MAP = EConfML1Package.EREF_NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>ESetting Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_DATA_FEATURE_COUNT = EConfML1Package.EREF_NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.impl.EViewElementImpl <em>EView Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EViewElementImpl
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2PackageImpl#getEViewElement()
	 * @generated
	 */
	int EVIEW_ELEMENT = 8;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVIEW_ELEMENT__ID = ECOMMON_ATTRS__ID;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVIEW_ELEMENT__CONTENTS = ECOMMON_ATTRS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVIEW_ELEMENT__LINKS = ECOMMON_ATTRS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Descriptions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVIEW_ELEMENT__DESCRIPTIONS = ECOMMON_ATTRS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Icons</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVIEW_ELEMENT__ICONS = ECOMMON_ATTRS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Groups</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVIEW_ELEMENT__GROUPS = ECOMMON_ATTRS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Metas</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVIEW_ELEMENT__METAS = ECOMMON_ATTRS_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVIEW_ELEMENT__NAME = ECOMMON_ATTRS_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>EView Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVIEW_ELEMENT_FEATURE_COUNT = ECOMMON_ATTRS_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.impl.EGroupImpl <em>EGroup</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EGroupImpl
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2PackageImpl#getEGroup()
	 * @generated
	 */
	int EGROUP = 9;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EGROUP__ID = ECOMMON_ATTRS__ID;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EGROUP__CONTENTS = ECOMMON_ATTRS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EGROUP__LINKS = ECOMMON_ATTRS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Descriptions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EGROUP__DESCRIPTIONS = ECOMMON_ATTRS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Icons</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EGROUP__ICONS = ECOMMON_ATTRS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Groups</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EGROUP__GROUPS = ECOMMON_ATTRS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Settings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EGROUP__SETTINGS = ECOMMON_ATTRS_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EGROUP__NAME = ECOMMON_ATTRS_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>EGroup</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EGROUP_FEATURE_COUNT = ECOMMON_ATTRS_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ELinkContainer <em>ELink Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.ELinkContainer
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2PackageImpl#getELinkContainer()
	 * @generated
	 */
	int ELINK_CONTAINER = 21;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELINK_CONTAINER__CONTENTS = ECONTENTS__CONTENTS;

	/**
	 * The feature id for the '<em><b>Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELINK_CONTAINER__LINKS = ECONTENTS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>ELink Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELINK_CONTAINER_FEATURE_COUNT = ECONTENTS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EGroupContainer <em>EGroup Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EGroupContainer
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2PackageImpl#getEGroupContainer()
	 * @generated
	 */
	int EGROUP_CONTAINER = 10;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EGROUP_CONTAINER__CONTENTS = ELINK_CONTAINER__CONTENTS;

	/**
	 * The feature id for the '<em><b>Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EGROUP_CONTAINER__LINKS = ELINK_CONTAINER__LINKS;

	/**
	 * The feature id for the '<em><b>Descriptions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EGROUP_CONTAINER__DESCRIPTIONS = ELINK_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Icons</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EGROUP_CONTAINER__ICONS = ELINK_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Groups</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EGROUP_CONTAINER__GROUPS = ELINK_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>EGroup Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EGROUP_CONTAINER_FEATURE_COUNT = ELINK_CONTAINER_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.impl.EFeatureRfsImpl <em>EFeature Rfs</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EFeatureRfsImpl
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2PackageImpl#getEFeatureRfs()
	 * @generated
	 */
	int EFEATURE_RFS = 11;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFEATURE_RFS__REF = EConfML1Package.EREF_NAMED_ELEMENT__REF;

	/**
	 * The feature id for the '<em><b>Settings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFEATURE_RFS__SETTINGS = EConfML1Package.EREF_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>EFeature Rfs</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFEATURE_RFS_FEATURE_COUNT = EConfML1Package.EREF_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.impl.ESettingRfsImpl <em>ESetting Rfs</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.ESettingRfsImpl
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2PackageImpl#getESettingRfs()
	 * @generated
	 */
	int ESETTING_RFS = 12;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_RFS__REF = EConfML1Package.EREF_NAMED_ELEMENT__REF;

	/**
	 * The feature id for the '<em><b>Rfs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_RFS__RFS = EConfML1Package.EREF_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>ESetting Rfs</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_RFS_FEATURE_COUNT = EConfML1Package.EREF_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EMetaContainer <em>EMeta Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EMetaContainer
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2PackageImpl#getEMetaContainer()
	 * @generated
	 */
	int EMETA_CONTAINER = 13;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMETA_CONTAINER__CONTENTS = ECONTENTS__CONTENTS;

	/**
	 * The feature id for the '<em><b>Metas</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMETA_CONTAINER__METAS = ECONTENTS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>EMeta Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMETA_CONTAINER_FEATURE_COUNT = ECONTENTS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.impl.EMetaElementImpl <em>EMeta Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EMetaElementImpl
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2PackageImpl#getEMetaElement()
	 * @generated
	 */
	int EMETA_ELEMENT = 14;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMETA_ELEMENT__CONTENTS = ELINK_CONTAINER__CONTENTS;

	/**
	 * The feature id for the '<em><b>Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMETA_ELEMENT__LINKS = ELINK_CONTAINER__LINKS;

	/**
	 * The feature id for the '<em><b>Icons</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMETA_ELEMENT__ICONS = ELINK_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMETA_ELEMENT__ID = ELINK_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Date</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMETA_ELEMENT__DATE = ELINK_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMETA_ELEMENT__OWNER = ELINK_CONTAINER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Editor</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMETA_ELEMENT__EDITOR = ELINK_CONTAINER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Product</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMETA_ELEMENT__PRODUCT = ELINK_CONTAINER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Status</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMETA_ELEMENT__STATUS = ELINK_CONTAINER_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Platform</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMETA_ELEMENT__PLATFORM = ELINK_CONTAINER_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Version</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMETA_ELEMENT__VERSION = ELINK_CONTAINER_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Release</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMETA_ELEMENT__RELEASE = ELINK_CONTAINER_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Customer</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMETA_ELEMENT__CUSTOMER = ELINK_CONTAINER_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMETA_ELEMENT__ORIGIN = ELINK_CONTAINER_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMETA_ELEMENT__TARGET = ELINK_CONTAINER_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Configuration Property</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMETA_ELEMENT__CONFIGURATION_PROPERTY = ELINK_CONTAINER_FEATURE_COUNT + 13;

	/**
	 * The number of structural features of the '<em>EMeta Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMETA_ELEMENT_FEATURE_COUNT = ELINK_CONTAINER_FEATURE_COUNT + 14;

	/**
	 * The meta object id for the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.impl.EOptionElementImpl <em>EOption Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EOptionElementImpl
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2PackageImpl#getEOptionElement()
	 * @generated
	 */
	int EOPTION_ELEMENT = 15;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOPTION_ELEMENT__ID = ECOMMON_ATTRS__ID;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOPTION_ELEMENT__CONTENTS = ECOMMON_ATTRS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOPTION_ELEMENT__LINKS = ECOMMON_ATTRS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Descriptions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOPTION_ELEMENT__DESCRIPTIONS = ECOMMON_ATTRS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Icons</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOPTION_ELEMENT__ICONS = ECOMMON_ATTRS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOPTION_ELEMENT__NAME = ECOMMON_ATTRS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOPTION_ELEMENT__VALUE = ECOMMON_ATTRS_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Relevant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOPTION_ELEMENT__RELEVANT = ECOMMON_ATTRS_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Map</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOPTION_ELEMENT__MAP = ECOMMON_ATTRS_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>EOption Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOPTION_ELEMENT_FEATURE_COUNT = ECOMMON_ATTRS_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.impl.EPropertyElementImpl <em>EProperty Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EPropertyElementImpl
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2PackageImpl#getEPropertyElement()
	 * @generated
	 */
	int EPROPERTY_ELEMENT = 16;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPROPERTY_ELEMENT__ID = ECOMMON_ATTRS__ID;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPROPERTY_ELEMENT__CONTENTS = ECOMMON_ATTRS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPROPERTY_ELEMENT__LINKS = ECOMMON_ATTRS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Descriptions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPROPERTY_ELEMENT__DESCRIPTIONS = ECOMMON_ATTRS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Icons</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPROPERTY_ELEMENT__ICONS = ECOMMON_ATTRS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPROPERTY_ELEMENT__NAME = ECOMMON_ATTRS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPROPERTY_ELEMENT__VALUE = ECOMMON_ATTRS_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPROPERTY_ELEMENT__UNIT = ECOMMON_ATTRS_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>EProperty Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPROPERTY_ELEMENT_FEATURE_COUNT = ECOMMON_ATTRS_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EDescriptionContainer <em>EDescription Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EDescriptionContainer
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2PackageImpl#getEDescriptionContainer()
	 * @generated
	 */
	int EDESCRIPTION_CONTAINER = 17;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDESCRIPTION_CONTAINER__CONTENTS = ECONTENTS__CONTENTS;

	/**
	 * The feature id for the '<em><b>Descriptions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDESCRIPTION_CONTAINER__DESCRIPTIONS = ECONTENTS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>EDescription Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDESCRIPTION_CONTAINER_FEATURE_COUNT = ECONTENTS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.impl.EDescriptionElementImpl <em>EDescription Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EDescriptionElementImpl
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2PackageImpl#getEDescriptionElement()
	 * @generated
	 */
	int EDESCRIPTION_ELEMENT = 18;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDESCRIPTION_ELEMENT__ID = ECOMMON_ATTRS__ID;

	/**
	 * The feature id for the '<em><b>Href</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDESCRIPTION_ELEMENT__HREF = ECOMMON_ATTRS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDESCRIPTION_ELEMENT__TITLE = ECOMMON_ATTRS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDESCRIPTION_ELEMENT__DESCRIPTION = ECOMMON_ATTRS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>EDescription Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDESCRIPTION_ELEMENT_FEATURE_COUNT = ECOMMON_ATTRS_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EIconContainer <em>EIcon Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EIconContainer
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2PackageImpl#getEIconContainer()
	 * @generated
	 */
	int EICON_CONTAINER = 19;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EICON_CONTAINER__CONTENTS = ECONTENTS__CONTENTS;

	/**
	 * The feature id for the '<em><b>Icons</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EICON_CONTAINER__ICONS = ECONTENTS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>EIcon Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EICON_CONTAINER_FEATURE_COUNT = ECONTENTS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.impl.EIconElementImpl <em>EIcon Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EIconElementImpl
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2PackageImpl#getEIconElement()
	 * @generated
	 */
	int EICON_ELEMENT = 20;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EICON_ELEMENT__ID = ECOMMON_ATTRS__ID;

	/**
	 * The feature id for the '<em><b>Href</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EICON_ELEMENT__HREF = ECOMMON_ATTRS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EICON_ELEMENT__TITLE = ECOMMON_ATTRS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>EIcon Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EICON_ELEMENT_FEATURE_COUNT = ECOMMON_ATTRS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.impl.ELinkElementImpl <em>ELink Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.ELinkElementImpl
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2PackageImpl#getELinkElement()
	 * @generated
	 */
	int ELINK_ELEMENT = 22;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELINK_ELEMENT__ID = ECOMMON_ATTRS__ID;

	/**
	 * The feature id for the '<em><b>Href</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELINK_ELEMENT__HREF = ECOMMON_ATTRS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELINK_ELEMENT__TITLE = ECOMMON_ATTRS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>ELink Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELINK_ELEMENT_FEATURE_COUNT = ECOMMON_ATTRS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.impl.EDataElementImpl <em>EData Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EDataElementImpl
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2PackageImpl#getEDataElement()
	 * @generated
	 */
	int EDATA_ELEMENT = 23;

	/**
	 * The feature id for the '<em><b>Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDATA_ELEMENT__DATA = 0;

	/**
	 * The number of structural features of the '<em>EData Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDATA_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.impl.ERfsElementImpl <em>ERfs Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.ERfsElementImpl
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2PackageImpl#getERfsElement()
	 * @generated
	 */
	int ERFS_ELEMENT = 24;

	/**
	 * The feature id for the '<em><b>Rfs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERFS_ELEMENT__RFS = 0;

	/**
	 * The number of structural features of the '<em>ERfs Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERFS_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EXLinkReference <em>EX Link Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EXLinkReference
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2PackageImpl#getEXLinkReference()
	 * @generated
	 */
	int EX_LINK_REFERENCE = 25;

	/**
	 * The feature id for the '<em><b>Href</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EX_LINK_REFERENCE__HREF = 0;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EX_LINK_REFERENCE__TITLE = 1;

	/**
	 * The number of structural features of the '<em>EX Link Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EX_LINK_REFERENCE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.impl.EMetaContentImpl <em>EMeta Content</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EMetaContentImpl
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2PackageImpl#getEMetaContent()
	 * @generated
	 */
	int EMETA_CONTENT = 27;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMETA_CONTENT__ID = ECOMMON_ATTRS__ID;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMETA_CONTENT__VALUE = ECOMMON_ATTRS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>EMeta Content</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMETA_CONTENT_FEATURE_COUNT = ECOMMON_ATTRS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2DocumentImpl <em>Document</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2DocumentImpl
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2PackageImpl#getEConfML2Document()
	 * @generated
	 */
	int ECONF_ML2_DOCUMENT = 28;

	/**
	 * The feature id for the '<em><b>Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECONF_ML2_DOCUMENT__CONFIGURATION = 0;

	/**
	 * The number of structural features of the '<em>Document</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECONF_ML2_DOCUMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.impl.ELocalPathElementImpl <em>ELocal Path Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.ELocalPathElementImpl
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2PackageImpl#getELocalPathElement()
	 * @generated
	 */
	int ELOCAL_PATH_ELEMENT = 29;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELOCAL_PATH_ELEMENT__ID = ECOMMON_ATTRS__ID;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELOCAL_PATH_ELEMENT__CONTENTS = ECOMMON_ATTRS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Descriptions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELOCAL_PATH_ELEMENT__DESCRIPTIONS = ECOMMON_ATTRS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Icons</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELOCAL_PATH_ELEMENT__ICONS = ECOMMON_ATTRS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELOCAL_PATH_ELEMENT__LINKS = ECOMMON_ATTRS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELOCAL_PATH_ELEMENT__CONSTRAINT = ECOMMON_ATTRS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELOCAL_PATH_ELEMENT__READ_ONLY = ECOMMON_ATTRS_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELOCAL_PATH_ELEMENT__REQUIRED = ECOMMON_ATTRS_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Map</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELOCAL_PATH_ELEMENT__MAP = ECOMMON_ATTRS_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>ELocal Path Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELOCAL_PATH_ELEMENT_FEATURE_COUNT = ECOMMON_ATTRS_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.impl.ETargetPathElementImpl <em>ETarget Path Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.ETargetPathElementImpl
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2PackageImpl#getETargetPathElement()
	 * @generated
	 */
	int ETARGET_PATH_ELEMENT = 30;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETARGET_PATH_ELEMENT__ID = ECOMMON_ATTRS__ID;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETARGET_PATH_ELEMENT__CONTENTS = ECOMMON_ATTRS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Descriptions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETARGET_PATH_ELEMENT__DESCRIPTIONS = ECOMMON_ATTRS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Icons</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETARGET_PATH_ELEMENT__ICONS = ECOMMON_ATTRS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETARGET_PATH_ELEMENT__LINKS = ECOMMON_ATTRS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETARGET_PATH_ELEMENT__CONSTRAINT = ECOMMON_ATTRS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETARGET_PATH_ELEMENT__READ_ONLY = ECOMMON_ATTRS_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETARGET_PATH_ELEMENT__REQUIRED = ECOMMON_ATTRS_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Map</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETARGET_PATH_ELEMENT__MAP = ECOMMON_ATTRS_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>ETarget Path Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETARGET_PATH_ELEMENT_FEATURE_COUNT = ECOMMON_ATTRS_FEATURE_COUNT + 8;

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EConfigurationElement <em>EConfiguration Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EConfiguration Element</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfigurationElement
	 * @generated
	 */
	EClass getEConfigurationElement();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EConfigurationElement#getConfigurations <em>Configurations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Configurations</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfigurationElement#getConfigurations()
	 * @see #getEConfigurationElement()
	 * @generated
	 */
	EReference getEConfigurationElement_Configurations();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EConfigurationElement#getFeatures <em>Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Features</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfigurationElement#getFeatures()
	 * @see #getEConfigurationElement()
	 * @generated
	 */
	EReference getEConfigurationElement_Features();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EConfigurationElement#getViews <em>Views</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Views</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfigurationElement#getViews()
	 * @see #getEConfigurationElement()
	 * @generated
	 */
	EReference getEConfigurationElement_Views();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EConfigurationElement#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Data</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfigurationElement#getData()
	 * @see #getEConfigurationElement()
	 * @generated
	 */
	EReference getEConfigurationElement_Data();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EConfigurationElement#getRfs <em>Rfs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rfs</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfigurationElement#getRfs()
	 * @see #getEConfigurationElement()
	 * @generated
	 */
	EReference getEConfigurationElement_Rfs();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EConfigurationElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfigurationElement#getName()
	 * @see #getEConfigurationElement()
	 * @generated
	 */
	EAttribute getEConfigurationElement_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EConfigurationElement#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfigurationElement#getVersion()
	 * @see #getEConfigurationElement()
	 * @generated
	 */
	EAttribute getEConfigurationElement_Version();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EConfigurationElement#getIncludes <em>Includes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Includes</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfigurationElement#getIncludes()
	 * @see #getEConfigurationElement()
	 * @generated
	 */
	EReference getEConfigurationElement_Includes();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EContents <em>EContents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EContents</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EContents
	 * @generated
	 */
	EClass getEContents();

	/**
	 * Returns the meta object for the attribute list '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EContents#getContents <em>Contents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Contents</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EContents#getContents()
	 * @see #getEContents()
	 * @generated
	 */
	EAttribute getEContents_Contents();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EFeatureElement <em>EFeature Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EFeature Element</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EFeatureElement
	 * @generated
	 */
	EClass getEFeatureElement();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EFeatureElement#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ref</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EFeatureElement#getRef()
	 * @see #getEFeatureElement()
	 * @generated
	 */
	EAttribute getEFeatureElement_Ref();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EFeatureElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EFeatureElement#getName()
	 * @see #getEFeatureElement()
	 * @generated
	 */
	EAttribute getEFeatureElement_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EFeatureElement#getRelevant <em>Relevant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Relevant</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EFeatureElement#getRelevant()
	 * @see #getEFeatureElement()
	 * @generated
	 */
	EAttribute getEFeatureElement_Relevant();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EFeatureData <em>EFeature Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EFeature Data</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EFeatureData
	 * @generated
	 */
	EClass getEFeatureData();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingTypeContainer <em>ESetting Type Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ESetting Type Container</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.ESettingTypeContainer
	 * @generated
	 */
	EClass getESettingTypeContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingTypeContainer#getSettings <em>Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Settings</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.ESettingTypeContainer#getSettings()
	 * @see #getESettingTypeContainer()
	 * @generated
	 */
	EReference getESettingTypeContainer_Settings();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement <em>ESetting Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ESetting Element</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement
	 * @generated
	 */
	EClass getESettingElement();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ref</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getRef()
	 * @see #getESettingElement()
	 * @generated
	 */
	EAttribute getESettingElement_Ref();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getReadOnly <em>Read Only</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Read Only</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getReadOnly()
	 * @see #getESettingElement()
	 * @generated
	 */
	EAttribute getESettingElement_ReadOnly();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getRelevant <em>Relevant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Relevant</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getRelevant()
	 * @see #getESettingElement()
	 * @generated
	 */
	EAttribute getESettingElement_Relevant();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getRequired <em>Required</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Required</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getRequired()
	 * @see #getESettingElement()
	 * @generated
	 */
	EAttribute getESettingElement_Required();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getMapKey <em>Map Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Map Key</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getMapKey()
	 * @see #getESettingElement()
	 * @generated
	 */
	EAttribute getESettingElement_MapKey();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getMapValue <em>Map Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Map Value</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getMapValue()
	 * @see #getESettingElement()
	 * @generated
	 */
	EAttribute getESettingElement_MapValue();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getName()
	 * @see #getESettingElement()
	 * @generated
	 */
	EAttribute getESettingElement_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getConstraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Constraint</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getConstraint()
	 * @see #getESettingElement()
	 * @generated
	 */
	EAttribute getESettingElement_Constraint();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getOptions <em>Options</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Options</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getOptions()
	 * @see #getESettingElement()
	 * @generated
	 */
	EReference getESettingElement_Options();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getProperties()
	 * @see #getESettingElement()
	 * @generated
	 */
	EReference getESettingElement_Properties();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getType()
	 * @see #getESettingElement()
	 * @generated
	 */
	EAttribute getESettingElement_Type();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getMinOccurs <em>Min Occurs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Occurs</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getMinOccurs()
	 * @see #getESettingElement()
	 * @generated
	 */
	EAttribute getESettingElement_MinOccurs();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getMaxOccurs <em>Max Occurs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Occurs</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getMaxOccurs()
	 * @see #getESettingElement()
	 * @generated
	 */
	EAttribute getESettingElement_MaxOccurs();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getMinExclusive <em>Min Exclusive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Min Exclusive</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getMinExclusive()
	 * @see #getESettingElement()
	 * @generated
	 */
	EReference getESettingElement_MinExclusive();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getMaxExclusive <em>Max Exclusive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Max Exclusive</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getMaxExclusive()
	 * @see #getESettingElement()
	 * @generated
	 */
	EReference getESettingElement_MaxExclusive();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getMinInclusive <em>Min Inclusive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Min Inclusive</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getMinInclusive()
	 * @see #getESettingElement()
	 * @generated
	 */
	EReference getESettingElement_MinInclusive();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getMaxInclusive <em>Max Inclusive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Max Inclusive</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getMaxInclusive()
	 * @see #getESettingElement()
	 * @generated
	 */
	EReference getESettingElement_MaxInclusive();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getMinLength <em>Min Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Min Length</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getMinLength()
	 * @see #getESettingElement()
	 * @generated
	 */
	EReference getESettingElement_MinLength();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getMaxLength <em>Max Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Max Length</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getMaxLength()
	 * @see #getESettingElement()
	 * @generated
	 */
	EReference getESettingElement_MaxLength();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getLength <em>Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Length</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getLength()
	 * @see #getESettingElement()
	 * @generated
	 */
	EReference getESettingElement_Length();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getTotalDigits <em>Total Digits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Total Digits</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getTotalDigits()
	 * @see #getESettingElement()
	 * @generated
	 */
	EReference getESettingElement_TotalDigits();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getPattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Pattern</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getPattern()
	 * @see #getESettingElement()
	 * @generated
	 */
	EReference getESettingElement_Pattern();

	/**
	 * Returns the meta object for the containment reference '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getLocalPath <em>Local Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Local Path</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getLocalPath()
	 * @see #getESettingElement()
	 * @generated
	 */
	EReference getESettingElement_LocalPath();

	/**
	 * Returns the meta object for the containment reference '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getTargetPath <em>Target Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target Path</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getTargetPath()
	 * @see #getESettingElement()
	 * @generated
	 */
	EReference getESettingElement_TargetPath();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingDataContainer <em>ESetting Data Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ESetting Data Container</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.ESettingDataContainer
	 * @generated
	 */
	EClass getESettingDataContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingDataContainer#getSettings <em>Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Settings</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.ESettingDataContainer#getSettings()
	 * @see #getESettingDataContainer()
	 * @generated
	 */
	EReference getESettingDataContainer_Settings();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingData <em>ESetting Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ESetting Data</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.ESettingData
	 * @generated
	 */
	EClass getESettingData();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingData#getTemplate <em>Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Template</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.ESettingData#getTemplate()
	 * @see #getESettingData()
	 * @generated
	 */
	EAttribute getESettingData_Template();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingData#getExtensionPolicy <em>Extension Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Extension Policy</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.ESettingData#getExtensionPolicy()
	 * @see #getESettingData()
	 * @generated
	 */
	EAttribute getESettingData_ExtensionPolicy();

	/**
	 * Returns the meta object for the attribute list '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingData#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Value</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.ESettingData#getValue()
	 * @see #getESettingData()
	 * @generated
	 */
	EAttribute getESettingData_Value();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingData#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.ESettingData#getText()
	 * @see #getESettingData()
	 * @generated
	 */
	EAttribute getESettingData_Text();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingData#getMap <em>Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Map</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.ESettingData#getMap()
	 * @see #getESettingData()
	 * @generated
	 */
	EAttribute getESettingData_Map();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EViewElement <em>EView Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EView Element</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EViewElement
	 * @generated
	 */
	EClass getEViewElement();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EViewElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EViewElement#getName()
	 * @see #getEViewElement()
	 * @generated
	 */
	EAttribute getEViewElement_Name();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EGroup <em>EGroup</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EGroup</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EGroup
	 * @generated
	 */
	EClass getEGroup();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EGroup#getSettings <em>Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Settings</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EGroup#getSettings()
	 * @see #getEGroup()
	 * @generated
	 */
	EReference getEGroup_Settings();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EGroup#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EGroup#getName()
	 * @see #getEGroup()
	 * @generated
	 */
	EAttribute getEGroup_Name();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EGroupContainer <em>EGroup Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EGroup Container</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EGroupContainer
	 * @generated
	 */
	EClass getEGroupContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EGroupContainer#getGroups <em>Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Groups</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EGroupContainer#getGroups()
	 * @see #getEGroupContainer()
	 * @generated
	 */
	EReference getEGroupContainer_Groups();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EFeatureRfs <em>EFeature Rfs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EFeature Rfs</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EFeatureRfs
	 * @generated
	 */
	EClass getEFeatureRfs();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EFeatureRfs#getSettings <em>Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Settings</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EFeatureRfs#getSettings()
	 * @see #getEFeatureRfs()
	 * @generated
	 */
	EReference getEFeatureRfs_Settings();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingRfs <em>ESetting Rfs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ESetting Rfs</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.ESettingRfs
	 * @generated
	 */
	EClass getESettingRfs();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingRfs#getRfs <em>Rfs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rfs</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.ESettingRfs#getRfs()
	 * @see #getESettingRfs()
	 * @generated
	 */
	EAttribute getESettingRfs_Rfs();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EMetaContainer <em>EMeta Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EMeta Container</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EMetaContainer
	 * @generated
	 */
	EClass getEMetaContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EMetaContainer#getMetas <em>Metas</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Metas</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EMetaContainer#getMetas()
	 * @see #getEMetaContainer()
	 * @generated
	 */
	EReference getEMetaContainer_Metas();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EMetaElement <em>EMeta Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EMeta Element</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EMetaElement
	 * @generated
	 */
	EClass getEMetaElement();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EMetaElement#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Id</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EMetaElement#getId()
	 * @see #getEMetaElement()
	 * @generated
	 */
	EReference getEMetaElement_Id();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EMetaElement#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Date</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EMetaElement#getDate()
	 * @see #getEMetaElement()
	 * @generated
	 */
	EReference getEMetaElement_Date();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EMetaElement#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owner</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EMetaElement#getOwner()
	 * @see #getEMetaElement()
	 * @generated
	 */
	EReference getEMetaElement_Owner();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EMetaElement#getEditor <em>Editor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Editor</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EMetaElement#getEditor()
	 * @see #getEMetaElement()
	 * @generated
	 */
	EReference getEMetaElement_Editor();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EMetaElement#getProduct <em>Product</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Product</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EMetaElement#getProduct()
	 * @see #getEMetaElement()
	 * @generated
	 */
	EReference getEMetaElement_Product();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EMetaElement#getStatus <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Status</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EMetaElement#getStatus()
	 * @see #getEMetaElement()
	 * @generated
	 */
	EReference getEMetaElement_Status();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EMetaElement#getPlatform <em>Platform</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Platform</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EMetaElement#getPlatform()
	 * @see #getEMetaElement()
	 * @generated
	 */
	EReference getEMetaElement_Platform();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EMetaElement#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Version</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EMetaElement#getVersion()
	 * @see #getEMetaElement()
	 * @generated
	 */
	EReference getEMetaElement_Version();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EMetaElement#getRelease <em>Release</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Release</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EMetaElement#getRelease()
	 * @see #getEMetaElement()
	 * @generated
	 */
	EReference getEMetaElement_Release();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EMetaElement#getCustomer <em>Customer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Customer</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EMetaElement#getCustomer()
	 * @see #getEMetaElement()
	 * @generated
	 */
	EReference getEMetaElement_Customer();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EMetaElement#getOrigin <em>Origin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Origin</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EMetaElement#getOrigin()
	 * @see #getEMetaElement()
	 * @generated
	 */
	EReference getEMetaElement_Origin();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EMetaElement#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Target</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EMetaElement#getTarget()
	 * @see #getEMetaElement()
	 * @generated
	 */
	EReference getEMetaElement_Target();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EMetaElement#getConfigurationProperty <em>Configuration Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Configuration Property</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EMetaElement#getConfigurationProperty()
	 * @see #getEMetaElement()
	 * @generated
	 */
	EReference getEMetaElement_ConfigurationProperty();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EOptionElement <em>EOption Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EOption Element</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EOptionElement
	 * @generated
	 */
	EClass getEOptionElement();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EOptionElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EOptionElement#getName()
	 * @see #getEOptionElement()
	 * @generated
	 */
	EAttribute getEOptionElement_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EOptionElement#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EOptionElement#getValue()
	 * @see #getEOptionElement()
	 * @generated
	 */
	EAttribute getEOptionElement_Value();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EOptionElement#getRelevant <em>Relevant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Relevant</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EOptionElement#getRelevant()
	 * @see #getEOptionElement()
	 * @generated
	 */
	EAttribute getEOptionElement_Relevant();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EOptionElement#getMap <em>Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Map</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EOptionElement#getMap()
	 * @see #getEOptionElement()
	 * @generated
	 */
	EAttribute getEOptionElement_Map();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EPropertyElement <em>EProperty Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EProperty Element</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EPropertyElement
	 * @generated
	 */
	EClass getEPropertyElement();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EPropertyElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EPropertyElement#getName()
	 * @see #getEPropertyElement()
	 * @generated
	 */
	EAttribute getEPropertyElement_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EPropertyElement#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EPropertyElement#getValue()
	 * @see #getEPropertyElement()
	 * @generated
	 */
	EAttribute getEPropertyElement_Value();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EPropertyElement#getUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unit</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EPropertyElement#getUnit()
	 * @see #getEPropertyElement()
	 * @generated
	 */
	EAttribute getEPropertyElement_Unit();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EDescriptionContainer <em>EDescription Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EDescription Container</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EDescriptionContainer
	 * @generated
	 */
	EClass getEDescriptionContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EDescriptionContainer#getDescriptions <em>Descriptions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Descriptions</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EDescriptionContainer#getDescriptions()
	 * @see #getEDescriptionContainer()
	 * @generated
	 */
	EReference getEDescriptionContainer_Descriptions();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EDescriptionElement <em>EDescription Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EDescription Element</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EDescriptionElement
	 * @generated
	 */
	EClass getEDescriptionElement();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EDescriptionElement#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EDescriptionElement#getDescription()
	 * @see #getEDescriptionElement()
	 * @generated
	 */
	EAttribute getEDescriptionElement_Description();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EIconContainer <em>EIcon Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EIcon Container</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EIconContainer
	 * @generated
	 */
	EClass getEIconContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EIconContainer#getIcons <em>Icons</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Icons</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EIconContainer#getIcons()
	 * @see #getEIconContainer()
	 * @generated
	 */
	EReference getEIconContainer_Icons();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EIconElement <em>EIcon Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EIcon Element</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EIconElement
	 * @generated
	 */
	EClass getEIconElement();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ELinkContainer <em>ELink Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ELink Container</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.ELinkContainer
	 * @generated
	 */
	EClass getELinkContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ELinkContainer#getLinks <em>Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Links</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.ELinkContainer#getLinks()
	 * @see #getELinkContainer()
	 * @generated
	 */
	EReference getELinkContainer_Links();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ELinkElement <em>ELink Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ELink Element</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.ELinkElement
	 * @generated
	 */
	EClass getELinkElement();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EDataElement <em>EData Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EData Element</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EDataElement
	 * @generated
	 */
	EClass getEDataElement();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EDataElement#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Data</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EDataElement#getData()
	 * @see #getEDataElement()
	 * @generated
	 */
	EReference getEDataElement_Data();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ERfsElement <em>ERfs Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ERfs Element</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.ERfsElement
	 * @generated
	 */
	EClass getERfsElement();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ERfsElement#getRfs <em>Rfs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rfs</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.ERfsElement#getRfs()
	 * @see #getERfsElement()
	 * @generated
	 */
	EReference getERfsElement_Rfs();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EXLinkReference <em>EX Link Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EX Link Reference</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EXLinkReference
	 * @generated
	 */
	EClass getEXLinkReference();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EXLinkReference#getHref <em>Href</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Href</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EXLinkReference#getHref()
	 * @see #getEXLinkReference()
	 * @generated
	 */
	EAttribute getEXLinkReference_Href();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EXLinkReference#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EXLinkReference#getTitle()
	 * @see #getEXLinkReference()
	 * @generated
	 */
	EAttribute getEXLinkReference_Title();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ECommonAttrs <em>ECommon Attrs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ECommon Attrs</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.ECommonAttrs
	 * @generated
	 */
	EClass getECommonAttrs();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ECommonAttrs#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.ECommonAttrs#getId()
	 * @see #getECommonAttrs()
	 * @generated
	 */
	EAttribute getECommonAttrs_Id();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EMetaContent <em>EMeta Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EMeta Content</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EMetaContent
	 * @generated
	 */
	EClass getEMetaContent();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EMetaContent#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EMetaContent#getValue()
	 * @see #getEMetaContent()
	 * @generated
	 */
	EAttribute getEMetaContent_Value();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EConfML2Document <em>Document</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfML2Document
	 * @generated
	 */
	EClass getEConfML2Document();

	/**
	 * Returns the meta object for the containment reference '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EConfML2Document#getConfiguration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Configuration</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfML2Document#getConfiguration()
	 * @see #getEConfML2Document()
	 * @generated
	 */
	EReference getEConfML2Document_Configuration();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ELocalPathElement <em>ELocal Path Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ELocal Path Element</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.ELocalPathElement
	 * @generated
	 */
	EClass getELocalPathElement();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ELocalPathElement#getConstraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Constraint</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.ELocalPathElement#getConstraint()
	 * @see #getELocalPathElement()
	 * @generated
	 */
	EAttribute getELocalPathElement_Constraint();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ELocalPathElement#getReadOnly <em>Read Only</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Read Only</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.ELocalPathElement#getReadOnly()
	 * @see #getELocalPathElement()
	 * @generated
	 */
	EAttribute getELocalPathElement_ReadOnly();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ELocalPathElement#getRequired <em>Required</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Required</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.ELocalPathElement#getRequired()
	 * @see #getELocalPathElement()
	 * @generated
	 */
	EAttribute getELocalPathElement_Required();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ELocalPathElement#getMap <em>Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Map</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.ELocalPathElement#getMap()
	 * @see #getELocalPathElement()
	 * @generated
	 */
	EAttribute getELocalPathElement_Map();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ETargetPathElement <em>ETarget Path Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ETarget Path Element</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.ETargetPathElement
	 * @generated
	 */
	EClass getETargetPathElement();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ETargetPathElement#getConstraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Constraint</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.ETargetPathElement#getConstraint()
	 * @see #getETargetPathElement()
	 * @generated
	 */
	EAttribute getETargetPathElement_Constraint();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ETargetPathElement#getReadOnly <em>Read Only</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Read Only</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.ETargetPathElement#getReadOnly()
	 * @see #getETargetPathElement()
	 * @generated
	 */
	EAttribute getETargetPathElement_ReadOnly();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ETargetPathElement#getRequired <em>Required</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Required</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.ETargetPathElement#getRequired()
	 * @see #getETargetPathElement()
	 * @generated
	 */
	EAttribute getETargetPathElement_Required();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ETargetPathElement#getMap <em>Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Map</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.ETargetPathElement#getMap()
	 * @see #getETargetPathElement()
	 * @generated
	 */
	EAttribute getETargetPathElement_Map();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EConfML2Factory getEConfML2Factory();

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
		 * The meta object literal for the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfigurationElementImpl <em>EConfiguration Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfigurationElementImpl
		 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2PackageImpl#getEConfigurationElement()
		 * @generated
		 */
		EClass ECONFIGURATION_ELEMENT = eINSTANCE.getEConfigurationElement();

		/**
		 * The meta object literal for the '<em><b>Configurations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECONFIGURATION_ELEMENT__CONFIGURATIONS = eINSTANCE
				.getEConfigurationElement_Configurations();

		/**
		 * The meta object literal for the '<em><b>Features</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECONFIGURATION_ELEMENT__FEATURES = eINSTANCE
				.getEConfigurationElement_Features();

		/**
		 * The meta object literal for the '<em><b>Views</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECONFIGURATION_ELEMENT__VIEWS = eINSTANCE
				.getEConfigurationElement_Views();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECONFIGURATION_ELEMENT__DATA = eINSTANCE
				.getEConfigurationElement_Data();

		/**
		 * The meta object literal for the '<em><b>Rfs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECONFIGURATION_ELEMENT__RFS = eINSTANCE
				.getEConfigurationElement_Rfs();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECONFIGURATION_ELEMENT__NAME = eINSTANCE
				.getEConfigurationElement_Name();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECONFIGURATION_ELEMENT__VERSION = eINSTANCE
				.getEConfigurationElement_Version();

		/**
		 * The meta object literal for the '<em><b>Includes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECONFIGURATION_ELEMENT__INCLUDES = eINSTANCE
				.getEConfigurationElement_Includes();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EContents <em>EContents</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EContents
		 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2PackageImpl#getEContents()
		 * @generated
		 */
		EClass ECONTENTS = eINSTANCE.getEContents();

		/**
		 * The meta object literal for the '<em><b>Contents</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECONTENTS__CONTENTS = eINSTANCE.getEContents_Contents();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.impl.EFeatureElementImpl <em>EFeature Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EFeatureElementImpl
		 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2PackageImpl#getEFeatureElement()
		 * @generated
		 */
		EClass EFEATURE_ELEMENT = eINSTANCE.getEFeatureElement();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EFEATURE_ELEMENT__REF = eINSTANCE.getEFeatureElement_Ref();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EFEATURE_ELEMENT__NAME = eINSTANCE.getEFeatureElement_Name();

		/**
		 * The meta object literal for the '<em><b>Relevant</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EFEATURE_ELEMENT__RELEVANT = eINSTANCE
				.getEFeatureElement_Relevant();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.impl.EFeatureDataImpl <em>EFeature Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EFeatureDataImpl
		 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2PackageImpl#getEFeatureData()
		 * @generated
		 */
		EClass EFEATURE_DATA = eINSTANCE.getEFeatureData();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingTypeContainer <em>ESetting Type Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.carbide.ct.confml.model.confml2.ESettingTypeContainer
		 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2PackageImpl#getESettingTypeContainer()
		 * @generated
		 */
		EClass ESETTING_TYPE_CONTAINER = eINSTANCE.getESettingTypeContainer();

		/**
		 * The meta object literal for the '<em><b>Settings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ESETTING_TYPE_CONTAINER__SETTINGS = eINSTANCE
				.getESettingTypeContainer_Settings();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.impl.ESettingElementImpl <em>ESetting Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.ESettingElementImpl
		 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2PackageImpl#getESettingElement()
		 * @generated
		 */
		EClass ESETTING_ELEMENT = eINSTANCE.getESettingElement();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESETTING_ELEMENT__REF = eINSTANCE.getESettingElement_Ref();

		/**
		 * The meta object literal for the '<em><b>Read Only</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESETTING_ELEMENT__READ_ONLY = eINSTANCE
				.getESettingElement_ReadOnly();

		/**
		 * The meta object literal for the '<em><b>Relevant</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESETTING_ELEMENT__RELEVANT = eINSTANCE
				.getESettingElement_Relevant();

		/**
		 * The meta object literal for the '<em><b>Required</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESETTING_ELEMENT__REQUIRED = eINSTANCE
				.getESettingElement_Required();

		/**
		 * The meta object literal for the '<em><b>Map Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESETTING_ELEMENT__MAP_KEY = eINSTANCE
				.getESettingElement_MapKey();

		/**
		 * The meta object literal for the '<em><b>Map Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESETTING_ELEMENT__MAP_VALUE = eINSTANCE
				.getESettingElement_MapValue();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESETTING_ELEMENT__NAME = eINSTANCE.getESettingElement_Name();

		/**
		 * The meta object literal for the '<em><b>Constraint</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESETTING_ELEMENT__CONSTRAINT = eINSTANCE
				.getESettingElement_Constraint();

		/**
		 * The meta object literal for the '<em><b>Options</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ESETTING_ELEMENT__OPTIONS = eINSTANCE
				.getESettingElement_Options();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ESETTING_ELEMENT__PROPERTIES = eINSTANCE
				.getESettingElement_Properties();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESETTING_ELEMENT__TYPE = eINSTANCE.getESettingElement_Type();

		/**
		 * The meta object literal for the '<em><b>Min Occurs</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESETTING_ELEMENT__MIN_OCCURS = eINSTANCE
				.getESettingElement_MinOccurs();

		/**
		 * The meta object literal for the '<em><b>Max Occurs</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESETTING_ELEMENT__MAX_OCCURS = eINSTANCE
				.getESettingElement_MaxOccurs();

		/**
		 * The meta object literal for the '<em><b>Min Exclusive</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ESETTING_ELEMENT__MIN_EXCLUSIVE = eINSTANCE
				.getESettingElement_MinExclusive();

		/**
		 * The meta object literal for the '<em><b>Max Exclusive</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ESETTING_ELEMENT__MAX_EXCLUSIVE = eINSTANCE
				.getESettingElement_MaxExclusive();

		/**
		 * The meta object literal for the '<em><b>Min Inclusive</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ESETTING_ELEMENT__MIN_INCLUSIVE = eINSTANCE
				.getESettingElement_MinInclusive();

		/**
		 * The meta object literal for the '<em><b>Max Inclusive</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ESETTING_ELEMENT__MAX_INCLUSIVE = eINSTANCE
				.getESettingElement_MaxInclusive();

		/**
		 * The meta object literal for the '<em><b>Min Length</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ESETTING_ELEMENT__MIN_LENGTH = eINSTANCE
				.getESettingElement_MinLength();

		/**
		 * The meta object literal for the '<em><b>Max Length</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ESETTING_ELEMENT__MAX_LENGTH = eINSTANCE
				.getESettingElement_MaxLength();

		/**
		 * The meta object literal for the '<em><b>Length</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ESETTING_ELEMENT__LENGTH = eINSTANCE
				.getESettingElement_Length();

		/**
		 * The meta object literal for the '<em><b>Total Digits</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ESETTING_ELEMENT__TOTAL_DIGITS = eINSTANCE
				.getESettingElement_TotalDigits();

		/**
		 * The meta object literal for the '<em><b>Pattern</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ESETTING_ELEMENT__PATTERN = eINSTANCE
				.getESettingElement_Pattern();

		/**
		 * The meta object literal for the '<em><b>Local Path</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ESETTING_ELEMENT__LOCAL_PATH = eINSTANCE
				.getESettingElement_LocalPath();

		/**
		 * The meta object literal for the '<em><b>Target Path</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ESETTING_ELEMENT__TARGET_PATH = eINSTANCE
				.getESettingElement_TargetPath();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingDataContainer <em>ESetting Data Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.carbide.ct.confml.model.confml2.ESettingDataContainer
		 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2PackageImpl#getESettingDataContainer()
		 * @generated
		 */
		EClass ESETTING_DATA_CONTAINER = eINSTANCE.getESettingDataContainer();

		/**
		 * The meta object literal for the '<em><b>Settings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ESETTING_DATA_CONTAINER__SETTINGS = eINSTANCE
				.getESettingDataContainer_Settings();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.impl.ESettingDataImpl <em>ESetting Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.ESettingDataImpl
		 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2PackageImpl#getESettingData()
		 * @generated
		 */
		EClass ESETTING_DATA = eINSTANCE.getESettingData();

		/**
		 * The meta object literal for the '<em><b>Template</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESETTING_DATA__TEMPLATE = eINSTANCE
				.getESettingData_Template();

		/**
		 * The meta object literal for the '<em><b>Extension Policy</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESETTING_DATA__EXTENSION_POLICY = eINSTANCE
				.getESettingData_ExtensionPolicy();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESETTING_DATA__VALUE = eINSTANCE.getESettingData_Value();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESETTING_DATA__TEXT = eINSTANCE.getESettingData_Text();

		/**
		 * The meta object literal for the '<em><b>Map</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESETTING_DATA__MAP = eINSTANCE.getESettingData_Map();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.impl.EViewElementImpl <em>EView Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EViewElementImpl
		 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2PackageImpl#getEViewElement()
		 * @generated
		 */
		EClass EVIEW_ELEMENT = eINSTANCE.getEViewElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVIEW_ELEMENT__NAME = eINSTANCE.getEViewElement_Name();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.impl.EGroupImpl <em>EGroup</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EGroupImpl
		 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2PackageImpl#getEGroup()
		 * @generated
		 */
		EClass EGROUP = eINSTANCE.getEGroup();

		/**
		 * The meta object literal for the '<em><b>Settings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EGROUP__SETTINGS = eINSTANCE.getEGroup_Settings();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EGROUP__NAME = eINSTANCE.getEGroup_Name();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EGroupContainer <em>EGroup Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EGroupContainer
		 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2PackageImpl#getEGroupContainer()
		 * @generated
		 */
		EClass EGROUP_CONTAINER = eINSTANCE.getEGroupContainer();

		/**
		 * The meta object literal for the '<em><b>Groups</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EGROUP_CONTAINER__GROUPS = eINSTANCE
				.getEGroupContainer_Groups();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.impl.EFeatureRfsImpl <em>EFeature Rfs</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EFeatureRfsImpl
		 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2PackageImpl#getEFeatureRfs()
		 * @generated
		 */
		EClass EFEATURE_RFS = eINSTANCE.getEFeatureRfs();

		/**
		 * The meta object literal for the '<em><b>Settings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EFEATURE_RFS__SETTINGS = eINSTANCE.getEFeatureRfs_Settings();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.impl.ESettingRfsImpl <em>ESetting Rfs</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.ESettingRfsImpl
		 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2PackageImpl#getESettingRfs()
		 * @generated
		 */
		EClass ESETTING_RFS = eINSTANCE.getESettingRfs();

		/**
		 * The meta object literal for the '<em><b>Rfs</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESETTING_RFS__RFS = eINSTANCE.getESettingRfs_Rfs();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EMetaContainer <em>EMeta Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EMetaContainer
		 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2PackageImpl#getEMetaContainer()
		 * @generated
		 */
		EClass EMETA_CONTAINER = eINSTANCE.getEMetaContainer();

		/**
		 * The meta object literal for the '<em><b>Metas</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMETA_CONTAINER__METAS = eINSTANCE.getEMetaContainer_Metas();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.impl.EMetaElementImpl <em>EMeta Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EMetaElementImpl
		 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2PackageImpl#getEMetaElement()
		 * @generated
		 */
		EClass EMETA_ELEMENT = eINSTANCE.getEMetaElement();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMETA_ELEMENT__ID = eINSTANCE.getEMetaElement_Id();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMETA_ELEMENT__DATE = eINSTANCE.getEMetaElement_Date();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMETA_ELEMENT__OWNER = eINSTANCE.getEMetaElement_Owner();

		/**
		 * The meta object literal for the '<em><b>Editor</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMETA_ELEMENT__EDITOR = eINSTANCE.getEMetaElement_Editor();

		/**
		 * The meta object literal for the '<em><b>Product</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMETA_ELEMENT__PRODUCT = eINSTANCE.getEMetaElement_Product();

		/**
		 * The meta object literal for the '<em><b>Status</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMETA_ELEMENT__STATUS = eINSTANCE.getEMetaElement_Status();

		/**
		 * The meta object literal for the '<em><b>Platform</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMETA_ELEMENT__PLATFORM = eINSTANCE
				.getEMetaElement_Platform();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMETA_ELEMENT__VERSION = eINSTANCE.getEMetaElement_Version();

		/**
		 * The meta object literal for the '<em><b>Release</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMETA_ELEMENT__RELEASE = eINSTANCE.getEMetaElement_Release();

		/**
		 * The meta object literal for the '<em><b>Customer</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMETA_ELEMENT__CUSTOMER = eINSTANCE
				.getEMetaElement_Customer();

		/**
		 * The meta object literal for the '<em><b>Origin</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMETA_ELEMENT__ORIGIN = eINSTANCE.getEMetaElement_Origin();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMETA_ELEMENT__TARGET = eINSTANCE.getEMetaElement_Target();

		/**
		 * The meta object literal for the '<em><b>Configuration Property</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMETA_ELEMENT__CONFIGURATION_PROPERTY = eINSTANCE
				.getEMetaElement_ConfigurationProperty();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.impl.EOptionElementImpl <em>EOption Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EOptionElementImpl
		 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2PackageImpl#getEOptionElement()
		 * @generated
		 */
		EClass EOPTION_ELEMENT = eINSTANCE.getEOptionElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EOPTION_ELEMENT__NAME = eINSTANCE.getEOptionElement_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EOPTION_ELEMENT__VALUE = eINSTANCE.getEOptionElement_Value();

		/**
		 * The meta object literal for the '<em><b>Relevant</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EOPTION_ELEMENT__RELEVANT = eINSTANCE
				.getEOptionElement_Relevant();

		/**
		 * The meta object literal for the '<em><b>Map</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EOPTION_ELEMENT__MAP = eINSTANCE.getEOptionElement_Map();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.impl.EPropertyElementImpl <em>EProperty Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EPropertyElementImpl
		 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2PackageImpl#getEPropertyElement()
		 * @generated
		 */
		EClass EPROPERTY_ELEMENT = eINSTANCE.getEPropertyElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPROPERTY_ELEMENT__NAME = eINSTANCE
				.getEPropertyElement_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPROPERTY_ELEMENT__VALUE = eINSTANCE
				.getEPropertyElement_Value();

		/**
		 * The meta object literal for the '<em><b>Unit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPROPERTY_ELEMENT__UNIT = eINSTANCE
				.getEPropertyElement_Unit();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EDescriptionContainer <em>EDescription Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EDescriptionContainer
		 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2PackageImpl#getEDescriptionContainer()
		 * @generated
		 */
		EClass EDESCRIPTION_CONTAINER = eINSTANCE.getEDescriptionContainer();

		/**
		 * The meta object literal for the '<em><b>Descriptions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDESCRIPTION_CONTAINER__DESCRIPTIONS = eINSTANCE
				.getEDescriptionContainer_Descriptions();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.impl.EDescriptionElementImpl <em>EDescription Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EDescriptionElementImpl
		 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2PackageImpl#getEDescriptionElement()
		 * @generated
		 */
		EClass EDESCRIPTION_ELEMENT = eINSTANCE.getEDescriptionElement();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDESCRIPTION_ELEMENT__DESCRIPTION = eINSTANCE
				.getEDescriptionElement_Description();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EIconContainer <em>EIcon Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EIconContainer
		 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2PackageImpl#getEIconContainer()
		 * @generated
		 */
		EClass EICON_CONTAINER = eINSTANCE.getEIconContainer();

		/**
		 * The meta object literal for the '<em><b>Icons</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EICON_CONTAINER__ICONS = eINSTANCE.getEIconContainer_Icons();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.impl.EIconElementImpl <em>EIcon Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EIconElementImpl
		 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2PackageImpl#getEIconElement()
		 * @generated
		 */
		EClass EICON_ELEMENT = eINSTANCE.getEIconElement();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ELinkContainer <em>ELink Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.carbide.ct.confml.model.confml2.ELinkContainer
		 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2PackageImpl#getELinkContainer()
		 * @generated
		 */
		EClass ELINK_CONTAINER = eINSTANCE.getELinkContainer();

		/**
		 * The meta object literal for the '<em><b>Links</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELINK_CONTAINER__LINKS = eINSTANCE.getELinkContainer_Links();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.impl.ELinkElementImpl <em>ELink Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.ELinkElementImpl
		 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2PackageImpl#getELinkElement()
		 * @generated
		 */
		EClass ELINK_ELEMENT = eINSTANCE.getELinkElement();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.impl.EDataElementImpl <em>EData Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EDataElementImpl
		 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2PackageImpl#getEDataElement()
		 * @generated
		 */
		EClass EDATA_ELEMENT = eINSTANCE.getEDataElement();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDATA_ELEMENT__DATA = eINSTANCE.getEDataElement_Data();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.impl.ERfsElementImpl <em>ERfs Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.ERfsElementImpl
		 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2PackageImpl#getERfsElement()
		 * @generated
		 */
		EClass ERFS_ELEMENT = eINSTANCE.getERfsElement();

		/**
		 * The meta object literal for the '<em><b>Rfs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERFS_ELEMENT__RFS = eINSTANCE.getERfsElement_Rfs();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EXLinkReference <em>EX Link Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EXLinkReference
		 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2PackageImpl#getEXLinkReference()
		 * @generated
		 */
		EClass EX_LINK_REFERENCE = eINSTANCE.getEXLinkReference();

		/**
		 * The meta object literal for the '<em><b>Href</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EX_LINK_REFERENCE__HREF = eINSTANCE
				.getEXLinkReference_Href();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EX_LINK_REFERENCE__TITLE = eINSTANCE
				.getEXLinkReference_Title();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.impl.ECommonAttrsImpl <em>ECommon Attrs</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.ECommonAttrsImpl
		 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2PackageImpl#getECommonAttrs()
		 * @generated
		 */
		EClass ECOMMON_ATTRS = eINSTANCE.getECommonAttrs();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECOMMON_ATTRS__ID = eINSTANCE.getECommonAttrs_Id();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.impl.EMetaContentImpl <em>EMeta Content</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EMetaContentImpl
		 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2PackageImpl#getEMetaContent()
		 * @generated
		 */
		EClass EMETA_CONTENT = eINSTANCE.getEMetaContent();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EMETA_CONTENT__VALUE = eINSTANCE.getEMetaContent_Value();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2DocumentImpl <em>Document</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2DocumentImpl
		 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2PackageImpl#getEConfML2Document()
		 * @generated
		 */
		EClass ECONF_ML2_DOCUMENT = eINSTANCE.getEConfML2Document();

		/**
		 * The meta object literal for the '<em><b>Configuration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECONF_ML2_DOCUMENT__CONFIGURATION = eINSTANCE
				.getEConfML2Document_Configuration();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.impl.ELocalPathElementImpl <em>ELocal Path Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.ELocalPathElementImpl
		 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2PackageImpl#getELocalPathElement()
		 * @generated
		 */
		EClass ELOCAL_PATH_ELEMENT = eINSTANCE.getELocalPathElement();

		/**
		 * The meta object literal for the '<em><b>Constraint</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELOCAL_PATH_ELEMENT__CONSTRAINT = eINSTANCE
				.getELocalPathElement_Constraint();

		/**
		 * The meta object literal for the '<em><b>Read Only</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELOCAL_PATH_ELEMENT__READ_ONLY = eINSTANCE
				.getELocalPathElement_ReadOnly();

		/**
		 * The meta object literal for the '<em><b>Required</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELOCAL_PATH_ELEMENT__REQUIRED = eINSTANCE
				.getELocalPathElement_Required();

		/**
		 * The meta object literal for the '<em><b>Map</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELOCAL_PATH_ELEMENT__MAP = eINSTANCE
				.getELocalPathElement_Map();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.impl.ETargetPathElementImpl <em>ETarget Path Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.ETargetPathElementImpl
		 * @see com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2PackageImpl#getETargetPathElement()
		 * @generated
		 */
		EClass ETARGET_PATH_ELEMENT = eINSTANCE.getETargetPathElement();

		/**
		 * The meta object literal for the '<em><b>Constraint</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ETARGET_PATH_ELEMENT__CONSTRAINT = eINSTANCE
				.getETargetPathElement_Constraint();

		/**
		 * The meta object literal for the '<em><b>Read Only</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ETARGET_PATH_ELEMENT__READ_ONLY = eINSTANCE
				.getETargetPathElement_ReadOnly();

		/**
		 * The meta object literal for the '<em><b>Required</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ETARGET_PATH_ELEMENT__REQUIRED = eINSTANCE
				.getETargetPathElement_Required();

		/**
		 * The meta object literal for the '<em><b>Map</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ETARGET_PATH_ELEMENT__MAP = eINSTANCE
				.getETargetPathElement_Map();

	}

} //EConfML2Package
