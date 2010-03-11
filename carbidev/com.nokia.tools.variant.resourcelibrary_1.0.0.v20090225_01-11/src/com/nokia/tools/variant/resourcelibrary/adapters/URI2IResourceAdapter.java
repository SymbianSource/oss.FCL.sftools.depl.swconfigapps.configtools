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
 * Description: This file is part of com.nokia.tools.variant.resourcelibrary component.
 */

package com.nokia.tools.variant.resourcelibrary.adapters;

import java.net.URI;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import com.nokia.tools.variant.confml.core.model.application.EConfigurationProject;
import com.nokia.tools.variant.resourcelibrary.resources.ResourceUtil;

public class URI2IResourceAdapter implements IAdapterFactory {
	static final Class<?>[] adapters = { IResource.class };

	@SuppressWarnings("unchecked")
	public Object getAdapter(Object adaptableObject, Class adapterType) {

		if (adapterType == IResource.class) {
			if (!(adaptableObject instanceof URI))
				return null;
			URI uri = (URI) adaptableObject;

			IWorkbench wb = PlatformUI.getWorkbench();
			IWorkbenchPage activePage = wb.getActiveWorkbenchWindow()
					.getActivePage();
			if (activePage != null) {
				IEditorPart editor = activePage.getActiveEditor();
				if (editor != null) {
					EConfigurationProject project = (EConfigurationProject) editor
							.getAdapter(EConfigurationProject.class);

					return ResourceUtil.toResource(uri, project);
				}
			}
		}
		return null;
	}

	public Class<?>[] getAdapterList() {
		return adapters;
	}
}
