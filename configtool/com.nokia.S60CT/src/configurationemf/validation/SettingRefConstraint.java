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

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;

import variantdata.util.ElementRefParser;
import configurationemf.ConfigurationemfPackage;
import configurationemf.LeafSettingDelegator;
import configurationemf.Setting;

public class SettingRefConstraint extends AbstractModelConstraint {

	
	public SettingRefConstraint() {
	}
	
	@Override
	public IStatus validate(IValidationContext ctx) {
		
		EObject obj = ctx.getTarget();
		
		if (obj instanceof Setting)
		{
			Setting setting = (Setting)obj;
			return validateSetting(setting, ctx, true);
			
		}
		else if (obj instanceof LeafSettingDelegator)
		{
			LeafSettingDelegator lsd = (LeafSettingDelegator)obj;			
			return validateSetting(lsd.getLeafSetting(),ctx, false);
		}
		

		return ctx.createSuccessStatus();
	}

	private IStatus validateSetting(Setting setting, IValidationContext ctx, boolean checkUnique)
	{
		int structuralFeatureId = ConfigurationemfPackage.REFERABLE__REF;
		String ref = setting.getRef();
		
		if(ref==null||ref.trim().isEmpty()){
			return MarkerManager.getInstance().addProblem(ctx, ElementRefParser.getName(setting), "Setting "+ElementRefParser.getName(setting)+" has empty reference.");
		}
		else if(Character.isDigit(ref.charAt(0))){
			return MarkerManager.getInstance().addProblem(ctx, ElementRefParser.getName(setting), "Setting "+ElementRefParser.getName(setting)+" reference "+ref+" cannot start with digit.");
		}
		else
		{
			for (int i = 0 ; i < ref.length() ; i++)
			{
				char c = ref.charAt(i);
				if (!(Character.isLetterOrDigit(c) || c =='_' || c =='-')) //is this all valid characters
				{
					
					if (c ==' ')
						return MarkerManager.getInstance().addProblem(ctx, ElementRefParser.getName(setting), structuralFeatureId, "Setting "+ElementRefParser.getName(setting)+" reference "+setting.getRef()+" contains space.");
					else
						return MarkerManager.getInstance().addProblem(ctx, ElementRefParser.getName(setting), structuralFeatureId, "Setting "+ElementRefParser.getName(setting)+" reference "+setting.getRef()+" contains invalid character \""+c+"\".");
				}
			}
		}
		if (checkUnique)
		{
			String absRef = setting.getAbsRef();
			Set<String> result = getDuplicateContext(ctx);
			if (absRef!= null && !absRef.equals(""))
			{
				if (result.contains(absRef))
				{
					return MarkerManager.getInstance().addProblem(ctx, ElementRefParser.getName(setting), "Setting "+ElementRefParser.getName(setting)+" doesn't have unique absolute ref ("+absRef+").");
				}
				else
					result.add(absRef);
			}
		}
		return ctx.createSuccessStatus();
	}
	
	private Set<String> getDuplicateContext(IValidationContext ctx) {
		if (ctx.getCurrentConstraintData() instanceof Set) {
			return (Set<String>) ctx.getCurrentConstraintData();
		}

		Set<String> result = new HashSet<String>();
		ctx.putCurrentConstraintData(result);
		
		return result;
	}
	
}
