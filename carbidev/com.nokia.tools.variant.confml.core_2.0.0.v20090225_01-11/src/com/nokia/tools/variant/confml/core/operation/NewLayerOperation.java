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

package com.nokia.tools.variant.confml.core.operation;

import java.net.URI;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;

import com.nokia.tools.variant.confml.core.ConfMLUtil;
import com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata;
import com.nokia.tools.variant.confml.core.model.metadata.EMetadataFactory;

public class NewLayerOperation implements IWorkspaceRunnable {
	private URI locationURI;
	private String projectName;
	private String version;
	private String name;
	private String provider;
	private String confmlPath;
	private String implmlPath;
	private String contentPath;
	private String notesPath;

	public NewLayerOperation(String projectName, String name, String version) {

		this.projectName = projectName;
		this.name = name;
		this.version = version;
	}

	public void run(IProgressMonitor monitor) throws CoreException {
		try {
			ECPFMetadata settings = EMetadataFactory.eINSTANCE
					.createECPFMetadata();
			settings.setCpfRootFile("root.confml");
			settings.setVersion(version);
			settings.setName(name);
			// settings.setProvider(provider);
			
			final IProject project = ResourcesPlugin.getWorkspace().getRoot()
					.getProject(projectName);

			ConfMLUtil.createConfMLProject(project, getLocationURI(), monitor,
					settings);
			project.open(new SubProgressMonitor(monitor, 0));
			project.refreshLocal(IResource.DEPTH_INFINITE,
					new NullProgressMonitor());
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getProvider() {
		return provider;
	}

	public void setLocationURI(URI locationURI) {
		this.locationURI = locationURI;
	}

	public java.net.URI getLocationURI() {
		return locationURI;
	}


	public void setConfmlPath(String confmlPath) {
		this.confmlPath = confmlPath;
	}

	public String getConfmlPath() {
		return confmlPath;
	}

	public void setImplmlPath(String implmlPath) {
		this.implmlPath = implmlPath;
	}

	public String getImplmlPath() {
		return implmlPath;
	}

	public void setContentPath(String contentPath) {
		this.contentPath = contentPath;
	}

	public String getContentPath() {
		return contentPath;
	}

	public void setNotesPath(String notesPath) {
		this.notesPath = notesPath;
	}

	public String getNotesPath() {
		return notesPath;
	}

}
