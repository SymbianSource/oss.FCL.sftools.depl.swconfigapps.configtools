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
package configurationemf.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>configurationemf</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class ConfigurationemfTests extends TestSuite {

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
		TestSuite suite = new ConfigurationemfTests("configurationemf Tests");
		suite.addTestSuite(FeatureTest.class);
		suite.addTestSuite(ViewTest.class);
		suite.addTestSuite(OptionTest.class);
		suite.addTestSuite(GSettingTest.class);
		suite.addTestSuite(LeafSettingTest.class);
		suite.addTestSuite(ParentSettingTest.class);
		suite.addTestSuite(LeafGroupTest.class);
		suite.addTestSuite(ParentGroupTest.class);
		suite.addTestSuite(RootConfTest.class);
		suite.addTestSuite(SubConfTest.class);
		suite.addTestSuite(RefTest.class);
		suite.addTestSuite(FrameTest.class);
		suite.addTestSuite(LeafSettingDelegatorTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigurationemfTests(String name) {
		super(name);
	}

} //ConfigurationemfTests
