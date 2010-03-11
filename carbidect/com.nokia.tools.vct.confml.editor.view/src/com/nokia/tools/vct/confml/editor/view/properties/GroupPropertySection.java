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

import java.util.Observable;
import java.util.Observer;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import com.nokia.tools.variant.confml.core.ConfMLCore;
import com.nokia.tools.variant.confml.ui.dialogs.IconSelectionDialog;
import com.nokia.tools.variant.confml.ui.properties.fields.FieldEditor;
import com.nokia.tools.variant.confml.ui.properties.fields.IStringButtonAdapter;
import com.nokia.tools.variant.confml.ui.properties.fields.StringButtonFieldEditor;
import com.nokia.tools.variant.confml.ui.properties.fields.StringFieldEditor;
import com.nokia.tools.vct.common.appmodel.EConfMLLayer;
import com.nokia.tools.vct.confml.editor.view.commands.SetDescriptionTextCommand;
import com.nokia.tools.vct.confml.editor.view.commands.SetGroupNameCommand;
import com.nokia.tools.vct.confml.editor.view.commands.SetIconURICommand;
import com.nokia.tools.vct.confml.editor.view.vemodel.EGroup;
import com.nokia.tools.vct.confml.editor.view.viewers.ViewTreeViewer;

public class GroupPropertySection extends AbstractPropertySection {

	public GroupPropertySection() {
		descriptionField = new StringFieldEditor(SWT.MULTI);
		descriptionField.setLabelText("Description");
		nameField = new StringFieldEditor();
		nameField.setLabelText("Name");
		imageField = new StringButtonFieldEditor();
		imageField.setLabelText("Icon URI");
		imageField.setButtonText("...");
	}

	private Section control;
	private boolean refreshFlag;
	private EGroup ref;
	private boolean isGroupWithIcon = false;

	private StringFieldEditor descriptionField;
	private StringFieldEditor nameField;
	private StringButtonFieldEditor imageField;

//	private Adapter adapter = new AdapterImpl() {
//
//		public void notifyChanged(Notification notification) {
//			if (refreshFlag) {
//				return;
//			}
//
//			if (control.isDisposed()) {
//				if (ref != null) {
//					ref.eAdapters().remove(adapter);
//				}
//				return;
//			}
//
//			String description = maskNull(ref.getDescriptionText());
//			String name = maskNull(ref.getName());
//			URI iconURI = ref.getIconUri();
//			String uriText = iconURI == null ? "" : iconURI.toASCIIString();
//
//			if (!descriptionField.getTextValue().equals(description)) {
//				descriptionField.setTextValue(description);
//			}
//			if (!nameField.getTextValue().equals(name)) {
//				nameField.setTextValue(name);
//			}
//			if (!imageField.getTextValue().equals(uriText)) {
//				imageField.setTextValue(uriText);
//			}
//
//		}
//
//	};

	@Override
	public void createControls(Composite parent,
			TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);

		TabbedPropertySheetWidgetFactory formToolkit = getWidgetFactory();
		control = formToolkit.createSection(parent, Section.TITLE_BAR);
		control.setText("View Group Properties");
		// control.setLayout(new GridLayout(2, false));

		Composite content = formToolkit.createComposite(control);
		control.setClient(content);
		content.setLayout(new GridLayout(3, false));

		nameField.fillIntoGrid(content, 3, formToolkit);
		descriptionField.fillIntoGrid(content, 3, formToolkit);
		imageField.fillIntoGrid(content, 3, formToolkit);
		imageField.getTextControl().setEditable(false);

		descriptionField.addObserver(new Observer() {
			public void update(Observable o, Object arg) {
				if (refreshFlag) {
					return;
				}

				String fieldValue = unmaskNull(descriptionField.getTextValue());
				if (ref.getDescriptionText() != null
						&& ref.getDescriptionText().equals(fieldValue)
						|| ref.getDescriptionText() == null && fieldValue == null) {
					return;
				}
				refreshFlag = true;
				try {
					SetDescriptionTextCommand command = new SetDescriptionTextCommand(
							ref, fieldValue);
					execute(command);
				} finally {
					refreshFlag = false;
				}
			}
		});
		nameField.addObserver(new Observer() {
			public void update(Observable o, Object arg) {
				if (refreshFlag) {
					return;
				}

				String fieldValue = unmaskNull(nameField.getTextValue());
				if (ref.getName() != null && ref.getName().equals(fieldValue)
						|| ref.getName() == null && fieldValue == null) {
					return;
				}
				refreshFlag = true;
				try {
					ViewTreeViewer viewer = (ViewTreeViewer) getPart()
							.getAdapter(ViewTreeViewer.class);
					SetGroupNameCommand command = new SetGroupNameCommand(
							viewer, ref, fieldValue);
					execute(command);
				} finally {
					refreshFlag = false;
				}
			}
		});
		imageField.addObserver(new Observer() {
			public void update(Observable o, Object arg) {
				if (refreshFlag) {
					return;
				}

				String fieldValue = unmaskNull(imageField.getTextValue());
				String iconURI = ref.getIconUri();

				if (iconURI != null && iconURI.equals(fieldValue)
						|| ref.getIconUri() == null && fieldValue == null) {
					return;
				}

				refreshFlag = true;
				try {

					SetIconURICommand command = new SetIconURICommand(ref, fieldValue);
					execute(command);
				} finally {
					refreshFlag = false;
				}
			}
		});
		imageField.setButtonAdapter(new IStringButtonAdapter() {
			public void changeControlPressed(FieldEditor source) {
				// super.widgetSelected(e);
				Shell shell = Display.getCurrent().getActiveShell();
				ElementTreeSelectionDialog dialog = new IconSelectionDialog(
						shell);

				Resource resource = ref.eResource();
				URI uri = resource.getURI();
				if (!uri.isPlatformResource()) {
					return;
				}
				IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(uri.toPlatformString(true)));
				EConfMLLayer layer = ConfMLCore.getLayer(file);
				if (layer == null) {
					return;
				}
				dialog.setInput(layer);
				URI initial = URI.createURI(imageField.getTextValue().trim());
				dialog.setInitialSelection(initial);
				
				if (dialog.open() == ElementTreeSelectionDialog.OK) {
					URI result = (URI) dialog.getFirstResult();
					imageField.setTextValue(result.toString());
				}
			}
		});
	}

	@Override
	public void dispose() {

		if (control != null) {
			control.dispose();
		}

//		if (ref != null) {
//			ref.eAdapters().remove(adapter);
//		}
		super.dispose();
	}

	@Override
	public void refresh() {
		refreshFlag = true;
		try {
			if (ref != null) {
				nameField.setTextValue(maskNull(ref.getName()));
				descriptionField.setTextValue(maskNull(ref.getDescriptionText()));
				String uri = ref.getIconUri() == null ? "" : ref.getIconUri();
				imageField.setTextValue(uri);
				imageField.getButtonControl().setEnabled(isGroupWithIcon);
			} else {
				nameField.setTextValue("");
				descriptionField.setTextValue("");
				imageField.setTextValue("");
			}
		} finally {
			refreshFlag = false;
		}
		super.refresh();
	}

	private String maskNull(String value) {
		return value == null ? "" : value;
	}

	private String unmaskNull(String value) {
		String trim = value.trim();
		return trim.length() == 0 ? null : trim;
	}

	@Override
	public void setInput(IWorkbenchPart part, ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection s = (IStructuredSelection) selection;
			Object firstElement = s.getFirstElement();
			if (firstElement instanceof EGroup) {
//				if (ref != null) {
//					ref.eAdapters().remove(adapter);
//				}
				ref = (EGroup) firstElement;
				if (ref.eContainer() instanceof EGroup) {
					isGroupWithIcon = false;
				} else {
					isGroupWithIcon = true;
				}
//				ref.eAdapters().add(adapter);
			}
		}
		super.setInput(part, selection);
	}

	private void execute(Command command) {
		CommandStack stack = getStack();
		if (stack != null) {
			stack.execute(command);
		}
	}

	private CommandStack getStack() {
		CommandStack stack = (CommandStack) getPart().getAdapter(
				CommandStack.class);
		return stack;
	}
}
