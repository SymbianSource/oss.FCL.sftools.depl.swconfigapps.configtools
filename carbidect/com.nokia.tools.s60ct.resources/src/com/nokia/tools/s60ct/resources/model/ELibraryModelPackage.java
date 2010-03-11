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
 * Description: This file is part of com.nokia.tools.variant.resourcelibrary component.
 */

package com.nokia.tools.s60ct.resources.model;

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
 * @see com.nokia.tools.s60ct.resources.model.ELibraryModelFactory
 * @model kind="package"
 * @generated
 */
public interface ELibraryModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.nokia.com/xml/ns/confml-core/resourcelibrary";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "model";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ELibraryModelPackage eINSTANCE = com.nokia.tools.s60ct.resources.model.impl.ELibraryModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.nokia.tools.s60ct.resources.model.impl.ELibraryElementImpl <em>ELibrary Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.s60ct.resources.model.impl.ELibraryElementImpl
	 * @see com.nokia.tools.s60ct.resources.model.impl.ELibraryModelPackageImpl#getELibraryElement()
	 * @generated
	 */
	int ELIBRARY_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELIBRARY_ELEMENT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Settings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELIBRARY_ELEMENT__SETTINGS = 1;

	/**
	 * The feature id for the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELIBRARY_ELEMENT__READ_ONLY = 2;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELIBRARY_ELEMENT__NOTE = 3;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELIBRARY_ELEMENT__TIMESTAMP = 4;

	/**
	 * The feature id for the '<em><b>Path2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELIBRARY_ELEMENT__PATH2 = 5;

	/**
	 * The feature id for the '<em><b>Resource From Top Layer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELIBRARY_ELEMENT__RESOURCE_FROM_TOP_LAYER = 6;

	/**
	 * The number of structural features of the '<em>ELibrary Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELIBRARY_ELEMENT_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link com.nokia.tools.s60ct.resources.model.impl.ELibraryDirectoryImpl <em>ELibrary Directory</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.s60ct.resources.model.impl.ELibraryDirectoryImpl
	 * @see com.nokia.tools.s60ct.resources.model.impl.ELibraryModelPackageImpl#getELibraryDirectory()
	 * @generated
	 */
	int ELIBRARY_DIRECTORY = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELIBRARY_DIRECTORY__NAME = ELIBRARY_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Settings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELIBRARY_DIRECTORY__SETTINGS = ELIBRARY_ELEMENT__SETTINGS;

	/**
	 * The feature id for the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELIBRARY_DIRECTORY__READ_ONLY = ELIBRARY_ELEMENT__READ_ONLY;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELIBRARY_DIRECTORY__NOTE = ELIBRARY_ELEMENT__NOTE;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELIBRARY_DIRECTORY__TIMESTAMP = ELIBRARY_ELEMENT__TIMESTAMP;

	/**
	 * The feature id for the '<em><b>Path2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELIBRARY_DIRECTORY__PATH2 = ELIBRARY_ELEMENT__PATH2;

	/**
	 * The feature id for the '<em><b>Resource From Top Layer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELIBRARY_DIRECTORY__RESOURCE_FROM_TOP_LAYER = ELIBRARY_ELEMENT__RESOURCE_FROM_TOP_LAYER;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELIBRARY_DIRECTORY__CHILDREN = ELIBRARY_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>ELibrary Directory</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELIBRARY_DIRECTORY_FEATURE_COUNT = ELIBRARY_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.nokia.tools.s60ct.resources.model.impl.ELibraryFileImpl <em>ELibrary File</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.s60ct.resources.model.impl.ELibraryFileImpl
	 * @see com.nokia.tools.s60ct.resources.model.impl.ELibraryModelPackageImpl#getELibraryFile()
	 * @generated
	 */
	int ELIBRARY_FILE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELIBRARY_FILE__NAME = ELIBRARY_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Settings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELIBRARY_FILE__SETTINGS = ELIBRARY_ELEMENT__SETTINGS;

	/**
	 * The feature id for the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELIBRARY_FILE__READ_ONLY = ELIBRARY_ELEMENT__READ_ONLY;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELIBRARY_FILE__NOTE = ELIBRARY_ELEMENT__NOTE;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELIBRARY_FILE__TIMESTAMP = ELIBRARY_ELEMENT__TIMESTAMP;

	/**
	 * The feature id for the '<em><b>Path2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELIBRARY_FILE__PATH2 = ELIBRARY_ELEMENT__PATH2;

	/**
	 * The feature id for the '<em><b>Resource From Top Layer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELIBRARY_FILE__RESOURCE_FROM_TOP_LAYER = ELIBRARY_ELEMENT__RESOURCE_FROM_TOP_LAYER;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELIBRARY_FILE__SIZE = ELIBRARY_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Content Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELIBRARY_FILE__CONTENT_DESCRIPTION = ELIBRARY_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Default Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELIBRARY_FILE__DEFAULT_RESOURCE = ELIBRARY_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>ELibrary File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELIBRARY_FILE_FEATURE_COUNT = ELIBRARY_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.nokia.tools.s60ct.resources.model.impl.ELibraryRootImpl <em>ELibrary Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.s60ct.resources.model.impl.ELibraryRootImpl
	 * @see com.nokia.tools.s60ct.resources.model.impl.ELibraryModelPackageImpl#getELibraryRoot()
	 * @generated
	 */
	int ELIBRARY_ROOT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELIBRARY_ROOT__NAME = ELIBRARY_DIRECTORY__NAME;

	/**
	 * The feature id for the '<em><b>Settings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELIBRARY_ROOT__SETTINGS = ELIBRARY_DIRECTORY__SETTINGS;

	/**
	 * The feature id for the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELIBRARY_ROOT__READ_ONLY = ELIBRARY_DIRECTORY__READ_ONLY;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELIBRARY_ROOT__NOTE = ELIBRARY_DIRECTORY__NOTE;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELIBRARY_ROOT__TIMESTAMP = ELIBRARY_DIRECTORY__TIMESTAMP;

	/**
	 * The feature id for the '<em><b>Path2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELIBRARY_ROOT__PATH2 = ELIBRARY_DIRECTORY__PATH2;

	/**
	 * The feature id for the '<em><b>Resource From Top Layer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELIBRARY_ROOT__RESOURCE_FROM_TOP_LAYER = ELIBRARY_DIRECTORY__RESOURCE_FROM_TOP_LAYER;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELIBRARY_ROOT__CHILDREN = ELIBRARY_DIRECTORY__CHILDREN;

	/**
	 * The feature id for the '<em><b>Temp Dir Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELIBRARY_ROOT__TEMP_DIR_PATH = ELIBRARY_DIRECTORY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>ELibrary Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELIBRARY_ROOT_FEATURE_COUNT = ELIBRARY_DIRECTORY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.nokia.tools.s60ct.resources.model.impl.ELibraryThemeFileImpl <em>ELibrary Theme File</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.s60ct.resources.model.impl.ELibraryThemeFileImpl
	 * @see com.nokia.tools.s60ct.resources.model.impl.ELibraryModelPackageImpl#getELibraryThemeFile()
	 * @generated
	 */
	int ELIBRARY_THEME_FILE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELIBRARY_THEME_FILE__NAME = ELIBRARY_FILE__NAME;

	/**
	 * The feature id for the '<em><b>Settings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELIBRARY_THEME_FILE__SETTINGS = ELIBRARY_FILE__SETTINGS;

	/**
	 * The feature id for the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELIBRARY_THEME_FILE__READ_ONLY = ELIBRARY_FILE__READ_ONLY;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELIBRARY_THEME_FILE__NOTE = ELIBRARY_FILE__NOTE;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELIBRARY_THEME_FILE__TIMESTAMP = ELIBRARY_FILE__TIMESTAMP;

	/**
	 * The feature id for the '<em><b>Path2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELIBRARY_THEME_FILE__PATH2 = ELIBRARY_FILE__PATH2;

	/**
	 * The feature id for the '<em><b>Resource From Top Layer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELIBRARY_THEME_FILE__RESOURCE_FROM_TOP_LAYER = ELIBRARY_FILE__RESOURCE_FROM_TOP_LAYER;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELIBRARY_THEME_FILE__SIZE = ELIBRARY_FILE__SIZE;

	/**
	 * The feature id for the '<em><b>Content Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELIBRARY_THEME_FILE__CONTENT_DESCRIPTION = ELIBRARY_FILE__CONTENT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Default Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELIBRARY_THEME_FILE__DEFAULT_RESOURCE = ELIBRARY_FILE__DEFAULT_RESOURCE;

	/**
	 * The feature id for the '<em><b>Validation Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELIBRARY_THEME_FILE__VALIDATION_MESSAGE = ELIBRARY_FILE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Cpf Platform Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELIBRARY_THEME_FILE__CPF_PLATFORM_ID = ELIBRARY_FILE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Theme Platform Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELIBRARY_THEME_FILE__THEME_PLATFORM_ID = ELIBRARY_FILE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>ELibrary Theme File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELIBRARY_THEME_FILE_FEATURE_COUNT = ELIBRARY_FILE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '<em>EPath</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.core.runtime.IPath
	 * @see com.nokia.tools.s60ct.resources.model.impl.ELibraryModelPackageImpl#getEPath()
	 * @generated
	 */
	int EPATH = 5;

	/**
	 * The meta object id for the '<em>EStorage</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.core.resources.IStorage
	 * @see com.nokia.tools.s60ct.resources.model.impl.ELibraryModelPackageImpl#getEStorage()
	 * @generated
	 */
	int ESTORAGE = 6;

	/**
	 * The meta object id for the '<em>Input Stream</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.io.InputStream
	 * @see com.nokia.tools.s60ct.resources.model.impl.ELibraryModelPackageImpl#getInputStream()
	 * @generated
	 */
	int INPUT_STREAM = 7;

	/**
	 * The meta object id for the '<em>IContent Type</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.core.runtime.content.IContentType
	 * @see com.nokia.tools.s60ct.resources.model.impl.ELibraryModelPackageImpl#getIContentType()
	 * @generated
	 */
	int ICONTENT_TYPE = 8;


	/**
	 * The meta object id for the '<em>IContent Description</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.core.runtime.content.IContentDescription
	 * @see com.nokia.tools.s60ct.resources.model.impl.ELibraryModelPackageImpl#getIContentDescription()
	 * @generated
	 */
	int ICONTENT_DESCRIPTION = 9;


	/**
	 * The meta object id for the '<em>JAVA IO FILE</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.io.File
	 * @see com.nokia.tools.s60ct.resources.model.impl.ELibraryModelPackageImpl#getJAVA_IO_FILE()
	 * @generated
	 */
	int JAVA_IO_FILE = 10;


	/**
	 * The meta object id for the '<em>Eclipse IPath</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.core.runtime.IPath
	 * @see com.nokia.tools.s60ct.resources.model.impl.ELibraryModelPackageImpl#getEclipse_IPath()
	 * @generated
	 */
	int ECLIPSE_IPATH = 11;


	/**
	 * Returns the meta object for class '{@link com.nokia.tools.s60ct.resources.model.ELibraryElement <em>ELibrary Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ELibrary Element</em>'.
	 * @see com.nokia.tools.s60ct.resources.model.ELibraryElement
	 * @generated
	 */
	EClass getELibraryElement();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.resources.model.ELibraryElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.nokia.tools.s60ct.resources.model.ELibraryElement#getName()
	 * @see #getELibraryElement()
	 * @generated
	 */
	EAttribute getELibraryElement_Name();

	/**
	 * Returns the meta object for the reference list '{@link com.nokia.tools.s60ct.resources.model.ELibraryElement#getSettings <em>Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Settings</em>'.
	 * @see com.nokia.tools.s60ct.resources.model.ELibraryElement#getSettings()
	 * @see #getELibraryElement()
	 * @generated
	 */
	EReference getELibraryElement_Settings();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.resources.model.ELibraryElement#isReadOnly <em>Read Only</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Read Only</em>'.
	 * @see com.nokia.tools.s60ct.resources.model.ELibraryElement#isReadOnly()
	 * @see #getELibraryElement()
	 * @generated
	 */
	EAttribute getELibraryElement_ReadOnly();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.resources.model.ELibraryElement#getNote <em>Note</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Note</em>'.
	 * @see com.nokia.tools.s60ct.resources.model.ELibraryElement#getNote()
	 * @see #getELibraryElement()
	 * @generated
	 */
	EAttribute getELibraryElement_Note();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.resources.model.ELibraryElement#getTimestamp <em>Timestamp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Timestamp</em>'.
	 * @see com.nokia.tools.s60ct.resources.model.ELibraryElement#getTimestamp()
	 * @see #getELibraryElement()
	 * @generated
	 */
	EAttribute getELibraryElement_Timestamp();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.resources.model.ELibraryElement#getPath2 <em>Path2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path2</em>'.
	 * @see com.nokia.tools.s60ct.resources.model.ELibraryElement#getPath2()
	 * @see #getELibraryElement()
	 * @generated
	 */
	EAttribute getELibraryElement_Path2();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.resources.model.ELibraryElement#isResourceFromTopLayer <em>Resource From Top Layer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resource From Top Layer</em>'.
	 * @see com.nokia.tools.s60ct.resources.model.ELibraryElement#isResourceFromTopLayer()
	 * @see #getELibraryElement()
	 * @generated
	 */
	EAttribute getELibraryElement_ResourceFromTopLayer();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.s60ct.resources.model.ELibraryDirectory <em>ELibrary Directory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ELibrary Directory</em>'.
	 * @see com.nokia.tools.s60ct.resources.model.ELibraryDirectory
	 * @generated
	 */
	EClass getELibraryDirectory();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.s60ct.resources.model.ELibraryDirectory#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see com.nokia.tools.s60ct.resources.model.ELibraryDirectory#getChildren()
	 * @see #getELibraryDirectory()
	 * @generated
	 */
	EReference getELibraryDirectory_Children();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.s60ct.resources.model.ELibraryFile <em>ELibrary File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ELibrary File</em>'.
	 * @see com.nokia.tools.s60ct.resources.model.ELibraryFile
	 * @generated
	 */
	EClass getELibraryFile();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.resources.model.ELibraryFile#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see com.nokia.tools.s60ct.resources.model.ELibraryFile#getSize()
	 * @see #getELibraryFile()
	 * @generated
	 */
	EAttribute getELibraryFile_Size();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.resources.model.ELibraryFile#getContentDescription <em>Content Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Content Description</em>'.
	 * @see com.nokia.tools.s60ct.resources.model.ELibraryFile#getContentDescription()
	 * @see #getELibraryFile()
	 * @generated
	 */
	EAttribute getELibraryFile_ContentDescription();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.resources.model.ELibraryFile#getDefaultResource <em>Default Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Resource</em>'.
	 * @see com.nokia.tools.s60ct.resources.model.ELibraryFile#getDefaultResource()
	 * @see #getELibraryFile()
	 * @generated
	 */
	EAttribute getELibraryFile_DefaultResource();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.s60ct.resources.model.ELibraryRoot <em>ELibrary Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ELibrary Root</em>'.
	 * @see com.nokia.tools.s60ct.resources.model.ELibraryRoot
	 * @generated
	 */
	EClass getELibraryRoot();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.resources.model.ELibraryRoot#getTempDirPath <em>Temp Dir Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Temp Dir Path</em>'.
	 * @see com.nokia.tools.s60ct.resources.model.ELibraryRoot#getTempDirPath()
	 * @see #getELibraryRoot()
	 * @generated
	 */
	EAttribute getELibraryRoot_TempDirPath();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.s60ct.resources.model.ELibraryThemeFile <em>ELibrary Theme File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ELibrary Theme File</em>'.
	 * @see com.nokia.tools.s60ct.resources.model.ELibraryThemeFile
	 * @generated
	 */
	EClass getELibraryThemeFile();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.resources.model.ELibraryThemeFile#getValidationMessage <em>Validation Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Validation Message</em>'.
	 * @see com.nokia.tools.s60ct.resources.model.ELibraryThemeFile#getValidationMessage()
	 * @see #getELibraryThemeFile()
	 * @generated
	 */
	EAttribute getELibraryThemeFile_ValidationMessage();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.resources.model.ELibraryThemeFile#getCpfPlatformId <em>Cpf Platform Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cpf Platform Id</em>'.
	 * @see com.nokia.tools.s60ct.resources.model.ELibraryThemeFile#getCpfPlatformId()
	 * @see #getELibraryThemeFile()
	 * @generated
	 */
	EAttribute getELibraryThemeFile_CpfPlatformId();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.s60ct.resources.model.ELibraryThemeFile#getThemePlatformId <em>Theme Platform Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Theme Platform Id</em>'.
	 * @see com.nokia.tools.s60ct.resources.model.ELibraryThemeFile#getThemePlatformId()
	 * @see #getELibraryThemeFile()
	 * @generated
	 */
	EAttribute getELibraryThemeFile_ThemePlatformId();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.core.runtime.IPath <em>EPath</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>EPath</em>'.
	 * @see org.eclipse.core.runtime.IPath
	 * @model instanceClass="org.eclipse.core.runtime.IPath"
	 * @generated
	 */
	EDataType getEPath();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.core.resources.IStorage <em>EStorage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>EStorage</em>'.
	 * @see org.eclipse.core.resources.IStorage
	 * @model instanceClass="org.eclipse.core.resources.IStorage" serializeable="false"
	 * @generated
	 */
	EDataType getEStorage();

	/**
	 * Returns the meta object for data type '{@link java.io.InputStream <em>Input Stream</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Input Stream</em>'.
	 * @see java.io.InputStream
	 * @model instanceClass="java.io.InputStream"
	 * @generated
	 */
	EDataType getInputStream();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.core.runtime.content.IContentType <em>IContent Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>IContent Type</em>'.
	 * @see org.eclipse.core.runtime.content.IContentType
	 * @model instanceClass="org.eclipse.core.runtime.content.IContentType"
	 * @generated
	 */
	EDataType getIContentType();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.core.runtime.content.IContentDescription <em>IContent Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>IContent Description</em>'.
	 * @see org.eclipse.core.runtime.content.IContentDescription
	 * @model instanceClass="org.eclipse.core.runtime.content.IContentDescription" serializeable="false"
	 * @generated
	 */
	EDataType getIContentDescription();

	/**
	 * Returns the meta object for data type '{@link java.io.File <em>JAVA IO FILE</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>JAVA IO FILE</em>'.
	 * @see java.io.File
	 * @model instanceClass="java.io.File"
	 * @generated
	 */
	EDataType getJAVA_IO_FILE();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.core.runtime.IPath <em>Eclipse IPath</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Eclipse IPath</em>'.
	 * @see org.eclipse.core.runtime.IPath
	 * @model instanceClass="org.eclipse.core.runtime.IPath"
	 * @generated
	 */
	EDataType getEclipse_IPath();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ELibraryModelFactory getELibraryModelFactory();

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
		 * The meta object literal for the '{@link com.nokia.tools.s60ct.resources.model.impl.ELibraryElementImpl <em>ELibrary Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.s60ct.resources.model.impl.ELibraryElementImpl
		 * @see com.nokia.tools.s60ct.resources.model.impl.ELibraryModelPackageImpl#getELibraryElement()
		 * @generated
		 */
		EClass ELIBRARY_ELEMENT = eINSTANCE.getELibraryElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELIBRARY_ELEMENT__NAME = eINSTANCE.getELibraryElement_Name();

		/**
		 * The meta object literal for the '<em><b>Settings</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELIBRARY_ELEMENT__SETTINGS = eINSTANCE.getELibraryElement_Settings();

		/**
		 * The meta object literal for the '<em><b>Read Only</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELIBRARY_ELEMENT__READ_ONLY = eINSTANCE.getELibraryElement_ReadOnly();

		/**
		 * The meta object literal for the '<em><b>Note</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELIBRARY_ELEMENT__NOTE = eINSTANCE.getELibraryElement_Note();

		/**
		 * The meta object literal for the '<em><b>Timestamp</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELIBRARY_ELEMENT__TIMESTAMP = eINSTANCE.getELibraryElement_Timestamp();

		/**
		 * The meta object literal for the '<em><b>Path2</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELIBRARY_ELEMENT__PATH2 = eINSTANCE.getELibraryElement_Path2();

		/**
		 * The meta object literal for the '<em><b>Resource From Top Layer</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELIBRARY_ELEMENT__RESOURCE_FROM_TOP_LAYER = eINSTANCE.getELibraryElement_ResourceFromTopLayer();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.s60ct.resources.model.impl.ELibraryDirectoryImpl <em>ELibrary Directory</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.s60ct.resources.model.impl.ELibraryDirectoryImpl
		 * @see com.nokia.tools.s60ct.resources.model.impl.ELibraryModelPackageImpl#getELibraryDirectory()
		 * @generated
		 */
		EClass ELIBRARY_DIRECTORY = eINSTANCE.getELibraryDirectory();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELIBRARY_DIRECTORY__CHILDREN = eINSTANCE.getELibraryDirectory_Children();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.s60ct.resources.model.impl.ELibraryFileImpl <em>ELibrary File</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.s60ct.resources.model.impl.ELibraryFileImpl
		 * @see com.nokia.tools.s60ct.resources.model.impl.ELibraryModelPackageImpl#getELibraryFile()
		 * @generated
		 */
		EClass ELIBRARY_FILE = eINSTANCE.getELibraryFile();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELIBRARY_FILE__SIZE = eINSTANCE.getELibraryFile_Size();

		/**
		 * The meta object literal for the '<em><b>Content Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELIBRARY_FILE__CONTENT_DESCRIPTION = eINSTANCE.getELibraryFile_ContentDescription();

		/**
		 * The meta object literal for the '<em><b>Default Resource</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELIBRARY_FILE__DEFAULT_RESOURCE = eINSTANCE.getELibraryFile_DefaultResource();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.s60ct.resources.model.impl.ELibraryRootImpl <em>ELibrary Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.s60ct.resources.model.impl.ELibraryRootImpl
		 * @see com.nokia.tools.s60ct.resources.model.impl.ELibraryModelPackageImpl#getELibraryRoot()
		 * @generated
		 */
		EClass ELIBRARY_ROOT = eINSTANCE.getELibraryRoot();

		/**
		 * The meta object literal for the '<em><b>Temp Dir Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELIBRARY_ROOT__TEMP_DIR_PATH = eINSTANCE.getELibraryRoot_TempDirPath();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.s60ct.resources.model.impl.ELibraryThemeFileImpl <em>ELibrary Theme File</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.s60ct.resources.model.impl.ELibraryThemeFileImpl
		 * @see com.nokia.tools.s60ct.resources.model.impl.ELibraryModelPackageImpl#getELibraryThemeFile()
		 * @generated
		 */
		EClass ELIBRARY_THEME_FILE = eINSTANCE.getELibraryThemeFile();

		/**
		 * The meta object literal for the '<em><b>Validation Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELIBRARY_THEME_FILE__VALIDATION_MESSAGE = eINSTANCE.getELibraryThemeFile_ValidationMessage();

		/**
		 * The meta object literal for the '<em><b>Cpf Platform Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELIBRARY_THEME_FILE__CPF_PLATFORM_ID = eINSTANCE.getELibraryThemeFile_CpfPlatformId();

		/**
		 * The meta object literal for the '<em><b>Theme Platform Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELIBRARY_THEME_FILE__THEME_PLATFORM_ID = eINSTANCE.getELibraryThemeFile_ThemePlatformId();

		/**
		 * The meta object literal for the '<em>EPath</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.core.runtime.IPath
		 * @see com.nokia.tools.s60ct.resources.model.impl.ELibraryModelPackageImpl#getEPath()
		 * @generated
		 */
		EDataType EPATH = eINSTANCE.getEPath();

		/**
		 * The meta object literal for the '<em>EStorage</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.core.resources.IStorage
		 * @see com.nokia.tools.s60ct.resources.model.impl.ELibraryModelPackageImpl#getEStorage()
		 * @generated
		 */
		EDataType ESTORAGE = eINSTANCE.getEStorage();

		/**
		 * The meta object literal for the '<em>Input Stream</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.io.InputStream
		 * @see com.nokia.tools.s60ct.resources.model.impl.ELibraryModelPackageImpl#getInputStream()
		 * @generated
		 */
		EDataType INPUT_STREAM = eINSTANCE.getInputStream();

		/**
		 * The meta object literal for the '<em>IContent Type</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.core.runtime.content.IContentType
		 * @see com.nokia.tools.s60ct.resources.model.impl.ELibraryModelPackageImpl#getIContentType()
		 * @generated
		 */
		EDataType ICONTENT_TYPE = eINSTANCE.getIContentType();

		/**
		 * The meta object literal for the '<em>IContent Description</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.core.runtime.content.IContentDescription
		 * @see com.nokia.tools.s60ct.resources.model.impl.ELibraryModelPackageImpl#getIContentDescription()
		 * @generated
		 */
		EDataType ICONTENT_DESCRIPTION = eINSTANCE.getIContentDescription();

		/**
		 * The meta object literal for the '<em>JAVA IO FILE</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.io.File
		 * @see com.nokia.tools.s60ct.resources.model.impl.ELibraryModelPackageImpl#getJAVA_IO_FILE()
		 * @generated
		 */
		EDataType JAVA_IO_FILE = eINSTANCE.getJAVA_IO_FILE();

		/**
		 * The meta object literal for the '<em>Eclipse IPath</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.core.runtime.IPath
		 * @see com.nokia.tools.s60ct.resources.model.impl.ELibraryModelPackageImpl#getEclipse_IPath()
		 * @generated
		 */
		EDataType ECLIPSE_IPATH = eINSTANCE.getEclipse_IPath();

	}

} //resourcesPackage
