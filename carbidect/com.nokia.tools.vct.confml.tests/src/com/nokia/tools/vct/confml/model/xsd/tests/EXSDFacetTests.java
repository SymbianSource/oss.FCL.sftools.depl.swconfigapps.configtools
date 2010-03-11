/*
* Copyright (c) 2008 Nokia Corporation and/or its subsidiary(-ies).
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

package com.nokia.tools.vct.confml.model.xsd.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>xsd</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class EXSDFacetTests extends TestSuite {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static Test suite() {
		TestSuite suite = new EXSDFacetTests("xsd Tests");
		suite.addTestSuite(EFacetTest.class);
		suite.addTestSuite(ELengthTest.class);
		suite.addTestSuite(EMaxExclusiveTest.class);
		suite.addTestSuite(EMaxInclusiveTest.class);
		suite.addTestSuite(EMinExclusiveTest.class);
		suite.addTestSuite(EMinExclusiveTest.class);
		suite.addTestSuite(EMaxLengthTest.class);
		suite.addTestSuite(EMinLengthTest.class);
		suite.addTestSuite(ENumFacetTest.class);
		suite.addTestSuite(EPatternTest.class);
		suite.addTestSuite(ETotalDigitsTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EXSDFacetTests(String name) {
		super(name);
	}

} //EXSDFacetTests
