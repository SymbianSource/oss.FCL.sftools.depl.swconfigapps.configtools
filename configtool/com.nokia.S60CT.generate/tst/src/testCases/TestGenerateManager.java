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

package testCases;

import java.util.Map;

import junit.framework.Assert;
import junit.framework.TestCase;
import mocks.PluginInitMock;
import mocks.RootConfMock;
import mocks.SettingMock;

import com.nokia.s60ct.generate.GenerateManager;

public class TestGenerateManager extends TestCase {

	GenerateManager manager=null;
	PluginInitMock pluginInit=null;
	
	@Override
	protected void setUp() throws Exception {
		pluginInit=new PluginInitMock();
		
		
	}

	@Override
	protected void tearDown() throws Exception {
		pluginInit=null;
		manager=null;
	}

	public void testGenerateAll(){
		RootConfMock rootConf= new RootConfMock();
		manager = new GenerateManager(rootConf,pluginInit);
		Assert.assertTrue("Not empty result.",manager.getRefValue().isEmpty());
		
		final String ref="ref";
		final String value="value";
		
		rootConf.getAllSettings().add(new SettingMock(ref,value,rootConf));
		if(manager.getRefValue().isEmpty())fail("Result should not be empty!");
		Map<String, Object>refValue=manager.getRefValue();
		Assert.assertTrue("Result does not contain ref",refValue.containsKey(ref));
		Assert.assertEquals(value,refValue.get(ref));
		
		ContentCreatorMock pluginMock = new ContentCreatorMock(); 
		pluginInit.addMockPlugin(pluginMock);
		manager.generateAll();
		
		Assert.assertTrue("Plugins' values was not set",pluginMock.isValueSet());
		Assert.assertTrue("Plugins' content was not generated",pluginMock.isGenerated());
		Assert.assertTrue("Plugins' content was not saved",pluginMock.isContentSaved());
	}
	
	public void testDeveloperCase(){
		RootConfMock rootConf= new RootConfMock();
		manager = new GenerateManager(rootConf,pluginInit);
		
		String ref = "ref";
		String value = "value";
		rootConf.getAllSettings().add(new SettingMock(ref,value,rootConf));
		Map<String, Object> result = manager.getRefValue();
		assertTrue(result!=null&&result.size()==2);
		for(String key : result.keySet()){
			if(key.indexOf("@RFS@")!=-1){
				assertEquals(",0,"+"@RFS@"+ref, key);
			}else{
				assertEquals(",0,"+ref, key);
			}
		}
	}
	
	public void testSingleMasterFileCase(){
		String ref = "ref";
		String value = "value";
		String confName = "confName";
		
		RootConfMock masterFile = new RootConfMock(confName);
		RootConfMock basedOn = new RootConfMock(masterFile,1);
		masterFile.getAllSettings().add(new SettingMock(ref,value,masterFile));
		
		manager = new GenerateManager(masterFile,pluginInit);
		Map<String, Object> result = manager.getRefValue();
		assertTrue(result!=null&&result.size()==2);
		for(String key : result.keySet()){
			if(key.indexOf("@RFS@")!=-1){
				assertEquals(confName+",0,"+"@RFS@"+ref, key);
			}else{
				assertEquals(confName+",0,"+ref, key);
			}
		}

	}
	
	public void testMutiMasterFileCase(){
		String ref = "ref";
		String value = "value";
		
		String ref1 = "ref1";
		String value1 = "value1";
		
		String foo = "foo";
		String bar = "bar";
		
		RootConfMock masterFile = new RootConfMock(bar);
		RootConfMock basedOn1 = new RootConfMock(foo,masterFile,1);
		RootConfMock basedOn11 = new RootConfMock(basedOn1,1);
		
		masterFile.getAllSettings().add(new SettingMock(ref,value,basedOn1));
		masterFile.getAllSettings().add(new SettingMock(ref1,value1,masterFile));
		
		manager = new GenerateManager(masterFile,pluginInit);
		Map<String, Object> result = manager.getRefValue();
		assertTrue(result!=null&&result.size()==4);
		for(String key : result.keySet()){
			if(key.indexOf(ref1)!=-1){
				if(key.indexOf("@RFS@")!=-1){
					assertEquals(bar+",0,"+"@RFS@"+ref1, key);
				}else{
					assertEquals(bar+",0,"+ref1, key);
				}
			}else{
				if(key.indexOf("@RFS@")!=-1){
					assertEquals(foo+",1,"+"@RFS@"+ref, key);
				}else{
					assertEquals(foo+",1,"+ref, key);
				}
			}
		}
	}
}
