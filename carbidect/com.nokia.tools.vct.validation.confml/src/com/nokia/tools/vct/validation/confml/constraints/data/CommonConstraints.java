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

import java.math.BigDecimal;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.IValidationContext;

import com.nokia.tools.vct.common.appmodel.EAppExpression;
import com.nokia.tools.vct.common.appmodel.EAppFeature;
import com.nokia.tools.vct.common.appmodel.EAppSetting;
import com.nokia.tools.vct.common.appmodel.EAppSettingType;
import com.nokia.tools.vct.common.appmodel.EAppSimpleType;
import com.nokia.tools.vct.common.confml.expressions.ConfMLExpressionsPlugin;
import com.nokia.tools.vct.common.confml.expressions.IConfMLSettingValuesProvider;
import com.nokia.tools.vct.validation.confml.constraints.ConfMLUtils;


public class CommonConstraints {


	public static IStatus length(IValidationContext ctx, String typePath, Integer length, String value)
	{
		if (length==null)
			return null;
		if (value.length()!=length.intValue())
			return ctx.createFailureStatus("Setting's "+typePath+" exact number of characters must be "+length.intValue());
		
		return null;
	}
	
	public static IStatus minLength(IValidationContext ctx, String typePath, Integer minLength, String value)
	{
		if (minLength==null)
			return null;
		if (value.length()<minLength.intValue())
			return ctx.createFailureStatus("Setting's "+typePath+" minimum number of characters is "+minLength.intValue());
		
		return null;
	}
	
	public static IStatus maxLength(IValidationContext ctx, String typePath, Integer maxLength, String value)
	{
		if (maxLength==null)
			return null;
		if (value.length()>maxLength)
			return ctx.createFailureStatus("Setting's "+typePath+" maximum number of characters is "+maxLength.intValue());
		
		return null;
	}
	
	public static IStatus totalDigits(IValidationContext ctx, String typePath, Integer totalDigits, long value)
	{
		if (totalDigits==null)
			return null;
		if ((""+value).length()>totalDigits.intValue())
			return ctx.createFailureStatus("Setting's "+typePath+" maximum number of digits is "+totalDigits.intValue());
		
		return null;
	}

	public static IStatus minInclusive(IValidationContext ctx, String typePath, Object minInclusive, long value)
	{
		if (minInclusive==null)
			return null;
		if (minInclusive instanceof BigDecimal)
		{
			BigDecimal bd = (BigDecimal)minInclusive;
			if (value<bd.longValue())
			{
				return ctx.createFailureStatus("Setting's "+typePath+" value "+value+" is out of bounds. Value must be >="+bd.longValue());
			}
		}
		return null;
	}
	
	public static IStatus maxInclusive(IValidationContext ctx, String typePath, Object maxInclusive, long value)
	{
		if (maxInclusive==null)
			return null;
		if (maxInclusive instanceof BigDecimal)
		{
			BigDecimal bd = (BigDecimal)maxInclusive;
			if (value>bd.longValue())
			{
				return ctx.createFailureStatus("Setting's "+typePath+" value "+value+" is out of bounds. Value must be <="+bd.longValue());
			}
		}
		return null;
	}
	
	public static IStatus minExclusive(IValidationContext ctx, String typePath, Object minExclusive, long value)
	{
		if (minExclusive==null)
			return null;
		if (minExclusive instanceof BigDecimal)
		{
			BigDecimal bd = (BigDecimal)minExclusive;
			if (value<=bd.longValue())
			{
				return ctx.createFailureStatus("Setting's "+typePath+" value "+value+" is out of bounds. Value must be >"+bd.longValue());
			}
		}
		return null;
	}
	
	public static IStatus maxExclusive(IValidationContext ctx, String typePath, Object maxExclusive, long value)
	{
		if (maxExclusive==null)
			return null;
		if (maxExclusive instanceof BigDecimal)
		{
			BigDecimal bd = (BigDecimal)maxExclusive;
			if (value>=bd.longValue())
			{
				return ctx.createFailureStatus("Setting's "+typePath+" value "+value+" is out of bounds. Value must be <"+bd.longValue());
			}
		}
		return null;
	}

	//DOUBLE
	public static IStatus minInclusive(IValidationContext ctx, String typePath, Object minInclusive, double value)
	{
		if (minInclusive==null)
			return null;
		if (minInclusive instanceof BigDecimal)
		{
			BigDecimal bd = (BigDecimal)minInclusive;
			if (value<bd.doubleValue())
			{
				return ctx.createFailureStatus("Setting's "+typePath+" value "+value+" is out of bounds. Value must be >="+bd.doubleValue());
			}
		}
		return null;
	}
	
	public static IStatus maxInclusive(IValidationContext ctx, String typePath, Object maxInclusive, double value)
	{
		if (maxInclusive==null)
			return null;
		if (maxInclusive instanceof BigDecimal)
		{
			BigDecimal bd = (BigDecimal)maxInclusive;
			if (value>bd.doubleValue())
			{
				return ctx.createFailureStatus("Setting's "+typePath+" value "+value+" is out of bounds. Value must be <="+bd.doubleValue());
			}
		}
		return null;
	}
	
	public static IStatus minExclusive(IValidationContext ctx, String typePath, Object minExclusive, double value)
	{
		if (minExclusive==null)
			return null;
		if (minExclusive instanceof BigDecimal)
		{
			BigDecimal bd = (BigDecimal)minExclusive;
			if (value<=bd.doubleValue())
			{
				return ctx.createFailureStatus("Setting's "+typePath+" value "+value+" is out of bounds. Value must be >"+bd.doubleValue());
			}
		}
		return null;
	}
	
	public static IStatus maxExclusive(IValidationContext ctx, String typePath, Object maxExclusive, double value)
	{
		if (maxExclusive==null)
			return null;
		if (maxExclusive instanceof BigDecimal)
		{
			BigDecimal bd = (BigDecimal)maxExclusive;
			if (value>=bd.doubleValue())
			{
				return ctx.createFailureStatus("Setting's "+typePath+" value "+value+" is out of bounds. Value must be <"+bd.doubleValue());
			}
		}
		return null;
	}

	public static IStatus pattern(IValidationContext ctx, String typePath, EList<String> patterns, String value)
	{
		if (patterns==null || patterns.size()==0)
			return null;
		for(String pattern : patterns)
		{
			if (!value.matches(pattern))
				return ctx.createFailureStatus("Setting's "+typePath+" value "+value+" doesn't match the required pattern.");
		}
		return null;
	}
	
	//STRING
	public static IStatus minInclusive(IValidationContext ctx, String typePath, Object minInclusive, String value)
	{
		if (minInclusive==null)
			return null;
		/*if (minInclusive instanceof BigDecimal)
		{
			BigDecimal bd = (BigDecimal)minInclusive;
			//if (value<bd.longValue())
			{
				return ctx.createFailureStatus("Setting's "+typePath+" value "+value+" is out of bounds. Value must be >="+bd.longValue());
			}
		}*/
		return null;
	}
	
	public static IStatus maxInclusive(IValidationContext ctx, String typePath, Object maxInclusive, String value)
	{
		if (maxInclusive==null)
			return null;
		/*if (maxInclusive instanceof BigDecimal)
		{
			BigDecimal bd = (BigDecimal)maxInclusive;
			//if (value>bd.longValue())
			{
				return ctx.createFailureStatus("Setting's "+typePath+" value "+value+" is out of bounds. Value must be <="+bd.longValue());
			}
		}*/
		return null;
	}
	
	public static IStatus minExclusive(IValidationContext ctx, String typePath, Object minExclusive, String value)
	{
		if (minExclusive==null)
			return null;
		/*if (minExclusive instanceof BigDecimal)
		{
			BigDecimal bd = (BigDecimal)minExclusive;
			//if (value<=bd.longValue())
			{
				return ctx.createFailureStatus("Setting's "+typePath+" value "+value+" is out of bounds. Value must be >"+bd.longValue());
			}
		}*/
		return null;
	}
	
	public static IStatus maxExclusive(IValidationContext ctx, String typePath, Object maxExclusive, String value)
	{
		if (maxExclusive==null)
			return null;
		/*if (maxExclusive instanceof BigDecimal)
		{
			BigDecimal bd = (BigDecimal)maxExclusive;
			//if (value>=bd.longValue())
			{
				return ctx.createFailureStatus("Setting's "+typePath+" value "+value+" is out of bounds. Value must be <"+bd.longValue());
			}
		}*/
		return null;
	}
	
	
	
}
