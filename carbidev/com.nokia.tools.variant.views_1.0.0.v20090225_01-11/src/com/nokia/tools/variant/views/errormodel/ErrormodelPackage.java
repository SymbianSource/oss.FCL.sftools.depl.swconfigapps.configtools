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
 * Description: This file is part of com.nokia.tools.variant.views component.
 */

package com.nokia.tools.variant.views.errormodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see com.nokia.tools.variant.views.errormodel.ErrormodelFactory
 * @model kind="package"
 * @generated
 */
public interface ErrormodelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "errormodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.nokia.com/xml/ns/cpf-views/errors";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "com.nokia.tools.variant.views.errormodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ErrormodelPackage eINSTANCE = com.nokia.tools.variant.views.errormodel.impl.ErrormodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.nokia.tools.variant.views.errormodel.impl.ErrorsRootImpl <em>Errors Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.variant.views.errormodel.impl.ErrorsRootImpl
	 * @see com.nokia.tools.variant.views.errormodel.impl.ErrormodelPackageImpl#getErrorsRoot()
	 * @generated
	 */
	int ERRORS_ROOT = 0;

	/**
	 * The feature id for the '<em><b>Errors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERRORS_ROOT__ERRORS = 0;

	/**
	 * The number of structural features of the '<em>Errors Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERRORS_ROOT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.nokia.tools.variant.views.errormodel.impl.ErrorImpl <em>Error</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.variant.views.errormodel.impl.ErrorImpl
	 * @see com.nokia.tools.variant.views.errormodel.impl.ErrormodelPackageImpl#getError()
	 * @generated
	 */
	int ERROR = 1;

	/**
	 * The feature id for the '<em><b>Setting</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR__SETTING = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR__LOCATION = 2;

	/**
	 * The number of structural features of the '<em>Error</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_FEATURE_COUNT = 3;


	/**
	 * Returns the meta object for class '{@link com.nokia.tools.variant.views.errormodel.ErrorsRoot <em>Errors Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Errors Root</em>'.
	 * @see com.nokia.tools.variant.views.errormodel.ErrorsRoot
	 * @generated
	 */
	EClass getErrorsRoot();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.variant.views.errormodel.ErrorsRoot#getErrors <em>Errors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Errors</em>'.
	 * @see com.nokia.tools.variant.views.errormodel.ErrorsRoot#getErrors()
	 * @see #getErrorsRoot()
	 * @generated
	 */
	EReference getErrorsRoot_Errors();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.variant.views.errormodel.Error <em>Error</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Error</em>'.
	 * @see com.nokia.tools.variant.views.errormodel.Error
	 * @generated
	 */
	EClass getError();

	/**
	 * Returns the meta object for the reference '{@link com.nokia.tools.variant.views.errormodel.Error#getSetting <em>Setting</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Setting</em>'.
	 * @see com.nokia.tools.variant.views.errormodel.Error#getSetting()
	 * @see #getError()
	 * @generated
	 */
	EReference getError_Setting();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.views.errormodel.Error#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.nokia.tools.variant.views.errormodel.Error#getDescription()
	 * @see #getError()
	 * @generated
	 */
	EAttribute getError_Description();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.views.errormodel.Error#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see com.nokia.tools.variant.views.errormodel.Error#getLocation()
	 * @see #getError()
	 * @generated
	 */
	EAttribute getError_Location();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ErrormodelFactory getErrormodelFactory();

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
		 * The meta object literal for the '{@link com.nokia.tools.variant.views.errormodel.impl.ErrorsRootImpl <em>Errors Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.variant.views.errormodel.impl.ErrorsRootImpl
		 * @see com.nokia.tools.variant.views.errormodel.impl.ErrormodelPackageImpl#getErrorsRoot()
		 * @generated
		 */
		EClass ERRORS_ROOT = eINSTANCE.getErrorsRoot();

		/**
		 * The meta object literal for the '<em><b>Errors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERRORS_ROOT__ERRORS = eINSTANCE.getErrorsRoot_Errors();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.variant.views.errormodel.impl.ErrorImpl <em>Error</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.variant.views.errormodel.impl.ErrorImpl
		 * @see com.nokia.tools.variant.views.errormodel.impl.ErrormodelPackageImpl#getError()
		 * @generated
		 */
		EClass ERROR = eINSTANCE.getError();

		/**
		 * The meta object literal for the '<em><b>Setting</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERROR__SETTING = eINSTANCE.getError_Setting();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ERROR__DESCRIPTION = eINSTANCE.getError_Description();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ERROR__LOCATION = eINSTANCE.getError_Location();

	}

} //ErrormodelPackage
