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

package com.nokia.tools.variant.resourcelibrary.resources;
import java.net.URI;
import java.net.URISyntaxException;

import org.eclipse.core.filesystem.URIUtil;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.nokia.tools.variant.confml.core.model.application.EConfigurationProject;
import com.nokia.tools.variant.resourcelibrary.model.Directory;
import com.nokia.tools.variant.resourcelibrary.model.FileSystemElement;
import com.nokia.tools.variant.resourcelibrary.model.ResourceModelRoot;

/**
 * 
 * Utility for working with resource library
 *
 */
public class ResourceUtil {
	
	/**
	 * Convert project-relative path to URI
	 * 
	 * Note: Assumes IPaths are of type "/resources/root/path"
	 * 
	 * @param path The project relative path
	 * @return URI matching the path, null if the path is invalid
	 */
	public static URI toURI(IPath path) {	
		if (path == null) return null;
		
		// Fetch the second segment root, e.g. URI scheme 
		String scheme = path.segment(1);
		
		// Fetch the path to resource library
		// Remove trailing "resources" to find the URI path
		IPath uriPath = path.removeFirstSegments(2);
		
		// Fetch the path
		URI ssp;
		if (uriPath.segmentCount() > 0)
			ssp = URIUtil.toURI(uriPath.toPortableString());
		else ssp = URIUtil.toURI("/");
		try {
			return new URI(scheme, ssp.getPath(), null);
		} catch (URISyntaxException e) {
			return null;
		}
	}
	
	public static String toURIString(IPath path) {
		if (path == null) return null;
		
		URI uri = toURI(path);
		if (uri != null) return uri.toString();
		return null;
	}
		
	public static IStorage toResource(String uri, EConfigurationProject project) {
		try {
			return toResource(new URI(uri), project);
		} catch (URISyntaxException e) {
			return null;
		}		
	}
	
	public static IStorage toResource(URI uri, EConfigurationProject project) {		
		String scheme = uri.getScheme();
		if (scheme == null || project == null) return null;
		
		if (project != null) {
			ResourceSet resourceRoots = project.eResource().getResourceSet();
			if (resourceRoots == null)
				return null;
			/*for (EResourceElement root : resourceRoots) {
				if (root.getName().equals(scheme)) {
					return root.findMember(uri.getPath());					
				}
			}*/
		}
		
		return null;
	}
	
	public static IStorage getResource(String resourceLibraryURI,
			EConfigurationProject p) {
		URI uri;
		try {
			uri = new URI(resourceLibraryURI);
		} catch (URISyntaxException e) {
			
			e.printStackTrace();
			return null;
		}
		// URI uri = ResourceUtil.toURI(new Path(v1));
		if (uri == null) {
			return null;
		}
		IStorage resource = ResourceUtil.toResource(uri, p);
		return resource;
	}

	public static FileSystemElement getFileSystemElement(ResourceModelRoot root,String localPath){
		if (localPath == null) {
			return null;
		}
		
		String[] path = localPath.split("\\\\|/");
		FileSystemElement fse = root;
		
		for (int i = 0; i < path.length; i++) {
			if (fse instanceof Directory) {
				Directory parentDir = (Directory) fse;
				FileSystemElement child = parentDir.getChild(path[i]);
				if (child == null) {
					break;
				} else {
					fse = child;
				}
				if (i == path.length - 1) {
					return child;
				}
			}
		}
		return null;
	}
	
}
