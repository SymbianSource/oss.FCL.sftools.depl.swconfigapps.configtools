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
package com.nokia.tools.s60ct.confml.editor.properties;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import com.nokia.tools.s60ct.model.confml.EFeature;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.LayoutUtil;
public class FeaturePropertySection extends TabControlPropertySection {
	private Section control;

	private StringFieldEditor featureDescription;
	private final String NOT_AVAILABLE = "N/A";
	private Adapter adapter;
	private EFeature feature;

	public FeaturePropertySection() {

	}

	@Override
	public void createControls(Composite parent,
			TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.setRemoveTabs(true);
		super.createControls(parent, tabbedPropertySheetPage);
	}

	private Composite mainComposite;
	private FormToolkit factory;
	private FormToolkit toolkit;
	private Composite content;
	private GridLayout gridLayout;
	private GridData gd;

	// private Composite topComposite;
	protected void createSpecificControls(Composite parent,
			TabbedPropertySheetPage tabbedPropertySheetPage) {
		parent.setLayoutData(new GridData(GridData.FILL_BOTH));

		factory = getWidgetFactory();
		factory.setBorderStyle(SWT.FLAT);

		toolkit = new FormToolkit(parent.getDisplay());
		control = toolkit.createSection(parent, Section.TITLE_BAR);
		content = toolkit.createComposite(control);
		control.setClient(content);
		content.setLayout(new GridLayout(1, false));

		// GridLayout and griddata for mainComposite
		gridLayout = new GridLayout(3, false);
		gridLayout.marginWidth = 0;
		gd = new GridData();
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalAlignment = GridData.FILL;

		featureDescription = new StringFieldEditor(SWT.MULTI | SWT.WRAP);
		featureDescription.setLabelText("Description: " + NOT_AVAILABLE);
		featureDescription.setEditable(false);

	}

	@Override
	public void refresh() {
		if (feature != null) {
			feature.eAdapters().remove(adapter);
		}

		// dispose properties of the older selection
		if (mainComposite != null)
			mainComposite.dispose();

		mainComposite = toolkit.createComposite(content);
		mainComposite.setLayout(gridLayout);
		mainComposite.setLayoutData(gd);

		IStructuredSelection selection = (IStructuredSelection) getSelection();
		Object firstElement = null;
		if (selection != null) {
			firstElement = selection.getFirstElement();
		}
		if (firstElement instanceof EFeature) {
			feature = (EFeature) firstElement;

			if (feature.getName() != null)
				control.setText(feature.getName());

			// common properties for all types of settings
			if (getTextWithoutSpecialChars(feature.getDescriptionText()) != null) {
				featureDescription.fillIntoGrid(mainComposite, 3, factory);
				LayoutUtil.setHorizontalSpan(featureDescription
						.getTextControl(), 3);
				featureDescription
						.setTextValue(getTextWithoutSpecialChars(feature
								.getDescriptionText()));
				featureDescription.setLabelText("");
			} else {
				featureDescription.setLabelText("Description: ");
				featureDescription.setTextValue(NOT_AVAILABLE);
				featureDescription.fillIntoGrid(mainComposite, 3, factory);
			}

		}
		control.getParent().getParent().layout(true, true);
		super.refresh();
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

//	private String maskNull(String value) {
//		if (value == null) {
//			return NOT_AVAILABLE;
//		}
//		return value;
//	}

	@Override
	public void dispose() {
		if (control != null) {
			control.dispose();
		}
		super.dispose();
	}

}
