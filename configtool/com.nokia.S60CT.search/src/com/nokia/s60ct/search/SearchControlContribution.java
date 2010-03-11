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
package com.nokia.s60ct.search;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.menus.WorkbenchWindowControlContribution;

import com.nokia.s60ct.search.gui.SearchPane;

public class SearchControlContribution extends
		WorkbenchWindowControlContribution {

	public SearchControlContribution() {
	}

	public SearchControlContribution(String id) {
		super(id);
	}

	@Override
	protected Control createControl(Composite parent) {
		return (new SearchPane(parent)).getControl();
	}

}
