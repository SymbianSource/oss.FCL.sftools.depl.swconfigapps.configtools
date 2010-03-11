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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;

import com.nokia.tools.vct.common.core.utils.ArrayUtils;

public class ComboDialogField extends DialogField {

	private String text;
	private int selectionIndex;
	private String[] items;
	private Combo comboControl;
	private ModifyListener modifyListener;
	private SelectionListener selectionListener;
	private int flags;

	/**
	 * Constructs dialog field
	 * 
	 * @param flags
	 *            Control flags.
	 * 
	 * @see Combo#Combo(Composite, int)
	 */
	public ComboDialogField(int flags) {
		super();
		this.text = ""; //$NON-NLS-1$
		this.items = new String[0];
		this.flags = flags;
		this.selectionIndex = -1;
	}

	// ------- layout helpers

	/*
	 * @see DialogField#doFillIntoGrid
	 */
	public Control[] doFillIntoGrid(Composite parent, int nColumns) {
		assertEnoughColumns(nColumns);

		List<Control> result = new ArrayList<Control>(2);

		Label label = getLabelControl(parent);
		if (label != null) {
			label.setLayoutData(gridDataForLabel(1));
			result.add(label);
		}
		Link link = getLinkControl(parent);
		if (link != null) {
			link.setLayoutData(gridDataForLabel(1));
			result.add(link);
		}

		Combo combo = getComboControl(parent);
		combo.setLayoutData(gridDataForCombo(nColumns - 1));

		result.add(combo);

		return ArrayUtils.createCopy(Control.class, result);
	}

	/*
	 * @see DialogField#getNumberOfControls
	 */
	public int getNumberOfControls() {
		return 2;
	}

	protected GridData gridDataForCombo(int span) {
		GridData gd = new GridData();
		gd.horizontalAlignment = GridData.FILL;
		gd.grabExcessHorizontalSpace = false;
		gd.horizontalSpan = span;
		gd.horizontalIndent = 10;
		return gd;
	}

	/**
	 * Overrides the label alignment when simple style is used.
	 */
	@Override
	protected GridData gridDataForLabel(int span) {
		GridData result = super.gridDataForLabel(span);
		if ((flags & SWT.SIMPLE) != 0) {
			result.verticalAlignment = SWT.BEGINNING;
		}
		return result;
	}

	// ------- focus methods

	/*
	 * @see DialogField#setFocus
	 */
	public boolean setFocus() {
		if (isOkToUse(comboControl)) {
			comboControl.setFocus();
		}
		return true;
	}

	// ------- ui creation

	/**
	 * Creates or returns the created combo control.
	 * 
	 * @param parent
	 *            The parent composite or <code>null</code> when the widget has
	 *            already been created.
	 */
	public Combo getComboControl(Composite parent) {
		if (comboControl == null) {
			assertCompositeNotNull(parent);
			modifyListener = new ModifyListener() {
				public void modifyText(ModifyEvent e) {
					doModifyText(e);
				}
			};
			selectionListener = new SelectionListener() {
				public void widgetSelected(SelectionEvent e) {
					doSelectionChanged(e);
				}

				public void widgetDefaultSelected(SelectionEvent e) {
				}
			};

			comboControl = new Combo(parent, flags);
			// moved up due to 1GEUNW2
			comboControl.setItems(items);
			if (selectionIndex != -1) {
				comboControl.select(selectionIndex);
			} else {
				comboControl.setText(text);
			}
			comboControl.setFont(parent.getFont());
			comboControl.addModifyListener(modifyListener);
			comboControl.addSelectionListener(selectionListener);
			comboControl.setEnabled(isEnabled());
		}
		return comboControl;
	}

	private void doModifyText(ModifyEvent e) {
		if (isOkToUse(comboControl)) {
			text = comboControl.getText();
			selectionIndex = comboControl.getSelectionIndex();
		}
		dialogFieldChanged();
	}

	private void doSelectionChanged(SelectionEvent e) {
		if (isOkToUse(comboControl)) {
			items = comboControl.getItems();
			text = comboControl.getText();
			selectionIndex = comboControl.getSelectionIndex();
		}
		dialogFieldChanged();
	}

	// ------ enable / disable management

	/*
	 * @see DialogField#updateEnableState
	 */
	protected void updateEnableState() {
		super.updateEnableState();
		if (isOkToUse(comboControl)) {
			comboControl.setEnabled(isEnabled());
		}
	}

	// ------ text access

	/**
	 * Gets the combo items.
	 */
	public String[] getItems() {
		return items;
	}

	/**
	 * Sets the combo items. Triggers a dialog-changed event.
	 */
	public void setItems(String[] items) {
		this.items = items;
		if (isOkToUse(comboControl)) {
			comboControl.setItems(items);
		}
		dialogFieldChanged();
	}

	/**
	 * Gets the text.
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets the text. Triggers a dialog-changed event.
	 */
	public void setText(String text) {
		this.text = text;
		if (isOkToUse(comboControl)) {
			comboControl.setText(text);
		} else {
			dialogFieldChanged();
		}
	}

	/**
	 * Selects an item.
	 * 
	 * @param index
	 *            Index of the item to select or <code>-1</code> to clear the
	 *            selection and display the text (when possible)
	 */
	public boolean selectItem(int index) {
		boolean success = false;
		if (isOkToUse(comboControl)) {
			if (index == -1) {
				comboControl.deselectAll();
				comboControl.setText(text);
			} else {
				comboControl.select(index);
			}
			success = comboControl.getSelectionIndex() == index;
		} else {
			if (index >= 0 && index < items.length) {
				text = items[index];
				selectionIndex = index;
				success = true;
			}
		}
		if (success) {
			dialogFieldChanged();
		}
		return success;
	}

	/**
	 * Clears any selection
	 * 
	 * @see Combo#deselectAll()
	 */
	public void deselectAll() {
		selectItem(-1);
	}

	/**
	 * Selects an item.
	 */
	public boolean selectItem(String name) {
		for (int i = 0; i < items.length; i++) {
			if (items[i].equals(name)) {
				return selectItem(i);
			}
		}
		return false;
	}

	public int getSelectionIndex() {
		return selectionIndex;
	}

	/**
	 * Sets the text without triggering a dialog-changed event.
	 */
	public void setTextWithoutUpdate(String text) {
		this.text = text;
		if (isOkToUse(comboControl)) {
			comboControl.removeModifyListener(modifyListener);
			comboControl.removeSelectionListener(selectionListener);
			comboControl.setText(text);
			comboControl.addSelectionListener(selectionListener);
			comboControl.addModifyListener(modifyListener);
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
		if (isOkToUse(comboControl)) {
			comboControl.removeModifyListener(modifyListener);
			comboControl.removeSelectionListener(selectionListener);
			comboControl.setItems(items);
			if (selectionIndex == -1) {
				comboControl.deselectAll();
				comboControl.setText(text);
			} else {
				comboControl.select(selectionIndex);
			}
			comboControl.addSelectionListener(selectionListener);
			comboControl.addModifyListener(modifyListener);
		}
	}

}
