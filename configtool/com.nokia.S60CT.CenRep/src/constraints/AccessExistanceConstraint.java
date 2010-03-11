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

import cenrep.Access;
import cenrep.IAccessable;
import cenrep.Key;
import cenrep.Repository;

public class AccessExistanceConstraint extends AbstractModelConstraint {

	private final static String URL_POSTFIX ="#.7B.25element_ref.25.7D_does_not_have_any_read_capabilities";
	
	public AccessExistanceConstraint() {
	}

	public IStatus validate(IValidationContext ctx) {
		IAccessable accessable = (IAccessable)ctx.getTarget();
		Access rac = accessable.getReadAccess(); 
		if (rac==null || ((rac.getSid()==null || rac.getSid().trim().isEmpty()) &&  (rac.getCapabilities()==null || rac.getCapabilities().trim().isEmpty()))){
			
			if (accessable instanceof Key)
			{
				Key key = (Key)accessable;
				if (!checkRepositoryAccess(((Repository)key.eContainer()).getReadAccess()))
					return MarkerManager.getInstance().addProblem(ctx, ElementRefParser.getName(accessable),ElementRefParser.getName(accessable),URL_POSTFIX);
			}
			else if (accessable instanceof Repository)
				return MarkerManager.getInstance().addProblem(ctx, ElementRefParser.getName(accessable),ElementRefParser.getName(accessable),URL_POSTFIX);
			
		}
		return ctx.createSuccessStatus();
	}
	
	private boolean checkRepositoryAccess(Access rac)
	{
			if (rac==null || ((rac.getSid()==null || rac.getSid().trim().isEmpty()) &&  (rac.getCapabilities()==null || rac.getCapabilities().trim().isEmpty())))
				return false;

			return true;
	}
	
}
