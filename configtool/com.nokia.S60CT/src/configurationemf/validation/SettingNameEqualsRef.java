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

public class SettingNameEqualsRef extends AbstractModelConstraint {

	public SettingNameEqualsRef() {
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
			String name = setting.getName();
			String ref = setting.getRef();
			if (!setting.isReadOnly()&& name!=null && ref!=null && name.equalsIgnoreCase(ref))
				return MarkerManager.getInstance().addProblem(ctx, ElementRefParser.getName(setting), "Setting "+ElementRefParser.getName(setting)+" has matching ref and name.");
			
		}
		else if (obj instanceof LeafSettingDelegator)
		{
			LeafSettingDelegator lsd = (LeafSettingDelegator)obj;
			Configuration conf = lsd.getLeafSetting().getDefaultConf();
			if (conf != null && conf.isReadOnly())
				return ctx.createSuccessStatus();
			String name = lsd.getLeafSetting().getName();
			String ref = lsd.getLeafSetting().getRef();
			LeafSetting ls = lsd.getLeafSetting();
			if (!ls.isReadOnly() && name!=null && ref!=null && name.equalsIgnoreCase(ref))
				return MarkerManager.getInstance().addProblem(ctx, ElementRefParser.getName(ls), "Setting "+ElementRefParser.getName(ls)+" has matching ref and name.");
		}
		return ctx.createSuccessStatus();
	}

}
