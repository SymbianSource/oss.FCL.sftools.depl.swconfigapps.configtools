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

package com.nokia.tools.s60ct.confml.editor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;

import com.nokia.tools.vct.common.appmodel.EAppFeature;
import com.nokia.tools.vct.common.appmodel.EAppGroup;
import com.nokia.tools.vct.common.appmodel.EAppSetting;
import com.nokia.tools.vct.common.appmodel.EAppSettingRef;

public class ConfmlEditorUtil {
	public static String escapeSpaces(String str) {
		return str.replaceAll(" ", "_");
	}
	
	public static String unEscapeSpaces(String str) {
		return str.replaceAll("_", " ");
	}
	
	public static Map<EAppFeature,List<String>> getFeatures(EAppGroup group) {
		Map<EAppFeature,List<String>> features = new HashMap<EAppFeature, List<String>>();
		EList<EAppSettingRef> settings = group.getSettings();
		for (EAppSettingRef appSettingRef : settings) {
			EAppSetting resolved = appSettingRef.getResolved();
			EAppFeature feature = (EAppFeature) resolved.eContainer().eContainer();
			if(features.get(feature)==null) {
				features.put(feature, new ArrayList<String>());
			}
			List<String> list = features.get(feature);
			list.add(resolved.getRef());
		}
		return features;
	}
	
	public static Map<EAppSetting,EList<String>> getVisibleSubSettings(EAppGroup group) {
		Map<EAppSetting,EList<String>> filters = new HashMap<EAppSetting, EList<String>>();
		EList<EAppSettingRef> settings = group.getSettings();
		for (EAppSettingRef appSettingRef : settings)
		{ 
			if (appSettingRef.getSubSettingsRef().size()==0)
				continue;
			EAppSetting resolved = appSettingRef.getResolved();
			if(filters.get(resolved)==null) {
				filters.put(resolved, appSettingRef.getSubSettingsRef());
			}
		}
		return filters;
	}
	
}
