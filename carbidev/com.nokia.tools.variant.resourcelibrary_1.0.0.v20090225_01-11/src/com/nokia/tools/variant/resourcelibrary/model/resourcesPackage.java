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

package com.nokia.tools.variant.resourcelibrary.model;

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
 * @see com.nokia.tools.variant.resourcelibrary.model.resourcesFactory
 * @model kind="package"
 * @generated
 */
public interface resourcesPackage extends EPackage {
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
	resourcesPackage eINSTANCE = com.nokia.tools.variant.resourcelibrary.model.impl.resourcesPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.nokia.tools.variant.resourcelibrary.model.impl.FileSystemElementImpl <em>File System Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.variant.resourcelibrary.model.impl.FileSystemElementImpl
	 * @see com.nokia.tools.variant.resourcelibrary.model.impl.resourcesPackageImpl#getFileSystemElement()
	 * @generated
	 */
	int FILE_SYSTEM_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_ELEMENT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Settings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_ELEMENT__SETTINGS = 1;

	/**
	 * The feature id for the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_ELEMENT__READ_ONLY = 2;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_ELEMENT__NOTE = 3;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_ELEMENT__TIMESTAMP = 4;

	/**
	 * The feature id for the '<em><b>Path2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_ELEMENT__PATH2 = 5;

	/**
	 * The number of structural features of the '<em>File System Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_ELEMENT_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link com.nokia.tools.variant.resourcelibrary.model.impl.DirectoryImpl <em>Directory</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.variant.resourcelibrary.model.impl.DirectoryImpl
	 * @see com.nokia.tools.variant.resourcelibrary.model.impl.resourcesPackageImpl#getDirectory()
	 * @generated
	 */
	int DIRECTORY = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY__NAME = FILE_SYSTEM_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Settings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY__SETTINGS = FILE_SYSTEM_ELEMENT__SETTINGS;

	/**
	 * The feature id for the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY__READ_ONLY = FILE_SYSTEM_ELEMENT__READ_ONLY;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY__NOTE = FILE_SYSTEM_ELEMENT__NOTE;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY__TIMESTAMP = FILE_SYSTEM_ELEMENT__TIMESTAMP;

	/**
	 * The feature id for the '<em><b>Path2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY__PATH2 = FILE_SYSTEM_ELEMENT__PATH2;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY__CHILDREN = FILE_SYSTEM_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Directory</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY_FEATURE_COUNT = FILE_SYSTEM_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.nokia.tools.variant.resourcelibrary.model.impl.FileImpl <em>File</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.variant.resourcelibrary.model.impl.FileImpl
	 * @see com.nokia.tools.variant.resourcelibrary.model.impl.resourcesPackageImpl#getFile()
	 * @generated
	 */
	int FILE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE__NAME = FILE_SYSTEM_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Settings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE__SETTINGS = FILE_SYSTEM_ELEMENT__SETTINGS;

	/**
	 * The feature id for the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE__READ_ONLY = FILE_SYSTEM_ELEMENT__READ_ONLY;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE__NOTE = FILE_SYSTEM_ELEMENT__NOTE;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE__TIMESTAMP = FILE_SYSTEM_ELEMENT__TIMESTAMP;

	/**
	 * The feature id for the '<em><b>Path2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE__PATH2 = FILE_SYSTEM_ELEMENT__PATH2;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE__SIZE = FILE_SYSTEM_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Content Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE__CONTENT_DESCRIPTION = FILE_SYSTEM_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Default Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE__DEFAULT_RESOURCE = FILE_SYSTEM_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_FEATURE_COUNT = FILE_SYSTEM_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.nokia.tools.variant.resourcelibrary.model.impl.ResourceModelRootImpl <em>Resource Model Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.variant.resourcelibrary.model.impl.ResourceModelRootImpl
	 * @see com.nokia.tools.variant.resourcelibrary.model.impl.resourcesPackageImpl#getResourceModelRoot()
	 * @generated
	 */
	int RESOURCE_MODEL_ROOT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_MODEL_ROOT__NAME = DIRECTORY__NAME;

	/**
	 * The feature id for the '<em><b>Settings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_MODEL_ROOT__SETTINGS = DIRECTORY__SETTINGS;

	/**
	 * The feature id for the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_MODEL_ROOT__READ_ONLY = DIRECTORY__READ_ONLY;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_MODEL_ROOT__NOTE = DIRECTORY__NOTE;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_MODEL_ROOT__TIMESTAMP = DIRECTORY__TIMESTAMP;

	/**
	 * The feature id for the '<em><b>Path2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_MODEL_ROOT__PATH2 = DIRECTORY__PATH2;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_MODEL_ROOT__CHILDREN = DIRECTORY__CHILDREN;

	/**
	 * The feature id for the '<em><b>Temp Dir Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_MODEL_ROOT__TEMP_DIR_PATH = DIRECTORY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Resource Model Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_MODEL_ROOT_FEATURE_COUNT = DIRECTORY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.nokia.tools.variant.resourcelibrary.model.impl.ThemeFileImpl <em>Theme File</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.variant.resourcelibrary.model.impl.ThemeFileImpl
	 * @see com.nokia.tools.variant.resourcelibrary.model.impl.resourcesPackageImpl#getThemeFile()
	 * @generated
	 */
	int THEME_FILE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THEME_FILE__NAME = FILE__NAME;

	/**
	 * The feature id for the '<em><b>Settings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THEME_FILE__SETTINGS = FILE__SETTINGS;

	/**
	 * The feature id for the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THEME_FILE__READ_ONLY = FILE__READ_ONLY;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THEME_FILE__NOTE = FILE__NOTE;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THEME_FILE__TIMESTAMP = FILE__TIMESTAMP;

	/**
	 * The feature id for the '<em><b>Path2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THEME_FILE__PATH2 = FILE__PATH2;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THEME_FILE__SIZE = FILE__SIZE;

	/**
	 * The feature id for the '<em><b>Content Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THEME_FILE__CONTENT_DESCRIPTION = FILE__CONTENT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Default Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THEME_FILE__DEFAULT_RESOURCE = FILE__DEFAULT_RESOURCE;

	/**
	 * The feature id for the '<em><b>Validation Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THEME_FILE__VALIDATION_MESSAGE = FILE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Theme File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THEME_FILE_FEATURE_COUNT = FILE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '<em>EPath</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.core.runtime.IPath
	 * @see com.nokia.tools.variant.resourcelibrary.model.impl.resourcesPackageImpl#getEPath()
	 * @generated
	 */
	int EPATH = 5;

	/**
	 * The meta object id for the '<em>EStorage</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.core.resources.IStorage
	 * @see com.nokia.tools.variant.resourcelibrary.model.impl.resourcesPackageImpl#getEStorage()
	 * @generated
	 */
	int ESTORAGE = 6;

	/**
	 * The meta object id for the '<em>Input Stream</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.io.InputStream
	 * @see com.nokia.tools.variant.resourcelibrary.model.impl.resourcesPackageImpl#getInputStream()
	 * @generated
	 */
	int INPUT_STREAM = 7;

	/**
	 * The meta object id for the '<em>IContent Type</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.core.runtime.content.IContentType
	 * @see com.nokia.tools.variant.resourcelibrary.model.impl.resourcesPackageImpl#getIContentType()
	 * @generated
	 */
	int ICONTENT_TYPE = 8;


	/**
	 * The meta object id for the '<em>IContent Description</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.core.runtime.content.IContentDescription
	 * @see com.nokia.tools.variant.resourcelibrary.model.impl.resourcesPackageImpl#getIContentDescription()
	 * @generated
	 */
	int ICONTENT_DESCRIPTION = 9;


	/**
	 * The meta object id for the '<em>JAVA IO FILE</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.io.File
	 * @see com.nokia.tools.variant.resourcelibrary.model.impl.resourcesPackageImpl#getJAVA_IO_FILE()
	 * @generated
	 */
	int JAVA_IO_FILE = 10;


	/**
	 * The meta object id for the '<em>Eclipse IPath</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.core.runtime.IPath
	 * @see com.nokia.tools.variant.resourcelibrary.model.impl.resourcesPackageImpl#getEclipse_IPath()
	 * @generated
	 */
	int ECLIPSE_IPATH = 11;


	/**
	 * Returns the meta object for class '{@link com.nokia.tools.variant.resourcelibrary.model.FileSystemElement <em>File System Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File System Element</em>'.
	 * @see com.nokia.tools.variant.resourcelibrary.model.FileSystemElement
	 * @generated
	 */
	EClass getFileSystemElement();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.resourcelibrary.model.FileSystemElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.nokia.tools.variant.resourcelibrary.model.FileSystemElement#getName()
	 * @see #getFileSystemElement()
	 * @generated
	 */
	EAttribute getFileSystemElement_Name();

	/**
	 * Returns the meta object for the reference list '{@link com.nokia.tools.variant.resourcelibrary.model.FileSystemElement#getSettings <em>Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Settings</em>'.
	 * @see com.nokia.tools.variant.resourcelibrary.model.FileSystemElement#getSettings()
	 * @see #getFileSystemElement()
	 * @generated
	 */
	EReference getFileSystemElement_Settings();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.resourcelibrary.model.FileSystemElement#isReadOnly <em>Read Only</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Read Only</em>'.
	 * @see com.nokia.tools.variant.resourcelibrary.model.FileSystemElement#isReadOnly()
	 * @see #getFileSystemElement()
	 * @generated
	 */
	EAttribute getFileSystemElement_ReadOnly();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.resourcelibrary.model.FileSystemElement#getNote <em>Note</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Note</em>'.
	 * @see com.nokia.tools.variant.resourcelibrary.model.FileSystemElement#getNote()
	 * @see #getFileSystemElement()
	 * @generated
	 */
	EAttribute getFileSystemElement_Note();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.resourcelibrary.model.FileSystemElement#getTimestamp <em>Timestamp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Timestamp</em>'.
	 * @see com.nokia.tools.variant.resourcelibrary.model.FileSystemElement#getTimestamp()
	 * @see #getFileSystemElement()
	 * @generated
	 */
	EAttribute getFileSystemElement_Timestamp();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.resourcelibrary.model.FileSystemElement#getPath2 <em>Path2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path2</em>'.
	 * @see com.nokia.tools.variant.resourcelibrary.model.FileSystemElement#getPath2()
	 * @see #getFileSystemElement()
	 * @generated
	 */
	EAttribute getFileSystemElement_Path2();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.variant.resourcelibrary.model.Directory <em>Directory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Directory</em>'.
	 * @see com.nokia.tools.variant.resourcelibrary.model.Directory
	 * @generated
	 */
	EClass getDirectory();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.variant.resourcelibrary.model.Directory#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see com.nokia.tools.variant.resourcelibrary.model.Directory#getChildren()
	 * @see #getDirectory()
	 * @generated
	 */
	EReference getDirectory_Children();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.variant.resourcelibrary.model.File <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File</em>'.
	 * @see com.nokia.tools.variant.resourcelibrary.model.File
	 * @generated
	 */
	EClass getFile();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.resourcelibrary.model.File#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see com.nokia.tools.variant.resourcelibrary.model.File#getSize()
	 * @see #getFile()
	 * @generated
	 */
	EAttribute getFile_Size();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.resourcelibrary.model.File#getContentDescription <em>Content Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Content Description</em>'.
	 * @see com.nokia.tools.variant.resourcelibrary.model.File#getContentDescription()
	 * @see #getFile()
	 * @generated
	 */
	EAttribute getFile_ContentDescription();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.resourcelibrary.model.File#getDefaultResource <em>Default Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Resource</em>'.
	 * @see com.nokia.tools.variant.resourcelibrary.model.File#getDefaultResource()
	 * @see #getFile()
	 * @generated
	 */
	EAttribute getFile_DefaultResource();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.variant.resourcelibrary.model.ResourceModelRoot <em>Resource Model Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Model Root</em>'.
	 * @see com.nokia.tools.variant.resourcelibrary.model.ResourceModelRoot
	 * @generated
	 */
	EClass getResourceModelRoot();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.resourcelibrary.model.ResourceModelRoot#getTempDirPath <em>Temp Dir Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Temp Dir Path</em>'.
	 * @see com.nokia.tools.variant.resourcelibrary.model.ResourceModelRoot#getTempDirPath()
	 * @see #getResourceModelRoot()
	 * @generated
	 */
	EAttribute getResourceModelRoot_TempDirPath();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.variant.resourcelibrary.model.ThemeFile <em>Theme File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Theme File</em>'.
	 * @see com.nokia.tools.variant.resourcelibrary.model.ThemeFile
	 * @generated
	 */
	EClass getThemeFile();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.resourcelibrary.model.ThemeFile#getValidationMessage <em>Validation Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Validation Message</em>'.
	 * @see com.nokia.tools.variant.resourcelibrary.model.ThemeFile#getValidationMessage()
	 * @see #getThemeFile()
	 * @generated
	 */
	EAttribute getThemeFile_ValidationMessage();

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
	resourcesFactory getresourcesFactory();

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
		 * The meta object literal for the '{@link com.nokia.tools.variant.resourcelibrary.model.impl.FileSystemElementImpl <em>File System Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.variant.resourcelibrary.model.impl.FileSystemElementImpl
		 * @see com.nokia.tools.variant.resourcelibrary.model.impl.resourcesPackageImpl#getFileSystemElement()
		 * @generated
		 */
		EClass FILE_SYSTEM_ELEMENT = eINSTANCE.getFileSystemElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_SYSTEM_ELEMENT__NAME = eINSTANCE.getFileSystemElement_Name();

		/**
		 * The meta object literal for the '<em><b>Settings</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FILE_SYSTEM_ELEMENT__SETTINGS = eINSTANCE.getFileSystemElement_Settings();

		/**
		 * The meta object literal for the '<em><b>Read Only</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_SYSTEM_ELEMENT__READ_ONLY = eINSTANCE.getFileSystemElement_ReadOnly();

		/**
		 * The meta object literal for the '<em><b>Note</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_SYSTEM_ELEMENT__NOTE = eINSTANCE.getFileSystemElement_Note();

		/**
		 * The meta object literal for the '<em><b>Timestamp</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_SYSTEM_ELEMENT__TIMESTAMP = eINSTANCE.getFileSystemElement_Timestamp();

		/**
		 * The meta object literal for the '<em><b>Path2</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_SYSTEM_ELEMENT__PATH2 = eINSTANCE.getFileSystemElement_Path2();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.variant.resourcelibrary.model.impl.DirectoryImpl <em>Directory</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.variant.resourcelibrary.model.impl.DirectoryImpl
		 * @see com.nokia.tools.variant.resourcelibrary.model.impl.resourcesPackageImpl#getDirectory()
		 * @generated
		 */
		EClass DIRECTORY = eINSTANCE.getDirectory();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIRECTORY__CHILDREN = eINSTANCE.getDirectory_Children();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.variant.resourcelibrary.model.impl.FileImpl <em>File</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.variant.resourcelibrary.model.impl.FileImpl
		 * @see com.nokia.tools.variant.resourcelibrary.model.impl.resourcesPackageImpl#getFile()
		 * @generated
		 */
		EClass FILE = eINSTANCE.getFile();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE__SIZE = eINSTANCE.getFile_Size();

		/**
		 * The meta object literal for the '<em><b>Content Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE__CONTENT_DESCRIPTION = eINSTANCE.getFile_ContentDescription();

		/**
		 * The meta object literal for the '<em><b>Default Resource</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE__DEFAULT_RESOURCE = eINSTANCE.getFile_DefaultResource();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.variant.resourcelibrary.model.impl.ResourceModelRootImpl <em>Resource Model Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.variant.resourcelibrary.model.impl.ResourceModelRootImpl
		 * @see com.nokia.tools.variant.resourcelibrary.model.impl.resourcesPackageImpl#getResourceModelRoot()
		 * @generated
		 */
		EClass RESOURCE_MODEL_ROOT = eINSTANCE.getResourceModelRoot();

		/**
		 * The meta object literal for the '<em><b>Temp Dir Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_MODEL_ROOT__TEMP_DIR_PATH = eINSTANCE.getResourceModelRoot_TempDirPath();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.variant.resourcelibrary.model.impl.ThemeFileImpl <em>Theme File</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.variant.resourcelibrary.model.impl.ThemeFileImpl
		 * @see com.nokia.tools.variant.resourcelibrary.model.impl.resourcesPackageImpl#getThemeFile()
		 * @generated
		 */
		EClass THEME_FILE = eINSTANCE.getThemeFile();

		/**
		 * The meta object literal for the '<em><b>Validation Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute THEME_FILE__VALIDATION_MESSAGE = eINSTANCE.getThemeFile_ValidationMessage();

		/**
		 * The meta object literal for the '<em>EPath</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.core.runtime.IPath
		 * @see com.nokia.tools.variant.resourcelibrary.model.impl.resourcesPackageImpl#getEPath()
		 * @generated
		 */
		EDataType EPATH = eINSTANCE.getEPath();

		/**
		 * The meta object literal for the '<em>EStorage</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.core.resources.IStorage
		 * @see com.nokia.tools.variant.resourcelibrary.model.impl.resourcesPackageImpl#getEStorage()
		 * @generated
		 */
		EDataType ESTORAGE = eINSTANCE.getEStorage();

		/**
		 * The meta object literal for the '<em>Input Stream</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.io.InputStream
		 * @see com.nokia.tools.variant.resourcelibrary.model.impl.resourcesPackageImpl#getInputStream()
		 * @generated
		 */
		EDataType INPUT_STREAM = eINSTANCE.getInputStream();

		/**
		 * The meta object literal for the '<em>IContent Type</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.core.runtime.content.IContentType
		 * @see com.nokia.tools.variant.resourcelibrary.model.impl.resourcesPackageImpl#getIContentType()
		 * @generated
		 */
		EDataType ICONTENT_TYPE = eINSTANCE.getIContentType();

		/**
		 * The meta object literal for the '<em>IContent Description</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.core.runtime.content.IContentDescription
		 * @see com.nokia.tools.variant.resourcelibrary.model.impl.resourcesPackageImpl#getIContentDescription()
		 * @generated
		 */
		EDataType ICONTENT_DESCRIPTION = eINSTANCE.getIContentDescription();

		/**
		 * The meta object literal for the '<em>JAVA IO FILE</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.io.File
		 * @see com.nokia.tools.variant.resourcelibrary.model.impl.resourcesPackageImpl#getJAVA_IO_FILE()
		 * @generated
		 */
		EDataType JAVA_IO_FILE = eINSTANCE.getJAVA_IO_FILE();

		/**
		 * The meta object literal for the '<em>Eclipse IPath</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.core.runtime.IPath
		 * @see com.nokia.tools.variant.resourcelibrary.model.impl.resourcesPackageImpl#getEclipse_IPath()
		 * @generated
		 */
		EDataType ECLIPSE_IPATH = eINSTANCE.getEclipse_IPath();

	}

} //resourcesPackage
