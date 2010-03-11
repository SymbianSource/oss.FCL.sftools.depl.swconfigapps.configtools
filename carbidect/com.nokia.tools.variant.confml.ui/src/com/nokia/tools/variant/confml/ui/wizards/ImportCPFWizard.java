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

package com.nokia.tools.variant.confml.ui.wizards;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IWorkbench;

import com.nokia.tools.variant.confml.core.operation.ImportCPFOperation;
import com.nokia.tools.variant.confml.ui.ConfmlUI;
import com.nokia.tools.vct.common.appmodel.EStorageClass;
import com.nokia.tools.vct.common.appmodel.util.CPFUtil;
import com.nokia.tools.vct.common.appmodel.util.ICPFContentProvider;
import com.nokia.tools.vct.common.appmodel.util.ISecureCPFContentProvider;

public class ImportCPFWizard extends Wizard implements IImportWizard {
	private final Cipher cipher;
	private static final String CPF_PROJECT_SECTION = "ExternalCPFProjectImportWizard";//$NON-NLS-1$
	private ImportCPFPage1 page1;
	private ImportCPFPage2 page2;
	private ImportCPFPage3 page3;

	private static final byte[] _$$d = { (byte) 0xE0, (byte) 0x9B, (byte) 0xAB,
			(byte) 0x75, (byte) 0xFF, (byte) 0xDC, (byte) 0xC8, (byte) 0x58,
			(byte) 0x72, (byte) 0xC8, (byte) 0x43, (byte) 0x96, (byte) 0x92,
			(byte) 0xC3, (byte) 0xB7, (byte) 0xF1 };

	public ImportCPFWizard() {
		super();
		setNeedsProgressMonitor(true);
		IDialogSettings settings = ConfmlUI.getInstance().getDialogSettings();
		IDialogSettings wizardSettings = settings
				.getSection(CPF_PROJECT_SECTION);
		if (wizardSettings == null) {
			wizardSettings = settings.addNewSection(CPF_PROJECT_SECTION);
		}
		setDialogSettings(wizardSettings);
		try {
			byte[] raw = _$$d.clone();
			SecretKeySpec skeySpec = new SecretKeySpec(raw, "Blowfish");
			cipher = Cipher.getInstance("Blowfish");
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		setNeedsProgressMonitor(true);
	}

	@Override
	public void addPages() {
		super.addPages();
		page1 = new ImportCPFPage1();
		page2 = new ImportCPFPage2();
		page3 = new ImportCPFPage3();
		addPage(page1);
		addPage(page2);
		addPage(page3);
	}
	
	@Override
	public boolean canFinish() {
		
		ICPFContentProvider contentProvider = page1.getContentProvider();
		if (contentProvider == null) {
			return false;
		} else if (contentProvider instanceof ISecureCPFContentProvider) {
			return ((ISecureCPFContentProvider) contentProvider).getPrivateKey() != null && super.canFinish();
		}

		return super.canFinish();
	}
	
	
	@Override
	public IWizardPage getNextPage(IWizardPage page) {
		if (page == page1) {
			if (!page1.isPageComplete()) {
				return null;
			}
			
			EStorageClass storageClass;
			 try {
				 File file = page1.getSourceFile();
				 if (file == null) {
					 return null;
				 }
				 
				storageClass = CPFUtil.detectStorageClass(file);
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
			switch (storageClass) {
			case PKZIP:
				return page3;
			case SECURE_M0:
			case ENCRYPTED:
				return page2;
			default:
				return null;
			}
		} else if (page == page2) {
			return page3;
		} else {
			return null;
		}
	}
	
	@Override
	public IWizardPage getPreviousPage(IWizardPage page) {
		if (page == page3) {
			EStorageClass storageClass;
			 try {
				storageClass = CPFUtil.detectStorageClass(page1.getSourceFile());
			} catch (IOException e) {
				e.printStackTrace();
				return page1;
			}
			switch (storageClass) {
			case ENCRYPTED:
				return page2;
			default:
				return page1;
			}
		} else if (page == page2) {
			return page1;
		} else {
			return null;
		}
	}

	@Override
	public boolean performFinish() {
		final ImportCPFOperation operation = new ImportCPFOperation();
		operation.setProjectName(page1.getProjectName());
		operation.setContentProvider(page1.getContentProvider());

		try {
			getContainer().run(false, false, new IRunnableWithProgress() {
				public void run(IProgressMonitor monitor)
						throws InvocationTargetException, InterruptedException {
					try {
						ResourcesPlugin.getWorkspace().run(operation,
								ResourcesPlugin.getWorkspace().getRoot(),
								IWorkspace.AVOID_UPDATE, monitor);
					} catch (CoreException e) {
						throw new InvocationTargetException(e);
					}
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public boolean performCancel() {
		return super.performCancel();
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// setWindowTitle(DataTransferMessages.DataTransfer_importTitle);
		//setDefaultPageImageDescriptor(IDEWorkbenchPlugin.getIDEImageDescriptor("wizban/importproj_wiz.png")); //$NON-NLS-1$
	}

}
