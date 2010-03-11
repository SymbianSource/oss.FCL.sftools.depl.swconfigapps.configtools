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
 * Description: This file is part of com.nokia.tools.variant.resourcelibrary component.
 */

package com.nokia.tools.s60ct.resources.model;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.nokia.tools.s60ct.resources.model.ELibraryModelPackage
 * @generated
 */
public interface ELibraryModelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ELibraryModelFactory eINSTANCE = com.nokia.tools.s60ct.resources.model.impl.ELibraryModelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>ELibrary Directory</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ELibrary Directory</em>'.
	 * @generated
	 */
	ELibraryDirectory createELibraryDirectory();

	/**
	 * Returns a new object of class '<em>ELibrary File</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ELibrary File</em>'.
	 * @generated
	 */
	ELibraryFile createELibraryFile();

	/**
	 * Returns a new object of class '<em>ELibrary Root</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ELibrary Root</em>'.
	 * @generated
	 */
	ELibraryRoot createELibraryRoot();

	/**
	 * Returns a new object of class '<em>ELibrary Theme File</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ELibrary Theme File</em>'.
	 * @generated
	 */
	ELibraryThemeFile createELibraryThemeFile();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ELibraryModelPackage getELibraryModelPackage();

} //resourcesFactory
