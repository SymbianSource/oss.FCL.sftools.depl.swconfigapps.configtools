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
 * Description: This file is part of com.nokia.tools.vct.common.confml.expressions.tests component.
 */

package com.nokia.tools.vct.confml.expressions.confml.grammar.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

public class ConstrainAndRelevantTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(
				"Test for constrains and relevants");
		suite.addTestSuite(SimpleTest.class);
		suite.addTestSuite(SequenceSettingTest.class);
		return suite;
	}

}
