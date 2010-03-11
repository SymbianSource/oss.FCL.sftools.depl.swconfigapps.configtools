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

package com.nokia.tools.variant.editor.listeners;

import org.eclipse.emf.common.util.EList;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;

import com.nokia.tools.variant.content.confml.Group;
import com.nokia.tools.variant.content.confml.LeafGroup;
import com.nokia.tools.variant.content.confml.ParentGroup;
import com.nokia.tools.variant.editor.editors.CPFEditor;
import com.nokia.tools.variant.editor.editors.EditorViewerContentProvider;
import com.nokia.tools.variant.editor.editors.EditorViewerLabelProvider;
import com.nokia.tools.variant.editor.editors.SummaryViewerContentProvider;
import com.nokia.tools.variant.editor.editors.SummaryViewerLabelProvider;
import com.nokia.tools.variant.editor.model.UIModel;
import com.nokia.tools.variant.editor.model.summaryModel.UISummaryModel;
import com.nokia.tools.variant.editor.summary.SummaryLeafGroup;
import com.nokia.tools.variant.editor.summary.SummaryParentGroup;
import com.nokia.tools.variant.resourcelibrary.model.ResourceModelRoot;
import com.nokia.tools.variant.viewer.viewer.SettingsViewer;

public class NavigatorViewerSelectionChangedListener implements
		ISelectionChangedListener {
	private CPFEditor editor;

	public NavigatorViewerSelectionChangedListener(CPFEditor editor) {
		this.editor = editor;
	}

	public void selectionChanged(SelectionChangedEvent event) {
		IStructuredSelection selection = (IStructuredSelection) event
				.getSelection();
		if (!selection.equals(StructuredSelection.EMPTY)
				&& selection.getFirstElement().equals(editor.getCurrentGroup())) {
			return;
		}
		UIModel createUIModel = null;
		Object firstElement = selection.getFirstElement();
		if (firstElement instanceof ParentGroup) {
			ParentGroup parentGroup = (ParentGroup) firstElement;
			EList<LeafGroup> leafGroup = parentGroup.getLeafGroup();
			if (leafGroup.size() > 0
					&& leafGroup.get(0) instanceof SummaryLeafGroup) {

				firstElement = leafGroup.get(0);

			} else {

				createUIModel = editor.getViewModelToUIModelConvertor()
						.createUIModel(parentGroup);
				editor.setNotesSorting(false);
				editor.setDirtySorting(false);
				editor.setErrorSorting(false);
				editor.setCurrentGroup(parentGroup);
				if (createUIModel != null) {
					SettingsViewer settingsViewer = editor.getSettingsViewer();
					settingsViewer.setGroupName(parentGroup.getName());
					settingsViewer.setInput(null);
					settingsViewer
							.setContentProvider(new EditorViewerContentProvider(
									editor.getCommandStack(), editor));
					settingsViewer.setInput(createUIModel);

					settingsViewer
							.setLabelProvider(new EditorViewerLabelProvider(
									(ResourceModelRoot) editor
											.getAdapter(ResourceModelRoot.class)));

				}
				return;
			}
		}
		if (firstElement instanceof LeafGroup) {
			SettingsViewer settingsViewer = editor.getSettingsViewer();
			CommandStack stack = editor.getCommandStack();
			Group currentLeafGroup = editor.getCurrentGroup();
			if (currentLeafGroup != null
					&& currentLeafGroup.equals(firstElement)) {
				return;
			}
			editor.setNotesSorting(false);
			editor.setDirtySorting(false);
			editor.setErrorSorting(false);
			LeafGroup leaf = (LeafGroup) firstElement;
			editor.setCurrentGroup(leaf);
			ParentGroup parent = (ParentGroup) leaf.eContainer();

			if (parent instanceof SummaryParentGroup) {
				UISummaryModel summaryModelRoot = editor.getSummaryModelroot();
				if (summaryModelRoot == null)
					summaryModelRoot = editor.getViewModelToUIModelConvertor()
							.createUISummaryModel(leaf);
				editor.setSummaryModelRoot(summaryModelRoot);
				editor.setSummaryLeafGroup((SummaryLeafGroup) leaf);
				if (summaryModelRoot != null) {

					if (!(settingsViewer.getInput() instanceof UISummaryModel)) {
						settingsViewer.setGroupName("Summary");
						settingsViewer.setInput(null);
						settingsViewer
								.setContentProvider(new SummaryViewerContentProvider(
										stack, editor));
						settingsViewer.setInput(summaryModelRoot);
						settingsViewer
								.setLabelProvider(new SummaryViewerLabelProvider());
					}
					editor.handleSummary(leaf);

				}

			} else {
				createUIModel = editor.getViewModelToUIModelConvertor()
						.createUIModel(leaf);
				if (createUIModel != null) {
					settingsViewer.setGroupName(leaf.getName());
					settingsViewer.setInput(null);
					settingsViewer
							.setContentProvider(new EditorViewerContentProvider(
									stack, editor));
					settingsViewer.setInput(createUIModel);

					settingsViewer
							.setLabelProvider(new EditorViewerLabelProvider(
									(ResourceModelRoot) editor
											.getAdapter(ResourceModelRoot.class)));

				}
			}
		}

	}

}
