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
 * Description: This file is part of com.nokia.tools.variant.carbidev component.
 */

package com.nokia.tools.variant.carbidev.rmi;

import java.util.LinkedList;
import java.util.Queue;

import org.eclipse.swt.internal.win32.OS;
import org.eclipse.swt.internal.win32.RECT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;

import com.nokia.tools.variant.editor.actions.OpenCpfAction;

@SuppressWarnings("restriction")
public class OpenCpfThread
    extends Thread {

	private Queue<String> cpfQueue = new LinkedList<String>();

	public OpenCpfThread() {
		setName("OpenCpfThread");
		setDaemon(true);
	}

	public void run() {

		while (true) {
			String nextCpf = null;
			synchronized (cpfQueue) {
				if (!cpfQueue.isEmpty()) {
					nextCpf = cpfQueue.peek();
				} else {
					try {
						cpfQueue.wait();
					} catch (InterruptedException e) {
					}
				}
			}

			if (nextCpf != null) {

				final String cpfPath = nextCpf;

				final boolean[] executed = new boolean[] { false };

				Display.getDefault().syncExec(new Runnable() {

					public void run() {
						executed[0] = executeOpenCpf(cpfPath);
					}
				});

				synchronized (cpfQueue) {
					if (executed[0]) {
						// if action successfully executed remove cpf file from
						// queue
						cpfQueue.poll();
					} else {
						// it happens when Platform UI not started yet
						// so wait a moment and try it again..
						try {
							cpfQueue.wait(500);
						} catch (InterruptedException e) {
						}
					}
				}
			}
		}
	}

	private boolean executeOpenCpf(final String cpfPath) {

		// Test if Platform UI is runningS
		if (PlatformUI.getWorkbench() == null
		    && PlatformUI.getWorkbench().getActiveWorkbenchWindow() == null
		    && PlatformUI.getWorkbench().getActiveWorkbenchWindow()
		        .getActivePage() == null) {

			return false;
		}

		try {
			/*
			 * Bring application window to front
			 */
			bringWindowToFront();

			/*
			 * Open action
			 */
			OpenCpfAction action = new OpenCpfAction();
			action.importProject(cpfPath);

			// wait till action will finish
//			while (!action.isDone()) {
//				try {
//					sleep(200);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return true;
	}

	private void bringWindowToFront() {
		int window = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
		    .getShell().handle;

		/*
		 * bring application window to front
		 */
		RECT rect = new RECT();
		OS.GetWindowRect(window, rect);
		int width = rect.right - rect.left;
		int height = rect.bottom - rect.top;

		if (width <= 160 && height <= 31) {
			OS.ShowWindow(window, OS.SW_RESTORE);
			OS.SetForegroundWindow(window);

		} else {
			OS.SetForegroundWindow(window);
		}
	}

	public void openCPF(String path) {
		synchronized (cpfQueue) {
			cpfQueue.add(path);
			cpfQueue.notifyAll();
		}
	}
}
