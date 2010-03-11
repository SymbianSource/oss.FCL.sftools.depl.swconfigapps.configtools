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

import static com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorPackage.Literals.ESETTING_REF__LENGTH;
import static com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorPackage.Literals.ESETTING_REF__MAX_EXCLUSIVE;
import static com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorPackage.Literals.ESETTING_REF__MAX_INCLUSIVE;
import static com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorPackage.Literals.ESETTING_REF__MAX_LENGTH;
import static com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorPackage.Literals.ESETTING_REF__MIN_EXCLUSIVE;
import static com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorPackage.Literals.ESETTING_REF__MIN_INCLUSIVE;
import static com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorPackage.Literals.ESETTING_REF__MIN_LENGTH;

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
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import com.nokia.tools.vct.confml.editor.view.commands.SetFeatureCommand;
import com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef;

public class ConstraintsSection extends AbstractPropertySection {

	private Section control;
	private boolean refreshFlag;
	private ESettingRef ref;

	private Text minInclusiveText;
	private Text maxInclusiveText;
	private Text minExclusiveText;
	private Text maxExclusiveText;
	private Text lengthText;
	private Text maxLengthText;
	private Text minLengthText;

	// private Text patternsText;

	// private Adapter adapter = new Adapter() {
	//
	// public Notifier getTarget() {
	//			
	// return null;
	// }
	//
	// public boolean isAdapterForType(Object type) {
	//			
	// return false;
	// }
	//
	// public void notifyChanged(Notification notification) {
	// if (refreshFlag) {
	// return;
	// }
	// if (featureIdText.isDisposed()) {
	// if (ref != null) {
	// ref.eAdapters().remove(adapter);
	// }
	// return;
	// }
	// String featureId = ref.getFeatureId();
	// String settingId = ref.getSettingId();
	// if (!featureIdText.getText().equals(featureId)) {
	// featureIdText.setText(featureId);
	// }
	// if (!settingIdText.getText().equals(settingId)) {
	// settingIdText.setText(settingId);
	// }
	//
	// }
	//
	// public void setTarget(Notifier newTarget) {
	//			
	//
	// }
	//
	// };

	public ConstraintsSection() {

	}

	@Override
	public void createControls(Composite parent,
			TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);

		TabbedPropertySheetWidgetFactory formToolkit = getWidgetFactory();
		control = formToolkit.createSection(parent, Section.TITLE_BAR);
		control.setText("Setting Reference");
		Composite content = formToolkit.createComposite(control, SWT.NONE);
		content.setLayout(new GridLayout(2, false));
		control.setClient(content);

		Group lengthGroup = new Group(content, SWT.NONE);
		lengthGroup.setText("Length Constraints");
		lengthGroup.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false,
				2, 1));
		lengthGroup.setLayout(new GridLayout(2, false));
		formToolkit.adapt(lengthGroup);

		formToolkit.paintBordersFor(lengthGroup);
		
		lengthText = createNamedField(formToolkit, lengthGroup, "Length:",
				ESETTING_REF__LENGTH);
		maxLengthText = createNamedField(formToolkit, lengthGroup,
				"Max Length:", ESETTING_REF__MAX_LENGTH);
		minLengthText = createNamedField(formToolkit, lengthGroup,
				"Min Length:", ESETTING_REF__MIN_LENGTH);

		Group minMaxGroup = new Group(content, SWT.NONE);
		formToolkit.paintBordersFor(minMaxGroup);
		minMaxGroup.setText("Value Constraints");
		minMaxGroup.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false,
				2, 1));
		minMaxGroup.setLayout(new GridLayout(2, false));
		formToolkit.adapt(minMaxGroup);
		minInclusiveText = createNamedField(formToolkit, minMaxGroup,
				"Min Inclusive:", ESETTING_REF__MIN_INCLUSIVE);
		minExclusiveText = createNamedField(formToolkit, minMaxGroup,
				"Min Exclusive:", ESETTING_REF__MIN_EXCLUSIVE);
		maxInclusiveText = createNamedField(formToolkit, minMaxGroup,
				"Max Inclusive:", ESETTING_REF__MAX_INCLUSIVE);
		maxExclusiveText = createNamedField(formToolkit, minMaxGroup,
				"Max Exclusive:", ESETTING_REF__MAX_EXCLUSIVE);

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
		// if (ref != null) {
		// ref.eAdapters().remove(adapter);
		// }
		super.dispose();
	}

	@Override
	public void refresh() {
		refreshFlag = true;
		try {
			updateTextField(lengthText);
			updateTextField(minLengthText);
			updateTextField(maxLengthText);
			updateTextField(minInclusiveText);
			updateTextField(maxInclusiveText);
			updateTextField(minExclusiveText);
			updateTextField(maxExclusiveText);
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
			// ref.eAdapters().remove(adapter);
			ref = null;
		}

		if (selection instanceof IStructuredSelection) {
			IStructuredSelection s = (IStructuredSelection) selection;
			Object firstElement = s.getFirstElement();
			if (firstElement instanceof ESettingRef) {
				ref = (ESettingRef) firstElement;
				// ref.eAdapters().add(adapter);
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
