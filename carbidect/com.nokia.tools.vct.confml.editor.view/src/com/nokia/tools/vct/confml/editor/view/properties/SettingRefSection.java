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

import static com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorPackage.Literals.EDESCRIPTION_CONTAINER__DESCRIPTION_TEXT;
import static com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorPackage.Literals.ESETTING_REF__NAME;

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

import com.nokia.tools.variant.confml.ui.properties.fields.LabelFieldEditor;
import com.nokia.tools.vct.confml.editor.view.commands.SetFeatureCommand;
import com.nokia.tools.vct.confml.editor.view.commands.SetFeatureIdCommand;
import com.nokia.tools.vct.confml.editor.view.commands.SetSettingIdCommand;
import com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef;

public class SettingRefSection extends AbstractPropertySection {

	private Section control;
	private boolean refreshFlag;
	private ESettingRef ref;
	private Text featureIdText;
	private Text settingIdText;
	private Text nameText;
	private Text descriptionText;

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

	public SettingRefSection() {

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

		Label featureIdLabel = formToolkit.createLabel(content, "Feature ID:");
		featureIdLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false,
				false));
		featureIdText = formToolkit.createText(content, "");
		featureIdText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false));
		Label settingIdLabel = formToolkit.createLabel(content, "Setting ID:");
		settingIdLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false,
				false));
		settingIdText = formToolkit.createText(content, "");
		settingIdText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false));
		nameText = createNamedField(formToolkit, content, "Name Override:",
				ESETTING_REF__NAME);
		descriptionText = createMultiNamedField(formToolkit, content,
				"Description Override:",
				EDESCRIPTION_CONTAINER__DESCRIPTION_TEXT);

		
		
		featureIdText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				if (refreshFlag) {
					return;
				}
				refreshFlag = true;
				try {
					if (ref != null
							&& !featureIdText.getText().trim().equals(
									ref.getFeatureId())) {
						SetFeatureIdCommand command = new SetFeatureIdCommand(
								ref, featureIdText.getText());
						execute(command);
					}
				} finally {
					refreshFlag = false;
				}
			}
		});
		settingIdText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				if (refreshFlag) {
					return;
				}
				refreshFlag = true;
				try {

					if (ref != null
							&& !settingIdText.getText().trim().equals(
									ref.getSettingId())) {
						SetSettingIdCommand command = new SetSettingIdCommand(
								ref, settingIdText.getText());
						execute(command);
					}
				} finally {
					refreshFlag = false;
				}
			}
		});

	}

	
	private Text createMultiNamedField(TabbedPropertySheetWidgetFactory formToolkit,
			Composite parent, String label, final EStructuralFeature feature) {
		Label lengthLabel = formToolkit.createLabel(parent, label);
		lengthLabel.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false,false));
		
		final Text text = new Text(parent, SWT.MULTI | SWT.BORDER_SOLID | SWT.WRAP);
		GridData layoutData = new GridData(GridData.FILL_BOTH);
		layoutData.grabExcessVerticalSpace = true;
		layoutData.heightHint = 60;
		text.setLayoutData(layoutData);
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

	
	
	private Text createNamedField(TabbedPropertySheetWidgetFactory formToolkit,
			Composite parent, String label, final EStructuralFeature feature) {
		Label lengthLabel = formToolkit.createLabel(parent, label);
		lengthLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false,false));
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
			if (ref != null) {
				featureIdText.setText(ref.getFeatureId());
				settingIdText.setText(ref.getSettingId());
			} else {
				featureIdText.setText("");
				settingIdText.setText("");
			}
			updateTextField(nameText);
			updateTextField(descriptionText);
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
