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
package views;

import interfaces.DeleteEObjectSet;
import interfaces.IOptionAdapterFactory;

import java.util.Iterator;
import java.util.List;

import javax.swing.text.html.Option;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
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
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableCursor;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.PropertySheetPage;

public class OptionView extends ViewPart implements ISelectionListener, IMenuListener {

	public static String ID = "option.view";
	
	private Option option=null;
	
	public TableViewer viewer = null;
	protected PropertySheetPage propertySheetPage;
	boolean optionCanModify = false;
	public TableCursor cursor = null;
	
	private AdapterFactoryContentProvider contentProvider=null;
	private AdapterFactoryLabelProvider labelProvider=null;
	private AdapterFactoryCellModifier cellModifier=null;
	private EObject input =  null;
	
	public static final String NAME_PROPERTY = "optionName";
	public static final String VALUE_PROPERTY = "optionValue";
	
	private static final Object[][] NORMAL_OPTIONS = new Object[][]{
		
			new Object[]{OptionView.class, null}
	};
		
	private static final DeleteEObjectSet DELETE_EOBJECT_SET = new DeleteEObjectSet(){
		public Object[][] getParentFeature() {
			return NORMAL_OPTIONS;
		}
		public Object[][] getRoFeatures() {
			return null;
		}
	};
	
	private static final String[][] columnInits = new String[][]{
			new String[]{"Name",NAME_PROPERTY},
			new String[]{"Value",VALUE_PROPERTY}
	};
	private static final int NAME_INDEX = 0;
	private static final int PROP_INDEX = 1;
	
	public OptionView() {
		contentProvider = new AdapterFactoryContentProvider(null);
		labelProvider = new AdapterFactoryLabelProvider(null);
		cellModifier = new AdapterFactoryCellModifier(null);
	}
	
	public Object getAdapter(Class adapter) {
		if(adapter.equals(IPropertySheetPage.class))
			return null; 
			//return getPropertySheetPage();
		else if(adapter.equals(DeleteEObjectSet.class))
			return DELETE_EOBJECT_SET;	
		return super.getAdapter(adapter);
		
	}

	public IPropertySheetPage getPropertySheetPage() {
		if (propertySheetPage == null&&input!=null) {
			propertySheetPage =
				new ExtendedPropertySheetPage((AdapterFactoryEditingDomain)AdapterFactoryEditingDomain.getEditingDomainFor(input)) {
					public void setSelectionToViewer(List selection) {
						viewer.setSelection(new StructuredSelection(selection.toArray()), true);
					}
				};
			propertySheetPage.setPropertySourceProvider(contentProvider);//new AdapterFactoryContentProvider(adapterFactory));
		}
		return propertySheetPage;
	}
	
	
	public void createPartControl(Composite parent) {
		int style = SWT.SINGLE | SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL;
		Composite container = new Composite(parent,SWT.NONE);
		TableColumnLayout layout = new TableColumnLayout();
		container.setLayout(layout);
		
		final Table table = new Table(container, style);
		viewer = new TableViewer(table);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		
		
		String[] columnProp = new  String[columnInits.length];
		for(int i=0;i<columnInits.length;i++){
			TableColumn column = new TableColumn(table,SWT.NONE);
			layout.setColumnData(column, new ColumnWeightData(1));
			column.setText(columnInits[i][NAME_INDEX]);
			columnProp[i]=columnInits[i][PROP_INDEX];
		}
		
		viewer.setLabelProvider(labelProvider);
		viewer.setContentProvider(contentProvider);
		viewer.setCellModifier(cellModifier);
		
		
		viewer.setColumnProperties(columnProp);
		viewer.setCellEditors(new CellEditor[]{new TextCellEditor(table), new TextCellEditor(table)});
		viewer.setUseHashlookup(true);
		
		createCursor(table);
		createContextMenuFor(viewer);
		getSite().setSelectionProvider(viewer);
		getSite().getPage().addSelectionListener(this);
		
	}
	
	private void createCursor(final Table table) {
		final TableCursor cursor = new TableCursor(table,SWT.NONE);
		cursor.addSelectionListener(new SelectionAdapter() {
			// when the TableEditor is over a cell, select the corresponding row in 
			// the table
			public void widgetSelected(SelectionEvent e) {
				table.setSelection(new TableItem[] {cursor.getRow()});
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
				TableItem row = cursor.getRow();
				if(e.button==1){
					int column = cursor.getColumn();
					viewer.editElement(row.getData(), column);
					super.mouseDown(e);
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

	public void setFocus() {
		this.viewer.getTable().setFocus();
//		TableItem[] items = this.viewer.getTable().getItems();
		try
		{
			TableItem lastItem = this.viewer.getTable().getItem(this.viewer.getTable().getItems().length-1);
			this.viewer.getTable().select(this.viewer.getTable().getItems().length-1);
			this.viewer.editElement(lastItem.getData(), 0);
		}
		catch (IllegalArgumentException e)
		{
			
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
	
	public boolean select(Object selectedObject) {
		if(selectedObject!=null){
			AdapterFactory adapterFactory = (AdapterFactory)Platform.getAdapterManager().getAdapter(selectedObject, IOptionAdapterFactory.class);
			if(adapterFactory!=null) {
				labelProvider.setAdapterFactory(adapterFactory);
				contentProvider.setAdapterFactory(adapterFactory);
				cellModifier.setAdapterFactory(adapterFactory);
				viewer.setInput(selectedObject);
				viewer.refresh();
				updateView(selectedObject);
				return true;
			}
		}
		updateView(selectedObject);
		return false;
	}
	
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		Object selectedObject = processSelection(selection);
		if(selectedObject != null) {
			select(selectedObject); 
		}
	}
	
	protected void updateView(Object selectedObject){
		if (selectedObject instanceof Option ){
			if(!selectedObject.equals(option)){
				option=(Option)selectedObject;
				viewer.setInput(option);
			}
		} else {
			if(option!=null){
				option = null;
				viewer.setInput(null);
			}
		}
	}
	
	public void dispose() {
		if(propertySheetPage!=null)propertySheetPage.dispose();
		super.dispose();
	}
	
	public void menuAboutToShow(IMenuManager menuManager) {
	}
	
	protected void createContextMenuFor(StructuredViewer viewer) {
		MenuManager contextMenu = new MenuManager("#PopupMenu");
		contextMenu.setRemoveAllWhenShown(true);
		contextMenu.addMenuListener(this);
		
		Menu menu= contextMenu.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(contextMenu, new UnwrappingSelectionProvider(viewer));
	}
	
	//clean Option view if all configuration browsers are closed
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
