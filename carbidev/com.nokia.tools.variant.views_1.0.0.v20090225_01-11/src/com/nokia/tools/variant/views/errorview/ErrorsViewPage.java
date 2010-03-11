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

package com.nokia.tools.variant.views.errorview;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.ui.part.Page;

import com.nokia.tools.variant.views.common.Column;
import com.nokia.tools.variant.views.common.ComboViewerFilter;
import com.nokia.tools.variant.views.common.GenericTableViewer;
import com.nokia.tools.variant.views.common.ViewsMessages;
import com.nokia.tools.variant.views.errormodel.Error;
import com.nokia.tools.variant.views.errormodel.ErrorsRoot;

/**
 * Errors view displays settings with validation error. Graphic user
 * interface(GUI) is represented by {@link TableViewer}, strictly speaking
 * {@link GenericTableViewer}, what is our component.
 * 
 */

public class ErrorsViewPage extends Page {

	private Label errorCount;
	private Label filterLbl;
	private Combo filterCombo;
	private ComboViewerFilter errorsViewerFilter;
	private int selectionIndex;

	private Composite topComposite;

	private GenericTableViewer errorTV;
	private ErrorsRoot errorsInput;

	private final int COLUMN_1_WIDTH = 200;
	private final int COLUMN_2_WIDTH = 350;
	private final int COLUMN_3_WIDTH = 350;

	private static final int MIN_FILTER_STEP = 20;

	private int currentFilterStep;

	private Adapter adapter = new Adapter() {

		public Notifier getTarget() {

			return null;
		}

		public boolean isAdapterForType(Object type) {

			return false;
		}

		public void notifyChanged(Notification notification) {
			if (notification.getEventType() == Notification.REMOVING_ADAPTER) {
				return;
			}

			if (notification.getEventType() == Notification.ADD
					|| notification.getEventType() == Notification.ADD_MANY
					|| notification.getEventType() == Notification.REMOVE
					|| notification.getEventType() == Notification.REMOVE_MANY) {

				filterCombo.removeAll();
				fillFilterCombo();

				if (selectionIndex < filterCombo.getItemCount()) {
					filterCombo.select(selectionIndex);
				} else {
					filterCombo.select(0);
				}

				errorTV.getTv().resetFilters();
				if (selectionIndex != 0
						&& selectionIndex < filterCombo.getItemCount()) {
					errorsViewerFilter = new ComboViewerFilter(filterCombo
							.getItem(selectionIndex));
					errorTV.getTv().addFilter(errorsViewerFilter);
				}
				if (errorsViewerFilter != null) {
					errorsViewerFilter.setCounter(0);
				}
				errorTV.getTv().refresh();
			}

			if (notification.getEventType() == Notification.SET) {
				errorTV.getTv().update(notification.getNotifier(), null);
			}

			errorCount.setText(errorsInput.getErrors().size() + " "
					+ ViewsMessages.ERRORS);

			errorCount.pack();
		}

		public void setTarget(Notifier newTarget) {

		}

	};

	public ErrorsViewPage(ErrorsRoot er) {
		this.errorsInput = er;
	}

	@Override
	public void init(IPageSite pageSite) {

		super.init(pageSite);
		contributeToActionBars();
	}

	@Override
	public void createControl(Composite parent) {
		topComposite = new Composite(parent, SWT.NONE);
		topComposite.setLayout(new GridLayout(3, false));

		errorCount = new Label(topComposite, SWT.NONE);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		errorCount.setLayoutData(gd);

		filterLbl = new Label(topComposite, SWT.NONE);
		filterLbl.setText("Show results:");

		filterCombo = new Combo(topComposite, SWT.READ_ONLY);

		fillFilterCombo();

		// default selection
		filterCombo.select(0);

		filterCombo.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				Combo combo = (Combo) e.widget;
				selectionIndex = combo.getSelectionIndex();
				errorTV.getTv().resetFilters();
				if (selectionIndex != 0) {
					errorsViewerFilter = new ComboViewerFilter(combo
							.getItem(selectionIndex));
					errorTV.getTv().addFilter(errorsViewerFilter);
				}
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				

			}
		});

		errorTV = new GenericTableViewer(topComposite);

		GridData layoutData = (GridData) errorTV.getTv().getTable()
				.getLayoutData();
		layoutData.horizontalSpan = 3;
		errorTV.getTv().getTable().setLayoutData(layoutData);

		errorTV.addColumn(new Column(ViewsMessages.ERROR_COLUMN_1_NAME,
				COLUMN_1_WIDTH));
		errorTV.addColumn(new Column(ViewsMessages.ERROR_COLUMN_2_NAME,
				COLUMN_2_WIDTH));
		errorTV.addColumn(new Column(ViewsMessages.ERROR_COLUMN_3_NAME,
				COLUMN_3_WIDTH));

		errorTV.setContentProvider(new ErrorsContentProvider());
		errorTV.setLabelProvider(new ErrorsLabelProvider());
		errorTV.setInput(errorsInput);

		errorsInput.eAdapters().add(adapter);
		errorTV.getTv().getTable().addDisposeListener(new DisposeListener() {

			public void widgetDisposed(DisposeEvent e) {
				errorsInput.eAdapters().remove(adapter);
				adapter = null;

			}

		});
		errorTV.populateTableViewer();
		errorTV.getTv().addDoubleClickListener(new IDoubleClickListener() {

			public void doubleClick(DoubleClickEvent event) {
				IWorkbenchPage activePage = PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getActivePage();
				if (activePage != null) {
					IEditorPart activeEditor = activePage.getActiveEditor();
					if (activeEditor instanceof ISelectionProvider) {
						StructuredSelection selection = (StructuredSelection) event
								.getSelection();
						Error errorElement = (Error) selection
								.getFirstElement();
						StructuredSelection structuredSelection = new StructuredSelection(
								errorElement.getSetting());

						ISelectionProvider provider = (ISelectionProvider) activeEditor;
						provider.setSelection(structuredSelection);
					}
				}

			}

		});

		errorCount.setText(errorsInput.getErrors().size() + " "
				+ ViewsMessages.ERRORS);
	}

	private void fillFilterCombo() {
		filterCombo.add("All", 0);
		int size = errorsInput.getErrors().size();
		if (size <= 200) {
			currentFilterStep = MIN_FILTER_STEP;
		} else {
			currentFilterStep = size / 10;
			if (size % 10 != 0) {
				currentFilterStep += 1;
			}
		}
		for (int i = 1, x = 0; x < size; i++, x = x + currentFilterStep) {
			String range = x + 1 + "-" + (x + currentFilterStep);
			if (x + currentFilterStep >= size) {
				range = x + 1 + "-" + size;
			}
			filterCombo.add(range, i);
		}

	}

	@Override
	public Control getControl() {
		
		return topComposite;
	}

	@Override
	public void setFocus() {
		

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
		bars.setGlobalActionHandler(ActionFactory.UNDO.getId(), registry
				.getAction(ActionFactory.UNDO.getId()));
		bars.setGlobalActionHandler(ActionFactory.REDO.getId(), registry
				.getAction(ActionFactory.REDO.getId()));

		bars.updateActionBars();

	}

}
