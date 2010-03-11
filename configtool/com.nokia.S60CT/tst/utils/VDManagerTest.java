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
package utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import junit.framework.Assert;
import junit.framework.JUnit4TestAdapter;

import org.easymock.EasyMock;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import variantdata.VariantData;
import configurationemf.Ref;
import configurationemf.RootConf;
import configurationemf.Setting;
import configurationemf.util.IVariantDataManager;
import configurationemf.util.VariantDataManager;

public class VDManagerTest {
	IVariantDataManager manager = null;

	
	public static junit.framework.Test suite(){
		return new JUnit4TestAdapter(VDManagerTest.class);
	}
	
	@Before
	public void setUp(){
		manager = new VariantDataManager();
	}
	
	@After
	public void tearDown(){
		manager = null;
	}
	
	@Test
	public void getMapSimpleTest() throws Exception {
		VariantData vd = createVDMock(new String[][]{
				new String[]{"f","s","value"},
		});
		Map<String, String> map = manager.getSingleVDMap(vd);
		Assert.assertNotNull(map);
		Assert.assertEquals("value",map.get("f/s"));
	}
	
	@Test
	public void getMapComplexTest() throws Exception {
		VariantData vd = createVDMock(new String[][]{
				new String[]{"f","s","0"},
				new String[]{"f","s1","1"},
				new String[]{"f1","s","2"},
		});
		Map<String, String> map = manager.getSingleVDMap(vd);
		Assert.assertNotNull(map);
		Assert.assertEquals("0",map.get("f/s"));
		Assert.assertEquals("1",map.get("f/s1"));
		Assert.assertEquals("2",map.get("f1/s"));
	}
	@Test
	public void singleVdImportSimpleTest() throws Exception {
		RootConf rootConf = EasyMock.createMock(RootConf.class);
		Setting[] settings = createSettingMocks(rootConf,new String[][]{
				// ref, expected value
				new String[]{"f/s","value"},
				new String[]{"f/s1","value1"}
		},true);
		
		VariantData vd = createVDMock(new String[][]{
				new String[]{"f","s","value"},
				new String[]{"f","s1","value1"},
		});
		Set<String> nfRefs = manager.importValues(rootConf,manager.getSingleVDMap(vd),null);
		EasyMock.verify(settings);
		Assert.assertTrue(nfRefs.isEmpty());
	}
	
	@Test
	public void singleVDImportSettingNFTest() throws Exception {
		RootConf rootConf = EasyMock.createMock(RootConf.class);
		Setting[] settings = createSettingMocks(rootConf,new String[][]{
				// ref, expected value, calls
				new String[]{"f/s","value"}	
		},false);
		VariantData vd = createVDMock(new String[][]{
				new String[]{"f","s1","value"},
		});
		Set<String> nfRefs = manager.importValues(rootConf,manager.getSingleVDMap(vd),null);
		Assert.assertTrue(nfRefs.contains("f/s1"));
		EasyMock.verify(settings);
	}
	
	
	@Test
	public void bitmaskDecTest() throws Exception {
		RootConf rootConf = EasyMock.createMock(RootConf.class);
		Setting[] settings = createSettingMocks(rootConf,new String[][]{
				// ref, expected value, calls
				new String[]{"f/s_bit1","true"},
				new String[]{"f/s_bit2","false"}
		},true);
		VariantData vd = createVDMock(new String[][]{
				new String[]{"f","s","1"},
		});
		Set<String> nfRefs = manager.importValues(rootConf,manager.getSingleVDMap(vd),null);
		EasyMock.verify(settings);
		Assert.assertTrue(nfRefs.isEmpty());
	}
	
	@Test
	public void bitmaskHexTest() throws Exception {
		RootConf rootConf = EasyMock.createMock(RootConf.class);
		Setting[] settings = createSettingMocks(rootConf,new String[][]{
				// ref, expected value, calls
				new String[]{"f/s_hex_bit1","false"},
				new String[]{"f/s_hex_bit2","true"}
		},true);
		VariantData vd = createVDMock(new String[][]{
				new String[]{"f","s","A"},
		});
		Set<String> nfRefs = manager.importValues(rootConf,manager.getSingleVDMap(vd),null);
		EasyMock.verify(settings);
		Assert.assertTrue(nfRefs.isEmpty());
	}
	
	@Test
	public void importChainTest() throws Exception {
		VariantData vd1 = createVDMock(new String[][]{
				new String[]{"f","s","1"},
		});
		VariantData vd2 = createVDMock(new String[][]{
				new String[]{"f","s1","2"},
		});
		
		vd2.getInclude().add(vd1);
		
		RootConf rootConf = EasyMock.createMock(RootConf.class);
		Setting[] settings = createSettingMocks(rootConf,new String[][]{
				// ref, expected value, calls
				new String[]{"f/s","1"},
				new String[]{"f/s1","2"}
		},true);
		
		Set<String> nfRefs = manager.importValues(rootConf,manager.getChainVDMap(vd2),null);
		EasyMock.verify(settings);
		Assert.assertTrue(nfRefs.isEmpty());
	}
	
	@Test
	public void importChainWhenDataInLeafVDOnlyTest() throws Exception {
		VariantData vd1 = createVDMock(new String[][]{
				new String[]{"f","s","1"},
		});
		VariantData vd2 = createVDMock(new String[][]{
				new String[]{"f","s1","2"},
		});
		
		vd2.getInclude().add(vd1);
		
		RootConf rootConf = EasyMock.createMock(RootConf.class);
		Setting[] settings = createSettingMocks(rootConf,new String[][]{
				// ref, expected value, calls
				new String[]{"f/s","1"},
		},true);
		
		Set<String> nfRefs = manager.importValues(rootConf,manager.getChainVDMap(vd2),null);
		EasyMock.verify(settings);
		Assert.assertTrue(nfRefs.contains("f/s1"));
	}
	
	
	@Test
	public void getChaintVDMapTest() throws Exception {
		VariantData vd1 = createVDMock(new String[][]{
				new String[]{"f","s","1"},
		});
		VariantData vd2 = createVDMock(new String[][]{
				new String[]{"f","s1","2"},
		});
		vd2.getInclude().add(vd1);
		Map<String, String> map = manager.getChainVDMap(vd2);
		Assert.assertTrue(map.keySet().size()==2);
		Assert.assertEquals("1", map.get("f/s"));
		Assert.assertEquals("2", map.get("f/s1"));
	}
	
	@Test
	public void getChaintVDMapOverLapTest() throws Exception {
		VariantData vd1 = createVDMock(new String[][]{
				new String[]{"f","s","1"},
		});
		VariantData vd2 = createVDMock(new String[][]{
				new String[]{"f","s","2"},
		});
		vd2.getInclude().add(vd1);
		Map<String, String> map = manager.getChainVDMap(vd2);
		Assert.assertTrue(map.keySet().size()==1);
		Assert.assertEquals("2", map.get("f/s"));
	}
	
	@Test
	public void importVDandSaveChangesToMap() throws Exception {
		RootConf rootConf = EasyMock.createMock(RootConf.class);
		Setting[] settings = createSettingMocks(rootConf,new String[][]{
				// ref, expected value, calls
				new String[]{"f/s","value"}	
		},false);
		VariantData vd = createVDMock(new String[][]{
				new String[]{"f","s","value"},
		});
		Map<Setting, Object> map = new HashMap<Setting, Object>();
		manager.importValues(rootConf,manager.getSingleVDMap(vd),map);
		Assert.assertEquals("value",map.get(settings[0]));
		EasyMock.verify(settings);
	}

	private Setting[] createSettingMocks(RootConf rootConf, String[][] absRefs, boolean expectsSettingValue) {
		EasyMock.expect(rootConf.getAllSettings()).andStubReturn(new BasicEList<Setting>());
		EasyMock.replay(rootConf);
		Setting[] setting = new Setting[absRefs.length];
		for (int i=0;i<absRefs.length; i++) {
			setting[i] = EasyMock.createMock(Setting.class);
			EasyMock.expect(setting[i].getAbsRef()).andReturn(absRefs[i][0]);
			if(expectsSettingValue){
				setting[i].setCurrentValue(EasyMock.eq(absRefs[i][1]));
			}
			rootConf.getAllSettings().add(setting[i]);
		}
		EasyMock.replay(setting);
		return setting;
	}

	private VariantData createVDMock(String[][] refValue) {
		VariantData vd = EasyMock.createMock(VariantData.class);
		EasyMock.expect(vd.getRef()).andStubReturn(new BasicEList<Ref>());
		EasyMock.expect(vd.getInclude()).andStubReturn(new BasicEList<VariantData>());
		EasyMock.replay(vd);
		Map<String,Ref> featureLevel = new HashMap<String,Ref>();
		Map<Ref, EList<Ref>> refs = new HashMap<Ref, EList<Ref>>();
		for (String[] strings : refValue) {
			String fStr = strings[0];
			String sStr = strings[1];
			String value = strings[2];
			Ref fRef = featureLevel.get(fStr);
			if(fRef==null){
				fRef = EasyMock.createMock(Ref.class);
				EasyMock.expect(fRef.getName()).andStubReturn(fStr);
				EasyMock.expect(fRef.getRef()).andStubReturn(new BasicEList<Ref>());
				EasyMock.replay(fRef);
				vd.getRef().add(fRef);
			}
			
			Ref sRef = EasyMock.createMock(Ref.class);
			EasyMock.expect(sRef.getName()).andStubReturn(sStr);
			EasyMock.expect(sRef.getValue()).andStubReturn(value);
			EasyMock.expect(sRef.getRef()).andStubReturn(new BasicEList<Ref>());
			EasyMock.replay(sRef);
			fRef.getRef().add(sRef);
		}
		
		return vd;
	};
}
