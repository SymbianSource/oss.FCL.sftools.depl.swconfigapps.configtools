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
package com.nokia.tools.variant.confml.ui.wizards;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.PropertyResourceBundle;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;
import org.osgi.framework.Bundle;

import com.nokia.tools.variant.confml.ui.ConfmlUI;

public class NewVariantPageTwo extends WizardPage {
	private ArrayList<Item> items = null;
	private PropertyResourceBundle properties;
	private List list;
	private Text description;
	private int selection;
	private final String PROPERTIES_FILE = "templates\\cpf.properties";
	protected NewVariantPageTwo(String pageName) {
		super(pageName);
		setPageComplete(false);
		setTitle("Select a Template"); 
		setDescription("Create a Configuration Project based on Template."); 
		items = new ArrayList<Item>();
		try {
			System.out.println(getBundle().getEntry("/"));
			
			File cpfProperties = new File(PROPERTIES_FILE);
			FileInputStream fs = new FileInputStream(cpfProperties);
			properties = new PropertyResourceBundle(fs);
		} catch (IOException e) {
			properties = null;
		}		
		getItems();
		setPageComplete(true);
		this.setSelection(-1);
	}

	private void getItems() {
		if(properties==null) return;
		int count = Integer.parseInt(properties.getString("numberOfTemplates"));
		for (int i = 0; i < count; i++) {
			Item item = new Item();
			item.title = properties.getString("template_"+i+"_title");
			item.location = properties.getString("template_"+i+"_location");
			item.description = properties.getString("template_"+i+"_description");
			items.add(item);
		}
	}

	private Bundle getBundle() {
		return ConfmlUI.getInstance().getBundle();
	}

	public void createControl(Composite parent) {
		Composite top = new Composite(parent,SWT.NONE);
		GridLayout layout = new GridLayout(2,false);
		top.setLayout(layout);
		GridData layoutData = new GridData(GridData.FILL_BOTH);
		top.setLayoutData(layoutData);
		
		Label label = new Label(top,SWT.NONE);
		label.setText("Select template from the below list.");
		layoutData = new GridData(GridData.FILL_HORIZONTAL);
		layoutData.horizontalSpan = 2;
		label.setLayoutData(layoutData);
		
		
		list = new List(top,SWT.BORDER|SWT.SINGLE);
		layoutData = new GridData(GridData.FILL_BOTH);
		layoutData.widthHint = 200;
		list.setLayoutData(layoutData);
		list.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				int index = list.getSelectionIndex();
				if(index!=-1) {
					updateSelection(index);
				}
				setSelection(index);
			}
		});
		
		description = new Text(top,SWT.BORDER|SWT.MULTI);
		layoutData = new GridData(GridData.FILL_BOTH);
		layoutData.widthHint = 200;
		description.setLayoutData(layoutData);
		description.setEditable(false);
		
		populate(list);
//		updateSelection(0);
		setControl(top);
	}

	private void updateSelection(int index) {
		if(!items.isEmpty()) {
			description.setText(items.get(index).description);
		}
	}

	private void populate(List list) {
		for (Item item : items) {
			list.add(item.title);
		}
	}

	public void setSelection(int selection) {
		this.selection = selection;
	}

	/**
	 * The location of the selected cpf file
	 * @return
	 */
	public String getTemplateLocation() {
		if(selection==-1) return null;
		return items.get(selection).location;
	}

	private class Item {
		public String title;
		public String location;
		public String description;
		public Item(){}
	}
}
