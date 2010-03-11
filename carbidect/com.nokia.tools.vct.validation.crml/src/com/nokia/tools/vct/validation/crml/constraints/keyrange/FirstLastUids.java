/*
 * Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies).
 * All rights reserved.
 * This component and the accompanying materials are made available
 * under the terms of "Eclipse Public License v1.0"
 * which accompanies this distribution, and is available
 * at the URL "http://www.eclipse.org/legal/epl-v10.html".
 * 
 * Initial Contributors:
 * Nokia Corporation - Initial contribution
 * 
 * Contributors:
 * 
 * Description: This file is part of com.nokia.tools.vct.validation.crml component.
 */

package com.nokia.tools.vct.validation.crml.constraints.keyrange;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;

import com.nokia.tools.vct.crml.crmodel.EKeyRange;
import com.nokia.tools.vct.validation.crml.constraints.ElementRefParser;

public class FirstLastUids extends AbstractModelConstraint {

	public FirstLastUids() {
		super();
	}

	@Override
	public IStatus validate(IValidationContext ctx) {
		EKeyRange range = (EKeyRange)ctx.getTarget();
		String fInt = range.getFirstInt();
		String lInt = range.getLastInt();
		String keyRangeName = ElementRefParser.getName(range);
		//1. check that uidValue exists
		if(fInt==null||fInt.trim().length() == 0){
			if(lInt==null||lInt.trim().length() == 0){//both not defined
				return ctx.createFailureStatus(keyRangeName, fInt, lInt);
			}
			else{//firstInt not defined
				return ctx.createFailureStatus(keyRangeName, fInt, lInt);
			}
		}else if(lInt==null||lInt.trim().length() == 0){//lastInt not defined
			return ctx.createFailureStatus(keyRangeName, fInt, lInt);
		}
		//2. check that uidValue in correct format
		if(!fInt.matches("0x(\\p{XDigit}){1,8}?")){
			if(!lInt.matches("0x(\\p{XDigit}){1,8}?"))
				return ctx.createFailureStatus(keyRangeName, fInt, lInt);
			else
				return ctx.createFailureStatus(keyRangeName, fInt, lInt);
		}else if(!lInt.matches("0x(\\p{XDigit}){1,8}?")){
			return ctx.createFailureStatus(keyRangeName, fInt, lInt);
		}
		//3. firstInt< lastInt
		long firstInt = Long.parseLong(range.getFirstInt().substring(2), 16);
		long lastInt = Long.parseLong(range.getLastInt().substring(2), 16);
		if(firstInt>=lastInt)
			return ctx.createFailureStatus(keyRangeName, fInt, lInt);
		return ctx.createSuccessStatus();
	}

}
