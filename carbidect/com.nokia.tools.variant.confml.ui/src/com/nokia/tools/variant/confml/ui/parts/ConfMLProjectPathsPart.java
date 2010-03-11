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

package com.nokia.tools.variant.confml.ui.parts;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;

import com.nokia.tools.vct.common.ui.utils.PixelConverter;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.DialogField;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.IDialogFieldListener;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.LayoutUtil;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.PathDialogField;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.SelectionButtonDialogField;

public class ConfMLProjectPathsPart extends Observable implements Observer {
	private final class LocationGroup extends Observable implements
			IDialogFieldListener {

		protected final SelectionButtonDialogField defaultLocationsRadio;
		protected final SelectionButtonDialogField customLocationsRadio;
		protected final PathDialogField confmlLocation;
		protected final PathDialogField implmlLocation;
		protected final PathDialogField contentLocation;
		protected final PathDialogField metadataLocation;

		private String lastConfmlLocation;
		private String lastImplmlLocation;
		private String lastContentLocation;
		private String lastMetadataLocation;

		public LocationGroup() {
			defaultLocationsRadio = new SelectionButtonDialogField(SWT.RADIO);
			defaultLocationsRadio.setDialogFieldListener(this);
			defaultLocationsRadio.setLabelText("Use default locations");

			customLocationsRadio = new SelectionButtonDialogField(SWT.RADIO);
			customLocationsRadio.setLabelText("Specify locations");

			confmlLocation = new PathDialogField();
			confmlLocation.setDialogFieldListener(this);
			confmlLocation.setLabelText("ConfML Location:");

			implmlLocation = new PathDialogField();
			implmlLocation.setDialogFieldListener(this);
			implmlLocation.setLabelText("ImplML Location:");

			contentLocation = new PathDialogField();
			contentLocation.setDialogFieldListener(this);
			contentLocation.setLabelText("Content Location:");

			metadataLocation = new PathDialogField();
			metadataLocation.setDialogFieldListener(this);
			metadataLocation.setLabelText("Metadata Location:");

			customLocationsRadio.attachDialogFields(confmlLocation,
					implmlLocation, contentLocation, metadataLocation);

			defaultLocationsRadio.setSelection(true);
			customLocationsRadio.setSelection(false);

			lastConfmlLocation = "confml"; //$NON-NLS-1$
			lastImplmlLocation = "implml"; //$NON-NLS-1$
			lastContentLocation = "content"; //$NON-NLS-1$
			lastMetadataLocation = "notes"; //$NON-NLS-1$
		}

		public Control createControl(Composite composite) {
			final int numColumns = 3;

			final Group group = new Group(composite, SWT.NONE);
			group.setLayout(initGridLayout(new GridLayout(numColumns, false),
					true));
			group.setText("Variant Layer Options");

			defaultLocationsRadio.doFillIntoGrid(group, numColumns);
			customLocationsRadio.doFillIntoGrid(group, numColumns);
			confmlLocation.doFillIntoGrid(group, numColumns);
			implmlLocation.doFillIntoGrid(group, numColumns);
			contentLocation.doFillIntoGrid(group, numColumns);
			metadataLocation.doFillIntoGrid(group, numColumns);
			LayoutUtil.setHorizontalGrabbing(confmlLocation
					.getTextControl(null));
			LayoutUtil.setHorizontalGrabbing(implmlLocation
					.getTextControl(null));
			LayoutUtil.setHorizontalGrabbing(contentLocation
					.getTextControl(null));
			LayoutUtil.setHorizontalGrabbing(metadataLocation
					.getTextControl(null));

			return group;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Observer#update(java.util.Observable,
		 * java.lang.Object)
		 */
		public void update(Observable o, Object arg) {
			if (isDefaultLocationRadioSelected()) {
				confmlLocation.setText("confml");
				implmlLocation.setText("implml");
				contentLocation.setText("content");
				metadataLocation.setText("notes");
			}
			fireEvent();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.jdt.internal.ui.wizards.dialogfields.IDialogFieldListener
		 * #dialogFieldChanged(org.eclipse.jdt.internal.ui.wizards.dialogfields.
		 * DialogField)
		 */
		public void dialogFieldChanged(DialogField field) {
			if (field == defaultLocationsRadio) {
				final boolean checked = defaultLocationsRadio.isSelected();
				if (checked) {
					lastConfmlLocation = confmlLocation.getText();
					lastImplmlLocation = implmlLocation.getText();
					lastContentLocation = contentLocation.getText();
					lastMetadataLocation = metadataLocation.getText();
					confmlLocation.setText("confml");
					implmlLocation.setText("implml");
					contentLocation.setText("content");
					metadataLocation.setText("notes");
				} else {
					confmlLocation.setText(lastConfmlLocation);
					implmlLocation.setText(lastImplmlLocation);
					contentLocation.setText(lastContentLocation);
					metadataLocation.setText(lastMetadataLocation);
				}
			}
			fireEvent();
		}

		protected void fireEvent() {
			setChanged();
			notifyObservers();
		}

		public boolean isDefaultLocationRadioSelected() {
			return defaultLocationsRadio.isSelected();
		}

		public IPath getConfmlLocation() {
			return confmlLocation.getPath();
		}

		public IPath getImplmlLocation() {
			return implmlLocation.getPath();
		}

		public IPath getContentLocation() {
			return contentLocation.getPath();
		}

		public IPath getMetadataLocation() {
			return metadataLocation.getPath();
		}

		public void setConfmlLocation(IPath path) {
			// defaultLocationsRadio.setSelection(path == null);
			confmlLocation.setPath(path);
			lastConfmlLocation = confmlLocation.getText();
			fireEvent();
		}

		public void setImplmlLocation(IPath path) {
			// defaultLocationsRadio.setSelection(path == null);
			implmlLocation.setPath(path);
			lastImplmlLocation = implmlLocation.getText();
		}

		public void setContentLocation(IPath path) {
			// defaultLocationsRadio.setSelection(path == null);
			contentLocation.setPath(path);
			lastContentLocation = contentLocation.getText();
			fireEvent();
		}

	}

	private Composite control;
	private PixelConverter pixelConverter;

	private final LocationGroup locationGroup;

	public ConfMLProjectPathsPart() {
		locationGroup = new LocationGroup();
		locationGroup.addObserver(this);
	}

	public void update(Observable o, Object arg) {
		setChanged();
		notifyObservers(arg);
	}

	public Control createControl(Composite parent) {
		pixelConverter = new PixelConverter(parent);
		control = new Composite(parent, SWT.NONE);
		control.setFont(parent.getFont());
		control.setLayout(initGridLayout(new GridLayout(1, false), false));

		Control locationsControl = locationGroup.createControl(control);
		locationsControl.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		return control;
	}

	private GridLayout initGridLayout(GridLayout layout, boolean margins) {
		layout.horizontalSpacing = pixelConverter
				.convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_SPACING);
		layout.verticalSpacing = pixelConverter
				.convertHorizontalDLUsToPixels(IDialogConstants.VERTICAL_SPACING);
		if (margins) {
			layout.marginWidth = pixelConverter
					.convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_MARGIN);
			layout.marginHeight = pixelConverter
					.convertHorizontalDLUsToPixels(IDialogConstants.VERTICAL_MARGIN);
		} else {
			layout.marginWidth = 0;
			layout.marginHeight = 0;
		}
		return layout;
	}

	public boolean validate(WizardPage page) {
		Map<IPath, String> locations = new HashMap<IPath, String>();

		if (!locationGroup.confmlLocation.isValidPath()) {
			page
					.setErrorMessage("Confml Location: The specified value must have single path segment");
			page.setPageComplete(false);
			return false;
		}
		locations.put(locationGroup.confmlLocation.getPath(), "Confml");

		if (!locationGroup.implmlLocation.isValidPath()) {
			page
					.setErrorMessage("Implml Location: The specified value must have single path segment");
			page.setPageComplete(false);
			return false;
		}
		if (locations.containsKey(locationGroup.implmlLocation.getPath())) {
			page
					.setErrorMessage("Implml Location: The paths must be different");
			page.setPageComplete(false);
			return false;
		}
		locations.put(locationGroup.implmlLocation.getPath(), "Implml");

		if (!locationGroup.contentLocation.isValidPath()) {
			page
					.setErrorMessage("Content Location: The specified value must have single path segment");
			page.setPageComplete(false);
			return false;
		}

		if (locations.containsKey(locationGroup.contentLocation.getPath())) {
			page
					.setErrorMessage("Content Location: The paths must be different");
			page.setPageComplete(false);
			return false;
		}
		locations.put(locationGroup.contentLocation.getPath(), "Content");

		if (!locationGroup.metadataLocation.isValidPath()) {
			page
					.setErrorMessage("Metadata Location: The specified value must have single path segment");
			page.setPageComplete(false);
			return false;
		}
		if (locations.containsKey(locationGroup.metadataLocation.getPath())) {
			page
					.setErrorMessage("Metadata Location: The paths must be different");
			page.setPageComplete(false);
			return false;
		}

		return true;
	}
}
