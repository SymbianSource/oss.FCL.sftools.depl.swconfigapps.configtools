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

public class RefConstraint extends AbstractModelConstraint {

	public RefConstraint() {
		super();
	}

	@Override
	public IStatus validate(IValidationContext ctx) {
		EKey key = (EKey) ctx.getTarget();
		String ref = key.getRef();
		if(key.getBits().isEmpty()){
			if(ref==null||ref.trim().length() == 0){
				return ctx.createFailureStatus(ElementRefParser.getName(key));
			}
		}
		return ctx.createSuccessStatus();
	}
}
