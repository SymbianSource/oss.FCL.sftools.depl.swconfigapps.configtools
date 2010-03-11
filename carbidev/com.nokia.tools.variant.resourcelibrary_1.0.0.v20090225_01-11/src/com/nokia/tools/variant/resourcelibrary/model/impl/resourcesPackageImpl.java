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

package com.nokia.tools.variant.resourcelibrary.model.impl;

import java.io.InputStream;

import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.content.IContentDescription;
import org.eclipse.core.runtime.content.IContentType;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import com.nokia.tools.variant.content.confml.ConfmlPackage;
import com.nokia.tools.variant.content.confml.impl.ConfmlPackageImpl;
import com.nokia.tools.variant.resourcelibrary.model.Directory;
import com.nokia.tools.variant.resourcelibrary.model.File;
import com.nokia.tools.variant.resourcelibrary.model.FileSystemElement;
import com.nokia.tools.variant.resourcelibrary.model.ResourceModelRoot;
import com.nokia.tools.variant.resourcelibrary.model.ThemeFile;
import com.nokia.tools.variant.resourcelibrary.model.resourcesFactory;
import com.nokia.tools.variant.resourcelibrary.model.resourcesPackage;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class resourcesPackageImpl extends EPackageImpl implements resourcesPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fileSystemElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass directoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fileEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceModelRootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass themeFileEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType ePathEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType eStorageEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType inputStreamEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType iContentTypeEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType iContentDescriptionEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType javA_IO_FILEEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType eclipse_IPathEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see com.nokia.tools.variant.resourcelibrary.model.resourcesPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private resourcesPackageImpl() {
		super(eNS_URI, resourcesFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static resourcesPackage init() {
		if (isInited) return (resourcesPackage)EPackage.Registry.INSTANCE.getEPackage(resourcesPackage.eNS_URI);

		// Obtain or create and register package
		resourcesPackageImpl theresourcesPackage = (resourcesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof resourcesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new resourcesPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		ConfmlPackageImpl theConfmlPackage = (ConfmlPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ConfmlPackage.eNS_URI) instanceof ConfmlPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ConfmlPackage.eNS_URI) : ConfmlPackage.eINSTANCE);

		// Create package meta-data objects
		theresourcesPackage.createPackageContents();
		theConfmlPackage.createPackageContents();

		// Initialize created meta-data
		theresourcesPackage.initializePackageContents();
		theConfmlPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theresourcesPackage.freeze();

		return theresourcesPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFileSystemElement() {
		return fileSystemElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFileSystemElement_Name() {
		return (EAttribute)fileSystemElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFileSystemElement_Settings() {
		return (EReference)fileSystemElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFileSystemElement_ReadOnly() {
		return (EAttribute)fileSystemElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFileSystemElement_Note() {
		return (EAttribute)fileSystemElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFileSystemElement_Timestamp() {
		return (EAttribute)fileSystemElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFileSystemElement_Path2() {
		return (EAttribute)fileSystemElementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDirectory() {
		return directoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDirectory_Children() {
		return (EReference)directoryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFile() {
		return fileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFile_Size() {
		return (EAttribute)fileEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFile_ContentDescription() {
		return (EAttribute)fileEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFile_DefaultResource() {
		return (EAttribute)fileEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResourceModelRoot() {
		return resourceModelRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResourceModelRoot_TempDirPath() {
		return (EAttribute)resourceModelRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThemeFile() {
		return themeFileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThemeFile_ValidationMessage() {
		return (EAttribute)themeFileEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getEPath() {
		return ePathEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getEStorage() {
		return eStorageEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getInputStream() {
		return inputStreamEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getIContentType() {
		return iContentTypeEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getIContentDescription() {
		return iContentDescriptionEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getJAVA_IO_FILE() {
		return javA_IO_FILEEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getEclipse_IPath() {
		return eclipse_IPathEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public resourcesFactory getresourcesFactory() {
		return (resourcesFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		fileSystemElementEClass = createEClass(FILE_SYSTEM_ELEMENT);
		createEAttribute(fileSystemElementEClass, FILE_SYSTEM_ELEMENT__NAME);
		createEReference(fileSystemElementEClass, FILE_SYSTEM_ELEMENT__SETTINGS);
		createEAttribute(fileSystemElementEClass, FILE_SYSTEM_ELEMENT__READ_ONLY);
		createEAttribute(fileSystemElementEClass, FILE_SYSTEM_ELEMENT__NOTE);
		createEAttribute(fileSystemElementEClass, FILE_SYSTEM_ELEMENT__TIMESTAMP);
		createEAttribute(fileSystemElementEClass, FILE_SYSTEM_ELEMENT__PATH2);

		directoryEClass = createEClass(DIRECTORY);
		createEReference(directoryEClass, DIRECTORY__CHILDREN);

		fileEClass = createEClass(FILE);
		createEAttribute(fileEClass, FILE__SIZE);
		createEAttribute(fileEClass, FILE__CONTENT_DESCRIPTION);
		createEAttribute(fileEClass, FILE__DEFAULT_RESOURCE);

		resourceModelRootEClass = createEClass(RESOURCE_MODEL_ROOT);
		createEAttribute(resourceModelRootEClass, RESOURCE_MODEL_ROOT__TEMP_DIR_PATH);

		themeFileEClass = createEClass(THEME_FILE);
		createEAttribute(themeFileEClass, THEME_FILE__VALIDATION_MESSAGE);

		// Create data types
		ePathEDataType = createEDataType(EPATH);
		eStorageEDataType = createEDataType(ESTORAGE);
		inputStreamEDataType = createEDataType(INPUT_STREAM);
		iContentTypeEDataType = createEDataType(ICONTENT_TYPE);
		iContentDescriptionEDataType = createEDataType(ICONTENT_DESCRIPTION);
		javA_IO_FILEEDataType = createEDataType(JAVA_IO_FILE);
		eclipse_IPathEDataType = createEDataType(ECLIPSE_IPATH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		ConfmlPackage theConfmlPackage = (ConfmlPackage)EPackage.Registry.INSTANCE.getEPackage(ConfmlPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		directoryEClass.getESuperTypes().add(this.getFileSystemElement());
		fileEClass.getESuperTypes().add(this.getFileSystemElement());
		resourceModelRootEClass.getESuperTypes().add(this.getDirectory());
		themeFileEClass.getESuperTypes().add(this.getFile());

		// Initialize classes and features; add operations and parameters
		initEClass(fileSystemElementEClass, FileSystemElement.class, "FileSystemElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFileSystemElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, FileSystemElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFileSystemElement_Settings(), theConfmlPackage.getSetting(), null, "settings", null, 0, -1, FileSystemElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFileSystemElement_ReadOnly(), ecorePackage.getEBoolean(), "readOnly", null, 0, 1, FileSystemElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFileSystemElement_Note(), ecorePackage.getEString(), "note", null, 0, 1, FileSystemElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFileSystemElement_Timestamp(), ecorePackage.getELong(), "timestamp", null, 0, 1, FileSystemElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFileSystemElement_Path2(), this.getEclipse_IPath(), "path2", null, 0, 1, FileSystemElement.class, !IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		addEOperation(fileSystemElementEClass, ecorePackage.getEString(), "getPath", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(fileSystemElementEClass, ecorePackage.getEString(), "getFullPath", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(fileSystemElementEClass, ecorePackage.getEBoolean(), "delete", 0, 1, IS_UNIQUE, IS_ORDERED);

		EOperation op = addEOperation(fileSystemElementEClass, ecorePackage.getEBoolean(), "move", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDirectory(), "target", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(fileSystemElementEClass, ecorePackage.getEBoolean(), "copy", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDirectory(), "target", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(fileSystemElementEClass, ecorePackage.getEBoolean(), "touchedByReadonlySetting", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(directoryEClass, Directory.class, "Directory", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDirectory_Children(), this.getFileSystemElement(), null, "children", null, 0, -1, Directory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(directoryEClass, this.getFileSystemElement(), "getChild", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(directoryEClass, ecorePackage.getEBoolean(), "addChild", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getFileSystemElement(), "child", 0, 1, !IS_UNIQUE, IS_ORDERED);

		addEOperation(directoryEClass, ecorePackage.getEInt(), "getSize", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(directoryEClass, ecorePackage.getEBoolean(), "deleteOnFileSystem", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(directoryEClass, this.getFileSystemElement(), "findChild", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getEclipse_IPath(), "path", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(fileEClass, File.class, "File", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFile_Size(), ecorePackage.getELong(), "size", null, 0, 1, File.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFile_ContentDescription(), this.getIContentDescription(), "contentDescription", null, 0, 1, File.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFile_DefaultResource(), this.getJAVA_IO_FILE(), "defaultResource", null, 0, 1, File.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(fileEClass, this.getInputStream(), "getInputStream", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(fileEClass, null, "recomputeContentDescription", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(resourceModelRootEClass, ResourceModelRoot.class, "ResourceModelRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getResourceModelRoot_TempDirPath(), ecorePackage.getEString(), "tempDirPath", null, 0, 1, ResourceModelRoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(themeFileEClass, ThemeFile.class, "ThemeFile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getThemeFile_ValidationMessage(), ecorePackage.getEString(), "validationMessage", null, 0, 1, ThemeFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize data types
		initEDataType(ePathEDataType, IPath.class, "EPath", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(eStorageEDataType, IStorage.class, "EStorage", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(inputStreamEDataType, InputStream.class, "InputStream", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(iContentTypeEDataType, IContentType.class, "IContentType", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(iContentDescriptionEDataType, IContentDescription.class, "IContentDescription", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(javA_IO_FILEEDataType, java.io.File.class, "JAVA_IO_FILE", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(eclipse_IPathEDataType, IPath.class, "Eclipse_IPath", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //resourcesPackageImpl
