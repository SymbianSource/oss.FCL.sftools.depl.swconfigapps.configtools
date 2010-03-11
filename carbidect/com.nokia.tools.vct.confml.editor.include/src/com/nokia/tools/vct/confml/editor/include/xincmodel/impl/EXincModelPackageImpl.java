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
 * Description: This file is part of com.nokia.tools.vct.confml.editor.include component.
 */

package com.nokia.tools.vct.confml.editor.include.xincmodel.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import com.nokia.tools.vct.confml.editor.include.xincmodel.EConfMLVersion;
import com.nokia.tools.vct.confml.editor.include.xincmodel.EDocument;
import com.nokia.tools.vct.confml.editor.include.xincmodel.EInclude;
import com.nokia.tools.vct.confml.editor.include.xincmodel.EProjectFile;
import com.nokia.tools.vct.confml.editor.include.xincmodel.EProjectFolder;
import com.nokia.tools.vct.confml.editor.include.xincmodel.EProjectResource;
import com.nokia.tools.vct.confml.editor.include.xincmodel.EResourceContainer;
import com.nokia.tools.vct.confml.editor.include.xincmodel.EXincModelFactory;
import com.nokia.tools.vct.confml.editor.include.xincmodel.EXincModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EXincModelPackageImpl extends EPackageImpl implements EXincModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eDocumentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eIncludeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eProjectFileEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eProjectResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eProjectFolderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eResourceContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eConfMLVersionEEnum = null;

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
	 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.EXincModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EXincModelPackageImpl() {
		super(eNS_URI, EXincModelFactory.eINSTANCE);
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
	public static EXincModelPackage init() {
		if (isInited) return (EXincModelPackage)EPackage.Registry.INSTANCE.getEPackage(EXincModelPackage.eNS_URI);

		// Obtain or create and register package
		EXincModelPackageImpl theEXincModelPackage = (EXincModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof EXincModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new EXincModelPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theEXincModelPackage.createPackageContents();

		// Initialize created meta-data
		theEXincModelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEXincModelPackage.freeze();

		return theEXincModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEDocument() {
		return eDocumentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEDocument_Includes() {
		return (EReference)eDocumentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEDocument_Version() {
		return (EAttribute)eDocumentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEDocument_Name() {
		return (EAttribute)eDocumentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEInclude() {
		return eIncludeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEInclude_Href() {
		return (EAttribute)eIncludeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEInclude_Target() {
		return (EReference)eIncludeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEProjectFile() {
		return eProjectFileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEProjectFile_Resource() {
		return (EAttribute)eProjectFileEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEProjectFile_Included() {
		return (EReference)eProjectFileEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEProjectFile_Version() {
		return (EAttribute)eProjectFileEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEProjectResource() {
		return eProjectResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEProjectResource_Name() {
		return (EAttribute)eProjectResourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEProjectResource_ProjectPath() {
		return (EAttribute)eProjectResourceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEProjectFolder() {
		return eProjectFolderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEResourceContainer() {
		return eResourceContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEResourceContainer_Resources() {
		return (EReference)eResourceContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEConfMLVersion() {
		return eConfMLVersionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EXincModelFactory getEXincModelFactory() {
		return (EXincModelFactory)getEFactoryInstance();
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
		eDocumentEClass = createEClass(EDOCUMENT);
		createEReference(eDocumentEClass, EDOCUMENT__INCLUDES);
		createEAttribute(eDocumentEClass, EDOCUMENT__VERSION);
		createEAttribute(eDocumentEClass, EDOCUMENT__NAME);

		eIncludeEClass = createEClass(EINCLUDE);
		createEAttribute(eIncludeEClass, EINCLUDE__HREF);
		createEReference(eIncludeEClass, EINCLUDE__TARGET);

		eProjectFileEClass = createEClass(EPROJECT_FILE);
		createEAttribute(eProjectFileEClass, EPROJECT_FILE__RESOURCE);
		createEReference(eProjectFileEClass, EPROJECT_FILE__INCLUDED);
		createEAttribute(eProjectFileEClass, EPROJECT_FILE__VERSION);

		eProjectResourceEClass = createEClass(EPROJECT_RESOURCE);
		createEAttribute(eProjectResourceEClass, EPROJECT_RESOURCE__NAME);
		createEAttribute(eProjectResourceEClass, EPROJECT_RESOURCE__PROJECT_PATH);

		eProjectFolderEClass = createEClass(EPROJECT_FOLDER);

		eResourceContainerEClass = createEClass(ERESOURCE_CONTAINER);
		createEReference(eResourceContainerEClass, ERESOURCE_CONTAINER__RESOURCES);

		// Create enums
		eConfMLVersionEEnum = createEEnum(ECONF_ML_VERSION);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		eDocumentEClass.getESuperTypes().add(this.getEResourceContainer());
		eProjectFileEClass.getESuperTypes().add(this.getEProjectResource());
		eProjectFolderEClass.getESuperTypes().add(this.getEProjectResource());
		eProjectFolderEClass.getESuperTypes().add(this.getEResourceContainer());

		// Initialize classes and features; add operations and parameters
		initEClass(eDocumentEClass, EDocument.class, "EDocument", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEDocument_Includes(), this.getEInclude(), null, "includes", null, 0, -1, EDocument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEDocument_Version(), this.getEConfMLVersion(), "version", null, 1, 1, EDocument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEDocument_Name(), ecorePackage.getEString(), "name", null, 0, 1, EDocument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eIncludeEClass, EInclude.class, "EInclude", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEInclude_Href(), ecorePackage.getEString(), "href", null, 0, 1, EInclude.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEInclude_Target(), this.getEProjectFile(), this.getEProjectFile_Included(), "target", null, 0, 1, EInclude.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eProjectFileEClass, EProjectFile.class, "EProjectFile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEProjectFile_Resource(), ecorePackage.getEResource(), "resource", null, 0, 1, EProjectFile.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEProjectFile_Included(), this.getEInclude(), this.getEInclude_Target(), "included", null, 0, -1, EProjectFile.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEProjectFile_Version(), this.getEConfMLVersion(), "version", null, 0, 1, EProjectFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eProjectResourceEClass, EProjectResource.class, "EProjectResource", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEProjectResource_Name(), ecorePackage.getEString(), "name", null, 1, 1, EProjectResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEProjectResource_ProjectPath(), ecorePackage.getEString(), "projectPath", null, 0, 1, EProjectResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eProjectFolderEClass, EProjectFolder.class, "EProjectFolder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(eResourceContainerEClass, EResourceContainer.class, "EResourceContainer", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEResourceContainer_Resources(), this.getEProjectResource(), null, "resources", null, 0, -1, EResourceContainer.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(eConfMLVersionEEnum, EConfMLVersion.class, "EConfMLVersion");
		addEEnumLiteral(eConfMLVersionEEnum, EConfMLVersion.CONFML1);
		addEEnumLiteral(eConfMLVersionEEnum, EConfMLVersion.CONFML2);

		// Create resource
		createResource(eNS_URI);
	}

} //EXincModelPackageImpl
