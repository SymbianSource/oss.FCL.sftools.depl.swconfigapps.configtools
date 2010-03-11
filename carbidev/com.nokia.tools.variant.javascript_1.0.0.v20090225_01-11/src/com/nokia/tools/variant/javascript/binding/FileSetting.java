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
 * Description: This file is part of com.nokia.tools.variant.javascript component.
 */

package com.nokia.tools.variant.javascript.binding;

import com.nokia.tools.variant.confml.core.model.application.EAppResourceData;
import com.nokia.tools.variant.confml.core.model.application.EAppSettingData;
import com.nokia.tools.variant.confml.core.model.application.EAppSimpleData;
import com.nokia.tools.variant.confml.core.model.application.EApplicationFactory;
import com.nokia.tools.variant.javascript.accesslog.ReadAccess;
import com.nokia.tools.variant.javascript.accesslog.SettingReadAccess;
import com.nokia.tools.variant.javascript.accesslog.SettingWriteAccess;
import com.nokia.tools.variant.javascript.accesslog.WriteAccess;

public class FileSetting extends Setting {
	
	public FileSetting() {
		
	}
	
	public void jsConstructor() {
	}

	public String jsGet_localPath() {
		// log
		ReadAccess read = new SettingReadAccess(absRef, "localPath");
		getLogger().log(read);
		
		// get value
		EAppResourceData resourceData = (EAppResourceData) appSetting.getValueInfo();
		if (resourceData == null) {
			return null;
		}
		EAppSettingData localPath = resourceData.getLocalPath();
		if (localPath == null) {
			return null;
		}
		if (localPath instanceof EAppSimpleData) {
			EAppSimpleData path = (EAppSimpleData) localPath;
			return path.getValue();
		}
		return null;
	}

	public String jsGet_targetPath() {
		// log
		ReadAccess read = new SettingReadAccess(absRef, "targetPath");
		getLogger().log(read);
		
		// get value
		EAppResourceData resourceData = (EAppResourceData) appSetting.getValueInfo();
		if (resourceData == null) {
			return null;
		}
		EAppSettingData targetPath = resourceData.getTargetPath();
		if (targetPath == null) {
			return null;
		}
		if (targetPath instanceof EAppSimpleData) {
			EAppSimpleData path = (EAppSimpleData) targetPath;
			return path.getValue();
		}
		return null;
	}

	
	public void jsSet_localPath(String value) {
		String oldValue = null;
		
		// get value
		EAppResourceData resourceData = (EAppResourceData) appSetting.getValueInfo();
		if (resourceData == null) {
			resourceData = EApplicationFactory.eINSTANCE.createEAppResourceData();
			appSetting.setValueInfo(resourceData);
		}
		EAppSimpleData localPath = (EAppSimpleData) resourceData.getLocalPath();
		if (localPath == null) {
			localPath = EApplicationFactory.eINSTANCE.createEAppSimpleData();
			resourceData.setLocalPath(localPath);
		}
		oldValue = localPath.getValue();
		localPath.setValue(value);

		// log
		WriteAccess write = new SettingWriteAccess(absRef, "localPath", oldValue, value);
		getLogger().log(write);
		
}

	
	public void jsSet_tagetPath(String value) {
		String oldValue = null;

		EAppResourceData resourceData = (EAppResourceData) appSetting.getValueInfo();
		if (resourceData == null) {
			resourceData = EApplicationFactory.eINSTANCE.createEAppResourceData();
			appSetting.setValueInfo(resourceData);
		}
		EAppSimpleData targetPath = (EAppSimpleData) resourceData.getTargetPath();
		if (targetPath == null) {
			targetPath = EApplicationFactory.eINSTANCE.createEAppSimpleData();
			resourceData.setTargetPath(targetPath);
		}
		oldValue = targetPath.getValue();
		targetPath.setValue(value);

		// log
		WriteAccess write = new SettingWriteAccess(absRef, "targetPath", oldValue, value);
		getLogger().log(write);
	}
	
	@Override
	public String getClassName() {
		return "FileSetting";
	}


}

