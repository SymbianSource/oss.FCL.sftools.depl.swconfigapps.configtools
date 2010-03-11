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

import cenrep.Key;
import cenrep.KeyRange;
import constraints.ElementRefParser;

public class GValueConstraint extends AbstractModelConstraint
{

	public GValueConstraint()
	{
	}

	@Override
	public IStatus validate(IValidationContext ctx)
	{
		
		Key key = (Key) ctx.getTarget();
		Object gValue = key.getGvalue();
		if (gValue != null)
		{
			//System.out.println(gValue.toString());
			return ctx.createSuccessStatus();
		}
		else if (!key.getBits().isEmpty() || key.eContainer() instanceof KeyRange)
		{	//skip gvalue validation if key of range or bitmask
			/*for(Bit bit : key.getBits())
			{
				if(bit.getGvalue()==null)
					return MarkerManager.getInstance().addProblem(ctx, ElementRefParser.getName(key), ElementRefParser.getName(key));
			}*/
		}			
		else
		{
			
			return MarkerManager.getInstance().addProblem(ctx, ElementRefParser.getName(key), ElementRefParser.getName(key));
		}
			
			
		return ctx.createSuccessStatus();
	}

}
