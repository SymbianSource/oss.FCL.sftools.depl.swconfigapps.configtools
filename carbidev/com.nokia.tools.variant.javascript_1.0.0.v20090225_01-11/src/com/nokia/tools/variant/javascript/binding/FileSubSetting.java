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

public class FileSubSetting extends FileSetting {

	
	private EAppResourceData resourceData;
	
	public FileSubSetting() {
		
	}
	
	public void jsConstructor() {
	}
	
	public void setResourceData(EAppResourceData resourceData) {
		this.resourceData = resourceData;
	}
	

	@Override
	public String jsGet_localPath() {
		// log
		ReadAccess read = new SettingReadAccess(absRef, "localPath");
		getLogger().log(read);
		
		// get value
		EAppSettingData localPath = resourceData.getLocalPath();
		if (localPath instanceof EAppSimpleData) {
			EAppSimpleData lp = (EAppSimpleData) localPath;
			return lp.getValue();
		}
		return null;
	}
	
	@Override
	public String jsGet_targetPath() {
		// log
		ReadAccess read = new SettingReadAccess(absRef, "targetPath");
		getLogger().log(read);

		
		EAppSettingData targetPath = resourceData.getTargetPath();
		if (targetPath instanceof EAppSimpleData) {
			EAppSimpleData tp = (EAppSimpleData) targetPath;
			return tp.getValue();
		}
		return null;
	}
	
	@Override
	public void jsSet_localPath(String value) {
		String oldValue = null;
		
		// get value
		EAppSettingData localPath = resourceData.getLocalPath();
		if (localPath instanceof EAppSimpleData) {
			EAppSimpleData lp = (EAppSimpleData) localPath;
			oldValue = lp.getValue();
			lp.setValue(value);
		} else if (localPath == null) {
			EAppSimpleData lp = EApplicationFactory.eINSTANCE.createEAppSimpleData();
			lp.setValue(value);
			resourceData.setLocalPath(lp);
		}
		
		// log
		WriteAccess write = new SettingWriteAccess(absRef, "localPath", oldValue, value);
		getLogger().log(write);
	}
	
	@Override
	public void jsSet_tagetPath(String value) {
		String oldValue = null;
		
		// get value
		EAppSettingData targetPath = resourceData.getTargetPath();
		if (targetPath instanceof EAppSimpleData) {
			EAppSimpleData tp = (EAppSimpleData) targetPath;
			oldValue = tp.getValue();
			tp.setValue(value);
		} else if (targetPath == null) {
			EAppSimpleData tp = EApplicationFactory.eINSTANCE.createEAppSimpleData();
			tp.setValue(value);
			resourceData.setTargetPath(tp);
		}
		
		// log
		WriteAccess write = new SettingWriteAccess(absRef, "targetPath", oldValue, value);
		getLogger().log(write);
	}
	
	@Override
	public String getClassName() {
		return "FileSubSetting";
	}
}
