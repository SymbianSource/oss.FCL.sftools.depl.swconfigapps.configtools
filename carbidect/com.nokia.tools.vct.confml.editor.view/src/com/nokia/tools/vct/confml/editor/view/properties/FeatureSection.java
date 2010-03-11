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

import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import com.nokia.tools.variant.confml.ui.properties.TabControlPropertySection;
import com.nokia.tools.variant.confml.ui.properties.fields.StringFieldEditor;
import com.nokia.tools.vct.confml.editor.view.vemodel.EFeature;
import com.nokia.tools.vct.confml.editor.view.vemodel.util.ConverterUtils;

/**
 * Section for the View Editor feature element
 * 
 */
public class FeatureSection extends TabControlPropertySection {

	private Section control;
	private EFeature appFeature;
	private StringFieldEditor featureId;
	private StringFieldEditor featureName;
	private StringFieldEditor featureDescription;
	private StringFieldEditor layerInfo;
	private StringFieldEditor fileInfo;

	public FeatureSection() {
		featureId = new StringFieldEditor();
		featureId.setLabelText("Id");
		featureId.setEditable(false);
		featureName = new StringFieldEditor();
		featureName.setLabelText("Name");
		featureName.setEditable(false);
		featureDescription = new StringFieldEditor(SWT.MULTI);
		featureDescription.setLabelText("Description");
		featureDescription.setEditable(false);
		layerInfo = new StringFieldEditor();
		layerInfo.setLabelText("Contributed by");
		layerInfo.setEditable(false);
		fileInfo = new StringFieldEditor();
		fileInfo.setLabelText("Location");
		fileInfo.setEditable(false);
	}

	@Override
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);
		if (selection instanceof IStructuredSelection) {
			Object top = ((IStructuredSelection) selection).getFirstElement();
			if (top instanceof EFeature) {
				appFeature = (EFeature) top;
			} else {
				appFeature = null;
			}
		}

		refresh();
	}

	@Override
	public void refresh() {
		super.refresh();

		TransactionalEditingDomain domain = appFeature == null ? null
				: TransactionUtil.getEditingDomain(appFeature);

		if (appFeature == null || domain == null) {
			featureId.setTextValue("");
			featureName.setTextValue("");
			featureDescription.setTextValue("");
			layerInfo.setTextValue("");
			fileInfo.setTextValue("");
		} else {
			try {
				TransactionUtil.runExclusive(domain,
						new RunnableWithResult.Impl<Void>() {
							public void run() {
								featureId.setTextValue(maskNull(ConverterUtils
										.getFeatureId(appFeature)));
								featureName.setTextValue(maskNull(appFeature
										.getName()));
								featureDescription
										.setTextValue(maskNull(appFeature
												.getDescriptionText()));

//
//								if (contributor != null) {
//									ELayerMetadata meta = contributor
//											.getConfiguration();
//									String layerId = meta.getId() + "."
//											+ meta.getVersion();
//									layerInfo.setTextValue(layerId);
//								} else {
									layerInfo.setTextValue("unknown");
//								}
								fileInfo.setTextValue("unknown");
							};
						});
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	private String maskNull(String value) {
		return value == null ? "" : value;
	}

	@Override
	public void createControls(Composite parent,
			TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.setRemoveTabs(true);
		super.createControls(parent, tabbedPropertySheetPage);
	}
	
	public void createSpecificControls(Composite parent,
			TabbedPropertySheetPage tabbedPropertySheetPage) {

		TabbedPropertySheetWidgetFactory factory = getWidgetFactory();

		control = factory.createSection(parent, Section.TITLE_BAR);
		control.setText("Feature Type Information (read only)");
		Composite content = factory.createComposite(control);
		control.setClient(content);
		content.setLayout(new GridLayout(3, false));

		featureId.fillIntoGrid(content, 3, factory);
		featureName.fillIntoGrid(content, 3, factory);
		featureDescription.fillIntoGrid(content, 3, factory);
		layerInfo.fillIntoGrid(content, 3, factory);
		fileInfo.fillIntoGrid(content, 3, factory);
	}

	@Override
	public void dispose() {
		if (control != null) {
			control.dispose();
		}
		super.dispose();
	}
}
