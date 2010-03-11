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
 * Description: This file is part of com.nokia.tools.vct.validation.confml component.
 */

package com.nokia.tools.vct.validation.confml.constraints.meta;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;

import com.nokia.tools.vct.confml.model.confml1.include.EInclude;

public class NoIncludeTarget extends AbstractModelConstraint {

	public NoIncludeTarget() {
		super();
	}

	@Override
	public IStatus validate(IValidationContext ctx) {
		try {
			EInclude include = (EInclude) ctx.getTarget();
			URI base = include.eResource().getURI();
			
			URI href = URI.createURI(include.getHref());
			href = href.resolve(base);
			if (!include.eResource().getResourceSet().getURIConverter().exists(
					href, null)) {
				return ctx.createFailureStatus(include.getHref());
			}
		} catch (Exception ex) {
			// ignore - Malformed URI
			// ex.printStackTrace();
		}

		return ctx.createSuccessStatus();
	}

}
