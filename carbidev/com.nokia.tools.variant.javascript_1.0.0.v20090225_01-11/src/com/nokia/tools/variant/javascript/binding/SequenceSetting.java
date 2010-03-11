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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ScriptableObject;

import com.nokia.tools.variant.confml.core.model.application.EAppSequenceData;
import com.nokia.tools.variant.confml.core.model.application.EAppSequenceDataItem;
import com.nokia.tools.variant.confml.core.model.application.EAppSequenceType;
import com.nokia.tools.variant.confml.core.model.application.EAppSetting;
import com.nokia.tools.variant.confml.core.model.application.EAppSettingType;

public class SequenceSetting extends Setting {

	public SequenceSetting() {
		
	}

	
	public void fillSequenceSetting(EAppSetting appSetting) {
		setAppSetting(appSetting);
		
		EAppSequenceData sequenceData = (EAppSequenceData) appSetting.getValueInfo();
		EAppSequenceType sequenceType = (EAppSequenceType) appSetting.getTypeInfo();
		
		// type map of subSettings
		EMap<String, EAppSettingType> subSettingTypeMap = sequenceType.getTypeMap();
		
		EList<EAppSequenceDataItem> items = sequenceData.getItems();
		// note: at the creation time all items must have all theirs possible attributes set up and present in the model. 
		for (int i = 0 ; i < items.size() ; i++) {
			EAppSequenceDataItem item = items.get(i);

			Context cx = Context.enter(); 
			SequenceItem si = (SequenceItem) cx.newObject(getParentScope(), "SequenceItem");
			si.setLogger(getLogger());
			si.setAbsRef(getAbsRef() + "[" + i + "]");
			si.fillSequenceItem(item);
			
			ScriptableObject.putProperty(this, "" + i, si);

			Object o = this.get("" + i, null);
		}
	}
	
	
	public void jsConstructor() {

	}

	
	public SequenceItem jsFunction_getItem(int i) {
		return (SequenceItem) get("" + i, null);
	}
	
	
	@Override
	public String getClassName() {
		return "SequenceSetting";
	}

}
