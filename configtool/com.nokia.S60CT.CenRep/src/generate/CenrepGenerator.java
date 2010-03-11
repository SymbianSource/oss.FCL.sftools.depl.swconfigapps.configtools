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
package generate;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import templates.CRTemplate;
import cenrep.Access;
import cenrep.Bit;
import cenrep.Key;
import cenrep.KeyRange;
import cenrep.RVG;
import cenrep.Repository;
import cenrep.TYPE;

import com.nokia.s60ct.generate.GenerationReport;

public class CenrepGenerator {
	
	private final String hexPrefix = "0x";
	private final String crHeader = "CR";
	private final static String LINE_SEPARATOR = System.getProperty("line.separator");
	
	private static final String RFS_PREFIX="@RFS@"; 
	
	private Repository[] reps=null;

	GenerationReport report = null;
	String errors = new String();

	
	public static String converAccessType(Access access){
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
		Key key = null;
		Repository rep = null;
		KeyRange range = null;
		List access = null;
		if ( input instanceof Key )
		{
			key = ( Key ) input;
			access = key.getAccess();
		}
		else if ( input instanceof Repository )
		{
			rep = ( Repository ) input;
			access = rep.getAccess();
		}
		else if ( input instanceof KeyRange )
		{
			range = ( KeyRange ) input;
			access = range.getAccess();
		}
		String readCap = "";
		String writeCap ="";
		for(Iterator itrAccess=access.iterator(); itrAccess.hasNext();){
			Access tAccess = (Access)itrAccess.next();
			String convAccess = CenrepGenerator.converAccessType(tAccess);
			if(convAccess.indexOf("wr")!=-1){
				if(key!=null&&key.isReadOnly())
					writeCap=convAccess+"="+"alwaysfail";
				else if(tAccess.getCapabilities()!=null&&tAccess.getCapabilities().length()>0)
					writeCap=convAccess+"="+tAccess.getCapabilities().replace(' ',',');
				else
					writeCap=convAccess;
				
			}
			else if(convAccess.indexOf("rd")!=-1){
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
			return " "+result;
		else
			return "";
	}

	boolean canExecute(){
		return reps!=null;
	}

	public Object generate() {
		if(!canExecute())return null;
		report = new GenerationReport();
		errors="";
		Map<String, String> result= new HashMap<String, String>();
		for(Repository rep : reps){
			if(rep.canGenerate())
			{
				result.put(rep.getFileName(), generate(rep));
				
			}else{
				errors += rep.getProblems();
				report.addCenRepError(rep.getProblems(), "");
			}
		}
		result.put( "cenrep_rfs.txt", getRFSContent());
		
		resetAll();
		return result;
	}

	public String getRFSContent()
	{
		String result = "";
		for (Repository rep : reps)
		{
			if (rep.isRfs()) //if repository if rfs, add only CR uidValue to rfs file.
			{
				try
				{
					result += crHeader + " " + truncate(rep.getUidValue(), false);
					result += LINE_SEPARATOR;
				}
				catch (StringIndexOutOfBoundsException sioobe)
				{
					//no uidValue given. Cannot be added.
				}
			}
			else //if repository is not rfs, check all keys and if any of them is rfs, add row with CR uidValue + rfs keys
			{
				for(Key anyKey : ( EList< Key > ) rep.getKey() )
				{
					if (anyKey.isRfs()) 
					{
						try
						{
							result += crHeader + " " + truncate(rep.getUidValue(), false);
							for(Key key : ( EList< Key > ) rep.getKey() )
							{
								if ( key.isRfs()) 
								{
									result += " " + truncate(key.getIdent(), true);
								}
							}
							result += LINE_SEPARATOR;
						}
						catch (StringIndexOutOfBoundsException sioobe)
						{
							//no uidValue given. Cannot be added.
						}
						break;
					}
				}
			}
		}
		return result;
	}

	private String truncate( String in , boolean removeLeadingZeroes)
	{
		String out = "";
		if ( in.startsWith( hexPrefix ) )
		{
			// Remove 0x
			out = in.substring( hexPrefix.length());
		}
		else
		{
			out = in;
		}
		
		if (!removeLeadingZeroes)
			return out;
		
		// Remove 0's from beginning
		int i = 0;
		for ( i = 0; i < out.length(); i++ )
		{
			if ( out.charAt( i ) != '0' )
			{
				out = out.substring( i );
				break;
			}
		}
		if ( i == out.length() && out.charAt( out.length() - 1 ) == '0' )
		{
			// Special case, all chars 0
			out = "0";
		}
		return out;
	}
	
	private String generate(Repository rep){
		CRTemplate crTemplate = new CRTemplate();
		String content = crTemplate.generate(rep);
		//System.out.println(content);
		return content;
		
	}

	public Collection<Object> setRefValue(Map<String, Object> refToValue) {
		List<Object> result = new ArrayList<Object>();
		for(Map.Entry<String, Object> entry : refToValue.entrySet()){
			//set value
			String[] entryKey = entry.getKey().split(",");
			if (entryKey[2].startsWith(RFS_PREFIX))
				continue;
			RVG rvg = findRVG(entryKey[2]);
			if(rvg!=null){
				/*Object value = entry.getValue();
				if (value==null && rvg instanceof Key && entryKey[2].split("/").length==3)
				{
					Key key = (Key)rvg;	
					TYPE type = key.getType();
					if (type.equals(TYPE.STRING) || type.equals(TYPE.STRING8))
					{
						rvg.setGvalue("");
					}
					else
					{
						rvg.setGvalue("0");
					}
				}
				else*/
				
				Object value = entry.getValue();
				//ConfML specification says that value of boolean type can be either "true/false" or 0/1.
				//"true/false" doesn't work if the crml key is "int" or "binary", so we need to change string value to corresponding int value.
				if (value != null)
				{
					if (rvg instanceof Key)
					{
						Key key = (Key)rvg;	
						TYPE type = key.getType();
						if ((type.equals(TYPE.INT) || type.equals(TYPE.BINARY)) && key.getBits().size() == 0)
						{
							if (value.equals("true"))
								value = "1";
							else if (value.equals("false"))
								value = "0";
						}
					}
					else if (rvg instanceof KeyRange)
					{
						KeyRange keyRange = (KeyRange)rvg;
						for (int i = 0 ; i < keyRange.getKeys().size() ; i++)
						{
							Key key = keyRange.getKeys().get(i);
							TYPE type = key.getType();
							if (type.equals(TYPE.INT) || type.equals(TYPE.BINARY))
							{
								Object[] subValue = ((Object[][])value)[i];
								for (int j = 1 ; j < subValue.length ; j++)
								{
									if (subValue[j].equals("true"))
										((Object[][])value)[i][j] = "1";
									else if (subValue[j].equals("false"))
										((Object[][])value)[i][j] = "0";
								}
								
							}
						}
					}
				}
				
				rvg.setGvalue(value);
				
				rvg.setGConf(entryKey[0]);
				rvg.setPriority(entryKey[1]);
				Boolean rfs = (Boolean)refToValue.get(entryKey[0]+","+entryKey[1]+","+RFS_PREFIX+entryKey[2]);
				if(rfs!=null)
					rvg.setRfs(rfs.booleanValue());	
				result.add(rvg);
			}
		}
		return result;
	}
	
	private RVG findRVG(String ref){
		for(Repository rep : reps){
			for(Key key : (EList<Key>)rep.getKey()){
				for(Bit bit : (EList<Bit>)key.getBits()){
					if(bit.getRef()!=null&&bit.getRef().compareTo(ref)==0)return bit;
				}
				if(key.getRef()!=null&&key.getRef().compareTo(ref)==0)return key;
			}
			for(KeyRange range : rep.getRangeKey()){
				if(range.getRef()!=null)
				{
					if (range.getRef().compareTo(ref)==0)return range;
					for (Key key : range.getKeys())
					{
						if (key.getRef()!=null && (range.getRef()+"/"+key.getRef()).compareTo(ref)==0)return key; //three part ref 
					}
				}
			}
		}
		return null;
	}
	
	private void resetAll(){
		for(Repository rep : reps){
			for(Key key : (EList<Key>)rep.getKey()){
				for(Bit bit : (EList<Bit>)key.getBits())
					bit.setGvalue(null);
				key.setGvalue(null);
				key.setRfs(false);
				key.setGConf(null);
				key.setPriority(null);
			}
			for(KeyRange range : rep.getRangeKey())
				range.setGvalue(null);
		}
		reps=null;
		System.err.println(errors); //For CLI
	}
	
	public void setRepositories(Repository[] reps){
		this.reps = reps;
	}
	
	Object generateCR(Repository rep,Map<String, String> result){
		String fileName = getFilePath(rep);
		System.out.println(fileName);
		CRTemplate crTemplate = new CRTemplate();
		String str = crTemplate.generate(rep);
		result.put(fileName, str);
		return result;
	}
	
	private String getFilePath(Repository rep) {
		String fileName = rep.getUidValue();
		int start = fileName.indexOf("x");
		if(start>0)
			fileName=fileName.substring(start+1);
		fileName=fileName+".txt";
		return fileName;
	}
	
	public GenerationReport getReport()
	{
		return report;
	}
}
	


	