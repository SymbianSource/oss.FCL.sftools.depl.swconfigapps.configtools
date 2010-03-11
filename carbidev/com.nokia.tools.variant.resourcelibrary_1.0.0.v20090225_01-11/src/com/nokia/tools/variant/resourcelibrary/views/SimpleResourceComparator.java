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
 * Description: This file is part of com.nokia.tools.variant.resourcelibrary component.
 */

package com.nokia.tools.variant.resourcelibrary.views;

import java.util.Map;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;

import com.nokia.tools.variant.resourcelibrary.model.File;
import com.nokia.tools.variant.resourcelibrary.model.FileSystemElement;
import com.nokia.tools.variant.resourcelibrary.resources.ResourceCategories;

class SimpleResourceComparator extends ViewerComparator implements
		SelectionListener {

	/** Sorting type: 0: Name, 1: Type, 2: Size */
	public static final int SORT_BY_NAME = 0;
	public static final int SORT_BY_TYPE = 1;
	public static final int SORT_BY_SIZE = 2;
	public static final int SORT_BY_NOTE = 3;
	private int sortType = SORT_BY_TYPE;
	private int sortDirection = SWT.NONE;

	private TreeViewer viewer;

	private static final Map<String, Integer> columnMapping = new java.util.HashMap<String, Integer>(
			4);
	static {
		columnMapping.put(ResourceLibraryPage.NAME_COLUMN_TEXT, SORT_BY_NAME);
		columnMapping.put(ResourceLibraryPage.TYPE_COLUMN_TEXT, SORT_BY_TYPE);
		columnMapping.put(ResourceLibraryPage.SIZE_COLUMN_TEXT, SORT_BY_SIZE);
		columnMapping.put(ResourceLibraryPage.NOTE_COLUMN_TEXT, SORT_BY_NOTE);
	}

	/**
	 * Construct ColumnSortingProvider, hook up to viewer. Expect that we
	 * already have tree columns set up.
	 * 
	 * @param viewer
	 */
	public SimpleResourceComparator(TreeViewer viewer) {
		this.viewer = viewer;
	}

	@Override
	public int compare(Viewer viewer, Object o1, Object o2) {

		FileSystemElement r1 = (FileSystemElement) o1;
		FileSystemElement r2 = (FileSystemElement) o2;

		int direction = sortDirection == SWT.DOWN ? 1 : -1;

		if (sortDirection == SWT.NONE) {
			sortType = SORT_BY_TYPE;
			direction = -1;
		}

		switch (sortType) {
		case SORT_BY_NAME:
			return direction * r2.getName().compareToIgnoreCase(r1.getName());
		case SORT_BY_TYPE:
			return direction * ResourceCategories.compare(r1, r2);
		case SORT_BY_SIZE:
			return compareBySize(r1, r2, direction);
		case SORT_BY_NOTE:
			String note1 = (r1.getNote() == null ? "" : r1.getNote()); 
			String note2 = (r2.getNote() == null ? "" : r2.getNote());
			return direction * note2.compareToIgnoreCase(note1);
		default:
			return 0;
		}
	}

	private int compareBySize(FileSystemElement r1, FileSystemElement r2,
			int direction) {
		long size1 = r1 instanceof File ? ((File) r1).getSize() : 0;
		long size2 = r2 instanceof File ? ((File) r2).getSize() : 0;
		if (size1 < size2) {
			return direction * 1;
		} else if (size1 == size2) {
			return direction * 0;
		} else {
			return direction * -1;
		}
	}

	@Override
	public boolean isSorterProperty(Object element, String property) {
		
		return super.isSorterProperty(element, property);
	}

	public void widgetSelected(SelectionEvent e) {
		// Check the column that provided the sorting
		TreeColumn col = (TreeColumn) e.getSource();

		// Fetch the tree and its column
		Tree tree = col.getParent();

		// If the column is already sort column, change sort
		// direction. Otherwise set the new sort column
		TreeColumn oldColumn = tree.getSortColumn();
		sortDirection = SWT.UP;
		if (col.equals(oldColumn)) {
			int oldDirection = tree.getSortDirection();
			if (oldDirection == SWT.DOWN) {
				sortDirection = SWT.NONE;
			} else if (oldDirection == SWT.UP) {
				sortDirection = SWT.DOWN;
			}
		}
		tree.setSortColumn(col);
		tree.setSortDirection(sortDirection);

		// Update comparator
		sortType = columnMapping.get(col.getText());
		// System.err.println("Set sort type to " + sortType);

		// Refresh viewer
		viewer.refresh();
	}

	public void widgetDefaultSelected(SelectionEvent e) {
	}
}
