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

package parserTests;

import junit.framework.TestCase;
import configurationemf.ConfigurationemfFactory;
import configurationemf.Data;
import configurationemf.Feature;
import configurationemf.ParentSetting;
import configurationemf.Ref;
import configurationemf.Rfs;
import configurationemf.RootConf;
import configurationemf.util.FeatureRefConnector;
import configurationemf.util.FeatureRefConnector.SettingNotFound;

public class TestFeatureRefConnector extends TestCase {
	ConfigurationemfFactory factory = ConfigurationemfFactory.eINSTANCE;
	RootConf conf=null;
	FeatureRefConnector connector=null;
	@Override
	protected void setUp() throws Exception {
		conf = ConfigurationemfFactory.eINSTANCE.createRootConf();
		connector = new FeatureRefConnector(conf);
		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		conf=null;
		connector=null;
		super.tearDown();
	}

	public void testConnectEmptyConfiguration(){
		connector.connectData();
		try{
			connector.connectRfs();
		}catch(SettingNotFound e){
			fail("Exception, but nothing to be connected");
		}
	}
	
	public void testConnectSingleSetting(){
		Feature f1 = factory.createFeature();
		f1.setRef("f1");
		ParentSetting s1 = factory.createParentSetting();
		s1.setRef("s1");
		f1.getParentSetting().add(s1);
		
		Data data = factory.createData();
		Ref r1=createRef("f1");
		Ref r2=createRef("s1");
		r2.setValue("val");
		r1.getRef().add(r2);
		data.getRef().add(r1);
		
		conf.setData(data);
		conf.getFeature().add(f1);
		connector.connectData();
		assertEquals(1, f1.getRefs().size());
		assertEquals(r1, f1.getRefs().get(0));
		assertEquals(1, s1.getRefs().size());
		assertEquals(r2, s1.getRefs().get(0));
		assertEquals("val", s1.getCurrentValue());
	}
	
	public void testConnectRfs(){
		Rfs rfs = ConfigurationemfFactory.eINSTANCE.createRfs();
		Ref ref1 = createRef("ref1");
		Ref ref2 = createRef("ref2");
		ref2.setValue(Boolean.toString(true));
		ref1.getRef().add(ref2);
		rfs.getRef().add(ref1);
		conf.setRfs(rfs);
		
		try{
			connector.reset();
			connector.connectRfs();
			fail("Exception not thrown, empty configuration");
		}catch(SettingNotFound e){
		}
		
		Feature fea = ConfigurationemfFactory.eINSTANCE.createFeature();
		conf.getFeature().add(fea);
		assertEquals(false, conf.getFeature().isEmpty());
		ParentSetting setting = ConfigurationemfFactory.eINSTANCE.createParentSetting();
		fea.setRef("ref1");
		setting.setRef("ref2");
		fea.getParentSetting().add(setting);
		try{
			connector.reset();
			connector.connectRfs();
		}catch(SettingNotFound e){
			fail("Exception, but everything is ok!");
		}
		assertEquals(true,setting.isRfs());
	}

	
	
	private Ref createRef(String name) {
		Ref ref2 = ConfigurationemfFactory.eINSTANCE.createRef();
		ref2.setName(name);
		return ref2;
	}
}
