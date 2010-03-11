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

import java.util.Map;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.commands.Command;

import com.nokia.tools.vct.confml.editor.view.vemodel.EView;
import com.nokia.tools.vct.confml.editor.view.vemodel.EViewsEditorDocument;


public class SetViewIdCommand extends Command {
	private EView ref;
	private String newValue;
	private String oldValue;
	private TransactionalEditingDomain domain;

	public SetViewIdCommand(EView ref, String newValue) {
		this.ref = ref;
		this.newValue = newValue;
		this.domain = TransactionUtil.getEditingDomain(ref);
	}

	@Override
	public void execute() {
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				Map.Entry<?, ?> entry = (Map.Entry<?, ?>)ref.eContainer(); 
				oldValue = (String)entry.getKey();
				EViewsEditorDocument doc = (EViewsEditorDocument)ref.eContainer().eContainer();
				EView view = doc.getViews().removeKey(oldValue);
				doc.getViews().put(newValue, view);
			}
		});
	}
	

	@Override
	public void undo() {
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				EViewsEditorDocument doc = (EViewsEditorDocument)ref.eContainer().eContainer();
				EView view = doc.getViews().removeKey(newValue);
				doc.getViews().put(oldValue, view);
			}
		});
	}
}
