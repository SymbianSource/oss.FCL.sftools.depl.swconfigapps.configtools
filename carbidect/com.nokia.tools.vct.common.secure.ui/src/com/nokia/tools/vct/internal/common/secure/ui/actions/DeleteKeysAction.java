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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.widgets.Shell;

import com.nokia.tools.vct.common.secure.core.IKeyStoreEntry;
import com.nokia.tools.vct.common.secure.core.SecurityCorePlugin;

public class DeleteKeysAction extends Action {
	private StructuredViewer viewer;

	public DeleteKeysAction(StructuredViewer viewer) {
		this.viewer = viewer;
		setEnabled(!viewer.getSelection().isEmpty());
		setText("Delete");
	}

	@Override
	public void run() {
		Object[] keys = ((IStructuredSelection) viewer.getSelection())
				.toArray();
		Shell shell = viewer.getControl().getShell();

		if (MessageDialog.openConfirm(shell, "Keys Removal", "Are you sure?")) {
			try {
				viewer.getControl().setRedraw(false);
				for (Object obj : keys) {
					if (obj instanceof IKeyStoreEntry) {
						try {
							IKeyStoreEntry alias = (IKeyStoreEntry) obj;
							SecurityCorePlugin.getKeyStoreManager().removeEntry(
									alias);
						} catch (CoreException e) {
							e.printStackTrace();
						}
					}
				}
			} finally {
				viewer.getControl().setRedraw(true);
			}
		}
	}
}
