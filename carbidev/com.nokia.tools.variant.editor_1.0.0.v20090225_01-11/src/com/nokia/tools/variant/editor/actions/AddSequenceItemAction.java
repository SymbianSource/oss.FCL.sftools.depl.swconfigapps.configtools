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
 * Description: This file is part of com.nokia.tools.variant.editor component.
 */

package com.nokia.tools.variant.editor.actions;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import com.nokia.tools.variant.content.confml.SequenceItem;
import com.nokia.tools.variant.content.confml.SequenceSetting;
import com.nokia.tools.variant.content.confml.Setting;
import com.nokia.tools.variant.editor.commands.AddSequenceItemCommand;
import com.nokia.tools.variant.editor.editors.CPFEditor;
import com.nokia.tools.variant.editor.editors.PluginImages;
import com.nokia.tools.variant.editor.model.UISetting;
import com.nokia.tools.variant.viewer.actions.EditorAction;
import com.nokia.tools.variant.viewer.widgets.SequenceWidget;

/**
 * Action creates new sequence item, according to template, default data, or
 * setting item declaration. Item is added to position of selected item or at
 * the end of the sequence.
 */
public class AddSequenceItemAction extends EditorAction {

	/**
	 * Constructor creates label and image for the action. 
	 */
	public AddSequenceItemAction() {
		setText("Add new sequence item");
		setImageDescriptor(PluginImages.ADD);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {

		IWorkbenchPage page = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage();
		if (page != null) {
			IEditorPart activeEditor = page.getActiveEditor();
			CPFEditor editor = null;
			if (activeEditor != null && activeEditor instanceof CPFEditor) {
				editor = (CPFEditor) activeEditor;
				CommandStack commandStack = editor.getCommandStack();
				ISelection selection = editor.getSelection();
				int position = -1;
				if (selection instanceof StructuredSelection) {
					StructuredSelection structuredSelection = (StructuredSelection) selection;
					Object[] selections = structuredSelection.toArray();
					for (int i = 0; i < selections.length; i++) {
						Object next = selections[i];
						if (next instanceof Setting) {
							Setting setting = (Setting) next;
							EObject container = setting.eContainer();
							if (container instanceof SequenceItem) {
								SequenceItem si = (SequenceItem) setting
										.eContainer();

								SequenceSetting sqSetting = (SequenceSetting) si
										.eContainer();
								int index = sqSetting.getSequenceItem()
										.indexOf(si);
								if (position < index) {
									position = index;
								}
							}
						}
					}

				}
				Object data = widget.getData();
				((SequenceWidget) widget).setCollapsed(false);
				if (data instanceof UISetting) {
					UISetting uiSetting = (UISetting) data;
					Setting setting = uiSetting.getSetting();
					int realPosition = 0;
					if (setting instanceof SequenceSetting) {
						SequenceSetting ss = (SequenceSetting) setting;
						SequenceItem template = ss.getTemplate();
						if (template == null && ss.getSequenceItem().size() > 0) {
							template = ss.getSequenceItem().get(0);
						}
						if (template == null
								&& ss.getDefaultStructure().size() > 0) {
							template = ss.getDefaultStructure().get(0);
						}
						if (template != null) {
							SequenceItem copy = (SequenceItem) EcoreUtil
									.copy(template);

							realPosition = (position == -1) ? ss
									.getSequenceItem().size() : position + 1;
							Command addCommand = new AddSequenceItemCommand(ss,
									copy, realPosition);
							commandStack.execute(addCommand);
						} else {
							MessageDialog
									.openWarning(widget.getShell(), "Warning",
											"Sequence setting doesn't have tepmlate or any data.");

						}
						Setting settingToSelect = ss.getSequenceItem().get(
								realPosition).getSetting().get(0);
						StructuredSelection structuredSelection = new StructuredSelection(
								settingToSelect);
						editor.setSelection(structuredSelection);
					}
				}
			}

		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.nokia.tools.variant.viewer.actions.EditorAction#initSelectionListener()
	 */
	@Override
	public void initSelectionListener() {
		// do nothing
	}

}
