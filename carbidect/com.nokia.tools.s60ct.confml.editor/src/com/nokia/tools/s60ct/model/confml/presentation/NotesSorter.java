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
 * Description: This file is part of com.nokia.tools.variant.views component.
 */

package com.nokia.tools.s60ct.model.confml.presentation;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TableColumn;
import com.nokia.tools.s60ct.confml.viewer.NotesView;

public class NotesSorter extends ViewerSorter {

	private TableColumn currentColumn;
	private int dir;

	public NotesSorter(TableColumn currentColumn, int dir) {
		super();
		this.currentColumn = currentColumn;
		this.dir = dir;
	}

	@Override
	public int compare(Viewer viewer, Object e1, Object e2) {
		int returnValue = 0;
		NotesLabelProvider labelProvider = null;
		if (viewer instanceof TableViewer) {

			TableViewer tv = (TableViewer) viewer;
			labelProvider=(NotesLabelProvider)tv.getLabelProvider();
		}

		int col = -1;
		
		if (currentColumn.getText() == NotesView.NOTES_COLUMN_1_NAME)
			col = 0;
	    else if (currentColumn.getText() == NotesView.NOTES_COLUMN_2_NAME)
	    	col = 1;
			
		String e1String = labelProvider.getColumnText(e1, col);
		String e2String = labelProvider.getColumnText(e2, col);
		returnValue = e1String.compareTo(e2String);
		
		if (dir == SWT.UP) {
			return -returnValue;
		}
		return returnValue;
	}

}
