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
 * Description: This file is part of com.nokia.tools.variant.common.ui component.
 */

package com.nokia.tools.variant.common.ui.properties;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.internal.views.properties.tabbed.view.TabbedPropertyComposite;
import org.eclipse.ui.internal.views.properties.tabbed.view.TabbedPropertyList;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

@SuppressWarnings("restriction")
public class NoTabControlPropertyPage extends TabbedPropertySheetPage {

	public NoTabControlPropertyPage(
			ITabbedPropertySheetPageContributor tabbedPropertySheetPageContributor) {
		super(tabbedPropertySheetPageContributor);
	}
	
	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);
		
		TabbedPropertyComposite pageComposite = (TabbedPropertyComposite)getControl();
		TabbedPropertyList list = pageComposite.getList();
		Composite leftComposite = list.getParent();
		leftComposite.setVisible(false);
		FormData fd = (FormData)leftComposite.getLayoutData();
		fd.right = new FormAttachment(0);

		ScrolledComposite scrolledComposite = pageComposite.getScrolledComposite();
		scrolledComposite.addControlListener(new ControlAdapter() {
			@Override
			public void controlResized(ControlEvent e) {
				ScrolledComposite sc = (ScrolledComposite)e.widget;
				Rectangle ca = sc.getClientArea();
				Control content = sc.getContent();
				Point size = content.computeSize(ca.width, SWT.DEFAULT, true);
				content.setSize(size);
				sc.setMinSize(size);
			}
		});

		FormData layoutData = (FormData) scrolledComposite.getLayoutData();
		layoutData.left = new FormAttachment(0);
	}
	
}
