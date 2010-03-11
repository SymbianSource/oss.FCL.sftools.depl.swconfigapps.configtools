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
import cenrep.RVG;

public class RFSwCapaConstraint extends AbstractModelConstraint {

	private static final String URL_POSTFIX = "#.7B.25element_ref.25.7D_has_RFS_defined.2C_but_write_capability_is_missing";
	
	public RFSwCapaConstraint() {
	}

	// w Capa should be define if RFS = true
	public IStatus validate(IValidationContext ctx) {
		EObject obj = ctx.getTarget();
		if(IAccessable.class.isInstance(obj)&&RVG.class.isInstance(obj)){
			if(((RVG)obj).isRfs()){
				IAccessable acc = (IAccessable)obj;
				Access wAccess = acc.getWriteAccess();
				if(wAccess==null || 
				  (wAccess.getCapabilities()==null && wAccess.getSid()== null) || 
				  (wAccess.getCapabilities()!=null && wAccess.getCapabilities().trim().isEmpty() && 
				   wAccess.getSid()!= null && wAccess.getSid().trim().isEmpty()))
					return MarkerManager.getInstance().addProblem(ctx, ElementRefParser.getName(obj),ElementRefParser.getName(obj),
							URL_POSTFIX);
			}
		}
		return ctx.createSuccessStatus();
	}

}
