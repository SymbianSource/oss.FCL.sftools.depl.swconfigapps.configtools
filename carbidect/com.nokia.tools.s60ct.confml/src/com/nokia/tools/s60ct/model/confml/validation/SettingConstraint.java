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
package com.nokia.tools.s60ct.model.confml.validation;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;

import com.nokia.tools.s60ct.model.confml.ESetting;

public class SettingConstraint extends AbstractModelConstraint {

	public SettingConstraint() {
		// Auto-generated constructor stub
	}

	@Override
	public IStatus validate(IValidationContext ctx) {
		// Auto-generated method stub
		EObject obj = ctx.getTarget();
		
		if (obj instanceof ESetting)
		{
			ESetting setting = (ESetting)obj;
			return ctx.createSuccessStatus();
			
		}
		
		return ctx.createSuccessStatus();
	}

}
