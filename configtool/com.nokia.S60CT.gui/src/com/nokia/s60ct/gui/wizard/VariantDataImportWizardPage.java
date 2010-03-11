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
package com.nokia.s60ct.gui.wizard;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import variantdata.VariantData;

import com.nokia.s60ct.gui.S60CtEditorPlugin;
import com.nokia.s60ct.gui.actions.ImportVatiantDataAction;
import com.nokia.s60ct.gui.actions.OpenConfiguration;
import command.SetMultipleCurrentValue;

import configurationemf.RootConf;
import configurationemf.Setting;
import configurationemf.util.IVariantDataManager;
import configurationemf.util.VariantDataManager;

public class VariantDataImportWizardPage extends WizardPage{
		
		private IVariantDataManager variantDataManager=null;
		private RootConf rootConf = null;
		private String filePath=null;
		
		//Map to be imported
		private Map<String, String> tobeImportedMap = new HashMap<String, String>();
		private List<String> listOfRefs = new ArrayList<String>();
		
		protected Table table;
		protected Text fileField;
		
		final int REF_COLUMN =0;
		private String actionId = "";
		private Button importButton;
		
		public VariantDataImportWizardPage(String pageName, String title,
				ImageDescriptor titleImage) {
			super(pageName, title, titleImage);
		}
		public void init(RootConf rootConf, String actionId ){
			this.variantDataManager = new VariantDataManager();
			this.rootConf=rootConf;
			this.actionId = actionId;
		}
		
		public VariantDataImportWizardPage(String pageName) {
			super(pageName);
		}

		public void createControl(Composite parent) {
			Composite composite = new Composite(parent, SWT.NONE);
			{
				GridLayout layout = new GridLayout();
				layout.numColumns = 1;
				layout.verticalSpacing = 12;
				composite.setLayout(layout);

				GridData data = new GridData();
				data.verticalAlignment = GridData.FILL;
				data.horizontalAlignment = GridData.FILL;
				data.grabExcessVerticalSpace = true;
				composite.setLayoutData(data);
			}
						
			Label resourceURILabel = new Label(composite, SWT.LEFT);
			{
				resourceURILabel.setText(getString("_UI_VariantData")+"*");
				GridData data = new GridData();
				data.horizontalAlignment = SWT.FILL;
				resourceURILabel.setLayoutData(data);
			}

			Composite fileComposite = new Composite(composite, SWT.NONE);
			{
				GridData data = new GridData();
				data.horizontalAlignment = SWT.FILL;
				fileComposite.setLayoutData(data);

				GridLayout layout = new GridLayout();
				data.horizontalAlignment = SWT.FILL;
				data.grabExcessHorizontalSpace = true;
				layout.marginHeight = 0;
				layout.marginWidth = 0;
				layout.numColumns = 2;
				fileComposite.setLayout(layout);
			}

			fileField = new Text(fileComposite, SWT.BORDER);
			{
				GridData data = new GridData();
				data.horizontalAlignment = SWT.FILL;
				data.grabExcessHorizontalSpace = true;
				data.horizontalSpan = 1;
				fileField.setLayoutData(data);
				fileField.setData("name", "fileURI");//for testing
				fileField.addModifyListener(new ModifyListener(){
					@Override
					public void modifyText(ModifyEvent e) {
						filePath=fileField.getText();
						setPageComplete(validatePage());
					}
				});
			}

			Button browseButton = new Button(fileComposite,SWT.PUSH);
			browseButton.setText("Browse");
			browseButton.addSelectionListener(new SelectionAdapter() {
				@Override
				 public void widgetSelected(SelectionEvent event) {
					 String fileExtension = getString("_UI_VariantdataFilenameExtension");
					 String filePath = OpenConfiguration.openFilePathDialog(getShell(), 
							 new String[]{"*."+fileExtension}, SWT.OPEN);
					if (filePath != null) {
						 fileField.setText(filePath);
					 }
				 }
			 });
			
			
			Composite tableComposite = new Composite(composite,SWT.NONE);
			TableColumnLayout tableLayout = new TableColumnLayout();
			{
				GridData data = new GridData();
				data.horizontalAlignment = SWT.FILL;
				data.verticalAlignment = SWT.FILL;
				data.grabExcessHorizontalSpace = true;
				data.grabExcessVerticalSpace = true;
				tableComposite.setLayoutData(data);
				tableComposite.setLayout(tableLayout);
			}
			Table table = createTable(tableComposite,tableLayout);
			
			
			Composite buttonsComposite = new Composite(composite,SWT.NONE);
			{
				GridData data = new GridData();
				data.horizontalAlignment = SWT.RIGHT;
				data.verticalAlignment = SWT.TOP;
				buttonsComposite.setLayoutData(data);
				GridLayout layout = new GridLayout();
				layout.numColumns = 2;
				buttonsComposite.setLayout(layout);
			}
			
			final Button loadButton = new Button(buttonsComposite,SWT.PUSH);
			importButton = new Button(buttonsComposite,SWT.PUSH);
			
			loadButton.setText("Load");
			loadButton.addSelectionListener
			(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent event) {
					try{
						VariantData vd = openVariantData(filePath);
						readVariantData(vd);
						importButton.setEnabled(true);
					}catch(FileNotFoundException e){
						setErrorMessage(e.getMessage());
					}catch(Exception e){
						setErrorMessage(e.getMessage());
					}
				}
			});
			

			importButton.setText("Import");
			importButton.setEnabled(false);
			importButton.addSelectionListener
			(new SelectionAdapter() {
				 public void widgetSelected(SelectionEvent event) {
					importVariantData();
				 }
			 });
			setControl(composite);
		}
		
		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		protected boolean validatePage() {
			URI fileURI = getFileURI();
			if (fileURI == null || fileURI.isEmpty()) {
				return false;
			}

			String requiredExt = getString("_UI_VariantdataFilenameExtension");
			String enteredExt = fileURI.fileExtension();
			if (enteredExt == null || !enteredExt.equals(requiredExt)) {
				setErrorMessage(S60CtEditorPlugin.INSTANCE.getString("_WARN_FilenameExtension", new Object [] { requiredExt }));
				return false;
			}

			setErrorMessage(null);
			return true;
		}

		private String getString(String var){
			return S60CtEditorPlugin.INSTANCE.getString(var);
		}
		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		@Override
		public void setVisible(boolean visible) {
			super.setVisible(visible);
			if (visible) {
				fileField.setFocus();
			}
		}

				
		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public URI getFileURI() {
			try {
				String uri = fileField.getText();
				return URI.createFileURI(uri);
			}
			catch (Exception exception) {
				// Ignore
			}
			return null;
		}

		
		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public void selectFileField() {
				fileField.selectAll();
				fileField.setFocus();
		}		

		private Table createTable(Composite composite,TableColumnLayout layout){
			table = new Table(composite,SWT.BORDER|SWT.FULL_SELECTION); 
			table.setLinesVisible(true);
			table.setHeaderVisible(true);
			
			final TableEditor editor = new TableEditor(table);
		    editor.horizontalAlignment = SWT.LEFT;
		    editor.grabHorizontal = true;
		    
		    table.addListener(SWT.MouseDown, new Listener() {
		    	public void handleEvent(Event event) {
		    		Rectangle clientArea = table.getClientArea();
		    		Point pt = new Point(event.x, event.y);
		    		int index = table.getTopIndex();
		    		while (index < table.getItemCount()) {
		    			boolean visible = false;
		    			final TableItem item = table.getItem(index);
		    			Rectangle rect = item.getBounds(0);
	    				if (rect.contains(pt)) {
	    					final int column = 0;
	    					final int row = index;
	    					final Text text = new Text(table, SWT.NONE);
	    					Listener textListener = new Listener() {
	    						public void handleEvent(final Event e) {
	    							switch (e.type) {
	    							case SWT.FocusOut:
	    								item.setText(column, text.getText());
	    								updateMap(row, text.getText());
	    		    					text.dispose();
	    								break;
	    							case SWT.Traverse:
	    								switch (e.detail) {
	    								
	    								case SWT.TRAVERSE_RETURN:
	    									item.setText(column, text.getText());
	    									//FALL THROUGH
	    								case SWT.TRAVERSE_ESCAPE:
	    									updateMap(row, text.getText());
	    									text.dispose();
	    									e.doit = false;
	    								
	    								}
	    								break;
	    							
	    							}
	    						}
	    					};
	    					
	    					text.addListener(SWT.FocusOut, textListener);
	    					text.addListener(SWT.Traverse, textListener);
	    					editor.setEditor(text, item, 0);
	    					text.setText(item.getText(0));
	    					text.selectAll();
	    					text.setFocus();
	    					return;
	    				}
	    				if (!visible && rect.intersects(clientArea)) {
	    					visible = true;
	    				}
		    			
		    			if (!visible)
		    				return;
		    			index++;
		    		}
		    	}
		    });
			TableColumn refColumn = new TableColumn(table,SWT.None);
			refColumn.setText("Absolute Ref");
			layout.setColumnData(refColumn, new ColumnWeightData(10,false));
//			setTableItems();
			return table;
		}
		
		public void setTableItems(){
			Set<String> refs = tobeImportedMap.keySet();
			listOfRefs.clear();
			table.clearAll();
			final int itemNumber = tobeImportedMap.size();
			table.setItemCount(itemNumber);
			int i=0;
			for(Iterator<String> iterator=refs.iterator();iterator.hasNext();){
				TableItem item =table.getItem(i);
				String name = iterator.next();
				item.setText(REF_COLUMN, name);
				listOfRefs.add(name);
				i++;
			}
			importButton.setEnabled(table.getItemCount()>0);
			
		}
		
		private VariantData openVariantData(String filePath)throws Exception{
			try{
			ResourceSet rset = new ResourceSetImpl();
			Resource resource = rset.getResource(URI.createFileURI(filePath), true);
			VariantData vd = null;
			resource.load(null);
			if (!resource.getContents().isEmpty())
				 vd = (VariantData)resource.getContents().get(0);
				 EcoreUtil.resolveAll(rset);
			return vd;
			}catch(WrappedException e){
				throw (Exception)e.getCause();
			}catch(Exception e){
				throw e;
			}
			
		}
		
		private void readVariantData(VariantData vd) {
			if(actionId.compareTo(ImportVatiantDataAction.CHAIN_IMPORT_ID)==0){
				tobeImportedMap =  variantDataManager.getChainVDMap(vd);
			}else if(actionId.compareTo(ImportVatiantDataAction.SINGLE_IMPORT_ID)==0){
				tobeImportedMap = variantDataManager.getSingleVDMap(vd);
			}
			setTableItems();
			table.redraw();
		}
		private void importVariantData(){
//			Set<String> problems=null;
			Map<Setting, Object> map = new HashMap<Setting, Object>();
			/*problems = */
			variantDataManager.importValues(rootConf, tobeImportedMap ,map);
			
			if(!map.isEmpty()){
				Command command = new SetMultipleCurrentValue(map);
				EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(rootConf);
				domain.getCommandStack().execute(command);
			}

			setTableItems();
			table.redraw();
		}
		

	void updateMap(int index, final String updatedRef){
		String upref=listOfRefs.get(index);
		String value = tobeImportedMap.get(upref);
		tobeImportedMap.put(updatedRef, value);
		if(updatedRef.compareTo(upref)!=0)
			tobeImportedMap.remove(upref);
		setTableItems();
	}
	
}
