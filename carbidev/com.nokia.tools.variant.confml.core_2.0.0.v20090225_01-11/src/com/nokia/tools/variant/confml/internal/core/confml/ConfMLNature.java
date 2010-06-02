/*
 * Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies). 
 * All rights reserved.
 * This component and the accompanying materials are made available
 * under the terms of the License "Eclipse Public License v1.0"
 * which accompanies this distribution, and is available
 * at the URL "http://www.eclipse.org/legal/epl-v10.html".
 * 
 * Initial Contributors:
 * Nokia Corporation - Initial contribution
 * 
 * Contributors:
 * 
 * Description: This file is part of com.nokia.tools.variant.confml.core component.
 */

package com.nokia.tools.variant.confml.internal.core.confml;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import com.nokia.tools.variant.confml.core.ConfMLCore;
import com.nokia.tools.variant.confml.internal.core.project.GenericNature;

public class ConfMLNature extends GenericNature {
	public static final String CONF_ML_NATURE_ID = ConfMLCore.PLUGIN_ID + ".ConfMLLayerNature";

	public ConfMLNature() {
		super(CONF_ML_NATURE_ID);
	}

	public static void configureNature(IProject project,
			IProgressMonitor monitor) throws CoreException {
		configureNature(project, CONF_ML_NATURE_ID, monitor);
		configureBuilder(project, "com.nokia.tools.variant.confml.core.ConfMLLayerBuilder", monitor);
	}
}

