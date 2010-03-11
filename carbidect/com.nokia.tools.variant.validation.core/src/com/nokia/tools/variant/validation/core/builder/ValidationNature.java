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

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import com.nokia.tools.variant.confml.internal.core.project.GenericNature;

public class ValidationNature extends GenericNature {

	private static final String VALIDATION_NATURE_ID = "com.validation";


	protected ValidationNature(String natureName, String[] builderNames) {
		super(natureName, builderNames);
		
	}


	public static void configureNature(IProject project,
			IProgressMonitor monitor) throws CoreException {
		configureNature(project, VALIDATION_NATURE_ID, monitor);
		configureBuilder(project, "com.nokia.tools.variant.confml.core.ConfMLLayerBuilder", monitor);
	}
}
