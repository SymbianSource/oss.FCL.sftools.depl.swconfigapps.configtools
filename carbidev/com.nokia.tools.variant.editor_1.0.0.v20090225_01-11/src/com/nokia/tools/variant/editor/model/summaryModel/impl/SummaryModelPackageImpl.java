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

package com.nokia.tools.variant.editor.model.summaryModel.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import com.nokia.tools.variant.content.confml.ConfmlPackage;
import com.nokia.tools.variant.editor.model.UIModelPackage;
import com.nokia.tools.variant.editor.model.impl.UIModelPackageImpl;
import com.nokia.tools.variant.editor.model.summaryModel.History;
import com.nokia.tools.variant.editor.model.summaryModel.Note;
import com.nokia.tools.variant.editor.model.summaryModel.SummaryModelFactory;
import com.nokia.tools.variant.editor.model.summaryModel.SummaryModelPackage;
import com.nokia.tools.variant.editor.model.summaryModel.UIElement;
import com.nokia.tools.variant.editor.model.summaryModel.UISummaryGroup;
import com.nokia.tools.variant.editor.model.summaryModel.UISummaryModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SummaryModelPackageImpl extends EPackageImpl implements SummaryModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass uiSummaryModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass uiElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass uiSummaryGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass noteEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass historyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum summarytypeEEnum = null;

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
	 * @see com.nokia.tools.variant.editor.model.summaryModel.SummaryModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SummaryModelPackageImpl() {
		super(eNS_URI, SummaryModelFactory.eINSTANCE);
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
	public static SummaryModelPackage init() {
		if (isInited) return (SummaryModelPackage)EPackage.Registry.INSTANCE.getEPackage(SummaryModelPackage.eNS_URI);

		// Obtain or create and register package
		SummaryModelPackageImpl theSummaryModelPackage = (SummaryModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof SummaryModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new SummaryModelPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ConfmlPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		UIModelPackageImpl theUIModelPackage = (UIModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(UIModelPackage.eNS_URI) instanceof UIModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(UIModelPackage.eNS_URI) : UIModelPackage.eINSTANCE);

		// Create package meta-data objects
		theSummaryModelPackage.createPackageContents();
		theUIModelPackage.createPackageContents();

		// Initialize created meta-data
		theSummaryModelPackage.initializePackageContents();
		theUIModelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSummaryModelPackage.freeze();

		return theSummaryModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUISummaryModel() {
		return uiSummaryModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUISummaryModel_UiGroups() {
		return (EReference)uiSummaryModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUIElement() {
		return uiElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUIElement_Name() {
		return (EAttribute)uiElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUIElement_Type() {
		return (EAttribute)uiElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUIElement_LastSavedValue() {
		return (EAttribute)uiElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUIElement_Value() {
		return (EAttribute)uiElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUIElement_DefaultValue() {
		return (EAttribute)uiElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUIElement_Note() {
		return (EAttribute)uiElementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUISummaryGroup() {
		return uiSummaryGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUISummaryGroup_Title() {
		return (EAttribute)uiSummaryGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUISummaryGroup_UiElements() {
		return (EReference)uiSummaryGroupEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNote() {
		return noteEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNote_Date() {
		return (EAttribute)noteEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNote_Content() {
		return (EAttribute)noteEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHistory() {
		return historyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHistory_Note() {
		return (EReference)historyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSUMMARYTYPE() {
		return summarytypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SummaryModelFactory getSummaryModelFactory() {
		return (SummaryModelFactory)getEFactoryInstance();
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
		uiSummaryModelEClass = createEClass(UI_SUMMARY_MODEL);
		createEReference(uiSummaryModelEClass, UI_SUMMARY_MODEL__UI_GROUPS);

		uiElementEClass = createEClass(UI_ELEMENT);
		createEAttribute(uiElementEClass, UI_ELEMENT__NAME);
		createEAttribute(uiElementEClass, UI_ELEMENT__TYPE);
		createEAttribute(uiElementEClass, UI_ELEMENT__LAST_SAVED_VALUE);
		createEAttribute(uiElementEClass, UI_ELEMENT__VALUE);
		createEAttribute(uiElementEClass, UI_ELEMENT__DEFAULT_VALUE);
		createEAttribute(uiElementEClass, UI_ELEMENT__NOTE);

		uiSummaryGroupEClass = createEClass(UI_SUMMARY_GROUP);
		createEAttribute(uiSummaryGroupEClass, UI_SUMMARY_GROUP__TITLE);
		createEReference(uiSummaryGroupEClass, UI_SUMMARY_GROUP__UI_ELEMENTS);

		noteEClass = createEClass(NOTE);
		createEAttribute(noteEClass, NOTE__DATE);
		createEAttribute(noteEClass, NOTE__CONTENT);

		historyEClass = createEClass(HISTORY);
		createEReference(historyEClass, HISTORY__NOTE);

		// Create enums
		summarytypeEEnum = createEEnum(SUMMARYTYPE);
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
		initEClass(uiSummaryModelEClass, UISummaryModel.class, "UISummaryModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUISummaryModel_UiGroups(), this.getUISummaryGroup(), null, "uiGroups", null, 0, -1, UISummaryModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(uiElementEClass, UIElement.class, "UIElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUIElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, UIElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUIElement_Type(), this.getSUMMARYTYPE(), "type", null, 0, 1, UIElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUIElement_LastSavedValue(), ecorePackage.getEString(), "lastSavedValue", "", 0, 1, UIElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUIElement_Value(), ecorePackage.getEString(), "value", "", 0, 1, UIElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUIElement_DefaultValue(), ecorePackage.getEString(), "defaultValue", null, 0, 1, UIElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUIElement_Note(), ecorePackage.getEString(), "note", "", 0, 1, UIElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(uiElementEClass, ecorePackage.getEBoolean(), "isDirty", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(uiElementEClass, ecorePackage.getEBoolean(), "isDefault", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(uiSummaryGroupEClass, UISummaryGroup.class, "UISummaryGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUISummaryGroup_Title(), ecorePackage.getEString(), "title", null, 0, 1, UISummaryGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUISummaryGroup_UiElements(), this.getUIElement(), null, "uiElements", null, 0, -1, UISummaryGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(noteEClass, Note.class, "Note", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNote_Date(), ecorePackage.getEString(), "date", null, 0, 1, Note.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNote_Content(), ecorePackage.getEString(), "content", null, 0, 1, Note.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(historyEClass, History.class, "History", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getHistory_Note(), this.getNote(), null, "note", null, 0, -1, History.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(summarytypeEEnum, com.nokia.tools.variant.editor.model.summaryModel.SUMMARYTYPE.class, "SUMMARYTYPE");
		addEEnumLiteral(summarytypeEEnum, com.nokia.tools.variant.editor.model.summaryModel.SUMMARYTYPE.NAME);
		addEEnumLiteral(summarytypeEEnum, com.nokia.tools.variant.editor.model.summaryModel.SUMMARYTYPE.OWNER);
		addEEnumLiteral(summarytypeEEnum, com.nokia.tools.variant.editor.model.summaryModel.SUMMARYTYPE.CONTENTS);
		addEEnumLiteral(summarytypeEEnum, com.nokia.tools.variant.editor.model.summaryModel.SUMMARYTYPE.CUSTOMER);
		addEEnumLiteral(summarytypeEEnum, com.nokia.tools.variant.editor.model.summaryModel.SUMMARYTYPE.AUTHOR);
		addEEnumLiteral(summarytypeEEnum, com.nokia.tools.variant.editor.model.summaryModel.SUMMARYTYPE.PRODUCTIMAGES);
		addEEnumLiteral(summarytypeEEnum, com.nokia.tools.variant.editor.model.summaryModel.SUMMARYTYPE.GUIDELINE);
		addEEnumLiteral(summarytypeEEnum, com.nokia.tools.variant.editor.model.summaryModel.SUMMARYTYPE.DESCRIPTION);
		addEEnumLiteral(summarytypeEEnum, com.nokia.tools.variant.editor.model.summaryModel.SUMMARYTYPE.VERSION);
		addEEnumLiteral(summarytypeEEnum, com.nokia.tools.variant.editor.model.summaryModel.SUMMARYTYPE.DATE);
		addEEnumLiteral(summarytypeEEnum, com.nokia.tools.variant.editor.model.summaryModel.SUMMARYTYPE.HISTORY);
		addEEnumLiteral(summarytypeEEnum, com.nokia.tools.variant.editor.model.summaryModel.SUMMARYTYPE.PRODUCT);
		addEEnumLiteral(summarytypeEEnum, com.nokia.tools.variant.editor.model.summaryModel.SUMMARYTYPE.PLATFORM);
		addEEnumLiteral(summarytypeEEnum, com.nokia.tools.variant.editor.model.summaryModel.SUMMARYTYPE.RELEASE);
		addEEnumLiteral(summarytypeEEnum, com.nokia.tools.variant.editor.model.summaryModel.SUMMARYTYPE.AVR);
		addEEnumLiteral(summarytypeEEnum, com.nokia.tools.variant.editor.model.summaryModel.SUMMARYTYPE.STATUS);
		addEEnumLiteral(summarytypeEEnum, com.nokia.tools.variant.editor.model.summaryModel.SUMMARYTYPE.ORIGIN);
		addEEnumLiteral(summarytypeEEnum, com.nokia.tools.variant.editor.model.summaryModel.SUMMARYTYPE.TARGET);
	}

} //SummaryModelPackageImpl
