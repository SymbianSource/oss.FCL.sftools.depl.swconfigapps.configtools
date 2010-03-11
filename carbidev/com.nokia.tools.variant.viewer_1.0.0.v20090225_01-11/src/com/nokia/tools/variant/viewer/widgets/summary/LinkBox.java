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

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.eclipse.core.commands.ExecutionException;
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
 * It represents UI component. Input of the component is directory path. The component loads list of files in the direcotry
 * and gets their paths which display as link. The user can click on this link and the file is opened in external application.
 *
 */
public class LinkBox extends BaseConfMLWidget {

	private List<Control> container;
	private String value;
	private Composite control;

	public LinkBox(Composite parent, int style, String widgetLabel, Image image) {
		super(parent, style, widgetLabel, image);

	}

	@Override
	protected void buildMainControl() {
		control = new Composite(group, SWT.NONE);
		control.setBackground(group.getBackground());
		GridLayout gridLayout = new GridLayout(1, false);

		control.setLayout(gridLayout);
		control.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		container = new ArrayList<Control>();
		container.add(control);

		if (value != null) {
			File tempDir = new File(value);
			File[] listFiles = tempDir.listFiles();

			Link link;
			for (File file : listFiles) {
				link = new Link(control, SWT.NONE);
				link.setText("<A>" + file.getName() + "</A>");
				link.addListener(SWT.MouseDown, new ShowView(file));
				link.setBackground(group.getBackground());
				container.add(link);
			}
		}
	}

	@Override
	public void clearErrorMessage() {

	}

	@Override
	protected void drawDeselectUI() {
		super.drawDeselectUI();
		for (Control control : container) {
			control.setBackground(group.getBackground());
		}
	}

	@Override
	protected void drawSelectUI() {
		super.drawSelectUI();
		for (Control control : container) {
			control.setBackground(group.getBackground());
		}
	}

	@Override
	public void addListener(Listener listener) {
		super.addListener(listener);
		for (Control control : container) {

			control.addListener(SWT.MouseDown, listener);
		}
	}

	@Override
	public String getValue() {

		return value;
	}

	@Override
	public void setValue(String value) {

		this.value = value;

		if (value != null) {
			File tempDir = new File(value);
			File[] listFiles = tempDir.listFiles();
			if (listFiles != null) {
				Link link;
				for (File file : listFiles) {
					link = new Link(control, SWT.NONE);
					link.setText("<A>" + file.getName() + "</A>");
					link.addListener(SWT.MouseDown, new ShowView(file));
					link.setBackground(group.getBackground());
					container.add(link);
				}
			}
		}
	}

	public void buildWidget(Composite composite, String label,
			Map<String, String> options) {

	}

	private class ShowView implements Listener {
		File file;

		public ShowView(File file) {
			this.file = file;
		}

		public void handleEvent(Event event) {
			OpenExternalViewerHandler handle = new OpenExternalViewerHandler();
			try {
				handle.execute(file, group.getShell());
			} catch (ExecutionException e) {
				e.printStackTrace();
			}

		}

	}

	@Override
	protected GridData layoutDataForLabel(int width) {
		GridData gridData = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING
				| GridData.VERTICAL_ALIGN_BEGINNING);
		gridData.widthHint = width;
		return gridData;
	}
}
