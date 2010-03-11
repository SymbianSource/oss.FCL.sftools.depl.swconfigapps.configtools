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
package init;

import interfaces.IPluginInitializer;

import java.io.File;

import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.osgi.service.prefs.BackingStoreException;
import org.osgi.service.prefs.Preferences;

import IBY.IBYFile;
import IBY.util.IBYResourceFactoryImpl;
import constants.IS60CTCommonConstants;

public class IBYPluginInitializer implements IPluginInitializer {

	//preferences file support
	private static final String IBY_CONF_NODE="IBY";
	private static final String IBY_CONF_PATH="PATH";
	private static final String IBY_EXTENSION = ".ibyml";
	
	ResourceSet resourceSet =  new ResourceSetImpl();
	private static IBYPluginInitializer INSTANCE = null;
	
	public IBYPluginInitializer() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ibyml", new IBYResourceFactoryImpl());
		if(INSTANCE==null)INSTANCE=this;
	}

	public void init() {
		IEclipsePreferences ePref= new ConfigurationScope().getNode(IS60CTCommonConstants.S60_PREFERENCES);
		Preferences pref=ePref.node(IBYPluginInitializer.IBY_CONF_NODE);
		String[] paths = pref.get(IBYPluginInitializer.IBY_CONF_PATH, "").trim().split(File.pathSeparator);
		for(int i=0;i<paths.length;i++){
			File file=new File(paths[i]);
			openIBYML(file);
		}
		updateLocationInfoInPrefs();
	}
	
	
	private void updateLocationInfoInPrefs() {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<resourceSet.getResources().size();i++)
		{
			if (!resourceSet.getResources().get(i).getContents().isEmpty())
			{
				IBYFile file =(IBYFile)resourceSet.getResources().get(i).getContents().get(0);
				String location = file.getLocationt().getValue();
				sb.append(location);
				sb.append(File.pathSeparator);
			}
		}
		IEclipsePreferences ePref= new ConfigurationScope().getNode(IS60CTCommonConstants.S60_PREFERENCES);
		ePref.put(IS60CTCommonConstants.IBY_OUTPUT_FOLDER, sb.toString());
		try 
		{
			ePref.flush();
		} 
		catch (BackingStoreException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public boolean openIBYML(File file) //mode is also here, because init is not called from CT CLI application. 
	{
		if (file.exists())
		{
			if(file.isDirectory())
			{
				String[] files=file.list();
				boolean found = false;
				for(int j=0;j<files.length;j++)
				{
					if (openIBYML(new File(file.getAbsolutePath()+File.separator+files[j])))
						found = true;
				}
				return found;	
			}
			else if(file.isFile()&&file.getAbsolutePath().endsWith(IBYPluginInitializer.IBY_EXTENSION))
			{
				resourceSet.getResource(URI.createFileURI(file.getAbsolutePath()), true);
				System.out.println("IBY file @ "+file.getPath());
				return true;
			}
			return false;
		}
		else
			return false;
		
	}

	public void setOutputLocation(String path)
	{
		for(int i=0;i<resourceSet.getResources().size();i++)
		{
			if (!resourceSet.getResources().get(i).getContents().isEmpty())
			{
				IBYFile file =(IBYFile)resourceSet.getResources().get(i).getContents().get(0);
				file.getLocationt().setValue(path);
			}
		}
	}
	
	public IBYFile[] getIBYFiles() {
		IBYFile[] result=new IBYFile[resourceSet.getResources().size()];
		for(int i=0;i<resourceSet.getResources().size();i++)
		{
			if (!resourceSet.getResources().get(i).getContents().isEmpty())
				result[i]=(IBYFile)resourceSet.getResources().get(i).getContents().get(0);
		}
		return result;
	}

	public static IBYPluginInitializer getINSTANCE() {
		return INSTANCE;
	}
}
