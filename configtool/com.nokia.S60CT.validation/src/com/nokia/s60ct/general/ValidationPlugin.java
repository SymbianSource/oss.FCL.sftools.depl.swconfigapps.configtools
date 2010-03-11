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
package com.nokia.s60ct.general;

import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.nokia.s60ct.validation.Activator;

public class ValidationPlugin extends AbstractUIPlugin {

//	 The shared instance.
	private static ValidationPlugin plugin;
	private static ValidatorGUI validatorGUI = null;
	private static ValidatorCLI validatorCLI = null;
	/**
	 * The constructor.
	 */
	public ValidationPlugin() {
		super();
		plugin = this;
		initValidatorCLI();
	}

	
	public static void initValidatorCLI()
	{
		validatorCLI = new ValidatorCLI();
	}
	
	public static ValidatorGUI getValidator()
	{
		if(validatorGUI==null){//init
			validatorGUI = new ValidatorGUI();
		}
		return validatorGUI;
	}
	public static ValidatorCLI getValidatorCLI()
	{
		return validatorCLI;
	}
	
	/**
	 * This method is called upon plug-in activation
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
	}

	/**
	 * This method is called when the plug-in is stopped
	 */
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
	}

	protected void initializeImageRegistry(ImageRegistry imageRegistry)
	{
		imageRegistry.put("error", Activator.getImageDescriptor("icons/error.gif"));
		imageRegistry.put("warning", Activator.getImageDescriptor("icons/warning.gif"));
		imageRegistry.put("information", Activator.getImageDescriptor("icons/information.gif"));
	}
	/**
	 * Returns the shared instance.
	 */
	public static ValidationPlugin getDefault() {
		return plugin;
	}

}
