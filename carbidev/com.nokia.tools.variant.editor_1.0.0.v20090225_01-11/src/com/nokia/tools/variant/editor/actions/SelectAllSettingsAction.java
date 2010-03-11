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

import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import com.nokia.tools.variant.editor.Activator;
import com.nokia.tools.variant.editor.editors.CPFEditor;
import com.nokia.tools.variant.editor.model.summaryModel.UISummaryModel;
import com.nokia.tools.variant.viewer.viewer.SettingsViewer;

/**
 * Action selects all widgets in
 * <code>com.nokia.tools.variant.editor.editors.CPFEditor</code>
 */
public class SelectAllSettingsAction extends Action {

	public static final String ID = "com.nokia.tools.variant.editor.SelectAllSettingsAction";

	private IWorkbenchWindow window;

	private int numberOfSelectedSettings;
	private static SelectAllSettingsAction INSTANCE = null;

	public static SelectAllSettingsAction getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new SelectAllSettingsAction();
		}
		return INSTANCE;

	}

	private SelectAllSettingsAction() {
	}

	public void init(IWorkbenchWindow window) {
		this.window = window;
		ISelectionService selectionService = window.getSelectionService();
		selectionService.addSelectionListener(selectionChangeListener);
		setActionDefinitionId("com.nokia.tools.variant.editor.selectAll");
	}

	@Override
	public void run() {
		IEditorPart activeEditor = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if (activeEditor instanceof CPFEditor) {
			CPFEditor cpfEditor = (CPFEditor) activeEditor;
			SettingsViewer settingsViewer = cpfEditor.getSettingsViewer();
			setNumberOfSelectedSettings(settingsViewer.selectAll());
			enable(false);
		}
	}

	@Override
	public String getText() {
		return "Select all settings";
	}

	@Override
	public String getId() {
		return "Select all settings";
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		if (super.getImageDescriptor() == null) {
			setImageDescriptor(Activator
					.getImageDescriptor("icons/select_all_16.png"));
		}
		ImageDescriptor imageDescriptor = super.getImageDescriptor();
		return imageDescriptor;
	}

	private void enable(boolean enableState) {
		if (enableState != isEnabled()) {
			if (enableState) {
				setEnabled(false);
				setEnabled(true);
			} else {
				setEnabled(true);
				setEnabled(false);
			}
		}
	}

	public void dispose() {
		ISelectionService selectionService = window.getSelectionService();
		selectionService.removeSelectionListener(selectionChangeListener);
	}

	private ISelectionListener selectionChangeListener = new ISelectionListener() {

		public void selectionChanged(IWorkbenchPart part, ISelection selection) {
			if (selection instanceof IStructuredSelection) {
				IStructuredSelection ss = (IStructuredSelection) selection;
				IWorkbenchPage page = window.getActivePage();
				if (page != null) {
					IEditorPart activeEditor = page.getActiveEditor();
					if (!(activeEditor instanceof CPFEditor)) {
						return;
					}

					// get current CPF editor
					CPFEditor cpfEditor = (CPFEditor) activeEditor;

					SettingsViewer sv = cpfEditor.getSettingsViewer();
					Object input = sv.getInput();
					if (input == null) {
						return;
					}
					if (input instanceof UISummaryModel) {
						enable(false);
						return;
					}
					if (ss.size() == getNumberOfSelectedSettings()) {
						setNumberOfSelectedSettings(0);
						enable(false);
					} else {
						enable(true);
					}
				} else {
					enable(false);
				}
			}
		}

	};

	public int getNumberOfSelectedSettings() {
		return numberOfSelectedSettings;
	}

	public void setNumberOfSelectedSettings(int numberOfSelectedSettings) {
		this.numberOfSelectedSettings = numberOfSelectedSettings;
	}
}
