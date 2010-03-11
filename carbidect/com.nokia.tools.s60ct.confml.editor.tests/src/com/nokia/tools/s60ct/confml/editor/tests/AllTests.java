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

package com.nokia.tools.s60ct.confml.editor.tests;

import com.nokia.tools.s60ct.model.confml.tests.S60ct_confmlAllTests;
import com.nokia.tools.vct.confml.tests.ConfMLAllTests;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {
	public static Test suite() {
		TestSuite suite = new TestSuite(
				"Test for Carbide.ct code");
		//$JUnit-BEGIN$
		
		// tests for ConfML model
		suite.addTest(ConfMLAllTests.suite());
		
		// tests for Application2EditorModel converter
		suite.addTestSuite(VEModel2Confml1PMConverterTest.class);
		suite.addTestSuite(VEModel2Confml2PMConverterTest.class);
		suite.addTestSuite(AppModel2EditorModelConverterTest.class);
		
		//tests for ConfML feature editor model
		suite.addTest(S60ct_confmlAllTests.suite());
		
		//java version checker
		suite.addTest(com.nokia.tools.s60ct.javaversionchecker.test.AllTests.suite());

		//refactoring tests
		suite.addTest(com.nokia.tools.carbide.ct.refactoring.tests.AllTests.suite());

		//variant.confml tests
		suite.addTest(com.nokia.tools.variant.confml.tests.AllTests.suite());

		//Test for Carbide.ct ConE integration
		suite.addTest(com.nokia.tools.carbidect.cone.tests.AllTests.suite());
		//$JUnit-END$
		return suite;
	}
}
