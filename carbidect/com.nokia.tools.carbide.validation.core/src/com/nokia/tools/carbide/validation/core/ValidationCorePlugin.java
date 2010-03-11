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
 * Description: This file is part of com.nokia.tools.carbide.validation.core component.
 */

package com.nokia.tools.carbide.validation.core;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class ValidationCorePlugin extends AbstractUIPlugin {

	public static final String PLUGIN_ID = "com.nokia.tools.carbide.validation.core";
	
	private static ValidationCorePlugin defPlugin;

	private ResourceBundle resourceBundle;

	public ValidationCorePlugin() {
		super();
		defPlugin = this;
		try {
			resourceBundle = ResourceBundle
					.getBundle(PLUGIN_ID);
		} catch (MissingResourceException x) {
			resourceBundle = null;
		}
	}

	@Override
	public void start(BundleContext context) throws Exception {
		// PreferencesHint.registerPreferenceStore(
		// new PreferencesHint("LogicEditor"), getPreferenceStore());

		super.start(context);
	}

	public static ValidationCorePlugin getDefault() {
		return defPlugin;
	}

	/**
	 * @return the plugin's resource bundle.
	 */
	public ResourceBundle getResourceBundle() {
		return resourceBundle;
	}

	public ValidationStatus getSeverity(String type) {
		try {
			return ValidationStatus.valueOf(getPreferenceStore()
					.getString(type));
		} catch (IllegalArgumentException iae) {
			return ValidationStatus.ERROR;
		}

	}

	public static void logError(String message, Throwable cause) {
		getDefault().getLog().log(new Status(IStatus.ERROR, PLUGIN_ID, message, cause));
	}
}
