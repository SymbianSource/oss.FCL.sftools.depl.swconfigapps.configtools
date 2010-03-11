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
 * Description: This file is part of com.nokia.tools.variant.confml.ui component.
 */

package com.nokia.tools.variant.confml.ui.popup.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

public class SaveAsAction implements IViewActionDelegate,
		IWorkbenchWindowActionDelegate {

	private ISelection selection;
	private IViewPart iViewPart;
	private IWorkbenchWindow iWorkbenchWindow;

	public void run(IAction action) {

		MessageDialog.openInformation(iViewPart.getSite().getShell(),
				"Save As", "eResource.save(null) ??");

	}

	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}

	public void dispose() {
		
	}

	public void init(IViewPart view) {
		this.iViewPart = view;
	}

	public void init(IWorkbenchWindow window) {
		this.iWorkbenchWindow = window;
	}
}
