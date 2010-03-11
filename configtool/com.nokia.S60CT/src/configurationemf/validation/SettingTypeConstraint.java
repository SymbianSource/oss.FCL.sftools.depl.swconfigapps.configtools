/*
* Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies). 
* All rights reserved.
* This component and the accompanying materials are made available
* under the terms of "Eclipse Public License v1.0"
* which accompanies this distribution, and is available
* at the URL "http://www.eclipse.org/legal/epl-v10.html".
*
* Initial Contributors:
* Nokia Corporation - initial contribution.
*
* Contributors:
*
* Description:
*
*/
package configurationemf.validation;

import helpers.MarkerManager;

import java.io.File;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;

import variantdata.util.ElementRefParser;
import configurationemf.Configuration;
import configurationemf.LeafSetting;
import configurationemf.LeafSettingDelegator;
import configurationemf.Option;
import configurationemf.ParentSetting;
import configurationemf.Setting;
import configurationemf.TYPE;

public class SettingTypeConstraint extends AbstractModelConstraint
{
	private static final String URL_POSTFIX = "#No_value_defined_for_a_setting_.7B.25ref.25.7D";
	
	public SettingTypeConstraint()
	{
	}

	@Override
	public IStatus validate(IValidationContext ctx)
	{
		EObject obj = ctx.getTarget();
		
		if (obj instanceof LeafSetting) //template of sequence setting
		{
			//do nothing...
		}
		else if (obj instanceof Setting)
		{
			Setting setting = (Setting)obj;
			String value = setting.getTopValue();
			return validateSetting(setting, value, ctx);
		}
		else if (obj instanceof LeafSettingDelegator)
		{
			LeafSettingDelegator lsd = (LeafSettingDelegator)obj;
			return validateSetting(lsd.getLeafSetting(), lsd.getValue() ,ctx);
		}
		return ctx.createSuccessStatus();
	}
	
	private IStatus validateSetting(Setting setting, String value, IValidationContext ctx)
	{
		IStatus status = null;
		TYPE type = setting.getType();
		
		if (type.equals(TYPE.UNDEFINED))
		{
			String quickFixID = "configuration.undefined.setting.type";
			Configuration conf = setting.getDefaultConf();
			if (conf != null && conf.isReadOnly())
				quickFixID = null;
			
			if (value!=null)
			{
				try
				{
					int intValue = Integer.parseInt(value);
					if (intValue==0 || intValue==1)
						quickFixID = null;
				}
				catch (NumberFormatException nfe)
				{
					quickFixID = null;
				}
			}
			else
				quickFixID = null;
			
			return MarkerManager.getInstance().addProblem(ctx, ElementRefParser.getName(setting), "Setting "+ElementRefParser.getName(setting)+" has undefined type.", null, quickFixID, value);
		}
		
		if (type.equals(TYPE.SEQUENCE)) //value is null
		{
			ParentSetting parentSetting = (ParentSetting)setting;
			int minOccurs = parentSetting.getMinOccurs();
			int maxOccurs = parentSetting.getMaxOccurs();
			int frameCount = parentSetting.getFrames().size();
			if (frameCount < minOccurs)
			{
				return MarkerManager.getInstance().addProblem(ctx, ElementRefParser.getName(parentSetting), "Sequence setting " + ElementRefParser.getName(parentSetting) + " has too few occurences. Minumum size is " + minOccurs);
			}
			if (frameCount > maxOccurs)
			{
				return MarkerManager.getInstance().addProblem(ctx, ElementRefParser.getName(parentSetting), "Sequence setting " + ElementRefParser.getName(parentSetting) + " has too many occurences. Maximum size is " + maxOccurs);
			}
			return ctx.createSuccessStatus();
		}
		
		if (value == null)
		{	
			if (setting instanceof LeafSetting)
				return ctx.createSuccessStatus();
			else
				return MarkerManager.getInstance().addProblem(ctx, ElementRefParser.getName(setting), "No value defined for a setting " + ElementRefParser.getName(setting),
						URL_POSTFIX);
		}
			
		if (type.equals(TYPE.STRING)) //|| type.equals(TYPE.FILE) || type.equals(TYPE.FOLDER))
		{
			/*
			if (value.indexOf("<=") != -1) {
				return Problems.addProblem(ctx, setting.eResource(), ElementRefParser.getName(setting),
						"Setting " + ElementRefParser.getName(setting) + " has invalid value. Characters '<=' must be represented using \"&lte;\"");
			}
			else if (value.indexOf(">=") != -1) {
				return Problems.addProblem(ctx, setting.eResource(), ElementRefParser.getName(setting),
						"Setting " + ElementRefParser.getName(setting) + " has invalid value. Characters '>=' must be represented using \"&gte;\"");
			}
			else if (value.contains("<"))
				return Problems.addProblem(ctx, setting.eResource(), ElementRefParser.getName(setting),
						"Setting " + ElementRefParser.getName(setting) + " has invalid value. Character '<' must be represented using \"&lt;\"");
			else if (value.contains(">"))
				return Problems.addProblem(ctx, setting.eResource(), ElementRefParser.getName(setting),
						"Setting " + ElementRefParser.getName(setting) + " has invalid value. Character '>' must be represented using \"&gt;\"");
			else if (value.contains("&"))
			{
				//check that if & is part of &lte, &gte, &lt, &gt or &amp
				int index = -1;
				do
				{
					index = value.indexOf("&", index+1);
					if (index != -1)
					{
						boolean error = true;
						try
						{
							String subString2 = value.substring(index+1, index+4);
							if (subString2.equals("lt;") || subString2.equals("gt;"))
							{
								error = false;
							}
							else
							{
								String subString3 = value.substring(index+1, index+5);
								if (subString3.equals("lte;") || subString3.equals("gte;") || subString3.equals("amp;"))
									error = false;
							}
						}
						catch (StringIndexOutOfBoundsException sioobe)
						{
							error = true;
						}
						if (error)
							return Problems.addProblem(ctx, setting.eResource(), ElementRefParser.getName(setting),
									"Setting " + ElementRefParser.getName(setting) + " has invalid value. Character '&' must be represented using \"&amp;\"");
					}
				}
				while (index != -1);
			}
			*/
			
			status = validateMaxLength(setting, value, ctx, true);
			if (status != null)
				return status;
			status = validateMinLength(setting, value, ctx, true);
			if (status != null)
				return status;
			status = validateLength(setting, value, ctx, true);
			if (status != null)
				return status;
			status = validatePattern(setting, value, ctx);
			if (status != null)
				return status;

			if (type.equals(TYPE.FILE) || type.equals(TYPE.FOLDER))
			{
				if (value.contains("\""))
					return MarkerManager.getInstance().addProblem(ctx, ElementRefParser.getName(setting), "Setting " + ElementRefParser.getName(setting) + " has invalid separator character. Use forward slash (/) for separator character.");
				
				if ((new File(value)).isAbsolute())
					return MarkerManager.getInstance().addProblem(ctx, ElementRefParser.getName(setting), "Setting " + ElementRefParser.getName(setting) + " has absolute path. The path must be always relative");
			}
		}
		else if (type.equals(TYPE.INT)) //must be handled as long, since some confmls have really big hex values.
		{
			if (setting instanceof LeafSetting && value.equals(""))
				return ctx.createSuccessStatus(); //it's ok if sequence setting has empty integer?
			
			long integerValue = 0;
			try
			{
				if (value.startsWith("0x") || value.startsWith("0X"))
					integerValue = Long.parseLong(value.substring(2), 16);
				else	
					integerValue = (new Long(value)).longValue();
			}
			catch (NumberFormatException decnfe)
			{
				return MarkerManager.getInstance().addProblem(ctx, ElementRefParser.getName(setting), "Setting "+ElementRefParser.getName(setting)+" has invalid integer value ("+value+").");
			}
			status = validateMaxExclusive(setting, integerValue, ctx);
			if (status != null)
				return status;
			status = validateMinExclusive(setting, integerValue, ctx);
			if (status != null)
				return status;
			status = validateMaxInclusive(setting, integerValue, ctx);
			if (status != null)
				return status;
			status = validateMinInclusive(setting, integerValue, ctx);
			if (status != null)
				return status;
			status = validateTotalDigits(setting, value, ctx);
			if (status != null)
				return status;
			//status = validateMinLength(setting, value, ctx, false); //not is specification!
			//if (status != null)
			//	return status;
			status = validatePattern(setting, value, ctx);
			if (status != null)
				return status;
		}
		else if (type.equals(TYPE.REAL))
		{
			if (setting instanceof LeafSetting && value.equals(""))
				return ctx.createSuccessStatus(); //it's ok if sequence setting has empty real?
			
			double doubleValue = 0;
			try
			{
				doubleValue = (new Double(value)).doubleValue();
			}
			catch (NumberFormatException nfe)
			{
				return MarkerManager.getInstance().addProblem(ctx, ElementRefParser.getName(setting), "Setting "+ElementRefParser.getName(setting)+" has invalid real value.");
			}
			status = validateMaxExclusive(setting, doubleValue, ctx);
			if (status != null)
				return status;
			status = validateMinExclusive(setting, doubleValue, ctx);
			if (status != null)
				return status;
			status = validateMaxInclusive(setting, doubleValue, ctx);
			if (status != null)
				return status;
			status = validateMinInclusive(setting, doubleValue, ctx);
			if (status != null)
				return status;
			status = validatePattern(setting, value, ctx);
			if (status != null)
				return status;
		}
		else if (type.equals(TYPE.BOOLEAN))
		{
			if (setting instanceof LeafSetting && value.equals(""))
				return ctx.createSuccessStatus();
			if (!(value.equals("true") || value.equals("false") || value.equals("1") || value.equals("0")))
				return MarkerManager.getInstance().addProblem(ctx, ElementRefParser.getName(setting), "Setting "+ElementRefParser.getName(setting)+" has invalid boolean value.");
			status = validatePattern(setting, value, ctx);
			if (status != null)
				return status;
		}
		else if (type.equals(TYPE.SELECTION))
		{
			for (Option option : setting.getOption())
			{
				if (option.getValue().equals(value))
					return ctx.createSuccessStatus();
			}
			if (setting instanceof LeafSetting)
				return ctx.createSuccessStatus(); //it's ok if sequence setting has empty selection?
			else
				return MarkerManager.getInstance().addProblem(ctx, ElementRefParser.getName(setting), "Setting "+ElementRefParser.getName(setting)+" value "+value+" is not included in options.");
		}

		return ctx.createSuccessStatus();
	}
	
	private IStatus validateLength(Setting setting, String value, IValidationContext ctx, boolean asCharacters)
	{
		if (setting.getLength() != null)
		{
			int length = setting.getLength().getValue();
			if (value.length()!=length)
			{	if (asCharacters)
					return MarkerManager.getInstance().addProblem(ctx, ElementRefParser.getName(setting), "Setting "+ElementRefParser.getName(setting)+" exact number of characters must be "+length+".");
				else
					return MarkerManager.getInstance().addProblem(ctx, ElementRefParser.getName(setting), "Setting "+ElementRefParser.getName(setting)+" exact number of digits must be "+length+".");
		
			}
		}
		return null;
	}
	private IStatus validateMaxLength(Setting setting, String value, IValidationContext ctx, boolean asCharacters)
	{
		if (setting.getMaxLength()!= null)
		{
			int maxLength = setting.getMaxLength().getValue();
			if (value.length()>maxLength)
			{	if (asCharacters)
					return MarkerManager.getInstance().addProblem(ctx, ElementRefParser.getName(setting), "Setting "+ElementRefParser.getName(setting)+" maximum number of characters is "+maxLength+".");
				else
					return MarkerManager.getInstance().addProblem(ctx, ElementRefParser.getName(setting), "Setting "+ElementRefParser.getName(setting)+" maximum number of digits is "+maxLength+".");
		
			}
		}
		return null;
	}
	private IStatus validateTotalDigits(Setting setting, String value, IValidationContext ctx)
	{
		if (setting.getMaxLength()!= null)
		{
			int totalDigits = setting.getTotalDigits().getValue();
			if (value.length()>totalDigits)
		{		return MarkerManager.getInstance().addProblem(ctx, ElementRefParser.getName(setting), "Setting "+ElementRefParser.getName(setting)+" maximum number of digits is "+totalDigits+".");
			}
		}
		return null;
	}

	
	private IStatus validateMinLength(Setting setting, String value, IValidationContext ctx, boolean asCharacters)
	{
		if (setting.getMinLength()!= null)
		{
			int minLength = setting.getMinLength().getValue();
			if (value.length()<minLength)
			{	if (asCharacters)
					return MarkerManager.getInstance().addProblem(ctx, ElementRefParser.getName(setting), "Setting "+ElementRefParser.getName(setting)+" minimum number of characters is "+minLength+".");
				else
					return MarkerManager.getInstance().addProblem(ctx, ElementRefParser.getName(setting), "Setting "+ElementRefParser.getName(setting)+" minimum number of digits is "+minLength+".");
			
			}
		}
		return null;
	}
	private IStatus validateMinExclusive(Setting setting, double value, IValidationContext ctx)
	{
		if (setting.getMinExclusive()!= null)
		{
			int minExclusive = setting.getMinExclusive().getValue();
			if (value<=minExclusive)
				return MarkerManager.getInstance().addProblem(ctx, ElementRefParser.getName(setting), "Setting "+ElementRefParser.getName(setting)+" value must be > "+minExclusive+".");
		}
		return null;
	}
	private IStatus validateMaxExclusive(Setting setting, double value, IValidationContext ctx)
	{
		if (setting.getMaxExclusive()!= null)
		{
			int maxExclusive = setting.getMaxExclusive().getValue();
			if (value>=maxExclusive)
				return MarkerManager.getInstance().addProblem(ctx, ElementRefParser.getName(setting), "Setting "+ElementRefParser.getName(setting)+" value must be < "+maxExclusive+".");
		}
		return null;
	}
	private IStatus validateMinInclusive(Setting setting, double value, IValidationContext ctx)
	{
		if (setting.getMinInclusive()!= null)
		{
			int minInclusive = setting.getMinInclusive().getValue();
			if (value<minInclusive)
				return MarkerManager.getInstance().addProblem(ctx, ElementRefParser.getName(setting), "Setting "+ElementRefParser.getName(setting)+" value must be >= "+minInclusive+".");
		}
		return null;
	}
	private IStatus validateMaxInclusive(Setting setting, double value, IValidationContext ctx)
	{
		if (setting.getMaxInclusive()!= null)
		{
			int maxInclusive = setting.getMaxInclusive().getValue();
			if (value>maxInclusive)
				return MarkerManager.getInstance().addProblem(ctx, ElementRefParser.getName(setting), "Setting "+ElementRefParser.getName(setting)+" value must be <= "+maxInclusive+".");
		}
		return null;
	}
	private IStatus validatePattern(Setting setting, String value, IValidationContext ctx)
	{
		if (setting.getPattern()!= null)
		{
			String pattern = setting.getPattern().getValue();
			if (!value.matches(pattern))
				return MarkerManager.getInstance().addProblem(ctx, ElementRefParser.getName(setting), "Setting "+ElementRefParser.getName(setting)+" value doesn't match the pattern.");
		}
		return null;
	}
}
