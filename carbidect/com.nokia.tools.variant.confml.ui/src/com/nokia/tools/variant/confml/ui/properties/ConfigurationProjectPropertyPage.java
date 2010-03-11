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

package com.nokia.tools.variant.confml.ui.properties;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IWorkbenchPropertyPage;
import org.eclipse.ui.dialogs.PropertyPage;

import com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata;
import com.nokia.tools.variant.confml.core.model.metadata.EMetadataFactory;
import com.nokia.tools.variant.confml.core.model.metadata.util.ECPFMetadataResourceFactoryImpl;
import com.nokia.tools.variant.confml.ui.ConfmlUI;
import com.nokia.tools.vct.common.core.utils.PlatformUtil;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.DialogField;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.IDialogFieldListener;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.LayoutUtil;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.SelectionButtonDialogField;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.StringDialogField;
import com.nokia.tools.vct.confml.model.confml1.include.EInclude;
import com.nokia.tools.vct.confml.model.confml1.util.EConfML1ResourceFactoryImpl;

/**
 * This class contributes into property pages with Layer Information.
 * 
 */

public class ConfigurationProjectPropertyPage extends PropertyPage implements
		IWorkbenchPropertyPage {

	private final class PropertiesGroup extends Observable implements
			IDialogFieldListener {
		protected final SelectionButtonDialogField projectDefaultRadio;
		protected final SelectionButtonDialogField projectCustomRadio;
		protected final StringDialogField rootConfmlFile;
		protected final StringDialogField dataOverrideFile;
		protected final StringDialogField viewId;

		public PropertiesGroup() {
			projectDefaultRadio = new SelectionButtonDialogField(SWT.RADIO);
			projectDefaultRadio
					.setLabelText("Use default configuration project options");
			projectDefaultRadio.setDialogFieldListener(this);

			projectCustomRadio = new SelectionButtonDialogField(SWT.RADIO);
			projectCustomRadio
					.setLabelText("Use custom configuration project options");
			projectCustomRadio.setDialogFieldListener(this);

			rootConfmlFile = new StringDialogField();
			rootConfmlFile.setLabelText("Root File:");
			rootConfmlFile.setDialogFieldListener(this);
			dataOverrideFile = new StringDialogField();
			dataOverrideFile.setLabelText("Data Override File:");
			dataOverrideFile.setDialogFieldListener(this);
			viewId = new StringDialogField();
			viewId.setLabelText("View Name:");
			viewId.setDialogFieldListener(this);

			projectCustomRadio.attachDialogFields(new DialogField[] {
					rootConfmlFile, dataOverrideFile, viewId });
			projectDefaultRadio.setSelection(true);
			projectCustomRadio.setSelection(false);
		}

		public Control createControl(Composite composite) {
			final int numColumns = 3;

			final Group group = new Group(composite, SWT.NONE);
			group.setLayout(new GridLayout(numColumns, false));
			group.setText("Configuration Project Defaults");

			projectDefaultRadio.doFillIntoGrid(group, numColumns);
			projectCustomRadio.doFillIntoGrid(group, numColumns);
			rootConfmlFile.doFillIntoGrid(group, numColumns);
			dataOverrideFile.doFillIntoGrid(group, numColumns);
			viewId.doFillIntoGrid(group, numColumns);
			LayoutUtil.setHorizontalGrabbing(projectDefaultRadio
					.getSelectionButton(null));
			LayoutUtil.setHorizontalGrabbing(projectCustomRadio
					.getSelectionButton(null));
			LayoutUtil.setHorizontalGrabbing(rootConfmlFile
					.getTextControl(null));
			LayoutUtil.setHorizontalGrabbing(dataOverrideFile
					.getTextControl(null));
			LayoutUtil.setHorizontalGrabbing(viewId.getTextControl(null));
			return group;
		}

		private void fireEvent() {
			setChanged();
			notifyObservers();
		}

		public void dialogFieldChanged(DialogField field) {
			fireEvent();
		}

		public boolean useDefaults() {
			return projectDefaultRadio.isSelected();
		}

		public String getDataOverrideFile() {
			String value = dataOverrideFile.getText().trim();
			return value.length() == 0 ? null : value;
		}

		public void setDataOverrideFile(String value) {
			dataOverrideFile.setText(value == null ? "" : value.trim());
		}

		public String getRootConfmlFile() {
			String value = rootConfmlFile.getText().trim();
			return value.length() == 0 ? null : value;
		}

		public void setRootConfmlFile(String value) {
			rootConfmlFile.setText(value == null ? "" : value.trim());
		}

		public String getViewId() {
			String value = viewId.getText().trim();
			return value.length() == 0 ? null : value;
		}

		public void setViewId(String value) {
			viewId.setText(value == null ? "" : value.trim());
		}
	}

	final class Validator implements Observer {
		public Validator() {
			super();
		}

		public void update(Observable o, Object arg) {
			String dataFileName = null;
			String rootFileName = null;
			if (properties.useDefaults()) {
				properties.dataOverrideFile.setErrorMessage(null);
				properties.rootConfmlFile.setErrorMessage(null);
				properties.dataOverrideFile.setWarningMessage(null);
				properties.rootConfmlFile.setWarningMessage(null);
				properties.viewId.setWarningMessage(null);
				properties.viewId.setWarningMessage(null);
				
				setValid(true);
				setMessage(null);
				setMessage(null, WARNING);
				setErrorMessage(null);
				return;
			} else {
				dataFileName = properties.getDataOverrideFile();
				rootFileName = properties.getRootConfmlFile();
			}
			properties.dataOverrideFile.setErrorMessage(null);
			properties.rootConfmlFile.setErrorMessage(null);
			properties.dataOverrideFile.setWarningMessage(null);
			properties.rootConfmlFile.setWarningMessage(null);
			properties.viewId.setWarningMessage(null);
			properties.viewId.setWarningMessage(null);
			
			if (dataFileName == null) {
				dataFileName = "data.confml";
			}
			if (rootFileName == null) {
				rootFileName = "root.confml";
			}

			IFile rootFile = project.getFile(rootFileName);
			if (!rootFile.isAccessible()) {
				properties.rootConfmlFile
						.setErrorMessage("File does not exist");
				properties.dataOverrideFile
						.setWarningMessage("Can not validate value");
			} else {
				URI rootFileURI = URI.createPlatformResourceURI(rootFile
						.getFullPath().toPortableString(), true);
				Resource resource = new EConfML1ResourceFactoryImpl()
						.createResource(rootFileURI);
				try {
					resource.load(null);
				} catch (IOException e) {
					e.printStackTrace();
				}
				TreeIterator<Object> it = EcoreUtil.getAllContents(resource,
						false);
				EInclude lastInclude = null;
				while (it.hasNext()) {
					Object obj = it.next();
					if (obj instanceof EInclude) {
						lastInclude = (EInclude) obj;
					}
				}
				if (lastInclude == null) {
					properties.rootConfmlFile
							.setErrorMessage("Root does not contain layers");
					properties.dataOverrideFile
							.setWarningMessage("Can not validate value");
				} else {
					URI layerRootURI = URI.createURI(lastInclude.getHref())
							.resolve(rootFileURI);
					IFile layerRootFile = project.getParent().getFile(
							new Path(layerRootURI.toPlatformString(true)));
					IContainer parent = layerRootFile.getParent();
					IContainer confmlFolder = parent.getFolder(new Path(
							"confml"));
					if (!confmlFolder.isAccessible()) {
						while (parent instanceof IFolder) {
							if (parent.getName().equals("confml")) {
								confmlFolder = (IFolder) parent;
								break;
							}
						}
						confmlFolder = project;
					}
					IFile dataFile = confmlFolder
							.getFile(new Path(dataFileName));

					if (!dataFile.isAccessible()) {
						properties.dataOverrideFile
								.setErrorMessage("Data file does not exist: "+dataFile.getProjectRelativePath());
					}
				}
			}

			setValid(properties.rootConfmlFile.getErrorMessage() == null
					&& properties.dataOverrideFile.getErrorMessage() == null);
			setErrorMessage(isValid() ? null : "Check values");
		}

	}

	// private EVariantProject projectModel;
	private IProject project;

	private ECPFMetadata cpfMetadata;
	private Resource cpfResource;
	private final Validator validator;
	private final PropertiesGroup properties;

	static final Pattern VALIDATOR_ID_PATTERN = Pattern
			.compile("\\w+(\\.\\w+)*");
	static final Pattern VALIDATOR_VERSION_PATTERN = Pattern
			.compile("\\d+(\\.\\d+(\\.\\d+(\\.\\w+)?)?)?");

	public ConfigurationProjectPropertyPage() {
		this.noDefaultAndApplyButton();
		validator = new Validator();
		properties = new PropertiesGroup();
		properties.addObserver(validator);
	}

	@Override
	protected Control createContents(Composite parent) {
		final Composite composite = new Composite(parent, SWT.NONE);
		composite.setFont(parent.getFont());
		composite.setLayout(new GridLayout(1, true));

		Control layoutControl = properties.createControl(composite);
		GridData gd = new GridData(SWT.FILL, SWT.FILL, true, false);
		layoutControl.setLayoutData(gd);

		setPropertiesValues();

		return composite;
	}

	public void setPropertiesValues() {
		if (cpfMetadata == null) {
			properties.projectCustomRadio.setSelection(false);
			properties.projectDefaultRadio.setSelection(true);
			properties.dataOverrideFile.setText("data.confml");
			properties.rootConfmlFile.setText("root.confml");
			properties.viewId.setText("");
		} else {
			properties.projectCustomRadio.setSelection(true);
			properties.projectDefaultRadio.setSelection(false);
			properties.setDataOverrideFile(cpfMetadata
					.getDataOverrideFile());
			properties.setRootConfmlFile(cpfMetadata.getCpfRootFile());
			properties.setViewId(cpfMetadata.getViewId());
		}
	}

	private void populateSettings() {
		if (properties.useDefaults()) {
			cpfMetadata = null;
			cpfResource.unload();
		} else {
			cpfMetadata = EMetadataFactory.eINSTANCE.createECPFMetadata();
			cpfMetadata.setDataOverrideFile(properties.getDataOverrideFile());
			cpfMetadata.setCpfRootFile(properties.getRootConfmlFile());
			cpfMetadata.setViewId(properties.getViewId());

			cpfResource.unload();
			cpfResource.getContents().add(cpfMetadata);
		}

	}

	@Override
	public boolean performOk() {
		populateSettings();

		IWorkspaceRunnable saveAction = new IWorkspaceRunnable() {
			public void run(IProgressMonitor monitor) throws CoreException {
				if (cpfMetadata != null) {
					try {
						cpfResource.save(null);
					} catch (IOException e) {
						throw new CoreException(new Status(IStatus.ERROR,
								ConfmlUI.PLUGIN_ID, "Failed to save", e));
					}
				} else {
					IFile metaFile = project.getFile(".metadata");
					if (metaFile.exists()) {
						metaFile.delete(true, null);
					}
				}
			}
		};

		try {
			ResourcesPlugin.getWorkspace().run(saveAction, project,
					IWorkspace.AVOID_UPDATE, null);
		} catch (CoreException e) {
			ConfmlUI.logWarning(e);
			return false;
		}

		return true;
	}

	@Override
	public void setElement(IAdaptable element) {
		super.setElement(element);

		project = PlatformUtil.getAdapter(element, IProject.class, false);
		final IFile metadataFile = project.getFile(".metadata");
		cpfResource = new ECPFMetadataResourceFactoryImpl().createResource(URI
				.createPlatformResourceURI(metadataFile.getFullPath()
						.toPortableString(), true));

		if (!metadataFile.isAccessible()) {
			cpfResource.unload();
			cpfMetadata = null;
			return;
		}

		try {
			cpfResource.load(null);
			cpfMetadata = (ECPFMetadata) cpfResource.getContents().get(0);
		} catch (Exception e) {
			ConfmlUI.logWarning(e);
			cpfResource.unload();
			cpfResource = null;
			return;
		}
	}

}
