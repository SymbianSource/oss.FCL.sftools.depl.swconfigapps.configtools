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

package parserTests;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

public class TestAll extends TestSuite {
	public static void main(String[] args) {
		TestRunner.run(suite());
	}
	public static Test suite() {
		TestSuite suite = new TestAll("Parser Tests");
		suite.addTestSuite(TestFeatureRefConnector.class);
		return suite;
	}
	public TestAll(String name) {
		super(name);
	}
}
