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
 * Description: This file is part of com.nokia.tools.variant.confml.core component.
 */

package com.nokia.tools.variant.confml.core;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata;
import com.nokia.tools.variant.confml.core.model.metadata.EMetadataFactory;
import com.nokia.tools.variant.confml.core.model.metadata.util.ECPFMetadataResourceFactoryImpl;
import com.nokia.tools.variant.confml.internal.core.confml.ConfMLNature;
import com.nokia.tools.variant.confml.internal.core.confml.CrmlNature;
import com.nokia.tools.vct.common.core.utils.PlatformUtil;
import com.nokia.tools.vct.common.core.utils.WorkspaceOperation;

public class ConfMLUtil {

	public static void createConfMLProject(final IProject project,
			final java.net.URI location, IProgressMonitor monitor,
			final ECPFMetadata settings) throws CoreException {
		WorkspaceOperation action = new WorkspaceOperation() {
			@Override
			protected void execute() throws CoreException {
				beginTask("Creating project", 10);
				createProject(getSubProgressMonitor(3), project, location);
				openProject(getSubProgressMonitor(3), project);
				configureProject(getSubProgressMonitor(4), project, settings);
			}

			private void createProject(IProgressMonitor monitor,
					IProject project, java.net.URI locationURI)
					throws CoreException {
				monitor.beginTask("Creating project", 1);
				try {
					if (!project.exists()) {
						IProjectDescription desc = project.getWorkspace()
								.newProjectDescription(project.getName());
						if (locationURI != null
								&& project.getWorkspace().getRoot()
										.getLocationURI().equals(locationURI)) {
							locationURI = null;
						}
						desc.setLocationURI(locationURI);
						createProject(new SubProgressMonitor(monitor, 1),
								project, desc);
					}
				} finally {
					monitor.done();
				}
			}

			private void openProject(IProgressMonitor monitor, IProject project)
					throws CoreException {
				if (!project.isOpen()) {
					project.open(monitor);
				} else {
					monitor.done();
				}
			}

			private void configureProject(IProgressMonitor monitor,
					IProject project, ECPFMetadata configuration)
					throws CoreException {
				monitor.beginTask("Configuring project", 7);
				ConfMLNature.configureNature(project, new SubProgressMonitor(
						monitor, 2));
				//add crml nature and builder
				CrmlNature.configureNature(project, new SubProgressMonitor(
						monitor, 2));

				try {

					if (configuration != null) {
						IFile file = project.getFile(".metadata");
						Resource resource = new ECPFMetadataResourceFactoryImpl()
								.createResource(URI.createPlatformResourceURI(
										file.getFullPath().toPortableString(),
										true));
						EObject copy = EcoreUtil.copy(configuration);
						resource.getContents().add(copy);
						resource.save(null);
					}

				} catch (Exception ex) {
					throw new CoreException(new Status(IStatus.ERROR,
							ConfMLCore.PLUGIN_ID,
							"Failed to configure project", ex));
				} finally {
					monitor.done();
				}

			}

		};

		PlatformUtil.run(action, monitor);
	}
	
	
	/**
	 * This method creates/updates the .metadata file given as
	 * parameter
	 * @param metaFile .metadata file
	 * @param activeConfig name of cpf root file to put
	 */
	public static void updateProjectMetadata(File metaFile, String activeConfig) {
		URI metadataFileURI = URI.createFileURI(metaFile
				.getAbsolutePath());
		Resource resource = new ECPFMetadataResourceFactoryImpl()
		.createResource(metadataFileURI);
		ECPFMetadata metadata = null;
		if (metaFile.exists()) {
			try {
				resource.load(null);
				metadata = (ECPFMetadata)resource.getContents().get(0);
			} catch (IOException e) {
			}
		} 
		
		if (metadata == null) {
			metadata = EMetadataFactory.eINSTANCE.createECPFMetadata();
			resource.unload();
			resource.getContents().add(metadata);
		}
		if(activeConfig!=null&&!activeConfig.equals("")) {
			metadata.setCpfRootFile(activeConfig);							
		}
		try {
			resource.save(null);
		} catch (IOException e) {							
			e.printStackTrace();
		}
	}
	
}
