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
 * Description: This file is part of com.nokia.tools.variant.editor component.
 */

package com.nokia.tools.variant.editor.summary;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;


public class OpenExternalViewerHandler {

//	private static final String PAUSE_DIALOG_TITLE = "External Editor Opened";
//	private static final String PAUSE_MESSAGE = "Carbide.v has been paused for external editor to finish.\n\n"
//			+ "Close this dialog when finished to refresh Resources.";
//	private static final String REFRESH_CHANGED_RESOURCE_ERROR = "Error in refreshing the changed resource";

	public static final String PROMPT_VIEWER_KEY = "com.nokia.tools.variant.resourcelibrary.promptExternalViewer";

	public Object execute(final File res, final Shell shell) throws ExecutionException {
//		IStructuredSelection sel = (IStructuredSelection) HandlerUtil
//				.getCurrentSelection(event);
//		IStorage file = (IStorage) sel.getFirstElement();
		
	//	final File res = new File(file.getFullPath().toOSString());
	
		IStatusLineManager man = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage().getActiveEditor()
				.getEditorSite().getActionBars().getStatusLineManager();
		final IProgressMonitor mon = man.getProgressMonitor();
	//	final Shell sh = HandlerUtil.getActiveShellChecked(event);

		// Check whether or not prompt external viewer
		//String promptViewerStr = event.getParameter(PROMPT_VIEWER_KEY);
//		final boolean promptViewer = ("true".equals(promptViewerStr)) ? true
//				: false;

		// Run the command in a separate thread
		Display.getCurrent().syncExec(new Runnable() {
			public void run() {
				openExternalEditor(res, true, mon, shell);
			}
		});

		return null;
	}

	private void openExternalEditor(File res, boolean promptViewer,
			IProgressMonitor mon, Shell sh) {
		String path = res.getPath();
		if (path != null) {
			String fullPath = path;
			try {
				if (promptViewer)
					Runtime.getRuntime().exec(
							"rundll32 SHELL32.DLL,OpenAs_RunDLL " + fullPath);
				else
					Runtime.getRuntime()
							.exec(
									"rundll32 SHELL32.DLL,ShellExec_RunDLL "
											+ fullPath);

				// Create a modal dialog that will prompt the user to refresh
				// resource library once he's finished
//				MessageBox promptRefresh = new MessageBox(sh,
//						SWT.ICON_INFORMATION);
//				promptRefresh.setText(PAUSE_DIALOG_TITLE);
//				promptRefresh.setMessage(PAUSE_MESSAGE);
//				promptRefresh.open();
				//refresh zip file
				/*final EVariantProject configurationProject = (EVariantProject) PlatformUI
						.getWorkbench().getActiveWorkbenchWindow()
						.getActivePage().getActiveEditor().getAdapter(
								EVariantProject.class);
				configurationProject.getProject().refreshLocal(
						IResource.DEPTH_INFINITE, mon);*/
			} catch (IOException e) {
				// If RunDLL32 fails, it should display an error of its own. Do
				// nothing.
			}/* catch (CoreException e) {
				MessageBox messageBox = new MessageBox(sh, SWT.ICON_ERROR);
				messageBox.setMessage(REFRESH_CHANGED_RESOURCE_ERROR);
				messageBox.open();
			}*/
		}
	}
}
