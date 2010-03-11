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
import configurationemf.Feature;


public class FeatureNameWarning extends AbstractModelConstraint
{

	public FeatureNameWarning()
	{
	}

	@Override
	public IStatus validate(IValidationContext ctx)
	{
		Feature feature = (Feature)ctx.getTarget();
		
		if (feature.getName()== null || feature.getName().equals(""))
		{
			Configuration conf = (Configuration)feature.eContainer();
			return MarkerManager.getInstance().addProblem(ctx, ElementRefParser.getName(conf), "Configuration "+ElementRefParser.getName(conf)+" has a feature without name");
		}
		return ctx.createSuccessStatus();
	}
}
