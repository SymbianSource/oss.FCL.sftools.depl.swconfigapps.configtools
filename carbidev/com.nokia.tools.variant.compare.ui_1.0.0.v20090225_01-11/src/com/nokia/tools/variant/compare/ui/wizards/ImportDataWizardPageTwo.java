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
 * Description: This file is part of com.nokia.tools.variant.compare.ui component.
 */

package com.nokia.tools.variant.compare.ui.wizards;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeViewerListener;
import org.eclipse.jface.viewers.TreeExpansionEvent;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;

import com.nokia.tools.variant.compare.cmodel.ECompareElement;
import com.nokia.tools.variant.compare.cmodel.EDiffGroup;
import com.nokia.tools.variant.compare.cmodel.EDiffResourceSetting2;
import com.nokia.tools.variant.compare.cmodel.EDiffSequence;
import com.nokia.tools.variant.compare.cmodel.EDiffSequenceItem;
import com.nokia.tools.variant.compare.cmodel.EDiffSetting;
import com.nokia.tools.variant.compare.cmodel.EModelRoot;
import com.nokia.tools.variant.compare.cmodel.provider.ECompareModelItemProviderAdapterFactory;
import com.nokia.tools.variant.compare.cmodel.provider.StateAdapterFactoryProvider;
import com.nokia.tools.variant.compare.ui.CustomCheckedTreeViewer;
import com.nokia.tools.variant.compare.ui.actions.CollapseAllAction;
import com.nokia.tools.variant.compare.ui.actions.ExpandAllAction;

public class ImportDataWizardPageTwo extends WizardPage {

	protected CustomCheckedTreeViewer treeViewerWithColumns;

	protected ComposedAdapterFactory adapterFactory;

	protected MenuManager menuManager;

	protected ImportDataWizardPageTwo() {
		super("ImportDataWizardPageTwo");
		setPageComplete(false);
		setTitle("Select settings to import");
		setDescription("You can select settings you want to import");

		adapterFactory = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		adapterFactory
				.addAdapterFactory(new ECompareModelItemProviderAdapterFactory());

	}

	public void createControl(Composite parent) {
		Composite content = new Composite(parent, SWT.NONE);
		// container.addControlListener(new ControlAdapter() {
		// @Override
		// public void controlResized(ControlEvent e) {
		// Rectangle bounds = getContainer().getClientArea();
		// content.setBounds(bounds);
		// }
		// });

		// {
		// @Override
		// public Point computeSize(int hint, int hint2,
		// boolean changed) {
		// return new Point(control.getClientArea().width - 16 ,
		// control.getClientArea().height - 16);
		// }
		// };
		content.setLayout(new GridLayout(2, true));
		// content.setLayoutData(new FillLayout());

		final Button check1 = new Button(content, SWT.CHECK);
		check1.setText("Show settings that exist only in target");
		check1.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false));
		final Button check2 = new Button(content, SWT.CHECK);
		check2.setText("Show settings that exist only in source");
		check2.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false));

		final Button check3 = new Button(content, SWT.CHECK);
		check3.setText("Show mismatches between default values");
		check3.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false));
		final Button check4 = new Button(content, SWT.CHECK);
		check4.setText("Show conflicts");
		check4.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false));
		SelectionListener checkAdapter = new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				List<ViewerFilter> filters = new ArrayList<ViewerFilter>();

				filters.add(new ViewerFilter() {

					@Override
					public boolean select(Viewer viewer, Object parentElement,
							Object element) {
						IStructuredContentProvider provider = (IStructuredContentProvider) treeViewerWithColumns
								.getContentProvider();
						if (provider == null) {
							return true;
						}
						if (element instanceof EDiffSequenceItem
								|| ((EObject) element).eContainer() instanceof EDiffSequenceItem) {
							return true;
						}
						if (element instanceof EDiffGroup) {
							return hasChildren((EDiffGroup) element);
						} else if (element instanceof EDiffResourceSetting2) {
							return hasChildren((EDiffResourceSetting2) element);
						}

						return true;
					}

					boolean hasChildren(EObject group) {
						IStructuredContentProvider provider = (IStructuredContentProvider) treeViewerWithColumns
								.getContentProvider();
						Object[] children = provider.getElements(group);

						for (ViewerFilter filter : treeViewerWithColumns
								.getFilters()) {
							children = filter.filter(treeViewerWithColumns,
									group, children);
						}

						return children.length > 0;
					}

				});

				final boolean targetOnly = check1.getSelection();
				final boolean sourceOnly = check2.getSelection();
				
				filters.add(new ViewerFilter() {
					@Override
					public boolean select(Viewer viewer,
							Object parentElement, Object element) {
						if (element instanceof EDiffSequenceItem
								|| ((EObject) element).eContainer() instanceof EDiffSequenceItem) {
							return true;
						}
						if (element instanceof EDiffGroup) {
							return true;
						}
						if (element instanceof ECompareElement) {
							ECompareElement el = (ECompareElement) element;
							if (el.isExistsInSource() && el.isExistsInTarget()) {
								return true;
							}
							if (targetOnly && el.isExistsInTarget()) {
								return true;
							}
							if (sourceOnly && el.isExistsInSource()) {
								return true;
							}
							return false;
						}

						return true;
					}
					});

				if (!check3.getSelection()) {
					filters.add(new ViewerFilter() {
						@Override
						public boolean select(Viewer viewer,
								Object parentElement, Object element) {
							if (element instanceof EDiffSequenceItem
									|| ((EObject) element).eContainer() instanceof EDiffSequenceItem) {
								return true;
							}
							if (element instanceof EDiffSetting) {
								EDiffSetting el = (EDiffSetting) element;
								return !(el.isSourceDefault() && el
										.isTargetDefault());
							}

							return true;
						}
					});
				}
				if (!check4.getSelection()) {
					filters.add(new ViewerFilter() {
						@Override
						public boolean select(Viewer viewer,
								Object parentElement, Object element) {
							if (element instanceof EDiffSequenceItem
									|| ((EObject) element).eContainer() instanceof EDiffSequenceItem) {
								return true;
							}
							if (element instanceof EDiffSetting) {
								EDiffSetting el = (EDiffSetting) element;
								if (el.isExistsInSource()
										&& el.isExistsInTarget()
										&& (!el.isTargetDefault() && !(el instanceof EDiffSequence))) {
									return false;
								}
							}

							return true;
						}
					});
				}
				treeViewerWithColumns.getControl().setRedraw(false);
				try {
					treeViewerWithColumns.setUpdateFlags(false);
					treeViewerWithColumns.setFilters(filters
							.toArray(new ViewerFilter[filters.size()]));

				} finally {
					treeViewerWithColumns.setUpdateFlags(true);
					treeViewerWithColumns.updateSelectionFlags();
					treeViewerWithColumns.getControl().setRedraw(true);
				}
			}
		};
		check1.addSelectionListener(checkAdapter);
		check2.addSelectionListener(checkAdapter);
		check3.addSelectionListener(checkAdapter);
		check4.addSelectionListener(checkAdapter);

		CustomCheckedTreeViewer viewer = new CustomCheckedTreeViewer(content,
				SWT.FULL_SELECTION | SWT.CHECK);
		viewer.getControl().setLayoutData(
				new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));

		viewer.addTreeListener(new ITreeViewerListener() {
			public void treeCollapsed(TreeExpansionEvent event) {
			}

			public void treeExpanded(TreeExpansionEvent event) {
				// Object element = event.getElement();
				// CheckboxTreeViewer viewer = (CheckboxTreeViewer) event
				// .getTreeViewer();
				// ITreeContentProvider cp = (ITreeContentProvider) viewer
				// .getContentProvider();
				// Object elements[] = cp.getChildren(element);
				// for (Object obj : elements) {
				// if (obj instanceof ECheckableElement) {
				// ((ECheckableElement) obj).setChecked(viewer
				// .getChecked(obj));
				// }
				// }
				//
				// viewer.update(elements, null);
			}
		});

		treeViewerWithColumns = viewer;

		check4.setSelection(true);
		checkAdapter.widgetSelected(null);

		final Tree tree = treeViewerWithColumns.getTree();
		// tree.setLayoutData(new FillLayout());
		tree.setHeaderVisible(true);
		tree.setLinesVisible(true);

		final TreeColumn objectColumn = new TreeColumn(tree, SWT.NONE);
		objectColumn.setText("Object");
		objectColumn.setResizable(true);
		objectColumn.setWidth(250);

		final TreeColumn sourceColumn = new TreeColumn(tree, SWT.NONE);
		sourceColumn.setText("Source Value");
		sourceColumn.setResizable(true);
		sourceColumn.setWidth(200);

		final TreeColumn stateColumn = new TreeColumn(tree, SWT.NONE);
		stateColumn.setText("");
		stateColumn.setResizable(false);
		stateColumn.setWidth(22);
		stateColumn.setAlignment(SWT.CENTER);

		final TreeColumn targetColumn = new TreeColumn(tree, SWT.NONE);
		targetColumn.setText("Target Value");
		targetColumn.setResizable(true);
		targetColumn.setWidth(200);

		final TreeColumn tailColumn = new TreeColumn(tree, SWT.NONE);
		tailColumn.setText("");
		tailColumn.setResizable(false);
		tailColumn.setWidth(200);

		ControlAdapter adapter = new ControlAdapter() {
			@Override
			public void controlResized(ControlEvent e) {
				if (tree.getColumnCount() > 0) {
					int width = tree.getClientArea().width;
					for (int i = 0; i < tree.getColumnCount() - 1; i++) {
						width -= tree.getColumn(i).getWidth();
					}

					width = Math.max(0, width);
					tree.getColumn(tree.getColumnCount() - 1).setWidth(width);
				}
			}
		};

		for (int i = 0; i < tree.getColumnCount() - 1; i++) {
			tree.getColumn(i).addControlListener(adapter);
		}

		tree.addControlListener(adapter);

		treeViewerWithColumns.setColumnProperties(new String[] { "a", "b" });
		treeViewerWithColumns
				.setContentProvider(new AdapterFactoryContentProvider(
						adapterFactory));
		treeViewerWithColumns.setLabelProvider(new StateAdapterFactoryProvider(
				adapterFactory, treeViewerWithColumns));

		menuManager = new MenuManager();
		menuManager.setRemoveAllWhenShown(true);
		menuManager.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				addActions(manager);
			}
		});

		Menu menu = menuManager.createContextMenu(treeViewerWithColumns
				.getControl());
		treeViewerWithColumns.getControl().setMenu(menu);

		treeViewerWithColumns.addCheckStateListener(new ICheckStateListener() {
			public void checkStateChanged(CheckStateChangedEvent event) {
				Object[] elements = treeViewerWithColumns.getCheckedElements();
				setPageComplete(elements.length > 0);
			}
		});

		setControl(content);
	}

	protected void addActions(IMenuManager manager) {
		manager.add(new ExpandAllAction(treeViewerWithColumns));
		manager.add(new CollapseAllAction(treeViewerWithColumns));
	}

	public void setCompareModelRoot(EModelRoot root) {
		treeViewerWithColumns.getControl().setRedraw(false);
		try {
			treeViewerWithColumns.setInput(root);
			treeViewerWithColumns.refresh(true);
			treeViewerWithColumns.updateSelectionFlags();
			treeViewerWithColumns.expandAll();
		} finally {
			treeViewerWithColumns.getControl().setRedraw(true);
		}
	}

	public Object[] getCheckedElements() {
		return treeViewerWithColumns.getCheckedElements();
	}

	@Override
	public void dispose() {
		if (menuManager != null) {
			menuManager.dispose();
		}

		super.dispose();
	}

}
