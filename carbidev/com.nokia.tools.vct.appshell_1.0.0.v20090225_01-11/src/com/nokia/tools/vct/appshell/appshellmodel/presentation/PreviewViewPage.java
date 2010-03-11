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
 * Description: This file is part of com.nokia.tools.vct.appshell component.
 */

package com.nokia.tools.vct.appshell.appshellmodel.presentation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.ListenerList;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.SelectionManager;
import org.eclipse.gef.editparts.ScalableRootEditPart;
import org.eclipse.gef.ui.parts.ScrollingGraphicalViewer;
import org.eclipse.jface.util.SafeRunnable;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.ui.part.Page;

import com.nokia.tools.variant.preview.ui.IPreviewViewPage;
import com.nokia.tools.vct.appshell.parts.EAppshellEditPartFactory;

public class PreviewViewPage extends Page implements IPreviewViewPage, ISelectionProvider {

	EditPartViewer viewer;
	private IEditorPart editorPart;
	private Object input;
	private ListenerList listeners;

	public PreviewViewPage(IEditorPart editorPart, Object input) {
		this.editorPart = editorPart;
		this.input = input;
		this.listeners = new ListenerList();
	}
	
	public EditPartViewer getViewer() {
		return viewer;
	}

	@Override
	public void createControl(Composite parent) {
		viewer = new ScrollingGraphicalViewer();
		
		ScalableRootEditPart rootEditPart = new ScalableRootEditPart();
		rootEditPart.getFigure().setBackgroundColor(ColorConstants.white);
		viewer.setRootEditPart(rootEditPart);
		DefaultEditDomain domain = new DefaultEditDomain(editorPart);
		domain.addViewer(viewer);
		viewer.setEditPartFactory(new EAppshellEditPartFactory(editorPart));
		viewer.setSelectionManager(SelectionManager.createDefault());
		viewer.createControl(parent);
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				SelectionChangedEvent newEvent = new SelectionChangedEvent(PreviewViewPage.this, getSelection());
				fireSelectionChanged(newEvent);
			}
		});

		viewer.setContents(input);
	}

	@Override
	public Control getControl() {
		return viewer.getControl();
	}

	@Override
	public void setFocus() {
		viewer.getControl().setFocus();
	}

	public void addSelectionChangedListener(ISelectionChangedListener listener) {
		listeners.add(listener);
	}
	
	public void removeSelectionChangedListener(
			ISelectionChangedListener listener) {
		listeners.remove(listener);
	}
	
	protected void fireSelectionChanged(final SelectionChangedEvent event) {
		for (final Object o: listeners.getListeners()) {
			SafeRunner.run(new SafeRunnable() {
				public void run() throws Exception {
					((ISelectionChangedListener)o).selectionChanged(event);
				}
			});
		}
	}
	
	public ISelection getSelection() {
		List<?> selected = viewer.getSelectedEditParts();
		Object[] src = selected.toArray();
		Object[] dst = new Object[src.length];
		for (int i = 0; i < src.length; i++) {
			dst[i] = ((EditPart)src[i]).getModel();
		}
		return new StructuredSelection(dst);
	}
	
	@Override
	public void init(IPageSite pageSite) {
		super.init(pageSite);
		pageSite.setSelectionProvider(this);
	}
	
	public void setSelection(ISelection selection) {
		if (!(selection instanceof IStructuredSelection)) {
			return;
		}
		Object[] selected = ((IStructuredSelection)selection).toArray();
		List<EditPart> editParts = new ArrayList<EditPart>();
		for (Object obj: selected) {
			EditPart editPart = (EditPart)viewer.getEditPartRegistry().get(obj);
			if (editPart != null) {
				editParts.add(editPart);
				viewer.reveal(editPart);
			}
		}
		viewer.setSelection(new StructuredSelection(editParts));
	}
	
	@Override
	public void dispose() {
		getSite().setSelectionProvider(null);
		if (viewer != null && viewer.getControl() != null) {
			viewer.getControl().dispose();
		}
		super.dispose();
	}
	
}
