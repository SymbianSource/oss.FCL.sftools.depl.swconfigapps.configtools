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
 * Description: This file is part of com.nokia.tools.vct.cli component.
 */

package com.nokia.tools.vct.cli;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionGroup;
import org.apache.commons.cli.Options;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;

public class CommandLineUtils {
	static final String EXTENSION_NAMESPACE = "com.nokia.tools.vct.cli.commandline";
	static final String ELEMENT_HANDLER = "handler";
	static final String ELEMENT_OPTION = "option";
	static final String ELEMENT_OPTION_GROUP = "optionGroup";
	static final String HANDLER_ATTR_CLASS = "class";
	static final String HANDLER_ATTR_APPLICATION_ID = "applicationId";
	static final String OPTION_ATTR_LONG_NAME = "longName";
	static final String OPTION_ATTR_SHORT_NAME = "shortName";
	static final String OPTION_ATTR_HAS_ARG = "hasArg";
	static final String OPTION_ATTR_DESCRIPTION = "description";

	static final String OPTION_GROUP_ATTR_REQUIRED = "required";
	
	public static void initOptions(Options options) {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		
		IExtension[] extensions = registry.getExtensionPoint(EXTENSION_NAMESPACE).getExtensions();
		for (IExtension extension: extensions) {
			for (IConfigurationElement element: extension.getConfigurationElements()) {
				if (ELEMENT_OPTION.equals(element.getName())) {
					Option option = makeOption(element);
					options.addOption(option);
				} else if (ELEMENT_OPTION_GROUP.equals(element.getName())) {
					OptionGroup optionGroup = new OptionGroup();
					boolean required = Boolean.TRUE.equals(element.getAttribute(OPTION_GROUP_ATTR_REQUIRED));
					optionGroup.setRequired(required);
					for (IConfigurationElement element2: element.getChildren(ELEMENT_OPTION)) {
						Option option = makeOption(element2);
						optionGroup.addOption(option);
					}
					options.addOptionGroup(optionGroup);
				}
			}
		}
	}
	public static List<ICommandLineHandler> getHandlers(String applicationId) {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		List<ICommandLineHandler> handlers = new ArrayList<ICommandLineHandler>();
		
		IExtension[] extensions =registry.getExtensionPoint(EXTENSION_NAMESPACE).getExtensions();
		for (IExtension extension: extensions) {
			for (IConfigurationElement element: extension.getConfigurationElements()) {
				if (ELEMENT_HANDLER.equals(element.getName())) {
					Object exec;
					try {
						exec = element.createExecutableExtension(HANDLER_ATTR_CLASS);
						if (exec instanceof ICommandLineHandler) {
							String applicationIdAttr = element.getAttribute(HANDLER_ATTR_APPLICATION_ID);
							// check for applicationId
							if (applicationIdAttr != null && applicationIdAttr.equals(applicationId)) {
								handlers.add((ICommandLineHandler)exec);
							}
						}
					} catch (CoreException e) {
						
						e.printStackTrace();
					}
				}
			}
		}
		return handlers;
	}

	private static Option makeOption(IConfigurationElement element) {
		String longName = element.getAttribute(OPTION_ATTR_LONG_NAME);
		String shortName = element.getAttribute(OPTION_ATTR_SHORT_NAME);
		String description = element.getAttribute(OPTION_ATTR_DESCRIPTION);
		boolean hasArg = Boolean.TRUE.equals(element.getAttribute(OPTION_ATTR_HAS_ARG));
		
		Option option = new Option(shortName, longName, hasArg, description);
		return option;
	}
}

