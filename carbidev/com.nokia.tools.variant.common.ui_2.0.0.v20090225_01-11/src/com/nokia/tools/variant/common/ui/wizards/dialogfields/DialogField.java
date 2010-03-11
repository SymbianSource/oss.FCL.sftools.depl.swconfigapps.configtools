/*******************************************************************************
 * Copyright (c) 2000, 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.nokia.tools.variant.common.ui.wizards.dialogfields;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.jface.util.SafeRunnable;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;

/**
 * Base class of all dialog fields. Dialog fields manage controls together with
 * the model, independed from the creation time of the widgets. - support for
 * automated layouting. - enable / disable, set focus a concept of the base
 * class.
 * 
 * DialogField have a label.
 */
public class DialogField {

	public static final int DEC_NONE = 0;
	public static final int DEC_ERROR = 1;
	public static final int DEC_WARNING = 2;
	public static final int DEC_REQUIRED = 3;

	private Label label;
	protected String labelText;

	private Link link;
	private String linkText;

	private ControlDecoration controlDecoration;
	private FieldDecoration errorDecoration, warningDecoration,
			requiredFieldDecoration;

	private ILinkAdapter linkAdapter;

	private String errorMessage;
	private String warningMessage;
	private boolean required;

	private IDialogFieldListener fDialogFieldListener;

	private boolean fEnabled;

	public DialogField() {
		fEnabled = true;
		label = null;
		labelText = ""; //$NON-NLS-1$
		link = null;
		linkText = ""; //$NON-NLS-1$
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public String getWarningMessage() {
		return warningMessage;
	}

	public void setErrorMessage(String message) {
		this.errorMessage = message;
		errorDecoration = null;
		updateDecoration();
	}

	public void setWarningMessage(String message) {
		this.warningMessage = message;
		warningDecoration = null;
		updateDecoration();
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
		requiredFieldDecoration = null;
		updateDecoration();
	}

	protected void updateDecoration() {
		if (isOkToUse(getDecoratedControl())) {
			if (errorMessage != null) {
				showDecoration(DEC_ERROR);
			} else if (warningMessage != null) {
				showDecoration(DEC_WARNING);
			} else if (isRequired()) {
				showDecoration(DEC_REQUIRED);
			} else {
				showDecoration(DEC_NONE);
			}
		}
	}

	protected boolean hasContentAssist() {
		return false;
	}

	protected boolean hasQuickFix() {
		return false;
	}

	protected void quickFix() {
		// do nothing
	}

	protected FieldDecoration getErrorDecoration() {
		if (errorDecoration == null) {
			FieldDecoration standardError;
			if (hasQuickFix()) {
				standardError = FieldDecorationRegistry.getDefault()
						.getFieldDecoration(
								FieldDecorationRegistry.DEC_ERROR_QUICKFIX);
			} else {
				standardError = FieldDecorationRegistry.getDefault()
						.getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
			}
			if (getErrorMessage() == null) {
				errorDecoration = standardError;
			} else {
				errorDecoration = new FieldDecoration(standardError.getImage(),
						getErrorMessage());
			}
		}
		return errorDecoration;

	}

	protected FieldDecoration getWarningDecoration() {
		if (warningDecoration == null) {
			FieldDecoration standardWarning = FieldDecorationRegistry
					.getDefault().getFieldDecoration(
							FieldDecorationRegistry.DEC_WARNING);
			if (getWarningMessage() == null) {
				warningDecoration = standardWarning;
			} else {
				warningDecoration = new FieldDecoration(standardWarning
						.getImage(), getWarningMessage());
			}
		}
		return warningDecoration;
	}

	protected FieldDecoration getRequiredFieldDecoration() {
		if (requiredFieldDecoration == null) {
			requiredFieldDecoration = FieldDecorationRegistry.getDefault()
					.getFieldDecoration(FieldDecorationRegistry.DEC_REQUIRED);
		}
		return requiredFieldDecoration;
	}

	public void showDecoration(int decor) {
		ControlDecoration controlDec = getControlDecoration();
		if (controlDec == null) {
			return;
		}

		FieldDecoration fieldDecoration = null;
		switch (decor) {
		case DEC_ERROR:
			fieldDecoration = getErrorDecoration();
			break;
		case DEC_WARNING:
			fieldDecoration = getWarningDecoration();
			break;
		case DEC_REQUIRED:
			fieldDecoration = getRequiredFieldDecoration();
			break;
		case DEC_NONE:
		default:
			fieldDecoration = null;
			break;
		}

		if (fieldDecoration == null) {
			controlDec.hide();
		} else {
			controlDec.setImage(fieldDecoration.getImage());
			controlDec.setDescriptionText(fieldDecoration.getDescription());
			controlDec.show();
		}
	}

	protected ControlDecoration getControlDecoration() {
		if (controlDecoration == null) {
			Control decorated = getDecoratedControl();
			if (decorated != null) {
				controlDecoration = new ControlDecoration(decorated, SWT.LEFT
						| SWT.CENTER);
			}
		}
		return controlDecoration;
	}

	protected Control getDecoratedControl() {
		return null;
	}

	/**
	 * Sets the label of the dialog field.
	 */
	public void setLabelText(String labeltext) {
		labelText = labeltext;
		if (isOkToUse(label)) {
			label.setText(labeltext);
		}
	}

	public void setLinkText(String labeltext) {
		linkText = labeltext;
		if (isOkToUse(link)) {
			link.setText(labeltext);
		}
	}

	// ------ change listener

	/**
	 * Defines the listener for this dialog field.
	 */
	public final void setDialogFieldListener(IDialogFieldListener listener) {
		fDialogFieldListener = listener;
	}

	/**
	 * Programatical invocation of a dialog field change.
	 */
	public void dialogFieldChanged() {
		if (fDialogFieldListener != null) {
			fDialogFieldListener.dialogFieldChanged(this);
		}
	}

	// ------- focus management

	/**
	 * Tries to set the focus to the dialog field. Returns <code>true</code> if
	 * the dialog field can take focus. To be reimplemented by dialog field
	 * implementors.
	 */
	public boolean setFocus() {
		if (link != null) {
			return link.setFocus();
		}
		return false;
	}

	/**
	 * Posts <code>setFocus</code> to the display event queue.
	 */
	public void postSetFocusOnDialogField(Display display) {
		if (display != null) {
			display.asyncExec(new Runnable() {
				public void run() {
					setFocus();
				}
			});
		}
	}

	// ------- layout helpers

	/**
	 * Creates all controls of the dialog field and fills it to a composite. The
	 * composite is assumed to have <code>MGridLayout</code> as layout. The
	 * dialog field will adjust its controls' spans to the number of columns
	 * given. To be reimplemented by dialog field implementors.
	 */
	public Control[] doFillIntoGrid(Composite parent, int nColumns) {
		assertEnoughColumns(nColumns);

		Label label = getLabelControl(parent);
		if (label != null) {
			label.setLayoutData(gridDataForLabel(nColumns));
			return new Control[] { label };
		}
		Link link = getLinkControl(parent);
		if (link != null) {
			link.setLayoutData(gridDataForLabel(nColumns));
			return new Control[] { link };
		}

		return new Control[] {};
	}

	/**
	 * Returns the number of columns of the dialog field. To be reimplemented by
	 * dialog field implementors.
	 */
	public int getNumberOfControls() {
		return 1;
	}

	protected static GridData gridDataForLabel(int span) {
		GridData gd = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		gd.horizontalSpan = span;
		return gd;
	}

	// ------- ui creation

	/**
	 * Creates or returns the created label widget.
	 * 
	 * @param parent
	 *            The parent composite or <code>null</code> if the widget has
	 *            already been created.
	 */
	public Label getLabelControl(Composite parent) {
		if (label == null) {
			assertCompositeNotNull(parent);

			if (labelText != null && !"".equals(labelText)) { //$NON-NLS-1$
				label = new Label(parent, SWT.LEFT | SWT.WRAP);
				label.setFont(parent.getFont());
				label.setEnabled(fEnabled);
				label.setText(labelText);
			}
		}
		return label;
	}

	public Link getLinkControl(Composite parent) {
		if (link == null) {
			assertCompositeNotNull(parent);

			if (linkText != null && !"".equals(linkText)) { //$NON-NLS-1$
				link = new Link(parent, SWT.LEFT | SWT.WRAP);
				link.setFont(parent.getFont());
				link.setEnabled(fEnabled);
				link.setText(linkText);

				link.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(final SelectionEvent e) {
						if (linkAdapter != null) {
							SafeRunner.run(new SafeRunnable() {
								public void run() throws Exception {
									linkAdapter.linkSelected(DialogField.this,
											e.text);
								}
							});
						}
					}
				});
			}
		}
		return link;
	}

	public void setLinkAdapter(ILinkAdapter adapter) {
		this.linkAdapter = adapter;
	}

	/**
	 * Creates a spacer control.
	 * 
	 * @param parent
	 *            The parent composite
	 */
	public static Control createEmptySpace(Composite parent) {
		return createEmptySpace(parent, 1);
	}

	/**
	 * Creates a spacer control with the given span. The composite is assumed to
	 * have <code>MGridLayout</code> as layout.
	 * 
	 * @param parent
	 *            The parent composite
	 */
	public static Control createEmptySpace(Composite parent, int span) {
		Label label = new Label(parent, SWT.LEFT);
		GridData gd = new GridData();
		gd.horizontalAlignment = GridData.BEGINNING;
		gd.grabExcessHorizontalSpace = false;
		gd.horizontalSpan = span;
		gd.horizontalIndent = 0;
		gd.widthHint = 0;
		gd.heightHint = 0;
		label.setLayoutData(gd);
		return label;
	}

	/**
	 * Tests is the control is not <code>null</code> and not disposed.
	 */
	protected final boolean isOkToUse(Control control) {
		return (control != null) && (Display.getCurrent() != null)
				&& !control.isDisposed();
	}

	// --------- enable / disable management

	/**
	 * Sets the enable state of the dialog field.
	 */
	public final void setEnabled(boolean enabled) {
		if (enabled != fEnabled) {
			fEnabled = enabled;
			updateEnableState();
		}
	}

	/**
	 * Called when the enable state changed. To be extended by dialog field
	 * implementors.
	 */
	protected void updateEnableState() {
		if (label != null) {
			label.setEnabled(fEnabled);
		}
		if (link != null) {
			link.setEnabled(fEnabled);
		}
	}

	/**
	 * Brings the UI in sync with the model. Only needed when model was changed
	 * in different thread whil UI was lready created.
	 */
	public void refresh() {
		updateEnableState();
	}

	/**
	 * Gets the enable state of the dialog field.
	 */
	public final boolean isEnabled() {
		return fEnabled;
	}

	protected final void assertCompositeNotNull(Composite comp) {
		Assert.isNotNull(comp,
				"uncreated control requested with composite null"); //$NON-NLS-1$
	}

	protected final void assertEnoughColumns(int nColumns) {
		Assert.isTrue(nColumns >= getNumberOfControls(),
				"given number of columns is too small"); //$NON-NLS-1$
	}

}
