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
 * Description: This file is part of com.nokia.tools.carbide.validation.core component.
 */

package com.nokia.tools.carbide.validation.core.builder;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.nokia.tools.carbide.validation.core.IValidationResourceSet;

public class ValidationResourceSet extends ResourceSetImpl implements IValidationResourceSet {

	private IProject configurationProject;
	
	public ValidationResourceSet() {
		super();
	}
	
	public Object getAdapter(Class adapter) {
		if (adapter == IProject.class) {
			return configurationProject;
		}
		
		return null;
	}
	
	public void setConfigurationProject(
			IProject configurationProject) {
		this.configurationProject = configurationProject;
	}
}
