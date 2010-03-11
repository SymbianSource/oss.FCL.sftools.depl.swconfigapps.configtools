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


package templates;

import java.util.*;
import cenrep.*;
import generate.*;

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
  protected final String TEXT_22 = " ";
  protected final String TEXT_23 = " 16777216";
  protected final String TEXT_24 = " 0";
  protected final String TEXT_25 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	Repository rep = (Repository)argument;
	String versionId = rep.getVersion();
	String owner = rep.getOwner();
	List keys = rep.sortKeys();
	

    stringBuffer.append(TEXT_1);
    stringBuffer.append(versionId);
    
	if(rep.getOwner()!=null&&!rep.getOwner().equals("")){

    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(rep.getOwner().trim());
    
}
    stringBuffer.append(TEXT_4);
    
	if(rep.isBackup()){
    stringBuffer.append(TEXT_5);
    }else{
    stringBuffer.append(TEXT_6);
    }
 for(Iterator<KeyRange> itrlistOfKeys=rep.getRangeKey().iterator(); itrlistOfKeys.hasNext();){
 	KeyRange keyRange = (KeyRange)itrlistOfKeys.next();
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
    stringBuffer.append(TEXT_14);
    stringBuffer.append(rep.getGAccess());
    
   for(Iterator<KeyRange> itrlistOfKeys=rep.getRangeKey().iterator(); itrlistOfKeys.hasNext();){
	 KeyRange keyRange = (KeyRange)itrlistOfKeys.next();
    if(keyRange != null){
    stringBuffer.append(TEXT_15);
    stringBuffer.append(keyRange.getFirstInt());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(keyRange.getLastInt());
      

    stringBuffer.append(CenrepGenerator.createCap(keyRange));
    //}
	    }
    }

    stringBuffer.append(TEXT_17);
     for(Iterator itrKey=keys.iterator(); itrKey.hasNext();){
	Key key = (Key)itrKey.next();
	
    stringBuffer.append(TEXT_18);
    stringBuffer.append(key.getShortIdent());
    stringBuffer.append(TEXT_19);
    stringBuffer.append(key.getType());
    
	if(key.getType().equals(TYPE.STRING)||key.getType().equals(TYPE.STRING8)){
    stringBuffer.append(TEXT_20);
    if(key.getRef()!=null && key.getRef().indexOf("/")==-1 && (key.getGvalue()==null||((String)key.getGvalue()).length()==0)){ 
	
	
    stringBuffer.append("\"\"");
    }else {
    stringBuffer.append(key.getGvalue());
    
	}}else{ if(key.getRef()!=null && key.getRef().indexOf("/")==-1 &&(key.getGvalue()==null||((String)key.getGvalue()).length()==0)) {
    stringBuffer.append(TEXT_21);
    stringBuffer.append("0");
    }else {
    stringBuffer.append(TEXT_22);
    stringBuffer.append(key.getGvalue());
    }}

	if(key.isBackup()){
    stringBuffer.append(TEXT_23);
    
	  }else{
    stringBuffer.append(TEXT_24);
    }
	String capabilities = key.getGAccess();

    stringBuffer.append(capabilities);
    
	//}
	
}
    stringBuffer.append(TEXT_25);
    return stringBuffer.toString();
  }
}
