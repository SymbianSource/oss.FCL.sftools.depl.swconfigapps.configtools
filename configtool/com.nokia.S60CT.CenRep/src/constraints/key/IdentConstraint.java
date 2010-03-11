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
package constraints.key;

import helpers.MarkerManager;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;

import constraints.ElementRefParser;


import cenrep.Key;

public class IdentConstraint extends AbstractModelConstraint {

	public IdentConstraint() {
	}

	@Override
	public IStatus validate(IValidationContext ctx) {
		Key key = (Key)ctx.getTarget();
		String uidValue = key.getIdent();
		String keyName = ElementRefParser.getName(key);
		//1. check that uidValue exists
		if(uidValue==null||uidValue.trim().isEmpty()){
			return MarkerManager.getInstance().addProblem(ctx, keyName, "Key "+keyName+" has empty uidValue");
		}
		uidValue=uidValue.trim().toLowerCase();
		//2. check that uidValue in correct format
		if(!uidValue.matches("0x(\\p{XDigit}){1,8}?")){
			return MarkerManager.getInstance().addProblem(ctx, keyName, "Key "+keyName+" has invalid uidValue "+uidValue+".");
		}
		return ctx.createSuccessStatus();
	}

}
