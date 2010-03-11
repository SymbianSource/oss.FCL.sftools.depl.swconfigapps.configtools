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
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.layout.TreeColumnLayout;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.ide.IDE;

import com.nokia.tools.variant.confml.internal.core.confml.ConfMLNature;
import com.nokia.tools.variant.confml.ui.ConfmlUI;
import com.nokia.tools.variant.confml.ui.IConfmlImages;
import com.nokia.tools.vct.common.appmodel.EConfMLLayer;
import com.nokia.tools.vct.common.appmodel.EConfigurationProject;
import com.nokia.tools.vct.common.appmodel.util.AppModelFactory;
import com.nokia.tools.vct.common.core.utils.ArrayUtils;
import com.nokia.tools.vct.common.secure.core.IKeyStoreEntry;
import com.nokia.tools.vct.common.secure.core.IKeyStoreManager;
import com.nokia.tools.vct.common.secure.core.SecurityCorePlugin;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.ComboDialogField;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.DialogField;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.IDialogFieldListener;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.IStringButtonAdapter;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.LayoutUtil;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.SelectionButtonDialogField;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.StringButtonDialogField;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.StringDialogField;

public class ExportCPFPage1 extends WizardPage {

	private class ViewGroup extends Observable implements IDialogFieldListener,
			IStringButtonAdapter {
		private final StringButtonDialogField fileField;

		public ViewGroup() {
			fileField = new StringButtonDialogField(this);
			fileField.setLinkText("Location:");
			fileField.setDialogFieldListener(this);
			fileField.setButtonLabel("Browse...");
		}

		public void changeControlPressed(DialogField field) {
			if (field == fileField) {
				FileDialog dialog = new FileDialog(getShell(), SWT.SAVE);
				dialog.setFileName(fileField.getText());
				dialog.setFilterExtensions(new String[] { "*.cpf" });
				dialog.setFilterNames(new String[] { "CPF package (*.cpf)" });
				String selected = dialog.open();
				if (selected != null) {
					fileField.setText(selected);
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
			group.setText("CPF Properties");

			fileField.doFillIntoGrid(group, numColumns);
			LayoutUtil.setHorizontalGrabbing(fileField.getTextControl(null));

			return group;
		}
	}

	static class ProjectContentsLabelProvider extends LabelProvider implements ITableLabelProvider {
		public Image getColumnImage(Object element, int columnIndex) {
			if (columnIndex != 0) {
				return null;
			}
			
			if (element instanceof EConfigurationProject) {
				return ConfmlUI.getImage(IConfmlImages.FLD_PROJECT);
			} else if (element instanceof EConfMLLayer) {
				return ConfmlUI.getImage(IConfmlImages.FLD_LAYER);
			} else {
				return null;
			}
		}
		public String getColumnText(Object element, int columnIndex) {
			if (columnIndex == 0) {
				if (element instanceof EConfigurationProject) {
					EConfigurationProject project = (EConfigurationProject)element;
					URI uri = project.getRootConfml();
					if (uri.isPlatform()) {
						IPath path = new Path(uri.toPlatformString(true)).removeFirstSegments(1);;
						return path.toString();
					} else {
						return uri.path();
					}
					
				} else if (element instanceof EConfMLLayer) {
					EConfMLLayer layer = (EConfMLLayer)element;
					URI uri = layer.getRootConfml();
					if (uri.isPlatform()) {
						IPath path = new Path(uri.toPlatformString(true)).removeFirstSegments(1);;
						return path.toString();
					} else {
						return uri.path();
					}
				} else {
					return null;
				}
			} else if (columnIndex == 1) {
				if (element instanceof EConfigurationProject) {
					EConfigurationProject project = (EConfigurationProject)element;
					return project.getName();
				} else if (element instanceof EConfMLLayer) {
					EConfMLLayer layer = (EConfMLLayer)element;
					return layer.getName();
				} else {
					return null;
				}
			} else {
				return null;
			}
		}
	}
	
	static class ProjectContentsContentProvider implements ITreeContentProvider {
		public Object[] getChildren(Object element) {
			if (element instanceof EConfigurationProject) {
				return ((EConfigurationProject) element).getLayers().toArray();
			} else {
				return new Object[0];
			}
		}

		public Object getParent(Object element) {
			return null;
		}

		public boolean hasChildren(Object element) {
			return getChildren(element).length != 0;
		}

		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof Collection) {
				return ((Collection<?>)inputElement).toArray();
			}
			if (inputElement instanceof Object[]) {
				return (Object[])inputElement;
			}
			return new Object[] {inputElement};
		}

		public void dispose() {
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}
	}
	
	public class EncryptionGroup extends Observable implements IDialogFieldListener {
		private final SelectionButtonDialogField signContent;
		private final ComboDialogField encryptionType;
		private final StringDialogField password;
		private Group group;

		public EncryptionGroup() {
			signContent = new SelectionButtonDialogField(SWT.CHECK);
			signContent.setLabelText("Sign Contents");
			encryptionType = new ComboDialogField(SWT.BORDER | SWT.READ_ONLY | SWT.SINGLE);
			encryptionType.setLabelText("Encryption algorithm");
			encryptionType.setItems(new String[] {"None", "AES-128", "AES-192", "AES-256"});
			encryptionType.selectItem(0);
			password = new StringDialogField(SWT.BORDER | SWT.PASSWORD);
			password.setLabelText("Password:");

			signContent.setDialogFieldListener(this);
			encryptionType.setDialogFieldListener(this);
			password.setDialogFieldListener(this);
		}
		
		public void dialogFieldChanged(DialogField field) {
			setChanged();
			
			int idx = encryptionType.getSelectionIndex();
			boolean passRequired = signContent.isSelected() || idx > 0;
			password.setEnabled(passRequired);
			if (!passRequired) {
				password.setTextWithoutUpdate("");
			}
			
			notifyObservers();
		}
		
		public Control createControl(Composite composite) {
			final int numColumns = 3;
			group = new Group(composite, SWT.NONE);
			group.setText("Security Control");
			
			group.setLayout(new GridLayout(3, false));
			signContent.doFillIntoGrid(group, numColumns);
			LayoutUtil.setHorizontalGrabbing(signContent
					.getSelectionButton(null));

			encryptionType.doFillIntoGrid(group, numColumns);
			LayoutUtil.setHorizontalGrabbing(encryptionType
					.getComboControl(null));
			
			password.doFillIntoGrid(group, numColumns);
			LayoutUtil.setHorizontalGrabbing(password
					.getTextControl(null));

			return group;
		}
	}
	
	public class ProjectGroup extends Observable implements
			IDialogFieldListener {
		private final ComboDialogField projectCombo;
		// private final ComboDialogField configurationsCombo;
		private TreeViewer projectContents;
		

		// private final List<String> viewIds;
		// private final List<String> viewNames;
		private final List<String> projectNames;
		private String selectedProject;

		private final ResourceSet resourceSet;

		private boolean validExport = true;

		public boolean getValidExport() {
			return validExport;
		}

		public ProjectGroup() {

			resourceSet = new ResourceSetImpl();

			projectCombo = new ComboDialogField(SWT.SINGLE | SWT.READ_ONLY);
			projectCombo.setLabelText("Project:");
			// configurationsCombo = new ComboDialogField(SWT.SINGLE);
			// configurationsCombo.setLabelText("Configurations:");
			// configurationsCombo.setDialogFieldListener(this);
			
			projectNames = new LinkedList<String>();

			projectCombo.setDialogFieldListener(this);
		}

		private void fireEvent() {
			setChanged();
			notifyObservers();
		}

		String getLayerName(EConfMLLayer layer) {
			return layer.getPlatform() + "/" + layer.getProduct() + "/"
					+ layer.getRelease() + "/" + layer.getVersion();
		}

		public void dialogFieldChanged(DialogField field) {

			if (field == projectCombo) {
				// update the list of available views
				final String selected;
				int idx = projectCombo.getSelectionIndex();
				if (idx >= 0 && idx < projectNames.size()) {
					selected = projectNames.get(idx);
				} else {
					selected = null;
					selectedProject = null;
					cpfs.clear();
					// configurationsCombo.setItems(new String[0]);
					projectContents.refresh();
					return;
				}
				
				if (selected.equals(selectedProject)) {
					return;
				}
				selectedProject = selected;

				IProject project = ResourcesPlugin.getWorkspace().getRoot()
						.getProject(selected);
				final List<URI> roots = new ArrayList<URI>();
				try {
					project.accept(new IResourceVisitor() {
						public boolean visit(IResource resource)
								throws CoreException {
							if (resource instanceof IProject) {
								return true;
							}
							if (!(resource instanceof IFile)) {
								return false;
							}
							IFile file = (IFile) resource;
							if ("confml".equals(file.getFileExtension())) {
								URI uri = URI
										.createPlatformResourceURI(resource
												.getFullPath().toString(), true);
								roots.add(uri);
							}
							return false;
						}
					}, IResource.DEPTH_ONE, IResource.NONE);
				} catch (CoreException e) {
					e.printStackTrace();
				}
				final List<URI> resources = new ArrayList<URI>();
				try {
					project.accept(new IResourceVisitor() {
						public boolean visit(IResource resource)
								throws CoreException {
							if (resource instanceof IProject) {
								return true;
							}
							URI uri = URI.createPlatformResourceURI(resource
									.getFullPath().toString(), true);
							if (resource instanceof IFile) {
								resources.add(uri);
								return false;
							}
							if (resource instanceof IFolder) {
								uri = uri.appendSegment("");
								resources.add(uri);
								return true;
							}
							return false;
						}
					}, IResource.DEPTH_INFINITE, IResource.NONE);
				} catch (CoreException e) {
					e.printStackTrace();
				}

				cpfs.clear();
				try {
					getContainer().run(true, false,
							new IRunnableWithProgress() {
								public void run(IProgressMonitor monitor)
										throws InvocationTargetException,
										InterruptedException {
									monitor.beginTask("Loading configuratons",
											100 * roots.size());
									URI uri = URI.createPlatformResourceURI(selectedProject, true).appendSegment("");
									
									Resource resource = resourceSet.getResource(uri, false);
									if (resource != null) {
										for (EObject next : resource.getContents()) {
											cpfs.add((EConfigurationProject)next);
										}
									} else {
										resource = new ResourceImpl(uri);
										resourceSet.getResources().add(resource);
										for (URI next : roots) {
											EConfigurationProject cpf = new AppModelFactory()
													.populateProject(
															new SubProgressMonitor(
																	monitor, 100),
															resourceSet, next,
															resources);
											resource.getContents().add(cpf);
											cpfs.add(cpf);
										}
									}
									monitor.done();
								}
							});
				} catch (Exception e) {
					e.printStackTrace();
				}
				projectContents.refresh();

				// viewIds.clear();
				// viewNames.clear();
				// for (Map.Entry<String, String> view : views.entrySet()) {
				// viewIds.add(view.getKey());
				// viewNames.add(view.getValue() + " (" + view.getKey() + ")");
				// }

				// configurationsCombo.setItems(ArrayUtils.createCopy(String.class,
				// viewNames));
				// if (!viewNames.isEmpty()) {
				// configurationsCombo.selectItem(0);
				// }
				// includeList.setElements(parents.entrySet());
				// includeList.setCheckedElements(parents.entrySet());
			}

			fireEvent();
		}

		public Control createControl(Composite composite) {
			final int numColumns = 3;
			final Group group = new Group(composite, SWT.NONE);
			group.setLayout(initGridLayout(new GridLayout(numColumns, false),
					true));
			group.setText("Source project && layers");

			projectCombo.doFillIntoGrid(group, numColumns);
			LayoutUtil
					.setHorizontalGrabbing(projectCombo.getComboControl(null));

			// configurationsCombo.doFillIntoGrid(group, numColumns);
			// LayoutUtil.setHorizontalGrabbing(configurationsCombo.getComboControl(null));

			Label label = new Label(group, SWT.NONE);
			label.setText("Project configurations:");
			label.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, numColumns, 1));
			Composite contents =new Composite(group, SWT.NULL);
			GridData gridData = new GridData(SWT.FILL, SWT.TOP, true, false, numColumns, 1);
			gridData.heightHint = 200;
			contents.setLayoutData(gridData);
			TreeColumnLayout layout = new TreeColumnLayout();
			contents.setLayout(layout);
			
			projectContents = new TreeViewer(contents, SWT.FULL_SELECTION | SWT.BORDER);
			projectContents.setContentProvider(new ProjectContentsContentProvider());
			projectContents.setLabelProvider(new ProjectContentsLabelProvider());
			projectContents.setInput(cpfs);
			
			projectContents.getTree().setHeaderVisible(true);
			
			TreeColumn column1 = new TreeColumn(projectContents.getTree(), SWT.LEFT);
			column1.setText("Elements");
			layout.setColumnData(column1, new ColumnWeightData(10, 150));
			
			TreeColumn column2 = new TreeColumn(projectContents.getTree(), SWT.LEFT);
			column2.setText("Name");
			layout.setColumnData(column2, new ColumnWeightData(3, 50));
			

			return group;
		}

	}

	final class Validator implements Observer {

		public boolean validExport = true;

		public Validator() {
			super();
		}

		public void update(Observable o, Object arg) {
			String fileName = viewGroup.fileField.getText().trim();

			boolean passwordOK;
			if (securityGroup.password.isEnabled()) {
				String password = securityGroup.password.getText();
				if (password.length() == 0) {
					securityGroup.password.setWarningMessage("Password is missing");
					securityGroup.password.setErrorMessage(null);
					passwordOK = false;
				} else {
					securityGroup.password.setWarningMessage(null);
					IKeyStoreManager manager = SecurityCorePlugin.getKeyStoreManager(); 
					IKeyStoreEntry entry = manager.getDefaultEntry();
					try {
						manager.getPrivateKey(entry, password);
						securityGroup.password.setErrorMessage(null);
						passwordOK = true;
					} catch (CoreException e) {
						securityGroup.password.setErrorMessage("Password is wrong");
						passwordOK = false;
					}
				}
				
			} else {
				securityGroup.password.setWarningMessage(null);
				securityGroup.password.setErrorMessage(null);
				passwordOK = true;
			}
			
			if (!validExport) {
				setMessage("There are no layer to export");
				setErrorMessage("There are no layers to export");
				setPageComplete(false);
				return;
			}

			if (fileName.length() == 0) {
				setMessage("CPF File Name: Select the outputfile");
				setErrorMessage(null);
				setPageComplete(false);
				return;
			}
			File file = new File(fileName);
			if (file.isDirectory()) {
				setMessage(null);
				setErrorMessage("CPF File Name: The entered value must not point to a directory");
				setPageComplete(false);
				return;
			}
			if (file.exists()) {
				setMessage(null);
				setErrorMessage("CPF File Name: The entered file already exists");
				setPageComplete(false);
				return;
			}
			if (!file.getName().endsWith(".cpf")) {
				setMessage(null);
				setErrorMessage("CPF File Name: File extension must be .cpf");
				setPageComplete(false);
				return;
			}

			int idx = projectGroup.projectCombo.getSelectionIndex();
			if (idx < 0 || idx >= projectGroup.projectNames.size()) {
				setMessage(null);
				setErrorMessage("Project Name: select valid project for export");
				setPageComplete(false);
				return;
			}

			// idx = projectGroup.configurationsCombo.getSelectionIndex();
			// if (idx < 0 || idx >= projectGroup.viewIds.size()) {
			// setMessage(null);
			// setErrorMessage(null);
			// setMessage("Exported view: select valid view for export",
			// WARNING);
			// setPageComplete(true);
			// return;
			// }

			if (passwordOK) {
				setMessage(null);
				setErrorMessage(null);
				setPageComplete(true);
			} else {
				setMessage(null);
				setErrorMessage("Specify password for accessing private key");
				setPageComplete(false);
			}
		}
	}

	static final String PAGE_NAME = "ExportCPFWizardPageOne";

	private final ViewGroup viewGroup;

	private final ProjectGroup projectGroup;
	private final EncryptionGroup securityGroup;

	private final Validator validator;

	private IProject defaultProject;

	private final List<EConfigurationProject> cpfs;

	
	public void initialize() {
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot()
				.getProjects();
		for (IProject next : projects) {
			try {
				if (next.hasNature(ConfMLNature.CONF_ML_NATURE_ID)) {
					projectGroup.projectNames.add(next.getName());
				}
			} catch (CoreException e) {
			}
		}
		projectGroup.projectCombo.setDialogFieldListener(null);
		projectGroup.projectCombo.setItems(ArrayUtils.createCopy(String.class,
				projectGroup.projectNames));

		if (defaultProject != null) {
			String defaultId = defaultProject.getName();
			int idx = projectGroup.projectNames.indexOf(defaultId);
			projectGroup.projectCombo.selectItem(idx);
			projectGroup.dialogFieldChanged(projectGroup.projectCombo);
		}
		projectGroup.projectCombo.setDialogFieldListener(projectGroup);

		if (SecurityCorePlugin.getKeyStoreManager().getDefaultEntry() == null) {
			securityGroup.encryptionType.setEnabled(false);
			securityGroup.encryptionType.selectItem(0);
			securityGroup.signContent.setEnabled(false);
			securityGroup.password.setEnabled(false);
			securityGroup.group.setEnabled(false);
			
			setMessage("No default key - security is disabled", IMessageProvider.WARNING);
		} else {
			securityGroup.group.setEnabled(true);
			securityGroup.encryptionType.setEnabled(true);
			securityGroup.encryptionType.selectItem(1);
			securityGroup.signContent.setSelection(true);
			securityGroup.password.setEnabled(true);
		}
		validator.update(null, null);
	}

	public ExportCPFPage1(IWorkbench workbench,
			IStructuredSelection selection, List<EConfigurationProject> context) {
		super(PAGE_NAME);
		setPageComplete(false);
		setTitle("Export CPF");
		setDescription("Create CPF package from the ConfML layer project set");

		findProject(selection);

		this.cpfs = context;
		
		viewGroup = new ViewGroup();
		projectGroup = new ProjectGroup();
		securityGroup = new EncryptionGroup();
		validator = new Validator();
		if (!projectGroup.getValidExport()) {
			// setErrorMessage("There are no confml layers to export")
			setTitle("Cannot export CPF");
			setDescription("There are no confml layers to export");
			setErrorMessage("There are no confml layers to export");
		}
		validator.validExport = projectGroup.getValidExport();
		viewGroup.addObserver(validator);
		projectGroup.addObserver(validator);
		securityGroup.addObserver(validator);
	}

	public void createControl(Composite parent) {
		initializeDialogUnits(parent);

		final Composite composite = new Composite(parent, SWT.NULL);
		composite.setFont(parent.getFont());
		composite.setLayout(initGridLayout(new GridLayout(1, false), true));
		composite.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));

		// create UI elements
		Control viewControl = createViewGroupControl(composite);
		viewControl.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

		Control control = projectGroup.createControl(composite);
		control.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

		control = securityGroup.createControl(composite);
		control.setLayoutData(new GridData(SWT.FILL, SWT.BOTTOM, true, false));
		
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

	public String getSelectedProject() {
		int idx = projectGroup.projectCombo.getSelectionIndex();
		if (idx >= 0 && idx < projectGroup.projectNames.size()) {
			return projectGroup.projectNames.get(idx);
		}
		return null;
	}

	public List<String> getExportedDependencies() {
		return Collections.emptyList();
		//		
		// List<Object> checked = projectGroup.includeList.getCheckedElements();
		// List<String> result = new ArrayList<String>(checked.size());
		// for (Object obj : checked) {
		// Map.Entry<?, ?> entry = (Map.Entry<?, ?>) obj;
		// result.add((String) entry.getValue());
		// }
		// return result;
	}

	public boolean isEncryptionNeeded() {
		return securityGroup.encryptionType.getSelectionIndex() > 0;
	}

	public String getAlgorithm() {
		switch (securityGroup.encryptionType.getSelectionIndex()) {
		case 1:
		case 2:
		case 3:
			return "AES";
		default:
			return null;
		}
	}
	
	public int getBlockSize() {
		switch (securityGroup.encryptionType.getSelectionIndex()) {
		case 1:
			return 128;
		case 2:
			return 192;
		case 3:
			return 256;
		default:
			return 0;
		}
	}
	
	public boolean isSiginingNeeded() {
		return securityGroup.signContent.isSelected();
	}
	
	public String getPassword() {
		return securityGroup.password.getText();
	}
	
	public String getTargetCPFFile() {
		return viewGroup.fileField.getText().trim();
	}

	public ViewGroup getViewGroup() {
		return viewGroup;
	}

	public ProjectGroup getProjectGroup() {
		return projectGroup;
	}

	public IProject getExportedProject() {
		int idx = projectGroup.projectCombo.getSelectionIndex();
		if (idx >= 0 && idx < projectGroup.projectNames.size()) {
			return ResourcesPlugin.getWorkspace().getRoot().getProject(
					projectGroup.projectNames.get(idx));
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	private void findProject(IStructuredSelection selection) {
		// preinit wizard page
		List<IResource> resources = IDE.computeSelectedResources(selection);
		for (IResource res : resources) {
			defaultProject = res.getProject();
			if (defaultProject != null) {
				break;
			}
		}
	}

	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		if (visible && projectGroup.projectNames.isEmpty()) {
			Display.getCurrent().asyncExec(new Runnable() {
				public void run() {
					initialize();
				}
			});
		}
	}
	
}
