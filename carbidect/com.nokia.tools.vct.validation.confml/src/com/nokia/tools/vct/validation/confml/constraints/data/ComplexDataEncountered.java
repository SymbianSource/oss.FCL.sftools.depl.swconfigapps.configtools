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

package com.nokia.tools.vct.validation.confml.constraints.data;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;

import com.nokia.tools.vct.common.appmodel.EAppSettingType;
import com.nokia.tools.vct.common.appmodel.EAppSimpleType;
import com.nokia.tools.vct.confml.model.confml1.ESettingData;
import com.nokia.tools.vct.validation.confml.constraints.ConfMLUtils;

public class ComplexDataEncountered extends AbstractModelConstraint {

	public ComplexDataEncountered() {
		super();
	}

	@Override
	public IStatus validate(IValidationContext ctx) {
		if (ctx.getTarget() instanceof ESettingData) {
			ESettingData settingData = (ESettingData) ctx.getTarget();
			StringBuilder tmp = new StringBuilder();
			EAppSettingType ptr = ConfMLUtils.findType(settingData, tmp);
			String typePath = tmp.toString();

			if (ptr instanceof EAppSimpleType) {
				if (!settingData.getSettings().isEmpty()) {
					return ctx.createFailureStatus(typePath);
				}
			}
			
		} else if (ctx.getTarget() instanceof com.nokia.tools.vct.confml.model.confml2.ESettingData) {
			com.nokia.tools.vct.confml.model.confml2.ESettingData settingData = (com.nokia.tools.vct.confml.model.confml2.ESettingData) ctx.getTarget();
			StringBuilder tmp = new StringBuilder();
			EAppSettingType ptr = ConfMLUtils.findType(settingData, tmp);
			String typePath = tmp.toString();

			if (ptr instanceof EAppSimpleType) {
				if (!settingData.getSettings().isEmpty()) {
					return ctx.createFailureStatus(typePath);
				}
			}
		} else {
			throw new IllegalArgumentException();
		}
		return ctx.createSuccessStatus();
	}
}
