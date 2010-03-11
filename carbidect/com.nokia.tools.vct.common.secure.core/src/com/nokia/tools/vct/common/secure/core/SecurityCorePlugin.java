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
 * Description: This file is part of com.nokia.tools.vct.common.secure.core component.
 */

package com.nokia.tools.vct.common.secure.core;

import java.security.Provider;

import javax.xml.crypto.dsig.XMLSignatureFactory;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

import com.nokia.tools.vct.internal.common.secure.core.KeyStoreManager;



/**
 * The activator class controls the plug-in life cycle
 */
public class SecurityCorePlugin extends Plugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.nokia.tools.vct.common.secure.core";

	// The shared instance
	private static SecurityCorePlugin plugin;

	private KeyStoreManager keyStoreManager;

	/**
	 * The constructor
	 */
	public SecurityCorePlugin() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		// Security.insertProviderAt(new BouncyCastleProvider(), 1);
		this.keyStoreManager = new KeyStoreManager();
		this.keyStoreManager.initialize();
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		this.keyStoreManager.release();
		this.keyStoreManager = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static SecurityCorePlugin getDefault() {
		return plugin;
	}

	public static IKeyStoreManager getKeyStoreManager() {
		return plugin.keyStoreManager;
	}
	

	public static XMLSignatureFactory getXMLSignatureFactory() {

		// First, create a DOM XMLSignatureFactory that will be used to 
		// generate the XMLSignature and marshal it to DOM.
		String providerName = System.getProperty
		    ("jsr105Provider", "org.jcp.xml.dsig.internal.dom.XMLDSigRI");
		XMLSignatureFactory factory;
		try {
			factory = XMLSignatureFactory.getInstance("DOM",
			    (Provider) Class.forName(providerName).newInstance());
		} catch (Exception e) {
			// IMPROVEMENT Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return factory;
	}
}
