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
package com.nokia.tools.s60ct.build.crml;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import org.junit.Before;
import org.junit.Test;

import com.nokia.tools.s60ct.build.builder.CrmlBuilder;
import com.nokia.tools.variant.confml.core.model.application.EConfigurationProject;


public class TestCrmlBuilder extends CrmlBuilder{
	
	private EConfigurationProject cpMock;

	@Before
	public void before() throws Exception {
		cpMock = createMock(EConfigurationProject.class);
	}
	
	@Test
	public void testInitializeBuild() throws Exception {
		expect(cpMock.getLayers()).andReturn(null);
		replay(cpMock);
		try {
			build(1, null, null);						
		} catch (ExceptionInInitializerError expected) {}
		catch (NullPointerException expected) {}
		verify(cpMock);
	}
	
	/**
	 * @return a mock configuration project instead of real configuration project
	 */
	protected EConfigurationProject getConfigurationProject() {
		return cpMock;
	}
}
