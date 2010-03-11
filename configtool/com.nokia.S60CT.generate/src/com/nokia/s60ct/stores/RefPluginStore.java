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
package com.nokia.s60ct.stores;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class RefPluginStore {
	
	//map, <ref - Set<plugin_id>>
	Map map = new TreeMap();
	
	public boolean addRef(String ref,String plugin_id){
		Set pluginIdSet = (Set)map.get(ref);
		if(pluginIdSet==null){
			pluginIdSet = new HashSet();
			map.put(ref, pluginIdSet);
		}
		return pluginIdSet.add(plugin_id);
	}
	
	public boolean removeRef(String ref,String plugin_id){
		Set pluginIdSet = (Set)map.get(ref);
		if(pluginIdSet==null)return false;
		else return pluginIdSet.remove(plugin_id);
	}
	
	public Map getMap(){
		return map;
	}
	
	public void print(){
		System.out.println("RefPluginStore");
		for(Iterator it = map.keySet().iterator();it.hasNext();){
			String ref = (String)it.next();
			Set set = (Set)map.get(ref);
			for(Iterator iPlugin = set.iterator();iPlugin.hasNext();){
				String plugin_id = (String)iPlugin.next();
				System.out.println(plugin_id+" "+ref);
			}
		}
	}
}
