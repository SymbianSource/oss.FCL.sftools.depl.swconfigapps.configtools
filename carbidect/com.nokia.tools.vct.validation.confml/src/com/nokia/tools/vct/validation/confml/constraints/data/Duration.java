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
import com.nokia.tools.vct.confml.model.confml2.ESettingData;
import com.nokia.tools.vct.validation.confml.constraints.ConfMLUtils;

public class Duration extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) 
	{
		ESettingData settingData = (ESettingData) ctx.getTarget();
		StringBuilder tmp = new StringBuilder();
		EAppSettingType ptr = ConfMLUtils.findType(settingData, tmp);
		String typePath = tmp.toString();

		if (ptr instanceof EAppSimpleType) {
			EAppSimpleType appSimpleType = (EAppSimpleType)ptr;
			if (appSimpleType.getType() == EAppValueType.DURATION) {
				String value = ConfMLUtils.getCorrectValue(settingData, appSimpleType, typePath);
				
				if (value != null)
				{
					if (value.equals("") && typePath.split("/").length==3)
						return ctx.createSuccessStatus();
					
					boolean ok = check(value);
					if (!ok)
						return ctx.createFailureStatus(typePath, value);
					
					IStatus commonStatus = null;
					commonStatus = CommonConstraints.maxExclusive(ctx, typePath, appSimpleType.getMaxExclusive(), value);
					if (commonStatus!=null)
						return commonStatus;
					commonStatus = CommonConstraints.minExclusive(ctx, typePath, appSimpleType.getMinExclusive(), value);
					if (commonStatus!=null)
						return commonStatus;
					commonStatus = CommonConstraints.maxInclusive(ctx, typePath, appSimpleType.getMaxInclusive(), value);
					if (commonStatus!=null)
						return commonStatus;
					commonStatus = CommonConstraints.minInclusive(ctx, typePath, appSimpleType.getMinInclusive(), value);
					if (commonStatus!=null)
						return commonStatus;
					commonStatus = CommonConstraints.pattern(ctx, typePath, appSimpleType.getPattern(), value);
					if (commonStatus!=null)
						return commonStatus;
				}
			}
		}
		return ctx.createSuccessStatus();
	}
	
	
	private boolean check(String value)
	{
		boolean inTime = false;
		int startIndex = 1;
		Integer years = null;
		Integer months = null;
		Integer days = null;
		Integer hours = null;
		Integer minutes = null;
		Integer seconds = null;
		
		if (!value.startsWith("P") || value.length() < 3)
			return false;
		try
		{
			for (int i = 1 ; i < value.length() ; i++)
			{
				char c = value.charAt(i);
				
				if (Character.isDigit(c))
				{
					if (i==value.length()-1)
						return false;
				}
				else if (!inTime)
				{
					if (c=='T')
					{
						inTime = true;
						startIndex = i+1;
					}
					else if (c=='Y' && years == null && months == null && days == null)
					{
						String duration = value.substring(startIndex, i);
						years = new Integer(duration);
						startIndex = i+1;
					}
					else if (c=='M' && months == null && days == null)
					{
						String duration = value.substring(startIndex, i);
						months = new Integer(duration);
						startIndex = i+1;
					}
					else if (c=='D' && days == null)
					{
						String duration = value.substring(startIndex, i);
						days = new Integer(duration);
						startIndex = i+1;
					}
					else 
						return false;
				}
				else if (inTime)
				{
					if (c=='H' && hours == null && minutes == null && seconds == null)
					{
						String duration = value.substring(startIndex, i);
						hours = new Integer(duration);
						startIndex = i+1;
					}
					else if (c=='M' && minutes == null && seconds == null)
					{
						String duration = value.substring(startIndex, i);
						minutes = new Integer(duration);
						startIndex = i+1;
					}
					else if (c=='S' && seconds == null)
					{
						String duration = value.substring(startIndex, i);
						seconds = new Integer(duration);
						startIndex = i+1;
					}
					else 
						return false;
				}
				else 
					return false;
			}
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}
	

}
