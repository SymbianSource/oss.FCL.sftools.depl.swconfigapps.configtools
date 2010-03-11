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


public class CollapseAllAction extends Action {

	private AbstractTreeViewer viewer;

	public CollapseAllAction(AbstractTreeViewer viewer) {
		super(ImportDataUIPlugin.INSTANCE.getString("_UI_Collapse_All_label"), ExtendedImageRegistry.INSTANCE
				.getImageDescriptor(ImportDataUIPlugin.INSTANCE
						.getImage("full/ctool16/collapseall")));
		this.viewer = viewer;
	}

	@Override
	public void run() {
		viewer.collapseAll();
	}
}
