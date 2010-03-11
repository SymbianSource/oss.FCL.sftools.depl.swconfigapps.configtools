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

package variantdata.validation;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;

import configurationemf.Configuration;

import variantdata.VariantData;

public class VariantDataChainBroken extends
				AbstractModelConstraint{

	@Override
	public IStatus validate(IValidationContext ctx) {
		Configuration conf=null;
		VariantData vd=null;
		if(ctx instanceof VariantData)
			conf=(Configuration)ctx;
		if(vd!=null){
			
		}
		
		return ctx.createSuccessStatus();
	}

}
