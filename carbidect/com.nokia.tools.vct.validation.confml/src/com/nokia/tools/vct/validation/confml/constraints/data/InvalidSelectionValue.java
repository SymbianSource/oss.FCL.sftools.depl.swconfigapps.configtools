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
 * Description: This file is part of com.nokia.tools.vct.validation.confml component.
 */

package com.nokia.tools.vct.validation.confml.constraints.data;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;

import com.nokia.tools.vct.common.appmodel.EAppSettingOption;
import com.nokia.tools.vct.common.appmodel.EAppSettingType;
import com.nokia.tools.vct.common.appmodel.EAppSimpleType;
import com.nokia.tools.vct.common.appmodel.EAppValueType;
import com.nokia.tools.vct.confml.model.confml1.ESettingData;
import com.nokia.tools.vct.validation.confml.constraints.ConfMLUtils;

public class InvalidSelectionValue extends AbstractModelConstraint {

	public InvalidSelectionValue() {
		super();
	}

	@Override
	public IStatus validate(IValidationContext ctx) {
		
		String value = null;
		String typePath = null;
		EAppSimpleType appSimpleType = null;
		
		if (ctx.getTarget() instanceof ESettingData) {
			ESettingData settingData = (ESettingData) ctx.getTarget();
			StringBuilder tmp = new StringBuilder();
			EAppSettingType ptr = ConfMLUtils.findType(settingData, tmp);
			typePath = tmp.toString();
			if (ptr instanceof EAppSimpleType) {
				appSimpleType = (EAppSimpleType)ptr;
				if (appSimpleType.getType() == EAppValueType.SELECTION) {
					value = ConfMLUtils.getCorrectValue(settingData, appSimpleType, typePath);
				}
			}
			
		}
		else if (ctx.getTarget() instanceof com.nokia.tools.vct.confml.model.confml2.ESettingData)
		{
			com.nokia.tools.vct.confml.model.confml2.ESettingData settingData = (com.nokia.tools.vct.confml.model.confml2.ESettingData) ctx.getTarget();
			StringBuilder tmp = new StringBuilder();
			EAppSettingType ptr = ConfMLUtils.findType(settingData, tmp);
			typePath = tmp.toString();
			
			if (ptr instanceof EAppSimpleType) {
				appSimpleType = (EAppSimpleType)ptr;
				if (appSimpleType.getType() == EAppValueType.SELECTION) {
					value = ConfMLUtils.getCorrectValue(settingData, appSimpleType, typePath);
				}
			}
			
			if (settingData.getMap()!=null && !settingData.getMap().equals(""))
				value = settingData.getMap();
		}
		
		if (value !=null)
		{
			if (value.equals("") && typePath.split("/").length==3)
				return ctx.createSuccessStatus();
			
			for (EAppSettingOption option: appSimpleType.getOptions())
			{
				if (option.getRefValue()!=null)
				{
					if (value.startsWith(option.getRefValue()))
					{
						//we would need to find correct sequence setting and check if this key is a given there...
						return ctx.createSuccessStatus(); //easy solution because it's probably ok
					}
				}
				else if (option!=null && option.getLiteralValue()!=null && option.getLiteralValue().equals(value))
				{
					return ctx.createSuccessStatus();
				}
			}
			return ctx.createFailureStatus(typePath, value); //no matching option value found
		}

		return ctx.createSuccessStatus();
	}
}
