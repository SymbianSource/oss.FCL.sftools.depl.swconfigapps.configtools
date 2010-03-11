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

import com.nokia.tools.vct.crml.crmodel.EAccess;


public class CapaAmount extends AbstractModelConstraint {

	private static final String URL = "http://127.0.0.1:1295/help/index.jsp?topic=/com.nokia.tools.variant.validation.help/html/validation.html" +
			"#.7B.25element_ref.25.7D_exceeds_capability_amount_limitations";
	
	public CapaAmount() {
		super();
	}

	/*
	 * allowed: max 7 capas for non-SID access, 3 for SID access
	 */
	public IStatus validate(IValidationContext ctx) {
		EAccess access = (EAccess)ctx.getTarget();
		String sid = access.getSid();
		String[] caps = new String[0];
		if(access.getCapabilities()!=null)caps = access.getCapabilities().split(",");
		
		if(sid==null||sid.trim().length() == 0){ //non-SID case
			if(caps.length>7)
				return ctx.createFailureStatus(ElementRefParser.getName(access), URL);
		}else{//SID case
			if(caps.length>3)
				return ctx.createFailureStatus(ElementRefParser.getName(access), URL);
		}
		return ctx.createSuccessStatus();
	}

}
