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

package com.nokia.tools.variant.confml.ui.views;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.util.SafeRunnable;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceAdapter;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.part.DrillDownAdapter;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import com.nokia.tools.variant.confml.core.ConfMLCore;
import com.nokia.tools.variant.confml.ui.ConfmlUI;
import com.nokia.tools.variant.confml.ui.editors.EditorUtils;
import com.nokia.tools.vct.common.appmodel.EAppFeature;
import com.nokia.tools.vct.common.appmodel.EAppGroup;
import com.nokia.tools.vct.common.appmodel.EAppSetting;
import com.nokia.tools.vct.common.appmodel.EAppSettingRef;
import com.nokia.tools.vct.common.appmodel.EAppView;
import com.nokia.tools.vct.common.appmodel.EConfMLLayer;
import com.nokia.tools.vct.common.core.utils.ArrayUtils;
import com.nokia.tools.vct.common.ui.utils.SWTUtil;
import com.nokia.tools.vct.confml.model.confml1.EConfMLDocument;

/**
 * Navigator view for the ConfML perspective. This navigator is expected to
 * display all plugin contributors and their elements.
 * 
 */
@Deprecated
public class ConfMLNavigator extends ViewPart implements ISelectionProvider,
		ITabbedPropertySheetPageContributor {
	public static final String VIEW_ID = "com.nokia.tools.variant.confml.ui.views.ConfMLNavigator";
	private TreeViewer viewer;
	private DrillDownAdapter drillDownAdapter;
	private Action doubleClickAction;
	private ListenerList listeners = new ListenerList();
	EMap<String, EAppFeature> parentFeatures;

	public TreeViewer getViewer() {
		return viewer;
	}

	public static class Options {
		EConfMLLayer parent;

		protected Options(EConfMLLayer parent) {
			this.parent = parent;
		}

		public EConfMLLayer getParent() {
			return parent;
		}
	}

	public static class Features extends Options {
		public Features(EConfMLLayer parent) {
			super(parent);
		}
	}

	public static class Views extends Options {
		public Views(EConfMLLayer parent) {
			super(parent);
		}
	}

	static class Resources extends Options {
		protected Resources(EConfMLLayer parent) {
			super(parent);
		}
	}

	static class Parents extends Options {
		protected Parents(EConfMLLayer parent) {
			super(parent);
		}
	}

	class ViewContentProvider implements IStructuredContentProvider,
			ITreeContentProvider, ResourceSetListener {

		Map<EConfMLLayer, List<Options>> treeStubs;

		TreeViewer v;
		TransactionalEditingDomain editingDomain;

		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
			editingDomain = ConfMLCore.getEditingDomain();
			editingDomain.addResourceSetListener(this);
			treeStubs = new HashMap<EConfMLLayer, List<Options>>();
			this.v = (TreeViewer) v;
		}

		public void dispose() {
			ConfMLCore.getEditingDomain().removeResourceSetListener(this);
		}

		public Object[] getElements(Object parent) {
			return getChildren(parent);
		}

		public Object getParent(Object child) {
			if (child instanceof Options) {
				return ((Options) child).parent;
			}
			if (child instanceof EObject) {
				EObject cont = ((EObject) child).eContainer();
				if (cont instanceof Map.Entry) {
					return cont.eContainer();
				}
			}

			return null;
		}

		public NotificationFilter getFilter() {
			return NotificationFilter.NOT_TOUCH;
		}

		public boolean isAggregatePrecommitListener() {
			return false;
		}

		public boolean isPostcommitOnly() {
			return true;
		}

		public boolean isPrecommitOnly() {
			return false;
		}

		public Command transactionAboutToCommit(ResourceSetChangeEvent event)
				throws RollbackException {
			return null;
		}

		public void resourceSetChanged(ResourceSetChangeEvent event) {
			final Set<Object> notifiers = new HashSet<Object>();
			for (Notification notification : event.getNotifications()) {
				Object source = notification.getNotifier();
				notifiers.add(source);
			}

			SWTUtil.getStandardDisplay().asyncExec(new Runnable() {
				public void run() {
					for (Object obj : notifiers) {
						v.refresh(obj);
					}
				}
			});
		}

		public Object[] getChildren(final Object parent) {
			Object[] result = null;
			try {
				result = TransactionUtil.runExclusive(editingDomain,
						new RunnableWithResult.Impl<Object[]>() {
							public void run() {
								Object[] objects = {};
								if (parent instanceof EConfMLLayer) {
									EConfMLLayer vp = (EConfMLLayer) parent;
									List<Options> stubs = treeStubs.get(vp);
									if (stubs == null) {
										stubs = new ArrayList<Options>();
										// stubs.add(new Resources(vp));
										stubs.add(new Features(vp));
										stubs.add(new Views(vp));
										stubs.add(new Resources(vp));
										stubs.add(new Parents(vp));
										treeStubs.put(vp, stubs);
									}
									objects = stubs.toArray();

								} else if (parent instanceof EAppFeature) {
									objects = ((EAppFeature) parent)
											.getSettings().values().toArray();
								} else if (parent instanceof EObject) {
									objects = ArrayUtils.createCopy(
											EObject.class, ((EObject) parent)
													.eContents());
								} else if (parent instanceof Features) {
									objects = ((Features) parent).parent
											.getFeatures().values().toArray();
								} else if (parent instanceof Views) {
									objects = ((Views) parent).parent
											.getViews().toArray();
								} else if (parent instanceof Resources) {
									objects = ((Resources) parent).parent
											.getLayerFiles().toArray();
								}
								setResult(objects);
								setStatus(Status.OK_STATUS);
							}
						});
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}

			return result;
		}

		public boolean hasChildren(Object parent) {
			return getChildren(parent).length > 0;
		}

	}

	class NameSorter extends ViewerSorter {
		@Override
		public int compare(Viewer viewer, Object e1, Object e2) {
			if (e1 instanceof Resource) {
				if (e2 instanceof Resource) {
					return super.compare(viewer, e1, e2);
				} else {
					return 1;
				}
			} else if (e2 instanceof Resource) {
				return -1;
			}
			return super.compare(viewer, e1, e2);
		}
	}

	/**
	 * The constructor.
	 */
	public ConfMLNavigator() {
	}

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	public void createPartControl(Composite parent) {
		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		drillDownAdapter = new DrillDownAdapter(viewer);
		viewer.setContentProvider(new ViewContentProvider());
		viewer.setLabelProvider(new DecoratingLabelProvider(
				new ConfMLViewLabelProvider(), PlatformUI.getWorkbench()
						.getDecoratorManager().getLabelDecorator()));
		viewer.setSorter(new NameSorter());
		viewer.setFilters(new ViewerFilter[0]);
		viewer.setInput(ResourcesPlugin.getWorkspace().getRoot());
		final Tree tree = viewer.getTree();

		final Listener labelListener = new Listener() {
			public void handleEvent(Event event) {
				Label label = (Label) event.widget;
				Shell shell = label.getShell();
				switch (event.type) {
				case SWT.MouseDown:
					Event e = new Event();
					e.item = (TreeItem) label.getData("_TABLEITEM");
					tree.setSelection(new TreeItem[] { (TreeItem) e.item });
					tree.notifyListeners(SWT.Selection, e);
					shell.dispose();
					tree.setFocus();
					break;
				case SWT.MouseExit:
					shell.dispose();
					break;
				}
			}
		};

		Listener tableListener = new Listener() {
			Shell tooltip = null;
			Label tooltipLabel = null;

			public void handleEvent(Event event) {
				switch (event.type) {
				case SWT.Dispose:
				case SWT.KeyDown:
				case SWT.MouseMove: {
					if (tooltip == null)
						break;
					tooltip.dispose();
					tooltip = null;
					tooltipLabel = null;
					break;
				}
				case SWT.MouseHover: {
					TreeItem item = tree.getItem(new Point(event.x, event.y));
					if (item != null) {
						if ((item.getData() instanceof EAppFeature)
								|| (item.getData() instanceof EAppSetting)) {
							if (tooltip != null && !tooltip.isDisposed())
								tooltip.dispose();
							tooltip = new Shell(Display.getCurrent()
									.getActiveShell(), SWT.ON_TOP
									| SWT.NO_FOCUS | SWT.TOOL);
							tooltip.setBackground(Display.getCurrent()
									.getSystemColor(SWT.COLOR_INFO_BACKGROUND));
							FillLayout layout = new FillLayout();
							layout.marginWidth = 2;
							tooltip.setLayout(layout);
							tooltipLabel = new Label(tooltip, SWT.NONE);
							tooltipLabel.setForeground(Display.getCurrent()
									.getSystemColor(SWT.COLOR_INFO_FOREGROUND));
							tooltipLabel.setBackground(Display.getCurrent()
									.getSystemColor(SWT.COLOR_INFO_BACKGROUND));
							tooltipLabel.setData("_TABLEITEM", item);
							String tooltipText = null;
							EAppFeature feature;
							if (item.getData() instanceof EAppFeature) {
								feature = (EAppFeature) item.getData();
							} else {
								EAppSetting setting = (EAppSetting) item
										.getData();
								feature = (EAppFeature) setting.eContainer()
										.eContainer();
							}
							EConfMLLayer ev = (EConfMLLayer) feature
									.eContainer().eContainer();
							tooltipLabel.setText("Inherited from "
									+ tooltipText);
							tooltipLabel.addListener(SWT.MouseExit,
									labelListener);
							tooltipLabel.addListener(SWT.MouseDown,
									labelListener);
							Point size = tooltip.computeSize(SWT.DEFAULT,
									SWT.DEFAULT);
							Rectangle rect = item.getBounds(0);
							Point pt = tree.toDisplay(rect.x, rect.y);
							tooltip.setBounds(pt.x, pt.y, size.x, size.y);
							if (tooltipText != null) {
								tooltip.setVisible(true);
							} else {
								tooltip.setVisible(false);
							}
						}
					}
				}
				}
			}
		};
		tree.addListener(SWT.Dispose, tableListener);
		tree.addListener(SWT.KeyDown, tableListener);
		tree.addListener(SWT.MouseMove, tableListener);
		tree.addListener(SWT.MouseHover, tableListener);

		Transfer[] types = new Transfer[] { LocalSelectionTransfer
				.getTransfer() };
		int operations = DND.DROP_MOVE | DND.DROP_COPY | DND.DROP_LINK;
		final DragSource source = new DragSource(viewer.getTree(), operations);
		source.setTransfer(types);
		source.addDragListener(new DragSourceAdapter() {
			public void dragStart(DragSourceEvent event) {
				ISelection selection = viewer.getSelection();
				if (!selection.isEmpty()) {
					event.doit = true;
					LocalSelectionTransfer.getTransfer()
							.setSelection(selection);
				} else {
					event.doit = false;
				}
			};
		});

		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				Object[] copy = listeners.getListeners();
				final SelectionChangedEvent event1 = new SelectionChangedEvent(
						ConfMLNavigator.this, event.getSelection());
				for (final Object l : copy) {
					SafeRunner.run(new SafeRunnable() {
						public void run() throws Exception {
							((ISelectionChangedListener) l)
									.selectionChanged(event1);
						}
					});
				}
			}
		});

		// Create the help context id for the viewer's control
		PlatformUI.getWorkbench().getHelpSystem().setHelp(viewer.getControl(),
				"com.nokia.tools.variant.confml.ui.viewer");
		makeActions();
		hookContextMenu();
		hookDoubleClickAction();
		contributeToActionBars();

	}

	@Override
	protected void setSite(IWorkbenchPartSite site) {
		super.setSite(site);
		site.setSelectionProvider(this);
	}

	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.add(new Separator());
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				ConfMLNavigator.this.fillContextMenu(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, viewer);
	}

	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void fillLocalPullDown(IMenuManager manager) {
	}

	private void fillContextMenu(IMenuManager manager) {
		manager.add(createNewMenu());
		manager.add(new Separator());

		manager.add(createOpenMenu());
		manager.add(new Separator());

		// manager.add(new Separator(ActionFactory.EDIT_ACTION_SETS.getId()));
		// manager.add(new Separator());

		manager.add(createImportExportMenu());
		manager.add(new Separator());

		// drillDownAdapter.addNavigationActions(manager);
		// Other plug-ins can contribute there actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));

		manager.add(new Separator());
		manager.add(new Separator(ActionFactory.PROPERTIES.getId()));
	}

	private MenuManager createOpenMenu() {

		MenuManager openWithManager = new MenuManager("&Open With", "OpenWith");

		openWithManager.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {

				ISelection selection = getViewer().getSelection();
				IContributionItem[] items = manager.getItems();

				if (selection instanceof StructuredSelection) {
					StructuredSelection structuredSelection = (StructuredSelection) selection;
					Object firstElement = structuredSelection.getFirstElement();

					if (firstElement instanceof EConfMLDocument) {
						for (int i = 0; i < items.length; i++) {
							if (items[i]
									.getId()
									.equalsIgnoreCase(
											"com.nokia.tools.variant.confml.ui.confmlvieweditor")) {
								items[i].setVisible(false);
								break;
							}
						}
					} else if (firstElement instanceof EAppView) {
						for (int i = 0; i < items.length; i++) {
							if (items[i]
									.getId()
									.equalsIgnoreCase(
											"com.nokia.tools.variant.confml.ui.confmleditor")) {
								items[i].setVisible(false);
								break;
							}
						}
					}
				}
			}

		});
		return openWithManager;
	}

	private MenuManager createNewMenu() {
		return new MenuManager("&New", "New");
	}

	private MenuManager createImportExportMenu() {
		return new MenuManager("&ImportExport", "ImportExport");
	}

	private void fillLocalToolBar(IToolBarManager manager) {
		drillDownAdapter.addNavigationActions(manager);
	}

	private void makeActions() {
		doubleClickAction = new Action() {
			public void run() {
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection) selection)
						.getFirstElement();

				String editorId = null;
				EConfMLDocument res = null;

				if (obj instanceof EAppSettingRef || obj instanceof EAppGroup
						|| obj instanceof EAppView) {
					res = EditorUtils.getConfMLResource((EObject) obj);
					editorId = ConfmlUI.VIEW_EDITOR_ID;
					// } else if (obj instanceof EAppFeature) {
					// res = EditorUtils.getConfMLResource(((EAppFeature) obj)
					// .getType());
					// editorId =
					// "org.eclipse.wst.xml.ui.internal.tabletree.XMLMultiPageEditorPart"
					// ;
					// } else if (obj instanceof EAppSetting) {
					// res = EditorUtils.getConfMLResource(((EAppSetting) obj)
					// .getType());
					// editorId =
					// "org.eclipse.wst.xml.ui.internal.tabletree.XMLMultiPageEditorPart"
					// ;
				} else if (obj instanceof EConfMLDocument) {
					res = (EConfMLDocument) obj;
					editorId = null;
				} else {
					showMessage("Double-click detected on " + obj.toString());
				}

				EditorUtils.openEditor(res, editorId);

			}

		};
	}

	private void hookDoubleClickAction() {
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				doubleClickAction.run();
			}
		});
	}

	private void showMessage(String message) {
		MessageDialog.openInformation(viewer.getControl().getShell(),
				"ConfML Navigator", message);
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}

	public void addSelectionChangedListener(ISelectionChangedListener listener) {
		listeners.add(listener);
	}

	public void removeSelectionChangedListener(
			ISelectionChangedListener listener) {
		listeners.remove(listener);
	}

	public ISelection getSelection() {
		return viewer == null ? StructuredSelection.EMPTY : viewer
				.getSelection();
	}

	public void setSelection(ISelection selection) {
		if (viewer != null) {
			viewer.setSelection(selection);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object getAdapter(Class adapter) {
		if (IPropertySheetPage.class.equals(adapter)) {
			if (propertySheetPage == null) {
				propertySheetPage = new TabbedPropertySheetPage(this);
			}
			return propertySheetPage;
		}

		return super.getAdapter(adapter);
	}

	IPropertySheetPage propertySheetPage;

	public String getContributorId() {
		return VIEW_ID;
	}

}
