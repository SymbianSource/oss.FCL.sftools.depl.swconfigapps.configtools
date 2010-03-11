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
import configurationemf.Feature;


public class FeatureRefConstraint extends AbstractModelConstraint
{

	public FeatureRefConstraint(){}

	@Override
	public IStatus validate(IValidationContext ctx) {
		
		Feature feature = (Feature)ctx.getTarget();
		
		String ref = feature.getRef();
		
		if(ref==null||ref.trim().isEmpty()){
			return MarkerManager.getInstance().addProblem(ctx, ElementRefParser.getName(feature), "Feature "+ElementRefParser.getName(feature)+" has empty reference.");
		}else if(Character.isDigit(ref.charAt(0))){
			return MarkerManager.getInstance().addProblem(ctx, ElementRefParser.getName(feature), "Feature "+ElementRefParser.getName(feature)+" reference "+ref+" cannot start with digit.");
		}
		else
		{
			for (int i = 0 ; i < ref.length() ; i++)
			{
				char c = ref.charAt(i);
				if (!(Character.isLetterOrDigit(c) || c =='_' || c =='-')) //is this all valid characters
				{
					if (c ==' ')
						return MarkerManager.getInstance().addProblem(ctx, ElementRefParser.getName(feature), "Feature "+ElementRefParser.getName(feature)+" reference "+feature.getRef()+" contains space.");
					else
						return MarkerManager.getInstance().addProblem(ctx, ElementRefParser.getName(feature), "Feature "+ElementRefParser.getName(feature)+" reference "+feature.getRef()+" contains invalid character \""+c+"\".");
				}
			}
		}
		return ctx.createSuccessStatus();
	}
}
