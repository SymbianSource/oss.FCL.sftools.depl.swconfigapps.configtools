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
import configurationemf.Feature;
import configurationemf.ParentSetting;



public class FeatureSettingRefConstraint extends AbstractModelConstraint {

	public FeatureSettingRefConstraint() {
	}

	@Override
	public IStatus validate(IValidationContext ctx) {
		
		Feature feature = (Feature)ctx.getTarget();
		
		EList<ParentSetting> list = feature.getParentSetting();
		
		for (int i = 0 ; i < list.size() ; i++)
		{
			ParentSetting setting1 = list.get(i);
			
			if (i < list.size()-1)
			{
				for (int j = i+1 ; j < list.size() ; j++)
				{
					ParentSetting setting2 = list.get(j);
					
					if (setting1.getRef().equalsIgnoreCase(setting2.getRef()))
					{
						return MarkerManager.getInstance().addProblem(ctx, ElementRefParser.getName(feature), "Feature "+ElementRefParser.getName(feature)+" has two settings with same ref ("+setting1.getName()+" & "+setting2.getName()+").");
					}
				}
			}
		}

		return ctx.createSuccessStatus();
	}
}
