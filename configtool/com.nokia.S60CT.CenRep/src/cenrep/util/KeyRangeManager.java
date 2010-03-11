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
package cenrep.util;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.service.IBatchValidator;
import org.eclipse.emf.validation.service.ModelValidationService;

import cenrep.Access;
import cenrep.CenrepFactory;
import cenrep.Key;
import cenrep.KeyRange;
import cenrep.TYPE;


public class KeyRangeManager {

	public static final KeyRangeManager INSTANCE = new KeyRangeManager();
	
	private IBatchValidator validator=null;
	
	private KeyRangeManager(){
	}
	
	/*
	 * creates arrays of keys corresponding to frame index
	 * frame index starts from 0
	 */
	public Key[] createKeysIndex(final cenrep.KeyRange range, final int fix){
		Key[] result = new Key[range.getKeys().size()];
		
		long firstInt = uidToInt(range.getFirstInt());
		long lastInt = uidToInt(range.getLastInt());
		long indexBit = uidToInt(range.getIndexBits());
		long firstIndex = Long.parseLong(range.getFirstIndex().trim(),16)+fix;
		firstIndex = moveFirstIndex(range.getIndexBits(),firstIndex);
		//frame absolute address
		long frameAbsAddress = calculateAbsAddress(indexBit,firstIndex,firstInt);
		
		for(int i = 0;i<range.getKeys().size();i++){
			Key key = range.getKeys().get(i);
			long keyInt = uidToInt(key.getIdent())+frameAbsAddress;
			Key newKey = CenrepFactory.eINSTANCE.createKey();
			copyKeys(key, newKey);
			List<Access> cloneAccess = cloneAccess(range.getAccess());
			if(!cloneAccess.isEmpty()) newKey.getAccess().addAll(cloneAccess);
			newKey.setIdent(intToUid(keyInt));
			result[i]=newKey;
		}
		return result;
	}
	
	private IBatchValidator getValidator(){
		if(validator==null){
			validator = (IBatchValidator)ModelValidationService.getInstance()
			.newValidator(EvaluationMode.BATCH);
			validator.setIncludeLiveConstraints(true);
		}
		return validator;
	}
	
	public boolean isRangeValid(KeyRange range){
		return getValidator().validate(range).getSeverity()!=IStatus.ERROR;
	}
	
	List<Access> cloneAccess(final List<Access> access){
		Access[] result = new Access[access.size()];
		for(int i=0;i<access.size();i++){
			Access ac = access.get(i);
			Access clone = CenrepFactory.eINSTANCE.createAccess();
			clone.setCapabilities(ac.getCapabilities());
			clone.setType(ac.getType());
			clone.setId(ac.getSid());
			result[i]=clone;
		}
		return Arrays.asList(result);
	}
	
	public Key createCountKey(final KeyRange range , final int size){
		Key countKey = null;
		String countInt = range.getCountInt();
		if(countInt!=null&&!countInt.trim().isEmpty()){
			countKey = CenrepFactory.eINSTANCE.createKey();
			countKey.setIdent(countInt);
			countKey.setType(TYPE.INT);
			countKey.setGvalue(String.valueOf(size));
			List<Access> cloneAccess = cloneAccess(range.getAccess());
			if(!cloneAccess.isEmpty()) countKey.getAccess().addAll(cloneAccess);
//			countKey.getAccess().addAll(range.getAccess());
			countKey.setBackup(range.isBackup());
		}
		return countKey;
	}
	
//	(indexBit&firstIndex)|firstInt
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
	
	private void copyKeys(Key key, Key newKey) {
		newKey.setBackup(key.isBackup());
		newKey.setReadOnly(key.isReadOnly());
		newKey.setType(key.getType());
		newKey.setRef(key.getRef());
	}
	/*
	 * Take values from frameArray (frame index fix) and set them to keys.
	 * fix 1-n
	 */
	public void setKeyGValues(Key[] keys,Object[][] gValues, int fix){
		for(Key key:keys){
			for(int i=0; i<gValues.length;i++){
				String ref = (String)gValues[i][0];
				if(key.getRef().trim().compareTo(ref)==0)
					key.setGvalue(gValues[i][fix]);
			}
		}
	}

	public long uidToInt(String uidValue){
		if(uidValue.length()>2){
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
