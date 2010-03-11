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
package helpers;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import constants.IS60CTCommonConstants;

public class DefaultProject {
	private static IProject defaultProject = null;
	
	public static IProject getDefaultProject() {
		if (defaultProject == null) {
			// Open or create project
			try {
				defaultProject = ResourcesPlugin.getWorkspace().getRoot().getProject(IS60CTCommonConstants.DEFAULT_PROJECT);
				if (!defaultProject.exists()) {
					defaultProject.create(null);
				}
				if (!defaultProject.isOpen()) {
					defaultProject.open(null);
				}
				defaultProject.deleteMarkers(null, true, IResource.DEPTH_INFINITE);
				for (IResource member : defaultProject.members(true)) {
					member.delete(true, null);				
				}
				defaultProject.clearHistory(null);
				//Is this needed? ResourcesPlugin.getWorkspace().getRoot().refreshLocal(IResource.DEPTH_INFINITE, null);
			} catch (CoreException exception) {
				System.out.println(exception.toString());
				EcorePlugin.INSTANCE.log(exception);
			}
		}
		return defaultProject;
	}
	
	public static IFile createLinkFile(URI fileURI){
		IFile iFile = DefaultProject.getDefaultProject().getFile(new Path(fileURI.lastSegment()));
		try{
			iFile.createLink(new Path(fileURI.toFileString()), IResource.REPLACE, null);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return iFile;
	}

	public static IFile getLinkFile(URI uri) {
		IFile file = DefaultProject.getDefaultProject().getFile(new Path(uri.lastSegment()));
		if(file.exists())
			return file;
		return null;
	}
}
