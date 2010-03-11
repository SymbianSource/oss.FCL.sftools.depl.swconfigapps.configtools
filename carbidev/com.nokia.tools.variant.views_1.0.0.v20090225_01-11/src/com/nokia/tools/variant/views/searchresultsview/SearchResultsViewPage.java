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

package com.nokia.tools.variant.views.searchresultsview;

import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.ui.part.Page;

import com.nokia.tools.variant.views.common.Column;
import com.nokia.tools.variant.views.common.GenericTableViewer;
import com.nokia.tools.variant.views.common.ViewsMessages;

public class SearchResultsViewPage extends Page {

	private Composite composite;

	private Label resultsCount;

	private GenericTableViewer searchTV;

	private String keyword = "";

	private final int COLUMN_1_WIDTH = 200;
	private final int COLUMN_2_WIDTH = 350;
	private final int COLUMN_3_WIDTH = 350;

	private Listener paintItemLister = new Listener() {

		public void handleEvent(Event event) {
			if (keyword != null && keyword.equals("")) {
				return;
			}
			TableItem item = (TableItem) event.item;
			int index = event.index;
			IBaseLabelProvider lp = searchTV.getTv().getLabelProvider();
			if (lp instanceof ITableLabelProvider) {
				ITableLabelProvider labelProvider = (ITableLabelProvider) lp;
				if (labelProvider != null) {
					String columnText = labelProvider.getColumnText(event.item.getData(), index);
	
					// display bolder keyword in the text
					String t = columnText.toLowerCase();
					String k = keyword.toLowerCase();
					if (t.contains(k)) {
						displayBoldOccurencies(event.gc, item, index, keyword, columnText, event.x, event.y);
					}
				} else {
					System.out.println(lp);
				}
			} else {
				System.out.println(lp);
			}
		}

		private void displayBoldOccurencies(GC gc, TableItem item, int index,
				String keyword, String columnText, int x, int y) {
			//gc.setBackground(new Color(Display.getDefault(), 100, 100, 0));
			
			String t = columnText.toLowerCase();
			String k = keyword.toLowerCase();

			// fill item's area with white color
			Rectangle bounds = item.getBounds(index);
			gc.fillRectangle(bounds);
			
			
			int indexOf = t.indexOf(k);
			if (indexOf != -1) {// no bold text
				// create bold font
				FontData fd = JFaceResources.getDefaultFont().getFontData()[0];
				Font boldFont = new Font(Display.getDefault(), fd.getName(), 8,
						SWT.BOLD);

				// get default font
				Font defaultFont = JFaceResources.getDefaultFont();
				
				// start X position for every substring has to be changed
				int diffX = 0;
				if (index > 0) {
					diffX = 5;
				}
				
				// default font
				gc.setFont(defaultFont);
				if (indexOf > 0) {
					String begining = columnText.substring(0, indexOf);
					Point textExtent = gc.textExtent(begining);

					gc.drawText(begining, diffX + x, y);
					diffX += textExtent.x;
				}
				
				
				// bold font
				gc.setFont(boldFont);
				String middle = keyword;
				Point textExtent = gc.textExtent(middle);

				
				gc.drawText(middle, x + diffX, y);
				diffX += textExtent.x;
				
				
				// default font
				gc.setFont(defaultFont);
				String ending = columnText.substring(indexOf + keyword.length()); 
				textExtent = gc.textExtent(ending);
				gc.drawText(ending, x + diffX, y);
				
				
				// dispose bold font
				boldFont.dispose();
			} else {
				if (index == 0) {
					gc.drawText(columnText, x+3, y);
				} else {
					gc.drawText(columnText, x+5, y);
				}
			}
			
			
			
			
			
		}
	};
	
	public SearchResultsViewPage() {
		super();
	}

	@Override
	public void init(IPageSite pageSite) {

		super.init(pageSite);
		contributeToActionBars();
	}

	@Override
	public void createControl(Composite parent) {
		composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));

		resultsCount = new Label(composite, SWT.NONE);
		searchTV = new GenericTableViewer(composite);

		searchTV.addColumn(new Column(ViewsMessages.SEARCH_COLUMN_1_NAME,
				COLUMN_1_WIDTH));
		searchTV.addColumn(new Column(ViewsMessages.SEARCH_COLUMN_2_NAME,
				COLUMN_2_WIDTH));
		searchTV.addColumn(new Column(ViewsMessages.SEARCH_COLUMN_3_NAME,
				COLUMN_3_WIDTH));

		searchTV.setContentProvider(new SearchContentProvider());
		searchTV.setLabelProvider(new SearchLabelProvider());
		searchTV.getTv().getTable().addListener(SWT.PaintItem, paintItemLister);
		searchTV.setInput(null);

		searchTV.populateTableViewer();
		searchTV.getTv().addDoubleClickListener(new IDoubleClickListener() {

			public void doubleClick(DoubleClickEvent event) {
				IWorkbenchPage activePage = PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getActivePage();
				if (activePage != null) {
					IEditorPart activeEditor = activePage.getActiveEditor();
					if (activeEditor instanceof ISelectionProvider) {
						ISelectionProvider provider = (ISelectionProvider) activeEditor;
						provider.setSelection(event.getSelection());
					}
				}

			}

		});
		resultsCount.setText(keyword + " - " + searchTV.getRowCount() + " "
				+ ViewsMessages.MATCHES);
	}

	@Override
	public Control getControl() {
		
		return composite;
	}

	@Override
	public void setFocus() {
		

	}

	public void setInput(Object input) {
		searchTV.setInput(input);
		searchTV.populateTableViewer();
		resultsCount.setText(keyword + " - " + searchTV.getRowCount() + " "
				+ ViewsMessages.MATCHES);
		resultsCount.pack();
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	/**
	 * adding actions to main toolbar
	 */
	private void contributeToActionBars() {

		IActionBars bars = getSite().getActionBars();
		/* set undo/redo handlers from parent editor */
		ActionRegistry registry = (ActionRegistry) (getSite()
				.getWorkbenchWindow().getActivePage().getActiveEditor())
				.getAdapter(ActionRegistry.class);
		if (registry == null) {
			return;
		}
		bars.setGlobalActionHandler(ActionFactory.UNDO.getId(), registry
				.getAction(ActionFactory.UNDO.getId()));
		bars.setGlobalActionHandler(ActionFactory.REDO.getId(), registry
				.getAction(ActionFactory.REDO.getId()));

		bars.updateActionBars();

	}
	
	public void dispose() {
		if (!searchTV.getTv().getTable().isDisposed()) {
			searchTV.getTv().getTable().removeListener(SWT.PaintItem, paintItemLister);
		}
		super.dispose();
	}

}
