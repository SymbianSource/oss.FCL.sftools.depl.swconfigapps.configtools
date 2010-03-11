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
package com.nokia.s60ct.cli;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Vector;

import com.nokia.s60ct.generate.GenerationReport;
import com.nokia.s60ct.interfaces.ISaveContent;

public class BuildIbyPlugin implements ISaveContent{

	private static final String pluginID = "com.nokia.S60CT.CLI";
	private GenerationReport report = null;
	
	String ibyFile = null;
	String ibyFolder = null;
	String[] crFolders = null;
	boolean dontSaveIby = false;
	final static String TARGET = "private\\10202BE9\\";
	private final String EOL = System.getProperty("line.separator");
	static String IBY_FLAG = "";   //"__S60CENREP_VARIANT_IBY__";
	final static String RFS_NAME = "cenrep_rfs.txt";
	final static String RFS_PATH = "\\epoc32\\data\\Z\\private\\100059C9\\";
	final static String RFS_IBY = "rfs_variant.iby";
	final static String RFS_FLAG = "__RFS_VARIANT_IBY__";
	final static String RFS_TARGET = "private\\100059C9\\";
	
	public BuildIbyPlugin(String strIbyFolder, String strIbyFile, String[] srcCenRepFolders, boolean dontSaveIby){
		this.ibyFile = strIbyFile;
		parseIBYMacroName();
		this.ibyFolder = strIbyFolder;
		this.crFolders = srcCenRepFolders;
		this.dontSaveIby = dontSaveIby;
	}

	private void parseIBYMacroName()
	{
		IBY_FLAG = "__"+ibyFile.toUpperCase()+"__";
		IBY_FLAG = IBY_FLAG.replace('.', '_');
	}
	
	public String[] getSrcPlugin() {
		return new String[]{"cenrep"};
	}

	@Override
	public GenerationReport saveContent(Object object, String pluginID) {
		
		report = new GenerationReport();
		
		if (object==null) 
			return null;
		Map<String, String> nameContent = (Map<String, String>)object;
		StringBuffer ibyFileContent = new StringBuffer();
		ibyFileContent.append( "#ifndef " + IBY_FLAG + EOL );
		ibyFileContent.append( "#define " + IBY_FLAG + EOL+EOL );
		
		for(String fileName : nameContent.keySet()){
			String name = fileName;
			if(name.indexOf("\\")!=-1){ // remove configuration name from file name (used for ROFS)
				name = name.substring(name.lastIndexOf("\\")+1);
			}
			if(name.compareTo(RFS_NAME)==0){
				StringBuffer rfsBuffer = new StringBuffer();
				rfsBuffer.append( "#ifndef " + RFS_FLAG + EOL );
				rfsBuffer.append( "#define " + RFS_FLAG + EOL+EOL );
				rfsBuffer.append("data="+RFS_PATH+RFS_NAME+"\t\t"+RFS_TARGET+RFS_NAME+EOL);
				rfsBuffer.append(EOL+"#endif "+"//"+RFS_FLAG+EOL);
				File existingFile = new File(RFS_PATH+RFS_NAME);
				if (existingFile.exists())
				{
					saveCenRep(RFS_PATH, RFS_NAME, mergeRFSContent(nameContent.get(fileName), existingFile));
				}
				else
					saveCenRep(RFS_PATH, RFS_NAME, nameContent.get(fileName));
				saveIby(ibyFolder,RFS_IBY,rfsBuffer.toString());
				continue;
			}
			ibyFileContent.append("data="+crFolders[0]+File.separator+name+"\t\t"+TARGET+name+EOL);
			for (int i = 0 ; i < crFolders.length ; i++)
				saveCenRep(crFolders[i],name,nameContent.get(fileName));
		}
		ibyFileContent.append(EOL+"#endif "+"//"+IBY_FLAG+EOL);
		saveIby(ibyFolder,ibyFile,ibyFileContent.toString());
		return report;
	}
	
	private void saveIby(String folder,String name,String content){
		
		if (dontSaveIby)
			return;
		File dir = new File(folder);
		if(!dir.exists()&&!dir.mkdirs()){
			System.err.println("Cannot create dir "+dir.getPath());
		}else{
			FileOutputStream fout=null;
			try
			{
			    fout = new FileOutputStream(dir.getPath()+File.separatorChar+name);
			    Writer osr = new OutputStreamWriter(fout,"US-ASCII");
			    osr.write(content);
			    osr.close();
			    fout.close();
			    report.addIBYReport(name, folder, ""); //no absolute path needed
			}
			catch (IOException e)
			{
				System.err.println (e.getMessage());
			}
		}
	}
	
	private void saveCenRep(String folder, String name, String content){
		
		String comment = "comment missing";
		File dir = new File(folder);
		if(!dir.exists()&&!dir.mkdirs()){
			System.err.println("Cannot create dir "+dir.getPath());
		}else{
			FileOutputStream fout=null;
			try
			{
			    fout = new FileOutputStream(dir.getPath()+File.separatorChar+name);
			    Writer osr = new OutputStreamWriter(fout,"UTF-16LE");
			    osr.write('\ufeff');
			    osr.write(content);
			    osr.close();
			    fout.close();
			    if (pluginID.compareTo("gencon") == 0) 
			    	report.addGenConfmlReport(name + " (" + comment + ")", dir.getPath(), dir.getAbsolutePath());
			    else 
			    	report.addCenRepReport(name, dir.getPath(), dir.getAbsolutePath());
			}
			catch (IOException e)
			{
				System.err.println (e.getMessage());
			}
		}
	}
	
	private String mergeRFSContent(String newContent, File oldFile)
	{
	    Vector oldContent = new Vector(50);
	    Vector mergedContent = new Vector(50);
	    try 
	    {
	      FileInputStream in = new FileInputStream(oldFile);
	      BufferedReader input =  new BufferedReader(new InputStreamReader(in, "UTF-16"));

	      String rfsLine = "";
	      while (( rfsLine = input.readLine()) != null)
	      {
		      oldContent.add(rfsLine);
	      }
	      input.close();

	    } catch (FileNotFoundException e) {
	      e.printStackTrace();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }

	    String[] newContentArray = newContent.split(EOL);
	    
	    for (int i = 0 ; i < newContentArray.length ; i++)
	    {
	    	if (!oldContent.contains(newContentArray[i]))
	    	{
	    		mergedContent.add(newContentArray[i]);
	    	}
	    }
		
	    StringBuffer mergedStringBuffer = new StringBuffer();
	    
	    for (int i = 0 ; i < oldContent.size() ; i++)
	    {
	    	mergedStringBuffer.append(oldContent.elementAt(i));
	    	mergedStringBuffer.append(EOL);
	    }
	    for (int i = 0 ; i < mergedContent.size() ; i++)
	    {
	    	mergedStringBuffer.append(mergedContent.elementAt(i));
	    	mergedStringBuffer.append(EOL);
	    }
	    
		return mergedStringBuffer.toString();
	}
	
	@Override
	public GenerationReport getReport() {
		return null;
	}

	@Override
	public Collection<Object> setRefValue(Map<String, Object> refToValue) {
		return new ArrayList<Object>();
	}
	
}
