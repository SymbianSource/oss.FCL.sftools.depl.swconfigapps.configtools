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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import com.nokia.s60ct.gui.S60CtEditorPlugin;
import com.nokia.s60ct.gui.actions.OpenConfiguration;

import configurationemf.RootConf;

public class AddBasedOnWizardPage extends WizardPage{
	
	private static final int NO_ROW = -1;

	Map<String, RootConf> uri2moder = new HashMap<String, RootConf>();
	
	List<RootConf> basedOnList = new ArrayList<RootConf>();
	RootConf rootConf = null;
	Table table;
	
	final int PRIORITY_COLUMN =0;
	final int CONF_COLUMN =1;
	
	public AddBasedOnWizardPage(String pageName, String title,
			ImageDescriptor titleImage) {
		super(pageName, title, titleImage);
	}
	public void init(RootConf rootConf){
		this.rootConf=rootConf;
		basedOnList.addAll(rootConf.getInclude());
		for(RootConf basedOn : rootConf.getInclude())
			uri2moder.put(basedOn.eResource().getURI().toFileString(),basedOn);
	}
	
	public AddBasedOnWizardPage(String pageName) {
		super(pageName);
	}

	public void createControl(Composite parent) {
		Composite composite = new Composite(parent,SWT.NONE);
		{
			GridLayout layout = new GridLayout();
			layout.numColumns = 2;
			composite.setLayout(layout);
			GridData data = new GridData();
			data.verticalAlignment = SWT.FILL;
			data.grabExcessVerticalSpace = true;
			data.grabExcessHorizontalSpace = true;
			data.horizontalAlignment = SWT.FILL;
			composite.setLayoutData(data);
		}
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
		createTable(tableComposite,tableLayout);
		
		Composite buttonsComposite = new Composite(composite,SWT.NONE);
		{
			GridData data = new GridData();
			data.horizontalAlignment = SWT.RIGHT;
			data.verticalAlignment = SWT.TOP;
			buttonsComposite.setLayoutData(data);
			GridLayout layout = new GridLayout();
			layout.numColumns = 1;
			buttonsComposite.setLayout(layout);
		}
		Button browseButton = new Button(buttonsComposite,SWT.PUSH);
		browseButton.setText("&Browse ");
		browseButton.addSelectionListener
		(new SelectionAdapter() {
			 @Override
			 public void widgetSelected(SelectionEvent event) {
				 String fileExtension = S60CtEditorPlugin.INSTANCE.getString("_UI_ConfigurationemfEditorFilenameExtension");
				 String filePath = OpenConfiguration.openFilePathDialog(getShell(), new String[]{"*.confml"}, SWT.OPEN);
				 if (filePath != null) {
					 if (!filePath.endsWith("." + fileExtension)) {
						 filePath = filePath + "." + fileExtension;
					 }
					 openBasedOnConf(filePath);
				 }
			 }
		 });
		
		Button removeButton = new Button(buttonsComposite,SWT.PUSH);
		removeButton.setText("&Remove");
		removeButton.addSelectionListener
		(new SelectionAdapter() {
			 public void widgetSelected(SelectionEvent event) {
				TableItem[] selectedItems = table.getSelection();
				if(selectedItems!=null){
					for(TableItem item : selectedItems){
						basedOnList.remove(item.getData());
					}
					setTableItems(NO_ROW);
					table.redraw();
				}
			 }
		 });
		
		
		Button upButton = new Button(buttonsComposite,SWT.PUSH);
		upButton.setText("    &Up     ");
		upButton.addSelectionListener
		(new SelectionAdapter() {
			 public void widgetSelected(SelectionEvent event) {
				TableItem[] selectedItems = table.getSelection();
				if(selectedItems!=null){
					int index = NO_ROW;
					for(TableItem item : selectedItems){
						RootConf selectedConf = (RootConf)item.getData();
						index = basedOnList.indexOf(selectedConf);
						if(index>0){
							RootConf conf = basedOnList.get(index-1);
							basedOnList.set(index-1, selectedConf);
							basedOnList.set(index, conf);
						}
						
					}
					setTableItems(index-1);
					table.redraw();
				}
			 }
		 });
		
		
		Button downButton = new Button(buttonsComposite,SWT.PUSH);
		downButton.setText("  &Down  ");
		downButton.addSelectionListener
		(new SelectionAdapter() {
			 public void widgetSelected(SelectionEvent event) {
				TableItem[] selectedItems = table.getSelection();
				if(selectedItems!=null){
					int index = NO_ROW;
					for(TableItem item : selectedItems){
						RootConf selectedConf = (RootConf)item.getData();
						index = basedOnList.indexOf(selectedConf);
						if(index!=basedOnList.size()-1){
							RootConf conf = basedOnList.get(index+1);
							basedOnList.set(index+1, selectedConf);
							basedOnList.set(index, conf);
						}
					}
					setTableItems(index+1);
					table.redraw();
				}
			 }
		 });
		
		setControl(composite);
	}
	
	private void createTable(Composite composite,TableColumnLayout layout){
		table = new Table(composite,SWT.BORDER|SWT.FULL_SELECTION); 
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		
		
		TableColumn priotiryColumn = new TableColumn(table,SWT.NONE);
		priotiryColumn.setText("Priority");
		layout.setColumnData(priotiryColumn, new ColumnWeightData(1,false));
		TableColumn confColumn = new TableColumn(table,SWT.NONE);
		confColumn.setText("Configuration Name");
		layout.setColumnData(confColumn, new ColumnWeightData(10,false));
		setTableItems(NO_ROW);
	}
	
	private void setTableItems(int index){
		final int itemNumber = basedOnList.size();
		table.setItemCount(itemNumber);
		for(int i=0;i<itemNumber;i++){
			TableItem item =table.getItem(i);
			item.setText(PRIORITY_COLUMN, String.valueOf(i+1));
			String name = basedOnList.get(i).eResource().getURI().lastSegment();
			item.setText(CONF_COLUMN, name);
			item.setData(basedOnList.get(i));
		}
		if(index!=NO_ROW)
			table.setSelection(index);
	}
	
	private void openBasedOnConf(String filePath){
		URI uri = URI.createFileURI(filePath);
		RootConf basedOn=uri2moder.get(uri.toFileString());
		if(basedOn==null){
			Resource resource = AdapterFactoryEditingDomain.getEditingDomainFor(rootConf).getResourceSet().getResource(uri,true);
			try{
				resource.load(null);
			}catch(Exception e){
				EcorePlugin.getPlugin().log(e);
				return;
			}
			if (!resource.getContents().isEmpty())
			{
				basedOn = (RootConf)resource.getContents().get(0);
				basedOn.setRoot(rootConf);
			}
			//uri2moder.put(uri.toFileString(),basedOn);
		}
		
		if (!uri2moder.containsValue(basedOn))
			basedOnList.add(basedOn);
		setTableItems(NO_ROW);
		table.redraw();
	}
	
	public List<RootConf> getConfToRemove(){
		if (uri2moder == null)
			return null;
		List<RootConf> result = new ArrayList<RootConf>();
		for(Map.Entry<String, RootConf> entry : uri2moder.entrySet()){
			if(!basedOnList.contains(entry.getValue()))
				result.add(entry.getValue());
		}
		return result;
	}
	
	public List<RootConf> getConfToAdd(){
		//return basedOnList;
		List<RootConf> result = new ArrayList<RootConf>();
		
		for (int i = 0 ; i < basedOnList.size() ; i++)
		{
			RootConf rc = basedOnList.get(i);
			if (!uri2moder.containsValue(rc))
				result.add(rc);
		}
		return result;
	}
	
	public boolean isChanged(){
		if(rootConf.getInclude().size()!= basedOnList.size())
			return true;
		for (int i=0; i<basedOnList.size();i++) {
			if(rootConf.getInclude().get(i).equals(basedOnList.get(i)))
				continue;
			else 
				return true;
		}
		return false;
	}
	
	public List<RootConf> getBasedOnList(){
		return basedOnList;
	}
}