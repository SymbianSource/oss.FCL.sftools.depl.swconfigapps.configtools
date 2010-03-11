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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;


import cenrep.Access;
import cenrep.IAccessable;
import cenrep.IReadOnly;
import cenrep.Key;
import cenrep.Repository;

public class WriteCapaExistanceConstraint extends AbstractModelConstraint {

	private static final String URL_POSTFIX = "#Writable_.7B.25element_ref.25.7D_does_not_have_any_write_capabilities";
	
	public WriteCapaExistanceConstraint() {
	}

	private boolean checkRepositoryAccess(Access wac)
	{
			if (wac==null || ((wac.getSid()==null || wac.getSid().trim().isEmpty()) &&  (wac.getCapabilities()==null || wac.getCapabilities().trim().isEmpty())))
				return false;

			return true;
	}
	
	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject target = ctx.getTarget();
		if(IReadOnly.class.isInstance(target)&&!((IReadOnly)target).isReadOnly()){
			if(IAccessable.class.isInstance(target)){
				Access wAccess = ((IAccessable)target).getWriteAccess();
				if (wAccess==null || ((wAccess.getSid()==null || wAccess.getSid().trim().isEmpty()) &&  (wAccess.getCapabilities()==null || wAccess.getCapabilities().trim().isEmpty())))
				{
					if (target instanceof Key)
					{
						Key key = (Key)target;
						if (!checkRepositoryAccess(((Repository)key.eContainer()).getWriteAccess()))
							return MarkerManager.getInstance().addProblem(ctx, ElementRefParser.getName(target),ElementRefParser.getName(target),URL_POSTFIX);
					}
					else if (target instanceof Repository)
						return MarkerManager.getInstance().addProblem(ctx, ElementRefParser.getName(target),ElementRefParser.getName(target),URL_POSTFIX);
				}		
			}
		}
		return ctx.createSuccessStatus();
		
	}

}
