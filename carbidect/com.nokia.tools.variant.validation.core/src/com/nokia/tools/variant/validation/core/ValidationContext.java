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
 * Description: This file is part of com.nokia.tools.variant.validation.core component.
 */

package com.nokia.tools.variant.validation.core;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata;
import com.nokia.tools.vct.common.appmodel.EConfigurationProject;

public class ValidationContext {
	/** Resource project context */
	private IProject project;
	/** Parsed metadata */ 
	private ECPFMetadata metadata;
	/** Parent layers */
	/** Application model for this project */
	private EConfigurationProject variantProject;
	/** Resource delta for the current project (can be NULL) */
	private IResourceDelta resourceDelta;
	/** Resource set */
	private ResourceSet resourceSet;
	
	public ValidationContext(IProject project, EConfigurationProject vp, IResourceDelta delta) {
		this.project = project;
		this.variantProject = vp;
		this.resourceDelta = delta;
	}
	
	public EConfigurationProject getVariantProject() {
		return variantProject;
	}
	
	public IProject getProject() {
		return project;
	}
	
	public ECPFMetadata getMetadata() {
		return metadata;
	}
	
	public void setMetadata(ECPFMetadata metadata) {
		this.metadata = metadata;
	}
	
	public IResourceDelta getResourceDelta() {
		return resourceDelta;
	}

	public void setResourceSet(ResourceSet resourceSet) {
		this.resourceSet = resourceSet;
	}

	public ResourceSet getResourceSet() {
		return resourceSet;
	}
}
