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

package com.nokia.tools.variant.views.notesview;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
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

import com.nokia.tools.variant.content.confml.ConfmlPackage;
import com.nokia.tools.variant.content.confml.Setting;
import com.nokia.tools.variant.content.confml.View;
import com.nokia.tools.variant.views.common.Column;
import com.nokia.tools.variant.views.common.GenericTableViewer;
import com.nokia.tools.variant.views.common.ViewsMessages;

public class NotesViewPage extends Page {

	private View view;

	private Composite composite;
	private GenericTableViewer notesTV;

	private final int COLUMN_1_WIDTH = 200;
	private final int COLUMN_2_WIDTH = 350;
	private final int COLUMN_3_WIDTH = 350;

	private Adapter adapter;

	public NotesViewPage(View view) {
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

		final Label notesCount = new Label(composite, SWT.NONE);

		notesTV = new GenericTableViewer(composite);

		notesTV.addColumn(new Column(ViewsMessages.NOTES_COLUMN_1_NAME,
				COLUMN_1_WIDTH));
		notesTV.addColumn(new Column(ViewsMessages.NOTES_COLUMN_2_NAME,
				COLUMN_2_WIDTH));
		notesTV.addColumn(new Column(ViewsMessages.NOTES_COLUMN_3_NAME,
				COLUMN_3_WIDTH));

		notesTV.setContentProvider(new NotesContentProvider());
		notesTV.setLabelProvider(new NotesLabelProvider());
		notesTV.setInput(view);

		notesTV.populateTableViewer();

		adapter = new EContentAdapter() {

			public void notifyChanged(Notification notification) {
				super.notifyChanged(notification);
				if (notification.getEventType() == Notification.REMOVING_ADAPTER) {
					return;
				}

				if (notification.getEventType() == Notification.ADD
						|| notification.getEventType() == Notification.ADD_MANY
						|| notification.getEventType() == Notification.REMOVE
						|| notification.getEventType() == Notification.REMOVE_MANY
						|| (notification.getEventType() == Notification.SET && notification
								.getFeatureID(Setting.class) == ConfmlPackage.SETTING__NOTE)) {
					if (notesTV != null && notesTV.getTv() != null) {
						notesTV.getTv().refresh();
						notesCount.setText(notesTV.getRowCount() + " "
								+ ViewsMessages.NOTES);
						notesCount.pack();
					}
				}
			}

		};

		view.eAdapters().add(adapter);

		notesTV.populateTableViewer();
		notesTV.getTv().addDoubleClickListener(new IDoubleClickListener() {

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

		notesCount.setText(notesTV.getRowCount() + " " + ViewsMessages.NOTES);
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
		view.eAdapters().remove(adapter);
		adapter = null;
		view = null;
		if (notesTV != null && notesTV.getTv() != null
				&& notesTV.getTv().getTable() != null
				&& !notesTV.getTv().getTable().isDisposed()) {
			notesTV.getTv().getTable().dispose();
			notesTV = null;
		}
		if(composite!=null&&!composite.isDisposed()){
			composite.dispose();
			composite = null;
		}
		notesTV = null;
		super.dispose();
	}
}
