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
 * Description: This file is part of com.nokia.tools.vct.confml.editor.view component.
 */

package com.nokia.tools.vct.confml.editor.view.vemodel.impl;

import com.nokia.tools.vct.confml.editor.view.vemodel.EContents;
import java.net.URI;
import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import com.nokia.tools.vct.confml.editor.view.vemodel.EDescriptionContainer;
import com.nokia.tools.vct.confml.editor.view.vemodel.EFeature;
import com.nokia.tools.vct.confml.editor.view.vemodel.EGroup;
import com.nokia.tools.vct.confml.editor.view.vemodel.EGroupContainer;
import com.nokia.tools.vct.confml.editor.view.vemodel.EGroupEntry;
import com.nokia.tools.vct.confml.editor.view.vemodel.EIconContainer;
import com.nokia.tools.vct.confml.editor.view.vemodel.ERefOption;
import com.nokia.tools.vct.confml.editor.view.vemodel.ERefProperty;
import com.nokia.tools.vct.confml.editor.view.vemodel.ERefTarget;
import com.nokia.tools.vct.confml.editor.view.vemodel.EResourceLocator;
import com.nokia.tools.vct.confml.editor.view.vemodel.ESetting;
import com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef;
import com.nokia.tools.vct.confml.editor.view.vemodel.EView;
import com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorFactory;
import com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorPackage;
import com.nokia.tools.vct.confml.editor.view.vemodel.EViewsEditorDocument;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EViewEditorPackageImpl extends EPackageImpl implements EViewEditorPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eViewsEditorDocumentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eViewEClass = null;

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
	private EClass eSettingRefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eFeatureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eSettingEntryEClass = null;

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
	private EClass eIconContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eResourceLocatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eRefTargetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eFeatureEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eSettingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eViewEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eRefPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eRefOptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eGroupEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType eJavaURIEDataType = null;

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
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EViewEditorPackageImpl() {
		super(eNS_URI, EViewEditorFactory.eINSTANCE);
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
	public static EViewEditorPackage init() {
		if (isInited) return (EViewEditorPackage)EPackage.Registry.INSTANCE.getEPackage(EViewEditorPackage.eNS_URI);

		// Obtain or create and register package
		EViewEditorPackageImpl theEViewEditorPackage = (EViewEditorPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof EViewEditorPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new EViewEditorPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theEViewEditorPackage.createPackageContents();

		// Initialize created meta-data
		theEViewEditorPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEViewEditorPackage.freeze();

		return theEViewEditorPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEViewsEditorDocument() {
		return eViewsEditorDocumentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEViewsEditorDocument_Views() {
		return (EReference)eViewsEditorDocumentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEViewsEditorDocument_UseCount() {
		return (EAttribute)eViewsEditorDocumentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEViewsEditorDocument_Features() {
		return (EReference)eViewsEditorDocumentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEViewsEditorDocument_AllViews() {
		return (EReference)eViewsEditorDocumentEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEView() {
		return eViewEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEView_Id() {
		return (EAttribute)eViewEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEView_InclusionURI() {
		return (EAttribute)eViewEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEView_FileURI() {
		return (EAttribute)eViewEClass.getEStructuralFeatures().get(2);
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
	public EReference getEGroup_Refs() {
		return (EReference)eGroupEClass.getEStructuralFeatures().get(0);
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
	public EReference getEGroupContainer_GroupsAndViews() {
		return (EReference)eGroupContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getESettingRef() {
		return eSettingRefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESettingRef_FeatureId() {
		return (EAttribute)eSettingRefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESettingRef_SettingId() {
		return (EAttribute)eSettingRefEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getESettingRef_Target() {
		return (EReference)eSettingRefEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESettingRef_Name() {
		return (EAttribute)eSettingRefEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESettingRef_MinInclusive() {
		return (EAttribute)eSettingRefEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESettingRef_MaxInclusive() {
		return (EAttribute)eSettingRefEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESettingRef_MinExclusive() {
		return (EAttribute)eSettingRefEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESettingRef_MaxExclusive() {
		return (EAttribute)eSettingRefEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESettingRef_Length() {
		return (EAttribute)eSettingRefEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESettingRef_MaxLength() {
		return (EAttribute)eSettingRefEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESettingRef_MinLength() {
		return (EAttribute)eSettingRefEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESettingRef_Patterns() {
		return (EAttribute)eSettingRefEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getESettingRef_Options() {
		return (EReference)eSettingRefEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getESettingRef_Properties() {
		return (EReference)eSettingRefEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEFeature() {
		return eFeatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEFeature_Settings() {
		return (EReference)eFeatureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEFeature_Name() {
		return (EAttribute)eFeatureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getESettingEntry() {
		return eSettingEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESettingEntry_Key() {
		return (EAttribute)eSettingEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getESettingEntry_Value() {
		return (EReference)eSettingEntryEClass.getEStructuralFeatures().get(1);
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
	public EAttribute getEDescriptionContainer_DescriptionText() {
		return (EAttribute)eDescriptionContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEDescriptionContainer_DescriptionUri() {
		return (EAttribute)eDescriptionContainerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEDescriptionContainer_DescriptionUriTitle() {
		return (EAttribute)eDescriptionContainerEClass.getEStructuralFeatures().get(2);
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
	public EAttribute getEIconContainer_IconUri() {
		return (EAttribute)eIconContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEIconContainer_IconUriTitle() {
		return (EAttribute)eIconContainerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEResourceLocator() {
		return eResourceLocatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEResourceLocator_ResourceUri() {
		return (EAttribute)eResourceLocatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getERefTarget() {
		return eRefTargetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getERefTarget_Refs() {
		return (EReference)eRefTargetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEFeatureEntry() {
		return eFeatureEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEFeatureEntry_Key() {
		return (EAttribute)eFeatureEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEFeatureEntry_Value() {
		return (EReference)eFeatureEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getESetting() {
		return eSettingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESetting_Name() {
		return (EAttribute)eSettingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESetting_ReadOnly() {
		return (EAttribute)eSettingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getESetting_SubSettings() {
		return (EReference)eSettingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEViewEntry() {
		return eViewEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEViewEntry_Key() {
		return (EAttribute)eViewEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEViewEntry_Value() {
		return (EReference)eViewEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getERefProperty() {
		return eRefPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getERefProperty_Name() {
		return (EAttribute)eRefPropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getERefProperty_Value() {
		return (EAttribute)eRefPropertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getERefProperty_Unit() {
		return (EAttribute)eRefPropertyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getERefOption() {
		return eRefOptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getERefOption_Map() {
		return (EAttribute)eRefOptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getERefOption_Name() {
		return (EAttribute)eRefOptionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getERefOption_Relevant() {
		return (EAttribute)eRefOptionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getERefOption_Value() {
		return (EAttribute)eRefOptionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEGroupEntry() {
		return eGroupEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEGroupEntry_Name() {
		return (EAttribute)eGroupEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getEJavaURI() {
		return eJavaURIEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EViewEditorFactory getEViewEditorFactory() {
		return (EViewEditorFactory)getEFactoryInstance();
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
		eViewsEditorDocumentEClass = createEClass(EVIEWS_EDITOR_DOCUMENT);
		createEReference(eViewsEditorDocumentEClass, EVIEWS_EDITOR_DOCUMENT__VIEWS);
		createEAttribute(eViewsEditorDocumentEClass, EVIEWS_EDITOR_DOCUMENT__USE_COUNT);
		createEReference(eViewsEditorDocumentEClass, EVIEWS_EDITOR_DOCUMENT__FEATURES);
		createEReference(eViewsEditorDocumentEClass, EVIEWS_EDITOR_DOCUMENT__ALL_VIEWS);

		eViewEClass = createEClass(EVIEW);
		createEAttribute(eViewEClass, EVIEW__ID);
		createEAttribute(eViewEClass, EVIEW__INCLUSION_URI);
		createEAttribute(eViewEClass, EVIEW__FILE_URI);

		eGroupEClass = createEClass(EGROUP);
		createEReference(eGroupEClass, EGROUP__REFS);

		eGroupContainerEClass = createEClass(EGROUP_CONTAINER);
		createEReference(eGroupContainerEClass, EGROUP_CONTAINER__GROUPS_AND_VIEWS);

		eSettingRefEClass = createEClass(ESETTING_REF);
		createEAttribute(eSettingRefEClass, ESETTING_REF__FEATURE_ID);
		createEAttribute(eSettingRefEClass, ESETTING_REF__SETTING_ID);
		createEReference(eSettingRefEClass, ESETTING_REF__TARGET);
		createEAttribute(eSettingRefEClass, ESETTING_REF__NAME);
		createEAttribute(eSettingRefEClass, ESETTING_REF__MIN_INCLUSIVE);
		createEAttribute(eSettingRefEClass, ESETTING_REF__MAX_INCLUSIVE);
		createEAttribute(eSettingRefEClass, ESETTING_REF__MIN_EXCLUSIVE);
		createEAttribute(eSettingRefEClass, ESETTING_REF__MAX_EXCLUSIVE);
		createEAttribute(eSettingRefEClass, ESETTING_REF__LENGTH);
		createEAttribute(eSettingRefEClass, ESETTING_REF__MAX_LENGTH);
		createEAttribute(eSettingRefEClass, ESETTING_REF__MIN_LENGTH);
		createEAttribute(eSettingRefEClass, ESETTING_REF__PATTERNS);
		createEReference(eSettingRefEClass, ESETTING_REF__OPTIONS);
		createEReference(eSettingRefEClass, ESETTING_REF__PROPERTIES);

		eFeatureEClass = createEClass(EFEATURE);
		createEReference(eFeatureEClass, EFEATURE__SETTINGS);
		createEAttribute(eFeatureEClass, EFEATURE__NAME);

		eSettingEntryEClass = createEClass(ESETTING_ENTRY);
		createEAttribute(eSettingEntryEClass, ESETTING_ENTRY__KEY);
		createEReference(eSettingEntryEClass, ESETTING_ENTRY__VALUE);

		eDescriptionContainerEClass = createEClass(EDESCRIPTION_CONTAINER);
		createEAttribute(eDescriptionContainerEClass, EDESCRIPTION_CONTAINER__DESCRIPTION_TEXT);
		createEAttribute(eDescriptionContainerEClass, EDESCRIPTION_CONTAINER__DESCRIPTION_URI);
		createEAttribute(eDescriptionContainerEClass, EDESCRIPTION_CONTAINER__DESCRIPTION_URI_TITLE);

		eIconContainerEClass = createEClass(EICON_CONTAINER);
		createEAttribute(eIconContainerEClass, EICON_CONTAINER__ICON_URI);
		createEAttribute(eIconContainerEClass, EICON_CONTAINER__ICON_URI_TITLE);

		eResourceLocatorEClass = createEClass(ERESOURCE_LOCATOR);
		createEAttribute(eResourceLocatorEClass, ERESOURCE_LOCATOR__RESOURCE_URI);

		eRefTargetEClass = createEClass(EREF_TARGET);
		createEReference(eRefTargetEClass, EREF_TARGET__REFS);

		eFeatureEntryEClass = createEClass(EFEATURE_ENTRY);
		createEAttribute(eFeatureEntryEClass, EFEATURE_ENTRY__KEY);
		createEReference(eFeatureEntryEClass, EFEATURE_ENTRY__VALUE);

		eSettingEClass = createEClass(ESETTING);
		createEAttribute(eSettingEClass, ESETTING__NAME);
		createEAttribute(eSettingEClass, ESETTING__READ_ONLY);
		createEReference(eSettingEClass, ESETTING__SUB_SETTINGS);

		eViewEntryEClass = createEClass(EVIEW_ENTRY);
		createEAttribute(eViewEntryEClass, EVIEW_ENTRY__KEY);
		createEReference(eViewEntryEClass, EVIEW_ENTRY__VALUE);

		eRefPropertyEClass = createEClass(EREF_PROPERTY);
		createEAttribute(eRefPropertyEClass, EREF_PROPERTY__NAME);
		createEAttribute(eRefPropertyEClass, EREF_PROPERTY__VALUE);
		createEAttribute(eRefPropertyEClass, EREF_PROPERTY__UNIT);

		eRefOptionEClass = createEClass(EREF_OPTION);
		createEAttribute(eRefOptionEClass, EREF_OPTION__MAP);
		createEAttribute(eRefOptionEClass, EREF_OPTION__NAME);
		createEAttribute(eRefOptionEClass, EREF_OPTION__RELEVANT);
		createEAttribute(eRefOptionEClass, EREF_OPTION__VALUE);

		eGroupEntryEClass = createEClass(EGROUP_ENTRY);
		createEAttribute(eGroupEntryEClass, EGROUP_ENTRY__NAME);

		// Create data types
		eJavaURIEDataType = createEDataType(EJAVA_URI);
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
		eViewEClass.getESuperTypes().add(this.getEDescriptionContainer());
		eViewEClass.getESuperTypes().add(this.getEIconContainer());
		eViewEClass.getESuperTypes().add(this.getEGroupEntry());
		eGroupEClass.getESuperTypes().add(this.getEDescriptionContainer());
		eGroupEClass.getESuperTypes().add(this.getEIconContainer());
		eGroupEClass.getESuperTypes().add(this.getEGroupEntry());
		eSettingRefEClass.getESuperTypes().add(this.getEDescriptionContainer());
		eFeatureEClass.getESuperTypes().add(this.getEDescriptionContainer());
		eFeatureEClass.getESuperTypes().add(this.getEResourceLocator());
		eFeatureEClass.getESuperTypes().add(this.getERefTarget());
		eSettingEClass.getESuperTypes().add(this.getEDescriptionContainer());
		eSettingEClass.getESuperTypes().add(this.getEResourceLocator());
		eSettingEClass.getESuperTypes().add(this.getERefTarget());
		eGroupEntryEClass.getESuperTypes().add(this.getEGroupContainer());

		// Initialize classes and features; add operations and parameters
		initEClass(eViewsEditorDocumentEClass, EViewsEditorDocument.class, "EViewsEditorDocument", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEViewsEditorDocument_Views(), this.getEViewEntry(), null, "views", null, 0, -1, EViewsEditorDocument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEViewsEditorDocument_UseCount(), ecorePackage.getEInt(), "useCount", null, 1, 1, EViewsEditorDocument.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEViewsEditorDocument_Features(), this.getEFeatureEntry(), null, "features", null, 0, -1, EViewsEditorDocument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEViewsEditorDocument_AllViews(), this.getEView(), null, "allViews", null, 0, -1, EViewsEditorDocument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eViewEClass, EView.class, "EView", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEView_Id(), ecorePackage.getEString(), "id", null, 0, 1, EView.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEView_InclusionURI(), ecorePackage.getEString(), "inclusionURI", null, 0, 1, EView.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEView_FileURI(), ecorePackage.getEString(), "fileURI", null, 0, 1, EView.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eGroupEClass, EGroup.class, "EGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEGroup_Refs(), this.getESettingRef(), null, "refs", null, 0, -1, EGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eGroupContainerEClass, EGroupContainer.class, "EGroupContainer", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEGroupContainer_GroupsAndViews(), this.getEGroupEntry(), null, "groupsAndViews", null, 0, -1, EGroupContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(eGroupContainerEClass, null, "getGroups", 0, 1, IS_UNIQUE, IS_ORDERED);
		EGenericType g1 = createEGenericType(ecorePackage.getEEList());
		EGenericType g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		op = addEOperation(eGroupContainerEClass, null, "getIncludeViews", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEEList());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		initEClass(eSettingRefEClass, ESettingRef.class, "ESettingRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getESettingRef_FeatureId(), ecorePackage.getEString(), "featureId", null, 1, 1, ESettingRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getESettingRef_SettingId(), ecorePackage.getEString(), "settingId", null, 1, 1, ESettingRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getESettingRef_Target(), this.getERefTarget(), this.getERefTarget_Refs(), "target", null, 0, 1, ESettingRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getESettingRef_Name(), ecorePackage.getEString(), "name", null, 0, 1, ESettingRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getESettingRef_MinInclusive(), ecorePackage.getEString(), "minInclusive", null, 0, 1, ESettingRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getESettingRef_MaxInclusive(), ecorePackage.getEString(), "maxInclusive", null, 0, 1, ESettingRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getESettingRef_MinExclusive(), ecorePackage.getEString(), "minExclusive", null, 0, 1, ESettingRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getESettingRef_MaxExclusive(), ecorePackage.getEString(), "maxExclusive", null, 0, 1, ESettingRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getESettingRef_Length(), ecorePackage.getEString(), "length", null, 0, 1, ESettingRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getESettingRef_MaxLength(), ecorePackage.getEString(), "maxLength", null, 0, 1, ESettingRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getESettingRef_MinLength(), ecorePackage.getEString(), "minLength", null, 0, 1, ESettingRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getESettingRef_Patterns(), ecorePackage.getEString(), "patterns", null, 0, 1, ESettingRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getESettingRef_Options(), this.getERefOption(), null, "options", null, 0, -1, ESettingRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getESettingRef_Properties(), this.getERefProperty(), null, "properties", null, 0, -1, ESettingRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eFeatureEClass, EFeature.class, "EFeature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEFeature_Settings(), this.getESettingEntry(), null, "settings", null, 0, -1, EFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getEFeature_Settings().getEKeys().add(this.getESettingEntry_Key());
		initEAttribute(getEFeature_Name(), ecorePackage.getEString(), "name", null, 1, 1, EFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eSettingEntryEClass, Map.Entry.class, "ESettingEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getESettingEntry_Key(), ecorePackage.getEString(), "key", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getESettingEntry_Value(), this.getESetting(), null, "value", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eDescriptionContainerEClass, EDescriptionContainer.class, "EDescriptionContainer", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEDescriptionContainer_DescriptionText(), ecorePackage.getEString(), "descriptionText", null, 0, 1, EDescriptionContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEDescriptionContainer_DescriptionUri(), ecorePackage.getEString(), "descriptionUri", null, 0, 1, EDescriptionContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEDescriptionContainer_DescriptionUriTitle(), ecorePackage.getEString(), "descriptionUriTitle", null, 0, 1, EDescriptionContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eIconContainerEClass, EIconContainer.class, "EIconContainer", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEIconContainer_IconUri(), ecorePackage.getEString(), "iconUri", null, 0, 1, EIconContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEIconContainer_IconUriTitle(), ecorePackage.getEString(), "iconUriTitle", null, 0, 1, EIconContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eResourceLocatorEClass, EResourceLocator.class, "EResourceLocator", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEResourceLocator_ResourceUri(), ecorePackage.getEString(), "resourceUri", null, 0, 1, EResourceLocator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eRefTargetEClass, ERefTarget.class, "ERefTarget", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getERefTarget_Refs(), this.getESettingRef(), this.getESettingRef_Target(), "refs", null, 0, -1, ERefTarget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eFeatureEntryEClass, Map.Entry.class, "EFeatureEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEFeatureEntry_Key(), ecorePackage.getEString(), "key", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEFeatureEntry_Value(), this.getEFeature(), null, "value", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eSettingEClass, ESetting.class, "ESetting", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getESetting_Name(), ecorePackage.getEString(), "name", null, 1, 1, ESetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getESetting_ReadOnly(), ecorePackage.getEBoolean(), "readOnly", null, 0, 1, ESetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getESetting_SubSettings(), this.getESettingEntry(), null, "subSettings", null, 0, -1, ESetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getESetting_SubSettings().getEKeys().add(this.getESettingEntry_Key());

		initEClass(eViewEntryEClass, Map.Entry.class, "EViewEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEViewEntry_Key(), ecorePackage.getEString(), "key", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEViewEntry_Value(), this.getEView(), null, "value", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eRefPropertyEClass, ERefProperty.class, "ERefProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getERefProperty_Name(), ecorePackage.getEString(), "name", null, 1, 1, ERefProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getERefProperty_Value(), ecorePackage.getEString(), "value", null, 1, 1, ERefProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getERefProperty_Unit(), ecorePackage.getEString(), "unit", null, 1, 1, ERefProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eRefOptionEClass, ERefOption.class, "ERefOption", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getERefOption_Map(), ecorePackage.getEString(), "map", null, 1, 1, ERefOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getERefOption_Name(), ecorePackage.getEString(), "name", null, 1, 1, ERefOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getERefOption_Relevant(), ecorePackage.getEString(), "relevant", null, 1, 1, ERefOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getERefOption_Value(), ecorePackage.getEString(), "value", null, 1, 1, ERefOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eGroupEntryEClass, EGroupEntry.class, "EGroupEntry", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEGroupEntry_Name(), ecorePackage.getEString(), "name", null, 1, 1, EGroupEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize data types
		initEDataType(eJavaURIEDataType, URI.class, "EJavaURI", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //EViewEditorPackageImpl
