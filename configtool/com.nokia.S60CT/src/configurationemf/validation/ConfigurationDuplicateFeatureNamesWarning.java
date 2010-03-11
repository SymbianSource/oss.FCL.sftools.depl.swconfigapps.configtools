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
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;

import variantdata.util.ElementRefParser;
import configurationemf.Configuration;
import configurationemf.Feature;

public class ConfigurationDuplicateFeatureNamesWarning extends
		AbstractModelConstraint
{

	String quickFixID = "configuration.duplicate.feature.name";
	
	public ConfigurationDuplicateFeatureNamesWarning()
	{
	}

	@Override
	public IStatus validate(IValidationContext ctx) {
		
		Configuration conf = (Configuration)ctx.getTarget();
		
		IStatus status = null;
		
		EList<Feature> list = conf.getFeature();
		
		for (int i = 0 ; i < list.size() ; i++)
		{
			Feature feat1 = list.get(i);
			
			if (i < list.size()-1)
			{
				for (int j = i+1 ; j < list.size() ; j++)
				{
					Feature feat2 = list.get(j);
					
					if (feat1.getName() != null && feat2.getName() != null && feat1.getName().equalsIgnoreCase(feat2.getName()))
					{
						String qfID = quickFixID; 
						if (conf.isReadOnly())
							qfID = null; //variant engineer should not use quick fix
						return MarkerManager.getInstance().addProblem(ctx, ElementRefParser.getName(conf), "Configuration "+ElementRefParser.getName(conf)+" has two features with same name ("+feat1.getName()+").", null, qfID, feat1.getName());
					}
				}
			}
		}
		return ctx.createSuccessStatus();
	}
}
