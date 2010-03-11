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

import helpers.ExceptionMessageConverter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import variantdata.VariantData;
import variantdata.util.VariantDataResourceFactoryImpl;
import cenrep.Repository;
import cenrep.util.CenrepResourceFactoryImpl;

import com.nokia.s60ct.generate.GenerationReport;

import configurationemf.RootConf;
import configurationemf.util.ConfigurationemfResourceFactoryImpl;


class ResourceManager implements IResourceManager {
	
	ResourceSet resourceSet = null;
	
	Map<String,Class> map = new HashMap<String, Class>();
	
	// filters
	private final ExtensionFilter TYPE_FILTER = new ExtensionFilter();
	private final FolderFilter FOLDER_FILTER = new FolderFilter();
	
	private final static String EOL = System.getProperty("line.separator");
	
	public ResourceManager(){
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(CONFML, new ConfigurationemfResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(VD, new VariantDataResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(CRML, new CenrepResourceFactoryImpl());
		
		resourceSet = new ResourceSetImpl();
		
		map.put(CRML, Repository.class);
		map.put(VD, VariantData.class);
		map.put(CONFML, RootConf.class);
	}
	
	/* (non-Javadoc)
	 * @see com.nokia.s60ct.cli.IResourceManager#readResource(java.lang.String)
	 */
	public Object readResource(String filePath){
		try
		{
			Resource resource = resourceSet.getResource(URI.createFileURI((new File(filePath)).getAbsolutePath()), true);
			resource.load(null);
			EcoreUtil.resolveAll(resourceSet);
			
			EObject obj = resource.getContents().get(0);
			if ( obj instanceof RootConf)
			{
				RootConf rootConf = (RootConf)obj;
				for (RootConf includedConf: rootConf.getInclude())
				{
					if (includedConf.eIsProxy())
					{
						URI uri = EcoreUtil.getURI(includedConf);
						String uriString = uri.toFileString();
						
						System.out.println("ERROR: Invalid file: "+uriString);
						System.err.println("ERROR: Invalid file: "+uriString);
					}
				}
			}
			return obj;
		}
		catch (Exception e) {//this exception is caused by ANSI format or any error in XML.
			int startIndex = e.getMessage().indexOf(": ")+2;
			String message = e.getMessage().substring(startIndex);
			System.out.println("ERROR: Invalid file "+filePath+". "+ExceptionMessageConverter.convertMessage(message));
			System.err.println("ERROR: Invalid file "+filePath+". "+ExceptionMessageConverter.convertMessage(message));
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.nokia.s60ct.cli.IResourceManager#readAllResources(java.lang.String[], java.lang.String)
	 */
	public <T extends EObject> T[] readAllResources(String[] paths, String type) {
		Set<T> result = new HashSet<T>();
		for(String path : paths){
			File file = new File((new File(path)).getAbsolutePath());
			readFile(file,result,type);
		}
		T[] tarr = (T[])Array.newInstance(getClassByType(type), result.size());
		return result.toArray(tarr);
	}
	

	private Class<? extends EObject> getClassByType(String type) {
		return map.get(type);
	}

	private <T> void readFile(File file, Set<T> result,String type) {
		if(file.isDirectory()){
			File[] contents = file.listFiles(TYPE_FILTER.setExtension(type));
			File[] dirs = file.listFiles(FOLDER_FILTER);
			for(File content:contents){
				Object resource = readResource(content.getAbsolutePath());
				if (resource != null)
					result.add((T)resource);
			}
			for(File dir : dirs){
				readFile(dir, result, type);
			}
		}else if(file.getAbsolutePath().endsWith(type)){
			Object resource = readResource(file.getAbsolutePath());
			if (resource != null)
				result.add((T)resource);
		}
		
	}

	/* (non-Javadoc)
	 * @see com.nokia.s60ct.cli.IResourceManager#save(org.eclipse.emf.ecore.EObject, java.lang.String)
	 */
	public void save(EObject eObj, String masterFilePath) {
		Resource resource = eObj.eResource();
		if(resource==null){
			resource = resourceSet.createResource(URI.createFileURI(masterFilePath));
			resource.getContents().add(eObj);
		}
		try{
			resource.save(null);
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	/* (non-Javadoc)
	 * @see com.nokia.s60ct.cli.IResourceManager#copyFiles(java.lang.String, java.lang.String, java.lang.String)
	 */
	public void copyFiles(String srcFolderPath, String targetFolderPath,final String type) {
		File srcFolder = new File(srcFolderPath);
		File targetFolder = new File(targetFolderPath);
		
		if (srcFolder.exists() && srcFolder.isDirectory()
				&& targetFolder.exists() && targetFolder.isDirectory()) {
			File[] files = srcFolder.listFiles(TYPE_FILTER.setExtension(type));
			for (File file : files) {
				try {
					copyFile(file, new File(targetFolder.getAbsolutePath()
							+ File.separatorChar + file.getName()));
				} catch (IOException e) {
					System.err.println(e.getMessage());
				}
			}
			File[] folders = srcFolder.listFiles(FOLDER_FILTER);
			for (File folder : folders) {
				copyFiles(folder.getAbsolutePath(), targetFolder.getAbsolutePath(),type);
			}
		}
	}

	private void copyFile(File srcFile, File destFile) throws IOException {
		InputStream in = new FileInputStream(srcFile);
		OutputStream out = new FileOutputStream(destFile);
		final int bufferSize = 4 * 1024;
		byte[] buffer = new byte[bufferSize];
		int bytesRead;
		while ((bytesRead = in.read(buffer)) >= 0) {
			out.write(buffer, 0, bytesRead);
		}
		out.close();
		in.close();
	}
	
	private final class ExtensionFilter implements FilenameFilter {
		String extension = null;

		public ExtensionFilter() {
		}

		public boolean accept(File arg0, String name) {
			return name.endsWith(extension);
		}

		public ExtensionFilter setExtension(String extension) {
			this.extension = "."+extension;
			return this;
		}
	}

	private final class FolderFilter implements FilenameFilter {

		public FolderFilter() {
		}

		public boolean accept(File file, String name) {
			File folder = new File(file.getAbsoluteFile() + File.separator
					+ name);
			return folder.isDirectory();
		}
	}

	public void saveReportFile(Vector vReports, String reportFile)
	{
		Object[] reports = vReports.toArray();
		Vector vFiles = new Vector(10);
		int type = GenerationReport.TYPE_CENREP;
		for (int i = 0 ; i < reports.length ; i++)
		{
			GenerationReport report = (GenerationReport)reports[i];
			if (report == null) 
				continue;
			
			GenerationReport.GeneratedFile[] files = report.getGeneratedFiles(type);
			
			if (files != null)
				for (int j = 0 ; j < files.length ; j++)
					vFiles.add(files[j]);
		}
		StringBuffer content = new StringBuffer();
		for (int i = 0 ; i < vFiles.size(); i++)
		{
			GenerationReport.GeneratedFile file = (GenerationReport.GeneratedFile)vFiles.elementAt(i);
			content.append(file.getAbsolutePath()+File.separator+file.getFileName()+EOL);
		}
		File report = new File((new File(reportFile).getAbsolutePath())); 
        FileOutputStream fout=null; 
        try 
        { 
            fout = new FileOutputStream(report.getAbsolutePath()); 
            Writer osr = new OutputStreamWriter(fout,"US-ASCII"); 
            osr.write(content.toString()); 
            osr.close(); 
            fout.close(); 
            System.out.println("Report file saved to "+report.getAbsolutePath());
        } 
        catch (IOException e) 
        { 
           System.err.println (e.getMessage()); 
        } 
	}
	
	public void cleanOutputFolders(String[] folders)
	{
		for (int i = 0; i < folders.length; i++) {
			File f = new File(folders[i]);
			deleteDir(f);
		}
	}
	
	private boolean deleteDir(File dir) {
		if (dir.isDirectory()) {
			String[] children = dir.list();
			for (int i=0; i<children.length; i++) {
				boolean success = deleteDir(new File(dir, children[i]));
				if (!success) {
					return false;
				}
			}
		}

		// The directory is now empty so delete it
		return dir.delete();
	} 
	
}
