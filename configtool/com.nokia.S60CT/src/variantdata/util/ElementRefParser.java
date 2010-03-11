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

package variantdata.util;

import org.eclipse.emf.ecore.EObject;

import configurationemf.Configuration;
import configurationemf.Feature;
import configurationemf.LeafSettingDelegator;
import configurationemf.ParentSetting;
import configurationemf.Setting;

public class ElementRefParser
{
	public ElementRefParser()
	{
	}
	
	public static String getName(Configuration conf)
	{
		String confName = conf.getName();
		if (confName!=null && !confName.equals(""))
			return confName;
		else 
			return "<unnamed configuration>";
	}
	public static String getName(Feature feature)
	{
		String featureName = feature.getName();
		String confName = getName((Configuration)feature.eContainer());
		if (featureName!=null && !featureName.equals(""))
			return confName+"/"+featureName;
		else if (feature.getRef()!= null && !feature.getRef().equals(""))
		{
			return confName+"/"+feature.getRef();
		}
		else
			return confName+"/<unknown feature>";
	}
	public static String getName(Setting setting)
	{
		String settingName = setting.getName();
		String featureName = null;
		EObject obj = setting.eContainer();
		if (obj instanceof Feature)
			featureName = getName((Feature)setting.eContainer());
		else if (obj instanceof ParentSetting)
			featureName = getName((ParentSetting)setting.eContainer());
		
		if (settingName!=null && !settingName.equals(""))
			return featureName+"/"+settingName;
		else if (setting.getRef()!= null && !setting.getRef().equals(""))
		{
			return featureName+"/"+setting.getRef();
		}
		else
			return featureName+"/<unknown setting>";
			
	}
	public static String getName(LeafSettingDelegator lsd)
	{
		System.out.println("LeafSettingDelegator");
		return "";
	}
	
	
}
