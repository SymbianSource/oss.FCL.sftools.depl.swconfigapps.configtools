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

import static com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorPackage.Literals.EREF_OPTION__MAP;
import static com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorPackage.Literals.EREF_OPTION__NAME;
import static com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorPackage.Literals.EREF_OPTION__RELEVANT;
import static com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorPackage.Literals.EREF_OPTION__VALUE;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import com.nokia.tools.vct.confml.editor.view.commands.SetFeatureCommand;
import com.nokia.tools.vct.confml.editor.view.vemodel.ERefOption;

public class RefOptionSection extends AbstractPropertySection {

	private Section control;
	private boolean refreshFlag;
	private ERefOption ref;

	private Text nameText;
	private Text unitText;
	private Text relevantText;
	private Text valueText;


	public RefOptionSection() {

	}

	@Override
	public void createControls(Composite parent,
			TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);

		TabbedPropertySheetWidgetFactory formToolkit = getWidgetFactory();
		
		control = formToolkit.createSection(parent, Section.TITLE_BAR);
		control.setText("Option Override");
		Composite content = formToolkit.createComposite(control, SWT.NONE);
		content.setLayout(new GridLayout(2, false));
		control.setClient(content);

		nameText = createNamedField(formToolkit, content, "Name:",
				EREF_OPTION__NAME);
		unitText = createNamedField(formToolkit, content,
				"Map:", EREF_OPTION__MAP);
		relevantText = createNamedField(formToolkit, content,
				"Relevant:", EREF_OPTION__RELEVANT);
		valueText = createNamedField(formToolkit, content,
				"Value:", EREF_OPTION__VALUE);


	}

	private Text createNamedField(TabbedPropertySheetWidgetFactory formToolkit,
			Composite parent, String label, final EStructuralFeature feature) {
		Label lengthLabel = formToolkit.createLabel(parent, label);
		lengthLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false,
				false));
		final Text text = formToolkit.createText(parent, "");
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		text.setData("FEATURE", feature);
		text.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				if (refreshFlag) {
					return;
				}
				refreshFlag = true;
				try {
					String newValue = text.getText().trim();

					if (ref != null && !newValue.equals(ref.eGet(feature))) {
						SetFeatureCommand cmd = new SetFeatureCommand(ref,
								feature, newValue) {
						};

						execute(cmd);
					}
				} finally {
					refreshFlag = false;
				}
			}
		});

		return text;
	}

	@Override
	public void dispose() {
		if (control != null) {
			control.dispose();
		}
		super.dispose();
	}

	@Override
	public void refresh() {
		refreshFlag = true;
		try {
			updateTextField(nameText);
			updateTextField(valueText);
			updateTextField(unitText);
			updateTextField(relevantText);
		} finally {
			refreshFlag = false;
		}
		super.refresh();
	}

	private void updateTextField(Text text) {

		if (ref == null) {
			text.setText("");
		} else {
			EStructuralFeature feature = (EStructuralFeature) text
					.getData("FEATURE");
			Object value = ref.eGet(feature);
			text.setText(value == null ? "" : String.valueOf(value));
		}

	}

	@Override
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);
		if (ref != null) {
			ref = null;
		}

		if (selection instanceof IStructuredSelection) {
			IStructuredSelection s = (IStructuredSelection) selection;
			Object firstElement = s.getFirstElement();
			if (firstElement instanceof ERefOption) {
				ref = (ERefOption) firstElement;
			}

		}
	}

	private void execute(Command command) {
		CommandStack stack = getStack();
		if (stack != null) {
			stack.execute(command);
		}
	}

	private CommandStack getStack() {
		return (CommandStack) getPart().getAdapter(CommandStack.class);
	}
}
