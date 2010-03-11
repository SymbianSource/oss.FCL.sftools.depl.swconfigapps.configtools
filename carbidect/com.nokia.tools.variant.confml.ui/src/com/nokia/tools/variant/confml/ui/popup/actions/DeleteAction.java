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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbench;

public class DeleteAction implements IViewActionDelegate {

	private ISelection selection;
	private IViewPart iViewPart;
	private IWorkbench workbench;

	public void run(IAction action) {

		if (!(selection instanceof IStructuredSelection) || selection == null
				|| workbench == null) {
			return;
		}

		List<EObject> list = new ArrayList<EObject>();
		IStructuredSelection iStructuredSelection = (IStructuredSelection) selection;

		Object[] selected = iStructuredSelection.toArray();
		for (Object o : selected) {
			if (o instanceof EObject) {
				list.add((EObject) o);
			}
		}
		IResource[] projects = null;

		Object firstElement = iStructuredSelection.getFirstElement();

		// if (firstElement instanceof EConfMLResource) {
		//			
		// EConfMLResource eConfMLResource = (EConfMLResource) firstElement;
		// EVariantProject container = (EVariantProject) eConfMLResource
		// .eContainer();
		//			
		// if (container != null) {
		//				
		// IFile iFile = container.getProject().getFile(
		// eConfMLResource.getPath());
		// try {
		// projects=iFile.getProject().members();
		// } catch (CoreException e) {
		// 
		// e.printStackTrace();
		// }
		//
		// }
		//
		// }
		//
		// DeleteProjectDialog d = new
		// DeleteProjectDialog(iViewPart.getViewSite()
		// .getShell(), projects);
		// d.open();

		if (!list.isEmpty()) {
			MessageBox mb = new MessageBox(Display.getCurrent()
					.getActiveShell(), SWT.ICON_QUESTION | SWT.YES | SWT.NO);
			mb.setMessage("Do you want to delete this project(s)? \n(It will be removed from workspace, the action is undone)");
			mb.setText("Delete confirmation");
			int answer = mb.open();
			if (answer == SWT.YES) {
				DeleteCommand deleteCommand = new DeleteCommand(list);
				deleteCommand.execute();
				iViewPart.getViewSite().getShell().layout(true, true);
			}
		}

	}

	public void init(IViewPart view) {
		this.iViewPart = view;
		this.workbench = view.getSite().getWorkbenchWindow().getWorkbench();
	}

	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}
}
