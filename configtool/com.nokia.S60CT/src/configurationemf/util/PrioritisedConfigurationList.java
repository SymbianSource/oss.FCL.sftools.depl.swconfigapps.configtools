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
package configurationemf.util;

import java.util.ArrayList;
import java.util.List;

import configurationemf.Configuration;
import configurationemf.RootConf;

public class PrioritisedConfigurationList {

	List<Configuration> prioritisedConfs = null;
	RootConf conf=null;
	public static PrioritisedConfigurationList prioritisedConfigurationList = null;
	private PrioritisedConfigurationList(){
		
	}
	
	public static PrioritisedConfigurationList getPrioritisedConfigurationList(){
		if(prioritisedConfigurationList == null)
			prioritisedConfigurationList = new PrioritisedConfigurationList();
		
		return prioritisedConfigurationList;
	}
	
	
	/**
	 * getPrioritisedConfigurations function traverse through configuration hierarchy 
	 * and return list of configurations based on inclusion order
	 * @return List of configurations resolved based on inclusion order.
	 */
	public List<Configuration> getPrioritisedConfigurations(RootConf conf){
		if(prioritisedConfs==null || prioritisedConfs.size()==0){
			prioritisedConfs = new ArrayList<Configuration>();
			prioritisedConfs(conf);
		}
		return prioritisedConfs;
		
	}
	
	/**
	 * clearPrioritisedConfigurationList method clears prioritised configurations list.  
	 */
	public void clearPrioritisedConfigurationList(){
		if(prioritisedConfs!=null)
			prioritisedConfs.clear();
		prioritisedConfs=null;
	}
	
	private void prioritisedConfs(RootConf conf){
		
		if(conf.getInclude().size()!=0){
			for (int i=conf.getInclude().size()-1; i>=0; i--) {
				prioritisedConfs(conf.getInclude().get(i));
			}
		}
		boolean bFound=false;
		for(Configuration obj : prioritisedConfs){
			if(obj.getName()!=null && conf.getName() != null && obj.getName().compareTo(conf.getName())==0)
				bFound=true;
		}
		if(!bFound)
			prioritisedConfs.add(conf);
	}
}
