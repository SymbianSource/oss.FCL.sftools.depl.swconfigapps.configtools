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
 * Description: This file is part of com.nokia.tools.vct.navigator.layer component.
 */

package com.nokia.tools.vct.navigator.layer;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.actions.ActionContext;
import org.eclipse.ui.internal.navigator.CommonViewerSiteIViewSiteDelegate;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonActionConstants;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;

import com.nokia.tools.vct.navigator.layer.actions.DoubleClickAction;

public class VariantActionProvider extends CommonActionProvider {
	private DoubleClickAction doubleClickAction;
	private ICommonActionExtensionSite site;
	public VariantActionProvider() {}

	@Override
	public void init(ICommonActionExtensionSite site) {
		super.init(site);
		doubleClickAction = new DoubleClickAction();
		this.site = site;
	}

	@Override
	public void fillActionBars(IActionBars actionBars) {
		super.fillActionBars(actionBars);
		actionBars.setGlobalActionHandler(ICommonActionConstants.OPEN, doubleClickAction);
	}


	@Override
	public void setContext(ActionContext context) {
		super.setContext(context);
		//Shell shell = getActionSite().getStructuredViewer().getControl().getShell();
		//shell.setFocus();
		IWorkbenchPart part = ((CommonViewerSiteIViewSiteDelegate)getActionSite().getViewSite()).getPart();
		part.setFocus();
	}


	
}
