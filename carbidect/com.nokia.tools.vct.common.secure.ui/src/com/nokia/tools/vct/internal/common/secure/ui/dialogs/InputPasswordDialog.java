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

package com.nokia.tools.vct.internal.common.secure.ui.dialogs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * It provides dialog for input the password. There is also check the option to
 * save password.
 * 
 */
public class InputPasswordDialog extends Dialog {

	public InputPasswordDialog(Shell parentShell) {
		super(parentShell);
	}

	/**
	 * Input text widget.
	 */
	private Text text;

	private String textValue;
	
	/**
	 * Check save password widget
	 */
	private Button chkSavePassword;
	
	private boolean savePass;

	public boolean isSavePassword() {
		return savePass;
	}

	public String getText() {
		return textValue;
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) parent;
		GridLayout layout = new GridLayout(1, true);
		layout.marginHeight = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_MARGIN);
		layout.marginWidth = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_MARGIN);
		layout.verticalSpacing = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_SPACING);
		layout.horizontalSpacing = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_SPACING);
		composite.setLayout(layout);

		Label label = new Label(composite, SWT.WRAP);
		label.setText("Enter your private key password");

		GridData data = new GridData(GridData.GRAB_HORIZONTAL
				| GridData.GRAB_VERTICAL | GridData.HORIZONTAL_ALIGN_FILL
				| GridData.VERTICAL_ALIGN_CENTER);
		label.setLayoutData(data);

		text = new Text(composite, SWT.SINGLE | SWT.BORDER | SWT.PASSWORD);
		text.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL
				| GridData.HORIZONTAL_ALIGN_FILL));

		chkSavePassword = new Button(composite, SWT.CHECK);
		chkSavePassword.setText("Save password");
		return composite;
	}

	@Override
	protected void configureShell(Shell newShell) {
		newShell.setText("Password");
		super.configureShell(newShell);
	}
	
	@Override
	protected void okPressed() {
		textValue = text.getText();
		savePass = chkSavePassword.getSelection();
		super.okPressed();
	}
}
