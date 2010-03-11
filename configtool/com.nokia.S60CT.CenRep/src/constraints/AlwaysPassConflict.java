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
import cenrep.ACCESS_TYPE;
import cenrep.Access;


public class AlwaysPassConflict extends AbstractModelConstraint {
	private static final String ALWAYS_PASS = "alwayspass";
	private static final String URL_POSTFIX = "#.7B.25element_ref.25.7D_has_other_read_capabilities_defined_with_AlwaysPass";
	public AlwaysPassConflict() {
	}

	@Override
	public IStatus validate(IValidationContext ctx) {
		Access access = (Access)ctx.getTarget();
		if(access.getType()==ACCESS_TYPE.READ){
			String capa = access.getCapabilities();
			if(capa!=null){
				capa=capa.trim().toLowerCase();
				if(capa.indexOf(ALWAYS_PASS)!=-1){
					capa = capa.replaceAll(ALWAYS_PASS, "");
					capa = capa.replaceAll(",", "");
					if(capa.matches("\\p{Alpha}++"))
						return MarkerManager.getInstance().addProblem(ctx, ElementRefParser.getName(access),ElementRefParser.getName(access),
								URL_POSTFIX);
				}
			}
			
		}
		return ctx.createSuccessStatus();
	}

}
