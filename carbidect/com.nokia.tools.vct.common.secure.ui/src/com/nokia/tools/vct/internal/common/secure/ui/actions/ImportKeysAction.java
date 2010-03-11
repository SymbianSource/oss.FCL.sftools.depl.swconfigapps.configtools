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

package com.nokia.tools.vct.internal.common.secure.ui.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;

import com.nokia.tools.vct.internal.common.secure.ui.wizards.ImportKeysWizard;

public class ImportKeysAction extends Action {
	private StructuredViewer viewer;

	public ImportKeysAction(StructuredViewer viewer) {
		this.viewer = viewer;
		setText("Import Keys");
	}

	@Override
	public void runWithEvent(Event event) {
		Shell shell = event.display.getActiveShell();
		runWizard(shell);
	}

	private void runWizard(Shell shell) {
		final ImportKeysWizard wizard = new ImportKeysWizard();
		WizardDialog dialog = new WizardDialog(shell, wizard);

		try {
			// viewer.getControl().setRedraw(false);
			if (dialog.open() == Dialog.OK) {
				viewer.getControl().getDisplay().asyncExec(new Runnable() {
					public void run() {
						if (wizard.getImported() != null) {
							viewer.setSelection(new StructuredSelection(wizard
									.getImported()));
						}
					}
				});
			}
		} finally {
			viewer.getControl().setRedraw(true);
		}
	}

	@Override
	public void run() {
		Shell activeShell = Display.getCurrent().getActiveShell();
		runWizard(activeShell);
	}
}
