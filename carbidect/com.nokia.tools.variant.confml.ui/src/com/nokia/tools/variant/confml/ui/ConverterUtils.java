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
 * Description: This file is part of com.nokia.tools.variant.confml.ui component.
 */

package com.nokia.tools.variant.confml.ui;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import com.nokia.tools.vct.common.appmodel.EAppFeature;
import com.nokia.tools.vct.common.appmodel.EAppSetting;

public class ConverterUtils {

	public static<T extends EObject> T getAncestor(EObject object, Class<T> type) {
		EObject ptr = object;
		
		while (ptr != null && !type.isInstance(ptr)) {
			ptr = ptr.eContainer();
		}
		
		return type.cast(ptr);
	}

	@Deprecated
	public static String getFeatureId(EAppFeature feature) {
		return feature.getRef();
	}
	@Deprecated
	public static String getSettingId(EAppSetting setting) {
		return setting.getRef();
	}	

	public static<T> T getMapEntryId(EObject object, Class<T> type) {
		Map.Entry<?, ?> entry = (Map.Entry<?, ?>)object.eContainer();
		return type.cast(entry.getKey());
	}

	
}
