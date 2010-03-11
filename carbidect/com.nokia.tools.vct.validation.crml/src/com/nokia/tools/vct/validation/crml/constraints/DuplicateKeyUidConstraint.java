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

package com.nokia.tools.vct.validation.crml.constraints;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;

import com.nokia.tools.vct.crml.crmodel.EKey;
import com.nokia.tools.vct.crml.crmodel.EKeyRange;
import com.nokia.tools.vct.crml.crmodel.ERepository;

public class DuplicateKeyUidConstraint extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {
		ERepository rep = (ERepository) ctx.getTarget();
		
		for(EKey simpleKey1 : rep.getKey()){
			for(EKey simpleKey2 : rep.getKey()){ //comparing simple keys
				if (simpleKey1 != simpleKey2){//skipping comparing with it self
					if (simpleKey1.getIdent().equals(simpleKey2.getIdent()) ){
						return ctx.createFailureStatus(simpleKey1.getIdent());
					}
				}
			}
		}
		
		for(EKeyRange keyRange : rep.getRangeKey()){
			for(EKey simpleKey1 : rep.getKey()){
				for(EKey simpleKey2 : rep.getKey()){ //comparing simple keys
					if (simpleKey1 != simpleKey2){//skipping comparing with it self
						if (simpleKey1.getIdent().equals(simpleKey2.getIdent()) ){
							return ctx.createFailureStatus(simpleKey1.getIdent());
						}
					}
				}
			}
		}
		
		return ctx.createSuccessStatus();
	}

	
}
