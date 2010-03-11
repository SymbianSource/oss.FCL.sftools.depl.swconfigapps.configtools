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
package com.nokia.s60ct.cenrep.gui.view;

import org.eclipse.ui.IWorkbenchPart;

import views.DescriptionView;
import views.OptionView;

public class CustomPropertySheet extends org.eclipse.ui.views.properties.PropertySheet
{
	@Override
	public void partActivated(IWorkbenchPart part) {
		if (part instanceof AccessView || //disables property sheet for these views
			part instanceof DescriptionView ||
			part instanceof OptionView)
			return;
		super.partActivated(part);
	}
}
