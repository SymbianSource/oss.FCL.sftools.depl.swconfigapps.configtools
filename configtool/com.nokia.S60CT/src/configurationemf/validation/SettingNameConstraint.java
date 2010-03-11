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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;

import configurationemf.LeafSettingDelegator;
import configurationemf.Setting;

public class SettingNameConstraint extends AbstractModelConstraint {

	
	public SettingNameConstraint() {
	}
	
	@Override
	public IStatus validate(IValidationContext ctx) {
		
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
		/* This validation doesn't make any sense. Why setting name couldn't have / (forward slash).
		String name = setting.getName();
		
		if(name != null)
		{
			for (int i = 0 ; i < name.length() ; i++)
			{
				char c = name.charAt(i);
				if (c =='/')
				{
					return MarkerManager.getInstance().addProblem(ctx, ElementRefParser.getName(setting), "Setting name "+ElementRefParser.getName(setting)+" contains invalid character \""+c+"\".");
				}
			}
		}
		*/
		return ctx.createSuccessStatus();
	}
}
