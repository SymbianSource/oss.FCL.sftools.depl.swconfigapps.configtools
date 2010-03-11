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
 * Description: This file is part of com.nokia.tools.vct.confml.editor.include component.
 */

package com.nokia.tools.vct.confml.editor.include.xincmodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.EXincModelPackage
 * @generated
 */
public interface EXincModelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EXincModelFactory eINSTANCE = com.nokia.tools.vct.confml.editor.include.xincmodel.impl.EXincModelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>EDocument</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EDocument</em>'.
	 * @generated
	 */
	EDocument createEDocument();

	/**
	 * Returns a new object of class '<em>EInclude</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EInclude</em>'.
	 * @generated
	 */
	EInclude createEInclude();

	/**
	 * Returns a new object of class '<em>EProject File</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EProject File</em>'.
	 * @generated
	 */
	EProjectFile createEProjectFile();

	/**
	 * Returns a new object of class '<em>EProject Folder</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EProject Folder</em>'.
	 * @generated
	 */
	EProjectFolder createEProjectFolder();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EXincModelPackage getEXincModelPackage();

} //EXincModelFactory
