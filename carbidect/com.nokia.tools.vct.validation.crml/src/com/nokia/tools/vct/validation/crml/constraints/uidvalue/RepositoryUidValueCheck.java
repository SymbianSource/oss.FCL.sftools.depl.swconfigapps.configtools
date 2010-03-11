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

package com.nokia.tools.vct.validation.crml.constraints.uidvalue;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;

import com.nokia.tools.vct.crml.crmodel.ERepository;
import com.nokia.tools.vct.validation.crml.constraints.ElementRefParser;

public class RepositoryUidValueCheck extends AbstractModelConstraint {

	public RepositoryUidValueCheck() {
		super();
	}

	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject obj = ctx.getTarget();
		IStatus status = ctx.createSuccessStatus();
		if(obj instanceof ERepository){
			status = validateRepository(ctx);
		}
		return status;
	}

	public IStatus validateRepository(IValidationContext ctx){
		ERepository rep = (ERepository)ctx.getTarget();
		String uidValue = rep.getUidValue();
		
		String repName = ElementRefParser.getName(rep);
		//1. check that uidValue exists
		if(uidValue==null||uidValue.trim().length() == 0){
			return ctx.createFailureStatus(repName, uidValue);
		}
		//2. check that uidValue in correct format
		uidValue=uidValue.trim().toLowerCase();
		if(!uidValue.matches("0x(\\p{XDigit}){8}?")){
			return ctx.createFailureStatus(repName, uidValue);
		}
		return ctx.createSuccessStatus();
	}
	
}
