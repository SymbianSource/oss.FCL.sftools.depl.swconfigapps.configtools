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
 * Description: This file is part of com.nokia.tools.variant.carbidev component.
 */

package com.nokia.tools.variant.carbidev.perspective.actions;

import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.internal.ResetPerspectiveAction;

import com.nokia.tools.variant.views.actions.registry.ViewActionRegistry;

/**
 * Reset the layout within the active perspective.
 *
 */
@SuppressWarnings("restriction")
public class CarbideVResetPerspectiveAction extends ResetPerspectiveAction {
	
	public CarbideVResetPerspectiveAction() {
		super();
	}
	
	public CarbideVResetPerspectiveAction(IWorkbenchWindow window) {
		super(window);
	}
	
	@Override
	protected void run(IWorkbenchPage page, IPerspectiveDescriptor persp) {
		
		super.run(page, persp);

		ViewActionRegistry viewActionRegistry = ViewActionRegistry.getInstance();
		viewActionRegistry.setActionsAsChecked();
		
	}
	
}
