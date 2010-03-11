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

package com.nokia.tools.s60ct.model.confml.util;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;

import com.nokia.tools.vct.common.appmodel.EAppFeature;
import com.nokia.tools.vct.common.appmodel.EAppSequenceDataItem;
import com.nokia.tools.vct.common.appmodel.EAppSetting;
import com.nokia.tools.vct.common.appmodel.EConfMLLayer;
import com.nokia.tools.vct.common.appmodel.ESourceLocator;

public class ValueEditorUtil {
	public static boolean isFromThisLayer(EConfMLLayer layer,URI file) {
		if(file==null) {
			return false;
		}
		EList<URI> layerFiles = layer.getLayerFiles();
		for (URI uri : layerFiles) {
			String path = file.path();
			if(uri.path().equals(path)) {
				return true;
			}
		}
		return false;
	}

	public static URI getSequenceItemLocationUri(
			EAppSequenceDataItem appSeqValItem) {
		ESourceLocator locator = (ESourceLocator)appSeqValItem;
		return locator.getUri()!=null&&locator.getUri().size()!=0?locator.getUri().get(0):null;
	}

	public static EAppSetting getSettingFromLayer(EConfMLLayer layer,
			String featureRef, String settingRef) {
		if(layer==null) {
			return null;
		}
		EAppFeature appFeature = layer.getFeatures().get(featureRef);
		if(appFeature==null) {
			return null;
		}
		return appFeature.getSettings().get(settingRef);
	}	
	
}
