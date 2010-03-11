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
 * Description: This file is part of com.nokia.tools.vct.ibyml component.
 */

package com.nokia.tools.vct.ibyml.ibymodel.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import com.nokia.tools.vct.ibyml.ibymodel.EEntity;
import com.nokia.tools.vct.ibyml.ibymodel.EEntry;
import com.nokia.tools.vct.ibyml.ibymodel.EFileName;
import com.nokia.tools.vct.ibyml.ibymodel.EIBYDocument;
import com.nokia.tools.vct.ibyml.ibymodel.EIBYFile;
import com.nokia.tools.vct.ibyml.ibymodel.EIBYModelFactory;
import com.nokia.tools.vct.ibyml.ibymodel.EIBYModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EIBYModelPackageImpl extends EPackageImpl implements EIBYModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eEntityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eibyFileEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eFileNameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eibyDocumentEClass = null;

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
	 * @see com.nokia.tools.vct.ibyml.ibymodel.EIBYModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EIBYModelPackageImpl() {
		super(eNS_URI, EIBYModelFactory.eINSTANCE);
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
	public static EIBYModelPackage init() {
		if (isInited) return (EIBYModelPackage)EPackage.Registry.INSTANCE.getEPackage(EIBYModelPackage.eNS_URI);

		// Obtain or create and register package
		EIBYModelPackageImpl theEIBYModelPackage = (EIBYModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof EIBYModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new EIBYModelPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theEIBYModelPackage.createPackageContents();

		// Initialize created meta-data
		theEIBYModelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEIBYModelPackage.freeze();

		return theEIBYModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEEntity() {
		return eEntityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEEntity_Ref() {
		return (EAttribute)eEntityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEEntity_Value() {
		return (EAttribute)eEntityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEIBYFile() {
		return eibyFileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEIBYFile_Name() {
		return (EAttribute)eibyFileEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEIBYFile_Flag() {
		return (EAttribute)eibyFileEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEIBYFile_Entries() {
		return (EReference)eibyFileEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEIBYFile_Locations() {
		return (EReference)eibyFileEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEEntry() {
		return eEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEEntry_Source() {
		return (EReference)eEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEEntry_Target() {
		return (EReference)eEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEEntry_FileName() {
		return (EReference)eEntryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEFileName() {
		return eFileNameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEFileName_Plugin() {
		return (EAttribute)eFileNameEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEFileName_Encoding() {
		return (EAttribute)eFileNameEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEIBYDocument() {
		return eibyDocumentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEIBYDocument_Root() {
		return (EReference)eibyDocumentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EIBYModelFactory getEIBYModelFactory() {
		return (EIBYModelFactory)getEFactoryInstance();
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
		eEntityEClass = createEClass(EENTITY);
		createEAttribute(eEntityEClass, EENTITY__REF);
		createEAttribute(eEntityEClass, EENTITY__VALUE);

		eibyFileEClass = createEClass(EIBY_FILE);
		createEAttribute(eibyFileEClass, EIBY_FILE__NAME);
		createEAttribute(eibyFileEClass, EIBY_FILE__FLAG);
		createEReference(eibyFileEClass, EIBY_FILE__ENTRIES);
		createEReference(eibyFileEClass, EIBY_FILE__LOCATIONS);

		eEntryEClass = createEClass(EENTRY);
		createEReference(eEntryEClass, EENTRY__SOURCE);
		createEReference(eEntryEClass, EENTRY__TARGET);
		createEReference(eEntryEClass, EENTRY__FILE_NAME);

		eFileNameEClass = createEClass(EFILE_NAME);
		createEAttribute(eFileNameEClass, EFILE_NAME__PLUGIN);
		createEAttribute(eFileNameEClass, EFILE_NAME__ENCODING);

		eibyDocumentEClass = createEClass(EIBY_DOCUMENT);
		createEReference(eibyDocumentEClass, EIBY_DOCUMENT__ROOT);
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
		eFileNameEClass.getESuperTypes().add(this.getEEntity());

		// Initialize classes and features; add operations and parameters
		initEClass(eEntityEClass, EEntity.class, "EEntity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEEntity_Ref(), ecorePackage.getEString(), "ref", null, 0, 1, EEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEEntity_Value(), ecorePackage.getEString(), "value", null, 0, 1, EEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eibyFileEClass, EIBYFile.class, "EIBYFile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEIBYFile_Name(), ecorePackage.getEString(), "name", null, 0, 1, EIBYFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEIBYFile_Flag(), ecorePackage.getEString(), "flag", null, 0, 1, EIBYFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEIBYFile_Entries(), this.getEEntry(), null, "entries", null, 0, -1, EIBYFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEIBYFile_Locations(), this.getEEntity(), null, "locations", null, 0, -1, EIBYFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eEntryEClass, EEntry.class, "EEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEEntry_Source(), this.getEEntity(), null, "source", null, 0, 1, EEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEEntry_Target(), this.getEEntity(), null, "target", null, 0, 1, EEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEEntry_FileName(), this.getEFileName(), null, "fileName", null, 0, 1, EEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eFileNameEClass, EFileName.class, "EFileName", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEFileName_Plugin(), ecorePackage.getEString(), "plugin", null, 0, 1, EFileName.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEFileName_Encoding(), ecorePackage.getEString(), "encoding", null, 0, 1, EFileName.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eibyDocumentEClass, EIBYDocument.class, "EIBYDocument", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEIBYDocument_Root(), this.getEIBYFile(), null, "root", null, 0, 1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";		
		addAnnotation
		  (eEntityEClass, 
		   source, 
		   new String[] {
			 "name", "entityType",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getEEntity_Ref(), 
		   source, 
		   new String[] {
			 "name", "ref",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getEEntity_Value(), 
		   source, 
		   new String[] {
			 "name", "value",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (eibyFileEClass, 
		   source, 
		   new String[] {
			 "name", "ibyFileType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getEIBYFile_Name(), 
		   source, 
		   new String[] {
			 "name", "name",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getEIBYFile_Flag(), 
		   source, 
		   new String[] {
			 "name", "flag",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getEIBYFile_Entries(), 
		   source, 
		   new String[] {
			 "name", "entry",
			 "kind", "element",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getEIBYFile_Locations(), 
		   source, 
		   new String[] {
			 "name", "location",
			 "kind", "element",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (eEntryEClass, 
		   source, 
		   new String[] {
			 "name", "entryType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getEEntry_Source(), 
		   source, 
		   new String[] {
			 "name", "source",
			 "kind", "element",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getEEntry_Target(), 
		   source, 
		   new String[] {
			 "name", "target",
			 "kind", "element",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getEEntry_FileName(), 
		   source, 
		   new String[] {
			 "name", "fileName",
			 "kind", "element",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (eFileNameEClass, 
		   source, 
		   new String[] {
			 "name", "fileNameType",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getEFileName_Plugin(), 
		   source, 
		   new String[] {
			 "name", "plugin",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getEFileName_Encoding(), 
		   source, 
		   new String[] {
			 "name", "encoding",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (eibyDocumentEClass, 
		   source, 
		   new String[] {
			 "name", "",
			 "kind", "mixed"
		   });		
		addAnnotation
		  (getEIBYDocument_Root(), 
		   source, 
		   new String[] {
			 "name", "ibyfile",
			 "kind", "element",
			 "namespace", "##targetNamespace"
		   });
	}

} //EIBYModelPackageImpl
