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
 * Description: This file is part of com.nokia.tools.variant.confml.ui component.
 */

package com.nokia.tools.variant.confml.ui.editors;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;

import com.nokia.tools.vct.confml.model.confml1.EConfMLDocument;

public class EditorUtils {
	
	public static void openEditor(URI uri, String editorId) {
		IPath path = null; // ConverterUtils.getWorkspacePath(uri);
		if (uri == null) {
			return;
		}
		path = new Path(uri.toPlatformString(true));
		
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
		if (file.exists()) {
			if (editorId == null) {
				editorId = "org.eclipse.wst.xml.ui.internal.tabletree.XMLMultiPageEditorPart";				
			}
			
			openEditor(file, editorId);
		}
	}

	public static void openEditor(IPath path, String editorId) {
		if (path == null) {
			return;
		}
		
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
		if (file.exists()) {
			if (editorId == null) {
				editorId = "org.eclipse.wst.xml.ui.internal.tabletree.XMLMultiPageEditorPart";				
			}
			
			openEditor(file, editorId);
		}
	}

	public static void openEditor(EConfMLDocument resource, String editorId) {
		if (resource == null) {
			return;
		}
		Resource res = resource.eResource();
		openEditor(res, editorId);
	}

	private static void openEditor(Resource res, String editorId) {
		if (res == null) {
			return;
		}
		org.eclipse.emf.common.util.URI uri = res.getURI();
		if (!uri.isPlatform()) {
			return;
		}
		
		String[] segments = uri.segments();
		IPath path = Path.EMPTY;
		for (int i= 1; i< segments.length;i++) {
			path = path.append(segments[i]);
		}
		
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);

		openEditor(file, editorId);
	}

	private static void openEditor(IFile file,
			String editorId) {

		if (file != null && editorId != null) {
			try {
				IEditorDescriptor descr =PlatformUI.getWorkbench().getEditorRegistry().findEditor(editorId);
				if (descr == null) {
					descr =PlatformUI.getWorkbench().getEditorRegistry().findEditor("org.eclipse.ui.DefaultTextEditor");
				}
				
				if (descr != null) {
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
							.openEditor(new FileEditorInput(file),
									descr.getId());
				}
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
	}
	
	public static EConfMLDocument getConfMLResource(EObject obj) {
		EObject ptr = obj;
//		if (obj instanceof EAppView) {
//			ptr = ((EAppView) obj).getDefinition();
//		} else if (obj instanceof EAppGroup) {
//			EGroup group = ((EAppGroup) obj).getDefinition();
//			ptr = group;
//		} else if (obj instanceof EAppSettingRef) {
//			ptr = ((EAppSettingRef) obj).getDefinition();
//		} else {
//			ptr = obj;
//		}
		while (ptr != null && !(ptr instanceof EConfMLDocument)) {
			ptr = ptr.eContainer();
		}

		return (EConfMLDocument) ptr;
	}

}
