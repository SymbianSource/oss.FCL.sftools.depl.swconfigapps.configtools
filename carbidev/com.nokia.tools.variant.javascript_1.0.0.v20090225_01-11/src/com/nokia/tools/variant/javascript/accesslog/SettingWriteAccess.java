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

package com.nokia.tools.variant.javascript.accesslog;

import java.util.Date;


public class SettingWriteAccess implements WriteAccess {
	
	private String absRef;
	
	private String propertyName;
	
	private long timestamp;
	
	private String oldValue;
	
	private String newValue;
	
	public SettingWriteAccess(String absRef, String propertyName, String oldValue, String newValue) {
		this.absRef = absRef;
		this.propertyName = propertyName;
		this.timestamp = new Date().getTime();
		this.oldValue = oldValue;
		this.newValue = newValue;
	}
	
	public Object getAccessedObject() {
		return absRef;
	}

	public String getAccessedPropertyName() {
		return propertyName;
	}

	public long timeStamp() {
		return timestamp;
	}

	public String getNewValue() {
		return newValue;
	}

	public String getOldValue() {
		return oldValue;
	}


}
