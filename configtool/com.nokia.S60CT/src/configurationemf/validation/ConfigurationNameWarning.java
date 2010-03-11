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
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;

import variantdata.util.ElementRefParser;
import configurationemf.Configuration;

public class ConfigurationNameWarning extends AbstractModelConstraint
{

	public ConfigurationNameWarning()
	{
	}

	@Override
	public IStatus validate(IValidationContext ctx)
	{
		Configuration conf = (Configuration)ctx.getTarget();
		
		if (conf.getName()== null || conf.getName().equals(""))
		{
			
			return MarkerManager.getInstance().addProblem(ctx, ElementRefParser.getName(conf), "Configuration doesn't have a name");
		}
		return ctx.createSuccessStatus();
	}
}
