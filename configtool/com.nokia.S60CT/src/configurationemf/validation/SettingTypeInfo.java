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
import configurationemf.TYPE;


public class SettingTypeInfo extends AbstractModelConstraint
{

	public SettingTypeInfo()
	{
	}

	@Override
	public IStatus validate(IValidationContext ctx)
	{
		EObject obj = ctx.getTarget();
		
		if (obj instanceof Setting)
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
		if (type.equals(TYPE.FILE))
			return MarkerManager.getInstance().addProblem(ctx, ElementRefParser.getName(setting), "Setting type \"file\" is not officially supported yet and should not be used.");
		else if (type.equals(TYPE.FOLDER))
			return MarkerManager.getInstance().addProblem(ctx, ElementRefParser.getName(setting), "Setting type \"folder\" is not officially supported yet and should not be used.");
			
		
		return ctx.createSuccessStatus();
	}
}
