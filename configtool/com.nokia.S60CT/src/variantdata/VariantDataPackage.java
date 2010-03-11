/*
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
*/
package variantdata;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import configurationemf.ConfigurationemfPackage;

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
 * @see variantdata.VariantDataFactory
 * @model kind="package"
 * @generated
 */
public interface VariantDataPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "variantdata";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///variantdata.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "vd";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	VariantDataPackage eINSTANCE = variantdata.impl.VariantDataPackageImpl.init();

	/**
	 * The meta object id for the '{@link variantdata.impl.VariantDataImpl <em>Variant Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see variantdata.impl.VariantDataImpl
	 * @see variantdata.impl.VariantDataPackageImpl#getVariantData()
	 * @generated
	 */
	int VARIANT_DATA = 0;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_DATA__REF = ConfigurationemfPackage.DATA__REF;

	/**
	 * The feature id for the '<em><b>Include</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_DATA__INCLUDE = ConfigurationemfPackage.DATA_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Variant Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_DATA_FEATURE_COUNT = ConfigurationemfPackage.DATA_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link variantdata.VariantData <em>Variant Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variant Data</em>'.
	 * @see variantdata.VariantData
	 * @generated
	 */
	EClass getVariantData();

	/**
	 * Returns the meta object for the reference list '{@link variantdata.VariantData#getInclude <em>Include</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Include</em>'.
	 * @see variantdata.VariantData#getInclude()
	 * @see #getVariantData()
	 * @generated
	 */
	EReference getVariantData_Include();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	VariantDataFactory getVariantDataFactory();

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
		 * The meta object literal for the '{@link variantdata.impl.VariantDataImpl <em>Variant Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see variantdata.impl.VariantDataImpl
		 * @see variantdata.impl.VariantDataPackageImpl#getVariantData()
		 * @generated
		 */
		EClass VARIANT_DATA = eINSTANCE.getVariantData();

		/**
		 * The meta object literal for the '<em><b>Include</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIANT_DATA__INCLUDE = eINSTANCE.getVariantData_Include();

	}

} //VariantDataPackage
