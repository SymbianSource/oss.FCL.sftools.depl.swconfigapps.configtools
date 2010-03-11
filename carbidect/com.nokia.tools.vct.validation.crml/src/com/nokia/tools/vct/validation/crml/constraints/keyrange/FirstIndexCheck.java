/*
 * Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies).
 * All rights reserved.
 * This component and the accompanying materials are made available
 * under the terms of "Eclipse Public License v1.0"
 * which accompanies this distribution, and is available
 * at the URL "http://www.eclipse.org/legal/epl-v10.html".
 * 
 * Initial Contributors:
 * Nokia Corporation - Initial contribution
 * 
 * Contributors:
 * 
 * Description: This file is part of com.nokia.tools.vct.validation.crml component.
 */

package com.nokia.tools.vct.validation.crml.constraints.keyrange;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;

import com.nokia.tools.vct.crml.crmodel.EKeyRange;
import com.nokia.tools.vct.validation.crml.constraints.ElementRefParser;

public class FirstIndexCheck extends AbstractModelConstraint {

	public FirstIndexCheck() {
		super();
	}

	@Override
	public IStatus validate(IValidationContext ctx) {
		EKeyRange range = (EKeyRange)ctx.getTarget();
		String firstIndex = range.getFirstIndex();
		String indexBits=range.getIndexBits();
		String keyRangeName = ElementRefParser.getName(range);
		if(firstIndex!=null&&firstIndex.trim().length() > 0){
			firstIndex=firstIndex.trim();

			//1. hex format
			if(!firstIndex.matches("(\\p{XDigit})+")){
				return ctx.createFailureStatus(keyRangeName, firstIndex, indexBits);
			}
			//2. check with index bit
			if(indexBits!=null&&indexBits.trim().length() > 0){
				indexBits=indexBits.toLowerCase();
				int first = indexBits.indexOf("f");
				int last = indexBits.lastIndexOf("f");
				int numberF = last>-1&&first>-1?last-first+1:0;
				if(numberF>0){
					if(firstIndex.length()>numberF){
						return ctx.createFailureStatus(keyRangeName, firstIndex, indexBits);
					}
				}
			}
		}else if(!range.getKeys().isEmpty()){
			return ctx.createFailureStatus(keyRangeName, firstIndex, indexBits);
		}
		return ctx.createSuccessStatus();
	}

}
