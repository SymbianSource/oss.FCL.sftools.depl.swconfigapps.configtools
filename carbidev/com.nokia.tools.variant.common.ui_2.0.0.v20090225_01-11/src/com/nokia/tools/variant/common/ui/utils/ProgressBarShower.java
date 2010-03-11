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
 * Description: This file is part of com.nokia.tools.variant.common.ui component.
 */

package com.nokia.tools.variant.common.ui.utils;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.operation.ModalContext;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.WorkbenchWindow;

@SuppressWarnings("restriction")
public class ProgressBarShower {

	private boolean actionDone;

	public void showProgressBar(Thread workingThread, String taskName,
			boolean busy) {

		IRunnableWithProgress progress = createRunnable(workingThread, taskName);

		WorkbenchWindow activeWorkbenchWindow = (WorkbenchWindow) PlatformUI
				.getWorkbench().getActiveWorkbenchWindow();

		IProgressMonitor monitor = activeWorkbenchWindow.getStatusLineManager()
				.getProgressMonitor();

		StatusLineManager statusLineManager = activeWorkbenchWindow
				.getStatusLineManager();
		Composite comp = (Composite) statusLineManager.getControl();
		comp.addControlListener(new ProgressBarControlListener(comp));

		Point point = comp.computeSize(SWT.DEFAULT, SWT.DEFAULT);
		comp.setSize(300, point.y);

		runTask(busy, progress, activeWorkbenchWindow, monitor);

	}

	class RunnableWithProgress implements IRunnableWithProgress {
		private Thread workingThread;
		private String taskName;

		public RunnableWithProgress(String taskName, Thread workingThread) {
			this.taskName = taskName;
			this.workingThread = workingThread;
		}

		public void run(IProgressMonitor monitor)
				throws InvocationTargetException, InterruptedException {
			Thread.currentThread().setPriority(Thread.MAX_PRIORITY);

			workingThread.start();

			int totalWork = 1000;
			int worked = 0;

			monitor.beginTask(taskName, totalWork); //$NON-NLS-1$

			while (true) {

				monitor.subTask("(" + worked * 100 / totalWork + "%" //$NON-NLS-1$
						//$NON-NLS-2$
						+ ")"); //$NON-NLS-1$

				if (actionDone) {
					break;
				}

				try {
					Thread.sleep(400);
				} catch (InterruptedException e) {
					// Ignored.
				}

				if (workingThread.isAlive()) {
					int currentWork = (totalWork - worked) / 10;
					worked += currentWork;
					monitor.worked(currentWork);
					if (worked >= totalWork) {
						actionDone = true;
					}
				} else {
					monitor.worked(totalWork - worked);
					worked = totalWork;
					actionDone = true;
				}
			}
			monitor.done();
			actionDone = false;
			workingThread = null;
		}

	}

	private IRunnableWithProgress createRunnable(Thread workingThread,
			String taskName) {
		IRunnableWithProgress progress = new RunnableWithProgress(taskName,
				workingThread);
		return progress;
	}

	private void runTask(boolean busy, IRunnableWithProgress progress,
			WorkbenchWindow activeWorkbenchWindow, IProgressMonitor monitor) {
		try {

			if (busy) {
				activeWorkbenchWindow.run(true, false, progress);
			} else {
				ModalContext.run(progress, true, monitor, Display.getDefault());
			}
		} catch (InvocationTargetException e) {

			e.printStackTrace();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public void showProgressBar(Thread workingThread, IProgressMonitor monitor,
			String taskName, boolean busy) {

		IRunnableWithProgress progress = createRunnable(workingThread, taskName);

		WorkbenchWindow activeWorkbenchWindow = (WorkbenchWindow) PlatformUI
				.getWorkbench().getActiveWorkbenchWindow();

		runTask(busy, progress, activeWorkbenchWindow, monitor);

	}

	public void done() {
		actionDone = true;
	}

	class ProgressBarControlListener extends ControlAdapter {
		private Composite comp;

		public ProgressBarControlListener(Composite comp) {
			this.comp = comp;
		}

		public void controlResized(ControlEvent e) {
			resizeProgressBarComposite();
		}

		private void resizeProgressBarComposite() {
			Point point = comp.computeSize(SWT.DEFAULT, SWT.DEFAULT);
			comp.setSize(300, point.y);
		}
	}

}
