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
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IDialogPage;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
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

public class NewConfigurationWizardPageOne extends WizardPage {

	class ViewerGroup extends Observable implements IDialogFieldListener {

		private TreeViewer viewer;
		private IResource basedOn = null;
		
		public ViewerGroup(IResource initial) {
			this.basedOn = initial;
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
			label.setText("Based on configuration:");
			GridData gd = new GridData(SWT.FILL, SWT.FILL, true, false, 3, 1);
			label.setLayoutData(gd);
			// comp.setLayoutData(new GridData(GridData.FILL, SWT.FILL, true, false));			
			
			viewer = new TreeViewer(comp);
			gd = new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1);
			gd.heightHint = 300;
			viewer.getControl().setLayoutData(gd);
			viewer.setContentProvider(new ITreeContentProvider() {
				public Object[] getChildren(Object element) {
					List<Object> result = new ArrayList<Object>();
					
					if(element instanceof IWorkspaceRoot) {
						IWorkspaceRoot root = (IWorkspaceRoot) element;
						IProject[] projects = root.getProjects();
						for (int i = 0; i < projects.length; i++) {
							result.add(projects[i]);							
						}
					} else if (element instanceof IProject) {
						IProject cnt = (IProject)element;
						IResource[] members = {};
						try {
							members = cnt.members();
						} catch (CoreException e) {
							// ignore
						}
						for (IResource resource: members) {
							if (resource instanceof IFile && resource.getName().endsWith("confml")) {
								result.add(resource);
							}
						}
					} else {}
					return result.toArray();
				}

				public Object getParent(Object element) {
					if (element instanceof IResource) {
						return ((IResource) element).getParent();
					}
					return null;
				}

				public boolean hasChildren(Object element) {
					if(element instanceof IContainer) {
						IContainer cnt = (IContainer) element;
						try {
							IResource[] members = cnt.members();
							return members.length!=0;
						} catch (CoreException e) {
							e.printStackTrace();
						}
					}
					return false;
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
					} else if (obj instanceof IFile) {
						imageKey = ISharedImages.IMG_OBJ_FILE;
					} 
					return PlatformUI.getWorkbench().getSharedImages()
							.getImage(imageKey);
				}

				@Override
				public String getText(Object element) {
					if (element instanceof IResource) {
						return ((IResource) element).getName();
					}
					if (element instanceof IProject) {
						return ((IProject) element).getName();
					}
					return "null";
				}
			});
			viewer.setInput(ResourcesPlugin.getWorkspace().getRoot());
			
			viewer.addSelectionChangedListener(new ISelectionChangedListener() {
				public void selectionChanged(SelectionChangedEvent event) {
					ITreeSelection sel = (ITreeSelection)viewer.getSelection();

					Object selected = sel.getFirstElement();
					if(selected instanceof IResource) {
						IResource res = (IResource) selected;
						viewerGroup.setBasedOn(res);
					}
				}
			});

			if (basedOn != null) {
				viewer.setSelection(new StructuredSelection(basedOn), true);
			}
			return comp;
		}

		protected void setBasedOn(IResource res) {
			this.basedOn = res;
			fireEvent();
		}

		protected IResource getBasedOn() {
			return this.basedOn;
		}
		
	}

	private class PathGroup extends Observable implements IDialogFieldListener {
		private final PathDialogField nameField;

		public PathGroup() {
			nameField = new PathDialogField();
			nameField.setLabelText("Configuration Name:");
			nameField.setDialogFieldListener(this);
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
			
			IResource basedOn = viewerGroup.getBasedOn();
			if(basedOn==null) {
				setErrorMessage("Based on configuration: Based on configuration must be selected.");
				setMessage(null);
				setPageComplete(false);
				return;
			}

			
			IPath namePath = pathGroup.nameField.getPath();
			if(namePath==null) {
				setErrorMessage("Configuration name: the configuration name is empty.");
				setMessage(null);
				setPageComplete(false);
				return;				
			}
			String name = namePath.toString();
			String ext = WizardUtils.getExtension(name);
			
			if (ext!=null && !"confml".equals(ext)) {
				setErrorMessage("Configuration name: the configuration has incorrect file extension.");
				setMessage(null);
				setPageComplete(false);
				return;
			} else {
				if(ext==null) {
					name = name + ".confml";					
				}
			}
			
			IProject project = basedOn.getProject();
			IFile file = project.getFile(name);

			if (file.exists()) {
				setErrorMessage("Configuration name: the configuration already exists.");
				setMessage(null);
				setPageComplete(false);
				return;
			}

			EConfigurationProject cp = ConfMLCore.getProjectModel(project);
			if (cp == null) {
				setErrorMessage("Based on configuration: the selected project does not contain variant definition.");
				setMessage(null);
				setPageComplete(false);
				return;
			}

			setErrorMessage(null);
			setMessage(null);
			setPageComplete(true);
		}
	};

	static final String PAGE_NAME = "NewConfigurationLayerWizardPageOne";

	private final PathGroup pathGroup;
	private final Validator validator;
	private final ViewerGroup viewerGroup;

	/**
	 * Constructor for SampleNewWizardPage.
	 * @param selection 
	 * 
	 * @param pageName
	 */
	public NewConfigurationWizardPageOne(IStructuredSelection selection) {
		super(PAGE_NAME);
		setTitle("Create new Configuration");
		setDescription("This wizard creates a new configuration based on existing one.");
		setPageComplete(false);
		
		viewerGroup = new ViewerGroup(setInitialSelection(selection));

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

		viewerGroup.createControl(composite);

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

	
	public IResource setInitialSelection(IStructuredSelection selection) {
		Object[] items = selection.toArray();
		for (int i = 0; i < items.length; i++) {
			Object item = items[i];
			if(item instanceof IResource) {
				IResource res = (IResource) item;
				if(res instanceof IProject) {
					return res;
				} else {
					if(res.getParent() instanceof IProject) {
						return res;
					} else {
						return res.getProject();
					}
				}
			}
			
		}
		return null;
	}

	public IResource getBasedOn() {
		return viewerGroup.getBasedOn();
	}
	
	public IResource getNewConfigurationRoot() {
		String name = pathGroup.nameField.getText();
		if(!name.endsWith(".confml")) {
			name=name+".confml";
		}
		return getBasedOn().getProject().getFile(name);
	}
}
