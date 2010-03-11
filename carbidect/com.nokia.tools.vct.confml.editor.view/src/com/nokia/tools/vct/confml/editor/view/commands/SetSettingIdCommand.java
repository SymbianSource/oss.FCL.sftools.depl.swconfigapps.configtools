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

import com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef;
import com.nokia.tools.vct.confml.editor.view.vemodel.EViewsEditorDocument;
import com.nokia.tools.vct.confml.editor.view.vemodel.util.ConverterUtils;

public class SetSettingIdCommand extends Command {
	private ESettingRef ref;
	private String oldSettingId;
	private String newSettingId;
	private EViewsEditorDocument document;
	
	public SetSettingIdCommand(ESettingRef ref, String newValue) {
		this.ref = ref;
		this.newSettingId = newValue;
	}
	
	@Override
	public void execute() {
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(ref);
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				document = ConverterUtils.getDocument(ref);
				oldSettingId = ref.getSettingId();
				ref.setSettingId(newSettingId);
				ConverterUtils.updateIndexReference(document, ref);
			}
		});
		domain.getCommandStack().flush();
	}
	
	@Override
	public void undo() {
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(ref);
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				ref.setSettingId(oldSettingId);
				ConverterUtils.updateIndexReference(document, ref);
			}
		});
		domain.getCommandStack().flush();
	}
}
