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
package com.nokia.tools.carbide.ct.ui.refactoring.internal.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ltk.core.refactoring.participants.RefactoringProcessor;
import org.eclipse.ltk.ui.refactoring.RefactoringWizardOpenOperation;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import com.nokia.tools.carbide.ct.ui.refactoring.internal.RenameConfmlProcessor;
import com.nokia.tools.carbide.ct.ui.refactoring.internal.RenameConfmlRefactoring;
import com.nokia.tools.carbide.ct.ui.refactoring.internal.wizards.RenameConfmlWizard;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class RenameHandler extends AbstractHandler {
	/**
	 * The constructor.
	 */
	public RenameHandler() {
	}

	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		ISelection selection = window.getSelectionService().getSelection();
		if(selection instanceof IStructuredSelection) {
			IStructuredSelection ss = (IStructuredSelection) selection;
			Object element = ss.getFirstElement();
			if(element instanceof IResource) {
				openWizard((IResource)element,window);
			}
		}
		return null;
	}
	
	private void openWizard(IResource resource, IWorkbenchWindow window) {
		RefactoringProcessor processor = new RenameConfmlProcessor(resource);
		RenameConfmlRefactoring ref = new RenameConfmlRefactoring( processor );
		RenameConfmlWizard wizard = new RenameConfmlWizard(ref);
		RefactoringWizardOpenOperation op 
		= new RefactoringWizardOpenOperation( wizard );
		try {
			String titleForFailedChecks = "Error"; //$NON-NLS-1$
			op.run( window.getShell(), titleForFailedChecks );
		} catch( final InterruptedException irex ) {
		}
	}	
	
}
