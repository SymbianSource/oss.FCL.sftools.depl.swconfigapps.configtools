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
 * Description: This file is part of com.nokia.tools.variant.confml.core component.
 */

package com.nokia.tools.variant.confml.core.model.metadata.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import com.nokia.tools.variant.confml.core.model.core.EConfmlRootPackage;
import com.nokia.tools.variant.confml.core.model.core.impl.EConfmlRootPackageImpl;
import com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata;
import com.nokia.tools.variant.confml.core.model.metadata.EMetaComponent;
import com.nokia.tools.variant.confml.core.model.metadata.EMetaProperty;
import com.nokia.tools.variant.confml.core.model.metadata.EMetadata;
import com.nokia.tools.variant.confml.core.model.metadata.EMetadataFactory;
import com.nokia.tools.variant.confml.core.model.metadata.EMetadataPackage;
import com.nokia.tools.vct.common.appmodel.EApplicationPackage;
import com.nokia.tools.vct.common.appmodel.impl.EApplicationPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EMetadataPackageImpl extends EPackageImpl implements EMetadataPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eMetadataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eMetaComponentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eMetaPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ecpfMetadataEClass = null;

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
	 * @see com.nokia.tools.variant.confml.core.model.metadata.EMetadataPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EMetadataPackageImpl() {
		super(eNS_URI, EMetadataFactory.eINSTANCE);
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
	public static EMetadataPackage init() {
		if (isInited) return (EMetadataPackage)EPackage.Registry.INSTANCE.getEPackage(EMetadataPackage.eNS_URI);

		// Obtain or create and register package
		EMetadataPackageImpl theEMetadataPackage = (EMetadataPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof EMetadataPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new EMetadataPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		EConfmlRootPackageImpl theEConfmlRootPackage = (EConfmlRootPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EConfmlRootPackage.eNS_URI) instanceof EConfmlRootPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EConfmlRootPackage.eNS_URI) : EConfmlRootPackage.eINSTANCE);
		EApplicationPackageImpl theEApplicationPackage = (EApplicationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EApplicationPackage.eNS_URI) instanceof EApplicationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EApplicationPackage.eNS_URI) : EApplicationPackage.eINSTANCE);

		// Create package meta-data objects
		theEMetadataPackage.createPackageContents();
		theEConfmlRootPackage.createPackageContents();
		theEApplicationPackage.createPackageContents();

		// Initialize created meta-data
		theEMetadataPackage.initializePackageContents();
		theEConfmlRootPackage.initializePackageContents();
		theEApplicationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEMetadataPackage.freeze();

		return theEMetadataPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEMetadata() {
		return eMetadataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEMetadata_Components() {
		return (EReference)eMetadataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEMetadata_Properties() {
		return (EReference)eMetadataEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEMetaComponent() {
		return eMetaComponentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEMetaComponent_Type() {
		return (EAttribute)eMetaComponentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEMetaComponent_Path() {
		return (EAttribute)eMetaComponentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEMetaProperty() {
		return eMetaPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEMetaProperty_Name() {
		return (EAttribute)eMetaPropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEMetaProperty_Value() {
		return (EAttribute)eMetaPropertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getECPFMetadata() {
		return ecpfMetadataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getECPFMetadata_Name() {
		return (EAttribute)ecpfMetadataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getECPFMetadata_Description() {
		return (EAttribute)ecpfMetadataEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getECPFMetadata_ViewId() {
		return (EAttribute)ecpfMetadataEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getECPFMetadata_CpfRootFile() {
		return (EAttribute)ecpfMetadataEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getECPFMetadata_Author() {
		return (EAttribute)ecpfMetadataEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getECPFMetadata_Version() {
		return (EAttribute)ecpfMetadataEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getECPFMetadata_DataOverrideFile() {
		return (EAttribute)ecpfMetadataEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getECPFMetadata_Product() {
		return (EAttribute)ecpfMetadataEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getECPFMetadata_Platform() {
		return (EAttribute)ecpfMetadataEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getECPFMetadata_Release() {
		return (EAttribute)ecpfMetadataEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getECPFMetadata_Customer() {
		return (EAttribute)ecpfMetadataEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getECPFMetadata_Owner() {
		return (EAttribute)ecpfMetadataEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getECPFMetadata_Date() {
		return (EAttribute)ecpfMetadataEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMetadataFactory getEMetadataFactory() {
		return (EMetadataFactory)getEFactoryInstance();
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
		eMetadataEClass = createEClass(EMETADATA);
		createEReference(eMetadataEClass, EMETADATA__COMPONENTS);
		createEReference(eMetadataEClass, EMETADATA__PROPERTIES);

		eMetaComponentEClass = createEClass(EMETA_COMPONENT);
		createEAttribute(eMetaComponentEClass, EMETA_COMPONENT__TYPE);
		createEAttribute(eMetaComponentEClass, EMETA_COMPONENT__PATH);

		eMetaPropertyEClass = createEClass(EMETA_PROPERTY);
		createEAttribute(eMetaPropertyEClass, EMETA_PROPERTY__NAME);
		createEAttribute(eMetaPropertyEClass, EMETA_PROPERTY__VALUE);

		ecpfMetadataEClass = createEClass(ECPF_METADATA);
		createEAttribute(ecpfMetadataEClass, ECPF_METADATA__NAME);
		createEAttribute(ecpfMetadataEClass, ECPF_METADATA__DESCRIPTION);
		createEAttribute(ecpfMetadataEClass, ECPF_METADATA__VIEW_ID);
		createEAttribute(ecpfMetadataEClass, ECPF_METADATA__CPF_ROOT_FILE);
		createEAttribute(ecpfMetadataEClass, ECPF_METADATA__AUTHOR);
		createEAttribute(ecpfMetadataEClass, ECPF_METADATA__VERSION);
		createEAttribute(ecpfMetadataEClass, ECPF_METADATA__DATA_OVERRIDE_FILE);
		createEAttribute(ecpfMetadataEClass, ECPF_METADATA__PRODUCT);
		createEAttribute(ecpfMetadataEClass, ECPF_METADATA__PLATFORM);
		createEAttribute(ecpfMetadataEClass, ECPF_METADATA__RELEASE);
		createEAttribute(ecpfMetadataEClass, ECPF_METADATA__CUSTOMER);
		createEAttribute(ecpfMetadataEClass, ECPF_METADATA__OWNER);
		createEAttribute(ecpfMetadataEClass, ECPF_METADATA__DATE);
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

		// Initialize classes and features; add operations and parameters
		initEClass(eMetadataEClass, EMetadata.class, "EMetadata", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEMetadata_Components(), this.getEMetaComponent(), null, "components", null, 0, -1, EMetadata.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEMetadata_Properties(), this.getEMetaProperty(), null, "properties", null, 0, -1, EMetadata.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eMetaComponentEClass, EMetaComponent.class, "EMetaComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEMetaComponent_Type(), ecorePackage.getEString(), "type", null, 1, 1, EMetaComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEMetaComponent_Path(), ecorePackage.getEString(), "path", null, 1, 1, EMetaComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eMetaPropertyEClass, EMetaProperty.class, "EMetaProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEMetaProperty_Name(), ecorePackage.getEString(), "name", null, 1, 1, EMetaProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEMetaProperty_Value(), ecorePackage.getEString(), "value", null, 1, 1, EMetaProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ecpfMetadataEClass, ECPFMetadata.class, "ECPFMetadata", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getECPFMetadata_Name(), ecorePackage.getEString(), "name", null, 1, 1, ECPFMetadata.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getECPFMetadata_Description(), ecorePackage.getEString(), "description", null, 1, 1, ECPFMetadata.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getECPFMetadata_ViewId(), ecorePackage.getEString(), "viewId", null, 1, 1, ECPFMetadata.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getECPFMetadata_CpfRootFile(), ecorePackage.getEString(), "cpfRootFile", null, 1, 1, ECPFMetadata.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getECPFMetadata_Author(), ecorePackage.getEString(), "author", null, 1, 1, ECPFMetadata.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getECPFMetadata_Version(), ecorePackage.getEString(), "version", null, 1, 1, ECPFMetadata.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getECPFMetadata_DataOverrideFile(), ecorePackage.getEString(), "dataOverrideFile", null, 1, 1, ECPFMetadata.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getECPFMetadata_Product(), ecorePackage.getEString(), "product", null, 1, 1, ECPFMetadata.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getECPFMetadata_Platform(), ecorePackage.getEString(), "platform", null, 1, 1, ECPFMetadata.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getECPFMetadata_Release(), ecorePackage.getEString(), "release", null, 1, 1, ECPFMetadata.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getECPFMetadata_Customer(), ecorePackage.getEString(), "customer", null, 1, 1, ECPFMetadata.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getECPFMetadata_Owner(), ecorePackage.getEString(), "owner", null, 1, 1, ECPFMetadata.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getECPFMetadata_Date(), ecorePackage.getEString(), "date", null, 1, 1, ECPFMetadata.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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
		  (eMetadataEClass, 
		   source, 
		   new String[] {
			 "name", "metadata",
			 "kind", "elementOnly",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getEMetadata_Components(), 
		   source, 
		   new String[] {
			 "name", "component",
			 "kind", "element",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getEMetadata_Properties(), 
		   source, 
		   new String[] {
			 "name", "property",
			 "kind", "element",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (eMetaComponentEClass, 
		   source, 
		   new String[] {
			 "name", "component",
			 "kind", "empty",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (eMetaPropertyEClass, 
		   source, 
		   new String[] {
			 "name", "property",
			 "kind", "empty",
			 "namespace", "##targetNamespace"
		   });
	}

} //EMetadataPackageImpl
