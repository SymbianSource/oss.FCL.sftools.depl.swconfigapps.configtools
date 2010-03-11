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

package com.nokia.tools.variant.imaker.ct.internal;

import java.io.IOException;
import java.net.URI;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;

import com.nokia.tools.vct.imaker.core.IImageMaker;
import com.nokia.tools.vct.imaker.core.ImakerCore;

public class ImageBuilderJob extends Job {

	private URI drive;
	private URI config;
	private URI outputLoc;
	private MessageConsole console;

	public ImageBuilderJob(String name, URI drive, URI config, URI outputLoc,
			MessageConsole console) {
		super(name);
		this.drive = drive;
		this.config = config;
		this.outputLoc = outputLoc;
		this.console = console;
	}

	@Override
	protected IStatus run(IProgressMonitor monitor) {
		MessageConsoleStream stream = console.newMessageStream();
		IImageMaker imageMaker;
		try {
			imageMaker = ImakerCore.getImageMaker(drive);
			int ret = imageMaker.createImage(config, null, outputLoc, stream,monitor);
			if(ret!=0) {
				showMessage();
			}
		} catch (IOException e) {
			e.printStackTrace();
			showMessage();
		}
				
		return Status.OK_STATUS;
	}

	private void showMessage() {
		Display.getDefault().asyncExec(new Runnable() {

			public void run() {
				Shell activeShell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
				MessageDialog.openError(activeShell, "iMaker", "Image creation failled!");
			}

		});
	}
}
