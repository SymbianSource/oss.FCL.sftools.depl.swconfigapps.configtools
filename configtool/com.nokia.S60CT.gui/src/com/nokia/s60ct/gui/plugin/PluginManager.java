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

package com.nokia.s60ct.gui.plugin;

import interfaces.IPluginInitializer;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;

public class PluginManager {
	
	public static final String EP_IMPL_GUI = "com.nokia.S60CT.impl.gui";
	public static final String EP_IMPL_GUI_FLEXT_EL = "fileExtension";
	public static final String EP_IMPL_GUI_FLEXT_VALUE = "value";
	public static final String EP_IMPL_GUI_VIEW_EL = "view";
	public static final String EP_IMPL_GUI_VIEW_ID = "view_id";
	
	public static final String PLUGIN_INIT = "startup.initializer";
	public static final String PLUGIN_INIT_CLASS ="class";
	
	IExtension[] extensions = null;
	String[] pNames = null;
	String[] fileExtensions = null;
	String[] view_ids = null;
	IPluginInitializer[] plugin_inits = null;
	
	String perspectives = null;
	public static final String PEPSPECTIVE_EP = "org.eclipse.ui.perspectives"; 
	public static final String PERSPECTIVE_ID ="id";
	public static final PluginManager INSTANCE = new PluginManager();
	
	public PluginManager(){
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IExtensionPoint point = registry.getExtensionPoint(EP_IMPL_GUI);
		extensions = point.getExtensions();
		
	}
	
	public String[] getFileExtensions(){
		if(fileExtensions==null){
			fileExtensions = getAttributeValue(EP_IMPL_GUI_FLEXT_EL, EP_IMPL_GUI_FLEXT_VALUE);
		}
		return fileExtensions;
	}
	
	public String[] getPNames(){
		if(pNames==null){
			pNames = new String[extensions.length];
			for (int i = 0; i < extensions.length; i++) 
				pNames[i] = extensions[i].getLabel();
		}
		return pNames;
	}
	
	public String[] getPluginViews(){
		if(view_ids==null){
			view_ids=getAttributeValue(EP_IMPL_GUI_VIEW_EL, EP_IMPL_GUI_VIEW_ID);
		}
		return view_ids;
	}
	
	public IPluginInitializer[] getPluginInitializers(){
		if(plugin_inits==null){
			List<IPluginInitializer> listInitializers = new ArrayList<IPluginInitializer>();
			IExtension[] extensions = Platform.getExtensionRegistry().getExtensionPoint(PLUGIN_INIT).getExtensions();
			for(int i=0;i<extensions.length;i++){
				IConfigurationElement[] elements = extensions[i].getConfigurationElements();
				for(int j=0;j<elements.length;j++){
					IPluginInitializer pluginInitializer=null;
					try{
						pluginInitializer = (IPluginInitializer)elements[j].createExecutableExtension(PLUGIN_INIT_CLASS);
					}catch(Exception e){
						System.out.println(e.getMessage());
					}
					if(pluginInitializer!=null)listInitializers.add(pluginInitializer);
				}
			}
			plugin_inits=listInitializers.toArray(new IPluginInitializer[listInitializers.size()]);
		}
		return plugin_inits;
	}
	
	private String[] getAttributeValue(String elementName, String attributeName){
		List list = new ArrayList();
		for(int i=0;i<extensions.length;i++){
			IExtension extension = extensions[i];
			IConfigurationElement[] elements = extension.getConfigurationElements();
			for(int j=0;j<elements.length;j++){
				IConfigurationElement element = elements[j];
				if(element.getName().equals(elementName))
					list.add(element.getAttribute(attributeName));
			}
		}
		String[] result = new String[list.size()];
		for(int i=0;i<list.size();i++)
			result[i]=(String)list.get(i);
		return result;
	}

	public String getAllPerspectivesID(){
		if(perspectives==null){
			List listInitializers = new ArrayList();
			IExtension[] extensions = Platform.getExtensionRegistry().getExtensionPoint(PEPSPECTIVE_EP).getExtensions();
			for(int i=0;i<extensions.length;i++){
				IConfigurationElement[] elements = extensions[i].getConfigurationElements();
				for(int j=0;j<elements.length;j++){
					String perspectiveID=null;
					try{
						perspectiveID = elements[j].getAttribute(PERSPECTIVE_ID);
					}catch(Exception e){
						System.out.println(e.getMessage());
					}
					if(perspectiveID!=null)
						if(perspectives==null)perspectives=perspectiveID;
						else perspectives=perspectives+", "+perspectiveID;
				}
			}
		}
		return perspectives;
	}
	
}
