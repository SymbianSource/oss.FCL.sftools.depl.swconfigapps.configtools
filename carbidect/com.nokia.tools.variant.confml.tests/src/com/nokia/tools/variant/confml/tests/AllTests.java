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

package com.nokia.tools.variant.confml.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {
	public static Test suite() {
		TestSuite suite = new TestSuite(
				"Test for Variant ConfML plugins");
		//$JUnit-BEGIN$
		//suite.addTest(ConfMLAllTests.suite());
		
		suite.addTestSuite(ConfMLUtilTest.class);
		
		//$JUnit-END$
		return suite;
	}
}
