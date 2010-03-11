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
package com.nokia.tools.variant.editor.commands;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import com.nokia.tools.variant.content.confml.SequenceItem;
import com.nokia.tools.variant.content.confml.Setting;

public class SelectionCompoundCommand extends CompoundCommand implements
		ISelectionCommand {

	private Object model;

	public SelectionCompoundCommand(Object model) {
		this.model = model;
	}

	public boolean isSelectionOK() {

		ISelectionProvider provider = getEditor();
		if (provider != null) {
			IStructuredSelection selection = (IStructuredSelection) provider
					.getSelection();
			List<?> list = selection.toList();
			List<?> model2 = (List<?>) getModel();

			if (!selection.isEmpty()) {
				for (Object object : model2) {
					if (!list.contains(object)) {
						if (object instanceof Setting) {
							Setting setting = (Setting) object;
							EObject container = setting.eContainer();
							if (container == null) {
								continue;
							}
							if (container instanceof SequenceItem
									&& container.eContainer() == null) {
								continue;
							}
						}
						return false;
					}
				}
				for (Object object : list) {
					if (!model2.contains(object)) {
						return false;
					}
				}
				return true;
			} else {
				return false;
			}
		}

		return true;
	}

	public void select() {
		ISelectionProvider provider = getEditor();
		if (provider != null) {
			List<?> model2 = (List<?>) getModel();
			StructuredSelection selection = new StructuredSelection(model2);
			provider.setSelection(selection);
		}
	}

	private Object getModel() {
		return model;

	}

	private ISelectionProvider getEditor() {
		IWorkbenchPage activePage = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage();
		if (activePage != null) {

			IEditorPart activeEditor = activePage.getActiveEditor();
			if (activeEditor instanceof ISelectionProvider) {
				return (ISelectionProvider) activeEditor;
			}
		}
		return null;
	}
}
