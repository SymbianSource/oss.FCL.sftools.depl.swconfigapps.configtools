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
package com.nokia.tools.s60ct.report;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.nokia.tools.s60ct.report.dialog.ReportDialog;

/**
 * The activator class controls the plug-in life cycle
 */
public class ReportPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.nokia.tools.s60ct.report";

	// The shared instance
	private static ReportPlugin plugin;
	
	private static IProject selectedProject;

	public static final String IMAGE_REPORT_EXP = "REPORT_EXP";
	public static final String IMAGE_REPORT_TLB = "REPORT_TLB";
	
	/**
	 * The constructor
	 */
	public ReportPlugin() {
	}

	public static IProject getSelectedProject() {
		return selectedProject;
	}
	
	public static void setSelectedProject(IProject selectedProject) {
		System.out.println("Selected project set:" + selectedProject.toString());
		ReportPlugin.selectedProject = selectedProject;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
	 * )
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		plugin.getPreferenceStore().putValue(ReportDialog.PROP_FILE_PATH, "");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
	 * )
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static ReportPlugin getDefault() {
		return plugin;
	}
	
	@Override
	protected void initializeImageRegistry(ImageRegistry reg) {
		reg.put(IMAGE_REPORT_EXP, imageDescriptorFromPlugin(PLUGIN_ID, "icons/report_exp.gif"));
		reg.put(IMAGE_REPORT_TLB, imageDescriptorFromPlugin(PLUGIN_ID, "icons/report_16_tlb.gif"));

		super.initializeImageRegistry(reg);
	}
	
	public static Image getImage(String key) {
		return plugin.getImageRegistry().get(key);
	}
	
	
	
}
