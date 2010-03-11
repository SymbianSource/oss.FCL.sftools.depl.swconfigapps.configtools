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

public class InvalidSettingRef extends AbstractModelConstraint {

	public InvalidSettingRef() {
		super();
	}

	@Override
	public IStatus validate(IValidationContext ctx) {
		if (ctx.getTarget() instanceof ESettingElement) {
			ESettingElement settingElement = (ESettingElement) ctx.getTarget();

			if (ConfMLUtils.isGroupElementChild(settingElement)) {
				String[] segs = settingElement.getRef().split("/");
				for (String segment : segs) {
					if (segment.equals("*") && segs[segs.length - 1] == segment) {
						continue;
					}
					if (!ConfMLUtils.isValidRef(segment)) {
						return ctx.createFailureStatus(settingElement.getRef(),
								settingElement.getName());
					}
				}

			} else if (ConfMLUtils.isFeatureElementChild(settingElement)) {
				if (!ConfMLUtils.isValidRef(settingElement.getRef())) {
					return ctx.createFailureStatus(settingElement.getRef(),
							settingElement.getName());
				}
			}

		} else if (ctx.getTarget() instanceof com.nokia.tools.vct.confml.model.confml2.ESettingElement) {
			com.nokia.tools.vct.confml.model.confml2.ESettingElement settingElement = (com.nokia.tools.vct.confml.model.confml2.ESettingElement) ctx
					.getTarget();

			if (ConfMLUtils.isGroupElementChild(settingElement)) {
				String[] segs = settingElement.getRef().split("/");
				for (String segment : segs) {
					if (segment.equals("*") && segs[segs.length - 1] == segment) {
						continue;
					}
					if (!ConfMLUtils.isValidRef(segment)) {
						return ctx.createFailureStatus(settingElement.getRef(),
								settingElement.getName());
					}
				}

			} else if (ConfMLUtils.isFeatureElementChild(settingElement)) {
				if (!ConfMLUtils.isValidRef(settingElement.getRef())) {
					return ctx.createFailureStatus(settingElement.getRef(),
							settingElement.getName());
				}
			}

		} else {
			throw new IllegalArgumentException();
		}

		return ctx.createSuccessStatus();
	}

}
