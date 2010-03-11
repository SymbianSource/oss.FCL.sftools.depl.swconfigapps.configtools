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

package com.nokia.tools.vct.validation.crml.constraints;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;

import com.nokia.tools.vct.crml.crmodel.ERepository;

public class RepositoryBUpOwnerConstraint extends AbstractModelConstraint {

	private static final String URL = "http://127.0.0.1:1295/help/index.jsp?topic=/com.nokia.tools.variant.validation.help/html/validation.html" +
			"#Back-up_is_enabled_for_.7B.25element_ref.25.7D.2C_but_repository_misses_owner_definition";
	
	public RepositoryBUpOwnerConstraint() {
	}

	@Override
	public IStatus validate(IValidationContext ctx) {
		ERepository rep = (ERepository)ctx.getTarget();
		if((rep.getOwner()==null||rep.getOwner().trim().length() == 0)&&rep.isBackup()){
			return ctx.createFailureStatus(ElementRefParser.getName(rep), URL);
		}
		return ctx.createSuccessStatus();
	}

}
