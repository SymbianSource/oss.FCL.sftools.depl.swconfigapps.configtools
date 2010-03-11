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
 * Description: This file is part of com.nokia.tools.variant.compare component.
 */

package com.nokia.tools.variant.compare.cmodel.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import com.nokia.tools.variant.compare.cmodel.ECheckableElement;
import com.nokia.tools.variant.compare.cmodel.ECompareElement;
import com.nokia.tools.variant.compare.cmodel.ECompareModelFactory;
import com.nokia.tools.variant.compare.cmodel.ECompareModelPackage;
import com.nokia.tools.variant.compare.cmodel.EDiffGroup;
import com.nokia.tools.variant.compare.cmodel.EDiffLocalPathSetting;
import com.nokia.tools.variant.compare.cmodel.EDiffMismatch;
import com.nokia.tools.variant.compare.cmodel.EDiffResourceSetting2;
import com.nokia.tools.variant.compare.cmodel.EDiffSequence;
import com.nokia.tools.variant.compare.cmodel.EDiffSequenceItem;
import com.nokia.tools.variant.compare.cmodel.EDiffSetting;
import com.nokia.tools.variant.compare.cmodel.EDiffSettingContainer;
import com.nokia.tools.variant.compare.cmodel.EDiffSimple;
import com.nokia.tools.variant.compare.cmodel.EGroupContainer;
import com.nokia.tools.variant.compare.cmodel.EModelRoot;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ECompareModelPackageImpl extends EPackageImpl implements ECompareModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eModelRootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eDiffGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eDiffSettingEClass = null;

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
	private EClass eCompareElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eDiffSimpleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eDiffSequenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eDiffSettingContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eDiffResourceSetting2EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eDiffLocalPathSettingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eDiffMismatchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eCheckableElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eDiffSequenceItemEClass = null;

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
	 * @see com.nokia.tools.variant.compare.cmodel.ECompareModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ECompareModelPackageImpl() {
		super(eNS_URI, ECompareModelFactory.eINSTANCE);
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
	public static ECompareModelPackage init() {
		if (isInited) return (ECompareModelPackage)EPackage.Registry.INSTANCE.getEPackage(ECompareModelPackage.eNS_URI);

		// Obtain or create and register package
		ECompareModelPackageImpl theECompareModelPackage = (ECompareModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof ECompareModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new ECompareModelPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theECompareModelPackage.createPackageContents();

		// Initialize created meta-data
		theECompareModelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theECompareModelPackage.freeze();

		return theECompareModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEModelRoot() {
		return eModelRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEDiffGroup() {
		return eDiffGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEDiffGroup_Name() {
		return (EAttribute)eDiffGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEDiffSetting() {
		return eDiffSettingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEDiffSetting_AbsRef() {
		return (EAttribute)eDiffSettingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEDiffSetting_Name() {
		return (EAttribute)eDiffSettingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEDiffSetting_SourceDefault() {
		return (EAttribute)eDiffSettingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEDiffSetting_TargetDefault() {
		return (EAttribute)eDiffSettingEClass.getEStructuralFeatures().get(3);
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
		return (EReference)eGroupContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getECompareElement() {
		return eCompareElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getECompareElement_ExistsInSource() {
		return (EAttribute)eCompareElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getECompareElement_ExistsInTarget() {
		return (EAttribute)eCompareElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getECompareElement_SourceObject() {
		return (EReference)eCompareElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getECompareElement_TargetObject() {
		return (EReference)eCompareElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEDiffSimple() {
		return eDiffSimpleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEDiffSimple_SourceValue() {
		return (EAttribute)eDiffSimpleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEDiffSimple_TargetValue() {
		return (EAttribute)eDiffSimpleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEDiffSequence() {
		return eDiffSequenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEDiffSequence_ItemCount() {
		return (EAttribute)eDiffSequenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEDiffSequence_Items() {
		return (EReference)eDiffSequenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEDiffSettingContainer() {
		return eDiffSettingContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEDiffSettingContainer_Settings() {
		return (EReference)eDiffSettingContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEDiffResourceSetting2() {
		return eDiffResourceSetting2EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEDiffResourceSetting2_SourcePath() {
		return (EReference)eDiffResourceSetting2EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEDiffResourceSetting2_TargetPath() {
		return (EReference)eDiffResourceSetting2EClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEDiffLocalPathSetting() {
		return eDiffLocalPathSettingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEDiffLocalPathSetting_Uri() {
		return (EAttribute)eDiffLocalPathSettingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEDiffLocalPathSetting_EqualContent() {
		return (EAttribute)eDiffLocalPathSettingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEDiffMismatch() {
		return eDiffMismatchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEDiffMismatch_SourceType() {
		return (EAttribute)eDiffMismatchEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEDiffMismatch_TargetType() {
		return (EAttribute)eDiffMismatchEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getECheckableElement() {
		return eCheckableElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getECheckableElement_Checked() {
		return (EAttribute)eCheckableElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEDiffSequenceItem() {
		return eDiffSequenceItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ECompareModelFactory getECompareModelFactory() {
		return (ECompareModelFactory)getEFactoryInstance();
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
		eDiffSettingContainerEClass = createEClass(EDIFF_SETTING_CONTAINER);
		createEReference(eDiffSettingContainerEClass, EDIFF_SETTING_CONTAINER__SETTINGS);

		eGroupContainerEClass = createEClass(EGROUP_CONTAINER);
		createEReference(eGroupContainerEClass, EGROUP_CONTAINER__GROUPS);

		eCompareElementEClass = createEClass(ECOMPARE_ELEMENT);
		createEAttribute(eCompareElementEClass, ECOMPARE_ELEMENT__EXISTS_IN_SOURCE);
		createEAttribute(eCompareElementEClass, ECOMPARE_ELEMENT__EXISTS_IN_TARGET);
		createEReference(eCompareElementEClass, ECOMPARE_ELEMENT__SOURCE_OBJECT);
		createEReference(eCompareElementEClass, ECOMPARE_ELEMENT__TARGET_OBJECT);

		eModelRootEClass = createEClass(EMODEL_ROOT);

		eDiffGroupEClass = createEClass(EDIFF_GROUP);
		createEAttribute(eDiffGroupEClass, EDIFF_GROUP__NAME);

		eDiffSettingEClass = createEClass(EDIFF_SETTING);
		createEAttribute(eDiffSettingEClass, EDIFF_SETTING__ABS_REF);
		createEAttribute(eDiffSettingEClass, EDIFF_SETTING__NAME);
		createEAttribute(eDiffSettingEClass, EDIFF_SETTING__SOURCE_DEFAULT);
		createEAttribute(eDiffSettingEClass, EDIFF_SETTING__TARGET_DEFAULT);

		eDiffSimpleEClass = createEClass(EDIFF_SIMPLE);
		createEAttribute(eDiffSimpleEClass, EDIFF_SIMPLE__SOURCE_VALUE);
		createEAttribute(eDiffSimpleEClass, EDIFF_SIMPLE__TARGET_VALUE);

		eDiffSequenceEClass = createEClass(EDIFF_SEQUENCE);
		createEAttribute(eDiffSequenceEClass, EDIFF_SEQUENCE__ITEM_COUNT);
		createEReference(eDiffSequenceEClass, EDIFF_SEQUENCE__ITEMS);

		eDiffResourceSetting2EClass = createEClass(EDIFF_RESOURCE_SETTING2);
		createEReference(eDiffResourceSetting2EClass, EDIFF_RESOURCE_SETTING2__SOURCE_PATH);
		createEReference(eDiffResourceSetting2EClass, EDIFF_RESOURCE_SETTING2__TARGET_PATH);

		eDiffLocalPathSettingEClass = createEClass(EDIFF_LOCAL_PATH_SETTING);
		createEAttribute(eDiffLocalPathSettingEClass, EDIFF_LOCAL_PATH_SETTING__URI);
		createEAttribute(eDiffLocalPathSettingEClass, EDIFF_LOCAL_PATH_SETTING__EQUAL_CONTENT);

		eDiffMismatchEClass = createEClass(EDIFF_MISMATCH);
		createEAttribute(eDiffMismatchEClass, EDIFF_MISMATCH__SOURCE_TYPE);
		createEAttribute(eDiffMismatchEClass, EDIFF_MISMATCH__TARGET_TYPE);

		eCheckableElementEClass = createEClass(ECHECKABLE_ELEMENT);
		createEAttribute(eCheckableElementEClass, ECHECKABLE_ELEMENT__CHECKED);

		eDiffSequenceItemEClass = createEClass(EDIFF_SEQUENCE_ITEM);
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
		eModelRootEClass.getESuperTypes().add(this.getEGroupContainer());
		eDiffGroupEClass.getESuperTypes().add(this.getECompareElement());
		eDiffGroupEClass.getESuperTypes().add(this.getEGroupContainer());
		eDiffGroupEClass.getESuperTypes().add(this.getEDiffSettingContainer());
		eDiffSettingEClass.getESuperTypes().add(this.getECompareElement());
		eDiffSettingEClass.getESuperTypes().add(this.getECheckableElement());
		eDiffSimpleEClass.getESuperTypes().add(this.getEDiffSetting());
		eDiffSequenceEClass.getESuperTypes().add(this.getEDiffSetting());
		eDiffResourceSetting2EClass.getESuperTypes().add(this.getEDiffSetting());
		eDiffLocalPathSettingEClass.getESuperTypes().add(this.getEDiffSimple());
		eDiffMismatchEClass.getESuperTypes().add(this.getEDiffSetting());
		eDiffSequenceItemEClass.getESuperTypes().add(this.getECompareElement());
		eDiffSequenceItemEClass.getESuperTypes().add(this.getEDiffSettingContainer());

		// Initialize classes and features; add operations and parameters
		initEClass(eDiffSettingContainerEClass, EDiffSettingContainer.class, "EDiffSettingContainer", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEDiffSettingContainer_Settings(), this.getEDiffSetting(), null, "settings", null, 0, -1, EDiffSettingContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eGroupContainerEClass, EGroupContainer.class, "EGroupContainer", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEGroupContainer_Groups(), this.getEDiffGroup(), null, "groups", null, 0, -1, EGroupContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eCompareElementEClass, ECompareElement.class, "ECompareElement", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getECompareElement_ExistsInSource(), ecorePackage.getEBoolean(), "existsInSource", null, 0, 1, ECompareElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getECompareElement_ExistsInTarget(), ecorePackage.getEBoolean(), "existsInTarget", null, 0, 1, ECompareElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getECompareElement_SourceObject(), ecorePackage.getEObject(), null, "sourceObject", null, 0, 1, ECompareElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getECompareElement_TargetObject(), ecorePackage.getEObject(), null, "targetObject", null, 0, 1, ECompareElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eModelRootEClass, EModelRoot.class, "EModelRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(eDiffGroupEClass, EDiffGroup.class, "EDiffGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEDiffGroup_Name(), ecorePackage.getEString(), "name", null, 0, 1, EDiffGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eDiffSettingEClass, EDiffSetting.class, "EDiffSetting", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEDiffSetting_AbsRef(), ecorePackage.getEString(), "absRef", "", 0, 1, EDiffSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEDiffSetting_Name(), ecorePackage.getEString(), "name", "", 0, 1, EDiffSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEDiffSetting_SourceDefault(), ecorePackage.getEBoolean(), "sourceDefault", null, 0, 1, EDiffSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEDiffSetting_TargetDefault(), ecorePackage.getEBoolean(), "targetDefault", null, 0, 1, EDiffSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eDiffSimpleEClass, EDiffSimple.class, "EDiffSimple", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEDiffSimple_SourceValue(), ecorePackage.getEString(), "sourceValue", null, 0, 1, EDiffSimple.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEDiffSimple_TargetValue(), ecorePackage.getEString(), "targetValue", null, 0, 1, EDiffSimple.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eDiffSequenceEClass, EDiffSequence.class, "EDiffSequence", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEDiffSequence_ItemCount(), ecorePackage.getEInt(), "itemCount", null, 0, 1, EDiffSequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEDiffSequence_Items(), this.getEDiffSequenceItem(), null, "items", null, 0, -1, EDiffSequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eDiffResourceSetting2EClass, EDiffResourceSetting2.class, "EDiffResourceSetting2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEDiffResourceSetting2_SourcePath(), this.getEDiffLocalPathSetting(), null, "sourcePath", null, 0, 1, EDiffResourceSetting2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEDiffResourceSetting2_TargetPath(), this.getEDiffSimple(), null, "targetPath", null, 0, 1, EDiffResourceSetting2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eDiffLocalPathSettingEClass, EDiffLocalPathSetting.class, "EDiffLocalPathSetting", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEDiffLocalPathSetting_Uri(), ecorePackage.getEString(), "uri", null, 0, 1, EDiffLocalPathSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEDiffLocalPathSetting_EqualContent(), ecorePackage.getEBoolean(), "equalContent", null, 0, 1, EDiffLocalPathSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eDiffMismatchEClass, EDiffMismatch.class, "EDiffMismatch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEDiffMismatch_SourceType(), ecorePackage.getEString(), "sourceType", null, 0, 1, EDiffMismatch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEDiffMismatch_TargetType(), ecorePackage.getEString(), "targetType", null, 0, 1, EDiffMismatch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eCheckableElementEClass, ECheckableElement.class, "ECheckableElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getECheckableElement_Checked(), ecorePackage.getEBoolean(), "checked", null, 0, 1, ECheckableElement.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eDiffSequenceItemEClass, EDiffSequenceItem.class, "EDiffSequenceItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //ECompareModelPackageImpl
