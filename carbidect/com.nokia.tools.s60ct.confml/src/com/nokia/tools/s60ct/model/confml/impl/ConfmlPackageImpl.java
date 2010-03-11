/*
* Copyright (c) 2007 Nokia Corporation and/or its subsidiary(-ies). 
* All rights reserved.
* This component and the accompanying materials are made available
* under the terms of "Eclipse Public License v1.0"
* which accompanies this distribution, and is available
* at the URL "http://www.eclipse.org/legal/epl-v10.html".
*
* Initial Contributors:
* Nokia Corporation - initial contribution.
*
* Contributors:
*
* Description: 
*
*/
package com.nokia.tools.s60ct.model.confml.impl;

import java.net.URI;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import com.nokia.tools.s60ct.model.confml.ConfmlFactory;
import com.nokia.tools.s60ct.model.confml.ConfmlPackage;
import com.nokia.tools.s60ct.model.confml.ECompositeSetting;
import com.nokia.tools.s60ct.model.confml.ECompositeValue;
import com.nokia.tools.s60ct.model.confml.EDescriptionContainer;
import com.nokia.tools.s60ct.model.confml.EExtensionPolicy;
import com.nokia.tools.s60ct.model.confml.EFeature;
import com.nokia.tools.s60ct.model.confml.EGroup;
import com.nokia.tools.s60ct.model.confml.EIconContainer;
import com.nokia.tools.s60ct.model.confml.EItemSetting;
import com.nokia.tools.s60ct.model.confml.ELinkContainer;
import com.nokia.tools.s60ct.model.confml.EOption;
import com.nokia.tools.s60ct.model.confml.EOptionMap;
import com.nokia.tools.s60ct.model.confml.EProperty;
import com.nokia.tools.s60ct.model.confml.EResourceKind;
import com.nokia.tools.s60ct.model.confml.EResourceLocator;
import com.nokia.tools.s60ct.model.confml.EResourceSetting;
import com.nokia.tools.s60ct.model.confml.EResourceValue;
import com.nokia.tools.s60ct.model.confml.ESequenceSetting;
import com.nokia.tools.s60ct.model.confml.ESequenceValue;
import com.nokia.tools.s60ct.model.confml.ESequenceValueItem;
import com.nokia.tools.s60ct.model.confml.ESetting;
import com.nokia.tools.s60ct.model.confml.ESettingContainer;
import com.nokia.tools.s60ct.model.confml.ESettingOption;
import com.nokia.tools.s60ct.model.confml.ESettingValue;
import com.nokia.tools.s60ct.model.confml.ESettingValueContainer;
import com.nokia.tools.s60ct.model.confml.ESettingValueType;
import com.nokia.tools.s60ct.model.confml.ESimpleSetting;
import com.nokia.tools.s60ct.model.confml.ESimpleValue;
import com.nokia.tools.s60ct.model.confml.ESubSettingValue;
import com.nokia.tools.s60ct.model.confml.EValueEditorDocument;
import com.nokia.tools.s60ct.model.confml.Pattern;
import com.nokia.tools.s60ct.model.confml.View;

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
	private EClass eFeatureEClass = null;

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
	private EClass eSettingOptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eSimpleSettingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eSequenceSettingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eItemSettingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eSubSettingValueEClass = null;

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
	private EClass eSettingValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eCompositeSettingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eResourceSettingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eSettingContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eSimpleValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eSequenceValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eSequenceValueItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eCompositeValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eSettingValueContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eResourceValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ePropertyEClass = null;

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
	private EClass eOptionMapEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eOptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eValueEditorDocumentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass patternEClass = null;

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
	private EClass eGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eSettingValueTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eExtensionPolicyEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eResourceKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType eJavaURIEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType ecore_URIEDataType = null;

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
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#eNS_URI
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
	public EAttribute getEFeature_Ref() {
		return (EAttribute)eFeatureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEFeature_Name() {
		return (EAttribute)eFeatureEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEFeature_Relevant() {
		return (EAttribute)eFeatureEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEFeature_RelevantAST() {
		return (EAttribute)eFeatureEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEFeature_ComputedRelevant() {
		return (EAttribute)eFeatureEClass.getEStructuralFeatures().get(5);
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
	public EAttribute getESetting_Ref() {
		return (EAttribute)eSettingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESetting_Rfs() {
		return (EAttribute)eSettingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getESetting_Value() {
		return (EReference)eSettingEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getESetting_DefaultValue() {
		return (EReference)eSettingEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESetting_DefaultRfs() {
		return (EAttribute)eSettingEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESetting_ReadOnly() {
		return (EAttribute)eSettingEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESetting_Constraint() {
		return (EAttribute)eSettingEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESetting_Relevant() {
		return (EAttribute)eSettingEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESetting_Required() {
		return (EAttribute)eSettingEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getESetting_Properties() {
		return (EReference)eSettingEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESetting_Deprecated() {
		return (EAttribute)eSettingEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESetting_Modified() {
		return (EAttribute)eSettingEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESetting_Setdefault() {
		return (EAttribute)eSettingEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESetting_ComputedRelevant() {
		return (EAttribute)eSettingEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESetting_ComputedConstraint() {
		return (EAttribute)eSettingEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESetting_RelevantAST() {
		return (EAttribute)eSettingEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESetting_ConstraintAST() {
		return (EAttribute)eSettingEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESetting_Dependencies() {
		return (EAttribute)eSettingEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESetting_OptionDependencies() {
		return (EAttribute)eSettingEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESetting_ValueNull() {
		return (EAttribute)eSettingEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESetting_Notes() {
		return (EAttribute)eSettingEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getESettingOption() {
		return eSettingOptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESettingOption_Relevant() {
		return (EAttribute)eSettingOptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESettingOption_RelevantAST() {
		return (EAttribute)eSettingOptionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESettingOption_ComputedRelevant() {
		return (EAttribute)eSettingOptionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getESimpleSetting() {
		return eSimpleSettingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESimpleSetting_Type() {
		return (EAttribute)eSimpleSettingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESimpleSetting_MinInclusive() {
		return (EAttribute)eSimpleSettingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESimpleSetting_MaxInclusive() {
		return (EAttribute)eSimpleSettingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESimpleSetting_MinExclusive() {
		return (EAttribute)eSimpleSettingEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESimpleSetting_MaxExclusive() {
		return (EAttribute)eSimpleSettingEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESimpleSetting_MinLength() {
		return (EAttribute)eSimpleSettingEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESimpleSetting_MaxLength() {
		return (EAttribute)eSimpleSettingEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESimpleSetting_Length() {
		return (EAttribute)eSimpleSettingEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESimpleSetting_Pattern() {
		return (EAttribute)eSimpleSettingEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESimpleSetting_TotalDigits() {
		return (EAttribute)eSimpleSettingEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getESimpleSetting_Options() {
		return (EReference)eSimpleSettingEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getESequenceSetting() {
		return eSequenceSettingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESequenceSetting_MinOccurs() {
		return (EAttribute)eSequenceSettingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESequenceSetting_MaxOccurs() {
		return (EAttribute)eSequenceSettingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getESequenceSetting_Items() {
		return (EReference)eSequenceSettingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getESequenceSetting_Template() {
		return (EReference)eSequenceSettingEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESequenceSetting_MapKey() {
		return (EAttribute)eSequenceSettingEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESequenceSetting_MapValue() {
		return (EAttribute)eSequenceSettingEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESequenceSetting_VisibleSubSettings() {
		return (EAttribute)eSequenceSettingEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEItemSetting() {
		return eItemSettingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEItemSetting_Number() {
		return (EAttribute)eItemSettingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEItemSetting_SubSettings() {
		return (EReference)eItemSettingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEItemSetting_Fields() {
		return (EReference)eItemSettingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getESubSettingValue() {
		return eSubSettingValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getESubSettingValue_SimpleSetting() {
		return (EReference)eSubSettingValueEClass.getEStructuralFeatures().get(0);
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
	public EAttribute getEDescriptionContainer_DescriptionUriText() {
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
	public EAttribute getEIconContainer_IconUriTitle() {
		return (EAttribute)eIconContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEIconContainer_IconUri() {
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
	public EClass getESettingValue() {
		return eSettingValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESettingValue_Ref() {
		return (EAttribute)eSettingValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getESettingValue_Type() {
		return (EReference)eSettingValueEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESettingValue_Map() {
		return (EAttribute)eSettingValueEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESettingValue_ChosenOption() {
		return (EAttribute)eSettingValueEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getECompositeSetting() {
		return eCompositeSettingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEResourceSetting() {
		return eResourceSettingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEResourceSetting_Kind() {
		return (EAttribute)eResourceSettingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEResourceSetting_LocalPath() {
		return (EReference)eResourceSettingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEResourceSetting_TargetPath() {
		return (EReference)eResourceSettingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getESettingContainer() {
		return eSettingContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getESettingContainer_SubTypes() {
		return (EReference)eSettingContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getESimpleValue() {
		return eSimpleValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESimpleValue_Value() {
		return (EAttribute)eSimpleValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getESequenceValue() {
		return eSequenceValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getESequenceValue_Template() {
		return (EReference)eSequenceValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getESequenceValue_Items() {
		return (EReference)eSequenceValueEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESequenceValue_ExtensionPolicy() {
		return (EAttribute)eSequenceValueEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getESequenceValueItem() {
		return eSequenceValueItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESequenceValueItem_Editable() {
		return (EAttribute)eSequenceValueItemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESequenceValueItem_FrameLocationUri() {
		return (EAttribute)eSequenceValueItemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESequenceValueItem_Removed() {
		return (EAttribute)eSequenceValueItemEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getECompositeValue() {
		return eCompositeValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getESettingValueContainer() {
		return eSettingValueContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getESettingValueContainer_SubSettings() {
		return (EReference)eSettingValueContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEResourceValue() {
		return eResourceValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEResourceValue_LocalPath() {
		return (EReference)eResourceValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEResourceValue_TargetPath() {
		return (EReference)eResourceValueEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEProperty() {
		return ePropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEProperty_Name() {
		return (EAttribute)ePropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEProperty_Value() {
		return (EAttribute)ePropertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEProperty_Unit() {
		return (EAttribute)ePropertyEClass.getEStructuralFeatures().get(2);
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
	public EAttribute getELinkContainer_LinkUri() {
		return (EAttribute)eLinkContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getELinkContainer_LinkUriTitle() {
		return (EAttribute)eLinkContainerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEOptionMap() {
		return eOptionMapEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEOptionMap_MapValue() {
		return (EAttribute)eOptionMapEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEOptionMap_Value2Save() {
		return (EAttribute)eOptionMapEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEOption() {
		return eOptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEOption_Name() {
		return (EAttribute)eOptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEOption_Value() {
		return (EAttribute)eOptionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEOption_Map() {
		return (EAttribute)eOptionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEOption_MapSourceSetting() {
		return (EReference)eOptionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEOption_OptionValues() {
		return (EAttribute)eOptionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEValueEditorDocument() {
		return eValueEditorDocumentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEValueEditorDocument_Features() {
		return (EReference)eValueEditorDocumentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEValueEditorDocument_Groups() {
		return (EReference)eValueEditorDocumentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPattern() {
		return patternEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPattern_Value() {
		return (EAttribute)patternEClass.getEStructuralFeatures().get(0);
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
	public EAttribute getView_Name() {
		return (EAttribute)viewEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getView_SharedSettingInstances() {
		return (EReference)viewEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getView_SharedFeatures() {
		return (EReference)viewEClass.getEStructuralFeatures().get(2);
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
	public EReference getEGroup_Features() {
		return (EReference)eGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEGroup_SettingOrder() {
		return (EAttribute)eGroupEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEGroup_Name() {
		return (EAttribute)eGroupEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getESettingValueType() {
		return eSettingValueTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEExtensionPolicy() {
		return eExtensionPolicyEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEResourceKind() {
		return eResourceKindEEnum;
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
	public EDataType getEcore_URI() {
		return ecore_URIEDataType;
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
		eFeatureEClass = createEClass(EFEATURE);
		createEReference(eFeatureEClass, EFEATURE__SETTINGS);
		createEAttribute(eFeatureEClass, EFEATURE__REF);
		createEAttribute(eFeatureEClass, EFEATURE__NAME);
		createEAttribute(eFeatureEClass, EFEATURE__RELEVANT);
		createEAttribute(eFeatureEClass, EFEATURE__RELEVANT_AST);
		createEAttribute(eFeatureEClass, EFEATURE__COMPUTED_RELEVANT);

		eSettingEClass = createEClass(ESETTING);
		createEAttribute(eSettingEClass, ESETTING__NAME);
		createEAttribute(eSettingEClass, ESETTING__REF);
		createEAttribute(eSettingEClass, ESETTING__RFS);
		createEReference(eSettingEClass, ESETTING__VALUE);
		createEReference(eSettingEClass, ESETTING__DEFAULT_VALUE);
		createEAttribute(eSettingEClass, ESETTING__DEFAULT_RFS);
		createEAttribute(eSettingEClass, ESETTING__READ_ONLY);
		createEAttribute(eSettingEClass, ESETTING__CONSTRAINT);
		createEAttribute(eSettingEClass, ESETTING__RELEVANT);
		createEAttribute(eSettingEClass, ESETTING__REQUIRED);
		createEReference(eSettingEClass, ESETTING__PROPERTIES);
		createEAttribute(eSettingEClass, ESETTING__DEPRECATED);
		createEAttribute(eSettingEClass, ESETTING__MODIFIED);
		createEAttribute(eSettingEClass, ESETTING__SETDEFAULT);
		createEAttribute(eSettingEClass, ESETTING__COMPUTED_RELEVANT);
		createEAttribute(eSettingEClass, ESETTING__COMPUTED_CONSTRAINT);
		createEAttribute(eSettingEClass, ESETTING__RELEVANT_AST);
		createEAttribute(eSettingEClass, ESETTING__CONSTRAINT_AST);
		createEAttribute(eSettingEClass, ESETTING__DEPENDENCIES);
		createEAttribute(eSettingEClass, ESETTING__OPTION_DEPENDENCIES);
		createEAttribute(eSettingEClass, ESETTING__VALUE_NULL);
		createEAttribute(eSettingEClass, ESETTING__NOTES);

		eSettingOptionEClass = createEClass(ESETTING_OPTION);
		createEAttribute(eSettingOptionEClass, ESETTING_OPTION__RELEVANT);
		createEAttribute(eSettingOptionEClass, ESETTING_OPTION__RELEVANT_AST);
		createEAttribute(eSettingOptionEClass, ESETTING_OPTION__COMPUTED_RELEVANT);

		eSimpleSettingEClass = createEClass(ESIMPLE_SETTING);
		createEAttribute(eSimpleSettingEClass, ESIMPLE_SETTING__TYPE);
		createEAttribute(eSimpleSettingEClass, ESIMPLE_SETTING__MIN_INCLUSIVE);
		createEAttribute(eSimpleSettingEClass, ESIMPLE_SETTING__MAX_INCLUSIVE);
		createEAttribute(eSimpleSettingEClass, ESIMPLE_SETTING__MIN_EXCLUSIVE);
		createEAttribute(eSimpleSettingEClass, ESIMPLE_SETTING__MAX_EXCLUSIVE);
		createEAttribute(eSimpleSettingEClass, ESIMPLE_SETTING__MIN_LENGTH);
		createEAttribute(eSimpleSettingEClass, ESIMPLE_SETTING__MAX_LENGTH);
		createEAttribute(eSimpleSettingEClass, ESIMPLE_SETTING__LENGTH);
		createEAttribute(eSimpleSettingEClass, ESIMPLE_SETTING__PATTERN);
		createEAttribute(eSimpleSettingEClass, ESIMPLE_SETTING__TOTAL_DIGITS);
		createEReference(eSimpleSettingEClass, ESIMPLE_SETTING__OPTIONS);

		eSequenceSettingEClass = createEClass(ESEQUENCE_SETTING);
		createEAttribute(eSequenceSettingEClass, ESEQUENCE_SETTING__MIN_OCCURS);
		createEAttribute(eSequenceSettingEClass, ESEQUENCE_SETTING__MAX_OCCURS);
		createEReference(eSequenceSettingEClass, ESEQUENCE_SETTING__ITEMS);
		createEReference(eSequenceSettingEClass, ESEQUENCE_SETTING__TEMPLATE);
		createEAttribute(eSequenceSettingEClass, ESEQUENCE_SETTING__MAP_KEY);
		createEAttribute(eSequenceSettingEClass, ESEQUENCE_SETTING__MAP_VALUE);
		createEAttribute(eSequenceSettingEClass, ESEQUENCE_SETTING__VISIBLE_SUB_SETTINGS);

		eItemSettingEClass = createEClass(EITEM_SETTING);
		createEAttribute(eItemSettingEClass, EITEM_SETTING__NUMBER);
		createEReference(eItemSettingEClass, EITEM_SETTING__SUB_SETTINGS);
		createEReference(eItemSettingEClass, EITEM_SETTING__FIELDS);

		eSubSettingValueEClass = createEClass(ESUB_SETTING_VALUE);
		createEReference(eSubSettingValueEClass, ESUB_SETTING_VALUE__SIMPLE_SETTING);

		eDescriptionContainerEClass = createEClass(EDESCRIPTION_CONTAINER);
		createEAttribute(eDescriptionContainerEClass, EDESCRIPTION_CONTAINER__DESCRIPTION_TEXT);
		createEAttribute(eDescriptionContainerEClass, EDESCRIPTION_CONTAINER__DESCRIPTION_URI);
		createEAttribute(eDescriptionContainerEClass, EDESCRIPTION_CONTAINER__DESCRIPTION_URI_TEXT);

		eIconContainerEClass = createEClass(EICON_CONTAINER);
		createEAttribute(eIconContainerEClass, EICON_CONTAINER__ICON_URI_TITLE);
		createEAttribute(eIconContainerEClass, EICON_CONTAINER__ICON_URI);

		eResourceLocatorEClass = createEClass(ERESOURCE_LOCATOR);
		createEAttribute(eResourceLocatorEClass, ERESOURCE_LOCATOR__RESOURCE_URI);

		eSettingValueEClass = createEClass(ESETTING_VALUE);
		createEAttribute(eSettingValueEClass, ESETTING_VALUE__REF);
		createEReference(eSettingValueEClass, ESETTING_VALUE__TYPE);
		createEAttribute(eSettingValueEClass, ESETTING_VALUE__MAP);
		createEAttribute(eSettingValueEClass, ESETTING_VALUE__CHOSEN_OPTION);

		eCompositeSettingEClass = createEClass(ECOMPOSITE_SETTING);

		eResourceSettingEClass = createEClass(ERESOURCE_SETTING);
		createEAttribute(eResourceSettingEClass, ERESOURCE_SETTING__KIND);
		createEReference(eResourceSettingEClass, ERESOURCE_SETTING__LOCAL_PATH);
		createEReference(eResourceSettingEClass, ERESOURCE_SETTING__TARGET_PATH);

		eSettingContainerEClass = createEClass(ESETTING_CONTAINER);
		createEReference(eSettingContainerEClass, ESETTING_CONTAINER__SUB_TYPES);

		eSimpleValueEClass = createEClass(ESIMPLE_VALUE);
		createEAttribute(eSimpleValueEClass, ESIMPLE_VALUE__VALUE);

		eSequenceValueEClass = createEClass(ESEQUENCE_VALUE);
		createEReference(eSequenceValueEClass, ESEQUENCE_VALUE__TEMPLATE);
		createEReference(eSequenceValueEClass, ESEQUENCE_VALUE__ITEMS);
		createEAttribute(eSequenceValueEClass, ESEQUENCE_VALUE__EXTENSION_POLICY);

		eSequenceValueItemEClass = createEClass(ESEQUENCE_VALUE_ITEM);
		createEAttribute(eSequenceValueItemEClass, ESEQUENCE_VALUE_ITEM__EDITABLE);
		createEAttribute(eSequenceValueItemEClass, ESEQUENCE_VALUE_ITEM__FRAME_LOCATION_URI);
		createEAttribute(eSequenceValueItemEClass, ESEQUENCE_VALUE_ITEM__REMOVED);

		eCompositeValueEClass = createEClass(ECOMPOSITE_VALUE);

		eSettingValueContainerEClass = createEClass(ESETTING_VALUE_CONTAINER);
		createEReference(eSettingValueContainerEClass, ESETTING_VALUE_CONTAINER__SUB_SETTINGS);

		eResourceValueEClass = createEClass(ERESOURCE_VALUE);
		createEReference(eResourceValueEClass, ERESOURCE_VALUE__LOCAL_PATH);
		createEReference(eResourceValueEClass, ERESOURCE_VALUE__TARGET_PATH);

		ePropertyEClass = createEClass(EPROPERTY);
		createEAttribute(ePropertyEClass, EPROPERTY__NAME);
		createEAttribute(ePropertyEClass, EPROPERTY__VALUE);
		createEAttribute(ePropertyEClass, EPROPERTY__UNIT);

		eLinkContainerEClass = createEClass(ELINK_CONTAINER);
		createEAttribute(eLinkContainerEClass, ELINK_CONTAINER__LINK_URI);
		createEAttribute(eLinkContainerEClass, ELINK_CONTAINER__LINK_URI_TITLE);

		eOptionMapEClass = createEClass(EOPTION_MAP);
		createEAttribute(eOptionMapEClass, EOPTION_MAP__MAP_VALUE);
		createEAttribute(eOptionMapEClass, EOPTION_MAP__VALUE2_SAVE);

		eOptionEClass = createEClass(EOPTION);
		createEAttribute(eOptionEClass, EOPTION__NAME);
		createEAttribute(eOptionEClass, EOPTION__VALUE);
		createEAttribute(eOptionEClass, EOPTION__MAP);
		createEReference(eOptionEClass, EOPTION__MAP_SOURCE_SETTING);
		createEAttribute(eOptionEClass, EOPTION__OPTION_VALUES);

		eValueEditorDocumentEClass = createEClass(EVALUE_EDITOR_DOCUMENT);
		createEReference(eValueEditorDocumentEClass, EVALUE_EDITOR_DOCUMENT__FEATURES);
		createEReference(eValueEditorDocumentEClass, EVALUE_EDITOR_DOCUMENT__GROUPS);

		patternEClass = createEClass(PATTERN);
		createEAttribute(patternEClass, PATTERN__VALUE);

		viewEClass = createEClass(VIEW);
		createEAttribute(viewEClass, VIEW__NAME);
		createEReference(viewEClass, VIEW__SHARED_SETTING_INSTANCES);
		createEReference(viewEClass, VIEW__SHARED_FEATURES);

		eGroupEClass = createEClass(EGROUP);
		createEReference(eGroupEClass, EGROUP__FEATURES);
		createEAttribute(eGroupEClass, EGROUP__SETTING_ORDER);
		createEAttribute(eGroupEClass, EGROUP__NAME);

		// Create enums
		eSettingValueTypeEEnum = createEEnum(ESETTING_VALUE_TYPE);
		eExtensionPolicyEEnum = createEEnum(EEXTENSION_POLICY);
		eResourceKindEEnum = createEEnum(ERESOURCE_KIND);

		// Create data types
		eJavaURIEDataType = createEDataType(EJAVA_URI);
		ecore_URIEDataType = createEDataType(ECORE_URI);
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
		eFeatureEClass.getESuperTypes().add(this.getEDescriptionContainer());
		eFeatureEClass.getESuperTypes().add(this.getEIconContainer());
		eFeatureEClass.getESuperTypes().add(this.getELinkContainer());
		eSettingEClass.getESuperTypes().add(this.getEDescriptionContainer());
		eSettingEClass.getESuperTypes().add(this.getEIconContainer());
		eSettingEClass.getESuperTypes().add(this.getELinkContainer());
		eSettingOptionEClass.getESuperTypes().add(this.getEDescriptionContainer());
		eSimpleSettingEClass.getESuperTypes().add(this.getESetting());
		eSequenceSettingEClass.getESuperTypes().add(this.getESetting());
		eSequenceSettingEClass.getESuperTypes().add(this.getESettingContainer());
		eCompositeSettingEClass.getESuperTypes().add(this.getESetting());
		eCompositeSettingEClass.getESuperTypes().add(this.getESettingContainer());
		eResourceSettingEClass.getESuperTypes().add(this.getECompositeSetting());
		eSimpleValueEClass.getESuperTypes().add(this.getESettingValue());
		eSequenceValueEClass.getESuperTypes().add(this.getESettingValue());
		eSequenceValueItemEClass.getESuperTypes().add(this.getESettingValueContainer());
		eCompositeValueEClass.getESuperTypes().add(this.getESettingValue());
		eCompositeValueEClass.getESuperTypes().add(this.getESettingValueContainer());
		eResourceValueEClass.getESuperTypes().add(this.getECompositeValue());
		eOptionMapEClass.getESuperTypes().add(this.getESettingOption());
		eOptionEClass.getESuperTypes().add(this.getESettingOption());
		eGroupEClass.getESuperTypes().add(this.getEDescriptionContainer());

		// Initialize classes and features; add operations and parameters
		initEClass(eFeatureEClass, EFeature.class, "EFeature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEFeature_Settings(), this.getESetting(), null, "settings", null, 0, -1, EFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEFeature_Ref(), ecorePackage.getEString(), "ref", null, 1, 1, EFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEFeature_Name(), ecorePackage.getEString(), "name", null, 1, 1, EFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEFeature_Relevant(), ecorePackage.getEString(), "relevant", null, 0, 1, EFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEFeature_RelevantAST(), ecorePackage.getEJavaObject(), "relevantAST", null, 0, 1, EFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEFeature_ComputedRelevant(), ecorePackage.getEBoolean(), "computedRelevant", "true", 0, 1, EFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(eFeatureEClass, this.getView(), "getView", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(eSettingEClass, ESetting.class, "ESetting", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getESetting_Name(), ecorePackage.getEString(), "name", null, 1, 1, ESetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getESetting_Ref(), ecorePackage.getEString(), "ref", null, 1, 1, ESetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getESetting_Rfs(), ecorePackage.getEBooleanObject(), "rfs", null, 0, 1, ESetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getESetting_Value(), this.getESettingValue(), null, "value", null, 0, 1, ESetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getESetting_DefaultValue(), this.getESettingValue(), null, "defaultValue", null, 0, 1, ESetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getESetting_DefaultRfs(), ecorePackage.getEBooleanObject(), "defaultRfs", null, 1, 1, ESetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getESetting_ReadOnly(), ecorePackage.getEBoolean(), "readOnly", null, 0, 1, ESetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getESetting_Constraint(), ecorePackage.getEString(), "constraint", null, 0, 1, ESetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getESetting_Relevant(), ecorePackage.getEString(), "relevant", null, 0, 1, ESetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getESetting_Required(), ecorePackage.getEBoolean(), "required", null, 0, 1, ESetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getESetting_Properties(), this.getEProperty(), null, "properties", null, 0, -1, ESetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getESetting_Deprecated(), ecorePackage.getEBoolean(), "deprecated", null, 0, 1, ESetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getESetting_Modified(), ecorePackage.getEBoolean(), "modified", null, 0, 1, ESetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getESetting_Setdefault(), ecorePackage.getEBoolean(), "setdefault", null, 0, 1, ESetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getESetting_ComputedRelevant(), ecorePackage.getEBoolean(), "computedRelevant", "true", 0, 1, ESetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getESetting_ComputedConstraint(), ecorePackage.getEBoolean(), "computedConstraint", "true", 0, 1, ESetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getESetting_RelevantAST(), ecorePackage.getEJavaObject(), "relevantAST", null, 0, 1, ESetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getESetting_ConstraintAST(), ecorePackage.getEJavaObject(), "constraintAST", null, 0, 1, ESetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		EGenericType g1 = createEGenericType(ecorePackage.getEEList());
		EGenericType g2 = createEGenericType(ecorePackage.getEObject());
		g1.getETypeArguments().add(g2);
		initEAttribute(getESetting_Dependencies(), g1, "dependencies", null, 0, 1, ESetting.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEEList());
		g2 = createEGenericType(this.getESetting());
		g1.getETypeArguments().add(g2);
		initEAttribute(getESetting_OptionDependencies(), g1, "optionDependencies", null, 0, 1, ESetting.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getESetting_ValueNull(), ecorePackage.getEBoolean(), "valueNull", null, 0, 1, ESetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getESetting_Notes(), ecorePackage.getEString(), "notes", null, 0, 1, ESetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(eSettingEClass, ecorePackage.getEBoolean(), "isDirty", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(eSettingEClass, null, "clearDirty", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(eSettingEClass, ecorePackage.getEBoolean(), "isDefault", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(eSettingEClass, this.getView(), "getView", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(eSettingOptionEClass, ESettingOption.class, "ESettingOption", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getESettingOption_Relevant(), ecorePackage.getEString(), "relevant", null, 0, 1, ESettingOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getESettingOption_RelevantAST(), ecorePackage.getEJavaObject(), "relevantAST", null, 0, 1, ESettingOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getESettingOption_ComputedRelevant(), ecorePackage.getEBoolean(), "computedRelevant", "true", 0, 1, ESettingOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eSimpleSettingEClass, ESimpleSetting.class, "ESimpleSetting", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getESimpleSetting_Type(), this.getESettingValueType(), "type", null, 1, 1, ESimpleSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getESimpleSetting_MinInclusive(), ecorePackage.getEString(), "minInclusive", null, 0, 1, ESimpleSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getESimpleSetting_MaxInclusive(), ecorePackage.getEString(), "maxInclusive", null, 0, 1, ESimpleSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getESimpleSetting_MinExclusive(), ecorePackage.getEString(), "minExclusive", null, 0, 1, ESimpleSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getESimpleSetting_MaxExclusive(), ecorePackage.getEString(), "maxExclusive", null, 0, 1, ESimpleSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getESimpleSetting_MinLength(), ecorePackage.getEIntegerObject(), "minLength", null, 0, 1, ESimpleSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getESimpleSetting_MaxLength(), ecorePackage.getEIntegerObject(), "maxLength", null, 0, 1, ESimpleSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getESimpleSetting_Length(), ecorePackage.getEIntegerObject(), "length", null, 0, 1, ESimpleSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getESimpleSetting_Pattern(), ecorePackage.getEString(), "pattern", null, 0, -1, ESimpleSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getESimpleSetting_TotalDigits(), ecorePackage.getEIntegerObject(), "totalDigits", null, 0, 1, ESimpleSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getESimpleSetting_Options(), this.getESettingOption(), null, "options", null, 0, -1, ESimpleSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eSequenceSettingEClass, ESequenceSetting.class, "ESequenceSetting", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getESequenceSetting_MinOccurs(), ecorePackage.getEIntegerObject(), "minOccurs", null, 0, 1, ESequenceSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getESequenceSetting_MaxOccurs(), ecorePackage.getEIntegerObject(), "maxOccurs", null, 0, 1, ESequenceSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getESequenceSetting_Items(), this.getEItemSetting(), null, "items", null, 0, -1, ESequenceSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getESequenceSetting_Template(), this.getEItemSetting(), null, "template", null, 0, 1, ESequenceSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getESequenceSetting_MapKey(), ecorePackage.getEString(), "mapKey", null, 0, 1, ESequenceSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getESequenceSetting_MapValue(), ecorePackage.getEString(), "mapValue", null, 0, 1, ESequenceSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getESequenceSetting_VisibleSubSettings(), ecorePackage.getEString(), "visibleSubSettings", null, 0, -1, ESequenceSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eItemSettingEClass, EItemSetting.class, "EItemSetting", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEItemSetting_Number(), ecorePackage.getEInt(), "number", null, 0, 1, EItemSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEItemSetting_SubSettings(), this.getESubSettingValue(), null, "subSettings", null, 0, -1, EItemSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEItemSetting_Fields(), this.getESetting(), null, "fields", null, 0, -1, EItemSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eSubSettingValueEClass, ESubSettingValue.class, "ESubSettingValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getESubSettingValue_SimpleSetting(), this.getESimpleSetting(), null, "simpleSetting", null, 0, 1, ESubSettingValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eDescriptionContainerEClass, EDescriptionContainer.class, "EDescriptionContainer", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEDescriptionContainer_DescriptionText(), ecorePackage.getEString(), "descriptionText", null, 0, 1, EDescriptionContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEDescriptionContainer_DescriptionUri(), ecorePackage.getEString(), "descriptionUri", null, 0, 1, EDescriptionContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEDescriptionContainer_DescriptionUriText(), ecorePackage.getEString(), "descriptionUriText", null, 0, 1, EDescriptionContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eIconContainerEClass, EIconContainer.class, "EIconContainer", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEIconContainer_IconUriTitle(), ecorePackage.getEString(), "iconUriTitle", null, 0, 1, EIconContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEIconContainer_IconUri(), ecorePackage.getEString(), "iconUri", null, 0, 1, EIconContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eResourceLocatorEClass, EResourceLocator.class, "EResourceLocator", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEResourceLocator_ResourceUri(), this.getEJavaURI(), "resourceUri", null, 0, 1, EResourceLocator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eSettingValueEClass, ESettingValue.class, "ESettingValue", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getESettingValue_Ref(), ecorePackage.getEString(), "ref", null, 1, 1, ESettingValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getESettingValue_Type(), this.getESetting(), null, "type", null, 1, 1, ESettingValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getESettingValue_Map(), ecorePackage.getEString(), "map", null, 0, 1, ESettingValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getESettingValue_ChosenOption(), ecorePackage.getEString(), "chosenOption", null, 0, 1, ESettingValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eCompositeSettingEClass, ECompositeSetting.class, "ECompositeSetting", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(eResourceSettingEClass, EResourceSetting.class, "EResourceSetting", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEResourceSetting_Kind(), this.getEResourceKind(), "kind", null, 1, 1, EResourceSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEResourceSetting_LocalPath(), this.getESetting(), null, "localPath", null, 0, 1, EResourceSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEResourceSetting_TargetPath(), this.getESetting(), null, "targetPath", null, 0, 1, EResourceSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eSettingContainerEClass, ESettingContainer.class, "ESettingContainer", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getESettingContainer_SubTypes(), this.getESetting(), null, "subTypes", null, 0, -1, ESettingContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eSimpleValueEClass, ESimpleValue.class, "ESimpleValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getESimpleValue_Value(), ecorePackage.getEString(), "value", null, 0, 1, ESimpleValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eSequenceValueEClass, ESequenceValue.class, "ESequenceValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getESequenceValue_Template(), this.getESequenceValueItem(), null, "template", null, 0, 1, ESequenceValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getESequenceValue_Items(), this.getESequenceValueItem(), null, "items", null, 0, -1, ESequenceValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getESequenceValue_ExtensionPolicy(), this.getEExtensionPolicy(), "extensionPolicy", null, 0, 1, ESequenceValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eSequenceValueItemEClass, ESequenceValueItem.class, "ESequenceValueItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getESequenceValueItem_Editable(), ecorePackage.getEBoolean(), "editable", null, 0, 1, ESequenceValueItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getESequenceValueItem_FrameLocationUri(), this.getEcore_URI(), "frameLocationUri", null, 0, 1, ESequenceValueItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getESequenceValueItem_Removed(), ecorePackage.getEBoolean(), "removed", null, 0, 1, ESequenceValueItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eCompositeValueEClass, ECompositeValue.class, "ECompositeValue", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(eSettingValueContainerEClass, ESettingValueContainer.class, "ESettingValueContainer", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getESettingValueContainer_SubSettings(), this.getESettingValue(), null, "subSettings", null, 0, -1, ESettingValueContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eResourceValueEClass, EResourceValue.class, "EResourceValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEResourceValue_LocalPath(), this.getESettingValue(), null, "localPath", null, 0, 1, EResourceValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEResourceValue_TargetPath(), this.getESettingValue(), null, "targetPath", null, 0, 1, EResourceValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ePropertyEClass, EProperty.class, "EProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEProperty_Name(), ecorePackage.getEString(), "name", null, 0, 1, EProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEProperty_Value(), ecorePackage.getEString(), "value", null, 0, 1, EProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEProperty_Unit(), ecorePackage.getEString(), "unit", null, 0, 1, EProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eLinkContainerEClass, ELinkContainer.class, "ELinkContainer", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getELinkContainer_LinkUri(), ecorePackage.getEString(), "linkUri", null, 0, 1, ELinkContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getELinkContainer_LinkUriTitle(), ecorePackage.getEString(), "linkUriTitle", null, 0, 1, ELinkContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eOptionMapEClass, EOptionMap.class, "EOptionMap", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEOptionMap_MapValue(), ecorePackage.getEString(), "mapValue", null, 0, 1, EOptionMap.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEOptionMap_Value2Save(), ecorePackage.getEString(), "value2Save", null, 0, 1, EOptionMap.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eOptionEClass, EOption.class, "EOption", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEOption_Name(), ecorePackage.getEString(), "name", "", 0, 1, EOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEOption_Value(), ecorePackage.getEString(), "value", null, 0, 1, EOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEOption_Map(), ecorePackage.getEString(), "map", "", 0, 1, EOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEOption_MapSourceSetting(), this.getESequenceSetting(), null, "mapSourceSetting", null, 0, 1, EOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEString());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getEOptionMap());
		g1.getETypeArguments().add(g2);
		initEAttribute(getEOption_OptionValues(), g1, "optionValues", null, 0, 1, EOption.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(eOptionEClass, ecorePackage.getEString(), "getMapValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "key", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(eValueEditorDocumentEClass, EValueEditorDocument.class, "EValueEditorDocument", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEValueEditorDocument_Features(), this.getEFeature(), null, "features", null, 0, -1, EValueEditorDocument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEValueEditorDocument_Groups(), this.getEGroup(), null, "groups", null, 0, -1, EValueEditorDocument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(patternEClass, Pattern.class, "Pattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPattern_Value(), ecorePackage.getEString(), "value", null, 0, -1, Pattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(viewEClass, View.class, "View", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getView_Name(), ecorePackage.getEString(), "name", "", 0, 1, View.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getView_SharedSettingInstances(), this.getESetting(), null, "sharedSettingInstances", null, 0, -1, View.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getView_SharedFeatures(), this.getEFeature(), null, "sharedFeatures", null, 0, -1, View.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eGroupEClass, EGroup.class, "EGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEGroup_Features(), this.getEFeature(), null, "features", null, 0, -1, EGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEEList());
		g2 = createEGenericType(ecorePackage.getEString());
		g1.getETypeArguments().add(g2);
		initEAttribute(getEGroup_SettingOrder(), g1, "settingOrder", null, 0, 1, EGroup.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEGroup_Name(), ecorePackage.getEString(), "name", null, 0, 1, EGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(eSettingValueTypeEEnum, ESettingValueType.class, "ESettingValueType");
		addEEnumLiteral(eSettingValueTypeEEnum, ESettingValueType.INTEGER);
		addEEnumLiteral(eSettingValueTypeEEnum, ESettingValueType.STRING);
		addEEnumLiteral(eSettingValueTypeEEnum, ESettingValueType.DECIMAL);
		addEEnumLiteral(eSettingValueTypeEEnum, ESettingValueType.SELECTION);
		addEEnumLiteral(eSettingValueTypeEEnum, ESettingValueType.BOOLEAN);
		addEEnumLiteral(eSettingValueTypeEEnum, ESettingValueType.URI);
		addEEnumLiteral(eSettingValueTypeEEnum, ESettingValueType.DATETIME);
		addEEnumLiteral(eSettingValueTypeEEnum, ESettingValueType.DURATION);
		addEEnumLiteral(eSettingValueTypeEEnum, ESettingValueType.TIME);
		addEEnumLiteral(eSettingValueTypeEEnum, ESettingValueType.DATE);
		addEEnumLiteral(eSettingValueTypeEEnum, ESettingValueType.MULTISELECTION);
		addEEnumLiteral(eSettingValueTypeEEnum, ESettingValueType.FILE);
		addEEnumLiteral(eSettingValueTypeEEnum, ESettingValueType.FOLDER);

		initEEnum(eExtensionPolicyEEnum, EExtensionPolicy.class, "EExtensionPolicy");
		addEEnumLiteral(eExtensionPolicyEEnum, EExtensionPolicy.REPLACE);
		addEEnumLiteral(eExtensionPolicyEEnum, EExtensionPolicy.APPEND);
		addEEnumLiteral(eExtensionPolicyEEnum, EExtensionPolicy.PREFIX);

		initEEnum(eResourceKindEEnum, EResourceKind.class, "EResourceKind");
		addEEnumLiteral(eResourceKindEEnum, EResourceKind.FILE);
		addEEnumLiteral(eResourceKindEEnum, EResourceKind.FOLDER);

		// Initialize data types
		initEDataType(eJavaURIEDataType, URI.class, "EJavaURI", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(ecore_URIEDataType, org.eclipse.emf.common.util.URI.class, "Ecore_URI", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //ConfmlPackageImpl
