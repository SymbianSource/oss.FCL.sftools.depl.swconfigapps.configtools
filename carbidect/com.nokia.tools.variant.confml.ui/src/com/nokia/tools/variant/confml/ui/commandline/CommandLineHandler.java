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
package com.nokia.tools.variant.confml.ui.commandline;

import java.io.File;

import org.eclipse.core.internal.events.BuildCommand;
import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.ui.IStartup;

import com.nokia.tools.variant.confml.core.ConfMLUtil;
import com.nokia.tools.variant.confml.internal.core.confml.ConfMLNature;
import com.nokia.tools.variant.confml.ui.ConfmlUI;

public class CommandLineHandler implements IStartup {
	final String CONFIGURATION_ROOT    = "-config_root";
	final String CONFIGURATION_PROJECT = "-project";

	public void earlyStartup() {
		ImportJob job = new ImportJob("Importing/Opening projects");
		job.setPriority(Job.LONG);
		job.schedule();
	}
	
	private class ImportJob extends Job {

		public ImportJob(String name) {
			super(name);
		}

		@Override
		protected IStatus run(IProgressMonitor monitor) {
			String projectArg = null;
			String configurationArg = null;

			String[] commandLineArgs = Platform.getCommandLineArgs();
			for (int i = 0; i < commandLineArgs.length; i++) {
				String arg = commandLineArgs[i];
				if(arg.equals(CONFIGURATION_PROJECT)) {
					if(i<commandLineArgs.length) {
						projectArg = commandLineArgs[i+1];
					}
				}
				if(arg.equals(CONFIGURATION_ROOT)) {
					if(i<commandLineArgs.length) {
						configurationArg = commandLineArgs[i+1];
					}
				}			
			}

			if(projectArg != null) {
				final IPath ppath = new Path(projectArg);
				final String configuration = configurationArg;
				final IWorkspace workspace = ResourcesPlugin.getWorkspace();
				final IWorkspaceRoot root = workspace.getRoot();

				if(ppath.isRoot() || !ppath.toFile().exists() ) {
					String message = "Command line argument -project doesn't point to existing project or folder";
					IStatus status = new Status(Status.ERROR,ConfmlUI.PLUGIN_ID,message);
					return status;
				}
				
				IWorkspaceRunnable op = 
					new IWorkspaceRunnable() {

					public void run(IProgressMonitor monitor)
					throws CoreException {
						// investigate project system file 
						IPath pSystemPath = ppath.append(".project");
						File metaFile = ppath.append(".metadata").toFile();
						File pSystemFile = pSystemPath.toFile();
						IProjectDescription pd = null;
						String projectName = ppath.lastSegment();
						IProject project = null;
						
						// prepare .metadata file
						ConfMLUtil.updateProjectMetadata(metaFile, configuration);
						
						// prepare .project file						
						if(pSystemFile.exists()) {
							pd = workspace.loadProjectDescription(pSystemPath);
						} else {
							// create new .project file
							pd = workspace.newProjectDescription(projectName);
							pd.setLocation(ppath);
							String[] natures = new String[2];
							natures[0] = ConfMLNature.CONF_ML_NATURE_ID;
							natures[1] = "com.nokia.s60ct.build.CenRepBuilder";
							pd.setNatureIds(natures);

							ICommand[] buildSpec = new ICommand[2];

							BuildCommand bc = new BuildCommand();
							bc.setBuilderName("com.nokia.tools.variant.confml.core.ConfMLLayerBuilder");									
							buildSpec[0] = bc;

							bc = new BuildCommand();
							bc.setBuilderName("com.nokia.s60ct.build.CenRepBuilder");
							buildSpec[1] = bc;

							pd.setBuildSpec(buildSpec);
						}
						
						project = root.getProject(projectName);
						if(!project.exists()) {
							project.create(pd, monitor);
							project.open(monitor);
						}
					}
				};


				try {
					workspace.run(op, root, IWorkspace.AVOID_UPDATE, monitor);
				} catch (CoreException e) {
					e.printStackTrace();
				}			
			}	
			return Status.OK_STATUS;
		}
		
	}
}
