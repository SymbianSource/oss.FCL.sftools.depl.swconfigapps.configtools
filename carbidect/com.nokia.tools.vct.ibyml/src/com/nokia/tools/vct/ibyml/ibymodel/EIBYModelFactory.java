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
 * Description: This file is part of com.nokia.tools.vct.ibyml component.
 */

package com.nokia.tools.vct.ibyml.ibymodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.nokia.tools.vct.ibyml.ibymodel.EIBYModelPackage
 * @generated
 */
public interface EIBYModelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EIBYModelFactory eINSTANCE = com.nokia.tools.vct.ibyml.ibymodel.impl.EIBYModelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>EEntity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EEntity</em>'.
	 * @generated
	 */
	EEntity createEEntity();

	/**
	 * Returns a new object of class '<em>EIBY File</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EIBY File</em>'.
	 * @generated
	 */
	EIBYFile createEIBYFile();

	/**
	 * Returns a new object of class '<em>EEntry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EEntry</em>'.
	 * @generated
	 */
	EEntry createEEntry();

	/**
	 * Returns a new object of class '<em>EFile Name</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EFile Name</em>'.
	 * @generated
	 */
	EFileName createEFileName();

	/**
	 * Returns a new object of class '<em>EIBY Document</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EIBY Document</em>'.
	 * @generated
	 */
	EIBYDocument createEIBYDocument();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EIBYModelPackage getEIBYModelPackage();

} //EIBYModelFactory
