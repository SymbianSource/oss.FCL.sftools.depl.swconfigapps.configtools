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


import cenrep.IReadOnly;
import cenrep.RVG;

public class ReadOnlyRFS extends AbstractModelConstraint {

	private static final String URL_POSTFIX = "#Read-only_.7B.25element_ref.25.7D_is_marked_for_RFS";
	
	public ReadOnlyRFS() {
	}

	// Restore Factory Settings must not be enabled for read-only element, 
	//	and will be ignored during initialization file generation
	public IStatus validate(IValidationContext ctx) {
		EObject obj = ctx.getTarget();
		if(IReadOnly.class.isInstance(obj)&&RVG.class.isInstance(obj)){
			if(((IReadOnly)obj).isReadOnly()&&((RVG)obj).isRfs()){
				return MarkerManager.getInstance().addProblem(ctx, ElementRefParser.getName(obj),ElementRefParser.getName(obj),
						URL_POSTFIX);
			}
		}
		return ctx.createSuccessStatus();
	}

}
