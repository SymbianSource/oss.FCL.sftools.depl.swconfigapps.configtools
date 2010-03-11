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
package com.nokia.s60ct.actions;

import org.eclipse.core.internal.resources.Marker;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import cenrep.util.CenrepResourceImpl;

import com.nokia.s60ct.general.ValidationPlugin;
import com.nokia.s60ct.messages.ValidationMessages;

public class BatchValidationDelegate implements IObjectActionDelegate
{

	/**
	 * The shell this action is hosted in
	 */
	protected static Shell shell = null;


	private EObject selectedEObject = null;

	
	public BatchValidationDelegate() {
	}

	

	public void selectionChanged(IAction action, ISelection selection) {
		this.selectedEObject = null;
		try {
			if (selection instanceof IStructuredSelection) {
				IStructuredSelection structuredSelection = (IStructuredSelection) selection;
				if (structuredSelection.getFirstElement() instanceof CenrepResourceImpl) {
						CenrepResourceImpl crImpl = (CenrepResourceImpl)structuredSelection.getFirstElement();
						if (!crImpl.getContents().isEmpty())
							this.selectedEObject = (EObject)crImpl.getContents().get(0); //always only one leaf?
				} else if (structuredSelection.getFirstElement() instanceof Marker) {
						this.selectedEObject = null;
				} else this.selectedEObject = (EObject)structuredSelection.getFirstElement();
			}
		} catch (Exception e) {
			// Exceptions are not expected
			MessageDialog.openInformation(shell,ValidationMessages.BatchValidationDelegate_title, ValidationMessages.message_exception);
			throw new RuntimeException(e);
		} finally {
			action.setEnabled(this.selectedEObject!=null);
		}
	}
	

	@Override
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		shell = targetPart.getSite().getShell();
	}


	public void run(IAction action) 
	{	
		ValidationPlugin.getValidator().validateSelected(selectedEObject);
	}

	
}
