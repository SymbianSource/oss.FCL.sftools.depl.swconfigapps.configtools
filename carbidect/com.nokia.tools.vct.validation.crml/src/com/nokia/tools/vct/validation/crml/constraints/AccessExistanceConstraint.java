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
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;

import com.nokia.tools.vct.crml.crmodel.EAccess;
import com.nokia.tools.vct.crml.crmodel.EAccessContainer;
import com.nokia.tools.vct.crml.crmodel.EAccessType;
import com.nokia.tools.vct.crml.crmodel.EKey;
import com.nokia.tools.vct.crml.crmodel.EKeyRange;
import com.nokia.tools.vct.crml.crmodel.ERepository;

public class AccessExistanceConstraint extends AbstractModelConstraint {

	private final static String URL = "http://127.0.0.1:1295/help/index.jsp?topic=/com.nokia.tools.variant.validation.help/html/validation.html" +
			"#.7B.25element_ref.25.7D_does_not_have_any_read_capabilities";

	public AccessExistanceConstraint() {

	}

	public IStatus validate(IValidationContext ctx) {
		EAccessContainer accessable = (EAccessContainer) ctx.getTarget();
		EAccess rac = null;
		for (EAccess tmp : accessable.getAccess()) {
			if (tmp.getType() == EAccessType.READ) {
				rac = tmp;
				break;
			}
		}

		if (rac == null
				|| ((rac.getSid() == null || rac.getSid().trim().length() == 0) && (rac
						.getCapabilities() == null || rac.getCapabilities()
						.trim().length() == 0))) {
			if (accessable instanceof EKey) 
			{
				EKey key = (EKey) accessable;
				if (key.eContainer() instanceof ERepository)
				{
					if (!checkRepositoryAccess(((ERepository) key.eContainer())))
						return ctx.createFailureStatus(ElementRefParser.getName(accessable), URL);
				}
				else if (key.eContainer() instanceof EKeyRange)
				{
					if (!checkRepositoryAccess(((ERepository) key.eContainer().eContainer())))
						return ctx.createFailureStatus(ElementRefParser.getName(accessable), URL);
				}
			} 
			else if (accessable instanceof ERepository)
				return ctx.createFailureStatus(ElementRefParser
						.getName(accessable), URL);

		}
		return ctx.createSuccessStatus();

		// if (rac==null || ((rac.getSid()==null || rac.getSid().trim().length()
		// == 0) && (rac.getCapabilities()==null ||
		// rac.getCapabilities().trim().length() == 0))){
		// return
		// ctx.createFailureStatus(ElementRefParser.getName(accessable),URL);
		// }
		// else return ctx.createSuccessStatus();
	}

	private boolean checkRepositoryAccess(ERepository rep) {
		EAccess rac = null;
		for (EAccess tmp : rep.getAccess()) {
			if (tmp.getType() == EAccessType.READ) {
				rac = tmp;
				break;
			}
		}

		if (rac == null
				|| ((rac.getSid() == null || rac.getSid().trim().length() == 0) && (rac
						.getCapabilities() == null || rac.getCapabilities()
						.trim().length() == 0)))
			return false;

		return true;
	}
}
