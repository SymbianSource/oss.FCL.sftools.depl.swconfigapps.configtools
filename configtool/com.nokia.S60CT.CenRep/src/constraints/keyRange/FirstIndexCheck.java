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

public class FirstIndexCheck extends AbstractModelConstraint {

	public FirstIndexCheck() {
	}

	@Override
	public IStatus validate(IValidationContext ctx) {
		KeyRange range = (KeyRange)ctx.getTarget();
		String firstIndex = range.getFirstIndex();
		String keyRangeName = ElementRefParser.getName(range);
		if(firstIndex!=null&&!firstIndex.trim().isEmpty()){
			firstIndex=firstIndex.trim();
			//1. hex format
			if(!firstIndex.matches("(\\p{XDigit})+")){
				return MarkerManager.getInstance().addProblem(ctx, keyRangeName, "Range "+keyRangeName+" has invalid value in firstIndex("+firstIndex+").");
			}
			//2. check with index bit
			String indexBits=range.getIndexBits();
			if(indexBits!=null&&!indexBits.trim().isEmpty()){
				indexBits=indexBits.toLowerCase();
				int first = indexBits.indexOf("f");
				int last = indexBits.lastIndexOf("f");
				int numberF = last>-1&&first>-1?last-first+1:0;
				if(numberF>0){
					if(firstIndex.length()>numberF){
						return MarkerManager.getInstance().addProblem(ctx, keyRangeName, "Range "+keyRangeName+" has firstIndex("+firstIndex+") that does not fit into indexBits("+indexBits+").");
					}
				}
			}
		}else if(!range.getKeys().isEmpty()){
			return MarkerManager.getInstance().addProblem(ctx, keyRangeName, "Range "+keyRangeName+" firstIndex should be defined.");
		}
		return ctx.createSuccessStatus();
	}

}
