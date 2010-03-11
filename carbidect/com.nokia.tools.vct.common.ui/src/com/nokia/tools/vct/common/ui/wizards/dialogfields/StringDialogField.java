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

import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;

import com.nokia.tools.vct.common.ui.contentassist.ControlContentAssistHelper;

public class StringDialogField extends DialogField {

	private String fText;
	private Text fTextControl;
	private ModifyListener fModifyListener;
	private IContentAssistProcessor fContentAssistProcessor;

	private int textStyle;
	
	public StringDialogField() {
		this(SWT.SINGLE | SWT.BORDER);
	}
	
	public StringDialogField(int style) {
		textStyle = style;
		fText = "";
	}

	public void setContentAssistProcessor(IContentAssistProcessor processor) {
		fContentAssistProcessor = processor;
		if (fContentAssistProcessor != null && isOkToUse(fTextControl)) {
			ControlContentAssistHelper.createTextContentAssistant(fTextControl,
					fContentAssistProcessor);
		}
	}

	public IContentAssistProcessor getContentAssistProcessor() {
		return fContentAssistProcessor;
	}

	// ------- layout helpers

	/*
	 * @see DialogField#doFillIntoGrid
	 */
	public Control[] doFillIntoGrid(Composite parent, int nColumns) {
		assertEnoughColumns(nColumns);

		Control label = getLabelControl(parent);
		if (label == null) {
			label = getLinkControl(parent);
		}
		
		if (label != null) {
			label.setLayoutData(gridDataForLabel(1));
			Text text = getTextControl(parent);
			text.setLayoutData(gridDataForText(nColumns - 1));
			
			updateDecoration();
			
			return new Control[] { label, text };
		} else {
			Text text = getTextControl(parent);
			GridData gd = gridDataForText(nColumns);
			gd.horizontalIndent = 0;
			text.setLayoutData(gd);

			updateDecoration();
			return new Control[] { text };
		}
	}

	/*
	 * @see DialogField#getNumberOfControls
	 */
	public int getNumberOfControls() {
		return 2;
	}

	protected static GridData gridDataForText(int span) {
		GridData gd = new GridData();
		gd.horizontalAlignment = GridData.FILL;
		gd.grabExcessHorizontalSpace = false;
		gd.horizontalSpan = span;
		gd.horizontalIndent = 10;
		return gd;
	}

	// ------- focus methods

	/*
	 * @see DialogField#setFocus
	 */
	public boolean setFocus() {
		if (isOkToUse(fTextControl)) {
			fTextControl.setFocus();
			fTextControl.setSelection(0, fTextControl.getText().length());
		}
		return true;
	}

	// ------- ui creation

	/**
	 * Creates or returns the created text control.
	 * 
	 * @param parent
	 *            The parent composite or <code>null</code> when the widget has
	 *            already been created.
	 */
	public Text getTextControl(Composite parent) {
		if (fTextControl == null) {
			assertCompositeNotNull(parent);
			fModifyListener = new ModifyListener() {
				public void modifyText(ModifyEvent e) {
					doModifyText(e);
				}
			};

			fTextControl = new Text(parent, textStyle);
			// moved up due to 1GEUNW2
			fTextControl.setText(fText);
			fTextControl.setFont(parent.getFont());
			fTextControl.addModifyListener(fModifyListener);

			fTextControl.setEnabled(isEnabled());
			if (fContentAssistProcessor != null) {
				ControlContentAssistHelper.createTextContentAssistant(
						fTextControl, fContentAssistProcessor);
			}
		}
		return fTextControl;
	}
	
	@Override
	protected Control getDecoratedControl() {
		return fTextControl;
	}

	private void doModifyText(ModifyEvent e) {
		if (isOkToUse(fTextControl)) {
			fText = fTextControl.getText();
		}
		dialogFieldChanged();
	}

	// ------ enable / disable management

	/*
	 * @see DialogField#updateEnableState
	 */
	protected void updateEnableState() {
		super.updateEnableState();
		if (isOkToUse(fTextControl)) {
			fTextControl.setEnabled(isEnabled());
		}
	}

	// ------ text access

	/**
	 * Gets the text. Can not be <code>null</code>
	 */
	public String getText() {
		return fText;
	}

	/**
	 * Sets the text. Triggers a dialog-changed event.
	 */
	public void setText(String text) {
		fText = text;
		if (isOkToUse(fTextControl)) {
			fTextControl.setText(text);
		} else {
			dialogFieldChanged();
		}
	}

	/**
	 * Sets the text without triggering a dialog-changed event.
	 */
	public void setTextWithoutUpdate(String text) {
		fText = text;
		if (isOkToUse(fTextControl)) {
			fTextControl.removeModifyListener(fModifyListener);
			fTextControl.setText(text);
			fTextControl.addModifyListener(fModifyListener);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jdt.internal.ui.wizards.dialogfields.DialogField#refresh()
	 */
	public void refresh() {
		super.refresh();
		if (isOkToUse(fTextControl)) {
			setTextWithoutUpdate(fText);
		}
	}

}
