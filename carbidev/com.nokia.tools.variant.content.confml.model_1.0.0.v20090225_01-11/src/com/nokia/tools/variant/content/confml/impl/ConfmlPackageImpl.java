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
 * Description: This file is part of com.nokia.tools.variant.content.confml.model component.
 */

package com.nokia.tools.variant.content.confml.impl;


import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import com.nokia.tools.variant.content.confml.ConfmlFactory;
import com.nokia.tools.variant.content.confml.ConfmlPackage;
import com.nokia.tools.variant.content.confml.Feature;
import com.nokia.tools.variant.content.confml.FilePath;
import com.nokia.tools.variant.content.confml.FileSystemEntrySetting;
import com.nokia.tools.variant.content.confml.Group;
import com.nokia.tools.variant.content.confml.Icon;
import com.nokia.tools.variant.content.confml.LeafGroup;
import com.nokia.tools.variant.content.confml.MaxExclusive;
import com.nokia.tools.variant.content.confml.MaxInclusive;
import com.nokia.tools.variant.content.confml.MinExclusive;
import com.nokia.tools.variant.content.confml.MinInclusive;
import com.nokia.tools.variant.content.confml.Option;
import com.nokia.tools.variant.content.confml.OptionMapEntry;
import com.nokia.tools.variant.content.confml.ParentGroup;
import com.nokia.tools.variant.content.confml.Property;
import com.nokia.tools.variant.content.confml.SequenceItem;
import com.nokia.tools.variant.content.confml.SequenceSetting;
import com.nokia.tools.variant.content.confml.Setting;
import com.nokia.tools.variant.content.confml.SimpleSetting;
import com.nokia.tools.variant.content.confml.View;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ConfmlPackageImpl extends EPackageImpl implements ConfmlPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parentGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass leafGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simpleSettingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iconEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass viewEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sequenceSettingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass settingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sequenceItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass optionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass groupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fileSystemEntrySettingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass minInclusiveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass maxInclusiveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass maxExclusiveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass minExclusiveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass filePathEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass optionMapEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum typeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType uriEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType objectEDataType = null;

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
	 * @see com.nokia.tools.variant.content.confml.ConfmlPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ConfmlPackageImpl() {
		super(eNS_URI, ConfmlFactory.eINSTANCE);
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
	public static ConfmlPackage init() {
		if (isInited) return (ConfmlPackage)EPackage.Registry.INSTANCE.getEPackage(ConfmlPackage.eNS_URI);

		// Obtain or create and register package
		ConfmlPackageImpl theConfmlPackage = (ConfmlPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof ConfmlPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new ConfmlPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theConfmlPackage.createPackageContents();

		// Initialize created meta-data
		theConfmlPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theConfmlPackage.freeze();

		return theConfmlPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParentGroup() {
		return parentGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParentGroup_LeafGroup() {
		return (EReference)parentGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLeafGroup() {
		return leafGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSimpleSetting() {
		return simpleSettingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSimpleSetting_DefaultValue() {
		return (EAttribute)simpleSettingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSimpleSetting_Value() {
		return (EAttribute)simpleSettingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSimpleSetting_LastSavedValue() {
		return (EAttribute)simpleSettingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSimpleSetting_MinLength() {
		return (EAttribute)simpleSettingEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSimpleSetting_MaxLength() {
		return (EAttribute)simpleSettingEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSimpleSetting_Length() {
		return (EAttribute)simpleSettingEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSimpleSetting_MaxInclusive() {
		return (EReference)simpleSettingEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSimpleSetting_MaxExclusive() {
		return (EReference)simpleSettingEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSimpleSetting_MinInclusive() {
		return (EReference)simpleSettingEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSimpleSetting_ContainedInLastLayer() {
		return (EAttribute)simpleSettingEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSimpleSetting_LastSavedInLastLayer() {
		return (EAttribute)simpleSettingEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSimpleSetting_ChoosenOption() {
		return (EAttribute)simpleSettingEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSimpleSetting_MinExclusive() {
		return (EReference)simpleSettingEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSimpleSetting_Pattern() {
		return (EAttribute)simpleSettingEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSimpleSetting_TotalDigits() {
		return (EAttribute)simpleSettingEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIcon() {
		return iconEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIcon_Title() {
		return (EAttribute)iconEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIcon_Href() {
		return (EAttribute)iconEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIcon_FilePath() {
		return (EAttribute)iconEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getView() {
		return viewEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getView_ParentGroup() {
		return (EReference)viewEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getView_Name() {
		return (EAttribute)viewEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getView_Icon() {
		return (EReference)viewEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getView_SharedSettingInstances() {
		return (EReference)viewEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getView_SharedFeatures() {
		return (EReference)viewEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSequenceSetting() {
		return sequenceSettingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSequenceSetting_DefaultStructure() {
		return (EReference)sequenceSettingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSequenceSetting_Template() {
		return (EReference)sequenceSettingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSequenceSetting_SequenceItem() {
		return (EReference)sequenceSettingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSequenceSetting_MinOccurs() {
		return (EAttribute)sequenceSettingEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSequenceSetting_MaxOccurs() {
		return (EAttribute)sequenceSettingEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSequenceSetting_LastSavedStructure() {
		return (EReference)sequenceSettingEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSequenceSetting_MapKey() {
		return (EAttribute)sequenceSettingEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSequenceSetting_MapValue() {
		return (EAttribute)sequenceSettingEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSetting() {
		return settingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetting_AbsRef() {
		return (EAttribute)settingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetting_Name() {
		return (EAttribute)settingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSetting_Property() {
		return (EReference)settingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetting_Description() {
		return (EAttribute)settingEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSetting_LeafGroup() {
		return (EReference)settingEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetting_Type() {
		return (EAttribute)settingEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetting_RfsValue() {
		return (EAttribute)settingEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetting_FeatureName() {
		return (EAttribute)settingEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetting_Note() {
		return (EAttribute)settingEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetting_Relevant() {
		return (EAttribute)settingEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetting_Required() {
		return (EAttribute)settingEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetting_Constraint() {
		return (EAttribute)settingEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetting_ComputedRelevant() {
		return (EAttribute)settingEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetting_ComputedConstraint() {
		return (EAttribute)settingEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetting_ReadOnly() {
		return (EAttribute)settingEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetting_ValueNull() {
		return (EAttribute)settingEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetting_NameOverride() {
		return (EAttribute)settingEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetting_DescriptionOverride() {
		return (EAttribute)settingEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetting_Dependencies() {
		return (EAttribute)settingEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSetting_Option() {
		return (EReference)settingEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSetting_ParentGroup() {
		return (EReference)settingEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetting_OptionDependencies() {
		return (EAttribute)settingEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSequenceItem() {
		return sequenceItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSequenceItem_Setting() {
		return (EReference)sequenceItemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOption() {
		return optionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOption_Name() {
		return (EAttribute)optionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOption_Value() {
		return (EAttribute)optionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOption_Relevant() {
		return (EAttribute)optionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOption_Map() {
		return (EAttribute)optionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOption_MapSourceSetting() {
		return (EReference)optionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOption_OptionValues() {
		return (EAttribute)optionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGroup() {
		return groupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGroup_Desc() {
		return (EAttribute)groupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGroup_Icon() {
		return (EReference)groupEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGroup_Name() {
		return (EAttribute)groupEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGroup_Id() {
		return (EAttribute)groupEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGroup_Settings() {
		return (EReference)groupEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProperty() {
		return propertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProperty_Name() {
		return (EAttribute)propertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProperty_Unit() {
		return (EAttribute)propertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProperty_Value() {
		return (EAttribute)propertyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFileSystemEntrySetting() {
		return fileSystemEntrySettingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFileSystemEntrySetting_File() {
		return (EAttribute)fileSystemEntrySettingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFileSystemEntrySetting_SourceFilePath() {
		return (EReference)fileSystemEntrySettingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFileSystemEntrySetting_TargetFilePath() {
		return (EReference)fileSystemEntrySettingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFileSystemEntrySetting_ChoosenOption() {
		return (EAttribute)fileSystemEntrySettingEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFileSystemEntrySetting_Pattern() {
		return (EAttribute)fileSystemEntrySettingEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeature() {
		return featureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeature_Name() {
		return (EAttribute)featureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeature_Ref() {
		return (EAttribute)featureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeature_Relevant() {
		return (EAttribute)featureEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeature_Description() {
		return (EAttribute)featureEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeature_IconTitle() {
		return (EAttribute)featureEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeature_IconDescriptor() {
		return (EAttribute)featureEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeature_IconURI() {
		return (EAttribute)featureEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeature_ComputedRelevant() {
		return (EAttribute)featureEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMinInclusive() {
		return minInclusiveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMinInclusive_Value() {
		return (EAttribute)minInclusiveEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMaxInclusive() {
		return maxInclusiveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMaxInclusive_Value() {
		return (EAttribute)maxInclusiveEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMaxExclusive() {
		return maxExclusiveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMaxExclusive_Value() {
		return (EAttribute)maxExclusiveEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMinExclusive() {
		return minExclusiveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMinExclusive_Value() {
		return (EAttribute)minExclusiveEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFilePath() {
		return filePathEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFilePath_Path() {
		return (EAttribute)filePathEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFilePath_LastSavedPath() {
		return (EAttribute)filePathEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFilePath_DefaultPath() {
		return (EAttribute)filePathEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFilePath_PathReadOnly() {
		return (EAttribute)filePathEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFilePath_PathNameOverride() {
		return (EAttribute)filePathEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFilePath_PathDescriptionOverride() {
		return (EAttribute)filePathEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFilePath_Parent() {
		return (EReference)filePathEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFilePath_ContainedInLastLayer() {
		return (EAttribute)filePathEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFilePath_LastSavedInLastLayer() {
		return (EAttribute)filePathEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOptionMapEntry() {
		return optionMapEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOptionMapEntry_Value2Save() {
		return (EAttribute)optionMapEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOptionMapEntry_MapValue() {
		return (EAttribute)optionMapEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTYPE() {
		return typeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getURI() {
		return uriEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getObject() {
		return objectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfmlFactory getConfmlFactory() {
		return (ConfmlFactory)getEFactoryInstance();
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
		parentGroupEClass = createEClass(PARENT_GROUP);
		createEReference(parentGroupEClass, PARENT_GROUP__LEAF_GROUP);

		leafGroupEClass = createEClass(LEAF_GROUP);

		simpleSettingEClass = createEClass(SIMPLE_SETTING);
		createEAttribute(simpleSettingEClass, SIMPLE_SETTING__DEFAULT_VALUE);
		createEAttribute(simpleSettingEClass, SIMPLE_SETTING__VALUE);
		createEAttribute(simpleSettingEClass, SIMPLE_SETTING__LAST_SAVED_VALUE);
		createEAttribute(simpleSettingEClass, SIMPLE_SETTING__MIN_LENGTH);
		createEAttribute(simpleSettingEClass, SIMPLE_SETTING__MAX_LENGTH);
		createEAttribute(simpleSettingEClass, SIMPLE_SETTING__LENGTH);
		createEAttribute(simpleSettingEClass, SIMPLE_SETTING__PATTERN);
		createEAttribute(simpleSettingEClass, SIMPLE_SETTING__TOTAL_DIGITS);
		createEReference(simpleSettingEClass, SIMPLE_SETTING__MAX_EXCLUSIVE);
		createEReference(simpleSettingEClass, SIMPLE_SETTING__MIN_EXCLUSIVE);
		createEReference(simpleSettingEClass, SIMPLE_SETTING__MAX_INCLUSIVE);
		createEReference(simpleSettingEClass, SIMPLE_SETTING__MIN_INCLUSIVE);
		createEAttribute(simpleSettingEClass, SIMPLE_SETTING__CONTAINED_IN_LAST_LAYER);
		createEAttribute(simpleSettingEClass, SIMPLE_SETTING__LAST_SAVED_IN_LAST_LAYER);
		createEAttribute(simpleSettingEClass, SIMPLE_SETTING__CHOOSEN_OPTION);

		iconEClass = createEClass(ICON);
		createEAttribute(iconEClass, ICON__TITLE);
		createEAttribute(iconEClass, ICON__HREF);
		createEAttribute(iconEClass, ICON__FILE_PATH);

		viewEClass = createEClass(VIEW);
		createEReference(viewEClass, VIEW__PARENT_GROUP);
		createEAttribute(viewEClass, VIEW__NAME);
		createEReference(viewEClass, VIEW__ICON);
		createEReference(viewEClass, VIEW__SHARED_SETTING_INSTANCES);
		createEReference(viewEClass, VIEW__SHARED_FEATURES);

		sequenceSettingEClass = createEClass(SEQUENCE_SETTING);
		createEReference(sequenceSettingEClass, SEQUENCE_SETTING__DEFAULT_STRUCTURE);
		createEReference(sequenceSettingEClass, SEQUENCE_SETTING__TEMPLATE);
		createEReference(sequenceSettingEClass, SEQUENCE_SETTING__SEQUENCE_ITEM);
		createEAttribute(sequenceSettingEClass, SEQUENCE_SETTING__MIN_OCCURS);
		createEAttribute(sequenceSettingEClass, SEQUENCE_SETTING__MAX_OCCURS);
		createEReference(sequenceSettingEClass, SEQUENCE_SETTING__LAST_SAVED_STRUCTURE);
		createEAttribute(sequenceSettingEClass, SEQUENCE_SETTING__MAP_KEY);
		createEAttribute(sequenceSettingEClass, SEQUENCE_SETTING__MAP_VALUE);

		settingEClass = createEClass(SETTING);
		createEAttribute(settingEClass, SETTING__ABS_REF);
		createEAttribute(settingEClass, SETTING__NAME);
		createEReference(settingEClass, SETTING__PROPERTY);
		createEAttribute(settingEClass, SETTING__DESCRIPTION);
		createEReference(settingEClass, SETTING__LEAF_GROUP);
		createEAttribute(settingEClass, SETTING__TYPE);
		createEAttribute(settingEClass, SETTING__RFS_VALUE);
		createEAttribute(settingEClass, SETTING__FEATURE_NAME);
		createEAttribute(settingEClass, SETTING__NOTE);
		createEAttribute(settingEClass, SETTING__RELEVANT);
		createEAttribute(settingEClass, SETTING__REQUIRED);
		createEAttribute(settingEClass, SETTING__CONSTRAINT);
		createEAttribute(settingEClass, SETTING__COMPUTED_RELEVANT);
		createEAttribute(settingEClass, SETTING__COMPUTED_CONSTRAINT);
		createEAttribute(settingEClass, SETTING__READ_ONLY);
		createEAttribute(settingEClass, SETTING__VALUE_NULL);
		createEAttribute(settingEClass, SETTING__NAME_OVERRIDE);
		createEAttribute(settingEClass, SETTING__DESCRIPTION_OVERRIDE);
		createEAttribute(settingEClass, SETTING__DEPENDENCIES);
		createEReference(settingEClass, SETTING__OPTION);
		createEReference(settingEClass, SETTING__PARENT_GROUP);
		createEAttribute(settingEClass, SETTING__OPTION_DEPENDENCIES);

		sequenceItemEClass = createEClass(SEQUENCE_ITEM);
		createEReference(sequenceItemEClass, SEQUENCE_ITEM__SETTING);

		optionEClass = createEClass(OPTION);
		createEAttribute(optionEClass, OPTION__NAME);
		createEAttribute(optionEClass, OPTION__VALUE);
		createEAttribute(optionEClass, OPTION__RELEVANT);
		createEAttribute(optionEClass, OPTION__MAP);
		createEReference(optionEClass, OPTION__MAP_SOURCE_SETTING);
		createEAttribute(optionEClass, OPTION__OPTION_VALUES);

		groupEClass = createEClass(GROUP);
		createEAttribute(groupEClass, GROUP__DESC);
		createEReference(groupEClass, GROUP__ICON);
		createEAttribute(groupEClass, GROUP__NAME);
		createEAttribute(groupEClass, GROUP__ID);
		createEReference(groupEClass, GROUP__SETTINGS);

		propertyEClass = createEClass(PROPERTY);
		createEAttribute(propertyEClass, PROPERTY__NAME);
		createEAttribute(propertyEClass, PROPERTY__UNIT);
		createEAttribute(propertyEClass, PROPERTY__VALUE);

		fileSystemEntrySettingEClass = createEClass(FILE_SYSTEM_ENTRY_SETTING);
		createEAttribute(fileSystemEntrySettingEClass, FILE_SYSTEM_ENTRY_SETTING__FILE);
		createEReference(fileSystemEntrySettingEClass, FILE_SYSTEM_ENTRY_SETTING__SOURCE_FILE_PATH);
		createEReference(fileSystemEntrySettingEClass, FILE_SYSTEM_ENTRY_SETTING__TARGET_FILE_PATH);
		createEAttribute(fileSystemEntrySettingEClass, FILE_SYSTEM_ENTRY_SETTING__CHOOSEN_OPTION);
		createEAttribute(fileSystemEntrySettingEClass, FILE_SYSTEM_ENTRY_SETTING__PATTERN);

		featureEClass = createEClass(FEATURE);
		createEAttribute(featureEClass, FEATURE__NAME);
		createEAttribute(featureEClass, FEATURE__REF);
		createEAttribute(featureEClass, FEATURE__RELEVANT);
		createEAttribute(featureEClass, FEATURE__DESCRIPTION);
		createEAttribute(featureEClass, FEATURE__ICON_TITLE);
		createEAttribute(featureEClass, FEATURE__ICON_DESCRIPTOR);
		createEAttribute(featureEClass, FEATURE__ICON_URI);
		createEAttribute(featureEClass, FEATURE__COMPUTED_RELEVANT);

		minInclusiveEClass = createEClass(MIN_INCLUSIVE);
		createEAttribute(minInclusiveEClass, MIN_INCLUSIVE__VALUE);

		maxInclusiveEClass = createEClass(MAX_INCLUSIVE);
		createEAttribute(maxInclusiveEClass, MAX_INCLUSIVE__VALUE);

		maxExclusiveEClass = createEClass(MAX_EXCLUSIVE);
		createEAttribute(maxExclusiveEClass, MAX_EXCLUSIVE__VALUE);

		minExclusiveEClass = createEClass(MIN_EXCLUSIVE);
		createEAttribute(minExclusiveEClass, MIN_EXCLUSIVE__VALUE);

		filePathEClass = createEClass(FILE_PATH);
		createEAttribute(filePathEClass, FILE_PATH__PATH);
		createEAttribute(filePathEClass, FILE_PATH__LAST_SAVED_PATH);
		createEAttribute(filePathEClass, FILE_PATH__DEFAULT_PATH);
		createEAttribute(filePathEClass, FILE_PATH__PATH_READ_ONLY);
		createEAttribute(filePathEClass, FILE_PATH__PATH_NAME_OVERRIDE);
		createEAttribute(filePathEClass, FILE_PATH__PATH_DESCRIPTION_OVERRIDE);
		createEReference(filePathEClass, FILE_PATH__PARENT);
		createEAttribute(filePathEClass, FILE_PATH__CONTAINED_IN_LAST_LAYER);
		createEAttribute(filePathEClass, FILE_PATH__LAST_SAVED_IN_LAST_LAYER);

		optionMapEntryEClass = createEClass(OPTION_MAP_ENTRY);
		createEAttribute(optionMapEntryEClass, OPTION_MAP_ENTRY__VALUE2_SAVE);
		createEAttribute(optionMapEntryEClass, OPTION_MAP_ENTRY__MAP_VALUE);

		// Create enums
		typeEEnum = createEEnum(TYPE);

		// Create data types
		uriEDataType = createEDataType(URI);
		objectEDataType = createEDataType(OBJECT);
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
		parentGroupEClass.getESuperTypes().add(this.getGroup());
		leafGroupEClass.getESuperTypes().add(this.getGroup());
		simpleSettingEClass.getESuperTypes().add(this.getSetting());
		sequenceSettingEClass.getESuperTypes().add(this.getSetting());
		fileSystemEntrySettingEClass.getESuperTypes().add(this.getSetting());
		minInclusiveEClass.getESuperTypes().add(ecorePackage.getEObject());
		maxInclusiveEClass.getESuperTypes().add(ecorePackage.getEObject());
		maxExclusiveEClass.getESuperTypes().add(ecorePackage.getEObject());
		minExclusiveEClass.getESuperTypes().add(ecorePackage.getEObject());
		filePathEClass.getESuperTypes().add(this.getFileSystemEntrySetting());

		// Initialize classes and features; add operations and parameters
		initEClass(parentGroupEClass, ParentGroup.class, "ParentGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParentGroup_LeafGroup(), this.getLeafGroup(), null, "leafGroup", null, 0, -1, ParentGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(leafGroupEClass, LeafGroup.class, "LeafGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(simpleSettingEClass, SimpleSetting.class, "SimpleSetting", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSimpleSetting_DefaultValue(), ecorePackage.getEString(), "defaultValue", null, 0, 1, SimpleSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimpleSetting_Value(), ecorePackage.getEString(), "value", "", 0, 1, SimpleSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimpleSetting_LastSavedValue(), ecorePackage.getEString(), "lastSavedValue", null, 0, 1, SimpleSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimpleSetting_MinLength(), ecorePackage.getEBigInteger(), "minLength", "-1", 0, 1, SimpleSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimpleSetting_MaxLength(), ecorePackage.getEBigInteger(), "maxLength", "-1", 0, 1, SimpleSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimpleSetting_Length(), ecorePackage.getEBigInteger(), "length", "-1", 0, 1, SimpleSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimpleSetting_Pattern(), ecorePackage.getEString(), "pattern", "", 0, 1, SimpleSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimpleSetting_TotalDigits(), ecorePackage.getEBigInteger(), "totalDigits", "-1", 0, 1, SimpleSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSimpleSetting_MaxExclusive(), this.getMaxExclusive(), null, "maxExclusive", null, 0, 1, SimpleSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSimpleSetting_MinExclusive(), this.getMinExclusive(), null, "minExclusive", null, 0, 1, SimpleSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSimpleSetting_MaxInclusive(), this.getMaxInclusive(), null, "maxInclusive", null, 0, 1, SimpleSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSimpleSetting_MinInclusive(), this.getMinInclusive(), null, "minInclusive", null, 0, 1, SimpleSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimpleSetting_ContainedInLastLayer(), ecorePackage.getEBoolean(), "containedInLastLayer", null, 0, 1, SimpleSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimpleSetting_LastSavedInLastLayer(), ecorePackage.getEBoolean(), "lastSavedInLastLayer", null, 0, 1, SimpleSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimpleSetting_ChoosenOption(), ecorePackage.getEString(), "choosenOption", null, 0, 1, SimpleSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iconEClass, Icon.class, "Icon", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIcon_Title(), ecorePackage.getEString(), "title", null, 0, 1, Icon.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIcon_Href(), ecorePackage.getEString(), "href", "", 0, 1, Icon.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIcon_FilePath(), ecorePackage.getEString(), "filePath", null, 0, 1, Icon.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(viewEClass, View.class, "View", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getView_ParentGroup(), this.getParentGroup(), null, "parentGroup", null, 0, -1, View.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getView_Name(), ecorePackage.getEString(), "name", null, 0, 1, View.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getView_Icon(), this.getIcon(), null, "icon", null, 0, -1, View.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getView_SharedSettingInstances(), this.getSetting(), null, "sharedSettingInstances", null, 0, -1, View.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getView_SharedFeatures(), this.getFeature(), null, "sharedFeatures", null, 0, -1, View.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sequenceSettingEClass, SequenceSetting.class, "SequenceSetting", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSequenceSetting_DefaultStructure(), this.getSequenceItem(), null, "defaultStructure", null, 0, -1, SequenceSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSequenceSetting_Template(), this.getSequenceItem(), null, "template", null, 0, 1, SequenceSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSequenceSetting_SequenceItem(), this.getSequenceItem(), null, "sequenceItem", null, 0, -1, SequenceSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSequenceSetting_MinOccurs(), ecorePackage.getEInt(), "minOccurs", null, 0, 1, SequenceSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSequenceSetting_MaxOccurs(), ecorePackage.getEInt(), "maxOccurs", null, 0, 1, SequenceSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSequenceSetting_LastSavedStructure(), this.getSequenceItem(), null, "lastSavedStructure", null, 0, -1, SequenceSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSequenceSetting_MapKey(), ecorePackage.getEString(), "mapKey", null, 0, 1, SequenceSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSequenceSetting_MapValue(), ecorePackage.getEString(), "mapValue", null, 0, 1, SequenceSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(sequenceSettingEClass, ecorePackage.getEBoolean(), "computeDefault", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(settingEClass, Setting.class, "Setting", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSetting_AbsRef(), ecorePackage.getEString(), "absRef", null, 0, 1, Setting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSetting_Name(), ecorePackage.getEString(), "name", null, 0, 1, Setting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSetting_Property(), this.getProperty(), null, "property", null, 0, -1, Setting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSetting_Description(), ecorePackage.getEString(), "description", null, 0, 1, Setting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSetting_LeafGroup(), this.getLeafGroup(), null, "leafGroup", null, 0, -1, Setting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSetting_Type(), this.getTYPE(), "type", null, 0, 1, Setting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSetting_RfsValue(), ecorePackage.getEBoolean(), "rfsValue", null, 0, 1, Setting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSetting_FeatureName(), ecorePackage.getEString(), "featureName", null, 0, 1, Setting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSetting_Note(), ecorePackage.getEString(), "note", null, 0, 1, Setting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSetting_Relevant(), ecorePackage.getEString(), "relevant", null, 0, 1, Setting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSetting_Required(), ecorePackage.getEBoolean(), "required", null, 0, 1, Setting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSetting_Constraint(), ecorePackage.getEString(), "constraint", null, 0, 1, Setting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSetting_ComputedRelevant(), ecorePackage.getEBoolean(), "computedRelevant", "true", 0, 1, Setting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSetting_ComputedConstraint(), ecorePackage.getEBoolean(), "computedConstraint", "true", 0, 1, Setting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSetting_ReadOnly(), ecorePackage.getEBoolean(), "readOnly", null, 0, 1, Setting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSetting_ValueNull(), ecorePackage.getEBoolean(), "valueNull", null, 0, 1, Setting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSetting_NameOverride(), ecorePackage.getEString(), "nameOverride", null, 0, 1, Setting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSetting_DescriptionOverride(), ecorePackage.getEString(), "descriptionOverride", null, 0, 1, Setting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		EGenericType g1 = createEGenericType(ecorePackage.getEEList());
		EGenericType g2 = createEGenericType(this.getObject());
		g1.getETypeArguments().add(g2);
		initEAttribute(getSetting_Dependencies(), g1, "dependencies", null, 0, 1, Setting.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSetting_Option(), this.getOption(), null, "option", null, 0, -1, Setting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSetting_ParentGroup(), this.getParentGroup(), null, "parentGroup", null, 0, -1, Setting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEEList());
		g2 = createEGenericType(this.getSetting());
		g1.getETypeArguments().add(g2);
		initEAttribute(getSetting_OptionDependencies(), g1, "optionDependencies", null, 0, 1, Setting.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(settingEClass, ecorePackage.getEBoolean(), "isDefault", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(settingEClass, ecorePackage.getEBoolean(), "isDirty", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(settingEClass, ecorePackage.getEString(), "getFeatureRef", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(settingEClass, ecorePackage.getEString(), "getSettingRef", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(settingEClass, ecorePackage.getEBoolean(), "isVisible", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(sequenceItemEClass, SequenceItem.class, "SequenceItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSequenceItem_Setting(), this.getSetting(), null, "setting", null, 0, -1, SequenceItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(optionEClass, Option.class, "Option", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOption_Name(), ecorePackage.getEString(), "name", "", 0, 1, Option.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOption_Value(), ecorePackage.getEString(), "value", null, 0, 1, Option.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOption_Relevant(), ecorePackage.getEString(), "relevant", null, 0, 1, Option.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOption_Map(), ecorePackage.getEString(), "map", "", 0, 1, Option.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOption_MapSourceSetting(), this.getSequenceSetting(), null, "mapSourceSetting", null, 0, 1, Option.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEString());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getOptionMapEntry());
		g1.getETypeArguments().add(g2);
		initEAttribute(getOption_OptionValues(), g1, "optionValues", null, 0, 1, Option.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(groupEClass, Group.class, "Group", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGroup_Desc(), ecorePackage.getEString(), "desc", "", 0, 1, Group.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGroup_Icon(), this.getIcon(), null, "icon", null, 0, -1, Group.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGroup_Name(), ecorePackage.getEString(), "name", null, 0, 1, Group.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGroup_Id(), ecorePackage.getEString(), "id", null, 0, 1, Group.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGroup_Settings(), this.getSetting(), null, "settings", null, 0, -1, Group.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propertyEClass, Property.class, "Property", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProperty_Name(), ecorePackage.getEString(), "name", null, 0, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProperty_Unit(), ecorePackage.getEString(), "unit", null, 0, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProperty_Value(), ecorePackage.getEString(), "value", null, 0, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fileSystemEntrySettingEClass, FileSystemEntrySetting.class, "FileSystemEntrySetting", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFileSystemEntrySetting_File(), ecorePackage.getEBoolean(), "file", null, 0, 1, FileSystemEntrySetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFileSystemEntrySetting_SourceFilePath(), this.getFilePath(), null, "sourceFilePath", null, 0, 1, FileSystemEntrySetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFileSystemEntrySetting_TargetFilePath(), this.getFilePath(), null, "targetFilePath", null, 0, 1, FileSystemEntrySetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFileSystemEntrySetting_ChoosenOption(), ecorePackage.getEString(), "choosenOption", null, 0, 1, FileSystemEntrySetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFileSystemEntrySetting_Pattern(), ecorePackage.getEString(), "pattern", "", 0, 1, FileSystemEntrySetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(featureEClass, Feature.class, "Feature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFeature_Name(), ecorePackage.getEString(), "name", null, 0, 1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeature_Ref(), ecorePackage.getEString(), "ref", null, 0, 1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeature_Relevant(), ecorePackage.getEString(), "relevant", null, 0, 1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeature_Description(), ecorePackage.getEString(), "description", null, 0, 1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeature_IconTitle(), ecorePackage.getEString(), "iconTitle", null, 0, 1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeature_IconDescriptor(), this.getObject(), "iconDescriptor", null, 0, 1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeature_IconURI(), this.getURI(), "iconURI", null, 0, 1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeature_ComputedRelevant(), ecorePackage.getEBoolean(), "computedRelevant", null, 0, 1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(minInclusiveEClass, MinInclusive.class, "MinInclusive", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMinInclusive_Value(), this.getObject(), "value", null, 0, 1, MinInclusive.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(maxInclusiveEClass, MaxInclusive.class, "MaxInclusive", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMaxInclusive_Value(), this.getObject(), "value", null, 0, 1, MaxInclusive.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(maxExclusiveEClass, MaxExclusive.class, "MaxExclusive", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMaxExclusive_Value(), this.getObject(), "value", null, 0, 1, MaxExclusive.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(minExclusiveEClass, MinExclusive.class, "MinExclusive", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMinExclusive_Value(), this.getObject(), "value", null, 0, 1, MinExclusive.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(filePathEClass, FilePath.class, "FilePath", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFilePath_Path(), ecorePackage.getEString(), "path", null, 0, 1, FilePath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFilePath_LastSavedPath(), ecorePackage.getEString(), "lastSavedPath", null, 0, 1, FilePath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFilePath_DefaultPath(), ecorePackage.getEString(), "defaultPath", null, 0, 1, FilePath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFilePath_PathReadOnly(), ecorePackage.getEBoolean(), "pathReadOnly", "false", 0, 1, FilePath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFilePath_PathNameOverride(), ecorePackage.getEString(), "pathNameOverride", null, 0, 1, FilePath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFilePath_PathDescriptionOverride(), ecorePackage.getEString(), "pathDescriptionOverride", null, 0, 1, FilePath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFilePath_Parent(), this.getFileSystemEntrySetting(), null, "parent", null, 0, 1, FilePath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFilePath_ContainedInLastLayer(), ecorePackage.getEBoolean(), "containedInLastLayer", null, 0, 1, FilePath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFilePath_LastSavedInLastLayer(), ecorePackage.getEBoolean(), "lastSavedInLastLayer", null, 0, 1, FilePath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(optionMapEntryEClass, OptionMapEntry.class, "OptionMapEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOptionMapEntry_Value2Save(), ecorePackage.getEString(), "value2Save", null, 0, 1, OptionMapEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOptionMapEntry_MapValue(), ecorePackage.getEString(), "mapValue", null, 0, 1, OptionMapEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(typeEEnum, com.nokia.tools.variant.content.confml.TYPE.class, "TYPE");
		addEEnumLiteral(typeEEnum, com.nokia.tools.variant.content.confml.TYPE.INT);
		addEEnumLiteral(typeEEnum, com.nokia.tools.variant.content.confml.TYPE.STRING);
		addEEnumLiteral(typeEEnum, com.nokia.tools.variant.content.confml.TYPE.REAL);
		addEEnumLiteral(typeEEnum, com.nokia.tools.variant.content.confml.TYPE.SELECTION);
		addEEnumLiteral(typeEEnum, com.nokia.tools.variant.content.confml.TYPE.BOOLEAN);
		addEEnumLiteral(typeEEnum, com.nokia.tools.variant.content.confml.TYPE.FILE);
		addEEnumLiteral(typeEEnum, com.nokia.tools.variant.content.confml.TYPE.FOLDER);
		addEEnumLiteral(typeEEnum, com.nokia.tools.variant.content.confml.TYPE.SEQUENCE);
		addEEnumLiteral(typeEEnum, com.nokia.tools.variant.content.confml.TYPE.DATE_TIME);
		addEEnumLiteral(typeEEnum, com.nokia.tools.variant.content.confml.TYPE.DATE);
		addEEnumLiteral(typeEEnum, com.nokia.tools.variant.content.confml.TYPE.TIME);
		addEEnumLiteral(typeEEnum, com.nokia.tools.variant.content.confml.TYPE.DURATION);
		addEEnumLiteral(typeEEnum, com.nokia.tools.variant.content.confml.TYPE.MULTISELECTION);
		addEEnumLiteral(typeEEnum, com.nokia.tools.variant.content.confml.TYPE.SIMPLE_FILE);
		addEEnumLiteral(typeEEnum, com.nokia.tools.variant.content.confml.TYPE.SIMPLE_FOLDER);
		addEEnumLiteral(typeEEnum, com.nokia.tools.variant.content.confml.TYPE.FILESOURCE);
		addEEnumLiteral(typeEEnum, com.nokia.tools.variant.content.confml.TYPE.FILETARGET);

		// Initialize data types
		initEDataType(uriEDataType, org.eclipse.emf.common.util.URI.class, "URI", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(objectEDataType, Object.class, "Object", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //ConfmlPackageImpl
