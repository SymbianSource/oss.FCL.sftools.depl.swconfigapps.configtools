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

package com.nokia.tools.vct.confml.tests;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

import com.nokia.tools.vct.confml.model.confml1.include.tests.EConfMLIncludeTests;
import com.nokia.tools.vct.confml.model.confml1.tests.EConfML1Tests;
import com.nokia.tools.vct.confml.model.confml2.tests.EConfML2Tests;
import com.nokia.tools.vct.confml.model.metaext.tests.EMetaExtTests;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>ConfML1</b></em>' model.
 * <!-- end-user-doc -->
 * @generated
 */
public class ConfMLAllTests extends TestSuite {

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
		TestSuite suite = new ConfMLAllTests("ConfML Model All Tests");
		suite.addTest(EConfML1Tests.suite());
		suite.addTest(EConfML2Tests.suite());
		suite.addTest(EConfMLIncludeTests.suite());
		suite.addTest(EMetaExtTests.suite());
		suite.addTest(EMetaExtTests.suite());
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfMLAllTests(String name) {
		super(name);
	}

} //ConfML1AllTests
