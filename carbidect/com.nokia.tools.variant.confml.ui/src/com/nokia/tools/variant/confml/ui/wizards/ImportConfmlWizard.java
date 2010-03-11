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

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IWorkbench;

import com.nokia.tools.variant.confml.core.operation.ImportConfMLFileRunnable;
import com.nokia.tools.variant.confml.ui.ConfmlUI;

public class ImportConfmlWizard extends NewElementWizard implements IImportWizard {
	
	ImportConfmlWizardPage mainPage;
	
	IStructuredSelection selection;

	public ImportConfmlWizard() {
		super();
	}
	 
	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench, org.eclipse.jface.viewers.IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		setWindowTitle("File Import Wizard"); //NON-NLS-1
		setNeedsProgressMonitor(true);
		this.selection = selection;
	}
	
	/* (non-Javadoc)
     * @see org.eclipse.jface.wizard.IWizard#addPages()
     */
    public void addPages() {
        super.addPages(); 
        mainPage = new ImportConfmlWizardPage();

        if (selection.getFirstElement() instanceof IFolder) {
    		mainPage.setSourceFolder((IFolder)selection.getFirstElement());
        }
		
        addPage(mainPage);        
    }

	@Override
	protected void finishPage(IProgressMonitor monitor)
			throws InterruptedException, CoreException {
		File source = mainPage.isDirectoryImportSelected() ? 
				mainPage.getSourceDirectory() : mainPage.getSourceFile();
		
		ImportConfMLFileRunnable importConfMLFile = new ImportConfMLFileRunnable(
				mainPage.isDirectoryImportSelected(),
				source,
				ResourcesPlugin.getWorkspace().getRoot().getFolder(new Path(mainPage.getProjectName())),
				mainPage.isFixXInclude(),
				mainPage.isPrettyPrint(),
				mainPage.isMakeLinks(),
				ConfmlUI.PLUGIN_ID);
		
		importConfMLFile.run(monitor);
	
	}

	@Override
	public Object getCreatedElement() {
		return null;
	}

}
