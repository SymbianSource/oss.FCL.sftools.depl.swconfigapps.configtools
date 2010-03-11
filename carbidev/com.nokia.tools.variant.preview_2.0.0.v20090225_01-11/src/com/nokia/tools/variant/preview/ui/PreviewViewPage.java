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
 * Description: This file is part of com.nokia.tools.variant.preview component.
 */

package com.nokia.tools.variant.preview.ui;

import org.eclipse.core.runtime.ListenerList;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.util.SafeRunnable;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.ui.part.Page;

import com.nokia.tools.variant.common.core.utils.PlatformUtil;
import com.nokia.tools.variant.preview.IPreviewDescriptor;
import com.nokia.tools.variant.preview.PreviewController;
import com.nokia.tools.variant.preview.UnsupportedContentDescriptor;

public class PreviewViewPage extends Page implements ISelectionListener,
		IPreviewViewPage, ISelectionProvider {

	private Composite topComposite;

	private PreviewController previewControl;

	private IWorkbenchPart contributor;

	private ListenerList listeners;

	private ISelection selection;

	public PreviewViewPage(IWorkbenchPart contributor) {
		this.contributor = contributor;
		this.listeners = new ListenerList();
	}

	@Override
	public void createControl(Composite parent) {
		topComposite = new Composite(parent, SWT.NONE);
		topComposite.setLayout(new FillLayout());
		topComposite.setBackground(parent.getBackground());
		topComposite.setForeground(parent.getForeground());
		topComposite.setFont(parent.getFont());

		createDefaultControl();
	}

	@Override
	public Control getControl() {
		return topComposite;
	}

	public void selectionChanged(final IWorkbenchPart part,
			final ISelection selection) {

		setSelection(selection);

		IWorkbenchPage activePage = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage();
		if (activePage != null) {
			IEditorReference[] editorReferences = activePage
					.getEditorReferences();
			boolean shouldReturn = true;
			for (IEditorReference editorReference : editorReferences) {
				if (editorReference.getEditor(true) == null) {
					shouldReturn = false;
					break;
				}
				if (editorReference.getEditor(true).equals(contributor)) {
					shouldReturn = false;
					break;
				}
			}
			if (shouldReturn) {
				return;
			}
		}

		if (part instanceof PreviewView) {
			return;
		}

		Object selected = null;
		if (selection instanceof IStructuredSelection) {
			selected = ((IStructuredSelection) selection).getFirstElement();
		}

		IPreviewDescriptor descriptor = null;
		if (selected != null) {
			descriptor = PlatformUtil.getAdapter(selected,
					IPreviewDescriptor.class, true);
		} else {
			disposePreviewControl();
			return;
		}

		if (descriptor instanceof UnsupportedContentDescriptor) {
			UnsupportedContentDescriptor unsupportedContentDescriptor = (UnsupportedContentDescriptor) descriptor;
			if (unsupportedContentDescriptor.getName() == "") {
				topComposite.setRedraw(true);
				disposePreviewControl();
				createDefaultControl();
				topComposite.layout(true, true);
				return;
			}
		}

		try {
			if (topComposite.isDisposed()) {
				disposePreviewControl();
				return;
			}
			topComposite.setRedraw(false);

			if (descriptor == null) {
				disposePreviewControl();
				createDefaultControl();
				return;
			}
			try {
				PreviewController newControl = descriptor
						.createPreviewControl();

				if (newControl == null) {
					disposePreviewControl();
					createDefaultControl();
				} else if (!newControl.equals(previewControl)) {
					disposePreviewControl();
					previewControl = newControl;

					previewControl.createControl(topComposite);
					previewControl.setActionBars(getSite().getActionBars());
				}
				if (previewControl != null) {
					previewControl.setInput(descriptor);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} finally {
			if (topComposite.isDisposed()) {
				return;
			}
			topComposite.layout(true, true);
			topComposite.setRedraw(true);
		}

	}

	private void disposePreviewControl() {
		if (previewControl != null) {
			previewControl.dispose();
			previewControl = null;
		}
		if (topComposite != null && !topComposite.isDisposed()) {
			for (Control child : topComposite.getChildren()) {
				if (child != null) {
					child.dispose();
				}
			}
		}
	}

	@Override
	public void init(IPageSite site) {
		super.init(site);
		site.setSelectionProvider(this);
	}

	@Override
	public void dispose() {
		setSelection(StructuredSelection.EMPTY);
		listeners.clear();
		getSite().setSelectionProvider(null);
		disposePreviewControl();
		if (contributor != null) {
			contributor = null;
		}
		if (topComposite != null) {
			topComposite.dispose();
			topComposite = null;
		}
		super.dispose();
	}

	@Override
	public void setFocus() {
		Control control = getControl();
		if (control != null && !control.isDisposed()) {
			getControl().setFocus();
		}
	}

	private void createDefaultControl() {
		Composite parent = new Composite(topComposite, SWT.NONE);
		parent.setBackground(topComposite.getBackground());
		parent.setLayout(new GridLayout());

		Label text = new Label(parent, SWT.WRAP | SWT.CENTER);
		text.setBackground(parent.getBackground());
		GridData data = new GridData(SWT.CENTER, SWT.CENTER, false, false);
		text.setLayoutData(data);
		text.setText("No preview for selected element");
	}

	/**
	 * @see org.eclipse.ui.part.IPage#setActionBars(org.eclipse.ui.IActionBars)
	 */
	@Override
	public void setActionBars(IActionBars actionBars) {
		// Override the undo and redo global action handlers
		// to use the contributor action handlers
		IActionBars partActionBars = null;
		if (contributor instanceof IEditorPart) {
			IEditorPart editorPart = (IEditorPart) contributor;
			partActionBars = editorPart.getEditorSite().getActionBars();
		} else if (contributor instanceof IViewPart) {
			IViewPart viewPart = (IViewPart) contributor;
			partActionBars = viewPart.getViewSite().getActionBars();
		}

		if (partActionBars != null) {
			IAction action = partActionBars
					.getGlobalActionHandler(ActionFactory.UNDO.getId());
			if (action != null) {
				actionBars.setGlobalActionHandler(ActionFactory.UNDO.getId(),
						action);
			}
			action = partActionBars.getGlobalActionHandler(ActionFactory.REDO
					.getId());
			if (action != null) {
				actionBars.setGlobalActionHandler(ActionFactory.REDO.getId(),
						action);
			}
		}
	}

	public void addSelectionChangedListener(ISelectionChangedListener listener) {
		listeners.add(listener);
	}

	public void removeSelectionChangedListener(
			ISelectionChangedListener listener) {
		listeners.remove(listener);
	};

	public ISelection getSelection() {
		return selection;
	}

	public void setSelection(ISelection selection) {
		this.selection = selection;
		final SelectionChangedEvent event = new SelectionChangedEvent(this,
				selection);

		for (final Object o : listeners.getListeners()) {
			SafeRunner.run(new SafeRunnable() {
				public void run() throws Exception {
					((ISelectionChangedListener) o).selectionChanged(event);
				}
			});
		}
	}
}
