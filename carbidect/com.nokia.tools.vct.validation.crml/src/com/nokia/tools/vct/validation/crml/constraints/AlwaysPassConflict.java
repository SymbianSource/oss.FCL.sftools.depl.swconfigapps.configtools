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
import com.nokia.tools.vct.crml.crmodel.EAccessType;

public class AlwaysPassConflict extends AbstractModelConstraint {
	private static final String ALWAYS_PASS = "alwayspass";
	private static final String URL = "http://127.0.0.1:1295/help/index.jsp?topic=/com.nokia.tools.variant.validation.help/html/validation.html" +
			"#.7B.25element_ref.25.7D_has_other_read_capabilities_defined_with_AlwaysPass";
	public AlwaysPassConflict() {
		super();
	}

	@Override
	public IStatus validate(IValidationContext ctx) {
		EAccess access = (EAccess)ctx.getTarget();
		if(access.getType()==EAccessType.READ){
			String capa = access.getCapabilities();
			if(capa!=null){
				capa=capa.trim().toLowerCase();
				if(capa.indexOf(ALWAYS_PASS)!=-1){
					capa = capa.replaceAll(ALWAYS_PASS, "");
					capa = capa.replaceAll(",", "");
					if(capa.matches("\\p{Alpha}++"))
						return ctx.createFailureStatus(ElementRefParser.getName(access), URL);
				}
			}
			
		}
		return ctx.createSuccessStatus();
	}

}
