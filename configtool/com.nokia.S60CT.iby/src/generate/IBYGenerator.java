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

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.Preferences;
import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;

import IBY.Entity;
import IBY.Entry;
import IBY.FileName;
import IBY.IBYFile;
import IBY.Location;
import IBY.SrcPath;

import com.nokia.s60ct.generate.GenerateManager;
import com.nokia.s60ct.generate.GeneratedContent;
import com.nokia.s60ct.generate.GenerationReport;

import constants.IS60CTCommonConstants;


public class IBYGenerator {
	
	private final IBYFile[] ibys;
	private Entity[] configurableEntities=null;
	private FileName[] fileExpectingEntities=null;
	private final String variantLocationVar;
	
	private final static String EOL = System.getProperty("line.separator");
	private final static String COMMON_FOLDER = "common";
	private final static String RFS_FILE_NAME = "cenrep_rfs.txt";
	private final static String RFS_IBY_FILE = "rfs_variant.iby";
	private final static String RFS_FLAG = "__RFS_VARIANT_IBY__";
	private final static String RFS_TARGET = "private\\100059C9\\cenrep_rfs.txt";
	
	private GenerationReport report = null;
	//private String errors = "";
	//private String reportIBYFileName = "";
	//private String reportLocation = null;
	
	public IBYGenerator(IBYFile[] ibys,String variantLocationVar){
		this.ibys=ibys;
		this.variantLocationVar=variantLocationVar;
	}
	
	public void setValues( Map< String, Object > refToValue )
	{
		for(IBYFile iby : ibys)
		{
			for(Entry entry : iby.getEntries() )
			{
				String ref = entry.getTarget().getRef();
				if ( ref != null )
				{
					for(String key: refToValue.keySet())
					{
						if(key.matches("(\\p{Alnum})*,(\\p{Digit}),"+ref)){
							// Entry has matching ref key, save values
							entry.getTarget().setGvalue( ( String ) refToValue.get( key ) );
						}
					}
				}
				ref = entry.getFileName().getRef();
				if ( ref != null )
				{
					if ( refToValue.keySet().contains( ref ) )
					{
						// Entry has matching ref key, save values
						entry.getFileName().setGvalue( ( String ) refToValue.get( ref ) );
					}
				}
				ref = entry.getSource().getRef();
				if ( ref != null )
				{
					for(String key: refToValue.keySet())
					{
						if(key.matches("(\\p{Alnum})*,(\\p{Digit}),"+ref)){
							// Entry has matching ref key, save values
							entry.getSource().setGvalue( ( String ) refToValue.get( key ) );
						}
					}
				}
			}
			Location location = iby.getLocationt();
			String locRef =location.getRef();
			for(String key: refToValue.keySet())
			{
				if(key.matches("(\\p{Alnum})*,(\\p{Digit}),"+locRef)){
					// Entry has matching ref key, save values
					location.setGvalue( ( String ) refToValue.get( key ) );
				}
			}
		}
	}
	
	public GenerationReport saveContent(Object object, String pluginID) {
		
		Map<String, String> input = null;
		GeneratedContent content = null;
		
		if (object instanceof Map) input = (Map<String, String>) object;
		else if (object instanceof GeneratedContent) content = (GeneratedContent) object;
		
		report = new GenerationReport();
		
		if (fileExpectingEntities != null) {
			for (FileName fname : fileExpectingEntities) {
				if (fname.getPlugin().compareTo(pluginID) == 0) {
					if (input != null) fname.setFiles(input);
					else if (content != null) {
						fname.setFiles(content.getContents());
						fname.setTargets(content.getTargets());
						fname.setComments(content.getComments());
						fname.setEncodings(content.getEncodings());
					}
				}
			}
		}
		
		if (ibys != null) {
			for (IBYFile iby : ibys) {
				if (iby.isValidContent()) {
					saveEntryFiles(iby, pluginID);
					saveIBYFile(iby);
					iby.reset();
				}
//				else{
//					errors = "Cannot save files. IBY content not valid";
//					System.out.println("Cannot save files. IBY content not valid");
//				}
			}
		}
		return report;
	}
	
	private void saveEntryFiles(IBYFile iby, String pluginID) {
		String location = getLocation(iby);
		for(Entry entry:iby.getEntries()){
			SrcPath source = entry.getSource();
			if(entry.getFileName().getFiles()!=null){
				for(Map.Entry nameContent : entry.getFileName().getFiles().entrySet()){
					
					String key = ((String) nameContent.getKey()).replace("/", File.separator);
					String fileName = "";
					String folder = File.separator+COMMON_FOLDER+File.separator;
					
					String comment = "";
					if (entry.getFileName().getComments() != null) {
						comment = (String) entry.getFileName().getComments().get(key);			
					}
					
					if (pluginID.equals("gencon")) {
						if (key.startsWith(File.separator)) {
							// Remove genconfml variant configuration to folder string
							folder = key.substring(0, key.indexOf(File.separator, 1) + 1);
							fileName = key.substring(key.indexOf(File.separator, 1) + 1);
						} else
							fileName = key;
						
					} else if ((key.indexOf(File.separator) != -1) && (key.lastIndexOf(File.separator) != 0)) {
						fileName = key.substring(key.lastIndexOf(File.separator) + 1, key.length());
						folder = key.substring(0, key.lastIndexOf(File.separator) + 1);
					}
					else
						fileName = key;
					
					if (fileName.indexOf(File.separator)==0) //remove leading slash from file name
					{
						fileName = fileName.substring(1, fileName.length());
					}
					
					String content = (String) nameContent.getValue();
					File dir = null;
					//System.out.println("source.getGvalue():"+source.getGvalue());
					if (fileName.contains(File.separator))
						dir = new File(location + File.separator +  folder + source.getGvalue() + fileName.substring(0, fileName.lastIndexOf(File.separator)));
					else
						dir = new File(location + File.separator + folder + source.getGvalue());
					if(!dir.exists()&&!dir.mkdirs()){
						System.err.println("Cannot create dir "+dir.getPath());
						if (pluginID.compareTo("gencon") == 0) report.addGenConfmlError("Cannot create dir "+dir.getPath(), "");
						else report.addCenRepError("Cannot create dir "+dir.getPath(), "");
					}else{
						FileOutputStream fout=null;
						try
						{
							if (fileName.contains(File.separator))
								fout = new FileOutputStream(location + File.separator +  folder + source.getGvalue() + File.separatorChar + fileName);
							else
								fout = new FileOutputStream(dir.getPath()+File.separatorChar+fileName);
							String encoding = "UTF-16LE";
							if (entry.getFileName().getEncodings() != null) encoding = (String) entry.getFileName().getEncodings().get(key);
						    Writer osr = null;
						    // Write BOM
						    if (encoding.equals("UTF-8")) {
						    	osr = new OutputStreamWriter(fout, "UTF-8");
						    	// BOM is EFBBBF but it can't be written with this 16-bit writer, seems to work ok without though
						    } else if (encoding.equals("UTF-16BE")) {
						    	osr = new OutputStreamWriter(fout, "UTF-16BE");
						    	osr.write('\uFFFE');
						    } else {
						    	// UTF-16LE as default
						    	osr = new OutputStreamWriter(fout, "UTF-16LE");
						    	osr.write('\uFEFF');
						    }
						    osr.write(content);
						    osr.close();
						    fout.close();
						    if (pluginID.compareTo("gencon") == 0)
						    	if (fileName.contains(File.separator))
						    		report.addGenConfmlReport(fileName.substring(fileName.lastIndexOf(File.separator) + 1) + " (" + comment + ")", dir.getPath(), dir.getAbsolutePath());
						    	else
						    		report.addGenConfmlReport(fileName + " (" + comment + ")", dir.getPath(), dir.getAbsolutePath());
						    else 
						    	report.addCenRepReport(fileName, dir.getPath(), dir.getAbsolutePath());
						}
						catch (IOException e)
						{
							System.err.println (e.getMessage());
							if (pluginID.compareTo("gencon") == 0) report.addGenConfmlError("Couldn't save file "+fileName, e.getMessage());
							else report.addCenRepError("Couldn't save file "+fileName, e.getMessage());
						}
					}
				}
			}
		}
	}
	
	public void saveIBYFile(IBYFile iby){
		//for each folder
		String location = getLocation(iby);
		//Map<folder, Map<source/fileName,targetPath>>
		Map<String, Map<String,String>> folder2FileName = new HashMap<String, Map<String,String>>();
		for(Entry entry : iby.getEntries()){
			groupFilesIntoFolder(entry,folder2FileName);
		}
		for(String folder:folder2FileName.keySet()){
			saveIBYFile(location, folder,iby.getName(),iby.getFlag(),folder2FileName.get(folder));
		}
	}
	
	private void groupFilesIntoFolder(Entry entry, Map<String, Map<String, String>> folder2FileName) {
		FileName fName = entry.getFileName();
		if (fName.getFiles() == null) return;
		for (String folderFileName : (Set<String>) fName.getFiles().keySet()) {
			String folder = "";
			String fileName = folderFileName;
			if (fName.getPlugin().equals("gencon")) {
				if (folderFileName.startsWith(File.separator)) {
					// Remove genconfml variant configuration to folder string
					folder = folderFileName.substring(1, folderFileName.indexOf(File.separator, 1));
					fileName = folderFileName.substring(folderFileName.indexOf(File.separator, 1) + 1);
				}
			} else if (folderFileName.lastIndexOf(File.separator) != -1) {
				folder = folderFileName.substring(0, folderFileName.lastIndexOf(File.separator));
				fileName = folderFileName.substring(folderFileName.lastIndexOf(File.separator) + 1, folderFileName.length());
			}
			fileName = entry.getSource().getGvalue() + fileName;
			Map<String, String> src2target = folder2FileName.get(folder);
			if (src2target == null) {
				src2target = new HashMap<String, String>();
				folder2FileName.put(folder, src2target);
			}
			if (entry.getFileName().getTargets() != null && !entry.getFileName().getTargets().get(folderFileName).equals(null) && !entry.getFileName().getTargets().get(folderFileName).equals("")) {
				// Genconfml target attribute overrules GenconfmlIby/TargetPath setting
				//System.out.println(entry.getFileName().getTargets().get(folderFileName));
				src2target.put(fileName, (String) entry.getFileName().getTargets().get(folderFileName));
			} 
			else 
			{
				if (fName.getPlugin().equals("gencon"))
					src2target.put(fileName, ""); //don't take the targetPath from confml setting. It shouldn't be used anymore.
				else
					src2target.put(fileName, entry.getTarget().getGvalue());
			}
				
		}
	}
	
	private void saveIBYFile( String location ,String iFolder,String iIbyFileName,String iFlag, Map<String,String> files)
	{
		String folder=!iFolder.isEmpty()?iFolder:COMMON_FOLDER;
		String ibyFileName;
		if (folder.contains(File.separator)) ibyFileName = folder.substring(folder.lastIndexOf(File.separator) + 1) + iIbyFileName; // Special case when genconfml already contains folder
		else ibyFileName = folder + iIbyFileName;
		String flag = "__"+folder.toUpperCase()+"_"+iFlag+"__";
		
		StringBuffer content = new StringBuffer();
		if ( flag != null)
		{
			content.append( "#ifndef " + flag + EOL );
			content.append( "#define " + flag + EOL+EOL );
		}
		for ( String srcFileName : files.keySet() )
		{
			String fileName = srcFileName.substring(srcFileName.lastIndexOf("\\")+1,srcFileName.length());
			String target = files.get(srcFileName);
			if (target == null) 
				target = "";
			if(fileName.compareTo(RFS_FILE_NAME)==0)
			{
				if (location.endsWith(File.separator))
					saveRFSfile(location+folder,srcFileName);
				else
					saveRFSfile(location+File.separator+folder,srcFileName);
			}else{
				content.append("data="+variantLocationVar+"\\"+srcFileName+"\t\t"+target+fileName+EOL);
			}
		}
		if(flag!=null)
			content.append(EOL+"#endif "+"//"+flag+EOL);
		FileOutputStream fout=null;
		try
		{
			if (location.endsWith(File.separator))
				location = location.substring(0, location.length()-1);
			String filePath = location+File.separator+folder+File.separator+ibyFileName;
		    System.out.println(filePath);
			fout = new FileOutputStream(filePath);
		    Writer osr = new OutputStreamWriter(fout,"US-ASCII");
		    
		    osr.write(content.toString());
		    osr.close();
		    fout.close();
		    report.addIBYReport(ibyFileName, location+File.separator+folder, ""); //no absolute path needed
		}
		catch (IOException e)
		{
			System.err.println (e.getMessage());
			report.addIBYError("Couldn't save file "+ibyFileName, e.getMessage());
		}
	}
	
	void saveRFSfile(String path,String srcFileName){
		StringBuffer content = new StringBuffer();
		content.append( "#ifndef " + RFS_FLAG + EOL );
		content.append( "#define " + RFS_FLAG + EOL+EOL );
		content.append( "data="+variantLocationVar+"\\"+srcFileName+"\t\t"+RFS_TARGET+EOL );
		content.append(EOL+"#endif "+"//"+RFS_FLAG+EOL);
		
		FileOutputStream fout=null;
		try
		{
			String filePath = path+File.separator+RFS_IBY_FILE;
		    fout = new FileOutputStream(filePath);
		    Writer osr = new OutputStreamWriter(fout,"US-ASCII");
		    
		    osr.write(content.toString());
		    osr.close();
		    fout.close();
		    report.addIBYReport(RFS_IBY_FILE, path, "");
		}
		catch (IOException e)
		{
			System.err.println (e.getMessage());
			report.addIBYError("Couldn't save file "+RFS_IBY_FILE, e.getMessage());
		}
		
	}
	
	public void reset(){
		if(configurableEntities!=null)
			for(Entity entity : configurableEntities)
				entity.setGvalue(null);
		configurableEntities=null;
		fileExpectingEntities=null;
	}
	
		public String[] getSrcPlugin(){
		FileName[] fnames = getFileExpectingEntities();
		String[] result = new String[fnames.length];
		for(int i=0;i<fnames.length;i++)
			result[i]=fnames[i].getPlugin();
		return result;
	}
	
	private FileName[] getFileExpectingEntities(){
		if(fileExpectingEntities==null){
			List<FileName> result = new ArrayList<FileName>();
			for(IBYFile iby : ibys){
				for(Entry entry : iby.getEntries()){
					if(entry.getFileName().getPlugin()!=null)
						result.add(entry.getFileName());
				}
			}
			fileExpectingEntities=result.toArray(new FileName[result.size()]);
		}
		return fileExpectingEntities;
	}
	
	private String getLocation(IBYFile iby)
	{
		String[] folders = GenerateManager.getOutputFolders();
		if (folders == null || folders[0].equals(""))
			return iby.getLocationt().getGvalue();
		else
			return folders[0];
	}
	
	/*
	private Entity[] getConfigurableEntities(){
		if(configurableEntities==null){
			List<Entity> result = new ArrayList<Entity>();
			for(IBYFile iby : ibys){
				if(iby.getLocationt()!=null&&iby.getLocationt().getRef()!=null)result.add(iby.getLocationt());
				for(Entry entry : iby.getEntries()){
					if(entry.getFileName()!=null&&entry.getFileName().getRef()!=null)result.add(entry.getFileName());
					if(entry.getSource()!=null&&entry.getSource().getRef()!=null)result.add(entry.getSource());
					if(entry.getTarget()!=null&&entry.getTarget().getRef()!=null)result.add(entry.getTarget());
				}
			}
			configurableEntities=result.toArray(new Entity[result.size()]);
		}
		return configurableEntities;
	}
	*/
	
}

