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

package com.nokia.tools.vct.internal.common.secure.ui.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.widgets.Event;

public class SelectAllKeysAction extends Action {
	private StructuredViewer viewer;

	public SelectAllKeysAction(StructuredViewer viewer) {
		this.viewer = viewer;
		setText("Select All");
	}

	@Override
	public void runWithEvent(Event event) {
		IStructuredContentProvider provider = (IStructuredContentProvider) viewer
				.getContentProvider();
		Object[] elements = provider.getElements(viewer.getInput());
		viewer.setSelection(new StructuredSelection(elements));
	}
}
