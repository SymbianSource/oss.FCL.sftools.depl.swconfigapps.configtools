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
package com.nokia.tools.s60ct.confml.viewer;

import java.util.Map.Entry;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.part.ViewPart;
import com.nokia.tools.s60ct.build.builder.NotesBuilder;
import com.nokia.tools.s60ct.confml.editor.popup.actions.OpenEditorHandler;
import com.nokia.tools.s60ct.model.confml.presentation.NotesContentProvider;
import com.nokia.tools.s60ct.model.confml.presentation.NotesLabelProvider;
import com.nokia.tools.s60ct.model.confml.presentation.NotesSorter;
import com.nokia.tools.vct.common.appmodel.EAppFeature;
import com.nokia.tools.vct.common.appmodel.EAppSetting;
import com.nokia.tools.vct.common.appmodel.EAppSettingType;

public class NotesView extends ViewPart {

	public static final String ID = "com.nokia.tools.s60ct.confml.editor.notesView";
	
	private TableViewer tv = null; 
	private TableColumn genericColumn;
	private Table table;
	private final int COLUMN_1_WIDTH = 200;
	private final int COLUMN_2_WIDTH = 800;
	public static final String NOTES_COLUMN_1_NAME = "Setting";
	public static final String NOTES_COLUMN_2_NAME = "Notes";
	
	public NotesView() {
		
	}

	@Override
	public void createPartControl(Composite parent) {
		
		tv = new TableViewer(parent, SWT.H_SCROLL | SWT.V_SCROLL| SWT.BORDER | SWT.FULL_SELECTION|SWT.MULTI);
		table = tv.getTable();
		
		table.setLayoutData(new GridData(GridData.FILL_BOTH));

		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		GridData layoutData = (GridData) table.getLayoutData();
		layoutData.horizontalSpan = 1;
		layoutData.grabExcessHorizontalSpace = true;
		layoutData.horizontalAlignment = SWT.FILL;
		
		table.setLayoutData(layoutData);
		
		addColumn(new Column(NOTES_COLUMN_1_NAME, COLUMN_1_WIDTH));
		addColumn(new Column(NOTES_COLUMN_2_NAME, COLUMN_2_WIDTH));
		
		tv.setContentProvider(new NotesContentProvider());
		tv.setLabelProvider(new NotesLabelProvider());
		
		tv.addDoubleClickListener(new IDoubleClickListener() {

			public void doubleClick(DoubleClickEvent event) {
				StructuredSelection selection = (StructuredSelection) event.getSelection();
				Entry entry = (Entry) selection.getFirstElement();
				Object eAppObject = entry.getKey();
				
				EAppFeature feature  = null;
				String ref = null;
				if (eAppObject instanceof EAppSetting)
				{
					EAppSetting setting = (EAppSetting)entry.getKey();
					if (setting.eContainer().eContainer() instanceof EAppFeature)
					{
						feature = (EAppFeature)setting.eContainer().eContainer();
						ref = feature.getRef()+"/"+setting.getRef();
					}
				}
				else if (eAppObject instanceof EAppSettingType)
				{
					EAppSettingType sType = (EAppSettingType)eAppObject;
					
					if (sType.eContainer().eContainer().eContainer().eContainer().eContainer() instanceof EAppFeature)
						feature = (EAppFeature)sType.eContainer().eContainer().eContainer().eContainer().eContainer();  //LOL!!!
				}
				
				if (feature!=null)
				{
					OpenEditorHandler handler = new OpenEditorHandler();
					handler.externalExecute(feature, getSite().getPage().getWorkbenchWindow(), ref);
				}
			}
		});
		loadNotes();
	}

	
	
	public void loadNotes()
	{
		tv.setInput(NotesBuilder.getNotesBuilder().getNotes());
	}
	
	public void addColumn(Column column) {
		genericColumn = new TableColumn(table, SWT.LEFT);
		genericColumn.setText(column.getName());
		genericColumn.setWidth(column.getWidth());
		genericColumn.addListener(SWT.Selection, new Listener() {

			public void handleEvent(Event event) {
				TableColumn sortColumn = table.getSortColumn();
				TableColumn currentColumn = (TableColumn) event.widget;

				int dir = table.getSortDirection();

				if (sortColumn == currentColumn) {
					dir = dir == SWT.UP ? SWT.DOWN : SWT.UP;
				} else {
					table.setSortColumn(currentColumn);
					dir = SWT.UP;
				}

				table.setSortDirection(dir);
				tv.setSorter(new NotesSorter(currentColumn, dir));
			}
		});
		
		tv.setSorter(new NotesSorter(genericColumn, SWT.DOWN));
	}

	public class Column {
		private String name;
		private int width;

		public Column(String name, int width) {
			this.name = name;
			this.width = width;
		}

		public String getName() {
			return name;
		}

		public int getWidth() {
			return width;
		}

	}

	@Override
	public void setFocus() {
	
		
	}
	
}
