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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;

import com.nokia.tools.vct.crml.crmodel.EAccess;
import com.nokia.tools.vct.crml.crmodel.EAccessContainer;
import com.nokia.tools.vct.crml.crmodel.EAccessType;
import com.nokia.tools.vct.crml.crmodel.EReadOnly;

public class ReadOnlyRuleConstraint extends AbstractModelConstraint {

	private static final String URL = "http://127.0.0.1:1295/help/index.jsp?topic=/com.nokia.tools.variant.validation.help/html/validation.html" +
			"#.7B.25element_ref.25.7D_is_read-only.2C_but_also_write_capabilities_are_set";

	public ReadOnlyRuleConstraint() {
		super();
	}

	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject target = ctx.getTarget();
		if (EReadOnly.class.isInstance(target)
				&& ((EReadOnly) target).isReadOnly()) {
			if (EAccessContainer.class.isInstance(target)) {
				EAccess wAccess = null;
				for (EAccess tmp: ((EAccessContainer)target).getAccess()) {
					if (tmp.getType() == EAccessType.WRITE) {
						wAccess = tmp;
						break;
					}
				}
				
				if (wAccess != null && wAccess.getCapabilities() != null
						&& wAccess.getCapabilities().trim().length() > 0) {
					return ctx.createFailureStatus(ElementRefParser
							.getName(target), URL);
				}
			}

		}
		return ctx.createSuccessStatus();
	}

}
