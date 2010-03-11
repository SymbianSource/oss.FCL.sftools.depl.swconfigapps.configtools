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

package com.nokia.tools.carbidect.cone.ui.internal.jobs;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

public class ConeBuilderJob extends Job {
	private ILaunchConfiguration runConfiguration;
	
	public ConeBuilderJob(String name, ILaunchConfiguration runLauch) {
		super(name);
		this.runConfiguration = runLauch;
	}

	@Override
	protected IStatus run(IProgressMonitor monitor) {
		try {
			runConfiguration.launch("run", monitor);
		} catch (Exception e) {
			showMessage();
		}
		return Status.OK_STATUS;
	}

	private void showMessage() {
		Display.getDefault().asyncExec(new Runnable() {

			public void run() {
				Shell activeShell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
				MessageDialog.openError(activeShell, "ConE", "Calling ConE tool failled!");
			}

		});
	}
}
