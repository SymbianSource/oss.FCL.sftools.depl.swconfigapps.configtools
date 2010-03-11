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

package com.nokia.tools.variant.editor.editors;

import java.io.File;

import org.eclipse.gef.commands.CommandStack;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

import com.nokia.tools.variant.editor.commands.ChangeMetadataValueCommand;
import com.nokia.tools.variant.editor.model.summaryModel.SUMMARYTYPE;
import com.nokia.tools.variant.editor.model.summaryModel.UIElement;
import com.nokia.tools.variant.editor.model.summaryModel.UISummaryGroup;
import com.nokia.tools.variant.editor.model.summaryModel.UISummaryModel;
import com.nokia.tools.variant.resourcelibrary.model.ResourceModelRoot;
import com.nokia.tools.variant.viewer.validation.EResult;
import com.nokia.tools.variant.viewer.validation.ValidationResult;
import com.nokia.tools.variant.viewer.viewer.IValuesContentProvider;

/**
 * The provider is used to map between UISummaryModel and the internal list
 * structure of viewer. It has similar function as EditorViewerContentProvider,
 * but method isDefault() always returns true because we don’t support default
 * and non default values for summary elements.
 */
public class SummaryViewerContentProvider implements IValuesContentProvider {
	private CommandStack stack;
	private CPFEditor editor;

	public SummaryViewerContentProvider(CommandStack stack, CPFEditor editor) {
		this.stack = stack;
		this.editor = editor;
	}

	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof UISummaryGroup) {
			return ((UISummaryGroup) parentElement).getUiElements().toArray();
		}
		return new Object[] {};
	}

	public Object getParent(Object element) {

		return null;
	}

	public boolean hasChildren(Object element) {

		return getChildren(element).length > 0;
	}

	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof UISummaryModel) {
			return ((UISummaryModel) inputElement).getUiGroups().toArray();
		}
		return null;
	}

	public void dispose() {

	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

	}

	public String getValue(Object element) {
		if (element instanceof UIElement) {
			if (((UIElement) element).getType().equals(
					SUMMARYTYPE.PRODUCTIMAGES)) {
				String s = "";
				ResourceModelRoot productImagesRoot = editor
						.getViewEditorModel().getProductImagesRoot();
				if (productImagesRoot != null
						&& productImagesRoot.getTempDirPath() != null) {
					File tempDir = new File(productImagesRoot.getTempDirPath());
					File[] listFiles = tempDir.listFiles();
					if (listFiles != null) {
						for (File file : listFiles) {
							s += file.getAbsolutePath() + ">";
						}
					}
					return s;
				}
			} else if (((UIElement) element).getType().equals(
					SUMMARYTYPE.GUIDELINE)) {
				CPFEditor editor;
				IEditorPart activeEditor = PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getActivePage()
						.getActiveEditor();
				if (activeEditor instanceof CPFEditor)
					editor = (CPFEditor) activeEditor;
				else
					return "";

				ResourceModelRoot guidelinesRoot = editor.getViewEditorModel()
						.getGuidelinesRoot();
				if (guidelinesRoot != null
						&& guidelinesRoot.getTempDirPath() != null) {
					return guidelinesRoot.getTempDirPath();
				}

			}
			return ((UIElement) element).getValue();

		}
		return null;
	}

	public void valueChanged(String newValue, Object element) {
		if (element instanceof UIElement) {
			UIElement uiElement = (UIElement) element;

			ChangeMetadataValueCommand changeSettingValueCommand = new ChangeMetadataValueCommand(
					newValue, uiElement);
			stack.execute(changeSettingValueCommand);
		}

	}

	public ValidationResult validate(String value, Object element) {
		return new ValidationResult(EResult.VALID);
	}

	public boolean isDirty(Object element) {
		
		if (element instanceof UIElement) {
			return ((UIElement) element).isDirty();
		}
		return false;
	}

	public void contributeToToolBar(IToolBarManager manager, Object element) {
		

	}

	public DropTargetListener getDropTargetListener(Object child) {
		
		return null;
	}

	public boolean hasNote(Object element) {
		if (element instanceof UIElement) {
			UIElement uiElement = (UIElement) element;
			if (uiElement != null) {
				String note = uiElement.getNote();
				if (note != null && !note.equals("")) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean isDefault(Object element) {
		
		return true;
	}

	public DragSourceListener getDragSourceListener(Object data) {
		
		return null;
	}

}
