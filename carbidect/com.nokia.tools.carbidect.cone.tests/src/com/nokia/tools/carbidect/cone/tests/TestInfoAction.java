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

package com.nokia.tools.carbidect.cone.tests;


import java.io.ByteArrayOutputStream;

import com.nokia.tools.carbidect.cone.core.actions.IConeActionArgumentConstants;
import com.nokia.tools.carbidect.cone.core.actions.IConeActionConfiguration;
import com.nokia.tools.carbidect.cone.core.internal.actions.InfoAction;

public class TestInfoAction extends TestConeAction {

	public TestInfoAction(String name) {
		super(name);
	}

	@Override
	protected void setUp() throws Exception {
		setFixture(new InfoAction());
	}

	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}
		
	public void testActionName() throws Exception {
		assertName(InfoAction.ACTION_NAME);
	}
	
	public void testRunningInfoActionHelp() throws Exception {
		InfoAction validate = (InfoAction) getFixture();
		IConeActionConfiguration actionConfig = validate.getActionConfigiration();
		actionConfig.addArgumentWithNoValue(IConeActionArgumentConstants.HELP);
		
				
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		validate.run(baos, null);
		byte[] coneBytes = "Running action info".getBytes();
		byte[] bytes = baos.toByteArray();
		assertTrue(bytes.length!=0);
		for (int i = 0; i < coneBytes.length; i++) {
			assertEquals(coneBytes[i], bytes[i]);
		}
	}	
}
