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
package com.nokia.s60ct.genconfml;

import gcmodel.util.GcmodelResourceImpl;
import interfaces.IPluginInitializer;

import java.io.File;
import java.util.ArrayList;

import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.osgi.service.prefs.Preferences;

import constants.IS60CTCommonConstants;

public class GenConfMlPluginInitializer implements IPluginInitializer
{
	private static GenConfMlPluginInitializer instance = null;
	
	private static final String GENCONFML_CONF_NODE = "GENCONFML";
	private static final String GENCONFML_CONF_PATH = "PATH";
	private static final String GENCONFML_EXTENSION = ".gcfml";
	private static final String CONFML_EXTENSION = ".confml";
	private static final String CRML_EXTENSION = ".crml";
	private static final String[] GENCONFML_DEFAULT_PATHS = {"genconfml", "\\epoc32\\rom\\config\\confml_data\\s60\\"};
	
	private ArrayList<gcmodel.File> fileArray = new ArrayList<gcmodel.File>();
	private ArrayList<String> unknownArray = new ArrayList<String>();
	
	/**
	 * Singleton constructor
	 */
	public GenConfMlPluginInitializer()
	{
		if (instance == null)
		{
			instance = this;
		}
	}

	/**
	 * @see IPluginItializer
	 */
	public void init()
	{
		fileArray.clear();
		unknownArray.clear();
		IEclipsePreferences ePrefs = new ConfigurationScope().getNode(IS60CTCommonConstants.S60_PREFERENCES);
		Preferences prefs = ePrefs.node(GENCONFML_CONF_NODE);
		String[] paths = prefs.get(GENCONFML_CONF_PATH, "").trim().split(File.pathSeparator);
		if (paths[0].equals("")) paths = GENCONFML_DEFAULT_PATHS; // Prefs file not found, use hardcoded defaults
		for (int i = 0; i < paths.length; i++)
		{
			File file = new File(paths[i]);
			openGenConfMl(file);
		}
	}
	
	public void init(String[] paths)
	{
		fileArray.clear();
		unknownArray.clear();
		if (paths[0].equals("")) paths = GENCONFML_DEFAULT_PATHS; // Use hardcoded defaults
		for (int i = 0; i < paths.length; i++)
		{
			File file = new File(paths[i]);
			openGenConfMl(file);
		}
	}

	/**
	 * Opens GenConfML file or directory and adds them as resources
	 * @param file File or directory to open
	 */
	public void openGenConfMl(File file)
	{
		if (file.exists())
		{
			if (file.isDirectory())
			{
				String[] files = file.list();
				for (int i = 0; i < files.length; i++)
				{
					openGenConfMl(new File(file.getAbsolutePath() + File.separator + files[i]));
				}
			}
			else
			{
				if (file.isFile() && file.getAbsolutePath().endsWith(GENCONFML_EXTENSION))
				{
//					GenConfMlFile newFile = new GenConfMlFile(file);
					Resource resource = new GcmodelResourceImpl(URI.createFileURI(file.getAbsolutePath()));
					try
					{
						resource.load(null);
					}
					catch (Exception e)
					{
						unknownArray.add(e.getMessage());
					}
					// Get XML contents and fill in GenConfMlFile
					if(!resource.getContents().isEmpty())
					{
						gcmodel.File fileModel  = (gcmodel.File)resource.getContents().get(0);
						fileModel.setParent(resource.getURI().toFileString());
						fileArray.add(fileModel);
					}
				} 
				else if (!file.getName().equals("Distribution.Policy.S60") && 
						 !file.getName().endsWith(CONFML_EXTENSION) && 
						 !file.getName().endsWith(CRML_EXTENSION)){
					// Add file to unknown files array
					unknownArray.add(file.getAbsolutePath() + ": unknown file");
				}
			}
		}
	}
	
	/**
	 * Returns GenConfML files
	 * @return Array of GenConfML files
	 */
	public gcmodel.File[] getFileModels()
	{
		//init(); // Re-read gcfml files. IF used in ibuild env, validation slows down a lot!!!
		return fileArray.toArray(new gcmodel.File[fileArray.size()]);
	}
	
	/**
	 * Returns unknown files
	 * @return Array of unknown files
	 */
	public String[] getUnknownFiles()
	{
		return unknownArray.toArray(new String[unknownArray.size()]);
	}
	
	/**
	 * Singleton instance
	 * @return Class instance
	 */
	public static GenConfMlPluginInitializer getInstance()
	{
		if (instance == null)
		{
			instance = new GenConfMlPluginInitializer();
		}
		return instance;
	}
}
