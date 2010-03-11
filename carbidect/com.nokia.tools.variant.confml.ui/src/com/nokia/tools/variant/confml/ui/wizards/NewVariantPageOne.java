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

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.core.filesystem.URIUtil;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.dialogs.WorkingSetConfigurationBlock;

import com.nokia.tools.variant.confml.ui.ConfmlUI;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.DialogField;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.IDialogFieldListener;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.IStringButtonAdapter;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.LayoutUtil;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.SelectionButtonDialogField;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.StringButtonDialogField;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.StringDialogField;

public class NewVariantPageOne extends WizardPage {

	/**
	 * Request a project name. Fires an event whenever the text field is
	 * changed, regardless of its content.
	 */
	private final class NameGroup extends Observable implements IDialogFieldListener {

		protected final StringDialogField fNameField;

		public NameGroup() {
			// text field for project name
			fNameField= new StringDialogField();
			fNameField.setLabelText("Project name:"); 
			fNameField.setDialogFieldListener(this);
		}

		public Control createControl(Composite composite) {
			Composite nameComposite= new Composite(composite, SWT.NONE);
			nameComposite.setFont(composite.getFont());
			nameComposite.setLayout(initGridLayout(new GridLayout(2, false), false));

			fNameField.doFillIntoGrid(nameComposite, 2);
			LayoutUtil.setHorizontalGrabbing(fNameField.getTextControl(null));

			return nameComposite;
		}

		protected void fireEvent() {
			setChanged();
			notifyObservers();
		}

		public String getName() {
			return fNameField.getText().trim();
		}

		public void postSetFocus() {
			fNameField.postSetFocusOnDialogField(getShell().getDisplay());
		}

		public void setName(String name) {
			fNameField.setText(name);
		}

		public void dialogFieldChanged(DialogField field) {
			fireEvent();
		}
	}

	/**
	 * Request a location. Fires an event whenever the checkbox or the location
	 * field is changed, regardless of whether the change originates from the
	 * user or has been invoked programmatically.
	 */
	private final class LocationGroup extends Observable implements Observer, IStringButtonAdapter, IDialogFieldListener {

		protected final SelectionButtonDialogField fWorkspaceRadio;
		protected final SelectionButtonDialogField fExternalRadio;
		protected final StringButtonDialogField fLocation;

		private String fPreviousExternalLocation;

		private static final String DIALOGSTORE_LAST_EXTERNAL_LOC= ConfmlUI.PLUGIN_ID + ".last.external.project"; //$NON-NLS-1$

		public LocationGroup() {
			fWorkspaceRadio= new SelectionButtonDialogField(SWT.RADIO);
			fWorkspaceRadio.setDialogFieldListener(this);
			fWorkspaceRadio.setLabelText("Create new project in workspace"); 

			fExternalRadio= new SelectionButtonDialogField(SWT.RADIO);
			fExternalRadio.setLabelText("Create project from existing source"); 

			fLocation= new StringButtonDialogField(this);
			fLocation.setDialogFieldListener(this);
			fLocation.setLabelText("Directory:"); 
			fLocation.setButtonLabel("Browse..."); 

			fExternalRadio.attachDialogField(fLocation);

			fWorkspaceRadio.setSelection(true);
			fExternalRadio.setSelection(false);

			fPreviousExternalLocation= ""; //$NON-NLS-1$
		}

		public Control createControl(Composite composite) {
			final int numColumns= 3;

			final Group group= new Group(composite, SWT.NONE);
			group.setLayout(initGridLayout(new GridLayout(numColumns, false), true));
			group.setText("Contents"); 

			fWorkspaceRadio.doFillIntoGrid(group, numColumns);
			fExternalRadio.doFillIntoGrid(group, numColumns);
			fLocation.doFillIntoGrid(group, numColumns);
			LayoutUtil.setHorizontalGrabbing(fLocation.getTextControl(null));

			return group;
		}

		protected void fireEvent() {
			setChanged();
			notifyObservers();
		}

		protected String getDefaultPath(String name) {
			final IPath path= Platform.getLocation().append(name);
			return path.toOSString();
		}

		/* (non-Javadoc)
		 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
		 */
		public void update(Observable o, Object arg) {
			if (isWorkspaceRadioSelected()) {
				fLocation.setText(getDefaultPath(fNameGroup.getName()));
			}
			fireEvent();
		}

		public IPath getLocation() {
			if (isWorkspaceRadioSelected()) {
				return Platform.getLocation();
			}
			return Path.fromOSString(fLocation.getText().trim());
		}

		public boolean isWorkspaceRadioSelected() {
			return fWorkspaceRadio.isSelected();
		}

		/**
		 * Returns <code>true</code> if the location is in the workspace
		 * 
		 * @return <code>true</code> if the location is in the workspace
		 */
		public boolean isLocationInWorkspace() {
			final String location= fLocationGroup.getLocation().toOSString();
			IPath projectPath= Path.fromOSString(location);
			return Platform.getLocation().isPrefixOf(projectPath);
		}


		public void setLocation(IPath path) {
			fWorkspaceRadio.setSelection(path == null);
			if (path != null) {
				fLocation.setText(path.toOSString());
			} else {
				fLocation.setText(getDefaultPath(fNameGroup.getName()));
			}
			fireEvent();
		}

		/* (non-Javadoc)
		 * @see org.eclipse.jdt.internal.ui.wizards.dialogfields.IStringButtonAdapter#changeControlPressed(org.eclipse.jdt.internal.ui.wizards.dialogfields.DialogField)
		 */
		public void changeControlPressed(DialogField field) {
			final DirectoryDialog dialog= new DirectoryDialog(getShell());
			dialog.setMessage("Choose a directory for the project contents"); 
			String directoryName = fLocation.getText().trim();
			if (directoryName.length() == 0) {
				String prevLocation= ConfmlUI.getInstance().getDialogSettings().get(DIALOGSTORE_LAST_EXTERNAL_LOC);
				if (prevLocation != null) {
					directoryName= prevLocation;
				}
			}

			if (directoryName.length() > 0) {
				final File path = new File(directoryName);
				if (path.exists())
					dialog.setFilterPath(directoryName);
			}
			final String selectedDirectory = dialog.open();
			if (selectedDirectory != null) {
				fLocation.setText(selectedDirectory);
				ConfmlUI.getInstance().getDialogSettings().put(DIALOGSTORE_LAST_EXTERNAL_LOC, selectedDirectory);
			}
		}

		/* (non-Javadoc)
		 * @see org.eclipse.jdt.internal.ui.wizards.dialogfields.IDialogFieldListener#dialogFieldChanged(org.eclipse.jdt.internal.ui.wizards.dialogfields.DialogField)
		 */
		public void dialogFieldChanged(DialogField field) {
			if (field == fWorkspaceRadio) {
				final boolean checked= fWorkspaceRadio.isSelected();
				if (checked) {
					fPreviousExternalLocation= fLocation.getText();
					fLocation.setText(getDefaultPath(fNameGroup.getName()));
				} else {
					fLocation.setText(fPreviousExternalLocation);
				}
			}
			fireEvent();
		}
	}

	private final class WorkingSetGroup {

		private WorkingSetConfigurationBlock fWorkingSetBlock;

		public WorkingSetGroup() {
			String[] workingSetIds= new String[] {/* JavaWorkingSetUpdater.ID,*/ "org.eclipse.ui.resourceWorkingSetPage"}; //$NON-NLS-1$
			fWorkingSetBlock= new WorkingSetConfigurationBlock(workingSetIds, ConfmlUI.getInstance().getDialogSettings());
			//fWorkingSetBlock.setDialogMessage(NewWizardMessages.NewJavaProjectWizardPageOne_WorkingSetSelection_message);
		}

		public Control createControl(Composite composite) {
			Group workingSetGroup= new Group(composite, SWT.NONE);
			workingSetGroup.setFont(composite.getFont());
			workingSetGroup.setText("Working sets");
			workingSetGroup.setLayout(new GridLayout(1, false));

			fWorkingSetBlock.createContent(workingSetGroup);

			return workingSetGroup;
		}


		public void setWorkingSets(IWorkingSet[] workingSets) {
			fWorkingSetBlock.setWorkingSets(workingSets);
		}

		public IWorkingSet[] getSelectedWorkingSets() {
			return fWorkingSetBlock.getSelectedWorkingSets();
		}
	}

	/**
	 * Validate this page and show appropriate warnings and error NewWizardMessages.
	 */
	private final class Validator implements Observer {

		public void update(Observable o, Object arg) {

			final IWorkspace workspace= ResourcesPlugin.getWorkspace();

			final String name= fNameGroup.getName();

			// check whether the project name field is empty
			if (name.length() == 0) { 
				setErrorMessage(null);
				setMessage("Enter project name"); 
				setPageComplete(false);
				
				fNameGroup.fNameField.setRequired(true);
				return;
			}
			fNameGroup.fNameField.setRequired(false);

			// check whether the project name is valid
			final IStatus nameStatus= workspace.validateName(name, IResource.PROJECT);
			if (!nameStatus.isOK()) {
				setErrorMessage(nameStatus.getMessage());
				setPageComplete(false);
				return;
			}

			// check whether project already exists
			final IProject handle= workspace.getRoot().getProject(name);
			if (handle.exists()) {
				setErrorMessage("A project with this name already exists"); 
				setPageComplete(false);
				return;
			}

			IPath projectLocation= ResourcesPlugin.getWorkspace().getRoot().getLocation().append(name);
			if (projectLocation.toFile().exists()) {
				try {
					//correct casing
					String canonicalPath= projectLocation.toFile().getCanonicalPath();
					projectLocation= new Path(canonicalPath);
				} catch (IOException e) {
					ConfmlUI.logWarning(e);
				}

				String existingName= projectLocation.lastSegment();
				if (!existingName.equals(fNameGroup.getName())) {
					setErrorMessage(java.text.MessageFormat.format("The name of the new project must be ''{0}''", existingName));
					setPageComplete(false);
					return;
				}

			}

			final String location= fLocationGroup.getLocation().toOSString();

			// check whether location is empty
			if (location.length() == 0) {
				setErrorMessage(null);
				setMessage("Enter a location for the project."); 
				setPageComplete(false);
				return;
			}

			// check whether the location is a syntactically correct path
			if (!Path.EMPTY.isValidPath(location)) { 
				setErrorMessage("Invalid location"); 
				setPageComplete(false);
				return;
			}

			IPath projectPath= Path.fromOSString(location);

			if (fLocationGroup.isWorkspaceRadioSelected())		
				projectPath= projectPath.append(fNameGroup.getName());

			if (projectPath.toFile().exists()) {//create from existing source			
				if (Platform.getLocation().isPrefixOf(projectPath)) { //create from existing source in workspace
					if (!Platform.getLocation().equals(projectPath.removeLastSegments(1))) {
						setErrorMessage("Not on a workspace root");
						setPageComplete(false);
						return;
					}

					if (!projectPath.toFile().exists()) {
						setErrorMessage("notExisingProjectOnWorkspaceRoot");
						setPageComplete(false);
						return;
					}
				}
			} else if (!fLocationGroup.isWorkspaceRadioSelected()) {//create at non existing external location
				if (!canCreate(projectPath.toFile())) {
					setErrorMessage("cannotCreateAtExternalLocation"); 
					setPageComplete(false);
					return;
				}

				// If we do not place the contents in the workspace validate the
				// location.
				final IStatus locationStatus= workspace.validateProjectLocation(handle, projectPath);
				if (!locationStatus.isOK()) {
					setErrorMessage(locationStatus.getMessage());
					setPageComplete(false);
					return;
				}
			}

			setPageComplete(true);

			setErrorMessage(null);
			setMessage(null);
		}

		private boolean canCreate(File file) {
			while (!file.exists()) {
				file= file.getParentFile();
				if (file == null)
					return false;
			}

			return file.canWrite();
		}
	}

	private static final String PAGE_NAME= "NewVariantPageOne"; //$NON-NLS-1$

	private final NameGroup fNameGroup;
	private final LocationGroup fLocationGroup;
//	private final DetectGroup fDetectGroup;
	private final Validator fValidator;
	private final WorkingSetGroup fWorkingSetGroup;


	/**
	 * Constructor for SampleNewWizardPage.
	 * 
	 * @param pageName
	 */
	public NewVariantPageOne() {
		super(PAGE_NAME);
		setPageComplete(false);
		setTitle("Create a Configuration Project"); 
		setDescription("Create a ConfML project in the workspace or in an external location."); 

		fNameGroup= new NameGroup();
		fLocationGroup= new LocationGroup();
//		fJREGroup= new JREGroup();
//		fLayoutGroup= new LayoutGroup();
		fWorkingSetGroup= new WorkingSetGroup();
//		fDetectGroup= new DetectGroup();

		// establish connections
		fNameGroup.addObserver(fLocationGroup);
//		fDetectGroup.addObserver(fLayoutGroup);
//		fDetectGroup.addObserver(fJREGroup);
//		fLocationGroup.addObserver(fDetectGroup);

		// initialize all elements
		fNameGroup.notifyObservers();

		// create and connect validator
		fValidator= new Validator();
		fNameGroup.addObserver(fValidator);
		fLocationGroup.addObserver(fValidator);

		// initialize defaults
		setProjectName(""); //$NON-NLS-1$
		setProjectLocationURI(null);
		setWorkingSets(new IWorkingSet[0]);

//		initializeDefaultVM();
	}

	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		initializeDialogUnits(parent);

		final Composite composite= new Composite(parent, SWT.NULL);
		composite.setFont(parent.getFont());
		composite.setLayout(initGridLayout(new GridLayout(1, false), true));
		composite.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));

		// create UI elements
		Control nameControl= createNameControl(composite);
		nameControl.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		Control locationControl= createLocationControl(composite);
		locationControl.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

//		Control jreControl= createJRESelectionControl(composite);
//		jreControl.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

//		Control layoutControl= createProjectLayoutControl(composite);
//		layoutControl.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		Control workingSetControl= createWorkingSetControl(composite);
		workingSetControl.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

//		Control infoControl= createInfoControl(composite);
//		infoControl.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		setControl(composite);
	}

	protected void setControl(Control newControl) {
		Dialog.applyDialogFont(newControl);

		// PlatformUI.getWorkbench().getHelpSystem().setHelp(newControl,
		// IJavaHelpContextIds.NEW_JAVAPROJECT_WIZARD_PAGE);

		super.setControl(newControl);
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


	/**
	 * Creates the controls for the name field. 
	 *  
	 * @param composite the parent composite
	 * @return the created control
	 */		
	protected Control createNameControl(Composite composite) {
		return fNameGroup.createControl(composite);
	}

	/**
	 * Creates the controls for the location field. 
	 *  
	 * @param composite the parent composite
	 * @return the created control
	 */		
	protected Control createLocationControl(Composite composite) {
		return fLocationGroup.createControl(composite);
	}

	/**
	 * Creates the controls for the working set selection. 
	 *  
	 * @param composite the parent composite
	 * @return the created control
	 */		
	protected Control createWorkingSetControl(Composite composite) {
		return fWorkingSetGroup.createControl(composite);
	}
//
//	/**
//	 * Creates the controls for the info section. 
//	 *  
//	 * @param composite the parent composite
//	 * @return the created control
//	 */		
//	protected Control createInfoControl(Composite composite) {
//		return fDetectGroup.createControl(composite);
//	}

	/**
	 * Gets a project name for the new project.
	 * 
	 * @return the new project resource handle
	 */
	public String getProjectName() {
		return fNameGroup.getName();
	}

	/**
	 * Sets the name of the new project
	 * 
	 * @param name the new name
	 */
	public void setProjectName(String name) {
		if (name == null)
			throw new IllegalArgumentException();

		fNameGroup.setName(name);
	}

	/**
	 * Returns the current project location path as entered by the user, or <code>null</code>
	 * if the project should be created in the workspace. 

	 * @return the project location path or its anticipated initial value.
	 */
	public URI getProjectLocationURI() {
		if (fLocationGroup.isLocationInWorkspace()) {
			return null;
		}
		return URIUtil.toURI(fLocationGroup.getLocation());
	}

	/**
	 * Sets the project location of the new project or <code>null</code> if the project
	 * should be created in the workspace
	 * 
	 * @param uri the new project location
	 */
	public void setProjectLocationURI(URI uri) {
		IPath path= uri != null ? URIUtil.toPath(uri) : null;
		fLocationGroup.setLocation(path);
	}
//
//	/**
//	 * Returns the compiler compliance to be used for the project, or <code>null</code> to use the workspace
//	 * compiler compliance.
//	 * 
//	 * @return compiler compliance to be used for the project or <code>null</code>
//	 */
//	public String getCompilerCompliance() {
//		return fJREGroup.getSelectedCompilerCompliance();
//	}
//
//	/**
//	 * Returns the default class path entries to be added on new projects. By default this is the JRE container as
//	 * selected by the user.
//	 * 
//	 * @return returns the default class path entries
//	 */
//	public IClasspathEntry[] getDefaultClasspathEntries() {
//		IClasspathEntry[] defaultJRELibrary= PreferenceConstants.getDefaultJRELibrary();
//		String compliance= getCompilerCompliance();
//		IPath jreContainerPath= new Path(JavaRuntime.JRE_CONTAINER);
//		if (compliance == null || defaultJRELibrary.length > 1 || !jreContainerPath.isPrefixOf(defaultJRELibrary[0].getPath())) {
//			// use default
//			return defaultJRELibrary;
//		}
//		IPath newPath= fJREGroup.getJREContainerPath();
//		if (newPath != null) {
//			return new IClasspathEntry[] { JavaCore.newContainerEntry(newPath) };
//		}
//		return defaultJRELibrary;
//	}
//
//	/**
//	 * Returns the source class path entries to be added on new projects.
//	 * The underlying resources may not exist. All entries that are returned must be of kind
//	 * {@link IClasspathEntry#CPE_SOURCE}.
//	 * 
//	 * @return returns the source class path entries for the new project
//	 */
//	public IClasspathEntry[] getSourceClasspathEntries() {
//		IPath sourceFolderPath= new Path(getProjectName()).makeAbsolute();
//
//		if (fLayoutGroup.isSrcBin()) {
//			IPath srcPath= new Path(PreferenceConstants.getPreferenceStore().getString(PreferenceConstants.SRCBIN_SRCNAME));
//			if (srcPath.segmentCount() > 0) {
//				sourceFolderPath= sourceFolderPath.append(srcPath);
//			}
//		}
//		return new IClasspathEntry[] {  JavaCore.newSourceEntry(sourceFolderPath) };
//	}

	/**
	 * Returns the source class path entries to be added on new projects.
	 * The underlying resource may not exist.
	 * 
	 * @return returns the default class path entries
	 */
	public IPath getOutputLocation() {
		IPath outputLocationPath= new Path(getProjectName()).makeAbsolute();
//		if (fLayoutGroup.isSrcBin()) {
//			IPath binPath= new Path(PreferenceConstants.getPreferenceStore().getString(PreferenceConstants.SRCBIN_BINNAME));
//			if (binPath.segmentCount() > 0) {
//				outputLocationPath= outputLocationPath.append(binPath);
//			}
//		}
		return outputLocationPath;
	}

	/**
	 * Returns the working sets to which the new project should be added.
	 * 
	 * @return the selected working sets to which the new project should be added
	 */
	public IWorkingSet[] getWorkingSets() {
		return fWorkingSetGroup.getSelectedWorkingSets();
	}

	/**
	 * Sets the working sets to which the new project should be added.
	 * 
	 * @param workingSets the initial selected working sets
	 */
	public void setWorkingSets(IWorkingSet[] workingSets) {
		if (workingSets == null) {
			throw new IllegalArgumentException();
		}
		fWorkingSetGroup.setWorkingSets(workingSets);
	}

	/**
	 * {@inheritDoc}
	 */
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		if (visible) {
			fNameGroup.postSetFocus();
		}
	}

//	private static final IWorkingSet[] EMPTY_WORKING_SET_ARRAY = new IWorkingSet[0];
//
//	private IWorkingSet[] getSelectedWorkingSet(IStructuredSelection selection, IWorkbenchPart activePart) {
//		IWorkingSet[] selected= getSelectedWorkingSet(selection);
//		if (selected != null && selected.length > 0) {
//			for (int i= 0; i < selected.length; i++) {
//				if (!isValidWorkingSet(selected[i]))
//					return EMPTY_WORKING_SET_ARRAY;
//			}
//			return selected;
//		}
//
//		return new IWorkingSet[0];
//		if (!(activePart instanceof PackageExplorerPart))
//			return EMPTY_WORKING_SET_ARRAY;
//		
//		PackageExplorerPart explorerPart= (PackageExplorerPart) activePart;
//		if (explorerPart.getRootMode() == PackageExplorerPart.PROJECTS_AS_ROOTS) {				
//			//Get active filter
//			IWorkingSet filterWorkingSet= explorerPart.getFilterWorkingSet();
//			if (filterWorkingSet == null)
//				return EMPTY_WORKING_SET_ARRAY;
//
//			if (!isValidWorkingSet(filterWorkingSet))
//				return EMPTY_WORKING_SET_ARRAY;
//
//			return new IWorkingSet[] {filterWorkingSet};
//		} else {
//			//If we have been gone into a working set return the working set
//			Object input= explorerPart.getViewPartInput();
//			if (!(input instanceof IWorkingSet))
//				return EMPTY_WORKING_SET_ARRAY;
//
//			IWorkingSet workingSet= (IWorkingSet)input;
//			if (!isValidWorkingSet(workingSet))
//				return EMPTY_WORKING_SET_ARRAY;
//
//			return new IWorkingSet[] {workingSet};
//		}
//	}

//	private IWorkingSet[] getSelectedWorkingSet(IStructuredSelection selection) {
//		if (!(selection instanceof ITreeSelection))
//			return EMPTY_WORKING_SET_ARRAY;
//
//		ITreeSelection treeSelection= (ITreeSelection) selection;
//		if (treeSelection.isEmpty())
//			return EMPTY_WORKING_SET_ARRAY;
//
//		List elements= treeSelection.toList();
//		if (elements.size() == 1) {
//			Object element= elements.get(0);
//			TreePath[] paths= treeSelection.getPathsFor(element);
//			if (paths.length != 1)
//				return EMPTY_WORKING_SET_ARRAY;
//
//			TreePath path= paths[0];
//			if (path.getSegmentCount() == 0)
//				return EMPTY_WORKING_SET_ARRAY;
//
//			Object candidate= path.getSegment(0);
//			if (!(candidate instanceof IWorkingSet))
//				return EMPTY_WORKING_SET_ARRAY;
//
//			IWorkingSet workingSetCandidate= (IWorkingSet) candidate;
//			if (isValidWorkingSet(workingSetCandidate))
//				return new IWorkingSet[] { workingSetCandidate };
//
//			return EMPTY_WORKING_SET_ARRAY;
//		}
//
//		ArrayList result= new ArrayList();
//		for (Iterator iterator= elements.iterator(); iterator.hasNext();) {
//			Object element= iterator.next();
//			if (element instanceof IWorkingSet && isValidWorkingSet((IWorkingSet) element)) {
//				result.add(element);
//			}
//		}
//		return (IWorkingSet[]) result.toArray(new IWorkingSet[result.size()]);
//	}


//	private static boolean isValidWorkingSet(IWorkingSet workingSet) {
//		String id= workingSet.getId();	
////		if (!JavaWorkingSetUpdater.ID.equals(id) && !"org.eclipse.ui.resourceWorkingSetPage".equals(id)) //$NON-NLS-1$
////			return false;
//
//		if (workingSet.isAggregateWorkingSet())
//			return false;
//
//		return true;
//	}


}
