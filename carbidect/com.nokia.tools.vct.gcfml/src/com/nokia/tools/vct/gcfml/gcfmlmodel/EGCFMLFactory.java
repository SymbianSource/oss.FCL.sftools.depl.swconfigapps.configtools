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
 * Description: This file is part of com.nokia.tools.vct.gcfml component.
 */

package com.nokia.tools.vct.gcfml.gcfmlmodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.nokia.tools.vct.gcfml.gcfmlmodel.EGCFMLPackage
 * @generated
 */
public interface EGCFMLFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EGCFMLFactory eINSTANCE = com.nokia.tools.vct.gcfml.gcfmlmodel.impl.EGCFMLFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>EFile</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EFile</em>'.
	 * @generated
	 */
	EFile createEFile();

	/**
	 * Returns a new object of class '<em>ESetting</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ESetting</em>'.
	 * @generated
	 */
	ESetting createESetting();

	/**
	 * Returns a new object of class '<em>Document Root</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Document Root</em>'.
	 * @generated
	 */
	EGCFMLDocumentRoot createEGCFMLDocumentRoot();

	/**
	 * Returns a new object of class '<em>EStylesheet</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EStylesheet</em>'.
	 * @generated
	 */
	EStylesheet createEStylesheet();

	/**
	 * Returns a new object of class '<em>EOutput</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EOutput</em>'.
	 * @generated
	 */
	EOutput createEOutput();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EGCFMLPackage getEGCFMLPackage();

} //EGCFMLFactory
