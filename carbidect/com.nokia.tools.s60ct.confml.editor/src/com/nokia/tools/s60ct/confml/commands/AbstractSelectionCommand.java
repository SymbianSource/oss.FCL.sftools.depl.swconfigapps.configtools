/*
* Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies). 
* All rights reserved.
* This component and the accompanying materials are made available
* under the terms of "Eclipse Public License v1.0"
* which accompanies this distribution, and is available
* at the URL "http://www.eclipse.org/legal/epl-v10.html".
*
* Initial Contributors:
* Nokia Corporation - initial contribution.
*
* Contributors:
*
* Description:
*
*/

package com.nokia.tools.s60ct.confml.commands;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

public abstract class AbstractSelectionCommand extends AbstractCommand implements
		ISelectionCommand {

	public boolean isSelectionOK() {

		ISelectionProvider provider = getEditor();
		if (provider != null) {
			IStructuredSelection selection = (IStructuredSelection) provider
					.getSelection();
			if (!selection.isEmpty()
					&& selection.getFirstElement().equals(getModel())) {
				return true;
			} else {
				return false;
			}
		}

		return true;
	}

	public void select() {
		ISelectionProvider provider = getEditor();
		if (provider != null) {
			provider.setSelection(new StructuredSelection(getModel()));
		}
	}

	public abstract Object getModel();

	private ISelectionProvider getEditor() {
		IWorkbenchPage activePage = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage();
		if (activePage != null) {

			IEditorPart activeEditor = activePage.getActiveEditor();
			if (activeEditor instanceof ISelectionProvider) {
				return (ISelectionProvider) activeEditor;
			}
		}
		return null;
	}

	@Override
	protected boolean prepare() {
		return true;
	}

	public void execute() {
		
	}

	public void redo() {
		
	}
	
}
