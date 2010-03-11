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

public class MalformedIncludeReference extends AbstractModelConstraint {

	public MalformedIncludeReference() {
		super();
	}

	@Override
	public IStatus validate(IValidationContext ctx) {
		EInclude include = (EInclude) ctx.getTarget();
		try {
			URI href = URI.createURI(include.getHref());
			
			if (!href.isRelative()) {
				return ctx.createFailureStatus(include.getHref());
			}
		} catch (Exception ex) {
			return ctx.createFailureStatus(include.getHref());
		}

		return ctx.createSuccessStatus();
	}

}
