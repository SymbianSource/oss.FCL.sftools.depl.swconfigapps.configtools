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

import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Layout;

/**
 * 
 * @author hajduivo
 *
 */
public class RulerComposite extends Composite {
	private RulerCompositeLayout layout;

	public RulerComposite(Composite parent, int style) {
		super(parent, style);
		layout = new RulerCompositeLayout(this, style);
		super.setLayout(layout);
		layout(true, true);
	}


	public Composite getRuler() {
		return layout.getRuler();
	}

	public ScrolledComposite getScrolledComposite() {
		return layout.getEditor();
	}

	public void setContent(Control content) {
		layout.getEditor().setContent(content);
	}
	
	
	@Override
	public void setLayout(Layout layout) {
		checkWidget();
		return;
	}
}
