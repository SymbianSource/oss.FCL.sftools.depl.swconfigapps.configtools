/*
 * Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies). 
 * All rights reserved.
 * This component and the accompanying materials are made available
 * under the terms of "Eclipse Public License v1.0"
 * which accompanies this distribution, and is available
 * at the URL "http://www.eclipse.org/legal/epl-v10.html".
 * 
 * Initial Contributors:
 * Nokia Corporation - Initial contribution
 * 
 * Contributors:
 * 
 * Description: This file is part of com.nokia.tools.variant.viewer component.
 */

package com.nokia.tools.variant.viewer.widgets.summary;

import java.util.Map;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import com.nokia.tools.variant.viewer.widgets.BaseConfMLWidget;
import com.nokia.tools.variant.viewer.widgets.WidgetOption;
import com.nokia.tools.variant.viewer.widgets.WidgetOptions;

/**
 * It represents UI component which displayes a table. This component can be inserted to the editor viewer.
 * The input is set in the method setOptions. The table has only two columns.
 */
public class TableBox extends BaseConfMLWidget {
	private Composite composite;
	private GenericTableViewer table;
	private final int COLUMN_1_WIDTH = 70;
	private final int COLUMN_2_WIDTH = 180;

	public TableBox(Composite parent, int style, String widgetLabel, Image image) {
		super(parent, style, widgetLabel, image);
	}

	@Override
	protected void buildMainControl() {
		composite = new Composite(group, SWT.NONE);
		composite.setBackground(group.getBackground());
		composite.setLayout(new GridLayout(1, false));

		table = new GenericTableViewer(composite);

		table.addColumn(new Column(Messages.SUMMARY_TABLE_COLUMN_1_NAME, COLUMN_1_WIDTH));
		table.addColumn(new Column(Messages.SUMMARY_TABLE_COLUMN_2_NAME, COLUMN_2_WIDTH));

		
		GridData gridData = new GridData();
		gridData.heightHint = 80;
		table.getTv().getTable().setLayoutData(gridData);
	}

	@Override
	public void clearErrorMessage() {

	}

	@Override
	public String getValue() {
	
		return null;
	}

	@Override
	public void setValue(String value) {
	

	}

	public void buildWidget(Composite composite, String label,
			Map<String, String> options) {
	

	}

	@Override
	protected GridData layoutDataForLabel(int width) {
		GridData gridData = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING
				| GridData.VERTICAL_ALIGN_BEGINNING);
		gridData.widthHint = width;
		return gridData;
	}

	@Override
	public void setOptions(WidgetOptions options) {
		
		table.getTv().setLabelProvider(new ITableLabelProvider() {

			public Image getColumnImage(Object element, int columnIndex) {
				
				return null;
			}

			public String getColumnText(Object element, int columnIndex) {
				if (element instanceof WidgetOption) {
					WidgetOption option = (WidgetOption) element;
					switch (columnIndex) {
					case 0:
						return option.getKey();
					case 1:
						return option.getValue();
					}
				}
				return "";
			}

			public void addListener(ILabelProviderListener listener) {
				

			}

			public void dispose() {
			

			}

			public boolean isLabelProperty(Object element, String property) {
				
				return false;
			}

			public void removeListener(ILabelProviderListener listener) {
				

			}

		});
		table.getTv().setContentProvider(new IStructuredContentProvider(){

			public void dispose() {
			
				
			}

			public void inputChanged(Viewer viewer, Object oldInput,
					Object newInput) {
			
				
			}

			public Object[] getElements(Object inputElement) {
				if(inputElement instanceof WidgetOptions){
					WidgetOptions options = (WidgetOptions)inputElement;
					return options.getOptions().toArray();
				}
				return null;
			}
			
		});
		table.getTv().setInput(options);
		
	}
	@Override
	protected void drawDeselectUI() {
		super.drawDeselectUI();
		composite.setBackground(group.getBackground());

	}

	@Override
	protected void drawSelectUI() {
		super.drawSelectUI();
		composite.setBackground(group.getBackground());
	}
}
