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
import com.nokia.tools.vct.confml.model.confml1.ESettingTypeContainer;

public class DuplicateSettingName extends AbstractModelConstraint {

	public DuplicateSettingName() {
		super();
	}

	@Override
	public IStatus validate(IValidationContext ctx) {
		if (ctx.getTarget() instanceof ESettingElement) {
			ESettingElement settingElement = (ESettingElement) ctx.getTarget();

			if (!ConfMLUtils.isFeatureElementChild(settingElement)) {
				return ctx.createSuccessStatus();
			}

			if (settingElement.getName() == null) {
				return ctx.createSuccessStatus();
			}
			String thisName = settingElement.getName();

			ESettingTypeContainer container = (ESettingTypeContainer) settingElement
					.eContainer();
			for (ESettingElement ptr2 : container.getSettings()) {
				if (ptr2 == settingElement) {
					continue;
				}

				String name = ptr2.getName();
				if (name == null) {
					continue;
				}
				name = name.trim();
				if (thisName.equalsIgnoreCase(name)) {
					return ctx.createFailureStatus(ConfMLUtils
							.getAbsoluteRef(settingElement), settingElement
							.getName());
				}
			}
		} else if (ctx.getTarget() instanceof com.nokia.tools.vct.confml.model.confml2.ESettingElement) {
			com.nokia.tools.vct.confml.model.confml2.ESettingElement settingElement = (com.nokia.tools.vct.confml.model.confml2.ESettingElement) ctx
					.getTarget();

			if (!ConfMLUtils.isFeatureElementChild(settingElement)) {
				return ctx.createSuccessStatus();
			}

			if (settingElement.getName() == null) {
				return ctx.createSuccessStatus();
			}
			String thisName = settingElement.getName();

			com.nokia.tools.vct.confml.model.confml2.ESettingTypeContainer container = (com.nokia.tools.vct.confml.model.confml2.ESettingTypeContainer) settingElement
					.eContainer();
			for (com.nokia.tools.vct.confml.model.confml2.ESettingElement ptr2 : container
					.getSettings()) {
				if (ptr2 == settingElement) {
					continue;
				}

				String name = ptr2.getName();
				if (name == null) {
					continue;
				}
				name = name.trim();
				if (thisName.equalsIgnoreCase(name)) {
					return ctx.createFailureStatus(ConfMLUtils
							.getAbsoluteRef(settingElement), settingElement
							.getName());
				}
			}

		} else {
			throw new IllegalArgumentException();
		}

		return ctx.createSuccessStatus();
	}

}
