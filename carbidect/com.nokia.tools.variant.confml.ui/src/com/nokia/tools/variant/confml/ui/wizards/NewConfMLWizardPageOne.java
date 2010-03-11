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

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IDialogPage;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE.SharedImages;

import com.nokia.tools.variant.confml.core.ConfMLCore;
import com.nokia.tools.vct.common.appmodel.EConfigurationProject;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.DialogField;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.IDialogFieldListener;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.LayoutUtil;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.PathDialogField;

public class NewConfMLWizardPageOne extends WizardPage {

	class ViewerGroup extends Observable implements IDialogFieldListener {

		private TreeViewer viewer;
		private final PathDialogField containingFolder;
		
		public ViewerGroup() {
			containingFolder = new PathDialogField();
			containingFolder.setDialogFieldListener(this);
		}

		public ISelection getSelection() {
			return viewer.getSelection();
		}


		private void fireEvent() {
			setChanged();
			notifyObservers();
		}

		public void dialogFieldChanged(DialogField field) {
			fireEvent();
			// notifyViewerGroup(field);
		}
		public Control createControl(Composite parent) {

			Composite comp = new Composite(parent, SWT.NONE);
			GridLayout layout = initGridLayout(new GridLayout(3, false), false);
			comp.setLayout(layout);
			comp.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

			// comp.setLayout(new FillLayout());
			Label label = new Label(comp, SWT.NONE);
			label.setText("Enter or select the parent folder");
			GridData gd = new GridData(SWT.FILL, SWT.FILL, true, false, 3, 1);
			label.setLayoutData(gd);
			// comp.setLayoutData(new GridData(GridData.FILL, SWT.FILL, true, false));
			
			containingFolder.doFillIntoGrid(comp, 3);
			
			
			viewer = new TreeViewer(comp);
			gd = new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1);
			viewer.getControl().setLayoutData(gd);
			viewer.setContentProvider(new ITreeContentProvider() {
				public Object[] getChildren(Object element) {
					List<Object> result = new ArrayList<Object>();
					
					if (element instanceof IContainer) {
						IContainer cnt = (IContainer)element;
						IResource[] members = {};
						try {
							members = cnt.members();
						} catch (CoreException e) {
							// ignore
						}
						for (IResource resource: members) {
							if (resource instanceof IContainer && resource.isAccessible()) {
								result.add(resource);
							}
						}
					}
					return result.toArray();
				}

				public Object getParent(Object element) {
					if (element instanceof IResource) {
						return ((IResource) element).getParent();
					}
					return null;
				}

				public boolean hasChildren(Object element) {
					return getChildren(element).length > 0;
				}

				public Object[] getElements(Object inputElement) {
					return getChildren(inputElement);
				}

				public void dispose() {
				}

				public void inputChanged(Viewer viewer, Object oldInput,
						Object newInput) {
				}

			});
			viewer.setLabelProvider(new LabelProvider() {
				public Image getImage(Object obj) {
					String imageKey = ISharedImages.IMG_OBJ_ELEMENT;
					if (obj instanceof IProject) {
						imageKey = SharedImages.IMG_OBJ_PROJECT;
					} else if (obj instanceof IFolder) {
						imageKey = ISharedImages.IMG_OBJ_FOLDER;
					}
					return PlatformUI.getWorkbench().getSharedImages()
							.getImage(imageKey);
				}

				@Override
				public String getText(Object element) {
					if (element instanceof IResource) {
						return ((IResource) element).getName();
					}
					return "null";
				}
			});
			viewer.setInput(ResourcesPlugin.getWorkspace().getRoot());
			viewer.addSelectionChangedListener(new ISelectionChangedListener() {
				public void selectionChanged(SelectionChangedEvent event) {
					ITreeSelection sel = (ITreeSelection)viewer.getSelection();

					Object selected = sel.getFirstElement();
					if (selected instanceof IContainer) {
						IContainer container = (IContainer) selected;
						viewerGroup.setFolderText(container.getFullPath().toString());
					}
				}
			});

			if (initial != null) {
				viewer.setSelection(new StructuredSelection(initial), true);
			}
			return comp;
		}

		public void setFolderText(String text) {
			containingFolder.setText(text);
		}

		public String getFolderText() {
			return containingFolder.getText();
		}

	}

	private class PathGroup extends Observable implements IDialogFieldListener {
		private final PathDialogField nameField;

		public PathGroup() {
			nameField = new PathDialogField();
			nameField.setLabelText("Name:");
			nameField.setDialogFieldListener(this);
		}


		private void fireEvent() {
			setChanged();
			notifyObservers();
		}

		public void dialogFieldChanged(DialogField field) {
			fireEvent();
			// notifyViewerGroup(field);
		}

		// private void notifyViewerGroup(DialogField field) {
		// if(field.equals(containingFolder)&&pathGroup!=null){
		//				
		// viewerGroup.setFilterText(pathGroup.getFolderText());
		// }
		// }

		public Control createControl(Composite composite) {
			final int numColumns = 3;
			final Composite group = new Composite(composite, SWT.NONE);
			group.setLayout(initGridLayout(new GridLayout(numColumns, false),
					false));
			nameField.doFillIntoGrid(group, numColumns);
			LayoutUtil.setHorizontalGrabbing(nameField.getTextControl(null));

			return group;
		}

	}


	private class Validator implements Observer {
		public void update(Observable o, Object arg) {
			

			String folderStr = viewerGroup.containingFolder.getText().trim();
			IPath path = new Path(folderStr);
			if (folderStr.length() == 0 || path.segmentCount() == 0) {
				setErrorMessage(null);
				setMessage("Specify containing folder");
				setPageComplete(false);
				return;
			}
			
			IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace()
					.getRoot();

			IProject project = workspaceRoot.getProject(path.segment(0));
			if (!project.isAccessible()) {
				setErrorMessage("Containing folder: the project is not accessible.");
				setMessage(null);
				setPageComplete(false);
				return;
			}
			EConfigurationProject cp = ConfMLCore.getProjectModel(project);
			if (cp == null) {
				setErrorMessage("Containing folder: the selected project does not contain variant definition.");
				setMessage(null);
				setPageComplete(false);
				return;
			}
//			if (cp.getLastLayer() == null) {
//				setErrorMessage("Containing folder: the selected project is misconfigured and can not be used.");
//				setMessage(null);
//				setPageComplete(false);
//				return;
//			}
			
			IContainer folder = path.segmentCount() > 1 ? workspaceRoot.getFolder(path) : project;
			if (!folder.exists()) {
				setErrorMessage("Containing folder: the selected folder does not exist.");
				setMessage(null);
				setPageComplete(false);
				return;
			}

			if (!pathGroup.nameField.isValidPath()) {
				setErrorMessage("File name: the file name is not valid.");
				setMessage(null);
				setPageComplete(false);
				return;
			}
			IFile file = folder.getFile(pathGroup.nameField.getPath());
			String fileExtension = file.getFileExtension();
			if (fileExtension != null && !"confml".equals(fileExtension)) {
				setErrorMessage("File name: the file must have .confml extension.");
				setMessage(null);
				setPageComplete(false);
				return;
			}
			if (file.exists()
					|| folder.getFile(
							new Path(pathGroup.nameField.getPath().toString()
									+ ".confml")).exists()) {

				setErrorMessage("File name: the file already exists.");
				setMessage(null);
				setPageComplete(false);
				return;
			}

			setErrorMessage(null);
			setMessage(null);
			setPageComplete(true);
		}
	};

	static final String PAGE_NAME = "NewConfMLPageOne";

	private final PathGroup pathGroup;
	private final Validator validator;
	private final ViewerGroup viewerGroup;

	/**
	 * Constructor for SampleNewWizardPage.
	 * 
	 * @param pageName
	 */
	public NewConfMLWizardPageOne() {
		super(PAGE_NAME);
		setTitle("Create new ConfML");
		setDescription("This wizard creates a new file with *.confml extension that can be opened by a multi-page editor.");
		setPageComplete(false);
		viewerGroup = new ViewerGroup();

		pathGroup = new PathGroup();
		validator = new Validator();
		pathGroup.addObserver(validator);
		viewerGroup.addObserver(validator);


	}

	/**
	 * @see IDialogPage#createControl(Composite)
	 */
	public void createControl(Composite parent) {
		initializeDialogUnits(parent);

		final Composite composite = new Composite(parent, SWT.NULL);
		composite.setFont(parent.getFont());
		composite.setLayout(initGridLayout(new GridLayout(1, false), true));
		composite.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));

		Control c = viewerGroup.createControl(composite);
		c.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		// create UI elements
		Control pathControl = createPathControl(composite);
		pathControl.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

//		Control contentTypeControl = createContentTypeControl(composite);
//		contentTypeControl
//				.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		setControl(composite);
	}

	private Control createPathControl(Composite composite) {
		Control control = pathGroup.createControl(composite);
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

	public IContainer getSelectedFolder() {
		String container = viewerGroup.containingFolder.getText().trim();
		IPath path = new Path(container);
		if (path.segmentCount() == 1) {
			return ResourcesPlugin.getWorkspace().getRoot().getProject(container);
		} else {
			return ResourcesPlugin.getWorkspace().getRoot().getFolder(path);
		}
	}

	public IFile getSelectedFile() {
		IContainer folder = getSelectedFolder();
		IPath path = pathGroup.nameField.getPath();
		if (path.getFileExtension() == null) {
			path = new Path(pathGroup.nameField.getPath().toString()
					+ ".confml");
		}
		return folder.getFile(path);
	}

	IContainer initial;
	
	public void setInitialContainer(IContainer cnt) {
		this.initial = cnt;
	}
	
	
}
