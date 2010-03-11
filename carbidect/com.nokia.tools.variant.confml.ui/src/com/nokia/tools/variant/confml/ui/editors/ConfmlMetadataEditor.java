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

package com.nokia.tools.variant.confml.ui.editors;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.views.navigator.ResourceComparator;

import com.nokia.tools.variant.confml.ui.ConfmlUI;
import com.nokia.tools.variant.confml.ui.dialogs.FileSelectionContentProvider;
import com.nokia.tools.variant.confml.ui.dialogs.FileSelectionLabelProvider;
import com.nokia.tools.variant.confml.ui.dialogs.IconSelectionDialog;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.DialogField;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.IDialogFieldListener;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.IStringButtonAdapter;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.LayoutUtil;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.StringButtonDialogField;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.StringDialogField;
import com.nokia.tools.vct.confml.model.confml1.EConfML1Factory;
import com.nokia.tools.vct.confml.model.confml1.EMetaContent;



//import com.nokia.tools.vct.confml.model.confml2.EConfML2Factory;
//import com.nokia.tools.vct.confml.model.confml2.EConfML2Document;
//import com.nokia.tools.vct.confml.model.confml2.EConfigurationElement;
//import com.nokia.tools.vct.confml.model.confml2.EDataElement;
//import com.nokia.tools.vct.confml.model.confml2.EDescriptionElement;
//import com.nokia.tools.vct.confml.model.confml2.EFeatureElement;
//import com.nokia.tools.vct.confml.model.confml2.EIconElement;
//import com.nokia.tools.vct.confml.model.confml2.ELinkElement;
//import com.nokia.tools.vct.confml.model.confml2.EMetaContent;
//import com.nokia.tools.vct.confml.model.confml2.EMetaElement;
//import com.nokia.tools.vct.confml.model.confml2.ERfsElement;
//import com.nokia.tools.vct.confml.model.confml2.EViewElement;
//import com.nokia.tools.vct.confml.model.confml2.util.EConfML2ResourceFactoryImpl;

public class ConfmlMetadataEditor extends EditorPart implements
		IDialogFieldListener {


	private Resource confMLResource;
	private StringDialogField customerField;
	private StringDialogField dateField;

	private StringDialogField descriptionField;
	private StringDialogField descriptionTitleField;
	private StringButtonDialogField descriptionUriField;

	private StringDialogField editorField;

	private IFile file;
	private Form form;
	private StringDialogField iconTitleField;
	private StringButtonDialogField iconUriField;

	// Metadata
	private StringDialogField idField;
	private boolean isDirty = false;
	private StringDialogField linkTitleField;
	private StringDialogField linkUriField;

	// Configuration settings
	private StringDialogField nameField;
	private StringDialogField ownerField;
	private StringDialogField platformField;

	private StringDialogField productField;
	private StringDialogField releaseField;
	private StringDialogField statusField;
	private FormToolkit toolkit;
	private StringDialogField versionField;

	private int version = 1;
	
	static final int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	/**
	 * Constructs the editor, currently does nothing.
	 */
	public ConfmlMetadataEditor() {
	}

	private StringButtonDialogField appendSelection(String label,
			String buttonLabel, IStringButtonAdapter adapter, Composite parent,
			int numCols, boolean horizontalGrab) {

		StringButtonDialogField field = new StringButtonDialogField(adapter);
		field.setDialogFieldListener(this);
		field.setLabelText(label);
		field.setButtonLabel(buttonLabel);
		field.doFillIntoGrid(parent, numCols);
		if (horizontalGrab)
			LayoutUtil.setHorizontalGrabbing(field.getTextControl(null));
		return field;
	}

	/**
	 * Helper method to release duplicate code for dialog field creation
	 * 
	 * 
	 * @param label
	 *            field label to use
	 * @param parent
	 *            parent to append the field to
	 * @param numCols
	 *            the number of columns to span
	 * @param horizontalGrab
	 *            should the control grab horizontal space or not
	 * @return the created control
	 */
	private StringDialogField appendString(String label, Composite parent,
			int numCols, boolean horizontalGrab) {
		StringDialogField field = new StringDialogField();
		field.setDialogFieldListener(this);
		field.setLabelText(label);
		field.doFillIntoGrid(parent, 3);

		if (horizontalGrab)
			LayoutUtil.setHorizontalGrabbing(field.getTextControl(null));
		return field;
	}

	/**
	 * Appends configuration element related controls for the given form.
	 * 
	 * 
	 */
	private void createConfigurationControls() {
		// Create non-contracting (or expanding) section
		Section section = toolkit.createSection(form.getBody(),
				Section.TITLE_BAR | Section.EXPANDED);
		section.setText("Configuration Properties");
		section.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		// Create the contents (client area) of the
		// section
		Composite sectionClient = toolkit.createComposite(section);
		sectionClient.setLayout(new GridLayout(3, false));
		// IMPROVEMENT Fill section client contents horizontally

		// Name, Version & Description
		nameField = appendString("Name :", sectionClient, 3, true);
		// IMPROVEMENT This is a field that should not be filled horizontally
		versionField = appendString("Version :", sectionClient, 3, true);
		// IMPROVEMENT Description field should be multiline
		descriptionField = appendString("Description :", sectionClient, 3, true);

		descriptionTitleField = appendString("Description Title:",
				sectionClient, 3, true);

		IStringButtonAdapter selectDescriptionAdapter = new IStringButtonAdapter() {

			public void changeControlPressed(DialogField field) {
				ElementTreeSelectionDialog dlg = new ElementTreeSelectionDialog(
						Display.getCurrent().getActiveShell(),
						new FileSelectionLabelProvider(),
						new FileSelectionContentProvider());

				IProject project = file.getProject();
				dlg.setInput(project);
				dlg.setTitle("File selection dialog");
				dlg.setAllowMultiple(false);
				dlg.setMessage("Select a file:");
				dlg.setValidator(new ISelectionStatusValidator() {
					public IStatus validate(Object[] selection) {
						if (selection.length == 1
								&& selection[0] instanceof IFile) {
							return Status.OK_STATUS;
						} else {
							return new Status(IStatus.ERROR,
									ConfmlUI.PLUGIN_ID, "Select a file");
						}
					}
				});

				IPath path = new Path(descriptionUriField.getText().trim());
				if (!path.isEmpty()
						&& project.getFile(path).exists()) {
					IFile initial = project.getFile(path);

					dlg.setInitialSelection(initial);
				}

				dlg.setComparator(new ResourceComparator(
						ResourceComparator.TYPE));

				if (dlg.open() == ElementTreeSelectionDialog.OK) {
					IFile choosenImage = (IFile) dlg.getFirstResult();
					URI uri = project.getLocationURI().relativize(
							choosenImage.getLocationURI());
					descriptionUriField.setText(uri.toString());
				}
			}
		};

		descriptionUriField = appendSelection("Description URI:", "Select...",
				selectDescriptionAdapter, sectionClient, 3, true);

		// Icon
		iconTitleField = appendString("Icon Title: ", sectionClient, 3, true);

		IStringButtonAdapter selectIconAdapter = new IStringButtonAdapter() {
			public void changeControlPressed(DialogField field) {
				IconSelectionDialog dlg = new IconSelectionDialog(Display
						.getCurrent().getActiveShell());
				dlg.setAllowMultiple(false);

				IProject project = file.getProject();
				dlg.setInput(project);

				IPath path = new Path(iconUriField.getText().trim());
				if (!path.isEmpty()
						&& project.getFile(path).exists()) {
					IFile initial = project.getFile(path);
					dlg.setInitialSelection(initial);
				}

				dlg.setMessage("Select an icon:");

				if (dlg.open() == ElementTreeSelectionDialog.OK) {
					IFile choosenImage = (IFile) dlg.getFirstResult();
					URI uri = project.getLocationURI().relativize(
							choosenImage.getLocationURI());
					iconUriField.setText(uri.toString());
				}
			}
		};

		iconUriField = appendSelection("Icon URI:", "Select...",
				selectIconAdapter, sectionClient, 3, true);

		// Link
		linkTitleField = appendString("Link Title:", sectionClient, 3, true);

		linkUriField = appendString("Link URI:", sectionClient, 3, true);

		// Set the client area to the section
		section.setClient(sectionClient);
	}

	/**
	 * Appends metadata controls for the given form.
	 * 
	 * Expects that form and toolkit have already been initialized.
	 * 
	 * 
	 */
	private void createMetadataControls() {
		// Create non-contracting (or expanding) section
		Section section = toolkit.createSection(form.getBody(),
				Section.TITLE_BAR | Section.EXPANDED);
		section.setText("Configuration Metadata");
		section.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		// Create the contents (client area) of the
		// section
		Composite sectionClient = toolkit.createComposite(section);
		sectionClient.setLayout(new GridLayout(3, false));
		// IMPROVEMENT Fill section client contents horizontally

		// Append Id, Date, Owner, Editor, Status, Platform,
		// Product, Release, Customer
		idField = appendString("Id :", sectionClient, 3, false);
		dateField = appendString("Date :", sectionClient, 3, true);
		ownerField = appendString("Owner :", sectionClient, 3, true);
		editorField = appendString("Editor :", sectionClient, 3, true);
		statusField = appendString("Status :", sectionClient, 3, true);
		platformField = appendString("Platform :", sectionClient, 3, true);
		productField = appendString("Product :", sectionClient, 3, true);
		releaseField = appendString("Release :", sectionClient, 3, true);
		customerField = appendString("Customer :", sectionClient, 3, true);

		// Set the client area to the section
		section.setClient(sectionClient);
	}

	/**
	 * Creates the UI controls using form toolkit.
	 * 
	 * Expects that form and toolkit have already been initialized.
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createPartControl(Composite parent) {
		ScrolledComposite sc = new ScrolledComposite(parent, SWT.V_SCROLL);

		Composite composite = new Composite(sc, SWT.NONE);
		composite.setLayout(new FillLayout());

		// Create the toolkit & form to be utilized.
		// Will be disposed on call to dispose()
		toolkit = new FormToolkit(composite.getDisplay());
		form = toolkit.createForm(composite);

		// Create decorated title for the editor
		toolkit.decorateFormHeading(form);
		form.setText("Overview");

		// Set form layout
		form.getBody().setLayout(new GridLayout());

		// Create configuration & common attributes
		// specific part
		createConfigurationControls();

		// Create metadata specific part
		createMetadataControls();

		// Set values from confml file
		setInitialValues();

		// ScrolledComposite setting
		sc.setContent(composite);
		sc.setExpandHorizontal(true);
		sc.setExpandVertical(true);
		sc.setMinSize(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));
	}

	public void dialogFieldChanged(DialogField field) {
		setDirty(true);
		
		String dateString = dateField.getText();
		
		if (dateString!=null && !dateString.trim().equals(""))
		{
			boolean ok = false;
			if (dateString.matches("\\d\\d\\d\\d-\\d\\d-\\d\\d")) //YYYY-MM-DD
			{
				String[] split = dateString.split("-");
				ok = checkCalendar(split);
			}
			if (!ok)
				dateField.setErrorMessage("Invalid date format. Correct format is YYYY-MM-DD");
			else
				dateField.setErrorMessage(null);
				
		}
		else
			dateField.setErrorMessage(null);
	}

	/**
	 * Cleans up the editor. Disposes form toolkit.
	 * 
	 * @see org.eclipse.ui.forms.widgets.FormToolkit
	 * @see org.eclipse.ui.part.WorkbenchPart#dispose()
	 */
	@Override
	public void dispose() {
		super.dispose();

		// Dispose form toolkit here to cover the
		// form toolkit contract (create on init,
		// dispose on close)
		form.dispose();
		toolkit.dispose();
	}

	/**
	 * 
	 * 
	 * @see org.eclipse.ui.part.EditorPart#doSave(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void doSave(IProgressMonitor monitor) {
		try {
			populateSettings();

			// IMPROVEMENT I cannot understand why we first need to
			// persist into memory, then to real stream
			confMLResource.save(null);

			// In the end, if everything works properly, we can
			// clear the dirty flag
			setDirty(false);

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * 
	 * 
	 * @see org.eclipse.ui.part.EditorPart#doSaveAs()
	 */
	@Override
	public void doSaveAs() {
		

	}

	/**
	 * Initialize the editor. Sets the given site & input, creates toolkit for
	 * rendering the controls
	 * 
	 * @see org.eclipse.ui.part.EditorPart#init(org.eclipse.ui.IEditorSite,
	 *      org.eclipse.ui.IEditorInput)
	 */
	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		setSite(site);
		setInput(input);

		
		if (input instanceof IFileEditorInput) {
			IFileEditorInput fei = (IFileEditorInput) input;
			file = fei.getFile();
		} else {
			file = (IFile) input.getAdapter(IFile.class);
		}
		String path = file.getFullPath().toPortableString();
		org.eclipse.emf.common.util.URI uri = org.eclipse.emf.common.util.URI
				.createPlatformResourceURI(path, true);
		Resource.Factory factory = new com.nokia.tools.vct.confml.model.confml1.util.EConfML1ResourceFactoryImpl();
		confMLResource = factory.createResource(uri);

		try {
			confMLResource.load(null);
		} catch (IOException e1) {
			
			e1.printStackTrace();
			throw new PartInitException("Ecore Load Error", e1);
		}
		setPartName(file.getName());

	}

	/**
	 * Determines whether the editor has unsaved changes
	 * 
	 * @see org.eclipse.ui.part.EditorPart#isDirty()
	 */
	@Override
	public boolean isDirty() {
		
		return isDirty;
	}

	/**
	 * 
	 * @see org.eclipse.ui.part.EditorPart#isSaveAsAllowed()
	 */
	@Override
	public boolean isSaveAsAllowed() {
		
		return false;
	}

	private void populateSettings() throws URISyntaxException {
		// configuration part
		
		
		Object obj = getTopConfiguration();
		
		if (obj instanceof com.nokia.tools.vct.confml.model.confml1.EConfigurationElement)
		{
			com.nokia.tools.vct.confml.model.confml1.EConfigurationElement conf = (com.nokia.tools.vct.confml.model.confml1.EConfigurationElement) obj;
			populateSettings1(conf);
		}
		else
		{
			com.nokia.tools.vct.confml.model.confml2.EConfigurationElement conf = (com.nokia.tools.vct.confml.model.confml2.EConfigurationElement)obj;
			populateSettings2(conf);
		}
		
	}
		
		private void populateSettings1(com.nokia.tools.vct.confml.model.confml1.EConfigurationElement conf) throws URISyntaxException 
		{	
		
		conf.getMetas().clear();
		com.nokia.tools.vct.confml.model.confml1.EMetaElement meta = com.nokia.tools.vct.confml.model.confml1.EConfML1Factory.eINSTANCE.createEMetaElement();
		conf.getMetas().add(meta);
		conf.getDescriptions().clear();

		if (nameField.getText().trim().length() != 0) {
			conf.setName(nameField.getText().trim());
		} else {
			conf.setName(null);
		}

		if (versionField.getText().trim().length() != 0) {
			conf.setVersion(versionField.getText().trim());
		} else {
			conf.setVersion(null);
		}

		if (descriptionField.getText().trim().length() != 0) {
			com.nokia.tools.vct.confml.model.confml1.EDescriptionElement descr = null;
			if ( !conf.getDescriptions().isEmpty()) 
			{
				descr = conf.getDescriptions().get(0); 
			}
			if (descr == null)
			{
				descr = com.nokia.tools.vct.confml.model.confml1.EConfML1Factory.eINSTANCE.createEDescriptionElement();
			}
			descr.setDescription(descriptionField.getText().trim());
			conf.getDescriptions().add(descr);
		}

		if (descriptionUriField.getText().trim().length() != 0 || descriptionTitleField.getText().trim().length() != 0) {
			com.nokia.tools.vct.confml.model.confml1.EDescriptionElement descr = null;
			if ( conf.getDescriptions() != null && conf.getDescriptions().size() > 1)
			{
				descr = conf.getDescriptions().get(1);
			}
			if ( descr == null)
			{
				descr =  com.nokia.tools.vct.confml.model.confml1.EConfML1Factory.eINSTANCE.createEDescriptionElement();
				
			}
			descr.setHref(descriptionUriField.getText().trim());
			descr.setTitle(descriptionTitleField.getText().trim());
			conf.getDescriptions().add(descr);
		} 
		
		if (iconTitleField.getText().trim().length() != 0 || iconUriField.getText().trim().length() != 0) {
			com.nokia.tools.vct.confml.model.confml1.EIconElement icon = null; 
			if 	(!conf.getIcons().isEmpty())
			{
				icon = conf.getIcons().get(0);
			}
			if (icon == null)
			{
				icon = com.nokia.tools.vct.confml.model.confml1.EConfML1Factory.eINSTANCE.createEIconElement();
			}
			icon.setHref(iconUriField.getText().trim());
			icon.setTitle(iconTitleField.getText().trim());
			conf.getIcons().add(icon);
		}

		if (linkTitleField.getText().trim().length() != 0 || linkUriField.getText().trim().length() != 0) {
			com.nokia.tools.vct.confml.model.confml1.ELinkElement link = null;
			if ( !conf.getLinks().isEmpty())
			{
				link =  conf.getLinks().get(0);
				
			}
			if (link == null)
			{
				link = com.nokia.tools.vct.confml.model.confml1.EConfML1Factory.eINSTANCE.createELinkElement();
			}
			link.setHref(linkUriField.getText().trim());
			link.setTitle(linkTitleField.getText().trim());
			conf.getLinks().add(link);
		}

		// metadata part

		addContent1(meta.getCustomer(), customerField);
		addContent1(meta.getDate(), dateField);
		addContent1(meta.getEditor(), editorField);
		addContent1(meta.getId(), idField);
		addContent1(meta.getOwner(), ownerField);
		addContent1(meta.getPlatform(), platformField);
		addContent1(meta.getProduct(), productField);
		addContent1(meta.getRelease(), releaseField);
		addContent1(meta.getStatus(), statusField);
		addContent1(meta.getVersion(), versionField);
		
	}

		
		private void populateSettings2(com.nokia.tools.vct.confml.model.confml2.EConfigurationElement conf) throws URISyntaxException 
		{	
		
		conf.getMetas().clear();
		com.nokia.tools.vct.confml.model.confml2.EMetaElement meta = com.nokia.tools.vct.confml.model.confml2.EConfML2Factory.eINSTANCE.createEMetaElement();
		conf.getMetas().add(meta);
		conf.getDescriptions().clear();

		if (nameField.getText().trim().length() != 0) {
			conf.setName(nameField.getText().trim());
		} else {
			conf.setName(null);
		}

		if (versionField.getText().trim().length() != 0) {
			conf.setVersion(versionField.getText().trim());
		} else {
			conf.setVersion(null);
		}

		if (descriptionField.getText().trim().length() != 0) {
			com.nokia.tools.vct.confml.model.confml2.EDescriptionElement descr = null;
			if ( !conf.getDescriptions().isEmpty()) 
			{
				descr = conf.getDescriptions().get(0); 
			}
			if (descr == null)
			{
				descr = com.nokia.tools.vct.confml.model.confml2.EConfML2Factory.eINSTANCE.createEDescriptionElement();
			}
			descr.setDescription(descriptionField.getText().trim());
			conf.getDescriptions().add(descr);
		}

		if (descriptionUriField.getText().trim().length() != 0 || descriptionTitleField.getText().trim().length() != 0) {
			com.nokia.tools.vct.confml.model.confml2.EDescriptionElement descr = null;
			if ( conf.getDescriptions() != null && conf.getDescriptions().size() > 1)
			{
				descr = conf.getDescriptions().get(1);
			}
			if ( descr == null)
			{
				descr =  com.nokia.tools.vct.confml.model.confml2.EConfML2Factory.eINSTANCE.createEDescriptionElement();
				
			}
			descr.setHref(descriptionUriField.getText().trim());
			descr.setTitle(descriptionTitleField.getText().trim());
			conf.getDescriptions().add(descr);
		} 
		
		if (iconTitleField.getText().trim().length() != 0 || iconUriField.getText().trim().length() != 0) {
			com.nokia.tools.vct.confml.model.confml2.EIconElement icon = null; 
			if 	(!conf.getIcons().isEmpty())
			{
				icon = conf.getIcons().get(0);
			}
			if (icon == null)
			{
				icon = com.nokia.tools.vct.confml.model.confml2.EConfML2Factory.eINSTANCE.createEIconElement();
			}
			icon.setHref(iconUriField.getText().trim());
			icon.setTitle(iconTitleField.getText().trim());
			conf.getIcons().add(icon);
		}

		if (linkTitleField.getText().trim().length() != 0 || linkUriField.getText().trim().length() != 0) {
			com.nokia.tools.vct.confml.model.confml2.ELinkElement link = null;
			if ( !conf.getLinks().isEmpty())
			{
				link =  conf.getLinks().get(0);
				
			}
			if (link == null)
			{
				link = com.nokia.tools.vct.confml.model.confml2.EConfML2Factory.eINSTANCE.createELinkElement();
			}
			link.setHref(linkUriField.getText().trim());
			link.setTitle(linkTitleField.getText().trim());
			conf.getLinks().add(link);
		}

		// metadata part

		addContent2(meta.getCustomer(), customerField);
		addContent2(meta.getDate(), dateField);
		addContent2(meta.getEditor(), editorField);
		addContent2(meta.getId(), idField);
		addContent2(meta.getOwner(), ownerField);
		addContent2(meta.getPlatform(), platformField);
		addContent2(meta.getProduct(), productField);
		addContent2(meta.getRelease(), releaseField);
		addContent2(meta.getStatus(), statusField);
		addContent2(meta.getVersion(), versionField);
		
	}
	
		
		
	private void addContent1(EList<com.nokia.tools.vct.confml.model.confml1.EMetaContent> content, StringDialogField field) {
		if (field.getText().trim().length() == 0) {
			content.clear();
		} else {
			EMetaContent element = EConfML1Factory.eINSTANCE.createEMetaContent();
			element.setValue(field.getText().trim());
			content.add(element);
		}
	}

	private void addContent2(EList<com.nokia.tools.vct.confml.model.confml2.EMetaContent> content, StringDialogField field) {
		if (field.getText().trim().length() == 0) {
			content.clear();
		} else {
			com.nokia.tools.vct.confml.model.confml2.EMetaContent element = com.nokia.tools.vct.confml.model.confml2.EConfML2Factory.eINSTANCE.createEMetaContent();
			element.setValue(field.getText().trim());
			content.add(element);
		}
	}
	
	
	private void setDirty(boolean isDirty) {
		this.isDirty = isDirty;
		firePropertyChange(IEditorPart.PROP_DIRTY);
	}

	/**
	 * Sets the focus for the root element of the page, e.g. the. form that
	 * embeds the other controls.
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	@Override
	public void setFocus() {
		form.setFocus();
	}

	private void setInitialValues() {
		// configuration part
		// if (confMLResource.getName() != null)
		// nameField.setText(confMLResource.getName());
		// if (confMLResource.getVersion() != null)
		// versionField.setText(confMLResource.getVersion());
		// if (confMLResource.getDescription() != null)
		// descriptionField.setText(confMLResource.getDescription());
		// if (confMLResource.getDescriptionTitle() != null)
		// descriptionTitleField.setText(confMLResource.getDescriptionTitle());
		// if (confMLResource.getDescriptionUri() != null)
		// descriptionUriField.setText(confMLResource.getDescriptionUri()
		// .toString());
		// if (confMLResource.getIconTitle() != null)
		// iconTitleField.setText(confMLResource.getIconTitle());
		// if (confMLResource.getIconUri() != null)
		// iconUriField.setText(confMLResource.getIconUri().toString());
		// if (confMLResource.getLinkTitle() != null)
		// linkTitleField.setText(confMLResource.getLinkTitle());
		// if (confMLResource.getLinkUri() != null)
		// linkUriField.setText(confMLResource.getLinkUri().toString());

		// metadata part
		
		
		Object obj = getTopConfiguration();
		
		if (obj instanceof com.nokia.tools.vct.confml.model.confml1.EConfigurationElement)
		{
			com.nokia.tools.vct.confml.model.confml1.EConfigurationElement conf = (com.nokia.tools.vct.confml.model.confml1.EConfigurationElement) obj;
			setInitialValues1(conf);
		}
		else if (obj instanceof com.nokia.tools.vct.confml.model.confml2.EConfigurationElement)
		{
			com.nokia.tools.vct.confml.model.confml2.EConfigurationElement conf = (com.nokia.tools.vct.confml.model.confml2.EConfigurationElement)obj;
			setInitialValues2(conf);
		}
	}	
		private void setInitialValues1(com.nokia.tools.vct.confml.model.confml1.EConfigurationElement conf) 
		{		
		
			com.nokia.tools.vct.confml.model.confml1.EMetaElement meta = null;
		if (!conf.getMetas().isEmpty()) {
			meta = conf.getMetas().get(0);
		}

		if (conf.getName() != null) {
			nameField.setText(conf.getName());
		}
		if (conf.getVersion() != null) {
			versionField.setText(conf.getVersion());
		}

		if (!conf.getDescriptions().isEmpty())
		{
			String value = conf.getDescriptions().get(0).getDescription();
			if (value == null) value = "";
			descriptionField.setText(value);
		}

		if (!conf.getDescriptions().isEmpty())
		{
			String value = conf.getDescriptions().get(1).getHref();
			if (value == null) value = "";
			
			descriptionUriField.setText(value);
		}
		
		if (!conf.getDescriptions().isEmpty())
		{
			String value = conf.getDescriptions().get(1).getTitle();
			if (value == null) value = "";
			
			descriptionTitleField.setText(value);
		}
		
		if (!conf.getIcons().isEmpty())
		{
			String value = conf.getIcons().get(0).getTitle();
			if (value == null) value = "";
			iconTitleField.setText(value);
		}
		
		if (!conf.getIcons().isEmpty())
		{
			String value = conf.getIcons().get(0).getHref();
			if (value == null) value = "";
			iconUriField.setText(value);
		}

		if (!conf.getLinks().isEmpty())
		{
			String value = conf.getLinks().get(0).getHref();
			if (value == null) value = "";
			linkUriField.setText(value);
		}

		if (!conf.getLinks().isEmpty())
		{
			String value = conf.getLinks().get(0).getTitle();
			if (value == null) value = "";
			linkTitleField.setText(value);
		}
		
		
		
		if (meta != null) {
		if (!meta.getId().isEmpty())
			idField.setText(meta.getId().get(0).getValue());
		if (!meta.getDate().isEmpty()) {
			dateField.setText(meta.getDate().get(0).getValue());
		}
		
		if (!meta.getOwner().isEmpty())
			ownerField.setText(meta.getOwner().get(0).getValue());
		if (!meta.getEditor().isEmpty())
			editorField.setText(meta.getEditor().get(0).getValue());
		if (!meta.getStatus().isEmpty())
			statusField.setText(meta.getStatus().get(0).getValue());
		if (!meta.getPlatform().isEmpty())
			platformField.setText(meta.getPlatform().get(0).getValue());
		if (!meta.getProduct().isEmpty())
			productField.setText(meta.getProduct().get(0).getValue());
		if (!meta.getRelease().isEmpty())
			releaseField.setText(meta.getRelease().get(0).getValue());
		if (!meta.getCustomer().isEmpty())
			customerField.setText(meta.getCustomer().get(0).getValue());
		
		
		}

		setDirty(false);
	}

		
		
		private void setInitialValues2(com.nokia.tools.vct.confml.model.confml2.EConfigurationElement conf) 
		{		
	
		com.nokia.tools.vct.confml.model.confml2.EMetaElement meta = null;
		
		if (!conf.getMetas().isEmpty()) {
			meta = conf.getMetas().get(0);
			
		}

		if (conf.getName() != null) {
			nameField.setText(conf.getName());
		}
		if (conf.getVersion() != null) {
			versionField.setText(conf.getVersion());
		}

		if (!conf.getDescriptions().isEmpty())
		{
			String value = conf.getDescriptions().get(0).getDescription();
			if (value == null) value = "";
			descriptionField.setText(value);
		}

		if (!conf.getDescriptions().isEmpty())
		{
			String value = conf.getDescriptions().get(1).getHref();
			if (value == null) value = "";
			descriptionUriField.setText(value);
		}
		
		if (!conf.getDescriptions().isEmpty())
		{
			String value = conf.getDescriptions().get(1).getTitle();
			if (value == null) value = "";
			descriptionTitleField.setText(value);
		}

		
		if (!conf.getIcons().isEmpty())
		{
			String value = conf.getIcons().get(0).getTitle();
			if (value == null) value = "";
			iconTitleField.setText(value);
		}
		
		if (!conf.getIcons().isEmpty())
		{
			String value = conf.getIcons().get(0).getHref();
			if (value == null) value = "";
			iconUriField.setText(value);
		}

		if (!conf.getLinks().isEmpty())
		{
			String value = conf.getLinks().get(0).getHref();
			if (value == null) value = "";
			linkUriField.setText(value);
		}

		if (!conf.getLinks().isEmpty())
		{
			String value = conf.getLinks().get(0).getTitle();
			if (value == null) value = "";
			linkTitleField.setText(value);
		}
		
		
		
		if (meta != null)
		{	
			
		if (!meta.getId().isEmpty())
			idField.setText(meta.getId().get(0).getValue());
		if (!meta.getDate().isEmpty()) {
			dateField.setText(meta.getDate().get(0).getValue());
		}
		if (!meta.getOwner().isEmpty())
			ownerField.setText(meta.getOwner().get(0).getValue());
		if (!meta.getEditor().isEmpty())
			editorField.setText(meta.getEditor().get(0).getValue());
		if (!meta.getStatus().isEmpty())
			statusField.setText(meta.getStatus().get(0).getValue());
		if (!meta.getPlatform().isEmpty())
			platformField.setText(meta.getPlatform().get(0).getValue());
		if (!meta.getProduct().isEmpty())
			productField.setText(meta.getProduct().get(0).getValue());
		if (!meta.getRelease().isEmpty())
			releaseField.setText(meta.getRelease().get(0).getValue());
		if (!meta.getCustomer().isEmpty())
			customerField.setText(meta.getCustomer().get(0).getValue());
		
		}
	
		setDirty(false);
	}
	
		
	private Object getTopConfiguration() {
		TreeIterator<Object> it = EcoreUtil.getAllContents(confMLResource,
				false);
		while (it.hasNext()) {
			Object obj = it.next();
			if (obj instanceof com.nokia.tools.vct.confml.model.confml1.EConfigurationElement) {
				com.nokia.tools.vct.confml.model.confml1.EConfigurationElement conf = (com.nokia.tools.vct.confml.model.confml1.EConfigurationElement)obj;
				return conf;
			}
			else if ( obj instanceof com.nokia.tools.vct.confml.model.confml2.EConfigurationElement) {
				com.nokia.tools.vct.confml.model.confml2.EConfigurationElement conf = (com.nokia.tools.vct.confml.model.confml2.EConfigurationElement)obj;
				return conf; 
			}
		
		}
		return null;
	}
	
	private boolean checkCalendar(String[] split)
	{
		int year = (new Integer(split[0]).intValue());
		int month = (new Integer(split[1]).intValue());
		int day = (new Integer(split[2]).intValue());
		
		if (month < 1 || month > 12)
			return false;
		int maxDays = daysInMonth[month-1];
		if (year%4==0 && month==2)
			maxDays = 29;
		if (day < 1 || day > maxDays)
			return false;
		
		return true;
	}	
	
	
}
