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

package com.nokia.s60ct.generate;

import java.util.Vector;

public class GenerationReport
{

	private Vector cenrepErrors = null;
	private Vector cenrepGeneratedFiles = null;
	
	private Vector genconErrors = null;
	private Vector genconGeneratedFiles = null;
	
	private Vector ibyErrors = null;
	private Vector ibyGeneratedFiles = null;
	
	public static final int TYPE_CENREP = 1;
	public static final int TYPE_GENCONFML = 2;
	public static final int TYPE_IBY = 3;
	
	public class Error
	{
		String errorTitle;
		String errorDetails;
		
		public Error(String title, String details)
		{
			this.errorTitle = title;
			this.errorDetails = details;
		}
		public String getErrorTitle()
		{
			return errorTitle;
		}
		public String getErrorDetails()
		{
			return errorDetails;
		}
		
	}
	
	public class GeneratedFile
	{
		String fileName;
		String relativePath;
		String absolutePath;
		
		public GeneratedFile(String fileName, String relativePath, String absolutePath)
		{
			this.fileName = fileName;
			this.relativePath = relativePath;
			this.absolutePath = absolutePath;
		}
		public String getFileName()
		{
			return fileName;
		}
		public String getRelativePath()
		{
			return relativePath;
		}
		public String getAbsolutePath()
		{
			return absolutePath;
		}
		
	}
	
	public GenerationReport()
	{
		cenrepErrors = new Vector();
		cenrepGeneratedFiles = new Vector();
		genconErrors = new Vector();
		genconGeneratedFiles = new Vector();
		ibyErrors = new Vector();
		ibyGeneratedFiles = new Vector();
	}
	
	public void addCenRepError(String errorTitle, String errorDetails)
	{
		cenrepErrors.add(new Error(errorTitle, errorDetails));
	}
	public void addGenConfmlError(String errorTitle, String errorDetails)
	{
		genconErrors.add(new Error(errorTitle, errorDetails));
	}
	public void addIBYError(String errorTitle, String errorDetails)
	{
		ibyErrors.add(new Error(errorTitle, errorDetails));
	}
	
	

	public void addCenRepReport(String file, String relativePath, String absolutePath)
	{
		cenrepGeneratedFiles.add(new GeneratedFile(file, relativePath, absolutePath));
	}
	public void addGenConfmlReport(String file, String relativePath, String absolutePath)
	{
		genconGeneratedFiles.add(new GeneratedFile(file, relativePath, absolutePath));
	}
	public void addIBYReport(String file, String relativePath, String absolutePath)
	{
		ibyGeneratedFiles.add(new GeneratedFile(file, relativePath, absolutePath));
	}
	
	
	public Error[] getErrors(int type)
	{
		
		Vector v = null;
		if (type == TYPE_CENREP)
			v = cenrepErrors;
		else if (type == TYPE_GENCONFML)
			v = genconErrors;
		else if (type == TYPE_IBY)
			v = ibyErrors;
		
		if (v == null || v.size()==0)
			return null;
		Object[] oArray = v.toArray();
		Error[] errors = new Error[oArray.length];
		for (int i = 0 ; i < oArray.length ; i++)
			errors[i] = (Error)oArray[i];
		return errors;
	}
	
	private Object[] sortVector(Vector v)
	{
		Object[] oArray = v.toArray();
		
		boolean sorted = false;
		
		do
		{
			sorted = true;
			
			for (int i = 0 ; i < oArray.length-1 ; i++)
			{
				GeneratedFile f1 = (GeneratedFile)oArray[i];
				GeneratedFile f2 = (GeneratedFile)oArray[i+1];
				
				String s1 = f1.getRelativePath()+f1.getFileName();
				String s2 = f2.getRelativePath()+f2.getFileName();
				
				if (s1.compareTo(s2)>0)
				{
					oArray[i+1] = f1;
					oArray[i] = f2;
					sorted = false;
				}
			}
		}
		while (!sorted);
		
		return oArray;
	}
	
	public GeneratedFile[] getGeneratedFiles(int type)
	{
		Vector v = null;
		if (type == TYPE_CENREP)
			v = cenrepGeneratedFiles;
		else if (type == TYPE_GENCONFML)
			v = genconGeneratedFiles;
		else if (type == TYPE_IBY)
			v = ibyGeneratedFiles;
		else
			return null;
		
		if (v == null || v.size()==0)
			return null;
		Object[] oArray = sortVector(v);
		GeneratedFile[] files = new GeneratedFile[oArray.length];
		for (int i = 0 ; i < oArray.length ; i++)
			files[i] = (GeneratedFile)oArray[i];
		return files;
	}
	

}

