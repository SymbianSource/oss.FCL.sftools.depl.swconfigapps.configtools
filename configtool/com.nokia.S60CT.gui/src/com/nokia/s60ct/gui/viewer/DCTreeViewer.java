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
package com.nokia.s60ct.gui.viewer;

import interfaces.CellModifier;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Widget;

import cellEditors.BoolComboEditor;
import cellEditors.ComboROCellEditor;
import cellEditors.FileCellEditor;
import cellEditors.FolderCellEditor;
import cellEditors.IPairItem;
import cellEditors.IntCellEditor;
import cellEditors.IntComboEditor;
import cellEditors.RealCellEditor;
import cellEditors.StringComboEditor;
import configurationemf.Configuration;
import configurationemf.ICellEditorProvider;
import configurationemf.IDynamicColumnProvider;
import configurationemf.ISequenceValueProvider;
import configurationemf.LeafSetting;
import configurationemf.ParentSetting;
import configurationemf.provider.SettingItemProvider;
import cursor.TreeCursor;

public class DCTreeViewer extends TreeViewer{

	private Map availableColumns = new HashMap();

	CellModifier cellModifierProvider = null;
	ICellEditorProvider cellEditorProvider=null;
	
	boolean settingCanModify = true;
	int currentIndex=-1;
	TreeCursor cursor=null;
	boolean showAll= false;

	TextCellEditor textCellEditor;
	BoolComboEditor boolComboEditor;
	StringComboEditor stringComboEditor;
	IntComboEditor intComboEditor;
	FileCellEditor fileCellEditor;
	ComboROCellEditor comboROeditor;
	IntCellEditor intCellEditor;
	
	private Object [][] CELL_EDITOR_TYPE = new Object[][]{
		new Object[]{ICellEditorProvider.STRING_TEXT,null},
		new Object[]{ICellEditorProvider.BOOLEAN_COMBO,null},
		new Object[]{ICellEditorProvider.INT_TEXT,null},
		new Object[]{ICellEditorProvider.REAL_TEXT,null},
		new Object[]{ICellEditorProvider.COMBO_RO,null},
		new Object[]{ICellEditorProvider.COMBO_INT,null},
		new Object[]{ICellEditorProvider.COMBO_STRING,null},
		new Object[]{ICellEditorProvider.FILE_BUTTON,null},
		new Object[]{ICellEditorProvider.FOLDER_BUTTON,null}
	};
	private static final int CE_TYPE=0;
	private static final int CE_OBJECT=1;
	
	public DCTreeViewer(final Tree tree) {
		super(tree);
		this.setUseHashlookup(true);
		this.setCellModifier(this.getCellModifier());
		initCellEditors(tree);
		createCursor(tree);
		this.setCellModifier(createCellModifier());	
	}
	
	public TreeCursor getCursor() {
		return cursor;
	}

	private void createCursor(final Tree tree) {
		cursor = new TreeCursor(tree,SWT.NONE);
		cursor.setBackground(tree.getBackground());
		cursor.addSelectionListener(new SelectionAdapter(){
				public void widgetDefaultSelected(SelectionEvent e) {
					TreeItem row = cursor.getRow();
					int column = cursor.getColumn();
					DCTreeViewer.this.editElement(row.getData(), column);
				}
				public void widgetSelected(SelectionEvent e) {
					tree.setSelection(cursor.getRow());
					
				}
		});
		cursor.addMouseListener(new MouseAdapter(){
			public void mouseDown(MouseEvent e) {
				if(e.button==1){
					TreeItem row = cursor.getRow();
					int column = cursor.getColumn();
					DCTreeViewer.this.editElement(row.getData(), column);
				}else if(e.button==3){
					cursor.setMenu(tree.getMenu());
				}
			}
		});

		

	}

	private void initCellEditors(final Tree tree) {
		for (int i = 0; i < CELL_EDITOR_TYPE.length; i++) {
			int type = (Integer)CELL_EDITOR_TYPE[i][CE_TYPE];
			CellEditor cellEditor=null;
			switch(type){
			case ICellEditorProvider.STRING_TEXT:
				cellEditor = new TextCellEditor(tree);
				break;
			case ICellEditorProvider.BOOLEAN_COMBO:
				cellEditor = new BoolComboEditor(tree);
				break;
			case ICellEditorProvider.INT_TEXT:
				cellEditor = new IntCellEditor(tree);
				break;
			case ICellEditorProvider.COMBO_RO:
				cellEditor = new BoolComboEditor(tree);
				break;
			case ICellEditorProvider.COMBO_INT:
				cellEditor = new IntComboEditor(tree,new String[0]);
				break;
			case ICellEditorProvider.COMBO_STRING:
				cellEditor= new StringComboEditor(tree, new String[0]);
				break;
			case ICellEditorProvider.FILE_BUTTON:
				cellEditor =new FileCellEditor(tree);
				break;
			case ICellEditorProvider.FOLDER_BUTTON:
				cellEditor =new FolderCellEditor(tree);
				break;
			case ICellEditorProvider.REAL_TEXT:
				cellEditor=new RealCellEditor(tree);
				break;
			};
			CELL_EDITOR_TYPE[i][CE_OBJECT]=cellEditor;
			 
		}
		
	}
	public void setShowAll(boolean showAll){
		if(this.showAll!=showAll){
			this.showAll=showAll;
			this.refresh();
		}
	}
	public void editElement(Object element, int column) {
		ICellEditorProvider cepro = getCellEditorProvider();
		if(cepro!=null){
			CellEditor cellEditor = createCellEditor(cepro.getCellEditor(element, column));
			if(cellEditor!=null){
				if(cellEditor instanceof IPairItem){
					((IPairItem)cellEditor).setPairs(cepro.getPairItems(element,column));
				}
				applyCellEditor(column, cellEditor);
			}else return;
		}
		super.editElement(element, column);
	}
	private void applyCellEditor(int column, CellEditor cellEditor) {
		CellEditor[] cellEditors = getCellEditors();
		if(cellEditors==null||cellEditors.length<=column)
			cellEditors = new CellEditor[this.getTree().getColumnCount()];
		cellEditors[column]=cellEditor;
		setCellEditors(cellEditors);
	}
	private CellEditor createCellEditor(int editorType){
		CellEditor cellEditor=null;
		for (int i = 0; i < CELL_EDITOR_TYPE.length&&cellEditor==null; i++) {
			int type = (Integer)CELL_EDITOR_TYPE[i][CE_TYPE];
			CellEditor editor = (CellEditor)CELL_EDITOR_TYPE[i][CE_OBJECT];
			if(type==editorType)cellEditor=editor;
		}
		return cellEditor;
	}
	public void setCurrentIndex(int currentIndex){
		if(this.currentIndex!=currentIndex){
			this.currentIndex=currentIndex;
			this.refresh();
		}
	}
	public int getCurrentIndex(){
		return currentIndex;
	}
	public int getSequenceSize(Object parentSetting){
		if(getLabelProvider() instanceof IDynamicColumnProvider){
			IDynamicColumnProvider dcp = (IDynamicColumnProvider)getLabelProvider();
			return dcp.getSequenceNumber(parentSetting);
		}
		return 0;
	}
	
	protected void createChildren(Widget widget) {
		super.createChildren(widget);
		
	}

	protected Item newItem(Widget parent, int flags, int ix) {
		
		return super.newItem(parent, flags, ix);
	}

	protected Object[] getRawChildren(Object parent) {
		Object[] original =super.getRawChildren(parent);
		Object[] result =null;
		if(showAll){
			if(original.length>0&&parent instanceof ParentSetting){
				IDynamicColumnProvider svp = (IDynamicColumnProvider)this.getLabelProvider();
				int fNumber = Math.max(1, svp.getSequenceNumber(parent));
				result = new Object[original.length*fNumber];
				for(int i=0;i<fNumber;i++)
					System.arraycopy(original, 0, result, original.length*i, original.length);
			}else result=original;
		}else result=original;
		return result;
	}
	public TreeItem getCursorItem(){
		return cursor.getRow();
	}
	public static int getValueIndex(TreeItem treeItem){
		int itemIndex = treeItem.getParentItem().indexOf(treeItem);
		String stringIndex =Double.toString(Math.ceil(itemIndex/2));
		stringIndex=stringIndex.substring(0, stringIndex.indexOf("."));
		int valueIndex = Integer.valueOf(stringIndex).intValue();
		return valueIndex;
	}
	Map elementOrder = new HashMap();
	protected void mapElement(Object element, Widget item) {
		super.mapElement(element, item);
		if(element instanceof LeafSetting && item.getData("index")==null){
			Integer order = (Integer)elementOrder.get(element);
			if(order==null)order=Integer.valueOf(0);
			else order=Integer.valueOf(order.intValue()+1);
			elementOrder.put(element, order);
			item.setData("index", order);
		}
	}

	protected void doUpdateItem(Item item, Object element) {
		super.doUpdateItem(item, element);
		
		IBaseLabelProvider blpro = this.getLabelProvider(); 
		IDynamicColumnProvider dcpro=null;
		ISequenceValueProvider svpro=null;
		TreeItem treeItem = (TreeItem)item;
		if(blpro instanceof ISequenceValueProvider && treeItem.getParentItem()!=null){
			int valueIndex = DCTreeViewer.getValueIndex(treeItem);
			svpro = (ISequenceValueProvider)blpro;
			String value=null;
			if(showAll){
				value=svpro.getValueForFrame(element, valueIndex);
				Display display = getTree().getDisplay();
				if(valueIndex%2==0)treeItem.setBackground(display.getSystemColor(SWT.COLOR_GRAY));
			}
			else value=svpro.getValueForFrame(element, currentIndex>0?currentIndex:0);
			if(value!=null){
				((TreeItem)item).setText(SettingItemProvider.SETTING_VALUE, value);
			}
		}
		if(blpro instanceof IDynamicColumnProvider){
			dcpro = (IDynamicColumnProvider)this.getLabelProvider();
			Map map = dcpro.getConfValues(element);
			final Tree tree = getTree();
			for(Iterator it=map!=null?map.keySet().iterator():null;it!=null&&it.hasNext();){
				Configuration conf = (Configuration)it.next();
				String value = (String)map.get(conf);
				TreeColumn treeColumn = (TreeColumn)availableColumns.get(conf);
				int index = 0;
				if(treeColumn==null){
					index = tree.getColumnCount();
					int[] currentOrder = tree.getColumnOrder();
					int[] newOrder = new int[currentOrder.length+1];
					treeColumn = new TreeColumn(tree,SWT.NONE,index);
					
					availableColumns.put(conf, treeColumn);
					treeColumn.setText(conf.getName());
					treeColumn.setData("index", Integer.valueOf(index));
					tree.setColumnOrder(newOrder);
				}else index = ((Integer)treeColumn.getData("index")).intValue();

				((TreeItem)item).setText(index,value!=null?value:"ND");
				treeColumn.pack();
			}
			cursor.redraw();
		}
		
	}
	/*
	 * this function must be called when input has been changed
	 */
	public void removeAvailableColumns() {
		for(Iterator it = availableColumns.values().iterator();it.hasNext();){
			TreeColumn treeColumn = (TreeColumn)it.next();
			treeColumn.dispose();
		}
		availableColumns.clear();
	}

	

	private ICellModifier createCellModifier() {
		return new DCellModifier();
	}
	
	private class DCellModifier implements ICellModifier {
		
		public boolean canModify(Object element, String property) {
			return DCTreeViewer.this.getCellModifierProvider().canModify(element, property);
			
		}
		public Object getValue(Object element, String property) {
			return DCTreeViewer.this.getCellModifierProvider().getValue(element, property);
		}
		public void modify(Object element, String property, Object value) {
			String strValue=(String)value;
			if(strValue.equals(""))
				value=null;
			Object object = ((Item)element).getData();
			Object parent = getParentObject((TreeItem)element);
			DCTreeViewer.this.getCellModifierProvider().modify(parent,object, property, value);
		}
	}

	private Object getParentObject(TreeItem item){
		TreeItem parentItem = item.getParentItem();
		if(parentItem!=null)return parentItem.getData();
		else return getInput();
	}
	
	public CellModifier getCellModifierProvider() {
		if(cellModifierProvider==null){
			IContentProvider contentProvider = this.getContentProvider();
			if(contentProvider instanceof CellModifier)
				cellModifierProvider = (CellModifier)contentProvider;
		}
		return cellModifierProvider;
	}
	public ICellEditorProvider getCellEditorProvider() {
			if(cellEditorProvider==null){
			IBaseLabelProvider blp = getLabelProvider();
			if(blp instanceof ICellEditorProvider)
				cellEditorProvider=(ICellEditorProvider)blp;
		}
		return cellEditorProvider;
	}
	
	
	
}
