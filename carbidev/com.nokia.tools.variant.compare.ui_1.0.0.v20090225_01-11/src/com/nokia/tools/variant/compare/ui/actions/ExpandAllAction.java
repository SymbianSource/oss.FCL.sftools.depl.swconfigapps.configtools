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
 * Description: This file is part of com.nokia.tools.variant.compare.ui component.
 */

package com.nokia.tools.variant.compare.ui.actions;

import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.AbstractTreeViewer;

import com.nokia.tools.variant.compare.ui.ImportDataUIPlugin;


public class ExpandAllAction extends Action {

	private AbstractTreeViewer page;

	public ExpandAllAction(AbstractTreeViewer page) {
		super(ImportDataUIPlugin.INSTANCE.getString("_UI_Expand_All_label"),
				ExtendedImageRegistry.INSTANCE
						.getImageDescriptor(ImportDataUIPlugin.INSTANCE
								.getImage("full/ctool16/expandall")));
		this.page = page;
	}

	@Override
	public void run() {
		page.expandAll();
	}
}
