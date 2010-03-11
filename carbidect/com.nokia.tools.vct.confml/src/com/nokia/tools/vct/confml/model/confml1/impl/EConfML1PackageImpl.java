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

package com.nokia.tools.vct.confml.model.confml1.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import com.nokia.tools.vct.confml.model.confml1.ECommonAttrs;
import com.nokia.tools.vct.confml.model.confml1.EConfML1Factory;
import com.nokia.tools.vct.confml.model.confml1.EConfML1Package;
import com.nokia.tools.vct.confml.model.confml1.EConfMLDocument;
import com.nokia.tools.vct.confml.model.confml1.EConfigurationElement;
import com.nokia.tools.vct.confml.model.confml1.EDataElement;
import com.nokia.tools.vct.confml.model.confml1.EDescriptionContainer;
import com.nokia.tools.vct.confml.model.confml1.EDescriptionElement;
import com.nokia.tools.vct.confml.model.confml1.EFeatureData;
import com.nokia.tools.vct.confml.model.confml1.EFeatureElement;
import com.nokia.tools.vct.confml.model.confml1.EFeatureRfs;
import com.nokia.tools.vct.confml.model.confml1.EGroup;
import com.nokia.tools.vct.confml.model.confml1.EGroupContainer;
import com.nokia.tools.vct.confml.model.confml1.EIconContainer;
import com.nokia.tools.vct.confml.model.confml1.EIconElement;
import com.nokia.tools.vct.confml.model.confml1.ELinkContainer;
import com.nokia.tools.vct.confml.model.confml1.ELinkElement;
import com.nokia.tools.vct.confml.model.confml1.EMetaContainer;
import com.nokia.tools.vct.confml.model.confml1.EMetaContent;
import com.nokia.tools.vct.confml.model.confml1.EMetaElement;
import com.nokia.tools.vct.confml.model.confml1.EOptionElement;
import com.nokia.tools.vct.confml.model.confml1.EPropertyElement;
import com.nokia.tools.vct.confml.model.confml1.ERefNamedElement;
import com.nokia.tools.vct.confml.model.confml1.ERfsElement;
import com.nokia.tools.vct.confml.model.confml1.ESettingData;
import com.nokia.tools.vct.confml.model.confml1.ESettingDataContainer;
import com.nokia.tools.vct.confml.model.confml1.ESettingElement;
import com.nokia.tools.vct.confml.model.confml1.ESettingRfs;
import com.nokia.tools.vct.confml.model.confml1.ESettingRfsContainer;
import com.nokia.tools.vct.confml.model.confml1.ESettingTypeContainer;
import com.nokia.tools.vct.confml.model.confml1.EViewElement;
import com.nokia.tools.vct.confml.model.confml1.EXLinkReference;
import com.nokia.tools.vct.confml.model.confml1.include.EConfMLIncludePackage;
import com.nokia.tools.vct.confml.model.confml1.include.impl.EConfMLIncludePackageImpl;
import com.nokia.tools.vct.confml.model.confml2.EConfML2Package;
import com.nokia.tools.vct.confml.model.confml2.impl.EConfML2PackageImpl;
import com.nokia.tools.vct.confml.model.metaext.EMetaExtPackage;
import com.nokia.tools.vct.confml.model.metaext.impl.EMetaExtPackageImpl;
import com.nokia.tools.vct.confml.model.xsd.EXSDFacetPackage;
import com.nokia.tools.vct.confml.model.xsd.impl.EXSDFacetPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EConfML1PackageImpl extends EPackageImpl implements
		EConfML1Package {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eConfigurationElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eContentsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eFeatureElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eFeatureDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eSettingTypeContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eSettingElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eSettingDataContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eSettingDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eViewElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eGroupContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eFeatureRfsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eSettingRfsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eMetaContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eMetaElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eOptionElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ePropertyElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eDescriptionContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eDescriptionElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eIconContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eIconElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eLinkContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eLinkElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eDataElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eRfsElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass exLinkReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eCommonAttrsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eMetaContentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eRefNamedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eConfMLDocumentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eSettingRfsContainerEClass = null;

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
	 * @see com.nokia.tools.vct.confml.model.confml1.EConfML1Package#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EConfML1PackageImpl() {
		super(eNS_URI, EConfML1Factory.eINSTANCE);
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
	public static EConfML1Package init() {
		if (isInited)
			return (EConfML1Package) EPackage.Registry.INSTANCE
					.getEPackage(EConfML1Package.eNS_URI);

		// Obtain or create and register package
		EConfML1PackageImpl theEConfML1Package = (EConfML1PackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(eNS_URI) instanceof EConfML1PackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(eNS_URI)
				: new EConfML1PackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
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
		EXSDFacetPackageImpl theEXSDFacetPackage = (EXSDFacetPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(EXSDFacetPackage.eNS_URI) instanceof EXSDFacetPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(EXSDFacetPackage.eNS_URI)
				: EXSDFacetPackage.eINSTANCE);

		// Create package meta-data objects
		theEConfML1Package.createPackageContents();
		theEConfMLIncludePackage.createPackageContents();
		theEConfML2Package.createPackageContents();
		theEMetaExtPackage.createPackageContents();
		theEXSDFacetPackage.createPackageContents();

		// Initialize created meta-data
		theEConfML1Package.initializePackageContents();
		theEConfMLIncludePackage.initializePackageContents();
		theEConfML2Package.initializePackageContents();
		theEMetaExtPackage.initializePackageContents();
		theEXSDFacetPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEConfML1Package.freeze();

		return theEConfML1Package;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEConfigurationElement() {
		return eConfigurationElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEConfigurationElement_Configurations() {
		return (EReference) eConfigurationElementEClass
				.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEConfigurationElement_Features() {
		return (EReference) eConfigurationElementEClass
				.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEConfigurationElement_Views() {
		return (EReference) eConfigurationElementEClass
				.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEConfigurationElement_Data() {
		return (EReference) eConfigurationElementEClass
				.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEConfigurationElement_Rfs() {
		return (EReference) eConfigurationElementEClass
				.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEConfigurationElement_Name() {
		return (EAttribute) eConfigurationElementEClass
				.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEConfigurationElement_Version() {
		return (EAttribute) eConfigurationElementEClass
				.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEConfigurationElement_Includes() {
		return (EReference) eConfigurationElementEClass
				.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEContents() {
		return eContentsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEContents_Contents() {
		return (EAttribute) eContentsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEFeatureElement() {
		return eFeatureElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEFeatureElement_Ref() {
		return (EAttribute) eFeatureElementEClass.getEStructuralFeatures().get(
				0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEFeatureElement_Name() {
		return (EAttribute) eFeatureElementEClass.getEStructuralFeatures().get(
				1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEFeatureElement_Relevant() {
		return (EAttribute) eFeatureElementEClass.getEStructuralFeatures().get(
				2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEFeatureData() {
		return eFeatureDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getESettingTypeContainer() {
		return eSettingTypeContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getESettingTypeContainer_Settings() {
		return (EReference) eSettingTypeContainerEClass
				.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getESettingElement() {
		return eSettingElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESettingElement_Ref() {
		return (EAttribute) eSettingElementEClass.getEStructuralFeatures().get(
				0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESettingElement_ReadOnly() {
		return (EAttribute) eSettingElementEClass.getEStructuralFeatures().get(
				1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESettingElement_Relevant() {
		return (EAttribute) eSettingElementEClass.getEStructuralFeatures().get(
				2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESettingElement_Required() {
		return (EAttribute) eSettingElementEClass.getEStructuralFeatures().get(
				3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESettingElement_MapKey() {
		return (EAttribute) eSettingElementEClass.getEStructuralFeatures().get(
				4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESettingElement_MapValue() {
		return (EAttribute) eSettingElementEClass.getEStructuralFeatures().get(
				5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESettingElement_Name() {
		return (EAttribute) eSettingElementEClass.getEStructuralFeatures().get(
				6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESettingElement_Constraint() {
		return (EAttribute) eSettingElementEClass.getEStructuralFeatures().get(
				7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getESettingElement_Options() {
		return (EReference) eSettingElementEClass.getEStructuralFeatures().get(
				8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getESettingElement_Properties() {
		return (EReference) eSettingElementEClass.getEStructuralFeatures().get(
				9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESettingElement_Type() {
		return (EAttribute) eSettingElementEClass.getEStructuralFeatures().get(
				10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESettingElement_MinOccurs() {
		return (EAttribute) eSettingElementEClass.getEStructuralFeatures().get(
				11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESettingElement_MaxOccurs() {
		return (EAttribute) eSettingElementEClass.getEStructuralFeatures().get(
				12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getESettingElement_MinExclusive() {
		return (EReference) eSettingElementEClass.getEStructuralFeatures().get(
				13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getESettingElement_MaxExclusive() {
		return (EReference) eSettingElementEClass.getEStructuralFeatures().get(
				14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getESettingElement_MinInclusive() {
		return (EReference) eSettingElementEClass.getEStructuralFeatures().get(
				15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getESettingElement_MaxInclusive() {
		return (EReference) eSettingElementEClass.getEStructuralFeatures().get(
				16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getESettingElement_MinLength() {
		return (EReference) eSettingElementEClass.getEStructuralFeatures().get(
				17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getESettingElement_MaxLength() {
		return (EReference) eSettingElementEClass.getEStructuralFeatures().get(
				18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getESettingElement_Length() {
		return (EReference) eSettingElementEClass.getEStructuralFeatures().get(
				19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getESettingElement_TotalDigits() {
		return (EReference) eSettingElementEClass.getEStructuralFeatures().get(
				20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getESettingElement_Pattern() {
		return (EReference) eSettingElementEClass.getEStructuralFeatures().get(
				21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getESettingDataContainer() {
		return eSettingDataContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getESettingDataContainer_Settings() {
		return (EReference) eSettingDataContainerEClass
				.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getESettingData() {
		return eSettingDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESettingData_Template() {
		return (EAttribute) eSettingDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESettingData_ExtensionPolicy() {
		return (EAttribute) eSettingDataEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESettingData_Value() {
		return (EAttribute) eSettingDataEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESettingData_Text() {
		return (EAttribute) eSettingDataEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEViewElement() {
		return eViewElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEViewElement_Name() {
		return (EAttribute) eViewElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEGroup() {
		return eGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEGroup_Settings() {
		return (EReference) eGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEGroup_Name() {
		return (EAttribute) eGroupEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEGroupContainer() {
		return eGroupContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEGroupContainer_Groups() {
		return (EReference) eGroupContainerEClass.getEStructuralFeatures().get(
				0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEGroupContainer_Includes() {
		return (EReference) eGroupContainerEClass.getEStructuralFeatures().get(
				1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEFeatureRfs() {
		return eFeatureRfsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getESettingRfs() {
		return eSettingRfsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESettingRfs_Rfs() {
		return (EAttribute) eSettingRfsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEMetaContainer() {
		return eMetaContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEMetaContainer_Metas() {
		return (EReference) eMetaContainerEClass.getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEMetaElement() {
		return eMetaElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEMetaElement_Id() {
		return (EReference) eMetaElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEMetaElement_Date() {
		return (EReference) eMetaElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEMetaElement_Owner() {
		return (EReference) eMetaElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEMetaElement_Editor() {
		return (EReference) eMetaElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEMetaElement_Product() {
		return (EReference) eMetaElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEMetaElement_Status() {
		return (EReference) eMetaElementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEMetaElement_Platform() {
		return (EReference) eMetaElementEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEMetaElement_Version() {
		return (EReference) eMetaElementEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEMetaElement_Release() {
		return (EReference) eMetaElementEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEMetaElement_Customer() {
		return (EReference) eMetaElementEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEMetaElement_ConfigurationProperty() {
		return (EReference) eMetaElementEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEMetaElement_OtherElements() {
		return (EAttribute) eMetaElementEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEOptionElement() {
		return eOptionElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEOptionElement_Name() {
		return (EAttribute) eOptionElementEClass.getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEOptionElement_Value() {
		return (EAttribute) eOptionElementEClass.getEStructuralFeatures()
				.get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEOptionElement_Relevant() {
		return (EAttribute) eOptionElementEClass.getEStructuralFeatures()
				.get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEOptionElement_Map() {
		return (EAttribute) eOptionElementEClass.getEStructuralFeatures()
				.get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEPropertyElement() {
		return ePropertyElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPropertyElement_Name() {
		return (EAttribute) ePropertyElementEClass.getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPropertyElement_Value() {
		return (EAttribute) ePropertyElementEClass.getEStructuralFeatures()
				.get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPropertyElement_Unit() {
		return (EAttribute) ePropertyElementEClass.getEStructuralFeatures()
				.get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEDescriptionContainer() {
		return eDescriptionContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEDescriptionContainer_Descriptions() {
		return (EReference) eDescriptionContainerEClass
				.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEDescriptionElement() {
		return eDescriptionElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEDescriptionElement_Description() {
		return (EAttribute) eDescriptionElementEClass.getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEIconContainer() {
		return eIconContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEIconContainer_Icons() {
		return (EReference) eIconContainerEClass.getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEIconElement() {
		return eIconElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getELinkContainer() {
		return eLinkContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getELinkContainer_Links() {
		return (EReference) eLinkContainerEClass.getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getELinkElement() {
		return eLinkElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEDataElement() {
		return eDataElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEDataElement_Data() {
		return (EReference) eDataElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getERfsElement() {
		return eRfsElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getERfsElement_Rfs() {
		return (EReference) eRfsElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEXLinkReference() {
		return exLinkReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEXLinkReference_Href() {
		return (EAttribute) exLinkReferenceEClass.getEStructuralFeatures().get(
				0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEXLinkReference_Title() {
		return (EAttribute) exLinkReferenceEClass.getEStructuralFeatures().get(
				1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getECommonAttrs() {
		return eCommonAttrsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getECommonAttrs_Id() {
		return (EAttribute) eCommonAttrsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEMetaContent() {
		return eMetaContentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEMetaContent_Value() {
		return (EAttribute) eMetaContentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getERefNamedElement() {
		return eRefNamedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getERefNamedElement_Ref() {
		return (EAttribute) eRefNamedElementEClass.getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEConfMLDocument() {
		return eConfMLDocumentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEConfMLDocument_Configuration() {
		return (EReference) eConfMLDocumentEClass.getEStructuralFeatures().get(
				0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getESettingRfsContainer() {
		return eSettingRfsContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getESettingRfsContainer_Settings() {
		return (EReference) eSettingRfsContainerEClass.getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EConfML1Factory getEConfML1Factory() {
		return (EConfML1Factory) getEFactoryInstance();
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
		eConfigurationElementEClass = createEClass(ECONFIGURATION_ELEMENT);
		createEReference(eConfigurationElementEClass,
				ECONFIGURATION_ELEMENT__CONFIGURATIONS);
		createEReference(eConfigurationElementEClass,
				ECONFIGURATION_ELEMENT__FEATURES);
		createEReference(eConfigurationElementEClass,
				ECONFIGURATION_ELEMENT__VIEWS);
		createEReference(eConfigurationElementEClass,
				ECONFIGURATION_ELEMENT__DATA);
		createEReference(eConfigurationElementEClass,
				ECONFIGURATION_ELEMENT__RFS);
		createEAttribute(eConfigurationElementEClass,
				ECONFIGURATION_ELEMENT__NAME);
		createEAttribute(eConfigurationElementEClass,
				ECONFIGURATION_ELEMENT__VERSION);
		createEReference(eConfigurationElementEClass,
				ECONFIGURATION_ELEMENT__INCLUDES);

		eContentsEClass = createEClass(ECONTENTS);
		createEAttribute(eContentsEClass, ECONTENTS__CONTENTS);

		eFeatureElementEClass = createEClass(EFEATURE_ELEMENT);
		createEAttribute(eFeatureElementEClass, EFEATURE_ELEMENT__REF);
		createEAttribute(eFeatureElementEClass, EFEATURE_ELEMENT__NAME);
		createEAttribute(eFeatureElementEClass, EFEATURE_ELEMENT__RELEVANT);

		eFeatureDataEClass = createEClass(EFEATURE_DATA);

		eSettingTypeContainerEClass = createEClass(ESETTING_TYPE_CONTAINER);
		createEReference(eSettingTypeContainerEClass,
				ESETTING_TYPE_CONTAINER__SETTINGS);

		eSettingElementEClass = createEClass(ESETTING_ELEMENT);
		createEAttribute(eSettingElementEClass, ESETTING_ELEMENT__REF);
		createEAttribute(eSettingElementEClass, ESETTING_ELEMENT__READ_ONLY);
		createEAttribute(eSettingElementEClass, ESETTING_ELEMENT__RELEVANT);
		createEAttribute(eSettingElementEClass, ESETTING_ELEMENT__REQUIRED);
		createEAttribute(eSettingElementEClass, ESETTING_ELEMENT__MAP_KEY);
		createEAttribute(eSettingElementEClass, ESETTING_ELEMENT__MAP_VALUE);
		createEAttribute(eSettingElementEClass, ESETTING_ELEMENT__NAME);
		createEAttribute(eSettingElementEClass, ESETTING_ELEMENT__CONSTRAINT);
		createEReference(eSettingElementEClass, ESETTING_ELEMENT__OPTIONS);
		createEReference(eSettingElementEClass, ESETTING_ELEMENT__PROPERTIES);
		createEAttribute(eSettingElementEClass, ESETTING_ELEMENT__TYPE);
		createEAttribute(eSettingElementEClass, ESETTING_ELEMENT__MIN_OCCURS);
		createEAttribute(eSettingElementEClass, ESETTING_ELEMENT__MAX_OCCURS);
		createEReference(eSettingElementEClass, ESETTING_ELEMENT__MIN_EXCLUSIVE);
		createEReference(eSettingElementEClass, ESETTING_ELEMENT__MAX_EXCLUSIVE);
		createEReference(eSettingElementEClass, ESETTING_ELEMENT__MIN_INCLUSIVE);
		createEReference(eSettingElementEClass, ESETTING_ELEMENT__MAX_INCLUSIVE);
		createEReference(eSettingElementEClass, ESETTING_ELEMENT__MIN_LENGTH);
		createEReference(eSettingElementEClass, ESETTING_ELEMENT__MAX_LENGTH);
		createEReference(eSettingElementEClass, ESETTING_ELEMENT__LENGTH);
		createEReference(eSettingElementEClass, ESETTING_ELEMENT__TOTAL_DIGITS);
		createEReference(eSettingElementEClass, ESETTING_ELEMENT__PATTERN);

		eSettingDataContainerEClass = createEClass(ESETTING_DATA_CONTAINER);
		createEReference(eSettingDataContainerEClass,
				ESETTING_DATA_CONTAINER__SETTINGS);

		eSettingDataEClass = createEClass(ESETTING_DATA);
		createEAttribute(eSettingDataEClass, ESETTING_DATA__TEMPLATE);
		createEAttribute(eSettingDataEClass, ESETTING_DATA__EXTENSION_POLICY);
		createEAttribute(eSettingDataEClass, ESETTING_DATA__VALUE);
		createEAttribute(eSettingDataEClass, ESETTING_DATA__TEXT);

		eViewElementEClass = createEClass(EVIEW_ELEMENT);
		createEAttribute(eViewElementEClass, EVIEW_ELEMENT__NAME);

		eGroupEClass = createEClass(EGROUP);
		createEReference(eGroupEClass, EGROUP__SETTINGS);
		createEAttribute(eGroupEClass, EGROUP__NAME);

		eGroupContainerEClass = createEClass(EGROUP_CONTAINER);
		createEReference(eGroupContainerEClass, EGROUP_CONTAINER__GROUPS);
		createEReference(eGroupContainerEClass, EGROUP_CONTAINER__INCLUDES);

		eFeatureRfsEClass = createEClass(EFEATURE_RFS);

		eSettingRfsEClass = createEClass(ESETTING_RFS);
		createEAttribute(eSettingRfsEClass, ESETTING_RFS__RFS);

		eMetaContainerEClass = createEClass(EMETA_CONTAINER);
		createEReference(eMetaContainerEClass, EMETA_CONTAINER__METAS);

		eMetaElementEClass = createEClass(EMETA_ELEMENT);
		createEReference(eMetaElementEClass, EMETA_ELEMENT__ID);
		createEReference(eMetaElementEClass, EMETA_ELEMENT__DATE);
		createEReference(eMetaElementEClass, EMETA_ELEMENT__OWNER);
		createEReference(eMetaElementEClass, EMETA_ELEMENT__EDITOR);
		createEReference(eMetaElementEClass, EMETA_ELEMENT__PRODUCT);
		createEReference(eMetaElementEClass, EMETA_ELEMENT__STATUS);
		createEReference(eMetaElementEClass, EMETA_ELEMENT__PLATFORM);
		createEReference(eMetaElementEClass, EMETA_ELEMENT__VERSION);
		createEReference(eMetaElementEClass, EMETA_ELEMENT__RELEASE);
		createEReference(eMetaElementEClass, EMETA_ELEMENT__CUSTOMER);
		createEReference(eMetaElementEClass,
				EMETA_ELEMENT__CONFIGURATION_PROPERTY);
		createEAttribute(eMetaElementEClass, EMETA_ELEMENT__OTHER_ELEMENTS);

		eOptionElementEClass = createEClass(EOPTION_ELEMENT);
		createEAttribute(eOptionElementEClass, EOPTION_ELEMENT__NAME);
		createEAttribute(eOptionElementEClass, EOPTION_ELEMENT__VALUE);
		createEAttribute(eOptionElementEClass, EOPTION_ELEMENT__RELEVANT);
		createEAttribute(eOptionElementEClass, EOPTION_ELEMENT__MAP);

		ePropertyElementEClass = createEClass(EPROPERTY_ELEMENT);
		createEAttribute(ePropertyElementEClass, EPROPERTY_ELEMENT__NAME);
		createEAttribute(ePropertyElementEClass, EPROPERTY_ELEMENT__VALUE);
		createEAttribute(ePropertyElementEClass, EPROPERTY_ELEMENT__UNIT);

		eDescriptionContainerEClass = createEClass(EDESCRIPTION_CONTAINER);
		createEReference(eDescriptionContainerEClass,
				EDESCRIPTION_CONTAINER__DESCRIPTIONS);

		eDescriptionElementEClass = createEClass(EDESCRIPTION_ELEMENT);
		createEAttribute(eDescriptionElementEClass,
				EDESCRIPTION_ELEMENT__DESCRIPTION);

		eIconContainerEClass = createEClass(EICON_CONTAINER);
		createEReference(eIconContainerEClass, EICON_CONTAINER__ICONS);

		eIconElementEClass = createEClass(EICON_ELEMENT);

		eLinkContainerEClass = createEClass(ELINK_CONTAINER);
		createEReference(eLinkContainerEClass, ELINK_CONTAINER__LINKS);

		eLinkElementEClass = createEClass(ELINK_ELEMENT);

		eDataElementEClass = createEClass(EDATA_ELEMENT);
		createEReference(eDataElementEClass, EDATA_ELEMENT__DATA);

		eRfsElementEClass = createEClass(ERFS_ELEMENT);
		createEReference(eRfsElementEClass, ERFS_ELEMENT__RFS);

		exLinkReferenceEClass = createEClass(EX_LINK_REFERENCE);
		createEAttribute(exLinkReferenceEClass, EX_LINK_REFERENCE__HREF);
		createEAttribute(exLinkReferenceEClass, EX_LINK_REFERENCE__TITLE);

		eCommonAttrsEClass = createEClass(ECOMMON_ATTRS);
		createEAttribute(eCommonAttrsEClass, ECOMMON_ATTRS__ID);

		eMetaContentEClass = createEClass(EMETA_CONTENT);
		createEAttribute(eMetaContentEClass, EMETA_CONTENT__VALUE);

		eRefNamedElementEClass = createEClass(EREF_NAMED_ELEMENT);
		createEAttribute(eRefNamedElementEClass, EREF_NAMED_ELEMENT__REF);

		eConfMLDocumentEClass = createEClass(ECONF_ML_DOCUMENT);
		createEReference(eConfMLDocumentEClass,
				ECONF_ML_DOCUMENT__CONFIGURATION);

		eSettingRfsContainerEClass = createEClass(ESETTING_RFS_CONTAINER);
		createEReference(eSettingRfsContainerEClass,
				ESETTING_RFS_CONTAINER__SETTINGS);
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

		// Obtain other dependent packages
		EConfMLIncludePackage theEConfMLIncludePackage = (EConfMLIncludePackage) EPackage.Registry.INSTANCE
				.getEPackage(EConfMLIncludePackage.eNS_URI);
		EConfML2Package theEConfML2Package = (EConfML2Package) EPackage.Registry.INSTANCE
				.getEPackage(EConfML2Package.eNS_URI);
		EMetaExtPackage theEMetaExtPackage = (EMetaExtPackage) EPackage.Registry.INSTANCE
				.getEPackage(EMetaExtPackage.eNS_URI);
		EXSDFacetPackage theEXSDFacetPackage = (EXSDFacetPackage) EPackage.Registry.INSTANCE
				.getEPackage(EXSDFacetPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theEConfMLIncludePackage);
		getESubpackages().add(theEConfML2Package);
		getESubpackages().add(theEMetaExtPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		eConfigurationElementEClass.getESuperTypes()
				.add(this.getECommonAttrs());
		eConfigurationElementEClass.getESuperTypes().add(this.getEContents());
		eConfigurationElementEClass.getESuperTypes().add(
				this.getELinkContainer());
		eConfigurationElementEClass.getESuperTypes().add(
				this.getEIconContainer());
		eConfigurationElementEClass.getESuperTypes().add(
				this.getEDescriptionContainer());
		eConfigurationElementEClass.getESuperTypes().add(
				this.getEMetaContainer());
		eFeatureElementEClass.getESuperTypes().add(this.getECommonAttrs());
		eFeatureElementEClass.getESuperTypes().add(
				this.getEDescriptionContainer());
		eFeatureElementEClass.getESuperTypes().add(this.getELinkContainer());
		eFeatureElementEClass.getESuperTypes().add(
				this.getESettingTypeContainer());
		eFeatureElementEClass.getESuperTypes().add(this.getEIconContainer());
		eFeatureDataEClass.getESuperTypes().add(this.getERefNamedElement());
		eFeatureDataEClass.getESuperTypes()
				.add(this.getESettingDataContainer());
		eSettingTypeContainerEClass.getESuperTypes().add(this.getEContents());
		eSettingElementEClass.getESuperTypes().add(this.getECommonAttrs());
		eSettingElementEClass.getESuperTypes().add(
				this.getEDescriptionContainer());
		eSettingElementEClass.getESuperTypes().add(this.getELinkContainer());
		eSettingElementEClass.getESuperTypes().add(
				this.getESettingTypeContainer());
		eSettingElementEClass.getESuperTypes().add(this.getEIconContainer());
		eSettingDataEClass.getESuperTypes().add(this.getERefNamedElement());
		eSettingDataEClass.getESuperTypes()
				.add(this.getESettingDataContainer());
		eViewElementEClass.getESuperTypes().add(this.getECommonAttrs());
		eViewElementEClass.getESuperTypes().add(this.getEGroupContainer());
		eViewElementEClass.getESuperTypes().add(this.getEMetaContainer());
		eGroupEClass.getESuperTypes().add(this.getECommonAttrs());
		eGroupEClass.getESuperTypes().add(this.getEGroupContainer());
		eGroupContainerEClass.getESuperTypes().add(this.getELinkContainer());
		eGroupContainerEClass.getESuperTypes().add(
				this.getEDescriptionContainer());
		eGroupContainerEClass.getESuperTypes().add(this.getEIconContainer());
		eFeatureRfsEClass.getESuperTypes().add(this.getERefNamedElement());
		eFeatureRfsEClass.getESuperTypes().add(this.getESettingRfsContainer());
		eSettingRfsEClass.getESuperTypes().add(this.getERefNamedElement());
		eSettingRfsEClass.getESuperTypes().add(this.getESettingRfsContainer());
		eMetaContainerEClass.getESuperTypes().add(this.getEContents());
		eMetaElementEClass.getESuperTypes().add(this.getELinkContainer());
		eMetaElementEClass.getESuperTypes().add(this.getEIconContainer());
		eOptionElementEClass.getESuperTypes().add(this.getECommonAttrs());
		eOptionElementEClass.getESuperTypes().add(this.getELinkContainer());
		eOptionElementEClass.getESuperTypes().add(
				this.getEDescriptionContainer());
		eOptionElementEClass.getESuperTypes().add(this.getEIconContainer());
		ePropertyElementEClass.getESuperTypes().add(this.getECommonAttrs());
		ePropertyElementEClass.getESuperTypes().add(this.getELinkContainer());
		ePropertyElementEClass.getESuperTypes().add(
				this.getEDescriptionContainer());
		ePropertyElementEClass.getESuperTypes().add(this.getEIconContainer());
		eDescriptionContainerEClass.getESuperTypes().add(this.getEContents());
		eDescriptionElementEClass.getESuperTypes().add(this.getECommonAttrs());
		eDescriptionElementEClass.getESuperTypes().add(
				this.getEXLinkReference());
		eIconContainerEClass.getESuperTypes().add(this.getEContents());
		eIconElementEClass.getESuperTypes().add(this.getECommonAttrs());
		eIconElementEClass.getESuperTypes().add(this.getEXLinkReference());
		eLinkContainerEClass.getESuperTypes().add(this.getEContents());
		eLinkElementEClass.getESuperTypes().add(this.getECommonAttrs());
		eLinkElementEClass.getESuperTypes().add(this.getEXLinkReference());
		eMetaContentEClass.getESuperTypes().add(this.getECommonAttrs());

		// Initialize classes and features; add operations and parameters
		initEClass(eConfigurationElementEClass, EConfigurationElement.class,
				"EConfigurationElement", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEConfigurationElement_Configurations(), this
				.getEConfigurationElement(), null, "configurations", null, 0,
				-1, EConfigurationElement.class, IS_TRANSIENT, IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getEConfigurationElement_Features(), this
				.getEFeatureElement(), null, "features", null, 0, -1,
				EConfigurationElement.class, IS_TRANSIENT, IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getEConfigurationElement_Views(),
				this.getEViewElement(), null, "views", null, 0, -1,
				EConfigurationElement.class, IS_TRANSIENT, IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getEConfigurationElement_Data(), this.getEDataElement(),
				null, "data", null, 0, -1, EConfigurationElement.class,
				IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED,
				IS_ORDERED);
		initEReference(getEConfigurationElement_Rfs(), this.getERfsElement(),
				null, "rfs", null, 0, -1, EConfigurationElement.class,
				IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getEConfigurationElement_Name(), ecorePackage
				.getEString(), "name", null, 0, 1, EConfigurationElement.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEConfigurationElement_Version(), ecorePackage
				.getEString(), "version", null, 0, 1,
				EConfigurationElement.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getEConfigurationElement_Includes(),
				theEConfMLIncludePackage.getEInclude(), null, "includes", null,
				0, -1, EConfigurationElement.class, IS_TRANSIENT, IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(eContentsEClass, null, "EContents", IS_ABSTRACT,
				IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEContents_Contents(), ecorePackage
				.getEFeatureMapEntry(), "contents", null, 0, -1, EObject.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eFeatureElementEClass, EFeatureElement.class,
				"EFeatureElement", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEFeatureElement_Ref(), ecorePackage.getEString(),
				"ref", null, 1, 1, EFeatureElement.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getEFeatureElement_Name(), ecorePackage.getEString(),
				"name", null, 0, 1, EFeatureElement.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getEFeatureElement_Relevant(),
				ecorePackage.getEString(), "relevant", null, 0, 1,
				EFeatureElement.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		initEClass(eFeatureDataEClass, EFeatureData.class, "EFeatureData",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(eSettingTypeContainerEClass, ESettingTypeContainer.class,
				"ESettingTypeContainer", IS_ABSTRACT, IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getESettingTypeContainer_Settings(), this
				.getESettingElement(), null, "settings", null, 0, -1,
				ESettingTypeContainer.class, IS_TRANSIENT, IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(eSettingElementEClass, ESettingElement.class,
				"ESettingElement", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getESettingElement_Ref(), ecorePackage.getEString(),
				"ref", null, 1, 1, ESettingElement.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getESettingElement_ReadOnly(),
				ecorePackage.getEString(), "readOnly", null, 0, 1,
				ESettingElement.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getESettingElement_Relevant(),
				ecorePackage.getEString(), "relevant", null, 0, 1,
				ESettingElement.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getESettingElement_Required(),
				ecorePackage.getEString(), "required", null, 0, 1,
				ESettingElement.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getESettingElement_MapKey(), ecorePackage.getEString(),
				"mapKey", null, 0, 1, ESettingElement.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getESettingElement_MapValue(),
				ecorePackage.getEString(), "mapValue", null, 0, 1,
				ESettingElement.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getESettingElement_Name(), ecorePackage.getEString(),
				"name", null, 1, 1, ESettingElement.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getESettingElement_Constraint(), ecorePackage
				.getEString(), "constraint", null, 0, 1, ESettingElement.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getESettingElement_Options(), this.getEOptionElement(),
				null, "options", null, 0, -1, ESettingElement.class,
				IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED,
				IS_ORDERED);
		initEReference(getESettingElement_Properties(), this
				.getEPropertyElement(), null, "properties", null, 0, -1,
				ESettingElement.class, IS_TRANSIENT, IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getESettingElement_Type(), ecorePackage.getEString(),
				"type", null, 0, 1, ESettingElement.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getESettingElement_MinOccurs(), ecorePackage
				.getEIntegerObject(), "minOccurs", null, 0, 1,
				ESettingElement.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getESettingElement_MaxOccurs(), ecorePackage
				.getEIntegerObject(), "maxOccurs", null, 0, 1,
				ESettingElement.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getESettingElement_MinExclusive(), theEXSDFacetPackage
				.getEMinExclusive(), null, "minExclusive", null, 0, -1,
				ESettingElement.class, IS_TRANSIENT, IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getESettingElement_MaxExclusive(), theEXSDFacetPackage
				.getEMaxExclusive(), null, "maxExclusive", null, 0, -1,
				ESettingElement.class, IS_TRANSIENT, IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getESettingElement_MinInclusive(), theEXSDFacetPackage
				.getEMinInclusive(), null, "minInclusive", null, 0, -1,
				ESettingElement.class, IS_TRANSIENT, IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getESettingElement_MaxInclusive(), theEXSDFacetPackage
				.getEMaxInclusive(), null, "maxInclusive", null, 0, -1,
				ESettingElement.class, IS_TRANSIENT, IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getESettingElement_MinLength(), theEXSDFacetPackage
				.getEMinLength(), null, "minLength", null, 0, -1,
				ESettingElement.class, IS_TRANSIENT, IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getESettingElement_MaxLength(), theEXSDFacetPackage
				.getEMaxLength(), null, "maxLength", null, 0, -1,
				ESettingElement.class, IS_TRANSIENT, IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getESettingElement_Length(), theEXSDFacetPackage
				.getELength(), null, "length", null, 0, -1,
				ESettingElement.class, IS_TRANSIENT, IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getESettingElement_TotalDigits(), theEXSDFacetPackage
				.getETotalDigits(), null, "totalDigits", null, 0, -1,
				ESettingElement.class, IS_TRANSIENT, IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getESettingElement_Pattern(), theEXSDFacetPackage
				.getEPattern(), null, "pattern", null, 0, -1,
				ESettingElement.class, IS_TRANSIENT, IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(eSettingDataContainerEClass, ESettingDataContainer.class,
				"ESettingDataContainer", IS_ABSTRACT, IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getESettingDataContainer_Settings(), this
				.getESettingData(), null, "settings", null, 0, -1,
				ESettingDataContainer.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eSettingDataEClass, ESettingData.class, "ESettingData",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getESettingData_Template(), ecorePackage.getEString(),
				"template", null, 0, 1, ESettingData.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getESettingData_ExtensionPolicy(), ecorePackage
				.getEString(), "extensionPolicy", null, 0, 1,
				ESettingData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getESettingData_Value(), ecorePackage
				.getEFeatureMapEntry(), "value", null, 0, -1,
				ESettingData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getESettingData_Text(), ecorePackage.getEString(),
				"text", null, 0, 1, ESettingData.class, IS_TRANSIENT,
				IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				IS_DERIVED, IS_ORDERED);

		initEClass(eViewElementEClass, EViewElement.class, "EViewElement",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEViewElement_Name(), ecorePackage.getEString(),
				"name", null, 0, 1, EViewElement.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(eGroupEClass, EGroup.class, "EGroup", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEGroup_Settings(), this.getESettingElement(), null,
				"settings", null, 0, -1, EGroup.class, IS_TRANSIENT,
				IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getEGroup_Name(), ecorePackage.getEString(), "name",
				null, 0, 1, EGroup.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		initEClass(eGroupContainerEClass, EGroupContainer.class,
				"EGroupContainer", IS_ABSTRACT, IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEGroupContainer_Groups(), this.getEGroup(), null,
				"groups", null, 0, -1, EGroupContainer.class, IS_TRANSIENT,
				IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getEGroupContainer_Includes(), theEConfMLIncludePackage
				.getEInclude(), null, "includes", null, 0, -1,
				EGroupContainer.class, IS_TRANSIENT, IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(eFeatureRfsEClass, EFeatureRfs.class, "EFeatureRfs",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(eSettingRfsEClass, ESettingRfs.class, "ESettingRfs",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getESettingRfs_Rfs(), ecorePackage.getEString(), "rfs",
				null, 0, 1, ESettingRfs.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		initEClass(eMetaContainerEClass, EMetaContainer.class,
				"EMetaContainer", IS_ABSTRACT, IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEMetaContainer_Metas(), this.getEMetaElement(), null,
				"metas", null, 0, -1, EMetaContainer.class, IS_TRANSIENT,
				IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(eMetaElementEClass, EMetaElement.class, "EMetaElement",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEMetaElement_Id(), this.getEMetaContent(), null,
				"id", null, 0, -1, EMetaElement.class, IS_TRANSIENT,
				IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getEMetaElement_Date(), this.getEMetaContent(), null,
				"date", null, 0, -1, EMetaElement.class, IS_TRANSIENT,
				IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getEMetaElement_Owner(), this.getEMetaContent(), null,
				"owner", null, 0, -1, EMetaElement.class, IS_TRANSIENT,
				IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getEMetaElement_Editor(), this.getEMetaContent(), null,
				"editor", null, 0, -1, EMetaElement.class, IS_TRANSIENT,
				IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getEMetaElement_Product(), this.getEMetaContent(), null,
				"product", null, 0, -1, EMetaElement.class, IS_TRANSIENT,
				IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getEMetaElement_Status(), this.getEMetaContent(), null,
				"status", null, 0, -1, EMetaElement.class, IS_TRANSIENT,
				IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getEMetaElement_Platform(), this.getEMetaContent(),
				null, "platform", null, 0, -1, EMetaElement.class,
				IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED,
				IS_ORDERED);
		initEReference(getEMetaElement_Version(), this.getEMetaContent(), null,
				"version", null, 0, -1, EMetaElement.class, IS_TRANSIENT,
				IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getEMetaElement_Release(), this.getEMetaContent(), null,
				"release", null, 0, -1, EMetaElement.class, IS_TRANSIENT,
				IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getEMetaElement_Customer(), this.getEMetaContent(),
				null, "customer", null, 0, -1, EMetaElement.class,
				IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED,
				IS_ORDERED);
		initEReference(getEMetaElement_ConfigurationProperty(),
				theEMetaExtPackage.getEConfigurationPropertyElement(), null,
				"configurationProperty", null, 0, -1, EMetaElement.class,
				IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getEMetaElement_OtherElements(), ecorePackage
				.getEFeatureMapEntry(), "otherElements", null, 0, -1,
				EMetaElement.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(eOptionElementEClass, EOptionElement.class,
				"EOptionElement", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEOptionElement_Name(), ecorePackage.getEString(),
				"name", null, 0, 1, EOptionElement.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getEOptionElement_Value(), ecorePackage.getEString(),
				"value", null, 0, 1, EOptionElement.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getEOptionElement_Relevant(), ecorePackage.getEString(),
				"relevant", null, 0, 1, EOptionElement.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getEOptionElement_Map(), ecorePackage.getEString(),
				"map", null, 0, 1, EOptionElement.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(ePropertyElementEClass, EPropertyElement.class,
				"EPropertyElement", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEPropertyElement_Name(), ecorePackage.getEString(),
				"name", null, 0, 1, EPropertyElement.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getEPropertyElement_Value(), ecorePackage.getEString(),
				"value", null, 0, 1, EPropertyElement.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getEPropertyElement_Unit(), ecorePackage.getEString(),
				"unit", null, 0, 1, EPropertyElement.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(eDescriptionContainerEClass, EDescriptionContainer.class,
				"EDescriptionContainer", IS_ABSTRACT, IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEDescriptionContainer_Descriptions(), this
				.getEDescriptionElement(), null, "descriptions", null, 0, -1,
				EDescriptionContainer.class, IS_TRANSIENT, IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(eDescriptionElementEClass, EDescriptionElement.class,
				"EDescriptionElement", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEDescriptionElement_Description(), ecorePackage
				.getEString(), "description", null, 0, 1,
				EDescriptionElement.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		initEClass(eIconContainerEClass, EIconContainer.class,
				"EIconContainer", IS_ABSTRACT, IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEIconContainer_Icons(), this.getEIconElement(), null,
				"icons", null, 0, -1, EIconContainer.class, IS_TRANSIENT,
				IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(eIconElementEClass, EIconElement.class, "EIconElement",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(eLinkContainerEClass, ELinkContainer.class,
				"ELinkContainer", IS_ABSTRACT, IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getELinkContainer_Links(), this.getELinkElement(), null,
				"links", null, 0, -1, ELinkContainer.class, IS_TRANSIENT,
				IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(eLinkElementEClass, ELinkElement.class, "ELinkElement",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(eDataElementEClass, EDataElement.class, "EDataElement",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEDataElement_Data(), this.getEFeatureData(), null,
				"data", null, 0, -1, EDataElement.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eRfsElementEClass, ERfsElement.class, "ERfsElement",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getERfsElement_Rfs(), this.getEFeatureRfs(), null,
				"rfs", null, 0, -1, ERfsElement.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(exLinkReferenceEClass, EXLinkReference.class,
				"EXLinkReference", IS_ABSTRACT, IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEXLinkReference_Href(), ecorePackage.getEString(),
				"href", null, 0, 1, EXLinkReference.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getEXLinkReference_Title(), ecorePackage.getEString(),
				"title", null, 0, 1, EXLinkReference.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(eCommonAttrsEClass, ECommonAttrs.class, "ECommonAttrs",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getECommonAttrs_Id(), ecorePackage.getEString(), "id",
				null, 0, 1, ECommonAttrs.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		initEClass(eMetaContentEClass, EMetaContent.class, "EMetaContent",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEMetaContent_Value(), ecorePackage.getEString(),
				"value", null, 0, 1, EMetaContent.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(eRefNamedElementEClass, ERefNamedElement.class,
				"ERefNamedElement", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getERefNamedElement_Ref(), ecorePackage.getEString(),
				"ref", null, 1, 1, ERefNamedElement.class, IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(eConfMLDocumentEClass, EConfMLDocument.class,
				"EConfMLDocument", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEConfMLDocument_Configuration(), this
				.getEConfigurationElement(), null, "configuration", null, 0, 1,
				null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		initEClass(eSettingRfsContainerEClass, ESettingRfsContainer.class,
				"ESettingRfsContainer", IS_ABSTRACT, IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getESettingRfsContainer_Settings(), this
				.getESettingRfs(), null, "settings", null, 0, -1,
				ESettingRfsContainer.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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
		addAnnotation(eConfigurationElementEClass, source, new String[] {
				"name", "configurationType", "kind", "elementOnly" });
		addAnnotation(getEConfigurationElement_Configurations(), source,
				new String[] { "kind", "element", "name", "configuration",
						"namespace", "##targetNamespace", "group",
						"#contents:0" });
		addAnnotation(getEConfigurationElement_Features(), source,
				new String[] { "kind", "element", "name", "feature",
						"namespace", "##targetNamespace", "group",
						"#contents:0" });
		addAnnotation(getEConfigurationElement_Views(), source, new String[] {
				"kind", "element", "name", "view", "namespace",
				"##targetNamespace", "group", "#contents:0" });
		addAnnotation(getEConfigurationElement_Data(), source, new String[] {
				"kind", "element", "name", "data", "namespace",
				"##targetNamespace", "group", "#contents:0" });
		addAnnotation(getEConfigurationElement_Rfs(), source, new String[] {
				"kind", "element", "name", "rfs", "namespace",
				"##targetNamespace", "group", "#contents:0" });
		addAnnotation(getEConfigurationElement_Includes(), source,
				new String[] { "kind", "element", "name", "include",
						"namespace", "http://www.w3.org/2001/XInclude",
						"group", "#contents:0" });
		addAnnotation(eContentsEClass, source, new String[] { "name",
				"contentsType", "kind", "elementOnly" });
		addAnnotation(getEContents_Contents(), source, new String[] { "kind",
				"group", "name", "contents:0" });
		addAnnotation(eFeatureElementEClass, source, new String[] { "name",
				"featureType", "kind", "elementOnly" });
		addAnnotation(getEFeatureElement_Ref(), source, new String[] { "kind",
				"attribute", "name", "ref" });
		addAnnotation(eFeatureDataEClass, source, new String[] { "name",
				"featureDataType", "kind", "elementOnly" });
		addAnnotation(eSettingTypeContainerEClass, source, new String[] {
				"name", "settingTypeContainer", "kind", "elementOnly" });
		addAnnotation(getESettingTypeContainer_Settings(), source,
				new String[] { "kind", "element", "name", "setting",
						"namespace", "##targetNamespace", "group",
						"#contents:0" });
		addAnnotation(eSettingElementEClass, source, new String[] { "name",
				"settingType", "kind", "elementOnly" });
		addAnnotation(getESettingElement_Ref(), source, new String[] { "kind",
				"attribute", "name", "ref" });
		addAnnotation(getESettingElement_Options(), source, new String[] {
				"kind", "element", "name", "option", "namespace",
				"##targetNamespace", "group", "#contents:0" });
		addAnnotation(getESettingElement_Properties(), source, new String[] {
				"kind", "element", "name", "property", "namespace",
				"##targetNamespace", "group", "#contents:0" });
		addAnnotation(getESettingElement_MinExclusive(), source, new String[] {
				"kind", "element", "name", "minExclusive", "namespace",
				"http://www.w3.org/2001/XMLSchema", "group", "#contents:0" });
		addAnnotation(getESettingElement_MaxExclusive(), source, new String[] {
				"kind", "element", "name", "maxExclusive", "namespace",
				"http://www.w3.org/2001/XMLSchema", "group", "#contents:0" });
		addAnnotation(getESettingElement_MinInclusive(), source, new String[] {
				"kind", "element", "name", "minInclusive", "namespace",
				"http://www.w3.org/2001/XMLSchema", "group", "#contents:0" });
		addAnnotation(getESettingElement_MaxInclusive(), source, new String[] {
				"kind", "element", "name", "maxInclusive", "namespace",
				"http://www.w3.org/2001/XMLSchema", "group", "#contents:0" });
		addAnnotation(getESettingElement_MinLength(), source, new String[] {
				"kind", "element", "name", "minLength", "namespace",
				"http://www.w3.org/2001/XMLSchema", "group", "#contents:0" });
		addAnnotation(getESettingElement_MaxLength(), source, new String[] {
				"kind", "element", "name", "maxLength", "namespace",
				"http://www.w3.org/2001/XMLSchema", "group", "#contents:0" });
		addAnnotation(getESettingElement_Length(), source, new String[] {
				"kind", "element", "name", "length", "namespace",
				"http://www.w3.org/2001/XMLSchema", "group", "#contents:0" });
		addAnnotation(getESettingElement_TotalDigits(), source, new String[] {
				"kind", "element", "name", "totalDigits", "namespace",
				"http://www.w3.org/2001/XMLSchema", "group", "#contents:0" });
		addAnnotation(getESettingElement_Pattern(), source, new String[] {
				"kind", "element", "name", "pattern", "namespace",
				"http://www.w3.org/2001/XMLSchema", "group", "#contents:0" });
		addAnnotation(eSettingDataContainerEClass, source, new String[] {
				"name", "settingDataContainerType", "kind", "elementOnly" });
		addAnnotation(getESettingDataContainer_Settings(), source,
				new String[] { "name", "setting", "kind", "elementWildcard" });
		addAnnotation(eSettingDataEClass, source, new String[] { "name",
				"settingDataType", "kind", "mixed" });
		addAnnotation(getESettingData_Template(), source, new String[] {
				"name", "template", "kind", "attribute" });
		addAnnotation(getESettingData_ExtensionPolicy(), source, new String[] {
				"name", "extensionPolicy", "kind", "attribute" });
		addAnnotation(getESettingData_Value(), source, new String[] { "name",
				":mixed", "kind", "elementWildcard" });
		addAnnotation(getESettingData_Text(), source, new String[] { "name",
				"ESettingData", "kind", "simple", "group", "#mixed:0" });
		addAnnotation(eViewElementEClass, source, new String[] { "name",
				"viewType", "kind", "elementOnly" });
		addAnnotation(eGroupEClass, source, new String[] { "name", "groupType",
				"kind", "elementOnly" });
		addAnnotation(getEGroup_Settings(), source, new String[] { "kind",
				"element", "name", "setting", "namespace", "##targetNamespace",
				"group", "#contents:0" });
		addAnnotation(eGroupContainerEClass, source, new String[] { "name",
				"groupContainerType", "kind", "elementOnly" });
		addAnnotation(getEGroupContainer_Groups(), source, new String[] {
				"kind", "element", "name", "group", "namespace",
				"##targetNamespace", "group", "#contents:0" });
		addAnnotation(getEGroupContainer_Includes(), source, new String[] {
				"kind", "element", "name", "include", "namespace",
				"http://www.w3.org/2001/XInclude", "group", "#contents:0" });
		addAnnotation(eFeatureRfsEClass, source, new String[] { "name",
				"featureRfsType", "kind", "elementOnly" });
		addAnnotation(eSettingRfsEClass, source, new String[] { "name",
				"settingRfsType", "kind", "mixed" });
		addAnnotation(getESettingRfs_Rfs(), source, new String[] { "name",
				"rfs", "kind", "simple" });
		addAnnotation(eMetaContainerEClass, source, new String[] { "name",
				"groupContainerType", "kind", "elementOnly" });
		addAnnotation(getEMetaContainer_Metas(), source, new String[] { "kind",
				"element", "name", "meta", "namespace", "##targetNamespace",
				"group", "#contents:0" });
		addAnnotation(eMetaElementEClass, source, new String[] { "name",
				"metaType", "kind", "elementOnly" });
		addAnnotation(getEMetaElement_Id(), source, new String[] { "kind",
				"element", "name", "id", "namespace", "##targetNamespace",
				"group", "#contents:0" });
		addAnnotation(getEMetaElement_Date(), source, new String[] { "kind",
				"element", "name", "date", "namespace", "##targetNamespace",
				"group", "#contents:0" });
		addAnnotation(getEMetaElement_Owner(), source, new String[] { "kind",
				"element", "name", "owner", "namespace", "##targetNamespace",
				"group", "#contents:0" });
		addAnnotation(getEMetaElement_Editor(), source, new String[] { "kind",
				"element", "name", "editor", "namespace", "##targetNamespace",
				"group", "#contents:0" });
		addAnnotation(getEMetaElement_Product(), source, new String[] { "kind",
				"element", "name", "product", "namespace", "##targetNamespace",
				"group", "#contents:0" });
		addAnnotation(getEMetaElement_Status(), source, new String[] { "kind",
				"element", "name", "status", "namespace", "##targetNamespace",
				"group", "#contents:0" });
		addAnnotation(getEMetaElement_Platform(), source, new String[] {
				"kind", "element", "name", "platform", "namespace",
				"##targetNamespace", "group", "#contents:0" });
		addAnnotation(getEMetaElement_Version(), source, new String[] { "kind",
				"element", "name", "version", "namespace", "##targetNamespace",
				"group", "#contents:0" });
		addAnnotation(getEMetaElement_Release(), source, new String[] { "kind",
				"element", "name", "release", "namespace", "##targetNamespace",
				"group", "#contents:0" });
		addAnnotation(getEMetaElement_Customer(), source, new String[] {
				"kind", "element", "name", "customer", "namespace",
				"##targetNamespace", "group", "#contents:0" });
		addAnnotation(getEMetaElement_ConfigurationProperty(), source,
				new String[] { "kind", "element", "name",
						"configuration-property", "namespace",
						"http://www.nokia.com/xml/cpf-id/1", "group",
						"#contents:0" });
		addAnnotation(getEMetaElement_OtherElements(), source, new String[] {
				"kind", "elementWildcard", "name", ":12", "wildcards",
				"##other", "group", "#contents:0", "processing", "lax" });
		addAnnotation(eOptionElementEClass, source, new String[] { "name",
				"optionType", "kind", "elementOnly" });
		addAnnotation(ePropertyElementEClass, source, new String[] { "name",
				"propertyType", "kind", "elementOnly" });
		addAnnotation(eDescriptionContainerEClass, source, new String[] {
				"name", "descriptionContainerType", "kind", "elementOnly" });
		addAnnotation(getEDescriptionContainer_Descriptions(), source,
				new String[] { "kind", "element", "name", "desc", "namespace",
						"##targetNamespace", "group", "#contents:0" });
		addAnnotation(eDescriptionElementEClass, source, new String[] { "name",
				"descriptionType", "kind", "simple" });
		addAnnotation(getEDescriptionElement_Description(), source,
				new String[] { "name", "description", "kind", "simple" });
		addAnnotation(eIconContainerEClass, source, new String[] { "name",
				"iconContainerType", "kind", "elementOnly" });
		addAnnotation(getEIconContainer_Icons(), source, new String[] { "kind",
				"element", "name", "icon", "namespace", "##targetNamespace",
				"group", "#contents:0" });
		addAnnotation(eIconElementEClass, source, new String[] { "name",
				"iconType", "kind", "elementOnly" });
		addAnnotation(eLinkContainerEClass, source, new String[] { "name",
				"linkContainerType", "kind", "elementOnly" });
		addAnnotation(getELinkContainer_Links(), source, new String[] { "kind",
				"element", "name", "link", "namespace", "##targetNamespace",
				"group", "#contents:0" });
		addAnnotation(eLinkElementEClass, source, new String[] { "name",
				"linkType", "kind", "elementOnly" });
		addAnnotation(eDataElementEClass, source, new String[] { "name",
				"dataType", "kind", "elementOnly" });
		addAnnotation(eRfsElementEClass, source, new String[] { "name",
				"rfsType", "kind", "elementOnly" });
		addAnnotation(exLinkReferenceEClass, source, new String[] { "name",
				"rfsType", "kind", "xlinkRefType" });
		addAnnotation(getEXLinkReference_Href(), source, new String[] { "kind",
				"attribute", "name", "href", "namespace",
				"http://www.w3.org/1999/xlink" });
		addAnnotation(getEXLinkReference_Title(), source, new String[] {
				"kind", "attribute", "name", "title", "namespace",
				"http://www.w3.org/1999/xlink" });
		addAnnotation(eCommonAttrsEClass, source, new String[] { "name",
				"commonAttrsType", "kind", "elementOnly" });
		addAnnotation(getECommonAttrs_Id(), source, new String[] { "kind",
				"attribute", "name", "id" });
		addAnnotation(eMetaContentEClass, source, new String[] { "name",
				"metaContentType", "kind", "simple" });
		addAnnotation(getEMetaContent_Value(), source, new String[] { "name",
				"value", "kind", "simple" });
		addAnnotation(eRefNamedElementEClass, source, new String[] { "name",
				"refHolderType", "kind", "elementOnly" });
		addAnnotation(getERefNamedElement_Ref(), source, new String[] { "kind",
				"attribute", "name", "ref" });
		addAnnotation(eConfMLDocumentEClass, source, new String[] { "name", "",
				"kind", "mixed" });
		addAnnotation(getEConfMLDocument_Configuration(), source, new String[] {
				"kind", "element", "name", "configuration", "namespace",
				"##targetNamespace" });
		addAnnotation(eSettingRfsContainerEClass, source, new String[] {
				"name", "settingRfsContainerType", "kind", "elementOnly" });
		addAnnotation(getESettingRfsContainer_Settings(), source, new String[] {
				"name", "rfsDataType", "kind", "elementWildcard" });
	}

} //EConfML1PackageImpl
