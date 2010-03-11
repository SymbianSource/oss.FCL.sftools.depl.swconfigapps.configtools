/*
* Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies).
* All rights reserved.
* This component and the accompanying materials are made available
* under the terms of "Eclipse Public License v1.0"
* which accompanies this distribution, and is available
* at the URL "http://www.eclipse.org/legal/epl-v10.html".
*
* Initial Contributors:
* Nokia Corporation - initial contribution.
*
* Contributors:
*
* Description: 
*
*/

package com.nokia.tools.variant.confml.internal.core.confml;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import com.nokia.tools.variant.confml.internal.core.project.GenericNature;

public class CrmlNature  extends GenericNature {
	public static final String CRML_NATURE_ID = "com.nokia.s60ct.build.CenRepNature";

	public CrmlNature() {
		super(CRML_NATURE_ID);
	}

	public static void configureNature(IProject project,
			IProgressMonitor monitor) throws CoreException {
		configureNature(project, CRML_NATURE_ID, monitor);
		configureBuilder(project, "com.nokia.s60ct.build.CenRepBuilder", monitor);
	}

}
