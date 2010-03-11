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

public class ReadOnlyRuleConstraint extends AbstractModelConstraint {

	private static final String URL_POSTFIX ="#.7B.25element_ref.25.7D_is_read-only.2C_but_also_write_capabilities_are_set";
	
	
	public ReadOnlyRuleConstraint() {
	}

	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject target = ctx.getTarget();
		if(IReadOnly.class.isInstance(target)&&((IReadOnly)target).isReadOnly()){
			if(IAccessable.class.isInstance(target)){
				Access wAccess = ((IAccessable)target).getWriteAccess();
				if(wAccess!=null&&
						wAccess.getCapabilities()!=null &&
						!wAccess.getCapabilities().trim().isEmpty()){
					return MarkerManager.getInstance().addProblem(ctx, ElementRefParser.getName(target),ElementRefParser.getName(target),
							URL_POSTFIX);
				}
			}
			
		}
		return ctx.createSuccessStatus();
	}

}
