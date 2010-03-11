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

package com.nokia.tools.vct.internal.common.secure.ui.wizards;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.SWT;
import org.eclipse.ui.IExportWizard;
import org.eclipse.ui.IWorkbench;

import com.nokia.tools.vct.common.secure.core.IKeyStoreEntry;
import com.nokia.tools.vct.common.secure.core.IKeyStoreManager;
import com.nokia.tools.vct.common.secure.core.SecurityCorePlugin;
import com.nokia.tools.vct.secure.common.ui.SecurityUI;

public class ExportKeysWizard extends Wizard implements IExportWizard {

	private ExportKeysPage1 page1;
	private Object[] keys;

	private static final String TITLE_IMAGE_PATH = "icons/handle_keys.png";

	public ExportKeysWizard(Object[] keys) {
		this.keys = keys;
		setWindowTitle("Export wizard");
		setDefaultPageImageDescriptor(SecurityUI
				.getImageDescriptor(TITLE_IMAGE_PATH));
	}

	@Override
	public void addPages() {
		int pairCount = 0;
		int cerCount = 0;

		for (Object key : keys) {
			IKeyStoreEntry entry = (IKeyStoreEntry) key;
			if (entry.hasPrivateKey()) {
				pairCount++;
			}
			cerCount++;
		}

		page1 = new ExportKeysPage1(pairCount, cerCount);
		addPage(page1);
	}

	@Override
	public boolean performFinish() {

		IKeyStoreManager manager = SecurityCorePlugin.getKeyStoreManager();
		List<IKeyStoreEntry> entries = new ArrayList<IKeyStoreEntry>();
		List<String> passwords = null;
		if (page1.getExportPrivate()) {
			passwords = new ArrayList<String>();
			for (Object next : keys) {
				if (next instanceof IKeyStoreEntry) {
					IKeyStoreEntry entry = (IKeyStoreEntry) next;
					entries.add(entry);
					String entryPass = null;
					if (entry.hasPrivateKey()) {
						entryPass = "";
						X509Certificate cert = manager.getCertificate(entry);
						if (cert == null) {
							return false;
						}

						while (true) {
							try {
								manager.getPrivateKey(entry, entryPass);
								break;
							} catch (Exception ex) {

								InputDialog dialog = new InputDialog(
										getShell(),
										"Enter Password",
										"Owner key information: \nName: "
												+ entry.getName()
												+ "\nOrganization: "
												+ entry.getOrganization()
												+ "\nValidity: "
												+ entry.getDate()
												+ "\n\nThe entry requires password:",
										"", null) {

									@Override
									protected int getInputTextStyle() {
										return SWT.SINGLE | SWT.BORDER
												| SWT.PASSWORD;
									}
								};
								if (dialog.open() == Dialog.OK) {
									entryPass = dialog.getValue();
									continue;
								} else {
									// operation canceled
									return false;
								}
							}
						}
					}
					passwords.add(entryPass);
				}
			}
		} else {
			for (Object next : keys) {
				if (next instanceof IKeyStoreEntry) {
					IKeyStoreEntry entry = (IKeyStoreEntry) next;
					entries.add(entry);
				}
			}
		}
		// String password = page1.getPassword();
		OutputStream os = null;
		try {
			if (page1.getExportPrivate()) {
				os = new BufferedOutputStream(new FileOutputStream(page1
						.getKeyDestinationFile()));
			}
			manager.exportEntries(entries, passwords, os, page1
					.getCertificateFolder());
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		} finally {
			// FileUtils.closeStream(os);
		}
		// Program p = Program.findProgram(".txt");
		// p.execute(page1.getOutputFile());

		return true;
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {

	}

}
