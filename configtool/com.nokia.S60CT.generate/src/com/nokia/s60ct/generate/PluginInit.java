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

import interfaces.IPluginInitializer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;

import com.nokia.s60ct.interfaces.IContentCreator;
import com.nokia.s60ct.interfaces.IPlugin;
import com.nokia.s60ct.interfaces.ISaveContent;

public class PluginInit implements IPluginInitializer{

	private static PluginInit INSTANCE;
	
//	Extension point related variables
	public static final String EX_GENERATE = "confml.generate";
	public static final String EX_NAME = "generator";
	public static final String EX_GENERATOR_ID = "generator_id";
	public static final String EX_GENERATE_CALL = "generate_call";
	
	IExtension[] extensions = null;
	
	Map pluginGenerate = new HashMap();
	Map pluginGenerate2 = new HashMap();
	
	//
	private Object[][] plugins = null;
	private static final int PLUGIN_ID_INDEX=0;
	private static final int CLASS_INDEX=1;
	private static final int ARRAY_SIZE=2;
	
	public PluginInit(){
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		if(registry!=null){
			IExtensionPoint point = registry.getExtensionPoint(EX_GENERATE);
			extensions = point.getExtensions();
			INSTANCE=this;
		}
	}
	
	public static final PluginInit getInstance(){
		return INSTANCE;
	}
	
	// changePlugin("iby",myNewPlugin)
	public void changePlugin(String pluginID, IPlugin plugin){
		for(Object[] pluginPair : plugins){
			String existID = (String)pluginPair[PLUGIN_ID_INDEX];
			if(existID.compareTo(pluginID)==0){
				pluginPair[CLASS_INDEX]=plugin;
			}
		}
	}
	
	public void excludePlugin(IPlugin plugin)
	{
		for(Object[] pluginPair : plugins){
			IPlugin existPlugin = (IPlugin)pluginPair[CLASS_INDEX];
			if(existPlugin != null && existPlugin.getClass().equals(plugin.getClass())){
				pluginPair[CLASS_INDEX]=null; //null plugin is excluded
			}
		}
	}
	
	public void init() {
		plugins = new Object[extensions.length][ARRAY_SIZE];
		for(int i=0;i<extensions.length;i++){
			IConfigurationElement[] elements = extensions[i].getConfigurationElements();
			for(int j=0;j<elements.length;j++){
				IConfigurationElement element = elements[j];
				if(element.getName().endsWith(EX_NAME)){
					String generator_id = element.getAttribute(EX_GENERATOR_ID);
					IPlugin plugin = null;
					try{
						plugin=(IPlugin)element.createExecutableExtension(EX_GENERATE_CALL);
					}catch(CoreException e){
						System.err.println(e.getMessage());
					}
					plugins[i][PLUGIN_ID_INDEX]=generator_id;
					plugins[i][CLASS_INDEX]=plugin;
				}
			}
		}
	}
	//returns all plugins, one and two
	public IPlugin[] getAllPlugins(){
		IPlugin[] result = new IPlugin[plugins.length];
		for(int i=0;i<plugins.length;i++)
			result[i]=(IPlugin)plugins[i][CLASS_INDEX];
		return result;
	}
	
	public ISaveContent[] getSaveContentPlugins(String pluginID){
		Set<ISaveContent> result = new HashSet<ISaveContent>();
		List<ISaveContent> allSaveContents = getSaveContents();
		for(ISaveContent plugin : allSaveContents){
			for(String creatorID : plugin.getSrcPlugin())
				if(creatorID.compareToIgnoreCase(pluginID)==0)result.add(plugin);
		}
		return result.toArray(new ISaveContent[result.size()]);
	}

	private List<ISaveContent> getSaveContents() {
		List<ISaveContent> allSaveContents = new ArrayList<ISaveContent>();
		for(int i=0;i<plugins.length;i++){
			IPlugin plugin = (IPlugin)plugins[i][CLASS_INDEX];
			if(plugin != null && plugin instanceof ISaveContent)
				allSaveContents.add((ISaveContent)plugin);
		}
		return allSaveContents;
	}

	public String findPluginID(IContentCreator contentCreator) {
		String thePluginID=null;
		for(int i=0;i<plugins.length&&thePluginID==null;i++){
			IPlugin plugin = (IPlugin)plugins[i][CLASS_INDEX];
			String pluginID= (String)plugins[i][PLUGIN_ID_INDEX];
			if(plugin!= null && plugin.equals(contentCreator))thePluginID=pluginID;
		}
		return thePluginID;
	}
	
	public IContentCreator[] getContentCreators(){
		List<IContentCreator> allContentCreators = new ArrayList<IContentCreator>();
		for(int i=0;i<plugins.length;i++){
			IPlugin plugin = (IPlugin)plugins[i][CLASS_INDEX];
			if (plugin == null) //plugin excluded
				continue;
			if(plugin instanceof IContentCreator)
				allContentCreators.add((IContentCreator)plugin);
		}
		return allContentCreators.toArray(new IContentCreator[allContentCreators.size()]);
	}
	
}
