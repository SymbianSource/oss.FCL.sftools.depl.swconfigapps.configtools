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

package com.nokia.tools.s60ct.javaversionchecker.test;


import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {
	public static Test suite() {
		TestSuite suite = new TestSuite(
				"Test for com.nokia.tools.s60ct.javaversionchecker.tests");
		//$JUnit-BEGIN$
		suite.addTestSuite(JavaVersionCheckerTest.class);
		suite.addTestSuite(MessageGeneratorTest.class);
		//$JUnit-END$
		return suite;
	}
}
