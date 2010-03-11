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


public class IndexBits extends AbstractModelConstraint {

	public IndexBits() {
		super();
	}

	@Override
	public IStatus validate(IValidationContext ctx) {
		EKeyRange keyRange = (EKeyRange) ctx.getTarget();
		String indexBits = keyRange.getIndexBits();
		String keyRangeName = ElementRefParser.getName(keyRange);
		if(indexBits!=null&&indexBits.trim().length() > 0){
			if(!indexBits.toLowerCase().matches("0x0{0,7}?f{1,7}?0{0,7}?")||indexBits.length()>10)
				return ctx.createFailureStatus(keyRangeName, indexBits);
		}else if(!keyRange.getKeys().isEmpty()){
			return ctx.createFailureStatus(keyRangeName, indexBits);
		}
		return ctx.createSuccessStatus();
	}

}
