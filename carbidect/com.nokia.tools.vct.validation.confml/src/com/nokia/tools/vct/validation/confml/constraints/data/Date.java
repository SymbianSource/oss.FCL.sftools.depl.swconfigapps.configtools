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

public class Date extends AbstractModelConstraint {

	static final int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public Date() {
		super();
	}

	@Override
	public IStatus validate(IValidationContext ctx) {
		ESettingData settingData = (ESettingData) ctx.getTarget();
		StringBuilder tmp = new StringBuilder();
		EAppSettingType ptr = ConfMLUtils.findType(settingData, tmp);
		String typePath = tmp.toString();

		if (ptr instanceof EAppSimpleType) {
			EAppSimpleType appSimpleType = (EAppSimpleType)ptr;
			if (appSimpleType.getType() == EAppValueType.DATE) {
				String value = ConfMLUtils.getCorrectValue(settingData, appSimpleType, typePath);
				if (value!=null)
				{
					if (value.equals("") && typePath.split("/").length==3)
						return ctx.createSuccessStatus();
					
					boolean ok = false;
					if (value.matches("\\d\\d\\d\\d-\\d\\d-\\d\\d")) //YYYY-MM-DD
					{
						String[] split = value.split("-");
						ok = checkCalendar(split, null);
					}
					else if (value.matches("\\d\\d\\d\\d-\\d\\d-\\d\\dZ")) //YYYY-MM-DDZ
					{
						String[] split = value.split("-");
						split[2] = split[2].substring(0, 2);
						ok = checkCalendar(split, null);
					}
					else if (value.matches("\\d\\d\\d\\d-\\d\\d-\\d\\d[+-]\\d\\d:\\d\\d")) //YYYY-MM-DD+hh:mm
					{
						String[] split = value.split("-");
						split[2] = split[2].substring(0, 2);
						String timeZone = value.substring(10);
						ok = checkCalendar(split, timeZone);
					}
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
	
	private boolean checkCalendar(String[] split, String timeZone)
	{
		int year = (new Integer(split[0]).intValue());
		int month = (new Integer(split[1]).intValue());
		int day = (new Integer(split[2]).intValue());
		
		if (month < 1 || month > 12)
			return false;
		int maxDays = daysInMonth[month-1];
		if (year%4==0 && month==2)
			maxDays = 29;
		if (day < 1 || day > maxDays)
			return false;
		
		if (timeZone!=null)
		{
			String[] timeZoneSplit = timeZone.split(":");
			if (timeZoneSplit[0].startsWith("+"))
				timeZoneSplit[0] = timeZoneSplit[0].substring(1);
			int tzHour = (new Integer(timeZoneSplit[0]).intValue());
			int tzMinute = (new Integer(timeZoneSplit[1]).intValue());
			
			if (tzHour >= -12 && tzHour <= 14)
			{
				if (tzMinute == 0)
				{
					return true;
				}
				else if (tzMinute == 30)
				{
					if (tzHour==11 || tzHour==10 || tzHour==9 || tzHour==6 || tzHour==5 || tzHour==4 || tzHour==3 || tzHour==-3 || tzHour==4|| tzHour==-9)
						return true;
				}
				else if (tzMinute == 45)
				{
					if (tzHour==12|| tzHour==8 || tzHour==5)
						return true;
				}
			}
			return false;
		}
		
		return true;
	}
	
}
