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

package com.nokia.tools.vct.navigator.sign;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.nokia.tools.vct.common.appmodel.EConfigurationProject;

public class ShowSigningStatusAction extends Action {

	private static final class StatusDialog extends TitleAreaDialog {
		EConfigurationProject project;
		
		private StatusDialog(Shell parentShell, EConfigurationProject project) {
			super(parentShell);
			this.project = project;
			setTitle("Configuration Project Signing Status");
		}
		
		@Override
		protected Point getInitialSize() {
			return new Point(600,500);
		}

		@Override
		protected int getShellStyle() {
			return super.getShellStyle() | SWT.RESIZE;
		}
		
		@Override
		public void create() {
			super.create();
			
			setMessage("Check the project content signing status");
		}
		
		@Override
		protected Control createDialogArea(Composite parent) {
			Composite comp = (Composite)super.createDialogArea(parent);
			CPFSigningViewer viewer = new CPFSigningViewer(comp);
			viewer.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
			viewer.setInput(project);
			return comp;
		}
		
		
		@Override
		protected void createButtonsForButtonBar(Composite parent) {
			createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
					true);
		}
		
		@Override
		protected void configureShell(Shell newShell) {
			super.configureShell(newShell);
		}
	}

	private EConfigurationProject project;
	
	public ShowSigningStatusAction(EConfigurationProject project) {
		setText("Display Signing Status");
		this.project = project;
	}
	
	@Override
	public void run() {
		
		final Shell shell = Display.getCurrent().getActiveShell();
		Dialog dialog = new StatusDialog(shell, project);
		dialog.setBlockOnOpen(true);
		dialog.open();
	}
	
	
	
}
