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
import java.util.Vector;

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
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
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

import s60cenrep.provider.KeyRangeItemProvider;
import s60cenrep.provider.RangeAdapterFactory;
import s60cenrep.provider.SimpleKeyItemProvider;
import views.AdapterFactoryCellModifier;
import cenrep.CenrepFactory;
import cenrep.CenrepPackage;
import cenrep.Key;
import cenrep.KeyRange;
import cenrep.Repository;
import cenrep.TYPE;
import cenrep.util.CenrepResourceImpl;

import common.VerifyIDAdapter;

import cursor.TreeCursor;

public class RangeKeyView extends ViewPart 
	implements IMenuListener, IViewerProvider, IObjectView {
	
	public static final String ID = "rangekey.view.id";
	TreeViewer viewer = null;
	Repository repository = null;
	
	private CellEditor nameCellEditor = null;
	private CellEditor refCellEditor = null;
	private CellEditor uidCellEditor = null;
	private CellEditor typeCellEditor = null;
	private CellEditor fiCellEditor = null;
	private CellEditor liCellEditor = null;
	
	PropertySheetPage propertySheetPage = null;
	
	private ITableLabelProvider lableProvider = null;
	private IContentProvider contentProvider = null;
	private AdapterFactory adapterFactory =null;
	
	private static final Object[][] NORMAL_RANGE_KEY = new Object[][] {
		new Object[] {KeyRange.class, CenrepPackage.eINSTANCE.getRepository_RangeKey()},
		new Object[] {Key.class, CenrepPackage.eINSTANCE.getKeyRange_Keys()}
	};
	
	private static final DeleteEObjectSet DELETE_EOBJECT_SET = new DeleteEObjectSet() {
		public Object[][] getParentFeature() {
			return NORMAL_RANGE_KEY;
		}
		public Object[][] getRoFeatures() {
			return null;
		}
	};
	
	private static final String[][] COLUMNS_INIT = new String[][] {
		new String[] {"Name","Key Name", KeyRangeItemProvider.PROP_NAME},
		new String[] {"Ref","Key Ref", KeyRangeItemProvider.PROP_REF},
		new String[] {"Uid","Key Uid", SimpleKeyItemProvider.PROP_UID},
		new String[] {"Type","Key Type", SimpleKeyItemProvider.PROP_TYPE},
		new String[] {"FirstInt","Range First Int", KeyRangeItemProvider.PROP_FIRSTINT},
		new String[] {"LastInt","Range Last Int", KeyRangeItemProvider.PROP_LASTINT}
		
	};
	
	static final int NAME_INDEX = 0;
	static final int TT_INDEX = 1;
	static final int PROP_INDEX = 2;
	
	public RangeKeyView() {
		adapterFactory = new RangeAdapterFactory();
		lableProvider = new AdapterFactoryLabelProvider(adapterFactory);
		contentProvider = new AdapterFactoryContentProvider(adapterFactory);
	}
	
	public void dispose() {
		super.dispose(); 		
	}

	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.LEFT);
		TreeColumnLayout layout = new TreeColumnLayout();
		container.setLayout(layout);
		
		final Tree tree = new Tree(container, SWT.LEFT);
		viewer = new TreeViewer(tree);
		tree.setLinesVisible(true);
		tree.setHeaderVisible(true);
		String[] columnProp = new String[COLUMNS_INIT.length];
		for (int i = 0; i < COLUMNS_INIT.length; i++) {
			String name = COLUMNS_INIT[i][NAME_INDEX];
			String tt = COLUMNS_INIT[i][TT_INDEX];
			columnProp[i] = COLUMNS_INIT[i][PROP_INDEX];
			TreeColumn column = new TreeColumn(tree, SWT.LEFT);
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
		viewer.setCellEditors(new CellEditor[]{nameCellEditor, refCellEditor, uidCellEditor, typeCellEditor, fiCellEditor,liCellEditor});
		
		createCursor(tree);
		createContextMenuFor(viewer);
		
		
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
			    	//int first = data.indexOf(";");
					//int second = data.indexOf(";", first + 1);
					String[] dataItems = data.split(";");
					// Only allow sequence
					if (dataItems[1].equals("sequenceitem") || dataItems[1].equals("sequence")) {
						String parentRef = dataItems[2];
						if (event.item != null) 
						{
							KeyRange keyRange = null;
							if (event.item.getData() instanceof KeyRange) //prevent mixing of refs
							{
								keyRange = (KeyRange)event.item.getData();
							} 
							else if (event.item.getData() instanceof Key)
							{
								Key key = (Key)event.item.getData();
								keyRange = (KeyRange)key.eContainer();
							}
							
							if (keyRange!=null)
							{
								if (keyRange.getRef()!=null && !keyRange.getRef().equals(parentRef) && !keyRange.getRef().equals(""))
								{
									event.detail = DND.DROP_NONE;
									return;
								}
							}
							else
							{
								event.detail = DND.DROP_NONE;
								return;
							}
						}
						event.detail = DND.DROP_DEFAULT;
					}
					else
					{
						event.detail = DND.DROP_NONE;
					}
			    } 
			    else 
			    {
			    	event.detail = DND.DROP_NONE;
			    }
			}
			public void drop(DropTargetEvent event) {
				// Item dropped
				String data = (String) event.data;
				String[] dataItems = data.split(";");
				Repository repository = (Repository) viewer.getInput();
				
				String name = dataItems[0];
				String parentRef = dataItems[2];
				
				
				if (dataItems[1].equals("sequence")) //user DnD' whole sequence setting
				{	//name ; sequence ; featureRef/SeqSetRef ; leafSettings
					//leafSettings = name1/type1/ref1 ; name2/type2/ref2
					
					Vector leafSettings = new Vector(10);
					for (int i = 3 ; i < dataItems.length ; i++)
					{
						leafSettings.add(dataItems[i]);
					}
					dragAndDropCreateNewRange(name, parentRef, leafSettings);
				}
				else if (dataItems[1].equals("sequenceitem")) //user DnD' sequence setting's single setting item...
				{   //data = ParentSettingName///LeafSettingName ; sequenceitem ; featureRef/SeqSetRef ; type ; leafSettingRef
					String parentSettingName = name.split("///")[0];
					String leafSettingName = name.split("///")[1];
					String type = dataItems[3];
					String lsdRef = dataItems[4];
					
					if (event.item==null)
					{
						Vector leafSetting = new Vector(1);
						leafSetting.add(leafSettingName+"/"+type+"/"+lsdRef);
						dragAndDropCreateNewRange(parentSettingName, parentRef, leafSetting);
					}
					else if (event.item.getData() instanceof KeyRange) //...over existing key range
					{
						dragAndDropCreateNewKey((KeyRange)event.item.getData(), leafSettingName, type, parentRef, lsdRef);
					}
					else if (event.item.getData() instanceof Key)  //...over existing key
					{
						dragAndDropReplaceKeyInRange((Key)event.item.getData(), leafSettingName, type, parentRef, lsdRef);
					}
				}
				viewer.refresh();
			}
		});
	}

	
	private void dragAndDropCreateNewRange(String name, String ref, Vector leafSettings)
	{
		KeyRange range = CenrepFactory.eINSTANCE.createKeyRange();
		range.setName(name);
		range.setRef(ref);
		EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(repository);
		Command command = AddCommand.create(editingDomain, repository, CenrepPackage.eINSTANCE.getRepository_RangeKey(), range);
		if (command != null) 
			editingDomain.getCommandStack().execute(command);
		
		for (int i = 0 ; i < leafSettings.size() ; i++)
		{
			String[] lsString = ((String)leafSettings.elementAt(i)).split("/");
			dragAndDropCreateNewKey(range, lsString[0], lsString[1], ref, lsString[2]);
		}
	}
	
	private void dragAndDropCreateNewKey(KeyRange range, String name, String type, String parentRef, String lsdRef)
	{
		// New key
		Key key = CenrepFactory.eINSTANCE.createKey();
		key.setName(name);
		key.setType(TYPE.getByName(type));
		key.setRef(lsdRef);
		// Search biggest ident
		int ident = 0;
		try {
			for (Key k : range.getKeys()) {
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
		// Update range ref to this key
		range.setRef(parentRef);
		// Add key to range
		//range.getKeys().add(key);
		EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(repository);
		Command cmd = AddCommand.create(domain, range, CenrepPackage.eINSTANCE.getKeyRange_Keys(), key);
		if (cmd != null) {
			domain.getCommandStack().execute(cmd);
		}
	}
	
	private void dragAndDropReplaceKeyInRange(Key key, String name, String type, String parentRef, String lsdRef)
	{
		
		KeyRange range = null;
		for (KeyRange oldRange : repository.getRangeKey()) {
			for (Key oldKey : oldRange.getKeys()) {
				if (oldKey == key) {
					range = oldRange;
					break;
				}
			}
		}
		
		range.setRef(parentRef);
		
		key.setName(name);
		key.setType(TYPE.getByName(type));
		
		//key.setRef(lsdRef);
		// Update range ref to this key
		EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(repository);
		Command cmd = SetCommand.create(domain, key, CenrepPackage.eINSTANCE.getRVG_Ref(), lsdRef);
		if (cmd != null) {
			domain.getCommandStack().execute(cmd);
		}
	}
	
	private void createCellEditors(final Tree tree) {
		// Name
		nameCellEditor = new TextCellEditor(tree);
		// Ref
		refCellEditor = new TextCellEditor(tree);
		//uid
		uidCellEditor=new TextCellEditor(tree){
			@Override
			protected Control createControl(Composite parent) {
				Text text = (Text)super.createControl(parent);
				text.addVerifyListener(VerifyIDAdapter.INSTANCE);
				return text;
			}
		};
		//type
		TYPE[] types = TYPE.values();
		String[] typeStrings = new String[types.length];
		for (int i = 0 ; i < typeStrings.length ; i++)
			typeStrings[i] = types[i].getName();
		typeCellEditor=new ComboBoxCellEditor(tree, typeStrings);
		// first int
		fiCellEditor = new TextCellEditor(tree){
			@Override
			protected Control createControl(Composite parent) {
				Text text = (Text)super.createControl(parent);
				text.addVerifyListener(VerifyIDAdapter.INSTANCE);
				return text;
			}
		};
		// last int
		liCellEditor = new TextCellEditor(tree){
			@Override
			protected Control createControl(Composite parent) {
				Text text = (Text)super.createControl(parent);
				text.addVerifyListener(VerifyIDAdapter.INSTANCE);
				return text;
			}
		};
	}
	
	private void createCursor(final Tree table) {
		final TreeCursor cursor = new TreeCursor(table, SWT.LEFT);
		cursor.addSelectionListener(new SelectionAdapter() {
			// when the TableEditor is over a cell, select the corresponding row in 
			// the table
			public void widgetSelected(SelectionEvent e) {
				table.setSelection(new TreeItem[] {cursor.getRow()});
				ISelection selection = getSite().getSelectionProvider().getSelection();
				updateAccessView(selection);
			}
			// when the user hits "ENTER" in the TableCursor, pop up a text editor so that 
			// they can change the text of the cell
			public void widgetDefaultSelected(SelectionEvent e) {
				TreeItem row = cursor.getRow();
				int column = cursor.getColumn();
				viewer.editElement(row.getData(), column);	
			}
		});
		
		cursor.addMouseListener(new MouseAdapter() {
			public void mouseDown(MouseEvent e) {
				if (e.button == 1 ) {
					TreeItem row = cursor.getRow();
					int column = cursor.getColumn();
					viewer.editElement(row.getData(), column);
				} else if (e.button == 3) {
					cursor.setMenu(table.getMenu());
				}
			}
		});
		
		table.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				if (cursor.isVisible()) cursor.redraw();
			}		
		});
	}
	
	@Override
	public void setFocus() {
		viewer.getTree().setFocus();
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
		Object selectedObject = null;
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structedSelection = (IStructuredSelection)selection;
			for (Iterator<Object> iterator = structedSelection.iterator(); iterator.hasNext();) {
				selectedObject = iterator.next();
			}
		}
		return selectedObject;
	}
	
	protected void setRepository(Repository repository) {
		this.repository = repository;
		viewer.setInput(repository);
	}
		
	public Object getAdapter(Class adapter) {
		if (adapter.equals(IPropertySheetPage.class)) {
			return getPropertySheetPage();
		} else if (adapter.equals(DeleteEObjectSet.class)) {
			return DELETE_EOBJECT_SET;
		}
		return super.getAdapter(adapter);
	}
	
	public IPropertySheetPage getPropertySheetPage() {
		if (propertySheetPage == null && repository != null) {
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
	
	public Viewer getViewer() {
		return viewer;
	}

	public boolean canShow(Object object) {
		return object instanceof KeyRange
			   || object instanceof Repository
			   || object instanceof CenrepResourceImpl; //when this is selected, view is cleaned
	}

	public void show(Object object, boolean tryActivate) throws IllegalArgumentException {
		if (!canShow(object)) {
			throw new IllegalArgumentException(); 
		}
		if (object instanceof KeyRange) {
			KeyRange range = (KeyRange)object;
			
			Object container = range.eContainer();
			if (container instanceof Repository) {
				setRepository((Repository)container);
				getViewer().setSelection(new TreeSelection(new TreePath(new Object[] {object})), true);
				if (tryActivate) {
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().activate(this); 
				} else {
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().bringToTop(this); 
				}
			}
		} 
		else if (object instanceof Repository) {
			setRepository((Repository)object); 
		}
		else if (object instanceof CenrepResourceImpl) {
			setRepository(null); 
		}
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
