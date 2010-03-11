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



public class CapaAmount extends AbstractModelConstraint {

	private static final String URL_POSTFIX = "#.7B.25element_ref.25.7D_exceeds_capability_amount_limitations";
	
	public CapaAmount() {
	}

	/*
	 * allowed: max 7 capas for non-SID access, 3 for SID access
	 */
	public IStatus validate(IValidationContext ctx) {
		Access access = (Access)ctx.getTarget();
		String sid = access.getSid();
		String[] caps = new String[0];
		if(access.getCapabilities()!=null)caps = access.getCapabilities().split(",");
		
		if(sid==null||sid.trim().isEmpty()){ //non-SID case
			if(caps.length>7)
				return MarkerManager.getInstance().addProblem(ctx, ElementRefParser.getName(access),ElementRefParser.getName(access));
		}else{//SID case
			if(caps.length>3)
				return MarkerManager.getInstance().addProblem(ctx, ElementRefParser.getName(access),ElementRefParser.getName(access),
						URL_POSTFIX);
		}
		return ctx.createSuccessStatus();
	}

}
