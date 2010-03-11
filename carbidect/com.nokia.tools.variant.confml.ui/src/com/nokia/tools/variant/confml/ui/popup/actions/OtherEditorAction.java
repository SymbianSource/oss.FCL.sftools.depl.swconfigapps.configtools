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

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.dialogs.EditorSelectionDialog;
import org.eclipse.ui.ide.IDE;

import com.nokia.tools.variant.confml.ui.ConfmlUI;
import com.nokia.tools.vct.common.appmodel.EAppGroup;
import com.nokia.tools.vct.common.appmodel.EAppSettingRef;
import com.nokia.tools.vct.common.appmodel.EAppView;
import com.nokia.tools.vct.common.ui.utils.SWTUtil;
import com.nokia.tools.vct.confml.model.confml1.EConfMLDocument;

public class OtherEditorAction implements IViewActionDelegate, IObjectActionDelegate {

	private ISelection selection;
	private IWorkbenchPart iViewPart;
	private IFile file;

	public void init(IViewPart view) {
		this.iViewPart = view;
	}

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		if (iViewPart == null)
			iViewPart =  targetPart;
	}

	public void run(IAction action) {

		if (!(selection instanceof IStructuredSelection) || selection == null
				|| iViewPart == null) {
			return;
		}

		IStructuredSelection iStructuredSelection = (IStructuredSelection) selection;
		Object firstElement = iStructuredSelection.getFirstElement();

		if (firstElement instanceof EConfMLDocument) {
			throw new UnsupportedOperationException();
		} else if (firstElement instanceof EAppSettingRef
				|| firstElement instanceof EAppGroup
				|| firstElement instanceof EAppView) {
			throw new UnsupportedOperationException();
		}

		EditorSelectionDialog editorSelectionDialog = new EditorSelectionDialog(
				iViewPart.getSite().getShell());
		editorSelectionDialog.open();
		final String selectedEditorID = editorSelectionDialog
				.getSelectedEditor().getId();

		if (file != null) {
			Display display = iViewPart.getSite().getShell().getDisplay();

			display.asyncExec(new Runnable() {
				public void run() {
					final IWorkbenchPage activePage = SWTUtil.getActivePage();
					if (activePage != null) {
						try {
							IDE.openEditor(activePage, file, selectedEditorID);
						} catch (PartInitException e) {
							ConfmlUI.logWarning(e);
						}
					}
				}
			});
		}
	}

	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}

}
