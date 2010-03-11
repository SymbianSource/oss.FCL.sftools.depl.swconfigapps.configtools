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

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.wizards.newresource.BasicNewResourceWizard;

import com.nokia.tools.variant.confml.ui.ConfmlUI;
import com.nokia.tools.vct.common.ui.operations.WorkbenchRunnableAdapter;
import com.nokia.tools.vct.common.ui.utils.SWTUtil;

public abstract class NewElementWizard extends Wizard implements INewWizard {

	private IWorkbench fWorkbench;
	private IStructuredSelection fSelection;

	public NewElementWizard() {
		setNeedsProgressMonitor(true);
	}

	/**
	 * Helper method for opening the editor. Can be called from any thread.
	 * 
	 * @param resource
	 *            File to open
	 */
	protected void openResource(final IFile resource, final String editorId) {
		final Display display = SWTUtil.getStandardDisplay();
		display.asyncExec(new Runnable() {
			public void run() {
				final IWorkbenchPage activePage = SWTUtil.getActivePage();
				if (activePage != null) {
					try {
						IDE.openEditor(activePage, resource, editorId, true);
					} catch (PartInitException e) {
						ConfmlUI.logWarning(e);
					}
				}
			}
		});
	}

	/**
	 * Subclasses should override to perform the actions of the wizard. This
	 * method is run in the wizard container's context as a workspace runnable.
	 * 
	 * @param monitor
	 * @throws InterruptedException
	 * @throws CoreException
	 */
	protected abstract void finishPage(IProgressMonitor monitor)
			throws InterruptedException, CoreException;

	/**
	 * Returns the scheduling rule for creating the element.
	 * 
	 * @return returns the scheduling rule
	 */
	protected ISchedulingRule getSchedulingRule() {
		return ResourcesPlugin.getWorkspace().getRoot(); // look all by default
	}

	protected boolean canRunForked() {
		return true;
	}

	public abstract Object getCreatedElement();

	protected void handleFinishException(Shell shell,
			InvocationTargetException e) {
		// String title= NewWizardMessages.NewElementWizard_op_error_title;
		// String message= NewWizardMessages.NewElementWizard_op_error_message;
		// ExceptionHandler.handle(e, shell, title, message);
	}

	/*
	 * @see Wizard#performFinish
	 */
	public boolean performFinish() {
		IWorkspaceRunnable op = new IWorkspaceRunnable() {
			public void run(IProgressMonitor monitor) throws CoreException,
					OperationCanceledException {
				try {
					finishPage(monitor);
				} catch (InterruptedException e) {
					throw new OperationCanceledException(e.getMessage());
				}
			}
		};
		try {
			ISchedulingRule rule = null;
			Job job = Job.getJobManager().currentJob();
			if (job != null)
				rule = job.getRule();
			IRunnableWithProgress runnable = null;
			if (rule != null)
				runnable = new WorkbenchRunnableAdapter(op, rule, true);
			else
				runnable = new WorkbenchRunnableAdapter(op, getSchedulingRule());
			getContainer().run(canRunForked(), true, runnable);
		} catch (InvocationTargetException e) {
			handleFinishException(getShell(), e);
			return false;
		} catch (InterruptedException e) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench,
	 * org.eclipse.jface.viewers.IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection currentSelection) {
		fWorkbench = workbench;
		fSelection = currentSelection;
	}

	public IStructuredSelection getSelection() {
		return fSelection;
	}

	public IWorkbench getWorkbench() {
		return fWorkbench;
	}

	protected void selectAndReveal(IResource newResource) {
		BasicNewResourceWizard.selectAndReveal(newResource, fWorkbench
				.getActiveWorkbenchWindow());
	}

}
