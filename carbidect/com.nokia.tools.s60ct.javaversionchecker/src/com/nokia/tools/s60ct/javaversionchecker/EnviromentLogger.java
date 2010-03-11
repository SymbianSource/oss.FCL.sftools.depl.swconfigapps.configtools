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
package com.nokia.tools.s60ct.javaversionchecker;

import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;


/**
 * Environment logger.
 * 
 */
public class EnviromentLogger {

	private static final String[] loggedSystemEnvs = {"os.name", "os.version", "java.vendor",
			"java.vm.version", "java.home", "java.runtime.version", "java.specification.version", "sun.boot.class.path",
			"java.class.path", "eclipse.commands", "eclipse.buildId"   };

	public static void logEnvironment() {

		try {
			ILog logger = Activator.getDefault().getLog();
			StringBuffer sb = new StringBuffer();
			sb.append("\n");
			
			for (int i = 0; i < loggedSystemEnvs.length; i++) {
				sb.append(loggedSystemEnvs[i]);
				sb.append('=');
				try {
					sb.append(JavaVersionChecker.getSystemPropertyValue(loggedSystemEnvs[i]));
				} catch (Exception e) {
					sb.append("unknown");
				} finally {
					sb.append("\n");
				}
			}
			Status status = new Status(IStatus.INFO, Activator.PLUGIN_ID, sb.toString());
			logger.log(status);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}
}
