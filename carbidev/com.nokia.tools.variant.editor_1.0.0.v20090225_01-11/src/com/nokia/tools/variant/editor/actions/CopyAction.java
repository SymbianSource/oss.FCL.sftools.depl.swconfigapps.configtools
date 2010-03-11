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

import java.util.Map;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import com.nokia.tools.variant.common.ui.properties.fields.StringFieldEditor;
import com.nokia.tools.variant.editor.editors.CPFEditor;
import com.nokia.tools.variant.viewer.viewer.SettingsViewer;
import com.nokia.tools.variant.viewer.widgets.BaseConfMLWidget;

/**
 * Action serves to copy text from editor widgets as in standard text editing.
 */
public class CopyAction extends Action {

	private CPFEditor editor;
	private IWorkbenchWindow window;
	private Object control;

	/**
	 * 
	 * @param editor
	 */
	public CopyAction(CPFEditor editor) {
		this.editor = editor;
		window = editor.getSite().getPage().getWorkbenchWindow();
	}

	/**
	 * 
	 * @param window
	 */
	public CopyAction(IWorkbenchWindow window) {
		this.window = window;
	}

	/**
	 * 
	 * @param control
	 */
	public CopyAction(Object control) {
		this.control = control;
		this.window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
	}

	public void init() {

		this.setId("copy");
		this.setAccelerator(SWT.CTRL + 'C');
		// this.setEnabled(false);
		this.setText("Copy");
		this.setToolTipText("Copy");

		this.setActionDefinitionId("org.eclipse.ui.edit.copy");
		ISharedImages sharedImages = window.getWorkbench().getSharedImages();
		this.setImageDescriptor(sharedImages
				.getImageDescriptor(ISharedImages.IMG_TOOL_COPY));
		this.setDisabledImageDescriptor(sharedImages
				.getImageDescriptor(ISharedImages.IMG_TOOL_COPY_DISABLED));
	}

	@Override
	public void run() {

		if (editor != null) {

			SettingsViewer settingsViewer = editor.getSettingsViewer();
			if (settingsViewer == null) {
				return;
			}
			ISelection selection = settingsViewer.getSelection();

			if (selection.isEmpty()) {
				if (editor.getSc().isFocused()) {
					Text text = editor.getSc().getAutocmpleteText().getText();					
					text.copy();
					text.update();
				}
				return;			
			}

			if (selection instanceof StructuredSelection) {
				StructuredSelection structuredSelection = (StructuredSelection) selection;
				Map<Object, Composite> elementToWidgetMap = settingsViewer
						.getElementToWidgetMap();
				Composite composite = elementToWidgetMap
						.get(structuredSelection.getFirstElement());

				if (composite instanceof BaseConfMLWidget) {
					BaseConfMLWidget baseConfMLWidget = (BaseConfMLWidget) composite;
					baseConfMLWidget.copy();
				}
			}
		} else {

			if (control != null) {

				if (control instanceof StringFieldEditor) {
					((StringFieldEditor) control).copy();

				} else if (control instanceof Text) {
					((Text) control).copy();
				}
			}
		}
	}
}
