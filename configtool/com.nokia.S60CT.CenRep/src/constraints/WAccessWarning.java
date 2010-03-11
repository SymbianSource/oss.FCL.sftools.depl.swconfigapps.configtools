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
import cenrep.Key;
import cenrep.KeyRange;



public class WAccessWarning extends AbstractModelConstraint {
	private static final String ALWAYS_PASS = "alwayspass";
	private static final String WRITE_DEVICE_DATA = "writedevicedata";
	private static final String URL_POSTFIX = "#.7B.25element_ref.25.7D_write_capability_is_neither_AlwaysPass_nor_WriteDeviceData";
	
	public WAccessWarning() {
	}

	@Override
	public IStatus validate(IValidationContext ctx) {
		Access access = (Access)ctx.getTarget();
		if(access.getType()==ACCESS_TYPE.WRITE){
			String cap = access.getCapabilities();
			
			EObject container = access.eContainer();
			if (container instanceof Key)
			{
				Key key = (Key)container;
				if (key.isReadOnly())
					return ctx.createSuccessStatus();
			}
			else if (container instanceof KeyRange)
			{
				KeyRange keyRange = (KeyRange)container;
				if (keyRange.isReadOnly())
					return ctx.createSuccessStatus();
			}
			if(cap==null||
			  (cap.toLowerCase().indexOf(ALWAYS_PASS)==-1 &&
			   cap.toLowerCase().indexOf(WRITE_DEVICE_DATA)==-1))
				return MarkerManager.getInstance().addProblem(ctx, ElementRefParser.getName(access),ElementRefParser.getName(access),
						URL_POSTFIX);
		}
		return ctx.createSuccessStatus();
	}

}
