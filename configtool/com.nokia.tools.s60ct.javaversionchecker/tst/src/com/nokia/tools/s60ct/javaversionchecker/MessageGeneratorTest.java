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
package com.nokia.tools.s60ct.javaversionchecker;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 *
 */
public class MessageGeneratorTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.nokia.tools.s60ct.javaversionchecker.MessageGenerator#generateMessage()}.
	 */
	@Test
	public void testGenerateMessage() {
		assertNotNull("Null not expected", MessageGenerator.generateMessage());
		assertTrue("Zero size not expected", MessageGenerator.generateMessage().length() > 0);
	}

	/**
	 * Test method for {@link com.nokia.tools.s60ct.javaversionchecker.MessageGenerator#generateTitle()}.
	 */
	@Test
	public void testGenerateTitle() {
		assertNotNull("Null not expected", MessageGenerator.generateTitle());
	}

}
