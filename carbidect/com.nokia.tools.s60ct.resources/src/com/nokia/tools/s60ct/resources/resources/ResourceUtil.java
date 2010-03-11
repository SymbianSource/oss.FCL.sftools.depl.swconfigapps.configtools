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

package com.nokia.tools.s60ct.resources.resources;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.eclipse.core.filesystem.URIUtil;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.IStructuredSelection;

import com.nokia.tools.s60ct.resources.model.ELibraryDirectory;
import com.nokia.tools.s60ct.resources.model.ELibraryElement;
import com.nokia.tools.s60ct.resources.model.ELibraryRoot;
import com.nokia.tools.s60ct.resources.views.ResourceStorage;
import com.nokia.tools.vct.common.appmodel.EConfigurationProject;

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

	public static ELibraryElement getFileSystemElement(ELibraryRoot root,String localPath){
		if (localPath == null) {
			return null;
		}
		
		String[] path = localPath.split("\\\\|/");
		ELibraryElement fse = root;
		
		for (int i = 0; i < path.length; i++) {
			if (fse instanceof ELibraryDirectory) {
				ELibraryDirectory parentDir = (ELibraryDirectory) fse;
				ELibraryElement child = parentDir.getChild(path[i]);
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
	
	/**
	 * @param selection
	 * @return Test if selection is from the same directory or not
	 */
	public static boolean checkSelectionForCopyOrMove(IStructuredSelection selection) {
		if (selection.isEmpty()) {
			return false;
		}
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection ss = (IStructuredSelection) selection;
			List list = ss.toList();

			if (list.size() == 1) {
				return true;
			}
			
			int size = list.size();
			for (int i = 0 ; i < size -1 ; i++) {
				Object o1 = list.get(i);
				Object o2 = list.get(i+1);
				
				if (o1 instanceof ResourceStorage && o2 instanceof ResourceStorage) {
					ResourceStorage rs1 = (ResourceStorage) o1;
					ResourceStorage rs2 = (ResourceStorage) o2;
					ELibraryElement o1fse = rs1.getFileSystemElement();
					ELibraryElement o2fse = rs2.getFileSystemElement();
					
					if (o1fse.eContainer() != o2fse.eContainer()) {
						return false;
					}
				} else {
					return false;
				}
			}
		}
		return true;
	}

	
}
