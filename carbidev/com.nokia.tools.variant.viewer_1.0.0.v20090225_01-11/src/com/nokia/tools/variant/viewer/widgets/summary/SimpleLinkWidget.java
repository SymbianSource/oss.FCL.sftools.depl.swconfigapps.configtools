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
 * Description: This file is part of com.nokia.tools.variant.viewer component.
 */

package com.nokia.tools.variant.viewer.widgets.summary;

import java.util.Map;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Listener;
import com.nokia.tools.variant.viewer.widgets.BaseConfMLWidget;


/**
 * It represents UI component which displayes input text value as link. 
 * 
 */
public class SimpleLinkWidget extends BaseConfMLWidget{

	protected Composite control;
	protected Link link;
	protected String linkValue = "<...>";
	
	public SimpleLinkWidget(Composite parent, int style, String widgetLabel, Image image) {
		super(parent, style, widgetLabel, image);
	}

	@Override
	protected void buildMainControl() {
		control = new Composite(group, SWT.NONE);
		control.setBackground(group.getBackground());
		GridLayout gridLayout = new GridLayout(1,false);
		control.setLayout(gridLayout);
		control.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		link = new Link(control, SWT.NONE);
		String value = linkValue;
		if (value == null) {
			value = "<...>";
		}
		link.setText("<A>"+value.replace("<","&lt;")+"</A>");
		link.setBackground(group.getBackground());
	}

	@Override
	public void clearErrorMessage() {
		
		
	}
	
	@Override
	protected void drawDeselectUI() {
		super.drawDeselectUI();
		control.setBackground(group.getBackground());
		for (Control cnt: control.getChildren()) {
			cnt.setBackground(group.getBackground());
		}
	}

	@Override
	protected void drawSelectUI() {
		super.drawSelectUI();
		control.setBackground(group.getBackground());
		for (Control cnt: control.getChildren()) {
			cnt.setBackground(group.getBackground());
		}
	}
	
	@Override
	public void addListener(Listener listener) {
		super.addListener(listener);
		for (Control cnt: control.getChildren()) {
			cnt.addListener(SWT.Selection, listener);
			cnt.addListener(SWT.MouseDown, listener);
		}
	}

	@Override
	public String getValue() {
		return linkValue;
	}

	@Override
	public void setValue(String value) {
		linkValue = value == null ? "<...>" : value;
		if (link != null && !link.isDisposed()) {
			link.setText("<A>"+linkValue.replace("<","&lt;")+"</A>");
		}
	}

	public void buildWidget(Composite composite, String label,
			Map<String, String> options) {
		
		
	}
}
