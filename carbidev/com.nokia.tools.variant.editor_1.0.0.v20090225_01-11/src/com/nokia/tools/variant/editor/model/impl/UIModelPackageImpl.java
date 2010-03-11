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

package com.nokia.tools.variant.editor.model.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import com.nokia.tools.variant.content.confml.ConfmlPackage;
import com.nokia.tools.variant.editor.model.SortingCriteria;
import com.nokia.tools.variant.editor.model.SortingOrder;
import com.nokia.tools.variant.editor.model.UIGroup;
import com.nokia.tools.variant.editor.model.UIMessage;
import com.nokia.tools.variant.editor.model.UIMessageType;
import com.nokia.tools.variant.editor.model.UIModel;
import com.nokia.tools.variant.editor.model.UIModelFactory;
import com.nokia.tools.variant.editor.model.UIModelPackage;
import com.nokia.tools.variant.editor.model.UISetting;
import com.nokia.tools.variant.editor.model.summaryModel.SummaryModelPackage;
import com.nokia.tools.variant.editor.model.summaryModel.impl.SummaryModelPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UIModelPackageImpl extends EPackageImpl implements UIModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass uiModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass uiGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass uiSettingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass uiMessageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum uiMessageTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum sortingOrderEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum sortingCriteriaEEnum = null;

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
	 * @see com.nokia.tools.variant.editor.model.UIModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private UIModelPackageImpl() {
		super(eNS_URI, UIModelFactory.eINSTANCE);
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
	public static UIModelPackage init() {
		if (isInited) return (UIModelPackage)EPackage.Registry.INSTANCE.getEPackage(UIModelPackage.eNS_URI);

		// Obtain or create and register package
		UIModelPackageImpl theUIModelPackage = (UIModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof UIModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new UIModelPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ConfmlPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		SummaryModelPackageImpl theSummaryModelPackage = (SummaryModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SummaryModelPackage.eNS_URI) instanceof SummaryModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SummaryModelPackage.eNS_URI) : SummaryModelPackage.eINSTANCE);

		// Create package meta-data objects
		theUIModelPackage.createPackageContents();
		theSummaryModelPackage.createPackageContents();

		// Initialize created meta-data
		theUIModelPackage.initializePackageContents();
		theSummaryModelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theUIModelPackage.freeze();

		return theUIModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUIModel() {
		return uiModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUIModel_UiGroups() {
		return (EReference)uiModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUIGroup() {
		return uiGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUIGroup_UiSettings() {
		return (EReference)uiGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUIGroup_Title() {
		return (EAttribute)uiGroupEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUIGroup_SortingOrder() {
		return (EAttribute)uiGroupEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUIGroup_Model() {
		return (EAttribute)uiGroupEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUIGroup_UiGroups() {
		return (EReference)uiGroupEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUISetting() {
		return uiSettingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUISetting_Setting() {
		return (EReference)uiSettingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUISetting_Selected() {
		return (EAttribute)uiSettingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUISetting_Focused() {
		return (EAttribute)uiSettingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUISetting_UiMessages() {
		return (EReference)uiSettingEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUISetting_Children() {
		return (EReference)uiSettingEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUISetting_Data() {
		return (EAttribute)uiSettingEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUIMessage() {
		return uiMessageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUIMessage_Type() {
		return (EAttribute)uiMessageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUIMessage_Text() {
		return (EAttribute)uiMessageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getUIMessageType() {
		return uiMessageTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSortingOrder() {
		return sortingOrderEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSortingCriteria() {
		return sortingCriteriaEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UIModelFactory getUIModelFactory() {
		return (UIModelFactory)getEFactoryInstance();
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
		uiModelEClass = createEClass(UI_MODEL);
		createEReference(uiModelEClass, UI_MODEL__UI_GROUPS);

		uiGroupEClass = createEClass(UI_GROUP);
		createEReference(uiGroupEClass, UI_GROUP__UI_SETTINGS);
		createEAttribute(uiGroupEClass, UI_GROUP__TITLE);
		createEAttribute(uiGroupEClass, UI_GROUP__SORTING_ORDER);
		createEAttribute(uiGroupEClass, UI_GROUP__MODEL);
		createEReference(uiGroupEClass, UI_GROUP__UI_GROUPS);

		uiSettingEClass = createEClass(UI_SETTING);
		createEReference(uiSettingEClass, UI_SETTING__SETTING);
		createEAttribute(uiSettingEClass, UI_SETTING__SELECTED);
		createEAttribute(uiSettingEClass, UI_SETTING__FOCUSED);
		createEReference(uiSettingEClass, UI_SETTING__UI_MESSAGES);
		createEReference(uiSettingEClass, UI_SETTING__CHILDREN);
		createEAttribute(uiSettingEClass, UI_SETTING__DATA);

		uiMessageEClass = createEClass(UI_MESSAGE);
		createEAttribute(uiMessageEClass, UI_MESSAGE__TYPE);
		createEAttribute(uiMessageEClass, UI_MESSAGE__TEXT);

		// Create enums
		uiMessageTypeEEnum = createEEnum(UI_MESSAGE_TYPE);
		sortingOrderEEnum = createEEnum(SORTING_ORDER);
		sortingCriteriaEEnum = createEEnum(SORTING_CRITERIA);
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

		// Obtain other dependent packages
		SummaryModelPackage theSummaryModelPackage = (SummaryModelPackage)EPackage.Registry.INSTANCE.getEPackage(SummaryModelPackage.eNS_URI);
		ConfmlPackage theConfmlPackage = (ConfmlPackage)EPackage.Registry.INSTANCE.getEPackage(ConfmlPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theSummaryModelPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(uiModelEClass, UIModel.class, "UIModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUIModel_UiGroups(), this.getUIGroup(), null, "uiGroups", null, 0, -1, UIModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(uiGroupEClass, UIGroup.class, "UIGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUIGroup_UiSettings(), this.getUISetting(), null, "uiSettings", null, 0, -1, UIGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUIGroup_Title(), ecorePackage.getEString(), "title", null, 0, 1, UIGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUIGroup_SortingOrder(), this.getSortingOrder(), "sortingOrder", null, 0, 1, UIGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUIGroup_Model(), theConfmlPackage.getObject(), "model", null, 0, 1, UIGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUIGroup_UiGroups(), this.getUIGroup(), null, "uiGroups", null, 0, -1, UIGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(uiSettingEClass, UISetting.class, "UISetting", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUISetting_Setting(), theConfmlPackage.getSetting(), null, "setting", null, 0, 1, UISetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUISetting_Selected(), ecorePackage.getEBoolean(), "selected", null, 0, 1, UISetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUISetting_Focused(), ecorePackage.getEBoolean(), "focused", null, 0, 1, UISetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUISetting_UiMessages(), this.getUIMessage(), null, "uiMessages", null, 0, -1, UISetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUISetting_Children(), this.getUISetting(), null, "children", null, 0, -1, UISetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUISetting_Data(), ecorePackage.getEJavaObject(), "data", null, 0, 1, UISetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(uiMessageEClass, UIMessage.class, "UIMessage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUIMessage_Type(), this.getUIMessageType(), "type", null, 0, 1, UIMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUIMessage_Text(), ecorePackage.getEString(), "text", null, 0, 1, UIMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(uiMessageTypeEEnum, UIMessageType.class, "UIMessageType");
		addEEnumLiteral(uiMessageTypeEEnum, UIMessageType.INFO);
		addEEnumLiteral(uiMessageTypeEEnum, UIMessageType.WARNING);
		addEEnumLiteral(uiMessageTypeEEnum, UIMessageType.ERROR);

		initEEnum(sortingOrderEEnum, SortingOrder.class, "SortingOrder");
		addEEnumLiteral(sortingOrderEEnum, SortingOrder.ASCENDING);
		addEEnumLiteral(sortingOrderEEnum, SortingOrder.DESCENDING);

		initEEnum(sortingCriteriaEEnum, SortingCriteria.class, "SortingCriteria");
		addEEnumLiteral(sortingCriteriaEEnum, SortingCriteria.FEATURE);
		addEEnumLiteral(sortingCriteriaEEnum, SortingCriteria.NOTE);
		addEEnumLiteral(sortingCriteriaEEnum, SortingCriteria.DEFAULT_VALUE);

		// Create resource
		createResource(eNS_URI);
	}

} //UIModelPackageImpl
