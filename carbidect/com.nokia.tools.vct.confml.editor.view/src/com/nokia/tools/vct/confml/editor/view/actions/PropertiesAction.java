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
 * Description: This file is part of com.nokia.tools.vct.confml.editor.view component.
 */

package com.nokia.tools.vct.confml.editor.view.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

public class PropertiesAction extends Action {

	TreeViewer viewer;

	public PropertiesAction(TreeViewer viewer) {
		this.viewer = viewer;
		setText("&Show properties");
	}

	@Override
	public void run() {
		super.run();
		IWorkbench workbench = PlatformUI.getWorkbench();
		IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
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
}
