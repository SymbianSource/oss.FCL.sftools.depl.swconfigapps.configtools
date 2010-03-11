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
package com.nokia.s60ct.cenrep.gui.view;

import interfaces.DeleteEObjectSet;

import java.util.List;

import objectview.IObjectView;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.edit.ui.provider.UnwrappingSelectionProvider;
import org.eclipse.emf.edit.ui.view.ExtendedPropertySheetPage;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableCursor;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.PropertySheetPage;

import s60cenrep.provider.SimpleKeyAdapterFactory;
import s60cenrep.provider.SimpleKeyItemProvider;
import views.AdapterFactoryCellModifier;
import cenrep.CenrepFactory;
import cenrep.CenrepPackage;
import cenrep.Key;
import cenrep.Repository;
import cenrep.TYPE;
import cenrep.util.CenrepResourceImpl;

import common.VerifyIDAdapter;

public class SimpleKeyView extends ViewPart
implements IMenuListener, IViewerProvider, IObjectView, ISelectionListener{

	public static final String ID="simplekey.view.id";
	TableViewer viewer = null;
	Repository repository=null;

	private CellEditor nameCellEditor = null;
	private CellEditor refCellEditor = null;
	private CellEditor uidCellEditor = null;
	private CellEditor typeCellEditor = null;

	PropertySheetPage propertySheetPage = null;

	private ITableLabelProvider lableProvider = null;
	private IContentProvider contentProvider = null;
	private AdapterFactory adapterFactory =null;
	private static final Object[][] NORMAL_SIMPLE_KEY = new Object[][]{
		new Object[]{Key.class, CenrepPackage.eINSTANCE.getRepository_Key()},
	};

	private static final DeleteEObjectSet DELETE_EOBJECT_SET = new DeleteEObjectSet(){
		public Object[][] getParentFeature() {
			return NORMAL_SIMPLE_KEY;
		}
		public Object[][] getRoFeatures() {
			return null;
		}
	};
	private static final String[][] COLUMNS_INIT = new String[][]{
		new String[]{"Name","Key Name", SimpleKeyItemProvider.PROP_NAME},
		new String[]{"Ref","Key Ref", SimpleKeyItemProvider.PROP_REF},
		new String[]{"Uid","Key Uid", SimpleKeyItemProvider.PROP_UID},
		new String[]{"Type","Key Type", SimpleKeyItemProvider.PROP_TYPE}
	};
	static final int NAME_INDEX=0;
	static final int TT_INDEX=1;
	static final int PROP_INDEX=2;

	private IWorkbenchWindow window;


	public SimpleKeyView() {
		adapterFactory = new SimpleKeyAdapterFactory();
		lableProvider = new AdapterFactoryLabelProvider(adapterFactory);
		contentProvider = new AdapterFactoryContentProvider(adapterFactory);
	}

	@Override
	public void createPartControl(Composite parent) {

		Composite container = new Composite(parent,SWT.NONE);
		TableColumnLayout layout = new TableColumnLayout();
		final Table table = new Table(container,SWT.NONE);
		viewer = new TableViewer(table);
		container.setLayout(layout);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		String[] columnProp=new String[COLUMNS_INIT.length];
		for (int i = 0; i < COLUMNS_INIT.length; i++) {
			String name = COLUMNS_INIT[i][NAME_INDEX];
			String tt = COLUMNS_INIT[i][TT_INDEX];
			columnProp[i] = COLUMNS_INIT[i][PROP_INDEX];
			TableColumn column = new TableColumn(table,SWT.NONE);

			if (i==0 || i==1)
				layout.setColumnData(column, new ColumnWeightData(3));
			else
				layout.setColumnData(column, new ColumnWeightData(1));

			column.setText(name);
			column.setToolTipText(tt);
		}
		viewer.setColumnProperties(columnProp);
		viewer.setLabelProvider(lableProvider);
		viewer.setContentProvider(contentProvider);
		viewer.setCellModifier(new AdapterFactoryCellModifier(adapterFactory));
		table.setData("name", "Simple Key");
		createCellEditors(table);
		viewer.setCellEditors(new CellEditor[]{nameCellEditor,refCellEditor, uidCellEditor, typeCellEditor});

		createCursor(table);
		createContextMenuFor(viewer);

		// Add listener for drop events
		DropTarget target = new DropTarget(viewer.getControl(), DND.DROP_DEFAULT | DND.DROP_COPY | DND.DROP_MOVE);
		Transfer[] types = new Transfer[] {TextTransfer.getInstance()};
		target.setTransfer(types);
		target.addDropListener(new DropTargetAdapter()  {
			public void dragOver(DropTargetEvent event) {
				// Only allow dropping if repository available
				if (viewer.getInput() == null) {
					event.detail = DND.DROP_NONE;
					return;
				}
				// Get data being dragged
				TextTransfer textTransfer = TextTransfer.getInstance();
				String data = (String) textTransfer.nativeToJava(event.currentDataType);
				if (data != null) {
					int first = data.indexOf(";");
					int second = data.indexOf(";", first + 1);
					// Don't allow sequenceitem
					if (data.substring(first + 1, second).compareTo("sequenceitem") == 0 ||
							data.substring(first + 1, second).compareTo("sequence") == 0) {
						event.detail = DND.DROP_NONE;
						return;
					}
				}
				event.detail = DND.DROP_DEFAULT;
			}
			public void drop(DropTargetEvent event) {
				// Item dropped
				String data = (String) event.data;
				int first = data.indexOf(";");
				int second = data.indexOf(";", first + 1);
				Repository repository = (Repository) viewer.getInput();
				if (repository != null) {
					Key key = null;
					if (event.item != null) {
						// Item dropped over existing key, only update ref
						key = (Key) event.item.getData();
						//key.setRef(data.substring(second + 1));
						EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(repository);
						Command cmd = SetCommand.create(domain, key, CenrepPackage.eINSTANCE.getRVG_Ref(), data.substring(second + 1));
						if (cmd != null) {
							domain.getCommandStack().execute(cmd);
						}
						viewer.refresh();
					} else {
						// New key
						key = CenrepFactory.eINSTANCE.createKey();
						key.setName(data.substring(0, first));
						key.setType(TYPE.getByName(data.substring(first + 1, second)));
						key.setRef(data.substring(second + 1));
						// Search biggest ident
						int ident = 0;
						try {
							for (Key k : repository.getKey()) {
								if (k.getIdent() != null) {
									if (Integer.valueOf(k.getIdent().replaceFirst("0x", ""), 16).intValue() > ident) {
										ident = Integer.valueOf(k.getIdent().replaceFirst("0x", ""), 16).intValue();
									}
								}
							}
							key.setIdent("0x" + Integer.toHexString(ident + 1));
						} catch (java.lang.NumberFormatException e) {
							// Too big integer
							key.setIdent("0x0");
						}
						EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(repository);
						Command cmd = AddCommand.create(domain, repository, CenrepPackage.eINSTANCE.getRepository_Key(), key);
						if (cmd != null) {
							domain.getCommandStack().execute(cmd);
						}
					}
					viewer.refresh();
				}
			}
		});

		getSite().setSelectionProvider(viewer);

		ISelection selection = getSite().getSelectionProvider().getSelection();
		processSelectionUpdateView(selection);
	}

	@Override
	public void init(IViewSite site) throws PartInitException {
		window = site.getWorkbenchWindow();
		super.init(site);
	}

	private void updateAccessView(ISelection selection) {
		Object object = processSelection(selection);
		for(IViewReference ref : window.getActivePage().getViewReferences()){
			IViewPart view = ref.getView(true);
			if(view != null) {
				IObjectView ov = (IObjectView)view.getAdapter(IObjectView.class);
				if (ov instanceof AccessView) {
					ov.show(object, true);
					return;
				}
			}
		}

	}

	private void processSelectionUpdateView(ISelection selection) {
		Object object = processSelection(selection);
		if (canShow(object)) {
			show(object, false);
		} else {
			setRepository(null); 
		}
	}

	private void createCursor(final Table table) {
		final TableCursor cursor = new TableCursor(table,SWT.NONE);
		cursor.addSelectionListener(new SelectionAdapter() {
			// when the TableEditor is over a cell, select the corresponding row in 
			// the table
			public void widgetSelected(SelectionEvent e) {
				table.setSelection(cursor.getRow());
				ISelection selection = getSite().getSelectionProvider().getSelection();
				updateAccessView(selection);
			}
			// when the user hits "ENTER" in the TableCursor, pop up a text editor so that 
			// they can change the text of the cell
			public void widgetDefaultSelected(SelectionEvent e){
				TableItem row = cursor.getRow();
				int column = cursor.getColumn();
				viewer.editElement(row.getData(), column);

			}
		});

		cursor.addMouseListener(new MouseAdapter(){
			public void mouseDown(MouseEvent e) {
				if(e.button==1){
					TableItem row = cursor.getRow();
					int column = cursor.getColumn();
					viewer.editElement(row.getData(), column);
				}else if(e.button==3){
					cursor.setMenu(table.getMenu());
				}
			}



		});
		table.addPaintListener(new PaintListener(){
			public void paintControl(PaintEvent e) {
				if(cursor.isVisible())cursor.redraw();
			}

		});
	}

	private void createCellEditors(final Table table) {
		nameCellEditor = new TextCellEditor(table);
		refCellEditor=new TextCellEditor(table);
		uidCellEditor=new TextCellEditor(table){
			@Override
			protected Control createControl(Composite parent) {
				Text text = (Text)super.createControl(parent);
				text.addVerifyListener(VerifyIDAdapter.INSTANCE);
				return text;
			}
		};
		//		((TextCellEditor)uidCellEditor).get
		TYPE[] types = TYPE.values();
		String[] typeStrings = new String[types.length];
		for (int i = 0 ; i < typeStrings.length ; i++)
			typeStrings[i] = types[i].getName();
		typeCellEditor=new ComboBoxCellEditor(table, typeStrings);
	}

	@Override
	public void setFocus() {
		viewer.getTable().setFocus();
	}

	private Object processSelection(ISelection selection) {
		Object selectedObject =null;
		if(selection instanceof IStructuredSelection) {
			IStructuredSelection structedSelection = (IStructuredSelection)selection;
			selectedObject = structedSelection.getFirstElement();
		}
		return selectedObject;
	}

	protected void setRepository(Repository repository) {
		this.repository=(Repository)repository;
		viewer.setInput(repository);
	}

	@SuppressWarnings("unchecked")
	public Object getAdapter(Class adapter) {
		if(adapter.equals(IPropertySheetPage.class)){
			return getPropertySheetPage();
		}else if(adapter.equals(DeleteEObjectSet.class)){
			return DELETE_EOBJECT_SET;
		}
		return super.getAdapter(adapter);
	}

	public IPropertySheetPage getPropertySheetPage() {
		if (propertySheetPage == null&&repository!=null) {
			propertySheetPage =
				new ExtendedPropertySheetPage((AdapterFactoryEditingDomain)AdapterFactoryEditingDomain.getEditingDomainFor(repository)) {
				public void setSelectionToViewer(List<?> selection) {
					viewer.setSelection(new StructuredSelection(selection.toArray()), true);
				}

			};
			propertySheetPage.setPropertySourceProvider(new AdapterFactoryContentProvider(adapterFactory));
		}
		return propertySheetPage;
	}

	@Override
	public void dispose() {
		if(propertySheetPage!=null)propertySheetPage.dispose();		

		super.dispose();
	}

	@Override
	public void menuAboutToShow(IMenuManager manager) {

	}

	protected void createContextMenuFor(StructuredViewer viewer) {
		MenuManager contextMenu = new MenuManager("#PopupMenu");
		contextMenu.setRemoveAllWhenShown(true);
		contextMenu.addMenuListener(this);

		Menu menu= contextMenu.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(contextMenu, new UnwrappingSelectionProvider(viewer));
	}

	public Viewer getViewer() {
		return viewer;
	}

	public void selectKey(Key key) {
		Object container = key.eContainer();
		if (container instanceof Repository) {
			setRepository((Repository)container);
			getViewer().setSelection(new TreeSelection(new TreePath(new Object[] {key})), true); 
		}
	}

	public boolean canShow(Object object) {
		return (object instanceof Key && !BitmaskKeyView.isBitmaskKey((Key)object))			   
		|| object instanceof Repository
		|| object instanceof CenrepResourceImpl; //when this is selected, view is cleaned
	}

	public void show(Object object, boolean tryActivate) throws IllegalArgumentException {
		if (!canShow(object)) {
			throw new IllegalArgumentException(); 
		}
		if (object instanceof Key) {
			selectKey((Key)object);
			if (tryActivate) {
				window.getActivePage().activate(this);
			} else {
				window.getActivePage().bringToTop(this); 
			}
		} 
		else if (object instanceof Repository) {
			setRepository((Repository)object); 
		}
		else if (object instanceof CenrepResourceImpl) {
			setRepository(null); 
		}
	}

	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		Object selectedObject = null;
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structedSelection = (IStructuredSelection) selection;
			selectedObject = structedSelection.getFirstElement();
		}
		if (canShow(selectedObject)) {
			show(selectedObject, false);
		}
	}

	//clean Option view if all CR browser are closed
	public void cleanViewer(IEditorPart editor){
		IEditorReference[] references = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getEditorReferences();
		boolean bExist=false;
		for (IEditorReference editorReference : references) {
			if(editorReference.getEditor(true).equals(editor))
				bExist=true;
		}
		if(!bExist)
			viewer.setInput(null);
		viewer.refresh();
	}
}
