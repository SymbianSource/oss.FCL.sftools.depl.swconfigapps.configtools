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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPart;

import com.nokia.tools.variant.confml.ui.editors.EditorUtils;
import com.nokia.tools.vct.confml.model.confml1.EConfMLDocument;

public class OpenConfMLMetadataEditor implements IViewActionDelegate,
		IObjectActionDelegate {

	private ISelection selection;
	private IViewPart iViewPart;
	private IWorkbench workbench;

	public void init(IViewPart view) {
		this.iViewPart = view;
		this.workbench = iViewPart.getSite().getWorkbenchWindow()
				.getWorkbench();

	}

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		if (workbench == null)
			workbench = targetPart.getSite().getWorkbenchWindow()
					.getWorkbench();
	}

	public void run(IAction action) {

		if (!(selection instanceof IStructuredSelection) || selection == null
				|| workbench == null) {
			return;
		}
		Object obj = ((IStructuredSelection) selection).getFirstElement();

		String editorId = null;

		EConfMLDocument res = null;
		
		if (obj instanceof EObject) {
			res = EditorUtils.getConfMLResource((EObject) obj);
			editorId = "com.nokia.tools.variant.confml.ui.confmlmetadataeditor";
		} else {
			// showMessage("Double-click detected on " + obj.toString());
		}
		EditorUtils.openEditor(res, editorId);
	}

	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}
}
