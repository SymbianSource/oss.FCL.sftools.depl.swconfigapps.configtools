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

package com.nokia.tools.s60ct.confml.editor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.EMFPlugin;

import com.nokia.tools.s60ct.confml.actions.EditorAction;


public class ContributorsRegistry {
	private static final String CONTRIBUTOR_EXTENSION_POINT = "com.nokia.tools.s60ct.confml.editor.ConfmlEditorWidget";
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
		if (EMFPlugin.IS_ECLIPSE_RUNNING) {
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
					Class<EditorAction> editorActionClass = (Class<EditorAction>) Class
							.forName(configurationElement
									.getAttribute(CONTRIBUTOR_CLASS));
					list.add(editorActionClass);
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
				} catch (ClassNotFoundException e) {
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
