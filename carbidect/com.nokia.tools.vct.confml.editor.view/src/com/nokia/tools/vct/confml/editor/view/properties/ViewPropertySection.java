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

import java.util.Map;

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
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import com.nokia.tools.vct.common.ui.utils.PixelConverter;
import com.nokia.tools.vct.confml.editor.view.ViewsEditor;
import com.nokia.tools.vct.confml.editor.view.commands.SetDescriptionTextCommand;
import com.nokia.tools.vct.confml.editor.view.commands.SetViewIdCommand;
import com.nokia.tools.vct.confml.editor.view.commands.SetViewNameCommand;
import com.nokia.tools.vct.confml.editor.view.vemodel.EView;
import com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewEntryImpl;

public class ViewPropertySection extends AbstractPropertySection {

	public ViewPropertySection() {

	}

	private Composite control;
	private EView ref;
	private Text descriptionText;
	private Text nameText;
//	private Adapter adapter = new Adapter() {
//
//		public Notifier getTarget() {
//
//			return null;
//		}
//
//		public boolean isAdapterForType(Object type) {
//
//			return false;
//		}
//
//		public void notifyChanged(Notification notification) {
//			if (descriptionText.isDisposed()) {
//				if (ref != null) {
//					ref.eAdapters().remove(adapter);
//				}
//				return;
//			}
//			String desc = ref.getDescriptionText();
//			String name = ref.getName();
//			String id = (String) ((Map.Entry<?, ?>)ref.eContainer()).getKey();
//			if (!descriptionText.getText().equals(desc) && desc != null) {
//				descriptionText.setText(desc);
//			}
//			if (!nameText.getText().equals(name) && name != null) {
//				nameText.setText(name);
//			}
//			if (!idText.getText().equals(id) && id != null) {
//				idText.setText(id);
//			}
//
//		}
//
//		public void setTarget(Notifier newTarget) {
//
//		}
//
//	};
	private Text idText;

	@Override
	public void createControls(Composite parent,
			TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);

		PixelConverter converter = new PixelConverter(parent);
		TabbedPropertySheetWidgetFactory formToolkit = getWidgetFactory();
		Section section = formToolkit.createSection(parent, Section.TITLE_BAR);
		section.setText("View Properties");
		GridData gd = new GridData(SWT.FILL, SWT.TOP, true, false);

		Composite sectionBody = formToolkit.createComposite(section);
		section.setClient(sectionBody);
		sectionBody.setLayout(new GridLayout(2, false));

		Label idLabel = formToolkit.createLabel(sectionBody, "Id");
		idLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		idText = formToolkit.createText(sectionBody, "");
		idText.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

		Label nameLabel = formToolkit.createLabel(sectionBody, "Name");
		nameLabel
				.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		nameText = formToolkit.createText(sectionBody, "");
		nameText.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

		Label descriptionLabel = formToolkit.createLabel(sectionBody,
				"Description");
		descriptionLabel.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false,
				false));
		descriptionText = formToolkit.createText(sectionBody, "", SWT.MULTI);
		gd = new GridData(SWT.FILL, SWT.TOP, true, true);
		gd.minimumHeight = converter.convertHeightInCharsToPixels(4);
		descriptionText.setLayoutData(gd);

		descriptionText.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				if (ref != null
						&& !descriptionText.getText().trim().equals(
								ref.getDescriptionText())) {
					SetDescriptionTextCommand command = new SetDescriptionTextCommand(
							ref, descriptionText.getText());
					execute(command);
				}

			}
		});
		nameText.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				if (ref != null
						&& !nameText.getText().trim().equals(ref.getName())) {
					SetViewNameCommand command = new SetViewNameCommand(ref,
							nameText.getText()); 
					execute(command);
				}

			}
		});

		idText.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				String id = "";

				if (ref.eContainer() instanceof EView)
					id = ((EView)ref.eContainer()).getId();

				else if (ref.eContainer() instanceof EViewEntryImpl)
					id = (String) ((Map.Entry<?, ?>)ref.eContainer()).getKey();
				
				if (ref != null && !idText.getText().trim().equals(id)) {
					SetViewIdCommand command = new SetViewIdCommand(ref, idText
							.getText());
					execute(command);
				}

			}
		});

		control = section;
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
		if (ref != null) {
			String description = ref.getDescriptionText();
			String id = null;
			if (ref.eContainer() instanceof EView)
				id = ((EView)ref.eContainer()).getId();
			else if (ref.eContainer() instanceof EViewEntryImpl)
				id = (String) ((Map.Entry<?, ?>)ref.eContainer()).getKey();
			if (id != null) {
				idText.setText(id);
			}
			if (description != null) {
				descriptionText.setText(description);
			}
			nameText.setText(ref.getName());
		}
		super.refresh();
	}

	@Override
	public void aboutToBeHidden() {

		super.aboutToBeHidden();
	}

	@Override
	public void aboutToBeShown() {

		super.aboutToBeShown();
	}

	@Override
	public void setInput(IWorkbenchPart part, ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection s = (IStructuredSelection) selection;
			Object firstElement = s.getFirstElement();
			if (firstElement instanceof EView) {
//				if (ref != null) {
//					ref.eAdapters().remove(adapter);
//				}
				ref = (EView) firstElement;
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
		IWorkbenchPage activePage = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage();
		if (activePage != null) {
			IEditorPart activeEditor = activePage.getActiveEditor();
			if (activeEditor instanceof ViewsEditor) {
				return ((ViewsEditor) activeEditor).getCommandStack();
			}
		}
		return null;
	}
}
