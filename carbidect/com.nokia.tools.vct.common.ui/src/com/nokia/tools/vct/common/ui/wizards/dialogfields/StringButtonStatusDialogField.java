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

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class StringButtonStatusDialogField extends StringButtonDialogField {
		
	private Label fStatusLabelControl;
	private Object fStatus;  // String or ImageDescriptor
	
	private String fWidthHintString;
	private int fWidthHint;	
	
	public StringButtonStatusDialogField(IStringButtonAdapter adapter) {
		super(adapter);
		fStatus= null;
		fWidthHintString= null;
		fWidthHint= -1;
	}
	
	// ------ set status

	/**
	 * Sets the status string.
	 */	
	public void setStatus(String status) {
		if (isOkToUse(fStatusLabelControl)) {
			fStatusLabelControl.setText(status);
		}
		fStatus= status;		
	}
	
	/**
	 * Sets the status image.
	 * Caller is responsible to dispose image
	 */
	public void setStatus(Image image) {
		if (isOkToUse(fStatusLabelControl)) {
			if (image == null) {
				fStatusLabelControl.setImage(null);
			} else {
				fStatusLabelControl.setImage(image);
			}
		}
		fStatus= image;		
	}	

	/**
	 * Sets the staus string hint of the status label.
	 * The string is used to calculate the size of the status label.
	 */		
	public void setStatusWidthHint(String widthHintString) {
		fWidthHintString= widthHintString;
		fWidthHint= -1;
	}
	
	/**
	 * Sets the width hint of the status label.
	 */
	public void setStatusWidthHint(int widthHint) {
		fWidthHint= widthHint;
		fWidthHintString= null;
	}
	
	// ------- layout helpers	

	/*
	 * @see DialogField#doFillIntoGrid
	 */		
	public Control[] doFillIntoGrid(Composite parent, int nColumns) {
		assertEnoughColumns(nColumns);
		
		Label label= getLabelControl(parent);
		if(label != null)
			label.setLayoutData(gridDataForLabel(1));
		Text text= getTextControl(parent);
		text.setLayoutData(gridDataForText(nColumns - 3));
		Label status= getStatusLabelControl(parent);
		status.setLayoutData(gridDataForStatusLabel(parent, 1));
		Button button= getChangeControl(parent);
		button.setLayoutData(gridDataForButton(button, 1));
		
		return new Control[] { label, text, status, button };
	}
	
	/*
	 * @see DialogField#getNumberOfControls
	 */
	public int getNumberOfControls() {
		return 4;	
	}
	
	protected GridData gridDataForStatusLabel(Control aControl, int span) {
		GridData gd= new GridData();
		gd.horizontalAlignment= GridData.BEGINNING;
		gd.grabExcessHorizontalSpace= false;
		gd.horizontalIndent= 0;
		if (fWidthHintString != null) {
			GC gc= new GC(aControl);
			gc.setFont(JFaceResources.getDialogFont());
			gd.widthHint= gc.textExtent(fWidthHintString).x;
			gc.dispose();
		} else if (fWidthHint != -1) {
			gd.widthHint= fWidthHint;
		} else {
			gd.widthHint= SWT.DEFAULT;
		}		
		return gd;
	}
	
	// ------- ui creation	

	/**
	 * Creates or returns the created status label widget.
	 * @param parent The parent composite or <code>null</code> when the widget has
	 * already been created.
	 */			
	public Label getStatusLabelControl(Composite parent) {
		if (fStatusLabelControl == null) {
			assertCompositeNotNull(parent);			
			fStatusLabelControl= new Label(parent, SWT.LEFT);
			fStatusLabelControl.setFont(parent.getFont());
			fStatusLabelControl.setEnabled(isEnabled());
			if (fStatus instanceof Image) {
				fStatusLabelControl.setImage((Image)fStatus);
			} else if (fStatus instanceof String) {
				fStatusLabelControl.setText((String)fStatus);
			} else {
				// must be null
			}
		}
		return fStatusLabelControl;
	}
	
	// ------ enable / disable management

	/*
	 * @see DialogField#updateEnableState
	 */	
	protected void updateEnableState() {
		super.updateEnableState();
		if (isOkToUse(fStatusLabelControl)) {
			fStatusLabelControl.setEnabled(isEnabled());
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jdt.internal.ui.wizards.dialogfields.DialogField#refresh()
	 */
	public void refresh() {
		super.refresh();
		if (fStatus instanceof String) {
			setStatus((String) fStatus);
		} else {
			setStatus((Image) fStatus);
		}
	}
}
