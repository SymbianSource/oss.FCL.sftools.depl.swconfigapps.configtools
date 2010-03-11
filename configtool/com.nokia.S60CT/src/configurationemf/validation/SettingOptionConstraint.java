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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;

import variantdata.util.ElementRefParser;
import configurationemf.LeafSettingDelegator;
import configurationemf.Option;
import configurationemf.Setting;

public class SettingOptionConstraint extends AbstractModelConstraint
{

	public SettingOptionConstraint()
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
		EList<Option> list = setting.getOption();
		for (int i = 0 ; i < list.size() ; i++)
		{
			Option option1 = list.get(i);
			
			if (i < list.size()-1)
			{
				for (int j = i+1 ; j < list.size() ; j++)
				{
					Option option2 = list.get(j);
					
					if (option1.getName().equals(option2.getName()))
						return MarkerManager.getInstance().addProblem(ctx, ElementRefParser.getName(setting), "Setting "+ElementRefParser.getName(setting)+" has duplicate option names.");
					if (option1.getValue().equals(option2.getValue()))
						return MarkerManager.getInstance().addProblem(ctx, ElementRefParser.getName(setting), "Setting "+ElementRefParser.getName(setting)+" has duplicate option values.");
				}
			}
		}
		return ctx.createSuccessStatus();
	}
}
