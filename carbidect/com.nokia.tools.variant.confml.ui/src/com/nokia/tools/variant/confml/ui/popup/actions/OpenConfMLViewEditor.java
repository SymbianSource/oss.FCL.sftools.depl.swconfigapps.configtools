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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPart;

import com.nokia.tools.variant.confml.ui.ConfmlUI;
import com.nokia.tools.variant.confml.ui.editors.EditorUtils;
import com.nokia.tools.vct.common.appmodel.EAppGroup;
import com.nokia.tools.vct.common.appmodel.EAppView;
import com.nokia.tools.vct.common.core.utils.ArrayUtils;
import com.nokia.tools.vct.confml.model.confml1.EGroup;
import com.nokia.tools.vct.confml.model.confml1.EViewElement;

public class OpenConfMLViewEditor implements IObjectActionDelegate {

	private ISelection selection;
	private IWorkbench workbench;

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		workbench = targetPart.getSite().getWorkbenchWindow().getWorkbench();
	}

	public void run(IAction action) {

		if (!(selection instanceof IStructuredSelection) || selection == null
				|| workbench == null) {
			return;
		}
		Object obj = ((IStructuredSelection) selection).getFirstElement();

		String editorId = null;
		URI uri = null;
		if (obj instanceof EAppView) {
			uri = ArrayUtils.getLast(((EAppView) obj).getUri());
		} else if (obj instanceof EAppGroup) {
			EObject ptr = (EAppGroup) obj;
			while (ptr instanceof EAppGroup) {
				ptr = ptr.eContainer();
			}
			if (ptr instanceof EAppView) {
				uri = ArrayUtils.getLast(((EAppView) ptr).getUri());
			}
		} else if (obj instanceof EGroup
				|| obj instanceof com.nokia.tools.vct.confml.model.confml2.EGroup
				|| obj instanceof EViewElement
				|| obj instanceof com.nokia.tools.vct.confml.model.confml2.EViewElement) {
			EObject eobj = (EObject) obj;
			uri = eobj.eResource().getURI();
		}

		if (uri != null) {
			uri = uri.trimFragment();
			editorId = ConfmlUI.VIEW_EDITOR_ID;
			EditorUtils.openEditor(uri, editorId);
		}
	}

	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}

}
