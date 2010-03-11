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
package com.nokia.tools.carbide.ct.confml.model.xsd;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.nokia.tools.carbide.ct.confml.model.xsd.EXSDFacetPackage
 * @generated
 */
public interface EXSDFacetFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EXSDFacetFactory eINSTANCE = com.nokia.tools.carbide.ct.confml.model.xsd.impl.EXSDFacetFactoryImpl
			.init();

	/**
	 * Returns a new object of class '<em>EMin Inclusive</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EMin Inclusive</em>'.
	 * @generated
	 */
	EMinInclusive createEMinInclusive();

	/**
	 * Returns a new object of class '<em>EMin Exclusive</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EMin Exclusive</em>'.
	 * @generated
	 */
	EMinExclusive createEMinExclusive();

	/**
	 * Returns a new object of class '<em>EMax Inclusive</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EMax Inclusive</em>'.
	 * @generated
	 */
	EMaxInclusive createEMaxInclusive();

	/**
	 * Returns a new object of class '<em>EMax Exclusive</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EMax Exclusive</em>'.
	 * @generated
	 */
	EMaxExclusive createEMaxExclusive();

	/**
	 * Returns a new object of class '<em>ELength</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ELength</em>'.
	 * @generated
	 */
	ELength createELength();

	/**
	 * Returns a new object of class '<em>EMin Length</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EMin Length</em>'.
	 * @generated
	 */
	EMinLength createEMinLength();

	/**
	 * Returns a new object of class '<em>EMax Length</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EMax Length</em>'.
	 * @generated
	 */
	EMaxLength createEMaxLength();

	/**
	 * Returns a new object of class '<em>ETotal Digits</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ETotal Digits</em>'.
	 * @generated
	 */
	ETotalDigits createETotalDigits();

	/**
	 * Returns a new object of class '<em>EPattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EPattern</em>'.
	 * @generated
	 */
	EPattern createEPattern();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EXSDFacetPackage getEXSDFacetPackage();

} //EXSDFacetFactory
