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

package com.nokia.tools.variant.carbidev;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;

import com.nokia.tools.vct.cli.ICommandLineHandler;
import com.nokia.tools.vct.cli.StopException;

public class HelpHandler implements ICommandLineHandler {

	public HelpHandler() {
	}

	public void handleCommandLine(CommandLine commandLine, Options options) throws StopException {
		if (commandLine.hasOption('h') || commandLine.hasOption("help")) {
			new HelpFormatter().printHelp("carbidev <options> <file>", options);
		}
	}

}
