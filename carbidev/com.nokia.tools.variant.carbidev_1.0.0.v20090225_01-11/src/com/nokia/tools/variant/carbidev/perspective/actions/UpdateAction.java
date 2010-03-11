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

package com.nokia.tools.variant.carbidev.perspective.actions;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IBundleGroup;
import org.eclipse.core.runtime.IBundleGroupProvider;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.PlatformUI;
import org.eclipse.update.standalone.UpdateCommand;

public class UpdateAction implements IWorkbenchWindowActionDelegate {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IWorkbenchWindowActionDelegate#dispose()
	 */
	public void dispose() {
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.ui.IWorkbenchWindowActionDelegate#init(org.eclipse.ui.
	 * IWorkbenchWindow)
	 */
	public void init(IWorkbenchWindow window) {

	}

	/**
	 * Software Updates
	 * 
	 */
	public void run(IAction action) {
		final Shell activeShell = Display.getCurrent().getActiveShell();

		ProgressMonitorDialog dialog = new ProgressMonitorDialog(activeShell);

		try {
			dialog.run(false, true, new IRunnableWithProgress() {

				public void run(IProgressMonitor monitor) {

					UpdateCommand command;

					try {
						boolean updated = false;
						
						command = new UpdateCommand(
								"com.nokia.tools.variant.feature.carbidev2",
								"false");
						if(command.run(monitor)) {
							updated = true;
						}

						if(isFeatureInstalled("com.nokia.tools.variant.feature.s60.components")) {
							command = new UpdateCommand(
									"com.nokia.tools.variant.feature.s60.components",
									"false");
							if(command.run(monitor)) {
								updated = true;
							}
						}
						
						if (updated) {
							
							String message = "Carbide.v was updated successfully. " +
								"It is recommended you restart Carbide.v for the changes to take effect. " +
								"Would you like to restart now?";
							int choice = showQuestionMessage(activeShell, message);

							switch (choice) {
							case SWT.YES:
								PlatformUI.getWorkbench().restart();
								break;
							case SWT.NO:
								break;
							}

							// boolean temp =
							// PlatformUI.getPreferenceStore().getBoolean
							// (IWorkbenchPreferenceConstants
							// .CLOSE_EDITORS_ON_EXIT);
							// PlatformUI.getPreferenceStore().setValue(
							// IWorkbenchPreferenceConstants
							// .CLOSE_EDITORS_ON_EXIT, false);
							// PlatformUI.getWorkbench().restart();
							// PlatformUI.getPreferenceStore().setValue(
							// IWorkbenchPreferenceConstants
							// .CLOSE_EDITORS_ON_EXIT, temp);

						} else {
							String message = "No updates for the currently installed feature(s) found, " +
								"try again later.";
							showInfoMessage(activeShell, message);
						}
					} catch (Exception e) {
						// e.printStackTrace();
						String message = "No updates for the currently installed feature(s) found, " +
							"try again later.";
						showInfoMessage(activeShell, message);
					}

				}

			});
			
		} catch (InvocationTargetException e) {
//			e.printStackTrace();
		} catch (InterruptedException e) {
//			e.printStackTrace();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action
	 * .IAction, org.eclipse.jface.viewers.ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		
	}
	
	private int showInfoMessage(Shell parent, String message) {
		MessageBox msgBox = new MessageBox(parent, SWT.OK
				| SWT.ICON_INFORMATION);
		msgBox.setText("Carbide.v Update");
		msgBox.setMessage(message);
		return msgBox.open();
	}
	
	private int showQuestionMessage(Shell parent, String message) {
		MessageBox msgBox = new MessageBox(parent,
				SWT.YES | SWT.NO | SWT.ICON_QUESTION);
		msgBox.setText("Carbide.v Update");
		msgBox.setMessage(message);
		return msgBox.open();
	}
	
	private boolean isFeatureInstalled(String featureId) {
		IBundleGroupProvider[] providers = Platform.getBundleGroupProviders();
		if (providers != null) {
			for (int i = 0; i < providers.length; ++i) {
				IBundleGroup[] bundleGroups = providers[i].getBundleGroups();
				for (IBundleGroup bg : bundleGroups) {
					if (bg.getIdentifier().equals(featureId)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
}
