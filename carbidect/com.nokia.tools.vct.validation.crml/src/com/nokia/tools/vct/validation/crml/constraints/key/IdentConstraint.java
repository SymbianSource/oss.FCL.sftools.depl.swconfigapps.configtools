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

package com.nokia.tools.vct.validation.crml.constraints.key;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;

import com.nokia.tools.vct.crml.crmodel.EKey;
import com.nokia.tools.vct.validation.crml.constraints.ElementRefParser;

public class IdentConstraint extends AbstractModelConstraint {

	public IdentConstraint() {
		super();
	}

	@Override
	public IStatus validate(IValidationContext ctx) {
		EKey key = (EKey)ctx.getTarget();
		String uidValue = key.getIdent();
		String keyName = ElementRefParser.getName(key);
		//1. check that uidValue exists
		if(uidValue==null||uidValue.trim().length() == 0 ){
			return ctx.createFailureStatus(keyName, uidValue);
		}
		uidValue=uidValue.trim().toLowerCase();
		//2. check that uidValue in correct format
		if(!uidValue.matches("0x(\\p{XDigit}){1,8}?")){
			return ctx.createFailureStatus(keyName, uidValue);
		}
		return ctx.createSuccessStatus();
	}

}
