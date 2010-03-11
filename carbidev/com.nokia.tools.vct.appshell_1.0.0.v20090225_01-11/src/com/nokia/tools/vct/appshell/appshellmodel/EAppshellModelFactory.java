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
 * Description: This file is part of com.nokia.tools.vct.appshell component.
 */

package com.nokia.tools.vct.appshell.appshellmodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.nokia.tools.vct.appshell.appshellmodel.EAppshellModelPackage
 * @generated
 */
public interface EAppshellModelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EAppshellModelFactory eINSTANCE = com.nokia.tools.vct.appshell.appshellmodel.impl.EAppshellModelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>EAppshell Document</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EAppshell Document</em>'.
	 * @generated
	 */
	EAppshellDocument createEAppshellDocument();

	/**
	 * Returns a new object of class '<em>EFolder Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EFolder Element</em>'.
	 * @generated
	 */
	EFolderElement createEFolderElement();

	/**
	 * Returns a new object of class '<em>EApplication Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EApplication Element</em>'.
	 * @generated
	 */
	EApplicationElement createEApplicationElement();

	/**
	 * Returns a new object of class '<em>EURL Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EURL Element</em>'.
	 * @generated
	 */
	EURLElement createEURLElement();

	/**
	 * Returns a new object of class '<em>EData Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EData Element</em>'.
	 * @generated
	 */
	EDataElement createEDataElement();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EAppshellModelPackage getEAppshellModelPackage();

} //EAppshellModelFactory
