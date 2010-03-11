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
 * Description: This file is part of com.nokia.tools.variant.generate component.
 */

package com.nokia.tools.carbidect.cone.ui;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class ConeUIPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.nokia.tools.carbidect.cone.ui";

	// The shared instance
	private static ConeUIPlugin plugin;
	
	/**
	 * The constructor
	 */
	public ConeUIPlugin() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
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
	public static ConeUIPlugin getDefault() {
		return plugin;
	}

	private MessageConsole console = null;

	private class ConeSchedulingRule implements ISchedulingRule {

		public boolean contains(ISchedulingRule rule) {
			if(rule instanceof ConeSchedulingRule) {
				return true;
			}
			return false;
		}

		public boolean isConflicting(ISchedulingRule rule) {
			if(rule instanceof ConeSchedulingRule) {
				return true;
			}
			return false;
		}
		
	};
	
	private ISchedulingRule coneRule = new ConeSchedulingRule();
	
	public ISchedulingRule getConeRule() {
		return coneRule;
	}

	public MessageConsole getConsole() {
		if(console==null) {
			console = new MessageConsole("ConE", null);
			IConsole[] consoles = new IConsole[] { console };
			ConsolePlugin.getDefault().getConsoleManager().addConsoles(
					consoles);
			console.activate();
		}
		return console;
	}
	
    public static final String IMAGE_ID_MAIN_TAB =  "tab.main";
    public static final String IMAGE_ID_ARGUMENTS_TAB =  "tab.arguments";

	@Override
	protected void initializeImageRegistry(ImageRegistry reg) {
      super.initializeImageRegistry(reg);

      ImageDescriptor image = ImageDescriptor.createFromURL(
            FileLocator.find(getBundle(),
                             new Path("icons/args.gif"),
                                      null));
      reg.put(IMAGE_ID_ARGUMENTS_TAB, image);

      image = ImageDescriptor.createFromURL(
    		  FileLocator.find(getBundle(),
    				  new Path("icons/main.gif"),
    				  null));
      reg.put(IMAGE_ID_MAIN_TAB, image);
	}

}
