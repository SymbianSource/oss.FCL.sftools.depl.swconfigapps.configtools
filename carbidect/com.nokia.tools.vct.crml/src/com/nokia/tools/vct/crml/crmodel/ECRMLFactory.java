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

package com.nokia.tools.vct.crml.crmodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.nokia.tools.vct.crml.crmodel.ECRMLPackage
 * @generated
 */
public interface ECRMLFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ECRMLFactory eINSTANCE = com.nokia.tools.vct.crml.crmodel.impl.ECRMLFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>EMeta</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EMeta</em>'.
	 * @generated
	 */
	EMeta createEMeta();

	/**
	 * Returns a new object of class '<em>EContent</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EContent</em>'.
	 * @generated
	 */
	EContent createEContent();

	/**
	 * Returns a new object of class '<em>ERepository</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ERepository</em>'.
	 * @generated
	 */
	ERepository createERepository();

	/**
	 * Returns a new object of class '<em>EKey</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EKey</em>'.
	 * @generated
	 */
	EKey createEKey();

	/**
	 * Returns a new object of class '<em>EKey Range</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EKey Range</em>'.
	 * @generated
	 */
	EKeyRange createEKeyRange();

	/**
	 * Returns a new object of class '<em>EAccess</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EAccess</em>'.
	 * @generated
	 */
	EAccess createEAccess();

	/**
	 * Returns a new object of class '<em>EValue</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EValue</em>'.
	 * @generated
	 */
	EValue createEValue();

	/**
	 * Returns a new object of class '<em>EBit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EBit</em>'.
	 * @generated
	 */
	EBit createEBit();

	/**
	 * Returns a new object of class '<em>Document Root</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Document Root</em>'.
	 * @generated
	 */
	ECRMLDocumentRoot createECRMLDocumentRoot();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ECRMLPackage getECRMLPackage();

} //ECRMLFactory
