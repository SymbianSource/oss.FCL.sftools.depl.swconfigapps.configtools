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
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;

import com.nokia.tools.vct.internal.common.secure.ui.wizards.GenerateKeysWizard;

public class GenerateKeysAction extends Action {

	public GenerateKeysAction() {
		setText("Create new key pair");
	}

	@Override
	public void runWithEvent(Event event) {
		Shell shell = event.display.getActiveShell();

		GenerateKeysWizard wizard = new GenerateKeysWizard();
		WizardDialog dialog = new WizardDialog(shell, wizard);
		dialog.open();

	}

}
