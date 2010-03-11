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
 * Description: This file is part of com.nokia.tools.variant.confml.ui component.
 */

package com.nokia.tools.variant.confml.ui.testers;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;

import com.nokia.tools.variant.confml.core.ConfMLCore;
import com.nokia.tools.vct.common.appmodel.EConfigurationProject;

public class ConfigurationRootTester extends PropertyTester {

	private static final String IS_CONFIGURATION_ROOT = "isConfigurationRoot";
	private static final String IS_CONFIGURATION_ROOT_CANDIDATE = "isConfigurationRootCandidate";

	public ConfigurationRootTester() {
		
	}

	public boolean test(Object receiver, String property, Object[] args,
			Object expectedValue) {

		if (!(receiver instanceof IFile)) {
			return false;
		}
		if (!(expectedValue instanceof Boolean)) {
			return false;
		}

		IFile file = (IFile) receiver;
		IProject project = file.getProject();

		EConfigurationProject cp = ConfMLCore.getProjectModel(project);
		if (cp == null) {
			return false;
		}
		URI rootConfmlURI = cp.getRootConfml();
		URI fileURI = URI.createPlatformResourceURI(file.getFullPath()
				.toString(), true);
		
		if (IS_CONFIGURATION_ROOT.equals(property)) {
			return expectedValue.equals(rootConfmlURI.equals(fileURI));
		} else if (IS_CONFIGURATION_ROOT_CANDIDATE.equals(property)) {
			return expectedValue.equals(!rootConfmlURI.equals(fileURI) && file.getParent() == project);
		}

		return false;
	}

}
