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

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.ui.actions.ActionContext;
import org.eclipse.ui.actions.ActionGroup;

public class KeyActions extends ActionGroup {

	public KeyActions() {
	}

	@Override
	public void setContext(ActionContext context) {
		super.setContext(context);
	}

	@Override
	public void fillContextMenu(IMenuManager menu) {
		StructuredViewer viewer = (StructuredViewer) getContext().getInput();

		menu.add(new SetAsDefaultAction(viewer));
		menu.add(new Separator());
		menu.add(new GenerateKeysAction());
		menu.add(new DeleteKeysAction(viewer));
		menu.add(new Separator());
		menu.add(new ExportKeysAction(viewer));
		menu.add(new ImportKeysAction(viewer));
		menu.add(new Separator());
		menu.add(new SelectAllKeysAction(viewer));
	}

}
