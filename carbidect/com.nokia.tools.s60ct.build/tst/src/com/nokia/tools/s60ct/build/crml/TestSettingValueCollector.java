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
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.nokia.tools.s60ct.build.builder.utils.ISettingCollector;
import com.nokia.tools.s60ct.build.builder.utils.SettingAndLayer;
import com.nokia.tools.s60ct.build.builder.utils.SettingValueCollector;
import com.nokia.tools.variant.confml.core.model.application.EConfMLLayer;
import com.nokia.tools.variant.confml.core.model.application.EConfigurationProject;


public class TestSettingValueCollector {

	
	private ISettingCollector settingCollector;                // class under test
	private EConfigurationProject configurationProjectMock;    // collaborator
	private SettingAndLayer settingAndLayer;
	
	@Before
	public void before() throws Exception {
		settingCollector = SettingValueCollector.getInstance();
	}
	
	@Test
	public void testNoConfigurationProject() throws Exception {
		settingAndLayer = settingCollector.getSetting(configurationProjectMock, "f1/s1");
		assertNotNull(settingAndLayer);
		assertNull(settingAndLayer.getSetting());
		assertNull(settingAndLayer.getLayer());
	}
	
	@Test
	public void testLayersRequested() throws Exception {
		createCPMock();
		expect(configurationProjectMock.getLastLayer()).andReturn(null); //expected behaviour
		replay(configurationProjectMock);   // switch to replay state
		getSettingNullPointerExpected();
		verify(configurationProjectMock);
	}

	@Test
	public void testLayerFeatureRequested() throws Exception {
		createCPMock();
		EConfMLLayer layerMock = createMock(EConfMLLayer.class);
		expect(configurationProjectMock.getLastLayer()).andReturn(layerMock); //expected behaviour
		expect(layerMock.getFeatures()).andReturn(null);
		replay(configurationProjectMock);   // switch to replay state
		getSettingNullPointerExpected();
		verify(configurationProjectMock);
		
	}

	private void createCPMock() {
		configurationProjectMock = createMock(EConfigurationProject.class);
	}

	private void getSettingNullPointerExpected() {
		try {
			settingAndLayer = settingCollector.getSetting(configurationProjectMock, "f1/s1");
			fail("Expected nullpointer exception did not occur!");
		} catch(NullPointerException expected) {}
	}
	
}
