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


import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import com.nokia.tools.s60ct.build.builder.CRTemplate;
import com.nokia.tools.vct.crml.crmodel.EAccess;
import com.nokia.tools.vct.crml.crmodel.EKey;
import com.nokia.tools.vct.crml.crmodel.EKeyRange;
import com.nokia.tools.vct.crml.crmodel.ERepository;

public class CenrepGenerator {
	
	private ERepository[] reps=null;
	String errors = new String();

	
	public static String converAccessType(EAccess access){
		if(access==null)return "ERROR";
		String type=access.getType().getLiteral();
		String ssid=access.getSid();
		if(type==null)return "TYPE_NULL";
		if(type.equals("R"))
			if(ssid!=null)
				return "sid_rd="+ssid/*+" cap_rd"*/;
			else return "cap_rd";
		else if(type.equals("W"))
			if(ssid!=null)
				return "sid_wr="+ssid/*+" cap_wr"*/;
			else return "cap_wr";
		return ";)";
	}
	
	public static String createCap(EObject input){
		String result = "";
		EKey key = null;
		ERepository rep = null;
		EKeyRange range = null;
		List access = null;
		if ( input instanceof EKey )
		{
			key = ( EKey ) input;
			access = key.getAccess();
		}
		else if ( input instanceof ERepository )
		{
			rep = ( ERepository ) input;
			access = rep.getAccess();
		}
		else if ( input instanceof EKeyRange )
		{
			range = ( EKeyRange ) input;
			access = range.getAccess();
		}
		String readCap = "";
		String writeCap ="";

		for(Iterator<EAccess> itrAccess=access.iterator(); itrAccess.hasNext();){
			EAccess tAccess = itrAccess.next();
			String convAccess = CenrepGenerator.converAccessType(tAccess);
			if(convAccess.indexOf("wr")!=-1){
				if(!writeCap.equals(""))
					continue;
				if(key!=null&&key.isReadOnly())
					writeCap=convAccess+"="+"alwaysfail";
				else if(tAccess.getCapabilities()!=null&&tAccess.getCapabilities().length()>0)
					writeCap=convAccess+"="+tAccess.getCapabilities().replace(' ',',');
				else
					writeCap=convAccess;
				
			}
			else if(convAccess.indexOf("rd")!=-1){
				if(!readCap.equals(""))
					continue;
				if(tAccess.getCapabilities()!=null)
					readCap=convAccess+"="+tAccess.getCapabilities().replace(' ',',');
				else
					readCap=convAccess;
			}
				
		}
		if(key!=null&&key.isReadOnly()&&writeCap.equals("")) writeCap="cap_wr=alwaysfail";
		result=readCap.trim()+" "+writeCap.trim();
		result=result.replaceAll("AlwaysPass", "alwayspass").trim();
		if(result.length()>0)
			return result;
		else
			return "";
	}

	boolean canExecute(){
		return reps!=null;
	}

	public void setRepositories(ERepository[] reps){
		this.reps = reps;
	}
	
	Object generateCR(ERepository rep,Map<String, String> result){
		String fileName = getFilePath(rep);
		//System.out.println(fileName);
		CRTemplate crTemplate = new CRTemplate();
		String str = crTemplate.generate(rep);
		result.put(fileName, str);
		return result;
	}
	
	private String getFilePath(ERepository rep) {
		String fileName = rep.getUidValue();
		int start = fileName.indexOf("x");
		if(start>0)
			fileName=fileName.substring(start+1);
		fileName=fileName+".txt";
		return fileName;
	}
}
	


	