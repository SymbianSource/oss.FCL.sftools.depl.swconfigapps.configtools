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
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;

public class PropertiesAction implements IViewActionDelegate {

	private ISelection selection;
	private IViewPart iViewPart;
	private IWorkbench iWorkbench;

	public void run(IAction action) {

		if (iWorkbench == null) {
			return;
		}

		IWorkbenchWindow window = iWorkbench.getActiveWorkbenchWindow();

		if (window != null) {
			IWorkbenchPage page = window.getActivePage();
			if (page != null) {
				IViewPart view = page.findView(IPageLayout.ID_PROP_SHEET);
				if (view == null) {
					// IWorkbenchPart activePart = page.getActivePart();
					try {
						view = page.showView(IPageLayout.ID_PROP_SHEET);
					} catch (PartInitException pie) {
					}
				} else {
					page.bringToTop(view);
					view.setFocus();
				}
			}
		}
	}

	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}

	public void init(IViewPart view) {
		this.iViewPart = view;
		this.iWorkbench = view.getSite().getWorkbenchWindow().getWorkbench();
	}

}
