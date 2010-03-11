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

import java.rmi.RemoteException;
import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;

import com.nokia.tools.variant.carbidev.rmi.CarbideVRemote;
import com.nokia.tools.variant.carbidev.rmi.ICarbideVRemote;
import com.nokia.tools.vct.cli.ICommandLineHandler;
import com.nokia.tools.vct.cli.StopException;

public class CarbideRCPHandler implements ICommandLineHandler {

	public CarbideRCPHandler() {
		
	}

	public void handleCommandLine(CommandLine commandLine, Options options) throws StopException {
		if (commandLine.getOptions().length != 0) {
			return;
		}
		
		boolean binded = CarbideVRemote.bind();
		if (!binded) {
			// wait till remote carbidev is ready, but max. 10 second :-)
			int retry = 10;
			while (CarbideVRemote.getRemote() == null && retry > 0) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ie) {
				}
				retry--;
			}

			if (CarbideVRemote.getRemote() != null) {
				handleOpenedCarbide(commandLine.getArgList());
				throw new StopException(IApplication.EXIT_OK);
			}

		}

		Display display = PlatformUI.createDisplay();
		try {
			int returnCode = PlatformUI.createAndRunWorkbench(display,
					new ApplicationWorkbenchAdvisor());

			if (returnCode == PlatformUI.RETURN_RESTART)
				throw new StopException(IApplication.EXIT_RESTART);
			else
				throw new StopException(IApplication.EXIT_OK);

		} finally {
			display.dispose();
		}
	}
	

	private void handleOpenedCarbide(List<?> list) {
		String[] nonFrameworkArgs = (String[])list.toArray(new String[list.size()]);
		if (nonFrameworkArgs.length > 0) {
			for (String arg : nonFrameworkArgs) {
				if (arg.toLowerCase().endsWith(".cpf")) {
					ICarbideVRemote remoteCarbideV = CarbideVRemote.getRemote();
					if (remoteCarbideV != null) {
						try {
							remoteCarbideV.openCpf(arg);
						} catch (RemoteException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

}
