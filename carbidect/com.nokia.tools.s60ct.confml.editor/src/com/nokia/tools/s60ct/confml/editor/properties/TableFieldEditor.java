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
package com.nokia.tools.s60ct.confml.editor.properties;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.nokia.tools.vct.common.ui.utils.PixelConverter;


public class TableFieldEditor extends LabelFieldEditor {

	private String textValue;
	private int style;
	private Table table;
	private PixelConverter pixelConverter;
	
	public TableFieldEditor() {
		this(SWT.NONE);
	}
	
	public TableFieldEditor(int style) {
		this.style = style;
		
	}
	
	public void setTextValue(List<String[]> valuesList, Composite parent) {
		
		int maxValueWidth = 30;
		int maxFileWidth = 30;
		
		for (int i=0; i<valuesList.size(); i++) {
			String[] values = valuesList.get(i);
			TableItem item = new TableItem (table, SWT.FILL);
			if (values[0]== null)
				values[0] = "";

			item.setText (0, values[0]);

			if (values[1]== null)
				values[1] = "";
		
			item.setText (1, values[1]);
			
			int width = pixelConverter.convertWidthInCharsToPixels(values[0].length());
			if (width > maxValueWidth)
				maxValueWidth = width;
			width = pixelConverter.convertWidthInCharsToPixels(values[1].length());
			if (width > maxFileWidth)
				maxFileWidth = width;
		}
		maxValueWidth = maxValueWidth+20;
		maxFileWidth = maxFileWidth + 30;
		table.getColumn(0).setWidth(maxValueWidth);
		
		//int availableFileWidth = parent.getBounds().width-maxValueWidth-40;
//		if (availableFileWidth > maxFileWidth)
//			maxFileWidth = availableFileWidth;
		
		table.getColumn(1).setWidth(maxFileWidth);
		table.pack();
	}
	
//	public String getTableValue() {
//		return textValue;
//	}
	
	@Override
	public void fillIntoGrid(Composite parent, int columns, FormToolkit toolkit, int rows) {
		super.fillIntoGrid(parent, 1, toolkit);
		
		table = createTableControl(parent, toolkit);
		GridData gridData = createLayoutDataForText(columns -1, rows);
		pixelConverter = new PixelConverter(parent);
		if ((style & SWT.MULTI) != 0) {
			gridData.minimumHeight = pixelConverter.convertHeightInCharsToPixels(rows)+3;
			gridData.heightHint = pixelConverter.convertHeightInCharsToPixels(rows)+3;
		}
		table.setLayoutData(gridData);
//		table.addModifyListener(new ModifyListener() {
//			public void modifyText(ModifyEvent e) {
//				textValue = table.getText();
//				setChanged();
//				notifyObservers();
//			}
//		});
	}
	
	public Table getTextControl() {
		return table;
	}
	
	protected Table createTableControl(Composite parent, FormToolkit toolkit) {
	
		Table control = toolkit.createTable(parent, style);
		//control.setEnabled(editable);
		control.setHeaderVisible(true);
		control.setLinesVisible(true);
		String[] titles = {"Value", "File"};
		for (int i=0; i<titles.length; i++) {
			TableColumn column = new TableColumn (control, SWT.NONE);
			column.setText (titles [i]);
		}
		
		for (int i=0; i<titles.length; i++) {
			control.getColumn (i).pack ();
		}	

		
		return control;
	}
	
	protected GridData createLayoutDataForText(int columns, int rows) {
		GridData gridData;
		if ((style & SWT.MULTI) != 0) {
			gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
		} else {
			gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
		}
		gridData.horizontalSpan = columns;
		gridData.verticalSpan = rows;
		return gridData;
	}
	
	@Override
	protected GridData createLayoutDataForLabel(int columns) {
		GridData data = super.createLayoutDataForLabel(columns);
		data.verticalAlignment = SWT.FILL;
		return data;
	}
	
	@Override
	protected int getNumberOfControls() {
		return 2;
	}
	
	@Override
	protected Control[] getControls() {
		return new Control[] {getTextControl(), getLabelControl()};
	}
	
	private boolean editable = true;
	
	public void setEditable(boolean flag) {
		this.editable = flag;
		if (canUseControl(table)) {
			//table.setEnabled(flag);
		}
	}
}
