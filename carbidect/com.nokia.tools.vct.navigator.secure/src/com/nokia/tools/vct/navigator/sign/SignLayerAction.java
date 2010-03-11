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

package com.nokia.tools.vct.navigator.sign;

import java.security.PrivateKey;
import java.security.cert.X509Certificate;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.nokia.tools.vct.common.appmodel.EConfMLLayer;
import com.nokia.tools.vct.common.appmodel.util.CPFSigningUtils;
import com.nokia.tools.vct.common.secure.core.IKeyStoreEntry;
import com.nokia.tools.vct.common.secure.core.SecurityCorePlugin;

public class SignLayerAction extends Action {

	private EConfMLLayer layer;

	public SignLayerAction(EConfMLLayer layer) {
		setText("Sign Layer");
		this.layer = layer;
	}

	@Override
	public void run() {
		final Shell shell = Display.getCurrent().getActiveShell();

		try {
			IKeyStoreEntry entry = SecurityCorePlugin.getKeyStoreManager()
					.getDefaultEntry();

			if (entry == null) {
				MessageDialog
						.openError(shell, "Layer Signing",
								"There is no default key specified. Operation aborted.");
				return;
			}
			InputDialog dialog = new InputDialog(shell, "Enter password",
					"Enter password for accessing private key:", "", null) {
				@Override
				protected int getInputTextStyle() {
					return super.getInputTextStyle() | SWT.PASSWORD;
				}
			};
			if (dialog.open() != Dialog.OK) {
				return;
			}
			String password = dialog.getValue();

			X509Certificate certificate = SecurityCorePlugin.getKeyStoreManager()
					.getCertificate(entry);
			PrivateKey privateKey = SecurityCorePlugin.getKeyStoreManager()
					.getPrivateKey(entry, password);

			CPFSigningUtils.signLayer(layer, certificate, privateKey);

		} catch (Exception ex) {
			ex.printStackTrace();
			MessageDialog.openError(shell, "Layer Signing",
					"There was an error during operation");
		}
	}
}
