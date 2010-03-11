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

package com.nokia.tools.vct.confml.editor.view.commands;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.commands.Command;
import org.eclipse.jface.viewers.StructuredSelection;

import com.nokia.tools.vct.common.ui.utils.SWTUtil;
import com.nokia.tools.vct.confml.editor.view.ViewsEditor;
import com.nokia.tools.vct.confml.editor.view.vemodel.EGroup;
import com.nokia.tools.vct.confml.editor.view.vemodel.EGroupContainer;

public class AddGroupCommand extends Command {

	private ViewsEditor editor;
	private EGroupContainer parentContainer;
	private EGroup newGroup;

	public AddGroupCommand(ViewsEditor editor, EGroupContainer parentContainer,
			EGroup newGroup) {
		this.editor = editor;
		this.parentContainer = parentContainer;
		this.newGroup = newGroup;
	}

	public void execute() {
		editor.getControl().setRedraw(false);
		try {
			TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(parentContainer);
			domain.getCommandStack().execute(new RecordingCommand(domain) {
				@Override
				protected void doExecute() {

			
			parentContainer.getGroupsAndViews().add(newGroup);
			SWTUtil.getStandardDisplay().asyncExec(new Runnable() {
				public void run() {
					editor.getSite().getSelectionProvider().setSelection(new StructuredSelection(newGroup));
				}
			});
				}});
		} finally {
			editor.getControl().setRedraw(true);
		}
	}

	public void undo() {
		editor.getControl().setRedraw(false);
		try {
			TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(parentContainer);
			domain.getCommandStack().execute(new RecordingCommand(domain) {
				@Override
				protected void doExecute() {

			parentContainer.getGroupsAndViews().remove(newGroup);
			SWTUtil.getStandardDisplay().asyncExec(new Runnable() {
				public void run() {
					editor.getSite().getSelectionProvider().setSelection(new StructuredSelection(parentContainer));
				}
			});
				}});
		} finally {
			editor.getControl().setRedraw(true);
		}
	}
}
