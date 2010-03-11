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
 * Description: This file is part of com.nokia.tools.variant.viewer component.
 */

package com.nokia.tools.variant.viewer.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.PlatformUI;

import com.nokia.tools.variant.viewer.widgets.BaseConfMLWidget;

public abstract class EditorAction extends Action {

	protected BaseConfMLWidget widget;
	protected Object object;
	protected ISelectionListener selectionListener;

	public EditorAction() {
		initSelectionListener();
		if (selectionListener != null) {
			ISelectionService selectionService = PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getSelectionService();
			selectionService.addSelectionListener(selectionListener);
		}
	}

	public void setWidget(BaseConfMLWidget widget) {
		this.widget = widget;
	}

	public abstract void initSelectionListener();

	public void dispose() {
		if (selectionListener != null) {
			ISelectionService selectionService = PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getSelectionService();
			selectionService.removeSelectionListener(selectionListener);
			selectionListener = null;
		}
		widget = null;
		setImageDescriptor(null);
	}

}
