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
package constraints.key;

import helpers.MarkerManager;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;

import constraints.ElementRefParser;


import cenrep.Key;

public class NameConstraint extends AbstractModelConstraint {

	public NameConstraint() {
	}

	/*
	 * name
	 */
	public IStatus validate(IValidationContext ctx) {
		Key key = (Key)ctx.getTarget();
		String name = key.getName();
		if(name==null||name.trim().isEmpty()){
			return MarkerManager.getInstance().addProblem(ctx, ElementRefParser.getName(key), ElementRefParser.getName(key));
		}
		return ctx.createSuccessStatus();
	}

}
