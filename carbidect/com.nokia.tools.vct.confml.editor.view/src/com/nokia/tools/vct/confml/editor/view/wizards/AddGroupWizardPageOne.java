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
 * Description: This file is part of com.nokia.tools.vct.confml.editor.view component.
 */

package com.nokia.tools.vct.confml.editor.view.wizards;

import java.util.Observable;
import java.util.Observer;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;

import com.nokia.tools.variant.confml.core.ConfMLCore;
import com.nokia.tools.variant.confml.ui.dialogs.IconSelectionDialog;
import com.nokia.tools.vct.common.appmodel.EConfMLLayer;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.DialogField;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.IDialogFieldListener;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.IStringButtonAdapter;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.LayoutUtil;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.StringButtonDialogField;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.StringDialogField;
import com.nokia.tools.vct.confml.editor.view.vemodel.EGroup;
import com.nokia.tools.vct.confml.editor.view.vemodel.EGroupContainer;
import com.nokia.tools.vct.confml.editor.view.vemodel.EView;

public class AddGroupWizardPageOne extends WizardPage {

	private EGroupContainer groupContainer;

	private class AddNewGroup extends Observable implements
			IDialogFieldListener, IStringButtonAdapter {
		private final StringButtonDialogField iconPathField;
		private final StringDialogField nameField;
		private final StringDialogField descriptionField;

		public AddNewGroup() {
			nameField = new StringDialogField();
			nameField.setLabelText("Name:");
			nameField.setDialogFieldListener(this);
			descriptionField = new StringDialogField();
			descriptionField.setLabelText("Description:");
			descriptionField.setDialogFieldListener(this);
			iconPathField = new StringButtonDialogField(this);
			if (isGroupWithIcon) {
				iconPathField.setLabelText("Icon path:");
				iconPathField.setDialogFieldListener(this);
				iconPathField.setButtonLabel("Browse...");
			}
		}

		public void changeControlPressed(DialogField field) {
			Shell shell = Display.getCurrent().getActiveShell();
			if (field == iconPathField) {
				IconSelectionDialog dialog = new IconSelectionDialog(shell);

				IFile editorFile = (IFile) editorInput.getAdapter(IFile.class);
				
				
				if (editorFile != null) {
					EConfMLLayer layer = ConfMLCore.getLayer(editorFile);
					dialog.setInput(layer);
					URI initial = URI.createURI(iconPathField.getText().trim());
					dialog.setInitialSelection(initial);

					if (dialog.open() == ElementTreeSelectionDialog.OK) {
						URI result = (URI) dialog.getFirstResult();
						iconPathField.setText(result.toString());
					}
				}
			}
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
			group.setText("Group properties");

			nameField.doFillIntoGrid(group, numColumns);
			LayoutUtil.setHorizontalGrabbing(nameField.getTextControl(null));

			descriptionField.doFillIntoGrid(group, numColumns);
			LayoutUtil.setHorizontalGrabbing(descriptionField
					.getTextControl(null));
			LayoutUtil.setVerticalGrabbing(descriptionField
					.getTextControl(null));

			if (isGroupWithIcon) {
				iconPathField.doFillIntoGrid(group, numColumns);
				iconPathField.getTextControl(group).setEditable(false);
				LayoutUtil.setHorizontalGrabbing(iconPathField
						.getTextControl(null));
			}

			return group;
		}
	}

	final class Validator implements Observer {
		public Validator() {
			super();
		}

		public void update(Observable o, Object arg) {

			String fileName = addNewGroup.iconPathField.getText().trim();
			URI fileURI = null;
			boolean exists = false;

			if (isGroupWithIcon && fileName.length() == 0) {
				addNewGroup.iconPathField
						.setWarningMessage("The icon resource should be specified");
			} else {
				try {
					fileURI = URI.createURI(fileName);
				} catch (Exception e) {
				}
				addNewGroup.iconPathField.setWarningMessage(null);

				if (fileURI == null) {
					addNewGroup.iconPathField
							.setErrorMessage("The URI is malformed");
				} else if (!fileURI.isRelative()) {
					addNewGroup.iconPathField
							.setErrorMessage("The URI must be relative");
				} else {
					addNewGroup.iconPathField.setErrorMessage(null);
				}
			}

			String name = addNewGroup.nameField.getText().trim();
			if (name.length() == 0) {
				setMessage("Name: enter name value");
				setErrorMessage(null);
				setPageComplete(false);
				return;
			}

			EList<EGroup> groups = groupContainer.getGroups();

			for (EGroup group : groups) {
				if (name.equalsIgnoreCase(group.getName())) {
					setMessage(null);
					setErrorMessage("Name: group with entered name already exists");
					setPageComplete(false);
					return;
				}
			}

			String description = addNewGroup.descriptionField.getText().trim();
			if (description.length() == 0) {
				setMessage("Description: enter description value");
				setErrorMessage(null);
				setPageComplete(false);
				return;
			}

			fileName = addNewGroup.iconPathField.getText().trim();
			if (isGroupWithIcon && fileName.length() == 0) {
				setMessage("Icon path: enter the icon file path or browse for it");
				setErrorMessage(null);
				// permit addition
				setPageComplete(true);
				return;
			}

			if (fileName.length() > 0) {

				try {
					URI uri = URI.createURI(fileName);
					if (!uri.isRelative()) {
						setMessage(null);
						setErrorMessage("Icon path: the URI must be relative");
						setPageComplete(false);
						return;
					}

					IFile editorFile = (IFile) editorInput
							.getAdapter(IFile.class);
					if (editorFile != null) {
						EConfMLLayer layer = ConfMLCore.getLayer(editorFile);
						exists = layer.getDocumentMap().containsKey(uri);
					} else {
						exists = true;
					}

					if (!exists) {
						setMessage(null);
						setErrorMessage("Icon path: entered image file doesn't exists");
						setPageComplete(false);
						return;
					}
				} catch (Exception ex) {
					setMessage(null);
					setErrorMessage("Icon path: malformed URI");
					setPageComplete(false);
					return;
				}

			}

			setMessage(null);
			setErrorMessage(null);
			setPageComplete(true);
		}
	}

	static final String PAGE_NAME = "AddGroupWizardPageOne";

	private final AddNewGroup addNewGroup;
	private final Validator validator;
	private boolean isGroupWithIcon = false;
	private IEditorInput editorInput;

	protected AddGroupWizardPageOne(EGroupContainer groupContainer,
			IEditorInput editorInput) {
		super(PAGE_NAME);
		setPageComplete(false);
		setTitle("Add new group wizard");
		setDescription("This wizard helps you to add new group or subgroup");
		this.groupContainer = groupContainer;
		this.editorInput = editorInput;
		if (groupContainer instanceof EView) {
			isGroupWithIcon = true;
			isGroupWithIcon = true;
		}
		addNewGroup = new AddNewGroup();
		validator = new Validator();
		addNewGroup.addObserver(validator);
	}

	public void createControl(Composite parent) {
		initializeDialogUnits(parent);

		final Composite composite = new Composite(parent, SWT.NULL);
		composite.setFont(parent.getFont());
		composite.setLayout(initGridLayout(new GridLayout(1, false), true));
		composite.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));

		Control groupControl = createGroupControl(composite);
		groupControl
				.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

		setControl(composite);

		validator.update(null, null);
	}

	private Control createGroupControl(Composite composite) {
		Control control = addNewGroup.createControl(composite);
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

	public String getGroupName() {
		return addNewGroup.nameField.getText().trim();
	}

	public String getGroupDescription() {
		return addNewGroup.descriptionField.getText().trim();
	}

	public String getGroupIconPath() {
		return addNewGroup.iconPathField.getText().trim();
	}

}
