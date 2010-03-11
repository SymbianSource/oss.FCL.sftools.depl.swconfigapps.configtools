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

package com.nokia.tools.vct.confml.editor.view;

import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.part.EditorActionBarContributor;


public class ViewsEditorActionBarContributor extends EditorActionBarContributor {

	
	private IWorkbenchAction undo;
	private IWorkbenchAction redo;
	private ViewsEditor editor;
	public ViewsEditorActionBarContributor() {

	}

	@Override
	public void setActiveEditor(IEditorPart targetEditor) {
		if(targetEditor instanceof ViewsEditor){
			editor = (ViewsEditor) targetEditor;
			registerUndoRedo();
		}
	
	

		super.setActiveEditor(targetEditor);
	}

	/**
	 * Hooks Undo/Redo to global Undo/Redo.
	 */
	public void registerUndoRedo() {
		IActionBars actionBars = getActionBars();
		if (actionBars != null) {
			ActionRegistry registry = editor.getActionRegistry();
			if (registry != null) {
				actionBars.setGlobalActionHandler(ActionFactory.UNDO.getId(),
						registry.getAction(ActionFactory.UNDO.getId()));
				actionBars.setGlobalActionHandler(ActionFactory.REDO.getId(),
						registry.getAction(ActionFactory.REDO.getId()));
			}
			actionBars.updateActionBars();

		}
	}
	@Override
	public void contributeToToolBar(IToolBarManager toolBarManager) {
		undo = ActionFactory.UNDO.create(PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow());
		redo = ActionFactory.REDO.create(PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow());
		toolBarManager.add(undo);
		toolBarManager.add(redo);
		super.contributeToToolBar(toolBarManager);
	}
}
