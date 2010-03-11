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
package configurationemf.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;

import variantdata.VariantData;
import configurationemf.Ref;
import configurationemf.RootConf;
import configurationemf.Setting;

public class VariantDataManager implements IVariantDataManager {
	
	static final String DEC_BIT = "_bit";
	static final String HEX_BIT = "_hex_bit";
	
	public VariantDataManager() {
	}

	/* (non-Javadoc)
	 * @see configurationemf.util.IVariantDataManager#importValues(configurationemf.RootConf, java.util.Map, java.util.Map)
	 */
	public Set<String> importValues(RootConf rootConf, Map<String, String> vdMap, Map<Setting, Object> map) {
		SetValue setValue = null;
		if(map!=null) setValue=new SetValueToMap(map);
		else setValue = new SetValue();
		
		EList<Setting> allSettings = rootConf.getAllSettings();
		Set<String> bitmaskRefs = new HashSet<String>();
		
		for (Setting setting : allSettings) {
			String setAbsRef = setting.getAbsRef();
			String value = filterValue(vdMap.get(setAbsRef));
			int indexDec = setAbsRef.indexOf(DEC_BIT);
			int indexHex = setAbsRef.indexOf(HEX_BIT);
			if(value!=null){
				
				setValue.setCurrentValue(setting,value);
				
				vdMap.remove(setAbsRef);
			}else if (indexHex!=-1){
				int bitN = Integer.valueOf(setAbsRef.substring(indexHex+HEX_BIT.length()));
				String vdAbsRef = setAbsRef.substring(0,indexHex);
				if(checkBitSetting(setValue,setting, bitN, vdMap.get(vdAbsRef),16))
					bitmaskRefs.add(vdAbsRef);
			}else if(indexDec!=-1){
				int bitN = Integer.valueOf(setAbsRef.substring(indexDec+DEC_BIT.length()));
				String vdAbsRef = setAbsRef.substring(0,indexDec);
				if(checkBitSetting(setValue,setting, bitN, vdMap.get(vdAbsRef),10))
					bitmaskRefs.add(vdAbsRef);
			}
			
		}
		
		vdMap.keySet().removeAll(bitmaskRefs);
		return vdMap.keySet();
	}

	private String filterValue(final String value) {
		if(value!=null){
			int firstQ = value.indexOf("\"");
			int lastQ = value.lastIndexOf("\"");
			if(firstQ==0&&lastQ==value.length()-1)
				return value.substring(firstQ+1, lastQ);
		}
		return value;
	}

	private boolean checkBitSetting(SetValue setValue, Setting setting, int bitN, String tValue,int radix) {
		if(tValue!=null){
			long lvalue = Long.parseLong(tValue,radix);
			if(isBitSet(lvalue, bitN))
				setValue.setCurrentValue(setting,"true");
			else
				setValue.setCurrentValue(setting,"false");
			return true;
		}
		return false;
	}

	
	private boolean isBitSet(long lvalue, int bitN) {
		String temp = Long.toBinaryString(lvalue);
		while(temp.length()<bitN)temp="0"+temp;
		return temp.charAt(temp.length()-bitN)=='1';
	}

	/* (non-Javadoc)
	 * @see configurationemf.util.IVariantDataManager#getSingleVDMap(variantdata.VariantData)
	 */
	public Map<String, String> getSingleVDMap(VariantData vd) {
		Map<String, String> map = new HashMap<String, String>();
		getMap(vd.getRef(),map,null);
		return map;
	}

	private void getMap(EList<Ref> refs, Map<String, String> map,String parentRef) {
		for (Ref ref : refs) {
			String myAbsRef = parentRef==null?ref.getName():parentRef+"/"+ref.getName();
			if(ref.getRef().isEmpty()){
				map.put(myAbsRef, ref.getValue());
			}else{
				getMap(ref.getRef(), map, myAbsRef);
			}
		}
	}

	/* (non-Javadoc)
	 * @see configurationemf.util.IVariantDataManager#getChainVDMap(variantdata.VariantData)
	 */
	public Map<String, String> getChainVDMap(VariantData vd) {
		Map<String,String> result = new HashMap<String, String>();
		for (VariantData temp : vd.getInclude()) {
			result.putAll(getChainVDMap(temp));
		}
		result.putAll(this.getSingleVDMap(vd));
		return result;
	}

	

	class SetValue {
		void setCurrentValue(Setting setting, String value){
			setting.setCurrentValue(value);
		}
	}

	class SetValueToMap extends SetValue{
		private Map<Setting, Object> map=null;
		
		public SetValueToMap(Map<Setting, Object> map) {
			this.map = map;
		}
		
		@Override
		void setCurrentValue(Setting setting, String value) {
			map.put(setting, value);
		}
	}
	
}