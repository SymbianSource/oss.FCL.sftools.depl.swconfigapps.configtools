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

import org.mozilla.javascript.ScriptableObject;

import com.nokia.tools.variant.confml.core.model.application.EAppSetting;
import com.nokia.tools.variant.javascript.accesslog.AuditLogger;

public abstract class Setting extends ScriptableObject {
	
	protected EAppSetting appSetting;
	
	protected AuditLogger logger;
	
	protected String absRef;
	
	public AuditLogger getLogger() {
		return logger;
	}

	public void setLogger(AuditLogger logger) {
		this.logger = logger;
	}

	public Setting() {
	}
	
	public void setAppSetting(EAppSetting appSetting) {
		this.appSetting = appSetting;
	}
	
	public String getAbsRef() {
		return absRef;
	}
	
	public void setAbsRef(String absRef) {
		this.absRef = absRef;
	}

	@Override
	public String getClassName() {
		return "Setting";
	}
	
}
