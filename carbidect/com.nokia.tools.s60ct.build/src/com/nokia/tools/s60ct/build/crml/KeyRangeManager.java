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

import java.util.Arrays;
import java.util.List;

import com.nokia.tools.vct.crml.crmodel.EAccess;
import com.nokia.tools.vct.crml.crmodel.ECRMLFactory;
import com.nokia.tools.vct.crml.crmodel.EKey;
import com.nokia.tools.vct.crml.crmodel.EKeyRange;
import com.nokia.tools.vct.crml.crmodel.EKeyType;


public class KeyRangeManager {

	public static final KeyRangeManager INSTANCE = new KeyRangeManager();
	private KeyRangeManager(){
	}
	
	/*
	 * creates arrays of keys corresponding to frame index
	 * frame index starts from 0
	 */
	public EKey[] createKeysIndex(final EKeyRange range, final int fix){
		EKey[] result = new EKey[range.getKeys().size()];
		
		long firstInt = uidToInt(range.getFirstInt());
		long lastInt = uidToInt(range.getLastInt());
		long indexBit = uidToInt(range.getIndexBits());
		long firstIndex = Long.parseLong(range.getFirstIndex().trim(),16)+fix;
		firstIndex = moveFirstIndex(range.getIndexBits(),firstIndex);
		//frame absolute address
		long frameAbsAddress = calculateAbsAddress(indexBit,firstIndex,firstInt);
		
		for(int i = 0;i<range.getKeys().size();i++){
			EKey key = range.getKeys().get(i);
			long keyInt = uidToInt(key.getIdent())+frameAbsAddress;
			EKey newKey = ECRMLFactory.eINSTANCE.createEKey();
			copyKeys(key, newKey);
			List<EAccess> cloneAccess = cloneAccess(range.getAccess());
			if(!cloneAccess.isEmpty()) newKey.getAccess().addAll(cloneAccess);
			newKey.setIdent(intToUid(keyInt));
			result[i]=newKey;
		}
		return result;
	}
	
	List<EAccess> cloneAccess(final List<EAccess> access){
		EAccess[] result = new EAccess[access.size()];
		for(int i=0;i<access.size();i++){
			EAccess ac = access.get(i);
			EAccess clone = ECRMLFactory.eINSTANCE.createEAccess();
			clone.setCapabilities(ac.getCapabilities());
			clone.setType(ac.getType());
			clone.setId(ac.getSid());
			result[i]=clone;
		}
		return Arrays.asList(result);
	}
	
	public EKey createCountKey(final EKeyRange range){
		EKey countKey = null;
		String countInt = range.getCountInt();
		if(countInt!=null&&!countInt.trim().equals("")){
			countKey = ECRMLFactory.eINSTANCE.createEKey();
			countKey.setIdent(countInt);
			countKey.setType(EKeyType.INT);
			List<EAccess> cloneAccess = cloneAccess(range.getAccess());
			if(!cloneAccess.isEmpty()) countKey.getAccess().addAll(cloneAccess);
			countKey.setBackup(range.isBackup());
		}
		return countKey;
	}
	
	long calculateAbsAddress(long indexBit, long firstIndex, long firstInt){
		long result = 0;
		String tmp="";
		String iBit = Long.toHexString(indexBit).toLowerCase();
		String fIndex = Long.toHexString(firstIndex).toLowerCase();
		
		for(int i=fIndex.length()-1;i>=0;i--){
			char ch;
			if(iBit.charAt(i)<fIndex.charAt(i)){
				ch=iBit.charAt(i);
			}else{
				ch=fIndex.charAt(i);
			}
			tmp=ch+tmp;
		}
		result = Long.parseLong(tmp,16);
		return result|firstInt;
	}
	
	long moveFirstIndex(String uid,final long number){
		String result = Long.toHexString(number);
		for(int i=uid.length()-1;i>=0;i--){
			if(uid.charAt(i)=='0')result=result+"0";
			else break;
		}
		return Long.parseLong(result,16);
		
	}
	
	private void copyKeys(EKey key, EKey newKey) {
		newKey.setBackup(key.isBackup());
		newKey.setReadOnly(key.isReadOnly());
		newKey.setType(key.getType());
		newKey.setRef(key.getRef());
		newKey.setName(key.getName());
	}

	public long uidToInt(String uidValue){
		if(uidValue.startsWith("0x") || uidValue.startsWith("0X")){
			return Long.parseLong(uidValue.substring(2),16);
		}
		return 0;
	}
	
	public String intToUid(long uid){
		String str=Long.toHexString(uid);
		str="0x"+"00000000".substring(str.length())+str;
		return str;
	}
}
