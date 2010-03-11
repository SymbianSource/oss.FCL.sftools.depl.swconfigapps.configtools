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
 * Description: This file is part of com.nokia.tools.vct.confml.editor.view component.
 */

package com.nokia.tools.vct.confml.editor.view.properties;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import com.nokia.tools.vct.confml.editor.view.vemodel.EIconContainer;


public class IconContainerSection extends AbstractPropertySection {

	private Control topControl;
	private EIconContainer target;

	private Text locText;
	private Text titleText;

	@Override
	public void createControls(Composite parent,
			TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);
		TabbedPropertySheetWidgetFactory formToolkit = getWidgetFactory();
		 // PixelConverter pixelConverter = new PixelConverter(parent);

		Section section = formToolkit.createSection(parent, Section.TITLE_BAR
				| Section.EXPANDED | Section.TWISTIE);
		section.setText("Icon Information");

		Composite sectionBody = formToolkit.createComposite(section, SWT.NONE);
		sectionBody.setLayout(new GridLayout(3, false));
		section.setClient(sectionBody);

		Label locLabel = formToolkit.createLabel(sectionBody, "Icon URI:");
		locLabel
				.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		locText = formToolkit.createText(sectionBody, "", SWT.BORDER);
		locText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		Button locButton = formToolkit.createButton(sectionBody, "...",
				SWT.FLAT);
		locButton
				.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));

		GridData gd;

		Label titleLabel = formToolkit.createLabel(sectionBody,
				"URI Description:");
		titleLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false,
				false));
		titleText = formToolkit.createText(sectionBody, "", SWT.BORDER);
		gd = new GridData(SWT.FILL, SWT.CENTER, true, false);
		gd.horizontalSpan = 2;
		titleText.setLayoutData(gd);

		updateTargetValues();
		topControl = section;
	}

	private void updateTargetValues() {
		if (target != null) {
			String title = target.getIconUriTitle();
			titleText.setText(title == null ? "" : title);
			String uri = target.getIconUri();
			locText.setText(uri == null ? "" : uri);
			titleText.setEnabled(true);
			locText.setEnabled(true);
		} else {
			titleText.setText("");
			locText.setText("");
			titleText.setEnabled(false);
			locText.setEnabled(false);
		}
	}


	@Override
	public void refresh() {
		super.refresh();
		updateTargetValues();
	}

	@Override
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);

		Object selected = null;
		if (selection instanceof IStructuredSelection) {
			selected = ((IStructuredSelection) selection).getFirstElement();
		}
		if (selected instanceof EIconContainer) {
			target = (EIconContainer)selected;
		} else {
			target = null;
		}

		updateTargetValues();
	}

	@Override
	public void dispose() {

		if (topControl != null) {
			topControl.dispose();
		}

		super.dispose();
	}

}
