/**
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
 * $Id$
 */
package com.nokia.tools.carbide.ct.confml.model.metaext.impl;

import com.nokia.tools.carbide.ct.confml.model.confml1.EConfML1Package;

import com.nokia.tools.carbide.ct.confml.model.confml1.impl.EConfML1PackageImpl;

import com.nokia.tools.carbide.ct.confml.model.confml1.include.EConfMLIncludePackage;

import com.nokia.tools.carbide.ct.confml.model.confml1.include.impl.EConfMLIncludePackageImpl;

import com.nokia.tools.carbide.ct.confml.model.confml2.EConfML2Package;

import com.nokia.tools.carbide.ct.confml.model.confml2.impl.EConfML2PackageImpl;

import com.nokia.tools.carbide.ct.confml.model.metaext.EConfigurationPropertyElement;
import com.nokia.tools.carbide.ct.confml.model.metaext.EMetaExtFactory;
import com.nokia.tools.carbide.ct.confml.model.metaext.EMetaExtPackage;

import com.nokia.tools.carbide.ct.confml.model.xsd.EXSDFacetPackage;

import com.nokia.tools.carbide.ct.confml.model.xsd.impl.EXSDFacetPackageImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EMetaExtPackageImpl extends EPackageImpl implements
		EMetaExtPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eConfigurationPropertyElementEClass = null;

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
	 * @see com.nokia.tools.carbide.ct.confml.model.metaext.EMetaExtPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EMetaExtPackageImpl() {
		super(eNS_URI, EMetaExtFactory.eINSTANCE);
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
	public static EMetaExtPackage init() {
		if (isInited)
			return (EMetaExtPackage) EPackage.Registry.INSTANCE
					.getEPackage(EMetaExtPackage.eNS_URI);

		// Obtain or create and register package
		EMetaExtPackageImpl theEMetaExtPackage = (EMetaExtPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(eNS_URI) instanceof EMetaExtPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(eNS_URI)
				: new EMetaExtPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		EConfML1PackageImpl theEConfML1Package = (EConfML1PackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(EConfML1Package.eNS_URI) instanceof EConfML1PackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(EConfML1Package.eNS_URI)
				: EConfML1Package.eINSTANCE);
		EConfMLIncludePackageImpl theEConfMLIncludePackage = (EConfMLIncludePackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(EConfMLIncludePackage.eNS_URI) instanceof EConfMLIncludePackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(EConfMLIncludePackage.eNS_URI)
				: EConfMLIncludePackage.eINSTANCE);
		EConfML2PackageImpl theEConfML2Package = (EConfML2PackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(EConfML2Package.eNS_URI) instanceof EConfML2PackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(EConfML2Package.eNS_URI)
				: EConfML2Package.eINSTANCE);
		EXSDFacetPackageImpl theEXSDFacetPackage = (EXSDFacetPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(EXSDFacetPackage.eNS_URI) instanceof EXSDFacetPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(EXSDFacetPackage.eNS_URI)
				: EXSDFacetPackage.eINSTANCE);

		// Create package meta-data objects
		theEMetaExtPackage.createPackageContents();
		theEConfML1Package.createPackageContents();
		theEConfMLIncludePackage.createPackageContents();
		theEConfML2Package.createPackageContents();
		theEXSDFacetPackage.createPackageContents();

		// Initialize created meta-data
		theEMetaExtPackage.initializePackageContents();
		theEConfML1Package.initializePackageContents();
		theEConfMLIncludePackage.initializePackageContents();
		theEConfML2Package.initializePackageContents();
		theEXSDFacetPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEMetaExtPackage.freeze();

		return theEMetaExtPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEConfigurationPropertyElement() {
		return eConfigurationPropertyElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEConfigurationPropertyElement_Name() {
		return (EAttribute) eConfigurationPropertyElementEClass
				.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEConfigurationPropertyElement_Value() {
		return (EAttribute) eConfigurationPropertyElementEClass
				.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMetaExtFactory getEMetaExtFactory() {
		return (EMetaExtFactory) getEFactoryInstance();
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
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		eConfigurationPropertyElementEClass = createEClass(ECONFIGURATION_PROPERTY_ELEMENT);
		createEAttribute(eConfigurationPropertyElementEClass,
				ECONFIGURATION_PROPERTY_ELEMENT__NAME);
		createEAttribute(eConfigurationPropertyElementEClass,
				ECONFIGURATION_PROPERTY_ELEMENT__VALUE);
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
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(eConfigurationPropertyElementEClass,
				EConfigurationPropertyElement.class,
				"EConfigurationPropertyElement", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEConfigurationPropertyElement_Name(), ecorePackage
				.getEString(), "name", null, 0, 1,
				EConfigurationPropertyElement.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getEConfigurationPropertyElement_Value(), ecorePackage
				.getEString(), "value", null, 0, 1,
				EConfigurationPropertyElement.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

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
		addAnnotation(eConfigurationPropertyElementEClass, source,
				new String[] { "name", "configuration-property", "kind",
						"empty", "namespace",
						"http://www.nokia.com/xml/cpf-id/1" });
	}

} //EMetaExtPackageImpl
