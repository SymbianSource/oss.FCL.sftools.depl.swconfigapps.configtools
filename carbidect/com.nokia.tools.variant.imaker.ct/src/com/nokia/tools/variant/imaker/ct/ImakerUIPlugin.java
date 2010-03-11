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
 * Description: This file is part of com.nokia.tools.variant.imaker.ct component.
 */

package com.nokia.tools.variant.imaker.ct;

import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;


/**
 * The activator class controls the plug-in life cycle
 */
public class ImakerUIPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.nokia.tools.variant.imaker.ct";

	// The shared instance
	private static ImakerUIPlugin plugin;
	
	/**
	 * The constructor
	 */
	public ImakerUIPlugin() {}

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
	public static ImakerUIPlugin getDefault() {
		return plugin;
	}

	private MessageConsole console = null;

	private class ImakerSchedulingRule implements ISchedulingRule {

		public boolean contains(ISchedulingRule rule) {
			if(rule instanceof ImakerSchedulingRule) {
				return true;
			}
			return false;
		}

		public boolean isConflicting(ISchedulingRule rule) {
			if(rule instanceof ImakerSchedulingRule) {
				return true;
			}
			return false;
		}
		
	};
	
	private ISchedulingRule imakerRule = new ImakerSchedulingRule();
	
	public ISchedulingRule getImakerRule() {
		return imakerRule;
	}

	public MessageConsole getConsole() {
		if(console==null) {
			console = new MessageConsole("iMaker", null);
			IConsole[] consoles = new IConsole[] { console };
			ConsolePlugin.getDefault().getConsoleManager().addConsoles(
					consoles);
			console.activate();
		}
		return console;
	}
}
