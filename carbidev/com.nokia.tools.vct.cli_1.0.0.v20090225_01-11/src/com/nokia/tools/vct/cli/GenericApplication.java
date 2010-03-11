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

import java.util.List;
import java.util.concurrent.Semaphore;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.Options;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;

public class GenericApplication implements IApplication {

	private Semaphore lock = new Semaphore(0);
	
	/**
	 * Application id for which are handlers applied
	 */
	private String applicationId;
	
	public GenericApplication(String applicationId) {
		this.applicationId = applicationId;
	}

	public Object start(IApplicationContext context) throws Exception {
		String[] args = (String[]) context.getArguments().get(
				IApplicationContext.APPLICATION_ARGS);

		Options options = new Options();
		CommandLineUtils.initOptions(options);

		CommandLineParser parser = new GnuParser();
		CommandLine cl = parser.parse(options, args);
		List<ICommandLineHandler> handlers = CommandLineUtils.getHandlers(applicationId);

		try {
			for (ICommandLineHandler handler : handlers) {
				try {
					handler.handleCommandLine(cl, options);
				} catch (StopException ex) {
					return ex.getExitCode();
				}
			}

			return EXIT_OK;
		} finally {
			lock.release();
		}
	}

	public void stop() {
		lock.acquireUninterruptibly();
	}
}
