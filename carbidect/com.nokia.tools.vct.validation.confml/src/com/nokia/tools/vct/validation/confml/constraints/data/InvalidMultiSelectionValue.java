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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;

import com.nokia.tools.vct.common.appmodel.EAppSettingOption;
import com.nokia.tools.vct.common.appmodel.EAppSettingType;
import com.nokia.tools.vct.common.appmodel.EAppSimpleType;
import com.nokia.tools.vct.common.appmodel.EAppValueType;
import com.nokia.tools.vct.confml.model.confml2.ESettingData;
import com.nokia.tools.vct.validation.confml.constraints.ConfMLUtils;

public class InvalidMultiSelectionValue extends AbstractModelConstraint {

	public InvalidMultiSelectionValue() {
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
				if (appSimpleType.getType() == EAppValueType.MULTISELECTION) {
					value = ConfMLUtils.getCorrectValue(settingData, appSimpleType, typePath);
				}
			}
		}

		if (value !=null && !value.equals(""))
		{
			Object[] values = parseValue(value);
			boolean found = false;
			for (int i = 0 ; i < values.length ; i++)
			{
				found = false;
				String singleValue = (String)values[i];
				for (EAppSettingOption option: appSimpleType.getOptions())
				{
					if (option.getLiteralValue()!= null && option.getLiteralValue().equals(singleValue))
					{
						found = true;
						break;
					}
				}
				if (!found)
					return ctx.createFailureStatus(typePath, value); //no matching option value found
			}
		}

		return ctx.createSuccessStatus();
	}
	
	private Object[] parseValue(String value)
	{
		if (value.indexOf("\"")==-1)
		{
			return value.split(" ");
		}
		else
		{
			List<String> values = new ArrayList<String>();
			int startIndex = 0;
			boolean insideQuotes = false;
			for (int i = 0 ; i < value.length() ; i++)
			{
				if (value.charAt(i)==' ' && !insideQuotes)
				{
					//values.add(value.substring(startIndex, i));
					
				}
				else if (value.charAt(i)=='\"')
				{
					if (insideQuotes)
					{
						values.add(value.substring(startIndex, i));
						insideQuotes = false;
					}
					else
					{
						insideQuotes = true;
						startIndex=i+1;	
					}
				}
				else if (i==value.length()-1)
				{
					if (!insideQuotes)
					{
						values.add(value.substring(startIndex, i));
					}
					else
					{
						return null; //error!
					}
				}
			}
			return values.toArray();
		}
	}
	
}
