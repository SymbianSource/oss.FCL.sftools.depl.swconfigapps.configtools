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
 * Description: This file is part of com.nokia.tools.variant.confml.ui component.
 */

package com.nokia.tools.variant.confml.ui.properties;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

public class ConfMLResourceSection extends AbstractPropertySection {

	private Composite control;
	private FormToolkit formToolkit;
	
	public ConfMLResourceSection() {
		
	}

	@Override
	public void createControls(Composite parent,
			TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);

		formToolkit = new FormToolkit(parent.getDisplay());
		control = formToolkit.createComposite(parent);
		control.setLayout(new GridLayout());
		Text text = formToolkit.createText(control, "You have selected a ConfML element");
		text.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
	}
	
	@Override
	public void dispose() {
		formToolkit.dispose();
		control.dispose();
		super.dispose();
	}
	
	@Override
	public void refresh() {
		super.refresh();
	}
}
