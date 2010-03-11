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

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.WorkbenchWindow;

@SuppressWarnings("restriction")
public class StatusbarAction implements IWorkbenchWindowActionDelegate {

	public void dispose() {
		
	}

	public void init(IWorkbenchWindow window) {
		
	}

	public void run(IAction action) {
		
		IWorkbench workbench = PlatformUI.getWorkbench();
		WorkbenchWindow workbenchWindow = (WorkbenchWindow) workbench.getActiveWorkbenchWindow();
		
		if(action.isChecked()) {
			
			workbenchWindow.setStatusLineVisible(true);
			
		} else {
			
			workbenchWindow.setStatusLineVisible(false);
			
		}
		
		workbenchWindow.getShell().layout();
		
	}

	public void selectionChanged(IAction action, ISelection selection) {
		
	}

}
