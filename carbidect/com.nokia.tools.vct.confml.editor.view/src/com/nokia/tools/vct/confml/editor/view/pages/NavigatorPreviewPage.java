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
 * Description: This file is part of com.nokia.tools.vct.confml.editor.view component.
 */

package com.nokia.tools.vct.confml.editor.view.pages;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.ui.part.Page;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;

import com.nokia.tools.variant.confml.ui.ConfmlUI;
import com.nokia.tools.variant.confml.ui.IConfmlImages;
import com.nokia.tools.vct.common.ui.navigator.NavigatorViewer;
import com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef;
import com.nokia.tools.vct.confml.editor.view.vemodel.EViewsEditorDocument;
import com.nokia.tools.vct.confml.editor.view.viewers.NavigatorViewerLabelProvider;
import com.nokia.tools.vct.confml.editor.view.viewers.ViewTreeViewerContentProvider;

public class NavigatorPreviewPage extends Page implements ITabbedPropertySheetPageContributor, 
		IAdaptable, ISelectionProvider,
		ISelectionListener {

	class SyncAction extends Action {
		public SyncAction() {
			super(null, AS_CHECK_BOX);
			setImageDescriptor(ConfmlUI
					.getImageDescriptor(IConfmlImages.ICO_SYNC));
			setId("SYNC");
			setDescription("Link with editor");
		}

		@Override
		public void run() {
			if (isChecked()) {
				updateReceivedSelection();
			}
		}
	}

	private Composite topComposite;
	private NavigatorViewer navigator;

	private IEditorPart host;

	private EViewsEditorDocument document;
	// private EView view;

	private SyncAction syncAction;
	private boolean skipSelection;

	public NavigatorPreviewPage(IEditorPart host) {
		this.host = host;
		this.syncAction = new SyncAction();
	}

	@Override
	public void createControl(Composite parent) {
		topComposite = new Composite(parent, SWT.NONE);
		topComposite.setLayout(new FillLayout());
		topComposite.setBackground(parent.getBackground());
		topComposite.setForeground(parent.getForeground());
		topComposite.setFont(parent.getFont());

		navigator = new NavigatorViewer(topComposite);
		// navigator.setLabelProvider(new LabelProvider());
		// navigator.setContentProvider(new ArrayContentProvider());
		navigator.setContentProvider(new ViewTreeViewerContentProvider());
		NavigatorViewerLabelProvider lp = new NavigatorViewerLabelProvider();
		lp.setViewer(navigator);
		navigator.setLabelProvider(lp);

		((NavigatorViewerLabelProvider) navigator.getLabelProvider())
				.bindModel(document);
		updateNavigatorInput();
		navigator.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				if (!syncAction.isChecked() || skipSelection) {
					return;
				}
				host.getSite().getSelectionProvider().setSelection(
						event.getSelection());
			}
		});
	}

	public void update(EViewsEditorDocument document, IEditorInput input) {
		this.document = document;
		// this.view = view;
		if (navigator != null) {
			((NavigatorViewerLabelProvider) navigator.getLabelProvider())
					.bindModel(document);
			updateNavigatorInput();
		}
	}

	void updateNavigatorInput() {
		if (document == null || document.getViews().isEmpty()) {
			navigator.setInput(null);
		} else {
			navigator.setInput(document.getViews().get(0).getValue());
		}
	}
	
	@Override
	public Control getControl() {
		return topComposite;
	}

	@Override
	public void init(IPageSite site) {
		super.init(site);
		site.setSelectionProvider(this);
		contributeToActionBars();
	}

	@Override
	public void dispose() {
		getSite().getActionBars().getToolBarManager()
				.remove(syncAction.getId());
		getSite().getActionBars().updateActionBars();

		topComposite.dispose();
		topComposite = null;
		navigator = null;
		super.dispose();
	}

	@Override
	public void setFocus() {
		getControl().setFocus();
	}

	public String getContributorId() {
		if (host instanceof ITabbedPropertySheetPageContributor) {
			return ((ITabbedPropertySheetPageContributor) host)
					.getContributorId();
		}
		return null;
	}

	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		if (!syncAction.isChecked()) {
			return;
		}
		if (part != host) {
			return;
		}
		if (!(selection instanceof IStructuredSelection)) {
			return;
		}
		Object obj = ((IStructuredSelection) selection).getFirstElement();
		if (!(obj instanceof EObject)) {
			return;
		}

		updateReceivedSelection();

	}

	private void updateReceivedSelection() {
		ISelection selection = host.getSite().getSelectionProvider()
				.getSelection();
		if (!(selection instanceof IStructuredSelection)) {
			return;
		}
		Object obj = ((IStructuredSelection) selection).getFirstElement();
		if (!(obj instanceof EObject)) {
			return;
		}
		EObject eobj = (EObject) obj;
		EObject input = (EObject) navigator.getInput();
		if (EcoreUtil.isAncestor(input, eobj)) {
			skipSelection = true;
			if (eobj instanceof ESettingRef) {
				eobj = eobj.eContainer();
			}
			navigator.setSelection(new StructuredSelection(eobj));
			skipSelection = false;
		}
	}

	@SuppressWarnings("unchecked")
	public Object getAdapter(Class adapter) {
		return host.getAdapter(adapter);
	}

	public ISelection getSelection() {
		return navigator.getSelection();
	}

	public void setSelection(ISelection selection) {
		navigator.setSelection(selection, true);
	}

	public void addSelectionChangedListener(ISelectionChangedListener listener) {
		navigator.addSelectionChangedListener(listener);
	}

	public void removeSelectionChangedListener(
			ISelectionChangedListener listener) {
		navigator.removeSelectionChangedListener(listener);
	}

	/**
	 * adding actions to main toolbar
	 */
	private void contributeToActionBars() {
		IActionBars bars = getSite().getActionBars();
		/* set undo/redo handlers from parent editor */
		ActionRegistry registry = (ActionRegistry) host
				.getAdapter(ActionRegistry.class);
		bars.setGlobalActionHandler(ActionFactory.UNDO.getId(), registry
				.getAction(ActionFactory.UNDO.getId()));
		bars.setGlobalActionHandler(ActionFactory.REDO.getId(), registry
				.getAction(ActionFactory.REDO.getId()));

		bars.getToolBarManager().add(syncAction);

		bars.updateActionBars();

	}
}
