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

package com.nokia.tools.vct.validation.confml.constraints;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;

import com.nokia.tools.vct.confml.model.confml1.EFeatureElement;

public class MissingFeatureRef extends AbstractModelConstraint {

	public MissingFeatureRef() {
		super();
	}

	@Override
	public IStatus validate(IValidationContext ctx) {
		String name;
		String ref;
		if (ctx.getTarget() instanceof EFeatureElement) {
			EFeatureElement featureElement = (EFeatureElement) ctx.getTarget();
			ref = featureElement.getRef();
			name = featureElement.getName();
		} else if (ctx.getTarget() instanceof com.nokia.tools.vct.confml.model.confml2.EFeatureElement) {
			com.nokia.tools.vct.confml.model.confml2.EFeatureElement featureElement = (com.nokia.tools.vct.confml.model.confml2.EFeatureElement) ctx
					.getTarget();
			ref = featureElement.getRef();
			name = featureElement.getName();
		} else {
			throw new IllegalArgumentException();
		}

		if (ref == null || ref.trim().length() == 0) {
			return ctx.createFailureStatus(name);
		}

		return ctx.createSuccessStatus();
	}

}
