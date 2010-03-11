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
 * Description: This file is part of com.nokia.tools.vct.validation.crml component.
 */

package com.nokia.tools.vct.validation.crml.constraints;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;

import com.nokia.tools.vct.crml.crmodel.EAccess;
import com.nokia.tools.vct.crml.crmodel.EAccessType;
import com.nokia.tools.vct.crml.crmodel.EKey;
import com.nokia.tools.vct.crml.crmodel.EKeyRange;

public class WAccessWarning extends AbstractModelConstraint {
	private static final String ALWAYS_PASS = "alwayspass";
	private static final String WRITE_DEVICE_DATA = "writedevicedata";
	private static final String URL = "http://127.0.0.1:1295/help/index.jsp?topic=/com.nokia.tools.variant.validation.help/html/validation.html" +
			"#.7B.25element_ref.25.7D_write_capability_is_neither_AlwaysPass_nor_WriteDeviceData";

	public WAccessWarning() {
		super();
	}

	@Override
	public IStatus validate(IValidationContext ctx) {
		EAccess access = (EAccess) ctx.getTarget();
		if (access.getType() == EAccessType.WRITE) {
			String cap = access.getCapabilities();

			EObject container = access.eContainer();
			if (container instanceof EKey) {
				EKey key = (EKey) container;
				if (key.isReadOnly())
					return ctx.createSuccessStatus();
			} else if (container instanceof EKeyRange) {
				EKeyRange keyRange = (EKeyRange) container;
				if (keyRange.isReadOnly())
					return ctx.createSuccessStatus();
			}
			if (cap == null
					|| (cap.toLowerCase().indexOf(ALWAYS_PASS) == -1 && cap
							.toLowerCase().indexOf(WRITE_DEVICE_DATA) == -1))
				return ctx.createFailureStatus(
						ElementRefParser.getName(access), URL);
		}
		return ctx.createSuccessStatus();
	}

}
