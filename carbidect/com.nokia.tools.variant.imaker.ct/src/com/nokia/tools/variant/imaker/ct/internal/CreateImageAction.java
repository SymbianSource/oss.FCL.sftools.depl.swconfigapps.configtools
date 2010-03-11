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

import java.net.URI;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.console.MessageConsole;

import com.nokia.tools.variant.confml.core.ConfMLCore;
import com.nokia.tools.variant.imaker.ct.ImakerUIPlugin;
import com.nokia.tools.vct.common.appmodel.EConfigurationProject;

public class CreateImageAction implements IWorkbenchWindowActionDelegate {

	private IProject project;
	private IFolder outFolder;
	private final String OUTPUT_FOLDER = "image";
	private IWorkbenchWindow window;

	public void dispose() {
	}

	public void init(IWorkbenchWindow window) {
		this.window = window;
	}

	public void run(IAction action) {
		EConfigurationProject pm = ConfMLCore.getProjectModel(project);
		if (pm != null) {
			URI loc = project.getLocationURI();
			createOutputFolder();
			URI output = outFolder.getLocationURI();
			ImakerUIPlugin plugin = ImakerUIPlugin.getDefault();
			MessageConsole console = plugin.getConsole();
			ImageBuilderJob job = new ImageBuilderJob("Create image", loc,
					loc, output, console);
			console.activate();
			job.setPriority(Job.LONG);
			job.setUser(true);
			job.setRule(plugin.getImakerRule());
			job.addJobChangeListener(new JobChangeAdapter() {

				@Override
				public void done(IJobChangeEvent event) {
					Display display = window.getShell().getDisplay();
					display.asyncExec(new Runnable() {

						public void run() {
							try {
								if(outFolder.isAccessible()) {
									outFolder.refreshLocal(IResource.DEPTH_INFINITE, null);									
								}
							} catch (CoreException e) {
								e.printStackTrace();
							}
						}
						
					});
				}
				
			});
			job.schedule();
		}
	}

	private void createOutputFolder() {
		IWorkspaceRunnable wr = new IWorkspaceRunnable() {

			public void run(IProgressMonitor monitor) throws CoreException {
				outFolder = project.getFolder(OUTPUT_FOLDER);
				if (!outFolder.isAccessible()) {
					outFolder.create(IResource.FORCE, true, null);
				}
			}

		};
		IWorkspace workspace = project.getWorkspace();
		try {
			workspace.run(wr, project, IWorkspace.AVOID_UPDATE, null);
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	public void selectionChanged(IAction action, ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection ss = (IStructuredSelection) selection;
			Object element = ss.getFirstElement();
			if(element instanceof IProject) {
				project = (IProject) element;				
			}
		}
	}

}
