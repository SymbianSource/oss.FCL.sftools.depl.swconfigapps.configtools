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
 * Description: This file is part of com.nokia.tools.variant.confml.core component.
 */

package com.nokia.tools.variant.confml.core;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.content.IContentType;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.osgi.framework.BundleContext;

import com.nokia.tools.variant.confml.internal.core.ModelManager;
import com.nokia.tools.variant.confml.internal.core.project.ProjectVariantAdapter;
import com.nokia.tools.vct.common.appmodel.EConfMLLayer;
import com.nokia.tools.vct.common.appmodel.EConfigurationProject;

/**
 * The ConfML core plugin.
 * 
 * This class also provides functions to access ConfML models.
 */
public class ConfMLCore extends Plugin {

	public static final String CONFML_CONTENT_ID = "com.nokia.tools.vct.content.confml";

	// The plug-in ID
	public static final String PLUGIN_ID = "com.nokia.tools.variant.confml.core";

	public static final String CONFML_NATURE_ID = PLUGIN_ID
			+ ".ConfMLLayerNature";

	/** CONFML content type */
	public static final IContentType CONFML_CONTENT_TYPE= Platform.getContentTypeManager().getContentType(CONFML_CONTENT_ID);
	
	// The shared instance
	private static ConfMLCore plugin;

	private ProjectVariantAdapter projectAdapter;

	/**
	 * The constructor
	 */
	public ConfMLCore() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		
		getModelManager();
		getEditingDomain().runExclusive(new Runnable() {
			public void run() {
			}
		});

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
	    if (projectAdapter != null) {
    		projectAdapter.stop();
    		projectAdapter = null;
	    }
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static ConfMLCore getDefault() {
		return plugin;
	}

	/**
	 * Internal helper
	 * 
	 * @return Model manager instance
	 */
	private static ModelManager getModelManager() {
        EcorePackage.eINSTANCE.eClass();

        if (plugin.projectAdapter == null) {
            plugin.projectAdapter = new ProjectVariantAdapter();
            plugin.projectAdapter.start();
        }
        ModelManager.getModelManager();
	    
	    return ModelManager.getModelManager();
	}

	/**
	 * Get the project model. Project model combines both persistence and
	 * logical views.
	 * 
	 * @param project
	 *            Project to load model for
	 * @param monitor
	 *            Monitor
	 * @return Project model
	 */
	public static EConfigurationProject getProjectModel(IProject project) {
		return getModelManager().getProjectModel(project);
	}
	
	
	public static EConfMLLayer getLayer(IResource resource) {
		return getModelManager().getLayer(resource);
	}

	public static TransactionalEditingDomain getEditingDomain() {
		return getModelManager().getEditingDomain();
	}

	/**
	 * Log warning message
	 * 
	 * @param message
	 *            Message text
	 * @param cause
	 *            Message cause
	 */
	public static void logWarning(String message, Throwable cause) {
		log(IStatus.WARNING, message, cause);
	}

	/**
	 * Log message
	 * 
	 * @param severity
	 *            Severity to use.
	 * @param message
	 *            Message text
	 * @param cause
	 *            Message cause
	 * 
	 * @see IStatus
	 * @see ILog
	 */
	public static void log(int severity, String message, Throwable cause) {
		getDefault().getLog().log(
				new Status(severity, PLUGIN_ID, message, cause));
	}
}
