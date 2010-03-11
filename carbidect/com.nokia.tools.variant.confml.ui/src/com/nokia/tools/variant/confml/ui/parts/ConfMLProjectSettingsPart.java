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

import java.util.Observable;
import java.util.Observer;
import java.util.regex.Pattern;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.osgi.framework.Version;

import com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata;
import com.nokia.tools.vct.common.ui.utils.PixelConverter;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.DialogField;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.IDialogFieldListener;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.IStringButtonAdapter;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.LayoutUtil;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.SelectionButtonDialogField;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.StringButtonDialogField;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.StringDialogField;

public class ConfMLProjectSettingsPart extends Observable implements Observer {

	private final class PropertiesGroup extends Observable implements
			IDialogFieldListener {

		protected final StringDialogField idField;
		protected final StringDialogField versionField;
		protected final StringDialogField nameField;
		protected final StringDialogField providerField;

		public PropertiesGroup() {
			idField = new StringDialogField();
			idField.setDialogFieldListener(this);
			idField.setLabelText("Layer ID:");
			versionField = new StringDialogField();
			versionField.setDialogFieldListener(this);
			versionField.setLabelText("Version:");
			nameField = new StringDialogField();
			nameField.setDialogFieldListener(this);
			nameField.setLabelText("Layer name:");
			providerField = new StringDialogField();
			providerField.setDialogFieldListener(this);
			providerField.setLabelText("Provider:");
		}

		public Control createControl(Composite composite) {
			final int numColumns = 3;

			final Group group = new Group(composite, SWT.NONE);
			group.setLayout(initGridLayout(new GridLayout(numColumns, false),
					true));
			group.setText("Variant Layer Properties");

			idField.doFillIntoGrid(group, numColumns);
			versionField.doFillIntoGrid(group, numColumns);
			nameField.doFillIntoGrid(group, numColumns);
			providerField.doFillIntoGrid(group, numColumns);
			LayoutUtil.setHorizontalGrabbing(idField.getTextControl(null));
			LayoutUtil.setHorizontalGrabbing(versionField.getTextControl(null));
			LayoutUtil.setHorizontalGrabbing(nameField.getTextControl(null));
			LayoutUtil
					.setHorizontalGrabbing(providerField.getTextControl(null));

			return group;
		}

		protected void fireEvent() {
			setChanged();
			notifyObservers();
		}

		public void postSetFocus() {
			idField.postSetFocusOnDialogField(control.getDisplay());
		}

		public void dialogFieldChanged(DialogField field) {
			fireEvent();
		}

		public String getLayerID() {
			return idField.getText().trim();
		}

		public void setLayerID(String id) {
			idField.setText(id);
		}

		public String getLayerVersion() {
			return versionField.getText().trim();
		}

		public void setLayerVersion(String version) {
			this.versionField.setText(version);
		}

		public String getNameField() {
			return nameField.getText().trim();
		}

		public void setName(String name) {
			this.nameField.setText(name);
		}

		public String getProvider() {
			return providerField.getText().trim();
		}

		public void setProvider(String provider) {
			this.providerField.setText(provider);
		}
	}

	private final class OptionsGroup extends Observable implements
			IDialogFieldListener, IStringButtonAdapter {

		protected final SelectionButtonDialogField rootLayerRadio;
		protected final SelectionButtonDialogField subLayerRadio;
		protected final StringButtonDialogField parentLayerId;

		private String lastParentLayerId;

		public OptionsGroup() {
			rootLayerRadio = new SelectionButtonDialogField(SWT.RADIO);
			rootLayerRadio.setDialogFieldListener(this);
			rootLayerRadio.setLabelText("Create new root layer");

			subLayerRadio = new SelectionButtonDialogField(SWT.RADIO);
			subLayerRadio
					.setLabelText("Create sub-layer based on existing one");

			parentLayerId = new StringButtonDialogField(this);
			parentLayerId.setDialogFieldListener(this);
			parentLayerId.setLabelText("Parent layer ID:");
			parentLayerId.setButtonLabel("Select...");

			subLayerRadio.attachDialogField(parentLayerId);

			rootLayerRadio.setSelection(true);
			subLayerRadio.setSelection(false);

			lastParentLayerId = ""; //$NON-NLS-1$
		}

		public Control createControl(Composite composite) {
			final int numColumns = 3;

			final Group group = new Group(composite, SWT.NONE);
			group.setLayout(initGridLayout(new GridLayout(numColumns, false),
					true));
			group.setText("Variant Layer Options");

			rootLayerRadio.doFillIntoGrid(group, numColumns);
			subLayerRadio.doFillIntoGrid(group, numColumns);
			parentLayerId.doFillIntoGrid(group, numColumns);
			LayoutUtil
					.setHorizontalGrabbing(parentLayerId.getTextControl(null));

			return group;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.jdt.internal.ui.wizards.dialogfields.IStringButtonAdapter
		 * #
		 * changeControlPressed(org.eclipse.jdt.internal.ui.wizards.dialogfields
		 * .DialogField)
		 */
		public void changeControlPressed(DialogField field) {
//			final MessageDialog dialog = new MessageDialog(control.getShell(),
//					"Not Implemented", null,
//					"This functionality is not available",
//					MessageDialog.INFORMATION, new String[] { "OK" }, 0);
//			// String directoryName = parentLayerId.getText().trim();
//
//			dialog.open();
			
//			LayerSelectionDialog dialog = new LayerSelectionDialog(Display.getCurrent().getActiveShell());
//			if (dialog.open() == Dialog.OK) {
//				EConfMLLayer selected = (EConfMLLayer) dialog.getSelected();
//				setParentLayerID(selected.getLayerURI());
//			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Observer#update(java.util.Observable,
		 * java.lang.Object)
		 */
		public void update(Observable o, Object arg) {
			if (isRootLayerRadioSelected()) {
				parentLayerId.setText("");
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
			if (field == rootLayerRadio) {
				final boolean checked = rootLayerRadio.isSelected();
				if (checked) {
					lastParentLayerId = parentLayerId.getText();
					parentLayerId.setText("");
				} else {
					parentLayerId.setText(lastParentLayerId);
				}
			}
			fireEvent();
		}

		protected void fireEvent() {
			setChanged();
			notifyObservers();
		}

		public boolean isRootLayerRadioSelected() {
			return rootLayerRadio.isSelected();
		}

		public String getParentLayerID() {
			if (isRootLayerRadioSelected()) {
				return null;
			} else {
				return parentLayerId.getText().trim();
			}
		}

		public void setParentLayerID(String id) {
			rootLayerRadio.setSelection(id == null);
			this.subLayerRadio.setSelection(id != null);
			if (id != null) {
				parentLayerId.setText(id.trim());
			}
		}
	}

	static final Pattern VALIDATOR_ID_PATTERN = Pattern.compile("\\w+(\\.\\w+)*");
	static final Pattern VALIDATOR_VERSION_PATTERN = Pattern.compile("\\d+(\\.\\d+(\\.\\d+(\\.\\w+)?)?)?");


	private Composite control;
	private PixelConverter pixelConverter;

	private final PropertiesGroup propertiesGroup;
	private final OptionsGroup optionsGroup;

	public ConfMLProjectSettingsPart() {
		propertiesGroup = new PropertiesGroup();
		propertiesGroup.addObserver(this);
		optionsGroup = new OptionsGroup();
		optionsGroup.addObserver(this);
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

		Control propertiesControl = propertiesGroup.createControl(control);
		propertiesControl.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		Control optionsControl = optionsGroup.createControl(control);
		optionsControl.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

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

	public void populateSettings(ECPFMetadata settings) {
		// settings.setId(propertiesGroup.getLayerID());
		settings.setName(propertiesGroup.getNameField());
		settings.setAuthor(propertiesGroup.getProvider());
		settings.setVersion(propertiesGroup.getLayerVersion());
	}
	
	static Version toVersion(String value) {
		if (value == null || value.trim().length() == 0) {
			return null;
		}
		return new Version(value);
	}

	public String getLayerID() {
		return propertiesGroup.getLayerID();
	}

	public String getLayerVersion() {
		return propertiesGroup.getLayerVersion();
	}

	public boolean validate(WizardPage page) {
		final String layerID = getLayerID();
		if (layerID.length() == 0) { 
			page.setErrorMessage("Layer ID: a value must be specified");
			page.setPageComplete(false);
			
			propertiesGroup.idField.setRequired(true);
			propertiesGroup.idField.setErrorMessage(null);
			return false;
		}
		if (!VALIDATOR_ID_PATTERN.matcher(layerID).matches()) {
			page.setErrorMessage("Layer ID: ID must be in reverse DNS form");
			page.setPageComplete(false);
			propertiesGroup.idField.setErrorMessage("Layer ID: ID must be in reverse DNS form");
			return false;
		}
		
		propertiesGroup.idField.setRequired(false);
		propertiesGroup.idField.setErrorMessage(null);

		final String version = getLayerVersion();
		if (version.length() == 0) { 
			page.setErrorMessage("Layer Version: a value must be specified");
			page.setPageComplete(false);
			
			propertiesGroup.versionField.setRequired(true);
			propertiesGroup.versionField.setErrorMessage(null);
			return false;
		}
		try {
			new Version(version);
		} catch (Exception ex) {
			page.setErrorMessage("Layer Version: The specified version does not have the correct format (major.minor.micro.qualifier) or contains invalid characters");
			page.setPageComplete(false);
			propertiesGroup.versionField.setRequired(false);
			propertiesGroup.versionField.setErrorMessage("The specified version does not have the correct format (major.minor.micro.qualifier) or contains invalid characters");
			return false;
		}
		
		propertiesGroup.versionField.setRequired(false);
		propertiesGroup.versionField.setErrorMessage(null);
		return true;
	}

}
