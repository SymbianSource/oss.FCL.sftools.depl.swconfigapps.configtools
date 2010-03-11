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
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;

import com.nokia.tools.vct.common.secure.core.IKeyStoreEntry;
import com.nokia.tools.vct.common.secure.core.IKeyStoreManager;
import com.nokia.tools.vct.common.secure.core.SecurityCorePlugin;
import com.nokia.tools.vct.internal.common.secure.ui.dialogs.InputPasswordDialog;

public class SetAsDefaultAction extends Action {
	private StructuredViewer viewer;
	private IKeyStoreEntry entry;

	public SetAsDefaultAction(StructuredViewer viewer) {
		this.viewer = viewer;
		IStructuredSelection selection = (IStructuredSelection) viewer
				.getSelection();
		Object[] selected = selection.toArray();
		if (selected.length != 1) {
			setEnabled(false);
			entry = null;
		} else {
			entry = (IKeyStoreEntry) selected[0];
			boolean enabled = !entry.equals(SecurityCorePlugin
					.getKeyStoreManager().getDefaultEntry());
			enabled = enabled & entry.hasPrivateKey();

			setEnabled(enabled);
		}
		setText("Set As Default");
	}

	@Override
	public void run() {
		try {
			viewer.getControl().setRedraw(false);
			InputPasswordDialog dlg = new InputPasswordDialog(Display
					.getCurrent().getActiveShell());
			IKeyStoreManager keyStoreManager = SecurityCorePlugin
					.getKeyStoreManager();
			
			if (dlg.open() == InputPasswordDialog.OK) {
				String passphrase = dlg.getText();

				if (!keyStoreManager.checkPassword(entry, passphrase)) {
					MessageBox mb = new MessageBox(Display.getCurrent().getActiveShell(),
							SWT.ICON_WARNING);
					mb.setText("Warning");
					mb.setMessage("Wrong password.\n Key is not set as default.");
					mb.open();
				
					return;
				}

				if (dlg.isSavePassword()) {
					keyStoreManager.setPasswordCookie(passphrase);
				}
				
				keyStoreManager.setDefaultEntry(entry);
			}
		} finally {
			viewer.getControl().setRedraw(true);
		}
	}
}
