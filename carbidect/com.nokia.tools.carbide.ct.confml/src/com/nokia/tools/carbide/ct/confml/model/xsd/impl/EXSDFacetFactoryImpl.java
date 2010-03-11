/**
 * Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies). 
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
 * $Id$
 */
package com.nokia.tools.carbide.ct.confml.model.xsd.impl;

import com.nokia.tools.carbide.ct.confml.model.xsd.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EXSDFacetFactoryImpl extends EFactoryImpl implements
		EXSDFacetFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EXSDFacetFactory init() {
		try {
			EXSDFacetFactory theEXSDFacetFactory = (EXSDFacetFactory) EPackage.Registry.INSTANCE
					.getEFactory("http://www.w3.org/2001/XMLSchema");
			if (theEXSDFacetFactory != null) {
				return theEXSDFacetFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EXSDFacetFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EXSDFacetFactoryImpl() {
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
		case EXSDFacetPackage.EMIN_INCLUSIVE:
			return createEMinInclusive();
		case EXSDFacetPackage.EMIN_EXCLUSIVE:
			return createEMinExclusive();
		case EXSDFacetPackage.EMAX_INCLUSIVE:
			return createEMaxInclusive();
		case EXSDFacetPackage.EMAX_EXCLUSIVE:
			return createEMaxExclusive();
		case EXSDFacetPackage.ELENGTH:
			return createELength();
		case EXSDFacetPackage.EMIN_LENGTH:
			return createEMinLength();
		case EXSDFacetPackage.EMAX_LENGTH:
			return createEMaxLength();
		case EXSDFacetPackage.ETOTAL_DIGITS:
			return createETotalDigits();
		case EXSDFacetPackage.EPATTERN:
			return createEPattern();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName()
					+ "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMinInclusive createEMinInclusive() {
		EMinInclusiveImpl eMinInclusive = new EMinInclusiveImpl();
		return eMinInclusive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMinExclusive createEMinExclusive() {
		EMinExclusiveImpl eMinExclusive = new EMinExclusiveImpl();
		return eMinExclusive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMaxInclusive createEMaxInclusive() {
		EMaxInclusiveImpl eMaxInclusive = new EMaxInclusiveImpl();
		return eMaxInclusive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMaxExclusive createEMaxExclusive() {
		EMaxExclusiveImpl eMaxExclusive = new EMaxExclusiveImpl();
		return eMaxExclusive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ELength createELength() {
		ELengthImpl eLength = new ELengthImpl();
		return eLength;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMinLength createEMinLength() {
		EMinLengthImpl eMinLength = new EMinLengthImpl();
		return eMinLength;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMaxLength createEMaxLength() {
		EMaxLengthImpl eMaxLength = new EMaxLengthImpl();
		return eMaxLength;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ETotalDigits createETotalDigits() {
		ETotalDigitsImpl eTotalDigits = new ETotalDigitsImpl();
		return eTotalDigits;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPattern createEPattern() {
		EPatternImpl ePattern = new EPatternImpl();
		return ePattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EXSDFacetPackage getEXSDFacetPackage() {
		return (EXSDFacetPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EXSDFacetPackage getPackage() {
		return EXSDFacetPackage.eINSTANCE;
	}

} //EXSDFacetFactoryImpl
