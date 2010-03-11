/*
 * Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies).
 * All rights reserved.
 * This component and the accompanying materials are made available
 * under the terms of "Eclipse Public License v1.0"
 * which accompanies this distribution, and is available
 * at the URL "http://www.eclipse.org/legal/epl-v10.html".
 * 
 * Initial Contributors:
 * Nokia Corporation - Initial contribution
 * 
 * Contributors:
 * 
 * Description: This file is part of com.nokia.tools.vct.validation.crml component.
 */

package com.nokia.tools.vct.validation.crml.constraints;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

import com.nokia.tools.variant.confml.core.ConfMLCore;
import com.nokia.tools.vct.common.appmodel.EAppFeature;
import com.nokia.tools.vct.common.appmodel.EAppSetting;
import com.nokia.tools.vct.common.appmodel.EConfMLLayer;
import com.nokia.tools.vct.common.appmodel.EConfigurationProject;
import com.nokia.tools.vct.crml.crmodel.EAccess;
import com.nokia.tools.vct.crml.crmodel.EKey;
import com.nokia.tools.vct.crml.crmodel.EKeyRange;
import com.nokia.tools.vct.crml.crmodel.ERepository;

public class ElementRefParser
{
	public ElementRefParser()
	{
	}
	public static String getName(ERepository repository)
	{
		String name = repository.getUidName();
		String value = repository.getUidValue();
		
		if (name != null && !name.equals(""))
			return name;
		else if (value != null && !value.equals(""))
			return value;
		else
			return "<unknown repository>";
	}
	public static String getName(EKey key)
	{
		String ref = key.getRef();
		if (ref != null && !ref.equals(""))
			return ref;
		else
		{
			String rep = getName(key.eContainer());
			String keyName = key.getName();
			String keyIdent = key.getIdent();
			if (keyName != null && !keyName.equals(""))
				return rep+"/"+keyName;
			else if (keyIdent != null && !keyIdent.equals(""))
				return rep+"/"+keyIdent;
			else
				return rep+"/"+"<unknown key>";
		}
	}
	public static EAppSetting getConfMLSetting(EObject obj, String ref) {
		URI uri = obj.eResource().getURI();
		IProject project = null;
		if (!uri.isPlatform()) {
			return null;
		}
		String projectName = uri.segment(1);
		project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
		
		EConfigurationProject vp = ConfMLCore.getProjectModel(project);
		EConfMLLayer layer = vp == null ? null : vp.getLastLayer();
		if (layer == null) {
			return null;
		}
		
		if (ref!=null)
		{
			int idx = ref.indexOf('/');
			if (idx != -1)
			{
				String featureId = ref.substring(0, idx);
				String settingId = ref.substring(idx+1);
				
				EAppFeature feature = layer.getFeatures().get(featureId);
				EAppSetting setting = null;
				if (feature != null) {
					setting = feature.getSettings().get(settingId);
				}
				return setting;
			}
			else //sequence settings leaf setting
			{
				
					return null;
			}
		}
		else
		{
			return null;
		}
	}

	
	public static String getName(EKeyRange keyRange)
	{
		String ref = keyRange.getRef();
		if (ref != null && !ref.equals(""))
			return ref;
		else
		{
			String rep = getName(keyRange.eContainer());
			String keyName = keyRange.getName();
			String firstInt = keyRange.getFirstInt();
			String LastInt = keyRange.getLastInt();
			if (keyName != null && !keyName.equals(""))
				return rep+"/"+keyName;
			else if (firstInt != null && !firstInt.equals(""))
				return rep+"/"+firstInt+"-"+LastInt;
			else
				return rep+"/"+"<unknown key>";
		}
	}
	public static String getName(EAccess access)
	{
		return getName(access.eContainer());
	}
	
	public static String getName(Object obj)
	{
		if (obj instanceof ERepository)
		{
			ERepository rep = (ERepository)obj;
			return getName(rep);
		}
		else if (obj instanceof EKey)
		{
			EKey key = (EKey)obj;
			return getName(key);
		}
		else if (obj instanceof EKeyRange)
		{
			EKeyRange keyRange = (EKeyRange)obj;
			return getName(keyRange);
		}
		else if (obj instanceof EAccess)
		{
			EAccess access = (EAccess)obj;
			return getName(access.eContainer());
		}
		return "<Unhandled object type>";
	}
	
}
