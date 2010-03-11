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

package com.nokia.tools.vct.confml.model.xsd.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import com.nokia.tools.vct.confml.model.confml1.EConfML1Package;
import com.nokia.tools.vct.confml.model.confml1.impl.EConfML1PackageImpl;
import com.nokia.tools.vct.confml.model.confml1.include.EConfMLIncludePackage;
import com.nokia.tools.vct.confml.model.confml1.include.impl.EConfMLIncludePackageImpl;
import com.nokia.tools.vct.confml.model.confml2.EConfML2Package;
import com.nokia.tools.vct.confml.model.confml2.impl.EConfML2PackageImpl;
import com.nokia.tools.vct.confml.model.metaext.EMetaExtPackage;
import com.nokia.tools.vct.confml.model.metaext.impl.EMetaExtPackageImpl;
import com.nokia.tools.vct.confml.model.xsd.EFacet;
import com.nokia.tools.vct.confml.model.xsd.ELength;
import com.nokia.tools.vct.confml.model.xsd.EMaxExclusive;
import com.nokia.tools.vct.confml.model.xsd.EMaxInclusive;
import com.nokia.tools.vct.confml.model.xsd.EMaxLength;
import com.nokia.tools.vct.confml.model.xsd.EMinExclusive;
import com.nokia.tools.vct.confml.model.xsd.EMinInclusive;
import com.nokia.tools.vct.confml.model.xsd.EMinLength;
import com.nokia.tools.vct.confml.model.xsd.ENumFacet;
import com.nokia.tools.vct.confml.model.xsd.EPattern;
import com.nokia.tools.vct.confml.model.xsd.ETotalDigits;
import com.nokia.tools.vct.confml.model.xsd.EXSDFacetFactory;
import com.nokia.tools.vct.confml.model.xsd.EXSDFacetPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EXSDFacetPackageImpl extends EPackageImpl implements
		EXSDFacetPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eFacetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eNumFacetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eMinInclusiveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eMinExclusiveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eMaxInclusiveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eMaxExclusiveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eLengthEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eMinLengthEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eMaxLengthEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eTotalDigitsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ePatternEClass = null;

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
	 * @see com.nokia.tools.vct.confml.model.xsd.EXSDFacetPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EXSDFacetPackageImpl() {
		super(eNS_URI, EXSDFacetFactory.eINSTANCE);
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
	public static EXSDFacetPackage init() {
		if (isInited)
			return (EXSDFacetPackage) EPackage.Registry.INSTANCE
					.getEPackage(EXSDFacetPackage.eNS_URI);

		// Obtain or create and register package
		EXSDFacetPackageImpl theEXSDFacetPackage = (EXSDFacetPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(eNS_URI) instanceof EXSDFacetPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(eNS_URI)
				: new EXSDFacetPackageImpl());

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
		EMetaExtPackageImpl theEMetaExtPackage = (EMetaExtPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(EMetaExtPackage.eNS_URI) instanceof EMetaExtPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(EMetaExtPackage.eNS_URI)
				: EMetaExtPackage.eINSTANCE);

		// Create package meta-data objects
		theEXSDFacetPackage.createPackageContents();
		theEConfML1Package.createPackageContents();
		theEConfMLIncludePackage.createPackageContents();
		theEConfML2Package.createPackageContents();
		theEMetaExtPackage.createPackageContents();

		// Initialize created meta-data
		theEXSDFacetPackage.initializePackageContents();
		theEConfML1Package.initializePackageContents();
		theEConfMLIncludePackage.initializePackageContents();
		theEConfML2Package.initializePackageContents();
		theEMetaExtPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEXSDFacetPackage.freeze();

		return theEXSDFacetPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEFacet() {
		return eFacetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEFacet_Value() {
		return (EAttribute) eFacetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEFacet_Fixed() {
		return (EAttribute) eFacetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getENumFacet() {
		return eNumFacetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEMinInclusive() {
		return eMinInclusiveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEMinExclusive() {
		return eMinExclusiveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEMaxInclusive() {
		return eMaxInclusiveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEMaxExclusive() {
		return eMaxExclusiveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getELength() {
		return eLengthEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEMinLength() {
		return eMinLengthEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEMaxLength() {
		return eMaxLengthEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getETotalDigits() {
		return eTotalDigitsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEPattern() {
		return ePatternEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EXSDFacetFactory getEXSDFacetFactory() {
		return (EXSDFacetFactory) getEFactoryInstance();
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
		eFacetEClass = createEClass(EFACET);
		createEAttribute(eFacetEClass, EFACET__VALUE);
		createEAttribute(eFacetEClass, EFACET__FIXED);

		eNumFacetEClass = createEClass(ENUM_FACET);

		eMinInclusiveEClass = createEClass(EMIN_INCLUSIVE);

		eMinExclusiveEClass = createEClass(EMIN_EXCLUSIVE);

		eMaxInclusiveEClass = createEClass(EMAX_INCLUSIVE);

		eMaxExclusiveEClass = createEClass(EMAX_EXCLUSIVE);

		eLengthEClass = createEClass(ELENGTH);

		eMinLengthEClass = createEClass(EMIN_LENGTH);

		eMaxLengthEClass = createEClass(EMAX_LENGTH);

		eTotalDigitsEClass = createEClass(ETOTAL_DIGITS);

		ePatternEClass = createEClass(EPATTERN);
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
		eNumFacetEClass.getESuperTypes().add(this.getEFacet());
		eMinInclusiveEClass.getESuperTypes().add(this.getEFacet());
		eMinExclusiveEClass.getESuperTypes().add(this.getEFacet());
		eMaxInclusiveEClass.getESuperTypes().add(this.getEFacet());
		eMaxExclusiveEClass.getESuperTypes().add(this.getEFacet());
		eLengthEClass.getESuperTypes().add(this.getENumFacet());
		eMinLengthEClass.getESuperTypes().add(this.getENumFacet());
		eMaxLengthEClass.getESuperTypes().add(this.getENumFacet());
		eTotalDigitsEClass.getESuperTypes().add(this.getENumFacet());
		ePatternEClass.getESuperTypes().add(this.getEFacet());

		// Initialize classes and features; add operations and parameters
		initEClass(eFacetEClass, EFacet.class, "EFacet", IS_ABSTRACT,
				IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEFacet_Value(), ecorePackage.getEString(), "value",
				null, 1, 1, EFacet.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getEFacet_Fixed(), ecorePackage.getEString(), "fixed",
				null, 0, 1, EFacet.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		initEClass(eNumFacetEClass, ENumFacet.class, "ENumFacet", IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(eMinInclusiveEClass, EMinInclusive.class, "EMinInclusive",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(eMinExclusiveEClass, EMinExclusive.class, "EMinExclusive",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(eMaxInclusiveEClass, EMaxInclusive.class, "EMaxInclusive",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(eMaxExclusiveEClass, EMaxExclusive.class, "EMaxExclusive",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(eLengthEClass, ELength.class, "ELength", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(eMinLengthEClass, EMinLength.class, "EMinLength",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(eMaxLengthEClass, EMaxLength.class, "EMaxLength",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(eTotalDigitsEClass, ETotalDigits.class, "ETotalDigits",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ePatternEClass, EPattern.class, "EPattern", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //EXSDFacetPackageImpl
