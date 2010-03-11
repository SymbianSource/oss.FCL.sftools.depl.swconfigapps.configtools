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


import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;

import junit.framework.TestCase;

import com.nokia.tools.carbidect.cone.core.actions.IConeAction;
import com.nokia.tools.carbidect.cone.core.actions.IConeActionConfiguration;

public abstract class TestConeAction extends TestCase {
	public final String TESTDATA_FOLDER = "testdata";
	
	protected IConeAction fixture = null;


	public TestConeAction(String name) {
		super(name);
	}

	protected void setFixture(IConeAction fixture) {
		this.fixture = fixture;
	}
	
	protected IConeAction getFixture() {
		return fixture;
	}
	
	protected void assertName(String expected) {
		assertEquals(expected, getFixture().getActionName());
	}
	
	public void testActionConfiguration() throws Exception {
		IConeActionConfiguration actionConfigiration = getFixture().getActionConfigiration();
		assertNotNull(actionConfigiration);
	}
	
	public void testUsedConeTool() throws Exception {
		IConeAction action = getFixture();
		String pathToConeCmd = "c:\\apps\\cone\\cone.cmd";
		action.setUsedConeTool(pathToConeCmd);
		assertEquals(pathToConeCmd, action.getUsedConeTool());
	}
	
	protected IProject getWorkspaceTestProject() {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot root = workspace.getRoot();
		IProject[] projects = root.getProjects();
		return (projects.length==0) ? null:projects[0];
	}
}
