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

import com.nokia.tools.vct.confml.model.confml1.ESettingElement;

public class MissingSettingName extends GlobalConstraint {

	public MissingSettingName() {
		super();
	}

	@Override
	public IStatus validate(IValidationContext ctx) {

		IStatus globalStatus = super.validate(ctx);
		if (globalStatus!=null)
			return globalStatus;
		
		String absRef;
		String name;

		if (ctx.getTarget() instanceof ESettingElement) {
			ESettingElement settingElement = (ESettingElement) ctx.getTarget();
			if (!ConfMLUtils.isFeatureElementChild(settingElement)) {
				return ctx.createSuccessStatus();
			}
			name = settingElement.getName();
			absRef = ConfMLUtils.getAbsoluteRef(settingElement);
		} else if (ctx.getTarget() instanceof com.nokia.tools.vct.confml.model.confml2.ESettingElement) {
			com.nokia.tools.vct.confml.model.confml2.ESettingElement settingElement = (com.nokia.tools.vct.confml.model.confml2.ESettingElement) ctx
					.getTarget();
			if (!ConfMLUtils.isFeatureElementChild(settingElement)) {
				return ctx.createSuccessStatus();
			}
			name = settingElement.getName();
			absRef = ConfMLUtils.getAbsoluteRef(settingElement);
		} else {
			throw new IllegalArgumentException();
		}

		if (name == null || name.trim().length() == 0) {
			return ctx.createFailureStatus(absRef);
		}

		return ctx.createSuccessStatus();
	}

}
