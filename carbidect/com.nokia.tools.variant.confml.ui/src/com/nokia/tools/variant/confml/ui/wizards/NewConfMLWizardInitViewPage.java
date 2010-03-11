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

package com.nokia.tools.variant.confml.ui.wizards;

import java.util.Observable;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IDialogPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;

import com.nokia.tools.vct.common.ui.wizards.dialogfields.DialogField;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.IDialogFieldListener;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.LayoutUtil;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.PathDialogField;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.StringDialogField;

public class NewConfMLWizardInitViewPage extends WizardPage {

	private class ViewGroup extends Observable implements IDialogFieldListener{
		private final StringDialogField nameField;
		private final StringDialogField descriptionField;

		public ViewGroup() {
			nameField = new PathDialogField();
			nameField.setLabelText("View Name:");
			nameField.setDialogFieldListener(this);
			descriptionField = new StringDialogField(SWT.MULTI | SWT.BORDER);
			descriptionField.setLabelText("Description:");
			descriptionField.setDialogFieldListener(this);
		}

		private void fireEvent() {
			setChanged();
			notifyObservers();
		}

		public void dialogFieldChanged(DialogField field) {
			fireEvent();
		}

		public Control createControl(Composite composite) {
			final int numColumns = 3;
			final Group group = new Group(composite, SWT.NONE);
			group.setLayout(initGridLayout(new GridLayout(numColumns, false),
					true));
			group.setText("View Properties");

			nameField.doFillIntoGrid(group, numColumns);
			LayoutUtil.setHorizontalGrabbing(nameField.getTextControl(null));
			nameField.setText("Sample View");
			
			descriptionField.doFillIntoGrid(group, numColumns);
			GridData gd = (GridData)descriptionField.getTextControl(null).getLayoutData();
			gd.grabExcessHorizontalSpace = true;
			gd.grabExcessVerticalSpace = true;
			gd.horizontalAlignment = gd.verticalAlignment = SWT.FILL;
			if(descriptionField.getLabelControl(null) != null){
				gd = (GridData)descriptionField.getLabelControl(null).getLayoutData();
				gd.verticalAlignment = SWT.TOP;
			}

			return group;
		}
	}


	static final String PAGE_NAME = "NewConfMLWizardViewPageOne";

	private final ViewGroup viewGroup;

	/**
	 * Constructor for SampleNewWizardPage.
	 * 
	 * @param pageName
	 */
	public NewConfMLWizardInitViewPage() {
		super(PAGE_NAME);
		setTitle("Create new ConfML");
		setDescription("This wizard creates a new file with *.confml extension that can be opened by a multi-page editor.");

		viewGroup = new ViewGroup();
	}

	/**
	 * @see IDialogPage#createControl(Composite)
	 */
	public void createControl(Composite parent) {
		initializeDialogUnits(parent);

		final Composite composite = new Composite(parent, SWT.NULL);
		composite.setFont(parent.getFont());
		composite.setLayout(initGridLayout(new GridLayout(1, false), true));
		composite.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));

		// create UI elements
		Control viewControl = createViewGroupControl(composite);
		viewControl.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		setControl(composite);
	}

	private Control createViewGroupControl(Composite composite) {
		Control control = viewGroup.createControl(composite);
		return control;
	}

	private GridLayout initGridLayout(GridLayout layout, boolean margins) {
		layout.horizontalSpacing = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_SPACING);
		layout.verticalSpacing = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_SPACING);
		if (margins) {
			layout.marginWidth = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_MARGIN);
			layout.marginHeight = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_MARGIN);
		} else {
			layout.marginWidth = 0;
			layout.marginHeight = 0;
		}
		return layout;
	}

	public String getViewName() {
		return viewGroup.nameField.getText().trim();
	}
	public String getViewDescription() {
		return viewGroup.descriptionField.getText().trim();
	}
}
