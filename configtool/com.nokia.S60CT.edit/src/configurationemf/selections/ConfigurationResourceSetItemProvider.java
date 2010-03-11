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
package configurationemf.selections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.provider.resource.ResourceSetItemProvider;

import configurationemf.RootConf;


public class ConfigurationResourceSetItemProvider 
	extends ResourceSetItemProvider{
	
	
	//selections
	public static String BY_CONFIGURATION = "by_configuration";
	public static String BY_FEATURE = "by_feature";
	public static String BY_VIEW = "by_view";
	
	//selected = root element in content provider
	private String selected = ConfigurationResourceSetItemProvider.BY_CONFIGURATION;
	private ResourceSet resourceSet=null;
	
	
	public ConfigurationResourceSetItemProvider(AdapterFactory adapterFactory)
	  {
	    super(adapterFactory);
	  }

	public ConfigurationResourceSetItemProvider(AdapterFactory adapterFactory, String selection)
	{
		super(adapterFactory);
		this.selected = selection; 
	}
	
	public Collection getChildren(Object object)
	  {
	    List children = new ArrayList();
		this.resourceSet = (ResourceSet)object;
	    for(Iterator iResource =resourceSet.getResources().iterator();iResource.hasNext();){
	    	Resource resource =(Resource)iResource.next();
	    	if(!resource.getContents().isEmpty())
	    	{
		    	RootConf rootConf = (RootConf)resource.getContents().get(0);
		    	if(rootConf.getRoot()==null) 
		    		children.add(resource.getContents().get(0));
	    	}
	    }
		return children;
	  }
	
	private Collection select(Resource resource){
		List list =new ArrayList(); 
		for(Iterator iterator = resource.getContents().iterator();iterator.hasNext();){
			RootConf root = (RootConf)iterator.next();
			if (selected == ConfigurationResourceSetItemProvider.BY_FEATURE){
				list.addAll(root.getFeature());
				continue;
			}
			else if (selected == ConfigurationResourceSetItemProvider.BY_VIEW){
				list.addAll(root.getView());
				continue;
			}
			else if (selected == ConfigurationResourceSetItemProvider.BY_CONFIGURATION){
				list.add(root);
				continue;
			}
		}
		return list;
	}

	
	
	public void setSelected(String selected) {
		this.selected = selected;
	}
}
