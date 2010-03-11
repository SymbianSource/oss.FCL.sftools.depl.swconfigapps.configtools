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

package com.nokia.tools.variant.confml.ui.properties.fields;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import com.nokia.tools.vct.common.ui.utils.SWTUtil;

/**
 * Dialog Field containing a single button such as a radio or checkbox button.
 */
public class SelectionButtonFieldEditor extends LabelFieldEditor {
	
	private Button button;
	private boolean fIsSelected;
	private FieldEditor[] fAttachedDialogFields;
	private int fButtonStyle;
	private String labelText;

	/**
	 * Creates a selection button.
	 * Allowed button styles: SWT.RADIO, SWT.CHECK, SWT.TOGGLE, SWT.PUSH
	 */
	public SelectionButtonFieldEditor(int buttonStyle) {
		super();
		fIsSelected= false;
		fAttachedDialogFields= null;
		fButtonStyle= buttonStyle;
	}
	
	/**
	 * Attaches a field to the selection state of the selection button.
	 * The attached field will be disabled if the selection button is not selected.
	 */
	public void attachDialogField(FieldEditor dialogField) {
		attachDialogFields(dialogField);
	}

	/**
	 * Attaches fields to the selection state of the selection button.
	 * The attached fields will be disabled if the selection button is not selected.
	 */	
	public void attachDialogFields(FieldEditor ... dialogFields) {
		fAttachedDialogFields= dialogFields;
		for (int i= 0; i < dialogFields.length; i++) {
			dialogFields[i].setEnabled(fIsSelected);
		}
	}	
	
	/**
	 * Returns <code>true</code> is the given field is attached to the selection button.
	 */
	public boolean isAttached(FieldEditor editor) {
		if (fAttachedDialogFields != null) {
			for (int i=0; i < fAttachedDialogFields.length; i++) {
				if (fAttachedDialogFields[i] == editor) {
					return true;
				}
			}
		}
		return false;
	}
	
	// ------- layout helpers
	
	/*
	 * @see DialogField#doFillIntoGrid
	 */
	public Control[] doFillIntoGrid(Composite parent, int nColumns) {
		Button button= getSelectionButton(parent);
		GridData gd= new GridData();
		gd.horizontalSpan= nColumns;
		gd.horizontalAlignment= GridData.FILL;
		if (fButtonStyle == SWT.PUSH) {
			gd.widthHint = SWTUtil.getButtonWidthHint(button);
		}			
		
		button.setLayoutData(gd);
		return new Control[] { button };
	}	

	/*
	 * @see DialogField#getNumberOfControls
	 */	
	public int getNumberOfControls() {
		return 1;	
	}	
	
	// ------- ui creation			

	/**
	 * Returns the selection button widget. When called the first time, the widget will be created.
	 * @param group The parent composite when called the first time, or <code>null</code>
	 * after.
	 */		
	public Button getSelectionButton(Composite group) {
		if (button == null) {
			button= new Button(group, fButtonStyle);
			button.setFont(group.getFont());			
			button.setText(labelText);
			button.setEnabled(isEnabled());
			button.setSelection(fIsSelected);
			button.addSelectionListener(new SelectionListener() {
				public void widgetDefaultSelected(SelectionEvent e) {
					doWidgetSelected(e);
				}
				public void widgetSelected(SelectionEvent e) {
					doWidgetSelected(e);
				}
			});				
		}
		return button;
	}
	
	private void doWidgetSelected(SelectionEvent e) {
		if (isOkToUse(button)) {
			changeValue(button.getSelection());
		}
	}	
	
	private void changeValue(boolean newState) {
		if (fIsSelected != newState) {
			fIsSelected= newState;			
			if (fAttachedDialogFields != null) {
				boolean focusSet= false;
				for (int i= 0; i < fAttachedDialogFields.length; i++) {		
					fAttachedDialogFields[i].setEnabled(fIsSelected);
					if (fIsSelected && !focusSet) {
						focusSet= fAttachedDialogFields[i].setFocus();
					}
				}
			}
			dialogFieldChanged();
		} else if (fButtonStyle == SWT.PUSH) {
			dialogFieldChanged();
		}
	}		

	/* (non-Javadoc)
	 * @see org.eclipse.jdt.internal.ui.wizards.dialogfields.DialogField#setLabelText(java.lang.String)
	 */
	public void setLabelText(String labeltext) {
		this.labelText = labeltext;
		if (isOkToUse(button)) {
			button.setText(labeltext);
		}
	}
	
	
	// ------ model access	
	
	/**
	 * Returns the selection state of the button.
	 */
	public boolean isSelected() {
		return fIsSelected;
	}

	/**
	 * Sets the selection state of the button.
	 */	
	public void setSelection(boolean selected) {
		changeValue(selected);
		if (isOkToUse(button)) {
			button.setSelection(selected);
		}
	}

	// ------ enable / disable management

	/*
	 * @see DialogField#updateEnableState
	 */	
	protected void updateEnableState() {
		super.updateEnableState();
		if (isOkToUse(button)) {
			button.setEnabled(isEnabled());
		}		
	}
	
	/*(non-Javadoc)
	 * @see org.eclipse.jdt.internal.ui.wizards.dialogfields.DialogField#refresh()
	 */
	public void refresh() {
		super.refresh();
		if (isOkToUse(button)) {
			button.setSelection(fIsSelected);
		}
	}
	
}
