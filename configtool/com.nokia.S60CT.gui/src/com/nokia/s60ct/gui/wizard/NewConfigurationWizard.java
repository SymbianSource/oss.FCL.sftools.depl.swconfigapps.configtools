/*
* Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies). 
* All rights reserved.
* This component and the accompanying materials are made available
* under the terms of "Eclipse Public License v1.0"
* which accompanies this distribution, and is available
* at the URL "http://www.eclipse.org/legal/epl-v10.html".
*
* Initial Contributors:
* Nokia Corporation - initial contribution.
*
* Contributors:
*
* Description:
*
*/
package com.nokia.s60ct.gui.wizard;


import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.MissingResourceException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

import com.nokia.s60ct.gui.S60CtEditorPlugin;
import com.nokia.s60ct.gui.actions.OpenConfiguration;

import configurationemf.ConfigurationemfFactory;
import configurationemf.ConfigurationemfPackage;
import configurationemf.RootConf;
import configurationemf.provider.ConfigurationEMFEditPlugin;
import configurationemf.util.ConfigurationemfResourceImpl;


/**
 * This is a simple wizard for creating a new model file.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class NewConfigurationWizard extends Wizard implements INewWizard {
	/**
	 * This caches an instance of the model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfigurationemfPackage configurationemfPackage = ConfigurationemfPackage.eINSTANCE;

	/**
	 * This caches an instance of the model factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfigurationemfFactory configurationemfFactory = configurationemfPackage.getConfigurationemfFactory();

	/**
	 * This is the initial object creation page.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfigurationemfModelWizardInitialObjectCreationPage initialObjectCreationPage;

	/**
	 * Remember the selection during initialization for populating the default container.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IStructuredSelection selection;

	/**
	 * Remember the workbench during initialization.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IWorkbench workbench;

	/**
	 * Caches the names of the types that can be created as the root object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected List<String> initialObjectNames;

	
	boolean readOnlyError = false;
	
	/**
	 * This just records the information.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
		setWindowTitle(S60CtEditorPlugin.INSTANCE.getString("_UI_Wizard_label"));
		setDefaultPageImageDescriptor(ExtendedImageRegistry.INSTANCE.getImageDescriptor(S60CtEditorPlugin.INSTANCE.getImage("full/wizban/NewConfigurationemf")));
	}

	/**
	 * Returns the names of the types that can be created as the root object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<String> getInitialObjectNames() {
		if (initialObjectNames == null) {
			initialObjectNames = new ArrayList<String>();
			for (EClassifier eClassifier : configurationemfPackage.getEClassifiers()) {
				if (eClassifier instanceof EClass) {
					EClass eClass = (EClass)eClassifier;
					if (!eClass.isAbstract()) {
						initialObjectNames.add(eClass.getName());
					}
				}
			}
			Collections.sort(initialObjectNames, java.text.Collator.getInstance());
		}
		return initialObjectNames;
	}

	/**
	 * Create a new model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EObject createInitialModel() {
		RootConf rootObject = configurationemfFactory.createRootConf();
		rootObject.setVers("1");
		rootObject.setName(initialObjectCreationPage.getConfigurationName());
		return rootObject;
	}

	/**
	 * Do the work after everything is specified.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean performFinish() {
		try {
			// Get the URI of the model file.
			//
			URI uri = getModelURI();
			File file = new File(uri.toFileString());
			
			if (uri.toFileString().startsWith(File.separator) &&
					System.getProperties().getProperty("os.name").startsWith("Windows"))
			{//unusual case, but user typed path that starts with "\"
				String userDir = System.getProperty("user.dir");
				char driveLetter = userDir.charAt(0);
				file = new File(driveLetter+":"+uri.toFileString());
				uri = URI.createFileURI(file.toString());
			}
			
			final URI fileURI = uri; //final uri for innerclass
			
			readOnlyError = false;
			
			if (file.exists()) {
				if (!MessageDialog.openQuestion
						(getShell(),
						 S60CtEditorPlugin.INSTANCE.getString("_UI_Question_title"),
						 S60CtEditorPlugin.INSTANCE.getString("_WARN_FileConflict", new String []{ fileURI.toFileString() }))) {
					initialObjectCreationPage.selectFileField();
					return false;
				}
			}
			
			
			
			// Do the work within an operation.
			//
			IRunnableWithProgress operation = new IRunnableWithProgress() {
				public void run(IProgressMonitor progressMonitor) {
						try {
							// Create a resource set
							//
//							ResourceSet resourceSet = new ResourceSetImpl();

							// Create a resource for this file.
							//
							Resource resource = new ConfigurationemfResourceImpl(fileURI);

							// Add the initial model object to the contents.
							//
							EObject rootObject = createInitialModel();
							if (rootObject != null) {
								resource.getContents().add(rootObject);
							}
							resource.save(null);
						}
						catch (java.io.FileNotFoundException ioe)
						{
							//folder is read-only
							readOnlyError = true;
							
						}
						catch (Exception exception)
						{
							S60CtEditorPlugin.INSTANCE.log(exception);
						}
						finally {
							progressMonitor.done();
						}
					}
				};

			getContainer().run(false, false, operation);
			
			if (readOnlyError)
			{
				MessageDialog.openError
				(getShell(),
				 S60CtEditorPlugin.INSTANCE.getString("_UI_Error_title"),
				 S60CtEditorPlugin.INSTANCE.getString("_UI_ReadOnlyFolderError_message", new String []{ fileURI.toFileString() }));
				 return false;
			}

			OpenConfiguration.openEditor(fileURI);
			return 	true;
		}
		catch (Exception exception) {
			S60CtEditorPlugin.INSTANCE.log(exception);
			return false;
		}
	}

	/**
	 * This is the page where the type of object to create is selected.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public class ConfigurationemfModelWizardInitialObjectCreationPage extends WizardPage {
		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		protected Text fileField;

		protected Text configurationName;
		/**
		 * Pass in the selection.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public ConfigurationemfModelWizardInitialObjectCreationPage(String pageId) {
			super(pageId);
		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public void createControl(Composite parent) {
			Composite composite = new Composite(parent, SWT.NONE);
			{
				GridLayout layout = new GridLayout();
				layout.numColumns = 1;
				layout.verticalSpacing = 12;
				composite.setLayout(layout);

				GridData data = new GridData();
				data.verticalAlignment = GridData.FILL;
				data.grabExcessVerticalSpace = true;
				data.horizontalAlignment = GridData.FILL;
				composite.setLayoutData(data);
			}
			
			Label resourceURILabel = new Label(composite, SWT.LEFT);
			{
				resourceURILabel.setText(S60CtEditorPlugin.INSTANCE.getString("_UI_File_label")+"*");
				GridData data = new GridData();
				data.horizontalAlignment = SWT.FILL;
				resourceURILabel.setLayoutData(data);
			}

			Composite fileComposite = new Composite(composite, SWT.NONE);
			{
				GridData data = new GridData();
				data.horizontalAlignment = SWT.FILL;
				fileComposite.setLayoutData(data);

				GridLayout layout = new GridLayout();
				data.horizontalAlignment = SWT.FILL;
				data.grabExcessHorizontalSpace = true;
				layout.marginHeight = 0;
				layout.marginWidth = 0;
				layout.numColumns = 2;
				fileComposite.setLayout(layout);
			}

			fileField = new Text(fileComposite, SWT.BORDER);
			{
				GridData data = new GridData();
				data.horizontalAlignment = SWT.FILL;
				data.grabExcessHorizontalSpace = true;
				data.horizontalSpan = 1;
				fileField.setLayoutData(data);
				fileField.setData("name", "fileURI");//for testing
			}

			fileField.addModifyListener(validator);

			Button resourceURIBrowseFileSystemButton = new Button(fileComposite, SWT.PUSH);
			resourceURIBrowseFileSystemButton.setText(S60CtEditorPlugin.INSTANCE.getString("_UI_Browse_label"));

			resourceURIBrowseFileSystemButton.addSelectionListener
				(new SelectionAdapter() {
					 @Override
					 public void widgetSelected(SelectionEvent event) {
						 String fileExtension = S60CtEditorPlugin.INSTANCE.getString("_UI_ConfigurationemfEditorFilenameExtension");
						 String filePath = OpenConfiguration.openFilePathDialog(getShell(), new String[]{"*.confml"}, SWT.OPEN);
						 if (filePath != null) {
							 if (!filePath.endsWith("." + fileExtension)) {
								 filePath = filePath + "." + fileExtension;
							 }
							 fileField.setText(filePath);
						 }
					 }
				 });
			Label nameLabel = new Label(composite,SWT.LEFT);
			{
				nameLabel.setText(S60CtEditorPlugin.INSTANCE.getString("_UI_Configuration_Name_label"));
				GridData data = new GridData();
				data.horizontalAlignment = SWT.FILL;
				nameLabel.setLayoutData(data);
			}
			Composite nameComposite = new Composite(composite, SWT.NONE);
			{
				GridData data = new GridData();
				data.horizontalAlignment = SWT.FILL;
				nameComposite.setLayoutData(data);

				GridLayout layout = new GridLayout();
				data.horizontalAlignment = SWT.FILL;
				data.grabExcessHorizontalSpace = true;
				layout.marginHeight = 0;
				layout.marginWidth = 0;
				layout.numColumns = 2;
				nameComposite.setLayout(layout);
			}
			configurationName = new Text(nameComposite, SWT.BORDER);
			{
				GridData data = new GridData();
				data.horizontalAlignment = SWT.FILL;
				data.grabExcessHorizontalSpace = true;
				data.horizontalSpan = 1;
				configurationName.setLayoutData(data);
			}
			
			setPageComplete(validatePage());
			setControl(composite);
		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		protected ModifyListener validator =
			new ModifyListener() {
				public void modifyText(ModifyEvent e) {
					setPageComplete(validatePage());
				}
			};

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		protected boolean validatePage() {
			URI fileURI = getFileURI();
			if (fileURI == null || fileURI.isEmpty()) {
				setErrorMessage(null);
				return false;
			}

			String requiredExt = S60CtEditorPlugin.INSTANCE.getString("_UI_ConfigurationemfEditorFilenameExtension");
			String enteredExt = fileURI.fileExtension();
			if (enteredExt == null || !enteredExt.equals(requiredExt)) {
				setErrorMessage(S60CtEditorPlugin.INSTANCE.getString("_WARN_FilenameExtension", new Object [] { requiredExt }));
				return false;
			}

			setErrorMessage(null);
			return true;
		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		@Override
		public void setVisible(boolean visible) {
			super.setVisible(visible);
			if (visible) {
				fileField.setFocus();
			}
		}

				
		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public URI getFileURI() {
			try {
				String uri = fileField.getText();
				return URI.createFileURI(uri);
			}
			catch (Exception exception) {
				// Ignore
			}
			return null;
		}

		public String getConfigurationName(){
			return configurationName.getText();
		}
		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public void selectFileField() {
				fileField.selectAll();
				fileField.setFocus();
		}		

		/**
		 * Returns the label for the specified type name.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		protected String getLabel(String typeName) {
			try {
				return ConfigurationEMFEditPlugin.INSTANCE.getString("_UI_" + typeName + "_type");
			}
			catch(MissingResourceException mre) {
				S60CtEditorPlugin.INSTANCE.log(mre);
			}
			return typeName;
		}

		
	}

	/**
	 * The framework calls this to create the contents of the wizard.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
		@Override
	public void addPages() {
		initialObjectCreationPage = new ConfigurationemfModelWizardInitialObjectCreationPage("Whatever2");
		initialObjectCreationPage.setTitle(S60CtEditorPlugin.INSTANCE.getString("_UI_ConfigurationemfModelWizard_label"));
		initialObjectCreationPage.setDescription(S60CtEditorPlugin.INSTANCE.getString("_UI_Wizard_initial_object_description"));
		addPage(initialObjectCreationPage);
	}

		/**
		 * Get the URI from the page.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		*/
		public URI getModelURI() {
			return initialObjectCreationPage.getFileURI();
		}

}
