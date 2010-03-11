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
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import com.nokia.tools.variant.confml.ui.properties.fields.StringFieldEditor;
import com.nokia.tools.vct.common.appmodel.EAppSetting;
import com.nokia.tools.vct.common.appmodel.EAppSettingType;

public class SettingTypeSection extends AbstractPropertySection {

	private Section control;
	private EAppSetting appSetting;
	private StringFieldEditor featureId;
	private StringFieldEditor featureName;
	private StringFieldEditor featureDescription;
	private StringFieldEditor layerInfo;
	private StringFieldEditor fileInfo;

	public SettingTypeSection() {
		featureId = new StringFieldEditor();
		featureId.setLabelText("Id");
		featureId.setEditable(false);
		featureName= new StringFieldEditor();
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
			Object top = ((IStructuredSelection)selection).getFirstElement();
			if (top instanceof EAppSetting) {
				appSetting = (EAppSetting)top;
			} else {
				appSetting = null;
			}
		}
		
		refresh();
	}
	
	@Override
	public void refresh() {
		super.refresh();
		
		TransactionalEditingDomain domain = appSetting == null ? null : TransactionUtil.getEditingDomain(appSetting);

		if (appSetting == null || domain == null) {
			featureId.setTextValue("");
			featureName.setTextValue("");
			featureDescription.setTextValue("");
			layerInfo.setTextValue("");
			fileInfo.setTextValue("");
		} else {
			try {
				TransactionUtil.runExclusive(domain, new RunnableWithResult.Impl<Void>() {
					public void run() {
						EAppSettingType type = appSetting.getTypeInfo();
						featureId.setTextValue(maskNull(appSetting.getRef()));
						featureName.setTextValue(maskNull(type.getName()));
						featureDescription.setTextValue(maskNull(type.getDescription()));
					}
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
		super.createControls(parent, tabbedPropertySheetPage);

		TabbedPropertySheetWidgetFactory factory =  getWidgetFactory();
		
		control = factory.createSection(parent, Section.TITLE_BAR);
		control.setText("Setting Type Information (read only)");
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
