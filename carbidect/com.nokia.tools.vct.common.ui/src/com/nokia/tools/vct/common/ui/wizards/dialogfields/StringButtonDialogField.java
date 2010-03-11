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
 * Description: This file is part of com.nokia.tools.vct.common.ui component.
 */

package com.nokia.tools.vct.common.ui.wizards.dialogfields;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;

import com.nokia.tools.vct.common.ui.utils.SWTUtil;

public class StringButtonDialogField extends StringDialogField {
		
	private Button fBrowseButton;
	private String fBrowseButtonLabel;
	private IStringButtonAdapter fStringButtonAdapter;
	
	private boolean fButtonEnabled;
	
	public StringButtonDialogField(IStringButtonAdapter adapter) {
		super();
		fStringButtonAdapter= adapter;
		fBrowseButtonLabel= "Browse..."; //$NON-NLS-1$
		fButtonEnabled= true;
	}

	/**
	 * Sets the label of the button.
	 */
	public void setButtonLabel(String label) {
		fBrowseButtonLabel= label;
	}
	
	// ------ adapter communication

	/**
	 * Programmatical pressing of the button
	 */	
	public void changeControlPressed() {
		fStringButtonAdapter.changeControlPressed(this);
	}
	
	// ------- layout helpers

	/*
	 * @see DialogField#doFillIntoGrid
	 */		
	public Control[] doFillIntoGrid(Composite parent, int nColumns) {
		assertEnoughColumns(nColumns);
		
		Control label;
		label= getLabelControl(parent);
		if (label == null) {
			label = getLinkControl(parent);
		}
		if(label != null) {
			label.setLayoutData(gridDataForLabel(1));
		}
		Text text= getTextControl(parent);
		
		text.setLayoutData(gridDataForText(label == null ? nColumns - 1 : nColumns - 2));
		Button button= getChangeControl(parent);
		button.setLayoutData(gridDataForButton(button, 1));
	
		return label != null ? new Control[] { label, text, button } : new Control[] {text, button};
	}	

	/*
	 * @see DialogField#getNumberOfControls
	 */		
	public int getNumberOfControls() {
		return 3;	
	}
	
	protected static GridData gridDataForButton(Button button, int span) {
		GridData gd= new GridData();
		gd.horizontalAlignment= GridData.FILL;
		gd.grabExcessHorizontalSpace= false;
		gd.horizontalSpan= span;
		gd.widthHint = SWTUtil.getButtonWidthHint(button);		
		return gd;
	}		
	
	// ------- ui creation	

	/**
	 * Creates or returns the created buttom widget.
	 * @param parent The parent composite or <code>null</code> if the widget has
	 * already been created.
	 */		
	public Button getChangeControl(Composite parent) {
		if (fBrowseButton == null) {
			assertCompositeNotNull(parent);
			
			fBrowseButton= new Button(parent, SWT.PUSH);
			fBrowseButton.setFont(parent.getFont());
			fBrowseButton.setText(fBrowseButtonLabel);
			fBrowseButton.setEnabled(isEnabled() && fButtonEnabled);
			fBrowseButton.addSelectionListener(new SelectionListener() {
				public void widgetDefaultSelected(SelectionEvent e) {
					changeControlPressed();
				}
				public void widgetSelected(SelectionEvent e) {
					changeControlPressed();
				}
			});	
			
		}
		return fBrowseButton;
	}
	
	// ------ enable / disable management
	
	/**
	 * Sets the enable state of the button.
	 */
	public void enableButton(boolean enable) {
		if (isOkToUse(fBrowseButton)) {
			fBrowseButton.setEnabled(isEnabled() && enable);
		}
		fButtonEnabled= enable;
	}

	/*
	 * @see DialogField#updateEnableState
	 */	
	protected void updateEnableState() {
		super.updateEnableState();
		if (isOkToUse(fBrowseButton)) {
			fBrowseButton.setEnabled(isEnabled() && fButtonEnabled);
		}
	}	
}
