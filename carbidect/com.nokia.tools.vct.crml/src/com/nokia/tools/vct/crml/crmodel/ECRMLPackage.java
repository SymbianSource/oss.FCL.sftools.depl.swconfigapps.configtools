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
 * Description: This file is part of com.nokia.tools.vct.crml component.
 */

package com.nokia.tools.vct.crml.crmodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see com.nokia.tools.vct.crml.crmodel.ECRMLFactory
 * @model kind="package"
 * @generated
 */
public interface ECRMLPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "crmodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.s60.com/xml/cenrep/1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "crml";

	/**
	 * The package content type ID.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eCONTENT_TYPE = "com.nokia.tools.vct.content.crml";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ECRMLPackage eINSTANCE = com.nokia.tools.vct.crml.crmodel.impl.ECRMLPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.crml.crmodel.impl.CommonAttrsImpl <em>Common Attrs</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.crml.crmodel.impl.CommonAttrsImpl
	 * @see com.nokia.tools.vct.crml.crmodel.impl.ECRMLPackageImpl#getCommonAttrs()
	 * @generated
	 */
	int COMMON_ATTRS = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMON_ATTRS__ID = 0;

	/**
	 * The number of structural features of the '<em>Common Attrs</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMON_ATTRS_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.crml.crmodel.impl.EMetaImpl <em>EMeta</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.crml.crmodel.impl.EMetaImpl
	 * @see com.nokia.tools.vct.crml.crmodel.impl.ECRMLPackageImpl#getEMeta()
	 * @generated
	 */
	int EMETA = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMETA__ID = COMMON_ATTRS__ID;

	/**
	 * The feature id for the '<em><b>Identification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMETA__IDENTIFICATION = COMMON_ATTRS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMETA__DATE = COMMON_ATTRS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Platform</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMETA__PLATFORM = COMMON_ATTRS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMETA__OWNER = COMMON_ATTRS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Editor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMETA__EDITOR = COMMON_ATTRS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMETA__STATUS = COMMON_ATTRS_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMETA__VERSION = COMMON_ATTRS_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Product</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMETA__PRODUCT = COMMON_ATTRS_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Release</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMETA__RELEASE = COMMON_ATTRS_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>EMeta</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMETA_FEATURE_COUNT = COMMON_ATTRS_FEATURE_COUNT + 9;

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.crml.crmodel.impl.EContentImpl <em>EContent</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.crml.crmodel.impl.EContentImpl
	 * @see com.nokia.tools.vct.crml.crmodel.impl.ECRMLPackageImpl#getEContent()
	 * @generated
	 */
	int ECONTENT = 2;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECONTENT__VALUE = 0;

	/**
	 * The number of structural features of the '<em>EContent</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECONTENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.crml.crmodel.impl.EAttributeAndDescriptionImpl <em>EAttribute And Description</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.crml.crmodel.impl.EAttributeAndDescriptionImpl
	 * @see com.nokia.tools.vct.crml.crmodel.impl.ECRMLPackageImpl#getEAttributeAndDescription()
	 * @generated
	 */
	int EATTRIBUTE_AND_DESCRIPTION = 10;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EATTRIBUTE_AND_DESCRIPTION__ID = COMMON_ATTRS__ID;

	/**
	 * The feature id for the '<em><b>Desc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EATTRIBUTE_AND_DESCRIPTION__DESC = COMMON_ATTRS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>EAttribute And Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT = COMMON_ATTRS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.crml.crmodel.impl.ERepositoryImpl <em>ERepository</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.crml.crmodel.impl.ERepositoryImpl
	 * @see com.nokia.tools.vct.crml.crmodel.impl.ECRMLPackageImpl#getERepository()
	 * @generated
	 */
	int EREPOSITORY = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREPOSITORY__ID = EATTRIBUTE_AND_DESCRIPTION__ID;

	/**
	 * The feature id for the '<em><b>Desc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREPOSITORY__DESC = EATTRIBUTE_AND_DESCRIPTION__DESC;

	/**
	 * The feature id for the '<em><b>Access</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREPOSITORY__ACCESS = EATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Backup</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREPOSITORY__BACKUP = EATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREPOSITORY__VERSION = EATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Uid Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREPOSITORY__UID_NAME = EATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Uid Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREPOSITORY__UID_VALUE = EATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Initialisation File Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREPOSITORY__INITIALISATION_FILE_VERSION = EATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREPOSITORY__OWNER = EATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Rfs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREPOSITORY__RFS = EATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Key</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREPOSITORY__KEY = EATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Meta</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREPOSITORY__META = EATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Range Key</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREPOSITORY__RANGE_KEY = EATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 10;

	/**
	 * The number of structural features of the '<em>ERepository</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREPOSITORY_FEATURE_COUNT = EATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 11;

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.crml.crmodel.impl.EKeyImpl <em>EKey</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.crml.crmodel.impl.EKeyImpl
	 * @see com.nokia.tools.vct.crml.crmodel.impl.ECRMLPackageImpl#getEKey()
	 * @generated
	 */
	int EKEY = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EKEY__ID = EATTRIBUTE_AND_DESCRIPTION__ID;

	/**
	 * The feature id for the '<em><b>Desc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EKEY__DESC = EATTRIBUTE_AND_DESCRIPTION__DESC;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EKEY__REF = EATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EKEY__READ_ONLY = EATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Access</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EKEY__ACCESS = EATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Backup</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EKEY__BACKUP = EATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EKEY__NAME = EATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Ident</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EKEY__IDENT = EATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EKEY__TYPE = EATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EKEY__VALUE = EATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Bits</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EKEY__BITS = EATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>EKey</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EKEY_FEATURE_COUNT = EATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 9;

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.crml.crmodel.impl.EKeyRangeImpl <em>EKey Range</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.crml.crmodel.impl.EKeyRangeImpl
	 * @see com.nokia.tools.vct.crml.crmodel.impl.ECRMLPackageImpl#getEKeyRange()
	 * @generated
	 */
	int EKEY_RANGE = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EKEY_RANGE__ID = EATTRIBUTE_AND_DESCRIPTION__ID;

	/**
	 * The feature id for the '<em><b>Desc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EKEY_RANGE__DESC = EATTRIBUTE_AND_DESCRIPTION__DESC;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EKEY_RANGE__REF = EATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EKEY_RANGE__READ_ONLY = EATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Access</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EKEY_RANGE__ACCESS = EATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Backup</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EKEY_RANGE__BACKUP = EATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EKEY_RANGE__NAME = EATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Int</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EKEY_RANGE__INT = EATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>First Int</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EKEY_RANGE__FIRST_INT = EATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Last Int</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EKEY_RANGE__LAST_INT = EATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Index Bits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EKEY_RANGE__INDEX_BITS = EATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>First Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EKEY_RANGE__FIRST_INDEX = EATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Count Int</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EKEY_RANGE__COUNT_INT = EATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Keys</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EKEY_RANGE__KEYS = EATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 11;

	/**
	 * The number of structural features of the '<em>EKey Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EKEY_RANGE_FEATURE_COUNT = EATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 12;

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.crml.crmodel.impl.EAccessImpl <em>EAccess</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.crml.crmodel.impl.EAccessImpl
	 * @see com.nokia.tools.vct.crml.crmodel.impl.ECRMLPackageImpl#getEAccess()
	 * @generated
	 */
	int EACCESS = 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EACCESS__ID = EATTRIBUTE_AND_DESCRIPTION__ID;

	/**
	 * The feature id for the '<em><b>Desc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EACCESS__DESC = EATTRIBUTE_AND_DESCRIPTION__DESC;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EACCESS__TYPE = EATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EACCESS__CAPABILITIES = EATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Sid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EACCESS__SID = EATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>EAccess</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EACCESS_FEATURE_COUNT = EATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.crml.crmodel.impl.EValueImpl <em>EValue</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.crml.crmodel.impl.EValueImpl
	 * @see com.nokia.tools.vct.crml.crmodel.impl.ECRMLPackageImpl#getEValue()
	 * @generated
	 */
	int EVALUE = 7;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUE__VALUE = ECONTENT__VALUE;

	/**
	 * The feature id for the '<em><b>Val</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUE__VAL = ECONTENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUE__ID = ECONTENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>EValue</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUE_FEATURE_COUNT = ECONTENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.crml.crmodel.impl.EBitImpl <em>EBit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.crml.crmodel.impl.EBitImpl
	 * @see com.nokia.tools.vct.crml.crmodel.impl.ECRMLPackageImpl#getEBit()
	 * @generated
	 */
	int EBIT = 8;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EBIT__VALUE = ECONTENT__VALUE;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EBIT__REF = ECONTENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EBIT__STATE = ECONTENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>EBit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EBIT_FEATURE_COUNT = ECONTENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.crml.crmodel.ERefContainer <em>ERef Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.crml.crmodel.ERefContainer
	 * @see com.nokia.tools.vct.crml.crmodel.impl.ECRMLPackageImpl#getERefContainer()
	 * @generated
	 */
	int EREF_CONTAINER = 9;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREF_CONTAINER__REF = 0;

	/**
	 * The number of structural features of the '<em>ERef Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREF_CONTAINER_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.crml.crmodel.EReadOnly <em>ERead Only</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.crml.crmodel.EReadOnly
	 * @see com.nokia.tools.vct.crml.crmodel.impl.ECRMLPackageImpl#getEReadOnly()
	 * @generated
	 */
	int EREAD_ONLY = 11;

	/**
	 * The feature id for the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREAD_ONLY__READ_ONLY = 0;

	/**
	 * The number of structural features of the '<em>ERead Only</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREAD_ONLY_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.crml.crmodel.EAccessContainer <em>EAccess Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.crml.crmodel.EAccessContainer
	 * @see com.nokia.tools.vct.crml.crmodel.impl.ECRMLPackageImpl#getEAccessContainer()
	 * @generated
	 */
	int EACCESS_CONTAINER = 12;

	/**
	 * The feature id for the '<em><b>Access</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EACCESS_CONTAINER__ACCESS = 0;

	/**
	 * The number of structural features of the '<em>EAccess Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EACCESS_CONTAINER_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.crml.crmodel.EBackup <em>EBackup</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.crml.crmodel.EBackup
	 * @see com.nokia.tools.vct.crml.crmodel.impl.ECRMLPackageImpl#getEBackup()
	 * @generated
	 */
	int EBACKUP = 13;

	/**
	 * The feature id for the '<em><b>Backup</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EBACKUP__BACKUP = 0;

	/**
	 * The number of structural features of the '<em>EBackup</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EBACKUP_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.crml.crmodel.impl.ECRMLDocumentRootImpl <em>Document Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.crml.crmodel.impl.ECRMLDocumentRootImpl
	 * @see com.nokia.tools.vct.crml.crmodel.impl.ECRMLPackageImpl#getECRMLDocumentRoot()
	 * @generated
	 */
	int ECRML_DOCUMENT_ROOT = 14;

	/**
	 * The feature id for the '<em><b>Repository</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECRML_DOCUMENT_ROOT__REPOSITORY = 0;

	/**
	 * The number of structural features of the '<em>Document Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECRML_DOCUMENT_ROOT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.crml.crmodel.EKeyType <em>EKey Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.crml.crmodel.EKeyType
	 * @see com.nokia.tools.vct.crml.crmodel.impl.ECRMLPackageImpl#getEKeyType()
	 * @generated
	 */
	int EKEY_TYPE = 15;

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.crml.crmodel.EAccessType <em>EAccess Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.crml.crmodel.EAccessType
	 * @see com.nokia.tools.vct.crml.crmodel.impl.ECRMLPackageImpl#getEAccessType()
	 * @generated
	 */
	int EACCESS_TYPE = 16;


	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.crml.crmodel.CommonAttrs <em>Common Attrs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Common Attrs</em>'.
	 * @see com.nokia.tools.vct.crml.crmodel.CommonAttrs
	 * @generated
	 */
	EClass getCommonAttrs();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.crml.crmodel.CommonAttrs#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.nokia.tools.vct.crml.crmodel.CommonAttrs#getId()
	 * @see #getCommonAttrs()
	 * @generated
	 */
	EAttribute getCommonAttrs_Id();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.crml.crmodel.EMeta <em>EMeta</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EMeta</em>'.
	 * @see com.nokia.tools.vct.crml.crmodel.EMeta
	 * @generated
	 */
	EClass getEMeta();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.crml.crmodel.EMeta#getIdentification <em>Identification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Identification</em>'.
	 * @see com.nokia.tools.vct.crml.crmodel.EMeta#getIdentification()
	 * @see #getEMeta()
	 * @generated
	 */
	EAttribute getEMeta_Identification();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.crml.crmodel.EMeta#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see com.nokia.tools.vct.crml.crmodel.EMeta#getDate()
	 * @see #getEMeta()
	 * @generated
	 */
	EAttribute getEMeta_Date();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.crml.crmodel.EMeta#getPlatform <em>Platform</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Platform</em>'.
	 * @see com.nokia.tools.vct.crml.crmodel.EMeta#getPlatform()
	 * @see #getEMeta()
	 * @generated
	 */
	EAttribute getEMeta_Platform();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.crml.crmodel.EMeta#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Owner</em>'.
	 * @see com.nokia.tools.vct.crml.crmodel.EMeta#getOwner()
	 * @see #getEMeta()
	 * @generated
	 */
	EAttribute getEMeta_Owner();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.crml.crmodel.EMeta#getEditor <em>Editor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Editor</em>'.
	 * @see com.nokia.tools.vct.crml.crmodel.EMeta#getEditor()
	 * @see #getEMeta()
	 * @generated
	 */
	EAttribute getEMeta_Editor();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.crml.crmodel.EMeta#getStatus <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Status</em>'.
	 * @see com.nokia.tools.vct.crml.crmodel.EMeta#getStatus()
	 * @see #getEMeta()
	 * @generated
	 */
	EAttribute getEMeta_Status();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.crml.crmodel.EMeta#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see com.nokia.tools.vct.crml.crmodel.EMeta#getVersion()
	 * @see #getEMeta()
	 * @generated
	 */
	EAttribute getEMeta_Version();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.crml.crmodel.EMeta#getProduct <em>Product</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Product</em>'.
	 * @see com.nokia.tools.vct.crml.crmodel.EMeta#getProduct()
	 * @see #getEMeta()
	 * @generated
	 */
	EAttribute getEMeta_Product();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.crml.crmodel.EMeta#getRelease <em>Release</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Release</em>'.
	 * @see com.nokia.tools.vct.crml.crmodel.EMeta#getRelease()
	 * @see #getEMeta()
	 * @generated
	 */
	EAttribute getEMeta_Release();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.crml.crmodel.EContent <em>EContent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EContent</em>'.
	 * @see com.nokia.tools.vct.crml.crmodel.EContent
	 * @generated
	 */
	EClass getEContent();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.crml.crmodel.EContent#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see com.nokia.tools.vct.crml.crmodel.EContent#getValue()
	 * @see #getEContent()
	 * @generated
	 */
	EAttribute getEContent_Value();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.crml.crmodel.ERepository <em>ERepository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ERepository</em>'.
	 * @see com.nokia.tools.vct.crml.crmodel.ERepository
	 * @generated
	 */
	EClass getERepository();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.crml.crmodel.ERepository#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see com.nokia.tools.vct.crml.crmodel.ERepository#getVersion()
	 * @see #getERepository()
	 * @generated
	 */
	EAttribute getERepository_Version();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.crml.crmodel.ERepository#getUidName <em>Uid Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uid Name</em>'.
	 * @see com.nokia.tools.vct.crml.crmodel.ERepository#getUidName()
	 * @see #getERepository()
	 * @generated
	 */
	EAttribute getERepository_UidName();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.crml.crmodel.ERepository#getUidValue <em>Uid Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uid Value</em>'.
	 * @see com.nokia.tools.vct.crml.crmodel.ERepository#getUidValue()
	 * @see #getERepository()
	 * @generated
	 */
	EAttribute getERepository_UidValue();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.crml.crmodel.ERepository#getInitialisationFileVersion <em>Initialisation File Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initialisation File Version</em>'.
	 * @see com.nokia.tools.vct.crml.crmodel.ERepository#getInitialisationFileVersion()
	 * @see #getERepository()
	 * @generated
	 */
	EAttribute getERepository_InitialisationFileVersion();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.crml.crmodel.ERepository#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Owner</em>'.
	 * @see com.nokia.tools.vct.crml.crmodel.ERepository#getOwner()
	 * @see #getERepository()
	 * @generated
	 */
	EAttribute getERepository_Owner();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.crml.crmodel.ERepository#isRfs <em>Rfs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rfs</em>'.
	 * @see com.nokia.tools.vct.crml.crmodel.ERepository#isRfs()
	 * @see #getERepository()
	 * @generated
	 */
	EAttribute getERepository_Rfs();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.vct.crml.crmodel.ERepository#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Key</em>'.
	 * @see com.nokia.tools.vct.crml.crmodel.ERepository#getKey()
	 * @see #getERepository()
	 * @generated
	 */
	EReference getERepository_Key();

	/**
	 * Returns the meta object for the containment reference '{@link com.nokia.tools.vct.crml.crmodel.ERepository#getMeta <em>Meta</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Meta</em>'.
	 * @see com.nokia.tools.vct.crml.crmodel.ERepository#getMeta()
	 * @see #getERepository()
	 * @generated
	 */
	EReference getERepository_Meta();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.vct.crml.crmodel.ERepository#getRangeKey <em>Range Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Range Key</em>'.
	 * @see com.nokia.tools.vct.crml.crmodel.ERepository#getRangeKey()
	 * @see #getERepository()
	 * @generated
	 */
	EReference getERepository_RangeKey();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.crml.crmodel.EKey <em>EKey</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EKey</em>'.
	 * @see com.nokia.tools.vct.crml.crmodel.EKey
	 * @generated
	 */
	EClass getEKey();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.crml.crmodel.EKey#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.nokia.tools.vct.crml.crmodel.EKey#getName()
	 * @see #getEKey()
	 * @generated
	 */
	EAttribute getEKey_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.crml.crmodel.EKey#getIdent <em>Ident</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ident</em>'.
	 * @see com.nokia.tools.vct.crml.crmodel.EKey#getIdent()
	 * @see #getEKey()
	 * @generated
	 */
	EAttribute getEKey_Ident();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.crml.crmodel.EKey#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.nokia.tools.vct.crml.crmodel.EKey#getType()
	 * @see #getEKey()
	 * @generated
	 */
	EAttribute getEKey_Type();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.vct.crml.crmodel.EKey#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Value</em>'.
	 * @see com.nokia.tools.vct.crml.crmodel.EKey#getValue()
	 * @see #getEKey()
	 * @generated
	 */
	EReference getEKey_Value();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.vct.crml.crmodel.EKey#getBits <em>Bits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Bits</em>'.
	 * @see com.nokia.tools.vct.crml.crmodel.EKey#getBits()
	 * @see #getEKey()
	 * @generated
	 */
	EReference getEKey_Bits();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.crml.crmodel.EKeyRange <em>EKey Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EKey Range</em>'.
	 * @see com.nokia.tools.vct.crml.crmodel.EKeyRange
	 * @generated
	 */
	EClass getEKeyRange();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.crml.crmodel.EKeyRange#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.nokia.tools.vct.crml.crmodel.EKeyRange#getName()
	 * @see #getEKeyRange()
	 * @generated
	 */
	EAttribute getEKeyRange_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.crml.crmodel.EKeyRange#getInt <em>Int</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Int</em>'.
	 * @see com.nokia.tools.vct.crml.crmodel.EKeyRange#getInt()
	 * @see #getEKeyRange()
	 * @generated
	 */
	EAttribute getEKeyRange_Int();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.crml.crmodel.EKeyRange#getFirstInt <em>First Int</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>First Int</em>'.
	 * @see com.nokia.tools.vct.crml.crmodel.EKeyRange#getFirstInt()
	 * @see #getEKeyRange()
	 * @generated
	 */
	EAttribute getEKeyRange_FirstInt();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.crml.crmodel.EKeyRange#getLastInt <em>Last Int</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Int</em>'.
	 * @see com.nokia.tools.vct.crml.crmodel.EKeyRange#getLastInt()
	 * @see #getEKeyRange()
	 * @generated
	 */
	EAttribute getEKeyRange_LastInt();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.crml.crmodel.EKeyRange#getIndexBits <em>Index Bits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index Bits</em>'.
	 * @see com.nokia.tools.vct.crml.crmodel.EKeyRange#getIndexBits()
	 * @see #getEKeyRange()
	 * @generated
	 */
	EAttribute getEKeyRange_IndexBits();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.crml.crmodel.EKeyRange#getFirstIndex <em>First Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>First Index</em>'.
	 * @see com.nokia.tools.vct.crml.crmodel.EKeyRange#getFirstIndex()
	 * @see #getEKeyRange()
	 * @generated
	 */
	EAttribute getEKeyRange_FirstIndex();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.crml.crmodel.EKeyRange#getCountInt <em>Count Int</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Count Int</em>'.
	 * @see com.nokia.tools.vct.crml.crmodel.EKeyRange#getCountInt()
	 * @see #getEKeyRange()
	 * @generated
	 */
	EAttribute getEKeyRange_CountInt();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.vct.crml.crmodel.EKeyRange#getKeys <em>Keys</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Keys</em>'.
	 * @see com.nokia.tools.vct.crml.crmodel.EKeyRange#getKeys()
	 * @see #getEKeyRange()
	 * @generated
	 */
	EReference getEKeyRange_Keys();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.crml.crmodel.EAccess <em>EAccess</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EAccess</em>'.
	 * @see com.nokia.tools.vct.crml.crmodel.EAccess
	 * @generated
	 */
	EClass getEAccess();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.crml.crmodel.EAccess#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.nokia.tools.vct.crml.crmodel.EAccess#getType()
	 * @see #getEAccess()
	 * @generated
	 */
	EAttribute getEAccess_Type();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.crml.crmodel.EAccess#getCapabilities <em>Capabilities</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Capabilities</em>'.
	 * @see com.nokia.tools.vct.crml.crmodel.EAccess#getCapabilities()
	 * @see #getEAccess()
	 * @generated
	 */
	EAttribute getEAccess_Capabilities();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.crml.crmodel.EAccess#getSid <em>Sid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sid</em>'.
	 * @see com.nokia.tools.vct.crml.crmodel.EAccess#getSid()
	 * @see #getEAccess()
	 * @generated
	 */
	EAttribute getEAccess_Sid();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.crml.crmodel.EValue <em>EValue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EValue</em>'.
	 * @see com.nokia.tools.vct.crml.crmodel.EValue
	 * @generated
	 */
	EClass getEValue();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.crml.crmodel.EValue#getVal <em>Val</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Val</em>'.
	 * @see com.nokia.tools.vct.crml.crmodel.EValue#getVal()
	 * @see #getEValue()
	 * @generated
	 */
	EAttribute getEValue_Val();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.crml.crmodel.EValue#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.nokia.tools.vct.crml.crmodel.EValue#getId()
	 * @see #getEValue()
	 * @generated
	 */
	EAttribute getEValue_Id();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.crml.crmodel.EBit <em>EBit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EBit</em>'.
	 * @see com.nokia.tools.vct.crml.crmodel.EBit
	 * @generated
	 */
	EClass getEBit();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.crml.crmodel.EBit#isState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see com.nokia.tools.vct.crml.crmodel.EBit#isState()
	 * @see #getEBit()
	 * @generated
	 */
	EAttribute getEBit_State();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.crml.crmodel.ERefContainer <em>ERef Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ERef Container</em>'.
	 * @see com.nokia.tools.vct.crml.crmodel.ERefContainer
	 * @generated
	 */
	EClass getERefContainer();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.crml.crmodel.ERefContainer#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ref</em>'.
	 * @see com.nokia.tools.vct.crml.crmodel.ERefContainer#getRef()
	 * @see #getERefContainer()
	 * @generated
	 */
	EAttribute getERefContainer_Ref();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.crml.crmodel.EAttributeAndDescription <em>EAttribute And Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EAttribute And Description</em>'.
	 * @see com.nokia.tools.vct.crml.crmodel.EAttributeAndDescription
	 * @generated
	 */
	EClass getEAttributeAndDescription();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.crml.crmodel.EAttributeAndDescription#getDesc <em>Desc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Desc</em>'.
	 * @see com.nokia.tools.vct.crml.crmodel.EAttributeAndDescription#getDesc()
	 * @see #getEAttributeAndDescription()
	 * @generated
	 */
	EAttribute getEAttributeAndDescription_Desc();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.crml.crmodel.EReadOnly <em>ERead Only</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ERead Only</em>'.
	 * @see com.nokia.tools.vct.crml.crmodel.EReadOnly
	 * @generated
	 */
	EClass getEReadOnly();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.crml.crmodel.EReadOnly#isReadOnly <em>Read Only</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Read Only</em>'.
	 * @see com.nokia.tools.vct.crml.crmodel.EReadOnly#isReadOnly()
	 * @see #getEReadOnly()
	 * @generated
	 */
	EAttribute getEReadOnly_ReadOnly();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.crml.crmodel.EAccessContainer <em>EAccess Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EAccess Container</em>'.
	 * @see com.nokia.tools.vct.crml.crmodel.EAccessContainer
	 * @generated
	 */
	EClass getEAccessContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.vct.crml.crmodel.EAccessContainer#getAccess <em>Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Access</em>'.
	 * @see com.nokia.tools.vct.crml.crmodel.EAccessContainer#getAccess()
	 * @see #getEAccessContainer()
	 * @generated
	 */
	EReference getEAccessContainer_Access();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.crml.crmodel.EBackup <em>EBackup</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EBackup</em>'.
	 * @see com.nokia.tools.vct.crml.crmodel.EBackup
	 * @generated
	 */
	EClass getEBackup();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.crml.crmodel.EBackup#isBackup <em>Backup</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Backup</em>'.
	 * @see com.nokia.tools.vct.crml.crmodel.EBackup#isBackup()
	 * @see #getEBackup()
	 * @generated
	 */
	EAttribute getEBackup_Backup();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.crml.crmodel.ECRMLDocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document Root</em>'.
	 * @see com.nokia.tools.vct.crml.crmodel.ECRMLDocumentRoot
	 * @generated
	 */
	EClass getECRMLDocumentRoot();

	/**
	 * Returns the meta object for the containment reference '{@link com.nokia.tools.vct.crml.crmodel.ECRMLDocumentRoot#getRepository <em>Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Repository</em>'.
	 * @see com.nokia.tools.vct.crml.crmodel.ECRMLDocumentRoot#getRepository()
	 * @see #getECRMLDocumentRoot()
	 * @generated
	 */
	EReference getECRMLDocumentRoot_Repository();

	/**
	 * Returns the meta object for enum '{@link com.nokia.tools.vct.crml.crmodel.EKeyType <em>EKey Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EKey Type</em>'.
	 * @see com.nokia.tools.vct.crml.crmodel.EKeyType
	 * @generated
	 */
	EEnum getEKeyType();

	/**
	 * Returns the meta object for enum '{@link com.nokia.tools.vct.crml.crmodel.EAccessType <em>EAccess Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EAccess Type</em>'.
	 * @see com.nokia.tools.vct.crml.crmodel.EAccessType
	 * @generated
	 */
	EEnum getEAccessType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ECRMLFactory getECRMLFactory();

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
		 * The meta object literal for the '{@link com.nokia.tools.vct.crml.crmodel.impl.CommonAttrsImpl <em>Common Attrs</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.crml.crmodel.impl.CommonAttrsImpl
		 * @see com.nokia.tools.vct.crml.crmodel.impl.ECRMLPackageImpl#getCommonAttrs()
		 * @generated
		 */
		EClass COMMON_ATTRS = eINSTANCE.getCommonAttrs();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMON_ATTRS__ID = eINSTANCE.getCommonAttrs_Id();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.crml.crmodel.impl.EMetaImpl <em>EMeta</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.crml.crmodel.impl.EMetaImpl
		 * @see com.nokia.tools.vct.crml.crmodel.impl.ECRMLPackageImpl#getEMeta()
		 * @generated
		 */
		EClass EMETA = eINSTANCE.getEMeta();

		/**
		 * The meta object literal for the '<em><b>Identification</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EMETA__IDENTIFICATION = eINSTANCE.getEMeta_Identification();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EMETA__DATE = eINSTANCE.getEMeta_Date();

		/**
		 * The meta object literal for the '<em><b>Platform</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EMETA__PLATFORM = eINSTANCE.getEMeta_Platform();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EMETA__OWNER = eINSTANCE.getEMeta_Owner();

		/**
		 * The meta object literal for the '<em><b>Editor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EMETA__EDITOR = eINSTANCE.getEMeta_Editor();

		/**
		 * The meta object literal for the '<em><b>Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EMETA__STATUS = eINSTANCE.getEMeta_Status();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EMETA__VERSION = eINSTANCE.getEMeta_Version();

		/**
		 * The meta object literal for the '<em><b>Product</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EMETA__PRODUCT = eINSTANCE.getEMeta_Product();

		/**
		 * The meta object literal for the '<em><b>Release</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EMETA__RELEASE = eINSTANCE.getEMeta_Release();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.crml.crmodel.impl.EContentImpl <em>EContent</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.crml.crmodel.impl.EContentImpl
		 * @see com.nokia.tools.vct.crml.crmodel.impl.ECRMLPackageImpl#getEContent()
		 * @generated
		 */
		EClass ECONTENT = eINSTANCE.getEContent();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECONTENT__VALUE = eINSTANCE.getEContent_Value();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.crml.crmodel.impl.ERepositoryImpl <em>ERepository</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.crml.crmodel.impl.ERepositoryImpl
		 * @see com.nokia.tools.vct.crml.crmodel.impl.ECRMLPackageImpl#getERepository()
		 * @generated
		 */
		EClass EREPOSITORY = eINSTANCE.getERepository();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EREPOSITORY__VERSION = eINSTANCE.getERepository_Version();

		/**
		 * The meta object literal for the '<em><b>Uid Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EREPOSITORY__UID_NAME = eINSTANCE.getERepository_UidName();

		/**
		 * The meta object literal for the '<em><b>Uid Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EREPOSITORY__UID_VALUE = eINSTANCE.getERepository_UidValue();

		/**
		 * The meta object literal for the '<em><b>Initialisation File Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EREPOSITORY__INITIALISATION_FILE_VERSION = eINSTANCE.getERepository_InitialisationFileVersion();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EREPOSITORY__OWNER = eINSTANCE.getERepository_Owner();

		/**
		 * The meta object literal for the '<em><b>Rfs</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EREPOSITORY__RFS = eINSTANCE.getERepository_Rfs();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EREPOSITORY__KEY = eINSTANCE.getERepository_Key();

		/**
		 * The meta object literal for the '<em><b>Meta</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EREPOSITORY__META = eINSTANCE.getERepository_Meta();

		/**
		 * The meta object literal for the '<em><b>Range Key</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EREPOSITORY__RANGE_KEY = eINSTANCE.getERepository_RangeKey();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.crml.crmodel.impl.EKeyImpl <em>EKey</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.crml.crmodel.impl.EKeyImpl
		 * @see com.nokia.tools.vct.crml.crmodel.impl.ECRMLPackageImpl#getEKey()
		 * @generated
		 */
		EClass EKEY = eINSTANCE.getEKey();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EKEY__NAME = eINSTANCE.getEKey_Name();

		/**
		 * The meta object literal for the '<em><b>Ident</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EKEY__IDENT = eINSTANCE.getEKey_Ident();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EKEY__TYPE = eINSTANCE.getEKey_Type();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EKEY__VALUE = eINSTANCE.getEKey_Value();

		/**
		 * The meta object literal for the '<em><b>Bits</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EKEY__BITS = eINSTANCE.getEKey_Bits();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.crml.crmodel.impl.EKeyRangeImpl <em>EKey Range</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.crml.crmodel.impl.EKeyRangeImpl
		 * @see com.nokia.tools.vct.crml.crmodel.impl.ECRMLPackageImpl#getEKeyRange()
		 * @generated
		 */
		EClass EKEY_RANGE = eINSTANCE.getEKeyRange();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EKEY_RANGE__NAME = eINSTANCE.getEKeyRange_Name();

		/**
		 * The meta object literal for the '<em><b>Int</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EKEY_RANGE__INT = eINSTANCE.getEKeyRange_Int();

		/**
		 * The meta object literal for the '<em><b>First Int</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EKEY_RANGE__FIRST_INT = eINSTANCE.getEKeyRange_FirstInt();

		/**
		 * The meta object literal for the '<em><b>Last Int</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EKEY_RANGE__LAST_INT = eINSTANCE.getEKeyRange_LastInt();

		/**
		 * The meta object literal for the '<em><b>Index Bits</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EKEY_RANGE__INDEX_BITS = eINSTANCE.getEKeyRange_IndexBits();

		/**
		 * The meta object literal for the '<em><b>First Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EKEY_RANGE__FIRST_INDEX = eINSTANCE.getEKeyRange_FirstIndex();

		/**
		 * The meta object literal for the '<em><b>Count Int</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EKEY_RANGE__COUNT_INT = eINSTANCE.getEKeyRange_CountInt();

		/**
		 * The meta object literal for the '<em><b>Keys</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EKEY_RANGE__KEYS = eINSTANCE.getEKeyRange_Keys();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.crml.crmodel.impl.EAccessImpl <em>EAccess</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.crml.crmodel.impl.EAccessImpl
		 * @see com.nokia.tools.vct.crml.crmodel.impl.ECRMLPackageImpl#getEAccess()
		 * @generated
		 */
		EClass EACCESS = eINSTANCE.getEAccess();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EACCESS__TYPE = eINSTANCE.getEAccess_Type();

		/**
		 * The meta object literal for the '<em><b>Capabilities</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EACCESS__CAPABILITIES = eINSTANCE.getEAccess_Capabilities();

		/**
		 * The meta object literal for the '<em><b>Sid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EACCESS__SID = eINSTANCE.getEAccess_Sid();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.crml.crmodel.impl.EValueImpl <em>EValue</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.crml.crmodel.impl.EValueImpl
		 * @see com.nokia.tools.vct.crml.crmodel.impl.ECRMLPackageImpl#getEValue()
		 * @generated
		 */
		EClass EVALUE = eINSTANCE.getEValue();

		/**
		 * The meta object literal for the '<em><b>Val</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVALUE__VAL = eINSTANCE.getEValue_Val();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVALUE__ID = eINSTANCE.getEValue_Id();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.crml.crmodel.impl.EBitImpl <em>EBit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.crml.crmodel.impl.EBitImpl
		 * @see com.nokia.tools.vct.crml.crmodel.impl.ECRMLPackageImpl#getEBit()
		 * @generated
		 */
		EClass EBIT = eINSTANCE.getEBit();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EBIT__STATE = eINSTANCE.getEBit_State();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.crml.crmodel.ERefContainer <em>ERef Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.crml.crmodel.ERefContainer
		 * @see com.nokia.tools.vct.crml.crmodel.impl.ECRMLPackageImpl#getERefContainer()
		 * @generated
		 */
		EClass EREF_CONTAINER = eINSTANCE.getERefContainer();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EREF_CONTAINER__REF = eINSTANCE.getERefContainer_Ref();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.crml.crmodel.impl.EAttributeAndDescriptionImpl <em>EAttribute And Description</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.crml.crmodel.impl.EAttributeAndDescriptionImpl
		 * @see com.nokia.tools.vct.crml.crmodel.impl.ECRMLPackageImpl#getEAttributeAndDescription()
		 * @generated
		 */
		EClass EATTRIBUTE_AND_DESCRIPTION = eINSTANCE.getEAttributeAndDescription();

		/**
		 * The meta object literal for the '<em><b>Desc</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EATTRIBUTE_AND_DESCRIPTION__DESC = eINSTANCE.getEAttributeAndDescription_Desc();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.crml.crmodel.EReadOnly <em>ERead Only</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.crml.crmodel.EReadOnly
		 * @see com.nokia.tools.vct.crml.crmodel.impl.ECRMLPackageImpl#getEReadOnly()
		 * @generated
		 */
		EClass EREAD_ONLY = eINSTANCE.getEReadOnly();

		/**
		 * The meta object literal for the '<em><b>Read Only</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EREAD_ONLY__READ_ONLY = eINSTANCE.getEReadOnly_ReadOnly();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.crml.crmodel.EAccessContainer <em>EAccess Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.crml.crmodel.EAccessContainer
		 * @see com.nokia.tools.vct.crml.crmodel.impl.ECRMLPackageImpl#getEAccessContainer()
		 * @generated
		 */
		EClass EACCESS_CONTAINER = eINSTANCE.getEAccessContainer();

		/**
		 * The meta object literal for the '<em><b>Access</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EACCESS_CONTAINER__ACCESS = eINSTANCE.getEAccessContainer_Access();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.crml.crmodel.EBackup <em>EBackup</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.crml.crmodel.EBackup
		 * @see com.nokia.tools.vct.crml.crmodel.impl.ECRMLPackageImpl#getEBackup()
		 * @generated
		 */
		EClass EBACKUP = eINSTANCE.getEBackup();

		/**
		 * The meta object literal for the '<em><b>Backup</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EBACKUP__BACKUP = eINSTANCE.getEBackup_Backup();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.crml.crmodel.impl.ECRMLDocumentRootImpl <em>Document Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.crml.crmodel.impl.ECRMLDocumentRootImpl
		 * @see com.nokia.tools.vct.crml.crmodel.impl.ECRMLPackageImpl#getECRMLDocumentRoot()
		 * @generated
		 */
		EClass ECRML_DOCUMENT_ROOT = eINSTANCE.getECRMLDocumentRoot();

		/**
		 * The meta object literal for the '<em><b>Repository</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECRML_DOCUMENT_ROOT__REPOSITORY = eINSTANCE.getECRMLDocumentRoot_Repository();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.crml.crmodel.EKeyType <em>EKey Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.crml.crmodel.EKeyType
		 * @see com.nokia.tools.vct.crml.crmodel.impl.ECRMLPackageImpl#getEKeyType()
		 * @generated
		 */
		EEnum EKEY_TYPE = eINSTANCE.getEKeyType();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.crml.crmodel.EAccessType <em>EAccess Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.crml.crmodel.EAccessType
		 * @see com.nokia.tools.vct.crml.crmodel.impl.ECRMLPackageImpl#getEAccessType()
		 * @generated
		 */
		EEnum EACCESS_TYPE = eINSTANCE.getEAccessType();

	}

} //ECRMLPackage
