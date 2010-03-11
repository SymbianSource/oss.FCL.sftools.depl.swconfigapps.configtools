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
package wizards;


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
import cenrep.CenrepFactory;
import cenrep.CenrepPackage;
import cenrep.Repository;
import cenrep.util.CenrepResourceImpl;
import com.nokia.s60ct.cenrep.gui.CenRepPlugin;
import com.nokia.s60ct.cenrep.gui.Actions.OpenCrMLFile;


import common.VerifyIDAdapter;



/**
 * This is a simple wizard for creating a new model file.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class NewRepositoryWizard extends Wizard implements INewWizard {
	/**
	 * This caches an instance of the model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CenrepPackage cenrepPackage = CenrepPackage.eINSTANCE;

	/**
	 * This caches an instance of the model factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CenrepFactory cenrepFactory = cenrepPackage.getCenrepFactory();

	/**
	 * This is the initial object creation page.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CenrepModelWizardInitialObjectCreationPage initialObjectCreationPage;

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

	/**
	 * This just records the information.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
		setWindowTitle(CenRepPlugin.INSTANCE.getString("_UI_Wizard_label"));
//		setDefaultPageImageDescriptor(ExtendedImageRegistry.INSTANCE.getImageDescriptor(CenRepPlugin.INSTANCE.getImage("full/wizban/NewConfigurationemf")));
	}

	boolean readOnlyError = false;
	
	/**
	 * Returns the names of the types that can be created as the root object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<String> getInitialObjectNames() {
		if (initialObjectNames == null) {
			initialObjectNames = new ArrayList<String>();
			for (EClassifier eClassifier : cenrepPackage.getEClassifiers()) {
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
		Repository repository = cenrepFactory.createRepository();
		repository.setVersion("1");
		repository.setUidValue("0x"+initialObjectCreationPage.getRepositoryName());
		return repository;
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
						 CenRepPlugin.INSTANCE.getString("_UI_Question_title"),
						 CenRepPlugin.INSTANCE.getString("_WARN_FileConflict", new String []{ fileURI.toFileString() }))) {
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
							Resource resource = new CenrepResourceImpl(fileURI);

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
						catch (Exception exception) {
							CenRepPlugin.INSTANCE.log(exception);
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
						CenRepPlugin.INSTANCE.getString("_UI_Error_title"),
						CenRepPlugin.INSTANCE.getString("_UI_ReadOnlyFolderError_message", new String []{ fileURI.toFileString() }));
				 return false;
			}
			
			OpenCrMLFile.openEditor(new URI[]{fileURI});
			return 	true;
		}
		catch (Exception exception) {
			CenRepPlugin.INSTANCE.log(exception);
			return false;
		}
	}

	/**
	 * This is the page where the type of object to create is selected.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public class CenrepModelWizardInitialObjectCreationPage extends WizardPage {
		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		protected Text fileField;

		protected Text repositoryName;
		/**
		 * Pass in the selection.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public CenrepModelWizardInitialObjectCreationPage(String pageId) {
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
				resourceURILabel.setText(CenRepPlugin.INSTANCE.getString("_UI_File_label")+"*");
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
			}

			fileField.addModifyListener(validator);
			fileField.setData("name", "fileURI");
			Button resourceURIBrowseFileSystemButton = new Button(fileComposite, SWT.PUSH);
			resourceURIBrowseFileSystemButton.setText(CenRepPlugin.INSTANCE.getString("_UI_Browse_label"));

			resourceURIBrowseFileSystemButton.addSelectionListener
				(new SelectionAdapter() {
					 @Override
					 public void widgetSelected(SelectionEvent event) {
						 String fileExtension = "crml";
						 String[] filePath = OpenCrMLFile.openFilePathDialog(getShell(), new String[]{"*."+fileExtension}, SWT.OPEN);
						 if (filePath != null) {
							 if (!filePath[0].endsWith("." + fileExtension)) {
								 filePath[0] = filePath[0] + "." + fileExtension;
							 }
							 fileField.setText(filePath[0]);
							 String fileName = filePath[0].substring(filePath[0].lastIndexOf("\\")+1);
							 if(fileName.matches("[\\p{Alpha}|\\p{Digit}]+_[\\p{Digit}|[a-fA-F]]{8}.crml")){
								 String repUid = fileName.substring(fileName.lastIndexOf("_")+1,fileName.indexOf("."));
								 repositoryName.setText(repUid);
							 }
						 }
					 }
				 });
			Label nameLabel = new Label(composite,SWT.LEFT);
			{
				nameLabel.setText(CenRepPlugin.INSTANCE.getString("_UI_Repository_Name_label"));
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
			Label label = new Label(nameComposite, SWT.NONE);
			label.setText("0x");
			label.pack();
			repositoryName = new Text(nameComposite, SWT.BORDER);
			{
				GridData data = new GridData();
				data.horizontalAlignment = SWT.FILL;
				data.grabExcessHorizontalSpace = true;
				data.horizontalSpan = 1;
				repositoryName.setLayoutData(data);
				repositoryName.addVerifyListener(VerifyIDAdapter.INSTANCE_WITHOUT_X);
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

			String requiredExt = "crml";
			String enteredExt = fileURI.fileExtension();
			if (enteredExt == null || !enteredExt.equals(requiredExt)) {
				setErrorMessage(CenRepPlugin.INSTANCE.getString("_WARN_FilenameExtension", new Object [] { requiredExt }));
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
				return URI.createFileURI(fileField.getText());
			}
			catch (Exception exception) {
				// Ignore
			}
			return null;
		}

		public String getRepositoryName(){
			return repositoryName.getText();
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
				return CenRepPlugin.INSTANCE.getString("_UI_" + typeName + "_type");
			}
			catch(MissingResourceException mre) {
				CenRepPlugin.INSTANCE.log(mre);
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
		initialObjectCreationPage = new CenrepModelWizardInitialObjectCreationPage("Whatever2");
		initialObjectCreationPage.setTitle(CenRepPlugin.INSTANCE.getString("_UI_Wizard_label"));
		initialObjectCreationPage.setDescription(CenRepPlugin.INSTANCE.getString("_UI_Wizard_initial_object_description"));
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
