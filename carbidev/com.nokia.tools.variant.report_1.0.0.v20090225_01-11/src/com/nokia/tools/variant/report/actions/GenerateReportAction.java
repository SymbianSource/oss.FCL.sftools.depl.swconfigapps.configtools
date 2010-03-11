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
 * Description: This file is part of com.nokia.tools.variant.report component.
 */

package com.nokia.tools.variant.report.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.PlatformUI;

import com.nokia.tools.variant.editor.editors.CPFEditor;
import com.nokia.tools.variant.report.dialog.ReportDialog;

/**
 * Action which opens the report dialog
 */
public class GenerateReportAction implements IWorkbenchWindowActionDelegate,
		IPartListener {

	private ISelection selection;
	private IWorkbenchWindow window;

	private IAction fAction = null;

	public void dispose() {
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getPartService()
				.removePartListener(this);
	}

	public void init(IWorkbenchWindow window) {
		this.window = window;

		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getPartService()
				.addPartListener(this);
	}

	public void run(IAction action) {
		if (selection instanceof IStructuredSelection || selection == null) {

			ReportDialog dialog = new ReportDialog(window.getShell());

			dialog.create();
			dialog.open();
		}
	}

	public void selectionChanged(IAction action, ISelection selection) {
		if (fAction != action) {
			fAction = action;
		}
		handleEnable();

		this.selection = selection;
	}

	/**
	 * Takes the active editor and calculate whether to enable action and then
	 * do that enabling/disabling
	 */
	private void handleEnable() {
		if (fAction == null
				|| PlatformUI.getWorkbench().getActiveWorkbenchWindow() == null
				|| PlatformUI.getWorkbench().getActiveWorkbenchWindow()
						.getActivePage() == null) {
			return;
		}

		IEditorPart activeEditor = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage().getActiveEditor();

		if (activeEditor == null) {
			fAction.setEnabled(false);
		} else if (activeEditor instanceof CPFEditor) {
			CPFEditor container = (CPFEditor) activeEditor;

			if (container != null) {
				fAction.setEnabled(true);
			} else {
				fAction.setEnabled(false);
			}
		}
	}

	public void partActivated(IWorkbenchPart part) {
		handleEnable();

	}

	public void partBroughtToTop(IWorkbenchPart part) {

	}

	public void partClosed(IWorkbenchPart part) {
		handleEnable();

	}

	public void partDeactivated(IWorkbenchPart part) {

	}

	public void partOpened(IWorkbenchPart part) {

	}

}
