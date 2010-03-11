/*
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
*/
package cenrep;

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
 * @see cenrep.CenrepFactory
 * @model kind="package"
 * @generated
 */
public interface CenrepPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "cenrep";

/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	String eNS_URI = "http://www.s60.com/xml/cenrep/1";

/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	String eNS_PREFIX = "";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CenrepPackage eINSTANCE = cenrep.impl.CenrepPackageImpl.init();

	/**
	 * The meta object id for the '{@link cenrep.impl.CommonAttrsImpl <em>Common Attrs</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cenrep.impl.CommonAttrsImpl
	 * @see cenrep.impl.CenrepPackageImpl#getCommonAttrs()
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
	 * The meta object id for the '{@link cenrep.impl.MetaImpl <em>Meta</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cenrep.impl.MetaImpl
	 * @see cenrep.impl.CenrepPackageImpl#getMeta()
	 * @generated
	 */
	int META = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META__ID = COMMON_ATTRS__ID;

	/**
	 * The feature id for the '<em><b>Identification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META__IDENTIFICATION = COMMON_ATTRS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Date</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META__DATE = COMMON_ATTRS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Platform</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META__PLATFORM = COMMON_ATTRS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META__OWNER = COMMON_ATTRS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Editor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META__EDITOR = COMMON_ATTRS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Status</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META__STATUS = COMMON_ATTRS_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Version</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META__VERSION = COMMON_ATTRS_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Product</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META__PRODUCT = COMMON_ATTRS_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Release</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META__RELEASE = COMMON_ATTRS_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Meta</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_FEATURE_COUNT = COMMON_ATTRS_FEATURE_COUNT + 9;

	/**
	 * The meta object id for the '{@link cenrep.impl.ContentImpl <em>Content</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cenrep.impl.ContentImpl
	 * @see cenrep.impl.CenrepPackageImpl#getContent()
	 * @generated
	 */
	int CONTENT = 11;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT__VALUE = 0;

	/**
	 * The number of structural features of the '<em>Content</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link cenrep.impl.IdentificationImpl <em>Identification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cenrep.impl.IdentificationImpl
	 * @see cenrep.impl.CenrepPackageImpl#getIdentification()
	 * @generated
	 */
	int IDENTIFICATION = 2;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFICATION__VALUE = CONTENT__VALUE;

	/**
	 * The number of structural features of the '<em>Identification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFICATION_FEATURE_COUNT = CONTENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link cenrep.impl.DateImpl <em>Date</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cenrep.impl.DateImpl
	 * @see cenrep.impl.CenrepPackageImpl#getDate()
	 * @generated
	 */
	int DATE = 3;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE__VALUE = CONTENT__VALUE;

	/**
	 * The number of structural features of the '<em>Date</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE_FEATURE_COUNT = CONTENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link cenrep.impl.OwnerImpl <em>Owner</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cenrep.impl.OwnerImpl
	 * @see cenrep.impl.CenrepPackageImpl#getOwner()
	 * @generated
	 */
	int OWNER = 4;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OWNER__VALUE = CONTENT__VALUE;

	/**
	 * The number of structural features of the '<em>Owner</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OWNER_FEATURE_COUNT = CONTENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link cenrep.impl.EditorImpl <em>Editor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cenrep.impl.EditorImpl
	 * @see cenrep.impl.CenrepPackageImpl#getEditor()
	 * @generated
	 */
	int EDITOR = 5;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR__VALUE = CONTENT__VALUE;

	/**
	 * The number of structural features of the '<em>Editor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR_FEATURE_COUNT = CONTENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link cenrep.impl.StatusImpl <em>Status</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cenrep.impl.StatusImpl
	 * @see cenrep.impl.CenrepPackageImpl#getStatus()
	 * @generated
	 */
	int STATUS = 6;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUS__VALUE = CONTENT__VALUE;

	/**
	 * The number of structural features of the '<em>Status</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUS_FEATURE_COUNT = CONTENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link cenrep.impl.VersionImpl <em>Version</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cenrep.impl.VersionImpl
	 * @see cenrep.impl.CenrepPackageImpl#getVersion()
	 * @generated
	 */
	int VERSION = 7;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION__VALUE = CONTENT__VALUE;

	/**
	 * The number of structural features of the '<em>Version</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION_FEATURE_COUNT = CONTENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link cenrep.impl.PlatformImpl <em>Platform</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cenrep.impl.PlatformImpl
	 * @see cenrep.impl.CenrepPackageImpl#getPlatform()
	 * @generated
	 */
	int PLATFORM = 8;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATFORM__VALUE = CONTENT__VALUE;

	/**
	 * The number of structural features of the '<em>Platform</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATFORM_FEATURE_COUNT = CONTENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link cenrep.impl.ProductImpl <em>Product</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cenrep.impl.ProductImpl
	 * @see cenrep.impl.CenrepPackageImpl#getProduct()
	 * @generated
	 */
	int PRODUCT = 9;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT__VALUE = CONTENT__VALUE;

	/**
	 * The number of structural features of the '<em>Product</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT_FEATURE_COUNT = CONTENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link cenrep.impl.ReleaseImpl <em>Release</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cenrep.impl.ReleaseImpl
	 * @see cenrep.impl.CenrepPackageImpl#getRelease()
	 * @generated
	 */
	int RELEASE = 10;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE__VALUE = CONTENT__VALUE;

	/**
	 * The number of structural features of the '<em>Release</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE_FEATURE_COUNT = CONTENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link cenrep.impl.AttributeAndDescriptionImpl <em>Attribute And Description</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cenrep.impl.AttributeAndDescriptionImpl
	 * @see cenrep.impl.CenrepPackageImpl#getAttributeAndDescription()
	 * @generated
	 */
	int ATTRIBUTE_AND_DESCRIPTION = 19;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_AND_DESCRIPTION__ID = COMMON_ATTRS__ID;

	/**
	 * The feature id for the '<em><b>Desc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_AND_DESCRIPTION__DESC = COMMON_ATTRS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Attribute And Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT = COMMON_ATTRS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link cenrep.impl.RepositoryImpl <em>Repository</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cenrep.impl.RepositoryImpl
	 * @see cenrep.impl.CenrepPackageImpl#getRepository()
	 * @generated
	 */
	int REPOSITORY = 12;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__ID = ATTRIBUTE_AND_DESCRIPTION__ID;

	/**
	 * The feature id for the '<em><b>Desc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__DESC = ATTRIBUTE_AND_DESCRIPTION__DESC;

	/**
	 * The feature id for the '<em><b>Access</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__ACCESS = ATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Read Access</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__READ_ACCESS = ATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Write Access</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__WRITE_ACCESS = ATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>GAccess</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__GACCESS = ATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Backup</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__BACKUP = ATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__VERSION = ATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Uid Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__UID_NAME = ATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Uid Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__UID_VALUE = ATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Initialisation File Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__INITIALISATION_FILE_VERSION = ATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__OWNER = ATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Rfs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__RFS = ATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Key</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__KEY = ATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Meta</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__META = ATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Simple Keys</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__SIMPLE_KEYS = ATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Bitmask Keys</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__BITMASK_KEYS = ATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Range Key</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__RANGE_KEY = ATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>File Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__FILE_NAME = ATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 16;

	/**
	 * The feature id for the '<em><b>Problems</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__PROBLEMS = ATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 17;

	/**
	 * The number of structural features of the '<em>Repository</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY_FEATURE_COUNT = ATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 18;

	/**
	 * The meta object id for the '{@link cenrep.impl.KeyImpl <em>Key</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cenrep.impl.KeyImpl
	 * @see cenrep.impl.CenrepPackageImpl#getKey()
	 * @generated
	 */
	int KEY = 13;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY__ID = ATTRIBUTE_AND_DESCRIPTION__ID;

	/**
	 * The feature id for the '<em><b>Desc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY__DESC = ATTRIBUTE_AND_DESCRIPTION__DESC;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY__REF = ATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Gvalue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY__GVALUE = ATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Rfs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY__RFS = ATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY__READ_ONLY = ATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Access</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY__ACCESS = ATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Read Access</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY__READ_ACCESS = ATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Write Access</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY__WRITE_ACCESS = ATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>GAccess</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY__GACCESS = ATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Backup</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY__BACKUP = ATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY__NAME = ATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Ident</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY__IDENT = ATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY__TYPE = ATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY__VALUE = ATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Bits</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY__BITS = ATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Bitmask Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY__BITMASK_KEY = ATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Simple Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY__SIMPLE_KEY = ATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Short Ident</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY__SHORT_IDENT = ATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 16;

	/**
	 * The feature id for the '<em><b>Str Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY__STR_TYPE = ATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 17;

	/**
	 * The feature id for the '<em><b>Dec Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY__DEC_FORMAT = ATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 18;

	/**
	 * The feature id for the '<em><b>Hex Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY__HEX_FORMAT = ATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 19;

	/**
	 * The number of structural features of the '<em>Key</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_FEATURE_COUNT = ATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 20;

	/**
	 * The meta object id for the '{@link cenrep.impl.KeyRangeImpl <em>Key Range</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cenrep.impl.KeyRangeImpl
	 * @see cenrep.impl.CenrepPackageImpl#getKeyRange()
	 * @generated
	 */
	int KEY_RANGE = 14;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_RANGE__ID = ATTRIBUTE_AND_DESCRIPTION__ID;

	/**
	 * The feature id for the '<em><b>Desc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_RANGE__DESC = ATTRIBUTE_AND_DESCRIPTION__DESC;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_RANGE__REF = ATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Gvalue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_RANGE__GVALUE = ATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Rfs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_RANGE__RFS = ATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_RANGE__READ_ONLY = ATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Access</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_RANGE__ACCESS = ATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Read Access</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_RANGE__READ_ACCESS = ATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Write Access</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_RANGE__WRITE_ACCESS = ATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>GAccess</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_RANGE__GACCESS = ATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Backup</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_RANGE__BACKUP = ATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_RANGE__NAME = ATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Int</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_RANGE__INT = ATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>First Int</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_RANGE__FIRST_INT = ATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Last Int</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_RANGE__LAST_INT = ATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Index Bits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_RANGE__INDEX_BITS = ATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>First Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_RANGE__FIRST_INDEX = ATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Count Int</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_RANGE__COUNT_INT = ATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Keys</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_RANGE__KEYS = ATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 16;

	/**
	 * The number of structural features of the '<em>Key Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_RANGE_FEATURE_COUNT = ATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 17;

	/**
	 * The meta object id for the '{@link cenrep.impl.AccessImpl <em>Access</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cenrep.impl.AccessImpl
	 * @see cenrep.impl.CenrepPackageImpl#getAccess()
	 * @generated
	 */
	int ACCESS = 15;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS__ID = ATTRIBUTE_AND_DESCRIPTION__ID;

	/**
	 * The feature id for the '<em><b>Desc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS__DESC = ATTRIBUTE_AND_DESCRIPTION__DESC;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS__TYPE = ATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS__CAPABILITIES = ATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Sid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS__SID = ATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Str Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS__STR_FORMAT = ATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Access</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_FEATURE_COUNT = ATTRIBUTE_AND_DESCRIPTION_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link cenrep.impl.ValueImpl <em>Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cenrep.impl.ValueImpl
	 * @see cenrep.impl.CenrepPackageImpl#getValue()
	 * @generated
	 */
	int VALUE = 16;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE__VALUE = CONTENT__VALUE;

	/**
	 * The feature id for the '<em><b>Val</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE__VAL = CONTENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE__ID = CONTENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_FEATURE_COUNT = CONTENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link cenrep.impl.BitImpl <em>Bit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cenrep.impl.BitImpl
	 * @see cenrep.impl.CenrepPackageImpl#getBit()
	 * @generated
	 */
	int BIT = 17;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIT__VALUE = CONTENT__VALUE;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIT__REF = CONTENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Gvalue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIT__GVALUE = CONTENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Rfs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIT__RFS = CONTENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIT__STATE = CONTENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIT__NUMBER = CONTENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Bit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIT_FEATURE_COUNT = CONTENT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link cenrep.RVG <em>RVG</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cenrep.RVG
	 * @see cenrep.impl.CenrepPackageImpl#getRVG()
	 * @generated
	 */
	int RVG = 18;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RVG__REF = 0;

	/**
	 * The feature id for the '<em><b>Gvalue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RVG__GVALUE = 1;

	/**
	 * The feature id for the '<em><b>Rfs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RVG__RFS = 2;

	/**
	 * The number of structural features of the '<em>RVG</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RVG_FEATURE_COUNT = 3;


	/**
	 * The meta object id for the '{@link cenrep.IReadOnly <em>IRead Only</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cenrep.IReadOnly
	 * @see cenrep.impl.CenrepPackageImpl#getIReadOnly()
	 * @generated
	 */
	int IREAD_ONLY = 20;

	/**
	 * The feature id for the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IREAD_ONLY__READ_ONLY = 0;

	/**
	 * The number of structural features of the '<em>IRead Only</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IREAD_ONLY_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link cenrep.IAccessable <em>IAccessable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cenrep.IAccessable
	 * @see cenrep.impl.CenrepPackageImpl#getIAccessable()
	 * @generated
	 */
	int IACCESSABLE = 21;

	/**
	 * The feature id for the '<em><b>Access</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IACCESSABLE__ACCESS = 0;

	/**
	 * The feature id for the '<em><b>Read Access</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IACCESSABLE__READ_ACCESS = 1;

	/**
	 * The feature id for the '<em><b>Write Access</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IACCESSABLE__WRITE_ACCESS = 2;

	/**
	 * The feature id for the '<em><b>GAccess</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IACCESSABLE__GACCESS = 3;

	/**
	 * The number of structural features of the '<em>IAccessable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IACCESSABLE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link cenrep.IBackup <em>IBackup</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cenrep.IBackup
	 * @see cenrep.impl.CenrepPackageImpl#getIBackup()
	 * @generated
	 */
	int IBACKUP = 22;

	/**
	 * The feature id for the '<em><b>Backup</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IBACKUP__BACKUP = 0;

	/**
	 * The number of structural features of the '<em>IBackup</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IBACKUP_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link cenrep.TYPE <em>TYPE</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cenrep.TYPE
	 * @see cenrep.impl.CenrepPackageImpl#getTYPE()
	 * @generated
	 */
	int TYPE = 23;


	/**
	 * The meta object id for the '{@link cenrep.ACCESS_TYPE <em>ACCESS TYPE</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cenrep.ACCESS_TYPE
	 * @see cenrep.impl.CenrepPackageImpl#getACCESS_TYPE()
	 * @generated
	 */
	int ACCESS_TYPE = 24;


	/**
	 * Returns the meta object for class '{@link cenrep.CommonAttrs <em>Common Attrs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Common Attrs</em>'.
	 * @see cenrep.CommonAttrs
	 * @generated
	 */
	EClass getCommonAttrs();

	/**
	 * Returns the meta object for the attribute '{@link cenrep.CommonAttrs#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see cenrep.CommonAttrs#getId()
	 * @see #getCommonAttrs()
	 * @generated
	 */
	EAttribute getCommonAttrs_Id();

	/**
	 * Returns the meta object for class '{@link cenrep.Meta <em>Meta</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Meta</em>'.
	 * @see cenrep.Meta
	 * @generated
	 */
	EClass getMeta();

	/**
	 * Returns the meta object for the reference '{@link cenrep.Meta#getIdentification <em>Identification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Identification</em>'.
	 * @see cenrep.Meta#getIdentification()
	 * @see #getMeta()
	 * @generated
	 */
	EReference getMeta_Identification();

	/**
	 * Returns the meta object for the reference '{@link cenrep.Meta#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Date</em>'.
	 * @see cenrep.Meta#getDate()
	 * @see #getMeta()
	 * @generated
	 */
	EReference getMeta_Date();

	/**
	 * Returns the meta object for the reference '{@link cenrep.Meta#getPlatform <em>Platform</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Platform</em>'.
	 * @see cenrep.Meta#getPlatform()
	 * @see #getMeta()
	 * @generated
	 */
	EReference getMeta_Platform();

	/**
	 * Returns the meta object for the reference '{@link cenrep.Meta#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Owner</em>'.
	 * @see cenrep.Meta#getOwner()
	 * @see #getMeta()
	 * @generated
	 */
	EReference getMeta_Owner();

	/**
	 * Returns the meta object for the reference '{@link cenrep.Meta#getEditor <em>Editor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Editor</em>'.
	 * @see cenrep.Meta#getEditor()
	 * @see #getMeta()
	 * @generated
	 */
	EReference getMeta_Editor();

	/**
	 * Returns the meta object for the reference '{@link cenrep.Meta#getStatus <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Status</em>'.
	 * @see cenrep.Meta#getStatus()
	 * @see #getMeta()
	 * @generated
	 */
	EReference getMeta_Status();

	/**
	 * Returns the meta object for the reference '{@link cenrep.Meta#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Version</em>'.
	 * @see cenrep.Meta#getVersion()
	 * @see #getMeta()
	 * @generated
	 */
	EReference getMeta_Version();

	/**
	 * Returns the meta object for the reference '{@link cenrep.Meta#getProduct <em>Product</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Product</em>'.
	 * @see cenrep.Meta#getProduct()
	 * @see #getMeta()
	 * @generated
	 */
	EReference getMeta_Product();

	/**
	 * Returns the meta object for the reference '{@link cenrep.Meta#getRelease <em>Release</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Release</em>'.
	 * @see cenrep.Meta#getRelease()
	 * @see #getMeta()
	 * @generated
	 */
	EReference getMeta_Release();

	/**
	 * Returns the meta object for class '{@link cenrep.Identification <em>Identification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Identification</em>'.
	 * @see cenrep.Identification
	 * @generated
	 */
	EClass getIdentification();

	/**
	 * Returns the meta object for class '{@link cenrep.Date <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Date</em>'.
	 * @see cenrep.Date
	 * @generated
	 */
	EClass getDate();

	/**
	 * Returns the meta object for class '{@link cenrep.Owner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Owner</em>'.
	 * @see cenrep.Owner
	 * @generated
	 */
	EClass getOwner();

	/**
	 * Returns the meta object for class '{@link cenrep.Editor <em>Editor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Editor</em>'.
	 * @see cenrep.Editor
	 * @generated
	 */
	EClass getEditor();

	/**
	 * Returns the meta object for class '{@link cenrep.Status <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Status</em>'.
	 * @see cenrep.Status
	 * @generated
	 */
	EClass getStatus();

	/**
	 * Returns the meta object for class '{@link cenrep.Version <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Version</em>'.
	 * @see cenrep.Version
	 * @generated
	 */
	EClass getVersion();

	/**
	 * Returns the meta object for class '{@link cenrep.Platform <em>Platform</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Platform</em>'.
	 * @see cenrep.Platform
	 * @generated
	 */
	EClass getPlatform();

	/**
	 * Returns the meta object for class '{@link cenrep.Product <em>Product</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Product</em>'.
	 * @see cenrep.Product
	 * @generated
	 */
	EClass getProduct();

	/**
	 * Returns the meta object for class '{@link cenrep.Release <em>Release</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Release</em>'.
	 * @see cenrep.Release
	 * @generated
	 */
	EClass getRelease();

	/**
	 * Returns the meta object for class '{@link cenrep.Content <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Content</em>'.
	 * @see cenrep.Content
	 * @generated
	 */
	EClass getContent();

	/**
	 * Returns the meta object for the attribute '{@link cenrep.Content#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see cenrep.Content#getValue()
	 * @see #getContent()
	 * @generated
	 */
	EAttribute getContent_Value();

	/**
	 * Returns the meta object for class '{@link cenrep.Repository <em>Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Repository</em>'.
	 * @see cenrep.Repository
	 * @generated
	 */
	EClass getRepository();

	/**
	 * Returns the meta object for the attribute '{@link cenrep.Repository#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see cenrep.Repository#getVersion()
	 * @see #getRepository()
	 * @generated
	 */
	EAttribute getRepository_Version();

	/**
	 * Returns the meta object for the attribute '{@link cenrep.Repository#getUidName <em>Uid Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uid Name</em>'.
	 * @see cenrep.Repository#getUidName()
	 * @see #getRepository()
	 * @generated
	 */
	EAttribute getRepository_UidName();

	/**
	 * Returns the meta object for the attribute '{@link cenrep.Repository#getUidValue <em>Uid Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uid Value</em>'.
	 * @see cenrep.Repository#getUidValue()
	 * @see #getRepository()
	 * @generated
	 */
	EAttribute getRepository_UidValue();

	/**
	 * Returns the meta object for the attribute '{@link cenrep.Repository#getInitialisationFileVersion <em>Initialisation File Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initialisation File Version</em>'.
	 * @see cenrep.Repository#getInitialisationFileVersion()
	 * @see #getRepository()
	 * @generated
	 */
	EAttribute getRepository_InitialisationFileVersion();

	/**
	 * Returns the meta object for the attribute '{@link cenrep.Repository#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Owner</em>'.
	 * @see cenrep.Repository#getOwner()
	 * @see #getRepository()
	 * @generated
	 */
	EAttribute getRepository_Owner();

	/**
	 * Returns the meta object for the attribute '{@link cenrep.Repository#isRfs <em>Rfs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rfs</em>'.
	 * @see cenrep.Repository#isRfs()
	 * @see #getRepository()
	 * @generated
	 */
	EAttribute getRepository_Rfs();

	/**
	 * Returns the meta object for the containment reference list '{@link cenrep.Repository#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Key</em>'.
	 * @see cenrep.Repository#getKey()
	 * @see #getRepository()
	 * @generated
	 */
	EReference getRepository_Key();

	/**
	 * Returns the meta object for the reference '{@link cenrep.Repository#getMeta <em>Meta</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Meta</em>'.
	 * @see cenrep.Repository#getMeta()
	 * @see #getRepository()
	 * @generated
	 */
	EReference getRepository_Meta();

	/**
	 * Returns the meta object for the reference list '{@link cenrep.Repository#getSimpleKeys <em>Simple Keys</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Simple Keys</em>'.
	 * @see cenrep.Repository#getSimpleKeys()
	 * @see #getRepository()
	 * @generated
	 */
	EReference getRepository_SimpleKeys();

	/**
	 * Returns the meta object for the reference list '{@link cenrep.Repository#getBitmaskKeys <em>Bitmask Keys</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Bitmask Keys</em>'.
	 * @see cenrep.Repository#getBitmaskKeys()
	 * @see #getRepository()
	 * @generated
	 */
	EReference getRepository_BitmaskKeys();

	/**
	 * Returns the meta object for the containment reference list '{@link cenrep.Repository#getRangeKey <em>Range Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Range Key</em>'.
	 * @see cenrep.Repository#getRangeKey()
	 * @see #getRepository()
	 * @generated
	 */
	EReference getRepository_RangeKey();

	/**
	 * Returns the meta object for the attribute '{@link cenrep.Repository#getFileName <em>File Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File Name</em>'.
	 * @see cenrep.Repository#getFileName()
	 * @see #getRepository()
	 * @generated
	 */
	EAttribute getRepository_FileName();

	/**
	 * Returns the meta object for the attribute '{@link cenrep.Repository#getProblems <em>Problems</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Problems</em>'.
	 * @see cenrep.Repository#getProblems()
	 * @see #getRepository()
	 * @generated
	 */
	EAttribute getRepository_Problems();

	/**
	 * Returns the meta object for class '{@link cenrep.Key <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Key</em>'.
	 * @see cenrep.Key
	 * @generated
	 */
	EClass getKey();

	/**
	 * Returns the meta object for the attribute '{@link cenrep.Key#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see cenrep.Key#getName()
	 * @see #getKey()
	 * @generated
	 */
	EAttribute getKey_Name();

	/**
	 * Returns the meta object for the attribute '{@link cenrep.Key#getIdent <em>Ident</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ident</em>'.
	 * @see cenrep.Key#getIdent()
	 * @see #getKey()
	 * @generated
	 */
	EAttribute getKey_Ident();

	/**
	 * Returns the meta object for the attribute '{@link cenrep.Key#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see cenrep.Key#getType()
	 * @see #getKey()
	 * @generated
	 */
	EAttribute getKey_Type();

	/**
	 * Returns the meta object for the containment reference list '{@link cenrep.Key#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Value</em>'.
	 * @see cenrep.Key#getValue()
	 * @see #getKey()
	 * @generated
	 */
	EReference getKey_Value();

	/**
	 * Returns the meta object for the containment reference list '{@link cenrep.Key#getBits <em>Bits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Bits</em>'.
	 * @see cenrep.Key#getBits()
	 * @see #getKey()
	 * @generated
	 */
	EReference getKey_Bits();

	/**
	 * Returns the meta object for the attribute '{@link cenrep.Key#isBitmaskKey <em>Bitmask Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bitmask Key</em>'.
	 * @see cenrep.Key#isBitmaskKey()
	 * @see #getKey()
	 * @generated
	 */
	EAttribute getKey_BitmaskKey();

	/**
	 * Returns the meta object for the attribute '{@link cenrep.Key#isSimpleKey <em>Simple Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Simple Key</em>'.
	 * @see cenrep.Key#isSimpleKey()
	 * @see #getKey()
	 * @generated
	 */
	EAttribute getKey_SimpleKey();

	/**
	 * Returns the meta object for the attribute '{@link cenrep.Key#getShortIdent <em>Short Ident</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Short Ident</em>'.
	 * @see cenrep.Key#getShortIdent()
	 * @see #getKey()
	 * @generated
	 */
	EAttribute getKey_ShortIdent();

	/**
	 * Returns the meta object for the attribute '{@link cenrep.Key#getStrType <em>Str Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Str Type</em>'.
	 * @see cenrep.Key#getStrType()
	 * @see #getKey()
	 * @generated
	 */
	EAttribute getKey_StrType();

	/**
	 * Returns the meta object for the attribute '{@link cenrep.Key#isDecFormat <em>Dec Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dec Format</em>'.
	 * @see cenrep.Key#isDecFormat()
	 * @see #getKey()
	 * @generated
	 */
	EAttribute getKey_DecFormat();

	/**
	 * Returns the meta object for the attribute '{@link cenrep.Key#isHexFormat <em>Hex Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hex Format</em>'.
	 * @see cenrep.Key#isHexFormat()
	 * @see #getKey()
	 * @generated
	 */
	EAttribute getKey_HexFormat();

	/**
	 * Returns the meta object for class '{@link cenrep.KeyRange <em>Key Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Key Range</em>'.
	 * @see cenrep.KeyRange
	 * @generated
	 */
	EClass getKeyRange();

	/**
	 * Returns the meta object for the attribute '{@link cenrep.KeyRange#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see cenrep.KeyRange#getName()
	 * @see #getKeyRange()
	 * @generated
	 */
	EAttribute getKeyRange_Name();

	/**
	 * Returns the meta object for the attribute '{@link cenrep.KeyRange#getInt <em>Int</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Int</em>'.
	 * @see cenrep.KeyRange#getInt()
	 * @see #getKeyRange()
	 * @generated
	 */
	EAttribute getKeyRange_Int();

	/**
	 * Returns the meta object for the attribute '{@link cenrep.KeyRange#getFirstInt <em>First Int</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>First Int</em>'.
	 * @see cenrep.KeyRange#getFirstInt()
	 * @see #getKeyRange()
	 * @generated
	 */
	EAttribute getKeyRange_FirstInt();

	/**
	 * Returns the meta object for the attribute '{@link cenrep.KeyRange#getLastInt <em>Last Int</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Int</em>'.
	 * @see cenrep.KeyRange#getLastInt()
	 * @see #getKeyRange()
	 * @generated
	 */
	EAttribute getKeyRange_LastInt();

	/**
	 * Returns the meta object for the attribute '{@link cenrep.KeyRange#getIndexBits <em>Index Bits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index Bits</em>'.
	 * @see cenrep.KeyRange#getIndexBits()
	 * @see #getKeyRange()
	 * @generated
	 */
	EAttribute getKeyRange_IndexBits();

	/**
	 * Returns the meta object for the attribute '{@link cenrep.KeyRange#getFirstIndex <em>First Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>First Index</em>'.
	 * @see cenrep.KeyRange#getFirstIndex()
	 * @see #getKeyRange()
	 * @generated
	 */
	EAttribute getKeyRange_FirstIndex();

	/**
	 * Returns the meta object for the attribute '{@link cenrep.KeyRange#getCountInt <em>Count Int</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Count Int</em>'.
	 * @see cenrep.KeyRange#getCountInt()
	 * @see #getKeyRange()
	 * @generated
	 */
	EAttribute getKeyRange_CountInt();

	/**
	 * Returns the meta object for the containment reference list '{@link cenrep.KeyRange#getKeys <em>Keys</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Keys</em>'.
	 * @see cenrep.KeyRange#getKeys()
	 * @see #getKeyRange()
	 * @generated
	 */
	EReference getKeyRange_Keys();

	/**
	 * Returns the meta object for class '{@link cenrep.Access <em>Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Access</em>'.
	 * @see cenrep.Access
	 * @generated
	 */
	EClass getAccess();

	/**
	 * Returns the meta object for the attribute '{@link cenrep.Access#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see cenrep.Access#getType()
	 * @see #getAccess()
	 * @generated
	 */
	EAttribute getAccess_Type();

	/**
	 * Returns the meta object for the attribute '{@link cenrep.Access#getCapabilities <em>Capabilities</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Capabilities</em>'.
	 * @see cenrep.Access#getCapabilities()
	 * @see #getAccess()
	 * @generated
	 */
	EAttribute getAccess_Capabilities();

	/**
	 * Returns the meta object for the attribute '{@link cenrep.Access#getSid <em>Sid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sid</em>'.
	 * @see cenrep.Access#getSid()
	 * @see #getAccess()
	 * @generated
	 */
	EAttribute getAccess_Sid();

	/**
	 * Returns the meta object for the attribute '{@link cenrep.Access#getStrFormat <em>Str Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Str Format</em>'.
	 * @see cenrep.Access#getStrFormat()
	 * @see #getAccess()
	 * @generated
	 */
	EAttribute getAccess_StrFormat();

	/**
	 * Returns the meta object for class '{@link cenrep.Value <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value</em>'.
	 * @see cenrep.Value
	 * @generated
	 */
	EClass getValue();

	/**
	 * Returns the meta object for the attribute '{@link cenrep.Value#getVal <em>Val</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Val</em>'.
	 * @see cenrep.Value#getVal()
	 * @see #getValue()
	 * @generated
	 */
	EAttribute getValue_Val();

	/**
	 * Returns the meta object for the attribute '{@link cenrep.Value#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see cenrep.Value#getId()
	 * @see #getValue()
	 * @generated
	 */
	EAttribute getValue_Id();

	/**
	 * Returns the meta object for class '{@link cenrep.Bit <em>Bit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bit</em>'.
	 * @see cenrep.Bit
	 * @generated
	 */
	EClass getBit();

	/**
	 * Returns the meta object for the attribute '{@link cenrep.Bit#isState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see cenrep.Bit#isState()
	 * @see #getBit()
	 * @generated
	 */
	EAttribute getBit_State();

	/**
	 * Returns the meta object for the attribute '{@link cenrep.Bit#getNumber <em>Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number</em>'.
	 * @see cenrep.Bit#getNumber()
	 * @see #getBit()
	 * @generated
	 */
	EAttribute getBit_Number();

	/**
	 * Returns the meta object for class '{@link cenrep.RVG <em>RVG</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>RVG</em>'.
	 * @see cenrep.RVG
	 * @generated
	 */
	EClass getRVG();

	/**
	 * Returns the meta object for the attribute '{@link cenrep.RVG#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ref</em>'.
	 * @see cenrep.RVG#getRef()
	 * @see #getRVG()
	 * @generated
	 */
	EAttribute getRVG_Ref();

	/**
	 * Returns the meta object for the attribute '{@link cenrep.RVG#getGvalue <em>Gvalue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Gvalue</em>'.
	 * @see cenrep.RVG#getGvalue()
	 * @see #getRVG()
	 * @generated
	 */
	EAttribute getRVG_Gvalue();

	/**
	 * Returns the meta object for the attribute '{@link cenrep.RVG#isRfs <em>Rfs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rfs</em>'.
	 * @see cenrep.RVG#isRfs()
	 * @see #getRVG()
	 * @generated
	 */
	EAttribute getRVG_Rfs();

	/**
	 * Returns the meta object for class '{@link cenrep.AttributeAndDescription <em>Attribute And Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute And Description</em>'.
	 * @see cenrep.AttributeAndDescription
	 * @generated
	 */
	EClass getAttributeAndDescription();

	/**
	 * Returns the meta object for the attribute '{@link cenrep.AttributeAndDescription#getDesc <em>Desc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Desc</em>'.
	 * @see cenrep.AttributeAndDescription#getDesc()
	 * @see #getAttributeAndDescription()
	 * @generated
	 */
	EAttribute getAttributeAndDescription_Desc();

	/**
	 * Returns the meta object for class '{@link cenrep.IReadOnly <em>IRead Only</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IRead Only</em>'.
	 * @see cenrep.IReadOnly
	 * @generated
	 */
	EClass getIReadOnly();

	/**
	 * Returns the meta object for the attribute '{@link cenrep.IReadOnly#isReadOnly <em>Read Only</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Read Only</em>'.
	 * @see cenrep.IReadOnly#isReadOnly()
	 * @see #getIReadOnly()
	 * @generated
	 */
	EAttribute getIReadOnly_ReadOnly();

	/**
	 * Returns the meta object for class '{@link cenrep.IAccessable <em>IAccessable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IAccessable</em>'.
	 * @see cenrep.IAccessable
	 * @generated
	 */
	EClass getIAccessable();

	/**
	 * Returns the meta object for the containment reference list '{@link cenrep.IAccessable#getAccess <em>Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Access</em>'.
	 * @see cenrep.IAccessable#getAccess()
	 * @see #getIAccessable()
	 * @generated
	 */
	EReference getIAccessable_Access();

	/**
	 * Returns the meta object for the reference '{@link cenrep.IAccessable#getReadAccess <em>Read Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Read Access</em>'.
	 * @see cenrep.IAccessable#getReadAccess()
	 * @see #getIAccessable()
	 * @generated
	 */
	EReference getIAccessable_ReadAccess();

	/**
	 * Returns the meta object for the reference '{@link cenrep.IAccessable#getWriteAccess <em>Write Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Write Access</em>'.
	 * @see cenrep.IAccessable#getWriteAccess()
	 * @see #getIAccessable()
	 * @generated
	 */
	EReference getIAccessable_WriteAccess();

	/**
	 * Returns the meta object for the attribute '{@link cenrep.IAccessable#getGAccess <em>GAccess</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>GAccess</em>'.
	 * @see cenrep.IAccessable#getGAccess()
	 * @see #getIAccessable()
	 * @generated
	 */
	EAttribute getIAccessable_GAccess();

	/**
	 * Returns the meta object for class '{@link cenrep.IBackup <em>IBackup</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IBackup</em>'.
	 * @see cenrep.IBackup
	 * @generated
	 */
	EClass getIBackup();

	/**
	 * Returns the meta object for the attribute '{@link cenrep.IBackup#isBackup <em>Backup</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Backup</em>'.
	 * @see cenrep.IBackup#isBackup()
	 * @see #getIBackup()
	 * @generated
	 */
	EAttribute getIBackup_Backup();

	/**
	 * Returns the meta object for enum '{@link cenrep.TYPE <em>TYPE</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>TYPE</em>'.
	 * @see cenrep.TYPE
	 * @generated
	 */
	EEnum getTYPE();

	/**
	 * Returns the meta object for enum '{@link cenrep.ACCESS_TYPE <em>ACCESS TYPE</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>ACCESS TYPE</em>'.
	 * @see cenrep.ACCESS_TYPE
	 * @generated
	 */
	EEnum getACCESS_TYPE();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CenrepFactory getCenrepFactory();

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
	interface Literals  {
		/**
		 * The meta object literal for the '{@link cenrep.impl.CommonAttrsImpl <em>Common Attrs</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cenrep.impl.CommonAttrsImpl
		 * @see cenrep.impl.CenrepPackageImpl#getCommonAttrs()
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
		 * The meta object literal for the '{@link cenrep.impl.MetaImpl <em>Meta</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cenrep.impl.MetaImpl
		 * @see cenrep.impl.CenrepPackageImpl#getMeta()
		 * @generated
		 */
		EClass META = eINSTANCE.getMeta();

		/**
		 * The meta object literal for the '<em><b>Identification</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference META__IDENTIFICATION = eINSTANCE.getMeta_Identification();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference META__DATE = eINSTANCE.getMeta_Date();

		/**
		 * The meta object literal for the '<em><b>Platform</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference META__PLATFORM = eINSTANCE.getMeta_Platform();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference META__OWNER = eINSTANCE.getMeta_Owner();

		/**
		 * The meta object literal for the '<em><b>Editor</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference META__EDITOR = eINSTANCE.getMeta_Editor();

		/**
		 * The meta object literal for the '<em><b>Status</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference META__STATUS = eINSTANCE.getMeta_Status();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference META__VERSION = eINSTANCE.getMeta_Version();

		/**
		 * The meta object literal for the '<em><b>Product</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference META__PRODUCT = eINSTANCE.getMeta_Product();

		/**
		 * The meta object literal for the '<em><b>Release</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference META__RELEASE = eINSTANCE.getMeta_Release();

		/**
		 * The meta object literal for the '{@link cenrep.impl.IdentificationImpl <em>Identification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cenrep.impl.IdentificationImpl
		 * @see cenrep.impl.CenrepPackageImpl#getIdentification()
		 * @generated
		 */
		EClass IDENTIFICATION = eINSTANCE.getIdentification();

		/**
		 * The meta object literal for the '{@link cenrep.impl.DateImpl <em>Date</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cenrep.impl.DateImpl
		 * @see cenrep.impl.CenrepPackageImpl#getDate()
		 * @generated
		 */
		EClass DATE = eINSTANCE.getDate();

		/**
		 * The meta object literal for the '{@link cenrep.impl.OwnerImpl <em>Owner</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cenrep.impl.OwnerImpl
		 * @see cenrep.impl.CenrepPackageImpl#getOwner()
		 * @generated
		 */
		EClass OWNER = eINSTANCE.getOwner();

		/**
		 * The meta object literal for the '{@link cenrep.impl.EditorImpl <em>Editor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cenrep.impl.EditorImpl
		 * @see cenrep.impl.CenrepPackageImpl#getEditor()
		 * @generated
		 */
		EClass EDITOR = eINSTANCE.getEditor();

		/**
		 * The meta object literal for the '{@link cenrep.impl.StatusImpl <em>Status</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cenrep.impl.StatusImpl
		 * @see cenrep.impl.CenrepPackageImpl#getStatus()
		 * @generated
		 */
		EClass STATUS = eINSTANCE.getStatus();

		/**
		 * The meta object literal for the '{@link cenrep.impl.VersionImpl <em>Version</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cenrep.impl.VersionImpl
		 * @see cenrep.impl.CenrepPackageImpl#getVersion()
		 * @generated
		 */
		EClass VERSION = eINSTANCE.getVersion();

		/**
		 * The meta object literal for the '{@link cenrep.impl.PlatformImpl <em>Platform</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cenrep.impl.PlatformImpl
		 * @see cenrep.impl.CenrepPackageImpl#getPlatform()
		 * @generated
		 */
		EClass PLATFORM = eINSTANCE.getPlatform();

		/**
		 * The meta object literal for the '{@link cenrep.impl.ProductImpl <em>Product</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cenrep.impl.ProductImpl
		 * @see cenrep.impl.CenrepPackageImpl#getProduct()
		 * @generated
		 */
		EClass PRODUCT = eINSTANCE.getProduct();

		/**
		 * The meta object literal for the '{@link cenrep.impl.ReleaseImpl <em>Release</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cenrep.impl.ReleaseImpl
		 * @see cenrep.impl.CenrepPackageImpl#getRelease()
		 * @generated
		 */
		EClass RELEASE = eINSTANCE.getRelease();

		/**
		 * The meta object literal for the '{@link cenrep.impl.ContentImpl <em>Content</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cenrep.impl.ContentImpl
		 * @see cenrep.impl.CenrepPackageImpl#getContent()
		 * @generated
		 */
		EClass CONTENT = eINSTANCE.getContent();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTENT__VALUE = eINSTANCE.getContent_Value();

		/**
		 * The meta object literal for the '{@link cenrep.impl.RepositoryImpl <em>Repository</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cenrep.impl.RepositoryImpl
		 * @see cenrep.impl.CenrepPackageImpl#getRepository()
		 * @generated
		 */
		EClass REPOSITORY = eINSTANCE.getRepository();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REPOSITORY__VERSION = eINSTANCE.getRepository_Version();

		/**
		 * The meta object literal for the '<em><b>Uid Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REPOSITORY__UID_NAME = eINSTANCE.getRepository_UidName();

		/**
		 * The meta object literal for the '<em><b>Uid Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REPOSITORY__UID_VALUE = eINSTANCE.getRepository_UidValue();

		/**
		 * The meta object literal for the '<em><b>Initialisation File Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REPOSITORY__INITIALISATION_FILE_VERSION = eINSTANCE.getRepository_InitialisationFileVersion();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REPOSITORY__OWNER = eINSTANCE.getRepository_Owner();

		/**
		 * The meta object literal for the '<em><b>Rfs</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REPOSITORY__RFS = eINSTANCE.getRepository_Rfs();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPOSITORY__KEY = eINSTANCE.getRepository_Key();

		/**
		 * The meta object literal for the '<em><b>Meta</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPOSITORY__META = eINSTANCE.getRepository_Meta();

		/**
		 * The meta object literal for the '<em><b>Simple Keys</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPOSITORY__SIMPLE_KEYS = eINSTANCE.getRepository_SimpleKeys();

		/**
		 * The meta object literal for the '<em><b>Bitmask Keys</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPOSITORY__BITMASK_KEYS = eINSTANCE.getRepository_BitmaskKeys();

		/**
		 * The meta object literal for the '<em><b>Range Key</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPOSITORY__RANGE_KEY = eINSTANCE.getRepository_RangeKey();

		/**
		 * The meta object literal for the '<em><b>File Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REPOSITORY__FILE_NAME = eINSTANCE.getRepository_FileName();

		/**
		 * The meta object literal for the '<em><b>Problems</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REPOSITORY__PROBLEMS = eINSTANCE.getRepository_Problems();

		/**
		 * The meta object literal for the '{@link cenrep.impl.KeyImpl <em>Key</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cenrep.impl.KeyImpl
		 * @see cenrep.impl.CenrepPackageImpl#getKey()
		 * @generated
		 */
		EClass KEY = eINSTANCE.getKey();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KEY__NAME = eINSTANCE.getKey_Name();

		/**
		 * The meta object literal for the '<em><b>Ident</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KEY__IDENT = eINSTANCE.getKey_Ident();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KEY__TYPE = eINSTANCE.getKey_Type();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KEY__VALUE = eINSTANCE.getKey_Value();

		/**
		 * The meta object literal for the '<em><b>Bits</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KEY__BITS = eINSTANCE.getKey_Bits();

		/**
		 * The meta object literal for the '<em><b>Bitmask Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KEY__BITMASK_KEY = eINSTANCE.getKey_BitmaskKey();

		/**
		 * The meta object literal for the '<em><b>Simple Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KEY__SIMPLE_KEY = eINSTANCE.getKey_SimpleKey();

		/**
		 * The meta object literal for the '<em><b>Short Ident</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KEY__SHORT_IDENT = eINSTANCE.getKey_ShortIdent();

		/**
		 * The meta object literal for the '<em><b>Str Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KEY__STR_TYPE = eINSTANCE.getKey_StrType();

		/**
		 * The meta object literal for the '<em><b>Dec Format</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KEY__DEC_FORMAT = eINSTANCE.getKey_DecFormat();

		/**
		 * The meta object literal for the '<em><b>Hex Format</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KEY__HEX_FORMAT = eINSTANCE.getKey_HexFormat();

		/**
		 * The meta object literal for the '{@link cenrep.impl.KeyRangeImpl <em>Key Range</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cenrep.impl.KeyRangeImpl
		 * @see cenrep.impl.CenrepPackageImpl#getKeyRange()
		 * @generated
		 */
		EClass KEY_RANGE = eINSTANCE.getKeyRange();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KEY_RANGE__NAME = eINSTANCE.getKeyRange_Name();

		/**
		 * The meta object literal for the '<em><b>Int</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KEY_RANGE__INT = eINSTANCE.getKeyRange_Int();

		/**
		 * The meta object literal for the '<em><b>First Int</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KEY_RANGE__FIRST_INT = eINSTANCE.getKeyRange_FirstInt();

		/**
		 * The meta object literal for the '<em><b>Last Int</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KEY_RANGE__LAST_INT = eINSTANCE.getKeyRange_LastInt();

		/**
		 * The meta object literal for the '<em><b>Index Bits</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KEY_RANGE__INDEX_BITS = eINSTANCE.getKeyRange_IndexBits();

		/**
		 * The meta object literal for the '<em><b>First Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KEY_RANGE__FIRST_INDEX = eINSTANCE.getKeyRange_FirstIndex();

		/**
		 * The meta object literal for the '<em><b>Count Int</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KEY_RANGE__COUNT_INT = eINSTANCE.getKeyRange_CountInt();

		/**
		 * The meta object literal for the '<em><b>Keys</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KEY_RANGE__KEYS = eINSTANCE.getKeyRange_Keys();

		/**
		 * The meta object literal for the '{@link cenrep.impl.AccessImpl <em>Access</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cenrep.impl.AccessImpl
		 * @see cenrep.impl.CenrepPackageImpl#getAccess()
		 * @generated
		 */
		EClass ACCESS = eINSTANCE.getAccess();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACCESS__TYPE = eINSTANCE.getAccess_Type();

		/**
		 * The meta object literal for the '<em><b>Capabilities</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACCESS__CAPABILITIES = eINSTANCE.getAccess_Capabilities();

		/**
		 * The meta object literal for the '<em><b>Sid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACCESS__SID = eINSTANCE.getAccess_Sid();

		/**
		 * The meta object literal for the '<em><b>Str Format</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACCESS__STR_FORMAT = eINSTANCE.getAccess_StrFormat();

		/**
		 * The meta object literal for the '{@link cenrep.impl.ValueImpl <em>Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cenrep.impl.ValueImpl
		 * @see cenrep.impl.CenrepPackageImpl#getValue()
		 * @generated
		 */
		EClass VALUE = eINSTANCE.getValue();

		/**
		 * The meta object literal for the '<em><b>Val</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALUE__VAL = eINSTANCE.getValue_Val();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALUE__ID = eINSTANCE.getValue_Id();

		/**
		 * The meta object literal for the '{@link cenrep.impl.BitImpl <em>Bit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cenrep.impl.BitImpl
		 * @see cenrep.impl.CenrepPackageImpl#getBit()
		 * @generated
		 */
		EClass BIT = eINSTANCE.getBit();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BIT__STATE = eINSTANCE.getBit_State();

		/**
		 * The meta object literal for the '<em><b>Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BIT__NUMBER = eINSTANCE.getBit_Number();

		/**
		 * The meta object literal for the '{@link cenrep.RVG <em>RVG</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cenrep.RVG
		 * @see cenrep.impl.CenrepPackageImpl#getRVG()
		 * @generated
		 */
		EClass RVG = eINSTANCE.getRVG();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RVG__REF = eINSTANCE.getRVG_Ref();

		/**
		 * The meta object literal for the '<em><b>Gvalue</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RVG__GVALUE = eINSTANCE.getRVG_Gvalue();

		/**
		 * The meta object literal for the '<em><b>Rfs</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RVG__RFS = eINSTANCE.getRVG_Rfs();

		/**
		 * The meta object literal for the '{@link cenrep.impl.AttributeAndDescriptionImpl <em>Attribute And Description</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cenrep.impl.AttributeAndDescriptionImpl
		 * @see cenrep.impl.CenrepPackageImpl#getAttributeAndDescription()
		 * @generated
		 */
		EClass ATTRIBUTE_AND_DESCRIPTION = eINSTANCE.getAttributeAndDescription();

		/**
		 * The meta object literal for the '<em><b>Desc</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_AND_DESCRIPTION__DESC = eINSTANCE.getAttributeAndDescription_Desc();

		/**
		 * The meta object literal for the '{@link cenrep.IReadOnly <em>IRead Only</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cenrep.IReadOnly
		 * @see cenrep.impl.CenrepPackageImpl#getIReadOnly()
		 * @generated
		 */
		EClass IREAD_ONLY = eINSTANCE.getIReadOnly();

		/**
		 * The meta object literal for the '<em><b>Read Only</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IREAD_ONLY__READ_ONLY = eINSTANCE.getIReadOnly_ReadOnly();

		/**
		 * The meta object literal for the '{@link cenrep.IAccessable <em>IAccessable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cenrep.IAccessable
		 * @see cenrep.impl.CenrepPackageImpl#getIAccessable()
		 * @generated
		 */
		EClass IACCESSABLE = eINSTANCE.getIAccessable();

		/**
		 * The meta object literal for the '<em><b>Access</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IACCESSABLE__ACCESS = eINSTANCE.getIAccessable_Access();

		/**
		 * The meta object literal for the '<em><b>Read Access</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IACCESSABLE__READ_ACCESS = eINSTANCE.getIAccessable_ReadAccess();

		/**
		 * The meta object literal for the '<em><b>Write Access</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IACCESSABLE__WRITE_ACCESS = eINSTANCE.getIAccessable_WriteAccess();

		/**
		 * The meta object literal for the '<em><b>GAccess</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IACCESSABLE__GACCESS = eINSTANCE.getIAccessable_GAccess();

		/**
		 * The meta object literal for the '{@link cenrep.IBackup <em>IBackup</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cenrep.IBackup
		 * @see cenrep.impl.CenrepPackageImpl#getIBackup()
		 * @generated
		 */
		EClass IBACKUP = eINSTANCE.getIBackup();

		/**
		 * The meta object literal for the '<em><b>Backup</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IBACKUP__BACKUP = eINSTANCE.getIBackup_Backup();

		/**
		 * The meta object literal for the '{@link cenrep.TYPE <em>TYPE</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cenrep.TYPE
		 * @see cenrep.impl.CenrepPackageImpl#getTYPE()
		 * @generated
		 */
		EEnum TYPE = eINSTANCE.getTYPE();

		/**
		 * The meta object literal for the '{@link cenrep.ACCESS_TYPE <em>ACCESS TYPE</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cenrep.ACCESS_TYPE
		 * @see cenrep.impl.CenrepPackageImpl#getACCESS_TYPE()
		 * @generated
		 */
		EEnum ACCESS_TYPE = eINSTANCE.getACCESS_TYPE();

	}

} //CenrepPackage
