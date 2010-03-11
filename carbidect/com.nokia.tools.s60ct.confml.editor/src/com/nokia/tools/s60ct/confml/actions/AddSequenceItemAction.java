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
package com.nokia.tools.s60ct.confml.actions;

import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
//import org.eclipse.gef.commands.Command;
//import org.eclipse.gef.commands.CommandStack;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import com.nokia.tools.s60ct.confml.commands.AddSequenceItemCommand;
import com.nokia.tools.s60ct.confml.editor.PluginImages;
import com.nokia.tools.s60ct.confml.widgets.SequenceWidget;
import com.nokia.tools.s60ct.model.confml.ESequenceSetting;
import com.nokia.tools.s60ct.model.confml.ESequenceValue;
import com.nokia.tools.s60ct.model.confml.ESequenceValueItem;
import com.nokia.tools.s60ct.model.confml.ESetting;
import com.nokia.tools.s60ct.model.confml.impl.ESequenceSettingImpl;
import com.nokia.tools.s60ct.model.confml.impl.ESequenceValueItemImpl;
import com.nokia.tools.s60ct.model.confml.presentation.ConfmlEditor;

public class AddSequenceItemAction extends EditorAction {

	// private boolean everySecondEvent = false;

	public AddSequenceItemAction() {
		setText("Add new sequence item");
		setImageDescriptor(PluginImages.ADD);
	}

	@Override
	public void run() {
		// if (everySecondEvent == false) {
		// everySecondEvent = true;
		// return;
		// }
		// everySecondEvent = false;

		IWorkbenchPage page = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage();
		if (page != null) {
			IEditorPart activeEditor = page.getActiveEditor();
			ConfmlEditor editor = null;
			if (activeEditor != null && activeEditor instanceof ConfmlEditor) {
				editor = (ConfmlEditor) activeEditor;
				CommandStack commandStack = editor.getCommandStack();
				ISelection selection = editor.getSelection();
				int position = -1;
				if (selection instanceof StructuredSelection) {
					StructuredSelection structuredSelection = (StructuredSelection) selection;
					Object[] selections = structuredSelection.toArray();
					for (int i = 0; i < selections.length; i++) {
						Object next = selections[i];
						if (next instanceof ESetting) { // WRONG HERE!!!
							ESetting setting = (ESetting) next;
							EObject container = setting.eContainer();
							if (container instanceof ESequenceValueItemImpl) {
								ESequenceSetting si = (ESequenceSetting) setting
										.eContainer();

								ESequenceSetting sqSetting = (ESequenceSetting) si
										.eContainer();
								int index = sqSetting.getSubTypes().indexOf(si);
								if (position < index) {
									position = index;
								}
							}
						}
					}

				}
				Object data = widget.getData();
				((SequenceWidget) widget).setCollapsed(false);
				if (data instanceof ESequenceSettingImpl) {
					ESequenceSettingImpl eSeqSetImpl = (ESequenceSettingImpl) data;
					ESequenceValueItem template = ((ESequenceValue) eSeqSetImpl
							.getDefaultValue()).getTemplate();
					int realPosition = 0;

					if (template == null && eSeqSetImpl.getItems().size() > 0) {
						// template = eSeqSetImpl.getItems().get(0);
						template = ((ESequenceValue) eSeqSetImpl
								.getDefaultValue()).getItems().get(0);
					}
					if (template != null) {
						ESequenceValueItem templateCopy = (ESequenceValueItem) EcoreUtil
								.copy(template);
						templateCopy.setEditable(true);
						URIEditorInput editorInput = (URIEditorInput) editor
								.getEditorInput();
						URI editorUri = editorInput.getURI();
						templateCopy.setFrameLocationUri(URI
								.createURI(editorUri.scheme() + ":"
										+ editorUri.path()));

						realPosition = (position == -1) ? eSeqSetImpl
								.getItems().size() : position + 1;
						Command addCommand = new AddSequenceItemCommand(
								eSeqSetImpl, templateCopy, realPosition);
						commandStack.execute(addCommand);
						final ConfmlEditor finalEditor = editor;
						Display.getCurrent().asyncExec(new Runnable() {

							public void run() {
								finalEditor.getViewer().refresh();
							}

						});
					} else {
						MessageDialog
								.openWarning(widget.getShell(), "Warning",
										"Sequence setting doesn't have tepmlate or any data.");

					}
					/*
					 * 
					 * ESubSettingValue settingToSelect =
					 * eSeqSetImpl.getItems().
					 * get(realPosition).getSubSettings().get(0);
					 * StructuredSelection structuredSelection = new
					 * StructuredSelection( settingToSelect);
					 * editor.setSelection(structuredSelection);
					 */
				}

			}
		}

	}

	@Override
	public void initSelectionListener() {

	}

	
	
}
