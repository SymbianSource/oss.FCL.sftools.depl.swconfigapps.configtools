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
package constraints.uidValue;

import helpers.MarkerManager;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;

import cenrep.Bit;
import cenrep.Key;
import cenrep.Repository;
import constraints.ElementRefParser;

public class UidValueCheck extends AbstractModelConstraint {

	public UidValueCheck() {
	}

	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject obj = ctx.getTarget();
		IStatus status = ctx.createSuccessStatus();
		if(obj instanceof Repository){
			status = validateRepository(ctx);
		}
		return status;
	}

	public IStatus validateRepository(IValidationContext ctx){
		Repository rep = (Repository)ctx.getTarget();
		String uidValue = rep.getUidValue();
		
		String repName = ElementRefParser.getName(rep);
		//1. check that uidValue exists
		if(uidValue==null||uidValue.trim().isEmpty()){
			return MarkerManager.getInstance().addProblem(ctx, repName,"Repository "+repName+" has empty uidValue." );
		}
		//2. check that uidValue in correct format
		uidValue=uidValue.trim().toLowerCase();
		if(!uidValue.matches("0x(\\p{XDigit}){8}?")){
			return MarkerManager.getInstance().addProblem(ctx, repName,"Repository "+repName+" has invalid uidValue "+uidValue+".");
		}
		
		//3. check that there are no duplicate UIDs in simple keys and bit keys
		for(Key simpleKey1 : (EList<Key>)rep.getSimpleKeys()){
			
			for(Key simpleKey2 : (EList<Key>)rep.getSimpleKeys()){ //comparing simple keys
				if (simpleKey1 != simpleKey2){//skipping comparing with it self
					if (simpleKey1.getIdent().equals(simpleKey2.getIdent()) ){
						return MarkerManager.getInstance().addProblem(ctx, repName, "Key " + simpleKey1.getName() + " has not unique Uid " + simpleKey1.getIdent());
					}
				}
			}
			
			for (Key bitkey : (EList<Key>)rep.getBitmaskKeys()) { //comparing simple and bit keys
				if (simpleKey1.getIdent().equals(bitkey.getIdent()) ){
					return MarkerManager.getInstance().addProblem(ctx, repName, "Key " + simpleKey1.getName() + " has not unique Uid " + simpleKey1.getIdent());
				}
			}
		}
		
		for(Key bitKey1 : (EList<Key>)rep.getBitmaskKeys()){
			
			for(Key bitKey2 : (EList<Key>)rep.getBitmaskKeys()){ //comparing bit keys
				if (bitKey1 != bitKey2){//skipping comparing with it self
					if (bitKey1.getIdent().equals(bitKey2.getIdent()) ){
						return MarkerManager.getInstance().addProblem(ctx, repName, "Key " + bitKey1.getName() + " has not unique Uid " + bitKey1.getIdent());
					}
				}
			}
		}
		
		return ctx.createSuccessStatus();
	}
}
