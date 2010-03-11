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
package constraints.keyRange;

import helpers.MarkerManager;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;

import constraints.ElementRefParser;

import cenrep.KeyRange;


public class IndexBits extends AbstractModelConstraint {

	public IndexBits() {
	}

	@Override
	public IStatus validate(IValidationContext ctx) {
		KeyRange keyRange = (KeyRange) ctx.getTarget();
		String indexBits = keyRange.getIndexBits();
		String keyRangeName = ElementRefParser.getName(keyRange);
		if(indexBits!=null&&!indexBits.trim().isEmpty()){
			if(!indexBits.toLowerCase().matches("0x0{0,7}?f{1,7}?0{0,7}?")||indexBits.length()>10)
				return MarkerManager.getInstance().addProblem(ctx, keyRangeName,"Range "+keyRangeName+" indexBits("+indexBits+") attribute is invalid");
		}else if(!keyRange.getKeys().isEmpty()){
			return MarkerManager.getInstance().addProblem(ctx, keyRangeName,"Range "+keyRangeName+" indexBits should be defined.");
		}
		return ctx.createSuccessStatus();
	}

}
