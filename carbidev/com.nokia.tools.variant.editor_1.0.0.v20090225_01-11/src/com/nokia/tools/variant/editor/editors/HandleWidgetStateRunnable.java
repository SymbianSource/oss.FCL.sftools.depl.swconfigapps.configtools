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

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;

import com.nokia.tools.variant.content.confml.Setting;
import com.nokia.tools.variant.editor.model.UISetting;
import com.nokia.tools.variant.navigator.views.NavigatorViewer;
import com.nokia.tools.variant.viewer.viewer.SettingsViewer;

public class HandleWidgetStateRunnable implements Runnable {
	private List<Setting> collapsedElementsFromView;
	private ISelection keepSelection;
	private CPFEditor editor;

	public HandleWidgetStateRunnable(List<Setting> collapsedElementsFromView,
			ISelection keepSelection, CPFEditor editor) {
		this.keepSelection = keepSelection;
		this.collapsedElementsFromView = collapsedElementsFromView;
		this.editor = editor;
	}

	public void run() {

		SettingsViewer settingsViewer = editor.getSettingsViewer();
		settingsViewer.refresh();
		List<Object> newCollapsedElementsList = new ArrayList<Object>();
		for (Setting setting : collapsedElementsFromView) {
			Set<Object> keySet = settingsViewer.getElementToWidgetMap()
					.keySet();
			for (Object object : keySet) {
				if (object instanceof UISetting) {
					UISetting ui = (UISetting) object;
					if (ui.getSetting().equals(setting)) {
						newCollapsedElementsList.add(ui);
					}
				}
			}
		}
		settingsViewer.setCollapsedElements(newCollapsedElementsList);
		Display.getDefault().syncExec(new Runnable() {

			public void run() {

				NavigatorViewer navigatorViewer = editor.getNavigatorViewer();
				ISelection selectionBefore = navigatorViewer.getSelection();
				editor.handleSelectionOnNavigator();
				ISelection selectionAfter = navigatorViewer.getSelection();
				if (selectionAfter.equals(selectionBefore)) {
					ISelection selection = editor
							.convertSelectionToUIModel((IStructuredSelection) keepSelection);
					editor.getSettingsViewer().setSelection(selection);
				}

			}
		});

	}
}
