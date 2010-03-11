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

import com.nokia.tools.vct.common.appmodel.EAppSettingType;
import com.nokia.tools.vct.common.appmodel.EAppSimpleType;
import com.nokia.tools.vct.common.appmodel.EAppValueType;
import com.nokia.tools.vct.confml.model.confml1.ESettingData;
import com.nokia.tools.vct.validation.confml.constraints.ConfMLUtils;

public class InvalidIntegerValue extends AbstractModelConstraint {

	public InvalidIntegerValue() {
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
				if (appSimpleType.getType() == EAppValueType.INTEGER) {
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
				if (appSimpleType.getType() == EAppValueType.INTEGER) {
					value = ConfMLUtils.getCorrectValue(settingData, appSimpleType, typePath);
				}
			}
		}

		if (value!=null)
		{
			if (value.equals("") && typePath.split("/").length==3)
				return ctx.createSuccessStatus();
				
			long integerValue = 0;
			try
			{
				if (value.startsWith("0x") || value.startsWith("0X"))
					integerValue = Long.parseLong(value.substring(2), 16);
				else	
					integerValue = (new Long(value)).longValue();
				
				IStatus commonStatus = null;
				commonStatus = CommonConstraints.maxExclusive(ctx, typePath, appSimpleType.getMaxExclusive(), integerValue);
				if (commonStatus!=null)
					return commonStatus;
				commonStatus = CommonConstraints.minExclusive(ctx, typePath, appSimpleType.getMinExclusive(), integerValue);
				if (commonStatus!=null)
					return commonStatus;
				commonStatus = CommonConstraints.maxInclusive(ctx, typePath, appSimpleType.getMaxInclusive(), integerValue);
				if (commonStatus!=null)
					return commonStatus;
				commonStatus = CommonConstraints.minInclusive(ctx, typePath, appSimpleType.getMinInclusive(), integerValue);
				if (commonStatus!=null)
					return commonStatus;
				commonStatus = CommonConstraints.totalDigits(ctx, typePath, appSimpleType.getTotalDigits(), integerValue);
				if (commonStatus!=null)
					return commonStatus;
				commonStatus = CommonConstraints.pattern(ctx, typePath, appSimpleType.getPattern(), ""+integerValue);
				if (commonStatus!=null)
					return commonStatus;
				
			}
			catch (NumberFormatException nfe)
			{
				return ctx.createFailureStatus("Setting "+typePath+" has invalid integer value "+value);
			}
			//IMPROVEMENT: do we need to check something else?
		}
			
		return ctx.createSuccessStatus();
	}
}
