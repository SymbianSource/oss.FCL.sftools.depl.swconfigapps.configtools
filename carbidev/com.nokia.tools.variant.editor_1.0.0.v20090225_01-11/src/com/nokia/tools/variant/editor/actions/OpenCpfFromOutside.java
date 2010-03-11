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
 * Description: This file is part of com.nokia.tools.variant.editor component.
 */

package com.nokia.tools.variant.editor.actions;

import org.eclipse.core.runtime.internal.adaptor.EclipseEnvironmentInfo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IStartup;

/**
 * Invokes {@link OpenCpfAction} when user starts Carbide.V over cpf
 * association in operating system. {@link OpenCpfAction} is able to run
 * only after the workbench UI is initialized. {@link IStartup} provides this
 * functionality for us.
 * 
 */
@SuppressWarnings("restriction")
public class OpenCpfFromOutside implements IStartup {

	public void earlyStartup() {

		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				//Map<String, String> getenv = System.getenv();
				String[] nonFrameworkArgs = EclipseEnvironmentInfo.getDefault()
				    .getNonFrameworkArgs();
				if (nonFrameworkArgs.length > 0) {
					for (String arg : nonFrameworkArgs) {
						if (arg.toLowerCase().endsWith(".cpf")) {
							OpenCpfAction action = new OpenCpfAction();
							String filePath = arg;
							action.importProject(filePath);
							//break;
						}
					}
				}
			}
		});
	}

}
