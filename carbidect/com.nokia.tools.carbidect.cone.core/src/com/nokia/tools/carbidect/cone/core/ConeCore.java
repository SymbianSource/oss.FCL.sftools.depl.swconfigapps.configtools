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
package com.nokia.tools.carbidect.cone.core;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

import com.nokia.tools.carbidect.cone.core.actions.IConeAction;
import com.nokia.tools.carbidect.cone.core.actions.IGenerateAction;
import com.nokia.tools.carbidect.cone.core.actions.IInfoAction;
import com.nokia.tools.carbidect.cone.core.internal.actions.GenerateAction;
import com.nokia.tools.carbidect.cone.core.internal.actions.InfoAction;

/**
 * The activator class controls the plug-in life cycle
 */
public class ConeCore extends Plugin {
	
	private final static String[] VERBOSES = new String[] {
			"NONE",
			"CRITICAL",
			"ERROR",
			"WARNING",
			"INFO",			
			"DEBUG",			
	};

	private final static String[] TARGETS = new String[] {
		"ROFS2",
		"ROFS3",
		"UDA",
	};


	// The plug-in ID
	public static final String PLUGIN_ID = "com.nokia.tools.variant.cone.core";

	// The shared instance
	private static ConeCore plugin;
	
	/**
	 * The constructor
	 */
	public ConeCore() {}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
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
	public static ConeCore getDefault() {
		return plugin;
	}

	/**
	 * This method create cone action of the specified type and returns
	 * @param key
	 * @return null if action implementation not found
	 */
	@SuppressWarnings("unchecked")
	public IConeAction createConeAction(Class key) {
		IConeAction action = null;
		if(key.equals(IGenerateAction.class)) {
			action = new GenerateAction();
		} else if (key.equals(IInfoAction.class)) {
			action = new InfoAction();			
		} else {}
		return action;
	}
	
	/**
	 * @return
	 */
	public static String[] getConeVerboseList() {
		return VERBOSES;
	}

	public static String[] getConeTargetsList() {
		return TARGETS;
	}
}
