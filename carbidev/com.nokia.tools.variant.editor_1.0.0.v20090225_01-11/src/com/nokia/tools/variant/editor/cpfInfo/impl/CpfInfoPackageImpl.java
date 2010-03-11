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
 * Description: This file is part of com.nokia.tools.variant.editor component.
 */

package com.nokia.tools.variant.editor.cpfInfo.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import com.nokia.tools.variant.editor.cpfInfo.CPFInformation;
import com.nokia.tools.variant.editor.cpfInfo.CpfInfoFactory;
import com.nokia.tools.variant.editor.cpfInfo.CpfInfoPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CpfInfoPackageImpl extends EPackageImpl implements CpfInfoPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cpfEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cpfInformationEClass = null;

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
	 * @see com.nokia.tools.variant.editor.cpfInfo.CpfInfoPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CpfInfoPackageImpl() {
		super(eNS_URI, CpfInfoFactory.eINSTANCE);
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
	public static CpfInfoPackage init() {
		if (isInited) return (CpfInfoPackage)EPackage.Registry.INSTANCE.getEPackage(CpfInfoPackage.eNS_URI);

		// Obtain or create and register package
		CpfInfoPackageImpl theCpfInfoPackage = (CpfInfoPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof CpfInfoPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new CpfInfoPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theCpfInfoPackage.createPackageContents();

		// Initialize created meta-data
		theCpfInfoPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCpfInfoPackage.freeze();

		return theCpfInfoPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCPF() {
		return cpfEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCPF_CpfInfo() {
		return (EReference)cpfEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCPFInformation() {
		return cpfInformationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCPFInformation_Name() {
		return (EAttribute)cpfInformationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCPFInformation_Author() {
		return (EAttribute)cpfInformationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCPFInformation_Owner() {
		return (EAttribute)cpfInformationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCPFInformation_Version() {
		return (EAttribute)cpfInformationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCPFInformation_Platform() {
		return (EAttribute)cpfInformationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCPFInformation_Date() {
		return (EAttribute)cpfInformationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCPFInformation_Release() {
		return (EAttribute)cpfInformationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCPFInformation_DataFile() {
		return (EAttribute)cpfInformationEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCPFInformation_ViewId() {
		return (EAttribute)cpfInformationEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCPFInformation_Description() {
		return (EAttribute)cpfInformationEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCPFInformation_Product() {
		return (EAttribute)cpfInformationEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCPFInformation_Customer() {
		return (EAttribute)cpfInformationEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCPFInformation_Status() {
		return (EAttribute)cpfInformationEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCPFInformation_Origin() {
		return (EAttribute)cpfInformationEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCPFInformation_Target() {
		return (EAttribute)cpfInformationEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCPFInformation_RootConfMLPath() {
		return (EAttribute)cpfInformationEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCPFInformation_LayerPopupInfoText() {
		return (EAttribute)cpfInformationEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CpfInfoFactory getCpfInfoFactory() {
		return (CpfInfoFactory)getEFactoryInstance();
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
		cpfEClass = createEClass(CPF);
		createEReference(cpfEClass, CPF__CPF_INFO);

		cpfInformationEClass = createEClass(CPF_INFORMATION);
		createEAttribute(cpfInformationEClass, CPF_INFORMATION__NAME);
		createEAttribute(cpfInformationEClass, CPF_INFORMATION__AUTHOR);
		createEAttribute(cpfInformationEClass, CPF_INFORMATION__OWNER);
		createEAttribute(cpfInformationEClass, CPF_INFORMATION__VERSION);
		createEAttribute(cpfInformationEClass, CPF_INFORMATION__PLATFORM);
		createEAttribute(cpfInformationEClass, CPF_INFORMATION__DATE);
		createEAttribute(cpfInformationEClass, CPF_INFORMATION__RELEASE);
		createEAttribute(cpfInformationEClass, CPF_INFORMATION__DATA_FILE);
		createEAttribute(cpfInformationEClass, CPF_INFORMATION__VIEW_ID);
		createEAttribute(cpfInformationEClass, CPF_INFORMATION__DESCRIPTION);
		createEAttribute(cpfInformationEClass, CPF_INFORMATION__PRODUCT);
		createEAttribute(cpfInformationEClass, CPF_INFORMATION__CUSTOMER);
		createEAttribute(cpfInformationEClass, CPF_INFORMATION__STATUS);
		createEAttribute(cpfInformationEClass, CPF_INFORMATION__ORIGIN);
		createEAttribute(cpfInformationEClass, CPF_INFORMATION__TARGET);
		createEAttribute(cpfInformationEClass, CPF_INFORMATION__ROOT_CONF_ML_PATH);
		createEAttribute(cpfInformationEClass, CPF_INFORMATION__LAYER_POPUP_INFO_TEXT);
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
		initEClass(cpfEClass, com.nokia.tools.variant.editor.cpfInfo.CPF.class, "CPF", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCPF_CpfInfo(), this.getCPFInformation(), null, "cpfInfo", null, 1, 1, com.nokia.tools.variant.editor.cpfInfo.CPF.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cpfInformationEClass, CPFInformation.class, "CPFInformation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCPFInformation_Name(), ecorePackage.getEString(), "name", null, 0, 1, CPFInformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCPFInformation_Author(), ecorePackage.getEString(), "author", null, 0, 1, CPFInformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCPFInformation_Owner(), ecorePackage.getEString(), "owner", null, 0, 1, CPFInformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCPFInformation_Version(), ecorePackage.getEString(), "version", null, 0, 1, CPFInformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCPFInformation_Platform(), ecorePackage.getEString(), "platform", null, 0, 1, CPFInformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCPFInformation_Date(), ecorePackage.getEString(), "date", null, 0, 1, CPFInformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCPFInformation_Release(), ecorePackage.getEString(), "release", null, 0, 1, CPFInformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCPFInformation_DataFile(), ecorePackage.getEString(), "dataFile", null, 0, 1, CPFInformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCPFInformation_ViewId(), ecorePackage.getEString(), "viewId", null, 0, 1, CPFInformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCPFInformation_Description(), ecorePackage.getEString(), "description", null, 0, 1, CPFInformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCPFInformation_Product(), ecorePackage.getEString(), "product", null, 0, 1, CPFInformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCPFInformation_Customer(), ecorePackage.getEString(), "customer", null, 0, 1, CPFInformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCPFInformation_Status(), ecorePackage.getEString(), "status", null, 0, 1, CPFInformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCPFInformation_Origin(), ecorePackage.getEString(), "origin", null, 0, 1, CPFInformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCPFInformation_Target(), ecorePackage.getEString(), "target", null, 0, 1, CPFInformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCPFInformation_RootConfMLPath(), ecorePackage.getEString(), "rootConfMLPath", null, 0, 1, CPFInformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCPFInformation_LayerPopupInfoText(), ecorePackage.getEString(), "layerPopupInfoText", null, 0, 1, CPFInformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //CpfInfoPackageImpl
