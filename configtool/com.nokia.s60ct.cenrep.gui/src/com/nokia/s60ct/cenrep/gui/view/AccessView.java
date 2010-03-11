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

import interfaces.IViewMarkerResolver;
import objectview.IObjectView;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableCursor;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.views.properties.IPropertySheetPage;

import cenrep.Access;
import cenrep.CenrepFactory;
import cenrep.CenrepPackage;
import cenrep.IAccessable;
import cenrep.util.CenrepResourceImpl;

import com.nokia.s60ct.cenrep.gui.CenRepPlugin;
import common.VerifyIDAdapter;

public class AccessView extends ViewPart 
	implements IObjectView {
	public static final String ID="access.view";
	
	
	private static final String[] COLUMN_PROPERTIES =new String[]{"Capability","R","W"};
	private static final int CAP_COLUMN=0;
	private static final int R_COLUMN=1;
	private static final int W_COLUMN=2;
	private static final String READ_ACCESS="R";
	private static final String WRITE_ACCESS="W";
	
	//Access attributes
	private static final int ACCESS_TYPE = CenrepPackage.ACCESS__TYPE;
	private static final int ACCESS_SID = CenrepPackage.ACCESS__SID;
	private static final int ACCESS_CAPABILITIES = CenrepPackage.ACCESS__CAPABILITIES;
	
	int style = SWT.SINGLE | SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION;
	CapProvider capProvider=new CapProvider(); 
	
	TableViewer tableViewer=null;
	
	public AccessView() {
		super();
	}

	public void dispose() {
		super.dispose();
	}
	
	@Override
	public Object getAdapter(Class adapter) {
		if(adapter.equals(IViewMarkerResolver.class))
			return resolver;
		else if(adapter.equals(IPropertySheetPage.class))
			return null;
		return super.getAdapter(adapter);
	}

	IViewMarkerResolver resolver = new IViewMarkerResolver(){
		public boolean accept(EObject object) {
			return object!=null && object instanceof Access;
		}
		public void updateElement(EObject object, EStructuralFeature feature) {
			System.out.println("update");
		}
	};

	public void createPartControl(Composite parent) {
		Composite gridComposite =createGridComposite(parent);
		createCapTable(gridComposite);
		createSIDEditors(gridComposite);
	}

	private Composite createGridComposite(Composite parent){
		GridLayout layout = new GridLayout(1,true);
		Composite result=new Composite(parent,SWT.NONE);
		result.setLayout(layout);
		return result;
	}
	private void createCapTable(Composite parent){
		GridData gdata = new GridData(SWT.FILL,SWT.FILL,true,true);
		Composite container = new Composite(parent,SWT.NONE);
		TableColumnLayout layout= new TableColumnLayout();
		container.setLayout(layout);
		container.setLayoutData(gdata);
		Table table = new Table(container,SWT.NONE);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		final TableColumn capColumn = new TableColumn(table,SWT.LEFT);
		final TableColumn rColumn = new TableColumn(table,SWT.LEFT);
		final TableColumn wColumn = new TableColumn(table,SWT.LEFT);
	
		capColumn.setText(AccessView.COLUMN_PROPERTIES[CAP_COLUMN]);
		rColumn.setText(AccessView.COLUMN_PROPERTIES[R_COLUMN]);
		wColumn.setText(AccessView.COLUMN_PROPERTIES[W_COLUMN]);
		
		layout.setColumnData(capColumn, new ColumnWeightData(3,1,true));
		layout.setColumnData(rColumn, new ColumnWeightData(1,1,false));
		layout.setColumnData(wColumn, new ColumnWeightData(1,1,false));
		
		tableViewer = new TableViewer(table);
		tableViewer.setColumnProperties(AccessView.COLUMN_PROPERTIES);
		
		tableViewer.setLabelProvider(capProvider);
		tableViewer.setContentProvider(capProvider);
		tableViewer.setCellModifier(capProvider);
		
		createCursor(table);
	}

	private void createCursor(Table table) {
		SelectionAdapter selectionAdapter = new CursorSelectionAdapter(table);
		final TableCursor cursor = new TableCursor(table,SWT.NONE);
		cursor.addSelectionListener(selectionAdapter);
		cursor.addMouseListener(new MouseAdapter(){
			public void mouseDown(MouseEvent e) {
				if(cursor.getColumn()!=CAP_COLUMN)
					tableViewer.editElement(cursor.getRow().getData(), cursor.getColumn());	
			}
		});
	}
	
	class CursorSelectionAdapter extends SelectionAdapter {
		Table table = null;
		boolean mouseFlag = false;
		
		public CursorSelectionAdapter(Table table){
			table.addMouseListener(new MouseAdapter(){
				public void mouseDown(MouseEvent e) {
					mouseFlag=true;	
				}
			});
		}
		public void widgetDefaultSelected(SelectionEvent e) {
			TableCursor cursor = (TableCursor)e.getSource();
			if(cursor.getColumn()!=CAP_COLUMN)
				tableViewer.editElement(cursor.getRow().getData(), cursor.getColumn());
		}
		public void widgetSelected(SelectionEvent e) {
			TableCursor cursor = (TableCursor)e.getSource();
			if(cursor.getColumn()!=CAP_COLUMN){
				tableViewer.setSelection(new StructuredSelection(cursor.getRow().getData()),true);
			if(mouseFlag)
				tableViewer.editElement(cursor.getRow().getData(), cursor.getColumn());
			}
			mouseFlag=false;
		}
	}
	
	private void createSIDEditors(Composite parent){
		GridLayout layout = new GridLayout(3,false);
		GridData gdata = new GridData(SWT.FILL,SWT.FILL,false,false);
		Composite composite = new Composite(parent,SWT.NONE);
		composite.setLayoutData(gdata);
		composite.setLayout(layout);
		
		GridData gTextData=new GridData(SWT.FILL,SWT.NONE,true,false);
		
		Label read_lable = new Label(composite,SWT.NONE);
		Label read_0x = new Label(composite,SWT.NONE);
		Text read_sid=new Text(composite,SWT.NONE);
		
		read_sid.setLayoutData(gTextData);
		read_lable.setText("READ SID");
		read_0x.setText("0x");
		capProvider.setRSID(read_sid);
		
		Label write_lable = new Label(composite,SWT.NONE);
		Label write_0x = new Label(composite,SWT.NONE);
		Text write_sid=new Text(composite,SWT.NONE);
		
		
		write_sid.setLayoutData(gTextData);
		write_lable.setText("WRITE SID");
		write_0x.setText("0x");
		capProvider.setWSID(write_sid);
	}
	
	
	
	public void setFocus() {
		tableViewer.getTable().setFocus();
	}
	
	private class CapProvider implements IStructuredContentProvider, ITableLabelProvider, ICellModifier{
		private Object parent = null;
		private Access rAccess = null;
		private Access wAccess = null;
		
		private Text rSID=null;
		private Text wSID=null;
		
		private final Image CHECKED_IMAGE;;
		private final Image UNCHECKED_IMAGE;;
		
		private final Object[]CAPS = {
				"AlwaysPass","TCB",
				"CommDD","PowerMgmt",
				"MultimediaDD","ReadDeviceData",
				"WriteDeviceData","DRM",
				"TrustedUI","ProtServ",
				"DiskAdmin","NetworkControl",
				"AllFiles","SwEvent",
				"NetworkServices","LocalServices",
				"ReadUserData","WriteUserData",
				"Location","SurroundingsDD",
				"UserEnvironment"
		};
		
		private FocusAdapter focusAdapter=new FocusAdapter(){
			String oldValue=null;
			public void focusGained(FocusEvent e) {
				super.focusGained(e);
				Text text = (Text)e.widget;
				oldValue=text.getText();
			}
			public void focusLost(FocusEvent e) {
				super.focusLost(e);
				Text text = (Text)e.widget;
				String newValue=text.getText();
				if(newValue!=null&&newValue.compareTo(oldValue)!=0){//update SID
					
					Access access = null;
					if(text.equals(rSID))
						access=getCreateRAccess();
					else if(text.equals(wSID))
						access=getCreateWAccess();
					
					updateStringAttribure(access, ACCESS_SID, parseValue(newValue));
					tableViewer.refresh();
				}
			}
			
			private String parseValue(String value)
			{
				if (value.startsWith("0x") || value.startsWith("0X"))
				{
					return "0x"+value.substring(2).toUpperCase();
				}
				else
					return "0x"+value.toUpperCase();
			}
			
		};
		
		
		
		public boolean canModify(Object element, String property) {
			if(property.compareTo(COLUMN_PROPERTIES[R_COLUMN])==0){
				modify(element, property, !isCapOn(rAccess, (String)element));
			}else if(property.compareTo(COLUMN_PROPERTIES[W_COLUMN])==0){
				modify(element, property, !isCapOn(wAccess, (String)element));
			}
			return false;
		}

		public Object getValue(Object element, String property) {
			//do nothing
			return null;
		}

		public void modify(Object element, String property, Object value) {
			String capa = (String)element;
			Boolean capaOn = (Boolean)value;
			
			Access access=null;
			if(property.compareTo(READ_ACCESS)==0)
				access = getCreateRAccess();
			else if(property.compareTo(WRITE_ACCESS)==0)
				access = getCreateWAccess();
			
			String caps = access.getCapabilities();
			caps=caps==null?"":caps.trim();
			if(capaOn){//add capa
				if(caps.length()==0)caps=caps+capa;
				else caps=caps+","+capa;
			}else{//remove capa
				int index = caps.indexOf(capa);
				int index2 = caps.indexOf(capa+",");
				int index3 = caps.indexOf(","+capa);
				if(index2!=-1)caps=caps.substring(0, index2)+caps.substring(index2+1+capa.length(), caps.length());
				else if(index3!=-1)caps=caps.substring(0, index3)+caps.substring(index3+1+capa.length(), caps.length());
				else if(index!=-1)caps=caps.substring(0, index)+caps.substring(index+capa.length(), caps.length());
			}
			updateStringAttribure(access, ACCESS_CAPABILITIES, caps);
			
			tableViewer.refresh();
		}
		
		public CapProvider(){
			CHECKED_IMAGE = ExtendedImageRegistry.INSTANCE.getImageDescriptor(getResourceLocator().getImage("checked")).createImage();
			UNCHECKED_IMAGE = ExtendedImageRegistry.INSTANCE.getImageDescriptor(getResourceLocator().getImage("unchecked")).createImage();
		}
		
		public Object[] getElements(Object inputElement) {
			return CAPS;
		}

		public void dispose() {
			
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			rAccess=null;
			wAccess=null;
			parent=newInput;
			if(newInput instanceof IAccessable){
				rAccess = ((IAccessable)newInput).getReadAccess();
				wAccess = ((IAccessable)newInput).getWriteAccess();
			}
			rSID.setText(getSidText(rAccess));
			wSID.setText(getSidText(wAccess));
		}
		
		
		private String getSidText(Access access)
		{
			if (access!=null && access.getSid()!= null)
			{
				String sid = access.getSid();
				if (sid.startsWith("0x") || sid.startsWith("0X"))
				{
					return sid.substring(2).toUpperCase();
				}
				else
					return sid.toUpperCase();
			}
			else 
				return "";
		}
		
		public Image getColumnImage(Object element, int columnIndex) {
			
			String capability = (String)element;
			if(capability!=null)
				switch(columnIndex){
				case CAP_COLUMN:
					return null;
				case R_COLUMN: 
					if(isCapOn(rAccess, capability))
						return CHECKED_IMAGE;
					else
						return UNCHECKED_IMAGE;
				case W_COLUMN: 
					if(isCapOn(wAccess, capability))
						return CHECKED_IMAGE;
					else
						return UNCHECKED_IMAGE;
				}
			return null;
		}

		public String getColumnText(Object element, int columnIndex) {
			String cap = (String)element;
			switch(columnIndex){
			case CAP_COLUMN: return cap;
			}
			return null;
		}

		public void addListener(ILabelProviderListener listener) {
			
		}

		public boolean isLabelProperty(Object element, String property) {
			return false;
		}

		public void removeListener(ILabelProviderListener listener) {
			
		}
		
		private boolean isCapOn(Access access,String cap){
			if(access==null)return false;
			String caps = access.getCapabilities();
			if(caps!=null&&caps.indexOf(cap)!=-1)return true;
			else return false;
		}
		
		
		public void setRSID(Text rsid) {
			rSID = rsid;
			rSID.addFocusListener(focusAdapter);
			rSID.addVerifyListener(VerifyIDAdapter.INSTANCE_WITHOUT_X);
		}

		public void setWSID(Text wsid) {
			wSID = wsid;
			wSID.addFocusListener(focusAdapter);
			wSID.addVerifyListener(VerifyIDAdapter.INSTANCE_WITHOUT_X);
		}
		
		private Access getCreateRAccess(){
			if(rAccess==null){
				rAccess=addAccess(parent);
				updateStringAttribure(rAccess, ACCESS_TYPE, READ_ACCESS);
			}
			return rAccess;
		}
		private Access getCreateWAccess(){
			if(wAccess==null){
				wAccess=addAccess(parent);
				updateStringAttribure(wAccess, ACCESS_TYPE, WRITE_ACCESS);
			}
			return wAccess;
		}
	}
	public ResourceLocator getResourceLocator() {
		return CenRepPlugin.INSTANCE;
	}

	public TableViewer getTableViewer() {
		return tableViewer;
	}
	
	private void updateStringAttribure(Access access, int attribute, String value){
		Command command = null;
		EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(access);
		switch(attribute){
		case ACCESS_SID:
			command = SetCommand.create(domain, access,
					CenrepPackage.eINSTANCE.getAccess_Sid(),value);
			break;
		case ACCESS_TYPE:
			command = SetCommand.create(domain, access,
					CenrepPackage.eINSTANCE.getAccess_Type(),cenrep.ACCESS_TYPE.get(value));
			break;
		
		case ACCESS_CAPABILITIES:
			command = SetCommand.create(domain, access,
					CenrepPackage.eINSTANCE.getAccess_Capabilities(),value);
			break;
		}
		if(command!=null)
			domain.getCommandStack().execute(command);
	}
	
	public static Access addAccess(Object parent){
		Access access = CenrepFactory.eINSTANCE.createAccess();
		EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(parent);
		
		Command command = null;
		if(parent instanceof IAccessable)
			command = AddCommand.create(domain, parent, CenrepPackage.eINSTANCE.getIAccessable_Access(), access);
		if(command!=null)domain.getCommandStack().execute(command);
		return access;
	}
	
	public void selectAccess(Access access) {
		for (int i = 0; i < tableViewer.getTable().getItemCount(); i++) {
			TableItem item = tableViewer.getTable().getItem(i);
			if (access.getCapabilities().equals(item.getData())) {
				tableViewer.setInput(access.eContainer()); 
				tableViewer.getTable().setSelection(i);
				break;
			}
		}
	}

	public boolean canShow(Object object) {
		return object instanceof IAccessable ||
			   object instanceof Access ||
			   object instanceof CenrepResourceImpl; //when this is selected, view is cleaned
	}

	public void show(Object object, boolean tryActivate) {
		if (object instanceof Access) {
			selectAccess((Access)object); 
			if (tryActivate) {
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().activate(this); 
			} else {
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().bringToTop(this); 
			}
		} 
		else if (object instanceof IAccessable) {
			tableViewer.setInput(object);
		} 
		else if (object instanceof CenrepResourceImpl) {
			tableViewer.setInput(null);
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
			tableViewer.setInput(null);
		tableViewer.refresh();
	}
}
