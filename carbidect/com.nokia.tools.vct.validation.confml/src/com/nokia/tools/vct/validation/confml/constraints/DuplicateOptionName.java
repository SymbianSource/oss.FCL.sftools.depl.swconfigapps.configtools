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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;

import com.nokia.tools.vct.confml.model.confml1.EOptionElement;
import com.nokia.tools.vct.confml.model.confml1.ESettingElement;

public class DuplicateOptionName extends AbstractModelConstraint {

	public DuplicateOptionName() {
		super();
	}

	@Override
	public IStatus validate(IValidationContext ctx) {
		if (ctx.getTarget() instanceof EOptionElement) {

			EOptionElement optionElement = (EOptionElement) ctx.getTarget();
			ESettingElement settingElement = (ESettingElement) optionElement
					.eContainer();

			String name = optionElement.getName();
			if (name == null) {
				return ctx.createSuccessStatus();
			}
			name = name.trim();

			List<EOptionElement> duplicates = new ArrayList<EOptionElement>();

			for (EOptionElement anotherOption : settingElement.getOptions()) {
				String anotherName = anotherOption.getName();
				if (anotherName == null) {
					continue;
				}
				anotherName = anotherName.trim();

				if (name.equalsIgnoreCase(anotherName)) {
					duplicates.add(anotherOption);
				}
			}
			if (duplicates.size() > 1) {
				return ctx.createFailureStatus(ConfMLUtils
						.getAbsoluteRef(settingElement), optionElement
						.getName());
			}
		} else if (ctx.getTarget() instanceof com.nokia.tools.vct.confml.model.confml2.EOptionElement) {
			com.nokia.tools.vct.confml.model.confml2.EOptionElement optionElement = (com.nokia.tools.vct.confml.model.confml2.EOptionElement) ctx
					.getTarget();
			com.nokia.tools.vct.confml.model.confml2.ESettingElement settingElement = (com.nokia.tools.vct.confml.model.confml2.ESettingElement) optionElement
					.eContainer();

			String name = optionElement.getName();
			if (name == null) {
				return ctx.createSuccessStatus();
			}
			name = name.trim();

			List<com.nokia.tools.vct.confml.model.confml2.EOptionElement> duplicates = new ArrayList<com.nokia.tools.vct.confml.model.confml2.EOptionElement>();

			for (com.nokia.tools.vct.confml.model.confml2.EOptionElement anotherOption : settingElement
					.getOptions()) {
				String anotherName = anotherOption.getName();
				if (anotherName == null) {
					continue;
				}
				anotherName = anotherName.trim();

				if (name.equalsIgnoreCase(anotherName)) {
					duplicates.add(anotherOption);
				}
			}
			if (duplicates.size() > 1) {
				return ctx.createFailureStatus(ConfMLUtils
						.getAbsoluteRef(settingElement), optionElement
						.getName());
			}

		} else {
			throw new IllegalArgumentException();
		}

		return ctx.createSuccessStatus();
	}

}
