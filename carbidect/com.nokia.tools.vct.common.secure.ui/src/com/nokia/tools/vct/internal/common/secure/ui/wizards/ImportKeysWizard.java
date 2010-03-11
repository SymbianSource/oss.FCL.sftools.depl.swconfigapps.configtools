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

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IWorkbench;

import com.nokia.tools.vct.common.core.utils.ArrayUtils;
import com.nokia.tools.vct.common.core.utils.FileUtils;
import com.nokia.tools.vct.common.secure.core.IKeyStoreEntry;
import com.nokia.tools.vct.common.secure.core.IKeyStoreManager;
import com.nokia.tools.vct.common.secure.core.SecurityCorePlugin;
import com.nokia.tools.vct.secure.common.ui.SecurityUI;

public class ImportKeysWizard extends Wizard implements IImportWizard {

	private static final String KEYSTORE_EXT = ".p12";
	private static final String CERTIFICATE_EXT = ".cer";
	private static final String TITLE_IMAGE_PATH = "icons/handle_keys.png";

	private ImportKeysPage1 page1;
	List<IKeyStoreEntry> imported = new ArrayList<IKeyStoreEntry>();

	// private IKeyStoreEntry[] imported;

	public ImportKeysWizard() {
		setWindowTitle("Import wizard");
		setDefaultPageImageDescriptor(SecurityUI
				.getImageDescriptor(TITLE_IMAGE_PATH));
	}

	@Override
	public void addPages() {
		page1 = new ImportKeysPage1();
		addPage(page1);
	}

	@Override
	public boolean performFinish() {
		List<String> files = page1.getSourceFile();

		for (String fileName : files) {
			String ext = fileName.substring(fileName.lastIndexOf('.'), fileName
					.length());

			if (KEYSTORE_EXT.equals(ext)) {
				loadP12(fileName);
			} else if (CERTIFICATE_EXT.equals(ext)) {
				loadCer(fileName);
			}
		}
		return true;
	}

	private void loadCer(String fileName) {
		IKeyStoreManager manager = SecurityCorePlugin.getKeyStoreManager();
		FileInputStream is = null;
		try {
			is = new FileInputStream(fileName);

			imported.addAll(manager.importCertificate(is));
		} catch (Exception e) {
			MessageBox mb = new MessageBox(Display.getCurrent()
					.getActiveShell(), SWT.ICON_WARNING);
			mb.setText("Warning");
			mb.setMessage(e.getMessage());
			mb.open();
		}
	}

	private void loadP12(String fileName) {
		IKeyStoreManager manager = SecurityCorePlugin.getKeyStoreManager();

		InputStream is = null;
		try {
			is = new BufferedInputStream(new FileInputStream(fileName));
			KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
			keyStore.load(is, "".toCharArray());

			FileUtils.closeStream(is);
			HashMap<String, String> alias2password = new HashMap<String, String>();
			String entryPass = "";
			Enumeration<String> en = keyStore.aliases();

			while (en.hasMoreElements()) {
				String alias = en.nextElement();

				X509Certificate x509 = null;
				while (true) {
					try {
						Certificate cert = keyStore.getCertificate(alias);
						x509 = (X509Certificate) cert;
						keyStore.getKey(alias, entryPass.toCharArray());
						break;
					} catch (Exception ex) {

						InputDialog dialog = new InputDialog(getShell(),
								"Enter Password",
								"Owner key information: \nName: "
										+ manager.getName(x509)
										+ "\nOrganization: "
										+ manager.getOrganization(x509)
										+ "\nValidity: "
										+ DateFormat.getDateInstance(
												DateFormat.LONG).format(
												x509.getNotAfter())
										+ "\n\nThe entry requires password:",
								"", null) {

							@Override
							protected int getInputTextStyle() {
								return SWT.SINGLE | SWT.BORDER | SWT.PASSWORD;
							}
						};

						if (dialog.open() == Dialog.OK) {
							entryPass = dialog.getValue();
							continue;
						} else {
							entryPass = "";
							break;
						}
					}
				}
				if (entryPass != "") {
					alias2password.put(alias, entryPass);
				}
				entryPass = "";
			}
			is = new BufferedInputStream(new FileInputStream(fileName));
			imported.addAll(manager.importEntries(is, alias2password));
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			FileUtils.closeStream(is);
		}
	}

	public IKeyStoreEntry[] getImported() {
		return ArrayUtils.createCopy(IKeyStoreEntry.class, imported);
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
	}
}
