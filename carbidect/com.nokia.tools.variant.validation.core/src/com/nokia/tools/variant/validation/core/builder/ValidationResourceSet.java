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
 * Description: This file is part of com.nokia.tools.variant.validation.core component.
 */

package com.nokia.tools.variant.validation.core.builder;

import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.nokia.tools.variant.validation.core.IValidationResourceSet;
import com.nokia.tools.vct.common.appmodel.EConfigurationProject;

public class ValidationResourceSet extends ResourceSetImpl implements IValidationResourceSet {

	private EConfigurationProject configurationProject;
	
	public ValidationResourceSet() {
		super();
	}
	
	public Object getAdapter(Class adapter) {
		if (adapter == EConfigurationProject.class) {
			return configurationProject;
		}
		
		return null;
	}
	
	public void setConfigurationProject(
			EConfigurationProject configurationProject) {
		this.configurationProject = configurationProject;
	}
}
