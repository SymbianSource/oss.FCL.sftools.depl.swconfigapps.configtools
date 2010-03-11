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

package com.nokia.s60ct.gui;

import java.io.File;
import java.net.URL;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.PaletteData;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.ui.application.IWorkbenchConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchAdvisor;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.internal.ide.IDEInternalWorkbenchImages;
import org.eclipse.ui.internal.ide.IDEWorkbenchPlugin;
import org.eclipse.ui.internal.ide.model.WorkbenchAdapterBuilder;
import org.osgi.framework.Bundle;

import com.nokia.s60ct.gui.percpectives.Perspective;

public class ApplicationWorkbenchAdvisor extends WorkbenchAdvisor {

	

    private static final String INFO = "icons"+File.separator+"full"+File.separator+"obj16"+File.separator+"info_tsk.gif";
	private static final String WARNING = "icons"+File.separator+"full"+File.separator+"obj16"+File.separator+"warn_tsk.gif";
	private static final String ERROR = "icons"+File.separator+"full"+File.separator+"obj16"+File.separator+"error_tsk.gif";
	private static final String HIERARCHICAL_LAYOUT = "icons"+File.separator+"full"+File.separator+"elcl16"+File.separator+"hierarchicalLayout.gif";

	public WorkbenchWindowAdvisor createWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
        return new ApplicationWorkbenchWindowAdvisor(configurer);
    }

	public String getInitialWindowPerspectiveId() {
		return Perspective.ID;
	}
	
	
	
	
	private class MyImageDescriptor extends ImageDescriptor {
		ImageData data = null;
		public MyImageDescriptor(String path){
			data = Activator.getImageDescriptor(path).getImageData();
		}
		
		public ImageData getImageData() {
			return data;
		}
		
	}
	
	public void initialize(IWorkbenchConfigurer configurer) {
		
		super.initialize(configurer);
		
		/*Saving windows location and size
		 */
		configurer.setSaveAndRestore(true);
		configurer.declareImage(IDEInternalWorkbenchImages.IMG_ETOOL_PROBLEM_CATEGORY, new MyImageDescriptor(HIERARCHICAL_LAYOUT), true);
		configurer.declareImage(IDEInternalWorkbenchImages.IMG_OBJS_ERROR_PATH, new MyImageDescriptor(ERROR), true);
		configurer.declareImage(IDEInternalWorkbenchImages.IMG_OBJS_WARNING_PATH, new MyImageDescriptor(WARNING), true);
		configurer.declareImage(IDEInternalWorkbenchImages.IMG_OBJS_INFO_PATH, new MyImageDescriptor(INFO), true);
		
		WorkbenchAdapterBuilder.registerAdapters();
		 
		final String ICONS_PATH = "icons/full/";
		final String PATH_OBJECT = ICONS_PATH + "obj16/";
		Bundle ideBundle = Platform.getBundle(IDEWorkbenchPlugin.IDE_WORKBENCH);
		declareWorkbenchImage(configurer, ideBundle,
				IDE.SharedImages.IMG_OBJ_PROJECT, PATH_OBJECT + "prj_obj.gif",
				true);
		declareWorkbenchImage(configurer, ideBundle,
				IDE.SharedImages.IMG_OBJ_PROJECT_CLOSED, PATH_OBJECT
						+ "cprj_obj.gif", true);
	}
	
	private void declareWorkbenchImage(IWorkbenchConfigurer configurer_p,
			Bundle ideBundle, String symbolicName, String path, boolean shared) {
		URL url = ideBundle.getEntry(path);
		ImageDescriptor desc = ImageDescriptor.createFromURL(url);
		configurer_p.declareImage(symbolicName, desc, shared);
	}
	
	
	public IAdaptable getDefaultPageInput() {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		return workspace.getRoot();
	}
}
