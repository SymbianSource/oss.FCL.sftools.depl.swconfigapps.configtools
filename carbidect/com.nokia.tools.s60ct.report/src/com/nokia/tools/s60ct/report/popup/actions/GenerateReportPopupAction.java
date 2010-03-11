/*
* Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies).
* All rights reserved.
* This component and the accompanying materials are made available
* under the terms of "Eclipse Public License v1.0"
* which accompanies this distribution, and is available
* at the URL "http://www.eclipse.org/legal/epl-v10.html".
*
* Initial Contributors:
* Nokia Corporation - initial contribution.
*
* Contributors:
*
* Description:
*
*/
package com.nokia.tools.s60ct.report.popup.actions;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import com.nokia.tools.s60ct.report.ReportPlugin;
import com.nokia.tools.variant.confml.core.ConfMLCore;
import com.nokia.tools.vct.common.appmodel.EConfigurationProject;

public class GenerateReportPopupAction implements IObjectActionDelegate {

	private Shell shell;
	
	/**
	 * Constructor for Action1.
	 */
	public GenerateReportPopupAction() {
		super();
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		shell = targetPart.getSite().getShell();
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		
//		GenerateReportPopupAction reportAction = new GenerateReportPopupAction();
//		reportAction.run(action);
		
		try {
			com.nokia.tools.s60ct.report.dialog.ReportDialog dialog = new com.nokia.tools.s60ct.report.dialog.ReportDialog(shell);

			dialog.create();
			dialog.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		MessageDialog.openInformation(
//			shell,
//			"Report Plug-in",
//			"Create Report was executed.");
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		try {
			if(selection instanceof StructuredSelection) {
				StructuredSelection ss = (StructuredSelection) selection;
				
				if ( ss == null){
					return;
				}
				IFile element = (IFile) ss.getFirstElement();
				if (element == null) return;
				
				IProject project = element.getProject();
				if (project == null) return;
				
				EConfigurationProject model = ConfMLCore.getProjectModel(project);
				URI rootConfml = model.getRootConfml();

				boolean match = true;
				if ((rootConfml.segments().length - 2) == element.getProjectRelativePath().segments().length ){
					
					for (int i = 2; i < rootConfml.segments().length; i++) {
						if (!rootConfml.segments()[i].equals(element.getProjectRelativePath().segments()[i-2])){
							match=false;
						}
				 	}
				}else{
					match = false;
				}
			
				System.out.println("Root congml selected: " + match);
				
				action.setEnabled(match);
				ReportPlugin.setSelectedProject(project);
			}else{
				action.setEnabled(false);	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
