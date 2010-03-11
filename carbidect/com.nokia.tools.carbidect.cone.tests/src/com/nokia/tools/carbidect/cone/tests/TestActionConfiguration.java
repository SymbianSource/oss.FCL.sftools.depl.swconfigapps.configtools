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


import java.util.List;

import junit.framework.TestCase;

import com.nokia.tools.carbidect.cone.core.actions.IConeActionArgumentConstants;
import com.nokia.tools.carbidect.cone.core.actions.IConeActionConfiguration;
import com.nokia.tools.carbidect.cone.core.internal.actions.ConeActionConfiguration;
import com.nokia.tools.carbidect.cone.ui.IConeConfigurationConstants;

public class TestActionConfiguration extends TestCase {
	
	private IConeActionConfiguration actionConfiguration;

	@Override
	protected void setUp() throws Exception {
		actionConfiguration = new ConeActionConfiguration();
	}

	public void testConeActionConfigurationUsageBasic() throws Exception {
		assertNotNull(actionConfiguration);
		
		String config = "root.confml";
		actionConfiguration.setConfiguration(config);
		assertEquals(config, actionConfiguration.getConfiguration());
		
		config = "config2.confml";
		actionConfiguration.setConfiguration(config);
		assertEquals(config, actionConfiguration.getConfiguration());

		String cp = "test_project";
		actionConfiguration.setStorage(cp);
		assertEquals("\""+cp+"\"", actionConfiguration.getStorage());

		cp = "test_project2";
		actionConfiguration.setStorage(cp);
		assertEquals("\""+cp+"\"", actionConfiguration.getStorage());
	}
	
	public void testConeActionConfigurationUsageAdvanced() throws Exception {
		String config = "root.confml";
		actionConfiguration.setConfiguration(config);
		assertEquals(config, actionConfiguration.getArgumentValue(IConeActionArgumentConstants.CONFIGURATION));
		
		config = "config2.confml";
		actionConfiguration.setConfiguration(config);
		assertEquals(config, actionConfiguration.getArgumentValue(IConeActionArgumentConstants.CONFIGURATION));
		
		verifyArgumentsContainsArgument(IConeActionArgumentConstants.CONFIGURATION);
		
		String cp = "test_project";
		actionConfiguration.setStorage(cp);
		assertEquals("\""+cp+"\"", actionConfiguration.getArgumentValue(IConeActionArgumentConstants.STORAGE));
		
		cp = "test_project2";
		actionConfiguration.setStorage(cp);
		assertEquals("\""+cp+"\"", actionConfiguration.getArgumentValue(IConeActionArgumentConstants.STORAGE));

		verifyArgumentsContainsArgument(IConeActionArgumentConstants.STORAGE);
	}
	
	public void testConeActionConfigurationEmptyArguments() throws Exception {
		String argument = IConeActionArgumentConstants.HELP;
		actionConfiguration.addArgumentWithNoValue(argument);
		String value = actionConfiguration.getArgumentValue(argument);
		assertEquals(value, null);
		verifyArgumentsContainsArgument(argument);
	}

	public void testConeActionConfigurationWithTargets() throws Exception {
		int targetIndex = IConeConfigurationConstants.ATTR_VALUE_DEFAULT_TARGET;
		actionConfiguration.setTarget(targetIndex);
		verifyArgumentsContainsArgument(IConeActionArgumentConstants.LAYER);
		targetIndex = 0;
		actionConfiguration.setTarget(targetIndex);
		verifyArgumentsContainsArgument(IConeActionArgumentConstants.ALL_LAYERS);
	}

	private void verifyArgumentsContainsArgument(String argument) {
		List<String> arguments = actionConfiguration.parseArguments();
		boolean contains = false;
		for (String arg: arguments) {
			if(arg.contains(argument)) {
				contains = true;
			}
		}
		assertTrue("Argument not found in the arguments list!: "+argument,contains);
	}
}
