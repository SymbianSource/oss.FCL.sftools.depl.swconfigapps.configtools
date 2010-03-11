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
package constraints;

import helpers.MarkerManager;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;


import cenrep.Repository;

public class RepositoryBUpOwnerConstraint extends AbstractModelConstraint {

	private static final String URL_POSTFIX = "#Back-up_is_enabled_for_.7B.25element_ref.25.7D.2C_but_repository_misses_owner_definition";
	
	public RepositoryBUpOwnerConstraint() {
	}

	@Override
	public IStatus validate(IValidationContext ctx) {
		Repository rep = (Repository)ctx.getTarget();
		if((rep.getOwner()==null||rep.getOwner().trim().isEmpty())&&rep.isBackup()){
			return MarkerManager.getInstance().addProblem(ctx, ElementRefParser.getName(rep),ElementRefParser.getName(rep),
					URL_POSTFIX);
		}
		return ctx.createSuccessStatus();
	}

}
