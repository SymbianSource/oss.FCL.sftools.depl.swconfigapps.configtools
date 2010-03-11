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

import com.nokia.tools.vct.common.appmodel.EAppRfsInfo;
import com.nokia.tools.vct.common.appmodel.EAppSetting;
import com.nokia.tools.vct.crml.crmodel.EReadOnly;
import com.nokia.tools.vct.crml.crmodel.ERefContainer;

public class ReadOnlyRFS extends AbstractModelConstraint {

	private static final String URL = "http://127.0.0.1:1295/help/index.jsp?topic=/com.nokia.tools.variant.validation.help/html/validation.html" +
			"#Read-only_.7B.25element_ref.25.7D_is_marked_for_RFS";
	
	public ReadOnlyRFS() {
		super();
	}

	// Restore Factory Settings must not be enabled for read-only element, 
	//	and will be ignored during initialization file generation
	public IStatus validate(IValidationContext ctx) {
		EObject obj = ctx.getTarget();
		if(EReadOnly.class.isInstance(obj)&&ERefContainer.class.isInstance(obj)){
			if(((EReadOnly)obj).isReadOnly()){
				EAppRfsInfo rfsInfo = null;
				EAppSetting setting = ElementRefParser.getConfMLSetting(obj, ((ERefContainer)obj).getRef());
				if (setting != null) {
					rfsInfo = setting.getRfsInfo();
				}

				if (rfsInfo != null && rfsInfo.isRfs()) {
					return ctx.createFailureStatus(ElementRefParser.getName(obj), URL);
				}
			}
		}
		return ctx.createSuccessStatus();
	}


}
