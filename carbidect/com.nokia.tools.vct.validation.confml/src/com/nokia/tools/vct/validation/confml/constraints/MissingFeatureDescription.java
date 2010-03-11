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

import com.nokia.tools.vct.common.core.utils.ArrayUtils;
import com.nokia.tools.vct.confml.model.confml1.EDescriptionElement;
import com.nokia.tools.vct.confml.model.confml1.EFeatureElement;

public class MissingFeatureDescription extends AbstractModelConstraint {

	public MissingFeatureDescription() {
		super();
	}

	@Override
	public IStatus validate(IValidationContext ctx)
	{
		if (ctx.getTarget() instanceof EFeatureElement) {
			EFeatureElement featureElement = (EFeatureElement) ctx.getTarget();
			String absRef = featureElement.getRef();
			EDescriptionElement descr = ArrayUtils.getFirst(featureElement
					.getDescriptions());
			if (descr == null || descr.getDescription() == null) {
				return ctx.createFailureStatus(absRef);
			}
			String text = descr.getDescription().trim();
			if (text.length() == 0) {
				return ctx.createFailureStatus(absRef);
			}
		} else if (ctx.getTarget() instanceof com.nokia.tools.vct.confml.model.confml2.EFeatureElement) {
			com.nokia.tools.vct.confml.model.confml2.EFeatureElement featureElement = (com.nokia.tools.vct.confml.model.confml2.EFeatureElement) ctx
					.getTarget();
			String absRef = featureElement.getRef();
			com.nokia.tools.vct.confml.model.confml2.EDescriptionElement descr = ArrayUtils
					.getFirst(featureElement.getDescriptions());
			if (descr == null || descr.getDescription() == null) {
				return ctx.createFailureStatus(absRef);
			}
			String text = descr.getDescription().trim();
			if (text.length() == 0) {
				return ctx.createFailureStatus(absRef);
			}
		} else {
			throw new IllegalArgumentException();
		}

		return ctx.createSuccessStatus();
	}

}
