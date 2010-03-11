/*******************************************************************************
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
 ******************************************************************************/
package com.nokia.tools.variant.carbidev;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

import com.nokia.tools.vct.cli.GenericApplication;

public class CarbideVCLIApplication extends GenericApplication implements IApplication {
	
	public CarbideVCLIApplication() {
		// application id = com.nokia.tools.variant.carbidev.CarbideVCLIApplication
		super("com.nokia.tools.variant.carbidev.CarbideVCLIApplication");
	}
	
	public Object start(IApplicationContext context) throws Exception {
		return super.start(context);
	}

	public void stop() {
		final IWorkbench workbench = PlatformUI.getWorkbench();
		if (workbench != null) {
			final Display display = workbench.getDisplay();
			display.syncExec(new Runnable() {
				public void run() {
					if (!display.isDisposed())
						workbench.close();
				}
			});
		}
		super.stop();
	}
}