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

package com.nokia.tools.vct.confml.model.confml2.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>confml2</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class EConfML2Tests extends TestSuite {

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
	 * @generated
	 */
	public static Test suite() {
		TestSuite suite = new EConfML2Tests("confml2 Tests");
		suite.addTestSuite(EConfigurationElementTest.class);
		suite.addTestSuite(EFeatureElementTest.class);
		suite.addTestSuite(ESettingElementTest.class);
		suite.addTestSuite(ESettingDataTest.class);
		suite.addTestSuite(EViewElementTest.class);
		suite.addTestSuite(EGroupTest.class);
		suite.addTestSuite(EMetaElementTest.class);
		suite.addTestSuite(EOptionElementTest.class);
		suite.addTestSuite(EPropertyElementTest.class);
		suite.addTestSuite(ELocalPathElementTest.class);
		suite.addTestSuite(ETargetPathElementTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EConfML2Tests(String name) {
		super(name);
	}

} //EConfML2Tests
