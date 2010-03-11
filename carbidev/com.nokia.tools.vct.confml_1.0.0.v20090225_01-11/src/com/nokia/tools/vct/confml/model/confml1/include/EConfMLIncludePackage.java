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
 * Description: This file is part of com.nokia.tools.vct.confml component.
 */

package com.nokia.tools.vct.confml.model.confml1.include;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.nokia.tools.vct.confml.model.confml1.include.EConfMLIncludeFactory
 * @model kind="package"
 * @generated
 */
public interface EConfMLIncludePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "include";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.w3.org/2001/XInclude";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "xi";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EConfMLIncludePackage eINSTANCE = com.nokia.tools.vct.confml.model.confml1.include.impl.EConfMLIncludePackageImpl
			.init();

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.confml.model.confml1.include.impl.EIncludeImpl <em>EInclude</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.confml.model.confml1.include.impl.EIncludeImpl
	 * @see com.nokia.tools.vct.confml.model.confml1.include.impl.EConfMLIncludePackageImpl#getEInclude()
	 * @generated
	 */
	int EINCLUDE = 0;

	/**
	 * The feature id for the '<em><b>Href</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EINCLUDE__HREF = 0;

	/**
	 * The number of structural features of the '<em>EInclude</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EINCLUDE_FEATURE_COUNT = 1;

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.confml.model.confml1.include.EInclude <em>EInclude</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EInclude</em>'.
	 * @see com.nokia.tools.vct.confml.model.confml1.include.EInclude
	 * @generated
	 */
	EClass getEInclude();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.confml.model.confml1.include.EInclude#getHref <em>Href</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Href</em>'.
	 * @see com.nokia.tools.vct.confml.model.confml1.include.EInclude#getHref()
	 * @see #getEInclude()
	 * @generated
	 */
	EAttribute getEInclude_Href();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EConfMLIncludeFactory getEConfMLIncludeFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.confml.model.confml1.include.impl.EIncludeImpl <em>EInclude</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.confml.model.confml1.include.impl.EIncludeImpl
		 * @see com.nokia.tools.vct.confml.model.confml1.include.impl.EConfMLIncludePackageImpl#getEInclude()
		 * @generated
		 */
		EClass EINCLUDE = eINSTANCE.getEInclude();

		/**
		 * The meta object literal for the '<em><b>Href</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EINCLUDE__HREF = eINSTANCE.getEInclude_Href();

	}

} //EConfMLIncludePackage
