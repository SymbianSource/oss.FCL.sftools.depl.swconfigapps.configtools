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

import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

/**
 * This class represents {@link TableViewer}. After creation of
 * {@link GenericTableViewer}, you could use addColumn(name, width) method and
 * add so may columns as you want. Next steps are to set content provider, label
 * provider and input. At the end you have to call populateTableViewer.
 * 
 * @see Column
 */
public class GenericTableViewer {

	private TableViewer tv;
	private TableColumn genericColumn;

	private IBaseLabelProvider labelProvider;
	private IContentProvider contentProvider;
	private Object input;
	private Table table;

	public GenericTableViewer(Composite parent) {
		setTv(new TableViewer(parent, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL
				| SWT.BORDER | SWT.FULL_SELECTION));
		table = getTv().getTable();

		table.setLayoutData(new GridData(GridData.FILL_BOTH));

		table.setHeaderVisible(true);
		table.setLinesVisible(true);
	}

	public int getRowCount() {
		return table.getItemCount();
	}

	public void populateTableViewer() {
		if (newValue(getTv().getContentProvider(), contentProvider)) {
			getTv().setContentProvider(contentProvider);
		}
		if (newValue(getTv().getLabelProvider(), labelProvider)) {
			getTv().setLabelProvider(labelProvider);
		}
		if (newValue(getTv().getInput(), input)) {
			getTv().setInput(input);
		}
	}

	private boolean newValue(Object old, Object nev) {
		if (old == null) {
			return true;
		} else {
			if (!old.equals(nev)) {
				return true;
			}
		}
		return false;
	}

	public void addColumn(Column column) {
		genericColumn = new TableColumn(table, SWT.LEFT);
		genericColumn.setText(column.getName());
		genericColumn.setWidth(column.getWidth());
		genericColumn.addListener(SWT.Selection, new Listener() {

			public void handleEvent(Event event) {
				TableColumn sortColumn = table.getSortColumn();
				TableColumn currentColumn = (TableColumn) event.widget;

				int dir = getTv().getTable().getSortDirection();

				if (sortColumn == currentColumn) {
					dir = dir == SWT.UP ? SWT.DOWN : SWT.UP;
				} else {
					getTv().getTable().setSortColumn(currentColumn);
					dir = SWT.UP;
				}

				table.setSortDirection(dir);
			
			}

		});
	}

	public void setContentProvider(IContentProvider contentProvider) {
		this.contentProvider = contentProvider;
	}

	public void setLabelProvider(IBaseLabelProvider labelProvider) {
		this.labelProvider = labelProvider;
	}

	public void setInput(Object input) {
		this.input = input;
	}

	private void setTv(TableViewer tv) {
		this.tv = tv;
	}

	public TableViewer getTv() {
		return tv;
	}
}
