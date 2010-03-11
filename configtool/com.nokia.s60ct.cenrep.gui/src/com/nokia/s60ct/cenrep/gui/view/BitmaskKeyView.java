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

import java.util.Iterator;
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
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.layout.TreeColumnLayout;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.PropertySheetPage;

import s60cenrep.provider.BitmaskKeyAdapterFactory;
import s60cenrep.provider.BitmaskKeyItemProvider;
import s60cenrep.provider.SimpleKeyItemProvider;
import views.AdapterFactoryCellModifier;
import cenrep.Bit;
import cenrep.CenrepFactory;
import cenrep.CenrepPackage;
import cenrep.Key;
import cenrep.Repository;
import cenrep.TYPE;
import cenrep.util.CenrepResourceImpl;

import common.VerifyIDAdapter;

import cursor.TreeCursor;

public class BitmaskKeyView extends ViewPart 
	implements IMenuListener, IObjectView, IViewerProvider {
	public static final String ID="bitmaskkey.view.id";
	TreeViewer viewer = null;
	Repository repository=null;
	
	private ITableLabelProvider lableProvider = null;
	private IContentProvider contentProvider = null;
	private AdapterFactory adapterFactory =null;
	
	PropertySheetPage propertySheetPage = null;
	
	private CellEditor nameCellEditor = null;
	private CellEditor refCellEditor = null;
	private CellEditor uidCellEditor = null;
	private CellEditor typeCellEditor = null;
	
	private static final Object[][] NORMAL_BITMASK_KEY = new Object[][]{
		new Object[]{Key.class, CenrepPackage.eINSTANCE.getRepository_Key()},
		new Object[]{Bit.class, CenrepPackage.eINSTANCE.getKey_Bits()}
	};
	
	private static final DeleteEObjectSet DELETE_EOBJECT_SET = new DeleteEObjectSet(){
		public Object[][] getParentFeature() {
			return NORMAL_BITMASK_KEY;
		}
		public Object[][] getRoFeatures() {
			return null;
		}
	};
	
	
	private static final String[][] COLUMNS_INIT = new String[][]{
		new String[]{"Name","Key Name", BitmaskKeyItemProvider.PROP_NAME},
		new String[]{"Ref","Key Ref", BitmaskKeyItemProvider.PROP_REF},
		new String[]{"Uid","Key Uid", SimpleKeyItemProvider.PROP_UID},
		new String[]{"Type","Key Type", SimpleKeyItemProvider.PROP_TYPE}
	};
	static final int NAME_INDEX=0;
	static final int TT_INDEX=1;
	static final int PROP_INDEX=2;
	
	public BitmaskKeyView() {
		adapterFactory = new BitmaskKeyAdapterFactory();
		lableProvider = new AdapterFactoryLabelProvider(adapterFactory);
		contentProvider = new AdapterFactoryContentProvider(adapterFactory);
	}

	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent,SWT.NONE);
		TreeColumnLayout layout = new TreeColumnLayout();
		container.setLayout(layout);
		final Tree tree = new Tree(container,SWT.NONE);
		viewer = new TreeViewer(tree);
		tree.setLinesVisible(true);
		tree.setHeaderVisible(true);
		String[] columnProp=new String[COLUMNS_INIT.length];
		for (int i = 0; i < COLUMNS_INIT.length; i++) {
			String name = COLUMNS_INIT[i][NAME_INDEX];
			String tt = COLUMNS_INIT[i][TT_INDEX];
			columnProp[i] = COLUMNS_INIT[i][PROP_INDEX];
			TreeColumn column = new TreeColumn(tree,SWT.NONE);
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
		
		getSite().setSelectionProvider(viewer);
		
		createCellEditors(tree);
		viewer.setCellEditors(new CellEditor[]{nameCellEditor,refCellEditor, uidCellEditor, typeCellEditor});
		
		// Add listener for drop events
		DropTarget target = new DropTarget(viewer.getControl(), DND.DROP_DEFAULT | DND.DROP_COPY | DND.DROP_MOVE);
		Transfer[] types = new Transfer[] {TextTransfer.getInstance()};
		target.setTransfer(types);
		target.addDropListener(new DropTargetAdapter() {
			public void dragOver(DropTargetEvent event) {
				// Get data being dragged
				TextTransfer textTransfer = TextTransfer.getInstance();
			    String data = (String) textTransfer.nativeToJava(event.currentDataType);
			    if (data != null) {
			    	int first = data.indexOf(";");
					int second = data.indexOf(";", first + 1);
					// Only allow boolean
					if (data.substring(first + 1, second).compareTo("boolean") != 0) {
						event.detail = DND.DROP_NONE;
						return;
					}
			    }
			    // Only allow drop on top of Key or Bit items
				if (event.item != null) {
					if (event.item.getData() instanceof Key) {
						event.detail = DND.DROP_DEFAULT;
					} else {
						if (event.item.getData() instanceof Bit) {
							event.detail = DND.DROP_DEFAULT;
						} else {
							event.detail = DND.DROP_NONE;
						}
					}
				}
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
						if (event.item.getData() instanceof Key) {
							// Add new bit
							key = (Key) event.item.getData();
							Bit bit = CenrepFactory.eINSTANCE.createBit();
							bit.setRef(data.substring(second + 1));
							bit.setNumber(key.getBits().get(key.getBits().size() - 1).getNumber() + 1);
							//key.getBits().add(bit); //use command instead. Otherwise isDirty state is not updated.
							EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(repository);
							Command cmd = AddCommand.create(domain, key, CenrepPackage.eINSTANCE.getKey_Bits(), bit);
							if (cmd != null) {
								domain.getCommandStack().execute(cmd);
							}
							viewer.refresh();
						}
						if (event.item.getData() instanceof Bit) {
							// Change ref on bit
							Bit bit = (Bit) event.item.getData();
							//bit.setRef(data.substring(second + 1)); //use command instead. Otherwise isDirty state is not updated.
							key = null;
							EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(repository);
							Command cmd = SetCommand.create(domain, bit, CenrepPackage.eINSTANCE.getRVG_Ref(), data.substring(second + 1));
							if (cmd != null) {
								domain.getCommandStack().execute(cmd);
							}
							viewer.refresh();
						}
					} else {
						// Add new bit holder
						key = CenrepFactory.eINSTANCE.createKey();
						key.setName(data.substring(0, first));
						key.setType(TYPE.getByName(data.substring(first + 1, second)));
						//key.setRef(data.substring(second + 1));
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
						Bit bit = CenrepFactory.eINSTANCE.createBit();
						bit.setRef(data.substring(second + 1));
						if (key.getBits().size() > 0) {
							bit.setNumber(key.getBits().get(key.getBits().size() - 1).getNumber() + 1);
						} else {
							bit.setNumber(1);
						}
						key.getBits().add(bit);
					}
					EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(repository);
					Command cmd = AddCommand.create(domain, repository, CenrepPackage.eINSTANCE.getRepository_Key(), key);
					if (cmd != null) {
						domain.getCommandStack().execute(cmd);
					}
					viewer.refresh();
				}
			}
		});
		
		createCursor(tree);
		createContextMenuFor(viewer);
		
		ISelection selection = getSite().getSelectionProvider().getSelection();
		processSelectionUpdateView(selection);
	}
	
	private void createCursor(final Tree tree) {
		final TreeCursor cursor = new TreeCursor(tree,SWT.NONE);
		cursor.setBackground(tree.getBackground());
		cursor.addSelectionListener(new SelectionAdapter(){
				public void widgetDefaultSelected(SelectionEvent e) {
					TreeItem row = cursor.getRow();
					int column = cursor.getColumn();
					viewer.editElement(row.getData(), column);
				}
				public void widgetSelected(SelectionEvent e) {
					tree.setSelection(cursor.getRow());
					ISelection selection = getSite().getSelectionProvider().getSelection();
					updateAccessView(selection);
				}
		});
		cursor.addMouseListener(new MouseAdapter(){
			public void mouseDown(MouseEvent e) {
				if(e.button==1){
					TreeItem row = cursor.getRow();
					int column = cursor.getColumn();
					viewer.editElement(row.getData(), column);
				}else if(e.button==3){
					cursor.setMenu(tree.getMenu());
				}
			}
		});
	}
	
	private void createCellEditors(final Tree table) {
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
	
	private void updateAccessView(ISelection selection) {
		Object object = processSelection(selection);
		if (PlatformUI.getWorkbench() != null 
		    	&& PlatformUI.getWorkbench().getActiveWorkbenchWindow() != null 
		    	&& PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage() != null) {
			    for(IViewReference ref : PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getViewReferences()){
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
		
	}
	
	private void processSelectionUpdateView(ISelection selection) {
		Object object = processSelection(selection);
		if (canShow(object)) {
			show(object, false);
		} else {
			setRepository(null);
		}
	}

	private Object processSelection(ISelection selection) {
		Object selectedObject =null;
		if(selection instanceof IStructuredSelection) {
			IStructuredSelection structedSelection = (IStructuredSelection)selection;
			for (Iterator<Object> iterator = structedSelection.iterator(); iterator.hasNext();) {
				selectedObject =  iterator.next();
			}
		}
		return selectedObject;
	}
	
	@Override
	public void setFocus() {
		viewer.getTree().setFocus();
	}
	
	public void setRepository(Repository repository) {
		if(this.repository != repository) {
			this.repository = repository; 
			viewer.setInput(repository); 
		}
	}
	
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
					public void setSelectionToViewer(List selection) {
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
	
	public void menuAboutToShow(IMenuManager menuManager) {
//		((IMenuListener)getEditorSite().getActionBarContributor()).menuAboutToShow(menuManager);
		fillContextMenu(menuManager);
	}
	
	protected void fillContextMenu(IMenuManager menuManager){
		IMenuManager newMenu = new MenuManager("New","New");
		newMenu.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
		menuManager.add(new Separator());
		menuManager.add(newMenu);
		menuManager.add(new Separator());
		menuManager.add(new GroupMarker("Edit"));
	}

	
	protected void createContextMenuFor(StructuredViewer viewer) {
		MenuManager contextMenu = new MenuManager("#PopupMenu");
		contextMenu.setRemoveAllWhenShown(true);
		contextMenu.addMenuListener(this);
		
		Menu menu= contextMenu.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(contextMenu, new UnwrappingSelectionProvider(viewer));
	}

	public void selectBit(Bit bit) {
		selectKey((Key)bit.eContainer());
		getViewer().setSelection(new TreeSelection(new TreePath(new Object[] {bit})), true); 
	}

	public void selectKey(Key key) {
		Object container = key.eContainer();
		if (container instanceof Repository) {
			setRepository((Repository)container);
			getViewer().setSelection(new TreeSelection(new TreePath(new Object[] {key})), true); 
		}
	}
	
	public static boolean isBitmaskKey(Key key) {
		return key.getBits().size() > 0;
	}

	public boolean canShow(Object object) {
		return object instanceof Bit
		       || (object instanceof Key && isBitmaskKey((Key)object))
		       || object instanceof Repository
		       || object instanceof CenrepResourceImpl; //when this is selected, view is cleaned
	}

	public void show(Object object, boolean tryActivate) throws IllegalArgumentException {
		if (!canShow(object)) {
			throw new IllegalArgumentException(); 
		}
		if (object instanceof Bit) {
			selectBit((Bit)object);
			if (tryActivate) {
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().activate(this); 
			} else {
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().bringToTop(this); 
			}
		} 
		else if (object instanceof Key && isBitmaskKey((Key)object)) {
			selectKey((Key)object);
			if (tryActivate) {
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().activate(this); 
			} else {
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().bringToTop(this); 
			}
		} 
		else if (object instanceof Repository) {
			setRepository((Repository)object); 
		}
		else if (object instanceof CenrepResourceImpl) {
			setRepository(null); 
		}
	}

	public Viewer getViewer() {
		return viewer;
	}
	
	//clean Option view if all CR browsers are closed
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
