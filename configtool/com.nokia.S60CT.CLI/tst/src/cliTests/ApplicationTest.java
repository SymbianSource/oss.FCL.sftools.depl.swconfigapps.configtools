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

package cliTests;

import java.util.HashMap;
import java.util.Map;

import org.easymock.EasyMock;
import org.eclipse.equinox.app.IApplicationContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import variantdata.VariantData;

import com.nokia.s60ct.cli.Application;
import com.nokia.s60ct.cli.IResourceManager;

import configurationemf.RootConf;
import configurationemf.util.IVariantDataManager;

public class ApplicationTest {
	Application app = null;
	
	
	@Before
	public void setUp() throws Exception {
		app= new Application();
	}

	@After
	public void tearDown() throws Exception {
		app = null;
	}

	@Test
	public void vdsTest() throws Exception {
		
		String confPath = "s60.confml";
		String vdPath = "vd.xml";
		IApplicationContext context = createStubContext(new String[]{
				"-master",confPath,"-vds",vdPath
		});
		RootConf rootCong = EasyMock.createMock(RootConf.class); 
		VariantData vd = EasyMock.createMock(VariantData.class);
		Map vdMap = EasyMock.createMock(Map.class);
		IResourceManager resourceManager = EasyMock.createMock(IResourceManager.class);
		EasyMock.expect(resourceManager.readResource(confPath)).andReturn(rootCong);
		EasyMock.expect(resourceManager.readResource(vdPath)).andReturn(vd);
		
		IVariantDataManager vdmanager = EasyMock.createMock(IVariantDataManager.class);
		EasyMock.expect(vdmanager.getSingleVDMap(vd)).andReturn(vdMap);
		EasyMock.expect(vdmanager.importValues(rootCong, vdMap, new HashMap())).andReturn(null);
		EasyMock.replay(resourceManager,vdmanager);
		
		app.setVariantDataManager(vdmanager);
		app.setResourceManager(resourceManager);
		app.start(context);
		
		EasyMock.verify(resourceManager,vdmanager);
		
	}

	@Test
	public void vdcTest() throws Exception {
		
		String confPath = "s60.confml";
		String vdPath = "vd.xml";
		IApplicationContext context = createStubContext(new String[]{
				"-master",confPath,"-vdc",vdPath
		});
		RootConf rootCong = EasyMock.createMock(RootConf.class); 
		VariantData vd = EasyMock.createMock(VariantData.class);
		Map vdMap = EasyMock.createMock(Map.class);
		IResourceManager resourceManager = EasyMock.createMock(IResourceManager.class);
		EasyMock.expect(resourceManager.readResource(confPath)).andReturn(rootCong);
		EasyMock.expect(resourceManager.readResource(vdPath)).andReturn(vd);
		
		IVariantDataManager vdmanager = EasyMock.createMock(IVariantDataManager.class);
		EasyMock.expect(vdmanager.getChainVDMap(vd)).andReturn(vdMap);
		EasyMock.expect(vdmanager.importValues(rootCong, vdMap, new HashMap())).andReturn(null);
		EasyMock.replay(resourceManager,vdmanager);
		
		app.setVariantDataManager(vdmanager);
		app.setResourceManager(resourceManager);
		app.start(context);
		
		EasyMock.verify(resourceManager,vdmanager);
		
	}
	
	@Test
	public void vdcSaveTest() throws Exception {
		
		String confPath = "s60.confml";
		String vdPath = "vd.xml";
		IApplicationContext context = createStubContext(new String[]{
				"-master",confPath,"-vdc","-save",vdPath,
		});
		RootConf rootCong = EasyMock.createMock(RootConf.class); 
		VariantData vd = EasyMock.createMock(VariantData.class);
		Map vdMap = EasyMock.createMock(Map.class);
		IResourceManager resourceManager = EasyMock.createMock(IResourceManager.class);
		EasyMock.expect(resourceManager.readResource(confPath)).andReturn(rootCong);
		EasyMock.expect(resourceManager.readResource(vdPath)).andReturn(vd);
		resourceManager.save(rootCong,null);
		
		IVariantDataManager vdmanager = EasyMock.createMock(IVariantDataManager.class);
		EasyMock.expect(vdmanager.getChainVDMap(vd)).andReturn(vdMap);
		EasyMock.expect(vdmanager.importValues(rootCong, vdMap, null)).andReturn(null);
		EasyMock.replay(resourceManager,vdmanager);
		
		app.setVariantDataManager(vdmanager);
		app.setResourceManager(resourceManager);
		app.start(context);
		
		EasyMock.verify(resourceManager,vdmanager);
		
	}
	
	@Test
	public void vdsSaveTest() throws Exception {
		
		String confPath = "s60.confml";
		String vdPath = "vd.xml";
		IApplicationContext context = createStubContext(new String[]{
				"-master",confPath,"-vds","-save",vdPath
		});
		RootConf rootCong = EasyMock.createMock(RootConf.class); 
		VariantData vd = EasyMock.createMock(VariantData.class);
		Map vdMap = EasyMock.createMock(Map.class);
		IResourceManager resourceManager = EasyMock.createMock(IResourceManager.class);
		EasyMock.expect(resourceManager.readResource(confPath)).andReturn(rootCong);
		EasyMock.expect(resourceManager.readResource(vdPath)).andReturn(vd);
		resourceManager.save(rootCong,null);
		
		IVariantDataManager vdmanager = EasyMock.createMock(IVariantDataManager.class);
		EasyMock.expect(vdmanager.getSingleVDMap(vd)).andReturn(vdMap);
		EasyMock.expect(vdmanager.importValues(rootCong, vdMap, null)).andReturn(null);
		EasyMock.replay(resourceManager,vdmanager);
		
		app.setVariantDataManager(vdmanager);
		app.setResourceManager(resourceManager);
		app.start(context);
		
		EasyMock.verify(resourceManager,vdmanager);
		
	}
	
	private IApplicationContext createStubContext(String[] argArray) {
		IApplicationContext context = EasyMock.createMock(IApplicationContext.class);

		Map<String,String[]> args = new HashMap<String, String[]>();
		args.put("application.args", argArray);
		EasyMock.expect(context.getArguments()).andStubReturn(args);
		EasyMock.replay(context);
		return context;
	}
	
}
