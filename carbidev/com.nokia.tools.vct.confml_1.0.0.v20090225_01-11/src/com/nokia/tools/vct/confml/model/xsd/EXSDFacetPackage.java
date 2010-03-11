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

package com.nokia.tools.vct.confml.model.xsd;

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
 * @see com.nokia.tools.vct.confml.model.xsd.EXSDFacetFactory
 * @model kind="package"
 * @generated
 */
public interface EXSDFacetPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "xsd";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.w3.org/2001/XMLSchema";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "xs";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EXSDFacetPackage eINSTANCE = com.nokia.tools.vct.confml.model.xsd.impl.EXSDFacetPackageImpl
			.init();

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.confml.model.xsd.EFacet <em>EFacet</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.confml.model.xsd.EFacet
	 * @see com.nokia.tools.vct.confml.model.xsd.impl.EXSDFacetPackageImpl#getEFacet()
	 * @generated
	 */
	int EFACET = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFACET__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFACET__FIXED = 1;

	/**
	 * The number of structural features of the '<em>EFacet</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFACET_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.confml.model.xsd.impl.ENumFacetImpl <em>ENum Facet</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.confml.model.xsd.impl.ENumFacetImpl
	 * @see com.nokia.tools.vct.confml.model.xsd.impl.EXSDFacetPackageImpl#getENumFacet()
	 * @generated
	 */
	int ENUM_FACET = 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_FACET__VALUE = EFACET__VALUE;

	/**
	 * The feature id for the '<em><b>Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_FACET__FIXED = EFACET__FIXED;

	/**
	 * The number of structural features of the '<em>ENum Facet</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_FACET_FEATURE_COUNT = EFACET_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.confml.model.xsd.impl.EMinInclusiveImpl <em>EMin Inclusive</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.confml.model.xsd.impl.EMinInclusiveImpl
	 * @see com.nokia.tools.vct.confml.model.xsd.impl.EXSDFacetPackageImpl#getEMinInclusive()
	 * @generated
	 */
	int EMIN_INCLUSIVE = 2;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMIN_INCLUSIVE__VALUE = EFACET__VALUE;

	/**
	 * The feature id for the '<em><b>Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMIN_INCLUSIVE__FIXED = EFACET__FIXED;

	/**
	 * The number of structural features of the '<em>EMin Inclusive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMIN_INCLUSIVE_FEATURE_COUNT = EFACET_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.confml.model.xsd.impl.EMinExclusiveImpl <em>EMin Exclusive</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.confml.model.xsd.impl.EMinExclusiveImpl
	 * @see com.nokia.tools.vct.confml.model.xsd.impl.EXSDFacetPackageImpl#getEMinExclusive()
	 * @generated
	 */
	int EMIN_EXCLUSIVE = 3;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMIN_EXCLUSIVE__VALUE = EFACET__VALUE;

	/**
	 * The feature id for the '<em><b>Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMIN_EXCLUSIVE__FIXED = EFACET__FIXED;

	/**
	 * The number of structural features of the '<em>EMin Exclusive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMIN_EXCLUSIVE_FEATURE_COUNT = EFACET_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.confml.model.xsd.impl.EMaxInclusiveImpl <em>EMax Inclusive</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.confml.model.xsd.impl.EMaxInclusiveImpl
	 * @see com.nokia.tools.vct.confml.model.xsd.impl.EXSDFacetPackageImpl#getEMaxInclusive()
	 * @generated
	 */
	int EMAX_INCLUSIVE = 4;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMAX_INCLUSIVE__VALUE = EFACET__VALUE;

	/**
	 * The feature id for the '<em><b>Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMAX_INCLUSIVE__FIXED = EFACET__FIXED;

	/**
	 * The number of structural features of the '<em>EMax Inclusive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMAX_INCLUSIVE_FEATURE_COUNT = EFACET_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.confml.model.xsd.impl.EMaxExclusiveImpl <em>EMax Exclusive</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.confml.model.xsd.impl.EMaxExclusiveImpl
	 * @see com.nokia.tools.vct.confml.model.xsd.impl.EXSDFacetPackageImpl#getEMaxExclusive()
	 * @generated
	 */
	int EMAX_EXCLUSIVE = 5;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMAX_EXCLUSIVE__VALUE = EFACET__VALUE;

	/**
	 * The feature id for the '<em><b>Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMAX_EXCLUSIVE__FIXED = EFACET__FIXED;

	/**
	 * The number of structural features of the '<em>EMax Exclusive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMAX_EXCLUSIVE_FEATURE_COUNT = EFACET_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.confml.model.xsd.impl.ELengthImpl <em>ELength</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.confml.model.xsd.impl.ELengthImpl
	 * @see com.nokia.tools.vct.confml.model.xsd.impl.EXSDFacetPackageImpl#getELength()
	 * @generated
	 */
	int ELENGTH = 6;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELENGTH__VALUE = ENUM_FACET__VALUE;

	/**
	 * The feature id for the '<em><b>Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELENGTH__FIXED = ENUM_FACET__FIXED;

	/**
	 * The number of structural features of the '<em>ELength</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELENGTH_FEATURE_COUNT = ENUM_FACET_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.confml.model.xsd.impl.EMinLengthImpl <em>EMin Length</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.confml.model.xsd.impl.EMinLengthImpl
	 * @see com.nokia.tools.vct.confml.model.xsd.impl.EXSDFacetPackageImpl#getEMinLength()
	 * @generated
	 */
	int EMIN_LENGTH = 7;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMIN_LENGTH__VALUE = ENUM_FACET__VALUE;

	/**
	 * The feature id for the '<em><b>Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMIN_LENGTH__FIXED = ENUM_FACET__FIXED;

	/**
	 * The number of structural features of the '<em>EMin Length</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMIN_LENGTH_FEATURE_COUNT = ENUM_FACET_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.confml.model.xsd.impl.EMaxLengthImpl <em>EMax Length</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.confml.model.xsd.impl.EMaxLengthImpl
	 * @see com.nokia.tools.vct.confml.model.xsd.impl.EXSDFacetPackageImpl#getEMaxLength()
	 * @generated
	 */
	int EMAX_LENGTH = 8;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMAX_LENGTH__VALUE = ENUM_FACET__VALUE;

	/**
	 * The feature id for the '<em><b>Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMAX_LENGTH__FIXED = ENUM_FACET__FIXED;

	/**
	 * The number of structural features of the '<em>EMax Length</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMAX_LENGTH_FEATURE_COUNT = ENUM_FACET_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.confml.model.xsd.impl.ETotalDigitsImpl <em>ETotal Digits</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.confml.model.xsd.impl.ETotalDigitsImpl
	 * @see com.nokia.tools.vct.confml.model.xsd.impl.EXSDFacetPackageImpl#getETotalDigits()
	 * @generated
	 */
	int ETOTAL_DIGITS = 9;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETOTAL_DIGITS__VALUE = ENUM_FACET__VALUE;

	/**
	 * The feature id for the '<em><b>Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETOTAL_DIGITS__FIXED = ENUM_FACET__FIXED;

	/**
	 * The number of structural features of the '<em>ETotal Digits</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETOTAL_DIGITS_FEATURE_COUNT = ENUM_FACET_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.confml.model.xsd.impl.EPatternImpl <em>EPattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.confml.model.xsd.impl.EPatternImpl
	 * @see com.nokia.tools.vct.confml.model.xsd.impl.EXSDFacetPackageImpl#getEPattern()
	 * @generated
	 */
	int EPATTERN = 10;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPATTERN__VALUE = EFACET__VALUE;

	/**
	 * The feature id for the '<em><b>Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPATTERN__FIXED = EFACET__FIXED;

	/**
	 * The number of structural features of the '<em>EPattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPATTERN_FEATURE_COUNT = EFACET_FEATURE_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.confml.model.xsd.EFacet <em>EFacet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EFacet</em>'.
	 * @see com.nokia.tools.vct.confml.model.xsd.EFacet
	 * @generated
	 */
	EClass getEFacet();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.confml.model.xsd.EFacet#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see com.nokia.tools.vct.confml.model.xsd.EFacet#getValue()
	 * @see #getEFacet()
	 * @generated
	 */
	EAttribute getEFacet_Value();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.confml.model.xsd.EFacet#getFixed <em>Fixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fixed</em>'.
	 * @see com.nokia.tools.vct.confml.model.xsd.EFacet#getFixed()
	 * @see #getEFacet()
	 * @generated
	 */
	EAttribute getEFacet_Fixed();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.confml.model.xsd.ENumFacet <em>ENum Facet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ENum Facet</em>'.
	 * @see com.nokia.tools.vct.confml.model.xsd.ENumFacet
	 * @generated
	 */
	EClass getENumFacet();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.confml.model.xsd.EMinInclusive <em>EMin Inclusive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EMin Inclusive</em>'.
	 * @see com.nokia.tools.vct.confml.model.xsd.EMinInclusive
	 * @generated
	 */
	EClass getEMinInclusive();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.confml.model.xsd.EMinExclusive <em>EMin Exclusive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EMin Exclusive</em>'.
	 * @see com.nokia.tools.vct.confml.model.xsd.EMinExclusive
	 * @generated
	 */
	EClass getEMinExclusive();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.confml.model.xsd.EMaxInclusive <em>EMax Inclusive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EMax Inclusive</em>'.
	 * @see com.nokia.tools.vct.confml.model.xsd.EMaxInclusive
	 * @generated
	 */
	EClass getEMaxInclusive();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.confml.model.xsd.EMaxExclusive <em>EMax Exclusive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EMax Exclusive</em>'.
	 * @see com.nokia.tools.vct.confml.model.xsd.EMaxExclusive
	 * @generated
	 */
	EClass getEMaxExclusive();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.confml.model.xsd.ELength <em>ELength</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ELength</em>'.
	 * @see com.nokia.tools.vct.confml.model.xsd.ELength
	 * @generated
	 */
	EClass getELength();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.confml.model.xsd.EMinLength <em>EMin Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EMin Length</em>'.
	 * @see com.nokia.tools.vct.confml.model.xsd.EMinLength
	 * @generated
	 */
	EClass getEMinLength();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.confml.model.xsd.EMaxLength <em>EMax Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EMax Length</em>'.
	 * @see com.nokia.tools.vct.confml.model.xsd.EMaxLength
	 * @generated
	 */
	EClass getEMaxLength();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.confml.model.xsd.ETotalDigits <em>ETotal Digits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ETotal Digits</em>'.
	 * @see com.nokia.tools.vct.confml.model.xsd.ETotalDigits
	 * @generated
	 */
	EClass getETotalDigits();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.confml.model.xsd.EPattern <em>EPattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EPattern</em>'.
	 * @see com.nokia.tools.vct.confml.model.xsd.EPattern
	 * @generated
	 */
	EClass getEPattern();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EXSDFacetFactory getEXSDFacetFactory();

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
		 * The meta object literal for the '{@link com.nokia.tools.vct.confml.model.xsd.EFacet <em>EFacet</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.confml.model.xsd.EFacet
		 * @see com.nokia.tools.vct.confml.model.xsd.impl.EXSDFacetPackageImpl#getEFacet()
		 * @generated
		 */
		EClass EFACET = eINSTANCE.getEFacet();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EFACET__VALUE = eINSTANCE.getEFacet_Value();

		/**
		 * The meta object literal for the '<em><b>Fixed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EFACET__FIXED = eINSTANCE.getEFacet_Fixed();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.confml.model.xsd.impl.ENumFacetImpl <em>ENum Facet</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.confml.model.xsd.impl.ENumFacetImpl
		 * @see com.nokia.tools.vct.confml.model.xsd.impl.EXSDFacetPackageImpl#getENumFacet()
		 * @generated
		 */
		EClass ENUM_FACET = eINSTANCE.getENumFacet();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.confml.model.xsd.impl.EMinInclusiveImpl <em>EMin Inclusive</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.confml.model.xsd.impl.EMinInclusiveImpl
		 * @see com.nokia.tools.vct.confml.model.xsd.impl.EXSDFacetPackageImpl#getEMinInclusive()
		 * @generated
		 */
		EClass EMIN_INCLUSIVE = eINSTANCE.getEMinInclusive();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.confml.model.xsd.impl.EMinExclusiveImpl <em>EMin Exclusive</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.confml.model.xsd.impl.EMinExclusiveImpl
		 * @see com.nokia.tools.vct.confml.model.xsd.impl.EXSDFacetPackageImpl#getEMinExclusive()
		 * @generated
		 */
		EClass EMIN_EXCLUSIVE = eINSTANCE.getEMinExclusive();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.confml.model.xsd.impl.EMaxInclusiveImpl <em>EMax Inclusive</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.confml.model.xsd.impl.EMaxInclusiveImpl
		 * @see com.nokia.tools.vct.confml.model.xsd.impl.EXSDFacetPackageImpl#getEMaxInclusive()
		 * @generated
		 */
		EClass EMAX_INCLUSIVE = eINSTANCE.getEMaxInclusive();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.confml.model.xsd.impl.EMaxExclusiveImpl <em>EMax Exclusive</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.confml.model.xsd.impl.EMaxExclusiveImpl
		 * @see com.nokia.tools.vct.confml.model.xsd.impl.EXSDFacetPackageImpl#getEMaxExclusive()
		 * @generated
		 */
		EClass EMAX_EXCLUSIVE = eINSTANCE.getEMaxExclusive();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.confml.model.xsd.impl.ELengthImpl <em>ELength</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.confml.model.xsd.impl.ELengthImpl
		 * @see com.nokia.tools.vct.confml.model.xsd.impl.EXSDFacetPackageImpl#getELength()
		 * @generated
		 */
		EClass ELENGTH = eINSTANCE.getELength();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.confml.model.xsd.impl.EMinLengthImpl <em>EMin Length</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.confml.model.xsd.impl.EMinLengthImpl
		 * @see com.nokia.tools.vct.confml.model.xsd.impl.EXSDFacetPackageImpl#getEMinLength()
		 * @generated
		 */
		EClass EMIN_LENGTH = eINSTANCE.getEMinLength();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.confml.model.xsd.impl.EMaxLengthImpl <em>EMax Length</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.confml.model.xsd.impl.EMaxLengthImpl
		 * @see com.nokia.tools.vct.confml.model.xsd.impl.EXSDFacetPackageImpl#getEMaxLength()
		 * @generated
		 */
		EClass EMAX_LENGTH = eINSTANCE.getEMaxLength();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.confml.model.xsd.impl.ETotalDigitsImpl <em>ETotal Digits</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.confml.model.xsd.impl.ETotalDigitsImpl
		 * @see com.nokia.tools.vct.confml.model.xsd.impl.EXSDFacetPackageImpl#getETotalDigits()
		 * @generated
		 */
		EClass ETOTAL_DIGITS = eINSTANCE.getETotalDigits();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.confml.model.xsd.impl.EPatternImpl <em>EPattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.confml.model.xsd.impl.EPatternImpl
		 * @see com.nokia.tools.vct.confml.model.xsd.impl.EXSDFacetPackageImpl#getEPattern()
		 * @generated
		 */
		EClass EPATTERN = eINSTANCE.getEPattern();

	}

} //EXSDFacetPackage
