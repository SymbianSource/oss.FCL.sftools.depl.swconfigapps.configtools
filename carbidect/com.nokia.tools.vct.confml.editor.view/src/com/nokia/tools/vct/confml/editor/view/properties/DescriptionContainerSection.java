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
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import com.nokia.tools.variant.confml.ui.properties.fields.StringFieldEditor;
import com.nokia.tools.vct.common.ui.utils.PixelConverter;
import com.nokia.tools.vct.confml.editor.view.vemodel.EDescriptionContainer;

public class DescriptionContainerSection extends AbstractPropertySection{
	
	private FormToolkit formToolkit;
	private PixelConverter pixelConverter;
	private Control topControl;
	private Text textText;
	private Text titleText;
	private Text locText;
	private EDescriptionContainer target;

	private final StringFieldEditor uriField; 
	private final StringFieldEditor titleField; 
	private final StringFieldEditor textField; 
	
	public DescriptionContainerSection() {
		uriField = new StringFieldEditor();
		titleField = new StringFieldEditor();
		textField = new StringFieldEditor(SWT.MULTI | SWT.BORDER);
		uriField.setLabelText("URI:");
		titleField.setLabelText("Title:");
		textField.setLabelText("Text:");
	}
	
	@Override
	public void createControls(Composite parent,
			TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);
		formToolkit = new FormToolkit(parent.getDisplay());
		pixelConverter = new PixelConverter(parent);
		
		Section section = formToolkit.createSection(parent, Section.TITLE_BAR | Section.EXPANDED | Section.TWISTIE);
		section.setText("Description Info");

		Composite sectionBody = formToolkit.createComposite(section, SWT.NONE);
		sectionBody.setLayout(new GridLayout(3, false));
		section.setClient(sectionBody);

		textField.fillIntoGrid(sectionBody, 3, formToolkit);
		uriField.fillIntoGrid(sectionBody, 3, formToolkit);
		titleField.fillIntoGrid(sectionBody, 3, formToolkit);
		
		Label locLabel = formToolkit.createLabel(sectionBody, "Description URI:");
		locLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		locText = formToolkit.createText(sectionBody, "", SWT.BORDER);
		locText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		Button locButton = formToolkit.createButton(sectionBody, "...", SWT.FLAT);
		locButton.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		
		GridData gd;
		
		Label titleLabel = formToolkit.createLabel(sectionBody, "URI Title:");
		titleLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		titleText = formToolkit.createText(sectionBody, "", SWT.BORDER);
		gd = new GridData(SWT.FILL, SWT.CENTER, true, false);
		gd.horizontalSpan = 2;
		titleText.setLayoutData(gd);
		
		Label textLabel = formToolkit.createLabel(sectionBody, "Description Text:");
		textLabel.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false));
		textText = formToolkit.createText(sectionBody, "", SWT.BORDER | SWT.MULTI);
		gd = new GridData(SWT.FILL, SWT.TOP, true, true);
		gd.horizontalSpan = 2;
		gd.minimumHeight = pixelConverter.convertHeightInCharsToPixels(4);
		textText.setLayoutData(gd);

		topControl = section;
	}
	

	@Override
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);

		Object selected = null;
		if (selection instanceof IStructuredSelection) {
			selected = ((IStructuredSelection) selection).getFirstElement();
		}
		if (selected instanceof EDescriptionContainer) {
			target = (EDescriptionContainer)selected;
		} else {
			target = null;
		}

		updateTargetValues();
	}

	@Override
	public void refresh() {
		super.refresh();
		updateTargetValues();
	}

	private void updateTargetValues() {
		if (target != null) {
			String title = target.getDescriptionUriTitle();
			titleText.setText(title == null ? "" : title);
			String uri = target.getDescriptionUri();
			locText.setText(uri == null ? "" : uri);
			String desc = target.getDescriptionText();
			textText.setText(desc == null ? "" : desc);
			titleText.setEnabled(true);
			locText.setEnabled(true);
			textText.setEnabled(true);
		} else {
			titleText.setText("");
			locText.setText("");
			textText.setText("");
			titleText.setEnabled(false);
			locText.setEnabled(false);
			textText.setEnabled(false);
		}
	}


	@Override
	public void dispose() {
		if (formToolkit != null) {
			formToolkit.dispose();
		}
		if (topControl != null) {
			topControl.dispose();
		}
		super.dispose();
	}
}
