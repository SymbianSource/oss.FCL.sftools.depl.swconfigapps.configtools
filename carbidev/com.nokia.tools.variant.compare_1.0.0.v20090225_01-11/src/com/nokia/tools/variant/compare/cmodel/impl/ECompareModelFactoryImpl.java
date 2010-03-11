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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.nokia.tools.variant.compare.cmodel.ECheckableElement;
import com.nokia.tools.variant.compare.cmodel.ECompareModelFactory;
import com.nokia.tools.variant.compare.cmodel.ECompareModelPackage;
import com.nokia.tools.variant.compare.cmodel.EDiffGroup;
import com.nokia.tools.variant.compare.cmodel.EDiffLocalPathSetting;
import com.nokia.tools.variant.compare.cmodel.EDiffMismatch;
import com.nokia.tools.variant.compare.cmodel.EDiffResourceSetting2;
import com.nokia.tools.variant.compare.cmodel.EDiffSequence;
import com.nokia.tools.variant.compare.cmodel.EDiffSequenceItem;
import com.nokia.tools.variant.compare.cmodel.EDiffSimple;
import com.nokia.tools.variant.compare.cmodel.EModelRoot;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ECompareModelFactoryImpl extends EFactoryImpl implements ECompareModelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ECompareModelFactory init() {
		try {
			ECompareModelFactory theECompareModelFactory = (ECompareModelFactory)EPackage.Registry.INSTANCE.getEFactory("model:///compare"); 
			if (theECompareModelFactory != null) {
				return theECompareModelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ECompareModelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ECompareModelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ECompareModelPackage.EMODEL_ROOT: return createEModelRoot();
			case ECompareModelPackage.EDIFF_GROUP: return createEDiffGroup();
			case ECompareModelPackage.EDIFF_SIMPLE: return createEDiffSimple();
			case ECompareModelPackage.EDIFF_SEQUENCE: return createEDiffSequence();
			case ECompareModelPackage.EDIFF_RESOURCE_SETTING2: return createEDiffResourceSetting2();
			case ECompareModelPackage.EDIFF_LOCAL_PATH_SETTING: return createEDiffLocalPathSetting();
			case ECompareModelPackage.EDIFF_MISMATCH: return createEDiffMismatch();
			case ECompareModelPackage.ECHECKABLE_ELEMENT: return createECheckableElement();
			case ECompareModelPackage.EDIFF_SEQUENCE_ITEM: return createEDiffSequenceItem();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EModelRoot createEModelRoot() {
		EModelRootImpl eModelRoot = new EModelRootImpl();
		return eModelRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDiffGroup createEDiffGroup() {
		EDiffGroupImpl eDiffGroup = new EDiffGroupImpl();
		return eDiffGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDiffSimple createEDiffSimple() {
		EDiffSimpleImpl eDiffSimple = new EDiffSimpleImpl();
		return eDiffSimple;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDiffSequence createEDiffSequence() {
		EDiffSequenceImpl eDiffSequence = new EDiffSequenceImpl();
		return eDiffSequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDiffResourceSetting2 createEDiffResourceSetting2() {
		EDiffResourceSetting2Impl eDiffResourceSetting2 = new EDiffResourceSetting2Impl();
		return eDiffResourceSetting2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDiffLocalPathSetting createEDiffLocalPathSetting() {
		EDiffLocalPathSettingImpl eDiffLocalPathSetting = new EDiffLocalPathSettingImpl();
		return eDiffLocalPathSetting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDiffMismatch createEDiffMismatch() {
		EDiffMismatchImpl eDiffMismatch = new EDiffMismatchImpl();
		return eDiffMismatch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ECheckableElement createECheckableElement() {
		ECheckableElementImpl eCheckableElement = new ECheckableElementImpl();
		return eCheckableElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDiffSequenceItem createEDiffSequenceItem() {
		EDiffSequenceItemImpl eDiffSequenceItem = new EDiffSequenceItemImpl();
		return eDiffSequenceItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ECompareModelPackage getECompareModelPackage() {
		return (ECompareModelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ECompareModelPackage getPackage() {
		return ECompareModelPackage.eINSTANCE;
	}

} //ECompareModelFactoryImpl
