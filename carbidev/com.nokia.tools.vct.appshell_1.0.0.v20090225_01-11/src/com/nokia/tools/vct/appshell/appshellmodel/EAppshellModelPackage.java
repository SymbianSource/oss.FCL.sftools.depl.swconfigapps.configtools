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
 * Description: This file is part of com.nokia.tools.vct.appshell component.
 */

package com.nokia.tools.vct.appshell.appshellmodel;

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
 * @see com.nokia.tools.vct.appshell.appshellmodel.EAppshellModelFactory
 * @model kind="package"
 * @generated
 */
public interface EAppshellModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "appshellmodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:://www.s60.com/xml/applicationshell/1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "appshell";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EAppshellModelPackage eINSTANCE = com.nokia.tools.vct.appshell.appshellmodel.impl.EAppshellModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.appshell.appshellmodel.impl.EAppshellDocumentImpl <em>EAppshell Document</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.appshell.appshellmodel.impl.EAppshellDocumentImpl
	 * @see com.nokia.tools.vct.appshell.appshellmodel.impl.EAppshellModelPackageImpl#getEAppshellDocument()
	 * @generated
	 */
	int EAPPSHELL_DOCUMENT = 0;

	/**
	 * The feature id for the '<em><b>Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EAPPSHELL_DOCUMENT__DATA = 0;

	/**
	 * The number of structural features of the '<em>EAppshell Document</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EAPPSHELL_DOCUMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.appshell.appshellmodel.impl.EFolderElementImpl <em>EFolder Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.appshell.appshellmodel.impl.EFolderElementImpl
	 * @see com.nokia.tools.vct.appshell.appshellmodel.impl.EAppshellModelPackageImpl#getEFolderElement()
	 * @generated
	 */
	int EFOLDER_ELEMENT = 1;

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.appshell.appshellmodel.ELockDescriptor <em>ELock Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.appshell.appshellmodel.ELockDescriptor
	 * @see com.nokia.tools.vct.appshell.appshellmodel.impl.EAppshellModelPackageImpl#getELockDescriptor()
	 * @generated
	 */
	int ELOCK_DESCRIPTOR = 5;

	/**
	 * The feature id for the '<em><b>Lock Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELOCK_DESCRIPTOR__LOCK_NAME = 0;

	/**
	 * The feature id for the '<em><b>Lock Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELOCK_DESCRIPTOR__LOCK_ICON = 1;

	/**
	 * The feature id for the '<em><b>Lock Delete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELOCK_DESCRIPTOR__LOCK_DELETE = 2;

	/**
	 * The feature id for the '<em><b>Lock Organize</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELOCK_DESCRIPTOR__LOCK_ORGANIZE = 3;

	/**
	 * The number of structural features of the '<em>ELock Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELOCK_DESCRIPTOR_FEATURE_COUNT = 4;

	/**
	 * The feature id for the '<em><b>Lock Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFOLDER_ELEMENT__LOCK_NAME = ELOCK_DESCRIPTOR__LOCK_NAME;

	/**
	 * The feature id for the '<em><b>Lock Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFOLDER_ELEMENT__LOCK_ICON = ELOCK_DESCRIPTOR__LOCK_ICON;

	/**
	 * The feature id for the '<em><b>Lock Delete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFOLDER_ELEMENT__LOCK_DELETE = ELOCK_DESCRIPTOR__LOCK_DELETE;

	/**
	 * The feature id for the '<em><b>Lock Organize</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFOLDER_ELEMENT__LOCK_ORGANIZE = ELOCK_DESCRIPTOR__LOCK_ORGANIZE;

	/**
	 * The feature id for the '<em><b>Icon File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFOLDER_ELEMENT__ICON_FILE = ELOCK_DESCRIPTOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>M3g Icon File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFOLDER_ELEMENT__M3G_ICON_FILE = ELOCK_DESCRIPTOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Icon Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFOLDER_ELEMENT__ICON_ID = ELOCK_DESCRIPTOR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Mask Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFOLDER_ELEMENT__MASK_ID = ELOCK_DESCRIPTOR_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Icon Skin Major Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFOLDER_ELEMENT__ICON_SKIN_MAJOR_ID = ELOCK_DESCRIPTOR_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Icon Skin Minor Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFOLDER_ELEMENT__ICON_SKIN_MINOR_ID = ELOCK_DESCRIPTOR_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Hide Change Skin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFOLDER_ELEMENT__HIDE_CHANGE_SKIN = ELOCK_DESCRIPTOR_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Hide Mem Details</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFOLDER_ELEMENT__HIDE_MEM_DETAILS = ELOCK_DESCRIPTOR_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Hide Download</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFOLDER_ELEMENT__HIDE_DOWNLOAD = ELOCK_DESCRIPTOR_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Hide Animated Icons</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFOLDER_ELEMENT__HIDE_ANIMATED_ICONS = ELOCK_DESCRIPTOR_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Title Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFOLDER_ELEMENT__TITLE_NAME = ELOCK_DESCRIPTOR_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Short Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFOLDER_ELEMENT__SHORT_NAME = ELOCK_DESCRIPTOR_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Long Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFOLDER_ELEMENT__LONG_NAME = ELOCK_DESCRIPTOR_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFOLDER_ELEMENT__CONTENTS = ELOCK_DESCRIPTOR_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFOLDER_ELEMENT__DEFAULT = ELOCK_DESCRIPTOR_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Application Group Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFOLDER_ELEMENT__APPLICATION_GROUP_NAME = ELOCK_DESCRIPTOR_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Applications</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFOLDER_ELEMENT__APPLICATIONS = ELOCK_DESCRIPTOR_FEATURE_COUNT + 16;

	/**
	 * The feature id for the '<em><b>Folders</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFOLDER_ELEMENT__FOLDERS = ELOCK_DESCRIPTOR_FEATURE_COUNT + 17;

	/**
	 * The feature id for the '<em><b>Urls</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFOLDER_ELEMENT__URLS = ELOCK_DESCRIPTOR_FEATURE_COUNT + 18;

	/**
	 * The number of structural features of the '<em>EFolder Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFOLDER_ELEMENT_FEATURE_COUNT = ELOCK_DESCRIPTOR_FEATURE_COUNT + 19;

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.appshell.appshellmodel.impl.EApplicationElementImpl <em>EApplication Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.appshell.appshellmodel.impl.EApplicationElementImpl
	 * @see com.nokia.tools.vct.appshell.appshellmodel.impl.EAppshellModelPackageImpl#getEApplicationElement()
	 * @generated
	 */
	int EAPPLICATION_ELEMENT = 2;

	/**
	 * The feature id for the '<em><b>Lock Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EAPPLICATION_ELEMENT__LOCK_NAME = ELOCK_DESCRIPTOR__LOCK_NAME;

	/**
	 * The feature id for the '<em><b>Lock Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EAPPLICATION_ELEMENT__LOCK_ICON = ELOCK_DESCRIPTOR__LOCK_ICON;

	/**
	 * The feature id for the '<em><b>Lock Delete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EAPPLICATION_ELEMENT__LOCK_DELETE = ELOCK_DESCRIPTOR__LOCK_DELETE;

	/**
	 * The feature id for the '<em><b>Lock Organize</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EAPPLICATION_ELEMENT__LOCK_ORGANIZE = ELOCK_DESCRIPTOR__LOCK_ORGANIZE;

	/**
	 * The feature id for the '<em><b>Icon File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EAPPLICATION_ELEMENT__ICON_FILE = ELOCK_DESCRIPTOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>M3g Icon File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EAPPLICATION_ELEMENT__M3G_ICON_FILE = ELOCK_DESCRIPTOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Icon Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EAPPLICATION_ELEMENT__ICON_ID = ELOCK_DESCRIPTOR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Mask Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EAPPLICATION_ELEMENT__MASK_ID = ELOCK_DESCRIPTOR_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Icon Skin Major Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EAPPLICATION_ELEMENT__ICON_SKIN_MAJOR_ID = ELOCK_DESCRIPTOR_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Icon Skin Minor Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EAPPLICATION_ELEMENT__ICON_SKIN_MINOR_ID = ELOCK_DESCRIPTOR_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Hide Change Skin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EAPPLICATION_ELEMENT__HIDE_CHANGE_SKIN = ELOCK_DESCRIPTOR_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Hide Mem Details</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EAPPLICATION_ELEMENT__HIDE_MEM_DETAILS = ELOCK_DESCRIPTOR_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Hide Download</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EAPPLICATION_ELEMENT__HIDE_DOWNLOAD = ELOCK_DESCRIPTOR_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Hide Animated Icons</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EAPPLICATION_ELEMENT__HIDE_ANIMATED_ICONS = ELOCK_DESCRIPTOR_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Title Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EAPPLICATION_ELEMENT__TITLE_NAME = ELOCK_DESCRIPTOR_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Short Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EAPPLICATION_ELEMENT__SHORT_NAME = ELOCK_DESCRIPTOR_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Long Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EAPPLICATION_ELEMENT__LONG_NAME = ELOCK_DESCRIPTOR_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Uid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EAPPLICATION_ELEMENT__UID = ELOCK_DESCRIPTOR_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>View</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EAPPLICATION_ELEMENT__VIEW = ELOCK_DESCRIPTOR_FEATURE_COUNT + 14;

	/**
	 * The number of structural features of the '<em>EApplication Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EAPPLICATION_ELEMENT_FEATURE_COUNT = ELOCK_DESCRIPTOR_FEATURE_COUNT + 15;

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.appshell.appshellmodel.impl.EURLElementImpl <em>EURL Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.appshell.appshellmodel.impl.EURLElementImpl
	 * @see com.nokia.tools.vct.appshell.appshellmodel.impl.EAppshellModelPackageImpl#getEURLElement()
	 * @generated
	 */
	int EURL_ELEMENT = 3;

	/**
	 * The feature id for the '<em><b>Lock Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EURL_ELEMENT__LOCK_NAME = ELOCK_DESCRIPTOR__LOCK_NAME;

	/**
	 * The feature id for the '<em><b>Lock Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EURL_ELEMENT__LOCK_ICON = ELOCK_DESCRIPTOR__LOCK_ICON;

	/**
	 * The feature id for the '<em><b>Lock Delete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EURL_ELEMENT__LOCK_DELETE = ELOCK_DESCRIPTOR__LOCK_DELETE;

	/**
	 * The feature id for the '<em><b>Lock Organize</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EURL_ELEMENT__LOCK_ORGANIZE = ELOCK_DESCRIPTOR__LOCK_ORGANIZE;

	/**
	 * The feature id for the '<em><b>Icon File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EURL_ELEMENT__ICON_FILE = ELOCK_DESCRIPTOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>M3g Icon File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EURL_ELEMENT__M3G_ICON_FILE = ELOCK_DESCRIPTOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Icon Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EURL_ELEMENT__ICON_ID = ELOCK_DESCRIPTOR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Mask Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EURL_ELEMENT__MASK_ID = ELOCK_DESCRIPTOR_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Icon Skin Major Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EURL_ELEMENT__ICON_SKIN_MAJOR_ID = ELOCK_DESCRIPTOR_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Icon Skin Minor Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EURL_ELEMENT__ICON_SKIN_MINOR_ID = ELOCK_DESCRIPTOR_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Hide Change Skin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EURL_ELEMENT__HIDE_CHANGE_SKIN = ELOCK_DESCRIPTOR_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Hide Mem Details</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EURL_ELEMENT__HIDE_MEM_DETAILS = ELOCK_DESCRIPTOR_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Hide Download</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EURL_ELEMENT__HIDE_DOWNLOAD = ELOCK_DESCRIPTOR_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Hide Animated Icons</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EURL_ELEMENT__HIDE_ANIMATED_ICONS = ELOCK_DESCRIPTOR_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Title Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EURL_ELEMENT__TITLE_NAME = ELOCK_DESCRIPTOR_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Short Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EURL_ELEMENT__SHORT_NAME = ELOCK_DESCRIPTOR_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Long Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EURL_ELEMENT__LONG_NAME = ELOCK_DESCRIPTOR_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EURL_ELEMENT__URL = ELOCK_DESCRIPTOR_FEATURE_COUNT + 13;

	/**
	 * The number of structural features of the '<em>EURL Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EURL_ELEMENT_FEATURE_COUNT = ELOCK_DESCRIPTOR_FEATURE_COUNT + 14;

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.appshell.appshellmodel.impl.EDataElementImpl <em>EData Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.appshell.appshellmodel.impl.EDataElementImpl
	 * @see com.nokia.tools.vct.appshell.appshellmodel.impl.EAppshellModelPackageImpl#getEDataElement()
	 * @generated
	 */
	int EDATA_ELEMENT = 4;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDATA_ELEMENT__VERSION = 0;

	/**
	 * The feature id for the '<em><b>Folder</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDATA_ELEMENT__FOLDER = 1;

	/**
	 * The number of structural features of the '<em>EData Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDATA_ELEMENT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.appshell.appshellmodel.EIconDescriptor <em>EIcon Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EIconDescriptor
	 * @see com.nokia.tools.vct.appshell.appshellmodel.impl.EAppshellModelPackageImpl#getEIconDescriptor()
	 * @generated
	 */
	int EICON_DESCRIPTOR = 6;

	/**
	 * The feature id for the '<em><b>Icon File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EICON_DESCRIPTOR__ICON_FILE = 0;

	/**
	 * The feature id for the '<em><b>M3g Icon File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EICON_DESCRIPTOR__M3G_ICON_FILE = 1;

	/**
	 * The feature id for the '<em><b>Icon Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EICON_DESCRIPTOR__ICON_ID = 2;

	/**
	 * The feature id for the '<em><b>Mask Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EICON_DESCRIPTOR__MASK_ID = 3;

	/**
	 * The feature id for the '<em><b>Icon Skin Major Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EICON_DESCRIPTOR__ICON_SKIN_MAJOR_ID = 4;

	/**
	 * The feature id for the '<em><b>Icon Skin Minor Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EICON_DESCRIPTOR__ICON_SKIN_MINOR_ID = 5;

	/**
	 * The number of structural features of the '<em>EIcon Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EICON_DESCRIPTOR_FEATURE_COUNT = 6;


	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.appshell.appshellmodel.EHideDescriptor <em>EHide Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EHideDescriptor
	 * @see com.nokia.tools.vct.appshell.appshellmodel.impl.EAppshellModelPackageImpl#getEHideDescriptor()
	 * @generated
	 */
	int EHIDE_DESCRIPTOR = 7;

	/**
	 * The feature id for the '<em><b>Hide Change Skin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EHIDE_DESCRIPTOR__HIDE_CHANGE_SKIN = 0;

	/**
	 * The feature id for the '<em><b>Hide Mem Details</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EHIDE_DESCRIPTOR__HIDE_MEM_DETAILS = 1;

	/**
	 * The feature id for the '<em><b>Hide Download</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EHIDE_DESCRIPTOR__HIDE_DOWNLOAD = 2;

	/**
	 * The feature id for the '<em><b>Hide Animated Icons</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EHIDE_DESCRIPTOR__HIDE_ANIMATED_ICONS = 3;

	/**
	 * The number of structural features of the '<em>EHide Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EHIDE_DESCRIPTOR_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.appshell.appshellmodel.ENameDescriptor <em>EName Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.appshell.appshellmodel.ENameDescriptor
	 * @see com.nokia.tools.vct.appshell.appshellmodel.impl.EAppshellModelPackageImpl#getENameDescriptor()
	 * @generated
	 */
	int ENAME_DESCRIPTOR = 8;

	/**
	 * The feature id for the '<em><b>Title Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENAME_DESCRIPTOR__TITLE_NAME = 0;

	/**
	 * The feature id for the '<em><b>Short Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENAME_DESCRIPTOR__SHORT_NAME = 1;

	/**
	 * The feature id for the '<em><b>Long Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENAME_DESCRIPTOR__LONG_NAME = 2;

	/**
	 * The number of structural features of the '<em>EName Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENAME_DESCRIPTOR_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.appshell.appshellmodel.EBooleanFlag <em>EBoolean Flag</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EBooleanFlag
	 * @see com.nokia.tools.vct.appshell.appshellmodel.impl.EAppshellModelPackageImpl#getEBooleanFlag()
	 * @generated
	 */
	int EBOOLEAN_FLAG = 9;


	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.appshell.appshellmodel.EAppshellDocument <em>EAppshell Document</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EAppshell Document</em>'.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EAppshellDocument
	 * @generated
	 */
	EClass getEAppshellDocument();

	/**
	 * Returns the meta object for the containment reference '{@link com.nokia.tools.vct.appshell.appshellmodel.EAppshellDocument#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Data</em>'.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EAppshellDocument#getData()
	 * @see #getEAppshellDocument()
	 * @generated
	 */
	EReference getEAppshellDocument_Data();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.appshell.appshellmodel.EFolderElement <em>EFolder Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EFolder Element</em>'.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EFolderElement
	 * @generated
	 */
	EClass getEFolderElement();

	/**
	 * Returns the meta object for the attribute list '{@link com.nokia.tools.vct.appshell.appshellmodel.EFolderElement#getContents <em>Contents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Contents</em>'.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EFolderElement#getContents()
	 * @see #getEFolderElement()
	 * @generated
	 */
	EAttribute getEFolderElement_Contents();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.appshell.appshellmodel.EFolderElement#getDefault <em>Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default</em>'.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EFolderElement#getDefault()
	 * @see #getEFolderElement()
	 * @generated
	 */
	EAttribute getEFolderElement_Default();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.appshell.appshellmodel.EFolderElement#getApplicationGroupName <em>Application Group Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Application Group Name</em>'.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EFolderElement#getApplicationGroupName()
	 * @see #getEFolderElement()
	 * @generated
	 */
	EAttribute getEFolderElement_ApplicationGroupName();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.vct.appshell.appshellmodel.EFolderElement#getApplications <em>Applications</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Applications</em>'.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EFolderElement#getApplications()
	 * @see #getEFolderElement()
	 * @generated
	 */
	EReference getEFolderElement_Applications();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.vct.appshell.appshellmodel.EFolderElement#getFolders <em>Folders</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Folders</em>'.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EFolderElement#getFolders()
	 * @see #getEFolderElement()
	 * @generated
	 */
	EReference getEFolderElement_Folders();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.vct.appshell.appshellmodel.EFolderElement#getUrls <em>Urls</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Urls</em>'.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EFolderElement#getUrls()
	 * @see #getEFolderElement()
	 * @generated
	 */
	EReference getEFolderElement_Urls();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.appshell.appshellmodel.EApplicationElement <em>EApplication Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EApplication Element</em>'.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EApplicationElement
	 * @generated
	 */
	EClass getEApplicationElement();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.appshell.appshellmodel.EApplicationElement#getUid <em>Uid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uid</em>'.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EApplicationElement#getUid()
	 * @see #getEApplicationElement()
	 * @generated
	 */
	EAttribute getEApplicationElement_Uid();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.appshell.appshellmodel.EApplicationElement#getView <em>View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>View</em>'.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EApplicationElement#getView()
	 * @see #getEApplicationElement()
	 * @generated
	 */
	EAttribute getEApplicationElement_View();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.appshell.appshellmodel.EURLElement <em>EURL Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EURL Element</em>'.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EURLElement
	 * @generated
	 */
	EClass getEURLElement();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.appshell.appshellmodel.EURLElement#getUrl <em>Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Url</em>'.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EURLElement#getUrl()
	 * @see #getEURLElement()
	 * @generated
	 */
	EAttribute getEURLElement_Url();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.appshell.appshellmodel.EDataElement <em>EData Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EData Element</em>'.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EDataElement
	 * @generated
	 */
	EClass getEDataElement();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.appshell.appshellmodel.EDataElement#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EDataElement#getVersion()
	 * @see #getEDataElement()
	 * @generated
	 */
	EAttribute getEDataElement_Version();

	/**
	 * Returns the meta object for the containment reference '{@link com.nokia.tools.vct.appshell.appshellmodel.EDataElement#getFolder <em>Folder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Folder</em>'.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EDataElement#getFolder()
	 * @see #getEDataElement()
	 * @generated
	 */
	EReference getEDataElement_Folder();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.appshell.appshellmodel.ELockDescriptor <em>ELock Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ELock Descriptor</em>'.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.ELockDescriptor
	 * @generated
	 */
	EClass getELockDescriptor();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.appshell.appshellmodel.ELockDescriptor#getLockName <em>Lock Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lock Name</em>'.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.ELockDescriptor#getLockName()
	 * @see #getELockDescriptor()
	 * @generated
	 */
	EAttribute getELockDescriptor_LockName();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.appshell.appshellmodel.ELockDescriptor#getLockIcon <em>Lock Icon</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lock Icon</em>'.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.ELockDescriptor#getLockIcon()
	 * @see #getELockDescriptor()
	 * @generated
	 */
	EAttribute getELockDescriptor_LockIcon();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.appshell.appshellmodel.ELockDescriptor#getLockDelete <em>Lock Delete</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lock Delete</em>'.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.ELockDescriptor#getLockDelete()
	 * @see #getELockDescriptor()
	 * @generated
	 */
	EAttribute getELockDescriptor_LockDelete();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.appshell.appshellmodel.ELockDescriptor#getLockOrganize <em>Lock Organize</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lock Organize</em>'.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.ELockDescriptor#getLockOrganize()
	 * @see #getELockDescriptor()
	 * @generated
	 */
	EAttribute getELockDescriptor_LockOrganize();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.appshell.appshellmodel.EIconDescriptor <em>EIcon Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EIcon Descriptor</em>'.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EIconDescriptor
	 * @generated
	 */
	EClass getEIconDescriptor();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.appshell.appshellmodel.EIconDescriptor#getIconFile <em>Icon File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Icon File</em>'.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EIconDescriptor#getIconFile()
	 * @see #getEIconDescriptor()
	 * @generated
	 */
	EAttribute getEIconDescriptor_IconFile();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.appshell.appshellmodel.EIconDescriptor#getM3gIconFile <em>M3g Icon File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>M3g Icon File</em>'.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EIconDescriptor#getM3gIconFile()
	 * @see #getEIconDescriptor()
	 * @generated
	 */
	EAttribute getEIconDescriptor_M3gIconFile();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.appshell.appshellmodel.EIconDescriptor#getIconId <em>Icon Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Icon Id</em>'.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EIconDescriptor#getIconId()
	 * @see #getEIconDescriptor()
	 * @generated
	 */
	EAttribute getEIconDescriptor_IconId();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.appshell.appshellmodel.EIconDescriptor#getMaskId <em>Mask Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mask Id</em>'.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EIconDescriptor#getMaskId()
	 * @see #getEIconDescriptor()
	 * @generated
	 */
	EAttribute getEIconDescriptor_MaskId();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.appshell.appshellmodel.EIconDescriptor#getIconSkinMajorId <em>Icon Skin Major Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Icon Skin Major Id</em>'.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EIconDescriptor#getIconSkinMajorId()
	 * @see #getEIconDescriptor()
	 * @generated
	 */
	EAttribute getEIconDescriptor_IconSkinMajorId();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.appshell.appshellmodel.EIconDescriptor#getIconSkinMinorId <em>Icon Skin Minor Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Icon Skin Minor Id</em>'.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EIconDescriptor#getIconSkinMinorId()
	 * @see #getEIconDescriptor()
	 * @generated
	 */
	EAttribute getEIconDescriptor_IconSkinMinorId();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.appshell.appshellmodel.EHideDescriptor <em>EHide Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EHide Descriptor</em>'.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EHideDescriptor
	 * @generated
	 */
	EClass getEHideDescriptor();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.appshell.appshellmodel.EHideDescriptor#getHideChangeSkin <em>Hide Change Skin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hide Change Skin</em>'.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EHideDescriptor#getHideChangeSkin()
	 * @see #getEHideDescriptor()
	 * @generated
	 */
	EAttribute getEHideDescriptor_HideChangeSkin();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.appshell.appshellmodel.EHideDescriptor#getHideMemDetails <em>Hide Mem Details</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hide Mem Details</em>'.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EHideDescriptor#getHideMemDetails()
	 * @see #getEHideDescriptor()
	 * @generated
	 */
	EAttribute getEHideDescriptor_HideMemDetails();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.appshell.appshellmodel.EHideDescriptor#getHideDownload <em>Hide Download</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hide Download</em>'.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EHideDescriptor#getHideDownload()
	 * @see #getEHideDescriptor()
	 * @generated
	 */
	EAttribute getEHideDescriptor_HideDownload();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.appshell.appshellmodel.EHideDescriptor#getHideAnimatedIcons <em>Hide Animated Icons</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hide Animated Icons</em>'.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EHideDescriptor#getHideAnimatedIcons()
	 * @see #getEHideDescriptor()
	 * @generated
	 */
	EAttribute getEHideDescriptor_HideAnimatedIcons();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.appshell.appshellmodel.ENameDescriptor <em>EName Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EName Descriptor</em>'.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.ENameDescriptor
	 * @generated
	 */
	EClass getENameDescriptor();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.appshell.appshellmodel.ENameDescriptor#getTitleName <em>Title Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title Name</em>'.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.ENameDescriptor#getTitleName()
	 * @see #getENameDescriptor()
	 * @generated
	 */
	EAttribute getENameDescriptor_TitleName();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.appshell.appshellmodel.ENameDescriptor#getShortName <em>Short Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Short Name</em>'.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.ENameDescriptor#getShortName()
	 * @see #getENameDescriptor()
	 * @generated
	 */
	EAttribute getENameDescriptor_ShortName();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.appshell.appshellmodel.ENameDescriptor#getLongName <em>Long Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Long Name</em>'.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.ENameDescriptor#getLongName()
	 * @see #getENameDescriptor()
	 * @generated
	 */
	EAttribute getENameDescriptor_LongName();

	/**
	 * Returns the meta object for enum '{@link com.nokia.tools.vct.appshell.appshellmodel.EBooleanFlag <em>EBoolean Flag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EBoolean Flag</em>'.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EBooleanFlag
	 * @generated
	 */
	EEnum getEBooleanFlag();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EAppshellModelFactory getEAppshellModelFactory();

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
		 * The meta object literal for the '{@link com.nokia.tools.vct.appshell.appshellmodel.impl.EAppshellDocumentImpl <em>EAppshell Document</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.appshell.appshellmodel.impl.EAppshellDocumentImpl
		 * @see com.nokia.tools.vct.appshell.appshellmodel.impl.EAppshellModelPackageImpl#getEAppshellDocument()
		 * @generated
		 */
		EClass EAPPSHELL_DOCUMENT = eINSTANCE.getEAppshellDocument();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EAPPSHELL_DOCUMENT__DATA = eINSTANCE.getEAppshellDocument_Data();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.appshell.appshellmodel.impl.EFolderElementImpl <em>EFolder Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.appshell.appshellmodel.impl.EFolderElementImpl
		 * @see com.nokia.tools.vct.appshell.appshellmodel.impl.EAppshellModelPackageImpl#getEFolderElement()
		 * @generated
		 */
		EClass EFOLDER_ELEMENT = eINSTANCE.getEFolderElement();

		/**
		 * The meta object literal for the '<em><b>Contents</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EFOLDER_ELEMENT__CONTENTS = eINSTANCE.getEFolderElement_Contents();

		/**
		 * The meta object literal for the '<em><b>Default</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EFOLDER_ELEMENT__DEFAULT = eINSTANCE.getEFolderElement_Default();

		/**
		 * The meta object literal for the '<em><b>Application Group Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EFOLDER_ELEMENT__APPLICATION_GROUP_NAME = eINSTANCE.getEFolderElement_ApplicationGroupName();

		/**
		 * The meta object literal for the '<em><b>Applications</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EFOLDER_ELEMENT__APPLICATIONS = eINSTANCE.getEFolderElement_Applications();

		/**
		 * The meta object literal for the '<em><b>Folders</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EFOLDER_ELEMENT__FOLDERS = eINSTANCE.getEFolderElement_Folders();

		/**
		 * The meta object literal for the '<em><b>Urls</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EFOLDER_ELEMENT__URLS = eINSTANCE.getEFolderElement_Urls();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.appshell.appshellmodel.impl.EApplicationElementImpl <em>EApplication Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.appshell.appshellmodel.impl.EApplicationElementImpl
		 * @see com.nokia.tools.vct.appshell.appshellmodel.impl.EAppshellModelPackageImpl#getEApplicationElement()
		 * @generated
		 */
		EClass EAPPLICATION_ELEMENT = eINSTANCE.getEApplicationElement();

		/**
		 * The meta object literal for the '<em><b>Uid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EAPPLICATION_ELEMENT__UID = eINSTANCE.getEApplicationElement_Uid();

		/**
		 * The meta object literal for the '<em><b>View</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EAPPLICATION_ELEMENT__VIEW = eINSTANCE.getEApplicationElement_View();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.appshell.appshellmodel.impl.EURLElementImpl <em>EURL Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.appshell.appshellmodel.impl.EURLElementImpl
		 * @see com.nokia.tools.vct.appshell.appshellmodel.impl.EAppshellModelPackageImpl#getEURLElement()
		 * @generated
		 */
		EClass EURL_ELEMENT = eINSTANCE.getEURLElement();

		/**
		 * The meta object literal for the '<em><b>Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EURL_ELEMENT__URL = eINSTANCE.getEURLElement_Url();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.appshell.appshellmodel.impl.EDataElementImpl <em>EData Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.appshell.appshellmodel.impl.EDataElementImpl
		 * @see com.nokia.tools.vct.appshell.appshellmodel.impl.EAppshellModelPackageImpl#getEDataElement()
		 * @generated
		 */
		EClass EDATA_ELEMENT = eINSTANCE.getEDataElement();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDATA_ELEMENT__VERSION = eINSTANCE.getEDataElement_Version();

		/**
		 * The meta object literal for the '<em><b>Folder</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDATA_ELEMENT__FOLDER = eINSTANCE.getEDataElement_Folder();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.appshell.appshellmodel.ELockDescriptor <em>ELock Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.appshell.appshellmodel.ELockDescriptor
		 * @see com.nokia.tools.vct.appshell.appshellmodel.impl.EAppshellModelPackageImpl#getELockDescriptor()
		 * @generated
		 */
		EClass ELOCK_DESCRIPTOR = eINSTANCE.getELockDescriptor();

		/**
		 * The meta object literal for the '<em><b>Lock Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELOCK_DESCRIPTOR__LOCK_NAME = eINSTANCE.getELockDescriptor_LockName();

		/**
		 * The meta object literal for the '<em><b>Lock Icon</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELOCK_DESCRIPTOR__LOCK_ICON = eINSTANCE.getELockDescriptor_LockIcon();

		/**
		 * The meta object literal for the '<em><b>Lock Delete</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELOCK_DESCRIPTOR__LOCK_DELETE = eINSTANCE.getELockDescriptor_LockDelete();

		/**
		 * The meta object literal for the '<em><b>Lock Organize</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELOCK_DESCRIPTOR__LOCK_ORGANIZE = eINSTANCE.getELockDescriptor_LockOrganize();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.appshell.appshellmodel.EIconDescriptor <em>EIcon Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.appshell.appshellmodel.EIconDescriptor
		 * @see com.nokia.tools.vct.appshell.appshellmodel.impl.EAppshellModelPackageImpl#getEIconDescriptor()
		 * @generated
		 */
		EClass EICON_DESCRIPTOR = eINSTANCE.getEIconDescriptor();

		/**
		 * The meta object literal for the '<em><b>Icon File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EICON_DESCRIPTOR__ICON_FILE = eINSTANCE.getEIconDescriptor_IconFile();

		/**
		 * The meta object literal for the '<em><b>M3g Icon File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EICON_DESCRIPTOR__M3G_ICON_FILE = eINSTANCE.getEIconDescriptor_M3gIconFile();

		/**
		 * The meta object literal for the '<em><b>Icon Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EICON_DESCRIPTOR__ICON_ID = eINSTANCE.getEIconDescriptor_IconId();

		/**
		 * The meta object literal for the '<em><b>Mask Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EICON_DESCRIPTOR__MASK_ID = eINSTANCE.getEIconDescriptor_MaskId();

		/**
		 * The meta object literal for the '<em><b>Icon Skin Major Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EICON_DESCRIPTOR__ICON_SKIN_MAJOR_ID = eINSTANCE.getEIconDescriptor_IconSkinMajorId();

		/**
		 * The meta object literal for the '<em><b>Icon Skin Minor Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EICON_DESCRIPTOR__ICON_SKIN_MINOR_ID = eINSTANCE.getEIconDescriptor_IconSkinMinorId();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.appshell.appshellmodel.EHideDescriptor <em>EHide Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.appshell.appshellmodel.EHideDescriptor
		 * @see com.nokia.tools.vct.appshell.appshellmodel.impl.EAppshellModelPackageImpl#getEHideDescriptor()
		 * @generated
		 */
		EClass EHIDE_DESCRIPTOR = eINSTANCE.getEHideDescriptor();

		/**
		 * The meta object literal for the '<em><b>Hide Change Skin</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EHIDE_DESCRIPTOR__HIDE_CHANGE_SKIN = eINSTANCE.getEHideDescriptor_HideChangeSkin();

		/**
		 * The meta object literal for the '<em><b>Hide Mem Details</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EHIDE_DESCRIPTOR__HIDE_MEM_DETAILS = eINSTANCE.getEHideDescriptor_HideMemDetails();

		/**
		 * The meta object literal for the '<em><b>Hide Download</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EHIDE_DESCRIPTOR__HIDE_DOWNLOAD = eINSTANCE.getEHideDescriptor_HideDownload();

		/**
		 * The meta object literal for the '<em><b>Hide Animated Icons</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EHIDE_DESCRIPTOR__HIDE_ANIMATED_ICONS = eINSTANCE.getEHideDescriptor_HideAnimatedIcons();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.appshell.appshellmodel.ENameDescriptor <em>EName Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.appshell.appshellmodel.ENameDescriptor
		 * @see com.nokia.tools.vct.appshell.appshellmodel.impl.EAppshellModelPackageImpl#getENameDescriptor()
		 * @generated
		 */
		EClass ENAME_DESCRIPTOR = eINSTANCE.getENameDescriptor();

		/**
		 * The meta object literal for the '<em><b>Title Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENAME_DESCRIPTOR__TITLE_NAME = eINSTANCE.getENameDescriptor_TitleName();

		/**
		 * The meta object literal for the '<em><b>Short Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENAME_DESCRIPTOR__SHORT_NAME = eINSTANCE.getENameDescriptor_ShortName();

		/**
		 * The meta object literal for the '<em><b>Long Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENAME_DESCRIPTOR__LONG_NAME = eINSTANCE.getENameDescriptor_LongName();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.appshell.appshellmodel.EBooleanFlag <em>EBoolean Flag</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.appshell.appshellmodel.EBooleanFlag
		 * @see com.nokia.tools.vct.appshell.appshellmodel.impl.EAppshellModelPackageImpl#getEBooleanFlag()
		 * @generated
		 */
		EEnum EBOOLEAN_FLAG = eINSTANCE.getEBooleanFlag();

	}

} //EAppshellModelPackage
