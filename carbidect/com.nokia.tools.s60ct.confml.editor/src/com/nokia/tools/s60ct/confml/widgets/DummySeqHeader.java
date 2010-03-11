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
package com.nokia.tools.s60ct.confml.widgets;

import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

public class DummySeqHeader extends BaseConfMLWidget {

	public DummySeqHeader(Composite parent, int style, String widgetLabel) {
		super(parent, style, widgetLabel);
	}

	@Override
	protected void buildMainControl() {

	}

	@Override
	public void clearErrorMessage() {

	}

	@Override
	public String getValue() {
		return null;
	}

	@Override
	public void setValue(String value) {
		
	}


	public void buildWidget(Composite composite, String label,
			Map<String, String> options) {

	}
	
	public void setGrayed(boolean grayed)
	{
	}


}
