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
package com.nokia.tools.s60ct.build.builder.utils;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

import com.nokia.tools.vct.common.appmodel.EAppFeature;
import com.nokia.tools.vct.common.appmodel.EAppSequenceData;
import com.nokia.tools.vct.common.appmodel.EAppSequenceDataItem;
import com.nokia.tools.vct.common.appmodel.EAppSetting;
import com.nokia.tools.vct.common.appmodel.EAppSettingData;
import com.nokia.tools.vct.common.appmodel.EAppSimpleData;
import com.nokia.tools.vct.common.appmodel.EConfMLLayer;
import com.nokia.tools.vct.common.appmodel.EConfigurationProject;

public class SettingValueCollector implements ISettingCollector {

	private static ISettingCollector singleton;

	private SettingValueCollector() {
		
	}
	
	static public ISettingCollector getInstance() {
		if(singleton==null) {
			singleton = new SettingValueCollector();
		}
		return singleton;
	}
	
	/**
	 * true if setting value same in both layers
	 *  
	 * @param layer1
	 * @param layer2
	 * @param setting 
	 * @return
	 */
	private boolean compareSettingValue(EConfMLLayer layer1, EConfMLLayer layer2, String absSettingRef) {
		//re-factor
		if(layer1==null || layer2 == null || absSettingRef==null) {
			return false;
		}
		String[] parts = absSettingRef.split("/");
		EAppFeature feature1 = layer1.getFeatures().get(parts[0]);
		EAppFeature feature2 = layer2.getFeatures().get(parts[0]);
		if(feature1==null || feature2==null) {
			return false;
		}
		
		EAppSetting setting1 = feature1.getSettings().get(parts[1]);
		EAppSetting setting2 = feature2.getSettings().get(parts[1]);
		if(setting1==null || setting2==null) {
			return false;
		}
		EAppSettingData value1 = setting1.getValueInfo();
		EAppSettingData value2 = setting2.getValueInfo();
		if(value1==null || value2==null) {
			return false;
		}
				
		if(value1 instanceof EAppSimpleData){
			EAppSimpleData simpleValue1 = (EAppSimpleData) value1;
			EAppSimpleData simpleValue2 = (EAppSimpleData) value2;
			
			String svalue1 = simpleValue1.getValue();
			String svalue2 = simpleValue2.getValue();
			if(svalue1==null || svalue2==null) return false;
			return (svalue1.equals(svalue2));
		} else if(value1 instanceof EAppSequenceData) {
			EAppSequenceData seq1 = (EAppSequenceData) value1;
			EAppSequenceData seq2 = (EAppSequenceData) value2;
			
			EList<EAppSequenceDataItem> items1 = seq1.getItems();
			EList<EAppSequenceDataItem> items2 = seq2.getItems();
			if(items1.size()!=items2.size()) {
				return false;
			}
			
			for (int i = 0; i < items1.size(); i++) {
				EMap<String, EAppSettingData> subSettings1 = items1.get(i).getSubSettings();
				EMap<String, EAppSettingData> subSettings2 = items2.get(i).getSubSettings();
				if(subSettings1.size()!=subSettings2.size()) {
					return false;
				}
				
			}
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see com.nokia.tools.s60ct.build.builder.utils.ISettingValueCollector#getSetting(com.nokia.tools.variant.confml.core.model.application.EConfigurationProject, java.lang.String)
	 */
	public SettingAndLayer getSetting(EConfigurationProject cp, String absRef) {
		SettingAndLayer retValue = new SettingAndLayer(null,null);
		if(cp ==null || absRef == null){
			return retValue;
		}
		
		EConfMLLayer lastLayer = cp.getLastLayer();
		
		String[] refs = absRef.split("/");
		
		EAppFeature feature = lastLayer.getFeatures().get(refs[0]);
		if(feature!=null) {
			EAppSetting setting = feature.getSettings().get(refs[1]);
			if(setting!=null) {
				EConfMLLayer genLayer = getGenerationLayer(lastLayer,absRef);
				retValue.setLayer(genLayer);
				retValue.setSetting(setting);
//				return new SettingAndLayer(setting,genLayer);
			}else
			{
				//System.err.println("Setting with Ref: "+refs[1]+" is missing");
			}
		}else
		{
			//System.err.println("Feature with Ref: "+refs[0]+" is missing");
		}
		return retValue;
	}

	private EConfMLLayer getGenerationLayer(EConfMLLayer lastLayer, String absSettingRef) {
		EConfMLLayer layer = lastLayer;
		while((layer!=null)&&(layer.getParent()!=null)) {
			EConfMLLayer parent = layer.getParent();
			if(compareSettingValue(layer, parent, absSettingRef)) {
				layer=parent;
				continue;
			} else {
				break;
			}
		}
		return layer;
	}

}
