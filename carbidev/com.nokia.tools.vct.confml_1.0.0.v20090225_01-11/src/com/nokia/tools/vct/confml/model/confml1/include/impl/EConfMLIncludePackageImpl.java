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
 * Description: This file is part of com.nokia.tools.vct.confml component.
 */

package com.nokia.tools.vct.confml.model.confml1.include.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import com.nokia.tools.vct.confml.model.confml1.EConfML1Package;
import com.nokia.tools.vct.confml.model.confml1.impl.EConfML1PackageImpl;
import com.nokia.tools.vct.confml.model.confml1.include.EConfMLIncludeFactory;
import com.nokia.tools.vct.confml.model.confml1.include.EConfMLIncludePackage;
import com.nokia.tools.vct.confml.model.confml1.include.EInclude;
import com.nokia.tools.vct.confml.model.confml2.EConfML2Package;
import com.nokia.tools.vct.confml.model.confml2.impl.EConfML2PackageImpl;
import com.nokia.tools.vct.confml.model.xsd.EXSDFacetPackage;
import com.nokia.tools.vct.confml.model.xsd.impl.EXSDFacetPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EConfMLIncludePackageImpl extends EPackageImpl implements
		EConfMLIncludePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eIncludeEClass = null;

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
	 * @see com.nokia.tools.vct.confml.model.confml1.include.EConfMLIncludePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EConfMLIncludePackageImpl() {
		super(eNS_URI, EConfMLIncludeFactory.eINSTANCE);
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
	public static EConfMLIncludePackage init() {
		if (isInited)
			return (EConfMLIncludePackage) EPackage.Registry.INSTANCE
					.getEPackage(EConfMLIncludePackage.eNS_URI);

		// Obtain or create and register package
		EConfMLIncludePackageImpl theEConfMLIncludePackage = (EConfMLIncludePackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(eNS_URI) instanceof EConfMLIncludePackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(eNS_URI)
				: new EConfMLIncludePackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		EConfML1PackageImpl theEConfML1Package = (EConfML1PackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(EConfML1Package.eNS_URI) instanceof EConfML1PackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(EConfML1Package.eNS_URI)
				: EConfML1Package.eINSTANCE);
		EConfML2PackageImpl theEConfML2Package = (EConfML2PackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(EConfML2Package.eNS_URI) instanceof EConfML2PackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(EConfML2Package.eNS_URI)
				: EConfML2Package.eINSTANCE);
		EXSDFacetPackageImpl theEXSDFacetPackage = (EXSDFacetPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(EXSDFacetPackage.eNS_URI) instanceof EXSDFacetPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(EXSDFacetPackage.eNS_URI)
				: EXSDFacetPackage.eINSTANCE);

		// Create package meta-data objects
		theEConfMLIncludePackage.createPackageContents();
		theEConfML1Package.createPackageContents();
		theEConfML2Package.createPackageContents();
		theEXSDFacetPackage.createPackageContents();

		// Initialize created meta-data
		theEConfMLIncludePackage.initializePackageContents();
		theEConfML1Package.initializePackageContents();
		theEConfML2Package.initializePackageContents();
		theEXSDFacetPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEConfMLIncludePackage.freeze();

		return theEConfMLIncludePackage;
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
		return (EAttribute) eIncludeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EConfMLIncludeFactory getEConfMLIncludeFactory() {
		return (EConfMLIncludeFactory) getEFactoryInstance();
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
		eIncludeEClass = createEClass(EINCLUDE);
		createEAttribute(eIncludeEClass, EINCLUDE__HREF);
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
		initEClass(eIncludeEClass, EInclude.class, "EInclude", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEInclude_Href(), ecorePackage.getEString(), "href",
				null, 0, 1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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
		addAnnotation(eIncludeEClass, source, new String[] { "name", "",
				"kind", "empty" });
	}

} //EConfMLIncludePackageImpl
