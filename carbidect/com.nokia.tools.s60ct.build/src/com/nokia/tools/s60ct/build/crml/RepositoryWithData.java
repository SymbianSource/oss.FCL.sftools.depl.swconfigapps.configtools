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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

import com.nokia.tools.s60ct.build.builder.utils.ISettingCollector;
import com.nokia.tools.s60ct.build.builder.utils.SettingAndLayer;
import com.nokia.tools.s60ct.build.builder.utils.SettingImplementationCollector;
import com.nokia.tools.vct.common.appmodel.EAppSequenceData;
import com.nokia.tools.vct.common.appmodel.EAppSetting;
import com.nokia.tools.vct.common.appmodel.EAppSettingData;
import com.nokia.tools.vct.common.appmodel.EAppSimpleData;
import com.nokia.tools.vct.common.appmodel.EConfMLLayer;
import com.nokia.tools.vct.common.appmodel.EConfigurationProject;
import com.nokia.tools.vct.crml.crmodel.EBit;
import com.nokia.tools.vct.crml.crmodel.EKey;
import com.nokia.tools.vct.crml.crmodel.EKeyRange;
import com.nokia.tools.vct.crml.crmodel.EKeyType;
import com.nokia.tools.vct.crml.crmodel.ERepository;

public class RepositoryWithData {
	private ERepository repository;
	
	private EConfigurationProject confProject;
	private Map<EKey, String> keyValueMap = new HashMap<EKey, String>();
	private EConfMLLayer generationLayer = null;

	private ISettingCollector collector = null;

	//private List<EKey> rfsKeys = new ArrayList<EKey>();

	public RepositoryWithData(ERepository repository, EConfigurationProject cp, ISettingCollector collector) {
		this.repository = repository;
		this.confProject = cp;
		this.collector = collector;
		UpdateKeyValueMap();
	}

	public ERepository getRepository() {
		return repository;
	}

	private void UpdateKeyValueMap() {
		SettingAndLayer settingAndLayer = null;
		//Repository header in rfs file
		StringBuilder rfs = new StringBuilder();
		rfs.append(repository.getUidValue());
		
		HashMap<EConfMLLayer, EConfMLLayer> layers = new HashMap<EConfMLLayer,EConfMLLayer>();
		for (EKey key : repository.getKey()) {
			EList<EBit> bits = key.getBits();
			settingAndLayer = collector.getSetting(confProject, key.getRef());
			
			EAppSetting setting = settingAndLayer.getSetting();
			//String ref = settingAndLayer.getSetting().getRef();
			
			if(!bits.isEmpty()) {
				long val = (long)calculateBitmask(settingAndLayer, bits);
				keyValueMap.put(key, String.valueOf(val));
				layers.put(settingAndLayer.getLayer(), settingAndLayer.getLayer());
			} else {
				SettingImplementationCollector.addImplementation(key.getRef(), key);
				if(settingAndLayer.getSetting()==null) continue;
				layers.put(settingAndLayer.getLayer(), settingAndLayer.getLayer());
				EAppSettingData settingValue = setting.getValueInfo();
				if(settingValue == null) continue;
				if(settingValue instanceof EAppSimpleData) {
					String setvalue = ((EAppSimpleData)settingValue).getValue();
					setvalue = formatKeyValue(key, setvalue);
					keyValueMap.put(key, setvalue);
				}				
			}
			
			//rfs content
//			if(settingAndLayer.getSetting()==null) continue;
//			EAppRfsInfo rfsInfo = settingAndLayer.getSetting().getRfsInfo();
//			if(rfsInfo.isRfs()) {
//				rfsKeys.add(key);
//			}
		}

		for(EKeyRange keyRange : repository.getRangeKey()) {
			settingAndLayer = collector.getSetting(confProject, keyRange.getRef());
			if(settingAndLayer.getSetting()==null) continue;
			layers.put(settingAndLayer.getLayer(), settingAndLayer.getLayer());
			EAppSettingData settingValue = settingAndLayer.getSetting().getValueInfo();
			
			SettingImplementationCollector.addImplementation(keyRange.getRef(), keyRange);
			
			if(settingValue == null) continue;
			if(settingValue instanceof EAppSequenceData) {
				EAppSequenceData sequenceData = (EAppSequenceData)settingValue;
				//1. create count key
				EKey countKey = KeyRangeManager.INSTANCE.createCountKey(keyRange);
				keyValueMap.put(countKey, String.valueOf(sequenceData.getItems().size()));
				
				//2. create sequence keys
				int nIndex=0;
				for(int seqItems=0; seqItems<sequenceData.getItems().size();seqItems++){
					EMap<String, EAppSettingData> subSettings = sequenceData.getItems().get(seqItems).getSubSettings();
					EKey[] keys = KeyRangeManager.INSTANCE.createKeysIndex(keyRange,nIndex);
					for (EKey key : keys) {
						SettingImplementationCollector.addImplementation("@"+seqItems+"/"+keyRange.getRef()+"/"+key.getRef(), key);
						EAppSimpleData keyData = (EAppSimpleData)subSettings.get(key.getRef());
						keyValueMap.put(key, formatKeyValue(key, keyData.getValue()));
					}
					nIndex++;
				}
			}
		}

		Set<Entry<EConfMLLayer, EConfMLLayer>> entrySet = layers.entrySet();

		//implementation must be improved
		int index = -1;
		//		for (Entry<EConfMLLayer, EConfMLLayer> entry : entrySet) {
		//			index = confProject.getLayers().indexOf(entry.getKey());
		//			break;
		//		}

		for (Entry<EConfMLLayer, EConfMLLayer> entry : entrySet) {
			int indexOf = confProject.getLayers().indexOf(entry.getKey());
			if(indexOf>index) {
				index = indexOf;
			}
		}
		generationLayer = confProject.getLayers().get(index==-1?0:index);
	}

	private String formatKeyValue(EKey key, String setvalue) {
		if(key.getType()==EKeyType.STRING) {
			if(setvalue==null) {
				return "\"\"";				
			}
			if(!setvalue.startsWith("\"")) {
				setvalue = "\"" + setvalue + "\"";
			}
		}
		return setvalue;
	}

	public List<EKey> sortKeys(){
		List<EKey> sortedKeys = new ArrayList<EKey>();
		sortedKeys.addAll(keyValueMap.keySet());
		sortList(sortedKeys);
		return sortedKeys;
//		return getKey();
	}

	private void sortList(List<EKey> sortedKeys) {
		removeLeadingZerosInKeyIdent(sortedKeys);
		Collections.sort(sortedKeys, new Comparator<EKey>(){
			public int compare(EKey arg0, EKey arg1) {
				int radix =16;
				EKey key0 = (EKey)arg0;
				EKey key1 = (EKey)arg1;
				String ident0 = key0.getIdent();
				String ident1 = key1.getIdent();
				if(ident0==null)return -1;
				else if(ident1==null)return 1;
				
				ident0=ident0.replaceAll("0x", "");
				ident1=ident1.replaceAll("0x", "");
				ident0="00000000".substring(0,8-ident0.length())+ident0;
				ident1="00000000".substring(0,8-ident1.length())+ident1;
				String upper0=ident0.substring(0, 4);
				String lower0 = ident0.substring(4,ident0.length());
				String upper1 = ident1.substring(0, 4);
				String lower1 = ident1.substring(4,ident1.length());
				if(!upper0.equals(upper1))
					return Integer.valueOf(upper0, radix).compareTo(Integer.valueOf(upper1, radix));
				else return Integer.valueOf(lower0, radix).compareTo(Integer.valueOf(lower1, radix));
				
				
				/*long id1 = Long.parseLong(ident0, 16);
				long id2 = Long.parseLong(ident1, 16);
				return Long.valueOf(id1).compareTo(id2);
				if(id1==id2) return 0;
				if(id1<id2) return -1;
				else return 1;*/
			}
		});
	}
	
	private void removeLeadingZerosInKeyIdent(List<EKey> sortedKeys) {
		for (EKey key : sortedKeys) {
			String ident = key.getIdent();
			int leadingZeroCount=0;
			if(ident.charAt(1)=='x'){
				for(int i=2; i<ident.length()-1;i++){
					if(ident.charAt(i)=='0'){
						leadingZeroCount++;
					}else
						break;
				}
				ident = "0x" + ident.substring(leadingZeroCount+2);
				key.setIdent(ident);		
			}	
		}
		
	}

	private double calculateBitmask(SettingAndLayer settingAndLayer, EList<EBit> bits) {
		double result = 0;
		int i=1;
		for(EBit bit : bits) {
			
			SettingImplementationCollector.addImplementation(bit.getRef(), bit);
			SettingAndLayer sl = collector.getSetting(confProject, bit.getRef());
			settingAndLayer.setLayer(sl.getLayer());
			settingAndLayer.setSetting(sl.getSetting());
			EAppSetting bitSetting = sl.getSetting();
			EAppSimpleData value = (EAppSimpleData) bitSetting.getValueInfo();
			//System.out.println(bit.getValue());
			if(value.getValue().compareTo("true")==0)
//				result=result+Math.pow(2,(double)Double.valueOf(bit.getValue())-1);			
				result=result+Math.pow(2,Integer.valueOf(bit.getValue())-1);	
			i++;
		}
		return result;
	}
	
	public Map<EKey, String> getKeyValueMap() {
		return keyValueMap;
	}

	public EConfMLLayer getOutputLayer() {
		return generationLayer;
	}

//	public String getRfsContent() {
//		StringBuilder sb = new StringBuilder();
//		sb.append("CR " + repository.getUidValue().substring(2));
//		sortList(rfsKeys);
//		for (int i = 0; i < rfsKeys.size(); i++) {
//			sb.append(" ");
//			sb.append(rfsKeys.get(i).getIdent().substring(2));
//		}
//		return sb.toString();
//	}
}
