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
package com.nokia.tools.variant.confml.ui.handlers;

import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata;
import com.nokia.tools.variant.confml.core.model.metadata.EMetadataFactory;
import com.nokia.tools.variant.confml.core.model.metadata.util.ECPFMetadataResourceFactoryImpl;

public class SetConfigurationRootHandler extends AbstractHandler {
	private IFile file;
	private IWorkbenchWindow window;
	
	public Object execute(ExecutionEvent event) throws ExecutionException {
		selectionChanged(event);
		
		if(file==null) {
			return null;
		}
		
		IProject project = file.getProject();
		IFile metadataFile = project.getFile(".metadata");
		URI metadataFileURI = URI.createPlatformResourceURI(metadataFile
				.getFullPath().toString(), true);
		Resource resource = new ECPFMetadataResourceFactoryImpl()
				.createResource(metadataFileURI);
		ECPFMetadata metadata = null;
		if (metadataFile.isAccessible()) {
			try {
				resource.load(null);
				metadata = (ECPFMetadata)resource.getContents().get(0);
			} catch (IOException e) {
				// e.printStackTrace();
			}
		} 
		
		if (metadata == null) {
			metadata = EMetadataFactory.eINSTANCE.createECPFMetadata();
			resource.unload();
			resource.getContents().add(metadata);
		}
		
		metadata.setCpfRootFile(file.getProjectRelativePath().toPortableString());
		try {
			resource.save(null);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		closeEditors();
		return null;
	}
	
	private void closeEditors()
	{
		window.getActivePage().getWorkbenchWindow().getActivePage().closeAllEditors(true); 
	}
	
	public void selectionChanged(ExecutionEvent event) {
		
		try {
			window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
			ISelection selection = window.getSelectionService().getSelection();
			this.file = null;
			if (!(selection instanceof IStructuredSelection)) {
				return;
			}
			Object first = ((IStructuredSelection) selection).getFirstElement();
			if (!(first instanceof IFile)) {
				return;
			}
			IFile file = (IFile) first;
			this.file = file;
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
	
}
