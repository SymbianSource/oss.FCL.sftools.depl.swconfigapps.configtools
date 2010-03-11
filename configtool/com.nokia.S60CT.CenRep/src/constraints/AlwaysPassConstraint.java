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
import cenrep.ACCESS_TYPE;
import cenrep.Access;
import cenrep.impl.KeyImpl;
import cenrep.impl.RepositoryImpl;


public class AlwaysPassConstraint extends AbstractModelConstraint {
	private static final String ALWAYS_PASS = "alwayspass";
	private static final String URL_POSTFIX = "#.7B.25element_ref.25.7D_read_capability_differs_from_AlwaysPass";
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.emf.validation.AbstractModelConstraint#validate(org.eclipse.emf.validation.IValidationContext)
	 * For Access.type==READ: AlwaysPass capa exists <=> there are not other R-capas
	 */
	public IStatus validate(IValidationContext ctx) {
		Access access = (Access) ctx.getTarget();
		if (access.getType() == ACCESS_TYPE.READ) {
			String capa = access.getCapabilities().trim().toLowerCase();
			if (capa != null){
				if (capa.indexOf(ALWAYS_PASS) == -1) {
					IStatus status = MarkerManager.getInstance().addProblem(ctx, ElementRefParser.getName(access), ElementRefParser.getName(access),
							URL_POSTFIX);
					return status; 
				}
			}
		}
		return ctx.createSuccessStatus();
	}
}
