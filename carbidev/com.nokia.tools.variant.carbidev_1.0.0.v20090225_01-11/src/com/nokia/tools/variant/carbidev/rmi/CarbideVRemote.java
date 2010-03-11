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
 * Description: This file is part of com.nokia.tools.variant.carbidev component.
 */

package com.nokia.tools.variant.carbidev.rmi;

import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import org.eclipse.core.runtime.Platform;

public class CarbideVRemote
    extends UnicastRemoteObject
    implements ICarbideVRemote {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3247400831689897904L;

	public static final String name = "CarbideVRemote";

	public static final int port = 59187;

	private static volatile boolean initialized;

	private static volatile OpenCpfThread openCpfThread;

	private CarbideVRemote() throws RemoteException {
		super();
	}

	private static Registry getRegistry() {
		init();

		Registry registry = null;
		try {
			registry = LocateRegistry.getRegistry(port);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		return registry;
	}

	private static Registry createRegistry() {
		init();

		Registry registry = null;
		try {
			registry = LocateRegistry.createRegistry(port);
		} catch (RemoteException e1) {
			// registry already running or it can't be created
		}

		return registry;
	}

	public static boolean bind() {
		init();

		try {

			Registry registry = createRegistry();

			if (registry == null || getRemote() != null) {
				// some instance is already binded
				return false;
			}

			try {

				CarbideVRemote carbideVRemote = new CarbideVRemote();

				registry.rebind(name, carbideVRemote);
				System.out.println("CarbideVRemote successfully registered as "
				    + name);

				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	private static void init() {
		if (initialized) {
			return;
		}
		initialized = true;

		try {

			URL policy = Platform.getInstallLocation().getURL();
			File policyFile = new File(policy.getFile(), "server.policy");

			if (!policyFile.exists()) {
				// recreate policy file if doesn't exists
				FileWriter fw = new FileWriter(policyFile);
				fw
				    .write("grant {\n// Allow everything for now\npermission java.security.AllPermission;\n};");
				fw.close();
			}

			System.setProperty("java.security.policy", policyFile
			    .getAbsolutePath());

			if (System.getSecurityManager() == null) {
				System.setSecurityManager(new RMISecurityManager());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ICarbideVRemote getRemote() {
		init();

		try {
			Registry registry = getRegistry();

			if (registry != null) {
				try {
					ICarbideVRemote remote = (ICarbideVRemote) registry
					    .lookup(name);
					return remote;
				} catch (Exception e) {
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Open CPF file at specified location (path)
	 * 
	 * @param path absolute path in filesystem to cpf file
	 * @throws RemoteException
	 */
	public void openCpf(final String path) throws RemoteException {
		if (path == null) {
			return;
		}

		if (openCpfThread == null) {
			openCpfThread = new OpenCpfThread();
			openCpfThread.start();
		}

		openCpfThread.openCPF(path);
	}
}
