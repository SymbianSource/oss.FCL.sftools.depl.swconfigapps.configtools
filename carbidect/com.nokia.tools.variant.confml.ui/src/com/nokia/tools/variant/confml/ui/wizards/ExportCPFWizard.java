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
import java.lang.reflect.InvocationTargetException;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IExportWizard;
import org.eclipse.ui.IWorkbench;

import com.nokia.tools.variant.confml.core.operation.ExportCPFRunnable;
import com.nokia.tools.vct.common.appmodel.EConfigurationProject;
import com.nokia.tools.vct.common.secure.core.IKeyStoreManager;
import com.nokia.tools.vct.common.secure.core.SecurityCorePlugin;
import com.nokia.tools.vct.common.ui.operations.WorkbenchRunnableAdapter;

public class ExportCPFWizard extends Wizard implements IExportWizard {

	private List<EConfigurationProject> context;
	
	private ExportCPFPage1 page1;
	private ExportCPFPage2 page2;
	private ExportCPFPage3 page3;

	private IWorkbench workbench;
	private IStructuredSelection selection;
	
	
	public ExportCPFWizard() {
		setNeedsProgressMonitor(true);
	}

	@Override
	public void addPages() {
		context = new ArrayList<EConfigurationProject>();
		
		page1 = new ExportCPFPage1(workbench, selection, context);
		page2 = new ExportCPFPage2(context);
		page3 = new ExportCPFPage3();
		addPage(page1);
		addPage(page2);
		addPage(page3);
		// pageOne.initialize();
	}	

	@Override
	public IWizardPage getNextPage(IWizardPage page) {
		if (page == page1) {
			if (page1.isSiginingNeeded()) {
				return page2;
			} else if (page1.isEncryptionNeeded()) {
				return page3;
			} else {
				return null;
			}
		} else if (page == page2) {
			if (page1.isEncryptionNeeded()) {
				return page3;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
	
	@Override
	public IWizardPage getPreviousPage(IWizardPage page) {
		if (page == page3) {
			if (page1.isSiginingNeeded()) {
				return page2;
			} else {
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
		ExportCPFRunnable op =new ExportCPFRunnable();
		op.setExportedProject(page1.getExportedProject());
		op.setOutputFile(new File(page1.getTargetCPFFile()));
		
		if (page1.isSiginingNeeded() || page1.isEncryptionNeeded()) {
			IKeyStoreManager manager = SecurityCorePlugin.getKeyStoreManager();
			try {
				PrivateKey privateKey = manager.getPrivateKey(manager.getDefaultEntry(), page1.getPassword());
				X509Certificate certificate = manager.getCertificate(manager.getDefaultEntry());
				op.setSigingOptions(certificate, privateKey);
			} catch (CoreException e) {
				return false;
			}
			if (page1.isSiginingNeeded()) {
				op.setSign(true);
				op.setSignTargets(page2.getSignTargets());
			}
			if (page1.isEncryptionNeeded()) {
				op.setEncrypt(true);
				op.setCertificates(page3.getCertificates());
				op.setEncryptionOptions(page1.getAlgorithm(), page1.getBlockSize());
			}
		}
		
		try {
			ISchedulingRule rule = null;
			Job job = Job.getJobManager().currentJob();
			if (job != null) {
				rule = job.getRule();
			}
			IRunnableWithProgress runnable;
			if (rule != null) {
				runnable = new WorkbenchRunnableAdapter(op, rule, true);
			} else {
				runnable = new WorkbenchRunnableAdapter(op, getSchedulingRule());
			}
			getContainer().run(canRunForked(), true, runnable);
		} catch (InvocationTargetException e) {
			handleFinishException(getShell(), e);
			return false;
		} catch (InterruptedException e) {
			return false;
		}
		return true;
	}

	protected void handleFinishException(Shell shell,
			InvocationTargetException e) {
		// String title= NewWizardMessages.NewElementWizard_op_error_title;
		// String message= NewWizardMessages.NewElementWizard_op_error_message;
		// ExceptionHandler.handle(e, shell, title, message);
	}

	protected boolean canRunForked() {
		return true;
	}
	
	@Override
	public boolean canFinish() {
		if (!page1.isPageComplete()) {
			return false;
		}
		if (!page1.isEncryptionNeeded() && !page1.isSiginingNeeded()) {
			return true;
		}
		if (page1.isSiginingNeeded() && !page2.isPageComplete()) {
			return false;
		}
		if (page1.isEncryptionNeeded() && !page3.isPageComplete()) {
			return false;
		}
		
		if (page1.isEncryptionNeeded()) {
			return getContainer().getCurrentPage() == page3;
		}
		if (page1.isSiginingNeeded()) {
			return getContainer().getCurrentPage() == page2;
		}
		return true;
	}

	/**
	 * Returns the scheduling rule for creating the element.
	 * 
	 * @return returns the scheduling rule
	 */
	protected ISchedulingRule getSchedulingRule() {
		return ResourcesPlugin.getWorkspace().getRoot(); // lock all by default
	}


	public static void main(String[] args) throws Exception {
		KeyGenerator keyGen = KeyGenerator.getInstance("Blowfish");
		SecretKey key = keyGen.generateKey();
		byte[] raw = key.getEncoded();

		for (int i = 0; i < raw.length; i++) {
			System.out.print(" 0x"
					+ Integer.toHexString(raw[i] & 0xFF).toUpperCase() + ",");
		}
	}


	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
	}
	
}
