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
package com.nokia.s60ct.gui.views;


import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class CleanDialog extends MessageDialog {

	private boolean checkboxStatus;
	public CleanDialog(Shell parentShell, String folder) {
		super(parentShell, "Clean output folder", null, 
		"Do you want to clean the output directory?\n\n\""+folder+"\"", QUESTION, new String[] { IDialogConstants.YES_LABEL,
                IDialogConstants.NO_LABEL }, 0);
	}

	@Override
	protected Control createCustomArea(Composite parent) {
		//return super.createCustomArea(parent);
		Composite comp = new Composite(parent,SWT.NONE);
		GridLayout gridLayout = new GridLayout(2,false);
		comp.setLayout(gridLayout);
		Button checkbox = new Button(comp,SWT.CHECK);
		checkbox.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}

			@Override
			public void widgetSelected(SelectionEvent e) {
				checkboxStatus = ((Button)e.getSource()).getSelection();
				
			}
			
		});
		Label label = new Label(comp,SWT.NONE);
		label.setText("Always clean without prompt");
		return comp;
	}
	
	public boolean getCheckBoxStatus() {
		return checkboxStatus;
	}
	
	public boolean displayDialog() {
		return open() == 0;
	}
}
