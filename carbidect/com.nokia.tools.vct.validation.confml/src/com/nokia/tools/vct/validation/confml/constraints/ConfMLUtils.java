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
 * Description: This file is part of com.nokia.tools.vct.validation.confml component.
 */

package com.nokia.tools.vct.validation.confml.constraints;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;

import com.nokia.tools.vct.common.appmodel.EAppFeature;
import com.nokia.tools.vct.common.appmodel.EAppResourceData;
import com.nokia.tools.vct.common.appmodel.EAppSequenceData;
import com.nokia.tools.vct.common.appmodel.EAppSequenceDataItem;
import com.nokia.tools.vct.common.appmodel.EAppSetting;
import com.nokia.tools.vct.common.appmodel.EAppSettingData;
import com.nokia.tools.vct.common.appmodel.EAppSettingType;
import com.nokia.tools.vct.common.appmodel.EAppSimpleData;
import com.nokia.tools.vct.common.appmodel.EAppSimpleType;
import com.nokia.tools.vct.common.appmodel.EAppTypeContainer;
import com.nokia.tools.vct.common.appmodel.EConfMLLayer;
import com.nokia.tools.vct.common.appmodel.EConfigurationProject;
import com.nokia.tools.vct.common.core.utils.PlatformUtil;
import com.nokia.tools.vct.confml.model.confml1.EFeatureData;
import com.nokia.tools.vct.confml.model.confml1.EFeatureElement;
import com.nokia.tools.vct.confml.model.confml1.EGroup;
import com.nokia.tools.vct.confml.model.confml1.ESettingData;
import com.nokia.tools.vct.confml.model.confml1.ESettingElement;

public class ConfMLUtils {
	
	public static String getCorrectValue(ESettingData settingData, EAppSimpleType appSimpleType, String absRef)
	{
		if (absRef.indexOf('/') != absRef.lastIndexOf('/')) //sequence setting
		{
			return settingData.getText();
		}
		else
		{
			return getCorrectValue(appSimpleType);
		}
	}
	
	
	public static String getCorrectValue(com.nokia.tools.vct.confml.model.confml2.ESettingData settingData, EAppSimpleType appSimpleType, String absRef)
	{
		if (absRef.indexOf('/') != absRef.lastIndexOf('/')) //sequence setting
		{
			return settingData.getText();
		}
		else
		{
			return getCorrectValue(appSimpleType);
		}
	}
	
	public static String getCorrectValue(EObject obj)
	{
		if (obj instanceof EAppSetting)
		{
			EAppSetting appSetting = (EAppSetting)obj;
			return getValueFromData(appSetting.getValueInfo());
		}
		else
		{
			return getCorrectValue(obj.eContainer());
		}
	}
	
	private static String getMapValue(String map, EAppSimpleData data)
	{
		String[] split1 = map.split("\\[@key='");
		String[] split2 = split1[0].split("/");
		
		String featureRef = split2[0];
		String settingRef = split2[1];
		String mapKey = split1[1].substring(0, split1[1].length()-2);
		
		EConfMLLayer lastLayer = (EConfMLLayer)getLastLayer(data);
		EAppFeature feature = lastLayer.getFeatures().get(featureRef);
		EAppSetting setting = feature.getSettings().get(settingRef);
		
		if (setting.getValueInfo() instanceof EAppSequenceData)
		{
			EAppSequenceData ssData = (EAppSequenceData)setting.getValueInfo();
			EList<EAppSequenceDataItem> dataItems = ssData.getItems();
			
			for (int i = 0 ; i < dataItems.size() ; i++)
			{
				EAppSequenceDataItem dataItem = dataItems.get(i);
				EMap<String, EAppSettingData> subSettings = dataItem.getSubSettings();
				if (((EAppSimpleData)subSettings.get("mapKey")).getValue().equals(mapKey))
				{
					return ((EAppSimpleData)subSettings.get("mapValue")).getValue();
				}
			}
		}
		return null;
	}
	
	private static String getValueFromData(EAppSettingData settingData)
	{
		if (settingData instanceof EAppSimpleData)
		{
			EAppSimpleData data = (EAppSimpleData)settingData;
			if (data.getMap()!=null)
			{
				return getMapValue(data.getMap(), data);
			}
			else
				return data.getValue();
		}
		else if (settingData instanceof EAppResourceData)
		{
			EAppResourceData data = (EAppResourceData)settingData;
			//getValueFromData(data.getTargetPath());
			return getValueFromData(data.getLocalPath());
		}
		else if (settingData instanceof EAppSequenceData)
		{
			EAppSequenceData data = (EAppSequenceData)settingData;
			System.out.println("We shouldn't come here");
		}
		return null;
	}
	
	public static String getAbsoluteRef(ESettingElement settingElement) {
		List<String> fragments = new ArrayList<String>();
		EObject ptr = settingElement;
		
		while (ptr instanceof ESettingElement) {
			fragments.add(((ESettingElement)ptr).getRef());
			ptr = ptr.eContainer();
		}
		if (ptr instanceof EFeatureElement) {
			fragments.add(((EFeatureElement) ptr).getRef());
		}
		StringBuilder tmp = new StringBuilder();
		for (int i = fragments.size() - 1; i >= 1; i--) {
			tmp.append(fragments.get(i)).append('/');
		}
		tmp.append(fragments.get(0));
		return tmp.toString();
	}

	public static String getAbsoluteRef(com.nokia.tools.vct.confml.model.confml2.ESettingElement settingElement) {
		List<String> fragments = new ArrayList<String>();
		EObject ptr = settingElement;
		
		while (ptr instanceof com.nokia.tools.vct.confml.model.confml2.ESettingElement) {
			fragments.add(((com.nokia.tools.vct.confml.model.confml2.ESettingElement)ptr).getRef());
			ptr = ptr.eContainer();
		}
		if (ptr instanceof com.nokia.tools.vct.confml.model.confml2.EFeatureElement) {
			fragments.add(((com.nokia.tools.vct.confml.model.confml2.EFeatureElement) ptr).getRef());
		}
		StringBuilder tmp = new StringBuilder();
		for (int i = fragments.size() - 1; i >= 1; i--) {
			tmp.append(fragments.get(i)).append('/');
		}
		tmp.append(fragments.get(0));
		return tmp.toString();
	}

	public static String getAbsoluteRef(ESettingData settingData) {
		List<String> fragments = new ArrayList<String>();
		EObject ptr = settingData;
		
		while (ptr instanceof ESettingData) {
			fragments.add(((ESettingData)ptr).getRef());
			ptr = ptr.eContainer();
		}
		if (ptr instanceof EFeatureData) {
			fragments.add(((EFeatureData) ptr).getRef());
		}
		StringBuilder tmp = new StringBuilder();
		for (int i = fragments.size(); i > 1; i--) {
			tmp.append(fragments.get(i)).append('/');
		}
		tmp.append(fragments.get(0));
		return tmp.toString();
	}
	
	public static boolean isFeatureElementChild(ESettingElement settingElement) {
		EObject ptr = settingElement;
		while (ptr instanceof ESettingElement) {
			ptr = ptr.eContainer();
		}
		
		return ptr instanceof EFeatureElement;
	}

	public static boolean isFeatureElementChild(com.nokia.tools.vct.confml.model.confml2.ESettingElement settingElement) {
		EObject ptr = settingElement;
		while (ptr instanceof com.nokia.tools.vct.confml.model.confml2.ESettingElement) {
			ptr = ptr.eContainer();
		}
		
		return ptr instanceof com.nokia.tools.vct.confml.model.confml2.EFeatureElement;
	}

	public static boolean isGroupElementChild(ESettingElement settingElement) {
		EObject ptr = settingElement;
		while (ptr instanceof ESettingElement) {
			ptr = ptr.eContainer();
		}
		
		return ptr instanceof EGroup;
	}
	public static boolean isGroupElementChild(com.nokia.tools.vct.confml.model.confml2.ESettingElement settingElement) {
		EObject ptr = settingElement;
		while (ptr instanceof com.nokia.tools.vct.confml.model.confml2.ESettingElement) {
			ptr = ptr.eContainer();
		}
		
		return ptr instanceof EGroup;
	}

	static final Pattern REF_PATTERN = Pattern.compile("[_\\p{Alpha}][_\\-\\p{Alnum}]*");
	
	public static boolean isValidRef(String ref) {
		return REF_PATTERN.matcher(ref).matches();
	}
	
	public static EAppSettingType findType(ESettingData data, StringBuilder tmp) {
		List<EObject> stack = new ArrayList<EObject>();
		for (EObject ptr = data; ptr instanceof ESettingData
				|| ptr instanceof EFeatureData; ptr = ptr.eContainer()) {
			stack.add(ptr);
		}
		Collections.reverse(stack);
		EFeatureData featureData = (EFeatureData) stack.get(0);
		ESettingData settingData2 = (ESettingData) stack.get(1);
		EConfigurationProject project = PlatformUtil.getAdapter(data
				.eResource().getResourceSet(), EConfigurationProject.class,
				false);


		EConfMLLayer layer = project.getLastLayer();
		EAppFeature appFeature = null;
		appFeature = layer == null ? null : layer.getFeatures().get(featureData.getRef());
		EAppSetting appSetting = null;
		appSetting = appFeature == null ? null : appFeature.getSettings().get(settingData2.getRef());

		EAppSettingType settingType = appSetting == null ? null : appSetting.getTypeInfo();
		EAppSettingType ptr = settingType;
		tmp.append(featureData.getRef()).append('/');
		tmp.append(settingData2.getRef());
		for (int i = 2; i < stack.size(); i++) {
			String ref = ((ESettingData)stack.get(i)).getRef();
			tmp.append('/').append(ref);
			if (ptr instanceof EAppTypeContainer) {
				EAppTypeContainer tc = (EAppTypeContainer) ptr;
				ptr = tc.getTypeMap().get(ref);
				if (ptr == null) {
					break;
				}
			} else {
				ptr = null;
				break;
			}
		}
		return ptr;
	}
	public static EAppSettingType findType(com.nokia.tools.vct.confml.model.confml2.ESettingData data, StringBuilder tmp) {
		List<EObject> stack = new ArrayList<EObject>();
		for (EObject ptr = data; ptr instanceof com.nokia.tools.vct.confml.model.confml2.ESettingData
				|| ptr instanceof com.nokia.tools.vct.confml.model.confml2.EFeatureData; ptr = ptr.eContainer()) {
			stack.add(ptr);
		}
		Collections.reverse(stack);
		com.nokia.tools.vct.confml.model.confml2.EFeatureData featureData = (com.nokia.tools.vct.confml.model.confml2.EFeatureData) stack.get(0);
		com.nokia.tools.vct.confml.model.confml2.ESettingData settingData2 = (com.nokia.tools.vct.confml.model.confml2.ESettingData) stack.get(1);
		EConfigurationProject project = PlatformUtil.getAdapter(data
				.eResource().getResourceSet(), EConfigurationProject.class,
				false);


		EConfMLLayer layer = project.getLastLayer();
		EAppFeature appFeature = null;
		appFeature = layer == null ? null : layer.getFeatures().get(featureData.getRef());
		EAppSetting appSetting = null;
		appSetting = appFeature == null ? null : appFeature.getSettings().get(settingData2.getRef());

		EAppSettingType settingType = appSetting == null ? null : appSetting.getTypeInfo();
		EAppSettingType ptr = settingType;
		tmp.append(featureData.getRef()).append('/');
		tmp.append(settingData2.getRef());
		for (int i = 2; i < stack.size(); i++) {
			String ref = ((com.nokia.tools.vct.confml.model.confml2.ESettingData)stack.get(i)).getRef();
			tmp.append('/').append(ref);
			if (ptr instanceof EAppTypeContainer) {
				EAppTypeContainer tc = (EAppTypeContainer) ptr;
				ptr = tc.getTypeMap().get(ref);
				if (ptr == null) {
					break;
				}
			} else {
				ptr = null;
				break;
			}
		}
		return ptr;
	}
	
	public static EObject getLastLayer(EObject eAppObj)
	{
		EObject obj = eAppObj.eContainer();
		
		if (obj instanceof EConfMLLayer)
			return obj;
		else
			return getLastLayer(obj);
	}

}
