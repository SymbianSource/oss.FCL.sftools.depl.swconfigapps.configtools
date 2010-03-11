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
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import com.nokia.tools.variant.confml.ui.properties.TabControlPropertySection;
import com.nokia.tools.variant.confml.ui.properties.fields.StringFieldEditor;
import com.nokia.tools.vct.confml.editor.view.vemodel.ESetting;
import com.nokia.tools.vct.confml.editor.view.vemodel.util.ConverterUtils;

/**
 * Section for VE setting element
 * 
 */
public class SettingSection extends TabControlPropertySection {

	private Section control;
	private ESetting appSetting;
	private StringFieldEditor settingId;
	private StringFieldEditor settingName;
	private StringFieldEditor layerInfo;
	private StringFieldEditor fileInfo;

	private StringFieldEditor settingDescription;
	private StringFieldEditor readOnly;
	private StringFieldEditor range;
	private StringFieldEditor notes;

	public SettingSection() {
		settingId = new StringFieldEditor(SWT.WRAP);
		settingId.setLabelText("Id:");
		settingId.setEditable(false);
		settingName = new StringFieldEditor(SWT.WRAP);
		settingName.setLabelText("Name:");
		settingName.setEditable(false);

		settingDescription = new StringFieldEditor(SWT.MULTI | SWT.WRAP);
		settingDescription.setLabelText("Description:");
		settingDescription.setEditable(false);
		readOnly = new StringFieldEditor(SWT.WRAP);
		readOnly.setLabelText("ReadOnly:");
		readOnly.setEditable(false);
		range = new StringFieldEditor(SWT.WRAP);
		range.setLabelText("Range:");
		range.setEditable(false);
		notes = new StringFieldEditor(SWT.MULTI | SWT.WRAP);
		notes.setLabelText("Notes:");
		notes.setEditable(false);

		layerInfo = new StringFieldEditor(SWT.WRAP);
		layerInfo.setLabelText("Contributed by:");
		layerInfo.setEditable(false);
		fileInfo = new StringFieldEditor(SWT.WRAP);
		fileInfo.setLabelText("Location:");
		fileInfo.setEditable(false);
	}

	@Override
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);
		if (selection instanceof IStructuredSelection) {
			Object top = ((IStructuredSelection) selection).getFirstElement();
			if (top instanceof ESetting) {
				appSetting = (ESetting) top;
			} else {
				appSetting = null;
			}
		}

		refresh();
	}

	@Override
	public void refresh() {
		super.refresh();

		TransactionalEditingDomain domain = appSetting == null ? null
				: TransactionUtil.getEditingDomain(appSetting);

		if (appSetting == null || domain == null) {
			settingId.setTextValue("");
			settingName.setTextValue("");
			layerInfo.setTextValue("");
			fileInfo.setTextValue("");

			settingDescription.setTextValue("");
			readOnly.setTextValue("");
			range.setTextValue("N/A");
			notes.setTextValue("");
		} else {
			try {
				TransactionUtil.runExclusive(domain,
						new RunnableWithResult.Impl<Void>() {
							public void run() {
								settingId.setTextValue(maskNull(ConverterUtils
										.getSettingId(appSetting)));
								settingName.setTextValue(maskNull(appSetting
										.getName()));

								control.setText(settingName.getTextValue());

								settingDescription
										.setTextValue(maskNull(appSetting
												.getDescriptionText()));
								readOnly.setTextValue(Boolean.toString(appSetting.isReadOnly()));
								range.setTextValue("N/A");
								notes.setTextValue("");

								layerInfo.setTextValue("unknown");
								fileInfo.setTextValue("unknown");
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
		super.setRemoveTabs(true);
		super.createControls(parent, tabbedPropertySheetPage);
	}

	protected void createSpecificControls(Composite parent,
			TabbedPropertySheetPage tabbedPropertySheetPage) {

		FormToolkit factory = getWidgetFactory();

		control = factory.createSection(parent, Section.TITLE_BAR);
		control.setText("Setting Type Information (read only)");
		Composite content = factory.createComposite(control);
		control.setClient(content);
		content.setLayout(new GridLayout(3, false));

		settingId.fillIntoGrid(content, 3, factory);
		settingName.fillIntoGrid(content, 3, factory);
		settingDescription.fillIntoGrid(content, 3, factory);
		readOnly.fillIntoGrid(content, 3, factory);
		range.fillIntoGrid(content, 3, factory);
		notes.fillIntoGrid(content, 3, factory);

		// layerInfo.fillIntoGrid(content, 3, factory);
		// fileInfo.fillIntoGrid(content, 3, factory);
	}

	@Override
	public void dispose() {
		if (control != null) {
			control.dispose();
		}
		super.dispose();
	}
}
