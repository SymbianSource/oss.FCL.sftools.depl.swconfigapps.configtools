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

import com.nokia.tools.variant.confml.core.model.application.EAppSimpleData;
import com.nokia.tools.variant.javascript.accesslog.ReadAccess;
import com.nokia.tools.variant.javascript.accesslog.SettingReadAccess;
import com.nokia.tools.variant.javascript.accesslog.SettingWriteAccess;
import com.nokia.tools.variant.javascript.accesslog.WriteAccess;

public class SimpleSubSetting extends SimpleSetting {
	
	private EAppSimpleData simpleData;

	public SimpleSubSetting() {
		
	}
	
	public void jsConstructor() {
	}
	
	public void setSimpleData(EAppSimpleData simpleData) {
		this.simpleData = simpleData;
	}
	
	
	
	@Override
	public String jsGet_value() {
		// log
		ReadAccess read = new SettingReadAccess(absRef, "value");
		getLogger().log(read);

		// get value
		return simpleData.getValue();
	}
	
	@Override
	public void jsSet_value(String value) {
		String oldValue = simpleData.getValue();

		// set value
		simpleData.setValue(value);
		
		// log
		WriteAccess write = new SettingWriteAccess(absRef, "value", oldValue, value);
		getLogger().log(write);

	}
	
	@Override
	public String getClassName() {
		return "SimpleSubSetting";
	}
	
	
}
