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
 * Description: This file is part of com.nokia.tools.variant.preview component.
 */

package com.nokia.tools.variant.preview;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;

/**
 * Controller for unsupported content
 */
public class UnsupportedContentController extends PreviewController {

	private Composite topComposite;

	private Label label;

	private UnsupportedContentDescriptor descriptor;

	public UnsupportedContentController() {
	}

	@Override
	public void createControl(Composite parent) {
		topComposite = new Composite(parent, SWT.NONE);
		topComposite.setBackground(ColorConstants.white);
		FormData topData = new FormData();
		topData.left = new FormAttachment(0, 0);
		topData.top = new FormAttachment(0, 0);
		topData.right = new FormAttachment(100, 0);
		topData.bottom = new FormAttachment(100, 0);
		topComposite.setLayoutData(topData);
		topComposite.setLayout(new GridLayout());
		label = new Label(topComposite, SWT.WRAP | SWT.CENTER);
		label.setBackground(topComposite.getBackground());

		topData = new FormData();
		topData.left = new FormAttachment(0, 0);
		topData.top = new FormAttachment(0, 0);
		topData.right = new FormAttachment(100, 0);
		topData.bottom = new FormAttachment(100, 0);
		// label.setLayoutData(topData);
		label.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true));
	}

	@Override
	public void setInput(IPreviewDescriptor desc) {
		this.descriptor = (UnsupportedContentDescriptor) desc;
		if (descriptor != null) {
			String name = descriptor.getName();
			boolean isFile = descriptor.isFile();
			if (isFile) {
				label
						.setText("Preview for selected file \""
								+ name
								+ "\" is not available.\nDouble click on selected file \""
								+ name
								+ "\" in Resources view to launch in external editor.");
			} else {
				label.setText("Preview for selected directory \"" + name
						+ "\" is not available.");
			}
		}
	}

	@Override
	public void dispose() {
		if (topComposite != null && !topComposite.isDisposed()) {
			for (Control child : topComposite.getChildren()) {
				if (child != null && !child.isDisposed()) {
					child.dispose();
					child = null;
				}
			}
			topComposite.dispose();
			topComposite = null;
		}
	}

	@Override
	public Control getControl() {
		return topComposite;
	}
}
