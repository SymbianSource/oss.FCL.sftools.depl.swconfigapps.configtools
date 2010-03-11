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
 * Description: This file is part of com.nokia.tools.vct.common.ui component.
 */

package com.nokia.tools.vct.common.ui.operations;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.operation.IThreadListener;

import com.nokia.tools.vct.common.core.utils.PlatformUtil;
import com.nokia.tools.vct.common.ui.CommonUIPlugin;

public class WorkbenchRunnableAdapter implements IRunnableWithProgress, IThreadListener {
	
	private boolean fTransfer= false;
	private IWorkspaceRunnable fWorkspaceRunnable;
	private ISchedulingRule fRule;
	
	/**
	 * Runs a workspace runnable with the workspace lock.
	 * @param runnable the runnable
	 */
	public WorkbenchRunnableAdapter(IWorkspaceRunnable runnable) {
		this(runnable, ResourcesPlugin.getWorkspace().getRoot());
	}
	
	/**
	 * Runs a workspace runnable with the given lock or <code>null</code> to run with no lock at all.
	 * @param runnable the runnable
	 * @param rule the scheduling rule
	 */
	public WorkbenchRunnableAdapter(IWorkspaceRunnable runnable, ISchedulingRule rule) {
		fWorkspaceRunnable= runnable;
		fRule= rule;
	}
	
	/**
	 * Runs a workspace runnable with the given lock or <code>null</code> to run with no lock at all.
	 * @param runnable the runnable
	 * @param rule the scheduling rule
	 * @param transfer <code>true</code> if the rule is to be transfered 
	 *  to the model context thread. Otherwise <code>false</code>
	 */
	public WorkbenchRunnableAdapter(IWorkspaceRunnable runnable, ISchedulingRule rule, boolean transfer) {
		fWorkspaceRunnable= runnable;
		fRule= rule;
		fTransfer= transfer;
	}
	
	public ISchedulingRule getSchedulingRule() {
		return fRule;
	}

	/**
	 * {@inheritDoc}
	 */
	public void threadChange(Thread thread) {
		if (fTransfer)
			Job.getJobManager().transferRule(fRule, thread);
	}

	/*
	 * @see IRunnableWithProgress#run(IProgressMonitor)
	 */
	public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
		try {
			PlatformUtil.run(fWorkspaceRunnable, fRule, monitor);
		} catch (OperationCanceledException e) {
			throw new InterruptedException(e.getMessage());
		} catch (CoreException e) {
			throw new InvocationTargetException(e);
		}
	}
	
	public void runAsUserJob(String name, final Object jobFamiliy) {
		Job job = new Job(name){ 
			/* (non-Javadoc)
			 * @see org.eclipse.core.runtime.jobs.Job#run(org.eclipse.core.runtime.IProgressMonitor)
			 */
			protected IStatus run(IProgressMonitor monitor) {
				try {
					WorkbenchRunnableAdapter.this.run(monitor);
				} catch (InvocationTargetException e) {
					Throwable cause= e.getCause();
					if (cause instanceof CoreException) {
						return ((CoreException) cause).getStatus();
					} else {
						return new Status(IStatus.ERROR, CommonUIPlugin.PLUGIN_ID, "Internal error", cause);
					}
				} catch (InterruptedException e) {
					return Status.CANCEL_STATUS;
				} finally {
					monitor.done();
				}
				return Status.OK_STATUS;
			}
			public boolean belongsTo(Object family) {
				return jobFamiliy == family;
			}
		};
		job.setRule(fRule);
		job.setUser(true); 
		job.schedule();
	}
}
