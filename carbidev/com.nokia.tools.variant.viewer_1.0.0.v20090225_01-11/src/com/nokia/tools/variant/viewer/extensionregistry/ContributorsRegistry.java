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
 * Description: This file is part of com.nokia.tools.variant.viewer component.
 */

package com.nokia.tools.variant.viewer.extensionregistry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;

import com.nokia.tools.variant.viewer.Activator;
import com.nokia.tools.variant.viewer.actions.EditorAction;

public class ContributorsRegistry {
	private static final String CONTRIBUTOR_EXTENSION_POINT = "com.nokia.tools.variant.editor.widget";
	private static final String ACTION = "action";
	private static final String WIDGET_CLASS = "widget_class";
	private static final String CONTRIBUTOR_CLASS = "class";
	private Map<String, List<Class<EditorAction>>> contributors;
	private static ContributorsRegistry instance;

	private ContributorsRegistry() {
		init();
	}

	public static ContributorsRegistry getInstance() {
		if (instance == null) {
			instance = new ContributorsRegistry();
		}
		return instance;
	}

	private void init() {
		contributors = new HashMap<String, List<Class<EditorAction>>>();
		if ( Platform.isRunning()) {
			IExtensionPoint extensionPoint = Platform.getExtensionRegistry()
					.getExtensionPoint(CONTRIBUTOR_EXTENSION_POINT);
			if (extensionPoint != null) {
				final IExtension[] extensions = extensionPoint.getExtensions();
				for (int i = 0; i < extensions.length; i++) {
					final IConfigurationElement[] configElements = extensions[i]
							.getConfigurationElements();
					for (int j = 0; j < configElements.length; j++) {
						parseRule(configElements[j]);
					}
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	private void parseRule(IConfigurationElement configurationElement) {
		if (!configurationElement.getName().equals(ACTION)) {
			return;
		} else {
			String widgetClass = configurationElement
					.getAttribute(WIDGET_CLASS);
			if (widgetClass != null) {
				List<Class<EditorAction>> list = contributors.get(widgetClass);
				if (list == null) {
					list = new ArrayList<Class<EditorAction>>();
					contributors.put(widgetClass, list);
				}

				try {
					Class<EditorAction> editorActionClass;
					try {
						editorActionClass = (Class<EditorAction>)(configurationElement.createExecutableExtension(CONTRIBUTOR_CLASS).getClass());
						list.add(editorActionClass);
					} catch (CoreException e) {
					
						e.printStackTrace();
					}

				
				} catch (InvalidRegistryObjectException e) {
					Activator
							.getDefault()
							.getLog()
							.log(
									new Status(
											IStatus.ERROR,
											Activator.PLUGIN_ID,
											"Failed to activate contributor - "
													.concat(
															configurationElement
																	.getAttribute(CONTRIBUTOR_CLASS))
													.concat("\n").concat(
															e.getMessage())));
					e.printStackTrace();
				}
			}
		}

	}

	public List<Class<EditorAction>> getContributors(String widgetClassName) {
		return contributors.get(widgetClassName);
	}

}
