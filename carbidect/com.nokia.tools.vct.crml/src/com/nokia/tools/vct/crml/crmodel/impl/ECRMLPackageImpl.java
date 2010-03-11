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
 * Description: This file is part of com.nokia.tools.vct.crml component.
 */

package com.nokia.tools.vct.crml.crmodel.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import com.nokia.tools.vct.crml.crmodel.CommonAttrs;
import com.nokia.tools.vct.crml.crmodel.EAccess;
import com.nokia.tools.vct.crml.crmodel.EAccessContainer;
import com.nokia.tools.vct.crml.crmodel.EAccessType;
import com.nokia.tools.vct.crml.crmodel.EAttributeAndDescription;
import com.nokia.tools.vct.crml.crmodel.EBackup;
import com.nokia.tools.vct.crml.crmodel.EBit;
import com.nokia.tools.vct.crml.crmodel.ECRMLDocumentRoot;
import com.nokia.tools.vct.crml.crmodel.ECRMLFactory;
import com.nokia.tools.vct.crml.crmodel.ECRMLPackage;
import com.nokia.tools.vct.crml.crmodel.EContent;
import com.nokia.tools.vct.crml.crmodel.EKey;
import com.nokia.tools.vct.crml.crmodel.EKeyRange;
import com.nokia.tools.vct.crml.crmodel.EKeyType;
import com.nokia.tools.vct.crml.crmodel.EMeta;
import com.nokia.tools.vct.crml.crmodel.EReadOnly;
import com.nokia.tools.vct.crml.crmodel.ERefContainer;
import com.nokia.tools.vct.crml.crmodel.ERepository;
import com.nokia.tools.vct.crml.crmodel.EValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ECRMLPackageImpl extends EPackageImpl implements ECRMLPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass commonAttrsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eMetaEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eContentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eRepositoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eKeyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eKeyRangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eAccessEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eBitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eRefContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eAttributeAndDescriptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eReadOnlyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eAccessContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eBackupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ecrmlDocumentRootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eKeyTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eAccessTypeEEnum = null;

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
	 * @see com.nokia.tools.vct.crml.crmodel.ECRMLPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ECRMLPackageImpl() {
		super(eNS_URI, ECRMLFactory.eINSTANCE);
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
	public static ECRMLPackage init() {
		if (isInited) return (ECRMLPackage)EPackage.Registry.INSTANCE.getEPackage(ECRMLPackage.eNS_URI);

		// Obtain or create and register package
		ECRMLPackageImpl theECRMLPackage = (ECRMLPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof ECRMLPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new ECRMLPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theECRMLPackage.createPackageContents();

		// Initialize created meta-data
		theECRMLPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theECRMLPackage.freeze();

		return theECRMLPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCommonAttrs() {
		return commonAttrsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCommonAttrs_Id() {
		return (EAttribute)commonAttrsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEMeta() {
		return eMetaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEMeta_Identification() {
		return (EAttribute)eMetaEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEMeta_Date() {
		return (EAttribute)eMetaEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEMeta_Platform() {
		return (EAttribute)eMetaEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEMeta_Owner() {
		return (EAttribute)eMetaEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEMeta_Editor() {
		return (EAttribute)eMetaEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEMeta_Status() {
		return (EAttribute)eMetaEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEMeta_Version() {
		return (EAttribute)eMetaEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEMeta_Product() {
		return (EAttribute)eMetaEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEMeta_Release() {
		return (EAttribute)eMetaEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEContent() {
		return eContentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEContent_Value() {
		return (EAttribute)eContentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getERepository() {
		return eRepositoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getERepository_Version() {
		return (EAttribute)eRepositoryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getERepository_UidName() {
		return (EAttribute)eRepositoryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getERepository_UidValue() {
		return (EAttribute)eRepositoryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getERepository_InitialisationFileVersion() {
		return (EAttribute)eRepositoryEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getERepository_Owner() {
		return (EAttribute)eRepositoryEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getERepository_Rfs() {
		return (EAttribute)eRepositoryEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getERepository_Key() {
		return (EReference)eRepositoryEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getERepository_Meta() {
		return (EReference)eRepositoryEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getERepository_RangeKey() {
		return (EReference)eRepositoryEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEKey() {
		return eKeyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEKey_Name() {
		return (EAttribute)eKeyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEKey_Ident() {
		return (EAttribute)eKeyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEKey_Type() {
		return (EAttribute)eKeyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEKey_Value() {
		return (EReference)eKeyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEKey_Bits() {
		return (EReference)eKeyEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEKeyRange() {
		return eKeyRangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEKeyRange_Name() {
		return (EAttribute)eKeyRangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEKeyRange_Int() {
		return (EAttribute)eKeyRangeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEKeyRange_FirstInt() {
		return (EAttribute)eKeyRangeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEKeyRange_LastInt() {
		return (EAttribute)eKeyRangeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEKeyRange_IndexBits() {
		return (EAttribute)eKeyRangeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEKeyRange_FirstIndex() {
		return (EAttribute)eKeyRangeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEKeyRange_CountInt() {
		return (EAttribute)eKeyRangeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEKeyRange_Keys() {
		return (EReference)eKeyRangeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEAccess() {
		return eAccessEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAccess_Type() {
		return (EAttribute)eAccessEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAccess_Capabilities() {
		return (EAttribute)eAccessEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAccess_Sid() {
		return (EAttribute)eAccessEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEValue() {
		return eValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEValue_Val() {
		return (EAttribute)eValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEValue_Id() {
		return (EAttribute)eValueEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEBit() {
		return eBitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEBit_State() {
		return (EAttribute)eBitEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getERefContainer() {
		return eRefContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getERefContainer_Ref() {
		return (EAttribute)eRefContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEAttributeAndDescription() {
		return eAttributeAndDescriptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAttributeAndDescription_Desc() {
		return (EAttribute)eAttributeAndDescriptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEReadOnly() {
		return eReadOnlyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEReadOnly_ReadOnly() {
		return (EAttribute)eReadOnlyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEAccessContainer() {
		return eAccessContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEAccessContainer_Access() {
		return (EReference)eAccessContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEBackup() {
		return eBackupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEBackup_Backup() {
		return (EAttribute)eBackupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getECRMLDocumentRoot() {
		return ecrmlDocumentRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getECRMLDocumentRoot_Repository() {
		return (EReference)ecrmlDocumentRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEKeyType() {
		return eKeyTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEAccessType() {
		return eAccessTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ECRMLFactory getECRMLFactory() {
		return (ECRMLFactory)getEFactoryInstance();
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
		commonAttrsEClass = createEClass(COMMON_ATTRS);
		createEAttribute(commonAttrsEClass, COMMON_ATTRS__ID);

		eMetaEClass = createEClass(EMETA);
		createEAttribute(eMetaEClass, EMETA__IDENTIFICATION);
		createEAttribute(eMetaEClass, EMETA__DATE);
		createEAttribute(eMetaEClass, EMETA__PLATFORM);
		createEAttribute(eMetaEClass, EMETA__OWNER);
		createEAttribute(eMetaEClass, EMETA__EDITOR);
		createEAttribute(eMetaEClass, EMETA__STATUS);
		createEAttribute(eMetaEClass, EMETA__VERSION);
		createEAttribute(eMetaEClass, EMETA__PRODUCT);
		createEAttribute(eMetaEClass, EMETA__RELEASE);

		eContentEClass = createEClass(ECONTENT);
		createEAttribute(eContentEClass, ECONTENT__VALUE);

		eRepositoryEClass = createEClass(EREPOSITORY);
		createEAttribute(eRepositoryEClass, EREPOSITORY__VERSION);
		createEAttribute(eRepositoryEClass, EREPOSITORY__UID_NAME);
		createEAttribute(eRepositoryEClass, EREPOSITORY__UID_VALUE);
		createEAttribute(eRepositoryEClass, EREPOSITORY__INITIALISATION_FILE_VERSION);
		createEAttribute(eRepositoryEClass, EREPOSITORY__OWNER);
		createEAttribute(eRepositoryEClass, EREPOSITORY__RFS);
		createEReference(eRepositoryEClass, EREPOSITORY__KEY);
		createEReference(eRepositoryEClass, EREPOSITORY__META);
		createEReference(eRepositoryEClass, EREPOSITORY__RANGE_KEY);

		eKeyEClass = createEClass(EKEY);
		createEAttribute(eKeyEClass, EKEY__NAME);
		createEAttribute(eKeyEClass, EKEY__IDENT);
		createEAttribute(eKeyEClass, EKEY__TYPE);
		createEReference(eKeyEClass, EKEY__VALUE);
		createEReference(eKeyEClass, EKEY__BITS);

		eKeyRangeEClass = createEClass(EKEY_RANGE);
		createEAttribute(eKeyRangeEClass, EKEY_RANGE__NAME);
		createEAttribute(eKeyRangeEClass, EKEY_RANGE__INT);
		createEAttribute(eKeyRangeEClass, EKEY_RANGE__FIRST_INT);
		createEAttribute(eKeyRangeEClass, EKEY_RANGE__LAST_INT);
		createEAttribute(eKeyRangeEClass, EKEY_RANGE__INDEX_BITS);
		createEAttribute(eKeyRangeEClass, EKEY_RANGE__FIRST_INDEX);
		createEAttribute(eKeyRangeEClass, EKEY_RANGE__COUNT_INT);
		createEReference(eKeyRangeEClass, EKEY_RANGE__KEYS);

		eAccessEClass = createEClass(EACCESS);
		createEAttribute(eAccessEClass, EACCESS__TYPE);
		createEAttribute(eAccessEClass, EACCESS__CAPABILITIES);
		createEAttribute(eAccessEClass, EACCESS__SID);

		eValueEClass = createEClass(EVALUE);
		createEAttribute(eValueEClass, EVALUE__VAL);
		createEAttribute(eValueEClass, EVALUE__ID);

		eBitEClass = createEClass(EBIT);
		createEAttribute(eBitEClass, EBIT__STATE);

		eRefContainerEClass = createEClass(EREF_CONTAINER);
		createEAttribute(eRefContainerEClass, EREF_CONTAINER__REF);

		eAttributeAndDescriptionEClass = createEClass(EATTRIBUTE_AND_DESCRIPTION);
		createEAttribute(eAttributeAndDescriptionEClass, EATTRIBUTE_AND_DESCRIPTION__DESC);

		eReadOnlyEClass = createEClass(EREAD_ONLY);
		createEAttribute(eReadOnlyEClass, EREAD_ONLY__READ_ONLY);

		eAccessContainerEClass = createEClass(EACCESS_CONTAINER);
		createEReference(eAccessContainerEClass, EACCESS_CONTAINER__ACCESS);

		eBackupEClass = createEClass(EBACKUP);
		createEAttribute(eBackupEClass, EBACKUP__BACKUP);

		ecrmlDocumentRootEClass = createEClass(ECRML_DOCUMENT_ROOT);
		createEReference(ecrmlDocumentRootEClass, ECRML_DOCUMENT_ROOT__REPOSITORY);

		// Create enums
		eKeyTypeEEnum = createEEnum(EKEY_TYPE);
		eAccessTypeEEnum = createEEnum(EACCESS_TYPE);
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
		eMetaEClass.getESuperTypes().add(this.getCommonAttrs());
		eRepositoryEClass.getESuperTypes().add(this.getEAttributeAndDescription());
		eRepositoryEClass.getESuperTypes().add(this.getEAccessContainer());
		eRepositoryEClass.getESuperTypes().add(this.getEBackup());
		eKeyEClass.getESuperTypes().add(this.getEAttributeAndDescription());
		eKeyEClass.getESuperTypes().add(this.getERefContainer());
		eKeyEClass.getESuperTypes().add(this.getEReadOnly());
		eKeyEClass.getESuperTypes().add(this.getEAccessContainer());
		eKeyEClass.getESuperTypes().add(this.getEBackup());
		eKeyRangeEClass.getESuperTypes().add(this.getEAttributeAndDescription());
		eKeyRangeEClass.getESuperTypes().add(this.getERefContainer());
		eKeyRangeEClass.getESuperTypes().add(this.getEReadOnly());
		eKeyRangeEClass.getESuperTypes().add(this.getEAccessContainer());
		eKeyRangeEClass.getESuperTypes().add(this.getEBackup());
		eAccessEClass.getESuperTypes().add(this.getEAttributeAndDescription());
		eValueEClass.getESuperTypes().add(this.getEContent());
		eBitEClass.getESuperTypes().add(this.getEContent());
		eBitEClass.getESuperTypes().add(this.getERefContainer());
		eAttributeAndDescriptionEClass.getESuperTypes().add(this.getCommonAttrs());

		// Initialize classes and features; add operations and parameters
		initEClass(commonAttrsEClass, CommonAttrs.class, "CommonAttrs", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCommonAttrs_Id(), ecorePackage.getEString(), "id", null, 0, 1, CommonAttrs.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eMetaEClass, EMeta.class, "EMeta", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEMeta_Identification(), ecorePackage.getEString(), "identification", null, 0, 1, EMeta.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEMeta_Date(), ecorePackage.getEString(), "date", null, 0, 1, EMeta.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEMeta_Platform(), ecorePackage.getEString(), "platform", null, 0, 1, EMeta.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEMeta_Owner(), ecorePackage.getEString(), "owner", null, 0, 1, EMeta.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEMeta_Editor(), ecorePackage.getEString(), "editor", null, 0, 1, EMeta.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEMeta_Status(), ecorePackage.getEString(), "status", null, 0, 1, EMeta.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEMeta_Version(), ecorePackage.getEString(), "version", null, 0, 1, EMeta.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEMeta_Product(), ecorePackage.getEString(), "product", null, 0, 1, EMeta.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEMeta_Release(), ecorePackage.getEString(), "release", null, 0, 1, EMeta.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eContentEClass, EContent.class, "EContent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEContent_Value(), ecorePackage.getEString(), "value", null, 0, 1, EContent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eRepositoryEClass, ERepository.class, "ERepository", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getERepository_Version(), ecorePackage.getEString(), "version", null, 0, 1, ERepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getERepository_UidName(), ecorePackage.getEString(), "uidName", null, 0, 1, ERepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getERepository_UidValue(), ecorePackage.getEString(), "uidValue", null, 0, 1, ERepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getERepository_InitialisationFileVersion(), ecorePackage.getEString(), "initialisationFileVersion", null, 0, 1, ERepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getERepository_Owner(), ecorePackage.getEString(), "owner", null, 0, 1, ERepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getERepository_Rfs(), ecorePackage.getEBoolean(), "rfs", null, 0, 1, ERepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getERepository_Key(), this.getEKey(), null, "key", null, 0, -1, ERepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getERepository_Meta(), this.getEMeta(), null, "meta", null, 0, 1, ERepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getERepository_RangeKey(), this.getEKeyRange(), null, "rangeKey", null, 0, -1, ERepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eKeyEClass, EKey.class, "EKey", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEKey_Name(), ecorePackage.getEString(), "name", null, 0, 1, EKey.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEKey_Ident(), ecorePackage.getEString(), "ident", null, 0, 1, EKey.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEKey_Type(), this.getEKeyType(), "type", null, 0, 1, EKey.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEKey_Value(), this.getEValue(), null, "value", null, 0, -1, EKey.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEKey_Bits(), this.getEBit(), null, "bits", null, 0, -1, EKey.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eKeyRangeEClass, EKeyRange.class, "EKeyRange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEKeyRange_Name(), ecorePackage.getEString(), "name", null, 0, 1, EKeyRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEKeyRange_Int(), ecorePackage.getEString(), "int", null, 0, 1, EKeyRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEKeyRange_FirstInt(), ecorePackage.getEString(), "firstInt", null, 0, 1, EKeyRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEKeyRange_LastInt(), ecorePackage.getEString(), "lastInt", null, 0, 1, EKeyRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEKeyRange_IndexBits(), ecorePackage.getEString(), "indexBits", null, 0, 1, EKeyRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEKeyRange_FirstIndex(), ecorePackage.getEString(), "firstIndex", null, 0, 1, EKeyRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEKeyRange_CountInt(), ecorePackage.getEString(), "countInt", null, 0, 1, EKeyRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEKeyRange_Keys(), this.getEKey(), null, "keys", null, 0, -1, EKeyRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eAccessEClass, EAccess.class, "EAccess", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEAccess_Type(), this.getEAccessType(), "type", null, 0, 1, EAccess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEAccess_Capabilities(), ecorePackage.getEString(), "capabilities", null, 0, 1, EAccess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEAccess_Sid(), ecorePackage.getEString(), "sid", null, 0, 1, EAccess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eValueEClass, EValue.class, "EValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEValue_Val(), ecorePackage.getEString(), "val", null, 0, 1, EValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEValue_Id(), ecorePackage.getEString(), "id", null, 0, 1, EValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eBitEClass, EBit.class, "EBit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEBit_State(), ecorePackage.getEBoolean(), "state", null, 0, 1, EBit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eRefContainerEClass, ERefContainer.class, "ERefContainer", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getERefContainer_Ref(), ecorePackage.getEString(), "ref", null, 0, 1, ERefContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eAttributeAndDescriptionEClass, EAttributeAndDescription.class, "EAttributeAndDescription", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEAttributeAndDescription_Desc(), ecorePackage.getEString(), "desc", null, 0, 1, EAttributeAndDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eReadOnlyEClass, EReadOnly.class, "EReadOnly", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEReadOnly_ReadOnly(), ecorePackage.getEBoolean(), "readOnly", null, 0, 1, EReadOnly.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eAccessContainerEClass, EAccessContainer.class, "EAccessContainer", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEAccessContainer_Access(), this.getEAccess(), null, "access", null, 0, -1, EAccessContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eBackupEClass, EBackup.class, "EBackup", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEBackup_Backup(), ecorePackage.getEBoolean(), "backup", null, 0, 1, EBackup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ecrmlDocumentRootEClass, ECRMLDocumentRoot.class, "ECRMLDocumentRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getECRMLDocumentRoot_Repository(), this.getERepository(), null, "repository", null, 1, 1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(eKeyTypeEEnum, EKeyType.class, "EKeyType");
		addEEnumLiteral(eKeyTypeEEnum, EKeyType.INT);
		addEEnumLiteral(eKeyTypeEEnum, EKeyType.REAL);
		addEEnumLiteral(eKeyTypeEEnum, EKeyType.STRING);
		addEEnumLiteral(eKeyTypeEEnum, EKeyType.STRING8);
		addEEnumLiteral(eKeyTypeEEnum, EKeyType.BINARY);

		initEEnum(eAccessTypeEEnum, EAccessType.class, "EAccessType");
		addEEnumLiteral(eAccessTypeEEnum, EAccessType.ND);
		addEEnumLiteral(eAccessTypeEEnum, EAccessType.READ);
		addEEnumLiteral(eAccessTypeEEnum, EAccessType.WRITE);

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
		  (commonAttrsEClass, 
		   source, 
		   new String[] {
			 "name", "commonType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (eMetaEClass, 
		   source, 
		   new String[] {
			 "name", "metaType",
			 "type", "elementOnly"
		   });		
		addAnnotation
		  (getEMeta_Identification(), 
		   source, 
		   new String[] {
			 "name", "id",
			 "kind", "element",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getEMeta_Date(), 
		   source, 
		   new String[] {
			 "name", "date",
			 "kind", "element",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getEMeta_Platform(), 
		   source, 
		   new String[] {
			 "name", "platform",
			 "kind", "element",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getEMeta_Owner(), 
		   source, 
		   new String[] {
			 "name", "owner",
			 "kind", "element",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getEMeta_Editor(), 
		   source, 
		   new String[] {
			 "name", "editor",
			 "kind", "element",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getEMeta_Status(), 
		   source, 
		   new String[] {
			 "name", "status",
			 "kind", "element",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getEMeta_Version(), 
		   source, 
		   new String[] {
			 "name", "version",
			 "kind", "element",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getEMeta_Product(), 
		   source, 
		   new String[] {
			 "name", "product",
			 "kind", "element",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getEMeta_Release(), 
		   source, 
		   new String[] {
			 "name", "release",
			 "kind", "element",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (eContentEClass, 
		   source, 
		   new String[] {
			 "name", "contentType",
			 "kind", "simple"
		   });		
		addAnnotation
		  (getEContent_Value(), 
		   source, 
		   new String[] {
			 "name", "value",
			 "kind", "simple"
		   });		
		addAnnotation
		  (eRepositoryEClass, 
		   source, 
		   new String[] {
			 "name", "repository",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getERepository_Key(), 
		   source, 
		   new String[] {
			 "name", "key",
			 "namespace", "##targetNamespace",
			 "kind", "element"
		   });		
		addAnnotation
		  (getERepository_Meta(), 
		   source, 
		   new String[] {
			 "name", "meta",
			 "namespace", "##targetNamespace",
			 "kind", "element"
		   });		
		addAnnotation
		  (getERepository_RangeKey(), 
		   source, 
		   new String[] {
			 "name", "keyRange",
			 "kind", "element",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (eKeyEClass, 
		   source, 
		   new String[] {
			 "name", "keyType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getEKey_Ident(), 
		   source, 
		   new String[] {
			 "name", "int",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getEKey_Value(), 
		   source, 
		   new String[] {
			 "name", "value",
			 "namespace", "##targetNamespace",
			 "kind", "element"
		   });		
		addAnnotation
		  (getEKey_Bits(), 
		   source, 
		   new String[] {
			 "name", "bit",
			 "namespace", "##targetNamespace",
			 "kind", "element"
		   });		
		addAnnotation
		  (eKeyRangeEClass, 
		   source, 
		   new String[] {
			 "name", "keyRangeType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getEKeyRange_Keys(), 
		   source, 
		   new String[] {
			 "name", "key",
			 "namespace", "##targetNamespace",
			 "kind", "element"
		   });		
		addAnnotation
		  (eAccessEClass, 
		   source, 
		   new String[] {
			 "name", "accessType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (eValueEClass, 
		   source, 
		   new String[] {
			 "name", "valueType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getEValue_Val(), 
		   source, 
		   new String[] {
			 "name", "value",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (eBitEClass, 
		   source, 
		   new String[] {
			 "name", "bitType",
			 "kind", "simple"
		   });		
		addAnnotation
		  (getEBit_State(), 
		   source, 
		   new String[] {
			 "name", "value",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (eRefContainerEClass, 
		   source, 
		   new String[] {
			 "name", "rvgType",
			 "kind", "empty"
		   });		
		addAnnotation
		  (eKeyTypeEEnum, 
		   source, 
		   new String[] {
			 "name", "keyTypeValue",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (eAccessTypeEEnum, 
		   source, 
		   new String[] {
			 "name", "accessTypeValue",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (eAttributeAndDescriptionEClass, 
		   source, 
		   new String[] {
			 "name", "desc",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getEAttributeAndDescription_Desc(), 
		   source, 
		   new String[] {
			 "name", "desc",
			 "kind", "element",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (eReadOnlyEClass, 
		   source, 
		   new String[] {
			 "name", "readOnlyType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (eAccessContainerEClass, 
		   source, 
		   new String[] {
			 "name", "accessibleType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getEAccessContainer_Access(), 
		   source, 
		   new String[] {
			 "name", "access",
			 "namespace", "##targetNamespace",
			 "kind", "element"
		   });		
		addAnnotation
		  (eBackupEClass, 
		   source, 
		   new String[] {
			 "name", "backupType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (ecrmlDocumentRootEClass, 
		   source, 
		   new String[] {
			 "name", "",
			 "kind", "mixed"
		   });		
		addAnnotation
		  (getECRMLDocumentRoot_Repository(), 
		   source, 
		   new String[] {
			 "name", "repository",
			 "kind", "element",
			 "namespace", "##targetNamespace"
		   });
	}

} //ECRMLPackageImpl
