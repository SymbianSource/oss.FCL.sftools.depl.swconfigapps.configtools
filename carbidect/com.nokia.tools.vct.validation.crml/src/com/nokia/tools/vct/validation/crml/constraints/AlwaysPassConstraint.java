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

public class AlwaysPassConstraint extends AbstractModelConstraint {
	private static final String ALWAYS_PASS = "alwayspass";
	private static final String URL = "http://127.0.0.1:1295/help/index.jsp?topic=/com.nokia.tools.variant.validation.help/html/validation.html" +
			"#.7B.25element_ref.25.7D_read_capability_differs_from_AlwaysPass";
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.emf.validation.AbstractModelConstraint#validate(org.eclipse.emf.validation.IValidationContext)
	 * For Access.type==READ: AlwaysPass capa exists <=> there are not other R-capas
	 */
	public IStatus validate(IValidationContext ctx) {
		EAccess access = (EAccess) ctx.getTarget();
		if (access.getType() == EAccessType.READ) {
			String capa = access.getCapabilities();
			if (capa != null){
				if (capa.trim().toLowerCase().indexOf(ALWAYS_PASS) == -1) {
					return ctx.createFailureStatus(ElementRefParser.getName(access), URL);
				}
			}
		}
		return ctx.createSuccessStatus();
	}
}
