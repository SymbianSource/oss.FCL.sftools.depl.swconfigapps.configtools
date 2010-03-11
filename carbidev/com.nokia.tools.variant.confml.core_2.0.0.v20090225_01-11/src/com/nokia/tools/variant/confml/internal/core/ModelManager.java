/*
 * Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies). 
 * All rights reserved.
 * This component and the accompanying materials are made available
 * under the terms of the License "Symbian Foundation License v1.0"
 * which accompanies this distribution, and is available
 * at the URL "http://www.symbianfoundation.org/legal/sfl-v10.html".
 * 
 * Initial Contributors:
 * Nokia Corporation - Initial contribution
 * 
 * Contributors:
 * 
 * Description: This file is part of com.nokia.tools.variant.confml.core component.
 */

package com.nokia.tools.variant.confml.internal.core;

import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIHandler;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.emf.ecore.resource.impl.PlatformResourceURIHandlerImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain.Registry;

import com.nokia.tools.variant.confml.core.ConfMLCore;
import com.nokia.tools.variant.confml.core.model.application.EConfMLLayer;
import com.nokia.tools.variant.confml.core.model.application.EConfigurationProject;
import com.nokia.tools.variant.confml.core.model.core.EConfmlRootFactory;
import com.nokia.tools.variant.confml.core.model.core.EWorkspaceModel;

public class ModelManager {
	static private ModelManager INSTANCE;

	private TransactionalEditingDomain editingDomain;
	private final Resource resource;
	private final EWorkspaceModel workspaceModel;

	public static synchronized ModelManager getModelManager() {
		if (INSTANCE == null) {
			INSTANCE = new ModelManager();
		}
		return INSTANCE;
	}

	private ModelManager() {
		try {
			resource = new ResourceImpl(URI.createURI("confml:///"));
			workspaceModel = EConfmlRootFactory.eINSTANCE
					.createEWorkspaceModel();
			resource.getContents().add(workspaceModel);
			editingDomain = Registry.INSTANCE
					.getEditingDomain("com.nokia.tools.variant.confml.core.ConfMLModelDomain");
			List<URIHandler> handlers = Collections
					.singletonList((URIHandler) new PlatformResourceURIHandlerImpl());
			editingDomain.getResourceSet()
					.setURIConverter(
							new ExtensibleURIConverterImpl(handlers,
									ContentHandler.Registry.INSTANCE
											.contentHandlers()));
			editingDomain.getCommandStack().execute(
					new RecordingCommand(editingDomain) {
						@Override
						protected void doExecute() {
							editingDomain.getResourceSet().getResources().add(
									resource);
						}
					});
			editingDomain.getCommandStack().flush();
		} catch (Exception ex) {
			System.err.println("Error loading *************************");
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}

	public TransactionalEditingDomain getEditingDomain() {
		return editingDomain;
	}

	public EWorkspaceModel getWorkspaceModel() {
		return workspaceModel;
	}

	/**
	 * Simply find the project model from the root model
	 * 
	 * @param project
	 *            Project to find corresponding project model for
	 * @param monitor
	 *            Progress monitor
	 * @return Project model or <code>null</code>
	 * @throws CoreException
	 */
	public EConfigurationProject getProjectModel(IProject project) {
		return workspaceModel.getProjectMap().get(project.getName());
	}

	public Resource getResource() {
		return resource;
	}

	public EConfMLLayer getLayer(IResource resource) {
		if (resource instanceof IProject) {
			EConfigurationProject cp = getProjectModel((IProject) resource);
			return cp == null ? null : cp.getLastLayer();
		}
		EConfigurationProject project;
		project = ConfMLCore.getProjectModel(resource.getProject());
		if (project == null) {
			return null;
		}

		IPath resourcePath = resource.getFullPath();
		EConfMLLayer result = null;
		IPath resultPath = Path.EMPTY;
		
		for (EConfMLLayer layer : project.getLayers()) {
			URI layerURI = layer.getLayerURI();
			IPath path = new Path(layerURI.toPlatformString(true));
			if (path.matchingFirstSegments(resourcePath) == path.segmentCount()) {
				if (resultPath.segmentCount() < path.segmentCount()) {
					resultPath = path;
					result = layer;
				}
			}
		}
		
		return result;
	}
}
