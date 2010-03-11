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

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;

import com.nokia.tools.vct.confml.model.confml1.ESettingElement;

public class InvalidSettingType extends GlobalConstraint {

	static final Set<String> VALID_TYPES;
	static {
		HashSet<String> tmp = new HashSet<String>();
		tmp.add("string");
		tmp.add("int");
		tmp.add("real");
		tmp.add("boolean");
		tmp.add("file");
		tmp.add("folder");
		tmp.add("sequence");
		tmp.add("selection");
		tmp.add("multiSelection");
		tmp.add("date");
		tmp.add("time");
		tmp.add("dateTime");
		tmp.add("duration");
		

		VALID_TYPES = Collections.unmodifiableSet(tmp);
	}

	public InvalidSettingType() {
		super();
	}

	@Override
	public IStatus validate(IValidationContext ctx) {
		
		IStatus globalStatus = super.validate(ctx);
		if (globalStatus!=null)
			return globalStatus;
		
		if (ctx.getTarget() instanceof ESettingElement) {

			ESettingElement settingElement = (ESettingElement) ctx.getTarget();

			if (!ConfMLUtils.isFeatureElementChild(settingElement)) {
				return ctx.createSuccessStatus();
			}

			String type = settingElement.getType();
			if (!VALID_TYPES.contains(type) && type != null) {
				return ctx.createFailureStatus(ConfMLUtils
						.getAbsoluteRef(settingElement), settingElement
						.getName(), type);
			}
		} else if (ctx.getTarget() instanceof com.nokia.tools.vct.confml.model.confml2.ESettingElement) {
			com.nokia.tools.vct.confml.model.confml2.ESettingElement settingElement = (com.nokia.tools.vct.confml.model.confml2.ESettingElement) ctx
					.getTarget();

			if (!ConfMLUtils.isFeatureElementChild(settingElement)) {
				return ctx.createSuccessStatus();
			}

			String type = settingElement.getType();
			if (!VALID_TYPES.contains(type) && type != null) {
				return ctx.createFailureStatus(ConfMLUtils
						.getAbsoluteRef(settingElement), settingElement
						.getName(), type);
			}

		} else {
			throw new IllegalArgumentException();
		}

		return ctx.createSuccessStatus();
	}

}
