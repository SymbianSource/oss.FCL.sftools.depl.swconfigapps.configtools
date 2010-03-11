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
import java.util.Observer;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.dialogs.IDialogConstants;
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
import com.nokia.tools.vct.common.ui.wizards.dialogfields.SelectionButtonDialogField;

public class NewConfMLWizardPageTwo extends WizardPage {

	private class VersionGroup extends Observable implements IDialogFieldListener {
		private final SelectionButtonDialogField version2;
		private final SelectionButtonDialogField version1;
		
		public VersionGroup() {
			version2 = new SelectionButtonDialogField(SWT.RADIO);
			version2.setLabelText("ConfML Version 2");
			version2.setDialogFieldListener(this);
			version1 = new SelectionButtonDialogField(SWT.RADIO);
			version1.setLabelText("ConfML Version 1");
			version1.setDialogFieldListener(this);
			version2.setSelection(true);
		}
		
		public void dialogFieldChanged(DialogField field) {
		}

		public Control createControl(Composite composite) {
			final int numColumns = 3;
			final Group group = new Group(composite, SWT.NONE);
			group.setLayout(initGridLayout(new GridLayout(numColumns, false),
					true));
			group.setText("Configuration ML Version");

			version2.doFillIntoGrid(group, numColumns);
			LayoutUtil
					.setHorizontalGrabbing(version2.getSelectionButton(null));
			version1.doFillIntoGrid(group, numColumns);
			LayoutUtil.setHorizontalGrabbing(version1
					.getSelectionButton(null));
			
			
			
			return group;
		}	
	}
	
	private class ContentTypeGroup extends Observable implements
			IDialogFieldListener {
		private final SelectionButtonDialogField typeRadio;
		private final SelectionButtonDialogField contentRadio;
		private final SelectionButtonDialogField viewRadio;
		private final SelectionButtonDialogField emptyRadio;
		private final SelectionButtonDialogField inclusionRadio;
		private final SelectionButtonDialogField addToLayer;

		public ContentTypeGroup() {
			typeRadio = new SelectionButtonDialogField(SWT.RADIO);
			typeRadio.setLabelText("New ConfML type and initial data");
			typeRadio.setDialogFieldListener(this);
			contentRadio = new SelectionButtonDialogField(SWT.RADIO);
			contentRadio.setLabelText("New data for existing ConfML Type");
			contentRadio.setDialogFieldListener(this);
			viewRadio = new SelectionButtonDialogField(SWT.RADIO);
			viewRadio.setLabelText("ConfML View Definition");
			viewRadio.setDialogFieldListener(this);
			emptyRadio = new SelectionButtonDialogField(SWT.RADIO);
			emptyRadio.setLabelText("Empty ConfML File");
			emptyRadio.setDialogFieldListener(this);
			inclusionRadio = new SelectionButtonDialogField(SWT.RADIO);
			inclusionRadio.setLabelText("Configuration Root or layer root");
			inclusionRadio.setDialogFieldListener(this);
			
			addToLayer = new SelectionButtonDialogField(SWT.CHECK);
			addToLayer.setLabelText("Add to layer inclusion chain");
			addToLayer.setDialogFieldListener(this);

			typeRadio.setSelection(false);
			contentRadio.setSelection(false);
			viewRadio.setSelection(false);
			emptyRadio.setSelection(true);
			addToLayer.setSelection(false);
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
			group.setText("Initial Content");

			typeRadio.doFillIntoGrid(group, numColumns);
			LayoutUtil
					.setHorizontalGrabbing(typeRadio.getSelectionButton(null));
			contentRadio.doFillIntoGrid(group, numColumns);
			LayoutUtil.setHorizontalGrabbing(contentRadio
					.getSelectionButton(null));
			viewRadio.doFillIntoGrid(group, numColumns);
			LayoutUtil
					.setHorizontalGrabbing(viewRadio.getSelectionButton(null));

			emptyRadio.doFillIntoGrid(group, numColumns);
			LayoutUtil.setHorizontalGrabbing(emptyRadio
					.getSelectionButton(null));

			inclusionRadio.doFillIntoGrid(group, numColumns);
			LayoutUtil.setHorizontalGrabbing(inclusionRadio
					.getSelectionButton(null));

			addToLayer.doFillIntoGrid(group, numColumns);
			LayoutUtil.setHorizontalGrabbing(addToLayer
					.getSelectionButton(null));

			return group;
		}

	}
	
	private class Validator implements Observer {
		public void update(Observable o, Object arg) {
			setPageComplete(true);
		}
	}

	private final ContentTypeGroup contentTypeGroup;
	private final VersionGroup versionGroup;
	private final Validator validator;
	
	public void setFile(IFile file) {
		if (file.getParent() instanceof IProject) {
			contentTypeGroup.addToLayer.setEnabled(false);
			contentTypeGroup.addToLayer.setSelection(false);
			contentTypeGroup.contentRadio.setEnabled(false);
			contentTypeGroup.typeRadio.setEnabled(false);
			contentTypeGroup.viewRadio.setEnabled(false);
			contentTypeGroup.contentRadio.setEnabled(false);
			contentTypeGroup.emptyRadio.setSelection(true);
		} else {
			contentTypeGroup.addToLayer.setEnabled(true);
			contentTypeGroup.contentRadio.setEnabled(true);
			contentTypeGroup.typeRadio.setEnabled(true);
			contentTypeGroup.viewRadio.setEnabled(true);
		}
	}

	public boolean isEmptyContentType() {
		return contentTypeGroup.emptyRadio.isSelected();
	}

	public boolean isViewContentType() {
		return contentTypeGroup.viewRadio.isSelected();
	}

	public boolean isAddToLayer() {
		return contentTypeGroup.addToLayer.isSelected();
	}
	
	public boolean isDataContentType() {
		return contentTypeGroup.contentRadio.isSelected();
	}

	public boolean isTypeContentType() {
		return contentTypeGroup.typeRadio.isSelected();
	}

	public boolean isInclusionType() {
		return contentTypeGroup.inclusionRadio.isSelected();
	}
	
	public NewConfMLWizardPageTwo() {
		super("NewConfMLWizardPageTwo");
		contentTypeGroup = new ContentTypeGroup();
		versionGroup = new VersionGroup();
		validator = new Validator();
		contentTypeGroup.addObserver(validator);
		
		setTitle("Select Initial Configuration ML Content");
	}

	public void createControl(Composite parent) {
		Composite comp = new Composite(parent, SWT.NONE);
		comp.setLayout(initGridLayout(new GridLayout(1, false), true));
		Control control;

		control = versionGroup.createControl(comp);
		control.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		control = contentTypeGroup.createControl(comp);
		control.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		setControl(comp);
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

	public boolean isVersionOne() {
		return versionGroup.version1.isSelected();
	}

}
