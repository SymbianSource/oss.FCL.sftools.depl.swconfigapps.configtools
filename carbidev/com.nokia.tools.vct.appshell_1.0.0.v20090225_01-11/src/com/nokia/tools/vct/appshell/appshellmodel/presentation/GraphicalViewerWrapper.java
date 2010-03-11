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

import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Control;

public class GraphicalViewerWrapper extends Viewer {

	private GraphicalViewer delegate;
	
	public GraphicalViewerWrapper(GraphicalViewer src) {
		this.delegate = src;
		this.delegate.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				SelectionChangedEvent newEvent = new SelectionChangedEvent(GraphicalViewerWrapper.this, getSelection());
				GraphicalViewerWrapper.this.fireSelectionChanged(newEvent);
			}
		});
	}
	
	public GraphicalViewer getDelegate() {
		return delegate;
	}
	
	@Override
	public Control getControl() {
		return delegate.getControl();
	}

	@Override
	public Object getInput() {
		return delegate.getContents().getModel();
	}

	@Override
	public ISelection getSelection() {
		IStructuredSelection ss = (IStructuredSelection)delegate.getSelection();
		Object[] src = ss.toArray();
		Object[] dst = new Object[src.length];
		for (int i = 0; i < src.length; i++) {
			dst[i] = ((EditPart)src[i]).getModel();
		}
		return new StructuredSelection(dst);
	}

	@Override
	public void refresh() {
		delegate.getRootEditPart().refresh();
	}

	@Override
	public void setInput(Object input) {
		delegate.setContents(input);
	}

	@Override
	public void setSelection(ISelection selection, boolean reveal) {
		if (!(selection instanceof IStructuredSelection)) {
			return;
		}
		Object[] selected = ((IStructuredSelection)selection).toArray();
		List<EditPart> editParts = new ArrayList<EditPart>();
		for (Object obj: selected) {
			EditPart editPart = (EditPart)delegate.getEditPartRegistry().get(obj);
			if (editPart != null) {
				editParts.add(editPart);
				if (reveal) {
					delegate.reveal(editPart);
				}
			}
		}
		delegate.setSelection(new StructuredSelection(editParts));
	}

}
