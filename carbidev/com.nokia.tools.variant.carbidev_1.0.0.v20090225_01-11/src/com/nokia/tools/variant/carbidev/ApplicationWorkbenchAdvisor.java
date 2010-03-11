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

package com.nokia.tools.variant.carbidev;

import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.application.IWorkbenchConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchAdvisor;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

import com.nokia.tools.variant.carbidev.perspective.CarbideVPerspective;
import com.nokia.tools.variant.editor.actions.OpenCpfAction;

public class ApplicationWorkbenchAdvisor extends WorkbenchAdvisor {

	public WorkbenchWindowAdvisor createWorkbenchWindowAdvisor(
			IWorkbenchWindowConfigurer configurer) {
		return new ApplicationWorkbenchWindowAdvisor(configurer);
	}

	public String getInitialWindowPerspectiveId() {
		return CarbideVPerspective.PERSPECTIVE_ID;
	}

	public void initialize(IWorkbenchConfigurer iworkbenchconfigurer) {
		super.initialize(iworkbenchconfigurer);

		// Restoring workbench state
		iworkbenchconfigurer.setSaveAndRestore(false);

		// You can here activate save History/recently files
		OpenCpfAction.loadEditorHistory();
	}

	private void closeEditors() {
		IWorkbenchWindow[] workbenchWindows = PlatformUI.getWorkbench()
				.getWorkbenchWindows();
		for (IWorkbenchWindow workbenchWindow : workbenchWindows) {
			IWorkbenchPage[] pages = workbenchWindow.getPages();
			for (IWorkbenchPage workbenchPage : pages) {
				IEditorReference[] editorReferences = workbenchPage.getEditorReferences();
				for (IEditorReference editorReference : editorReferences) {
					IEditorPart editor = editorReference.getEditor(false);
					if (editor != null) {
						workbenchPage.closeEditor(editor, editor.isDirty());
					}
				}
			}
		}

	}

	@Override
	public boolean preShutdown() {
		closeEditors();

		return super.preShutdown();
	}
}
