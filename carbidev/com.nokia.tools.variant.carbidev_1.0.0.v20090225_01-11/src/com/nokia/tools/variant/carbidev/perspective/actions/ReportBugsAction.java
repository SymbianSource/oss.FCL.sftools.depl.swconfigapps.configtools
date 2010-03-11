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

package com.nokia.tools.variant.carbidev.perspective.actions;

import java.net.URL;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.browser.IWorkbenchBrowserSupport;

/**
 * Open external browser for bug reporting.
 *
 */
public class ReportBugsAction implements IWorkbenchWindowActionDelegate {

	private static final String TARGET_URL = "https://s60wiki.nokia.com/S60Wiki/Carbide.v#Reporting_Defects";
	private IWorkbenchWindow window;

	public void dispose() {
	}

	public void init(IWorkbenchWindow window) {
		this.window = window;
	}

	public void run(IAction action) {
		IWorkbenchBrowserSupport support = window.getWorkbench()
		.getBrowserSupport();
		try {
			support.getExternalBrowser().openURL(new URL(TARGET_URL));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectionChanged(IAction action, ISelection selection) {
	}
}
