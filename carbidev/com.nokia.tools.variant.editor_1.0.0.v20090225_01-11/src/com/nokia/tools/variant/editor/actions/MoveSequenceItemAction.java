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

import org.eclipse.gef.commands.CommandStack;
import org.eclipse.jface.action.Action;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import com.nokia.tools.variant.content.confml.SequenceItem;
import com.nokia.tools.variant.editor.commands.MoveSequenceItemCommand;
import com.nokia.tools.variant.editor.editors.CPFEditor;

/**
 * Action server for changing order of sequence items in sequence.
 */
public class MoveSequenceItemAction extends Action {

	private SequenceItem sourceSetting;
	private SequenceItem targetSetting;

	/**
	 * Constructor
	 * @param sourceItem
	 * @param targetItem
	 */
	public MoveSequenceItemAction(SequenceItem sourceItem,
			SequenceItem targetItem) {
		setText("Move sequence item");
		this.sourceSetting = sourceItem;
		this.targetSetting = targetItem;
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
			if (activeEditor != null && activeEditor instanceof CPFEditor) {
				CPFEditor editor = (CPFEditor) activeEditor;
				CommandStack commandStack = editor.getCommandStack();
				MoveSequenceItemCommand command = new MoveSequenceItemCommand(
						sourceSetting, targetSetting);
				commandStack.execute(command);
			}
		}
	}
}
