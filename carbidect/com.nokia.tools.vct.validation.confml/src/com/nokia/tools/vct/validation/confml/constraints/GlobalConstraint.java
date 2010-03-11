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

package com.nokia.tools.vct.validation.confml.constraints;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;

import com.nokia.tools.vct.confml.model.confml1.EGroup;

public class GlobalConstraint extends AbstractModelConstraint{

	public IStatus validate(IValidationContext ctx) {
		
		if  (ctx.getTarget().eContainer() instanceof EGroup ||
			ctx.getTarget().eContainer() instanceof	com.nokia.tools.vct.confml.model.confml2.EGroup)
		{
			return ctx.createSuccessStatus();
		}
		
		return null;
	}
	
}
