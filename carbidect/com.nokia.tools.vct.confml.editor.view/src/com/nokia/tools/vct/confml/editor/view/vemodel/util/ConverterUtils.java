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
 * Description: This file is part of com.nokia.tools.vct.confml.editor.view component.
 */

package com.nokia.tools.vct.confml.editor.view.vemodel.util;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import com.nokia.tools.vct.common.appmodel.EAppFeature;
import com.nokia.tools.vct.common.appmodel.EAppSetting;
import com.nokia.tools.vct.confml.editor.view.vemodel.EFeature;
import com.nokia.tools.vct.confml.editor.view.vemodel.ERefTarget;
import com.nokia.tools.vct.confml.editor.view.vemodel.ESetting;
import com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef;
import com.nokia.tools.vct.confml.editor.view.vemodel.EView;
import com.nokia.tools.vct.confml.editor.view.vemodel.EViewsEditorDocument;
import com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewEntryImpl;

public class ConverterUtils {
	public static final String SETTING_WILDCARD = "*";

	/**
	 * Helper method for setting the {@link ESettingRef#getTarget() target
	 * reference} value.
	 * 
	 * @param document
	 *            Editor's model instance
	 * @param ref
	 *            Container to update reference for
	 */
	public static void updateIndexReference(EViewsEditorDocument document,
			ESettingRef ref) {
		String featureId = ref.getFeatureId();
		String settingId = ref.getSettingId();
		String subSettingID = null;
		
		if (settingId.indexOf("/")!=-1)
		{
			String[] segs = settingId.split("/");
			settingId = segs[0];
			subSettingID = segs[1];
		}
		
		ERefTarget target = null;
		if (settingId.equals(SETTING_WILDCARD)) 
		{
			target = document.getFeatures().get(featureId);
		} 
		else if (subSettingID!= null && subSettingID.equals(SETTING_WILDCARD)) 
		{
			EFeature tmp = document.getFeatures().get(featureId);
			if (tmp != null)
			{
				target = tmp.getSettings().get(settingId);
			}
		}
		else if (subSettingID!= null)
		{
			EFeature tmp = document.getFeatures().get(featureId);
			if (tmp != null) 
			{
				ESetting tempSetting = tmp.getSettings().get(settingId);
				target = tempSetting.getSubSettings().get(subSettingID);
			}
		}
		else 
		{
			EFeature tmp = document.getFeatures().get(featureId);
			if (tmp != null) 
			{
				target = tmp.getSettings().get(settingId);
			}
		}
		ref.setTarget(target);
	}

	public static EViewsEditorDocument getDocument(EObject object) {
		return getAncestor(object, EViewsEditorDocument.class);
	}

	public static<T extends EObject> T getAncestor(EObject object, Class<T> type) {
		EObject ptr = object;
		
		while (ptr != null && !type.isInstance(ptr)) {
			ptr = ptr.eContainer();
		}
		
		return type.cast(ptr);
	}

	public static String getFeatureId(EFeature feature) {
		return getMapEntryId(feature, String.class);
	}
	public static String getSettingId(ESetting setting) {
		return getMapEntryId(setting, String.class);
	}	
	public static String getFeatureId(EAppFeature feature) {
		return getMapEntryId(feature, String.class);
	}
	public static String getSettingId(EAppSetting setting) {
		return getMapEntryId(setting, String.class);
	}	
	public static String getViewId(EView view) {
//		if (view.eContainer() instanceof EViewEntryImpl)
//			return getMapEntryId(view, String.class);
//		else
//			return null;
		return view.getId();
	}

	public static<T> T getMapEntryId(EObject object, Class<T> type) {
		Map.Entry<?, ?> entry = (Map.Entry<?, ?>)object.eContainer();
		return type.cast(entry.getKey());
		
	}

	
}
