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
import configurationemf.Configuration;
import configurationemf.LeafSetting;
import configurationemf.LeafSettingDelegator;
import configurationemf.Setting;

public class SettingDescriptionMissing extends AbstractModelConstraint {

	public SettingDescriptionMissing() {
	}

	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject obj = ctx.getTarget();
		
		if (obj instanceof Setting)
		{
			Setting setting = (Setting)obj;
			Configuration conf = setting.getDefaultConf();
			if (conf != null && conf.isReadOnly())
				return ctx.createSuccessStatus();
			if (!setting.isReadOnly() && (setting.getDesc()==null || setting.getDesc().equals("")))
				return MarkerManager.getInstance().addProblem(ctx, ElementRefParser.getName(setting), "Setting "+ElementRefParser.getName(setting)+" has no description.");
		
				
		}
		else if (obj instanceof LeafSettingDelegator)
		{
			LeafSettingDelegator lsd = (LeafSettingDelegator)obj;
			Configuration conf = lsd.getLeafSetting().getDefaultConf();
			LeafSetting ls = lsd.getLeafSetting();
			if (conf != null && conf.isReadOnly())
				return ctx.createSuccessStatus();
			if (!ls.isReadOnly() && (ls.getDesc()==null || ls.getDesc().equals("")))
				return MarkerManager.getInstance().addProblem(ctx, ElementRefParser.getName(ls), "Setting "+ElementRefParser.getName(ls)+" has no description.");
		
		}
		return ctx.createSuccessStatus();
	}

}
