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
package constraints.keyRange;

import helpers.MarkerManager;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;

import constraints.ElementRefParser;

import cenrep.KeyRange;


public class FirstLastUids extends AbstractModelConstraint {

	public FirstLastUids() {
	}

	@Override
	public IStatus validate(IValidationContext ctx) {
		KeyRange range = (KeyRange)ctx.getTarget();
		String fInt = range.getFirstInt();
		String lInt = range.getLastInt();
		String keyRangeName = ElementRefParser.getName(range);
		//1. check that uidValue exists
		if(fInt==null||fInt.trim().isEmpty()){
			if(lInt==null||lInt.trim().isEmpty()){//both not defined
				return MarkerManager.getInstance().addProblem(ctx, keyRangeName, "KeyRange "+keyRangeName+" first and last uidValues are invalid");
			}
			else{//firstInt not defined
				return MarkerManager.getInstance().addProblem(ctx, keyRangeName, "KeyRange "+keyRangeName+" first uidValue is invalid");
			}
		}else if(lInt==null||lInt.trim().isEmpty()){//lastInt not defined
			return MarkerManager.getInstance().addProblem(ctx, keyRangeName,"KeyRange "+keyRangeName+" lastInt is invalid");
		}
		//2. check that uidValue in correct format
		if(!fInt.matches("0x(\\p{XDigit}){1,8}?")){
			if(!lInt.matches("0x(\\p{XDigit}){1,8}?"))
				return MarkerManager.getInstance().addProblem(ctx, keyRangeName,"Range "+keyRangeName+" first uidValue ("+fInt+") and last uidValue ("+lInt+") are invalid.");
			else
				return MarkerManager.getInstance().addProblem(ctx, keyRangeName,"Range "+keyRangeName+" first uidValue ("+fInt+") is invalid.");
		}else if(!lInt.matches("0x(\\p{XDigit}){1,8}?")){
			return MarkerManager.getInstance().addProblem(ctx, keyRangeName,"Range "+keyRangeName+" last uidValue ("+lInt+") is invalid.");
		}
		//3. firstInt< lastInt
		long firstInt = Long.parseLong(range.getFirstInt().substring(2), 16);
		long lastInt = Long.parseLong(range.getLastInt().substring(2), 16);
		if(firstInt>=lastInt)
			return MarkerManager.getInstance().addProblem(ctx, keyRangeName,"Range "+keyRangeName+" first uidValue ("+fInt+") is not smaller than last uidValue("+lInt+").");
		return ctx.createSuccessStatus();
	}

}
