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

package com.nokia.tools.vct.internal.common.secure.ui.editor;

import java.util.concurrent.atomic.AtomicInteger;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.util.SafeRunnable;
import org.eclipse.jface.viewers.ContentViewer;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.ActionContext;
import org.eclipse.ui.part.EditorPart;

import com.nokia.tools.vct.common.secure.core.SecurityCorePlugin;
import com.nokia.tools.vct.internal.common.secure.ui.actions.DeleteKeysAction;
import com.nokia.tools.vct.internal.common.secure.ui.actions.ExportKeysAction;
import com.nokia.tools.vct.internal.common.secure.ui.actions.ImportKeysAction;
import com.nokia.tools.vct.internal.common.secure.ui.actions.KeyActions;
import com.nokia.tools.vct.internal.common.secure.ui.wizards.GenerateKeysWizard;

public class KeyManagerEditor extends EditorPart implements ISelectionProvider {

	private static final String IMPORT_KEYS = "Import Keys";

	private static final String DELETE = "Delete";

	private static final String EXPORT_KEYS = "Export Keys";

	private static final String GENERATE_NEW = "Generate New";

	public static final String EDITOR_ID = "com.nokia.tools.vct.keystore.editor.KeyStoreEditor";

	private Composite editorControl;

	private TableViewer keyTV;
	private MenuManager menuManager;
	private KeyActions actions;
	private ListenerList listenerList;

	@Override
	public void doSave(IProgressMonitor monitor) {
	}

	@Override
	public void doSaveAs() {

	}

	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		setSite(site);
		setInputWithNotify(input);
		setPartName("Key Store Manager");

		listenerList = new ListenerList();
		site.setSelectionProvider(this);
	}

	@Override
	public boolean isDirty() {
		return false;
	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

	@Override
	public void dispose() {
		editorControl.dispose();
		menuManager.dispose();
		actions.dispose();
		listenerList.clear();
		super.dispose();
	}

	@Override
	public void createPartControl(Composite parent) {
		actions = new KeyActions();

		editorControl = new Composite(parent, SWT.NONE);
		editorControl.setLayout(new GridLayout(2, false));

		keyTV = new TableViewer(editorControl, SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL | SWT.BORDER | SWT.FULL_SELECTION);
		keyTV.addPostSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				notifySelectionListeners();
			}
		});

		final Table keyTable = keyTV.getTable();
		keyTable.setHeaderVisible(true);
		keyTable.setLinesVisible(true);

		GridData gd = new GridData();
		gd.horizontalAlignment = GridData.FILL;
		gd.grabExcessHorizontalSpace = true;
		gd.verticalAlignment = GridData.FILL;
		gd.grabExcessVerticalSpace = true;
		gd.verticalSpan = 5;
		keyTable.setLayoutData(gd);

		keyTV.setSorter(new KeyViewerSorter());

		final AtomicInteger sortOrder = new AtomicInteger(SWT.UP);

		final TableColumn typeColumn = new TableColumn(keyTable, SWT.LEFT);
		typeColumn.setText("Type");
		typeColumn.setWidth(50);
		typeColumn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (keyTable.getSortColumn() == typeColumn) {
					if (sortOrder.get() == SWT.UP) {
						sortOrder.set(SWT.DOWN);
					} else if (sortOrder.get() == SWT.DOWN) {
						sortOrder.set(SWT.NONE);
					} else {
						sortOrder.set(SWT.UP);
					}
				} else {
					sortOrder.set(SWT.UP);
					keyTable.setSortColumn(typeColumn);
				}
				keyTable.setSortDirection(sortOrder.get());
				((KeyViewerSorter) keyTV.getSorter()).doSort(
						KeyTableConst.COLUMN_TYPE, sortOrder.get());
				keyTV.refresh();
			}
		});

		final TableColumn nameColumn = new TableColumn(keyTable, SWT.LEFT);
		nameColumn.setText("Name");
		nameColumn.setWidth(150);
		nameColumn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (keyTable.getSortColumn() == nameColumn) {
					if (sortOrder.get() == SWT.UP) {
						sortOrder.set(SWT.DOWN);
					} else if (sortOrder.get() == SWT.DOWN) {
						sortOrder.set(SWT.NONE);
					} else {
						sortOrder.set(SWT.UP);
					}
				} else {
					sortOrder.set(SWT.UP);
					keyTable.setSortColumn(nameColumn);
				}
				keyTable.setSortDirection(sortOrder.get());
				((KeyViewerSorter) keyTV.getSorter()).doSort(
						KeyTableConst.COLUMN_NAME, sortOrder.get());
				keyTV.refresh();
			}
		});

		final TableColumn orgColumn = new TableColumn(keyTable, SWT.LEFT);
		orgColumn.setText("Organization");
		orgColumn.setWidth(150);
		orgColumn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (keyTable.getSortColumn() == orgColumn) {
					if (sortOrder.get() == SWT.UP) {
						sortOrder.set(SWT.DOWN);
					} else if (sortOrder.get() == SWT.DOWN) {
						sortOrder.set(SWT.NONE);
					} else {
						sortOrder.set(SWT.UP);
					}
				} else {
					sortOrder.set(SWT.UP);
					keyTable.setSortColumn(orgColumn);
				}
				keyTable.setSortDirection(sortOrder.get());
				((KeyViewerSorter) keyTV.getSorter()).doSort(
						KeyTableConst.COLUMN_ORGANIZATION, sortOrder.get());
				keyTV.refresh();
			}
		});

		final TableColumn validityColumn = new TableColumn(keyTable, SWT.LEFT);
		validityColumn.setText("Validity");
		validityColumn.setWidth(180);
		validityColumn.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (keyTable.getSortColumn() == validityColumn) {
					if (sortOrder.get() == SWT.UP) {
						sortOrder.set(SWT.DOWN);
					} else if (sortOrder.get() == SWT.DOWN) {
						sortOrder.set(SWT.NONE);
					} else {
						sortOrder.set(SWT.UP);
					}
				} else {
					sortOrder.set(SWT.UP);
					keyTable.setSortColumn(validityColumn);
				}
				keyTable.setSortDirection(sortOrder.get());
				((KeyViewerSorter) keyTV.getSorter()).doSort(
						KeyTableConst.COLUMN_VALIDITY, sortOrder.get());
				keyTV.refresh();
			}

		});

		Font std = keyTV.getTable().getFont();
		FontData[] descr = std.getFontData();
		for (FontData next : descr) {
			next.setStyle(next.getStyle() ^ SWT.BOLD);
		}
		Font bold = new Font(null, descr);
		keyTV.setContentProvider(new KeysContentProvider());
		keyTV.setLabelProvider(new KeysLabelProvider(bold));
		keyTV.setInput(SecurityCorePlugin.getKeyStoreManager());

		Button importBtn = new Button(editorControl, SWT.NONE);
		importBtn.setText(IMPORT_KEYS);
		importBtn.setLayoutData(getBtnGD());
		importBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ImportKeysAction importKeysAction = new ImportKeysAction(keyTV);
				importKeysAction.run();
			}
		});

		Button exportBtn = new Button(editorControl, SWT.NONE);
		exportBtn.setText(EXPORT_KEYS);
		exportBtn.setLayoutData(getBtnGD());
		exportBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ISelection selection = keyTV.getSelection();
				if (selection.isEmpty()) {
					MessageBox mb = new MessageBox(getSite().getShell(),
							SWT.ICON_WORKING);
					mb.setText("Select key");
					mb.setMessage("There is no key selected.");
					mb.open();
					return;
				}
				if (selection instanceof IStructuredSelection) {
					ExportKeysAction exportKeysAction = new ExportKeysAction(
							keyTV);
					exportKeysAction.run();
				}
			}
		});

		Button generateBtn = new Button(editorControl, SWT.NONE);
		generateBtn.setText(GENERATE_NEW);
		generateBtn.setLayoutData(getBtnGD());
		generateBtn.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				Wizard wizard = new GenerateKeysWizard();
				WizardDialog dialog = new WizardDialog(getSite().getShell(),
						wizard);
				dialog.open();
			}
		});

		Button deleteBtn = new Button(editorControl, SWT.NONE);
		deleteBtn.setText(DELETE);
		deleteBtn.setLayoutData(getBtnGD());
		deleteBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				new DeleteKeysAction(keyTV).run();
			}
		});

		// dummy label
		new Label(editorControl, SWT.NONE);

		Label glossary = new Label(editorControl, SWT.NONE);
		glossary.setText("* Pair includes private key and X.509 certificate");

		createContextMenu(keyTV);
	}

	private GridData getBtnGD() {
		GridData gd = new GridData();
		gd.horizontalAlignment = GridData.FILL;
		return gd;
	}

	@Override
	public void setFocus() {
		editorControl.setFocus();
	}

	private class KeyViewerSorter extends ViewerSorter {

		private int column;

		private int direction;

		public void doSort(int column, int direction) {
			this.column = column;
			this.direction = direction;
		}

		@Override
		public int compare(Viewer viewer, Object e1, Object e2) {
			int res = 0;
			int cat1 = category(e1);
			int cat2 = category(e2);

			if (cat1 != cat2) {
				return cat1 - cat2;
			}

			String name1;
			String name2;

			if (viewer == null || !(viewer instanceof ContentViewer)) {
				name1 = e1.toString();
				name2 = e2.toString();
			} else {
				IBaseLabelProvider prov = ((ContentViewer) viewer)
						.getLabelProvider();
				if (prov instanceof ITableLabelProvider) {
					ITableLabelProvider lprov = (ITableLabelProvider) prov;
					name1 = lprov.getColumnText(e1, column);
					name2 = lprov.getColumnText(e2, column);
				} else {
					name1 = e1.toString();
					name2 = e2.toString();
				}
			}
			if (name1 == null) {
				name1 = "";//$NON-NLS-1$
			}
			if (name2 == null) {
				name2 = "";//$NON-NLS-1$
			}

			// use the comparator to compare the strings
			res = getComparator().compare(name1, name2);
			switch (direction) {
			case SWT.UP:
				res = -res;
				break;
			case SWT.DOWN:
				break;
			default:
				res = 0;
			}
			return res;
		}
	}

	private static class KeyTableConst {
		// Column constants
		public static final int COLUMN_TYPE = 0;

		public static final int COLUMN_NAME = 1;

		public static final int COLUMN_ORGANIZATION = 2;

		public static final int COLUMN_VALIDITY = 3;
	}

	private void createContextMenu(Viewer viewer) {
		MenuManager menuMgr = new MenuManager("#KeyStoreManagerMenu");
		menuMgr.setRemoveAllWhenShown(true);

		menuMgr.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
		getSite().registerContextMenu(menuMgr, viewer);

		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager menuMgr) {
				fillMenu(menuMgr);
			}
		});
		Menu menu = menuMgr.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		this.menuManager = menuMgr;
	}

	private void fillMenu(IMenuManager menuMgr) {
		ActionContext context = new ActionContext(keyTV.getSelection());
		context.setInput(keyTV);
		actions.setContext(context);
		actions.fillContextMenu(menuMgr);
	}

	public ISelection getSelection() {
		return keyTV.getSelection();
	}

	public void setSelection(ISelection selection) {
		keyTV.setSelection(selection, true);
	}

	public void addSelectionChangedListener(ISelectionChangedListener listener) {
		listenerList.add(listener);
	}

	public void removeSelectionChangedListener(
			ISelectionChangedListener listener) {
		listenerList.remove(listener);
	}

	protected void notifySelectionListeners() {
		Object[] copy = listenerList.getListeners();
		final SelectionChangedEvent event = new SelectionChangedEvent(this,
				getSelection());
		for (final Object next : copy) {
			SafeRunner.run(new SafeRunnable() {
				public void run() throws Exception {
					((ISelectionChangedListener) next).selectionChanged(event);
				}
			});
		}
	}
}
