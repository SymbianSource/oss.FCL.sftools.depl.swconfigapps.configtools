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
import java.io.File;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;

import com.nokia.tools.carbidect.cone.core.actions.IConeActionArgumentConstants;
import com.nokia.tools.carbidect.cone.core.actions.IConeActionConfiguration;
import com.nokia.tools.carbidect.cone.core.internal.actions.GenerateAction;

public class TestGenerateAction extends TestConeAction {

	public TestGenerateAction(String name) {
		super(name);
	}

	@Override
	protected void setUp() throws Exception {
		setFixture(new GenerateAction());
	}

	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}
		
	public void testActionName() throws Exception {
		assertName(GenerateAction.ACTION_NAME);
	}
	
	public void testRunningGenerateActionHelp() throws Exception {
		GenerateAction generate = (GenerateAction) getFixture();
		IConeActionConfiguration actionConfig = generate.getActionConfigiration();
		actionConfig.addArgumentWithNoValue(IConeActionArgumentConstants.HELP);
		
				
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		generate.run(baos, null);
		byte[] coneBytes = "Running action generate".getBytes();
		byte[] bytes = baos.toByteArray();
		assertTrue(bytes.length!=0);
		for (int i = 0; i < coneBytes.length; i++) {
			assertEquals(coneBytes[i], bytes[i]);
		}
	}
	
	public void testRunningGenerateActionOnTestProject() throws Exception {
		IProject project = getWorkspaceTestProject();
		File log = new File(TESTDATA_FOLDER + File.separator + "cone.log");
		File output = new File(TESTDATA_FOLDER + File.separator + "output");
		assertNotNull("No test project found on workspace!",project);
		
		String config = "root.confml";
		IPath projectLoc = project.getLocation();
		GenerateAction generate = (GenerateAction) getFixture();
		IConeActionConfiguration actionConfig = generate.getActionConfigiration();
		
		actionConfig.setStorage(projectLoc.toOSString());
		actionConfig.setConfiguration(config);
		
		actionConfig.setArgumentValue(IConeActionArgumentConstants.OUTPUT_FOLDER, output.getAbsolutePath());
		actionConfig.setArgumentValue(IConeActionArgumentConstants.LOG_FILE, log.getAbsolutePath());
		generate.run(null, null);
		
		assertTrue(log.exists());
		assertTrue(output.exists());
		String[] files = output.list();
		
		assertTrue("Generation output file is empty!",files.length!=0);
	}
}
