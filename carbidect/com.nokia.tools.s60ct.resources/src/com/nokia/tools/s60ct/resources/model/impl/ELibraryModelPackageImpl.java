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

package com.nokia.tools.s60ct.resources.model.impl;

import java.io.File;
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

import com.nokia.tools.s60ct.content.confml.ConfmlPackage;
import com.nokia.tools.s60ct.content.confml.impl.ConfmlPackageImpl;
import com.nokia.tools.s60ct.resources.model.ELibraryDirectory;
import com.nokia.tools.s60ct.resources.model.ELibraryElement;
import com.nokia.tools.s60ct.resources.model.ELibraryFile;
import com.nokia.tools.s60ct.resources.model.ELibraryModelFactory;
import com.nokia.tools.s60ct.resources.model.ELibraryModelPackage;
import com.nokia.tools.s60ct.resources.model.ELibraryRoot;
import com.nokia.tools.s60ct.resources.model.ELibraryThemeFile;



/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ELibraryModelPackageImpl extends EPackageImpl implements ELibraryModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eLibraryElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eLibraryDirectoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eLibraryFileEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eLibraryRootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eLibraryThemeFileEClass = null;

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
	 * @see com.nokia.tools.s60ct.resources.model.ELibraryModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ELibraryModelPackageImpl() {
		super(eNS_URI, ELibraryModelFactory.eINSTANCE);
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
	public static ELibraryModelPackage init() {
		if (isInited) return (ELibraryModelPackage)EPackage.Registry.INSTANCE.getEPackage(ELibraryModelPackage.eNS_URI);

		// Obtain or create and register package
		ELibraryModelPackageImpl theELibraryModelPackage = (ELibraryModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof ELibraryModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new ELibraryModelPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		ConfmlPackageImpl theConfmlPackage = (ConfmlPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ConfmlPackage.eNS_URI) instanceof ConfmlPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ConfmlPackage.eNS_URI) : ConfmlPackage.eINSTANCE);

		// Create package meta-data objects
		theELibraryModelPackage.createPackageContents();
		theConfmlPackage.createPackageContents();

		// Initialize created meta-data
		theELibraryModelPackage.initializePackageContents();
		theConfmlPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theELibraryModelPackage.freeze();

		return theELibraryModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getELibraryElement() {
		return eLibraryElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getELibraryElement_Name() {
		return (EAttribute)eLibraryElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getELibraryElement_Settings() {
		return (EReference)eLibraryElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getELibraryElement_ReadOnly() {
		return (EAttribute)eLibraryElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getELibraryElement_Note() {
		return (EAttribute)eLibraryElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getELibraryElement_Timestamp() {
		return (EAttribute)eLibraryElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getELibraryElement_Path2() {
		return (EAttribute)eLibraryElementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getELibraryElement_ResourceFromTopLayer() {
		return (EAttribute)eLibraryElementEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getELibraryDirectory() {
		return eLibraryDirectoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getELibraryDirectory_Children() {
		return (EReference)eLibraryDirectoryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getELibraryFile() {
		return eLibraryFileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getELibraryFile_Size() {
		return (EAttribute)eLibraryFileEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getELibraryFile_ContentDescription() {
		return (EAttribute)eLibraryFileEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getELibraryFile_DefaultResource() {
		return (EAttribute)eLibraryFileEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getELibraryRoot() {
		return eLibraryRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getELibraryRoot_TempDirPath() {
		return (EAttribute)eLibraryRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getELibraryThemeFile() {
		return eLibraryThemeFileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getELibraryThemeFile_ValidationMessage() {
		return (EAttribute)eLibraryThemeFileEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getELibraryThemeFile_CpfPlatformId() {
		return (EAttribute)eLibraryThemeFileEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getELibraryThemeFile_ThemePlatformId() {
		return (EAttribute)eLibraryThemeFileEClass.getEStructuralFeatures().get(2);
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
	public ELibraryModelFactory getELibraryModelFactory() {
		return (ELibraryModelFactory)getEFactoryInstance();
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
		eLibraryElementEClass = createEClass(ELIBRARY_ELEMENT);
		createEAttribute(eLibraryElementEClass, ELIBRARY_ELEMENT__NAME);
		createEReference(eLibraryElementEClass, ELIBRARY_ELEMENT__SETTINGS);
		createEAttribute(eLibraryElementEClass, ELIBRARY_ELEMENT__READ_ONLY);
		createEAttribute(eLibraryElementEClass, ELIBRARY_ELEMENT__NOTE);
		createEAttribute(eLibraryElementEClass, ELIBRARY_ELEMENT__TIMESTAMP);
		createEAttribute(eLibraryElementEClass, ELIBRARY_ELEMENT__PATH2);
		createEAttribute(eLibraryElementEClass, ELIBRARY_ELEMENT__RESOURCE_FROM_TOP_LAYER);

		eLibraryDirectoryEClass = createEClass(ELIBRARY_DIRECTORY);
		createEReference(eLibraryDirectoryEClass, ELIBRARY_DIRECTORY__CHILDREN);

		eLibraryFileEClass = createEClass(ELIBRARY_FILE);
		createEAttribute(eLibraryFileEClass, ELIBRARY_FILE__SIZE);
		createEAttribute(eLibraryFileEClass, ELIBRARY_FILE__CONTENT_DESCRIPTION);
		createEAttribute(eLibraryFileEClass, ELIBRARY_FILE__DEFAULT_RESOURCE);

		eLibraryRootEClass = createEClass(ELIBRARY_ROOT);
		createEAttribute(eLibraryRootEClass, ELIBRARY_ROOT__TEMP_DIR_PATH);

		eLibraryThemeFileEClass = createEClass(ELIBRARY_THEME_FILE);
		createEAttribute(eLibraryThemeFileEClass, ELIBRARY_THEME_FILE__VALIDATION_MESSAGE);
		createEAttribute(eLibraryThemeFileEClass, ELIBRARY_THEME_FILE__CPF_PLATFORM_ID);
		createEAttribute(eLibraryThemeFileEClass, ELIBRARY_THEME_FILE__THEME_PLATFORM_ID);

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
		eLibraryDirectoryEClass.getESuperTypes().add(this.getELibraryElement());
		eLibraryFileEClass.getESuperTypes().add(this.getELibraryElement());
		eLibraryRootEClass.getESuperTypes().add(this.getELibraryDirectory());
		eLibraryThemeFileEClass.getESuperTypes().add(this.getELibraryFile());

		// Initialize classes and features; add operations and parameters
		initEClass(eLibraryElementEClass, ELibraryElement.class, "ELibraryElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getELibraryElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, ELibraryElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getELibraryElement_Settings(), theConfmlPackage.getSetting(), null, "settings", null, 0, -1, ELibraryElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getELibraryElement_ReadOnly(), ecorePackage.getEBoolean(), "readOnly", null, 0, 1, ELibraryElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getELibraryElement_Note(), ecorePackage.getEString(), "note", null, 0, 1, ELibraryElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getELibraryElement_Timestamp(), ecorePackage.getELong(), "timestamp", null, 0, 1, ELibraryElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getELibraryElement_Path2(), this.getEclipse_IPath(), "path2", null, 0, 1, ELibraryElement.class, !IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getELibraryElement_ResourceFromTopLayer(), ecorePackage.getEBoolean(), "resourceFromTopLayer", null, 0, 1, ELibraryElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(eLibraryElementEClass, ecorePackage.getEString(), "getPath", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(eLibraryElementEClass, ecorePackage.getEString(), "getFullPath", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(eLibraryElementEClass, ecorePackage.getEBoolean(), "delete", 0, 1, IS_UNIQUE, IS_ORDERED);

		EOperation op = addEOperation(eLibraryElementEClass, ecorePackage.getEBoolean(), "move", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getELibraryDirectory(), "target", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(eLibraryElementEClass, ecorePackage.getEBoolean(), "copy", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getELibraryDirectory(), "target", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(eLibraryElementEClass, ecorePackage.getEBoolean(), "touchedByReadonlySetting", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(eLibraryDirectoryEClass, ELibraryDirectory.class, "ELibraryDirectory", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getELibraryDirectory_Children(), this.getELibraryElement(), null, "children", null, 0, -1, ELibraryDirectory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(eLibraryDirectoryEClass, this.getELibraryElement(), "getChild", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(eLibraryDirectoryEClass, ecorePackage.getEBoolean(), "addChild", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getELibraryElement(), "child", 0, 1, !IS_UNIQUE, IS_ORDERED);

		addEOperation(eLibraryDirectoryEClass, ecorePackage.getEInt(), "getSize", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(eLibraryDirectoryEClass, ecorePackage.getEBoolean(), "deleteOnFileSystem", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(eLibraryDirectoryEClass, this.getELibraryElement(), "findChild", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getEclipse_IPath(), "path", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(eLibraryFileEClass, ELibraryFile.class, "ELibraryFile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getELibraryFile_Size(), ecorePackage.getELong(), "size", null, 0, 1, ELibraryFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getELibraryFile_ContentDescription(), this.getIContentDescription(), "contentDescription", null, 0, 1, ELibraryFile.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getELibraryFile_DefaultResource(), this.getJAVA_IO_FILE(), "defaultResource", null, 0, 1, ELibraryFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(eLibraryFileEClass, this.getInputStream(), "getInputStream", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(eLibraryFileEClass, null, "recomputeContentDescription", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(eLibraryRootEClass, ELibraryRoot.class, "ELibraryRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getELibraryRoot_TempDirPath(), ecorePackage.getEString(), "tempDirPath", null, 0, 1, ELibraryRoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eLibraryThemeFileEClass, ELibraryThemeFile.class, "ELibraryThemeFile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getELibraryThemeFile_ValidationMessage(), ecorePackage.getEString(), "validationMessage", null, 0, 1, ELibraryThemeFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getELibraryThemeFile_CpfPlatformId(), ecorePackage.getEString(), "cpfPlatformId", null, 0, 1, ELibraryThemeFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getELibraryThemeFile_ThemePlatformId(), ecorePackage.getEString(), "themePlatformId", null, 0, 1, ELibraryThemeFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize data types
		initEDataType(ePathEDataType, IPath.class, "EPath", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(eStorageEDataType, IStorage.class, "EStorage", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(inputStreamEDataType, InputStream.class, "InputStream", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(iContentTypeEDataType, IContentType.class, "IContentType", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(iContentDescriptionEDataType, IContentDescription.class, "IContentDescription", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(javA_IO_FILEEDataType, File.class, "JAVA_IO_FILE", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(eclipse_IPathEDataType, IPath.class, "Eclipse_IPath", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //resourcesPackageImpl
