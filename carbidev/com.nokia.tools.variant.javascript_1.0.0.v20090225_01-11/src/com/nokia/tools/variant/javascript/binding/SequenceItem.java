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

import java.util.Map.Entry;

import org.eclipse.emf.common.util.EMap;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ScriptableObject;

import com.nokia.tools.variant.confml.core.model.application.EAppResourceData;
import com.nokia.tools.variant.confml.core.model.application.EAppSequenceDataItem;
import com.nokia.tools.variant.confml.core.model.application.EAppSettingData;
import com.nokia.tools.variant.confml.core.model.application.EAppSimpleData;
import com.nokia.tools.variant.javascript.accesslog.AuditLogger;

public class SequenceItem extends ScriptableObject {

	private EAppSequenceDataItem item;

	protected AuditLogger logger;
	
	private String absRef;
	
	public SequenceItem() {
		
	}
	
	public AuditLogger getLogger() {
		return logger;
	}

	public void setLogger(AuditLogger logger) {
		this.logger = logger;
	}

	public String getAbsRef() {
		return absRef;
	}
	
	public void setAbsRef(String absRef) {
		this.absRef = absRef;
	}
	
	public void fillSequenceItem(EAppSequenceDataItem item) {
		this.item = item;

		EMap<String, EAppSettingData> itemSubSettings = item.getSubSettings();
		for (int i = 0 ; i < itemSubSettings.size() ; i++) {
			Entry<String, EAppSettingData> entry = itemSubSettings.get(i);
			
			String subSettingRef = entry.getKey();
			EAppSettingData subSettingData = entry.getValue();
			
			if (subSettingData instanceof EAppSimpleData) {
				Context cx = Context.enter(); 
				SimpleSubSetting s = (SimpleSubSetting) cx.newObject(getParentScope(), "SimpleSubSetting");
				s.setSimpleData((EAppSimpleData)subSettingData);
				s.setAbsRef(getAbsRef() + "/" + subSettingRef);
				s.setLogger(getLogger());
				ScriptableObject.putProperty(this, subSettingRef, s);
			} else if (subSettingData instanceof EAppResourceData) {
				Context cx = Context.enter(); 
				FileSubSetting s = (FileSubSetting) cx.newObject(getParentScope(), "FileSubSetting");
				s.setLogger(getLogger());
				s.setAbsRef(getAbsRef() + "/" + subSettingRef);
				s.setResourceData((EAppResourceData)subSettingData);
				s.setAbsRef(subSettingRef);
				ScriptableObject.putProperty(this, subSettingRef, s);
			}
			
		}
	
	}
	
	public void jsConstructor() {

	}


	@Override
	public String getClassName() {
		return "SequenceItem";
	}
	
}
