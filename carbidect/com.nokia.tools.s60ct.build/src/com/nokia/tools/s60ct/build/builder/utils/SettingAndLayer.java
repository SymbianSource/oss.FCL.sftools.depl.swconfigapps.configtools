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

package com.nokia.tools.s60ct.build.builder.utils;

import com.nokia.tools.vct.common.appmodel.EAppSetting;
import com.nokia.tools.vct.common.appmodel.EConfMLLayer;

public class SettingAndLayer {
	private EAppSetting setting;
	private EConfMLLayer layer;
	
	public EAppSetting getSetting() {
		return setting;
	}

	public void setSetting(EAppSetting setting) {
		this.setting = setting;
	}

	public EConfMLLayer getLayer() {
		return layer;
	}

	public void setLayer(EConfMLLayer layer) {
		this.layer = layer;
	}

	
	public SettingAndLayer(EAppSetting setting, EConfMLLayer layer) {
		this.setting = setting;
		this.layer = layer;
	}
}
