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
package com.nokia.tools.vct.navigator.sign;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.layout.TreeColumnLayout;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableColorProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import com.nokia.tools.vct.common.appmodel.EConfMLLayer;
import com.nokia.tools.vct.common.appmodel.EConfigurationProject;
import com.nokia.tools.vct.common.appmodel.util.CPFSigningUtils;
import com.nokia.tools.vct.common.secure.core.SigningStatus;
import com.nokia.tools.vct.common.secure.core.SigningUtils;

public class CPFSigningViewer extends Viewer {

	private EConfigurationProject input;
	private Composite control;
	private Tree tree;
	private TreeViewer viewer;

	public CPFSigningViewer(Composite parent) {
		control = new Composite(parent, SWT.NONE);
		TreeColumnLayout layout = new TreeColumnLayout();
		control.setLayout(layout);
		tree = new Tree(control, SWT.MULTI | SWT.FULL_SELECTION);
		tree.setLinesVisible(true);
		tree.setHeaderVisible(true);
		TreeColumn column1 = new TreeColumn(tree, SWT.LEFT);
		column1.setText("Element");
		layout.setColumnData(column1, new ColumnWeightData(15, 200, true));
		TreeColumn column2 = new TreeColumn(tree, SWT.LEFT);
		column2.setText("Status");
		layout.setColumnData(column2, new ColumnWeightData(1, 80, true));
		TreeColumn column3 = new TreeColumn(tree, SWT.LEFT);
		column3.setText("Certificate");
		layout.setColumnData(column3, new ColumnWeightData(3,100, true));
		viewer = new TreeViewer(tree);
	}

	@Override
	public Control getControl() {
		return control;
	}

	@Override
	public Object getInput() {
		return input;
	}

	@Override
	public ISelection getSelection() {
		return viewer.getSelection();
	}

	@Override
	public void refresh() {
		viewer.refresh();
	}

	@Override
	public void setInput(Object input) {
		this.input = (EConfigurationProject) input;

		ResourceSet rs = this.input.eResource().getResourceSet();
		EditingDomain editingDomain = null;
		IStructuredContentProvider contentProvider;
		ILabelProvider labelProvider;
		if (rs instanceof IEditingDomainProvider) {
			editingDomain = ((IEditingDomainProvider) rs).getEditingDomain();
		}
		if (editingDomain instanceof TransactionalEditingDomain) {
			TransactionalEditingDomain domain = (TransactionalEditingDomain) editingDomain;
			contentProvider = new TransactionalContentProvider(domain);
			labelProvider = new TransactionalLabelProvider(domain);
		} else {
			contentProvider = new DirectContentProvider();
			labelProvider = new DirectLabelProvider();
		}
		
		viewer.setLabelProvider(labelProvider);
		viewer.setContentProvider(contentProvider);
		viewer.setInput(input);
	}

	@Override
	public void setSelection(ISelection selection, boolean reveal) {
		viewer.setSelection(selection, reveal);
	}

	static class DirectLabelProvider extends LabelProvider implements
			ITableLabelProvider, ITableColorProvider {
		public Image getColumnImage(Object element, int columnIndex) {
			if (element instanceof SigningStatus) {
				SigningStatus status = (SigningStatus)element;
				if (columnIndex == 0) {
					if (status.modelObject instanceof EConfigurationProject) {
						return SigningUIPlugin.getImage(ISiginginUIPluginImages.CONFML_PROJECT);
					} else {
						return SigningUIPlugin.getImage(ISiginginUIPluginImages.CONFML_LAYER);
					}
				}
			} else if (element instanceof FileElement) {
				if (columnIndex == 0) {
					return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FILE);
				}
			}
			
			return null;
		}

		public String getColumnText(Object element, int columnIndex) {
			if (element instanceof SigningStatus) {
				SigningStatus status  = (SigningStatus)element;
				switch (columnIndex) {
				case 0:
					URI uri; 
					if (status.modelObject instanceof EConfigurationProject) {
						uri = ((EConfigurationProject)status.modelObject).getRootConfml();
					} else {
						uri = ((EConfMLLayer)status.modelObject).getRootConfml();
					}
					if (uri.isPlatformResource()) {
						return new Path(uri.toPlatformString(true)).removeFirstSegments(1).toString();
					} else {
						return uri.path();
					}
					
				case 1:
					if (status.contentOK) {
						return "signed";
					} else if (!status.signatureFound) {
						return "unsigned";
					} else {
						return "modified";
					}
				case 2:
					if (status.certificate != null) {
						return SigningUtils.getShortName(status.certificate);
					} else {
						return "n/a";
					}
				}
			} else if (element instanceof FileElement) {
				FileElement file = (FileElement)element;
				switch (columnIndex) {
				case 0:
					return file.uri.path();
				case 1:
					switch (file.state) {
					case FileElement.OK:
						return "ok";
					case FileElement.ADDED:
						return "added";
					case FileElement.MODIFIED:
						return "modified";
					case FileElement.REMOVED:
						return "removed";
					}
				}
			}
			
			return null;
		}
		
		public Color getBackground(Object element, int columnIndex) {
			if (element instanceof SigningStatus) {
				SigningStatus status  = (SigningStatus)element;
				if (status.contentOK) {
					return Display.getCurrent().getSystemColor(SWT.COLOR_WHITE);
				}
				if (!status.signatureFound) {
					return Display.getCurrent().getSystemColor(SWT.COLOR_GRAY);
				}
				return Display.getCurrent().getSystemColor(SWT.COLOR_RED);
		} else if (element instanceof FileElement) {
			FileElement file = (FileElement)element;
				switch (file.state) {
				case FileElement.OK:
					return Display.getCurrent().getSystemColor(SWT.COLOR_WHITE);
				case FileElement.ADDED:
					return Display.getCurrent().getSystemColor(SWT.COLOR_GRAY);
				case FileElement.MODIFIED:
					return Display.getCurrent().getSystemColor(SWT.COLOR_RED);
				case FileElement.REMOVED:
					return Display.getCurrent().getSystemColor(SWT.COLOR_GRAY);
				}
		}

			return null;
		}
		public Color getForeground(Object element, int columnIndex) {
			if (element instanceof SigningStatus) {
				SigningStatus status  = (SigningStatus)element;
				if (status.contentOK) {
					return Display.getCurrent().getSystemColor(SWT.COLOR_BLACK);
				}
				if (!status.signatureFound) {
					return Display.getCurrent().getSystemColor(SWT.COLOR_BLACK);
				}
				return Display.getCurrent().getSystemColor(SWT.COLOR_WHITE);
			} else if (element instanceof FileElement) {
				FileElement file = (FileElement)element;
					switch (file.state) {
					case FileElement.OK:
						return Display.getCurrent().getSystemColor(SWT.COLOR_BLACK);
					case FileElement.ADDED:
						return Display.getCurrent().getSystemColor(SWT.COLOR_BLACK);
					case FileElement.MODIFIED:
						return Display.getCurrent().getSystemColor(SWT.COLOR_WHITE);
					case FileElement.REMOVED:
						return Display.getCurrent().getSystemColor(SWT.COLOR_BLACK);
					}
			}
			return null;
		}
	}

	static class TransactionalLabelProvider extends DirectLabelProvider {
		private TransactionalEditingDomain domain;

		public TransactionalLabelProvider(TransactionalEditingDomain domain) {
			this.domain = domain;
		}

		@Override
		public Image getColumnImage(final Object element, final int arg1) {
			return run(domain, new RunnableWithResult.Impl<Image>() {
				public void run() {
					setResult(TransactionalLabelProvider.super.getColumnImage(
							element, arg1));
					setStatus(Status.OK_STATUS);
				}
			});
		}

		@Override
		public String getColumnText(final Object element, final int arg1) {
			return run(domain, new RunnableWithResult.Impl<String>() {
				public void run() {
					setResult(TransactionalLabelProvider.super.getColumnText(
							element, arg1));
					setStatus(Status.OK_STATUS);
				}
			});
		}

		@Override
		public Image getImage(final Object element) {
			return run(domain, new RunnableWithResult.Impl<Image>() {
				public void run() {
					setResult(TransactionalLabelProvider.super
							.getImage(element));
					setStatus(Status.OK_STATUS);
				}
			});
		}

		@Override
		public String getText(final Object element) {
			return run(domain, new RunnableWithResult.Impl<String>() {
				public void run() {
					setResult(TransactionalLabelProvider.super.getText(element));
					setStatus(Status.OK_STATUS);
				}
			});
		}
		
		@Override
		public Color getBackground(final Object element, final int columnIndex) {
			return run(domain, new RunnableWithResult.Impl<Color>() {
				public void run() {
					setResult(TransactionalLabelProvider.super.getBackground(element, columnIndex));
					setStatus(Status.OK_STATUS);
				}
			});
		}
		
		@Override
		public Color getForeground(final Object element, final int columnIndex) {
			return run(domain, new RunnableWithResult.Impl<Color>() {
				public void run() {
					setResult(TransactionalLabelProvider.super.getForeground(element, columnIndex));
					setStatus(Status.OK_STATUS);
				}
			});
		}
	}

	static class DirectContentProvider implements IStructuredContentProvider, ITreeContentProvider {
		
		static Object[] createFileElements(SigningStatus status) {
//			
//			URI base;
//			if (status.modelObject instanceof EConfigurationProject) {
//				base = ((EConfigurationProject)status.modelObject).getRootConfml();
//			} else {
//				base = ((EConfMLLayer)status.modelObject).getRootConfml();
//			}
			
			List<Object> result = new ArrayList<Object>();
			
			for (URI uri : status.checkedFiles) {
				FileElement element = new FileElement();
				element.uri = uri;
				element.state = FileElement.OK;
				result.add(element);
			}
			for (URI uri : status.addedFiles) {
				FileElement element = new FileElement();
				element.uri = uri;
				element.state = FileElement.ADDED;
				result.add(element);
			}
			for (URI uri : status.removedFiles) {
				FileElement element = new FileElement();
				element.uri = uri;
				element.state = FileElement.REMOVED;
				result.add(element);
			}
			for (URI uri : status.tamperedFiles) {
				FileElement element = new FileElement();
				element.uri = uri;
				element.state = FileElement.MODIFIED;
				result.add(element);
			}
			
			return result.toArray();
		}
		
		public void dispose() {
		}
		
		public Object getParent(Object element) {
			return null;
		}
		
		public Object[] getChildren(Object element) {
			if (element instanceof SigningStatus) {
				return createFileElements((SigningStatus)element);
			}
			return new Object[0];
		}
		
		public boolean hasChildren(Object element) {
			return getChildren(element).length > 0;
		}
		

		public Object[] getElements(final Object inputElement) {
			if (inputElement instanceof EConfigurationProject) {
				ProgressMonitorDialog dialog = new ProgressMonitorDialog(Display.getCurrent().getActiveShell());
				final AtomicReference<Object[]> result = new AtomicReference<Object[]>();
				try {
					dialog.run(true, false, new IRunnableWithProgress() {
						public void run(IProgressMonitor monitor)
								throws InvocationTargetException,
								InterruptedException {
							// IMPROVEMENT Auto-generated method stub
							result.set(CPFSigningUtils.getProjectStatus((EConfigurationProject)inputElement, monitor));
						}
					});
				} catch (InvocationTargetException e) {
					// IMPROVEMENT Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// IMPROVEMENT Auto-generated catch block
					e.printStackTrace();
				}
				return result.get();
			} else {
				return new Object[0];
			}
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}
	}

	static class TransactionalContentProvider extends DirectContentProvider {
		private TransactionalEditingDomain domain;

		public TransactionalContentProvider(TransactionalEditingDomain domain) {
			this.domain = domain;
		}

		public Object[] getElements(final Object inputElement) {
			return run(domain, new RunnableWithResult.Impl<Object[]>() {
				public void run() {
					setResult(TransactionalContentProvider.super
							.getElements(inputElement));
					setStatus(Status.OK_STATUS);
				}
			});
		}
	}

	static <T> T run(TransactionalEditingDomain domain,
			RunnableWithResult<? extends T> run) {
		try {
			return TransactionUtil.runExclusive(domain, run);
		} catch (InterruptedException e) {
			// propagate interrupt status because we are not throwing
			Thread.currentThread().interrupt();
			return null;
		}
	}

	
	static class FileElement {
		static final int ADDED = 1; 
		static final int REMOVED = 2; 
		static final int MODIFIED = 3; 
		static final int OK = 0; 
		
		URI uri;
		int state;
	}
	
}
