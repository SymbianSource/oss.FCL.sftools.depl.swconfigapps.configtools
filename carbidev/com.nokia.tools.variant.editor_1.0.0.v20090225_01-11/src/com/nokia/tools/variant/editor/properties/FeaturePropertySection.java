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
 * Description: This file is part of com.nokia.tools.variant.editor component.
 */

package com.nokia.tools.variant.editor.properties;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import com.nokia.tools.variant.common.ui.properties.AutoSizePropertySection;
import com.nokia.tools.variant.common.ui.properties.fields.StringFieldEditor;
import com.nokia.tools.variant.content.confml.Feature;

public class FeaturePropertySection extends AutoSizePropertySection {

	private Section section;
	private Composite control;
	private Composite mainComposite;

	private StringFieldEditor featureDescription;
	private final String NOT_AVAILABLE = "N/A";
	private Adapter adapter;
	private Feature feature;

	private FormToolkit toolkit;

	private static final int NUM_COLUMNS = 2;

	protected void createSpecificControls(Composite parent,
			TabbedPropertySheetPage tabbedPropertySheetPage) {

		toolkit = new FormToolkit(parent.getDisplay());
		toolkit.setBorderStyle(SWT.NULL);
		control = toolkit.createComposite(parent);
		GridLayout layout = new GridLayout(1, false);
		layout.marginHeight = layout.marginWidth = 0;
		control.setLayout(layout);
		section = toolkit.createSection(control, Section.TITLE_BAR);
		section.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
	}

	@Override
	protected void doRefresh() {
		if (feature != null) {
			feature.eAdapters().remove(adapter);
		}

		// dispose properties of the older selection
		if (mainComposite != null)
			mainComposite.dispose();

		featureDescription = new StringFieldEditor();
		featureDescription.setLabelText("Description: " + NOT_AVAILABLE);
		featureDescription.setEditable(false);

		mainComposite = toolkit.createComposite(control);
		GridData gd = new GridData(SWT.FILL, SWT.TOP, true, false);
		gd.horizontalIndent = 5;
		mainComposite.setLayoutData(gd);
		GridLayout gridLayout = new GridLayout(NUM_COLUMNS, false);
		mainComposite.setLayout(gridLayout);

		IStructuredSelection selection = (IStructuredSelection) getSelection();
		Object firstElement = null;
		if (selection != null) {
			firstElement = selection.getFirstElement();
		}
		if (firstElement instanceof Feature) {
			feature = (Feature) firstElement;

			if (feature.getName() != null)
				section.setText(feature.getName());

			if (getTextWithoutSpecialChars(feature.getDescription()) != null) {

				Text text = toolkit.createText(mainComposite,
						getTextWithoutSpecialChars(feature.getDescription()),
						SWT.MULTI | SWT.WRAP | SWT.FLAT);
				text.setEditable(false);
				GridData textData = new GridData(SWT.FILL, SWT.TOP, true,
						false, NUM_COLUMNS, 1);
				text.setLayoutData(textData);

			} else {
				featureDescription.setLabelText("Description: ");
				featureDescription.setTextValue(NOT_AVAILABLE);
				featureDescription.fillIntoGrid(mainComposite, NUM_COLUMNS,
						toolkit);
			}
		}
	}

	private String getTextWithoutSpecialChars(String input) {
		String result = input;
		if (input != null) {
			result = result.replaceAll("[' ']+", " ");
			result = result.replaceAll("\t+", "");
			result = result.replaceAll("\n+", "\n");
			result = result.replaceAll("\n ", "\n");
			return result;
		} else
			return null;
	}

	@Override
	public void dispose() {
		if (control != null) {
			control.dispose();
		}
		super.dispose();
	}

}
