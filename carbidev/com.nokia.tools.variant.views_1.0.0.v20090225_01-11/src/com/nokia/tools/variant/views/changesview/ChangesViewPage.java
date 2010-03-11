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

package com.nokia.tools.variant.views.changesview;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.GridLayout;
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

import com.nokia.tools.variant.content.confml.Setting;
import com.nokia.tools.variant.content.confml.View;
import com.nokia.tools.variant.views.common.Column;
import com.nokia.tools.variant.views.common.GenericTableViewer;
import com.nokia.tools.variant.views.common.ViewsMessages;

/**
 * In this view are displayed settings changed from their default values.
 * Graphic user interface(GUI) is represented by {@link TableViewer}, strictly
 * speaking {@link GenericTableViewer}, what is our component. The changes are
 * notified over the adapter.
 * 
 */
public class ChangesViewPage extends Page {

	private View view;

	private Composite composite;
	private GenericTableViewer changesTV;

	private final int COLUMN_1_WIDTH = 200;
	private final int COLUMN_2_WIDTH = 200;
	private final int COLUMN_3_WIDTH = 200;
	private final int COLUMN_4_WIDTH = 200;

	private Adapter adapter;

	public ChangesViewPage(View view) {
		super();
		this.view = view;
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

		final Label changesCount = new Label(composite, SWT.NONE);

		changesTV = new GenericTableViewer(composite);

		changesTV.addColumn(new Column(ViewsMessages.CHANGES_COLUMN_1_NAME,
				COLUMN_1_WIDTH));
		changesTV.addColumn(new Column(ViewsMessages.CHANGES_COLUMN_2_NAME,
				COLUMN_2_WIDTH));
		changesTV.addColumn(new Column(ViewsMessages.CHANGES_COLUMN_3_NAME,
				COLUMN_3_WIDTH));
		changesTV.addColumn(new Column(ViewsMessages.CHANGES_COLUMN_4_NAME,
				COLUMN_4_WIDTH));

		changesTV.setContentProvider(new ChangesContentProvider());
		changesTV.setLabelProvider(new ChangesLabelProvider());
		changesTV.setInput(view);

		changesTV.populateTableViewer();

		adapter = new EContentAdapter() {

			public void notifyChanged(Notification notification) {
				super.notifyChanged(notification);
				if (notification.getEventType() == Notification.REMOVING_ADAPTER) {
					return;
				}

				if (notification.getEventType() == Notification.ADD
						|| notification.getEventType() == Notification.ADD_MANY
						|| notification.getEventType() == Notification.REMOVE
						|| notification.getEventType() == Notification.REMOVE_MANY) {
					changesTV.getTv().refresh();
				}

				if (notification.getEventType() == Notification.SET) {
					changesTV.getTv().refresh();
				}

				changesCount.setText(changesTV.getRowCount() + " "
						+ ViewsMessages.CHANGES);
				changesCount.pack();
			}

		};

		view.eAdapters().add(adapter);

		changesTV.getTv().getTable().addDisposeListener(new DisposeListener() {

			public void widgetDisposed(DisposeEvent e) {
				view.eAdapters().remove(adapter);

			}

		});

		changesTV.getTv().addDoubleClickListener(new IDoubleClickListener() {

			public void doubleClick(DoubleClickEvent event) {
				IWorkbenchPage activePage = PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getActivePage();
				if (activePage != null) {
					IEditorPart activeEditor = activePage.getActiveEditor();
					if (activeEditor instanceof ISelectionProvider) {
						StructuredSelection selection = (StructuredSelection) event
								.getSelection();
						Setting setting = (Setting) selection.getFirstElement();
						StructuredSelection structuredSelection = new StructuredSelection(
								setting);

						ISelectionProvider provider = (ISelectionProvider) activeEditor;
						provider.setSelection(structuredSelection);
					}
				}

			}

		});

		changesCount.setText(changesTV.getRowCount() + " "
				+ ViewsMessages.CHANGES);
	}

	@Override
	public Control getControl() {

		return composite;
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

	@Override
	public void dispose() {
		if (view != null) {
			view.eAdapters().remove(adapter);
			view = null;
		}
		adapter = null;
		if (changesTV != null && changesTV.getTv() != null
				&& changesTV.getTv().getTable() != null
				&& !changesTV.getTv().getTable().isDisposed()) {
			changesTV.getTv().getTable().dispose();
			changesTV = null;
		}
		if (composite != null && !composite.isDisposed()) {
			composite.dispose();
			composite = null;
		}
		super.dispose();
	}

}
