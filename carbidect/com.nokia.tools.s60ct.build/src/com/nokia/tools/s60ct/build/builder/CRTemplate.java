/*
* Copyright (c) 2010 Nokia Corporation and/or its subsidiary(-ies).
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
package com.nokia.tools.s60ct.build.builder;

import java.util.*;
import com.nokia.tools.s60ct.build.crml.*;
import com.nokia.tools.vct.crml.crmodel.*;

public class CRTemplate
{
  protected static String nl;
  public static synchronized CRTemplate create(String lineSeparator)
  {
    nl = lineSeparator;
    CRTemplate result = new CRTemplate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "cenrep" + NL + "version ";
  protected final String TEXT_2 = NL + "[owner]";
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = NL + "[defaultmeta]";
  protected final String TEXT_5 = NL + " 16777216";
  protected final String TEXT_6 = NL + " 0";
  protected final String TEXT_7 = NL;
  protected final String TEXT_8 = " ";
  protected final String TEXT_9 = " 16777216";
  protected final String TEXT_10 = NL;
  protected final String TEXT_11 = " ";
  protected final String TEXT_12 = " 0";
  protected final String TEXT_13 = NL + "[platsec]";
  protected final String TEXT_14 = NL;
  protected final String TEXT_15 = NL;
  protected final String TEXT_16 = " ";
  protected final String TEXT_17 = NL + "[Main]";
  protected final String TEXT_18 = NL;
  protected final String TEXT_19 = " ";
  protected final String TEXT_20 = " ";
  protected final String TEXT_21 = " ";
  protected final String TEXT_22 = " 16777216";
  protected final String TEXT_23 = " 0";
  protected final String TEXT_24 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	RepositoryWithData repWithData = (RepositoryWithData)argument;
	ERepository rep = repWithData.getRepository();
	String versionId = rep.getVersion();
	versionId = versionId==null? "1":versionId;
	String owner = rep.getOwner();
	
List<EKey> keys =/*repWithData.getKeyValueMap().keySet()*/repWithData.sortKeys();
	

    stringBuffer.append(TEXT_1);
    stringBuffer.append(versionId);
    
	if(owner!=null&&!owner.equals("")) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(owner.trim());
    
	}
    stringBuffer.append(TEXT_4);
    
	if(rep.isBackup()){
    stringBuffer.append(TEXT_5);
    }else{
    stringBuffer.append(TEXT_6);
    }
 for(Iterator<EKeyRange> rangeKeys=rep.getRangeKey().iterator(); rangeKeys.hasNext();){
 	EKeyRange keyRange = (EKeyRange)rangeKeys.next();
 	if(keyRange != null){
    		if(keyRange.isBackup()){
    stringBuffer.append(TEXT_7);
    stringBuffer.append(keyRange.getFirstInt());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(keyRange.getLastInt());
    stringBuffer.append(TEXT_9);
    }else{
    stringBuffer.append(TEXT_10);
    stringBuffer.append(keyRange.getFirstInt());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(keyRange.getLastInt());
    stringBuffer.append(TEXT_12);
    }
 }
 }
    stringBuffer.append(TEXT_13);
    
    //EList<EAccess> repAccesses = rep.getAccess();
	//StringBuilder sb1 = new StringBuilder();
	/*for(EAccess acc: repAccesses) {
		if(sb1.length()!=0)
			sb1.append(" ");
		System.out.println(acc.getType());
		if(acc.getType()==EAccessType.READ)
			sb1.append("cap_rd=");
		else
			sb1.append("cap_wr=");
		sb1.append(acc.getCapabilities().toLowerCase());
		
	}*/
	String repCap = CenrepGenerator.createCap(rep);
 
    stringBuffer.append(TEXT_14);
    stringBuffer.append(repCap.equals("")?"":" "+CenrepGenerator.createCap(rep)
);
    
  for(Iterator<EKeyRange> rangeKeys=rep.getRangeKey().iterator(); rangeKeys.hasNext();){
	 EKeyRange keyRange = rangeKeys.next();
    if(keyRange != null){
    stringBuffer.append(TEXT_15);
    stringBuffer.append(keyRange.getFirstInt());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(keyRange.getLastInt());
      

    stringBuffer.append(" "+CenrepGenerator.createCap(keyRange));
    //}
	    }
    }

    stringBuffer.append(TEXT_17);
     for(Iterator<EKey> itrKey=keys.iterator(); itrKey.hasNext();){
	EKey key = itrKey.next();
	
    stringBuffer.append(TEXT_18);
    stringBuffer.append(key.getIdent());
    stringBuffer.append(TEXT_19);
    stringBuffer.append(key.getType());
    
	if(key.getType().equals(EKeyType.STRING)||key.getType().equals(EKeyType.STRING8)){
    stringBuffer.append(TEXT_20);
    stringBuffer.append(repWithData.getKeyValueMap().get(key));
    
	}else{
    stringBuffer.append(TEXT_21);
    stringBuffer.append(repWithData.getKeyValueMap().get(key));
    }

	if(key.isBackup()){
    stringBuffer.append(TEXT_22);
    
	  }else{
    stringBuffer.append(TEXT_23);
    }
	  /*	EList<EAccess> accesses = key.getAccess();
		StringBuilder sb = new StringBuilder();
		for(EAccess acc: accesses) {
			if(sb.length()!=0)
				sb.append(" ");
			System.out.println(acc.getType());
			if(acc.getType()==EAccessType.READ)
				sb.append("cap_rd=");
			else
				sb.append("cap_wr=");
			sb.append(acc.getCapabilities().toLowerCase());
			}*/
			String keyCap = CenrepGenerator.createCap(key);

    stringBuffer.append(keyCap.equals("")?"":" "+keyCap);
    
	//}
	
}
    stringBuffer.append(TEXT_24);
    return stringBuffer.toString();
  }
}
