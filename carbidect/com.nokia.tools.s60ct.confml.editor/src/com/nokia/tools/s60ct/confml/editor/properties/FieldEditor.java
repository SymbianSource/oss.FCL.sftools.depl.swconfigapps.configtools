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
package com.nokia.tools.s60ct.confml.editor.properties;

import java.util.Observable;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.widgets.FormToolkit;

/**
 * Abstract class for MVC-type control of form fields
 * 
 * @author Valeri Atamaniouk
 */
public class FieldEditor extends Observable {

	private IFieldListener fieldListener;
	private boolean enabled;
	
	public FieldEditor() {
		super();
		
		enabled = true;
	}
	
	public void dispose() {
	}
	
	protected boolean canUseControl(Control control) {
		return control != null && !control.isDisposed();
	}


	public void fillIntoGrid(Composite parent, int nColumns, FormToolkit toolkit) {
		// do nothing
	}
	
	public void fillIntoGrid(Composite parent, int nColumns, FormToolkit toolkit, int rows) {
		// do nothing
	}
	/**
	 * Child classes shall override.
	 * 
	 * @return Number of control that fill the grid
	 */
	protected int getNumberOfControls() {
		return 0;
	}
	
	protected Control[] getControls() {
		return new Control[0];
	}

	
	public void setFieldListener(IFieldListener fieldListener) {
		this.fieldListener = fieldListener;
	}
	
	public IFieldListener getFieldListener() {
		return fieldListener;
	}

	/**
	 * Programatical invocation of a dialog field change.
	 */
	public void dialogFieldChanged() {
		if (fieldListener != null) {
			fieldListener.fieldChanged(this);
		}
	}

	protected void updateEnableState() {
		// do nothing
	}
	
	public void setEnabled(boolean enabled) {
		if (this.enabled != enabled) {
			this.enabled = enabled;
			updateEnableState();
		}
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
	protected boolean isOkToUse(Control control) {
		return control != null && !control.isDisposed();
	}
	
	public void refresh() {
	}
	
	public boolean setFocus() {
		return false;
	}

}


