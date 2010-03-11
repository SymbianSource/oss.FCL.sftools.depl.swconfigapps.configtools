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
 * Description: This file is part of com.nokia.tools.variant.resourcelibrary component.
 */

package com.nokia.tools.variant.resourcelibrary.actions;

import org.eclipse.jface.action.Action;

import com.nokia.tools.variant.resourcelibrary.Activator;
import com.nokia.tools.variant.resourcelibrary.views.IResourceLibraryPage;

public class ExpandAllAction extends Action {

	private IResourceLibraryPage page;

	public ExpandAllAction(IResourceLibraryPage page) {
		super("Expand All", Activator.getImageDescriptor("icons/expandall.gif"));
		this.page = page;
	}

	@Override
	public void run() {
		page.expandAll();
	}
}
