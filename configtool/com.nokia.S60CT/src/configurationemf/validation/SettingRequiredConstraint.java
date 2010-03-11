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
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;

import variantdata.util.ElementRefParser;
import configurationemf.LeafSettingDelegator;
import configurationemf.Setting;

public class SettingRequiredConstraint extends AbstractModelConstraint
{

	public SettingRequiredConstraint()
	{
	}

	@Override
	public IStatus validate(IValidationContext ctx)
	{
		EObject obj = ctx.getTarget();
		
		if (obj instanceof Setting)
		{
			Setting setting = (Setting)obj;
			return validateSetting(setting, ctx);
			
		}
		else if (obj instanceof LeafSettingDelegator)
		{
			LeafSettingDelegator lsd = (LeafSettingDelegator)obj;
			return validateSetting(lsd.getLeafSetting(),ctx);
		}
		
		return ctx.createSuccessStatus();
	}

	private IStatus validateSetting(Setting setting, IValidationContext ctx)
	{
		if (setting.getRequired()!= null && setting.getRequired().equalsIgnoreCase("true"))
		{
			if (setting.getCurrentValue()==null)
			{
				return MarkerManager.getInstance().addProblem(ctx, ElementRefParser.getName(setting), "Setting "+ElementRefParser.getName(setting)+" is required, but value is not given.");
			}
		}
		return ctx.createSuccessStatus();
	}
}
